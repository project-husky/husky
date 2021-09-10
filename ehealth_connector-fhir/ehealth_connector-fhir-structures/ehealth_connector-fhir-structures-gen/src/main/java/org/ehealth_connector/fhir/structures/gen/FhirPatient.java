/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.fhir.structures.gen;

import java.util.Date;
import java.util.LinkedList;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Telecom;
import org.ehealth_connector.common.basetypes.AddressBaseType;
import org.ehealth_connector.common.basetypes.NameBaseType;
import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.enums.EntityNameUse;
import org.ehealth_connector.common.hl7cdar2.CE;
import org.ehealth_connector.common.hl7cdar2.CS;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Birthplace;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040LanguageCommunication;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Organization;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Place;
import org.ehealth_connector.common.mdht.enums.AdministrativeGender;
import org.ehealth_connector.common.utils.Util;
import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.ContactPoint;
import org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.HumanName.NameUse;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.IntegerType;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.Type;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The Class FhirPatient. FHIRPatient extends from the FHIR HAPI Patient
 * Resource and provides convenience methods to translate between the
 * convenience patient in the ehealthconeector and back
 *
 * @see "http://jamesagnew.github.io/hapi-fhir/index.html"
 */
@ResourceDef(name = "Patient")
public class FhirPatient extends org.hl7.fhir.dstu3.model.Patient {

	/**
	 *
	 */
	private static final long serialVersionUID = -1520681931095452610L;

	/**
	 * converts the mdht AD to the fhir address
	 *
	 * @param mdhtAddr
	 *            address object
	 * @return fhir address
	 */
	static public org.hl7.fhir.dstu3.model.Address convertAddress(org.ehealth_connector.common.Address mdhtAddr) {
		org.hl7.fhir.dstu3.model.Address fhirAddr = null;
		if (mdhtAddr != null) {
			fhirAddr = new org.hl7.fhir.dstu3.model.Address();
			if (mdhtAddr.getStreetAddressLine1() != null) {
				fhirAddr.addLine(mdhtAddr.getStreetAddressLine1());

				if (mdhtAddr.getCity() != null) {
					fhirAddr.setCity(mdhtAddr.getCity());
				}
				if (mdhtAddr.getPostalCode() != null) {
					fhirAddr.setPostalCode(mdhtAddr.getPostalCode());
				}
				if (mdhtAddr.getState() != null) {
					fhirAddr.setState(mdhtAddr.getState());
				}
				if (mdhtAddr.getCountry() != null) {
					fhirAddr.setCountry(mdhtAddr.getCountry());
				}
				if (mdhtAddr.getUsage() != null) {
					switch (mdhtAddr.getUsage()) {
					case HOME_ADDRESS, VACATION_HOME, PRIMARY_HOME:
						fhirAddr.setUse(org.hl7.fhir.dstu3.model.Address.AddressUse.HOME);
						break;
					case WORK_PLACE:
						fhirAddr.setUse(org.hl7.fhir.dstu3.model.Address.AddressUse.WORK);
						break;
					case TEMPORARY:
						fhirAddr.setUse(org.hl7.fhir.dstu3.model.Address.AddressUse.TEMP);
						break;
					case BAD_ADDRESS:
						fhirAddr.setUse(org.hl7.fhir.dstu3.model.Address.AddressUse.NULL);
						break;
					}

				}
			}
		}
		return fhirAddr;
	}

	/**
	 * Convert the cda gender to the fhir gender.
	 *
	 * @param gender
	 *            the gender
	 * @return the administrative gender enum
	 */
	static public org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender convertGender(
			AdministrativeGender gender) {
		if (gender != null) {
			if (gender.equals(AdministrativeGender.FEMALE)) {
				return org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE;
			} else if (gender.equals(AdministrativeGender.MALE)) {
				return org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.MALE;
			} else if (gender.equals(AdministrativeGender.UNDIFFERENTIATED)) {
				return org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.OTHER;
			}
		}
		return null;
	}

