/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.communication.mpi.impl.pdq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.husky.communication.mpi.MpiQuery;
import org.husky.communication.utils.PixPdqV3Utils;
import org.husky.fhir.structures.gen.FhirCommon;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom;

/**
 * The class V3PdqQuery implements the MpiQuery functionality for the Patient
 * Demographics Query (PDQ) ITI-47.
 */
public class V3PdqQuery implements MpiQuery {

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** cancels the next Query */
	private boolean cancelQuery;

	/** continues the query. */
	private boolean continueQuery;

	/** OHT consumer query response */
	private V3PdqConsumerResponse lastPdqConsumerResponse;

	/** limit query results size. */
	private int pageCount;

	/** OTH consumer query object */
	private final V3PdqConsumerQuery v3PdqConsumerQuery;

	/**
	 * Instantiates a new v3 pdq query.
	 *
	 * @param senderApplicationOID
	 *            the sender application oid
	 * @param senderFacilityOID
	 *            the sender facility oid
	 * @param receiverApplicationOID
	 *            the receiver application oid
	 * @param receiverFacilityOID
	 *            the receiver facility oid
	 */
	public V3PdqQuery(String senderApplicationOID, String senderFacilityOID,
			String receiverApplicationOID, String receiverFacilityOID) {
		v3PdqConsumerQuery = new V3PdqConsumerQuery(senderApplicationOID, senderFacilityOID,
				receiverApplicationOID, receiverFacilityOID);
	}

	/**
	 * Returned patient identifiers will include the added domain if available
	 *
	 * @param organizationOID
	 *            the organization oid
	 * @return the query object
	 */
	@Override
	public MpiQuery addDomainToReturn(String organizationOID) {
		if (organizationOID != null) {
			v3PdqConsumerQuery.addDomainToReturn(organizationOID);
		}
		return this;
	}

	/**
	 * Adds the mothers maiden name the query
	 *
	 * @param useFuzzySearch
	 *            if true does not require an exact match, see Table
	 *            3.47.4.1.2-1: Model Attributes (ITI TF-2b)
	 * @param humanDt
	 *            name
	 * @return the query object
	 */
	@Override
	public MpiQuery addMothersMaidenName(boolean useFuzzySearch, HumanName humanDt) {
		v3PdqConsumerQuery.addPatientMothersMaidenName(useFuzzySearch, humanDt.getFamily(),
				humanDt.getGivenAsSingleString(), null, humanDt.getSuffixAsSingleString(),
				humanDt.getPrefixAsSingleString());
		return this;
	}

	/**
	 * Adds a patient address to the query.
	 *
	 * @param address
	 *            the address to be queried for
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientAddress(org.hl7.fhir.r4.model.Address address) {
		if (address == null) {
			log.error("Address not specified");
			return this;
		}

		String addressStreetAddress = null;
		if (!address.getLine().isEmpty()) {
			addressStreetAddress = address.getLine().get(0).getValueAsString();
		}

		String addressOtherDesignation = null;
		if (address.getLine().size() > 1) {
			addressOtherDesignation = address.getLine().get(1).getValueAsString();
		}

		// H, W WP
		String addressType = null;
		if ((address.getUseElement() != null) && (address.getUseElement().getValue() != null)) {
			switch (address.getUseElement().getValue()) {
			case HOME:
				addressType = "H";
				break;
			case WORK:
				addressType = "WP";
				break;
			default:
				break;
			}
		}
		v3PdqConsumerQuery.addPatientAddress(addressStreetAddress, address.getCity(), null, address.getState(),
				address.getCountry(), address.getPostalCode(),
				addressOtherDesignation, addressType);
		return this;
	}

	/**
	 * Adds a patient identifier to be queried for
	 *
	 * @param identifier
	 *            patient identifier
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientIdentifier(Identifier identifier) {
		if (identifier != null && identifier.getSystem() != null && identifier.getSystem().length() > 8
				&& identifier.getSystem().startsWith(FhirCommon.OID_URN)) {
			final String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
			v3PdqConsumerQuery.addPatientID(oid, identifier.getValue(), "");
		} else if (identifier != null) {
			v3PdqConsumerQuery.addPatientID(identifier.getSystem(), identifier.getValue(), "");
		}
		return this;
	}

	/**
	 * Adds a patient name to the query.
	 *
	 * @param useFuzzySearch
	 *            if true does not require an exact match, see Table
	 *            3.47.4.1.2-1: Model Attributes (ITI TF-2b)
	 * @param humanDt
	 *            name
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientName(boolean useFuzzySearch, HumanName humanDt) {
		v3PdqConsumerQuery.addPatientName(useFuzzySearch, humanDt.getFamily(),
				humanDt.getGivenAsSingleString(), null, humanDt.getSuffixAsSingleString(),
				humanDt.getPrefixAsSingleString());
		return this;
	}

	/**
	 * Adds a patient telecom to be queried for.
	 *
	 * @param contactPoint
	 *            telecom
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientTelecom(ContactPoint contactPoint) {
		if (contactPoint == null) {
			log.error("ContactPoint not specified");
			return this;
		}
		if (ContactPointSystem.PHONE.equals(contactPoint.getSystemElement().getValue())) {
			var use = "";
			if (ContactPointUse.HOME.equals(contactPoint.getUseElement().getValue())) {
				use = "HP";
			} else if (ContactPointUse.WORK.equals(contactPoint.getUseElement().getValue())) {
				use = "WP";
			}
			addPatientTelecom(contactPoint.getValue(), use);
		} else {
			log.error(
					"no phone specified as telecom {}", contactPoint.getSystemElement().getValue());
		}
		return this;
	}

	/**
	 * Add a patient telecom value of the supplied type. OHT method is missing
	 * <semanticsText>Patient.telecom</semanticsText>
	 *
	 * @param telecom
	 *            the telecom
	 * @param type
	 *            ("HP" or "WP"
	 */
	private void addPatientTelecom(String telecom, String type) {
		final var patientTel = new PRPAMT201306UV02PatientTelecom();
		final var tel = PixPdqV3Utils.createTEL(telecom, type);
		patientTel.getValue().add(tel);
		patientTel.setSemanticsText(PixPdqV3Utils.createST("Patient.telecom"));
		v3PdqConsumerQuery.getParameterList().getPatientTelecom().add(patientTel);
	}

