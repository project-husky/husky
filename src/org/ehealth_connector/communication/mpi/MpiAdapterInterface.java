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

/**
 * General adapter Inteface for an MPI implementation.
 * 
 * @param <T> a MpiQuery type implementation
 * @param <U> a MpiQueryResponse type implementation
 */
public interface MpiAdapterInterface<T extends MpiQuery, U extends MpiQueryResponse> {

	/**
	 * adds a patient to the mpi.
	 * 
	 * @param patient
	 *            the patient
	 * @return if success true, false otherwise
	 */
	abstract boolean addPatient(FhirPatient patient);

	/**
	 * Gets an empty MpiQuery objects.
	 * 
	 * @return the mpiQuery objects
	 */
	abstract T getMpiQuery();

	/**
	 * a patient referenced with the obsolete id will be merged into supplied
	 * patient.
	 * 
	 * @param patient
	 *            the patient
	 * @param obsoleteId
	 *            the obsolete id
	 * @return if success true, false otherwise
	 */
	abstract boolean mergePatient(FhirPatient patient, String obsoleteId);

	/**
	 * query the mpi with patient id and return the ids in the queried Domains
	 * from the mpi.
	 * 
	 * @param patient
	 *            patient with local Id
	 * @param queryDomainOids
	 *            if provided oid of queried domain, otherwise id of mpi
	 * @param queryDomainNamespaces
	 *            the query domain namespaces (optional, must correspont to the
	 *            queryDomainOids)
	 * @return string array with correspoding identifiers to queryDomainOids
	 */
	abstract String[] queryPatientId(FhirPatient patient, String queryDomainOids[],
			String queryDomainNamespaces[]);

	/**
	 * queries the mpi for patients according to the criteria specified
	 * 
	 * @param mpiQuery
	 *            the mpi query criterias
	 * @return the mpi query response
	 */
	abstract U queryPatients(T mpiQuery);

	/**
	 * updates the demographic information of the patient in the mpi.
	 * 
	 * @param patient
	 *            the patient
	 * @return if success true, false otherwise
	 */
	abstract boolean updatePatient(FhirPatient patient);

}
