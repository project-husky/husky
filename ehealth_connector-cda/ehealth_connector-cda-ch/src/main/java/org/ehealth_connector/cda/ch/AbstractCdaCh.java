/*
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
package org.ehealth_connector.cda.ch;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.AbstractCda;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.CDAPackage;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * CDA Dokument, das den Vorgaben der Spezifikation CDA-CH entspricht
 */
public abstract class AbstractCdaCh<EClinicalDocument extends ClinicalDocument>
		extends AbstractCda<EClinicalDocument> {

	/** main OID for CDA-CH */
	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1";

	/** OID for CDA-CH V1.* */
	public static final String OID_V1 = "2.16.756.5.30.1.1.1.1.1";

	/**
	 * <div class="en">Constructor for CdaCh documents</div>
	 * <div class="de">Erstellt ein CdaCh Objekt</div> <div class="fr"></div>
	 *
	 * @param doc
	 *            the CDA-CH Object in its MDHT representation
	 */
	public AbstractCdaCh(EClinicalDocument doc) {
		super(doc);
	}

	public AbstractCdaCh(EClinicalDocument doc, LanguageCode languageCode) {
		super(doc, languageCode);
	}

	/**
	 * <div class="en">Constructor that includes a stylesheet and a cascasing
	 * stylesheet into the document processing instructions and initalizes the
	 * standard document attributes.</div> <div class="de">Erzeugt ein CdaCh
	 * Objekt (CDA Header nach schweizer Spezifikation)</div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the CDA-CH Object in its MDHT representation
	 * @param stylesheet
	 *            the stylesheet for the document (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').
	 * @param css
	 *            the Cascasing stylesheet for the document (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').
	 */
	public AbstractCdaCh(EClinicalDocument doc, String stylesheet, String css) {
		super(doc, stylesheet, css);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCda#getLanguageCode()
	 */
	@Override
	public LanguageCode getLanguageCode() {
		return LanguageCode.getEnum(super.getDoc().getLanguageCode().getCode());
	}

	/**
	 *
	 * Method implementing
	 *
	 */
	@Override
	public void initCda() {
		// // Set the eHealthConnector comment
		// FeatureMapUtil.addComment(docRoot.getMixed(), 0, generateComment());

		// Add the stylesheet processing instructions to the document root using
		// featuremaputil
		// set xml namespace
		getDocRoot().getXMLNSPrefixMap().put("", CDAPackage.eNS_URI);

		// Set OID of the document
		setId(null);
		setVersion(null, null);

		setConfidentialityCode(null);

		// Set creation time of the document
		setTimestamp(null);

		// Fix RealmCode
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(CountryCode.SWITZERLAND.getCodeValue());
		getDoc().getRealmCodes().clear();
		getDoc().getRealmCodes().add(cs);

		// Type ID
		setTypeId();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCda#setId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void setId(Identificator id) {
		if (id == null) {
			final II docID = DatatypesFactory.eINSTANCE.createII();
			docID.setRoot(AbstractCdaCh.OID_MAIN);
			docID.setExtension(UUID.generate());
			getDoc().setId(docID);
		} else {
			getDoc().setId(id.getIi());
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCda#setSetId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void setSetId(Identificator id) {
		if (id == null) {
			getDoc().setSetId(EcoreUtil.copy(getDoc().getId()));
		} else {
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setRoot(id.getRoot());
			ii.setExtension(id.getExtension());
			getDoc().setSetId(ii);
		}
	}

}
