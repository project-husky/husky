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
package org.ehealth_connector.communication.mpi.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.mpi.MpiQuery;
import org.hl7.v3.PRPAMT201306UV02PatientTelecom;
import org.hl7.v3.TEL;
import org.hl7.v3.V3Factory;
import org.openhealthtools.ihe.common.hl7v3.client.PixPdqV3Utils;
import org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerQuery;
import org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerResponse;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;

/**
 * The class V3PdqQuery implements the MpiQuery functionality for the Patient
 * Demographics Query (PDQ) ITI-47.
 */
public class V3PdqQuery implements MpiQuery {

	/** cancels the next Query */
	private boolean cancelQuery;

	/** continues the query. */
	private boolean continueQuery;

	/** OHT consumer query response */
	private V3PdqConsumerResponse lastPdqConsumerResponse;

	/** logging */
	private final Log log = LogFactory.getLog(V3PdqQuery.class);

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
	public MpiQuery addMothersMaidenName(boolean useFuzzySearch, HumanNameDt humanDt) {
		v3PdqConsumerQuery.addPatientMothersMaidenName(useFuzzySearch,
				humanDt.getFamilyAsSingleString(), humanDt.getGivenAsSingleString(), null,
				humanDt.getSuffixAsSingleString(), humanDt.getPrefixAsSingleString());
		return this;
	}

	/**
	 * Adds a patient address to the query.
	 *
	 * @param addressDt
	 *            the address to be queried for
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientAddress(AddressDt addressDt) {
		if (addressDt == null) {
			log.error("addressDt not specified");
			return this;
		}

		String addressStreetAddress = null;
		if (addressDt.getLine().size() > 0) {
			addressStreetAddress = addressDt.getLine().get(0).getValueAsString();
		}

		String addressOtherDesignation = null;
		if (addressDt.getLine().size() > 1) {
			addressOtherDesignation = addressDt.getLine().get(1).getValueAsString();
		}

		// H, W WP
		String addressType = null;
		if (addressDt.getUseElement() != null
				&& addressDt.getUseElement().getValueAsEnum() != null) {
			switch (addressDt.getUseElement().getValueAsEnum()) {
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
		v3PdqConsumerQuery.addPatientAddress(addressStreetAddress, addressDt.getCity(), null,
				addressDt.getState(), addressDt.getCountry(), addressDt.getPostalCode(),
				addressOtherDesignation, addressType);
		return this;
	}

	/**
	 * Adds a patient identifier to be queried for
	 *
	 * @param identifierDt
	 *            patient identifier
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientIdentifier(IdentifierDt identifierDt) {
		if (identifierDt != null && identifierDt.getSystem().length() > 8
				&& (identifierDt.getSystem().startsWith("urn:oid:"))) {
			String oid = identifierDt.getSystem().substring(8);
			v3PdqConsumerQuery.addPatientID(oid, identifierDt.getValue(), "");
		} else {
			log.error(
					"identifier system is not starting with urn:oid: " + identifierDt.getSystem());
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
	public MpiQuery addPatientName(boolean useFuzzySearch, HumanNameDt humanDt) {
		v3PdqConsumerQuery.addPatientName(useFuzzySearch, humanDt.getFamilyAsSingleString(),
				humanDt.getGivenAsSingleString(), null, humanDt.getSuffixAsSingleString(),
				humanDt.getPrefixAsSingleString());
		return this;
	}

	/**
	 * Adds a patient telecom to be queried for.
	 *
	 * @param contactPointDt
	 *            telecom
	 * @return the query object
	 */
	@Override
	public MpiQuery addPatientTelecom(ContactPointDt contactPointDt) {
		if (contactPointDt == null) {
			log.error("contactPointDt not specified");
			return this;
		}
		if (ContactPointSystemEnum.PHONE
				.equals(contactPointDt.getSystemElement().getValueAsEnum())) {
			String use = "";
			if (ContactPointUseEnum.HOME.equals(contactPointDt.getUseElement().getValueAsEnum())) {
				use = "HP";
			} else if (ContactPointUseEnum.WORK
					.equals(contactPointDt.getUseElement().getValueAsEnum())) {
				use = "WP";
			} else if (ContactPointUseEnum.MOBILE
					.equals(contactPointDt.getUseElement().getValueAsEnum())) {
			}
			addPatientTelecom(contactPointDt.getValue(), use);
		} else {
			log.error("no phone specified as telecom "
					+ contactPointDt.getSystemElement().getValueAsEnum());
		}
		return this;
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
	 * Gets the v3 consumer query object.
	 *
	 * @return the v3 pdq consumer query
	 */
	public V3PdqConsumerQuery getV3PdqConsumerQuery() {
		return v3PdqConsumerQuery;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		v3PdqConsumerQuery.setPatientDateOfBirth(sdf.format(date));
		return this;
	}

	/**
	 * Sets the patient sex for the query.
	 *
	 * @param adminstrativeGenderEnum
	 *            gender
	 * @return the query object
	 */
	@Override
	public MpiQuery setPatientSex(AdministrativeGenderEnum adminstrativeGenderEnum) {
		if (adminstrativeGenderEnum == null) {
			log.error("adminstrativeGenderEnum not specified");
			return this;
		}
		if (adminstrativeGenderEnum.equals(AdministrativeGenderEnum.FEMALE)) {
			v3PdqConsumerQuery.setPatientSex("F");
		} else if (adminstrativeGenderEnum.equals(AdministrativeGenderEnum.MALE)) {
			v3PdqConsumerQuery.setPatientSex("M");
		} else if (adminstrativeGenderEnum.equals(AdministrativeGenderEnum.OTHER)) {
			v3PdqConsumerQuery.setPatientSex("U");
		}
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
	 * Sets the pdq consumer response.
	 *
	 * @param lastPdqConsumerResponse
	 *            the new last pdq consumer response
	 */
	protected void setLastPdqConsumerResponse(V3PdqConsumerResponse lastPdqConsumerResponse) {
		this.lastPdqConsumerResponse = lastPdqConsumerResponse;
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
		PRPAMT201306UV02PatientTelecom patientTel = V3Factory.eINSTANCE
				.createPRPAMT201306UV02PatientTelecom();
		TEL tel = PixPdqV3Utils.createTEL(telecom, type);
		patientTel.getValue().add(tel);
		patientTel.setSemanticsText(PixPdqV3Utils.createST1("Patient.telecom"));
		v3PdqConsumerQuery.getParameterList().getPatientTelecom().add(patientTel);
	}

}
