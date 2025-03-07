// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.java.codeInsight.completion;

import com.intellij.JavaTestUtil;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.LightFixtureCompletionTestCase;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.testFramework.IdeaTestUtil;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.NeedsIndex;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class NormalSwitchCompletionVariantsTest extends LightFixtureCompletionTestCase {
  private static final String[] COMMON_VARIANTS = {"case", "default"};
  private static final String[] COMMON_OBJECT_VARIANTS = ArrayUtil.mergeArrays(COMMON_VARIANTS, "case null", "case null, default");

  @Override
  protected String getBasePath() {
    return JavaTestUtil.getRelativeJavaTestDataPath() + "/codeInsight/completion/normal/variants/";
  }

  @NotNull
  @Override
  protected LightProjectDescriptor getProjectDescriptor() {
    return JAVA_21;
  }

  public void testCompletionPrimitiveTypeExpr() { doTest(COMMON_VARIANTS); }
  public void testCompletionPrimitiveTypeStmt() { doTest(COMMON_VARIANTS); }
  public void testCompletionVariantsInStmt() { doTest(COMMON_OBJECT_VARIANTS); }
  public void testCompletionVariantsInExpr() { doTest(COMMON_OBJECT_VARIANTS); }
  public void testCompletionWhenAfterTypeTest() {
    List<String> lookup = doTestAndGetLookup();
    assertContainsElements(lookup, "when");
  }
  public void testCompletionWhenAfterDeconstruction() {
    List<String> lookup = doTestAndGetLookup();
    assertContainsElements(lookup, "when");
  }
  public void testCompletionWhenAfterPartDeconstruction() {
    List<String> lookup = doTestAndGetLookup();
    if (lookup != null) {
      assertDoesntContain(lookup, "when");
    }
    //if null - it is ok
  }

  public void testCompletionWhenAfterPartTypeTest() {
    List<String> lookup = doTestAndGetLookup();
    if (lookup != null) {
      assertDoesntContain(lookup, "when");
    }
    //if null - it is ok
  }

  public void testCompletionDefaultNotShow() {
    List<String> lookup = doTestAndGetLookup();
    if (lookup != null) {
      assertDoesntContain(lookup, "default");
      assertDoesntContain(lookup, "case null, default");
    }
    //if null - it is ok
  }

  public void testCompletionNullDefault() {
    List<String> lookup = doTestAndGetLookup();
    assertNotNull(lookup);
    assertContainsElements(lookup, "case null", "case null, default", "default");
  }

  @NeedsIndex.Full
  public void testCompletionUsedSealedNotShow() {
    List<String> lookup = doTestAndGetLookup();
    assertNotNull(lookup);
    assertDoesntContain(lookup, "case A");
    assertContainsElements(lookup, "case B");
  }

  @NeedsIndex.Full
  public void testCompletionSmartCase() {
    IdeaTestUtil.withLevel(myFixture.getModule(), LanguageLevel.JDK_21, () -> {
      myFixture.configureByFile(getTestName(false) + ".java");
      myFixture.complete(CompletionType.SMART);
      List<String> lookup = myFixture.getLookupElementStrings();
      assertContainsElements(lookup, "case A", "case B", "default", "case null", "case null, default");
    });
  }

  @NeedsIndex.Full
  public void testCompletionRuleCaseOrdering() {
    IdeaTestUtil.withLevel(myFixture.getModule(), LanguageLevel.JDK_21, () -> {
      List<String> lookup = doTestAndGetLookup();
      Set<Integer> indexes = Set.of(
        lookup.indexOf("case A"),
        lookup.indexOf("case B"),
        lookup.indexOf("default"),
        lookup.indexOf("case null"),
        lookup.indexOf("case null, default"));
      assertFalse(indexes.contains(-1));
      int last = lookup.indexOf("o");
      for (Integer index : indexes) {
        if (last < index) {
          fail("broken order");
        }
      }
    });
  }

  @NeedsIndex.Full
  public void testCompletionCaseOrdering() {
    IdeaTestUtil.withLevel(myFixture.getModule(), LanguageLevel.JDK_21, () -> {
      List<String> lookup = doTestAndGetLookup();
      Set<Integer> indexes = Set.of(
        lookup.indexOf("case A"),
        lookup.indexOf("case B"),
        lookup.indexOf("default"),
        lookup.indexOf("case null"),
        lookup.indexOf("case null, default"));
      assertFalse(indexes.contains(-1));
      int last = lookup.indexOf("o");
      Optional<Integer> afterO = indexes.stream().filter(index -> last < index).findAny();
      if (afterO.isEmpty()) {
        fail("broken order");
      }
    });
  }

  @NeedsIndex.Full
  public void testCompletionSealedHierarchyStmt() {
    doTest(ArrayUtil.mergeArrays(COMMON_OBJECT_VARIANTS, "case Variant1", "case Variant2"));
  }

  @NeedsIndex.Full
  public void testCompletionSealedHierarchyExpr() {
    doTest(ArrayUtil.mergeArrays(COMMON_OBJECT_VARIANTS, "case Variant1", "case Variant2"));
  }

  private void doTest(String[] variants) {
    final List<String> lookupElementStrings =doTestAndGetLookup();
    assertSameElements(lookupElementStrings, variants);
  }
  private List<String> doTestAndGetLookup() {
    myFixture.configureByFile(getTestName(false) + ".java");
    myFixture.complete(CompletionType.BASIC);

    return myFixture.getLookupElementStrings();
  }
}
