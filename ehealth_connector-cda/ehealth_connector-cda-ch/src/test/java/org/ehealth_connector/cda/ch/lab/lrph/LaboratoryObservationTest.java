package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.enums.StandardCdaBodySelections;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryObservation;
import org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed;
import org.ehealth_connector.cda.enums.ObservationInterpretation;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class LaboratoryObservationTest extends TestUtils {

	@Test
	public void testAbstractLaboratoryObservation() throws Exception {

		super.init();

		// Constructors
		final LaboratoryObservation observation = new LaboratoryObservation();
		Document document = observation.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.6']"));
		assertTrue(xExist(document, "//statusCode[@code='completed']"));

		// add er
		// Comment
		SectionAnnotationCommentEntry sce = new SectionAnnotationCommentEntry();
		sce.setContentIdReference("testRef1");
		observation.addCommentEntry(sce);
		assertEquals("#testRef1", observation.getCommentEntry().get(0).getContentIdReference());
		document = observation.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.2']"));
		assertTrue(xExist(document, "//templateId[@root='2.16.840.1.113883.10.20.1.40']"));
		assertTrue(xExist(document, "//reference[@value='#testRef1']"));

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
		observation.setInterpretationCode(ObservationInterpretation.ABNORMAL);
		assertEquals(ObservationInterpretation.ABNORMAL, observation.getInterpretationCodeEnum());
		observation.setLaboratory(organization1, endDate);
		assertTrue(isEqual(organization1, observation.getLaboratory()));
		assertEquals(endDate, DateUtil.parseIVL_TSVDateTimeValue(
				observation.getPerformerList().get(0).getPerformerMdht().getTime()));

		// code with translation
		Code code = new Code(LabObsListSnomed.BRUCELLA_ABORTUS.getCode());
		Code internalCode = new Code("testoid", "LabInternalCode");
		code.addTranslation(internalCode);
		observation.setCode(code);
		document = observation.getDocument();
		assertTrue(
				xExist(document, "//translation[@code='LabInternalCode' and @codeSystem='testoid']"));

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
		LaboratoryObservation observation = new LaboratoryObservation();
		observation.setCode(LabObsListSnomed.BRUCELLA);
		assertEquals(LabObsListSnomed.BRUCELLA, observation.getCodeAsSnomedEnum());

		// Hiv Valueset
		observation.setHivRecency(StandardCdaBodySelections.NO);
		assertEquals(StandardCdaBodySelections.NO, observation.getHivRecency());
	}
}
