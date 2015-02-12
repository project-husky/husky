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
 * Attribution-ShareAlike 3.0 Switzerland License.
 * 
 * Year of publication: 2014
 * 
 *******************************************************************************/

package org.ehc.common;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;

/**
 * Eine Person (z.B. Arzt, Datenerfasser, Angehörige, ...)
 */
public class Person {

	org.openhealthtools.mdht.uml.cda.Person mPerson;
	
	public Person() {
		
	}

	public Person(org.openhealthtools.mdht.uml.cda.Person person) {
		this.mPerson = person;
	}

	/**
	 * Erstellt eine neue Person (Dieser Konstruktor wird oft gebraucht für Behandelnde)
	 * 
	 * @param familyName Nachname
	 * @param givenName Vorname
	 */
	public Person(Name name) {
		mPerson = CDAFactory.eINSTANCE.createPerson();
		// Create and fill Person Name
		mPerson.getNames().add(name.copyMdhtPn());
	}

	public Name getName() {
		Name name = new Name(mPerson.getNames().get(0)); 
		return name;
	}

	public ArrayList<Name> getNames() {
		ArrayList<Name> nl = new ArrayList<Name>();
		for (PN mName: mPerson.getNames()) {
			Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}
	
	public org.openhealthtools.mdht.uml.cda.Person getMdhtPerson() {
		return mPerson;
	}
	
	public org.openhealthtools.mdht.uml.cda.Person copyMdhtPerson() {
		return EcoreUtil.copy(mPerson);
	}
}
