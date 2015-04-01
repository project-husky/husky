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
package org.ehealth_connector.communication.mpi.impl;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.MpiAdapterInterface;
import org.openhealthtools.ihe.utils.UUID;

import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;

/**
 * InMemoryMockMpiAdapter to test a basic MPI with no crossmatching of patient
 * for testing Note: No production use, no demographic data is stored, just the
 * identifier.
 */
public class InMemoryMockMpiAdapter implements MpiAdapterInterface {

	static private HashMap<String, FhirPatient> map = new HashMap<String, FhirPatient>();

	/** The mpi community oid. */
	static private String mpiCommunityOid = UUID.generate();

	private Log log = LogFactory.getLog(InMemoryMockMpiAdapter.class);

	/** The home community oid */
	private String homeCommunityOid;

	/**
	 * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#addPatient(org.ehealth_connector.communication.mpi.FhirPatient)
	 *      note: no demographic information is stored
	 */
	@Override
	public boolean addPatient(FhirPatient patient) {
		if (patient == null) {
			log.debug("patient is null");
			return false;
		}
		String mpiIdendity = UUID.generate();
		String mapKey = this.getMapKey(patient);
		if (mapKey != null) {
			if (map.containsKey(mapKey)) {
				log.error("patient exists already with  " + getHomeCommunityPatientId(patient));
				return false;
			}
			FhirPatient immutablePatient = new FhirPatient();
			// just copied the id of the patient currently, no demographic data
			immutablePatient.setIdentifier(patient.getIdentifier());
			IdentifierDt id = immutablePatient.addIdentifier();
			id.setSystem("urn:oid:" + mpiCommunityOid);
			id.setValue(mpiIdendity);
			map.put(mapKey, immutablePatient);
			log.info("added patient to mpi with key " + mapKey + " and mpi idendity " + mpiCommunityOid
					+ "," + mpiIdendity);
			return true;
		} else {
			log.error("patient has no homeCommunityPatientId of " + getHomeCommunityPatientId(patient));
		}
		return false;
	}

	/**
	 * resets the mpi, mpi data is static.
	 */
	public void clear() {
		map = new HashMap<String, FhirPatient>();
	}

	/**
	 * Merge patient.
	 * 
	 * @param patient
	 *          the patient
	 * @param obsoleteId
	 *          the obsolete id
	 * @return true, if successful
	 * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#mergePatient(FhirPatient
	 *      patient, String obsoleteId)
	 */
	@Override
	public boolean mergePatient(FhirPatient patient, String obsoleteId) {
		if (patient == null || obsoleteId == null) {
			log.debug("patient or obosoleId is null");
			return false;
		}
		String mapKey = this.getMapKey(obsoleteId);
		if (mapKey != null) {
			if (map.containsKey(mapKey)) {
				map.put(mapKey, patient);
				return true;
			}
			log.error("patient not found in mpi " + patient);
		} else {
			log.error("no patient id provided " + patient);
		}
		return false;
	}

	/**
	 * Query patient id.
	 * 
	 * @param patient
	 *          the patient
	 * @return the string
	 */
	public String queryPatientId(FhirPatient patient) {
		return queryPatientId(patient, null, null)[0];
	}

	/**
	 * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#queryPatientId(org.ehealth_connector.communication.mpi.FhirPatient,
	 *      java.lang.String[], java.lang.String[])
	 */
	@Override
	public String[] queryPatientId(FhirPatient patient, String queryDomainOids[],
			String queryDomainNamespaces[]) {
		String[] domainOids = null;
		if (queryDomainOids != null) {
			domainOids = queryDomainOids;
		} else {
			domainOids = new String[1];
			domainOids[0] = mpiCommunityOid;
		}
		if (patient == null) {
			log.debug("patient is null");
			return null;
		}
		String mapKey = this.getMapKey(patient);
		if (mapKey != null) {
			if (map.containsKey(mapKey)) {
				FhirPatient patientMpi = map.get(mapKey);
				String returnIds[] = new String[domainOids.length];
				for (int i = 0; i < returnIds.length; ++i) {
					returnIds[i] = getPatientId(patientMpi, "urn:oid:" + domainOids[i]);
				}
				return returnIds;
			}
			log.error("patient not found in mpi " + patient);
		} else {
			log.error("no patient id provided " + patient);
		}
		return null;
	}

