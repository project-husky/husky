/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.ehealth_connector.cda.ch.CdaChV2StructuredBody;
import org.ehealth_connector.cda.ch.edes.CdaChEdesCtnn;
import org.ehealth_connector.cda.ch.edes.CdaChEdesEdpn;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEdes;
import org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport;
import org.ehealth_connector.cda.ch.lab.lrph.CdaChLrph;
import org.ehealth_connector.cda.ch.lab.lrqc.CdaChLrqc;
import org.ehealth_connector.cda.ch.lab.lrtp.CdaChLrtp;
import org.ehealth_connector.cda.ch.vacd.v140.CdaChVacd;
import org.ehealth_connector.cda.ch.vacd.v140.enums.SectionsVacd;
import org.ehealth_connector.cda.utils.CdaUtilMdht;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">A util class with helper functions.</div>
 * <div class="de">Eine Klasse mit Hilfsfunktionen.</div>
 */
public abstract class CdaChUtil extends CdaUtilMdht {

	/**
	 * <div class="en">Loads a CdaChLrepV1GeneralReport document from a given
	 * File.</div> <div class="de">Lädt ein CdaChLrepV1GeneralReport aus einer
	 * Datei.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChLrepV1GeneralReport Document
	 */
	public static CdaChLrepV1GeneralReport loadCdaChLrepV1GeneralReportFromFile(String filePath)
			throws Exception {
		FileInputStream fs = new FileInputStream(filePath);
		CdaChLrepV1GeneralReport retVal = loadCdaChLrepV1GeneralReportFromStream(
				Util.getUtf8InputStream(fs));
		fs.close();
		return retVal;
	}

	public static CdaChLrepV1GeneralReport loadCdaChLrepV1GeneralReportFromStream(
			InputStream inputStream) throws Exception {
		final CdaChLoader<CdaChLrepV1GeneralReport> loader = new CdaChLoader<CdaChLrepV1GeneralReport>();
		CdaChLrepV1GeneralReport retVal = loader.loadFromStream(inputStream,
				CdaChLrepV1GeneralReport.class,
				org.openhealthtools.mdht.uml.cda.ch.CdaChLrepV1GeneralReport.class);
		return retVal;

	}

	/**
	 * <div class="en">Loads a CdaChV2 document from a given File.</div>
	 * <div class="de">Lädt ein CdaChV2 aus einer Datei.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param filePath
	 *            path to the XML file
	 * @throws Exception
	 *             the exception
	 * @return the CdaChV2 Document
	 */
	public static CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> loadCdaChV2FromFile(
			String filePath) throws Exception {
		FileInputStream fs = new FileInputStream(filePath);
		CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> retVal = loadCdaChV2FromStream(
				Util.getUtf8InputStream(fs));
		fs.close();
		return retVal;
	}

	/**
	 * <div class="en">Loads a CdaChV2 document from an inputstream.</div>
	 * <div class="de">Lädt ein CdaChV2 aus einem Inputstream.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param inputStream
	 *            the inputstream
	 * @throws Exception
	 *             the exception
	 * @return the CdaChV2 Document
	 */
	public static CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> loadCdaChV2FromStream(
			InputStream inputStream) throws Exception {
		final CdaChLoader<CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>> loader = new CdaChLoader<CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>>();
		CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> retVal = loader
				.loadCdaChV2StructuredBodyFromStream(inputStream);
		return retVal;
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
		return loadEdesCtnnFromStream(IOUtils.toInputStream(
				IOUtils.toString(new InputStreamReader(new FileInputStream(filePath), "UTF-8")),
				Charsets.UTF_8));
	}

	/**
	 * <div class="en">Loads a CdaChEdesCtnn document from an inputstream.</div>
	 * <div class="de">Lädt ein CdaChEdesCtnn aus einem Inputstream.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param inputStream
	 *            an inputstream
	 * @throws Exception
	 *             the exception
	 * @return the CdaChEdesCtnn Document
	 */
	public static CdaChEdesCtnn loadEdesCtnnFromStream(InputStream inputStream) throws Exception {
		final CdaChLoader<CdaChEdesCtnn> loader = new CdaChLoader<CdaChEdesCtnn>();
		CdaChEdesCtnn retVal = loader.loadFromStream(inputStream, CdaChEdesCtnn.class,
				org.openhealthtools.mdht.uml.cda.ch.CdaChEdesV1Ctnn.class);
		retVal.initAfterLoad();
		return retVal;
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
		return loadEdesEdpnFromStream(IOUtils.toInputStream(
				IOUtils.toString(new InputStreamReader(new FileInputStream(filePath), "UTF-8")),
				Charsets.UTF_8));
	}

	/**
	 * <div class="en">Loads a CdaChEdesEdpn document from an inputstream.</div>
	 * <div class="de">Lädt ein CdaChEdesEdpn aus einem Inputstream.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param inputStream
	 *            an input stream
	 * @throws Exception
	 *             the exception
	 * @return the CdaChEdesEdpn Document
	 */
	public static CdaChEdesEdpn loadEdesEdpnFromStream(InputStream inputStream) throws Exception {
		final CdaChLoader<CdaChEdesEdpn> loader = new CdaChLoader<CdaChEdesEdpn>();
		CdaChEdesEdpn retVal = loader.loadFromStream(inputStream, CdaChEdesEdpn.class,
				org.openhealthtools.mdht.uml.cda.ch.CdaChEdesV1Edpn.class);
		retVal.initAfterLoad();
		return retVal;
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
		return loadLrphFromStream(IOUtils.toInputStream(
				IOUtils.toString(new InputStreamReader(new FileInputStream(filePath), "UTF-8")),
				Charsets.UTF_8));
	}

