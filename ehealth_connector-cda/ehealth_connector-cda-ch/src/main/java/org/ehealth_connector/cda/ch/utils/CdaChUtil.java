/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.utils;

import java.io.FileInputStream;
import java.io.InputStream;

import org.ehealth_connector.cda.ch.edes.CdaChEdesCommon;
import org.ehealth_connector.cda.ch.edes.CdaChEdesCtnn;
import org.ehealth_connector.cda.ch.edes.CdaChEdesEdpn;
import org.ehealth_connector.cda.ch.lab.lrph.CdaChLrph;
import org.ehealth_connector.cda.ch.lab.lrqc.CdaChLrqc;
import org.ehealth_connector.cda.ch.lab.lrtp.CdaChLrtp;
import org.ehealth_connector.cda.ch.vacd.CdaChVacd;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ch.CDACH;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">A util class with helper functions.</div>
 * <div class="de">Eine Klasse mit Hilfsfunktionen.</div>
 */
public abstract class CdaChUtil extends CdaUtil {

	/**
	 * <div class="en">Creates a UUID for EDES documents with the EDES root ID
	 * and a generated extension.</div>
	 *
	 * @param id
	 *            <br>
	 *            <div class="en"> the id</div>
	 * @return the ii
	 */
	public static Identificator createUuidEdes(String id) {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(CdaChEdesCommon.OID_MAIN);
		if (id == null) {
			ii.setExtension(UUID.generate());
		} else {
			ii.setExtension(id);
		}
		return new Identificator(ii);
	}

	/**
	 * <div class="en">Creates a UUID for VACD documents with the VACD root ID
	 * and a generated extension.</div>
	 *
	 * @param id
	 *            <br>
	 *            <div class="en"> the id</div>
	 * @return the ii
	 */
	public static II createUuidVacd(String id) {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(CdaChVacd.OID_MAIN);
		if (id == null) {
			ii.setExtension(UUID.generate());
		} else {
			// TODO should this not be ii.setExtension(id) ?
			// ii.setRoot(id);
			ii.setExtension(id);
		}
		return ii;
	}

	/**
	 * <div class="en">Creates a UUID for VACD documents with the VACD root ID
	 * (if the root id is null, otherwise the provided id will be used) and a
	 * generated extension.</div>
	 *
	 * @param id
	 *            <br>
	 *            <div class="en"> the id</div>
	 * @return the ii
	 */
	public static II createUuidVacdIdentificator(Identificator id) {
		II ii;
		if (id == null) {
			ii = createUuidVacd(null);
		} else {
			ii = id.getIi();
		}
		return ii;
	}

	/**
	 * <div class="en">Loads a CdaChEdesCtnn document from a given File.</div>
	 * <div class="de">Lädt ein CdaChEdesCtnn aus einer Datei.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChEdesCtnn Document
	 */
	public static CdaChEdesCtnn loadEdesCtnnFromFile(String filePath) throws Exception {
		InputStream inputstream = new FileInputStream(filePath);
		ClinicalDocument document = CDAUtil.load(inputstream);
		return new CdaChEdesCtnn((org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn) document);
	}

	/**
	 * <div class="en">Loads a CdaChEdesEdpn document from a given File.</div>
	 * <div class="de">Lädt ein CdaChEdesEdpn aus einer Datei.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChEdesEdpn Document
	 */
	public static CdaChEdesEdpn loadEdesEdpnFromFile(String filePath) throws Exception {
		InputStream inputstream = new FileInputStream(filePath);
		ClinicalDocument document = CDAUtil.load(inputstream);
		return new CdaChEdesEdpn((org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn) document);
	}

	/**
	 * <div class="en">Loads a CdaChLrph document from a given File.</div>
	 * <div class="de">Lädt ein CdaChLrph aus einer Datei.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChLrph Document
	 */
	public static CdaChLrph loadLrphFromFile(String filePath) throws Exception {
		InputStream inputstream = new FileInputStream(filePath);
		ClinicalDocument document = CDAUtil.load(inputstream);
		return new CdaChLrph((org.openhealthtools.mdht.uml.cda.ch.CdaChLrph) document);
	}

