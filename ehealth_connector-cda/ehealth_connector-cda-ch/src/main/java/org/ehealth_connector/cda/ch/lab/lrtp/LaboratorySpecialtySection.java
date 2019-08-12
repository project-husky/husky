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
package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.SpecialtySections;
import org.ehealth_connector.cda.ihe.lab.BaseLaboratorySpecialtySection;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;

/**
 * The Class LaboratorySpecialtySection. <div class="en">Each LRPH document in
 * Swiss MUST contain exactly one laboratory specialty section.</div>
 * <div class="de">Für meldepflichtige Laborbefunde in der Schweiz wird
 * festgelegt, dass genau ein Kapitel vorhanden sein muss.</div>
 */
public class LaboratorySpecialtySection extends BaseLaboratorySpecialtySection {

	/**
	 * Instantiates a new laboratory specialty section.
	 */
	public LaboratorySpecialtySection() {
		super();
	}

	/**
	 * Instantiates a new laboratory specialty section.
	 *
	 * @param code
	 *            the code
	 */
	public LaboratorySpecialtySection(Code code) {
		super(code);
	}

	/**
	 * Instantiates the class with the required elements. A
	 * LaboratoryReportDataProcessingEntry will be created automatically.
	 *
	 * @param code
	 *            the code for this section
	 * @param languageCode
	 *            the language code
	 */
	public LaboratorySpecialtySection(Code code, LanguageCode languageCode) {
		super(code, languageCode);
		setLaboratoryReportDataProcessingEntry(new LaboratoryReportDataProcessingEntry());
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            the code for this section
	 * @param languageCode
	 *            the language code
	 * @param entry
	 *            the LaboratoryReportDataProcessingEntry
	 */
	public LaboratorySpecialtySection(Code code, LanguageCode languageCode,
			LaboratoryReportDataProcessingEntry entry) {
		this(code, languageCode);
		getMdht().getEntries().clear();
		getMdht().getEntries().add(0, entry.getMdht());
	}

	/**
	 * Instantiates a new laboratory specialty section.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratorySpecialtySection(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection mdht) {
		super(mdht);
	}

	/**
	 * Instantiates the class with the required elements. A
	 * LaboratoryReportDataProcessingEntry will be created automatically.
	 *
	 * @param code
	 *            the code for this section
	 * @param languageCode
	 *            the language code
	 */
	public LaboratorySpecialtySection(SpecialtySections code, LanguageCode languageCode) {
		this(code.getCode(), languageCode);
	}

	/**
	 * Adds a laboratory battery organizer to the section.
	 *
	 * @param sectionCode
	 *            the section code
	 * @param organizer
	 *            the organizer
	 * @param languageCode
	 *            the language code (used for narrative text generation)
	 */
	public void addLaboratoryBatteryOrganizer(Code sectionCode,
			LaboratoryBatteryOrganizer organizer, LanguageCode languageCode) {
		boolean newLrdpe = false;
		boolean newSa = false;

		LaboratoryReportDataProcessingEntry lrdpe = getLaboratoryReportDataProcessingEntry();
		if (getLaboratoryReportDataProcessingEntry() == null) {
			newLrdpe = true;
			lrdpe = new LaboratoryReportDataProcessingEntry();
		}

		BaseChSpecimenAct sa;
		if (lrdpe.getSpecimenAct() == null) {
			newSa = true;
			sa = new BaseChSpecimenAct();
			if (sectionCode != null) {
				sa.setCode(sectionCode);
			}
		} else {
			sa = new BaseChSpecimenAct(lrdpe.getSpecimenAct().getMdht());
		}

		sa.addLaboratoryBatteryOrganizer(organizer);

		// make sure that exactly one LaboratoryReportDataProcessingEntry and
		// exactly one SpecimenAct exist between section and organizer
		if (newSa)
			lrdpe.setSpecimenAct(sa);
		if (newLrdpe)
			setLaboratoryReportDataProcessingEntry(lrdpe);

	}

	/**
	 * Gets the laboratory report data processing entry.
	 *
	 * @return the laboratory report data processing entry
	 */
	public org.ehealth_connector.cda.ch.lab.lrtp.LaboratoryReportDataProcessingEntry getLaboratoryReportDataProcessingEntry() {
		if (!getMdht().getEntries().isEmpty() && getMdht().getEntries().get(
				0) instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) {
			return new org.ehealth_connector.cda.ch.lab.lrtp.LaboratoryReportDataProcessingEntry(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) getMdht()
							.getEntries().get(0));
		}
		return null;
	}

	/**
	 * @see org.ehealth_connector.cda.ihe.lab.BaseLaboratorySpecialtySection#setLaboratoryReportDataProcessingEntry(org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry)
	 */
	public void setLaboratoryReportDataProcessingEntry(
			org.ehealth_connector.cda.ch.lab.lrtp.LaboratoryReportDataProcessingEntry entry) {
		getMdht().getEntries().clear();
		getMdht().getEntries().add(0, entry.copy());
	}

	public void setNarrativeText(String text) {
		getMdht().createStrucDocText(text);
	}

}
