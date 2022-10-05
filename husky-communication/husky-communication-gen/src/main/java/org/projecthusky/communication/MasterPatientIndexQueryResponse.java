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

package org.projecthusky.communication;

import java.util.ArrayList;
import java.util.List;

import org.projecthusky.common.model.Patient;
import org.projecthusky.communication.mpi.MpiQueryResponse;
import org.projecthusky.fhir.structures.gen.FhirPatient;

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

	private MpiQueryResponse mpiQueryResponse;

	/**
	 * Instantiates a new master patient index query response.
	 *
	 * @param mpiQueryResponse
	 *            the mpi query response
	 */
	protected MasterPatientIndexQueryResponse(MpiQueryResponse mpiQueryResponse) {
		if (mpiQueryResponse != null) {
			this.mpiQueryResponse = mpiQueryResponse;
			this.success = mpiQueryResponse.getSuccess();
			this.totalNumbers = mpiQueryResponse.getTotalNumbers();
			this.currentNumbers = mpiQueryResponse.getCurrentNumbers();
			this.remainingNumbers = mpiQueryResponse.getRemainingNumbers();
			if (mpiQueryResponse.getPatients() != null
					&& !mpiQueryResponse.getPatients().isEmpty()) {
				patients = new ArrayList<>();
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

	public MpiQueryResponse getMpiQueryResponse() {
		return mpiQueryResponse;
	}

}