	/**
	 * <div class="en">Loads a CdaChLrqc document from a given File.</div>
	 * <div class="de">Lädt ein CdaChLrqc aus einer Datei.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChLrqc Document
	 */
	public static CdaChLrqc loadLrqcFromFile(String filePath) throws Exception {
		InputStream inputstream = new FileInputStream(filePath);
		ClinicalDocument document = CDAUtil.load(inputstream);
		return new CdaChLrqc((org.openhealthtools.mdht.uml.cda.ch.CdaChLrqc) document);
	}

	/**
	 * <div class="en">Loads a CdaChLrtp document from a given File.</div>
	 * <div class="de">Lädt ein CdaChLrtp aus einer Datei.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChLrtp Document
	 */
	public static CdaChLrtp loadLrtpFromFile(String filePath) throws Exception {
		InputStream inputstream = new FileInputStream(filePath);
		ClinicalDocument document = CDAUtil.load(inputstream);
		return new CdaChLrtp((org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp) document);
	}

	/**
	 * <div class="en">Loads a CdaChVacd document from a given File.</div>
	 * <div class="de">Lädt ein CdaChVacd aus einer Datei.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChVacd Document
	 */
	public static CdaChVacd loadVacdFromFile(String filePath) throws Exception {
		final InputStream inputstream = new FileInputStream(filePath);
		return loadVacdFromStream(inputstream);
	}

	/**
	 * <div class="en">Loads a CdaChVacd document from a given
	 * InputStream.</div> <div class="de">Lädt ein CdaChVacd aus einem
	 * InputStream</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param input
	 *            <div class="en">InputStream of a CDA-CH-VACD XML
	 *            structure</div> <div class="de">InputStream einer CDA-CH-VACD
	 *            XML-Struktur </div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @return the CdaChVacd Document
	 * @throws Exception
	 *             if the document could not be loaded
	 */
	public static CdaChVacd loadVacdFromStream(InputStream input) throws Exception {
		// Explicit initialization
		CHPackage.eINSTANCE.eClass();

		final ClinicalDocument clinicalDocument = CDAUtil.load(input);

		// Implicit initialization

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

		return new CdaChVacd(evacdocMdht);
	}

	/**
	 * Updates a Reference if it is a comment (in a deph of two counters)
	 *
	 * @param er
	 *            the EntryRelationship
	 * @param i
	 *            first counter
	 * @param j
	 *            second counter
	 * @param prefix
	 *            the prefix of the reference
	 * @return the EntryRelationship
	 */
	public static EntryRelationship updateRefIfComment(EntryRelationship er, int i, int j,
			SectionsVACD prefix) {
		if (er.getTypeCode().equals(x_ActRelationshipEntryRelationship.SUBJ)
				&& er.getInversionInd()) {
			// Get the ed and update it with the reference
			final ED ed = er.getAct().getText();
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			ed.setReference(tel);
			if (CdaChVacd.CDA_LEVEL2_TEXT_GENERATION) {
				tel.setValue("#" + prefix.getContentIdPrefix() + "-comment" + i + j);
			} else {
				tel.setValue(("#" + prefix.getContentIdPrefix() + "1"));
			}
			er.getAct().setText(ed);
		}
		return er;
	}

	/**
	 * Updates a Reference if it is a comment
	 *
	 * @param er
	 *            the EntryRelationship
	 * @param ref
	 *            the reference
	 * @param prefix
	 *            the prefix of the reference
	 * @return the EntryRelationship
	 */
	public static EntryRelationship updateRefIfComment(EntryRelationship er, String ref,
			SectionsVACD prefix) {
		if (Util.isComment(er)) {
			// Get the ed and update it with the reference
			final ED ed = er.getAct().getText();
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			ed.setReference(tel);
			if (CdaChVacd.CDA_LEVEL2_TEXT_GENERATION) {
				tel.setValue("#" + prefix.getContentIdPrefix() + "-comment" + ref);
			} else {
				tel.setValue(("#" + prefix.getContentIdPrefix() + "1"));
			}
			er.getAct().setText(ed);
		}
		return er;
	}
}
