package org.husky.communication.mpi.impl;

import org.husky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.coctmt030007UV.COCTMT030007UVPerson;
import net.ihe.gazelle.hl7v3.datatypes.AD;
import net.ihe.gazelle.hl7v3.datatypes.CE;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02OtherIDs;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Person;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02PersonalRelationship;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02OtherIDs;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02OtherIDsId;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientPatientPerson;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PersonalRelationship;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02OtherIDs;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Person;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02PersonalRelationship;
import net.ihe.gazelle.hl7v3.voc.EntityClass;
import net.ihe.gazelle.hl7v3.voc.EntityDeterminer;
import net.ihe.gazelle.hl7v3.voc.XDeterminerInstanceKind;

public class PixPdqPerson {

	private Object internalObj;

	public PixPdqPerson(Object obj) {

		this.internalObj = obj;

		if (obj instanceof PRPAMT201303UV02Person) {
			// set the person classcode
			getPRPAMT201303UV02Person().setClassCode(EntityClass.PSN);

			// set the person determiner code
			getPRPAMT201303UV02Person().setDeterminerCode(EntityDeterminer.INSTANCE);
		} else if (obj instanceof PRPAMT201302UV02PatientPatientPerson) {
			// set the person classcode
			getPRPAMT201302UV02PatientPatientPerson().setClassCode(EntityClass.PSN);

			// set the person determiner code
			getPRPAMT201302UV02PatientPatientPerson().setDeterminerCode(EntityDeterminer.INSTANCE);
		} else if (obj instanceof PRPAMT201301UV02Person) {
			// set the person classcode
			getPRPAMT201301UV02Person().setClassCode(EntityClass.PSN);

			// set the person determiner code
			getPRPAMT201301UV02Person().setDeterminerCode(EntityDeterminer.INSTANCE);
		}

	}

