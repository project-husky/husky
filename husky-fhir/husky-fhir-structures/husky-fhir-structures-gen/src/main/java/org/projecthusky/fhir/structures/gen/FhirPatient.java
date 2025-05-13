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
package org.projecthusky.fhir.structures.gen;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Address.AddressUse;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Type;
import org.projecthusky.common.basetypes.AddressBaseType;
import org.projecthusky.common.basetypes.NameBaseType;
import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.common.enums.EntityNameUse;
import org.projecthusky.common.enums.PostalAddressUse;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Birthplace;
import org.projecthusky.common.hl7cdar2.POCDMT000040LanguageCommunication;
import org.projecthusky.common.hl7cdar2.POCDMT000040Organization;
import org.projecthusky.common.hl7cdar2.POCDMT000040Patient;
import org.projecthusky.common.hl7cdar2.POCDMT000040Place;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Organization;
import org.projecthusky.common.model.Patient;
import org.projecthusky.common.model.Telecom;

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
/* derived from external library */
@SuppressWarnings("java:S110")
@ResourceDef(name = "Patient")
public class FhirPatient extends org.hl7.fhir.r4.model.Patient {

	/**
	 *
	 */
	private static final long serialVersionUID = -1520681931095452610L;

	private static final String PARENT_LITERAL = "parent";

