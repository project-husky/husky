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

import java.util.Date;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ch.Consumable;
import org.ehealth_connector.cda.ch.CriterionEntry;
import org.ehealth_connector.cda.ch.ExternalDocumentEntry;
import org.ehealth_connector.cda.ch.ImmunizationRecommendation;
import org.ehealth_connector.cda.ch.MedicationTargetEntry;
import org.ehealth_connector.cda.ch.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.enums.CdaChVacdImmunizations;
import org.ehealth_connector.cda.ch.enums.CdaChVacdRecCategories;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.ch.enums.RouteOfAdministration;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ImmunizationRecommendationRecommondationTests.
 */
public class ImmunizationRecommendationTests {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testAddCriterionEntry() throws Exception {

		ImmunizationRecommendation immunization = new ImmunizationRecommendation();
		assertEquals(null, immunization.getCriterionEntry());

		CriterionEntry entry = new CriterionEntry();
		entry.setRecCategory(CdaChVacdRecCategories.REC_NONE, LanguageCode.ITALIAN);

		immunization.setCriterionEntry(entry);

		assertEquals(entry, immunization.getCriterionEntry());

		Document document = immunization.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/precondition/criterion/templateId[@root='2.16.756.5.30.1.1.1.1.3.5.1' and @extension='CDA-CH.VACD.Body.MediL3.Category']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("substanceadministration/precondition/criterion/code[@code='41504' and @codeSystem='2.16.756.5.30.1.127.3.3.4']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testAddMedicationTarget() throws Exception {

		ImmunizationRecommendation immunization = new ImmunizationRecommendation();

		assertEquals(0, immunization.getMedicationTargetEntries().size());

		MedicationTargetEntry medicationTargetEntry = new MedicationTargetEntry();
		medicationTargetEntry.setImmunizationTarget(CdaChVacdImmunizations.HEPB);
		immunization.addMedicationTargetEntry(medicationTargetEntry);

		assertEquals(1, immunization.getMedicationTargetEntries().size());
		assertEquals(medicationTargetEntry, immunization.getMedicationTargetEntries().get(0));

		Document document = immunization.getDocument();

		XPathExpression expr = xpath
				.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.1' and @extension='CDA-CH.Body.MediL3']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("substanceadministration/entryRelationship[@typeCode='RSON' and @inversionInd='false']/observation[@classCode='OBS' and @moodCode='EVN']/templateId[@root='2.16.756.5.30.1.1.1.1.3.5.1' and @extension='CDA-CH.VACD.Body.MediL3.Reason']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testAuthorAsDoctor() throws Exception {
		ImmunizationRecommendation immunization = new ImmunizationRecommendation();

		Name name = new Name("Pieks", "Ratschlag", "Prof.", "Immunologin");
		Author author = new Author(name, "7607777777777");
		immunization.setAuthor(author);

		Document document = immunization.getDocument();

		assertEquals(false, immunization.getAuthor().isAuthorPatient());

		XPathExpression expr = xpath
				.compile("substanceadministration/author/functionCode[@code='221' and @codeSystem='2.16.840.1.113883.2.9.6.2.7' and @codeSystemName='ISCO-08' and @displayName='Medical doctors']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("substanceadministration/author/assignedAuthor/id[@root='1.3.88' and @extension='7607777777777']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("substanceadministration/author/assignedAuthor/assignedPerson/name/given='Pieks'");
		assertTrue((Boolean) expr.evaluate(document, XPathConstants.BOOLEAN));

	}

	@Test
	public void testAuthorAsPatient() throws Exception {
		ImmunizationRecommendation immunization = new ImmunizationRecommendation();

		Name name = new Name("Muster", "Franz");

		Author author = new Author(name);
		author.addId(new Identificator("OID des jeweiligen Systems",
				"D der eintragenden Person, welche innerhalb der OID des jeweiligen Systems eindeutig ist"));
		author.setAuthorIsPatient(true);

		immunization.setAuthor(author);

		assertEquals(true, immunization.getAuthor().isAuthorPatient());

		Document document = immunization.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/author/functionCode[@nullFlavor='NA']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testCommentEntry() throws XPathExpressionException {
		SectionAnnotationCommentEntry commentEntry = new SectionAnnotationCommentEntry();
		commentEntry.setContentIdReference("#reference");

		ImmunizationRecommendation entry = new ImmunizationRecommendation();
		entry.setCommentEntry(commentEntry);

		assertEquals(commentEntry, entry.getCommentEntry());

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/entryRelationship[@typeCode='SUBJ' and @inversionInd='true']/act/text/reference[@value='#reference']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testConsumable() throws XPathExpressionException {
		Consumable consumable = new Consumable("BOOSTRIX Polio Inj Susp");

		Code whoAtc = new Code("2.16.840.1.113883.6.73", "J07CA02");

		Organization organization = new Organization("GlaxoSmithKline");
		consumable.setManufacturer(organization);
		Identificator gtin = new Identificator("1.3.160", "7680006370012");
		consumable.setManufacturedProductId(gtin);
		consumable.setLotNr("lotNr");
		consumable.setWhoAtcCode(whoAtc);

		ImmunizationRecommendation entry = new ImmunizationRecommendation();
		entry.setConsumable(consumable);

		assertEquals(whoAtc, entry.getConsumable().getWhoAtcCode());
		assertEquals(gtin, entry.getConsumable().getManufacturedProductId());
		assertEquals("BOOSTRIX Polio Inj Susp", entry.getConsumable().getTradeName());

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/consumable/manufacturedProduct/templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.7.2']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("substanceadministration/consumable/manufacturedProduct/id[@root='1.3.160' and @extension='7680006370012']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("substanceadministration/consumable/manufacturedProduct/manufacturedMaterial/name='BOOSTRIX Polio Inj Susp'");
		assertTrue((Boolean) expr.evaluate(document, XPathConstants.BOOLEAN));
	}

	@Test
	public void testImmunizationRecommendationSofwareId() throws Exception {
		ImmunizationRecommendation immunization = new ImmunizationRecommendation();

		Identificator identificator = new Identificator("oid", "id");
		immunization.setId(identificator);

		assertEquals(identificator, immunization.getId());

		Document document = immunization.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/id[@root='oid' and @extension='id']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}

	@Test
	public void testImmunizationUndesired() throws Exception {
		ImmunizationRecommendation immunization = new ImmunizationRecommendation();

		assertTrue(immunization.isAdministered());
		assertTrue(!immunization.isUndesired());

		immunization.setUndesired();
		assertTrue(!immunization.isAdministered());
		assertTrue(immunization.isUndesired());

		Document document = immunization.getDocument();

		XPathExpression expr = xpath.compile("substanceadministration[@negationInd='true']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testPossibleAppliance() throws XPathExpressionException {
		ImmunizationRecommendation entry = new ImmunizationRecommendation();

		Date appliedAt = DateUtil.parseDateyyyyMMdd("20151019");

		entry.setPossibleAppliance(appliedAt);

		assertEquals(appliedAt, entry.getPossibleAppliance());

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/effectiveTime[@value='20151019']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testPossibleApplianceStartEndDate() throws XPathExpressionException {
		ImmunizationRecommendation entry = new ImmunizationRecommendation();

		Date appliedStartAt = DateUtil.parseDateyyyyMMdd("20151019");
		Date appliedEndAt = DateUtil.parseDateyyyyMMdd("20161019");

		entry.setPossibleAppliance(appliedStartAt, appliedEndAt);

		assertEquals(appliedStartAt, entry.getPossibleApplianceStartDate());
		assertEquals(appliedEndAt, entry.getPossibleApplianceEndDate());

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/effectiveTime/low[@value='20151019']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("substanceadministration/effectiveTime/high[@value='20161019']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testPriorityCode() throws XPathExpressionException {
		ImmunizationRecommendation entry = new ImmunizationRecommendation();

		Code priorityCode = new Code("2.16.840.1.113883.5.7", "UR");
		entry.setPriorityCode(priorityCode);
		assertEquals(priorityCode, entry.getPriorityCode());

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/priorityCode[@code='UR' and @codeSystem='2.16.840.1.113883.5.7']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testRouteCode() throws XPathExpressionException {
		ImmunizationRecommendation entry = new ImmunizationRecommendation();
		entry.setRouteOfAdministration(RouteOfAdministration.INJECTION_SUBCUTANEOUS);
		assertEquals(RouteOfAdministration.INJECTION_SUBCUTANEOUS, entry.getRouteOfAdministration());

		Document document = entry.getDocument();
		XPathExpression expr = xpath
				.compile("substanceadministration/routeCode[@code='SQ' and @codeSystem='2.16.840.1.113883.5.112']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		ImmunizationRecommendation immunization = new ImmunizationRecommendation();

		Document document = immunization.getDocument();

		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.12.2']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("substanceadministration[@moodCode='PRP' and @negationInd='false']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.25']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.1' and @extension='CDA-CH.Body.MediL3']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("substanceadministration/code[@code='IMMUNIZ' and @codeSystem='2.16.840.1.113883.5.4']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("substanceadministration/statusCode[@code='active']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("substanceadministration/routeCode[@nullFlavor='NA']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("substanceadministration/priorityCode[@nullFlavor='UNK']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testTextReference() throws XPathExpressionException {
		ImmunizationRecommendation entry = new ImmunizationRecommendation();

		entry.setTextReference("#reference1");

		Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("substanceadministration/text/reference[@value='#reference1']");

		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#reference1", entry.getTextReference());
	}

	@Test
	public void textExternalDocumentEntry() throws XPathExpressionException {
		ImmunizationRecommendation entry = new ImmunizationRecommendation();

		ExternalDocumentEntry externalDocEntry = new ExternalDocumentEntry();
		externalDocEntry.setReference("http://www.bag.admin.ch/ekif/04423/04428/index.html",
				"Schweizerischer Impfplan");
		entry.setExternalDocumentEntry(externalDocEntry);

		assertEquals(externalDocEntry, entry.getExternalDocumentEntry());

		Document document = entry.getDocument();

		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();

		XPathExpression expr = xpath
				.compile("substanceadministration/reference[@typeCode='REFR']/externalDocument/text/reference[@value='http://www.bag.admin.ch/ekif/04423/04428/index.html']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

}
