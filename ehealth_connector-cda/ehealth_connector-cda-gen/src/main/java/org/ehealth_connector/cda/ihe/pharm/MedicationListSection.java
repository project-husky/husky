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
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ihe.pharm;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

/**
 * Implements the Medication List Section Content Module (see also CDA-CH MTPS
 * 7.3.5)
 */
public class MedicationListSection
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationListSection> {

	/** The language code. */
	private LanguageCode languageCode;

	/**
	 * Instantiates a new medication list section.
	 */
	public MedicationListSection() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new medication list section.
	 *
	 * @param languageCode
	 *          the language code
	 */
	public MedicationListSection(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createMedicationListSection().init());
		this.languageCode = languageCode;

		switch (this.languageCode) {
		case GERMAN:
			this.getMdht().setTitle(Util.st("Medikamentenliste"));
			break;
		case FRENCH:
			this.getMdht().setTitle(Util.st("Liste de médicaments"));
			break;
		case ITALIAN:
			this.getMdht().setTitle(Util.st("Lista farmaci"));
			break;
		case ENGLISH:
			this.getMdht().setTitle(Util.st("Medication List"));
			break;
		}
	}

	/**
	 * Instantiates a new medication list section.
	 *
	 * @param section
	 *          the section
	 */
	public MedicationListSection(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationListSection section) {
		super(section);
	}

	/**
	 * Adds the dispense item entry.
	 *
	 * @param entry
	 *          the entry
	 */
	public void addDispenseItemEntry(DispenseItemEntry entry) {
		this.getMdht().addSupply(entry.getMdht());
	}

	/**
	 * Adds the medication treatment plan item entry.
	 *
	 * @param entry
	 *          the entry
	 */
	public void addMedicationTreatmentPlanItemEntry(MedicationTreatmentPlanItemEntry entry) {
		this.getMdht().addSubstanceAdministration(entry.getMdht());
	}

	/**
	 * Adds the pharmaceutical advice item entry.
	 *
	 * @param entry
	 *          the entry
	 */
	public void addPharmaceuticalAdviceItemEntry(PharmaceuticalAdviceItemEntry entry) {
		this.getMdht().addObservation(entry.getMdht());
	}

	/**
	 * Adds the prescription item entry.
	 *
	 * @param entry
	 *          the entry
	 */
	public void addPrescriptionItemEntry(PrescriptionItemEntry entry) {
		this.getMdht().addSubstanceAdministration(entry.getMdht());
	}

	/**
	 * Gets the dispense item entries.
	 *
	 * @return the dispense item entries
	 */
	public List<DispenseItemEntry> getDispenseItemEntries() {
		final List<DispenseItemEntry> entries = new ArrayList<DispenseItemEntry>();
		for (org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry entry : getMdht()
				.getDispenseItemEntries()) {
			entries.add(new DispenseItemEntry(entry));
		}
		return entries;
	}

	/**
	 * Gets the medication treatment plan item entries.
	 *
	 * @return the medication treatment plan item entries
	 */
	public List<MedicationTreatmentPlanItemEntry> getMedicationTreatmentPlanItemEntries() {
		final List<MedicationTreatmentPlanItemEntry> entries = new ArrayList<MedicationTreatmentPlanItemEntry>();
		for (org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry entry : getMdht()
				.getMedicationTreatmentPlanItemEntries()) {
			entries.add(new MedicationTreatmentPlanItemEntry(entry));
		}
		return entries;
	}

	/**
	 * Gets the pharmaceutical advice item entries.
	 *
	 * @return the pharmaceutical advice item entries
	 */
	public List<PharmaceuticalAdviceItemEntry> getPharmaceuticalAdviceItemEntries() {
		final List<PharmaceuticalAdviceItemEntry> entries = new ArrayList<PharmaceuticalAdviceItemEntry>();
		for (org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry entry : getMdht()
				.getPharmaceuticalAdviceItemEntries()) {
			entries.add(new PharmaceuticalAdviceItemEntry(entry));
		}
		return entries;
	}

	/**
	 * Gets the prescription item entries.
	 *
	 * @return the prescription item entries
	 */
	public List<PrescriptionItemEntry> getPrescriptionItemEntries() {
		final List<PrescriptionItemEntry> entries = new ArrayList<PrescriptionItemEntry>();
		for (org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry entry : getMdht()
				.getPrescriptionItemEntries()) {
			entries.add(new PrescriptionItemEntry(entry));
		}
		return entries;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		if (this.getMdht().getTitle() != null) {
			return this.getMdht().getTitle().getText();
		}
		return null;
	}

}
