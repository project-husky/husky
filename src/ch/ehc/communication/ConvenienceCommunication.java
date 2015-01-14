/*******************************************************************************
*
* The authorship of this code and the accompanying materials is held by
* medshare GmbH, Switzerland. All rights reserved.
* http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the
* Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the
* Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
*
* Year of publication: 2014
*
*******************************************************************************/

package ch.ehc.communication;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.ehc.cda.DocumentMetadata;
import org.ehc.common.Identificator;
import org.ehc.communication.Destination;
import org.ehc.communication.Response;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;

import ch.ehc.cda.CdaCh;
import ch.ehc.cda.CdaChVacd;

/**
 * <p>
 * Die ConvenienceCommunication Klasse stellt Methoden für die Kommunikation von
 * CDA-Dokumenten mit IHE Transaktionen von und zu einer beliebigen Destination
 * bereit.
 * 
 * Die Klasse implementiert folgende IHE Akteure und Transaktionen:
 * <ul>
 * <li><b>IHE ITI Document Source Akteur</b></li>
 * <ul>
 * <li>[ITI-41] Provide & Register Document Set – b</li>
 * </ul>
 * <li><b>IHE ITI Document Consumer Akteur</b></li>
 * <ul>
 * <li>[ITI-18] Registry Stored Query</li>
 * <li>[ITI-43] Retrieve Document Set</li>
 * </ul>
 * <li><b>IHE ITI Portable Media Creator und Media Importer Akteur</b></li>
 * <ul>
 * <li>[ITI-32] Distribute Document Set on Media</li>
 * </ul>
 * <li><b>IHE PCC Care Manager und Decision Support Service Akteur</b></li>
 * <ul>
 * <li>[PCC-12] Request for Clinical Guidance</li>
 * </ul>
 * </ul>
 * </p>
 */
public class ConvenienceCommunication {

	/**
	 * <p>
	 * Anfrage einer Impfempfehlung (pseudonymisiert das Dokument vor dem
	 * eigentlichen Versand ans Expertensystem). Die Kommunikation zum
	 * Kommunikations-Endpunkt erfolgt gemäss <b>IHE [PCC-12] Request for Clinical
	 * Guidance</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PCC
	 * Care Manager Akteur</b>
	 * </p>
	 * 
	 * @param destination
	 *          Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param doc
	 *          CDA-CH-VACD Dokument mit den Impfungen und anderen für die
	 *          Impfempfehlung relevanten Angaben eines Patienten.
	 * @return CDA-CH-VACD Dokument, welches mit dem Parameter doc übergeben
	 *         worden ist und nun zusätzlich die Section mit den Impfempfehlungen
	 *         enthält
	 * 
	 * @throws Exception
	 *           Fehler während der Übertragung
	 */
	public static CdaChVacd getImmunizationRecommendationRequest(
			Destination destination, CdaChVacd doc) throws Exception {
		return null;
	}

	// Übermittlung per XDR und XDS (Senden und Empfangen) - A5, A6, A7,

    /**
     * <p>
     * Sendet ein CDA Dokument an einen Empfänger (Repository Akteur gemäss IHE
     * XDR oder IHE XDS). Die Kommunikation zum Kommunikations-Endpunkt erfolgt
     * gemäss <b>IHE [ITI-41] Provide & Register Document Set – b</b>.
     * </p>
     * <p>
     * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
     * Document Source Actor</b>
     * </p>
     * 
     * @param destination
     *          Ziel der Übertragung (Kommunikations-Endpunkt)
     * @param doc
     *          das CDA-Dokument, welches verschickt werden soll
     * @return status der XDS-Übertragung
     * @throws Exception
     */
    public static Response sendCdaDocument(Destination destination, CdaCh doc) throws Exception {
      XdsMetadata metadata = null; //TODO extract from CDA
      return sendCdaDocument(metadata, destination, doc);
    }

    /**
	 * <p>
	 * Sendet ein CDA Dokument an einen Empfänger (Repository Akteur gemäss IHE
	 * XDR oder IHE XDS). Die Kommunikation zum Kommunikations-Endpunkt erfolgt
	 * gemäss <b>IHE [ITI-41] Provide & Register Document Set – b</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Document Source Actor</b>
	 * </p>
	 * 
	 * @param metadata
	 *          Zusätzliche Metadaten für die Übertragung
	 * @param destination
	 *          Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param doc
	 *          das CDA-Dokument, welches verschickt werden soll
	 * @return status der XDS-Übertragung
	 * @throws Exception
	 */
	public static Response sendCdaDocument(XdsMetadata metadata,
			Destination destination, CdaCh doc) throws Exception {
		return null;
	}

