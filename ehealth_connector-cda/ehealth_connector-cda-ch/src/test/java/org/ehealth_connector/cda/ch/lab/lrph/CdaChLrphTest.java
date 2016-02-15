package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReportTest;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class CdaChLrphTest extends AbstractLaboratoryReportTest {

	private CdaChLrph deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return new CdaChLrph((org.openhealthtools.mdht.uml.cda.ch.CdaChLrph) CDAUtil.load(source));
	}

	private CdaChLrph deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				CHPackage.eINSTANCE.getCdaChMtpsDis());
		return new CdaChLrph((org.openhealthtools.mdht.uml.cda.ch.CdaChLrph) clinicalDocument);
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	private String serializeDocument(CdaChLrph doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}

	@Override
	@Test
	public void testDocumentHeader() throws XPathExpressionException {
		final CdaChLrph cda = new CdaChLrph();
		final Document document = cda.getDocument();

		// LRPH
		XPathExpression expr = xpath.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.3.3.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// expr = xpath.compile("//code[@code='18725-2']");
		// nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		// assertEquals(1, nodes.getLength());
	}
}
