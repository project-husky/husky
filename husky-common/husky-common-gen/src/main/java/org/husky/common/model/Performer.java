/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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

package org.husky.common.model;

import java.util.*;

import org.husky.common.basetypes.IdentificatorBaseType;
import org.husky.common.enums.CodeSystems;
import org.husky.common.hl7cdar2.AD;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.PN;
import org.husky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.husky.common.hl7cdar2.POCDMT000040Performer2;
import org.husky.common.hl7cdar2.POCDMT000040Person;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.utils.DateUtil;
import org.husky.common.utils.Util;

/**
 * A Person or Organization performing an action
 *
 */
public class Performer {

	private final POCDMT000040Performer2 mPerfomer;
	private final POCDMT000040AssignedEntity mAsEntity;
	private POCDMT000040Person mPerson;

	/**
	 * Instantiates a new performer.
	 */
	public Performer() {
		mPerfomer = new POCDMT000040Performer2();
		mAsEntity = new POCDMT000040AssignedEntity();
		mPerson = new POCDMT000040Person();

		mAsEntity.setAssignedPerson(mPerson);
		mPerfomer.setAssignedEntity(mAsEntity);

		// add time
		setTimeValue(new Date());
	}

	/**
	 * Instantiates a new performer.
	 *
	 * @param author
	 *            the author to be used as performer.
	 */
	public Performer(Author author) {
		this();
		addName(author.getName());
		for (org.husky.common.model.Identificator id : author.getIds()) {
			mAsEntity.getId().add(id.getHl7CdaR2Ii());
		}

		// add time
		setTimeValue(author.getTimeAsDate());

		if (author.getOrganization() != null)
				setOrganization(author.getOrganization());
	}

	/**
	 * Default constructor to instanciate the object
	 *
	 * @param name
	 *            the name of the performer
	 */
	public Performer(Name name) {
		this();
		addName(name);
	}

	/**
	 * Erstellt einen neuen Perfomer (Dieser Konstruktor wird oft gebraucht für
	 * Gesundheitsfachpersonen
	 *
	 * @param name
	 *            Name
	 * @param gln
	 *            Global Location Number (GLN)
	 */
	public Performer(Name name, String gln) {
		this(name);

		// Create and fill Person Name and GLN
		final var id = new II();
		id.setRoot(CodeSystems.GLN.getCodeSystemId());
		id.setExtension(gln);

		mAsEntity.getId().add(id);
	}

	/**
	 * Erstellt ein eHealthconnector-Performer Objekt mittels eines
	 * MDHT-Performer Objekts.
	 *
	 * @param performerMdht
	 *            the MDHT Performer Object
	 */
	public Performer(POCDMT000040Performer2 performerMdht) {
		mPerfomer = performerMdht;
		mAsEntity = performerMdht.getAssignedEntity();
		mPerson = performerMdht.getAssignedEntity().getAssignedPerson();
	}

	/**
	 * Default constructor to instanciate the object
	 *
	 * @param organization
	 *            the organization of the performer
	 */
	public Performer(org.husky.common.model.Organization organization) {
		mPerfomer = new POCDMT000040Performer2();
		mAsEntity = new POCDMT000040AssignedEntity();
		mPerfomer.setAssignedEntity(mAsEntity);

		// add time
		setTimeValue(new Date());

		setOrganization(organization);

		for (IdentificatorBaseType idBaseType : organization.getIdentificatorList()) {
			if (idBaseType != null) {
				mAsEntity.getId().add(new org.husky.common.model.Identificator(idBaseType).getHl7CdaR2Ii());
			}
		}

	}

	/**
	 * Instantiates a new performer.
	 *
	 * @param person
	 *            the person to be used as performer.
	 */
	public Performer(Person person) {
		this();
		addName(person.getName());
	}

	/**
	 * Weist dem Autor eine Postadresse zu.
	 *
	 * @param address
	 *            Die Postadresse des Autors
	 */
	public void addAddress(Address address) {
		mAsEntity.getAddr().add(address.getHl7CdaR2Ad());
	}

	/**
	 * Weist dem Autoren eine ID zu.
	 *
	 * @param identificator
	 *            Kombination von eigentlicher ID und der OID der verwaltenden
	 *            Domäne
	 */
	public void addId(org.husky.common.model.Identificator identificator) {
		mAsEntity.getId().add(identificator.getHl7CdaR2Ii());
	}

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *            name
	 */
	public void addName(Name name) {
		mAsEntity.getAssignedPerson().getName().add(name.getHl7CdaR2Pn());
	}

	/**
	 * <div class="en">Copy mdht performer.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda. performer 2
	 */
	public POCDMT000040Performer2 getHl7Cdar2Perfomer() {
		return mPerfomer;
	}

	/**
	 * <div class="en">Gets the address.</div> <div class="de">Liefert die
	 * (erste) Adresse.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the address</div>
	 */
	public Address getAddress() {
		return new Address(mAsEntity.getAddr().get(0));
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<>();
		for (final AD mAddress : mAsEntity.getAddr()) {
			al.add(new Address(mAddress));
		}
		return al;
	}

