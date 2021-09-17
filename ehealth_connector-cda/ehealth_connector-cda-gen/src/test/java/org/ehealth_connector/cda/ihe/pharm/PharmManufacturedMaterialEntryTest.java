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

package org.ehealth_connector.cda.ihe.pharm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.junit.jupiter.api.Test;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class PharmManufacturedMaterialEntryTest.
 */
public class PharmManufacturedMaterialEntryTest {

	private XPath xpath = PharmXPath.getXPath();

	@Test
	public void testContent() throws XPathExpressionException {

		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();
		String name = "BOOSTRIX Polio Inj Susp";

		Code whoAtc = new Code("2.16.840.1.113883.6.73", "J07CA02");

		entry.setName(name);
		entry.setLotNr("lotNr");
		entry.setWhoAtcCode(whoAtc);

		assertEquals(whoAtc, entry.getWhoAtcCode());
		assertEquals("BOOSTRIX Polio Inj Susp", entry.getName());
		assertEquals("lotNr", entry.getLotNr());

		Document document = entry.getDocument(true);

		XPathExpression expr = xpath
				.compile("//cda:templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testFormCode() throws XPathExpressionException {
		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();

		Code formCode = new Code("2.16.840.1.113883.5.85", "TAB", "Tablet");
		entry.setFormCode(formCode);

		Date expirationTime = DateUtilMdht.dateAndTime("04.12.2021 12:00");
		entry.setExpirationTime(expirationTime);

		assertEquals(formCode, entry.getFormCode());
		assertEquals(expirationTime, entry.getExpirationTime());

		Document document = entry.getDocument(true);

		XPathExpression expr = xpath
				.compile("//cda:templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"//pharm:formCode[@code='TAB' and @codeSystem='2.16.840.1.113883.5.85' and @displayName='Tablet']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

	@Test
	public void testIngredient() throws XPathExpressionException {
		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();

		Code code = new Code("2.16.840.1.113883.6.73", "A10BA02", "metformin");
		entry.setIngredientCode(code);

		String brandName = "various";
		entry.setIngredientName(brandName);

		Value quantity = new Value(new Double(1000), new Double(1), Ucum.MilliGram);

		entry.setIngredientQuantity(quantity);

		assertEquals(brandName, entry.getIngredientName());
		assertEquals(code, entry.getIngredientCode());

		Document document = entry.getDocument(true);
		XPathExpression expr = xpath.compile("//cda:material/pharm:ingredient[@classCode='ACTI']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"//pharm:code[@code='A10BA02' and @codeSystem='2.16.840.1.113883.6.73' and @displayName='metformin']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//pharm:quantity/pharm:numerator[@unit='mg' and @value='1000.0']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//pharm:name[text()='various']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testPackagedMedicineProduct() throws XPathExpressionException {
		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();

		Code code = new Code("GTIN", "7680553510145", "METFIN cpr pell 1000 mg 60 pce");
		entry.setPackagedMedicineProductCode(code);

		String brandName = "METFIN cpr pell 1000 mg";
		entry.setPackagedMedicineName(brandName);

		Code formCode = new Code("2.16.840.1.113883.5.85", "TAB", "Tablet");
		entry.setPackagedMedicineFormCode(formCode);

		BigDecimal value = BigDecimal.valueOf(60);
		entry.setPackagedMedicineQuantity(value);

		assertEquals(code, entry.getPackagedMedicineProductCode());
		assertEquals(brandName, entry.getPackagedMedicineName());
		assertEquals(formCode, entry.getPackagedMedicineFormCode());
		assertEquals(value, entry.getPackagedMedicineQuantity());

		Document document = entry.getDocument(true);
		XPathExpression expr = xpath.compile("//cda:material/pharm:asContent");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"//pharm:code[@code='7680553510145' and @codeSystem='GTIN' and @displayName='METFIN cpr pell 1000 mg 60 pce']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//pharm:capacityQuantity[@value='60']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"//pharm:formCode[@code='TAB' and @codeSystem='2.16.840.1.113883.5.85' and @displayName='Tablet']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testPharmNamespace() {
		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();
		Code formCode = new Code("2.16.840.1.113883.5.85", "TAB", "Tablet");
		entry.setFormCode(formCode);
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		try {
			CDAUtil.saveSnippet(entry.getMdht(), boas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(boas.toString().contains("pharm:"));
	}

	// <pharm:ingredient classCode="ACTI"
	// xmlns:pharm="urn:ihe:pharm:medication">
	// <pharm:quantity>
	// <pharm:numerator unit="mg" value="1000"
	// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	// xsi:type="pharm:PQ"/>
	// <pharm:denominator value="1"
	// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	// xsi:type="pharm:PQ"/>
	// </pharm:quantity>
	// <pharm:ingredient classCode="MMAT" determinerCode="KIND">
	// <pharm:code code="A10BA02" codeSystem="2.16.840.1.113883.6.73"
	// codeSystemName="ATC WHO" displayName="metformin"/>
	// <pharm:name>various</pharm:name>
	// </pharm:ingredient>

	@Test
	public void testSerializeEmpty() throws Exception {
		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();
		final Document document = entry.getDocument(true);
		XPathExpression expr = xpath
				.compile("//cda:templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		expr = xpath.compile("//cda:material[@classCode='MMAT' and @determinerCode='KIND']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

}
