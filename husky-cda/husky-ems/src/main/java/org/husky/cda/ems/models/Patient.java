/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.ems.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.husky.cda.ems.generated.artdecor.EpimsHeaderRecordTarget;
import org.husky.cda.ems.generated.artdecor.enums.ElgaAdministrativeGender;
import org.husky.common.hl7cdar2.AD;
import org.husky.common.hl7cdar2.BL;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.PN;
import org.husky.common.hl7cdar2.POCDMT000040Birthplace;
import org.husky.common.hl7cdar2.POCDMT000040Place;
import org.husky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.husky.common.model.Address;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Telecom;
import org.husky.common.utils.time.DateTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Patient {

	/** The SLF4J logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(Patient.class.getName());
	private List<Identificator> ids;
	private List<Name> names;
	private ElgaAdministrativeGender administrativeGenderCode;
	private LocalDate birthDate;
	private LocalDate dateOfDeath;
	private List<Address> address;
	private List<Telecom> telecoms;
	private List<Guardian> guardians;
	private Address birthPlace;

	public Patient() {
		ids = new ArrayList<>();
	}

	public Patient(POCDMT000040RecordTarget target) {
		if (target != null && target.getPatientRole() != null) {

			if (target.getPatientRole().getPatient() != null) {
				if (target.getPatientRole().getPatient().getName() != null) {
					names = new ArrayList<>();
					for (PN pn : target.getPatientRole().getPatient().getName()) {
						names.add(new Name(pn));
					}
				}

				if (target.getPatientRole().getPatient().getAdministrativeGenderCode() != null) {
					this.administrativeGenderCode = ElgaAdministrativeGender
							.getEnum(target.getPatientRole().getPatient().getAdministrativeGenderCode().getCode());
				}

				if (target.getPatientRole().getPatient().getBirthTime() != null) {
					this.birthDate = DateTimes.toLocalDate(target.getPatientRole().getPatient().getBirthTime());
				}

				if (target.getPatientRole().getPatient().getBirthplace() != null
						&& target.getPatientRole().getPatient().getBirthplace().getPlace() != null) {
					this.birthPlace = new Address(
							target.getPatientRole().getPatient().getBirthplace().getPlace().getAddr());
				}
			}

			if (target.getPatientRole().getAddr() != null) {
				this.address = new ArrayList<>();
				for (AD ad : target.getPatientRole().getAddr()) {
					if (ad != null) {
						this.address.add(new Address(ad));
					}
				}
			}

			if (target.getPatientRole().getId() != null) {
				this.ids = new ArrayList<>();
				for (II id : target.getPatientRole().getId()) {
					if (id != null) {
						this.ids.add(new Identificator(id));
					}
				}
			}
		}
	}

	public List<Address> getAddress() {
		return address;
	}

	public ElgaAdministrativeGender getAdministrativeGenderCode() {
		return administrativeGenderCode;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public List<Identificator> getIds() {
		return ids;
	}

	public List<Name> getName() {
		return names;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public void setAdministrativeGenderCode(ElgaAdministrativeGender gender) {
		this.administrativeGenderCode = gender;
	}

	public void setBirthDate(LocalDate birthday) {
		this.birthDate = birthday;
	}

	public void setIds(List<Identificator> ids) {
		this.ids = ids;
	}

	public void setName(List<Name> name) {
		this.names = name;
	}

	public List<Telecom> getTelecoms() {
		return telecoms;
	}

	public void setTelecoms(List<Telecom> telecoms) {
		this.telecoms = telecoms;
	}

	public List<Guardian> getGuardians() {
		return this.guardians;
	}

	public void setGuardians(List<Guardian> orgGuardian) {
		this.guardians = orgGuardian;
	}

	public Address getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(Address birthPlace) {
		this.birthPlace = birthPlace;
	}

	public LocalDate getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(LocalDate dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public EpimsHeaderRecordTarget getHeaderRecordTarget() {
		EpimsHeaderRecordTarget recordTarget = new EpimsHeaderRecordTarget();
		EpimsPatientRole patientRole = recordTarget.getPatientRole();

		if (ids != null) {
			for (Identificator id : ids) {
				patientRole.getId().add(id.getHl7CdaR2Ii());
			}
		}

		if (address != null) {
			for (Address ad : address) {
				if (ad != null) {
					patientRole.getAddr().add(ad.getHl7CdaR2Ad());
				}
			}
		}

		if (this.telecoms != null && !this.telecoms.isEmpty()) {
			for (Telecom tel : telecoms) {
				patientRole.getTelecom().add(tel.getHl7CdaR2Tel());
			}
		}

		patientRole.setEpimsPatient(getEpimsPatient());
		recordTarget.setPatientRole(patientRole);
		return recordTarget;
	}

	private EpimsPatient getEpimsPatient() {
		EpimsPatient patient = new EpimsPatient();
		patient.getClassCode().add("PSN");
		patient.setDeterminerCode("INSTANCE");

		if (this.names != null) {
			for (Name nam : names) {
				if (nam != null) {
					patient.getName().add(nam.getHl7CdaR2Pn());
				}
			}
		}

		if (this.administrativeGenderCode != null) {
			patient.setAdministrativeGenderCode(createGenderTag(administrativeGenderCode));
		} else {
			CE genderCode = new CE();
			genderCode.getNullFlavor().add("UNK");
			patient.setAdministrativeGenderCode(genderCode);
		}

		if (this.birthDate != null) {
			patient.setBirthTime(DateTimes.toDateTs(this.birthDate));
		}

		if (this.dateOfDeath != null) {
			patient.setDeceasedTime(DateTimes.toDateTs(this.dateOfDeath));
			BL deceasedInd = new BL();
			deceasedInd.setValue(true);
			patient.setDeceasedInd(deceasedInd);
		}

		if (this.guardians != null && !this.guardians.isEmpty()) {
			for (Guardian guardian : guardians) {
				if (guardian != null) {
					patient.getGuardian().add(guardian.getPOCDMT000040Guardian());
				}
			}
		}

		if (this.birthPlace != null) {
			patient.setBirthplace(createBirthPlace(this.birthPlace));
		}

		return patient;
	}

	protected POCDMT000040Birthplace createBirthPlace(Address address) {
		POCDMT000040Birthplace birthplace = new POCDMT000040Birthplace();
		birthplace.getClassCode().add("BIRTHPL");
		birthplace.setPlace(createPlace(address));
		return birthplace;
	}

	protected POCDMT000040Place createPlace(Address address) {
		POCDMT000040Place place = new POCDMT000040Place();
		place.setDeterminerCode("INSTANCE");
		if (address == null) {
			AD ad = new AD();
			ad.setXmlMixed("UNKNOWN");
			place.setAddr(ad);
		} else {
			place.setAddr(address.getHl7CdaR2Ad());
		}

		return place;
	}

	protected CE createGenderTag(ElgaAdministrativeGender genderEnum) {
		CE gender = new CE();
		gender.setCode(genderEnum.getCodeValue());
		gender.setCodeSystem(genderEnum.getCodeSystemId());
		gender.setCodeSystemName("HL7:AdministrativeGender");
		gender.setDisplayName(genderEnum.getDisplayName());
		return gender;
	}


}
