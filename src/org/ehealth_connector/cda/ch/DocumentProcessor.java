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
	 * <div class="en">Loads a CdaChVacd document from a given
	 * InputStream.</div> <div class="de">Lädt ein CdaChVacd aus einem
	 * InputStream</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChVacd Document
	 */
	public static CdaChVacd loadFromFile(String filePath) throws Exception {
		InputStream inputstream = new FileInputStream(filePath);
		return loadFromStream(inputstream);
	}

	/**
	 * <div class="en">Loads a CdaChVacd document from a given
	 * InputStream.</div> <div class="de">Lädt ein CdaChVacd aus einem
	 * InputStream</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param input
	 *            <div class="en">InputStream of a CDA-CH-VACD XML
	 *            structure</div> <div class="de">InputStream einer CDA-CH-VACD
	 *            XML-Struktur </div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @return the CdaChVacd Document
	 * @throws Exception
	 *             if the document could not be loaded
	 */
	public static CdaChVacd loadFromStream(InputStream input) throws Exception {
		ClinicalDocument clinicalDocument = CDAUtil.load(input);

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
			System.out.println("clinical document is NOT an instance of eVACDOC");
			return null;
		}

		CdaChVacd evacdoc = new CdaChVacd(evacdocMdht);

		return evacdoc;
	}
}
