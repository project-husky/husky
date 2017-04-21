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

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionSection;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class CdaChMtpsPre. See also CDA CH MTPS 7.4.2.4
 */
public class CdaChMtpsPre extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPre> {

	/**
	 * <div class="en">Instantiates a new cda ch mtps PRE Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Created PRE Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsPre() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps PRE Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param languageCode
	 *            the language code
	 *
	 * @return <div class="en">Created PRE Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsPre(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsPre().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case GERMAN:
			this.setTitle("Verordnung von Medikamenten"); // CDA CH MTPS 7.4.2.4
			break;
		case FRENCH:
			setTitle("Prescriptions des médicaments"); // CDA CH MTPS 7.4.2.4
			break;
		case ITALIAN:
			setTitle("Prescrizione farmacologica"); // CDA CH MTPS 7.4.2.4
			break;
		case ENGLISH:
			setTitle("Pharmacy Prescription");
			break;
		}
		final PrescriptionSection section = new PrescriptionSection(getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps MTP Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the MDHT document
	 *
	 * @return <div class="en">Created PRE Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsPre(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPre doc) {
		super(doc);
	}

	/**
	 * <div class="en">Adds a PRE Item Entry using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param entry
	 *            PRE Item Entry
	 *
	 */
	public void addPrescriptionItemEntry(PrescriptionItemEntry entry) {
		if (entry != null) {
			this.getMdht().getPrescriptionSection().addSubstanceAdministration(entry.getMdht());

		}
	}

	/**
	 * <div class="en">Creates the header for a sample CDA-CH-MTPS PRE document
	 * using the eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param author
	 *            Author of document
	 * @param legalAuthenticator
	 *            Legal authenticator of document
	 * @param organization
	 *            Parent organization
	 * @param mtpsPreId
	 *            ID of document
	 * @param dateOfDocument
	 *            Creation date
	 * @param languageCode
	 *            Langague code for document
	 */
	public void createPreHeader(Author author, Author legalAuthenticator, Organization organization,
			Patient patient, Identificator mtpsPreId, Date dateOfDocument,
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
		if (mtpsPreId != null) {
			this.setId(mtpsPreId);
			this.getPrescriptionSection().getMdht().setId(mtpsPreId.getIi());
		}
	}

	/**
	 * <div class="en">Returns the list of PRE Item Entries using the eHealth
	 * Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return List of PRE items
	 *
	 */
	public List<PrescriptionItemEntry> getPrescriptionItemEntries() {
		final List<PrescriptionItemEntry> entries = new ArrayList<PrescriptionItemEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.pharm.PrescriptionItemEntry entry : getMdht()
				.getPrescriptionSection().getPrescriptionItemEntries()) {
			entries.add(new PrescriptionItemEntry(entry));
		}
		return entries;
	}

	/**
	 * <div class="en">Returns the PRE Section using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return the prescription section
	 */
	public PrescriptionSection getPrescriptionSection() {
		if (this.getMdht().getPrescriptionSection() != null) {
			return new PrescriptionSection(this.getMdht().getPrescriptionSection());
		}
		return null;
	}

}