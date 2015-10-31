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
package org.ehealth_connector.communication.mpi;

import java.util.List;

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
