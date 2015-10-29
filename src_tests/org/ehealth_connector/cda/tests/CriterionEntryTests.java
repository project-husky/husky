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

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ch.CriterionEntry;
import org.ehealth_connector.cda.ch.enums.CdaChVacdRecCategories;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class CriterionEntryTests.
 */
public class CriterionEntryTests {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testSerializeEmpty() throws Exception {
		CriterionEntry entry = new CriterionEntry();

		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile(
				"criterion/templateId[@root='2.16.756.5.30.1.1.1.1.3.5.1' and @extension='CDA-CH.VACD.Body.MediL3.Category']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	/*
	 * REC_BASE("41501", "Empfohlene Basisimpfungen",
	 * "Vaccinations recommandées de base", "Vaccinazioni raccomandate di base"
	 * ),
	 */
	@Test
	public void testRecCatgoryCode() throws XPathExpressionException {
		CriterionEntry entry = new CriterionEntry();

		entry.setRecCategoryCode(CdaChVacdRecCategories.REC_BASE.getCode(LanguageCode.GERMAN));

		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile(
				"criterion/code[@code='41501' and @codeSystem='2.16.756.5.30.1.127.3.3.4']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(CdaChVacdRecCategories.REC_BASE.getCode(null), entry.getRecCategoryCode());
	}

	/*
	 * NO_REC("41504", "Impfungen ohne Empfehlungen",
	 * "Vaccinations sans recommandation d’utilisation",
	 * "Vaccinazioni senza raccomandazione d’utilizzo");
	 */
	@Test
	public void testRecCatgoryEnum() throws XPathExpressionException {
		CriterionEntry entry = new CriterionEntry();

		entry.setRecCategory(CdaChVacdRecCategories.REC_NONE, LanguageCode.FRENCH);
		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile(
				"criterion/code[@code='41504' and @codeSystem='2.16.756.5.30.1.127.3.3.4']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(CdaChVacdRecCategories.REC_NONE, entry.getRecCategory());
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		CriterionEntry entry = new CriterionEntry();

		entry.setTextReference("#reference1");

		Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("criterion/text/reference[@value='#reference1']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}

}
