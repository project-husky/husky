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

package org.ehealth_connector.cda.ch;

import java.io.FileInputStream;
import java.io.InputStream;

import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CDACH;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;

/**
 * Der DocumentProcessor verarbeitet ein gegebenes CDA Dokument zum Laden von
 * CDA-Dokumenten als XML-Datei.
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
	 * @param filePath
	 *            das File Object
	 * @return den DocumentProcessor
	 * @throws Exception
	 *             the exception
	 */
	public static CdaChVacd loadFromFile(String filePath) throws Exception {
		InputStream inputstream = new FileInputStream(filePath);
		ClinicalDocument clinicalDocument = CDAUtil.load(inputstream);

		// Implicit initialization
		// CDAUtil.loadPackages();

		// Explicit initialization
		CHPackage.eINSTANCE.eClass();

		VACD evacdocMdht = null;
		if (clinicalDocument instanceof CDACH) {
			// System.out.println("clinicalDocument is an instance of CDACH");
		}
		if (clinicalDocument instanceof VACD) {
			// System.out.println("clinicalDocument is an instance of eVACDOC");
			evacdocMdht = (VACD) clinicalDocument;
		} else {
			System.out
					.println("clinical document is NOT an instance of eVACDOC");
		}

		CdaChVacd evacdoc = new CdaChVacd(evacdocMdht);

		return evacdoc;
	}
}
