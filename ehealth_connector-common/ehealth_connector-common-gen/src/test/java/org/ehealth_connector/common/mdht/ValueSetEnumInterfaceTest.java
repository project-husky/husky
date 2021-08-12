/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.common.mdht;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.junit.Test;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

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

			final CodedMetadataType cmt = enumEntry.getCodedMetadataType();
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
	public void testInterfaceDefaultMethodImplementation() {

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

		final CodedMetadataType cmt = mock.getCodedMetadataType();
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