	/**
	 * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#updatePatient(org.ehealth_connector.communication.mpi.FhirPatient)
	 */
	@Override
	public boolean updatePatient(FhirPatient patient) {
		if (patient == null) {
			log.debug("patient is null");
			return false;
		}
		String mapKey = this.getMapKey(patient);
		if (mapKey != null) {
			if (map.containsKey(mapKey)) {
				FhirPatient oldPatient = map.get(mapKey);
				FhirPatient immutablePatient = new FhirPatient();
				// just copied the id of the patient currently, no demographic
				// data
				immutablePatient.setIdentifier(patient.getIdentifier());
				IdentifierDt id = immutablePatient.addIdentifier();
				id.setSystem("urn:oid:" + mpiCommunityOid);
				id.setValue(getMpiPatientId(oldPatient));
				map.put(mapKey, immutablePatient);
				return true;
			}
			log.error("patient not found in mpi " + patient);
		} else {
			log.error("no patient id provided " + patient);
		}
		return false;
	}

	/**
	 * Gets the home community patient id.
	 * 
	 * @param patient
	 *          the patient
	 * @return the home community patient id
	 */
	private String getHomeCommunityPatientId(FhirPatient patient) {
		initHomeCommunityId(patient);
		return getPatientId(patient, "urn:oid:" + homeCommunityOid);
	}

	/**
	 * Gets the internal map key.
	 * 
	 * @param patient
	 *          the patient
	 * @return the map key
	 */
	private String getMapKey(FhirPatient patient) {
		String homeCommunityPatientId = getHomeCommunityPatientId(patient);
		if (homeCommunityPatientId == null) {
			return null;
		}
		return getMapKey(homeCommunityPatientId);
	}

	/**
	 * Gets the internal map key.
	 * 
	 * @param homeCommunityPatientId
	 *          the home community patient id
	 * @return the map key
	 */
	private String getMapKey(String homeCommunityPatientId) {
		return homeCommunityOid + "-" + homeCommunityPatientId;
	}

	/**
	 * Gets the mpi patient id.
	 * 
	 * @param patient
	 *          the patient
	 * @return the mpi patient id
	 */
	private String getMpiPatientId(FhirPatient patient) {
		initHomeCommunityId(patient);
		return getPatientId(patient, "urn:oid:" + mpiCommunityOid);
	}

	/**
	 * gets the patient identifier defined by the system which issued the patient
	 * identifier.
	 * 
	 * @param patient
	 *          the Patient
	 * @param system
	 *          the system responsible which issued the patient identifer
	 * @return the patient id
	 */
	private String getPatientId(FhirPatient patient, String system) {
		initHomeCommunityId(patient);
		for (IdentifierDt identifierDt : patient.getIdentifier()) {
			if (identifierDt.getSystem().equals(system)) {
				return identifierDt.getValue();
			}
		}
		return null;
	}

	/**
	 * Inits the home community id.
	 * 
	 * @param patient
	 *          the patient
	 */
	private void initHomeCommunityId(FhirPatient patient) {
		if (homeCommunityOid == null) {
			if (patient.getIdentifier().size() == 1) {
				String system = patient.getIdentifier().get(0).getSystem();
				if (system.length() > 8) {
					// "urn:oid:"+
					homeCommunityOid = system.substring(8);
				} else {
					throw new IllegalStateException("system has to start with urn:oid:");
				}
			} else {
				throw new IllegalStateException("homeCommunityId has to be specified");
			}
		}
	}

}
