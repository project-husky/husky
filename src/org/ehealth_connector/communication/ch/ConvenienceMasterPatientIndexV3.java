package org.ehealth_connector.communication.ch;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.AtnaConfig;
import org.ehealth_connector.communication.Destination;
import org.ehealth_connector.communication.Response;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.impl.V3PixAdapter;
import org.ehealth_connector.communication.mpi.impl.V3PixAdapterConfig;

/**
 * <p>
 * Diese Klasse stellt Methoden für die Kommunikation mit einem Master Patient Index bereit (MPI)
 * Die Kommunikation erfolgt in dieser Klasse mit HL7 V3 (PIX V3)
 * 
 * Die Klasse implementiert folgende IHE Akteure und Transaktionen:
 * <ul>
 * <li><b>IHE PIX V3 Patient Identity Source Akteur</b></li>
 * <ul>
 * <li>[ITI-44] Patient Identity Feed</li>
 * </ul>
 * <li><b>IHE PIX V3 Patient Identifier Cross-Reference Consumer Akteur</b></li>
 * <ul>
 * <li>[ITI-45] PIX Query</li>
 * </ul>
 * </ul>
 * </p>
 */
public class ConvenienceMasterPatientIndexV3 {

	static private Log log = LogFactory.getLog(ConvenienceMasterPatientIndexV3.class);


	/**
	 * <p>
	 * Registriert einen neuen Patienten mit demografischen Personendaten an einen Master Patient
	 * Index (Patient Identity Cross-Reference Manager Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX Patient Identity
	 * Source</b>
	 * </p>
	 * 
	 * @param patient demografische Personendaten eines Patienten
	 * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
	 * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param atna ATNA Konfiguration
	 * @return Status der Übertragung
	 */
	public static Response addPatientDemographics(Patient patient, String homeCommunityOID,
			Destination dest, AtnaConfig atna) {
		V3PixAdapterConfig v3PixAdapterConfig =
				new V3PixAdapterConfig(null, (dest != null ? dest.getPixSourceUri() : null),
						(dest != null ? dest.getSenderApplicationOid() : null),
						(dest != null ? dest.getSenderFacilityOid() : null),
						(dest != null ? dest.getReceiverApplicationOid() : null),
						(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
						null, (atna != null ? atna.getAuditRepositoryUri() : null),
						(atna != null ? atna.getAuditSourceId() : null));
		V3PixAdapter v3PixAdapter = new V3PixAdapter(v3PixAdapterConfig);
		boolean ret = v3PixAdapter.addPatient(new FhirPatient(patient));
		Response response = new Response(null, null, ret);
		return response;
	}

	/**
	 * <p>
	 * Vereinigt zwei Patienten im Master Patient Index (Patient Identity Cross-Reference Manager
	 * Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX Patient Identity
	 * Source</b>
	 * </p>
	 * 
	 * @param finalPatient demografische Personendaten des finalen Patienten (Dieser Patient soll im
	 *        MPI verbleiben)
	 * @param mergeObsoleteId id des Patienten, welcher mit dem finalen
	 *        Patienten vereinigt wird
	 * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
	 * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param atna ATNA Konfiguration
	 * @return Status der Übertragung
	 */
	public static Response mergePatients(Patient finalPatient, String mergeObsoleId,
			String homeCommunityOID, Destination dest, AtnaConfig atna) {

		V3PixAdapterConfig v3PixAdapterConfig =
				new V3PixAdapterConfig(null, (dest != null ? dest.getPixSourceUri() : null),
						(dest != null ? dest.getSenderApplicationOid() : null),
						(dest != null ? dest.getSenderFacilityOid() : null),
						(dest != null ? dest.getReceiverApplicationOid() : null),
						(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
						null, (atna != null ? atna.getAuditRepositoryUri() : null),
						(atna != null ? atna.getAuditSourceId() : null));
		V3PixAdapter v3PixAdapter = new V3PixAdapter(v3PixAdapterConfig);
		if (mergeObsoleId == null) {
			// FIXME add error message to response
			log.error("no localid specified for oid " + homeCommunityOID);
			return new Response(null, null, false);
		}
		boolean ret =
				v3PixAdapter.mergePatient(new FhirPatient(finalPatient), mergeObsoleId);
		Response response = new Response(null, null, ret);
		return response;
	}

	/**
	 * <p>
	 * Fragt eine Patienten-ID beim Master Patient Index ab (Patient Identity Cross-Reference Manager
	 * Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX Patient Identifier
	 * Cross-Reference Concumer</b>
	 * </p>
	 * 
	 * @param patient demografische Personendaten eines Patienten
	 * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
	 * @param requestedCommunityOID OID der gewünschten Patienten Identifikationsdomäne
	 * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param atna ATNA Konfiguration
	 * @return Patienten-ID in der requestedCommunityOID
	 * @throws Exception
	 */
	public static ArrayList<Identificator> queryPatientID(Patient patient, String homeCommunityOID,
			String[] requestedCommunityOIDs, Destination dest, AtnaConfig atna, Response response) {

		V3PixAdapterConfig v3PixAdapterConfig =
				new V3PixAdapterConfig((dest != null ? dest.getPixQueryUri() : null), null,
						(dest != null ? dest.getSenderApplicationOid() : null),
						(dest != null ? dest.getSenderFacilityOid() : null),
						(dest != null ? dest.getReceiverApplicationOid() : null),
						(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
						null, (atna != null ? atna.getAuditRepositoryUri() : null),
						(atna != null ? atna.getAuditSourceId() : null));
		V3PixAdapter v3PixAdapter = new V3PixAdapter(v3PixAdapterConfig);
		String ids[] =
				v3PixAdapter.queryPatientId(new FhirPatient(patient), requestedCommunityOIDs, null);
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		if (requestedCommunityOIDs != null) {
			for (int i = 0; i < requestedCommunityOIDs.length; ++i) {
				String id = "";
				if (i<ids.length) {
					id = ids[i];
				}
				list.add(new Identificator(requestedCommunityOIDs[i], id));
			}
		}
		return list;
	}

	/**
	 * <p>
	 * Aktualiesiert die demographischen Daten eines Patienten im Master Patient Index (Patient
	 * Identity Cross-Reference Manager Akteur gemäss IHE PIX)
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX Patient Identity
	 * Source</b>
	 * </p>
	 * 
	 * @param patient demografische Personendaten eines Patienten
	 * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
	 * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param atna ATNA Konfiguration
	 * @return Status der Übertragung
	 */
	public static Response updatePatientDemographics(Patient patient, String homeCommunityOID,
			Destination dest, AtnaConfig atna) {
		V3PixAdapterConfig v3PixAdapterConfig =
				new V3PixAdapterConfig(null, (dest != null ? dest.getPixSourceUri() : null),
						(dest != null ? dest.getSenderApplicationOid() : null),
						(dest != null ? dest.getSenderFacilityOid() : null),
						(dest != null ? dest.getReceiverApplicationOid() : null),
						(dest != null ? dest.getReceiverFacilityOid() : null), homeCommunityOID, null, null,
						null, (atna != null ? atna.getAuditRepositoryUri() : null),
						(atna != null ? atna.getAuditSourceId() : null));
		V3PixAdapter v3PixAdapter = new V3PixAdapter(v3PixAdapterConfig);
		boolean ret = v3PixAdapter.updatePatient(new FhirPatient(patient));
		Response response = new Response(null, null, ret);
		return response;
	}


}
