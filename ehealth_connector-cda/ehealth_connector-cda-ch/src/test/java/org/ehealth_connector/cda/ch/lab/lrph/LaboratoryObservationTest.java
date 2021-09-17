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
package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.enums.StandardCdaBodySelections;
import org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Performer;
import org.ehealth_connector.common.mdht.enums.ObservationInterpretation;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class LaboratoryObservationTest extends TestUtils {
	final LaboratoryObservation observation;

	public LaboratoryObservationTest() {
		super.init();
		observation = new LaboratoryObservation();
	}

	@Test
	public void testAbstractLaboratoryObservation() throws Exception {

		// Constructors
		Document document = observation.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.6']"));
		assertTrue(xExist(document, "//statusCode[@code='completed']"));

		// add er
		// Comment
		SectionAnnotationCommentEntry sce = new SectionAnnotationCommentEntry();
		sce.setContentIdReference("testRef1");
		observation.addCommentEntry(sce);
		assertEquals("#testRef1", observation.getCommentEntryList().get(0).getContentIdReference());
		document = observation.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.2']"));
		assertTrue(xExist(document, "//templateId[@root='2.16.840.1.113883.10.20.1.40']"));
		assertTrue(xExist(document, "//reference[@value='#testRef1']"));
		assertTrue(
				xExist(document, "//entryRelationship[@typeCode='SUBJ' and @inversionInd='true']"));

		// Performer
		Performer performer = new Performer(organization1);
		observation.addPerformer(performer, super.endDate);

		// Value
		observation.addValue(value1);
		observation.addValue(value2);
		document = observation.getDocument();
		XPathExpression expr = xpath.compile("//value");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(2, nodes.getLength());
		assertTrue(xExist(document, "//value[@code='" + value1.getCode().getCode() + "']"));

		// setter
		observation.setEffectiveTime(startDate);
		assertEquals(startDate, observation.getEffectiveTime());
		observation.addInterpretationCode(ObservationInterpretation.ABNORMAL);
		assertEquals(ObservationInterpretation.ABNORMAL,
				observation.getInterpretationCodesAsEnum().get(0));
		observation.setLaboratory(organization1, endDate);
		assertTrue(isEqual(organization1, observation.getLaboratory()));
		assertEquals(endDate, DateUtilMdht.parseIVL_TSVDateTimeValue(
				observation.getPerformers().get(0).getPerformerMdht().getTime()));

		// code with translation
		Code code = new Code(LabObsListSnomed.BRUCELLA_ABORTUS.getCode());
		Code internalCode = new Code("testoid", "LabInternalCode");
		code.addTranslation(internalCode);
		observation.setCode(code);
		document = observation.getDocument();
		assertTrue(xExist(document,
				"//translation[@code='LabInternalCode' and @codeSystem='testoid']"));

		// new code
		SectionAnnotationCommentEntry sace = new SectionAnnotationCommentEntry();
		sace.setContentIdReference("testRefNumber9");
		Code newCode = new Code("testoid", "NewCode");
		observation.setNewCode(newCode, sace);
		document = observation.getDocument();
		assertTrue(xExist(document, "//translation[@code='NewCode' and @codeSystem='testoid']"));

	}

	@Test
	public void testLaboratoryObservationLrph() {
		// Code Valueset
		observation.setCode(LabObsListSnomed.BRUCELLA);
		assertEquals(LabObsListSnomed.BRUCELLA, observation.getCodeAsSnomedEnum());

		// Hiv Valueset
		observation.setHivRecency(StandardCdaBodySelections.NO);
		assertEquals(StandardCdaBodySelections.NO, observation.getHivRecency());
	}
}
