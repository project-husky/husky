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

package org.ehealth_connector.cda.ch.mtps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaChV1;
import org.ehealth_connector.cda.ihe.pharm.DispenseItemEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationListSection;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PharmaceuticalAdviceItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionItemEntry;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;

/**
 * The Class CdaChMtpsPml. See also CDA-CH-MTPS 7.4.2.2
 */
public class CdaChMtpsPml
		extends AbstractCdaChV1<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsV1Pml> {

	/**
	 * <div class="en">Instantiates a new CDA-CH-MTPS PML Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 */
	public CdaChMtpsPml() {
		this(LanguageCode.ENGLISH, null, null);
	}

	/**
	 * <div class="en">Creates a new MTPS PML CDA document</div>
	 * <div class="de">Erstellt ein neues MTPS PML CDA Dokument.</div>
	 *
	 * @param languageCode
	 *            <br>
	 *            <div class="en">document language</div>
	 *            <div class="de">Sprache des Dokments</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param stylesheet
	 *            <div class="en">stylesheet, which should be referenced to
	 *            render a human readable representation of the document</div>
	 *            <div class="de">Stylesheet, welches im CDA mittels
	 *            ?xml-stylesheet für die menschlich lesbare Darstellung
	 *            referenziert werden soll (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 * @param cascadingStylesheet
	 *            <div class="en">Cascading stylesheet, which should be
	 *            referenced to render a human readable representation of the
	 *            document</div> <div class="de">Cascasing Stylesheet, welches
	 *            Designinformationen für die menschlich lesbare Darstellung
	 *            referenziert (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 */
	public CdaChMtpsPml(LanguageCode languageCode, String stylesheet, String cascadingStylesheet) {
		super(ChFactory.eINSTANCE.createCdaChMtpsV1Pml().init(), stylesheet, cascadingStylesheet);
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("Medikamentenliste");
			break;
		case FRENCH:
			setTitle("Liste de médicaments");
			break;
		case ITALIAN:
			setTitle("Lista farmaci");
			break;
		case ENGLISH:
			setTitle("Medication List");
		}
		final MedicationListSection section = new MedicationListSection(getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * <div class="en">Instantiates a new CDA-CH-MTPS PML Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the MDHT document
	 */
	public CdaChMtpsPml(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsV1Pml doc) {
		super(doc);
	}

	/**
	 * <div class="en">Adds an DIS entry to the PML Document using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param disEntry
	 *            the DIS Entry
	 */
	public void addDispenseItemEntry(DispenseItemEntry disEntry) {
		MedicationListSection section = null;
		if (getMdht().getMedicationListSection() == null) {
			section = new MedicationListSection(getLanguageCode());
			this.getMdht().addSection(section.getMdht());
		} else {
			section = new MedicationListSection(getMdht().getMedicationListSection());
		}
		section.addDispenseItemEntry(disEntry);
	}

	/**
	 * <div class="en">Adds an MTP entry to the PML Document using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param mtpEntry
	 *            the MTP Entry
	 */
	public void addMedicationTreatmentPlanEntry(MedicationTreatmentPlanItemEntry mtpEntry) {
		MedicationListSection section = null;
		if (getMdht().getMedicationListSection() == null) {
			section = new MedicationListSection(getLanguageCode());
			this.getMdht().addSection(section.getMdht());
		} else {
			section = new MedicationListSection(getMdht().getMedicationListSection());
		}
		section.addMedicationTreatmentPlanItemEntry(mtpEntry);
	}

	/**
	 * <div class="en">Adds an PADV entry to the PML Document using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param padvEntry
	 *            the PADV Entry
	 */
	public void addPharmaceuticalAdviceItemEntry(PharmaceuticalAdviceItemEntry padvEntry) {
		MedicationListSection section = null;
		if (getMdht().getMedicationListSection() == null) {
			section = new MedicationListSection(getLanguageCode());
			this.getMdht().addSection(section.getMdht());
		} else {
			section = new MedicationListSection(getMdht().getMedicationListSection());
		}
		section.addPharmaceuticalAdviceItemEntry(padvEntry);
	}

	/**
	 * <div class="en">Adds an PRE entry to the PML Document using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param preEntry
	 *            the PRE Entry
	 */
	public void addPrescriptionItemEntry(PrescriptionItemEntry preEntry) {
		MedicationListSection section = null;
		if (getMdht().getMedicationListSection() == null) {
			section = new MedicationListSection(getLanguageCode());
			this.getMdht().addSection(section.getMdht());
		} else {
			section = new MedicationListSection(getMdht().getMedicationListSection());
		}
		section.addPrescriptionItemEntry(preEntry);
	}

	/**
	 * <div class="en">Creates the header for a sample CDA-CH-MTPS PADV document
	 * using the eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param author
	 *            Author of document
	 * @param legalAuthenticator
	 *            Legal authenticator of document
	 * @param organization
	 *            Parent organization
	 * @param mtpsMtpId
	 *            ID of document
	 * @param dateOfDocument
	 *            Creation date
	 * @param languageCode
	 *            Langague code for document
	 */
	public void createPmlHeader(Author author, Author legalAuthenticator, Organization organization,
			Patient patient, Identificator mtpsMtpId, Date dateOfDocument,
			LanguageCode languageCode) {

		if (dateOfDocument != null)
			this.setTimestamp(dateOfDocument);
		if (legalAuthenticator != null)
			this.setLegalAuthenticator(legalAuthenticator);
		if (organization != null)
			this.setCustodian(organization);
		if (languageCode != null)
			this.setLanguageCode(languageCode);
		if (author != null)
			this.addAuthor(author);
		if (patient != null)
			this.setPatient(patient);
		if (mtpsMtpId != null)
			this.setId(mtpsMtpId);
	}

	/**
	 * <div class="en">Returns the DIS Entries using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return the List of DIS Items
	 */
	public List<DispenseItemEntry> getDispenseItemEntries() {
		final List<DispenseItemEntry> entries = new ArrayList<DispenseItemEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry entry : getMdht()
				.getMedicationListSection().getDispenseItemEntries()) {
			entries.add(new DispenseItemEntry(entry));
		}
		return entries;
	}

	/**
	 * <div class="en">Returns the Medication List Section using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return the Medication List section
	 */
	public MedicationListSection getMedicationListSection() {
		if (this.getMdht().getMedicationListSection() != null) {
			return new MedicationListSection(this.getMdht().getMedicationListSection());
		}
		return null;
	}

	/**
	 * <div class="en">Returns the MTP Entries using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return the List of MTP Items
	 */
	public List<MedicationTreatmentPlanItemEntry> getMedicationTreatmentPlanItemEntries() {
		final List<MedicationTreatmentPlanItemEntry> entries = new ArrayList<MedicationTreatmentPlanItemEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry entry : getMdht()
				.getMedicationListSection().getMedicationTreatmentPlanItemEntries()) {
			entries.add(new MedicationTreatmentPlanItemEntry(entry));
		}
		return entries;
	}

	/**
	 * <div class="en">Returns the PADV Entries using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return the List of PADV Items
	 */
	public List<PharmaceuticalAdviceItemEntry> getPharmaceuticalAdviceItemEntries() {
		final List<PharmaceuticalAdviceItemEntry> entries = new ArrayList<PharmaceuticalAdviceItemEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry entry : getMdht()
				.getMedicationListSection().getPharmaceuticalAdviceItemEntries()) {
			entries.add(new PharmaceuticalAdviceItemEntry(entry));
		}
		return entries;
	}

	/**
	 * <div class="en">Returns the PRE Entries using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return the List of PRE Items
	 */
	public List<PrescriptionItemEntry> getPrescriptionItemEntries() {
		final List<PrescriptionItemEntry> entries = new ArrayList<PrescriptionItemEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry entry : getMdht()
				.getMedicationListSection().getPrescriptionItemEntries()) {
			entries.add(new PrescriptionItemEntry(entry));
		}
		return entries;
	}

}
