/* **********************************************************************
 * Author: roeland
 * Date  : Dec 15, 2015
 * File  : CdaUtilTest.java
 * **********************************************************************
 * ehealth_connector-cda-gen
 *
 * Copyright (c) 2015
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */
package org.ehealth_connector.cda.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.ch.enums.SectionsVACD;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.CodeSystems;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.InfrastructureRootTypeId;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StructuredBody;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Dec 15, 2015 9:10:22 AM
 *
 */
public class CdaUtilTest {

	private String testId;
	private Identificator testIdentiicator;
	private EntryRelationship testEr;
	private String testRef;
	private SectionsVACD testPrefix;
	private int testI;
	private int testJ;
	private StructuredBody testSb;
	private Section testS;
	private String testText;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testId = "1234-5678-123456789";
		testIdentiicator = new Identificator(CodeSystems.GLN, testId);
		testEr = CDAFactory.eINSTANCE.createEntryRelationship();
		testEr.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		testEr.setInversionInd(true);
		final Act act = CDAFactory.eINSTANCE.createAct();
		final ED ed = DatatypesFactory.eINSTANCE.createED();
		testText = "Dies ist ein test";
		ed.addText(testText);
		act.setText(ed);
		testEr.setAct(act);
		testRef = "ABCDEFGHIJKL";
		testPrefix = SectionsVACD.ALLERGIES_REACTIONS;

		testSb = CDAFactory.eINSTANCE.createStructuredBody();
		testSb.setLanguageCode(DatatypesFactory.eINSTANCE.createCS("de-CH"));
		final InfrastructureRootTypeId irtid1 = CDAFactory.eINSTANCE
				.createInfrastructureRootTypeId();
		irtid1.setRoot("1.2.3.4.5.6.7");
		irtid1.setExtension("1234567890");
		testSb.setTypeId(irtid1);
		testS = CDAFactory.eINSTANCE.createSection();
		final InfrastructureRootTypeId irtid2 = CDAFactory.eINSTANCE
				.createInfrastructureRootTypeId();
		irtid2.setRoot("7.6.5.4.3.2.1");
		irtid2.setExtension("0987654321");
		testS.setTypeId(irtid2);
		testS.setTitle(DatatypesFactory.eINSTANCE.createST("Dies ist mein Titel"));
		testS.setLanguageCode(DatatypesFactory.eINSTANCE.createCS("de-CH"));

		testI = 1111;
		testJ = 2222;
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.utils.CdaUtil#createUuidVacd(java.lang.String)}
	 * .
	 */
	@Test
	public void testCreateUuidVacd() {
		final II ref = CdaUtil.createUuidVacd(testId);

		assertEquals(testId, ref.getExtension());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.utils.CdaUtil#createUuidVacdIdentificator(org.ehealth_connector.common.Identificator)}
	 * .
	 */
	@Test
	public void testCreateUuidVacdIdentificator() {
		final II ref = CdaUtil.createUuidVacdIdentificator(testIdentiicator);
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
		final EntryRelationship ref = CdaUtil.updateRefIfComment(testEr, testI, testJ, testPrefix);
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
		final EntryRelationship ref = CdaUtil.updateRefIfComment(testEr, testRef, testPrefix);
		assertNotNull(ref);
		assertTrue(ref.getInversionInd());

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.utils.CdaUtil#addSectionToStructuredBodyAsCopy(org.openhealthtools.mdht.uml.cda.StructuredBody, org.openhealthtools.mdht.uml.cda.Section)}
	 * .
	 */
	@Test
	public void testAddSectionToStructuredBodyAsCopy() {
		CdaUtil.addSectionToStructuredBodyAsCopy(testSb, testS);
		LogFactory.getLog(getClass()).debug(testSb);
	}

}
