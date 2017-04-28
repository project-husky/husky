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
package org.ehealth_connector.communication.mpi.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.ehealth_connector.communication.mpi.MpiQuery;
import org.hl7.fhir.dstu3.model.ContactPoint;
import org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.v3.PRPAMT201306UV02PatientTelecom;
import org.hl7.v3.TEL;
import org.hl7.v3.V3Factory;
import org.openhealthtools.ihe.common.hl7v3.client.PixPdqV3Utils;
import org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerQuery;
import org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	 * @param Address
	 *            the address to be queried for
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientAddress(org.hl7.fhir.dstu3.model.Address Address) {
		if (Address == null) {
			log.error("Address not specified");
			return this;
		}

		String addressStreetAddress = null;
		if (Address.getLine().size() > 0) {
			addressStreetAddress = Address.getLine().get(0).getValueAsString();
		}

		String addressOtherDesignation = null;
		if (Address.getLine().size() > 1) {
			addressOtherDesignation = Address.getLine().get(1).getValueAsString();
		}

		// H, W WP
		String addressType = null;
		if ((Address.getUseElement() != null) && (Address.getUseElement().getValue() != null)) {
			switch (Address.getUseElement().getValue()) {
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
		v3PdqConsumerQuery.addPatientAddress(addressStreetAddress, Address.getCity(), null,
				Address.getState(), Address.getCountry(), Address.getPostalCode(),
				addressOtherDesignation, addressType);
		return this;
	}

	/**
	 * Adds a patient identifier to be queried for
	 *
	 * @param Identifier
	 *            patient identifier
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientIdentifier(Identifier Identifier) {
		if ((Identifier != null) && (Identifier.getSystem().length() > 8)
				&& (Identifier.getSystem().startsWith("urn:oid:"))) {
			final String oid = Identifier.getSystem().substring(8);
			v3PdqConsumerQuery.addPatientID(oid, Identifier.getValue(), "");
		} else {
			log.error("identifier system is not starting with urn:oid: " + Identifier.getSystem());
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
	 * @param ContactPoint
	 *            telecom
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientTelecom(ContactPoint ContactPoint) {
		if (ContactPoint == null) {
			log.error("ContactPoint not specified");
			return this;
		}
		if (ContactPointSystem.PHONE.equals(ContactPoint.getSystemElement().getValue())) {
			String use = "";
			if (ContactPointUse.HOME.equals(ContactPoint.getUseElement().getValue())) {
				use = "HP";
			} else if (ContactPointUse.WORK.equals(ContactPoint.getUseElement().getValue())) {
				use = "WP";
			}
			// else if
			// (ContactPointUse.MOBILE.equals(ContactPoint.getUseElement().getValue()))
			// {
			// }
			addPatientTelecom(ContactPoint.getValue(), use);
		} else {
			log.error(
					"no phone specified as telecom " + ContactPoint.getSystemElement().getValue());
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
		final PRPAMT201306UV02PatientTelecom patientTel = V3Factory.eINSTANCE
				.createPRPAMT201306UV02PatientTelecom();
		final TEL tel = PixPdqV3Utils.createTEL(telecom, type);
		patientTel.getValue().add(tel);
		patientTel.setSemanticsText(PixPdqV3Utils.createST1("Patient.telecom"));
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
	protected boolean doCancelQuery() {
		return cancelQuery;
	}

	/**
	 * if query should be continued
	 *
	 * @return true continue next query
	 */
	protected boolean doContinueQuery() {
		return continueQuery;
	}

	/**
	 * Gets the last pdq consumer response.
	 *
	 * @return the last pdq consumer response
	 */
	protected V3PdqConsumerResponse getLastPdqConsumerResponse() {
		return lastPdqConsumerResponse;
	}

	/**
	 * gets the page count for partial lists of search results
	 * (QueryByParameter.initialQuantity).
	 *
	 * @return the page count
	 */
	protected int getPageCount() {
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
	protected void setLastPdqConsumerResponse(V3PdqConsumerResponse lastPdqConsumerResponse) {
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
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
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
