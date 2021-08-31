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

package org.ehealth_connector.cda.ch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ch.enums.RiskOfComplications;
import org.ehealth_connector.cda.ch.enums.RiskOfExposure;
import org.ehealth_connector.cda.enums.AllergiesSpecialConditions;
import org.ehealth_connector.cda.enums.ProblemType;
import org.ehealth_connector.cda.enums.ProblemsSpecialConditions;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ProblemEntryTests.
 */
public class ProblemEntryTest {

	protected XPathFactory xpathFactory = XPathFactory.newInstance();
	protected XPath xpath = xpathFactory.newXPath();

	@Test
	public void testAllergiesSpecialConditions() throws XPathExpressionException {
		final ProblemEntry entry = new ProblemEntry();

		entry.setAllergySpecialCondition(AllergiesSpecialConditions.NO_KNOWN_ALLERGIES);

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile(
				"observation/value[@type='CD' and @code='160244002' and @codeSystem='2.16.840.1.113883.6.96']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(AllergiesSpecialConditions.NO_KNOWN_ALLERGIES,
				entry.getAllergySpecialCondition());
	}

	@Test
	public void testComplicationRisks() throws XPathExpressionException {
		final ProblemEntry entry = new ProblemEntry();

		entry.setComplicationRisk(
				RiskOfComplications.ANDERE_LUNGENERKRANKUNGEN_ZB_MUKOVISZIDOSE_ASTHMA_BRONCHIALE_ETC,
				null);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile(
				"observation/code[@code='55607006' and @codeSystem='2.16.840.1.113883.6.96']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// note, does not check xsi:prefix in attribute value, output
		// xsi:type="CD"
		expr = xpath.compile(
				"observation/value[@type='CD' and @code='114006' and @codeSystem='2.16.756.5.30.1.127.3.3.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(
				RiskOfComplications.ANDERE_LUNGENERKRANKUNGEN_ZB_MUKOVISZIDOSE_ASTHMA_BRONCHIALE_ETC,
				entry.getComplicationRisk());
	}

	@Test
	public void testEndDate() throws Exception {
		final ProblemEntry entry = new ProblemEntry();

		assertEquals(null, entry.getEndDate());
		final Date date = DateUtil.parseDateyyyyMMdd("20161019");
		entry.setEndDate(date);
		assertEquals(date, entry.getEndDate());

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath
				.compile("observation/effectiveTime/high[@value='20161019']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testEndDateNotSet() throws Exception {
		final ProblemEntry entry = new ProblemEntry();

		entry.setEndDate(null);
		final Document document = entry.getDocument();

		final XPathExpression expr = xpath
				.compile("observation/effectiveTime/high[@nullFlavor='UNK']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testExposureRisks() throws XPathExpressionException {
		final ProblemEntry entry = new ProblemEntry();

		entry.setExposureRisk(
				RiskOfExposure.KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN,
				null);

		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile(
				"observation/code[@code='55607006' and @codeSystem='2.16.840.1.113883.6.96']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// note, does not check xsi:prefix in attribute value, output
		// xsi:type="CD"
		expr = xpath.compile(
				"observation/value[@type='CD' and @code='213012' and @codeSystem='2.16.756.5.30.1.127.3.3.2']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(RiskOfExposure.KONSUMENTEN_VON_INJIZIERBAREN_DROGEN_UND_DEREN_KONTAKTPERSONEN,
				entry.getExposureRisk());
	}

	@Test
	public void testProblemOccured() throws Exception {
		final ProblemEntry entry = new ProblemEntry();

		assertEquals(false, entry.getProblemNotOccured());
		entry.setNotOccured(true);
		assertEquals(true, entry.getProblemNotOccured());

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile("observation[@negationInd='true']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

	@Test
	public void testProblemSpecialConditions() throws XPathExpressionException {
		final ProblemEntry entry = new ProblemEntry();

		entry.setProblemSpecialCondition(
				ProblemsSpecialConditions.NO_CURRENT_PROBLEMS_OR_DISABILITY);

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile(
				"observation/value[@type='CD' and @code='160245001' and @codeSystem='2.16.840.1.113883.6.96']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(ProblemsSpecialConditions.NO_CURRENT_PROBLEMS_OR_DISABILITY,
				entry.getProblemSpecialCondition());
	}

	/*
	 * PROBLEM("55607006", "Problem"),
	 */
	@Test
	public void testProblemTypEnum() throws XPathExpressionException {
		final ProblemEntry entry = new ProblemEntry();

		entry.setProblemType(ProblemType.PROBLEM);

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath.compile(
				"observation/code[@code='55607006' and @codeSystem='2.16.840.1.113883.6.96']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals(ProblemType.PROBLEM, entry.getProblemType());
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final ProblemEntry entry = new ProblemEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("observation/templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.5']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("observation/templateId[@root='2.16.840.1.113883.10.20.1.28']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("observation/statusCode[@code='completed']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("observation[@negationInd='false']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("observation/id");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

	@Test
	public void testStartDate() throws Exception {
		final ProblemEntry entry = new ProblemEntry();

		assertEquals(null, entry.getStartDate());
		final Date date = DateUtil.parseDateyyyyMMdd("20151019");
		entry.setStartDate(date);
		assertEquals(date, entry.getStartDate());

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath
				.compile("observation/effectiveTime/low[@value='20151019']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testStartDateNotSet() throws Exception {
		final ProblemEntry entry = new ProblemEntry();

		entry.setStartDate(null);
		final Document document = entry.getDocument();

		final XPathExpression expr = xpath
				.compile("observation/effectiveTime/low[@nullFlavor='UNK']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		final ProblemEntry entry = new ProblemEntry();

		entry.setTextReference("#reference1");

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath
				.compile("observation/text/reference[@value='#reference1']");

		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}

}
