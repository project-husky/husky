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

package org.ehealth_connector.fhir.ch;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.Confidentiality;
import org.ehealth_connector.fhir.FhirCommon;
import org.ehealth_connector.fhir.ch.FhirCdaChVacd.DocTypeCode;

import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.NarrativeDt;
import ca.uhn.fhir.model.dstu2.resource.Basic;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Person;

public abstract class AbstractFhirCdaCh {
	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static final String OID_CONFIDENTIALITY_CODE = "urn:oid:"
			+ CodeSystems.ConfidentialityCode.getCodeSystemId();

	/**
	 * <div class="en">Gets a list of eHC Authors from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return list of eHC Authors </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.common.Author> getAuthors(Bundle bundle) {
		final List<org.ehealth_connector.common.Author> retVal = new ArrayList<org.ehealth_connector.common.Author>();
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsAuthor).isEmpty()
					&& (entry.getResource() instanceof Person)) {
				retVal.add(FhirCommon.getAuthor((Person) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC confidentiality code from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC confidentiality code </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public Confidentiality getConfidentialityCode(Bundle bundle) {
		Confidentiality retVal = Confidentiality.NORMAL; // default
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (langCode != null && langCode.getSystem() != null
						&& langCode.getSystem().equals(OID_CONFIDENTIALITY_CODE)) {
					if ("veryrestricted".equals(langCode.getCode().toLowerCase())) {
						retVal = Confidentiality.VERY_RESTRICTED;
						break;
					} else if ("restricted".equals(langCode.getCode().toLowerCase())) {
						retVal = Confidentiality.RESTRICED;
						break;
					} else if ("normal".equals(langCode.getCode().toLowerCase())) {
						retVal = Confidentiality.NORMAL;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC Custodian from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Custodian</div> <div class="de"></div> <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Organization getCustodian(Bundle bundle) {
		org.ehealth_connector.common.Organization retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsCustodian).isEmpty()
					&& (entry.getResource() instanceof Organization)) {
				retVal = FhirCommon.getOrganization((Organization) entry.getResource());
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC document language code from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC document language </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public LanguageCode getDocLanguage(Bundle bundle) {
		LanguageCode retVal = LanguageCode.GERMAN; // default
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (langCode.getSystem().equals(FhirCommon.oidLanguage)) {
					if (langCode.getCode().toLowerCase().startsWith("de")) {
						retVal = LanguageCode.GERMAN;
						break;
					} else if (langCode.getCode().toLowerCase().startsWith("fr")) {
						retVal = LanguageCode.FRENCH;
						break;
					} else if (langCode.getCode().toLowerCase().startsWith("it")) {
						retVal = LanguageCode.ITALIAN;
						break;
					} else if (langCode.getCode().toLowerCase().startsWith("en")) {
						retVal = LanguageCode.ENGLISH;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC document type code (full or masked patient
	 * demographics) from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @param docOid
	 *            the oid of the document
	 * @return eHC document type code (full or masked patient
	 *         demographics)</div> <div class="de"></div> <div class="fr"></div>
	 */
	public DocTypeCode getDocType(Bundle bundle, String docOid) {
		DocTypeCode retVal = DocTypeCode.PATIENT; // default
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (docOid.equals(langCode.getSystem())) {
					if ("patient".equals(langCode.getCode().toLowerCase())) {
						retVal = DocTypeCode.PATIENT;
						break;
					} else if ("pseudonymized".equals(langCode.getCode().toLowerCase())) {
						retVal = DocTypeCode.PSEUDONYMIZED;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets an eHC Author object containing the legal authenticator from the
	 * given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Author object containing the legal authenticator
	 */
	public org.ehealth_connector.common.Author getLegalAuthenticator(Bundle bundle) {
		org.ehealth_connector.common.Author retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLegalAuthenticator).isEmpty()
					&& (entry.getResource() instanceof Person)) {
				retVal = FhirCommon.getAuthor((Person) entry.getResource());
			}
		}
		return retVal;
	}

	/**
	 * Gets an eHC Author object containing the legal authenticator from the
	 * given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Author object containing the legal authenticator
	 */
	public String getNarrative(Bundle bundle, String extensionUrl) {
		String retVal = "";
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(extensionUrl).isEmpty()
					&& (entry.getResource() instanceof Basic)) {
				NarrativeDt text = ((Basic) entry.getResource()).getText();
				if (text != null) {
					retVal = text.getDiv().getValueAsString();
					retVal = retVal.replace("</div>", "");
					retVal = retVal.substring(retVal.indexOf(">") + 1, retVal.length());
					return retVal;
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Checks if a document type code with a matching oid is
	 * present in the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @param docOid
	 *            the oid of the document
	 * @return eHC document type code (full or masked patient
	 *         demographics)</div> <div class="de"></div> <div class="fr"></div>
	 */
	public boolean isDocType(Bundle bundle, String docOid) {
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (docOid.equals(langCode.getSystem())) {
					return true;
				}
			}
		}
		return false;
	}
}