	/**
	 * converts the mdht AD to the fhir address
	 *
	 * @param mdhtAddr address object
	 * @return fhir address
	 */
	public static org.hl7.fhir.r4.model.Address convertAddress(org.projecthusky.common.model.Address mdhtAddr) {
		org.hl7.fhir.r4.model.Address fhirAddr = null;
		if (mdhtAddr != null) {
			fhirAddr = new org.hl7.fhir.r4.model.Address();

			fhirAddr.setLine(getStreetAdddressLines(mdhtAddr));

			if (mdhtAddr.getStreetName() != null) {
				org.hl7.fhir.r4.model.Extension streetNameExt = new org.hl7.fhir.r4.model.Extension(
						"http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetName",
						new StringType(mdhtAddr.getStreetName()));
				addAddressLineExtension(fhirAddr, streetNameExt);
			}

			if (mdhtAddr.getBuildingNumber() != null) {
				org.hl7.fhir.r4.model.Extension houseNumberExt = new org.hl7.fhir.r4.model.Extension(
						"http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-houseNumber",
						new StringType(mdhtAddr.getBuildingNumber()));
				addAddressLineExtension(fhirAddr, houseNumberExt);
			}

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
				fhirAddr.setUse(convertAddressUse(mdhtAddr.getUsage()));
			}

		}
		return fhirAddr;
	}

	private static void addAddressLineExtension(final Address address,
												final org.hl7.fhir.r4.model.Extension extension) {
		if (address.getLine().isEmpty()) {
			address.addLineElement().addExtension(extension);
		} else {
			address.getLine().get(0).addExtension(extension);
		}
	}

	private static List<StringType> getStreetAdddressLines(org.projecthusky.common.model.Address huskyAddr) {
		List<StringType> lines = new LinkedList<>();
		if (huskyAddr.getStreetAddressLine1() != null && !huskyAddr.getStreetAddressLine1().isEmpty()) {
			lines.add(new StringType(huskyAddr.getStreetAddressLine1()));
		}

		if (huskyAddr.getStreetAddressLine2() != null && !huskyAddr.getStreetAddressLine2().isEmpty()) {
			lines.add(new StringType(huskyAddr.getStreetAddressLine2()));
		}

		return lines;
	}

	private static AddressUse convertAddressUse(PostalAddressUse usage) {
		switch (usage) {
		case HOME_ADDRESS, VACATION_HOME, PRIMARY_HOME:
			return org.hl7.fhir.r4.model.Address.AddressUse.HOME;
		case WORK_PLACE:
			return org.hl7.fhir.r4.model.Address.AddressUse.WORK;
		case TEMPORARY:
			return org.hl7.fhir.r4.model.Address.AddressUse.TEMP;
		case BAD_ADDRESS:
			return org.hl7.fhir.r4.model.Address.AddressUse.NULL;
		case CONFIDENTIAL:
			break;
		case DIRECT:
			break;
		case PHYSICAL_VISIT_ADDRESS:
			break;
		case POSTAL_ADDRESS:
			break;
		case PUBLIC:
			break;
		default:
			break;
		}

		return null;
	}

	/**
	 * Convert the cda gender to the fhir gender.
	 *
	 * @param gender the gender
	 * @return the administrative gender enum
	 */
	public static org.hl7.fhir.r4.model.Enumerations.AdministrativeGender convertGender(AdministrativeGender gender) {
		if (gender != null) {
			if (gender.equals(AdministrativeGender.FEMALE)) {
				return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE;
			} else if (gender.equals(AdministrativeGender.MALE)) {
				return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE;
			} else if (gender.equals(AdministrativeGender.UNDIFFERENTIATED)) {
				return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.OTHER;
			}
		}
		return null;
	}

	/**
	 * Converts the convenience name to the fhir name
	 *
	 * @param name the name
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
	 * @return allocated value or {@link NameUse#USUAL} if no value can be allocated
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
	 * @param tel hl7 data type
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
		if (tel.getUsage() != null) {

			switch (tel.getUsage()) {
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
	private org.hl7.fhir.r4.model.Address birthPlace;

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
	 * Instantiates a new fhir patient based on the org.projecthusky.common.patient
	 *
	 * @param patient the patient
	 */
	public FhirPatient(Patient patient) {

		if (patient == null) {
			return;
		}

		setNames(patient.getNames());

		if (patient.getBirthday() != null) {
			setBirthDate(patient.getBirthday());
		}

		if (patient.getAdministrativeGenderCode() != null) {
			setGender(convertGender(patient.getAdministrativeGenderCode()));
		}

		setAddresses(patient.getAddresses());

		setIds(patient.getIds());

		final POCDMT000040Organization organization = patient.getMdhtPatientRole().getProviderOrganization();
		if (organization != null) {
			getManagingOrganization().setResource(convertOrganization(organization));
		}

		setTelecoms(patient.getTelecoms());

		// languageCommunications
		if (!patient.getMdhtPatient().getLanguageCommunication().isEmpty()) {
			this.getCommunication().addAll(convertLanguageCommunication(patient.getMdhtPatient()));
		}

		// maritalStatus
		if (((patient.getMdhtPatient().getMaritalStatusCode() != null)
				&& (patient.getMdhtPatient().getMaritalStatusCode().getCode() != null))) {
			this.setMaritalStatus(convertMaritalStatus(patient.getMdhtPatient().getMaritalStatusCode()));
		}

		setDeceased(patient);

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
			setBirthPlace(convertAddress(
					new org.projecthusky.common.model.Address(patient.getMdhtPatient().getBirthplace().getPlace().getAddr())));
		}

		// religiousAffiliation
		if (patient.getReligiousAffiliation() != null) {
			final var religiousaffiliation = new CodeableConcept();
			religiousaffiliation.setText(patient.getReligiousAffiliation());
			this.setReligiousAffiliation(religiousaffiliation);
		}

		// nationCode
		setNation(patient.getNation());

		// employeeOccupationcode
		setEmployeeOccupation(patient.getEmployeeOccupation());
	}

	public void setTelecoms(List<Telecom> telecoms) {
		if (telecoms != null) {
			for (final Telecom tel : telecoms) {
				this.getTelecom().add(convertTelecom(tel));
			}
		}
	}

	/**
	 * set names of patient
	 * 
	 * @param names
	 */
	public void setNames(List<Name> names) {
		if (names != null) {
			for (final Name name : names) {
				getName().add(convertName(name));
			}
		}
	}

	/**
	 * set addresses of patient
	 * 
	 * @param addresses
	 */
	public void setAddresses(List<org.projecthusky.common.model.Address> addresses) {
		if (addresses != null && !addresses.isEmpty()) {
			for (final org.projecthusky.common.model.Address address : addresses) {
				getAddress().add(convertAddress(address));
			}
		}

	}

	/**
	 * set IDs of patient
	 * 
	 * @param ids list of id
	 */
	public void setIds(List<Identificator> ids) {
		for (final Identificator ident : ids) {
			var id = new Identifier();
			id.setSystem(FhirCommon.addUrnOid(ident.getRoot()));
			id.setValue(ident.getExtension());
			this.getIdentifier().add(id);
		}
	}

	/**
	 * set nation
	 * 
	 * @param nation
	 */
	public void setNation(String nation) {
		if (nation != null) {
			final var nationCode = new CodeableConcept();
			nationCode.setText(nation);
			this.setNation(nationCode);
		}
	}

	/**
	 * set employee occupation
	 * 
	 * @param employeeOccupation
	 */
	public void setEmployeeOccupation(String employeeOccupation) {
		if (employeeOccupation != null) {
			final var employeeOccupationCode = new CodeableConcept();
			employeeOccupationCode.setText(employeeOccupation);
			this.setEmployeeOccupation(employeeOccupationCode);
		}
	}

	/**
	 * set deceased from patient deceased indicator or deceased time
	 * 
	 * @param patient
	 */
	public void setDeceased(Patient patient) {
		// deceasedBooolean
		if (patient.getDeceasedInd() != null) {
			setDeceased(new BooleanType(patient.getDeceasedInd()));
		}

		// deceasedDateTime
		if (patient.getDeceasedTime() != null) {
			setDeceased(new DateTimeType(patient.getDeceasedTime()));
		}
	}

	private CodeableConcept convertMaritalStatus(CE maritalStatusCe) {
		if (maritalStatusCe == null) {
			return null;
		}

		final var maritalStatus = new CodeableConcept();
		var code = new Coding();
		code.setCode(maritalStatusCe.getCode());
		code.setDisplay(maritalStatusCe.getDisplayName());
		maritalStatus.addCoding(code);
		return maritalStatus;
	}

	/**
	 * converts the hl7 cda r2 Patient to fhir patient communication
	 * 
	 * @param hl7cdar2Patient
	 * @return fhir patient communication
	 */
	private List<org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent> convertLanguageCommunication(
			POCDMT000040Patient hl7cdar2Patient) {
		List<org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent> communications = new LinkedList<>();
		for (final POCDMT000040LanguageCommunication languageCommunication : hl7cdar2Patient
				.getLanguageCommunication()) {
			final var communication = new PatientCommunicationComponent();
			final var language = new CodeableConcept();
			language.setText(languageCommunication.getLanguageCode().getCode());
			communication.setLanguage(language);
			communications.add(communication);
		}

		return communications;
	}

	/**
	 * converts the convenience organization to fhir organization
	 * 
	 * @param organization
	 * @return fhir organization
	 */
	private org.hl7.fhir.r4.model.Organization convertOrganization(POCDMT000040Organization organization) {
		if (organization == null) {
			return null;
		}

		final var fhirOrganization = new org.hl7.fhir.r4.model.Organization();

		if (!organization.getId().isEmpty()) {
			final var ii = organization.getId().get(0);
			final var identifier = new Identifier();
			identifier.setValue(ii.getExtension());
			identifier.setSystem(FhirCommon.addUrnOid(ii.getRoot()));
			fhirOrganization.getIdentifier().add(identifier);
		}

		if (!organization.getName().isEmpty()) {
			final String name = organization.getName().get(0).getMergedXmlMixed();
			fhirOrganization.setName(name);
		}

		if (!organization.getTelecom().isEmpty()) {
			final var tel = organization.getTelecom().get(0);
			final ContactPoint fhirTel = fhirOrganization.addTelecom();
			if (tel.getValue().startsWith("tel:")) {
				fhirTel.setValue(tel.getValue().substring(4));
			}
		}

		return fhirOrganization;
	}

	/**
	 * converts the fhir address to the convenience address
	 *
	 * @param fhirAddress
	 * @return fhir address
	 */
	private org.projecthusky.common.model.Address convertAddress(org.hl7.fhir.r4.model.Address fhirAddress) {
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

		org.projecthusky.common.enums.PostalAddressUse addressUse = null;
		if ((fhirAddress.getUseElement() != null) && (fhirAddress.getUseElement().getValue() != null)) {
			switch (fhirAddress.getUseElement().getValue()) {
			case HOME:
				addressUse = org.projecthusky.common.enums.PostalAddressUse.PRIMARY_HOME;
				break;
			case WORK:
				addressUse = org.projecthusky.common.enums.PostalAddressUse.WORK_PLACE;
				break;
			default:
				break;
			}
		}
		final var patientAddress = new org.projecthusky.common.model.Address(new AddressBaseType());
		if (!addressline1.isEmpty()) {
			patientAddress.setStreetAddressLine1(addressline1);
		}

		if (!addressline2.isEmpty()) {
			patientAddress.setStreetAddressLine2(addressline2);
		}

		final var firstLine = fhirAddress.hasLine() ? fhirAddress.getLine().get(0) : null;
		Optional.ofNullable(firstLine)
				.map(line -> line.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetName"))
				.map(ext -> (StringType) ext.getValue())
				.map(StringType::getValue)
				.ifPresent(patientAddress::setStreetName);

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
	public org.hl7.fhir.r4.model.Address getBirthPlace() {
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
	 * Gets the maiden name, implementation might change, because it is yet an open
	 * issue how it is stored in pdqm/fhir
	 *
	 * @return mothers maiden name
	 */
	public HumanName getMothersMaidenName() {
		for (final ContactComponent contact : getContact()) {
			for (final CodeableConcept CodeableConcept : contact.getRelationship()) {
				for (final Coding Coding : CodeableConcept.getCoding()) {
					if (PARENT_LITERAL.equalsIgnoreCase(Coding.getCode())
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

		Calendar calendar = new GregorianCalendar();

		if (getBirthDate() != null) {
			calendar.setTime(getBirthDate());
		}

		final var patient = new Patient(getConvenienceName(), convertGender(getGender()), calendar);
		patient.setIds(getIdentificators());

		for (final Address Address : getAddress()) {
			patient.addAddress(convertAddress(Address));
		}

		Organization organization = getOrganization();

		if (organization != null) {
			patient.setProviderOrganization(organization);
		}

		// telecommunications
		if (!getTelecom().isEmpty()) {
			patient.setTelecoms(getTelecommunications());
		}

		// languageCommunications
		if (!getCommunication().isEmpty()) {
			patient.getMdhtPatient().getLanguageCommunication().addAll(getLanguangeCommunication());
		}

		// maritalStatus
		if (!getMaritalStatus().isEmpty()) {
			final var maritalStatusCode = new CE();
			maritalStatusCode.setCode(getMaritalStatus().getCodingFirstRep().getCode());
			patient.getMdhtPatient().setMaritalStatusCode(maritalStatusCode);
		}

		setDeceasedToPatient(patient);
		setMultipleBirth(patient);

		// mothersName
		final HumanName mothersMaidenName = getMothersMaidenName();
		if (!mothersMaidenName.isEmpty()) {
			patient.setMothersMaidenName(mothersMaidenName.getFamily());
		}

		// birth place
		if ((getBirthPlace() != null) && !getBirthPlace().isEmpty()) {
			patient.getMdhtPatient().setBirthplace(getHl7Cdar2Birthplace());
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

	private void setDeceasedToPatient(Patient patient) {
		// deceasedBooolean
		final Type idDeceased = getDeceased();
		if (idDeceased instanceof BooleanType deceased && deceased.getValue() != null) {
			patient.setDeceasedInd(deceased.getValue());
		}

		// deceasedDateTime
		if (idDeceased instanceof DateTimeType deceased && deceased.getValue() != null) {
			patient.setDeceasedTime(deceased.getValue());
			patient.setDeceasedInd(true);
		}
	}

	private void setMultipleBirth(Patient patient) {
		// multipleBirthOrder
		final Type iMultipleBirth = getMultipleBirth();
		if (iMultipleBirth instanceof IntegerType multipleBirth && multipleBirth.getValue() != null) {
			patient.setMultipleBirthOrderNumber(multipleBirth.getValue());
			patient.setMultipleBirthInd(true);
		}

		// multipleBirth Indicator
		if (iMultipleBirth instanceof BooleanType multipleBirth && multipleBirth.getValue() != null) {
			patient.setMultipleBirthInd(true);
		}
	}

	/**
	 * convert the fhir identifiers to a list of convenience identificator
	 * 
	 * @return list of convenience identificator
	 */
	public List<Identificator> getIdentificators() {
		List<Identificator> ids = new LinkedList<>();
		for (final Identifier identDt : getIdentifier()) {
			var oid = "";
			if (identDt.getSystem().startsWith(FhirCommon.OID_URN)) {
				oid = FhirCommon.removeUrnOidPrefix(identDt.getSystem());
			}
			final String id = identDt.getValue();
			final var identificator = new Identificator(oid, id);
			ids.add(identificator);
		}

		return ids;
	}

	/**
	 * convert the fhir telecoms to a list of convenience telecom
	 * 
	 * @return list of convenience telecom
	 */
	public List<Telecom> getTelecommunications() {
		final var telecoms = new LinkedList<Telecom>();
		for (final ContactPoint contactPoint : getTelecom()) {
			telecoms.add(createTelecom(contactPoint.getValue(), contactPoint.getSystemElement().getValue(),
					contactPoint.getUseElement().getValue()));
		}

		return telecoms;
	}

	/**
	 * convert the fhir birth place to hl7 cda r2 birth place
	 * 
	 * @return hl7 cda r2 birth place
	 */
	public POCDMT000040Birthplace getHl7Cdar2Birthplace() {
		final var birthplace = new POCDMT000040Birthplace();
		final var place = new POCDMT000040Place();
		birthplace.setPlace(place);

		var address = this.convertAddress(getBirthPlace());
		if (address != null) {
			place.setAddr(address.getHl7CdaR2Ad());
		}

		return birthplace;
	}

	/**
	 * convert the fhir communication to list of hl7 cda r2 languange communication
	 * 
	 * @return list of hl7 cda r2 languange communication
	 */
	public List<POCDMT000040LanguageCommunication> getLanguangeCommunication() {
		List<POCDMT000040LanguageCommunication> communications = new LinkedList<>();
		for (final PatientCommunicationComponent communication : getCommunication()) {
			final var lang = new POCDMT000040LanguageCommunication();
			final var languageCode = new CS();
			languageCode.setCode(communication.getLanguage().getText());
			lang.setLanguageCode(languageCode);
			communications.add(lang);
		}

		return communications;
	}

	/**
	 * convert the fhir patient human name to convenience name
	 * 
	 * @return convenience name
	 */
	public Name getConvenienceName() {
		final var patientName = new Name();

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
			patientName.setGiven(givenBuilder.toString().trim());

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

		return patientName;
	}

	/**
	 * convert the fhir managing organization to convenience Organization
	 * 
	 * @return convenience organization
	 */
	public Organization getOrganization() {
		if (getManagingOrganization() == null) {
			return null;
		}

		var organization = new org.projecthusky.common.model.Organization(new OrganizationBaseType());

		final org.hl7.fhir.r4.model.Organization org = (org.hl7.fhir.r4.model.Organization) getManagingOrganization()
				.getResource();

		if (org == null) {
			return null;
		}

		if (org.getName() != null) {
			var orgName = new NameBaseType();
			orgName.setName(org.getName());
			organization.addName(orgName);
		}

		if (org.getIdentifierFirstRep() != null && (org.getIdentifierFirstRep().getSystem() != null)
				&& org.getIdentifierFirstRep().getSystem().startsWith(FhirCommon.OID_URN)) {
			var oid = "";
			oid = org.getIdentifierFirstRep().getSystem().substring(8);
			organization.getIdentificatorList().add(new Identificator(oid, org.getIdentifierFirstRep().getValue()));
		}
		if (org.getTelecom() != null && !org.getTelecom().isEmpty()) {
			final var contactPoint = org.getTelecomFirstRep();
			if ((contactPoint != null) && (contactPoint.getValue() != null)) {
				organization.addTelecom(createTelecom(contactPoint.getValue(),
						contactPoint.getSystemElement().getValue(), contactPoint.getUseElement().getValue()));
			}
		}

		return organization;
	}

	/**
	 * Convert the fhir gender to the cda gender.
	 *
	 * @param gender the gender
	 * @return the administrative gender enum
	 */
	public AdministrativeGender convertGender(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender gender) {
		if (gender != null) {
			if (gender.equals(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE)) {
				return AdministrativeGender.FEMALE;
			} else if (gender.equals(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE)) {
				return AdministrativeGender.MALE;
			} else if (gender.equals(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.OTHER)) {
				return AdministrativeGender.UNDIFFERENTIATED;
			} else {
				return AdministrativeGender.UNDIFFERENTIATED;
			}
		}
		return null;
	}

	public Telecom createTelecom(String value, ContactPointSystem system, ContactPointUse usage) {
		final var tel = new Telecom();

		if (system != null) {
			org.projecthusky.common.enums.TelecomAddressUse addressUse = null;
			if (ContactPointSystem.PHONE.equals(system)) {

				if (ContactPointUse.HOME.equals(usage)) {
					addressUse = org.projecthusky.common.enums.TelecomAddressUse.PRIVATE;
				} else if (ContactPointUse.WORK.equals(usage)) {
					addressUse = org.projecthusky.common.enums.TelecomAddressUse.BUSINESS;
				} else if (ContactPointUse.MOBILE.equals(usage)) {
					addressUse = org.projecthusky.common.enums.TelecomAddressUse.MOBILE;
				}

				tel.setValue("tel:" + value.replaceAll("\\s+", ""));
			}
			if (ContactPointSystem.EMAIL.equals(system)) {
				if (ContactPointUse.HOME.equals(usage)) {
					addressUse = org.projecthusky.common.enums.TelecomAddressUse.PRIVATE;
				} else if (ContactPointUse.WORK.equals(usage)) {
					addressUse = org.projecthusky.common.enums.TelecomAddressUse.BUSINESS;
				}

				tel.setValue("mailto:" + value);

			}
			tel.setUsage(addressUse);

		} else {
			tel.setValue(value);
		}

		return tel;
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
	 * @param address the new birth place
	 */
	public void setBirthPlace(Address address) {
		birthPlace = address;

	}

	/**
	 * Sets the employee occupation.
	 *
	 * @param employeeOccupation the new employee occupation
	 */
	public void setEmployeeOccupation(CodeableConcept employeeOccupation) {
		this.employeeOccupation = employeeOccupation;
	}

	/**
	 * Sets the maiden name, implementation might change, because it is yet an open
	 * issue how it is stored in pdqm/fhir
	 *
	 * @param maidenName sets the mothers maiden name
	 */
	public void setMothersMaidenName(HumanName maidenName) {
		maidenName.setUse(NameUse.MAIDEN);
		for (final ContactComponent contact : getContact()) {
			for (final CodeableConcept CodeableConcept : contact.getRelationship()) {
				for (final Coding Coding : CodeableConcept.getCoding()) {
					if (PARENT_LITERAL.equals(Coding.getCode())
							&& "female".equalsIgnoreCase(contact.getGender().getDefinition())
							&& NameUse.MAIDEN.equals(contact.getName().getUseElement().getValue())) {
						contact.setName(maidenName);
						return;
					}
				}
			}
		}
		final ContactComponent mother = addContact()
				.setGender(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE);
		mother.addRelationship().addCoding().setCode(PARENT_LITERAL);
		mother.setName(maidenName);
	}

	/**
	 * Sets the nation.
	 *
	 * @param nation the new nation
	 */
	public void setNation(CodeableConcept nation) {
		this.nation = nation;
	}

	/**
	 * Set the religious Affiliation
	 *
	 * @param religiousAffiliation the religious affiliation
	 */
	public void setReligiousAffiliation(CodeableConcept religiousAffiliation) {
		this.religiousAffiliation = religiousAffiliation;
	}

}
