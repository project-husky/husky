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
package org.projecthusky.communication.testhelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.hl7.fhir.r4.model.Identifier;

import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.fhir.structures.gen.FhirPatient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * InMemoryMockMpiAdapter to test a basic MPI with no crossmatching of patient
 * for testing Note: No production use, no demographic data is stored, just the
 * identifier.
 */
public class InMemoryMockMpiAdapter {

	static private Map<String, org.projecthusky.fhir.structures.gen.FhirPatient> map = new HashMap<String, FhirPatient>();

	/** The mpi community oid. */
	static private String mpiCommunityOid = UUID.randomUUID().toString();

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** The home community oid */
	private String homeCommunityOid;

	/**
	 * Adds the patient.
	 *
	 * @param patient
	 *            the patient
	 * @return true, if successful
	 */
	public boolean addPatient(FhirPatient patient) {
		if (patient == null) {
			log.debug("patient is null");
			return false;
		}
		boolean retVal = false;

		final String mpiIdendity = UUID.randomUUID().toString();
		final String mapKey = this.getMapKey(patient);
		if (mapKey != null) {
			if (!map.containsKey(mapKey)) {
				final FhirPatient immutablePatient = new FhirPatient();
				// just copied the id of the patient currently, no demographic
				// data
				immutablePatient.setIdentifier(patient.getIdentifier());
				final org.hl7.fhir.r4.model.Identifier id = immutablePatient.addIdentifier();
				id.setSystem(FhirCommon.addUrnOid(mpiCommunityOid));
				id.setValue(mpiIdendity);
				map.put(mapKey, immutablePatient);
				log.info("added patient to mpi with key " + mapKey + " and mpi idendity "
						+ mpiCommunityOid + "," + mpiIdendity);
				retVal = true;
			} else {
				log.error("patient exists already with  " + getHomeCommunityPatientId(patient));
			}
		} else {
			log.error("patient has no homeCommunityPatientId of "
					+ getHomeCommunityPatientId(patient));
		}
		return retVal;
	}

	/**
	 * resets the mpi, mpi data is static.
	 */
	public void clear() {
		map = new HashMap<String, FhirPatient>();
	}

	/**
	 * Gets the home community patient id.
	 *
	 * @param patient
	 *            the patient
	 * @return the home community patient id
	 */
	private String getHomeCommunityPatientId(FhirPatient patient) {
		initHomeCommunityId(patient);
		return getPatientId(patient, FhirCommon.addUrnOid(homeCommunityOid));
	}

	/**
	 * Gets the internal map key.
	 *
	 * @param patient
	 *            the patient
	 * @return the map key
	 */
	private String getMapKey(FhirPatient patient) {
		final String homeCommunityPatientId = getHomeCommunityPatientId(patient);
		if (homeCommunityPatientId == null) {
			return null;
		}
		return getMapKey(homeCommunityPatientId);
	}

	/**
	 * Gets the internal map key.
	 *
	 * @param homeCommunityPatientId
	 *            the home community patient id
	 * @return the map key
	 */
	private String getMapKey(String homeCommunityPatientId) {
		return homeCommunityOid + "-" + homeCommunityPatientId;
	}

	/**
	 * Gets the mpi patient id.
	 *
	 * @param patient
	 *            the patient
	 * @return the mpi patient id
	 */
	private String getMpiPatientId(FhirPatient patient) {
		initHomeCommunityId(patient);
		return getPatientId(patient, FhirCommon.addUrnOid(mpiCommunityOid));
	}

	/**
	 * gets the patient identifier defined by the system which issued the
	 * patient identifier.
	 *
	 * @param patient
	 *            the Patient
	 * @param system
	 *            the system responsible which issued the patient identifer
	 * @return the patient id
	 */
	private String getPatientId(FhirPatient patient, String system) {
		initHomeCommunityId(patient);
		for (final Identifier Identifier : patient.getIdentifier()) {
			if (Identifier.getSystem().equals(system)) {
				return Identifier.getValue();
			}
		}
		return null;
	}

	/**
	 * Inits the home community id.
	 *
	 * @param patient
	 *            the patient
	 */
	private void initHomeCommunityId(FhirPatient patient) {
		if (homeCommunityOid == null) {
			if (patient.getIdentifier().size() == 1) {
				final String system = patient.getIdentifier().get(0).getSystem();
				if (system.length() > 8) {
					homeCommunityOid = system.substring(8);
				} else {
					throw new IllegalStateException("system has to start with urn:oid:");
				}
			} else {
				throw new IllegalStateException("homeCommunityId has to be specified");
			}
		}
	}

	/**
	 * Merge patient.
	 *
	 * @param patient
	 *            the patient
	 * @param obsoleteId
	 *            the obsolete id
	 * @return true, if successful
	 */
	public boolean mergePatient(FhirPatient patient, String obsoleteId) {
		if ((patient == null) || (obsoleteId == null)) {
			log.debug("patient or obosoleId is null");
			return false;
		}
		final String mapKey = this.getMapKey(obsoleteId);
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
	 *            the patient
	 * @return the string
	 */
	public String queryPatientId(FhirPatient patient) {
		return queryPatientId(patient, null, null)[0];
	}

	/**
	 * Query patient id.
	 *
	 * @param patient
	 *            the patient
	 * @param queryDomainOids
	 *            the query domain oids
	 * @param queryDomainNamespaces
	 *            the query domain namespaces
	 * @return the string[]
	 */
	public String[] queryPatientId(FhirPatient patient, String[] queryDomainOids,
			String[] queryDomainNamespaces) {
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
		final String mapKey = this.getMapKey(patient);
		if (mapKey != null) {
			if (map.containsKey(mapKey)) {
				final FhirPatient patientMpi = map.get(mapKey);
				final String[] returnIds = new String[domainOids.length];
				for (int i = 0; i < returnIds.length; ++i) {
					returnIds[i] = getPatientId(patientMpi, FhirCommon.addUrnOid(domainOids[i]));
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
	 * Update patient.
	 *
	 * @param patient
	 *            the patient
	 * @return true, if successful
	 */
	public boolean updatePatient(FhirPatient patient) {
		if (patient == null) {
			log.debug("patient is null");
			return false;
		}
		final String mapKey = this.getMapKey(patient);
		if (mapKey != null) {
			if (map.containsKey(mapKey)) {
				final FhirPatient oldPatient = map.get(mapKey);
				final FhirPatient immutablePatient = new FhirPatient();
				// just copied the id of the patient currently, no demographic
				// data
				immutablePatient.setIdentifier(patient.getIdentifier());
				final Identifier id = immutablePatient.addIdentifier();
				id.setSystem(FhirCommon.addUrnOid(mpiCommunityOid));
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

}
