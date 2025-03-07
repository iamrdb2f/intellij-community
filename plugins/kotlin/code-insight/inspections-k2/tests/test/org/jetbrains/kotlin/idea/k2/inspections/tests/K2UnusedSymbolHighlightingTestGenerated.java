// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.k2.inspections.tests;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.idea.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.idea.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.idea.base.test.TestRoot;
import org.junit.runner.RunWith;

/**
 * This class is generated by {@link org.jetbrains.kotlin.testGenerator.generator.TestGenerator}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("code-insight/inspections-k2/tests")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
@TestMetadata("../../../idea/tests/testData/inspectionsLocal/unusedSymbol")
public class K2UnusedSymbolHighlightingTestGenerated extends AbstractK2LocalInspectionAndGeneralHighlightingTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    @TestMetadata("abstractFunctionParameter.kt")
    public void testAbstractFunctionParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/abstractFunctionParameter.kt");
    }

    @TestMetadata("asDefaultConstructorParameter.kt")
    public void testAsDefaultConstructorParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/asDefaultConstructorParameter.kt");
    }

    @TestMetadata("callableReference.kt")
    public void testCallableReference() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/callableReference.kt");
    }

    @TestMetadata("catchParameter.kt")
    public void testCatchParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/catchParameter.kt");
    }

    @TestMetadata("classByPrimaryConstructor.kt")
    public void testClassByPrimaryConstructor() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/classByPrimaryConstructor.kt");
    }

    @TestMetadata("companionObject.kt")
    public void testCompanionObject() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/companionObject.kt");
    }

    @TestMetadata("companionViaImport.kt")
    public void testCompanionViaImport() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/companionViaImport.kt");
    }

    @TestMetadata("companionViaImport2.kt")
    public void testCompanionViaImport2() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/companionViaImport2.kt");
    }

    @TestMetadata("contextReceiver.kt")
    public void testContextReceiver() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/contextReceiver.kt");
    }

    @TestMetadata("dataInlineClassDeclarationk1.kt")
    public void testDataInlineClassDeclarationk1() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/dataInlineClassDeclarationk1.kt");
    }

    @TestMetadata("dataInlineClassDeclarationk2.kt")
    public void testDataInlineClassDeclarationk2() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/dataInlineClassDeclarationk2.kt");
    }

    @TestMetadata("entryPoint.kt")
    public void testEntryPoint() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/entryPoint.kt");
    }

    @TestMetadata("enumSecondaryConstructor.kt")
    public void testEnumSecondaryConstructor() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/enumSecondaryConstructor.kt");
    }

    @TestMetadata("expectFunctionParameter.kt")
    public void testExpectFunctionParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/expectFunctionParameter.kt");
    }

    @TestMetadata("functionLiteralParameters.kt")
    public void testFunctionLiteralParameters() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/functionLiteralParameters.kt");
    }

    @TestMetadata("functionWithInlineClass.kt")
    public void testFunctionWithInlineClass() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/functionWithInlineClass.kt");
    }

    @TestMetadata("functionWithInlineClassReceiver.kt")
    public void testFunctionWithInlineClassReceiver() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/functionWithInlineClassReceiver.kt");
    }

    @TestMetadata("inAnonymous.kt")
    public void testInAnonymous() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inAnonymous.kt");
    }

    @TestMetadata("inAnonymousDeeply.kt")
    public void testInAnonymousDeeply() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inAnonymousDeeply.kt");
    }

    @TestMetadata("inAnonymousDeeplyInTopLevel.kt")
    public void testInAnonymousDeeplyInTopLevel() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inAnonymousDeeplyInTopLevel.kt");
    }

    @TestMetadata("inAnonymousInCompanion.kt")
    public void testInAnonymousInCompanion() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inAnonymousInCompanion.kt");
    }

    @TestMetadata("inAnonymousInTopLovel.kt")
    public void testInAnonymousInTopLovel() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inAnonymousInTopLovel.kt");
    }

    @TestMetadata("inAnonymousRunWrapped.kt")
    public void testInAnonymousRunWrapped() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inAnonymousRunWrapped.kt");
    }

    @TestMetadata("infixCall.kt")
    public void testInfixCall() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/infixCall.kt");
    }

    @TestMetadata("inlineClassConstructor.kt")
    public void testInlineClassConstructor() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inlineClassConstructor.kt");
    }

    @TestMetadata("inlineClassMemberFunction.kt")
    public void testInlineClassMemberFunction() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inlineClassMemberFunction.kt");
    }

    @TestMetadata("inlineClassProperty.kt")
    public void testInlineClassProperty() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/inlineClassProperty.kt");
    }

    @TestMetadata("innerClass.kt")
    public void testInnerClass() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/innerClass.kt");
    }

    @TestMetadata("internal.kt")
    public void testInternal() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/internal.kt");
    }

    @TestMetadata("jsExport.kt")
    public void testJsExport() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/jsExport.kt");
    }

    @TestMetadata("lastPropertyInPrimaryConstructor.kt")
    public void testLastPropertyInPrimaryConstructor() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/lastPropertyInPrimaryConstructor.kt");
    }

    @TestMetadata("lastPropertyInPrimaryConstructorWithComments.kt")
    public void testLastPropertyInPrimaryConstructorWithComments() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/lastPropertyInPrimaryConstructorWithComments.kt");
    }

    @TestMetadata("loopParameter.kt")
    public void testLoopParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/loopParameter.kt");
    }

    @TestMetadata("namedFunctionalParameter.kt")
    public void testNamedFunctionalParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/namedFunctionalParameter.kt");
    }

    @TestMetadata("namelessFunctionalParameter.kt")
    public void testNamelessFunctionalParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/namelessFunctionalParameter.kt");
    }

    @TestMetadata("nestedPrivateObject.kt")
    public void testNestedPrivateObject() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/nestedPrivateObject.kt");
    }

    @TestMetadata("nonPrivateFields.kt")
    public void testNonPrivateFields() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/nonPrivateFields.kt");
    }

    @TestMetadata("overrideProperty.kt")
    public void testOverrideProperty() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/overrideProperty.kt");
    }

    @TestMetadata("parameterOfFunctionInInterface.kt")
    public void testParameterOfFunctionInInterface() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/parameterOfFunctionInInterface.kt");
    }

    @TestMetadata("parameterOfOpenFunction.kt")
    public void testParameterOfOpenFunction() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/parameterOfOpenFunction.kt");
    }

    @TestMetadata("parameterOfOverriddenFunction.kt")
    public void testParameterOfOverriddenFunction() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/parameterOfOverriddenFunction.kt");
    }

    @TestMetadata("primaryConstructorParameter.kt")
    public void testPrimaryConstructorParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/primaryConstructorParameter.kt");
    }

    @TestMetadata("primaryConstructorParameterDataClass.kt")
    public void testPrimaryConstructorParameterDataClass() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/primaryConstructorParameterDataClass.kt");
    }

    @TestMetadata("privateFunction.kt")
    public void testPrivateFunction() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/privateFunction.kt");
    }

    @TestMetadata("privateOperator.kt")
    public void testPrivateOperator() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/privateOperator.kt");
    }

    @TestMetadata("privateOperatorUsed.kt")
    public void testPrivateOperatorUsed() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/privateOperatorUsed.kt");
    }

    @TestMetadata("privateProperty.kt")
    public void testPrivateProperty() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/privateProperty.kt");
    }

    @TestMetadata("privatePropertyViaGetter.kt")
    public void testPrivatePropertyViaGetter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/privatePropertyViaGetter.kt");
    }

    @TestMetadata("privatePropertyViaSetter.kt")
    public void testPrivatePropertyViaSetter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/privatePropertyViaSetter.kt");
    }

    @TestMetadata("propertyOfInlineClassType.kt")
    public void testPropertyOfInlineClassType() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/propertyOfInlineClassType.kt");
    }

    @TestMetadata("secondaryConstructorCalledByImportAlias.kt")
    public void testSecondaryConstructorCalledByImportAlias() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/secondaryConstructorCalledByImportAlias.kt");
    }

    @TestMetadata("secondaryConstructorCalledByTypeAlias.kt")
    public void testSecondaryConstructorCalledByTypeAlias() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/secondaryConstructorCalledByTypeAlias.kt");
    }

    @TestMetadata("secondaryLocalClassConstructor.kt")
    public void testSecondaryLocalClassConstructor() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/secondaryLocalClassConstructor.kt");
    }

    @TestMetadata("typeAlias.kt")
    public void testTypeAlias() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/typeAlias.kt");
    }

    @TestMetadata("unusedClassExplicitApi.kt")
    public void testUnusedClassExplicitApi() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedClassExplicitApi.kt");
    }

    @TestMetadata("unusedEnumEntries.kt")
    public void testUnusedEnumEntries() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumEntries.kt");
    }

    @TestMetadata("unusedEnumEntries2.kt")
    public void testUnusedEnumEntries2() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumEntries2.kt");
    }

    @TestMetadata("unusedEnumEntries3.kt")
    public void testUnusedEnumEntries3() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumEntries3.kt");
    }

    @TestMetadata("unusedEnumEntries4.kt")
    public void testUnusedEnumEntries4() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumEntries4.kt");
    }

    @TestMetadata("unusedEnumEntries5.kt")
    public void testUnusedEnumEntries5() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumEntries5.kt");
    }

    @TestMetadata("unusedEnumEntries6.kt")
    public void testUnusedEnumEntries6() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumEntries6.kt");
    }

    @TestMetadata("unusedEnumEntry.kt")
    public void testUnusedEnumEntry() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumEntry.kt");
    }

    @TestMetadata("unusedEnumSecondaryConstructor.kt")
    public void testUnusedEnumSecondaryConstructor() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumSecondaryConstructor.kt");
    }

    @TestMetadata("unusedEnumValues.kt")
    public void testUnusedEnumValues() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumValues.kt");
    }

    @TestMetadata("unusedEnumValues2.kt")
    public void testUnusedEnumValues2() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumValues2.kt");
    }

    @TestMetadata("unusedEnumValues3.kt")
    public void testUnusedEnumValues3() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumValues3.kt");
    }

    @TestMetadata("unusedEnumValues4.kt")
    public void testUnusedEnumValues4() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedEnumValues4.kt");
    }

    @TestMetadata("unusedExtensionExplicitApi.kt")
    public void testUnusedExtensionExplicitApi() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedExtensionExplicitApi.kt");
    }

    @TestMetadata("unusedFunctionExplicitApi.kt")
    public void testUnusedFunctionExplicitApi() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedFunctionExplicitApi.kt");
    }

    @TestMetadata("unusedPublicMembers.kt")
    public void testUnusedPublicMembers() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/unusedPublicMembers.kt");
    }

    @TestMetadata("usedEnumFunction.kt")
    public void testUsedEnumFunction() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction.kt");
    }

    @TestMetadata("usedEnumFunction10.kt")
    public void testUsedEnumFunction10() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction10.kt");
    }

    @TestMetadata("usedEnumFunction11.kt")
    public void testUsedEnumFunction11() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction11.kt");
    }

    @TestMetadata("usedEnumFunction12.kt")
    public void testUsedEnumFunction12() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction12.kt");
    }

    @TestMetadata("usedEnumFunction13.kt")
    public void testUsedEnumFunction13() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction13.kt");
    }

    @TestMetadata("usedEnumFunction14.kt")
    public void testUsedEnumFunction14() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction14.kt");
    }

    @TestMetadata("usedEnumFunction15.kt")
    public void testUsedEnumFunction15() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction15.kt");
    }

    @TestMetadata("usedEnumFunction16.kt")
    public void testUsedEnumFunction16() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction16.kt");
    }

    @TestMetadata("usedEnumFunction17.kt")
    public void testUsedEnumFunction17() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction17.kt");
    }

    @TestMetadata("usedEnumFunction2.kt")
    public void testUsedEnumFunction2() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction2.kt");
    }

    @TestMetadata("usedEnumFunction3.kt")
    public void testUsedEnumFunction3() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction3.kt");
    }

    @TestMetadata("usedEnumFunction4.kt")
    public void testUsedEnumFunction4() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction4.kt");
    }

    @TestMetadata("usedEnumFunction5.kt")
    public void testUsedEnumFunction5() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction5.kt");
    }

    @TestMetadata("usedEnumFunction6.kt")
    public void testUsedEnumFunction6() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction6.kt");
    }

    @TestMetadata("usedEnumFunction7.kt")
    public void testUsedEnumFunction7() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction7.kt");
    }

    @TestMetadata("usedEnumFunction8.kt")
    public void testUsedEnumFunction8() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction8.kt");
    }

    @TestMetadata("usedEnumFunction9.kt")
    public void testUsedEnumFunction9() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunction9.kt");
    }

    @TestMetadata("usedEnumFunctionWithImport.kt")
    public void testUsedEnumFunctionWithImport() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithImport.kt");
    }

    @TestMetadata("usedEnumFunctionWithImport2.kt")
    public void testUsedEnumFunctionWithImport2() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithImport2.kt");
    }

    @TestMetadata("usedEnumFunctionWithImport3.kt")
    public void testUsedEnumFunctionWithImport3() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithImport3.kt");
    }

    @TestMetadata("usedEnumFunctionWithImport4.kt")
    public void testUsedEnumFunctionWithImport4() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithImport4.kt");
    }

    @TestMetadata("usedEnumFunctionWithImport5.kt")
    public void testUsedEnumFunctionWithImport5() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithImport5.kt");
    }

    @TestMetadata("usedEnumFunctionWithImport6.kt")
    public void testUsedEnumFunctionWithImport6() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithImport6.kt");
    }

    @TestMetadata("usedEnumFunctionWithImport7.kt")
    public void testUsedEnumFunctionWithImport7() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithImport7.kt");
    }

    @TestMetadata("usedEnumFunctionWithImport8.kt")
    public void testUsedEnumFunctionWithImport8() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithImport8.kt");
    }

    @TestMetadata("usedEnumFunctionWithNestedEnum.kt")
    public void testUsedEnumFunctionWithNestedEnum() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithNestedEnum.kt");
    }

    @TestMetadata("usedEnumFunctionWithNestedEnum2.kt")
    public void testUsedEnumFunctionWithNestedEnum2() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/usedEnumFunctionWithNestedEnum2.kt");
    }

    @TestMetadata("valInPrimaryConstructor.kt")
    public void testValInPrimaryConstructor() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/valInPrimaryConstructor.kt");
    }

    @TestMetadata("valueClassGenericParameter.kt")
    public void testValueClassGenericParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/valueClassGenericParameter.kt");
    }

    @TestMetadata("valueClassParameter.kt")
    public void testValueClassParameter() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/valueClassParameter.kt");
    }

    @TestMetadata("withJvmNameUsedFromKotlin.kt")
    public void testWithJvmNameUsedFromKotlin() throws Exception {
        runTest("../../../idea/tests/testData/inspectionsLocal/unusedSymbol/withJvmNameUsedFromKotlin.kt");
    }
}
