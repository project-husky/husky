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
package org.projecthusky.communication.requests.pix;

import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.mpi.impl.pix.V3PixSourceMessageHelper;
import org.projecthusky.communication.utils.ConverterUtil;
import org.projecthusky.communication.utils.PixPdqV3Utils;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.fhir.structures.gen.FhirPatient;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02Type;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Citizen;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Employee;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02LanguageCommunication;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Nation;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientPatientPerson;

/**
 * This class is designed to contain the properties of a Patient (closely: {@link FhirPatient}) to be updated in the system. <br/>
 * All properties provided will overwrite or create the given properties existing in the system. <br/>
 * The minimal properties for an update request are a proper {@link Destination}, {@link #scopingOrganization} and the two IDs by which the Patient to update is identified.<br/>
 * <b>Warning!</b><br/>
 * <b>Not provided properties</b> will be seen by the webservice as an <b>update to a null value</b>! Meaning when a minimal request (containing only the minimal required parameters)
 * is issued and no formal errors, then any other properties already present in the system will be removed, except the provided minimal props (organization, 2x IDs).
 * Yes, this means this request type is essentially a REPLACE operation at the moment, not a partial update.
 * @author szalai
 */
@Builder
@Getter
@ToString
public class PixUpdatePatientFeed {
	@NonNull
	private Destination destination;
	/** Use providingOrganization instead */
	@Deprecated
	private Organization scopingOrganization;
	private Organization providerOrganization;
	private String homeCommunityOID;
	private String homeCommunityNamespace;

	@Singular
	private List<Identifier> identifiers;
	@Singular
	private List<Identifier> nonMedicalIdentifiers; //The "otherOIDs" feature from PixPdqQuery
	private HumanName patientName;
	private Date birthday;
	private AdministrativeGender gender;
	private HumanName mothersMaidenName;
	@Singular
	private List<Address> addresses;
	private CodeableConcept nation;
	private CodeableConcept religion;
	private CodeableConcept maritalStatus;
	@Singular
	private List<CodeableConcept> languages;
	@Singular
	private List<ContactPoint> telecomContacts;
	private CodeableConcept employeeOccupation;
	
	public static class PixUpdatePatientFeedBuilder {}

	public PixUpdatePatientRequest build() {
		PixUpdatePatientRequest request = new PixUpdatePatientRequest(this.destination.getSenderApplicationOid(), null, this.destination.getReceiverApplicationOid(), null);
		addIdentifiers(request);
		addNonMedicalIdentifiers(request);
		addPatientName(request);
		addPatientBirthday(request);
		addPatientGender(request);
		addPatientsMothersMaidenName(request);
		addAddresses(request);
		addNation(request);
		addReligion(request);
		addMaritalStatus(request);
		addLanguages(request);
		addTelecomContacts(request);
		addProviderOrganization(request);
		addEmployeeOccupation(request);
		return request;
	}

	private void addEmployeeOccupation(PixUpdatePatientRequest request) {
		PRPAIN201302UV02Type rootElement = request.getRootElement();
		PRPAMT201302UV02PatientPatientPerson patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
				.getSubject1().getPatient().getPatientPerson();

		if (this.employeeOccupation != null) {
			var employee = new PRPAMT201302UV02Employee();
			employee.setOccupationCode(PixPdqV3Utils.createCE(employeeOccupation.getText()));
			patientPerson.getAsEmployee().add(employee);
		}
	}

	private void addProviderOrganization(PixUpdatePatientRequest request) {
	    if (providerOrganization == null && scopingOrganization != null) {
	      providerOrganization = scopingOrganization;
	    }

	    if (providerOrganization != null) {
	      String organizationName = "";
	      String telecomValue = "NOTPROVIDED";
	      
	      if (providerOrganization.getName() != null) {
	        organizationName = providerOrganization.getName();
	      }

	      if (providerOrganization.getTelecom() != null && !providerOrganization.getTelecom().isEmpty()) {
	        var contactPoint = providerOrganization.getTelecomFirstRep();
	        if (contactPoint != null) {
	          telecomValue = contactPoint.getValue();
	        }
	      }
	      request.setProviderOrganization(providerOrganization.getIdentifier(), organizationName, telecomValue);
	    }
	  }

