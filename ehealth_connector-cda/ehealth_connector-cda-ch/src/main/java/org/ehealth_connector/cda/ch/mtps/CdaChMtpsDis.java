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

package org.ehealth_connector.cda.ch.mtps;

import java.util.Date;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ihe.pharm.DispenseItemEntry;
import org.ehealth_connector.cda.ihe.pharm.DispenseSection;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class CdaChMtpsDis. see also CDA CH MTPS 7.4.2.5
 */
public class CdaChMtpsDis extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsDis> {

	/**
	 * <div class="en">Instantiates a new cda ch mtps DIS Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Created PRE Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsDis() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps DIS Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param languageCode
	 *            the language code
	 *
	 * @return <div class="en">Created DIS Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsDis(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsDis().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case FRENCH:
			setTitle("Dispensation des médicaments"); // CDA CH MTPS 7.4.2.5
			break;
		case GERMAN:
			this.setTitle("Abgabe von Medikamenten"); // CDA CH MTPS 7.4.2.5
			break;
		case ITALIAN:
			setTitle("Dispensazioni di farmaci"); // CDA CH MTPS 7.4.2.5
			break;
		case ENGLISH:
			setTitle("Medication dispensed"); // IHE PHARM DIS L350
			break;
		}
		final DispenseSection dispenseSection = new DispenseSection(languageCode);
		this.getDoc().addSection(dispenseSection.getMdht());
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps DIS Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the MDHT document
	 *
	 * @return <div class="en">Created DIS Document</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChMtpsDis(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsDis doc) {
		super(doc);
	}

	/**
	 * <div class="en">Creates the header for a sample CDA-CH-MTPS DIS document
	 * using the eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param author
	 *            Author of document
	 * @param legalAuthenticator
	 *            Legal authenticator of document
	 * @param organization
	 *            Parent organization
	 * @param mtpsDisId
	 *            ID of document
	 * @param dateOfDocument
	 *            Creation date
	 * @param languageCode
	 *            Langague code for document
	 */
	public void createDisHeader(Author author, Author legalAuthenticator, Organization organization,
			Patient patient, Identificator mtpsDisId, Date dateOfDocument,
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
		if (mtpsDisId != null) {
			this.setId(mtpsDisId);
			this.getDispenseSection().getMdht().setId(mtpsDisId.getIi());
		}
	}

	/**
	 * <div class="en">Returns the DIS Item Entry using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return DIS item
	 *
	 */
	public DispenseItemEntry getDispenseItemEntry() {
		final org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry entry = this.getMdht()
				.getDispenseSection().getDispenseItemEntry();

		final DispenseItemEntry disEntry = new DispenseItemEntry(entry);
		return disEntry;
	}

	/**
	 * <div class="en">Returns the DIS Section using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return the dispense section
	 */
	public DispenseSection getDispenseSection() {
		return new DispenseSection(this.getMdht().getDispenseSection());
	}

	/**
	 * <div class="en">Sets the DIS Item Entry using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param entry
	 *            DIS Item Entry
	 *
	 */
	public void setDispenseItemEntry(DispenseItemEntry entry) {
		if (entry != null) {
			this.getMdht().getDispenseSection().addSupply(entry.getMdht());
		}
	}
}
