/********************************************************************************
*
* The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
* Year of publication: 2015
*
********************************************************************************/


package org.ehealth_connector.cda.ch;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CDACH;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;

/**
 * Der DocumentProcessor verarbeitet ein gegebenes CDA Dokument. Er bietet
 * Methoden zur Serialisierung, Deserialisierung, Validierung und zum Laden und
 * Speichern von CDA-Dokumenten als XML-Datei.
 * 
 */
public class DocumentProcessor {

  /**
   * Gibt das Dokument als Objekt zurück
   * 
   * @return das ClinicalDocument
   */
  public static ClinicalDocument getDocument() {
    return null;
  }

  /**
   * Lädt ein Dokument in Form einer XML-Datei aus dem Dateisystem.
   *
   * @param filePath            das File Object
   * @return den DocumentProcessor
   * @throws Exception the exception
   */
  public static CdaChVacd loadFromFile(String filePath) throws Exception {
    // TODO Falsche Pfade abfangen (z.B. mit \ in \\ escapen)
    InputStream inputstream = new FileInputStream(filePath);
    ClinicalDocument clinicalDocument = CDAUtil.load(inputstream);

    // Implicit initialization
    // CDAUtil.loadPackages();

    // Explicit initialization
    CHPackage.eINSTANCE.eClass();

    VACD evacdocMdht = null;
    //System.out.println("\n\n ===== Checking type of clinical document =====");
    if (clinicalDocument instanceof CDACH) {
      //System.out.println("clinicalDocument is an instance of CDACH");
    }
    if (clinicalDocument instanceof VACD) {
      //System.out.println("clinicalDocument is an instance of eVACDOC");
      evacdocMdht = (VACD) clinicalDocument;
    } else {
      System.out.println("clinical document is NOT an instance of eVACDOC");
    }
    //System.out.println("\n\n");

    CdaChVacd evacdoc = new CdaChVacd(evacdocMdht);

    return evacdoc;
  }

  /**
   * Speichert das Dokument (standardkonform) als UTF8 enkodierte XML-Datei.
   *
   * @param file            das File Object
   * @return den DocumentProcessor
   * @throws Exception the exception
   */
  public static DocumentProcessor saveToFile(File file) throws Exception {
    return null;
  }

  /**
   * Setzt ein ClinicalDocument zur Verarbeitung
   * 
   * @param doc
   *            das ClinicalDocument
   * @return the DocumentProcessor
   */
  public static DocumentProcessor setDocument(ClinicalDocument doc) {
    return null;
  }

  /**
   * Setzt ein ClinicalDocument zur Verarbeitung
   * 
   * @param xmlString
   *            the ClinicalDocument
   * @return the DocumentProcessor
   */
  public static DocumentProcessor setDocument(String xmlString) {
    return null;
  }

  /**
   * Validierung gegen einen Implementierungsleitfaden (CDA-CH
   * Austauschformate)
   * 
   * @param doc
   *            Das Dokument, welches validiert werden soll
   * @param handler
   *            ein handler für die Validierung
   * @return true, wenn das Dokument der Spezifikation entspricht, false
   *         anderenfalls
   */
  public static boolean validate(CdaChVacd doc, CdaChValidationHandler handler) {
    return false;
  }
}