	/**
	 * Converts the convenience name to the fhir name
	 *
	 * @param name
	 *            the name
	 * @return converted name
	 */
	public static HumanName convertName(Name name) {
		if (name != null) {
			final var humanName = new HumanName();

			humanName.setUse(getNameUse(name.getUsage()));
			humanName.setFamily(name.getFamily());
			humanName.addGiven(name.getGiven());
			humanName.addPrefix(name.getPrefix());
			humanName.addSuffix(name.getSuffix());

			return humanName;
		}
		return null;
	}

	/**
	 * Allocates HL7 FHIR {@link NameUse} for passed name use. </br>
	 *
	 * <table border="1">
	 * <tr>
	 * <td><b>CDA R2</b></td>
	 * <td><b>HL7 FHIR</b></td>
	 * </tr>
	 * <tr>
	 * <td>L</td>
	 * <td>official</td>
	 * </tr>
	 * <tr>
	 * <td>P</td>
	 * <td>anonymous</td>
	 * </tr>
	 * </table>
	 *
	 * @param entityNameUse usage of name
	 *
	 * @return allocated value or {@link NameUse.<code>USUAL</code>} if no value can
	 *         be allocated
	 */
	private static NameUse getNameUse(EntityNameUse entityNameUse) {
		if (entityNameUse == null) {
			return null;
		}

		switch (entityNameUse) {
		case LEGAL:
			return NameUse.OFFICIAL;
		case PSEUDONYM:
			return NameUse.ANONYMOUS;
		default:
			return NameUse.USUAL;
		}
	}

	/**
	 * Convert telecom from hl7 datatype to fhir datatpye.
	 *
	 * @param tel
	 *            hl7 data type
	 * @return the fhir data type
	 */
	public static ContactPoint convertTelecom(Telecom tel) {
		if (tel == null) {
			return null;
		}
		final var contactPoint = new ContactPoint();
		String value = null;
		ContactPointSystem system = null;
		ContactPointUse use = null;
		if ((tel.getValue().length() > 4) && tel.getValue().startsWith("tel:")) {
			value = tel.getValue().substring(4);
			system = ContactPointSystem.PHONE;
		} else if ((tel.getValue().length() > 4) && tel.getValue().startsWith("mailto:")) {
			value = tel.getValue().substring(7);
			system = ContactPointSystem.EMAIL;
		}
		if (tel.getUsage() != null ) {
			
			switch (tel.getUsage())		{
			case BAD:
				use = ContactPointUse.NULL;
				break;
			case BUSINESS:
				use = ContactPointUse.WORK;
				break;
			case BUSINESS_DIRECT:
				use = ContactPointUse.WORK;
				break;
			case MOBILE:
				use = ContactPointUse.MOBILE;
				break;
			case OLD:
				use = ContactPointUse.OLD;
				break;
			case PAGER:
				use = ContactPointUse.MOBILE;
				break;
			case PRIVATE:
				use = ContactPointUse.HOME;
				break;
			case PRIVATE_PRIMARY:
				use = ContactPointUse.HOME;
				break;
			case PRIVATE_VACATION:
				use = ContactPointUse.HOME;
				break;
			case TEMPORARY:
				use = ContactPointUse.TEMP;
				break;
			default:
				break;
			}
		}
			
		contactPoint.setSystem(system);
		contactPoint.setUse(use);
		contactPoint.setValue(value);
		return contactPoint;
	}

