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

	static final private org.openhealthtools.mdht.uml.cda.CDAFactory factory = org.openhealthtools.mdht.uml.cda.CDAFactory.eINSTANCE;

	static private Log log = LogFactory.getLog(ConvenienceMasterPatientIndexV3.class);

	static {
		// org.openhealthtools.mdht.uml.cda.CDAFactory.eINSTANCE needs to be
		// initialized before org.hl7.v3.impl.V3FactoryImpl, otherwise a
		// classcast Exception occurs
		// java.lang.ClassCastException: org.hl7.v3.impl.V3FactoryImpl cannot be
		// cast to org.openhealthtools.mdht.uml.cda.CDAFactory
		if (factory == null) {
			throw new ExceptionInInitializerError();
		}
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
		Destination pixSource = affinityDomain.getPixDestination();
		AtnaConfig atna = affinityDomain.getAtnaConfig();
		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(pixSource != null ? pixSource.getUri() : null), null,
				(pixSource != null ? pixSource.getSenderApplicationOid() : null),
				(pixSource != null ? pixSource.getSenderFacilityOid() : null),
				(pixSource != null ? pixSource.getReceiverApplicationOid() : null),
				(pixSource != null ? pixSource.getReceiverFacilityOid() : null), homeCommunityOid,
				null, null, null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), affinityDomain.getOtherIdsOidSet()
						.toArray(new String[0]));
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
		Destination pixSource = affinityDomain.getPixDestination();
		AtnaConfig atna = affinityDomain.getAtnaConfig();

		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(pixSource != null ? pixSource.getUri() : null), null,
				(pixSource != null ? pixSource.getSenderApplicationOid() : null),
				(pixSource != null ? pixSource.getSenderFacilityOid() : null),
				(pixSource != null ? pixSource.getReceiverApplicationOid() : null),
				(pixSource != null ? pixSource.getReceiverFacilityOid() : null), homeCommunityOid,
				null, null, null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), affinityDomain.getOtherIdsOidSet()
						.toArray(new String[0]));
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		if (mergeObsoleteId == null) {
			log.error("no localid specified for oid " + homeCommunityOid);
			return false;
		}
		boolean ret = v3PixAdapter.mergePatient(new FhirPatient(finalPatient), mergeObsoleteId);
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
		Destination pdqQuery = affinityDomain.getPdqDestination();
		AtnaConfig atna = affinityDomain.getAtnaConfig();

		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null, null,
				(pdqQuery != null ? pdqQuery.getUri() : null),
				(pdqQuery != null ? pdqQuery.getSenderApplicationOid() : null),
				(pdqQuery != null ? pdqQuery.getSenderFacilityOid() : null),
				(pdqQuery != null ? pdqQuery.getReceiverApplicationOid() : null),
				(pdqQuery != null ? pdqQuery.getReceiverFacilityOid() : null), null, null, null,
				null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), affinityDomain.getOtherIdsOidSet()
						.toArray(new String[0]));
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		V3PdqQueryResponse pdqQueryRespones = v3PixAdapter.queryPatients(mpiQuery.getV3PdqQuery());
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
		Destination pixQuery = affinityDomain.getPixDestination();
		AtnaConfig atna = affinityDomain.getAtnaConfig();

		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(
				(pixQuery != null ? pixQuery.getUri() : null), null, null,
				(pixQuery != null ? pixQuery.getSenderApplicationOid() : null),
				(pixQuery != null ? pixQuery.getSenderFacilityOid() : null),
				(pixQuery != null ? pixQuery.getReceiverApplicationOid() : null),
				(pixQuery != null ? pixQuery.getReceiverFacilityOid() : null), homeCommunityOid,
				null, null, null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), affinityDomain.getOtherIdsOidSet()
						.toArray(new String[0]));
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		String ids[] = v3PixAdapter.queryPatientId(new FhirPatient(patient),
				requestedCommunityOIDs, null);
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
		Destination pixSource = affinityDomain.getPixDestination();
		AtnaConfig atna = affinityDomain.getAtnaConfig();

		V3PixPdqAdapterConfig v3PixAdapterConfig = new V3PixPdqAdapterConfig(null,
				(pixSource != null ? pixSource.getUri() : null), null,
				(pixSource != null ? pixSource.getSenderApplicationOid() : null),
				(pixSource != null ? pixSource.getSenderFacilityOid() : null),
				(pixSource != null ? pixSource.getReceiverApplicationOid() : null),
				(pixSource != null ? pixSource.getReceiverFacilityOid() : null), homeCommunityOid,
				null, null, null, (atna != null ? atna.getAuditRepositoryUri() : null),
				(atna != null ? atna.getAuditSourceId() : null), affinityDomain.getOtherIdsOidSet()
						.toArray(new String[0]));
		V3PixPdqAdapter v3PixAdapter = new V3PixPdqAdapter(v3PixAdapterConfig);
		boolean ret = v3PixAdapter.updatePatient(new FhirPatient(patient));
		return ret;
	}

}
