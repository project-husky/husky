package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class OutbreakIdentificationTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		OutbreakIdentificationObservation oi = new OutbreakIdentificationObservation();

		Document document = oi.getDocument();
		assertTrue(xExist(document, "//code[@code='416534008']"));
		assertTrue(xExist(document, "//statusCode[@code='completed']"));
		assertTrue(xExist(document, "//value[@type='CE' and @nullFlavor='NA']"));

		// Annotation Comment
		SectionAnnotationCommentEntry sac = new SectionAnnotationCommentEntry();
		sac.setContentIdReference("testReference");
		oi.setCommentEntry(sac);
		assertTrue(oi.getCommentEntry() != null);
		assertTrue(oi.getCommentEntry().getContentIdReference().equals("#testReference"));

		document = oi.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.2']"));
	}
}
