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
package org.ehealth_connector.fhir.structures.gen;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.enums.AdministrativeGender;
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
import org.openhealthtools.mdht.uml.cda.Birthplace;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.LanguageCommunication;
import org.openhealthtools.mdht.uml.cda.Organization;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.Place;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.ADXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

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
	@SuppressWarnings("incomplete-switch")
	static public org.hl7.fhir.dstu3.model.Address convertAddress(AD mdhtAddr) {
		org.hl7.fhir.dstu3.model.Address fhirAddr = null;
		if (mdhtAddr != null) {
			fhirAddr = new org.hl7.fhir.dstu3.model.Address();
			if (mdhtAddr.getStreetAddressLines() != null) {
				for (final ADXP street : mdhtAddr.getStreetAddressLines()) {
					fhirAddr.addLine(street.getText());
				}
				if ((mdhtAddr.getCities() != null) && (mdhtAddr.getCities().size() > 0)) {
					fhirAddr.setCity(mdhtAddr.getCities().get(0).getText());
				}
				if ((mdhtAddr.getPostalCodes() != null) && (mdhtAddr.getPostalCodes().size() > 0)) {
					fhirAddr.setPostalCode(mdhtAddr.getPostalCodes().get(0).getText());
				}
				if ((mdhtAddr.getStates() != null) && (mdhtAddr.getStates().size() > 0)) {
					fhirAddr.setState(mdhtAddr.getStates().get(0).getText());
				}
				if ((mdhtAddr.getCountries() != null) && (mdhtAddr.getCountries().size() > 0)) {
					fhirAddr.setCountry(mdhtAddr.getCountries().get(0).getText());
				}
				if ((mdhtAddr.getUses() != null) && (!mdhtAddr.getUses().isEmpty())
						&& (mdhtAddr.getCountries().size() > 0)) {
					switch (mdhtAddr.getUses().get(0)) {
					case H:
					case HP:
						fhirAddr.setUse(org.hl7.fhir.dstu3.model.Address.AddressUse.HOME);
						break;
					case WP:
						fhirAddr.setUse(org.hl7.fhir.dstu3.model.Address.AddressUse.WORK);
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
	static public HumanName convertName(Name name) {
		if (name != null) {
			final HumanName humanName = new HumanName();
			if (name.getAllGivenNames() != null) {
				final EList<ENXP> givens = name.getMdhtPn().getGivens();
				for (final ENXP given : givens) {
					humanName.addGiven(given.getText());
				}
			}
			if (name.getFamilyNames() != null) {
				final EList<ENXP> givens = name.getMdhtPn().getFamilies();
				for (final ENXP given : givens) {
					humanName.setFamily(given.getText());
				}
			}
			if (name.getPrefixes() != null) {
				final EList<ENXP> givens = name.getMdhtPn().getPrefixes();
				for (final ENXP given : givens) {
					humanName.addPrefix(given.getText());
				}
			}
			if (name.getSuffixes() != null) {
				final EList<ENXP> givens = name.getMdhtPn().getSuffixes();
				for (final ENXP given : givens) {
					humanName.addSuffix(given.getText());
				}
			}
			return humanName;
		}
		return null;
	}

	/**
	 * Convert telecom from hl7 datatype to fhir datatpye.
	 *
	 * @param tel
	 *            hl7 data type
	 * @return the fhir data type
	 */
	public static ContactPoint convertTelecom(TEL tel) {
		if (tel == null) {
			return null;
		}
		final ContactPoint ContactPoint = new ContactPoint();
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
		if ((tel.getUses().size() > 0)
				&& (tel.getUses().get(0) == TelecommunicationAddressUse.HP)) {
			use = ContactPointUse.HOME;
		}
		if ((tel.getUses().size() > 0)
				&& (tel.getUses().get(0) == TelecommunicationAddressUse.WP)) {
			use = ContactPointUse.WORK;
		}
		if ((tel.getUses().size() > 0)
				&& (tel.getUses().get(0) == TelecommunicationAddressUse.MC)) {
			use = ContactPointUse.MOBILE;
		}
		ContactPoint.setSystem(system);
		ContactPoint.setUse(use);
		ContactPoint.setValue(value);
		return ContactPoint;
	}

	@Child(name = "birthPlace")
	@Extension(url = "http://hl7.org/fhir/ExtensionDefinition/birthPlace", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The birtplace of the patientt")
	private org.hl7.fhir.dstu3.model.Address birthPlace;

	@Child(name = "religiousAffiliation")
	@Extension(url = "http://hl7.org/fhir/ExtensionDefinition/us-core-religion", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The religious Affiliation of the patient")
	private CodeableConcept religiousAffiliation;

	@Child(name = "nation")
	@Extension(url = "http://www.ehealth-connector.org/fhir-extensions/nation", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The nation of the patient")
	private CodeableConcept nation;

	@Child(name = "employeeOccupation")
	@Extension(url = "http://www.ehealth-connector.org/fhir-extensions/employeeOccupation", definedLocally = false, isModifier = false)
	@Description(shortDefinition = "The employee OccupationCode of the patient")
	private CodeableConcept employeeOccupation;

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

		if ((patient.getAddresses() != null) && (patient.getAddresses().size() > 0)) {
			for (final org.ehealth_connector.common.Address address : patient.getAddresses()) {
				getAddress().add(convertAddress(address.getMdhtAdress()));
			}
		}
		for (final Identificator ident : patient.getIds()) {
			Identifier id = new Identifier();
			id.setSystem(FhirCommon.addUrnOid(ident.getRoot()));
			id.setValue(ident.getExtension());
			this.getIdentifier().add(id);
		}
		final Organization organization = patient.getMdhtPatientRole().getProviderOrganization();
		if (organization != null) {
			final org.hl7.fhir.dstu3.model.Organization fhirOrganization = new org.hl7.fhir.dstu3.model.Organization();

			if ((organization != null) && (organization.getIds() != null)
					&& (organization.getIds().size() > 0)) {
				final org.openhealthtools.mdht.uml.hl7.datatypes.II ii = organization.getIds()
						.get(0);
				final Identifier identifier = new Identifier();
				identifier.setValue(ii.getExtension());
				identifier.setSystem(FhirCommon.addUrnOid(ii.getRoot()));
				fhirOrganization.getIdentifier().add(identifier);
			}

			if ((organization.getNames() != null) && (organization.getNames().size() > 0)) {
				final String name = organization.getNames().get(0).getText();
				fhirOrganization.setName(name);
			}

			if ((organization.getTelecoms() != null) && (organization.getTelecoms().size() > 0)) {
				final TEL tel = organization.getTelecoms().get(0);
				final ContactPoint fhirTel = fhirOrganization.addTelecom();
				if (tel.getValue().startsWith("tel:")) {
					fhirTel.setValue(tel.getValue().substring(4));
				}
			}
			getManagingOrganization().setResource(fhirOrganization);
		}

		if (patient.getTelecoms() != null) {
			for (final TEL tel : patient.getTelecoms().getMdhtTelecoms()) {
				this.getTelecom().add(convertTelecom(tel));
			}
		}

		// languageCommunications
		if (patient.getMdhtPatient().getLanguageCommunications().size() > 0) {
			for (final LanguageCommunication languageCommunication : patient.getMdhtPatient()
					.getLanguageCommunications()) {
				final PatientCommunicationComponent communication = new PatientCommunicationComponent();
				final CodeableConcept language = new CodeableConcept();
				language.setText(languageCommunication.getLanguageCode().getCode());
				communication.setLanguage(language);
				this.getCommunication().add(communication);
			}
		}

		// maritalStatus
		if (((patient.getMdhtPatient().getMaritalStatusCode() != null)
				&& (patient.getMdhtPatient().getMaritalStatusCode().getCode() != null))) {
			final CodeableConcept maritalStatus = new CodeableConcept();
			Coding code = new Coding();
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
			final HumanName mothersMaidenName = new HumanName();
			mothersMaidenName.setFamily(patient.getMothersMaidenName());
			setMothersMaidenName(mothersMaidenName);
		}

		// birthplace
		if ((patient.getMdhtPatient().getBirthplace() != null)
				&& (patient.getMdhtPatient().getBirthplace().getPlace() != null)) {
			setBirthPlace(
					convertAddress(patient.getMdhtPatient().getBirthplace().getPlace().getAddr()));
		}

		// religiousAffiliation
		if (patient.getReligiousAffiliation() != null) {
			final CodeableConcept religiousAffiliation = new CodeableConcept();
			religiousAffiliation.setText(patient.getReligiousAffiliation());
			this.setReligiousAffiliation(religiousAffiliation);
		}

		// nationCode
		if (patient.getNation() != null) {
			final CodeableConcept nationCode = new CodeableConcept();
			nationCode.setText(patient.getNation());
			this.setNation(nationCode);
		}

		// employeeOccupationcode
		if (patient.getEmployeeOccupation() != null) {
			final CodeableConcept employeeOccupationCode = new CodeableConcept();
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

		String addressline1 = "";
		String addressline2 = "";
		String addressline3 = "";

		if (fhirAddress.getLine().size() > 2) {
			addressline3 = fhirAddress.getLine().get(2).getValueAsString();
		}
		if (fhirAddress.getLine().size() > 1) {
			addressline2 = fhirAddress.getLine().get(1).getValueAsString();
		}
		if (fhirAddress.getLine().size() > 0) {
			addressline1 = fhirAddress.getLine().get(0).getValueAsString();
		}

		String city = "";
		if (fhirAddress.getCity() != null) {
			city = fhirAddress.getCity();
		}
		String zip = "";
		if (fhirAddress.getPostalCode() != null) {
			zip = fhirAddress.getPostalCode();
		}

		org.ehealth_connector.common.enums.AddressUse addressUse = null;
		if ((fhirAddress.getUseElement() != null)
				&& (fhirAddress.getUseElement().getValue() != null)) {
			switch (fhirAddress.getUseElement().getValue()) {
			case HOME:
				addressUse = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
				break;
			case WORK:
				addressUse = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
				break;
			default:
				break;
			}
		}
		final org.ehealth_connector.common.Address patientAddress = new org.ehealth_connector.common.Address(
				addressline1, addressline2, addressline3, zip, city, addressUse);
		if (fhirAddress.getState() != null) {
			patientAddress.getMdhtAdress().addState(fhirAddress.getState());
		}
		if (fhirAddress.getCountry() != null) {
			patientAddress.getMdhtAdress().addCountry(fhirAddress.getCountry());
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
					if ("parent".equals(Coding.getCode().toLowerCase())
							&& "female".equals(contact.getGender().toCode().toLowerCase())) {
						if ((NameUse.MAIDEN.equals(contact.getName().getUseElement().getValue()))) {
							return contact.getName();
						}
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

		final Name patientName = new Name("", "");
		final PN pn = patientName.getMdhtPn();
		AdministrativeGender patientGender = null;
		Date patientBirthdate = null;

		final HumanName humanName = this.getNameFirstRep();
		if (humanName != null) {
			for (final StringType name : humanName.getPrefix()) {
				pn.addPrefix(name.getValue());
			}
			for (final StringType name : humanName.getGiven()) {
				pn.addGiven(name.getValue());
			}
			if (humanName.getFamily() != null)
				pn.addFamily(humanName.getFamily());
			for (final StringType name : humanName.getSuffix()) {
				pn.addSuffix(name.getValue());
			}
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
		final Patient patient = new Patient(patientName, patientGender, patientBirthdate);
		for (final Identifier identDt : getIdentifier()) {
			String oid = "";
			if (identDt.getSystem().startsWith(FhirCommon.oidUrn)) {
				oid = FhirCommon.removeUrnOidPrefix(identDt.getSystem());
			}
			final String id = identDt.getValue();
			final Identificator identificator = new Identificator(oid, id);
			patient.addId(identificator);
		}

		for (final Address Address : getAddress()) {
			patient.addAddress(convertAddress(Address));
		}

		if (getManagingOrganization() != null) {
			final PatientRole patientRole = patient.getMdhtPatientRole();
			final Organization organization = CDAFactory.eINSTANCE.createOrganization();
			final org.ehealth_connector.common.Organization convenienceOrganization = new org.ehealth_connector.common.Organization(
					organization);

			patientRole.setProviderOrganization(organization);
			final org.hl7.fhir.dstu3.model.Organization org = (org.hl7.fhir.dstu3.model.Organization) getManagingOrganization()
					.getResource();

			if ((org != null) && (org.getName() != null)) {
				convenienceOrganization.addName(org.getName());
			}

			if ((org != null) && (org.getIdentifierFirstRep() != null)
					&& (org.getIdentifierFirstRep().getSystem() != null)
					&& org.getIdentifierFirstRep().getSystem().startsWith(FhirCommon.oidUrn)) {
				String oid = "";
				oid = org.getIdentifierFirstRep().getSystem().substring(8);
				organization.getIds().add(
						new Identificator(oid, org.getIdentifierFirstRep().getValue()).getIi());
			}
			if ((org != null) && (org.getTelecom() != null) && (org.getTelecom().size() > 0)) {
				final ContactPoint ContactPoint = org.getTelecomFirstRep();
				if ((ContactPoint != null) && (ContactPoint.getValue() != null)) {
					final TEL tel = Util.createTel(ContactPoint.getValue(), null);
					organization.getTelecoms().add(tel);
				}
			}
		}

		// telecommunications
		if (getTelecom().size() > 0) {
			final Telecoms telecoms = new Telecoms();
			for (final ContactPoint ContactPoint : getTelecom()) {
				if (ContactPointSystem.PHONE.equals(ContactPoint.getSystemElement().getValue())) {
					org.ehealth_connector.common.enums.AddressUse addressUse = null;
					if (ContactPointUse.HOME.equals(ContactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
					} else if (ContactPointUse.WORK
							.equals(ContactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
					} else if (ContactPointUse.MOBILE
							.equals(ContactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.AddressUse.MOBILE;
					}
					telecoms.addPhone(ContactPoint.getValue(), addressUse);
				}
				if (ContactPointSystem.EMAIL.equals(ContactPoint.getSystemElement().getValue())) {
					org.ehealth_connector.common.enums.AddressUse addressUse = null;
					if (ContactPointUse.HOME.equals(ContactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
					} else if (ContactPointUse.WORK
							.equals(ContactPoint.getUseElement().getValue())) {
						addressUse = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
					}
					telecoms.addEMail(ContactPoint.getValue(), addressUse);
				}
			}
			if (telecoms.getMdhtTelecoms().size() > 0) {
				patient.setTelecoms(telecoms);
			}
		}

		// languageCommunications
		if (getCommunication().size() > 0) {
			for (final PatientCommunicationComponent communication : getCommunication()) {
				final LanguageCommunication lang = CDAFactory.eINSTANCE
						.createLanguageCommunication();
				final CS languageCode = DatatypesFactory.eINSTANCE.createCS();
				languageCode.setCode(communication.getLanguage().getText());
				lang.setLanguageCode(languageCode);
				patient.getMdhtPatient().getLanguageCommunications().add(lang);
			}
		}

		// maritalStatus
		if (!getMaritalStatus().isEmpty()) {
			final CE maritalStatusCode = DatatypesFactory.eINSTANCE.createCE();
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
			final Birthplace birthPlace = CDAFactory.eINSTANCE.createBirthplace();
			final Place place = CDAFactory.eINSTANCE.createPlace();
			birthPlace.setPlace(place);
			place.setAddr(this.convertAddress(this.getBirthPlace()).getMdhtAdress());
			patient.getMdhtPatient().setBirthplace(birthPlace);
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
					if ("parent".equals(Coding.getCode()) && "female".equals(contact.getGender())) {
						if ((NameUse.MAIDEN.equals(contact.getName().getUseElement().getValue()))) {
							contact.setName(maidenName);
							return;
						}
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
