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
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.SpecimenReceivedEntry;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.IntendedRecipient;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.Confidentiality;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.fhir.FhirCommon;
import org.ehealth_connector.fhir.ch.FhirCdaChVacd.DocTypeCode;

import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.NarrativeDt;
import ca.uhn.fhir.model.dstu2.resource.Basic;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Condition;
import ca.uhn.fhir.model.dstu2.resource.DocumentManifest;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.dstu2.valueset.ObservationStatusEnum;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.model.primitive.TimeDt;

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
			List<ExtensionDt> extensions = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsAuthor);
			if (!extensions.isEmpty()) {
				org.ehealth_connector.common.Author author = null;
				if (entry.getResource() instanceof Person) {
					author = FhirCommon.getAuthor((Person) entry.getResource());
				}
				if (entry.getResource() instanceof Organization) {
					author = FhirCommon.getAuthor((Organization) entry.getResource());
				}

				StringDt timeStamp = ((StringDt) extensions.get(0).getValue());
				author.setTime(DateUtil.parseDates(timeStamp.getValue()));
				retVal.add(author);
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
					} else if ("restricted".equals(langCode.getCode().toLowerCase())
							|| "r".equals(langCode.getCode().toLowerCase())) {
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
	 * <div class="en"> Gets the document date from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return the document Id
	 */
	public Date getDocumentDate(Bundle bundle) {
		Date retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof DocumentManifest) {
				final DocumentManifest fhirDocumentManifest = (DocumentManifest) entry
						.getResource();
				retVal = fhirDocumentManifest.getCreated();
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the document Id from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return the document Id
	 */
	public Identificator getDocumentId(Bundle bundle) {
		Identificator retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof DocumentManifest) {
				final DocumentManifest fhirDocumentManifest = (DocumentManifest) entry
						.getResource();
				final IdentifierDt docId = fhirDocumentManifest.getIdentifier().get(0);
				retVal = new Identificator(docId.getSystem(), docId.getValue());
			}
		}
		return retVal;
	};

	/**
	 * <div class="en"> Gets the document Set Id from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return the document Set Id
	 */
	public Identificator getDocumentSetId(Bundle bundle) {
		Identificator retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof DocumentManifest) {
				final DocumentManifest fhirDocumentManifest = (DocumentManifest) entry
						.getResource();
				final IdentifierDt docId = fhirDocumentManifest.getIdentifier().get(1);
				retVal = new Identificator(docId.getSystem(), docId.getValue());
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC ReferralOrderingPhyscian from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Custodian</div> <div class="de"></div> <div class="fr"></div>
	 */
	public IntendedRecipient getIntendedRecipient(Bundle bundle) {
		IntendedRecipient retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsInformationRecipient)
					.isEmpty()) {
				Organization physician = (Organization) entry.getResource();
				org.ehealth_connector.common.Organization o = FhirCommon.getOrganization(physician);
				retVal = new IntendedRecipient(o);
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
			List<ExtensionDt> extensions = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLegalAuthenticator);
			if (!extensions.isEmpty() && (entry.getResource() instanceof Person)) {
				retVal = FhirCommon.getAuthor((Person) entry.getResource());
				TimeDt timeStamp = ((TimeDt) extensions.get(0).getValue());
				retVal.setTime(DateUtil.parseDateyyyyMMddHHmmssZZZZ(timeStamp.getValue()));
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
			if (!entry.getUndeclaredExtensionsByUrl(extensionUrl).isEmpty()) {
				NarrativeDt text;
				if (entry.getResource() instanceof Basic) {
					text = ((Basic) entry.getResource()).getText();
				} else {
					if (entry.getResource() instanceof Condition) {
						text = ((Condition) entry.getResource()).getText();
					} else {
						text = ((Observation) entry.getResource()).getText();
					}
				}
				if (text != null && text.getDiv().getValueAsString() != null) {
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
	 * Gets the specimen collection entry.
	 *
	 * @param bundle
	 *            the bundle
	 * @return the specimen collection entry
	 */
	public SpecimenCollectionEntry getSpecimenCollectionEntry(Bundle bundle) {
		for (final Entry entry : bundle.getEntry()) {
			// Get all LaboratorySpecialtySections
			List<ExtensionDt> specimenCollection = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsSpecimenCollection);
			if (specimenCollection != null && !specimenCollection.isEmpty()) {
				Observation obs = (Observation) entry.getResource();

				Identificator id = FhirCommon
						.fhirIdentifierToEhcIdentificator(obs.getIdentifierFirstRep());
				DateTimeDt date = (DateTimeDt) obs.getEffective();

				SpecimenCollectionEntry sce = new SpecimenCollectionEntry(date.getValue(), id,
						"ref");
				return sce;
			}
		}
		return null;
	}

	/**
	 * Gets the specimen received entry.
	 *
	 * @param bundle
	 *            the bundle
	 * @return the specimen received entry
	 */
	public SpecimenReceivedEntry getSpecimenReceivedEntry(Bundle bundle) {
		for (final Entry entry : bundle.getEntry()) {
			// Get all LaboratorySpecialtySections
			List<ExtensionDt> specimenReceived = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsSpecimenReceived);
			if (specimenReceived != null && !specimenReceived.isEmpty()) {
				Observation obs = (Observation) entry.getResource();
				SpecimenReceivedEntry sce = new SpecimenReceivedEntry();

				Identificator id = FhirCommon
						.fhirIdentifierToEhcIdentificator(obs.getIdentifierFirstRep());
				if (id != null) {
					sce.addId(id);
				}
				DateTimeDt fDate = (DateTimeDt) obs.getEffective();
				if (fDate != null) {
					Date date = fDate.getValue();
					sce.setEffectiveTime(date);
				}

				return sce;
			}
		}
		return null;
	}

	public String getValueFromKeyValueString(NarrativeDt text, String key) {
		if (text == null || text.getDivAsString() == null)
			return null;
		if (!text.getDivAsString().contains(key))
			return null;
		String[] lines = text.getDivAsString().split("\n");
		for (String line : lines) {
			if (line.contains(key)) {
				String[] keyValue = line.split("=");
				String value = keyValue[2].replace("</div>", "");
				return value;
			}
		}
		return null;
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

	private Observation createComment(String comment) {

		final Observation fhirObservation = new Observation();
		fhirObservation.setStatus(ObservationStatusEnum.UNKNOWN_STATUS);

		final CodeableConceptDt fhirCode = new CodeableConceptDt();
		fhirCode.addCoding().setSystem("urn:oid:2.16.840.1.113883.6.1").setCode("48767-8");
		fhirObservation.setCode(fhirCode);
		fhirObservation.setComments(comment);

		return fhirObservation;
	}
}
