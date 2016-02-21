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
package org.ehealth_connector.cda.ch.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.cda.utils.CdaUtilTest;
import org.ehealth_connector.common.enums.CodeSystems;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

/**
 * Test of CdaChUtil
 *
 */
public class CdaChUtilTest extends CdaUtilTest {
	private SectionsVACD testPrefix;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		testPrefix = SectionsVACD.ALLERGIES_REACTIONS;
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.utils.CdaUtil#createUuidVacd(java.lang.String)}
	 * .
	 */
	@Test
	public void testCreateUuidVacd() {
		final II ref = CdaChUtil.createUuidVacd(testId);

		assertEquals(testId, ref.getExtension());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.utils.CdaUtil#createUuidVacdIdentificator(org.ehealth_connector.common.Identificator)}
	 * .
	 */
	@Test
	public void testCreateUuidVacdIdentificator() {
		final II ref = CdaChUtil.createUuidVacdIdentificator(testIdentiicator);
		assertEquals(CodeSystems.GLN.getCodeSystemId(), ref.getRoot());
		assertEquals(testId, ref.getExtension());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.utils.CdaUtil#updateRefIfComment(org.openhealthtools.mdht.uml.cda.EntryRelationship, int, int, org.ehealth_connector.cda.ch.enums.SectionsVACD)}
	 * .
	 */
	@Test
	public void testUpdateRefIfCommentEntryRelationshipIntIntSectionsVACD() {
		final EntryRelationship ref = CdaChUtil.updateRefIfComment(testEr, testI, testJ, testPrefix);
		assertNotNull(ref);
		assertTrue(ref.getInversionInd());
		assertNotNull(ref.getAct());
		final ED ed = ref.getAct().getText();
		assertNotNull(ed);
		assertEquals(testText, ed.getText());
		final TEL refRef = ed.getReference();
		assertNotNull(refRef);
		final String refVal = refRef.getValue();
		assertTrue(refVal.startsWith("#"));
		assertTrue(refVal.endsWith("1"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.utils.CdaUtil#updateRefIfComment(org.openhealthtools.mdht.uml.cda.EntryRelationship, java.lang.String, org.ehealth_connector.cda.ch.enums.SectionsVACD)}
	 * .
	 */
	@Test
	public void testUpdateRefIfCommentEntryRelationshipStringSectionsVACD() {
		final EntryRelationship ref = CdaChUtil.updateRefIfComment(testEr, testRef, testPrefix);
		assertNotNull(ref);
		assertTrue(ref.getInversionInd());

	}

}
