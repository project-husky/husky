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
package org.ehealth_connector.cda.ch.emed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.Serializable;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.StringUtils;
import org.ehealth_connector.cda.ch.emed.v097.DosageInstructionsEntryDosageChange;
import org.ehealth_connector.cda.ch.emed.v097.DosageInstructionsStartStopFrequency;
import org.ehealth_connector.cda.ch.emed.v097.DosageIntakeModeEntryContentModule;
import org.ehealth_connector.cda.ch.emed.v097.MedicationTreatmenPlanSectionContentModule;
import org.ehealth_connector.cda.ch.emed.v097.enums.ChEmedTimingEvent;
import org.ehealth_connector.cda.ch.emed.v097.enums.UnitsOfPresentation;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.hl7cdar2.EIVLEvent;
import org.ehealth_connector.common.hl7cdar2.EIVLTS;
import org.ehealth_connector.common.hl7cdar2.INT;
import org.ehealth_connector.common.hl7cdar2.IVLPQ;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.PIVLTS;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Component3;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040StructuredBody;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.ehealth_connector.common.hl7cdar2.PQ;
import org.ehealth_connector.common.hl7cdar2.SXCMTS;
import org.ehealth_connector.common.hl7cdar2.SXPRTS;
import org.ehealth_connector.common.hl7cdar2.SetOperator;
import org.ehealth_connector.common.hl7cdar2.StrucDocTable;
import org.ehealth_connector.common.hl7cdar2.StrucDocTd;
import org.ehealth_connector.common.hl7cdar2.StrucDocText;
import org.ehealth_connector.common.hl7cdar2.TS;
import org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * <div class="en">Unit Tests for Class EmedChStrucDocTextBuilderV097</div>
 */
public class EmedChStrucDocTextBuilderV097Test {
	/**
	 * to create new objects
	 */
	private ObjectFactory factory = new ObjectFactory();

	/**
	 * Add dosage
	 *
	 * @param dosageInstructionsStartStopFrequency
	 * @return
	 */
	private POCDMT000040ClinicalDocument addDosageInstructionToNewDoc(
			DosageInstructionsStartStopFrequency dosageInstructionsStartStopFrequency) {
		POCDMT000040ClinicalDocument doc = factory.createPOCDMT000040ClinicalDocument();
		POCDMT000040Entry entry = factory.createPOCDMT000040Entry();
		MedicationTreatmenPlanSectionContentModule section = new MedicationTreatmenPlanSectionContentModule();
		entry.setSubstanceAdministration(dosageInstructionsStartStopFrequency);
		section.getEntry().add(entry);
		POCDMT000040Component3 comp3 = factory.createPOCDMT000040Component3();
		comp3.setSection(section);
		POCDMT000040StructuredBody structuredBody = CdaUtil.getHl7CdaR2StructuredBody(doc);
		structuredBody.getComponent().add(comp3);

		jaxbObjectToXML(doc);
		return doc;
	}

