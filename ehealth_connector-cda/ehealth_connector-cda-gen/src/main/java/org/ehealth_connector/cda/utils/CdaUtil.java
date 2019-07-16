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

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.enums.EhcVersions;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Authenticator;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Component3;
import org.openhealthtools.mdht.uml.cda.Custodian;
import org.openhealthtools.mdht.uml.cda.DataEnterer;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.LegalAuthenticator;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StructuredBody;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.rim.InfrastructureRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">A util class with helper functions.</div>
 * <div class="de">Eine Klasse mit Hilfsfunktionen.</div>
 */
public abstract class CdaUtil {

	/**
	 * Adds a copy of a given section to a given structured body.
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
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(Act mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(Authenticator mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(Author mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param doc
	 *            the doc
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(ClinicalDocument doc, Identificator id) {
		doc.getTemplateIds().add(id.getIi());
		sortTemplateIds(doc);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(Custodian mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(DataEnterer mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(InformationRecipient mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(InfrastructureRoot mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(LaboratoryObservation mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(LaboratoryReportDataProcessingEntry mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(LaboratorySpecialtySection mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(LegalAuthenticator mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(Organizer mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(RecordTarget mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(SpecimenCollection mdht, Identificator id) {
		mdht.getTemplateIds().add(id.getIi());
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(Act mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(Authenticator mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(Author mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a given template id to the given MDHT object, if it does not exist,
	 * yet.
	 *
	 * @param doc
	 *            the doc
	 * @param id
	 *            the id to be added if it doesn't exist, yet.
	 */
	public static void addTemplateIdOnce(ClinicalDocument doc, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : doc.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(doc, id);
		sortTemplateIds(doc);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(Custodian mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(DataEnterer mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(InformationRecipient mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param doc
	 *            the doc
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(InfrastructureRoot doc, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : doc.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(doc, id);
		sortTemplateIds(doc);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(LaboratoryObservation mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(LaboratoryReportDataProcessingEntry mdht,
			Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(LaboratorySpecialtySection mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(LegalAuthenticator mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(Organizer mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(RecordTarget mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * Adds a template id once.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateIdOnce(SpecimenCollection mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi()))
				alreadyExists = true;
		}
		if (!alreadyExists)
			addTemplateId(mdht, id);
		sortTemplateIds(mdht);
	}

	/**
	 * <div class="en">Creates a unique Identificator (root=ehc OID;
	 * extension=UUID)</div>.
	 *
	 * @return the Identificator
	 */
	public static Identificator createUniqueIdentificator() {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(EhcVersions.getCurrentVersion().getOid());
		ii.setExtension(UUID.generate());
		return new Identificator(ii);
	}

	/**
	 * <div class="en">Creates a unique II (root=ehc OID; extension=UUID)</div>.
	 *
	 * @return the II
	 */
	public static II createUniqueIi() {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(EhcVersions.getCurrentVersion().getOid());
		ii.setExtension(UUID.generate());
		return ii;
	}

	/**
	 * <div class="en">Creates a unique II (root=from the id or the ehc OID;
	 * extension=from the id or a UUID)</div>.
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
	 * id or a UUID)</div>.
	 *
	 * @param id
	 *            the base id
	 * @return the II
	 */
	public static II createUniqueIiFromString(String id) {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(EhcVersions.getCurrentVersion().getOid());
		if (id == null) {
			ii.setExtension(UUID.generate());
		} else {
			ii.setExtension(id);
		}
		return ii;
	}

	/**
	 * Gets the mdht cda factory instance.
	 *
	 * @return the mdht cda factory instance
	 */
	public static CDAFactory getMdhtCdaFactoryInstance() {
		return CDAFactory.eINSTANCE;
	}

	/**
	 * Gets the mdht datatypes factory instance.
	 *
	 * @return the mdht datatypes factory instance
	 */
	public static DatatypesFactory getMdhtDatatypesFactoryInstance() {
		return DatatypesFactory.eINSTANCE;
	}

	/**
	 * Removes the template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void removeTemplateId(LaboratoryObservation mdht, Identificator id) {
		for (II existingId : mdht.getTemplateIds()) {
			if (existingId.equals(id.getIi())) {
				mdht.getTemplateIds().remove(existingId);
				break;
			}
		}
		sortTemplateIds(mdht);
	}

	/**
	 * Sets the entry relationship comment inversion id and type code.
	 *
	 * @param entryRelationships
	 *            the new entry relationship comment inversion id and type code
	 */
	public static void setEntryRelationshipCommentInversionIdAndTypeCode(
			EList<EntryRelationship> entryRelationships) {
		final int erNb = entryRelationships.size() - 1;
		entryRelationships.get(erNb).setInversionInd(true);
		entryRelationships.get(erNb).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
	}

	/**
	 * Sets the entry relationship type code.
	 *
	 * @param erList
	 *            the er list
	 * @param typeCode
	 *            the type code
	 */
	public static void setEntryRelationshipTypeCode(EList<EntryRelationship> erList,
			x_ActRelationshipEntryRelationship typeCode) {
		final int nb = erList.size() - 1;
		erList.get(nb).setTypeCode(typeCode);
	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(Act mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(Authenticator mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(Author mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param doc
	 *            the doc
	 */
	public static void sortTemplateIds(ClinicalDocument doc) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : doc.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		doc.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			doc.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(Custodian mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(DataEnterer mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(InformationRecipient mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(InfrastructureRoot mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(LaboratoryObservation mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(LaboratoryReportDataProcessingEntry mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(LaboratorySpecialtySection mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(LegalAuthenticator mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(Organizer mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(RecordTarget mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(SpecimenCollection mdht) {
		ArrayList<Identificator> list = new ArrayList<Identificator>();
		for (II ii : mdht.getTemplateIds()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateIds().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateIds().add(identificator.getIi());
		}

	}
}
