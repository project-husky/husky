package org.ehc.communication.ch;

import java.util.ArrayList;

import org.ehc.common.Identificator;
import org.ehc.common.Patient;
import org.ehc.communication.Destination;
import org.ehc.communication.Response;

/**
 * <p>
 * Diese Klasse stellt Methoden für die Kommunikation mit einem Master Patient Index bereit (MPI)
 * Die Kommunikation erfolgt in dieser Klasse mit HL7 V2 (PIX)
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
public class ConvenienceMasterPatientIndexV2 {

	/**
	 * <p>
	 * Vereinigt zwei Patienten im Master Patient Index (Patient
	 * Identity Cross-Reference Manager Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX Patient Identity
	 * Source</b>
	 * </p>
	 * 
	 * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param finalPatient demografische Personendaten des finalen Patienten (Dieser Patient soll im MPI verbleiben)
	 * @param mergePatient demografische Personendaten des Patienten, welcher mit dem finalen Patienten vereinigt wird 
	 * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
	 * @return Status der Übertragung
	 * @throws Exception
	 */
	public static Response mergePatients(Destination dest, Patient finalPatient, Patient mergePatient,
			String homeCommunityOID) throws Exception {
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
	 * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param patient demografische Personendaten eines Patienten
	 * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
	 * @param requestedCommunityOID OID der gewünschten Patienten Identifikationsdomäne
	 * @return Liste mit Patienten-IDs
	 * @throws Exception
	 */
	public static ArrayList<Identificator> queryPatientID(Destination dest, Patient patient,
			String homeCommunityOID, String requestedCommunityOID) throws Exception {
		// TODO not yet implemented

		// This is for prototyping, only
		ArrayList<Identificator> retVal = new ArrayList<Identificator>();
		retVal.add(new Identificator("dummy1", requestedCommunityOID));
		retVal.add(new Identificator("dummy2", requestedCommunityOID));
		return retVal;
	}

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
	 * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param patient demografische Personendaten eines Patienten
	 * @param homeCommunityOID OID der lokalen Patient ID (Gemeinschaft des Aufrufers)
	 * @return Status der Übertragung
	 * @throws Exception
	 */
	public static Response sendPatientDemographics(Destination dest, Patient patient,
			String homeCommunityOID) throws Exception {
		// TODO not yet implemented
		return null;
	}

}
