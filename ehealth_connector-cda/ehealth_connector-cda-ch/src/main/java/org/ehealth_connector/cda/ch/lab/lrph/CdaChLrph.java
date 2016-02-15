package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.List;

import org.ehealth_connector.cda.ch.lab.AbstractLaboratoryReport;
import org.ehealth_connector.cda.ch.lab.LaboratoryBatteryOrganizer;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.LaboratorySpecialtySection;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;

public class CdaChLrph
		extends AbstractLaboratoryReport<org.openhealthtools.mdht.uml.cda.ch.CdaChLrph> {

	public CdaChLrph() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch lrph.
	 *
	 * @param languageCode
	 *          the language code
	 */
	protected CdaChLrph(LanguageCode languageCode) {
		this(languageCode, null, null);
	}

	public CdaChLrph(LanguageCode languageCode, String styleSheet, String css) {
		super(CHFactory.eINSTANCE.createCdaChLrph().init(), languageCode, styleSheet, css);
		// super.initCda();
	}

	/**
	 * Instantiates a new cda ch lrph.
	 *
	 * @param doc
	 *          mdht model document
	 */
	public CdaChLrph(org.openhealthtools.mdht.uml.cda.ch.CdaChLrph doc) {
		super(doc);
	}

	// Convenience function
	// Creates LaboratorySpecialtySection
	// Creates SpecimenAct
	// adds the Laboratory Battery to the SpecimenAct
	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer organizer) {

	}

	// Convenience function
	public void addLaboratoryIsolateOrganizer(LaboratoryIsolateOrganizer organizer) {

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

	// Convenience function
	public List<LaboratoryIsolateOrganizer> getLaboratoryIsolateOrganizerList() {
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

	// Convenience function
	public NotificationOrganizer getNotificationOrganizer() {
		return null;

	}

	// Convenience function
	public SpecimenCollection getSpecimenCollection() {
		return null;

	}

	// Convenience function
	public void setNotificationOrganizer(NotificationOrganizer organizer) {

	}

	// Convenience function
	public void setSpecimenCollection(SpecimenCollection procedure) {

	}
}
