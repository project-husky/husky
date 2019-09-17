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

package org.ehealth_connector.cda.ch.vacd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdRecCategories;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Author;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ImmunizationSectionTest.
 */
public class ImmunizationSectionTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testAddImmunizationContentIdCheck() throws Exception {

		final ImmunizationSection immunizationSection = new ImmunizationSection(
				LanguageCode.GERMAN);
		final Immunization immunization = new Immunization();

		final Author author = CdaChVacdTest.getArztAllzeitBereit();
		immunization.setAuthor(author);
		immunization.setPerformer(author);

		final MedicationTargetEntry hepA = CdaChVacdTest.getMedTargetEntryHepA();
		final MedicationTargetEntry hepB = CdaChVacdTest.getMedTargetEntryHepB();
		final MedicationTargetEntry diphterie = CdaChVacdTest.getMedTargetEntryDiptherie();

		immunization.addMedicationTargetEntry(hepA);
		immunization.addMedicationTargetEntry(hepB);
		immunization.addMedicationTargetEntry(diphterie);

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

		immunizationSection.addImmunization(immunization, true);

		assertEquals("#is10", immunization.getTextReference());
		assertEquals("#is11", diphterie.getTextReference());
		assertEquals("#is12", hepA.getTextReference());
		assertEquals("#is13", hepB.getTextReference());
		assertEquals("#is14", criterionEntry.getTextReference());
		assertEquals("#is15", commentEntry.getContentIdReference());

		assertEquals(comment, commentEntry.getContentIdText(immunizationSection,
				commentEntry.getContentIdReference()));

		assertEquals("Hepatitis A immunization (procedure)",
				hepB.getContentIdText(immunizationSection, hepA.getTextReference()));
		assertEquals("Hepatitis B vaccination (procedure)",
				hepA.getContentIdText(immunizationSection, hepB.getTextReference()));

		final Immunization immunization2 = new Immunization();
		final Consumable boostrix2 = CdaChVacdTest.getConsumableBoostrix();
		immunization2.setConsumable(boostrix2);
		immunizationSection.addImmunization(immunization2, true);

		immunizationSection.getDocument();

		assertEquals("#is20", immunization2.getTextReference());

	}

	@Test
	public void testAddImmunizationEmpty() throws Exception {
		final ImmunizationSection immunizationSection = new ImmunizationSection(
				LanguageCode.GERMAN);
		final Immunization immunization = new Immunization();
		immunizationSection.addImmunization(immunization, true);
		final Document document = immunizationSection.getDocument();
		final XPathExpression expr = xpath.compile("//tr");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(2, nodes.getLength());
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final ImmunizationSection immunization = new ImmunizationSection(LanguageCode.GERMAN);

		final Document document = immunization.getDocument();

		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.3.23']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.6']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//code[@code='11369-6' and @codeSystem='2.16.840.1.113883.6.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("section/title='Impfungen'");
		assertTrue((Boolean) expr.evaluate(document, XPathConstants.BOOLEAN));
	}

}
