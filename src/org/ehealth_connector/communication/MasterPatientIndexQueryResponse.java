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

package org.ehealth_connector.communication;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.MpiQueryResponse;

public class MasterPatientIndexQueryResponse {

	private boolean success;
	private int totalNumbers;
	private int position;
	private List<Patient> patients;

	public MasterPatientIndexQueryResponse(MpiQueryResponse mpiQueryResponse) {
		if (mpiQueryResponse != null) {
			this.success = mpiQueryResponse.getSuccess();
			this.totalNumbers = mpiQueryResponse.getTotalNumbers();
			this.position = mpiQueryResponse.getPosition();
			if (mpiQueryResponse.getPatients() != null
					&& mpiQueryResponse.getPatients().size() > 0) {
				patients = new ArrayList<Patient>();
				for (FhirPatient patient : mpiQueryResponse.getPatients()) {
					patients.add(patient.getPatient());
				}
			}
		}
	}

	public boolean getSuccess() {
		return success;
	}

	public int getTotalNumbers() {
		return totalNumbers;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int postion) {
		this.position = postion;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
