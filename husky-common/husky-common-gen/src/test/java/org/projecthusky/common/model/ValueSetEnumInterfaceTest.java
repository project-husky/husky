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
package org.projecthusky.common.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.utils.XdsMetadataUtil;
import org.junit.jupiter.api.Test;

public class ValueSetEnumInterfaceTest {

	public class ValueSetEnumInterfaceMock implements ValueSetEnumInterface {

		private String codeSystem;
		private String code;

		private Map<LanguageCode, String> displayNames;

		public ValueSetEnumInterfaceMock(final String code, final String codeSystem,
										 final String displayName, final String displayNameEn,
										 final String displayNameDe, final String displayNameFr,
										 final String displayNameIt) {
			this.code = code;
			this.codeSystem = codeSystem;
			this.displayNames = new HashMap<>();
			this.displayNames.put(null, displayName);
			this.displayNames.put(LanguageCode.ENGLISH, displayNameEn);
			this.displayNames.put(LanguageCode.GERMAN, displayNameDe);
			this.displayNames.put(LanguageCode.FRENCH, displayNameFr);
			this.displayNames.put(LanguageCode.ITALIAN, displayNameIt);
		}

		@Override
		public String getCodeSystemId() {
			return this.codeSystem;
		}

		@Override
		public String getCodeSystemName() {
			String retVal = "";
			CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
			if (cs != null)
				retVal = cs.getCodeSystemName();
			return retVal;
		}

		@Override
		public String getCodeValue() {
			return code;
		}

		@Override
		public String getDisplayName(LanguageCode languageCode) {
			String displayName = this.displayNames.get(languageCode);
			if (displayName == null && languageCode == LanguageCode.ENGLISH) {
				return this.displayNames.get(null);
			}
			return displayName;
		}

		@Override
		public String getValueSetId() {
			return null;
		}

		@Override
		public String getValueSetName() {
			return null;
		}

		@Override
		public String name() { return null; }
	}

	public static void assertValueSetEnumEntries(ValueSetEnumInterface[] enumEntries)
			throws AssertionError {

		for (ValueSetEnumInterface enumEntry : enumEntries) {

			assertNotNull(enumEntry.getCodeSystemId());
			assertNotNull(enumEntry.getCodeValue());
			assertNotNull(enumEntry.getDisplayName());
			assertNotNull(enumEntry.getDisplayName(LanguageCode.ENGLISH));
			assertNotNull(enumEntry.getDisplayName(LanguageCode.GERMAN));
			assertNotNull(enumEntry.getDisplayName(LanguageCode.FRENCH));
			assertNotNull(enumEntry.getDisplayName(LanguageCode.ITALIAN));

			final Code code = enumEntry.getCode();
			assertEquals(enumEntry.getCodeValue(), code.getCode());
			assertEquals(enumEntry.getCodeSystemId(), code.getCodeSystem());
			assertEquals(enumEntry.getDisplayName(), code.getDisplayName());

			final org.openehealth.ipf.commons.ihe.xds.core.metadata.Code cmt = enumEntry.getIpfCode();
			assertEquals(enumEntry.getCodeValue(), cmt.getCode());
			assertEquals(enumEntry.getCodeSystemId(), cmt.getSchemeName());
			assertEquals(enumEntry.getDisplayName(),
					XdsMetadataUtil.convertInternationalStringType(cmt.getDisplayName()));

			final CE ce = enumEntry.getCE();
			assertEquals(enumEntry.getCodeValue(), ce.getCode());
			assertEquals(enumEntry.getCodeSystemId(), ce.getCodeSystem());
			assertEquals(enumEntry.getDisplayName(), ce.getDisplayName());

		}

	}

	@Test
	void testInterfaceDefaultMethodImplementation() {

		final String codeValue = "1234";
		final String codeSystemValue = "1.2.3.4";
		final String displayName = "Display name";
		final String displayNameEn = "Display name (en)";
		final String displayNameDe = "Display name (de-CH)";
		final String displayNameFr = "Display name (fr-CH)";
		final String displayNameIt = "Display name (it-CH)";

		final ValueSetEnumInterfaceMock mock = new ValueSetEnumInterfaceMock(codeValue,
				codeSystemValue, displayName, displayNameEn, displayNameDe, displayNameFr,
				displayNameIt);

		assertEquals(displayName, mock.getDisplayName());

		final Code code = mock.getCode();
		assertEquals(codeValue, code.getCode());
		assertEquals(codeSystemValue, code.getCodeSystem());
		assertEquals(displayName, code.getDisplayName());

		final org.openehealth.ipf.commons.ihe.xds.core.metadata.Code cmt = mock.getIpfCode();
		assertEquals(codeValue, cmt.getCode());
		assertEquals(codeSystemValue, cmt.getSchemeName());
		assertEquals(displayName,
				XdsMetadataUtil.convertInternationalStringType(cmt.getDisplayName()));

		final CE ce = mock.getCE();
		assertEquals(codeValue, ce.getCode());
		assertEquals(codeSystemValue, ce.getCodeSystem());
		assertEquals(displayName, ce.getDisplayName());

	}

}
