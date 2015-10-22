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
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.CdaChVacd;
import org.ehealth_connector.cda.EFacade;
import org.ehealth_connector.common.Identificator;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * The Class CdaChVacdTests.
 */
public class CdaChVacdTests {

	private final Log log = LogFactory.getLog(EFacade.class);

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		CdaChVacd vacd = new CdaChVacd();
		String deserialized = this.serializeDocument(vacd);
		log.debug(deserialized);
		ClinicalDocument vacdDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(vacdDeserialized != null);
	}

	@Test
	public void deserializeVacDirectTest() throws Exception {
		CdaChVacd vacd = new CdaChVacd();
		String deserialized = this.serializeDocument(vacd);
		log.debug(deserialized);
		VACD vacdDeserialized = deserializeVacDirect(deserialized);
		assertTrue(vacdDeserialized != null);
	}

	@Test
	public void deserializeVacdTest() throws Exception {
		CdaChVacd vacd = new CdaChVacd();
		String deserialized = this.serializeDocument(vacd);
		log.debug(deserialized);
		VACD vacdDeserialized = deserializeVacd(deserialized);
		assertTrue(vacdDeserialized != null);
	}

	@Test
	public void deserializeVacdTestTemplateId() throws Exception {
		CHPackage.eINSTANCE.eClass();
		CHPackage.eINSTANCE.getVACD();
		CdaChVacd vacd = new CdaChVacd();
		String deserialized = this.serializeDocument(vacd);
		log.debug(deserialized);
		VACD vacdDeserialized = deserializeVacd(deserialized);
		assertTrue(vacdDeserialized != null);
	}

	@Test
	public void testDocumentReplaceIdentifier() throws Exception {
		CdaChVacd vacd = new CdaChVacd();
		assertEquals(null, vacd.getDocumentToReplaceIdentifier());
		Identificator identificator = new Identificator("root", "ext");
		vacd.setDocumentToReplaceIdentifier(identificator);
		assertEquals(identificator, vacd.getDocumentToReplaceIdentifier());

		Document document = vacd.getDocument();
		XPathExpression expr = xpath.compile(
				"clinicaldocument/relatedDocument[@typeCode='RPLC']/parentDocument/setId[@root='root' and @extension='ext']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	private VACD deserializeVacd(String document) throws Exception {
		InputSource source = new InputSource(new StringReader(document));
		return (VACD) CDAUtil.load(source);
	}

	private VACD deserializeVacDirect(String document) throws Exception {
		InputStream stream = new ByteArrayInputStream(document.getBytes(StandardCharsets.UTF_8));
		ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream, CHPackage.eINSTANCE.getVACD());
		return (VACD) clinicalDocument;
	}

	private String serializeDocument(CdaChVacd vacd) throws Exception {
		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(vacd.getDoc(), boas);
		return boas.toString();
	}

}