	/**
	 * <div class="en">Gets the complete name.</div> <div class="de">Liefert den
	 * ganzen Namen (z.B. "Dr. Allzeit Bereit der Dritte")</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the complete name</div>
	 */
	public String getCompleteName() {
		// Search for the performer name. If it isn´t there, try to use the
		// organisation name.
		var retVal = "";
		if ((mAsEntity != null) && (mAsEntity.getAssignedPerson() != null)) {
			if (mAsEntity.getAssignedPerson().getName() != null) {
				final var name = new Name(mAsEntity.getAssignedPerson().getName().get(0));
				retVal = name.getFullName();
			} else {
				if ((mAsEntity.getRepresentedOrganization() != null)
						&& (mAsEntity.getRepresentedOrganization().getName() != null)) {
					final var name = new Name(
							mAsEntity.getRepresentedOrganization().getName().get(0));
					retVal = name.getFullName();
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the gln (identification of the performer)</div>
	 * <div class="de">Liefert die GLN (ID des Autors)</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the gln</div>
	 */
	public String getGln() {
		for (II id : mAsEntity.getId()) {
			if (id != null && CodeSystems.GLN.getCodeSystemId().equalsIgnoreCase(id.getRoot())) {
				return id.getExtension();
			}
		}

		return null;
	}

	/**
	 * <div class="en">Gets the gln as identificator.</div>
	 * <div class="de">Liefert gln (ID des Autoren) als Identificator
	 * Objekt.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the gln as identificator</div>
	 */
	public org.husky.common.model.Identificator getGlnAsIdentificator() {
		final var ii = mAsEntity.getId().get(0);
		return new org.husky.common.model.Identificator(ii);
	}

	/**
	 * <div class="en">Gets all ids of the performer</div>
	 * <div class="de">Liefert alle IDs des Autoren</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<org.husky.common.model.Identificator> getIds() {
		return Util.convertIds(mAsEntity.getId());
	}

	/**
	 * <div class="en">Gets the (first) family name.</div>
	 * <div class="de">Liefert den (ersten) Nachnamen</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the name</div>
	 */
	public Name getName() {
		return new Name(mAsEntity.getAssignedPerson().getName().get(0));
	}

	/**
	 * <div class="en">Gets the names.</div> <div class="de">Liefert alle
	 * Nachnamen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	public List<Name> getNames() {
		final List<Name> nl = new ArrayList<>();
		for (final PN mName : mAsEntity.getAssignedPerson().getName()) {
			nl.add(new Name(mName));
		}
		return nl;
	}

	/**
	 * <div class="en">Gets the organization (RepresentedOrganization)</div>
	 * <div class="de">Liefert die Organisation (RepresentedOrganization), der
	 * der Autor angehört (z.B. ein Krankenhaus)</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return organization <div class="en">the organization</div>
	 *         <div class="de">die Organisation</div> <div class="fr"></div>
	 *         <div class="it"></div>
	 */
	public Organization getOrganization() {
		return new Organization(mAsEntity.getRepresentedOrganization());
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public List<Telecom> getTelecoms() {
		List<Telecom> telecoms = new LinkedList<>();

		for (TEL tel : mAsEntity.getTelecom()) {
			if (tel != null) {
				telecoms.add(new Telecom(tel));
			}
		}

		return telecoms;
	}

	/**
	 * <div class="en">Gets the performance time</div> <div class="de">Liefert
	 * die Zeit für den Performer.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return date <div class="en">the performance time</div>
	 *         <div class="de">die Zeit für den Performer.</div>
	 *         <div class="fr"></div> <div class="it"></div>
	 */
	public IVLTS getTimeAsIVLTS() {
		return new IVLTS(Optional.ofNullable(mPerfomer.getTime()).map(IVLTS::getValue).orElse(null));
	}

	/**
	 * <div class="en">Sets the gln.</div> <div class="de">Setzt die GLN (ID des
	 * Autoren).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @param gln
	 *            <div class="en">the new gln</div> <div class="de">das neue
	 *            gln.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void setGln(String gln) {
		addId(new org.husky.common.model.Identificator(CodeSystems.GLN.getCodeSystemId(), gln));
	}

	/**
	 * <div class="en">Sets the organization (RepresentedOrganization)</div>
	 * <div class="de">Setzt eine Organisation (RepresentedOrganization), der
	 * der Autor angehört (z.B. ein Krankenhaus)</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @param organization
	 *            <div class="en">the new organization</div> <div class="de">die
	 *            neue Organisation</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setOrganization(org.husky.common.model.Organization organization) {
		mAsEntity.setRepresentedOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
	}

	/**
	 * <div class="en">Sets the telecoms.</div> <div class="de">Setzt
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param telecoms
	 *            <div class="en">the new telecoms</div> <div class="de">das
	 *            neue telecoms.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setTelecoms(List<TEL> telecoms) {
		mAsEntity.getTelecom().addAll(telecoms);
	}

	/**
	 * Sets the Time Value
	 *
	 * @param eurDate
	 *            the date
	 */
	public void setTimeValue(Date eurDate) {
		mPerfomer.setTime(DateUtil.date2IvltsTzon(eurDate));
	}

}
