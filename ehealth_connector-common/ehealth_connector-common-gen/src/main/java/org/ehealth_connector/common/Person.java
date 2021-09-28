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

package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.hl7cdar2.POCDMT000040Person;

/**
 * Eine Person (z.B. Arzt, Datenerfasser, Angehörige, ...)
 */
public class Person {

	/**
	 * The CDA person.
	 */
	private POCDMT000040Person mPerson;

	/**
	 * <div class="en">Instantiates a new person.</div>
	 * <div class="de">Instantiiert ein neues Personen Objekt </div>
	 * <div class="fr"></div> <div class="it"></div>
	 */
	public Person() {
		mPerson = new POCDMT000040Person();
	}

	/**
	 * Erstellt eine neue Person (Dieser Konstruktor wird oft gebraucht für
	 * Behandelnde).
	 *
	 * @param name
	 *            <br>
	 *            <div class="de"> name</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Person(Name name) {
		mPerson = new POCDMT000040Person();
		// Create and fill Person Name
		mPerson.getName().add(name.getHl7CdaR2Pn());
	}

	/**
	 * <div class="en">Instantiates a new person.</div>
	 * <div class="de">Instantiiert eine neues Personen Objekt </div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param person
	 *            <br>
	 *            <div class="de"> person</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Person(POCDMT000040Person person) {
		mPerson = person;
	}

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *            name
	 */
	public void addName(Name name) {
		mPerson.getName().add(name.getHl7CdaR2Pn());
	}

	/**
	 * <div class="en">Gets the complete name.</div> <div class="de">Liefert den
	 * ganzen Namen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the complete name</div>
	 */
	public String getCompleteName() {
		var retVal = "";
		if (mPerson.getName() != null && !mPerson.getName().isEmpty()) {
			final var name = new Name(mPerson.getName().get(0));
			retVal = name.getFullName();
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the mdht person.</div> <div class="de">Liefert mdht
	 * person.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.Person <div class="en">the mdht
	 *         person</div>
	 */
	public POCDMT000040Person getHl7CdaPerson() {
		return mPerson;
	}

	/**
	 * <div class="en">Gets the (first) name.</div> <div class="de">Liefert den
	 * (ersten) Namen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the name</div>
	 */
	public Name getName() {
		return new Name(mPerson.getName().get(0));
	}

	/**
	 * <div class="en">Gets the names.</div> <div class="de">Liefert alle
	 * Namen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	public List<Name> getNames() {
		final List<Name> nl = new ArrayList<>();
		for (org.ehealth_connector.common.hl7cdar2.PN mName : mPerson.getName()) {
			nl.add(new Name(mName));
		}
		return nl;
	}

	public org.openehealth.ipf.commons.ihe.xds.core.metadata.Person getIpfPerson() {
		var person = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Person();

		if(mPerson.getName() != null && !mPerson.getName().isEmpty()) {
			person.setName(Name.getIpfXpnName(mPerson.getName().get(0)));
		}
		
		return person;
	}

}
