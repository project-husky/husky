package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Specimen;
import org.junit.Test;
import org.w3c.dom.Document;

public class LaboratoryIsolateOrganizerTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		super.init();
		LaboratoryIsolateOrganizer lio = new LaboratoryIsolateOrganizer();

		Document document = lio.getDocument();
		assertTrue(xExist(document, "//statusCode[@code='completed']"));

		// EffectiveTime
		lio.setEffectiveTime(endDate);
		assertEquals(endDate, lio.getEffectiveTime());

		// Subject
		Specimen s = new Specimen();
		s.addId(id1);
		code1.setOriginalTextReference("testRef5");
		s.setCode(code1);
		lio.setSpecimen(s);
		assertNotNull(lio.getSpecimen());
		assertTrue(code1.equals(lio.getSpecimen().getCode()));
		assertTrue(id1.equals(lio.getSpecimen().getIdList().get(0)));
		assertEquals("testRef5", lio.getSpecimen().getCode().getOriginalTextReference());

		document = lio.getDocument();
		assertTrue(xExist(document, "//specimen[@typeCode='PRD']"));
		assertTrue(xExist(document, "//specimenRole[@classCode='SPEC']"));
		assertTrue(xExist(document, "//specimenPlayingEntity[@classCode='MIC']"));

		// SectionAnnotationCommentEntry sac = new SectionAnnotationCommentEntry();
		// sac.setContentIdReference("testReference");
		// oi.setCommentEntry(sac);
		// assertTrue(lio.getCommentEntry() != null);
		// assertTrue(lio.getCommentEntry().getContentIdReference().equals("#testReference"));
		//
		// document = lio.getDocument();
		// assertTrue(xExist(document,
		// "//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.2']"));
	}
}
