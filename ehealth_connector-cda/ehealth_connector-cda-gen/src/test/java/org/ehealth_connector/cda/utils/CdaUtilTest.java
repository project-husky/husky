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
package org.ehealth_connector.cda.utils;

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
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * Test of CdaUtil
 */
public class CdaUtilTest {

	protected String testId;
	protected Identificator testIdentiicator;
	protected EntryRelationship testEr;
	protected String testRef;
	protected int testI;
	protected int testJ;
	protected StructuredBody testSb;
	protected Section testS;
	protected String testText;

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
	 * {@link org.ehealth_connector.cda.utils.CdaUtil#addSectionToStructuredBodyAsCopy(org.openhealthtools.mdht.uml.cda.StructuredBody, org.openhealthtools.mdht.uml.cda.Section)}
	 * .
	 */
	@Test
	public void testAddSectionToStructuredBodyAsCopy() {
		CdaUtil.addSectionToStructuredBodyAsCopy(testSb, testS);
	}

}
