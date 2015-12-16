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
package org.ehealth_connector.cda.utils;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.CdaChVacd;
import org.ehealth_connector.cda.ch.enums.SectionsVACD;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Component3;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StructuredBody;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * @author roeland
 * @version 1.0
 * @since Jun 16, 2015 6:34:53 AM
 */
public abstract class CdaUtil {

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

	/**
	 * Adds the copy of a given section to a given structured body
	 * 
	 * @param sb
	 *            the StructuredBody
	 * @param s
	 *            the Section
	 */
	public static void addSectionToStructuredBodyAsCopy(StructuredBody sb, Section s) {
		if ((sb != null) && (s != null)) {
			final Component3 c = CDAFactory.eINSTANCE.createComponent3();
			c.setSection(EcoreUtil.copy(s));
			sb.getComponents().add(c);
		}
	}
}