    /**
     * <p>
     * Sendet eine beliebige Datei an einen Empfänger (Repository Akteur gemäss IHE
     * XDR oder IHE XDS). Die Kommunikation zum Kommunikations-Endpunkt erfolgt
     * gemäss <b>IHE [ITI-41] Provide & Register Document Set – b</b>.
     * </p>
     * <p>
     * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
     * Document Source Actor</b>
     * </p>
     * 
     * @param metadata
     *          Metadaten zum Dokument
     * @param destination
     *          Ziel der Übertragung (Kommunikations-Endpunkt)
     * @param filePath
     *          Datei (inkl. Pfad), welche verschickt werden soll
     * @return status der XDS-Übertragung
     * @throws Exception
     */
    public static Response sendDocument(XdsMetadata metadata,
            Destination destination, String filePath) throws Exception {
        return null;
    }

    // Übermittlung per XDM (Speichern und Laden von einem Datenträger) - A10, A11

	/**
	 * <p>
	 * Speichert ein CDA-Dokument inkl. der benötigten Metadaten auf einem
	 * Datenträger (gemäss IHE XDM). Die Speicherung auf dem Medium erfolgt gemäss
	 * <b>[ITI-32] Distribute Document Set on Media</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Portable Media Creator Akteur</b>
	 * </p>
	 * 
	 * @param destination
	 *          Pfad zum Datenträger auf dem XDM-konforme Daten gespeichert werden
	 * @param doc
	 *          das CDA-Dokument, welches gespeichert werden soll
	 * @return true, wenn das Dokument erfolgreich gespeichert wurde. Sonst:
	 *         false.
	 * @throws Exception
	 */
	public static boolean storeOnMedia(File destination, ClinicalDocument doc)
			throws Exception {
		return false;
	}

	/**
	 * <p>
	 * Lädt CDA-Dokumente von einem Medium (Datenträger oder Pfad im Dateisystem;
	 * gemäss IHE XDM). Die Verarbeitung des Mediums erfolgt gemäss <b>[ITI-32]
	 * Distribute Document Set on Media</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Portable Media Importer Akteur</b>
	 * </p>
	 * 
	 * @param destination
	 *          Pfad zum Datenträger von dem XDM-konforme Daten geladen werden
	 * @return eine Liste von CDA-Dokumenten
	 * @throws Exception
	 */
	public static ArrayList<ClinicalDocument> parseStoredCdaChVacd(File destination)
			throws Exception {
		return null;
	}

	// XDS: Interaktion mit einer IHE Registry - A8

	/**
	 * <p>
	 * Sucht alle CDA-CH-VACD Dokumente zu einem Patienten in einem
	 * Dokumentenregister (gemäss IHE XDS). Die Kommunikation zum
	 * Kommunikations-Endpunkt erfolgt gemäss <b>[ITI-18] Registry Stored
	 * Query</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Document Consumer Akteur</b>
	 * </p>
	 * 
	 * @param destination
	 *          Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param patientID
	 *          ID des Patienten
	 * @return eine Liste mit IDs, zu den CDA-CH-VACD-Dokumenten, die zu einem
	 *         Patienten vorhanden sind
	 */
	public static ArrayList<DocumentMetadata> findImmunizationDocuments(
			Destination destination, Identificator patientID) {
		return null;
	}

	// XDS: Herunterladen eines Impfdokuments von einem IHE XDS Repository - A9

	/**
	 * <p>
	 * Lädt ein Dokument aus einer Dokumentenablage herunter (gemäss IHE XDS). Die
	 * Kommunikation zum Kommunikations-Endpunkt erfolgt gemäss <b>[ITI-43]
	 * Retrieve Document Set</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Document Consumer Akteur</b>
	 * </p>
	 * 
	 * @param repository
	 *          Das Repository, von dem ein CDA-CH-VACD heruntergeladen werden
	 *          soll
	 * @param documentId
	 *          ID des CDA-CH-VACD
	 * @return das CDA-CH-VACD-Objekt
	 */
	public static CdaChVacd getCdaChVacdDocument(Destination repository,
			UUID documentId) {
		return null;
	}

	// Anfrage einer Immunization Recommendation (Senden der Anfrage und Empfangen
	// der Antwort) - A4, A5, A6

	/**
	 * Pseudonymisierung eines ClinicalDocument nach der CDA-CH-VACD Spezifikation
	 * (siehe CDA-CH-VACD, UseCases ab Kapitel 6.3 und insbesondere Kapitel
	 * "7.4 CDA Header", Regel <CH-VACD-HPAT> )
	 * 
	 * @return das pseudonymisierte CdaChVacd
	 */
	public static CdaChVacd pseudonymize(CdaChVacd doc) {
		return null;
	}

	/**
	 * Speichert ein CDA Dokument für den Versand zu einer beliebigen Destination
	 * auf einem Medium
	 * 
	 * @param destination
	 *          Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param doc
	 *          CDA-CH Dokument
	 */
	public static void storeOnMedia(Destination destination, CdaCh doc) {
		// TODO Auto-generated method stub

	}

}
