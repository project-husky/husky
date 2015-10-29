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
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch;

import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ch.VACD;

/**
 * <div class="en">A CDA document, which is conform to the CDA-CH-VACD
 * specification</div> <div class="de">Ein CDA Dokument, welches der
 * Spezifikation CDA-CH-VACD entspricht.</div> <div class="fr">Class
 * CdaChVacd.</div> <div class="it">Class CdaChVacd.</div>
 * 
 * @deprecated use org.ehealth_connector.cda.CdaChVacd instead
 */
@Deprecated
public class CdaChVacd extends org.ehealth_connector.cda.CdaChVacd {

	public CdaChVacd() {
		super();
	}

	/**
	 * Erstellt ein neues eVACDOC CDA Dokument.
	 * 
	 * @param language
	 *            document language
	 * @param immunization
	 *            an immunization
	 */
	public CdaChVacd(LanguageCode language, Immunization immunization) {
		super(language, immunization);
	}

	/**
	 * <div class="en">Creates a new eVACDOC CDA document</div>
	 * <div class="de">Erstellt ein neues eVACDOC CDA Dokument.</div>
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
	public CdaChVacd(LanguageCode language, String stylesheet, String cascadingStylesheet) {
		super(language, stylesheet, cascadingStylesheet);
	}

	/**
	 * <div class="en">Creates a new eVACDOC CDA document</div>
	 * <div class="de">Erstellt ein neues eVACDOC CDA Dokument.</div>
	 * 
	 * @param language
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
	 * @param cascasingStylesheet
	 *            <div class="en">Cascading stylesheet, which should be
	 *            referenced to render a human readable representation of the
	 *            document</div> <div class="de">Cascasing Stylesheet, welches
	 *            Designinformationen für die menschlich lesbare Darstellung
	 *            referenziert (z.B.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').</div
	 *            >
	 * @param immunization
	 *            <div class="en">the immunization</div>
	 *            <div class="de">Impfung</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public CdaChVacd(LanguageCode language, String stylesheet, String cascasingStylesheet,
			Immunization immunization) {
		super(language, stylesheet, cascasingStylesheet);
	}

	/**
	 * <div class="en">Creates a new CdaChVacd convenience object on the basis
	 * of a MDHT-VACD object. Both represent an immunization document</div>
	 * <div class="de">Erstellt ein neues CdaChVacd Convenience Objekt mittels
	 * eines MDHT-VACD Objekts. Beide repräsentieren ein Impfdokument.</div>
	 * <div class="fr"></div>
	 * 
	 * @param doc
	 *            MDHT VACD object
	 */
	public CdaChVacd(VACD doc) {
		super(doc);
	}

}