	@Child(name = "birthPlace")
	@Extension(url = "http://hl7.org/fhir/ExtensionDefinition/birthPlace", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The birtplace of the patientt")
	private org.hl7.fhir.dstu3.model.Address birthPlace;

	@Child(name = "employeeOccupation")
	@Extension(url = "http://www.ehealth-connector.org/fhir-extensions/employeeOccupation", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The employee OccupationCode of the patient")
	private CodeableConcept employeeOccupation;

	@Child(name = "nation")
	@Extension(url = "http://www.ehealth-connector.org/fhir-extensions/nation", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The nation of the patient")
	private CodeableConcept nation;

	@Child(name = "religiousAffiliation")
	@Extension(url = "http://hl7.org/fhir/ExtensionDefinition/us-core-religion", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The religious Affiliation of the patient")
	private CodeableConcept religiousAffiliation;

	/**
	 * Instantiates a new fhir patient.
	 */
	public FhirPatient() {

	}

	/**
	 * Instantiates a new fhir patient based on the
	 * org.ehealth_connector.common.patient
	 *
	 * @param patient
	 *            the patient
	 */
	public FhirPatient(Patient patient) {

		if (patient == null) {
			return;
		}

		if (patient.getNames() != null) {
			for (final Name name : patient.getNames()) {
				getName().add(convertName(name));
			}
		}

		if (patient.getBirthday() != null) {
			setBirthDate(patient.getBirthday());
		}

		if (patient.getAdministrativeGenderCode() != null) {
			setGender(convertGender(patient.getAdministrativeGenderCode()));
		}

		if (patient.getAddresses() != null && !patient.getAddresses().isEmpty()) {
			for (final org.ehealth_connector.common.Address address : patient.getAddresses()) {
				getAddress().add(convertAddress(address));
			}
		}
		for (final Identificator ident : patient.getIds()) {
			var id = new Identifier();
			id.setSystem(FhirCommon.addUrnOid(ident.getRoot()));
			id.setValue(ident.getExtension());
			this.getIdentifier().add(id);
		}
		final POCDMT000040Organization organization = patient.getMdhtPatientRole().getProviderOrganization();
		if (organization != null) {
			final var fhirOrganization = new org.hl7.fhir.dstu3.model.Organization();

			if (organization != null && organization.getId() != null
					&& !organization.getId().isEmpty()) {
				final var ii = organization.getId().get(0);
				final var identifier = new Identifier();
				identifier.setValue(ii.getExtension());
				identifier.setSystem(FhirCommon.addUrnOid(ii.getRoot()));
				fhirOrganization.getIdentifier().add(identifier);
			}

			if (organization.getName() != null && !organization.getName().isEmpty()) {
				final String name = organization.getName().get(0).xmlContent;
				fhirOrganization.setName(name);
			}

			if ((organization.getTelecom() != null) && !organization.getTelecom().isEmpty()) {
				final var tel = organization.getTelecom().get(0);
				final ContactPoint fhirTel = fhirOrganization.addTelecom();
				if (tel.getValue().startsWith("tel:")) {
					fhirTel.setValue(tel.getValue().substring(4));
				}
			}
			getManagingOrganization().setResource(fhirOrganization);
		}

		if (patient.getTelecoms() != null) {
			for (final Telecom tel : patient.getTelecoms()) {
				this.getTelecom().add(convertTelecom(tel));
			}
		}

		// languageCommunications
		if (!patient.getMdhtPatient().getLanguageCommunication().isEmpty()) {
			for (final POCDMT000040LanguageCommunication languageCommunication : patient.getMdhtPatient()
					.getLanguageCommunication()) {
				final var communication = new PatientCommunicationComponent();
				final var language = new CodeableConcept();
				language.setText(languageCommunication.getLanguageCode().getCode());
				communication.setLanguage(language);
				this.getCommunication().add(communication);
			}
		}

		// maritalStatus
		if (((patient.getMdhtPatient().getMaritalStatusCode() != null)
				&& (patient.getMdhtPatient().getMaritalStatusCode().getCode() != null))) {
			final var maritalStatus = new CodeableConcept();
			var code = new Coding();
			code.setCode(patient.getMdhtPatient().getMaritalStatusCode().getCode());
			code.setDisplay(patient.getMdhtPatient().getMaritalStatusCode().getDisplayName());
			maritalStatus.addCoding(code);
			this.setMaritalStatus(maritalStatus);
		}

		// deceasedBooolean
		if (patient.getDeceasedInd() != null) {
			setDeceased(new BooleanType(patient.getDeceasedInd()));
		}

		// deceasedDateTime
		if (patient.getDeceasedTime() != null) {
			setDeceased(new DateTimeType(patient.getDeceasedTime()));
		}

		// multipleBirthInd
		if (patient.getMultipleBirthInd() != null) {
			setMultipleBirth(new BooleanType(patient.getMultipleBirthInd()));
		}

		// multipleBirthOrder
		if (patient.getMultipleBirthOrderNumber() != null) {
			setMultipleBirth(new IntegerType(patient.getMultipleBirthOrderNumber()));
		}

		// mothersMaidenName
		if (patient.getMothersMaidenName() != null) {
			final var mothersMaidenName = new HumanName();
			mothersMaidenName.setFamily(patient.getMothersMaidenName());
			setMothersMaidenName(mothersMaidenName);
		}

		// birthplace
		if ((patient.getMdhtPatient().getBirthplace() != null)
				&& (patient.getMdhtPatient().getBirthplace().getPlace() != null)) {
			setBirthPlace(
					convertAddress(new org.ehealth_connector.common.Address(
							patient.getMdhtPatient().getBirthplace().getPlace().getAddr())));
		}

		// religiousAffiliation
		if (patient.getReligiousAffiliation() != null) {
			final var religiousaffiliation = new CodeableConcept();
			religiousaffiliation.setText(patient.getReligiousAffiliation());
			this.setReligiousAffiliation(religiousaffiliation);
		}

		// nationCode
		if (patient.getNation() != null) {
			final var nationCode = new CodeableConcept();
			nationCode.setText(patient.getNation());
			this.setNation(nationCode);
		}

		// employeeOccupationcode
		if (patient.getEmployeeOccupation() != null) {
			final var employeeOccupationCode = new CodeableConcept();
			employeeOccupationCode.setText(patient.getEmployeeOccupation());
			this.setEmployeeOccupation(employeeOccupationCode);
		}

	}

	/**
	 * converts the fhir address to the convenience address
	 *
	 * @param address
	 * @return fhir address
	 */
	private org.ehealth_connector.common.Address convertAddress(
			org.hl7.fhir.dstu3.model.Address fhirAddress) {
		if (fhirAddress == null) {
			return null;
		}

		var addressline1 = "";
		var addressline2 = "";

		if (fhirAddress.getLine().size() > 1) {
			addressline2 = fhirAddress.getLine().get(1).getValueAsString();
		}
		if (!fhirAddress.getLine().isEmpty()) {
			addressline1 = fhirAddress.getLine().get(0).getValueAsString();
		}

		var city = "";
		if (fhirAddress.getCity() != null) {
			city = fhirAddress.getCity();
		}
		var zip = "";
		if (fhirAddress.getPostalCode() != null) {
			zip = fhirAddress.getPostalCode();
		}

		org.ehealth_connector.common.enums.PostalAddressUse addressUse = null;
		if ((fhirAddress.getUseElement() != null)
				&& (fhirAddress.getUseElement().getValue() != null)) {
			switch (fhirAddress.getUseElement().getValue()) {
			case HOME:
				addressUse = org.ehealth_connector.common.enums.PostalAddressUse.PRIMARY_HOME;
				break;
			case WORK:
				addressUse = org.ehealth_connector.common.enums.PostalAddressUse.WORK_PLACE;
				break;
			default:
				break;
			}
		}
		final var patientAddress = new org.ehealth_connector.common.Address(new AddressBaseType());
		patientAddress.setStreetAddressLine1(addressline1);
		patientAddress.setStreetAddressLine2(addressline2);
		patientAddress.setPostalCode(zip);
		patientAddress.setCity(city);
		patientAddress.setUsage(addressUse);

		if (fhirAddress.getState() != null) {
			patientAddress.setState(fhirAddress.getState());
		}
		if (fhirAddress.getCountry() != null) {
			patientAddress.setCountry(fhirAddress.getCountry());
		}

		return patientAddress;
	}

	/**
	 * Gets the birth place.
	 *
	 * @return the birth place
	 */
	public org.hl7.fhir.dstu3.model.Address getBirthPlace() {
		return birthPlace;
	}

	/**
	 * Gets the employee occupation.
	 *
	 * @return the employee occupation
	 */
	public CodeableConcept getEmployeeOccupation() {
		return employeeOccupation;
	}

	/**
	 * Gets the maiden name, implementation might change, because it is yet an
	 * open issue how it is stored in pdqm/fhir
	 *
	 * @return mothers maiden name
	 */
	public HumanName getMothersMaidenName() {
		for (final ContactComponent contact : getContact()) {
			for (final CodeableConcept CodeableConcept : contact.getRelationship()) {
				for (final Coding Coding : CodeableConcept.getCoding()) {
					if ("parent".equalsIgnoreCase(Coding.getCode())
							&& "female".equalsIgnoreCase(contact.getGender().toCode())
							&& NameUse.MAIDEN.equals(contact.getName().getUseElement().getValue())) {
							return contact.getName();
					}
				}
			}
		}
		return new HumanName();
	}

	/**
	 * Gets the nation.
	 *
	 * @return the nation
	 */
	public CodeableConcept getNation() {
		return nation;
	}

	/**
	 * converts the fhir patient resource in the convenience api patient
	 *
	 * @return the patient convenience api patient
	 */
	public Patient getPatient() {

		final var patientName = new Name();
		AdministrativeGender patientGender = null;
		Date patientBirthdate = null;

		final var humanName = this.getNameFirstRep();
		if (humanName != null) {
			var prefixBuilder = new StringBuilder();
			for (final StringType name : humanName.getPrefix()) {
				prefixBuilder.append(name.getValue());
				prefixBuilder.append(" ");
			}
			patientName.setPrefix(prefixBuilder.toString().trim());
			
			var givenBuilder = new StringBuilder();
			for (final StringType name : humanName.getGiven()) {
				givenBuilder.append(name.getValue());
				givenBuilder.append(" ");
			}
			if (humanName.getFamily() != null) {
				patientName.setFamily(humanName.getFamily());
			}

			var suffixBuilder = new StringBuilder();
			for (final StringType name : humanName.getSuffix()) {
				suffixBuilder.append(name.getValue());
				suffixBuilder.append(" ");
			}
			patientName.setSuffix(suffixBuilder.toString());
		}

		final org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender gender = getGender();
		if (gender != null) {
			switch (gender) {
			case FEMALE:
				patientGender = AdministrativeGender.FEMALE;
				break;
			case MALE:
				patientGender = AdministrativeGender.MALE;
				break;
			case OTHER:
				patientGender = AdministrativeGender.UNDIFFERENTIATED;
				break;
			default:
				patientGender = AdministrativeGender.UNDIFFERENTIATED;
				break;
			}
		}

		patientBirthdate = getBirthDate();
		final var patient = new Patient(patientName, patientGender, patientBirthdate);
		for (final Identifier identDt : getIdentifier()) {
			var oid = "";
			if (identDt.getSystem().startsWith(FhirCommon.oidUrn)) {
				oid = FhirCommon.removeUrnOidPrefix(identDt.getSystem());
			}
			final String id = identDt.getValue();
			final var identificator = new Identificator(oid, id);
			patient.addId(identificator);
		}

		for (final Address Address : getAddress()) {
			patient.addAddress(convertAddress(Address));
		}

		if (getManagingOrganization() != null) {
			var organization = new org.ehealth_connector.common.Organization(
					new OrganizationBaseType());

			patient.setProviderOrganization(organization);
			final org.hl7.fhir.dstu3.model.Organization org = (org.hl7.fhir.dstu3.model.Organization) getManagingOrganization()
					.getResource();

			if ((org != null) && (org.getName() != null)) {
				var orgName = new NameBaseType();
				orgName.setName(org.getName());
				organization.setPrimaryName(orgName);
			}

			if ((org != null) && (org.getIdentifierFirstRep() != null)
					&& (org.getIdentifierFirstRep().getSystem() != null)
					&& org.getIdentifierFirstRep().getSystem().startsWith(FhirCommon.oidUrn)) {
				var oid = "";
				oid = org.getIdentifierFirstRep().getSystem().substring(8);
				organization.getIdentificatorList()
						.add(
								new Identificator(oid, org.getIdentifierFirstRep().getValue()));
			}
			if (org != null && org.getTelecom() != null && !org.getTelecom().isEmpty()) {
				final var contactPoint = org.getTelecomFirstRep();
				if ((contactPoint != null) && (contactPoint.getValue() != null)) {
					final var tel = Util.createTel(contactPoint.getValue(), null);
					organization.addTelecom(new Telecom(tel));
				}
			}
		}

		// telecommunications
		if (!getTelecom().isEmpty()) {
			final var telecoms = new LinkedList<Telecom>();
			for (final ContactPoint contactPoint : getTelecom()) {
				if (ContactPointSystem.PHONE.equals(contactPoint.getSystemElement().getValue())) {
					org.ehealth_connector.common.enums.TelecomAddressUse addressUse = null;
					if (ContactPointUse.HOME.equals(contactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.TelecomAddressUse.PRIVATE;
					} else if (ContactPointUse.WORK
							.equals(contactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.TelecomAddressUse.BUSINESS;
					} else if (ContactPointUse.MOBILE
							.equals(contactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.TelecomAddressUse.MOBILE;
					}

					final var tel = Util.createTel(contactPoint.getValue(), addressUse);
					telecoms.add(new Telecom(tel));
				}
				if (ContactPointSystem.EMAIL.equals(contactPoint.getSystemElement().getValue())) {
					org.ehealth_connector.common.enums.TelecomAddressUse addressUse = null;
					if (ContactPointUse.HOME.equals(contactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.TelecomAddressUse.PRIVATE;
					} else if (ContactPointUse.WORK
							.equals(contactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.TelecomAddressUse.BUSINESS;
					}

					final var tel = Util.createTel(contactPoint.getValue(), addressUse);
					telecoms.add(new Telecom(tel));
				}
			}
			if (!telecoms.isEmpty()) {
				patient.setTelecoms(telecoms);
			}
		}

		// languageCommunications
		if (!getCommunication().isEmpty()) {
			for (final PatientCommunicationComponent communication : getCommunication()) {
				final var lang = new POCDMT000040LanguageCommunication();
				final var languageCode = new CS();
				languageCode.setCode(communication.getLanguage().getText());
				lang.setLanguageCode(languageCode);
				patient.getMdhtPatient().getLanguageCommunication().add(lang);
			}
		}

		// maritalStatus
		if (!getMaritalStatus().isEmpty()) {
			final var maritalStatusCode = new CE();
			maritalStatusCode.setCode(getMaritalStatus().getCodingFirstRep().getCode());
			patient.getMdhtPatient().setMaritalStatusCode(maritalStatusCode);
		}

		// deceasedBooolean
		final Type idDeceased = getDeceased();
		if (idDeceased instanceof BooleanType) {
			final BooleanType deceased = (BooleanType) idDeceased;
			if (deceased.getValue() != null) {
				patient.setDeceasedInd(deceased.getValue());
			}
		}

		// deceasedDateTime
		if (idDeceased instanceof DateTimeType) {
			final DateTimeType deceased = (DateTimeType) idDeceased;
			if (deceased.getValue() != null) {
				patient.setDeceasedTime(deceased.getValue());
				patient.setDeceasedInd(true);
			}
		}

		// multipleBirthOrder
		final Type iMultipleBirth = getMultipleBirth();
		if (iMultipleBirth instanceof IntegerType) {
			final IntegerType multipleBirth = (IntegerType) iMultipleBirth;
			if (multipleBirth.getValue() != null) {
				patient.setMultipleBirthOrderNumber(multipleBirth.getValue());
				patient.setMultipleBirthInd(true);
			}
		}

		// multipleBirth Indicator
		if (iMultipleBirth instanceof BooleanType) {
			final BooleanType multipleBirth = (BooleanType) iMultipleBirth;
			if (multipleBirth.getValue() != null) {
				patient.setMultipleBirthInd(true);
			}
		}

		// mothersName
		final HumanName mothersMaidenName = getMothersMaidenName();
		if (!mothersMaidenName.isEmpty()) {
			patient.setMothersMaidenName(mothersMaidenName.getFamily());
		}

		if ((getBirthPlace() != null) && !getBirthPlace().isEmpty()) {
			final var birthplace = new POCDMT000040Birthplace();
			final var place = new POCDMT000040Place();
			birthplace.setPlace(place);
			
			var address = this.convertAddress(this.getBirthPlace());
			if (address != null) {
				place.setAddr(address.getHl7CdaR2Ad());
			}

			patient.getMdhtPatient().setBirthplace(birthplace);
		}

		// religiousAffiliation
		if ((getReligiousAffiliation() != null) && !getReligiousAffiliation().isEmpty()) {
			patient.setReligiousAffiliation(getReligiousAffiliation().getText());
		}

		// nationCode
		if ((getNation() != null) && !getNation().isEmpty()) {
			patient.setNation(getNation().getText());
		}

		// employeeOccupationCode
		if ((getEmployeeOccupation() != null) && !getEmployeeOccupation().isEmpty()) {
			patient.setEmployeeOccupation(getEmployeeOccupation().getText());
		}

		return patient;
	}

	/**
	 * Gets the religious Affiliation
	 *
	 * @return religious affiliation
	 */
	public CodeableConcept getReligiousAffiliation() {
		return religiousAffiliation;
	}

	/**
	 * Sets the birth place.
	 *
	 * @param address
	 *            the new birth place
	 */
	public void setBirthPlace(Address address) {
		birthPlace = address;

	}

	/**
	 * Sets the employee occupation.
	 *
	 * @param employeeOccupation
	 *            the new employee occupation
	 */
	public void setEmployeeOccupation(CodeableConcept employeeOccupation) {
		this.employeeOccupation = employeeOccupation;
	}

	/**
	 * Sets the maiden name, implementation might change, because it is yet an
	 * open issue how it is stored in pdqm/fhir
	 *
	 * @param maidenName
	 *            sets the mothers maiden name
	 */
	public void setMothersMaidenName(HumanName maidenName) {
		maidenName.setUse(NameUse.MAIDEN);
		for (final ContactComponent contact : getContact()) {
			for (final CodeableConcept CodeableConcept : contact.getRelationship()) {
				for (final Coding Coding : CodeableConcept.getCoding()) {
					if ("parent".equals(Coding.getCode())
							&& "female".equalsIgnoreCase(contact.getGender().getDefinition())
							&& NameUse.MAIDEN.equals(contact.getName().getUseElement().getValue())) {
							contact.setName(maidenName);
							return;
					}
				}
			}
		}
		final ContactComponent mother = addContact()
				.setGender(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE);
		mother.addRelationship().addCoding().setCode("parent");
		mother.setName(maidenName);
	}

	/**
	 * Sets the nation.
	 *
	 * @param nation
	 *            the new nation
	 */
	public void setNation(CodeableConcept nation) {
		this.nation = nation;
	}

	/**
	 * Set the religious Affiliation
	 *
	 * @param religiousAffiliation
	 *            the religious affiliation
	 */
	public void setReligiousAffiliation(CodeableConcept religiousAffiliation) {
		this.religiousAffiliation = religiousAffiliation;
	}

}