	/**
	 * Cancels the next query.
	 *
	 * @return the query object
	 */
	@Override
	public MpiQuery cancelQuery() {
		this.cancelQuery = true;
		return this;
	}

	/**
	 * Continues query for the next pageCount results.
	 *
	 * @return continues the query for the next batch
	 */
	@Override
	public MpiQuery continueQuery() {
		this.continueQuery = true;
		return this;
	}

	/**
	 * if query should be canceled
	 *
	 * @return true cancel next query
	 */
	public boolean doCancelQuery() {
		return cancelQuery;
	}

	/**
	 * if query should be continued
	 *
	 * @return true continue next query
	 */
	public boolean doContinueQuery() {
		return continueQuery;
	}

	/**
	 * Gets the last pdq consumer response.
	 *
	 * @return the last pdq consumer response
	 */
	public V3PdqConsumerResponse getLastPdqConsumerResponse() {
		return lastPdqConsumerResponse;
	}

	/**
	 * gets the page count for partial lists of search results
	 * (QueryByParameter.initialQuantity).
	 *
	 * @return the page count
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * Gets the v3 consumer query object.
	 *
	 * @return the v3 pdq consumer query
	 */
	public V3PdqConsumerQuery getV3PdqConsumerQuery() {
		return v3PdqConsumerQuery;
	}

	/**
	 * Sets the pdq consumer response.
	 *
	 * @param lastPdqConsumerResponse
	 *            the new last pdq consumer response
	 */
	public void setLastPdqConsumerResponse(V3PdqConsumerResponse lastPdqConsumerResponse) {
		this.lastPdqConsumerResponse = lastPdqConsumerResponse;
	}

	/**
	 * Sets the page count for partial lists of search results
	 * (QueryByParameter.initialQuantity).
	 *
	 * @param pageCount
	 *            the page count
	 * @return the query object
	 */
	@Override
	public MpiQuery setPageCount(int pageCount) {
		this.pageCount = pageCount;
		v3PdqConsumerQuery.setInitialQuantity(pageCount);
		return this;
	}

	/**
	 * Sets the patient birth date for the query.
	 *
	 * @param date
	 *            the date
	 * @return the query object
	 */
	@Override
	public MpiQuery setPatientBirthDate(Date date) {
		if (date == null) {
			log.error("date not specified");
			return this;
		}
		final var sdf = new SimpleDateFormat("yyyyMMdd");
		v3PdqConsumerQuery.setPatientDateOfBirth(sdf.format(date));
		return this;
	}

	/**
	 * Sets the patient sex for the query.
	 *
	 * @param administrativeGender
	 *            gender
	 * @return the query object
	 */
	@Override
	public MpiQuery setPatientSex(AdministrativeGender administrativeGender) {
		if (administrativeGender == null) {
			log.error("adminstrativeGenderEnum not specified");
			return this;
		}
		if (administrativeGender.equals(AdministrativeGender.FEMALE)) {
			v3PdqConsumerQuery.setPatientSex("F");
		} else if (administrativeGender.equals(AdministrativeGender.MALE)) {
			v3PdqConsumerQuery.setPatientSex("M");
		} else if (administrativeGender.equals(AdministrativeGender.OTHER)) {
			v3PdqConsumerQuery.setPatientSex("U");
		}
		return this;
	}

}
