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

package org.ehealth_connector.common;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;

/**
 * Eine Person (z.B. Arzt, Datenerfasser, Angehörige, ...)
 */
public class Person {

	/**
	 * The mdht person.
	 */
	org.openhealthtools.mdht.uml.cda.Person mPerson;

	/**
	 * <div class="en">Instantiates a new person.</div> <div
	 * class="de">Instantiiert ein neues Personen Objekt </div> <div
	 * class="fr"></div> <div class="it"></div>
	 */
	public Person() {

	}

	/**
	 * Erstellt eine neue Person (Dieser Konstruktor wird oft gebraucht für
	 * Behandelnde).
	 *
	 * @param name
	 * <br>
	 *            <div class="de"> name</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Person(Name name) {
		mPerson = CDAFactory.eINSTANCE.createPerson();
		// Create and fill Person Name
		mPerson.getNames().add(name.copyMdhtPn());
	}

	/**
	 * <div class="en">Instantiates a new person.</div> <div
	 * class="de">Instantiiert eine neues Personen Objekt </div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @param person
	 * <br>
	 *            <div class="de"> person</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Person(org.openhealthtools.mdht.uml.cda.Person person) {
		mPerson = person;
	}

	/**
	 * <div class="en">Copy mdht person.</div> <div class="de"></div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.Person The MDHT Person
	 *         object
	 */
	public org.openhealthtools.mdht.uml.cda.Person copyMdhtPerson() {
		return EcoreUtil.copy(mPerson);
	}

	/**
	 * <div class="en">Gets the mdht person.</div> <div class="de">Liefert mdht
	 * person.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.Person <div class="en">the mdht
	 *         person</div>
	 */
	public org.openhealthtools.mdht.uml.cda.Person getMdhtPerson() {
		return mPerson;
	}

	/**
	 * <div class="en">Gets the (first) name.</div> <div class="de">Liefert den
	 * (ersten) Namen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the name</div>
	 */
	public Name getName() {
		Name name = new Name(mPerson.getNames().get(0));
		return name;
	}

	/**
	 * <div class="en">Gets the names.</div> <div class="de">Liefert alle
	 * Namen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	public ArrayList<Name> getNames() {
		ArrayList<Name> nl = new ArrayList<Name>();
		for (PN mName : mPerson.getNames()) {
			Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}
}
