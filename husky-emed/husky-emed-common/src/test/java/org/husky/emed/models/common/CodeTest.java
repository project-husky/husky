package org.husky.emed.models.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.emed.models.common.basetypes.CodeBaseType;
import org.husky.emed.models.common.Code;
import org.junit.jupiter.api.Test;

class CodeTest {

    /**
     * Do all tests.
     */
    @Test
    void doAllTests() {

        String codeStr1 = "784.0";
        String codeSystem1 = "2.999";
        String codeSystemName1 = "ICD-10";
        String codeSystemVersion1 = "codeSystemVersion";
        String displayName1 = "Headache";
        String originalText1 = "Kopfschmerzen";
        CodeBaseType codeBt = CodeBaseType.builder().withCode(codeStr1).withCodeSystem(codeSystem1)
                .withCodeSystemName(codeSystemName1).withCodeSystemVersion(codeSystemVersion1)
                .withDisplayName(displayName1).withOriginalText(originalText1).build();

        String codeStr2 = "784.0-2";
        String codeSystem2 = "2.999.2";
        String codeSystemName2 = "ICD-10-copy2";
        String codeSystemVersion2 = "codeSystemVersion2";
        String displayName2 = "Headache2";
        String originalText2 = "Kopfschmerzen2";
        CodeBaseType codeBaseType2 = CodeBaseType.builder().withCode(codeStr2)
                .withCodeSystem(codeSystem2).withCodeSystemName(codeSystemName2)
                .withCodeSystemVersion(codeSystemVersion2).withDisplayName(displayName2)
                .withOriginalText(originalText2).build();

        String codeStr3 = "784.0-3";
        String codeSystem3 = "2.999.3";
        String codeSystemName3 = "ICD-10-copy3";
        String codeSystemVersion3 = "codeSystemVersion3";
        String displayName3 = "Headache3";
        String originalText3 = "Kopfschmerzen3";
        CodeBaseType codeBaseType3 = CodeBaseType.builder().withCode(codeStr3)
                .withCodeSystem(codeSystem3).withCodeSystemName(codeSystemName3)
                .withCodeSystemVersion(codeSystemVersion3).withDisplayName(displayName3)
                .withOriginalText(originalText3).build();

        String codeStr4 = "784.0-4";
        String codeSystem4 = "2.999.4";
        String codeSystemName4 = "ICD-10-copy4";
        String codeSystemVersion4 = "codeSystemVersion4";
        String displayName4 = "Headache4";
        String originalText4 = "Kopfschmerzen4";
        CodeBaseType codeBaseType4 = CodeBaseType.builder().withCode(codeStr4)
                .withCodeSystem(codeSystem4).withCodeSystemName(codeSystemName4)
                .withCodeSystemVersion(codeSystemVersion4).withDisplayName(displayName4)
                .withOriginalText(originalText4).build();

        codeBaseType3.addCodeTranslation(codeBaseType4);

        codeBt.addCodeTranslation(codeBaseType2);
        codeBt.addCodeTranslation(codeBaseType3);

        Code code1 = new Code(codeBt);
        CD hl7CdaR2Type = code1.getHl7CdaR2Cd();
        Code code2 = new Code(hl7CdaR2Type);

        assertTrue(code1.equals(code2));

        // Null Flavor Tests
        CD nullHl7CdaR2Value = null;
        Code nullObj = new Code(nullHl7CdaR2Value);
        assertEquals(NullFlavor.NOT_AVAILABLE, nullObj.getNullFlavor());

        ObjectFactory factory = new ObjectFactory();
        nullHl7CdaR2Value = factory.createCD();
        nullHl7CdaR2Value.nullFlavor = new ArrayList<String>();
        nullHl7CdaR2Value.nullFlavor.add("UNK");
		nullObj = new Code(nullHl7CdaR2Value);
        assertEquals(NullFlavor.UNKNOWN, nullObj.getNullFlavor());
    }
}