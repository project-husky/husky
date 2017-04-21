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

import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanSection;
import org.ehealth_connector.cda.ihe.pharm.PatientMedicalInstructionsEntry;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;

/**
 * The Class CdaChMtpsMtp. see also CDA CH MTPS 7.4.2.3
 */
public class CdaChMtpsMtp extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp> {

	/**
	 * <div class="en">Creates a Patient Medical Instructions Entry using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param textReference
	 *            <div class="en">Instructions for the patient</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 *
	 * @return <div class="en">Created PatientMedicalInstructionsEntry</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public static PatientMedicalInstructionsEntry createPatientMedicalInstruction(
			String textReference) {
		final PatientMedicalInstructionsEntry pi = new PatientMedicalInstructionsEntry();
		pi.setTextReference(textReference);
		return pi;
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps MTP Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Created MTP Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsMtp() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps MTP Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param languageCode
	 *            the language code
	 *
	 * @return <div class="en">Created MTP Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsMtp(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsMtp().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("Medikamentöser Behandlungsplan");
			break;
		case FRENCH:
			setTitle("Plan de traitement médicamenteux");
			break;
		case ITALIAN:
			setTitle("Piano terapeutico farmacologico");
			break;
		case ENGLISH:
			setTitle("Medication Treatment Plan");
			break;
		}

		final MedicationTreatmentPlanSection section = new MedicationTreatmentPlanSection(
				getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps MTP Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the document
	 *
	 * @return <div class="en">Created MTP Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsMtp(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsMtp doc) {
		super(doc);
	}

	/**
	 * <div class="en">Creates the header for a sample CDA-CH-MTPS MTP document
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
	public void createMtpHeader(Author author, Author legalAuthenticator, Organization organization,
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
		if (mtpsMtpId != null) {
			this.setId(mtpsMtpId);
			this.getMedicationTreatmentPlanSection().getMdht().setId(mtpsMtpId.getIi());
		}

	}

	/**
	 * <div class="en">Returns the Dose Quantity using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return <div class="en">Reference to the existing Dose quantity
	 *         (IVL_PQ)</div> <div class="de"></div> <div class="fr"></div>
	 */
	public IVL_PQ getDosage() {
		return ((SubstanceAdministration) getMdht()).getDoseQuantity();
	}

	/**
	 * <div class="en">Returns the ID of the document using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">ID of document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	@Override
	public Identificator getId() {
		Identificator id = null;
		if ((getMdht().getId() != null)) {
			id = new Identificator(getMdht().getId());
		}
		return id;
	}

	/**
	 * <div class="en">Returns the Medication treatment plan entry using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Medication treatment plan entry</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public MedicationTreatmentPlanItemEntry getMedicationTreatmentPlanEntry() {
		MedicationTreatmentPlanItemEntry mtpEntry = null;
		final List<org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry> entries = getMdht()
				.getMedicationTreatmentPlanSection().getMedicationTreatmentPlanItemEntries();
		for (final org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationTreatmentPlanItemEntry entry : entries) {
			mtpEntry = new MedicationTreatmentPlanItemEntry(entry);
		}

		return mtpEntry;
	}

	/**
	 * <div class="en">Returns the Medication treatment plan section using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Medication treatment plan section</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public MedicationTreatmentPlanSection getMedicationTreatmentPlanSection() {
		if (this.getMdht().getMedicationTreatmentPlanSection() != null) {
			return new MedicationTreatmentPlanSection(
					this.getMdht().getMedicationTreatmentPlanSection());
		}
		return null;
	}

	/**
	 * <div class="en">Returns the Patient Instructions using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Patient Instructions</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public PatientMedicalInstructionsEntry getPatientInstructions() {

		final PatientMedicalInstructionsEntry pi = new PatientMedicalInstructionsEntry();

		pi.setTextReference(this.getMdht().getMedicationTreatmentPlanSection()
				.getMedicationTreatmentPlanItemEntries().get(0).getPatientInstructions().get(0)
				.getText().getText());
		return pi;
	}

	/**
	 * <div class="en">Returns the Professional Instructions using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Professional Instructions</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public String getProfessionalInstructions() {
		return this.getMedicationTreatmentPlanSection().getMdht()
				.getMedicationTreatmentPlanItemEntries().get(0)
				.getMedicationFullfillmentInstructions().getText().getText();
	}

	/**
	 * <div class="en">Returns the "Reason for treatment" using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Reason for treatment</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public String getReasonForTreatment() {
		return this.getMedicationTreatmentPlanSection().getMdht()
				.getMedicationTreatmentPlanItemEntries().get(0).getActs().get(0).getText()
				.getText();
	}

	/**
	 * <div class="en">Returns the Document's Status Code using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Status code</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public void getStatusCode(Code statusCode) {
		getMdht().setCode(statusCode.getCS());
	}

	/**
	 * <div class="en">Indicates if a MTP Entry is present using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">true if there is a MTP entry</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public boolean hasItemEntry() {
		boolean flag = false;
		if (getMdht().getMedicationTreatmentPlanSection() != null) {
			if (getMdht().getMedicationTreatmentPlanSection()
					.getMedicationTreatmentPlanItemEntries().size() > 0) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * <div class="en">Sets the MTP Item Entry using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param mtpItem
	 *            MTP Item Entry
	 *
	 */
	public void setMedicationTreatmentPlanItemEntry(MedicationTreatmentPlanItemEntry mtpItem) {
		this.getMdht().getMedicationTreatmentPlanSection()
				.addSubstanceAdministration(mtpItem.getMdht());
	}

}
