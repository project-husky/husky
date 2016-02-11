package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.List;

import org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReport;
import org.ehealth_connector.cda.ch.lab.LaboratoryBatteryOrganizer;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.LaboratorySpecialtySection;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class CdaChLrtp
		extends AbstractLaboratoryReport<org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp> {

	// TODO Add two constructors:
	// one with the LabObsListLoinc, which uses the getGroup (Befundgruppe) Method
	// to determine the type of the section
	// the other uses a Sections Enum, which contains two Elements (LRTP Spec.
	// 5.6.1)

	/**
	 * Instantiates a new cda ch lrtp.
	 */
	public CdaChLrtp(Code code) {
		this(code, LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch lrtp.
	 *
	 * @param languageCode
	 *          the language code
	 */
	public CdaChLrtp(Code code, LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChLrtp().init(), languageCode);
		super.initCda();
		LaboratorySpecialtySection specialtySection = new LaboratorySpecialtySection(code,
				languageCode);
		this.getDoc().addSection(specialtySection.getMdht());
	}

	/**
	 * Instantiates a new cda ch lrtp.
	 *
	 * @param doc
	 *          mdht model document
	 */
	public CdaChLrtp(org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp doc) {
		super(doc);
	}

	// Convenience function
	// Creates LaboratorySpecialtySection
	// Creates SpecimenAct
	// adds the Laboratory Battery to the SpecimenAct
	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer organizer) {

	}

	// Convenience Function
	// - Scan Observations for pseudonymization / anonymization related
	// NotifiableObservationLoinc or NotifiableObservationSnomed
	// - If such an element exists, use getPrivacyFilter() to determine
	// anonymization function
	// - Apply Anonymization function
	public void applyPrivacyFilter() {

	}

	// Convenience function
	// gets the LaboratorySpecialtySection
	// gets the SpecimenAct
	// gets the Laboratory Batteries from the SpecimenAct
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizerList() {
		return null;

	}

	/**
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	public List<LaboratorySpecialtySection> getLaboratorySpecialtySection() {
		return null;
	}
}