	/**
	 * <div class="en">Loads a CdaChLrph document from an inputstream.</div>
	 * <div class="de">Lädt ein CdaChLrph aus einem Inputstream.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param inputStream
	 *            the stream
	 * @throws Exception
	 *             the exception
	 * @return the CdaChLrph Document
	 */
	public static CdaChLrph loadLrphFromStream(InputStream inputStream) throws Exception {
		final CdaChLoader<CdaChLrph> loader = new CdaChLoader<CdaChLrph>();
		return loader.loadFromStream(inputStream, CdaChLrph.class,
				org.openhealthtools.mdht.uml.cda.ch.CdaChLrphV1.class);
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
		return loadLrqcFromStream(IOUtils.toInputStream(
				IOUtils.toString(new InputStreamReader(new FileInputStream(filePath), "UTF-8")),
				Charsets.UTF_8));
	}

	/**
	 * <div class="en">Loads a CdaChLrqc document from an inputstream.</div>
	 * <div class="de">Lädt ein CdaChLrqc aus einem Inputstream.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param inputStream
	 *            the inputstream
	 * @throws Exception
	 *             the exception
	 * @return the CdaChLrqc Document
	 */
	public static CdaChLrqc loadLrqcFromStream(InputStream inputStream) throws Exception {
		final CdaChLoader<CdaChLrqc> loader = new CdaChLoader<CdaChLrqc>();
		return loader.loadFromStream(inputStream, CdaChLrqc.class,
				org.openhealthtools.mdht.uml.cda.ch.CdaChLrqcV1.class);
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
		return loadLrtpFromStream(IOUtils.toInputStream(
				IOUtils.toString(new InputStreamReader(new FileInputStream(filePath), "UTF-8")),
				Charsets.UTF_8));
	}

	/**
	 * <div class="en">Loads a CdaChLrtp document from an inputstream.</div>
	 * <div class="de">Lädt ein CdaChLrtp aus einem Inputstream.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param inputStream
	 *            inputstream
	 * @throws Exception
	 *             the exception
	 * @return the CdaChLrtp Document
	 */
	public static CdaChLrtp loadLrtpFromStream(InputStream inputStream) throws Exception {
		final CdaChLoader<CdaChLrtp> loader = new CdaChLoader<CdaChLrtp>();
		return loader.loadFromStream(inputStream, CdaChLrtp.class,
				org.openhealthtools.mdht.uml.cda.ch.CdaChLrtpV1.class);
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
		return loadVacdFromStream(IOUtils.toInputStream(
				IOUtils.toString(new InputStreamReader(new FileInputStream(filePath), "UTF-8")),
				Charsets.UTF_8));
	}

	/**
	 * <div class="en">Loads a CdaChVacd document from an input stream.</div>
	 * <div class="de">Lädt ein CdaChVacd aus einem inputstream.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param inputStream
	 *            the input stream
	 * @return the CdaChVacd Document
	 * @throws Exception
	 *             the exception
	 */
	public static CdaChVacd loadVacdFromStream(InputStream inputStream) throws Exception {
		final CdaChLoader<CdaChVacd> loader = new CdaChLoader<CdaChVacd>();
		return loader.loadFromStream(inputStream, CdaChVacd.class,
				org.openhealthtools.mdht.uml.cda.ch.CdaChVacdV1.class);
	}

	/**
	 * Updates a Reference if it is a comment (in a deph of two counters)
	 *
	 * @param doNarrTextGen
	 *            true, when narrative text generation is on; false otherwise
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
	public static EntryRelationship updateRefIfComment(boolean doNarrTextGen, EntryRelationship er,
			int i, int j, SectionsVacd prefix) {
		if (er.getTypeCode().equals(x_ActRelationshipEntryRelationship.SUBJ)
				&& er.getInversionInd()) {
			// Get the ed and update it with the reference
			final ED ed = er.getAct().getText();
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			ed.setReference(tel);
			if (doNarrTextGen) {
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
	 * @param doNarrTextGen
	 *            true, when narrative text generation is on; false otherwise
	 * @param er
	 *            the EntryRelationship
	 * @param ref
	 *            the reference
	 * @param prefix
	 *            the prefix of the reference
	 * @return the EntryRelationship
	 */
	public static EntryRelationship updateRefIfComment(boolean doNarrTextGen, EntryRelationship er,
			String ref, SectionsEdes prefix) {
		if (Util.isComment(er)) {
			// Get the ed and update it with the reference
			final ED ed = er.getAct().getText();
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			ed.setReference(tel);
			if (doNarrTextGen) {
				tel.setValue("#" + prefix.getContentIdPrefix() + "-comment" + ref);
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
	 * @param doNarrTextGen
	 *            true, when narrative text generation is on; false otherwise
	 * @param er
	 *            the EntryRelationship
	 * @param ref
	 *            the reference
	 * @param prefix
	 *            the prefix of the reference
	 * @return the EntryRelationship
	 */
	public static EntryRelationship updateRefIfComment(boolean doNarrTextGen, EntryRelationship er,
			String ref, SectionsVacd prefix) {
		if (Util.isComment(er)) {
			// Get the ed and update it with the reference
			final ED ed = er.getAct().getText();
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			ed.setReference(tel);
			if (doNarrTextGen) {
				tel.setValue("#" + prefix.getContentIdPrefix() + "-comment" + ref);
			} else {
				tel.setValue(("#" + prefix.getContentIdPrefix() + "1"));
			}
			er.getAct().setText(ed);
		}
		return er;
	}
}
