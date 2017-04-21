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
package org.ehealth_connector.cda.ch.lab.lrph;

import org.ehealth_connector.cda.ihe.lab.AbstractLaboratorySpecialtySection;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.LanguageCode;

/**
 * The Class LaboratorySpecialtySection.
 *
 * <div class="en">Each LRPH document in Swiss MUST contain exactly one
 * laboratory specialty section.</div> <div class="de">Für meldepflichtige
 * Laborbefunde in der Schweiz wird festgelegt, dass genau ein Kapitel vorhanden
 * sein muss.</div>
 *
 */
public class LaboratorySpecialtySection extends AbstractLaboratorySpecialtySection {

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
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            the code for this section
	 * @param entry
	 *            the LaboratoryReportDataProcessingEntry
	 */
	public LaboratorySpecialtySection(Code code, LaboratoryReportDataProcessingEntry entry) {
		this(code);
		getMdht().getEntries().clear();
		getMdht().getEntries().add(0, entry.getMdht());
	}

	/**
	 * Instantiates the class.
	 *
	 * @param code
	 *            the code for this section
	 * @param languageCode
	 *            the language code
	 */
	public LaboratorySpecialtySection(Code code, LanguageCode languageCode) {
		super(code, languageCode);
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
		setLaboratoryReportDataProcessingEntry(entry);
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
	 * Gets the laboratory report data processing entry.
	 *
	 * @return the laboratory report data processing entry
	 */
	public org.ehealth_connector.cda.ch.lab.lrph.LaboratoryReportDataProcessingEntry getLaboratoryReportDataProcessingEntry() {
		if (!getMdht().getEntries().isEmpty() && getMdht().getEntries().get(
				0) instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) {
			return new org.ehealth_connector.cda.ch.lab.lrph.LaboratoryReportDataProcessingEntry(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) getMdht()
							.getEntries().get(0));
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.ihe.lab.AbstractLaboratorySpecialtySection#setLaboratoryReportDataProcessingEntry(org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry)
	 */
	public void setLaboratoryReportDataProcessingEntry(
			org.ehealth_connector.cda.ch.lab.lrph.LaboratoryReportDataProcessingEntry entry) {
		getMdht().getEntries().clear();
		getMdht().getEntries().add(0, entry.copy());
	}
}
