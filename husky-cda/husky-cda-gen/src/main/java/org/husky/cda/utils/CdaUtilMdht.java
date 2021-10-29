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
package org.husky.cda.utils;

import java.util.ArrayList;
import java.util.List;

import org.husky.common.enums.EhcVersions;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.common.hl7cdar2.POCDMT000040Authenticator;
import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.POCDMT000040Custodian;
import org.husky.common.hl7cdar2.POCDMT000040DataEnterer;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040InformationRecipient;
import org.husky.common.hl7cdar2.POCDMT000040LegalAuthenticator;
import org.husky.common.hl7cdar2.POCDMT000040Observation;
import org.husky.common.hl7cdar2.POCDMT000040Organizer;
import org.husky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.husky.common.hl7cdar2.POCDMT000040Section;
import org.husky.common.hl7cdar2.POCDMT000040Specimen;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.model.Identificator;
import org.husky.common.utils.UUID;

/**
 * <div class="en">A util class with helper functions for CDA based on
 * MDHT.</div> <div class="de">Eine Klasse mit Hilfsfunktionen für CDA basierend
 * auf MDHT.</div>
 */
public abstract class CdaUtilMdht {



	/**
	 * Adds a template id.
	 *
	 * @param act the act
	 * @param id  the id
	 */
	public static void addTemplateId(POCDMT000040Act act, Identificator id) {
		act.getTemplateId().add(id.getHl7CdaR2Ii());
		sortTemplateIds(act);
	}

	/**
	 * Adds a template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void addTemplateId(POCDMT000040Authenticator mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040Author mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040ClinicalDocument doc, Identificator id) {
		doc.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040Custodian mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040DataEnterer mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040InformationRecipient mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040Observation mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040Section mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040LegalAuthenticator mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040Organizer mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040RecordTarget mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateId(POCDMT000040Specimen mdht, Identificator id) {
		mdht.getTemplateId().add(id.getHl7CdaR2Ii());
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
	public static void addTemplateIdOnce(POCDMT000040Act mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040Authenticator mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040Author mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040ClinicalDocument doc, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : doc.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040Custodian mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040DataEnterer mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040InformationRecipient mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040Observation mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040Section mdht, Identificator id) {
		var alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040LegalAuthenticator mdht, Identificator id) {
		var alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040Organizer mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040RecordTarget mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
	public static void addTemplateIdOnce(POCDMT000040Specimen mdht, Identificator id) {
		boolean alreadyExists = false;
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii()))
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
		final II ii = new II();
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
		final II ii = new II();
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
			ii = id.getHl7CdaR2Ii();
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
		final II ii = new II();
		ii.setRoot(EhcVersions.getCurrentVersion().getOid());
		if (id == null) {
			ii.setExtension(UUID.generate());
		} else {
			ii.setExtension(id);
		}
		return ii;
	}

	/**
	 * Removes the template id.
	 *
	 * @param mdht
	 *            the mdht
	 * @param id
	 *            the id
	 */
	public static void removeTemplateId(POCDMT000040Observation mdht, Identificator id) {
		for (II existingId : mdht.getTemplateId()) {
			if (existingId.equals(id.getHl7CdaR2Ii())) {
				mdht.getTemplateId().remove(existingId);
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
			List<POCDMT000040EntryRelationship> entryRelationships) {
		final int erNb = entryRelationships.size() - 1;
		entryRelationships.get(erNb).setInversionInd(true);
		entryRelationships.get(erNb).setTypeCode(XActRelationshipEntryRelationship.SUBJ);
	}

	/**
	 * Sets the entry relationship type code.
	 *
	 * @param erList
	 *            the er list
	 * @param typeCode
	 *            the type code
	 */
	public static void setEntryRelationshipTypeCode(List<POCDMT000040EntryRelationship> erList,
			XActRelationshipEntryRelationship typeCode) {
		final int nb = erList.size() - 1;
		erList.get(nb).setTypeCode(typeCode);
	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040Act mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040Authenticator mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040Author mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param doc
	 *            the doc
	 */
	public static void sortTemplateIds(POCDMT000040ClinicalDocument doc) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : doc.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		doc.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			doc.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040Custodian mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040DataEnterer mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040InformationRecipient mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}


	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040Observation mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040Section mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040LegalAuthenticator mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040Organizer mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040RecordTarget mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}

	/**
	 * Sort template ids.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public static void sortTemplateIds(POCDMT000040Specimen mdht) {
		ArrayList<Identificator> list = new ArrayList<>();
		for (II ii : mdht.getTemplateId()) {
			list.add(new Identificator(ii));
		}
		mdht.getTemplateId().clear();
		list.sort(new IdentificatorComparator());
		for (Identificator identificator : list) {
			mdht.getTemplateId().add(identificator.getHl7CdaR2Ii());
		}

	}
}
