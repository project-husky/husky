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
package org.ehealth_connector.communication;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.impl.V3PdqQueryResponse;
import org.ehealth_connector.communication.mpi.impl.V3PixPdqAdapter;
import org.ehealth_connector.communication.mpi.impl.V3PixPdqAdapterConfig;

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
public class ConvenienceMasterPatientIndexV3 {

	static private Log log = LogFactory.getLog(ConvenienceMasterPatientIndexV3.class);

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
	 * @param homeCommunityOID
	 *            local patient domain (oid) of the source
	 * @param dest
	 *            communication endpoint
	 * @param atna
	 *            atna configuration
	 * @return true, if successful
	 */
	public static boolean addPatientDemographics(Patient patient, String homeCommunityOID,
			Destination dest, AtnaConfig atna) {
		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(dest != null ? dest.getPixSourceUri() : null), null,
				(dest != null ? dest.getSenderApplicationOid() : null),
				(dest != null ? dest.getSenderFacilityOid() : null),
				(dest != null ? dest.getReceiverApplicationOid() : null),
				(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
				null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), null);
		log.debug("addPatientDemographics, creating V3PixAdapter");
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		log.debug("addPatientDemographics, creating patient");
		FhirPatient fhirPatient = new FhirPatient(patient);
		log.debug("addPatientDemographics, add patient");
		boolean ret = v3PixAdapter.addPatient(fhirPatient);
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
	 * @param mergeObsoleteId
	 *            duplicate patient identifier
	 * @param homeCommunityOID
	 *            local patient domain (oid) of the source
	 * @param dest
	 *            communication endpoint
	 * @param atna
	 *            atna configuration
	 * @return true, if successful
	 */
	public static boolean mergePatients(Patient finalPatient, String mergeObsoleteId,
			String homeCommunityOID, Destination dest, AtnaConfig atna) {

		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(dest != null ? dest.getPixSourceUri() : null), null,
				(dest != null ? dest.getSenderApplicationOid() : null),
				(dest != null ? dest.getSenderFacilityOid() : null),
				(dest != null ? dest.getReceiverApplicationOid() : null),
				(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
				null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), null);
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		if (mergeObsoleteId == null) {
			log.error("no localid specified for oid " + homeCommunityOID);
			return false;
		}
		boolean ret = v3PixAdapter.mergePatient(new FhirPatient(finalPatient), mergeObsoleteId);
		return ret;
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
	 * @param homeCommunityOID
	 *            local patient domain (oid) of the source
	 * @param requestedCommunityOIDs
	 *            array of oids for domains to query
	 * @param dest
	 *            communication endpoint
	 * @param atna
	 *            atna configuration
	 * @return list of ids
	 */
	public static List<Identificator> queryPatientID(Patient patient, String homeCommunityOID,
			String[] requestedCommunityOIDs, Destination dest, AtnaConfig atna) {

		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(
				(dest != null ? dest.getPixQueryUri() : null), null, null,
				(dest != null ? dest.getSenderApplicationOid() : null),
				(dest != null ? dest.getSenderFacilityOid() : null),
				(dest != null ? dest.getReceiverApplicationOid() : null),
				(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
				null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), null);
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		String ids[] = v3PixAdapter.queryPatientId(new FhirPatient(patient), requestedCommunityOIDs,
				null);
		ArrayList<Identificator> list = new ArrayList<Identificator>();
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
	 * queries the mpi for patients according to the criteria specified
	 * 
	 * @param mpiQuery
	 *            the mpi query criterias
	 * @return the mpi query response
	 */
	public static MasterPatientIndexQueryResponse queryPatients(MasterPatientIndexQuery mpiQuery,
			String homeCommunityOID, Destination dest, AtnaConfig atna) {

		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null, null,
				(dest != null ? dest.getPdqQueryUri() : null),
				(dest != null ? dest.getSenderApplicationOid() : null),
				(dest != null ? dest.getSenderFacilityOid() : null),
				(dest != null ? dest.getReceiverApplicationOid() : null),
				(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
				null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), null);
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		V3PdqQueryResponse pdqQueryRespones = v3PixAdapter.queryPatients(mpiQuery.getV3PdqQuery());
		return new MasterPatientIndexQueryResponse(pdqQueryRespones);
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
	 * @param homeCommunityOID
	 *            local patient domain (oid) of the source
	 * @param dest
	 *            communication endpoint
	 * @param atna
	 *            atna configuration
	 * @return true, if successful
	 */
	public static boolean updatePatientDemographics(Patient patient, String homeCommunityOID,
			Destination dest, AtnaConfig atna) {
		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(dest != null ? dest.getPixSourceUri() : null), null,
				(dest != null ? dest.getSenderApplicationOid() : null),
				(dest != null ? dest.getSenderFacilityOid() : null),
				(dest != null ? dest.getReceiverApplicationOid() : null),
				(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
				null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), null);
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		boolean ret = v3PixAdapter.updatePatient(new FhirPatient(patient));
		return ret;
	}

}
