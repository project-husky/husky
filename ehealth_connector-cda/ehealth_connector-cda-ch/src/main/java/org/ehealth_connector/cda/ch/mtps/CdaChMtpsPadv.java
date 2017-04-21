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
import org.ehealth_connector.cda.ihe.pharm.PharmaceuticalAdviceItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PharmaceuticalAdviceSection;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class CdaChMtpsPadv. see also CDA CH MTPS 7.4.2.6
 */
public class CdaChMtpsPadv
		extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPadv> {

	/**
	 * <div class="en">Instantiates a new cda ch mtps PADV Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @return <div class="en">Created PADV Document</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public CdaChMtpsPadv() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps PADV Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param languageCode
	 *            the language code
	 *
	 * @return <div class="en">Created PADV Document</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public CdaChMtpsPadv(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsPadv().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case FRENCH:
			setTitle("Conseils sur les médicaments"); // CDA CH MTPS 7.4.2.6
			break;
		case GERMAN:
			this.setTitle("Hinweise zur Medikation"); // CDA CH MTPS 7.4.2.6
			break;
		case ITALIAN:
			setTitle("Consigli sui farmaci"); // CDA CH MTPS 7.4.2.6
			break;
		case ENGLISH:
			setTitle("Pharmacy Pharmaceutical Advice"); // CDA CH MTPS 7.4.2.6
			break;
		}
		final PharmaceuticalAdviceSection section = new PharmaceuticalAdviceSection(
				getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * <div class="en">Instantiates a new cda ch mtps PADV Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the MDHT document
	 *
	 * @return <div class="en">Created PADV Document</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public CdaChMtpsPadv(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPadv doc) {
		super(doc);
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
	 * @param mtpsPadvId
	 *            ID of document
	 * @param dateOfDocument
	 *            Creation date
	 * @param languageCode
	 *            Langague code for document
	 */
	public void createPadvHeader(Author author, Author legalAuthenticator,
			Organization organization, Patient patient, Identificator mtpsPadvId,
			Date dateOfDocument, LanguageCode languageCode) {

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
		if (mtpsPadvId != null) {
			this.setId(mtpsPadvId);
			this.getPharmaceuticalAdviceSection().getMdht().setId(mtpsPadvId.getIi());
		}
	}

	/**
	 * <div class="en">Returns the PADV Item Entry using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return PADV item
	 *
	 */
	public PharmaceuticalAdviceItemEntry getPharmaceuticalAdviceItemEntry() {

		final org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemEntry entry = this
				.getMdht().getPharmaceuticalAdviceSection().getPharmaceuticalAdviceItemEntry();
		final PharmaceuticalAdviceItemEntry padvEntry = new PharmaceuticalAdviceItemEntry(entry);

		return padvEntry;
	}

	/**
	 * <div class="en">Returns the PADV Section using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @return the pharmaceutical advice section
	 */
	public PharmaceuticalAdviceSection getPharmaceuticalAdviceSection() {
		return new PharmaceuticalAdviceSection(this.getMdht().getPharmaceuticalAdviceSection());
	}

	/**
	 * <div class="en">Sets the PADV Item Entry using the eHealth Connector
	 * convenience API</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param entry
	 *            PADV Item Entry
	 *
	 */
	public void setPharmaceuticalAdviceItemEntry(PharmaceuticalAdviceItemEntry entry) {
		if (entry != null) {
			// do a list of Padv, which are an encapsulation of observations
			// entryRelationships
			this.getMdht().getPharmaceuticalAdviceSection().addObservation(entry.getMdht());

		}
	}

}