package org.ehealth_connector.communication.mpi.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.mpi.MpiQuery;
import org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerQuery;

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

	public V3PdqQuery(String senderApplicationOID, String senderFacilityOID,
			String receiverApplicationOID, String receiverFacilityOID) {
		v3PdqConsumerQuery = new V3PdqConsumerQuery(senderApplicationOID, senderFacilityOID,
				receiverApplicationOID, receiverFacilityOID);
	}

	@Override
	public MpiQuery addPatientIdentifier(IdentifierDt identifierDt) {
		if (identifierDt != null && identifierDt.getSystem().length() > 8
				&& (identifierDt.getSystem().startsWith("urn:oid:"))) {
			String oid = identifierDt.getSystem().substring(8);
			v3PdqConsumerQuery.addPatientID(identifierDt.getValue(), oid, "");
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
	public MpiQuery setPatientSex(AdministrativeGenderEnum adminstrativeGenderEnum) {
		if (adminstrativeGenderEnum.equals(AdministrativeGenderEnum.FEMALE.getCode())) {
			v3PdqConsumerQuery.setPatientSex("F");
		} else if (adminstrativeGenderEnum.equals(AdministrativeGenderEnum.MALE.getCode())) {
			v3PdqConsumerQuery.setPatientSex("M");
		} else if (adminstrativeGenderEnum.equals(AdministrativeGenderEnum.OTHER.getCode())) {
			v3PdqConsumerQuery.setPatientSex("U");
		}
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
	public MpiQuery addMothersMaidenName(boolean useFuzzySearch, HumanNameDt humanDt) {
		v3PdqConsumerQuery.addPatientName(useFuzzySearch, humanDt.getFamilyAsSingleString(),
				humanDt.getGivenAsSingleString(), null, humanDt.getSuffixAsSingleString(),
				humanDt.getPrefixAsSingleString());
		return this;
	}

	@Override
	public MpiQuery addPatientTelecom(ContactPointDt contactPointDt) {
		if (contactPointDt == null) {
			log.error("contactPointDt not specified");
			return null;
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
			v3PdqConsumerQuery.addPatientTelecom(contactPointDt.getValue(), use);
		} else {
			log.error("no phone specified as telecom "
					+ contactPointDt.getSystemElement().getValueAsEnum());
		}
		return this;
	}

	@Override
	public MpiQuery cancelQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MpiQuery setPageCount(int pageCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public V3PdqConsumerQuery getV3PdqConsumerQuery() {
		return v3PdqConsumerQuery;
	}

}
