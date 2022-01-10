package org.husky.communication.mpi.impl;

import org.husky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.datatypes.CS;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Patient;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02Patient;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientId;
import net.ihe.gazelle.hl7v3.prpamt201302UV02.PRPAMT201302UV02PatientStatusCode;
import net.ihe.gazelle.hl7v3.prpamt201303UV02.PRPAMT201303UV02Patient;

public class PixPdqSubjectPatient {

	private Object internalObj;
	private String patientId = "";

	public PixPdqSubjectPatient(Object obj) {

		this.internalObj = obj;
		String classCode = "PAT";
		CS activeCode = PixPdqV3Utils.createCS("active");
		if (obj instanceof PRPAMT201301UV02Patient) {
			// set the patient classcode to "PAT"
			getPRPAMT201301UV02Patient().setClassCode(classCode);

			// set the statusCode
			getPRPAMT201301UV02Patient().setStatusCode(activeCode);
		} else if (obj instanceof PRPAMT201302UV02Patient) {
			// set the patient classcode to "PAT"
			getPRPAMT201302UV02Patient().setClassCode(classCode);

			// set the statusCode
			var statusCode = new PRPAMT201302UV02PatientStatusCode();
			statusCode.setCode("active");
			getPRPAMT201302UV02Patient().setStatusCode(statusCode);
		} else if (obj instanceof PRPAMT201303UV02Patient) {
			// set the patient classcode to "PAT"
			getPRPAMT201303UV02Patient().setClassCode(classCode);

			// set the statusCode
			getPRPAMT201303UV02Patient().setStatusCode(activeCode);
		}

	}

	/**
	 * Add a confidentiality code to the patient
	 *
	 * @param code
	 */
	public void addPatientConfidentialityCode(String code) {
		if (internalObj instanceof PRPAMT201301UV02Patient) {
			getPRPAMT201301UV02Patient().getConfidentialityCode().add(PixPdqV3Utils.createCE(code));
		} else if (internalObj instanceof PRPAMT201302UV02Patient) {
			getPRPAMT201302UV02Patient().getConfidentialityCode().add(PixPdqV3Utils.createCE(code));
		} else if (internalObj instanceof PRPAMT201303UV02Patient) {
			getPRPAMT201303UV02Patient().getConfidentialityCode().add(PixPdqV3Utils.createCE(code));
		}

	}

	/**
	 * Set the patient id
	 *
	 * @param extension
	 * @param root
	 * @param namespace
	 */
	public void addPatientID(String extension, String root, String namespace) {
		final var idString = new StringBuilder();
		idString.append(extension) //
				.append("^^^");
		if (namespace != null) {
			idString.append(namespace);
		}
		idString.append("&") //
				.append(root) //
				.append("&ISO");
		patientId = idString.toString();

		if (internalObj instanceof PRPAMT201301UV02Patient) {
			getPRPAMT201301UV02Patient().getId().add(PixPdqV3Utils.createII(root, extension, namespace));
		} else if (internalObj instanceof PRPAMT201302UV02Patient) {
			var prpamPatientId = new PRPAMT201302UV02PatientId();

			if (null != root && !root.isEmpty())
				prpamPatientId.setRoot(root);
			if (null != extension && !extension.isEmpty())
				prpamPatientId.setExtension(extension);
			if (null != namespace && !namespace.isEmpty())
				prpamPatientId.setAssigningAuthorityName(namespace);

			getPRPAMT201302UV02Patient().getId().add(prpamPatientId);
		} else if (internalObj instanceof PRPAMT201303UV02Patient) {
			getPRPAMT201303UV02Patient().getId().add(PixPdqV3Utils.createII(root, extension, namespace));
		}

	}

	/**
	 * Set Patient Very Important Person code
	 *
	 * @param code
	 */
	public void setPatientVeryImportantPerson(String code) {

		if (internalObj instanceof PRPAMT201301UV02Patient) {
			getPRPAMT201301UV02Patient().setVeryImportantPersonCode(PixPdqV3Utils.createCE(code));
		} else if (internalObj instanceof PRPAMT201302UV02Patient) {
			getPRPAMT201302UV02Patient().setVeryImportantPersonCode(PixPdqV3Utils.createCE(code));
		} else if (internalObj instanceof PRPAMT201303UV02Patient) {
			getPRPAMT201303UV02Patient().setVeryImportantPersonCode(PixPdqV3Utils.createCE(code));
		}

	}

	public void setProviderOrganization(String organizationOID, String organizationName, String telecomValue) {
		if (internalObj instanceof PRPAMT201301UV02Patient) {
			getPRPAMT201301UV02Patient().setProviderOrganization(
					PixPdqV3Utils.createCOCTMT150003UV03Organization(organizationOID, organizationName, telecomValue));
		} else if (internalObj instanceof PRPAMT201302UV02Patient) {
			getPRPAMT201302UV02Patient().setProviderOrganization(
					PixPdqV3Utils.createCOCTMT150003UV03Organization(organizationOID, organizationName, telecomValue));
		} else if (internalObj instanceof PRPAMT201303UV02Patient) {
			getPRPAMT201303UV02Patient().setProviderOrganization(
					PixPdqV3Utils.createCOCTMT150003UV03Organization(organizationOID, organizationName, telecomValue));
		}

	}

	/**
	 * Get the patient ID
	 *
	 * @return String - the patient id
	 */
	public String getPatientId() {
		return patientId;
	}

	public PRPAMT201301UV02Patient getPRPAMT201301UV02Patient() {
		return (PRPAMT201301UV02Patient) internalObj;
	}

	public PRPAMT201302UV02Patient getPRPAMT201302UV02Patient() {
		return (PRPAMT201302UV02Patient) internalObj;
	}

	public PRPAMT201303UV02Patient getPRPAMT201303UV02Patient() {
		return (PRPAMT201303UV02Patient) internalObj;
	}

}
