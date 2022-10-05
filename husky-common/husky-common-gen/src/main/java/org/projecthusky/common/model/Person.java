/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

package org.projecthusky.common.model;

import java.util.ArrayList;
import java.util.List;

import org.projecthusky.common.hl7cdar2.POCDMT000040Person;

/**
 * Eine Person (z.B. Arzt, Datenerfasser, Angehörige, ...)
 */
public class Person {

    /**
     * The CDA person.
     */
    private POCDMT000040Person mPerson;

    /**
     * Instantiates a new person.
     */
    public Person() {
        mPerson = new POCDMT000040Person();
    }

    /**
     * Erstellt eine neue Person (Dieser Konstruktor wird oft gebraucht für Behandelnde).
     *
     * @param name name
     */
    public Person(Name name) {
        mPerson = new POCDMT000040Person();
        // Create and fill Person Name
        mPerson.getName().add(name.getHl7CdaR2Pn());
    }

    /**
     * Instantiates a new person.
     *
     * @param person person
     */
    public Person(POCDMT000040Person person) {
        mPerson = person;
    }

	/**
     * Instantiaties a new person
     * 
     */
    public Person(org.openehealth.ipf.commons.ihe.xds.core.metadata.Person person) {
		this();
		setIpfPerson(person);
    }

    /**
     * Adds the name.
     *
     * @param name name
     */
    public void addName(Name name) {
        mPerson.getName().add(name.getHl7CdaR2Pn());
    }

    /**
     * Gets the complete name.
     *
     * @return the complete name
     */
    public String getCompleteName() {
        var retVal = "";
		if (!mPerson.getName().isEmpty()) {
            final var name = new Name(mPerson.getName().get(0));
            retVal = name.getFullName();
        }
        return retVal;
    }

    /**
     * Gets the CDA R2 person.
     *
     * @return the CDA R2 person
     */
    public POCDMT000040Person getHl7CdaPerson() {
        return mPerson;
    }

    /**
     * Gets the (first) name.
     *
     * @return the name
     */
    public Name getName() {
        return new Name(mPerson.getName().get(0));
    }

    /**
     * Gets the names.
     *
     * @return the names
     */
    public List<Name> getNames() {
        final List<Name> nl = new ArrayList<>();
        for (org.projecthusky.common.hl7cdar2.PN mName : mPerson.getName()) {
            nl.add(new Name(mName));
        }
        return nl;
    }

    public org.openehealth.ipf.commons.ihe.xds.core.metadata.Person getIpfPerson() {
        var person = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Person();

		if (!mPerson.getName().isEmpty()) {
            person.setName(Name.getIpfXpnName(mPerson.getName().get(0)));
        }

        return person;
    }

	public void setIpfPerson(org.openehealth.ipf.commons.ihe.xds.core.metadata.Person ipfPerson) {
		if (ipfPerson != null) {
			if (ipfPerson.getName() != null) {
				Name persName = new Name(ipfPerson.getName());
				mPerson.getName().add(persName.getHl7CdaR2Pn());
			}
		}
	}

}
