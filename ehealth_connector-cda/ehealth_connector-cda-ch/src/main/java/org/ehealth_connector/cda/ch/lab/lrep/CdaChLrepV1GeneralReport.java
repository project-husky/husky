/*
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
package org.ehealth_connector.cda.ch.lab.lrep;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.CdaChV2StructuredBody;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Address;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Organization;
import org.ehealth_connector.common.mdht.Patient;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.Custodian;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.impl.LaboratoryBatteryOrganizerImpl;
import org.openhealthtools.mdht.uml.cda.ihe.lab.impl.LaboratorySpecialtySectionImpl;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

/**
 * The implementation of the Swiss CDA-CH-LREP General Report exchange format.
 *
 * <div class="en">Implements a CDA document based on the CDA-CH-LREP (2018)
 * exchange format.</div> <div class="de">Implementiert ein CDA-Dokument
 * basierend auf dem Austauschformat CDA-CH-LREP (2018).</div>
 */
public class CdaChLrepV1GeneralReport extends
		CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChLrepV1GeneralReport> {

	/** A section index, used for automatic narrative text generation. */
	private int mSectionIndex = 0;

	/**
	 * Instantiates a new CDA-CH-LREP General Report document.
	 *
	 * @param languageCode
	 *            the language code
	 * @param styleSheet
	 *            the style sheet
	 * @param css
	 *            the css
	 */
	public CdaChLrepV1GeneralReport(LanguageCode languageCode, String styleSheet, String css) {
		super(ChFactory.eINSTANCE.createCdaChLrepV1GeneralReport().init(), languageCode, styleSheet,
				css);
		super.initCda();

		Code code = new Code(CodeSystems.LOINC.getCodeSystemId(), "11502-2",
				CodeSystems.LOINC.getCodeSystemName(), "LABORATORY REPORT.TOTAL");
		code.addTranslation(new Code(CodeSystems.SNOMEDCT.getCodeSystemId(), "4241000179101",
				CodeSystems.SNOMEDCT.getCodeSystemName(), "Laboratory report"));
		getDoc().setCode(code.getCE());

		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("Laborbefund ");
			break;
		case FRENCH:
			setTitle("Rapport de laboratoire");
			break;
		case ITALIAN:
			setTitle("Referto di laboratorio");
			break;
		case ENGLISH:
			setTitle("Laboratory report");
		}

		// Make sure the document contains all necessary templateIds
		CdaUtil.addTemplateIdOnce(getDoc(), new Identificator("2.16.756.5.30.1.1.1.1.3.9.1"));
		CdaUtil.addTemplateIdOnce(getDoc(), new Identificator("1.3.6.1.4.1.19376.1.3.3"));

	}

	/**
	 * Instantiates a new CDA-CH-LREP General Report document.
	 *
	 * @param doc
	 *            the doc
	 */
	public CdaChLrepV1GeneralReport(
			org.openhealthtools.mdht.uml.cda.ch.CdaChLrepV1GeneralReport doc) {
		super(doc);
	}

	/**
	 * <div class="en">Adds an author</div> <div class="de">Fügt einen Autor
	 * hinzu</div>.
	 *
	 * @param author
	 *            the autor
	 * @return the author
	 */
	@Override
	public Author addAuthor(org.ehealth_connector.common.mdht.Author author) {
		Author mdht = super.addAuthor(author);
		CdaUtil.addTemplateIdOnce(mdht, new Identificator("2.16.756.5.30.1.1.10.2.59"));
		return mdht;
	}

	/**
	 * Convenience function to add a Laboratory Battery Organizer to a new
	 * Section and create the necessary elements, if they do not exist. If the
	 * elements exist, their contents will not be overwritten.
	 *
	 * These elements are: LaboratorySpecialtySection,
	 * LaboratoryReportProcessingEntry, and SpecimenAct with the given
	 * Laboratory Battery Organizer
	 *
	 * @param organizer
	 *            the LaboratoryBatteryOrganizer holding at least one
	 *            LaboratoryObservation
	 * @param sectionCode
	 *            the LOINC code for the LaboratorySpecialtySection
	 * @param sce
	 *            the sce
	 * @return the laboratory specialty section
	 */
	public LaboratorySpecialtySection addLaboratoryBatteryOrganizerInNewSection(
			LaboratoryBatteryOrganizer organizer, Code sectionCode, SpecimenCollectionEntry sce) {
		LaboratorySpecialtySection laboratorySpecialtySection;
		mSectionIndex++;
		if (sectionCode != null) {
			laboratorySpecialtySection = new LaboratorySpecialtySection(sectionCode,
					getLanguageCode());
		} else {
			laboratorySpecialtySection = new LaboratorySpecialtySection();
		}

		laboratorySpecialtySection.addLaboratoryBatteryOrganizer(sectionCode, organizer,
				getLanguageCode());
		laboratorySpecialtySection.getLaboratoryReportDataProcessingEntry().getSpecimenAct()
				.setSpecimenCollectionEntry(sce);

		laboratorySpecialtySection
				.setText(generateNarrativeTextLaboratoryObservations(laboratorySpecialtySection,
						mSectionIndex, "lss", CodeSystems.SwissAL.getCodeSystemId()));

		addLaboratorySpecialtySection(laboratorySpecialtySection);

		return laboratorySpecialtySection;
	}

	/**
	 * Adds a LaboratorySpecialtySection.
	 *
	 * @param laboratorySpecialtySection
	 *            the section
	 */
	public void addLaboratorySpecialtySection(
			org.ehealth_connector.cda.ch.lab.lrep.LaboratorySpecialtySection laboratorySpecialtySection) {
		getMdht().addSection(laboratorySpecialtySection.copy());
	}

	/**
	 * Adds another information recipient.
	 *
	 * @param recipient
	 *            the information recipient
	 * @return the information recipient
	 */
	@Override
	public InformationRecipient addOtherRecipient(Organization recipient) {
		InformationRecipient mdht = super.addOtherRecipient(recipient);
		CdaUtil.addTemplateIdOnce(mdht, new Identificator("2.16.756.5.30.1.1.10.2.57"));
		return mdht;
	}

	/**
	 * Gets the list of laboratory batteries.
	 *
	 * @return the laboratory batteriy list
	 */
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteries() {
		ArrayList<LaboratoryBatteryOrganizer> retVal = new ArrayList<LaboratoryBatteryOrganizer>();
		for (Section section : getMdht().getSections()) {
			if (section instanceof LaboratorySpecialtySectionImpl) {
				EList<EntryRelationship> erList = section.getEntries().get(0).getAct()
						.getEntryRelationships();
				for (EntryRelationship er : erList) {
					if (er.getOrganizer() instanceof LaboratoryBatteryOrganizerImpl) {
						retVal.add(new LaboratoryBatteryOrganizer(
								(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) er
										.getOrganizer()));
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Sets an organization as the custodian of the
	 * document</div> <div class="de">Weist dem CDA Dokument die verwaltende
	 * Organisation zu</div>.
	 *
	 * @param organization
	 *            <div class="en">custodian organization</div>
	 *            <div class="de">verwaltende Organisation</div>
	 * @return the custodian
	 */
	@Override
	public Custodian setCustodian(Organization organization) {
		Custodian mdht = super.setCustodian(organization);
		CdaUtil.addTemplateIdOnce(mdht, new Identificator("2.16.756.5.30.1.1.10.2.60"));
		return mdht;
	}

	/**
	 * <div class="en">Adds a patient</div> <div class="de">Weist dem CDA
	 * Dokument einen Patienten zu</div>.
	 *
	 * @param patient
	 *            Patient
	 * @return the record target
	 */
	@Override
	public RecordTarget setPatient(Patient patient) {
		RecordTarget mdht = super.setPatient(patient);
		CdaUtil.addTemplateIdOnce(mdht, new Identificator("2.16.756.5.30.1.1.10.2.58"));
		CdaUtil.addTemplateIdOnce(mdht, new Identificator("1.3.6.1.4.1.19376.1.3.3.1.4"));
		return mdht;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setPrimaryRecipient(
	 *      org.ehealth_connector.common.mdht.Organization)
	 */
	@Override
	public InformationRecipient setPrimaryRecipient(Organization recipient) {
		InformationRecipient mdht = super.setPrimaryRecipient(recipient);

		for (Address item : recipient.getAddresses()) {
			mdht.getIntendedRecipient().getAddrs().add(item.copyMdhtAdress());
		}

		for (TEL item : recipient.getMdhtTelecoms()) {
			mdht.getIntendedRecipient().getTelecoms().add(EcoreUtil.copy(item));
		}

		CdaUtil.addTemplateIdOnce(mdht, new Identificator("2.16.756.5.30.1.1.10.2.57"));
		CdaUtil.addTemplateIdOnce(mdht, new Identificator("1.3.6.1.4.1.19376.1.3.3.1.4"));
		return mdht;
	}
}
