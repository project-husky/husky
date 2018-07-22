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

import org.ehealth_connector.cda.ch.AbstractCdaChV1;
import org.ehealth_connector.cda.ihe.pharm.DispenseItemEntry;
import org.ehealth_connector.cda.ihe.pharm.DispenseSection;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;

/**
 * The Class CdaChMtpsDis. See also CDA-CH-MTPS 7.4.2.5
 */
@SuppressWarnings("deprecation")
public class CdaChMtpsDis
		extends AbstractCdaChV1<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsV1Dis> {

	/**
	 * <div class="en">Instantiates a new CDA-CH-MTPS DIS Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 */
	public CdaChMtpsDis() {
		this(LanguageCode.ENGLISH, null, null);
	}

	/**
	 * <div class="en">Creates a new MTPS DIS CDA document</div>
	 * <div class="de">Erstellt ein neues MTPS DIS CDA Dokument.</div>
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
	public CdaChMtpsDis(LanguageCode language, String stylesheet, String cascadingStylesheet) {
		super(ChFactory.eINSTANCE.createCdaChMtpsV1Dis().init(), language, stylesheet,
				cascadingStylesheet);
		super.initCda();
		switch (this.getLanguageCode()) {
		case FRENCH:
			setTitle("Dispensation des médicaments"); // CDA-CH-MTPS 7.4.2.5
			break;
		case GERMAN:
			this.setTitle("Abgabe von Medikamenten"); // CDA-CH-MTPS 7.4.2.5
			break;
		case ITALIAN:
			setTitle("Dispensazioni di farmaci"); // CDA-CH-MTPS 7.4.2.5
			break;
		case ENGLISH:
			setTitle("Medication dispensed"); // IHE PHARM DIS L350
			break;
		}
		final DispenseSection dispenseSection = new DispenseSection(language);
		this.getDoc().addSection(dispenseSection.getMdht());
	}

	/**
	 * <div class="en">Instantiates a new CDA-CH-MTPS DIS Document using the
	 * eHealth Connector convenience API</div> <div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the MDHT document
	 */
	public CdaChMtpsDis(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsV1Dis doc) {
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
