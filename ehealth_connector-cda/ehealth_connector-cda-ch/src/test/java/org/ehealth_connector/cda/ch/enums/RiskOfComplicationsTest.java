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
package org.ehealth_connector.cda.ch.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.LanguageCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of RiskOfComplikations
 *
 */
public class RiskOfComplicationsTest {

	private LanguageCode testLanguage;

	private RiskOfComplications testRiskOfCom;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testLanguage = LanguageCode.FRENCH;
		testRiskOfCom = RiskOfComplications.ANDERE_LUNGENERKRANKUNGEN_ZB_MUKOVISZIDOSE_ASTHMA_BRONCHIALE_ETC;
	}

	@Test
	public void testGetCode() {
		final Code ref = testRiskOfCom.getCode(testLanguage);
		assertNotNull(ref);
		assertEquals(
				"Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)",
				ref.getDisplayName());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.enums.RiskOfComplications#getDisplayName(org.ehealth_connector.common.enums.LanguageCode)}
	 * .
	 */
	@Test
	public void testGetDisplayNameLanguageCode() {
		final String displNameFrench = testRiskOfCom.getDisplayName(testLanguage);
		assertNotNull(displNameFrench);
		assertEquals(
				"Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)",
				displNameFrench);
	}

}
