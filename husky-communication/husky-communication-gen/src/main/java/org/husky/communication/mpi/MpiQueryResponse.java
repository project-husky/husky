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
package org.husky.communication.mpi;

import java.util.List;

import org.husky.fhir.structures.gen.FhirPatient;

/**
 * The Interface MpiQueryResponse describes a generic Mpi Query Response.
 */
public interface MpiQueryResponse {

	/**
	 * Gets the current numbers of returned patients in the query.
	 *
	 * @return the current numbers
	 */
	abstract int getCurrentNumbers();

	/**
	 * Gets the patients from the query.
	 *
	 * @return the patients
	 */
	abstract List<FhirPatient> getPatients();

	/**
	 * Gets the remaining numbers of patients in the query.
	 *
	 * @return the remaining numbers
	 */
	abstract int getRemainingNumbers();

	/**
	 * Query state
	 *
	 * @return true if successful
	 */
	abstract boolean getSuccess();

	/**
	 * Gets the total numbers of patients from the query.
	 *
	 * @return the total numbers
	 */
	abstract int getTotalNumbers();
}
