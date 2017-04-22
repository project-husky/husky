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
 * The Class CdaChMtpsPadv. See also CDA-CH-MTPS 7.4.2.6
 */
public class CdaChMtpsPadv
		extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPadv> {

	/**
	 * <div class="en">Instantiates a new CDA-CH-MTPS PADV Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 */
	public CdaChMtpsPadv() {
		this(LanguageCode.ENGLISH, null, null);
	}

	/**
	 * <div class="en">Creates a new MTPS PADV CDA document</div>
	 * <div class="de">Erstellt ein neues MTPS PADV CDA Dokument.</div>
	 *
	 * @param language
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
	public CdaChMtpsPadv(LanguageCode languageCode, String stylesheet, String cascadingStylesheet) {
		super(CHFactory.eINSTANCE.createCdaChMtpsPadv().init(), stylesheet, cascadingStylesheet);
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case FRENCH:
			setTitle("Conseils sur les médicaments"); // CDA-CH-MTPS 7.4.2.6
			break;
		case GERMAN:
			this.setTitle("Hinweise zur Medikation"); // CDA-CH-MTPS 7.4.2.6
			break;
		case ITALIAN:
			setTitle("Consigli sui farmaci"); // CDA-CH-MTPS 7.4.2.6
			break;
		case ENGLISH:
			setTitle("Pharmacy Pharmaceutical Advice"); // CDA-CH-MTPS 7.4.2.6
			break;
		}
		final PharmaceuticalAdviceSection section = new PharmaceuticalAdviceSection(
				getLanguageCode());
		this.getDoc().addSection(section.getMdht());
	}

	/**
	 * <div class="en">Instantiates a new CDA-CH-MTPS PADV Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the MDHT document
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