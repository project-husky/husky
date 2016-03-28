package org.ehealth_connector.cda.ch.lab.lrqc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ihe.lab.enums.LabObservationMediaMimeType;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class ObservationMediaEntryTest extends TestUtils {

	@Test
	public void modelTest() throws XPathExpressionException, FileNotFoundException {
		ObservationMediaEntry o = new ObservationMediaEntry();

		// set Image
		// Read a sample file (not an image), encode it into the
		// ObservationMediaEntry and write it to the disc
		InputStream is = this.getClass().getResourceAsStream("/cda/vacDoc_Test2.xml");
		OutputStream os = new FileOutputStream("ObservationMediaTest.xml");

		try {
			o.setObject(is, LabObservationMediaMimeType.BMP_IMAGE);
			o.getObject(os);

		} catch (IOException e) {
			e.printStackTrace();
		}
		o.setObservationMediaId("TestRef");
		assertEquals("TestRef", o.getObservationMediaId());

		Document document = o.getDocument();
		assertTrue(xExist(document, "//observationmedia[@classCode='OBS' and @moodCode='EVN']"));
		assertTrue(xExist(document, "//value[@representation='B64']"));

		// add comment
		SectionAnnotationCommentEntry sac = new SectionAnnotationCommentEntry();
		sac.setContentIdReference("TestRef");
		o.addCommentEntry(sac);
		assertFalse(o.getCommentEntryList().isEmpty());
		assertEquals("#TestRef", o.getCommentEntryList().get(0).getContentIdReference());

		document = o.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.2']"));

	}
}
