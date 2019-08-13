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
package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.BaseObservation;
import org.ehealth_connector.cda.BaseObservationComparator;
import org.ehealth_connector.cda.BaseOrganizer;
import org.ehealth_connector.cda.BaseOrganizerComparator;
import org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReport;
import org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.cda.utils.CdaUtilMdht;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Author;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.IntendedRecipient;
import org.ehealth_connector.common.mdht.enums.CountryCode;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Patient;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.StructuredBody;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.ADXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * The Class CdaChLrph. <div class="en">This document implements the normative
 * specification for the electronic notification of germs to the BAG, based on
 * HL7 CDA-CH.</div> <div class="de">Dieses Dokument setzt die normative
 * Spezifikation für die elektronische Meldung von Erregernachweisen an die
 * Sektion Meldesysteme des BAG, basierend auf HL7 CDA-CH um.</div>
 */
@SuppressWarnings("deprecation")
public class CdaChLrph
		extends AbstractLaboratoryReport<org.openhealthtools.mdht.uml.cda.ch.CdaChLrphV1> {

	private int sectionIndex = 0;

	/**
	 * Standard constructor.
	 */
	public CdaChLrph() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch lrph.
	 *
	 * @param languageCode
	 *            the language code
	 */
	protected CdaChLrph(LanguageCode languageCode) {
		this(languageCode, null, null);
	}

	/**
	 * Constructor with the recommended elements for the LRPH document Header.
	 *
	 * @param languageCode
	 *            the language code
	 * @param author
	 *            the author of the document (a laboratory)
	 * @param refOrderingPhysician
	 *            a physician
	 * @param patient
	 *            the patient
	 * @param recipient
	 *            the recipient (e.g. the Bundesamt für Gesundheit)
	 */
	public CdaChLrph(LanguageCode languageCode, Author author,
			ReferralOrderingPhysician refOrderingPhysician,
			org.ehealth_connector.common.mdht.Patient patient, IntendedRecipient recipient) {
		this(languageCode);
		setPatient(patient);
		setEmtpyCustodian();
		addAuthor(author);
		addReferralOrderingPhysician(refOrderingPhysician);
		addIntendedRecipient(recipient);
	}

	/**
	 * Instantiates a new cda ch lrph.
	 *
	 * @param languageCode
	 *            language of the document contents
	 * @param styleSheet
	 *            an extensible style sheet (XSLT) to transform and render the
	 *            document
	 * @param css
	 *            cascading style sheet (CSS) to add style information for
	 *            rendering
	 */
	public CdaChLrph(LanguageCode languageCode, String styleSheet, String css) {
		super(ChFactory.eINSTANCE.createCdaChLrphV1().init(), languageCode, styleSheet, css);
		// Fix RealmCode
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(CountryCode.SWITZERLAND.getCodeAlpha3());
		getDoc().getRealmCodes().clear();
		getDoc().getRealmCodes().add(cs);
	}

	/**
	 * Constructor with the recommended elements for the LRPH document Header.
	 *
	 * @param languageCode
	 *            the language code
	 * @param styleSheet
	 *            an extensible style sheet (XSLT) to transform and render the
	 *            document
	 * @param css
	 *            cascading style sheet (CSS) to add style information for
	 *            rendering
	 * @param author
	 *            the author of the document (a laboratory)
	 * @param refOrderingPhysician
	 *            a physician
	 * @param patient
	 *            the patient
	 * @param recipient
	 *            the recipient (e.g. the Bundesamt für Gesundheit)
	 */
	public CdaChLrph(LanguageCode languageCode, String styleSheet, String css, Author author,
			ReferralOrderingPhysician refOrderingPhysician,
			org.ehealth_connector.common.mdht.Patient patient, IntendedRecipient recipient) {
		this(languageCode, styleSheet, css);
		setPatient(patient);
		setEmtpyCustodian();
		addAuthor(author);
		addReferralOrderingPhysician(refOrderingPhysician);
		addIntendedRecipient(recipient);
	}

	/**
	 * Instantiates a new cda ch lrph.
	 *
	 * @param doc
	 *            mdht model document
	 */
	public CdaChLrph(org.openhealthtools.mdht.uml.cda.ch.CdaChLrphV1 doc) {
		super(doc);
	}

	/**
	 * Convenience function to add a Laboratory Battery Organizer and create the
	 * necessary elements, if they do not exist. If the elements exist, their
	 * contents will not be overwritten.
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
	 */
	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer organizer,
			Code sectionCode) {
		LaboratorySpecialtySection laboratorySpecialtySection = getLaboratorySpecialtySection();
		if (laboratorySpecialtySection == null) {
			sectionIndex++;
			if (sectionCode != null) {
				laboratorySpecialtySection = new LaboratorySpecialtySection(sectionCode,
						getLanguageCode());
				getMdht().setCode(sectionCode.getCE());
			} else {
				laboratorySpecialtySection = new LaboratorySpecialtySection();
			}
		}
		laboratorySpecialtySection.addLaboratoryBatteryOrganizer(sectionCode, organizer,
				getLanguageCode());
		if (isNarrativeTextGenerationEnabled()) {
			laboratorySpecialtySection.setText(generateNarrativeTextLaboratoryObservations(
					laboratorySpecialtySection, sectionIndex, "lss"));
		}
		setLaboratorySpecialtySection(laboratorySpecialtySection);
	}

	/**
	 * Applies the 'hiv' privacy filter to all given record target elements.
	 *
	 * <table summary="Elements which will be set">
	 * <thead>
	 * <tr>
	 * <th>Element name (english)</th>
	 * <th>Element name (german)</th>
	 * <th>CDA element</th>
	 * </tr>
	 * </thead><tbody>
	 * <tr>
	 * <td>First letter and number of letters of the given name</td>
	 * <td>Erster Buchstabe und Anzahl Buchstaben des Vornamens</td>
	 * <td>recordTarget/patientRole/patient/name/given[0]</td>
	 * </tr>
	 * <tr>
	 * <td>City</td>
	 * <td>Wohnort</td>
	 * <td>/recordTarget/patientRole/addr[0]/city[0]</td>
	 * </tr>
	 * <tr>
	 * <td>Date of birth</td>
	 * <td>Geburtsdatum</td>
	 * <td>recordTarget/patientRole/patient/birthTime</td>
	 * </tr>
	 * <tr>
	 * <td>Gender</td>
	 * <td>Geschlecht</td>
	 * <td>recordTarget/patientRole/patient/administrativeGenderCode</td>
	 * </tr>
	 * <tr>
	 * </tbody>
	 * </table>
	 */
	public void applyPrivacyFilterHiv() {
		byte index = 0;
		for (final RecordTarget originalRt : getMdht().getRecordTargets()) {
			// Get original elements
			PatientRole originalPr = null;
			if (originalRt.getPatientRole() != null) {
				originalPr = originalRt.getPatientRole();
			}
			Patient originalP = null;
			if ((originalPr != null) && (originalPr.getPatient() != null)) {
				originalP = originalPr.getPatient();
			}

			// Initialize new elements
			final RecordTarget processedRt = CDAFactory.eINSTANCE.createRecordTarget();
			final PatientRole processedPr = CDAFactory.eINSTANCE.createPatientRole();
			final Patient processedP = CDAFactory.eINSTANCE.createPatient();
			processedRt.setPatientRole(processedPr);
			processedPr.setPatient(processedP);

			// Copy all necessary elements from the original to the processed
			// recordTarget
			// Patient Name
			if ((originalP != null) && !originalP.getNames().isEmpty()) {
				if (originalP.getNames().get(0) != null) {
					final PN pn = DatatypesFactory.eINSTANCE.createPN();
					pn.setNullFlavor(NullFlavor.MSK);
					// First letter and number of letters of first given name
					if (!originalP.getNames().get(0).getGivens().isEmpty()) {
						pn.addGiven(originalP.getNames().get(0).getGivens().get(0).getText()
								.substring(0, 1)
								+ originalP.getNames().get(0).getGivens().get(0).getText()
										.length());
					}
					// Family Name = MSK
					final ENXP enxp = DatatypesFactory.eINSTANCE.createENXP();
					enxp.setNullFlavor(NullFlavor.MSK);
					pn.getFamilies().add(enxp);

					processedP.getNames().add(pn);
				}
			}

			if ((originalPr != null) && !originalPr.getAddrs().isEmpty()
					&& (originalPr.getAddrs().get(0).getCities() != null)
					&& !originalPr.getAddrs().get(0).getCities().isEmpty()) {
				final AD ad = DatatypesFactory.eINSTANCE.createAD();
				// Street Name = MSK
				final ADXP streetName = DatatypesFactory.eINSTANCE.createADXP();
				streetName.setNullFlavor(NullFlavor.MSK);
				ad.getStreetNames().add(streetName);
				// City
				ad.addCity(
						EcoreUtil.copy(originalPr.getAddrs().get(0).getCities().get(0)).getText());
				processedPr.getAddrs().add(ad);
			}

			// Birth time
			if ((originalP != null) && (originalP.getBirthTime() != null)) {
				processedP.setBirthTime(EcoreUtil.copy(originalP.getBirthTime()));
			}

			// Gender
			if ((originalP != null) && (originalP.getAdministrativeGenderCode() != null)) {
				processedP.setAdministrativeGenderCode(
						EcoreUtil.copy(originalP.getAdministrativeGenderCode()));
			}

			// Telecom (MSK)
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			tel.setNullFlavor(NullFlavor.MSK);
			processedPr.getTelecoms().add(tel);

			// ID (MSK)
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setNullFlavor(NullFlavor.MSK);
			processedPr.getIds().add(ii);

			getMdht().getRecordTargets().set(index, processedRt);
			index++;
		}
	}

	/**
	 * Applies the 'initials' privacy filter to all given record target
	 * elements.
	 *
	 * <table summary="Elements which will be set">
	 * <thead>
	 * <tr>
	 * <th>Element name (english)</th>
	 * <th>Element name (german)</th>
	 * <th>CDA element</th>
	 * </tr>
	 * </thead><tbody>
	 * <tr>
	 * <td>First letter of the given and the family name</td>
	 * <td>Erster Buchstabe des Vor- und Nachnamens</td>
	 * <td>recordTarget/patientRole/patient/name/given[0] and family[0]</td>
	 * </tr>
	 * <tr>
	 * <td>City</td>
	 * <td>Wohnort</td>
	 * <td>/recordTarget/patientRole/addr[0]/city[0]</td>
	 * </tr>
	 * <tr>
	 * <td>Date of birth</td>
	 * <td>Geburtsdatum</td>
	 * <td>recordTarget/patientRole/patient/birthTime</td>
	 * </tr>
	 * <tr>
	 * <td>Gender</td>
	 * <td>Geschlecht</td>
	 * <td>recordTarget/patientRole/patient/administrativeGenderCode</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 */
	public void applyPrivacyFilterInitials() {
		byte index = 0;
		for (final RecordTarget originalRt : getMdht().getRecordTargets()) {
			// Get original elements
			PatientRole originalPr = null;
			if (originalRt.getPatientRole() != null) {
				originalPr = originalRt.getPatientRole();
			}
			Patient originalP = null;
			if ((originalPr != null) && (originalPr.getPatient() != null)) {
				originalP = originalPr.getPatient();
			}

			// Initialize new elements
			final RecordTarget processedRt = CDAFactory.eINSTANCE.createRecordTarget();
			final PatientRole processedPr = CDAFactory.eINSTANCE.createPatientRole();
			final Patient processedP = CDAFactory.eINSTANCE.createPatient();
			processedRt.setPatientRole(processedPr);
			processedPr.setPatient(processedP);

			// Copy all necessary elements from the original to the processed
			// recordTarget
			// Patient Name
			if ((originalP != null) && !originalP.getNames().isEmpty()) {
				if (originalP.getNames().get(0) != null) {
					// First letter of first given and family name
					final PN pn = DatatypesFactory.eINSTANCE.createPN();
					pn.setNullFlavor(NullFlavor.MSK);
					if (!originalP.getNames().get(0).getGivens().isEmpty()) {
						pn.addGiven(originalP.getNames().get(0).getGivens().get(0).getText()
								.substring(0, 1));
					}
					if (!originalP.getNames().get(0).getFamilies().isEmpty()) {
						pn.addFamily(originalP.getNames().get(0).getFamilies().get(0).getText()
								.substring(0, 1));
					}
					processedP.getNames().add(pn);
				}
			}

			if ((originalPr != null) && !originalPr.getAddrs().isEmpty()) {
				final AD ad = DatatypesFactory.eINSTANCE.createAD();
				// Street Name = MSK
				final ADXP streetName = DatatypesFactory.eINSTANCE.createADXP();
				streetName.setNullFlavor(NullFlavor.MSK);
				ad.getStreetNames().add(streetName);
				// Postal code
				if (!originalPr.getAddrs().get(0).getPostalCodes().isEmpty()) {
					ad.addPostalCode(
							originalPr.getAddrs().get(0).getPostalCodes().get(0).getText());
				}
				// City
				if ((originalPr.getAddrs().get(0).getCities() != null)
						&& !originalPr.getAddrs().get(0).getCities().isEmpty()) {
					ad.addCity(originalPr.getAddrs().get(0).getCities().get(0).getText());
				}
				processedPr.getAddrs().add(ad);
			}

			// Birth time
			if ((originalP != null) && (originalP.getBirthTime() != null)) {
				processedP.setBirthTime(EcoreUtil.copy(originalP.getBirthTime()));
			}

			// Gender
			if ((originalP != null) && (originalP.getAdministrativeGenderCode() != null)) {
				processedP.setAdministrativeGenderCode(
						EcoreUtil.copy(originalP.getAdministrativeGenderCode()));
			}

			// Telecom (MSK)
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			tel.setNullFlavor(NullFlavor.MSK);
			processedPr.getTelecoms().add(tel);

			// ID (MSK)
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setNullFlavor(NullFlavor.MSK);
			processedPr.getIds().add(ii);

			getMdht().getRecordTargets().set(index, processedRt);
			index++;
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReport#
	 * createDocumentTitle()
	 */
	@Override
	protected String createDocumentTitle() {
		switch (this.getLanguageCode()) {
		case FRENCH:
			return ("Rapport de laboratoire soumis à déclaration");
		case GERMAN:
			return ("Meldepflichtiger Laborbefund");
		case ITALIAN:
			return ("it: TOTRANSLATE");
		case ENGLISH:
			return ("Laboratory Reports for Public Health");
		}
		return "Laboratory report";
	}

	/**
	 * <div class="en">Generates the human readable text of the coded vital
	 * signs section</div> <div class="de">Generiert den menschenlesbaren Text
	 * des Kapitels zu Vitalzeichen</div>.
	 *
	 */
	public void generateNarrativeTextLaboratoryObservations() {

		LaboratorySpecialtySection laboratorySpecialtySection = getLaboratorySpecialtySection();

		laboratorySpecialtySection.setText(generateNarrativeTextLaboratoryObservations(
				laboratorySpecialtySection, sectionIndex, "lss", null,
				new BaseOrganizerComparator(), new BaseObservationComparator()));

	}

	/**
	 * <div class="en">Generates the human readable text of the coded vital
	 * signs section</div> <div class="de">Generiert den menschenlesbaren Text
	 * des Kapitels zu Vitalzeichen</div>.
	 *
	 * @param organizerComparator
	 *            the organizer comparator (pass null for default sorting)
	 * @param observationComparator
	 *            the observation comparator (pass null for default sorting)
	 */
	public void generateNarrativeTextLaboratoryObservations(
			Comparator<BaseOrganizer> organizerComparator,
			Comparator<BaseObservation> observationComparator) {

		LaboratorySpecialtySection laboratorySpecialtySection = getLaboratorySpecialtySection();

		laboratorySpecialtySection
				.setText(generateNarrativeTextLaboratoryObservations(laboratorySpecialtySection,
						sectionIndex, "lss", null, organizerComparator, observationComparator));

	}

	/**
	 * Convenience function to return all LaboratoryBatteryOrganizers directly
	 * from all underlying
	 * LaboratorySpecialtySection/LaboratoryReportDataProcessingEntry/
	 * SpecimenAct element.
	 *
	 * @return a list of LaboratoryBatteryOrganizers.
	 */
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizerList() {
		final ArrayList<LaboratoryBatteryOrganizer> lbol = new ArrayList<LaboratoryBatteryOrganizer>();
		final LaboratorySpecialtySection lss = getLaboratorySpecialtySection();
		if (lss != null) {
			final LaboratoryReportDataProcessingEntry lrdpe = lss
					.getLaboratoryReportDataProcessingEntry();
			if (lrdpe != null) {
				final BaseChSpecimenAct se = lrdpe.getSpecimenAct();
				if (se != null) {
					lbol.addAll(se.getLrphLaboratoryBatteryOrganizers());
				}
			}
		}
		return lbol;
	}

	/**
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	@Override
	public LaboratorySpecialtySection getLaboratorySpecialtySection() {
		if (!getMdht().getLaboratorySpecialtySections().isEmpty()) {
			return new LaboratorySpecialtySection(
					getMdht().getLaboratorySpecialtySections().get(0));
		}
		return null;
	}

	/**
	 * Convenience function, which returns the SpecimenAct directly from the
	 * underlying LaboratorySpecialtySection/LaboratoryReportDataProcessingEntry
	 * element.
	 *
	 * @return the SpecimenAct. Returns null, if this element does not exist.
	 */
	public BaseChSpecimenAct getSpecimenAct() {
		if ((getLaboratorySpecialtySection() != null)
				&& (getLaboratorySpecialtySection()
						.getLaboratoryReportDataProcessingEntry() != null)
				&& (getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
						.getSpecimenAct() != null)) {
			return getLaboratorySpecialtySection().getLaboratoryReportDataProcessingEntry()
					.getSpecimenAct();
		}
		return null;
	}

	/**
	 * Sets a LaboratorySpecialtySection.
	 *
	 * @param laboratorySpecialtySection
	 *            the section
	 */
	public void setLaboratorySpecialtySection(
			org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection laboratorySpecialtySection) {
		// Create a new structured body
		if (getMdht().getLaboratorySpecialtySections().isEmpty()) {
			getMdht().addSection(laboratorySpecialtySection.copy());
		} else {
			// We need to create a new Structured Body element, as the section
			// list is
			// not modifiable
			final StructuredBody sb = CDAFactory.eINSTANCE.createStructuredBody();
			CdaUtilMdht.addSectionToStructuredBodyAsCopy(sb, laboratorySpecialtySection.copy());
			getMdht().setStructuredBody(sb);
		}
	}

}
