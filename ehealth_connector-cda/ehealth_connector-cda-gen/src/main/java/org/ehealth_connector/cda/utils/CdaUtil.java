/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.EHealthConnectorVersions;
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Component3;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StructuredBody;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">A util class with helper functions.</div>
 * <div class="de">Eine Klasse mit Hilfsfunktionen.</div>
 */
public abstract class CdaUtil {

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

	/**
	 * <div class="en">Creates a unique Identificator (root=ehc OID;
	 * extension=UUID)</div>
	 *
	 * @return the Identificator
	 */
	public static Identificator createUniqueIdentificator() {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(EHealthConnectorVersions.getCurrentVersion().getOid());
		ii.setExtension(UUID.generate());
		return new Identificator(ii);
	}

	/**
	 * <div class="en">Creates a unique II (root=ehc OID; extension=UUID)</div>
	 *
	 * @return the II
	 */
	public static II createUniqueIi() {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(EHealthConnectorVersions.getCurrentVersion().getOid());
		ii.setExtension(UUID.generate());
		return ii;
	}

	/**
	 * <div class="en">Creates a unique II (root=from the id or the ehc OID;
	 * extension=from the id or a UUID)</div>
	 *
	 * @param id
	 *            the base id
	 * @return the II
	 */
	public static II createUniqueIiFromIdentificator(Identificator id) {
		II ii;
		if (id == null) {
			ii = createUniqueIi();
		} else {
			ii = id.getIi();
		}
		return ii;
	}

	/**
	 * <div class="en">Creates a unique II (root=the ehc OID; extension=from the
	 * id or a UUID)</div>
	 *
	 * @param id
	 *            the base id
	 * @return the II
	 */
	public static II createUniqueIiFromString(String id) {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(EHealthConnectorVersions.getCurrentVersion().getOid());
		if (id == null) {
			ii.setExtension(UUID.generate());
		} else {
			ii.setExtension(id);
		}
		return ii;
	}

	public static CDAFactory getMdhtCdaFactoryInstance() {
		return CDAFactory.eINSTANCE;
	}

	public static DatatypesFactory getMdhtDatatypesFactoryInstance() {
		return DatatypesFactory.eINSTANCE;
	}

	public static void setEntryRelationshipCommentInversionIdAndTypeCode(
			EList<EntryRelationship> entryRelationships) {
		final int erNb = entryRelationships.size() - 1;
		entryRelationships.get(erNb).setInversionInd(true);
		entryRelationships.get(erNb).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
	}

	public static void setEntryRelationshipTypeCode(EList<EntryRelationship> erList,
			x_ActRelationshipEntryRelationship typeCode) {
		final int nb = erList.size() - 1;
		erList.get(nb).setTypeCode(typeCode);
	}

}
