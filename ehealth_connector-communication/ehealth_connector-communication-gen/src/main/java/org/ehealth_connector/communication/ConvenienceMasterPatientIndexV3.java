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
package org.ehealth_connector.communication;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.common.communication.AtnaConfig;
import org.ehealth_connector.common.communication.Destination;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Patient;
import org.ehealth_connector.communication.mpi.impl.V3PdqQueryResponse;
import org.ehealth_connector.communication.mpi.impl.V3PixPdqAdapter;
import org.ehealth_connector.communication.mpi.impl.V3PixPdqAdapterConfig;
import org.ehealth_connector.communication.tls.CustomHttpsTLSv11v12SocketFactory;
import org.ehealth_connector.communication.utils.AbstractAxis2Util;
import org.ehealth_connector.fhir.structures.gen.FhirPatient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ConvenienceMasterPatientIndexV3
 *
 * ConvenienceMasterPatientIndexV3 implements the Actor Patient Identity Source
 * from ITI-44 Patient Identity Feed HL7 V3, the Actor Patient Identifier
 * Cross-reference Consumer from ITI-45 PIXV3 Query and as well as the ITI-47
 * PDQ Consumer to communicate with an MPI.
 *
 * <div class="de"> Diese Klasse stellt Methoden für die Kommunikation mit einem
 * Master Patient Index bereit (MPI) Die Kommunikation erfolgt in dieser Klasse
 * mit HL7 V3 (PIX V3, PDQV3) </div>
 */
public class ConvenienceMasterPatientIndexV3 extends CamelService {

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(ConvenienceMasterPatientIndexV3.class);

	static {
		CustomHttpsTLSv11v12SocketFactory.setup();
		AbstractAxis2Util.initAxis2Config();
	}

