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

import org.ehealth_connector.cda.CommentEntry;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.CriterionEntry;
import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ImmunizationSection;
import org.ehealth_connector.cda.MedicationTargetEntry;
import org.ehealth_connector.cda.ch.enums.CdaChVacdRecCategories;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.common.Author;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ImmunizationSectionTest.
 */
public class ImmunizationSectionTests {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testSerializeEmpty() throws Exception {
		ImmunizationSection immunization = new ImmunizationSection(LanguageCode.GERMAN);

		Document document = immunization.getDocument();

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

	@Test
	public void testAddImmunizationEmpty() throws Exception {
		ImmunizationSection immunizationSection = new ImmunizationSection(LanguageCode.GERMAN);
		Immunization immunization = new Immunization();
		immunizationSection.addImmunization(immunization, LanguageCode.GERMAN, true);
		Document document = immunizationSection.getDocument();
		XPathExpression expr = xpath.compile("//tr");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(2, nodes.getLength());
	}

	@Test
	public void testAddImmunizationContentIdCheck() throws Exception {

		ImmunizationSection immunizationSection = new ImmunizationSection(LanguageCode.GERMAN);
		Immunization immunization = new Immunization();

		Author author = CdaChVacdTest.getArztAllzeitBereit();
		immunization.setAuthor(author);
		immunization.setPerformer(author);

		MedicationTargetEntry hepA = CdaChVacdTest.getMedTargetEntryHepA();
		MedicationTargetEntry hepB = CdaChVacdTest.getMedTargetEntryHepB();
		MedicationTargetEntry diphterie = CdaChVacdTest.getMedTargetEntryDiptherie();

		immunization.addMedicationTargetEntry(hepA);
		immunization.addMedicationTargetEntry(hepB);
		immunization.addMedicationTargetEntry(diphterie);

		CommentEntry commentEntry = new CommentEntry();
		String comment = "Genereller Kommentar";

		commentEntry.setText("Genereller Kommentar");
		immunization.setCommentEntry(commentEntry);

		CriterionEntry criterionEntry = new CriterionEntry();
		criterionEntry.setRecCategory(CdaChVacdRecCategories.REC_RISK, LanguageCode.GERMAN);
		immunization.setCriterionEntry(criterionEntry);

		Consumable boostrix = CdaChVacdTest.getConsumableBoostrix();
		immunization.setConsumable(boostrix);

		assertEquals(null, immunization.getTextReference());

		immunizationSection.addImmunization(immunization, LanguageCode.GERMAN, true);

		assertEquals("#is10", immunization.getTextReference());
		assertEquals("#is11", diphterie.getTextReference());
		assertEquals("#is12", hepB.getTextReference());
		assertEquals("#is13", hepA.getTextReference());
		assertEquals("#is14", criterionEntry.getTextReference());
		assertEquals("#is15", commentEntry.getTextReference());

		assertEquals(comment, commentEntry.getContentIdText(immunizationSection,
				commentEntry.getTextReference()));

		assertEquals("Hepatitis A immunization (procedure)",
				hepB.getContentIdText(immunizationSection, hepA.getTextReference()));
		assertEquals("Hepatitis B vaccination (procedure)",
				hepA.getContentIdText(immunizationSection, hepB.getTextReference()));

		Immunization immunization2 = new Immunization();
		Consumable boostrix2 = CdaChVacdTest.getConsumableBoostrix();
		immunization2.setConsumable(boostrix2);
		immunizationSection.addImmunization(immunization2, LanguageCode.GERMAN, true);

		immunizationSection.getDocument();

		assertEquals("#is20", immunization2.getTextReference());

	}

}
