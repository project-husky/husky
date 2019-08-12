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
package org.ehealth_connector.communication.mpi.impl;

import java.util.List;

import org.ehealth_connector.communication.mpi.MpiQueryResponse;
import org.ehealth_connector.fhir.structures.gen.FhirPatient;

/**
 * The Class V3PdqQueryResponse implements the MpiQueryResponse
 */
public class V3PdqQueryResponse implements MpiQueryResponse {

	/** The current numbers in this query step. */
	private int currentNumbers;

	/** patients returned in this query step. */
	private List<FhirPatient> patients;

	/** The remaining numbers of patients in the query (continuation). */
	private int remainingNumbers;

	/** query success. */
	private boolean success = false;

	/** The total numbers of patient for whole query. */
	private int totalNumbers;

	/**
	 * Gets the current numbers of returned patients in the query.
	 *
	 * @return the current numbers
	 */
	@Override
	public int getCurrentNumbers() {
		return currentNumbers;
	}

	/**
	 * Gets the patients from the query.
	 *
	 * @return the patients
	 */
	@Override
	public List<FhirPatient> getPatients() {
		return patients;
	}

	/**
	 * Gets the remaining numbers of patients in the query.
	 *
	 * @return the remaining numbers
	 */
	@Override
	public int getRemainingNumbers() {
		return remainingNumbers;
	}

	/**
	 * Query state
	 *
	 * @return true if successful
	 */
	@Override
	public boolean getSuccess() {
		return success;
	}

	/**
	 * Gets the total numbers of patients from the query.
	 *
	 * @return the total numbers
	 */
	@Override
	public int getTotalNumbers() {
		return totalNumbers;
	}

	/**
	 * Sets the current numbers of patient returned in this query step.
	 *
	 * @param currentNumbers
	 *            the new current numbers
	 */
	protected void setCurrentNumbers(int currentNumbers) {
		this.currentNumbers = currentNumbers;
	}

	/**
	 * Sets the patients from the query.
	 *
	 * @param patients
	 *            the new patients
	 */
	protected void setPatients(List<FhirPatient> patients) {
		this.patients = patients;
	}

	/**
	 * Sets the remaining numbers of patients for this query.
	 *
	 * @param remainingNumbers
	 *            the new remaining numbers
	 */
	protected void setRemainingNumbers(int remainingNumbers) {
		this.remainingNumbers = remainingNumbers;
	}

	/**
	 * Sets the success return value of the query.
	 *
	 * @param success
	 *            the new success
	 */
	protected void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Sets the total numbers of patients for this query.
	 *
	 * @param totalNumbers
	 *            the new total numbers
	 */
	protected void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}

}