	/**
	 * adds a patient to the mpi. implements ITI-44 Patient Identity Source –
	 * Add Patient Record
	 *
	 * <div class="de">
	 * <p>
	 * Registriert einen neuen Patienten mit demografischen Personendaten an
	 * einen Master Patient Index (Patient Identity Cross-Reference Manager
	 * Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE
	 * PIX Patient Identity Source</b>
	 * </p>
	 * </div>
	 *
	 * @param patient
	 *            demographic data of the patient
	 * @param homeCommunityOid
	 *            local patient domain (oid) of the source
	 * @param affinityDomain
	 *            affinityDomain configuration with pixDestination,
	 *            homeCommunityId and Atna configuration
	 * @return true, if successful
	 */
	public static boolean addPatientDemographics(Patient patient, String homeCommunityOid,
			AffinityDomain affinityDomain) {
		if (affinityDomain == null) {
			log.error("affinityDomain has to be specified");
			return false;
		}
		final Destination pixSource = affinityDomain.getPixDestination();
		final AtnaConfig atna = affinityDomain.getAtnaConfig();
		final V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(pixSource != null ? pixSource.getUri() : null), null,
				(pixSource != null ? pixSource.getSenderApplicationOid() : null),
				(pixSource != null ? pixSource.getSenderFacilityOid() : null),
				(pixSource != null ? pixSource.getReceiverApplicationOid() : null),
				(pixSource != null ? pixSource.getReceiverFacilityOid() : null), homeCommunityOid,
				null, null, null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null),
				(atna != null ? atna.getAuditEnterpriseSiteID() : null),
				affinityDomain.getOtherIdsOidSet().toArray(new String[0]));
		log.debug("addPatientDemographics, creating V3PixAdapter");
		final V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		log.debug("addPatientDemographics, creating patient");
		final FhirPatient fhirPatient = new FhirPatient(patient);
		log.debug("addPatientDemographics, add patient");
		final boolean ret = v3PixAdapter.addPatient(fhirPatient);
		log.debug("addPatientDemographics, add patient finished");
		return ret;
	}

	/**
	 * Merge patient. implements ITI-44 Patient Identity Source – Patient
	 * Identity Merge
	 *
	 * Patient Registry Duplicates Resolved message indicates that the Patient
	 * Identity Source has done a merge within a specific Patient Identification
	 * Domain. That is, the surviving identifier (patient ID) has subsumed a
	 * duplicate patient identifier.
	 *
	 * <div class="de">
	 * <p>
	 * Vereinigt zwei Patienten im Master Patient Index (Patient Identity
	 * Cross-Reference Manager Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE
	 * PIX Patient Identity Source</b>
	 * </p>
	 * </div>
	 *
	 * @param finalPatient
	 *            the patient with the surviving identifier
	 * @param homeCommunityOid
	 *            local patient domain (oid) of the source
	 * @param mergeObsoleteId
	 *            duplicate patient identifier
	 * @param affinityDomain
	 *            affinityDomain configuration with pixDestination,
	 *            homeCommunityId and Atna configuration
	 * @return true, if successful
	 */
	public static boolean mergePatients(Patient finalPatient, String mergeObsoleteId,
			String homeCommunityOid, AffinityDomain affinityDomain) {

		if (affinityDomain == null) {
			log.error("affinityDomain has to be specified");
			return false;
		}
		final Destination pixSource = affinityDomain.getPixDestination();
		final AtnaConfig atna = affinityDomain.getAtnaConfig();

		final V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(pixSource != null ? pixSource.getUri() : null), null,
				(pixSource != null ? pixSource.getSenderApplicationOid() : null),
				(pixSource != null ? pixSource.getSenderFacilityOid() : null),
				(pixSource != null ? pixSource.getReceiverApplicationOid() : null),
				(pixSource != null ? pixSource.getReceiverFacilityOid() : null), homeCommunityOid,
				null, null, null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null),
				(atna != null ? atna.getAuditEnterpriseSiteID() : null),
				affinityDomain.getOtherIdsOidSet().toArray(new String[0]));
		final V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		if (mergeObsoleteId == null) {
			log.error("no localid specified for oid " + homeCommunityOid);
			return false;
		}
		final boolean ret = v3PixAdapter.mergePatient(new FhirPatient(finalPatient),
				mergeObsoleteId);
		return ret;
	}

	/**
	 * queries the mpi for patient according to the demographics criteria
	 * specified.
	 *
	 * @param mpiQuery
	 *            the mpi query criterias
	 * @param affinityDomain
	 *            affinityDomain configuration with pdqDestination,
	 *            homeCommunityId and Atna configuration
	 * @return query response with patients
	 */
	public static MasterPatientIndexQueryResponse queryPatientDemographics(
			MasterPatientIndexQuery mpiQuery, AffinityDomain affinityDomain) {

		if (affinityDomain == null) {
			log.error("affinityDomain has to be specified");
			return null;
		}
		final Destination pdqQuery = affinityDomain.getPdqDestination();
		final AtnaConfig atna = affinityDomain.getAtnaConfig();

		final V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null, null,
				(pdqQuery != null ? pdqQuery.getUri() : null),
				(pdqQuery != null ? pdqQuery.getSenderApplicationOid() : null),
				(pdqQuery != null ? pdqQuery.getSenderFacilityOid() : null),
				(pdqQuery != null ? pdqQuery.getReceiverApplicationOid() : null),
				(pdqQuery != null ? pdqQuery.getReceiverFacilityOid() : null), null, null, null,
				null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null),
				(atna != null ? atna.getAuditEnterpriseSiteID() : null),
				affinityDomain.getOtherIdsOidSet().toArray(new String[0]));
		final V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		final V3PdqQueryResponse pdqQueryRespones = v3PixAdapter
				.queryPatients(mpiQuery.getV3PdqQuery());
		return new MasterPatientIndexQueryResponse(pdqQueryRespones);
	}

	/**
	 * query the mpi with patient id and return the ids in the queried domains
	 * from the mpi.
	 *
	 * Implements ITI-45 Patient Identifier Cross-reference Consumer Queries the
	 * Patient Identifier Cross-reference Manager for a list of corresponding
	 * patientidentifiers, if any
	 *
	 * <div class="de">
	 * <p>
	 * Fragt eine Patienten-ID beim Master Patient Index ab (Patient Identity
	 * Cross-Reference Manager Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE
	 * PIX Patient Identifier Cross-Reference Concumer</b>
	 * </p>
	 * </div>
	 *
	 * @param patient
	 *            demographic data of the patient
	 * @param homeCommunityOid
	 *            local patient domain (oid) of the source
	 * @param requestedCommunityOIDs
	 *            array of oids for domains to query
	 * @param affinityDomain
	 *            affinityDomain configuration with pixDestination,
	 *            homeCommunityId and Atna configuration
	 * @return list of ids
	 */
	public static List<Identificator> queryPatientId(Patient patient, String homeCommunityOid,
			String[] requestedCommunityOIDs, AffinityDomain affinityDomain) {

		if (affinityDomain == null) {
			log.error("affinityDomain has to be specified");
			return null;
		}
		final Destination pixQuery = affinityDomain.getPixDestination();
		final AtnaConfig atna = affinityDomain.getAtnaConfig();

		final V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(
				(pixQuery != null ? pixQuery.getUri() : null), null, null,
				(pixQuery != null ? pixQuery.getSenderApplicationOid() : null),
				(pixQuery != null ? pixQuery.getSenderFacilityOid() : null),
				(pixQuery != null ? pixQuery.getReceiverApplicationOid() : null),
				(pixQuery != null ? pixQuery.getReceiverFacilityOid() : null), homeCommunityOid,
				null, null, null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null),
				(atna != null ? atna.getAuditEnterpriseSiteID() : null),
				affinityDomain.getOtherIdsOidSet().toArray(new String[0]));
		final V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		final String[] ids = v3PixAdapter.queryPatientId(new FhirPatient(patient),
				requestedCommunityOIDs, null);
		final List<Identificator> list = new ArrayList<>();
		if (requestedCommunityOIDs != null) {
			for (int i = 0; i < requestedCommunityOIDs.length; ++i) {
				String id = "";
				if (i < ids.length) {
					id = ids[i];
				}
				list.add(new Identificator(requestedCommunityOIDs[i], id));
			}
		}
		return list;
	}

	/**
	 * updates the demographic information of the patient in the mpi.
	 *
	 * implements ITI-44 Patient Identity Source – Revise Patient Record updates
	 * the demographic information of the patient in the mpi.
	 *
	 * <div class="de">
	 * <p>
	 * Aktualisiert die demographischen Daten eines Patienten im Master Patient
	 * Index (Patient Identity Cross-Reference Manager Akteur gemäss IHE PIX)
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE
	 * PIX Patient Identity Source</b>
	 * </p>
	 * </div>
	 *
	 * @param patient
	 *            demographic data of the patient
	 * @param homeCommunityOid
	 *            local patient domain (oid) of the source
	 * @param affinityDomain
	 *            affinityDomain configuration with pixDestination,
	 *            homeCommunityId and Atna configuration
	 * @return true, if successful
	 */
	public static boolean updatePatientDemographics(Patient patient, String homeCommunityOid,
			AffinityDomain affinityDomain) {

		if (affinityDomain == null) {
			log.error("affinityDomain has to be specified");
			return false;
		}
		final Destination pixSource = affinityDomain.getPixDestination();
		final AtnaConfig atna = affinityDomain.getAtnaConfig();

		final V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(pixSource != null ? pixSource.getUri() : null), null,
				(pixSource != null ? pixSource.getSenderApplicationOid() : null),
				(pixSource != null ? pixSource.getSenderFacilityOid() : null),
				(pixSource != null ? pixSource.getReceiverApplicationOid() : null),
				(pixSource != null ? pixSource.getReceiverFacilityOid() : null), homeCommunityOid,
				null, null, null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null),
				(atna != null ? atna.getAuditEnterpriseSiteID() : null),
				affinityDomain.getOtherIdsOidSet().toArray(new String[0]));
		final V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		final boolean ret = v3PixAdapter.updatePatient(new FhirPatient(patient));
		return ret;
	}

}
