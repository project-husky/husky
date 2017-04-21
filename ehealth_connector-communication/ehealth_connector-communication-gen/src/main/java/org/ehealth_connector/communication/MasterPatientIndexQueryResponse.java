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

package org.ehealth_connector.communication;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.mpi.MpiQueryResponse;
import org.ehealth_connector.fhir.FhirPatient;

/**
 * The Class MasterPatientIndexQueryResponse.
 */
public class MasterPatientIndexQueryResponse {

	/** The currentNumbers of patients in this query step. */
	private int currentNumbers;

	/** The patients in this query step. */
	private List<Patient> patients;

	/** The remaining numbers of patients for this query. */
	private int remainingNumbers;

	/** query state */
	private boolean success;

	/** The total numbers of patients for this query. */
	private int totalNumbers;

	/**
	 * Instantiates a new master patient index query response.
	 *
	 * @param mpiQueryResponse
	 *            the mpi query response
	 */
	protected MasterPatientIndexQueryResponse(MpiQueryResponse mpiQueryResponse) {
		if (mpiQueryResponse != null) {
			this.success = mpiQueryResponse.getSuccess();
			this.totalNumbers = mpiQueryResponse.getTotalNumbers();
			this.currentNumbers = mpiQueryResponse.getCurrentNumbers();
			this.remainingNumbers = mpiQueryResponse.getRemainingNumbers();
			if ((mpiQueryResponse.getPatients() != null)
					&& (mpiQueryResponse.getPatients().size() > 0)) {
				patients = new ArrayList<Patient>();
				for (final FhirPatient patient : mpiQueryResponse.getPatients()) {
					patients.add(patient.getPatient());
				}
			}
		}
	}

	/**
	 * Gets the current numbers.
	 *
	 * @return the current numbers
	 */
	public int getCurrentNumbers() {
		return currentNumbers;
	}

	/**
	 * Gets the patients from the query.
	 *
	 * @return the patients
	 */
	public List<Patient> getPatients() {
		return patients;
	}

	/**
	 * Gets the remaining numbers of patients in the query.
	 *
	 * @return the remaining numbers
	 */
	public int getRemainingNumbers() {
		return remainingNumbers;
	}

	/**
	 * Query state
	 *
	 * @return true if successful
	 */
	public boolean getSuccess() {
		return success;
	}

	/**
	 * Gets the total numbers of patients from the query.
	 *
	 * @return the total numbers
	 */
	public int getTotalNumbers() {
		return totalNumbers;
	}

}
