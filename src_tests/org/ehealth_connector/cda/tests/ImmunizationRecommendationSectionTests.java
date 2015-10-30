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

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ch.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.Consumable;
import org.ehealth_connector.cda.ch.CriterionEntry;
import org.ehealth_connector.cda.ch.ExternalDocumentEntry;
import org.ehealth_connector.cda.ch.ImmunizationRecommendation;
import org.ehealth_connector.cda.ch.ImmunizationRecommendationSection;
import org.ehealth_connector.cda.ch.MedicationTargetEntry;
import org.ehealth_connector.cda.ch.enums.CdaChVacdRecCategories;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.common.Author;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ImmunizationRecommendationSectionTests.
 */
public class ImmunizationRecommendationSectionTests {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testSerializeEmpty() throws Exception {
		ImmunizationRecommendationSection immunization = new ImmunizationRecommendationSection(
				LanguageCode.GERMAN);

		Document document = immunization.getDocument();

		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.1.18.3.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//code[@code='18776-5' and @codeSystem='2.16.840.1.113883.6.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("section/title='Impfplan'");
		assertTrue((Boolean) expr.evaluate(document, XPathConstants.BOOLEAN));
	}

	@Test
	public void testAddImmunizationRecommendationEmpty() throws Exception {
		ImmunizationRecommendationSection ImmunizationRecommendationSection = new ImmunizationRecommendationSection(
				LanguageCode.GERMAN);
		ImmunizationRecommendation immunization = new ImmunizationRecommendation();
		ImmunizationRecommendationSection.addImmunizationRecommendation(immunization,
				LanguageCode.GERMAN, true);
		Document document = ImmunizationRecommendationSection.getDocument();
		XPathExpression expr = xpath.compile("//tr");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(2, nodes.getLength());
	}

	@Test
	public void testAddImmunizationRecommendationContentIdCheck() throws Exception {

		ImmunizationRecommendationSection immunizationRecommendationSection = new ImmunizationRecommendationSection(
				LanguageCode.GERMAN);
		ImmunizationRecommendation immunization = new ImmunizationRecommendation();

		Author author = CdaChVacdTest.getArztAllzeitBereit();
		immunization.setAuthor(author);

		MedicationTargetEntry hepA = CdaChVacdTest.getMedTargetEntryHepA();
		MedicationTargetEntry hepB = CdaChVacdTest.getMedTargetEntryHepB();

		immunization.addMedicationTargetEntry(hepA);
		immunization.addMedicationTargetEntry(hepB);

		SectionAnnotationCommentEntry commentEntry = new SectionAnnotationCommentEntry();
		String comment = "Genereller Kommentar";

		commentEntry.setAnnotationCommentText("Genereller Kommentar");
		immunization.setCommentEntry(commentEntry);

		CriterionEntry criterionEntry = new CriterionEntry();
		criterionEntry.setRecCategory(CdaChVacdRecCategories.REC_RISK, LanguageCode.GERMAN);
		immunization.setCriterionEntry(criterionEntry);

		Consumable boostrix = CdaChVacdTest.getConsumableBoostrix();
		immunization.setConsumable(boostrix);

		assertEquals(null, immunization.getTextReference());

		ExternalDocumentEntry entry = new ExternalDocumentEntry();
		entry.setTextReference("http://www.bag.admin.ch/ekif/04423/04428/index.html");
		immunization.setExternalDocumentEntry(entry);

		immunizationRecommendationSection.addImmunizationRecommendation(immunization,
				LanguageCode.GERMAN, true);

		immunizationRecommendationSection.getDocument();

		assertEquals("#irs10", immunization.getTextReference());
		assertEquals("#irs13", criterionEntry.getTextReference());
		assertEquals("#irs14", commentEntry.getContentIdReference());

		assertEquals(comment, commentEntry.getContentIdText(immunizationRecommendationSection,
				commentEntry.getContentIdReference()));

		assertEquals("Hepatitis A immunization (procedure)",
				hepB.getContentIdText(immunizationRecommendationSection, hepA.getTextReference()));
		assertEquals("Hepatitis B vaccination (procedure)",
				hepA.getContentIdText(immunizationRecommendationSection, hepB.getTextReference()));

		ImmunizationRecommendation immunization2 = new ImmunizationRecommendation();
		Consumable boostrix2 = CdaChVacdTest.getConsumableBoostrix();
		immunization2.setConsumable(boostrix2);
		immunizationRecommendationSection.addImmunizationRecommendation(immunization2,
				LanguageCode.GERMAN, true);

		assertEquals("#irs20", immunization2.getTextReference());

	}

}
