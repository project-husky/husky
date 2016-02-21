/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.junit.Before;
import org.junit.Test;

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
	@Before
	public void setUp() throws Exception {
		testLanguage = LanguageCode.FRENCH;
		testRiskOfCom = RiskOfComplications.ANDERE_LUNGENERKRANKUNGEN_ZB_MUKOVISZIDOSE_ASTHMA_BRONCHIALE_ETC;
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.enums.RiskOfComplications#getDisplayName(org.ehealth_connector.cda.enums.LanguageCode)}
	 * .
	 */
	@Test
	public void testGetDisplayNameLanguageCode() {
		final String displNameFrench = testRiskOfCom.getDisplayName(testLanguage);
		assertNotNull(displNameFrench);
		assertEquals("Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)", displNameFrench);
	}

	@Test
	public void testGetCode() {
		final Code ref = testRiskOfCom.getCode(testLanguage);
		assertNotNull(ref);
		assertEquals("Autres maladies pulmonaires (ex : mucoviscidose, asthme traité par aérosols, etc)", ref.getDisplayName());
	}

}