	/**
	 * Add an address for the patient.
	 *
	 * @param addressStreetAddress
	 * @param addressCity
	 * @param addressCounty
	 * @param addressState
	 * @param addressCountry
	 * @param addressZip
	 * @param addressOtherDesignation
	 * @param addressType
	 */
	public void addPatientAddress(AD patientAddress) {
		if (patientAddress == null) {
			return;
		}

		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().getAddr().add(patientAddress);
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().getAddr().add(patientAddress);
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().getAddr().add(patientAddress);
		}

	}

	/**
	 * Add Patient Ethnic Group Code to the patient
	 *
	 * @param code
	 */
	public void addPatientEthnicGroupCode(String code) {

		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().getEthnicGroupCode().add(PixPdqV3Utils.createCE(code));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().getEthnicGroupCode().add(PixPdqV3Utils.createCE(code));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().getEthnicGroupCode().add(PixPdqV3Utils.createCE(code));
		}

	}

	/**
	 * Add a patient name.
	 *
	 * @param familyName
	 * @param givenName
	 * @param other
	 * @param prefixName
	 * @param suffixName
	 */
	public void addPatientName(String familyName, String givenName, String other, String prefixName,
			String suffixName) {
		var patientName = PixPdqV3Utils.createPN(familyName, givenName, other, suffixName, prefixName);

		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().getName().add(patientName);
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().getName().add(patientName);
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().getName().add(patientName);
		}

	}

	/**
	 * Add a Patient Other ID for the patient
	 *
	 * @param extension
	 * @param root
	 */
	public void addPatientOtherID(String extension, String root) {

		if (internalObj instanceof PRPAMT201303UV02Person) {
			var asOtherID = new PRPAMT201303UV02OtherIDs();
			asOtherID.setClassCode("PAT");
			asOtherID.getId().add(PixPdqV3Utils.createII(root, extension, ""));
			asOtherID.setScopingOrganization(PixPdqV3Utils.createCOCTMT150002UV01Organization(root));

			getPRPAMT201303UV02Person().getAsOtherIDs().add(asOtherID);
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			var asOtherID = new PRPAMT201302UV02OtherIDs();
			asOtherID.setClassCode("PAT");
			var otherId = new PRPAMT201302UV02OtherIDsId();
			if (null != root && !root.isEmpty())
				otherId.setRoot(root);
			if (null != extension && !extension.isEmpty())
				otherId.setExtension(extension);
			asOtherID.getId().add(otherId);
			asOtherID.setScopingOrganization(PixPdqV3Utils.createCOCTMT150002UV01Organization(root));

			getPRPAMT201302UV02PatientPatientPerson().getAsOtherIDs().add(asOtherID);
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			final var asOtherID = new PRPAMT201301UV02OtherIDs();
			asOtherID.setClassCode("PAT");
			asOtherID.getId().add(PixPdqV3Utils.createII(root, extension, ""));
			asOtherID.setScopingOrganization(PixPdqV3Utils.createCOCTMT150002UV01Organization(root));
			getPRPAMT201301UV02Person().getAsOtherIDs().add(asOtherID);
		}
	}

	/**
	 * Add Patient Race Code to the patient
	 *
	 * @param code
	 */
	public void addPatientRaceCode(String code) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().getRaceCode().add(PixPdqV3Utils.createCE(code));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().getRaceCode().add(PixPdqV3Utils.createCE(code));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().getRaceCode().add(PixPdqV3Utils.createCE(code));
		}

	}

	/**
	 * Add a telecom value with the provided useValue ("HP" or "WP")
	 *
	 * @param telecomValue
	 * @param useValue
	 */
	public void addPatientTelecom(String telecomValue, String useValue) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().getTelecom().add(PixPdqV3Utils.createTEL(telecomValue, useValue));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().getTelecom().add(PixPdqV3Utils.createTEL(telecomValue, useValue));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().getTelecom().add(PixPdqV3Utils.createTEL(telecomValue, useValue));
		}

	}

	/**
	 * Set whether there was a multiple birth.
	 *
	 * @param birthIndicator
	 */
	public void setMultipleBirthIndicator(boolean birthIndicator) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().setMultipleBirthInd(PixPdqV3Utils.createBL(birthIndicator));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().setMultipleBirthInd(PixPdqV3Utils.createBL(birthIndicator));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().setMultipleBirthInd(PixPdqV3Utils.createBL(birthIndicator));
		}

	}

	/**
	 * Set the birth order number to the provided value
	 *
	 * @param birthNumber
	 */
	public void setMultipleBirthOrderNumber(int birthNumber) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().setMultipleBirthOrderNumber(PixPdqV3Utils.createINT1(birthNumber));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson()
					.setMultipleBirthOrderNumber(PixPdqV3Utils.createINT1(birthNumber));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().setMultipleBirthOrderNumber(PixPdqV3Utils.createINT1(birthNumber));
		}
	}

	/**
	 * Set the patient birth time.
	 *
	 * @param birthTime
	 */
	public void setPatientBirthTime(String birthTime) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().setBirthTime(PixPdqV3Utils.createTS(birthTime));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().setBirthTime(PixPdqV3Utils.createTS(birthTime));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().setBirthTime(PixPdqV3Utils.createTS(birthTime));
		}
	}

	/**
	 * Set whether the patient is deceased
	 *
	 * @param patientDeceased
	 */
	public void setPatientDeceased(boolean patientDeceased) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().setDeceasedInd(PixPdqV3Utils.createBL(patientDeceased));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().setDeceasedInd(PixPdqV3Utils.createBL(patientDeceased));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().setDeceasedInd(PixPdqV3Utils.createBL(patientDeceased));
		}
	}

	/**
	 * Set the patient deceased time.
	 *
	 * @param patientDeceasedTime
	 */
	public void setPatientDeceasedTime(String patientDeceasedTime) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().setDeceasedTime(PixPdqV3Utils.createTS(patientDeceasedTime));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().setDeceasedTime(PixPdqV3Utils.createTS(patientDeceasedTime));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().setDeceasedTime(PixPdqV3Utils.createTS(patientDeceasedTime));
		}

	}

	/**
	 * Set the patient gender to the provided value ("M", "F", or "U")
	 *
	 * @param gender
	 */
	public void setPatientGender(String gender) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person()
					.setAdministrativeGenderCode(PixPdqV3Utils.createCE(gender, "2.16.840.1.113883.5.1", "", ""));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson()
					.setAdministrativeGenderCode(PixPdqV3Utils.createCE(gender, "2.16.840.1.113883.5.1", "", ""));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person()
					.setAdministrativeGenderCode(PixPdqV3Utils.createCE(gender, "2.16.840.1.113883.5.1", "", ""));
		}
	}

	/**
	 * Set the marital status for the patient
	 *
	 * @param maritalStatus
	 */
	public void setPatientMaritalStatus(String maritalStatus) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().setMaritalStatusCode(PixPdqV3Utils.createCE(maritalStatus));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson().setMaritalStatusCode(PixPdqV3Utils.createCE(maritalStatus));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().setMaritalStatusCode(PixPdqV3Utils.createCE(maritalStatus));
		}
	}

	/**
	 * Add a mother's maiden name for the patient.
	 *
	 * @param family
	 * @param given
	 * @param other
	 * @param suffix
	 * @param prefix
	 */
	public void setPatientMothersMaidenName(String family, String given, String other, String suffix, String prefix) {
		var classCode = "PRS";
		CE mthCe = PixPdqV3Utils.createCE("MTH", "2.16.840.1.113883.5.111", "PersonalRelationshipRoleType", "Mother");
		COCTMT030007UVPerson motherRelHolder = getMotherRelationshipHolder(family, given, other, suffix, prefix);

		if (internalObj instanceof PRPAMT201303UV02Person) {
			var motherRelationship = new PRPAMT201303UV02PersonalRelationship();

			motherRelationship.setClassCode(classCode);
			motherRelationship.setCode(mthCe);
			motherRelationship.setRelationshipHolder1(motherRelHolder);

			getPRPAMT201303UV02Person().getPersonalRelationship().add(motherRelationship);
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			var motherRelationship = new PRPAMT201302UV02PersonalRelationship();
			motherRelationship.setClassCode(classCode);
			motherRelationship.setCode(mthCe);
			motherRelationship.setRelationshipHolder1(motherRelHolder);

			getPRPAMT201302UV02PatientPatientPerson().getPersonalRelationship().add(motherRelationship);
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			final var motherRelationship = new PRPAMT201301UV02PersonalRelationship();

			motherRelationship.setClassCode(classCode);
			motherRelationship.setCode(mthCe);
			motherRelationship.setRelationshipHolder1(motherRelHolder);

			getPRPAMT201301UV02Person().getPersonalRelationship().add(motherRelationship);
		}
	}

	/**
	 * Set the religious affiliation for the patient
	 *
	 * @param religiousAffiliation
	 */
	public void setPatientReligiousAffiliation(String religiousAffiliation) {
		if (internalObj instanceof PRPAMT201303UV02Person) {
			getPRPAMT201303UV02Person().setReligiousAffiliationCode(PixPdqV3Utils.createCE(religiousAffiliation));
		} else if (internalObj instanceof PRPAMT201302UV02PatientPatientPerson) {
			getPRPAMT201302UV02PatientPatientPerson()
					.setReligiousAffiliationCode(PixPdqV3Utils.createCE(religiousAffiliation));
		} else if (internalObj instanceof PRPAMT201301UV02Person) {
			getPRPAMT201301UV02Person().setReligiousAffiliationCode(PixPdqV3Utils.createCE(religiousAffiliation));
		}
	}

	public COCTMT030007UVPerson getMotherRelationshipHolder(String family, String given, String other, String suffix,
			String prefix) {
		var motherRelationshipHolder = new COCTMT030007UVPerson();
		motherRelationshipHolder.setClassCode(EntityClass.PSN);
		motherRelationshipHolder.setDeterminerCode(XDeterminerInstanceKind.INSTANCE);
		motherRelationshipHolder.getName().add(PixPdqV3Utils.createPN(family, given, other, suffix, prefix));
		return motherRelationshipHolder;
	}

	public PRPAMT201303UV02Person getPRPAMT201303UV02Person() {
		return (PRPAMT201303UV02Person) internalObj;
	}

	public PRPAMT201302UV02PatientPatientPerson getPRPAMT201302UV02PatientPatientPerson() {
		return (PRPAMT201302UV02PatientPatientPerson) internalObj;
	}

	public PRPAMT201301UV02Person getPRPAMT201301UV02Person() {
		return (PRPAMT201301UV02Person) internalObj;
	}

}
