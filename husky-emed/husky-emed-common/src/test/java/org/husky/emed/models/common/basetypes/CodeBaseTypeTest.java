package org.husky.emed.models.common.basetypes;

import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.enums.LanguageCode;
import org.husky.common.utils.LangText;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CodeBaseTypeTest {

    /**
     * Do all tests.
     */
    @Test
    void doAllTests() {

        String code = "784.0";
        String codeSystem = "2.999";
        String codeSystemName = "ICD-10";
        String codeSystemVersion = "codeSystemVersion";
        String displayName = "Headache";
        String originalText = "Kopfschmerzen";
        org.husky.common.basetypes.CodeBaseType codeBaseType1 = org.husky.common.basetypes.CodeBaseType.builder().withCode(code)
                .withCodeSystem(codeSystem).withCodeSystemName(codeSystemName)
                .withCodeSystemVersion(codeSystemVersion).withDisplayName(displayName)
                .withOriginalText(originalText).build();

        org.husky.common.basetypes.CodeBaseType codeBaseTypeA = org.husky.common.basetypes.CodeBaseType.builder().withCode(code)
                .withCodeSystem(codeSystem).withCodeSystemName(codeSystemName)
                .withCodeSystemVersion(codeSystemVersion).withDisplayName(displayName)
                .withOriginalText(originalText).build();

        assertEquals(codeBaseType1.hashCode(), codeBaseTypeA.hashCode());
        assertTrue(codeBaseType1.equals(codeBaseTypeA));

        assertEquals(code, codeBaseType1.getCode());
        assertEquals(codeSystem, codeBaseType1.getCodeSystem());
        assertEquals(codeSystemName, codeBaseType1.getCodeSystemName());
        assertEquals(codeSystemVersion, codeBaseType1.getCodeSystemVersion());
        assertEquals(displayName, codeBaseType1.getDisplayName());
        assertEquals(originalText, codeBaseType1.getOriginalText());
        assertEquals(0, codeBaseType1.getCodeTranslationList().size());

        String code2 = "784.0-2";
        String codeSystem2 = "2.999.2";
        String codeSystemName2 = "ICD-10-copy2";
        String codeSystemVersion2 = "codeSystemVersion2";
        String displayName2 = "Headache2";
        String originalText2 = "Kopfschmerzen2";
        org.husky.common.basetypes.CodeBaseType codeBaseType2 = org.husky.common.basetypes.CodeBaseType.builder().withCode(code2)
                .withCodeSystem(codeSystem2).withCodeSystemName(codeSystemName2)
                .withCodeSystemVersion(codeSystemVersion2).withDisplayName(displayName2)
                .withOriginalText(originalText2).build();

        String code3 = "784.0-3";
        String codeSystem3 = "2.999.3";
        String codeSystemName3 = "ICD-10-copy3";
        String codeSystemVersion3 = "codeSystemVersion3";
        String displayName3 = "Headache3";
        String originalText3 = "Kopfschmerzen3";
        org.husky.common.basetypes.CodeBaseType codeBaseType3 = org.husky.common.basetypes.CodeBaseType.builder().withCode(code3)
                .withCodeSystem(codeSystem3).withCodeSystemName(codeSystemName3)
                .withCodeSystemVersion(codeSystemVersion3).withDisplayName(displayName3)
                .withOriginalText(originalText3).build();

        codeBaseType1.addCodeTranslation(codeBaseType2);
        codeBaseType1.addCodeTranslation(codeBaseType3);

        assertEquals(2, codeBaseType1.getCodeTranslationList().size());
        CodeBaseType translation = codeBaseType1.getCodeTranslationList().get(1);

        assertEquals(code3, translation.getCode());
        assertEquals(codeSystem3, translation.getCodeSystem());
        assertEquals(codeSystemName3, translation.getCodeSystemName());
        assertEquals(codeSystemVersion3, translation.getCodeSystemVersion());
        assertEquals(displayName3, translation.getDisplayName());
        assertEquals(originalText3, translation.getOriginalText());

        LangText langTextDe = new LangText(LanguageCode.GERMAN, "Deutscher Text");

        codeBaseType1.addDisplayNameTranslation(langTextDe);
        codeBaseType1.addDisplayNameTranslation(LanguageCode.FRENCH, "Texte français");
        assertEquals(2, codeBaseType1.getDisplayNameTranslationList().size());

        LangText displayNameTranslation = codeBaseType1.getDisplayNameTranslationList().get(0);
        assertEquals(langTextDe.getLangCode(), displayNameTranslation.getLangCode());
        assertEquals(langTextDe.getLangText(), displayNameTranslation.getLangText());

    }
}