/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

package org.ehealth_connector.cda.ch.vacd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdRecCategories;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Author;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ImmunizationRecommendationSectionTests.
 */
public class ImmunizationRecommendationSectionTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testAddImmunizationRecommendationContentIdCheck() throws Exception {

		final ImmunizationRecommendationSection immunizationRecommendationSection = new ImmunizationRecommendationSection(
				LanguageCode.GERMAN);
		final ImmunizationRecommendation immunization = new ImmunizationRecommendation();

		final Author author = CdaChVacdTest.getArztAllzeitBereit();
		immunization.setAuthor(author);

		final MedicationTargetEntry hepA = CdaChVacdTest.getMedTargetEntryHepA();
		final MedicationTargetEntry hepB = CdaChVacdTest.getMedTargetEntryHepB();

		immunization.addMedicationTargetEntry(hepA);
		immunization.addMedicationTargetEntry(hepB);

		final SectionAnnotationCommentEntry commentEntry = new SectionAnnotationCommentEntry();
		final String comment = "Genereller Kommentar";

		commentEntry.setAnnotationCommentText("Genereller Kommentar");
		immunization.setCommentEntry(commentEntry);

		final CriterionEntry criterionEntry = new CriterionEntry();
		criterionEntry.setRecCategory(CdaChVacdRecCategories.REC_RISK, LanguageCode.GERMAN);
		immunization.setCriterionEntry(criterionEntry);

		final Consumable boostrix = CdaChVacdTest.getConsumableBoostrix();
		immunization.setConsumable(boostrix);

		assertEquals(null, immunization.getTextReference());

		final ExternalDocumentEntry entry = new ExternalDocumentEntry();
		entry.setReference("http://www.bag.admin.ch/ekif/04423/04428/index.html",
				"Schweizerischer Impfplan");
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

		final ImmunizationRecommendation immunization2 = new ImmunizationRecommendation();
		final Consumable boostrix2 = CdaChVacdTest.getConsumableBoostrix();
		immunization2.setConsumable(boostrix2);
		immunizationRecommendationSection.addImmunizationRecommendation(immunization2,
				LanguageCode.GERMAN, true);

		assertEquals("#irs20", immunization2.getTextReference());

	}

	@Test
	public void testAddImmunizationRecommendationEmpty() throws Exception {
		final ImmunizationRecommendationSection ImmunizationRecommendationSection = new ImmunizationRecommendationSection(
				LanguageCode.GERMAN);
		final ImmunizationRecommendation immunization = new ImmunizationRecommendation();
		ImmunizationRecommendationSection.addImmunizationRecommendation(immunization,
				LanguageCode.GERMAN, true);
		final Document document = ImmunizationRecommendationSection.getDocument();
		final XPathExpression expr = xpath.compile("//tr");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(2, nodes.getLength());
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final ImmunizationRecommendationSection immunization = new ImmunizationRecommendationSection(
				LanguageCode.GERMAN);

		final Document document = immunization.getDocument();

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

}
