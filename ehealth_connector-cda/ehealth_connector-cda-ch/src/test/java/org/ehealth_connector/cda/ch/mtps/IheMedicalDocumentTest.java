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
package org.ehealth_connector.cda.ch.mtps;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Identificator;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 *
 */
public class IheMedicalDocumentTest extends TestUtils {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	public IheMedicalDocumentTest() {
		super();
	}

	@Test
	public void testDocumentReplaceIdentifier() throws Exception {
		final IheMedicalDocument vacd = new IheMedicalDocument();
		assertEquals(null, vacd.getDocumentToReplaceIdentifier());
		final Identificator identificator = new Identificator("root", "ext");
		vacd.setDocumentToReplaceIdentifier(identificator);
		assertEquals(identificator, vacd.getDocumentToReplaceIdentifier());

		final Document document = vacd.getDocument();
		final XPathExpression expr = xpath.compile(
				"clinicaldocument/relatedDocument[@typeCode='RPLC']/parentDocument/id[@root='root' and @extension='ext']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

}
