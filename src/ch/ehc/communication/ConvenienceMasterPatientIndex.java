package ch.ehc.communication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.ehc.communication.Destination;
import org.ehc.communication.Response;
import org.ehc.general.Identificator;
import org.ehc.general.Patient;

import ch.ehc.cda.CdaChVacd;

/**
 * <p>
 * Diese Klasse stellt Methoden für die Kommunikation mit einem Master Patient Index bereit (MPI)
 * 
 * Die Klasse implementiert folgende IHE Akteure und Transaktionen:
 * <ul>
 * <li><b>IHE PIX Patient Identity Source Akteur</b></li>
 * <ul>
 * <li>[ITI-44] Patient Identity Feed</li>
 * </ul>
 * <li><b>IHE PIX Patient Identifier Cross-Reference Concumer Akteur</b></li>
 * <ul>
 * <li>[ITI-45] PIX Query</li>
 * </ul>
 * </ul>
 * </p>
 */
public class ConvenienceMasterPatientIndex {

  /**
   * <p>
   * Sendet demografische Personendaten eines Patienten an einen Master Patient Index (Patient
   * Identity Cross-Reference Manager Akteur gemäss IHE PIX).
   * </p>
   * <p>
   * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX Patient Identity
   * Source</b>
   * </p>
   * 
   * @param patient demografische Personendaten eines Patienten
   * @return Status der Übertragung
   * @throws Exception
   */
  public static Response sendPatientDemographics(Patient patient) throws Exception {
    // TODO not yet implemented
    return null;
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
   * @param domainOID OID der gewünschten Patienten Identifikationsdomäne
   * @return Liste mit Patienten-IDs
   * @throws Exception
   */
  public static ArrayList<Identificator> queryPatientID(Patient patient, String domainOID) throws Exception {
    // TODO not yet implemented

    // This is for prototyping, only
    ArrayList<Identificator> retVal = new ArrayList<Identificator>();
    retVal.add(new Identificator("dummy1", domainOID));
    retVal.add(new Identificator("dummy2", domainOID));
    return retVal;
  }
  
}
