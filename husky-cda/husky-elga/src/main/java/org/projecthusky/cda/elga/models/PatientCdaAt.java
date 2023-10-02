/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrHeaderRecordTargetEImpfpass;
import org.projecthusky.cda.elga.generated.artdecor.base.HeaderRecordTarget;
import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsHeaderRecordTarget;
import org.projecthusky.cda.elga.models.ems.EpimsPatient;
import org.projecthusky.cda.elga.models.ems.EpimsPatientRole;
import org.projecthusky.common.at.Guardian;
import org.projecthusky.common.at.PatientAt;
import org.projecthusky.common.hl7cdar2.AD;
import org.projecthusky.common.hl7cdar2.BL;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.POCDMT000040Birthplace;
import org.projecthusky.common.hl7cdar2.POCDMT000040Place;
import org.projecthusky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Telecom;
import org.projecthusky.common.utils.time.DateTimes;

public class PatientCdaAt extends PatientAt {

	public PatientCdaAt() {
		super();
	}

	public PatientCdaAt(POCDMT000040RecordTarget recordTarget) {
		super(recordTarget);
	}

	public HeaderRecordTarget getHeaderRecordTargetBase() {
		HeaderRecordTarget recordTarget = new HeaderRecordTarget();
		recordTarget.setHl7PatientRole(getMdhtPatientRole());
		return recordTarget;
	}

	public AtcdabbrHeaderRecordTargetEImpfpass getAtcdabbrHeaderRecordTargetEImpfpass() {
		AtcdabbrHeaderRecordTargetEImpfpass recordTarget = new AtcdabbrHeaderRecordTargetEImpfpass();
		recordTarget.setPatientRole(getMdhtPatientRole());
		return recordTarget;
	}

	public EpimsHeaderRecordTarget getHeaderRecordTarget() {
		EpimsHeaderRecordTarget recordTarget = new EpimsHeaderRecordTarget();
		EpimsPatientRole patientRole = recordTarget.getPatientRole();

		if (getIds() != null) {
			for (Identificator id : getIds()) {
				patientRole.getId().add(id.getHl7CdaR2Ii());
			}
		}

		if (getAddresses() != null) {
			for (Address ad : getAddresses()) {
				if (ad != null) {
					patientRole.getAddr().add(ad.getHl7CdaR2Ad());
				}
			}
		}

		if (getTelecoms() != null && !getTelecoms().isEmpty()) {
			for (Telecom tel : getTelecoms()) {
				patientRole.getTelecom().add(tel.getHl7CdaR2Tel());
			}
		}

		patientRole.setPatient(getEpimsPatient());
		recordTarget.setPatientRole(patientRole);
		return recordTarget;
	}

	private EpimsPatient getEpimsPatient() {
		EpimsPatient patient = new EpimsPatient();
		patient.getClassCode().add("PSN");
		patient.setDeterminerCode("INSTANCE");

		if (getNames() != null) {
			for (Name nam : getNames()) {
				if (nam != null) {
					patient.getName().add(nam.getHl7CdaR2Pn());
				}
			}
		}

		if (getAdministrativeGenderCode() != null) {
			patient.setAdministrativeGenderCode(createGenderTag(getAdministrativeGenderCode().getCode()));
		} else {
			CE genderCode = new CE();
			genderCode.getNullFlavor().add("UNK");
			patient.setAdministrativeGenderCode(genderCode);
		}

		if (getBirthday() != null) {
			patient.setBirthTime(DateTimes.toDateTs(getBirthdayAsLocalDate()));
		}

		if (getDateOfDeath() != null) {
			patient.setDeceasedTime(DateTimes.toDateTs(getDateOfDeath()));
			BL deceasedInd = new BL();
			deceasedInd.setValue(true);
			patient.setDeceasedInd(deceasedInd);
		}

		if (getGuardians() != null && !getGuardians().isEmpty()) {
			for (Guardian guardian : getGuardians()) {
				if (guardian != null) {
					patient.getGuardian().add(guardian.getPOCDMT000040Guardian());
				}
			}
		}

		if (getBirthPlace() != null) {
			patient.setBirthplace(createBirthPlace(getBirthPlace()));
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

	protected CE createGenderTag(Code genderEnum) {
		CE gender = new CE();
		gender.setCode(genderEnum.getCode());
		gender.setCodeSystem(genderEnum.getCodeSystem());
		gender.setCodeSystemName("HL7:AdministrativeGender");
		gender.setDisplayName(genderEnum.getDisplayName());
		return gender;
	}



}
