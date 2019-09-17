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
package org.ehealth_connector.cda.ihe.lab;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.BaseObservation;
import org.ehealth_connector.cda.MdhtSectionFacade;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Entry;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer;

/**
 * A base LaboratorySpecialtySection.
 */
public class BaseLaboratorySpecialtySection extends
		MdhtSectionFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection> {

	/**
	 * Instantiates a new abstract laboratory specialty section.
	 */
	public BaseLaboratorySpecialtySection() {
		super(LABFactory.eINSTANCE.createLaboratorySpecialtySection().init());
		setTitle(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new abstract laboratory specialty section.
	 *
	 * @param code
	 *            the code
	 */
	public BaseLaboratorySpecialtySection(Code code) {
		this();
		setCode(code);
	}

	/**
	 * Instantiates a new abstract laboratory specialty section.
	 *
	 * @param code
	 *            the code
	 * @param languageCode
	 *            the language code
	 */
	public BaseLaboratorySpecialtySection(Code code, LanguageCode languageCode) {
		this(code);
		setTitle(languageCode);
	}

	/**
	 * Instantiates a new abstract laboratory specialty section.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public BaseLaboratorySpecialtySection(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection mdht) {
		super(mdht);
	}

	/**
	 * Gets the act.
	 *
	 * @return the act
	 */
	public BaseLaboratoryAct getAct() {
		final EList<Entry> entries = getMdht().getEntries();

		for (final Entry entry : entries) {
			final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mLabRdpe = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) entry;

			return new BaseLaboratoryAct(mLabRdpe.getAct());
		}
		return null;
	}

	/**
	 * Gets the observations.
	 *
	 * @return the observations
	 */
	public List<BaseObservation> getObservations() {
		final EList<Entry> entries = getMdht().getEntries();

		final List<BaseObservation> labObservations = new ArrayList<BaseObservation>();
		for (final Entry entry : entries) {
			final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mLabRdpe = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) entry;

			final Act act = mLabRdpe.getAct();
			for (final EntryRelationship er : act.getEntryRelationships()) {
				if (er.getOrganizer() instanceof LaboratoryBatteryOrganizer) {
					final LaboratoryBatteryOrganizer mLabOrg = (LaboratoryBatteryOrganizer) er
							.getOrganizer();
					for (final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mLo : mLabOrg
							.getLaboratoryObservations()) {
						final BaseObservation lo = new BaseObservation(mLo);
						labObservations.add(lo);
					}
				}
			}
		}
		return labObservations;
	}

	/**
	 * Sets the laboratory report data processing entry.
	 *
	 * @param entry
	 *            the new laboratory report data processing entry
	 */
	public void setLaboratoryReportDataProcessingEntry(LaboratoryReportDataProcessingEntry entry) {
		getMdht().getEntries().clear();
		getMdht().getEntries().add(entry.getMdht());
	}

	/**
	 * Sets the title.
	 *
	 * @param languageCode
	 *            the new title
	 */
	public void setTitle(LanguageCode languageCode) {
		if (languageCode == LanguageCode.FRENCH)
			setTitle("Rapport de laboratoire");
		if (languageCode == LanguageCode.GERMAN)
			this.setTitle("Laborbefund");
		if (languageCode == LanguageCode.ITALIAN)
			setTitle("Rapporto di laboratorio");
		if (languageCode == LanguageCode.ENGLISH)
			setTitle("Laboratory report");
	}
}
