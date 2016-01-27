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
 * 
 * @author roeland
 * @version 1.0
 * @since Jan 8, 2016 3:05:42 PM
 *
 */
public class RiskOfExposureTest {

	private LanguageCode testLanguage;

	private RiskOfExposure testRiskOfExp;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testLanguage = LanguageCode.FRENCH;
		testRiskOfExp = RiskOfExposure.FLEDERMAUSFORSCHER_UND_SCHUETZER;
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.enums.RiskOfExposure#getCode(org.ehealth_connector.cda.enums.LanguageCode)}
	 * .
	 */
	@Test
	public void testGetCode() {
		final Code ref = testRiskOfExp.getCode(testLanguage);
		assertNotNull(ref);
		assertEquals("Scientifiques effectuant des recherches sur les chiroptères, protecteurs ou amateurs de chauves-souris",
				ref.getDisplayName());

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.enums.RiskOfExposure#getDisplayName(org.ehealth_connector.cda.enums.LanguageCode)}
	 * .
	 */
	@Test
	public void testGetDisplayName() {
		final String displNameFrench = testRiskOfExp.getDisplayName(testLanguage);
		assertNotNull(displNameFrench);
		assertEquals("Scientifiques effectuant des recherches sur les chiroptères, protecteurs ou amateurs de chauves-souris",
				displNameFrench);
	}

}
