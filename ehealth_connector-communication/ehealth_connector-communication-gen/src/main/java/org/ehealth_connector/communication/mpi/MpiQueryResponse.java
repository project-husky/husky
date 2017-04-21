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
package org.ehealth_connector.communication.mpi;

import java.util.List;

import org.ehealth_connector.fhir.FhirPatient;

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
