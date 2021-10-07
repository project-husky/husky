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
package org.ehealth_connector.cda.utils;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.hl7cdar2.ED;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Act;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Section;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040StructuredBody;
import org.ehealth_connector.common.hl7cdar2.ST;
import org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of CdaUtil
 */
public class CdaUtilMdhtTest {

	protected String testId;
	protected Identificator testIdentiicator;
	protected POCDMT000040EntryRelationship testEr;
	protected String testRef;
	protected int testI;
	protected int testJ;
	protected POCDMT000040StructuredBody testSb;
	protected POCDMT000040Section testS;
	protected String testText;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testId = "1234-5678-123456789";
		testIdentiicator = new Identificator(CodeSystems.GLN.getCodeSystemId(), testId);
		testEr = new POCDMT000040EntryRelationship();
		testEr.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
		testEr.setInversionInd(true);
		final POCDMT000040Act act = new POCDMT000040Act();
		final ED ed = new ED();
		testText = "Dies ist ein test";
		ed.xmlContent = testText;
		act.setText(ed);
		testEr.setAct(act);
		testRef = "ABCDEFGHIJKL";

		testSb = new POCDMT000040StructuredBody();
		testSb.setLanguageCode(LanguageCode.GERMAN.getCS());
		final POCDMT000040InfrastructureRootTypeId irtid1 = new POCDMT000040InfrastructureRootTypeId();
		irtid1.setRoot("1.2.3.4.5.6.7");
		irtid1.setExtension("1234567890");
		testSb.setTypeId(irtid1);
		testS = new POCDMT000040Section();
		final POCDMT000040InfrastructureRootTypeId irtid2 = new POCDMT000040InfrastructureRootTypeId();
		irtid2.setRoot("7.6.5.4.3.2.1");
		irtid2.setExtension("0987654321");
		testS.setTypeId(irtid2);
		ST title = new ST();
		title.xmlContent = "Dies ist mein Titel";
		testS.setTitle(title);
		testS.setLanguageCode(LanguageCode.GERMAN.getCS());

		testI = 1111;
		testJ = 2222;
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.utils.CdaUtilMdht#addSectionToStructuredBodyAsCopy(org.openhealthtools.mdht.uml.cda.StructuredBody, org.openhealthtools.mdht.uml.cda.Section)}
	 * .
	 */
	@Test
	public void testAddSectionToStructuredBodyAsCopy() {
		CdaUtil.addSectionToStructuredBody(testSb, testS);
	}

}
