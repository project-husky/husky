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

public class V3PdqQuery implements MpiQuery {

	private final Log log = LogFactory.getLog(V3PdqQuery.class);

	private final V3PdqConsumerQuery v3PdqConsumerQuery;

	private boolean cancelQuery;
	private boolean continueQuery;
	private int pageCount;

	private V3PdqConsumerResponse lastPdqConsumerResponse;

	public V3PdqQuery(String senderApplicationOID, String senderFacilityOID,
			String receiverApplicationOID, String receiverFacilityOID) {
		v3PdqConsumerQuery = new V3PdqConsumerQuery(senderApplicationOID, senderFacilityOID,
				receiverApplicationOID, receiverFacilityOID);
	}

	@Override
	public MpiQuery addDomainToReturn(String organizationOID) {
		if (organizationOID != null) {
			v3PdqConsumerQuery.addDomainToReturn(organizationOID);
		}
		return this;
	}

	@Override
	public MpiQuery addMothersMaidenName(boolean useFuzzySearch, HumanNameDt humanDt) {
		v3PdqConsumerQuery.addPatientMothersMaidenName(useFuzzySearch,
				humanDt.getFamilyAsSingleString(), humanDt.getGivenAsSingleString(), null,
				humanDt.getSuffixAsSingleString(), humanDt.getPrefixAsSingleString());
		return this;
	}

	@Override
	@SuppressWarnings("incomplete-switch")
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
			}
		}
		v3PdqConsumerQuery.addPatientAddress(addressStreetAddress, addressDt.getCity(), null,
				addressDt.getState(), addressDt.getCountry(), addressDt.getPostalCode(),
				addressOtherDesignation, addressType);
		return this;
	}

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

	@Override
	public MpiQuery addPatientName(boolean useFuzzySearch, HumanNameDt humanDt) {
		v3PdqConsumerQuery.addPatientName(useFuzzySearch, humanDt.getFamilyAsSingleString(),
				humanDt.getGivenAsSingleString(), null, humanDt.getSuffixAsSingleString(),
				humanDt.getPrefixAsSingleString());
		return this;
	}

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
	 * Add a patient telecom value of the supplied type. OHT method is missing
	 * <semanticsText>Patient.telecom</semanticsText>
	 * 
	 * @param telecom
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

	@Override
	public MpiQuery cancelQuery() {
		this.cancelQuery = true;
		return this;
	}

	@Override
	public MpiQuery continueQuery() {
		this.continueQuery = true;
		return this;
	}

	public boolean doCancelQuery() {
		return cancelQuery;
	}

	public boolean doContinueQuery() {
		return continueQuery;
	}

	public V3PdqConsumerResponse getLastPdqConsumerResponse() {
		return lastPdqConsumerResponse;
	}

	public int getPageCount() {
		return pageCount;
	}

	public V3PdqConsumerQuery getV3PdqConsumerQuery() {
		return v3PdqConsumerQuery;
	}

	public void setLastPdqConsumerResponse(V3PdqConsumerResponse lastPdqConsumerResponse) {
		this.lastPdqConsumerResponse = lastPdqConsumerResponse;
	}

	@Override
	public MpiQuery setPageCount(int pageCount) {
		this.pageCount = pageCount;
		v3PdqConsumerQuery.setInitialQuantity(pageCount);
		return this;
	}

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

}