	private void addTelecomContacts(PixUpdatePatientRequest request) {
		PRPAIN201302UV02Type rootElement = request.getRootElement();
		PRPAMT201302UV02PatientPatientPerson patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
				.getSubject1().getPatient().getPatientPerson();

		for (ContactPoint contactPoint: this.telecomContacts) {
			patientPerson.getTelecom().add(V3PixSourceMessageHelper.createTEL(ConverterUtil.getTelecomValue(contactPoint), ConverterUtil.getTelecomAddressUse(contactPoint)));
		}

	}

	private void addLanguages(PixUpdatePatientRequest request) {
		PRPAIN201302UV02Type rootElement = request.getRootElement();
		PRPAMT201302UV02PatientPatientPerson patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
				.getSubject1().getPatient().getPatientPerson();

		for (CodeableConcept language: this.languages) {
			var communication = new PRPAMT201302UV02LanguageCommunication();
			communication.setLanguageCode(PixPdqV3Utils.createCE(new PatientCommunicationComponent().setLanguage(language).getLanguage().getText()));
			patientPerson.getLanguageCommunication().add(communication);
		}

	}

	private void addMaritalStatus(PixUpdatePatientRequest request) {
		if (this.maritalStatus != null) {
			request.setPatientMaritalStatus(maritalStatus.getCodingFirstRep().getCode());
		}
	}

	private void addReligion(PixUpdatePatientRequest request) {
		if (this.religion != null) {
			request.setPatientReligiousAffiliation(religion.getText());
		}
	}

	private void addNation(PixUpdatePatientRequest request) {
		if (this.nation != null) {
			PRPAIN201302UV02Type rootElement = request.getRootElement();
			PRPAMT201302UV02PatientPatientPerson patientPerson = rootElement.getControlActProcess().getSubject().get(0).getRegistrationEvent()
					.getSubject1().getPatient().getPatientPerson();
			var citizen = new PRPAMT201302UV02Citizen();
			var citizenNation = new PRPAMT201302UV02Nation();
			citizen.setPoliticalNation(citizenNation);
			citizenNation.setCode(PixPdqV3Utils.createCE(nation.getText()));
			patientPerson.getAsCitizen().add(citizen);
		}
	}

	private void addAddresses(PixUpdatePatientRequest request) {
		for (Address address: this.addresses) {
			request.addPatientAddress(PixPdqV3Utils.createAd(address));
		}
	}

	private void addPatientsMothersMaidenName(PixUpdatePatientRequest request) {
		if (this.mothersMaidenName != null) {
			request.setPatientMothersMaidenName(mothersMaidenName.getFamily(), mothersMaidenName.getGivenAsSingleString(), null,
					mothersMaidenName.getPrefixAsSingleString(), mothersMaidenName.getSuffixAsSingleString());
		}
	}

	private void addPatientGender(PixUpdatePatientRequest request) {
		if (this.gender != null) {
			request.setPatientGender(ConverterUtil.convertAdministrativeGenderToSingleCharString(gender));
		}
	}

	private void addPatientBirthday(PixUpdatePatientRequest request) {
		if (this.birthday != null) {
			DateType birthdate = new DateType();
			birthdate.setValue(this.birthday);
			request.setPatientBirthTime(birthdate.getValueAsString().replace("-", ""));
		}
	}

	private void addPatientName(PixUpdatePatientRequest request) {
		if (this.patientName != null) {
			request.addPatientName(this.patientName.getFamily(), this.patientName.getGivenAsSingleString(), null,
					this.patientName.getPrefixAsSingleString(), this.patientName.getSuffixAsSingleString());
		}
	}

	private void addNonMedicalIdentifiers(PixUpdatePatientRequest request) {
		for (Identifier identifier: this.nonMedicalIdentifiers) {
			if ((identifier.getSystem().length() > 8)) {
				String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
				request.addPatientOtherID(identifier.getValue(), oid);
			}
		}

	}

	private void addIdentifiers(PixUpdatePatientRequest request) {
		for (Identifier identifier: this.identifiers) {
			if ((identifier.getSystem().length() > 8)) {
				String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
				if (this.homeCommunityOID != null && this.homeCommunityOID.equals(oid)) {
					request.addPatientID(identifier.getValue(), this.homeCommunityOID, this.homeCommunityNamespace);
				} else {
					request.addPatientID(identifier.getValue(), oid, "");
				}
			}
		}
	}

}
