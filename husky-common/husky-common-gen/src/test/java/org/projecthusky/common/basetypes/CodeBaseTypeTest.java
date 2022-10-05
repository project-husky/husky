/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.common.basetypes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.LangText;
import org.junit.jupiter.api.Test;

/**
 * The test class for CodeBaseType.
 */
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
		CodeBaseType codeBaseType1 = CodeBaseType.builder().withCode(code)
				.withCodeSystem(codeSystem).withCodeSystemName(codeSystemName)
				.withCodeSystemVersion(codeSystemVersion).withDisplayName(displayName)
				.withOriginalText(originalText).build();

		CodeBaseType codeBaseTypeA = CodeBaseType.builder().withCode(code)
				.withCodeSystem(codeSystem).withCodeSystemName(codeSystemName)
				.withCodeSystemVersion(codeSystemVersion).withDisplayName(displayName)
				.withOriginalText(originalText).build();

		assertEquals(codeBaseType1.hashCode(), codeBaseTypeA.hashCode());
		assertEquals(codeBaseType1, codeBaseTypeA);

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
		CodeBaseType codeBaseType2 = CodeBaseType.builder().withCode(code2)
				.withCodeSystem(codeSystem2).withCodeSystemName(codeSystemName2)
				.withCodeSystemVersion(codeSystemVersion2).withDisplayName(displayName2)
				.withOriginalText(originalText2).build();

		String code3 = "784.0-3";
		String codeSystem3 = "2.999.3";
		String codeSystemName3 = "ICD-10-copy3";
		String codeSystemVersion3 = "codeSystemVersion3";
		String displayName3 = "Headache3";
		String originalText3 = "Kopfschmerzen3";
		CodeBaseType codeBaseType3 = CodeBaseType.builder().withCode(code3)
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