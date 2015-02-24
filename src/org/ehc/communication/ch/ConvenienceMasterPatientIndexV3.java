package org.ehc.communication.ch;

import java.net.URI;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehc.common.Identificator;
import org.ehc.common.Patient;
import org.ehc.communication.Destination;
import org.ehc.communication.Response;
import org.ehc.communication.mpi.FhirPatient;
import org.ehc.communication.mpi.impl.V3PixAdapter;
import org.ehc.communication.mpi.impl.V3PixAdapterConfig;

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
   * Fragt eine Patienten-ID beim Master Patient Index ab (Patient Identity Cross-Reference Manager
   * Akteur gemäss IHE PIX).
   * </p>
   * <p>
   * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX Patient Identifier
   * Cross-Reference Concumer</b>
   * </p>
   * 
   * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
   * @param patient demografische Personendaten eines Patienten
   * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
   * @param requestedCommunityOID OID der gewünschten Patienten Identifikationsdomäne
   * @return Patienten-ID in der requestedCommunityOID
   * @throws Exception
   */
  public static ArrayList<Identificator> queryPatientID(Destination dest, Patient patient,
      String homeCommunityOID, String[] requestedCommunityOIDs) throws Exception {
    // FIXME should also not an Response Object returned?
    URI pixQueryUri = null; // FIXME need to add configuration parameters
    String senderApplicationOid = null; // FIXME need to add configuration parameters
    String senderFacilityOid = null; // FIXME need to add configuration parameters
    String receiverApplicationOid = null; // FIXME need to add configuration parameters
    String receiverFacilityOid = null; // FIXME need to add configuration parameters
    String auditRepositoryUri = null; // FIXME need to add configuration parameters
    String auditSourceId = null; // FIXME need to add configuration parameters

    V3PixAdapterConfig v3PixAdapterConfig =
        new V3PixAdapterConfig(pixQueryUri, null, senderApplicationOid, senderFacilityOid,
            receiverApplicationOid, receiverFacilityOid, homeCommunityOID, null, null, null,
            auditRepositoryUri, auditSourceId);

    V3PixAdapter v3PixAdapter = new V3PixAdapter(v3PixAdapterConfig);
    String ids[] =
        v3PixAdapter.queryPatientId(new FhirPatient(patient), requestedCommunityOIDs, null);
    ArrayList<Identificator> list = new ArrayList<Identificator>();
    if (ids != null) {
      for (int i = 0; i < ids.length; ++i) {
        list.add(new Identificator(requestedCommunityOIDs[i], ids[i]));
      }
    }
    return list;
  }

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
   * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
   * @param patient demografische Personendaten eines Patienten
   * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
   * @return Status der Übertragung
   * @throws Exception
   */
  public static Response addPatientDemographics(Destination dest, Patient patient,
      String homeCommunityOID) throws Exception {

    URI pixSourceUri = null; // FIXME need to add configuration parameters
    String senderApplicationOid = null; // FIXME need to add configuration parameters
    String senderFacilityOid = null; // FIXME need to add configuration parameters
    String receiverApplicationOid = null; // FIXME need to add configuration parameters
    String receiverFacilityOid = null; // FIXME need to add configuration parameters
    String auditRepositoryUri = null; // FIXME need to add configuration parameters
    String auditSourceId = null; // FIXME need to add configuration parameters

    V3PixAdapterConfig v3PixAdapterConfig =
        new V3PixAdapterConfig(null, pixSourceUri, senderApplicationOid, senderFacilityOid,
            receiverApplicationOid, receiverFacilityOid, homeCommunityOID, null, null, null,
            auditRepositoryUri, auditSourceId);

    V3PixAdapter v3PixAdapter = new V3PixAdapter(v3PixAdapterConfig);
    boolean ret = v3PixAdapter.addPatient(new FhirPatient(patient));
    Response response = new Response(null, null, ret);
    return response;
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
   * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
   * @param patient demografische Personendaten eines Patienten
   * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
   * @return Status der Übertragung
   * @throws Exception
   */
  public static Response updatePatientDemographics(Destination dest, Patient patient,
      String homeCommunityOID) throws Exception {

    URI pixSourceUri = null; // FIXME need to add configuration parameters
    String senderApplicationOid = null; // FIXME need to add configuration parameters
    String senderFacilityOid = null; // FIXME need to add configuration parameters
    String receiverApplicationOid = null; // FIXME need to add configuration parameters
    String receiverFacilityOid = null; // FIXME need to add configuration parameters
    String auditRepositoryUri = null; // FIXME need to add configuration parameters
    String auditSourceId = null; // FIXME need to add configuration parameters

    V3PixAdapterConfig v3PixAdapterConfig =
        new V3PixAdapterConfig(null, pixSourceUri, senderApplicationOid, senderFacilityOid,
            receiverApplicationOid, receiverFacilityOid, homeCommunityOID, null, null, null,
            auditRepositoryUri, auditSourceId);

    V3PixAdapter v3PixAdapter = new V3PixAdapter(v3PixAdapterConfig);
    boolean ret = v3PixAdapter.updatePatient(new FhirPatient(patient));
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
   * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
   * @param finalPatient demografische Personendaten des finalen Patienten (Dieser Patient soll im
   *        MPI verbleiben)
   * @param mergePatient demografische Personendaten des Patienten, welcher mit dem finalen
   *        Patienten vereinigt wird
   * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
   * @return Status der Übertragung
   * @throws Exception
   */
  public static Response mergePatients(Destination dest, Patient finalPatient,
      Patient mergePatient, String homeCommunityOID) throws Exception {
    URI pixSourceUri = null; // FIXME need to add configuration parameters
    String senderApplicationOid = null; // FIXME need to add configuration parameters
    String senderFacilityOid = null; // FIXME need to add configuration parameters
    String receiverApplicationOid = null; // FIXME need to add configuration parameters
    String receiverFacilityOid = null; // FIXME need to add configuration parameters
    String auditRepositoryUri = null; // FIXME need to add configuration parameters
    String auditSourceId = null; // FIXME need to add configuration parameters

    V3PixAdapterConfig v3PixAdapterConfig =
        new V3PixAdapterConfig(null, pixSourceUri, senderApplicationOid, senderFacilityOid,
            receiverApplicationOid, receiverFacilityOid, homeCommunityOID, null, null, null,
            auditRepositoryUri, auditSourceId);

    V3PixAdapter v3PixAdapter = new V3PixAdapter(v3PixAdapterConfig);

    Identificator obsoleteId =
        Identificator
            .getIdentificator(mergePatient.getMdhtPatientRole().getIds(), homeCommunityOID);
    if (obsoleteId == null) {
      // FIXME add error message to response
      log.error("no localid specified for oid " + homeCommunityOID);
      return new Response(null, null, false);
    }
    boolean ret =
        v3PixAdapter.mergePatient(new FhirPatient(finalPatient), obsoleteId.getExtension());
    Response response = new Response(null, null, ret);
    return response;
  }


}
