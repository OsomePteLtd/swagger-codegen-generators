package io.swagger.codegen.v3.generators.swift;

import io.swagger.codegen.v3.CodegenConstants;
import io.swagger.codegen.v3.CodegenOperation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.swagger.codegen.v3.generators.handlebars.ExtensionHelper.getBooleanValue;

public class Swift5CodegenTest {

    Swift5Codegen swiftCodegen = new Swift5Codegen();

    @Test
    public void testCapitalizedReservedWord() throws Exception {
        Assert.assertEquals(swiftCodegen.toEnumVarName("AS", null), "_as");
    }
    
    @Test
    public void testNameStarsWithSpecialCharacters() {
        Assert.assertEquals(swiftCodegen.toEnumVarName("+createdat", null), "plusCreatedat");
        Assert.assertEquals(swiftCodegen.toEnumVarName("-createdat", null), "minusCreatedat");
    }

    @Test
    public void testNameContainsSpecialSeparatorSymbols() {
        Assert.assertEquals(swiftCodegen.toEnumVarName("random , comma", null), "randomComma");
        Assert.assertEquals(swiftCodegen.toEnumVarName("random . dot", null), "randomDot");
        Assert.assertEquals(swiftCodegen.toEnumVarName("random 'special' symbols", null), "randomSpecialSymbols");
    }

}