	/**
	 * Add phase to pivlts
	 *
	 * @param pivlts
	 * @param low
	 * @param widthMinutes
	 * @return
	 */
	private PIVLTS addPhaseToPivlTs(PIVLTS pivlts, Date low, String widthMinutes) {
		ObjectFactory factory = new ObjectFactory();
		IVLTS retVal = factory.createIVLTS();

		if (low != null) {
			TS tsLow = null;

			tsLow = factory.createTS();
			tsLow.setValue(DateUtil.formatDateTime(low));

			retVal.getRest()
					.add(new JAXBElement<TS>(new QName("urn:hl7-org:v3", "low"), TS.class, tsLow));

		}
		if (widthMinutes != null) {
			PQ pq = factory.createPQ();
			pq.setValue(widthMinutes);
			pq.setUnit("min");
			retVal.getRest()
					.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "width"), PQ.class, pq));
		}

		pivlts.setPhase(retVal);
		return pivlts;
	}

	/**
	 * Creates sample data.
	 *
	 * @return the eivlts
	 */
	private EIVLTS createAcm() {

		return createEIVLTS(ChEmedTimingEvent.BEFORE_BREAKFAST_L1);
	}

	/**
	 * Creates sample data.
	 *
	 * @return the eivlts
	 */
	private EIVLTS createAcmWithOffset() {
		ObjectFactory factory = new ObjectFactory();
		EIVLTS acm = DosageInstructionsStartStopFrequency.getPredefinedEffectiveTimeA();
		EIVLEvent eivlEvent = factory.createEIVLEvent();
		eivlEvent.setCode(ChEmedTimingEvent.BEFORE_BREAKFAST_L1.getCodeValue());
		acm.setEvent(eivlEvent);
		IVLPQ offset = createHl7CdaR2Ivlpq("1", "2", "1", "h");
		acm.setOffset(offset);
		return acm;
	}

	/**
	 * Creates sample data.
	 *
	 * @return the dosage instructions for a specific datetime
	 */
	private DosageInstructionsEntryDosageChange createDosageInstructionsEntryDosageChange(int sN,
			String doseQuantityInG, String rateQuantityInG, ChEmedTimingEvent chEmedTimingEvent) {
		ObjectFactory objectFactory = new ObjectFactory();
		POCDMT000040SubstanceAdministration substanceAdministration = objectFactory
				.createPOCDMT000040SubstanceAdministration();
		DosageInstructionsEntryDosageChange dosageInstructionsEntryDosageChange = new DosageInstructionsEntryDosageChange();
		INT anInt = new INT();

		anInt.setValue(BigInteger.valueOf(sN));

		dosageInstructionsEntryDosageChange.setHl7SequenceNumber(anInt);
		dosageInstructionsEntryDosageChange.setSubstanceAdministration(substanceAdministration);
		if (doseQuantityInG != null) {
			IVLPQ doseQuantity = CdaUtil.createHl7CdaR2Ivlpq(doseQuantityInG,
					UnitsOfPresentation.G.getCodeValue());
			substanceAdministration.setDoseQuantity(doseQuantity);
		}
		if (rateQuantityInG != null) {
			IVLPQ doseQuantity = CdaUtil.createHl7CdaR2Ivlpq(rateQuantityInG,
					UnitsOfPresentation.MIN.getCodeValue());

			substanceAdministration.setRateQuantity(doseQuantity);
		}
		substanceAdministration.getEffectiveTime().add(createEIVLTS(chEmedTimingEvent));
		return dosageInstructionsEntryDosageChange;

	}

	/**
	 * Creates sample data.
	 *
	 * @return the dosage instructions start stop frequency
	 */
	@SuppressWarnings("unused")
	private DosageInstructionsStartStopFrequency createDosageSingle() {

		DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
		diStartStopFrequency.getClassCode().add("SBADM");

		diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

		diStartStopFrequency.getTemplateId()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

		diStartStopFrequency.getEffectiveTime()
				.add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

		diStartStopFrequency.getEffectiveTime().add(createAcm());

		diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5", null));

		return diStartStopFrequency;

	}

	/**
	 * Creates sample data.
	 *
	 * @return the dosage instructions start stop frequency
	 */
	@SuppressWarnings("unused")
	private DosageInstructionsStartStopFrequency createDosageSingleWithOffset() {

		DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
		diStartStopFrequency.getClassCode().add("SBADM");

		diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

		diStartStopFrequency.getTemplateId()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

		diStartStopFrequency.getEffectiveTime()
				.add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

		EIVLTS eivlts = createAcmWithOffset();

		System.out.println(EmedChStrucDocTextBuilderV097.parseEivlTs(LanguageCode.ENGLISH, eivlts));
		diStartStopFrequency.getEffectiveTime().add(eivlts);

		diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5", null));

		return diStartStopFrequency;

	}

	/**
	 * Creates sample data.
	 *
	 * @return the dosage instructions start stop frequency
	 */
	private DosageInstructionsStartStopFrequency createDosageSplited() {

		DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
		diStartStopFrequency.getClassCode().add("SBADM");

		diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

		diStartStopFrequency.getTemplateId()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.9").getHl7CdaR2Ii());

		diStartStopFrequency.getEffectiveTime()
				.add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

		diStartStopFrequency.getEntryRelationship().add(createDosageInstructionsEntryDosageChange(1,
				"40", null, ChEmedTimingEvent.AFTER_DINNER_L1));
		diStartStopFrequency.getEntryRelationship().add(createDosageInstructionsEntryDosageChange(2,
				"20", "10", ChEmedTimingEvent.BEFORE_SLEEP_L1));

		diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5", null));

		return diStartStopFrequency;

	}

	/**
	 * Creates sample data.
	 *
	 * @return the eivlts
	 */
	private EIVLTS createEIVLTS(ChEmedTimingEvent chEmedTimingEvent) {
		ObjectFactory factory = new ObjectFactory();
		EIVLTS acm = DosageInstructionsStartStopFrequency.getPredefinedEffectiveTimeA();
		EIVLEvent eivlEvent = factory.createEIVLEvent();
		eivlEvent.setCode(chEmedTimingEvent.getCodeValue());

		acm.setEvent(eivlEvent);
		return acm;
	}

	private IVLPQ createHl7CdaR2Ivlpq(String lowValue, String highValue, String widthValue,
			String unit) {
		ObjectFactory factory = new ObjectFactory();
		IVLPQ retVal = factory.createIVLPQ();

		PQ pqLow = null;
		if (lowValue == null) {
			pqLow = CdaUtil.createHl7CdaR2NullFlavorPq(null);
		} else {
			pqLow = factory.createPQ();
			pqLow.setValue(lowValue);
			pqLow.setUnit(unit);
		}

		PQ pqHigh = null;
		if (highValue == null) {
			pqHigh = CdaUtil.createHl7CdaR2NullFlavorPq(null);
		} else {
			pqHigh = factory.createPQ();
			pqHigh.setValue(highValue);
			pqHigh.setUnit(unit);

		}

		PQ pqWidth = null;
		if (highValue == null) {
			pqWidth = CdaUtil.createHl7CdaR2NullFlavorPq(null);
		} else {
			pqWidth = factory.createPQ();
			pqWidth.setValue(widthValue);
			pqWidth.setUnit(unit);

		}

		retVal.getRest()
				.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "low"), PQ.class, pqLow));
		retVal.getRest()
				.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "high"), PQ.class, pqHigh));

		retVal.getRest()
				.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "width"), PQ.class, pqWidth));
		return retVal;
	}

	private IVLTS createHl7CdaR2IvlTs(String lowValue, String highValue, String widthValue,
			String unit) {
		ObjectFactory factory = new ObjectFactory();
		IVLTS retVal = factory.createIVLTS();

		PQ pqLow = null;
		if (lowValue == null) {
			pqLow = CdaUtil.createHl7CdaR2NullFlavorPq(null);
		} else {
			pqLow = factory.createPQ();
			pqLow.setValue(lowValue);
			pqLow.setUnit(unit);
		}

		PQ pqHigh = null;
		if (highValue == null) {
			pqHigh = CdaUtil.createHl7CdaR2NullFlavorPq(null);
		} else {
			pqHigh = factory.createPQ();
			pqHigh.setValue(highValue);
			pqHigh.setUnit(unit);

		}

		PQ pqWidth = null;
		if (widthValue == null) {
			pqWidth = CdaUtil.createHl7CdaR2NullFlavorPq(null);
		} else {
			pqWidth = factory.createPQ();
			pqWidth.setValue(widthValue);
			pqWidth.setUnit(unit);

		}

		retVal.getRest()
				.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "low"), PQ.class, pqLow));
		retVal.getRest()
				.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "high"), PQ.class, pqHigh));

		retVal.getRest()
				.add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "width"), PQ.class, pqWidth));
		return retVal;
	}

	/**
	 * Creates sample data.
	 *
	 * @return the eivlts
	 */
	private PIVLTS createPivl(boolean institutionSpecified) {
		ObjectFactory factory = new ObjectFactory();
		PIVLTS pivlts = new PIVLTS();
		pivlts.setInstitutionSpecified(institutionSpecified);
		pivlts.setOperator(SetOperator.A);
		PQ period = factory.createPQ();
		period.setUnit("h");
		period.setValue("2");
		pivlts.setPeriod(period);
		return pivlts;
	}

	/**
	 * Creates sample data.
	 *
	 * @return the dosage instructions for a specific datetime
	 */
	private DosageInstructionsStartStopFrequency createPivl(PIVLTS pivlts) {

		DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
		diStartStopFrequency.getClassCode().add("SBADM");

		diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

		diStartStopFrequency.getTemplateId()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

		diStartStopFrequency.getEffectiveTime().add(pivlts);

		addDosageInstructionToNewDoc(diStartStopFrequency);
		return diStartStopFrequency;

	}

	/**
	 * Creates sample data.
	 *
	 * @return the eivlts
	 */
	private PIVLTS createPivlWithPhase() {
		PIVLTS pivlts = createPivl(false);
		addPhaseToPivlTs(pivlts, DateUtil.parseDateAndTime("20.6.2020 10:50"), "10");
		PQ period = factory.createPQ();
		period.setUnit("d");
		period.setValue("1");
		pivlts.setPeriod(period);
		return pivlts;
	}

	/**
	 * Creates sample data.
	 *
	 * @return the dosage instructions for a specific datetime
	 */
	@SuppressWarnings("unused")
	private DosageInstructionsStartStopFrequency createTS() {

		DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
		diStartStopFrequency.getClassCode().add("SBADM");

		diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

		diStartStopFrequency.getTemplateId()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

		diStartStopFrequency.getEffectiveTime()
				.add((SXCMTS) DateUtil.date2Ts(DateUtil.parseDateAndTime("20.6.2020 10:50")));

		return diStartStopFrequency;

	}

	/**
	 * Transform an object to xml to print it
	 *
	 * @param doc
	 */
	private void jaxbObjectToXML(POCDMT000040ClinicalDocument doc) {
		try {
			// Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(POCDMT000040ClinicalDocument.class);

			// Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// Print XML String to Console
			StringWriter sw = new StringWriter();

			// Write XML to StringWriter
			jaxbMarshaller.marshal(doc, sw);

			// Verify XML Content
			String xmlContent = sw.toString();
			System.out.println(xmlContent);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test is narrative text and references are well created and added to the
	 * doc
	 */
	@Disabled
	@Test
	public void narrativTextAndReferenceGenerated() {

		// Check if narrative table is well created and added to the text
		// section
		DosageInstructionsStartStopFrequency dosageInstructionsSplited = createDosageSplited();
		POCDMT000040ClinicalDocument doc = addDosageInstructionToNewDoc(dosageInstructionsSplited);
		POCDMT000040StructuredBody structuredBody = CdaUtil.getHl7CdaR2StructuredBody(doc);
		CdaChUtil.setSectionTextGenerated(structuredBody,
				structuredBody.getComponent().get(0).getSection(), LanguageCode.FRENCH, 1);
		StrucDocText strucDocText = structuredBody.getComponent().get(0).getSection().getText();
		List<Serializable> content = strucDocText.getContent();
		assertTrue(content.size() > 1);
		@SuppressWarnings("rawtypes")
		StrucDocTable strucDocTable = (StrucDocTable) ((JAXBElement) content.get(1)).getValue();
		StrucDocTd strucDocTd = (StrucDocTd) strucDocTable.getTbody().get(0).getTr().get(0)
				.getThOrTd().get(2);
		assertEquals("MTP.frequency.section0021.0", strucDocTd.getID());
		assertEquals("1) 40g Après le repas du soir", strucDocTd.getContent().get(0));
		assertEquals("2) 20g Avant le coucher, Débit : 10 par min", strucDocTd.getContent().get(2));

		String DOSAGE_INTAKE_REFERENCE_TEMPLATE_ID = new DosageIntakeModeEntryContentModule()
				.getHl7TemplateId().get(0).getRoot(); // "2.16.756.5.30.1.1.10.4.37";
		// Check if reference is well added in an entryRelationship
		POCDMT000040SubstanceAdministration substanceAdministrationDosageIntakeText = structuredBody
				.getComponent().get(0).getSection().getEntry().get(0).getSubstanceAdministration()
				.getEntryRelationship().stream()
				.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
						.getSubstanceAdministration() != null)
				.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
						.getSubstanceAdministration().getTemplateId().stream()
						.anyMatch(templateId -> templateId.getRoot()
								.equals(DOSAGE_INTAKE_REFERENCE_TEMPLATE_ID)))
				.findFirst().map(POCDMT000040EntryRelationship::getSubstanceAdministration)
				.orElse(null);
		assertEquals("#MTP.frequency.section0021.0",
				substanceAdministrationDosageIntakeText.getText().getReference().getValue());
		jaxbObjectToXML(doc);
	}

	/**
	 * Test eivlts
	 */
	@Test
	public void parseEivltsTest() {
		EIVLTS eivltsWithOffset = createAcmWithOffset();
		String eivltsWithOffsetText = EmedChStrucDocTextBuilderV097
				.parseEivlTs(LanguageCode.ENGLISH, eivltsWithOffset);
		String eivltsWithOffsetTextFrench = EmedChStrucDocTextBuilderV097
				.parseEivlTs(LanguageCode.FRENCH, eivltsWithOffset);
		String eivltsWithOffsetTextGerman = EmedChStrucDocTextBuilderV097
				.parseEivlTs(LanguageCode.GERMAN, eivltsWithOffset);
		String eivltsWithOffsetTextItalian = EmedChStrucDocTextBuilderV097
				.parseEivlTs(LanguageCode.ITALIAN, eivltsWithOffset);
		assertEquals("1 hour(s) - 2 hour(s) Before breakfast during 1 hour(s)",
				eivltsWithOffsetText);
		assertEquals("1 Stunde(n) - 2 Stunde(n) Vor dem Frühstück während 1 Stunde(n)",
				eivltsWithOffsetTextGerman);

		assertEquals("1 heure(s) - 2 heure(s) Avant le petit-déjeuner pendant 1 heure(s)",
				eivltsWithOffsetTextFrench);
		assertEquals("1 ora(e) - 2 ora(e) Prima di colazione durante 1 ora(e)",
				eivltsWithOffsetTextItalian);
		EIVLTS eivltsAcm = createAcm();
		assertEquals("Before breakfast",
				EmedChStrucDocTextBuilderV097.parseEivlTs(LanguageCode.ENGLISH, eivltsAcm));
		assertEquals("Avant le petit-déjeuner",
				EmedChStrucDocTextBuilderV097.parseEivlTs(LanguageCode.FRENCH, eivltsAcm));
	}

	/**
	 * Test pivlts
	 */
	@Test
	public void parsePivltsTest() {
		/*
		 * <effectiveTime xsi:type="PIVL_TS" institutionSpecified="true"
		 * operator="A" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
		 * <period value="2" unit="h"/> </effectiveTime>
		 */
		PIVLTS pivltsFrequency = createPivl(true);
		/*
		 *
		 * <effectiveTime xsi:type="PIVL_TS" institutionSpecified="false"
		 * operator="A" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
		 * <period value="2" unit="h"/> </effectiveTime>
		 */
		PIVLTS pivltsPeriod = createPivl(false);
		String pivltsFrequencyStr = EmedChStrucDocTextBuilderV097.parsePivlTs(LanguageCode.ENGLISH,
				pivltsFrequency);

		PIVLTS pivltsWithPhase = createPivlWithPhase();
		System.out.println(DateUtil.parseHl7Timestamp("198701010800").toString());
		printDoc(pivltsWithPhase);
		assertEquals("12x per day(s)", pivltsFrequencyStr);

		assertEquals("chaque 2 heure(s)",
				EmedChStrucDocTextBuilderV097.parsePivlTs(LanguageCode.FRENCH, pivltsPeriod));

		assertEquals("chaque 1 jour(s) à 10:50 pendant 10 minute(s)",
				EmedChStrucDocTextBuilderV097.parsePivlTs(LanguageCode.FRENCH, pivltsWithPhase));

		createPivl(pivltsFrequency);
		createPivl(pivltsPeriod);
	}

	/**
	 * Test splited Dosage
	 */
	@Test
	public void parseSplitedDosage() {

		DosageInstructionsStartStopFrequency dosageInstructionsSplited = createDosageSplited();
		System.out.println(dosageInstructionsSplited);
		addDosageInstructionToNewDoc(dosageInstructionsSplited);

		List<String> dosageIntakes = EmedChStrucDocTextBuilderV097
				.parseSplitDosageIntake(dosageInstructionsSplited, LanguageCode.FRENCH);

		assertEquals("1) 40g Après le repas du soir", dosageIntakes.get(0));
		assertEquals("2) 20g Avant le coucher, Débit : 10 par min", dosageIntakes.get(1));
		System.out.println(StringUtils.join(dosageIntakes, "\n"));

	}

	/**
	 * Test sxprts
	 */
	@Test
	public void parseSxprtsTest() {
		ObjectFactory objectFactory = new ObjectFactory();
		SXPRTS sxprts = objectFactory.createSXPRTS();
		sxprts.getComp()
				.add(createHl7CdaR2IvlTs(
						DateUtil.formatDateTime(DateUtil.parseDateAndTime("20.6.2020 10:50")), null,
						"10", "d"));
		sxprts.getComp().add(createAcm());
		sxprts.getComp().add(createEIVLTS(ChEmedTimingEvent.AFTER_BREAKFAST_L1));
		sxprts.getComp().add(createEIVLTS(ChEmedTimingEvent.BETWEEN_LUNCH_AND_DINNER_L1));
		sxprts.getComp().add(createEIVLTS(ChEmedTimingEvent.AFTER_DINNER_L1));

		assertEquals(
				"du 20 juin 2020 10:50 pendant 10 jour(s): Avant le petit-déjeuner et Après le petit-déjeuner et Entre le repas de midi et du soir et Après le repas du soir",
				EmedChStrucDocTextBuilderV097.parseSxprTs(LanguageCode.FRENCH, sxprts));
	}

	/**
	 * Test date formating
	 */
	@Test
	public void parseTsTest() {
		TS ts = DateUtil.date2Ts(DateUtil.parseDateAndTime("20.6.2020 10:50"));
		String dateFR = EmedChStrucDocTextBuilderV097.parseTs(LanguageCode.FRENCH, ts);
		String dateDE = EmedChStrucDocTextBuilderV097.parseTs(LanguageCode.GERMAN, ts);
		String dateIT = EmedChStrucDocTextBuilderV097.parseTs(LanguageCode.ITALIAN, ts);
		String dateEN = EmedChStrucDocTextBuilderV097.parseTs(LanguageCode.ENGLISH, ts);
		assertEquals("20 juin 2020 10:50", dateFR);
		assertEquals("20 Juni 2020 10:50", dateDE);
		assertEquals("20 giugno 2020 10:50", dateIT);
		assertEquals("20 June 2020 10:50", dateEN);
	}

	private void printDoc(SXCMTS dosageFrequency) {
		DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
		diStartStopFrequency.getClassCode().add("SBADM");

		diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

		diStartStopFrequency.getTemplateId()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

		diStartStopFrequency.getEffectiveTime()
				.add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

		diStartStopFrequency.getEffectiveTime().add(dosageFrequency);

		diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5", "1", "g"));// CdaUtil.createHl7CdaR2Ivlpq("0.5",
																							// "g"));

		System.out.println(
				EmedChStrucDocTextBuilderV097.parseDoseQuantity(diStartStopFrequency.getDoseQuantity(), LanguageCode.FRENCH));
		addDosageInstructionToNewDoc(diStartStopFrequency);

	}

}
