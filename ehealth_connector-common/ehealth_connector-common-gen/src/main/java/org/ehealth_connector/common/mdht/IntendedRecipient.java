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
package org.ehealth_connector.common.mdht;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;

/**
 * The Class IntendedRecipient. This element contains information about a
 * specific person or organization which is the recipient of the document.
 */
public class IntendedRecipient {

	/** The MDHT intended recipient object. */
	private org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient mIntendedRecipient;

	/**
	 * Standard constructor.
	 */
	public IntendedRecipient() {
		this.setIntendedRecipient(LABFactory.eINSTANCE.createIntendedRecipient().init());
		this.getIntendedRecipient()
				.setIntendedRecipient(CDAFactory.eINSTANCE.createIntendedRecipient());
	}

	/**
	 * Convenience constructor with (for CDA-CH-LRTP) required elements, if the
	 * recipient is a person. The according informationRecipient element will be
	 * constructed with the given name.
	 *
	 * @param name
	 *            the name
	 * @param id
	 *            the id
	 * @param address
	 *            the address
	 * @param telecoms
	 *            the telecoms
	 */
	public IntendedRecipient(Name name, Identificator id, Address address, Telecoms telecoms) {
		this();
		final Person p = new Person(name);
		setInformationRecipient(p);
		addId(id);
		addAddress(address);
		setTelecoms(telecoms);
	}

	/**
	 * Standard mdht constructor.
	 *
	 * @param mdht
	 *            the mdht object
	 */
	public IntendedRecipient(org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient mdht) {
		this.setIntendedRecipient(mdht);
	}

	/**
	 * Convenience constructor with required elements, if the recipient is an
	 * organization. The according receivingOrganization element will be
	 * constructed with the same data as the IntendedRecipient (Id, addr,
	 * telecoms). These elements have to be present in the Organization object.
	 * If the Organization has a name, it will be set as the name for the
	 * information recipient (intendedRecipient/informationRecipient/name[0] =
	 * organization/name[0])
	 *
	 * @param organization
	 *            the organization
	 */
	public IntendedRecipient(Organization organization) {
		this();
		final org.openhealthtools.mdht.uml.cda.Organization mdht = organization
				.copyMdhtOrganization();
		if (!mdht.getAddrs().isEmpty()) {
			getIntendedRecipient().getIntendedRecipient().getAddrs().addAll(mdht.getAddrs());
		}
		if (!mdht.getIds().isEmpty()) {
			getIntendedRecipient().getIntendedRecipient().getIds().addAll(mdht.getIds());
		}
		if (!mdht.getTelecoms().isEmpty()) {
			getIntendedRecipient().getIntendedRecipient().getTelecoms().addAll(mdht.getTelecoms());
		}
		if (!mdht.getNames().isEmpty()) {
			final org.openhealthtools.mdht.uml.cda.Person p = CDAFactory.eINSTANCE.createPerson();
			p.getNames().add(Util.createPnFromOn(mdht.getNames().get(0)));
			getIntendedRecipient().getIntendedRecipient().setInformationRecipient(p);
		}
		setOrganization(organization);
	}

	/**
	 * Assigns a post address.
	 *
	 * @param address
	 *            the post address
	 */
	public void addAddress(Address address) {
		getIntendedRecipient().getIntendedRecipient().getAddrs().add(address.copyMdhtAdress());
	}

	/**
	 * Assigns an id.
	 *
	 * @param identificator
	 *            the id
	 */
	public void addId(Identificator identificator) {
		getIntendedRecipient().getIntendedRecipient().getIds().add(identificator.getIi());
	}

	/**
	 * Returns a copy of the underlying mdht element.
	 *
	 * @return the copy of the mdht element
	 */
	public org.openhealthtools.mdht.uml.cda.IntendedRecipient copy() {
		return EcoreUtil.copy(getIntendedRecipient().getIntendedRecipient());
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<Address>();
		for (final AD mAddress : getIntendedRecipient().getIntendedRecipient().getAddrs()) {
			final Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	/**
	 * <div class="en">Gets all ids of the author</div> <div class="de">Liefert
	 * alle IDs des Autoren</div> <div class="fr"></div> <div class="it"></div>.
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<Identificator> getIds() {
		return Util.convertIds(getIntendedRecipient().getIntendedRecipient().getIds());
	}

	/**
	 * Method to get
	 *
	 * @return the intendedRecipient
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient getIntendedRecipient() {
		return mIntendedRecipient;
	}

	/**
	 * Gets the person, who receives the information.
	 *
	 * @return the person
	 */
	public Person getMdhtInformationRecipient() {
		return new Person(getIntendedRecipient().getIntendedRecipient().getInformationRecipient());
	}

	/**
	 * Returns the underlying mdht element.
	 *
	 * @return the mdht element
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient getMdhtIntendedRecipient() {
		return this.getIntendedRecipient();
	}

	/**
	 * <div class="en">Gets the organization (ReceivedOrganization).</div>
	 * <div class="de">Liefert die Organisation (ReceivedOrganization), der der
	 * Autor angehört (z.B. ein Krankenhaus).</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @return organization <div class="en">the organization</div>
	 *         <div class="de">die Organisation</div> <div class="fr"></div>
	 *         <div class="it"></div>
	 */
	public Organization getOrganization() {
		final Organization o = new Organization(
				getIntendedRecipient().getIntendedRecipient().getReceivedOrganization());
		return o;
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public Telecoms getTelecoms() {
		return new Telecoms(getIntendedRecipient().getIntendedRecipient().getTelecoms());
	}

	/**
	 * Sets the person, who receives the information.
	 *
	 * @param person
	 *            the person
	 */
	public void setInformationRecipient(Person person) {
		getIntendedRecipient().getIntendedRecipient()
				.setInformationRecipient(person.copyMdhtPerson());
	}

	/**
	 * Method to set
	 *
	 * @param intendedRecipient
	 *            the intendedRecipient to set
	 */
	public void setIntendedRecipient(
			org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient intendedRecipient) {
		mIntendedRecipient = intendedRecipient;
	}

	/**
	 * <div class="en">Sets the organization (ReceivedOrganization).</div>
	 * <div class="de">Setzt eine Organisation (ReceivedOrganization), der der
	 * Autor angehört (z.B. ein Krankenhaus). </div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @param organization
	 *            <div class="en">the new organization</div> <div class="de">die
	 *            neue Organisation</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setOrganization(Organization organization) {
		getIntendedRecipient().getIntendedRecipient()
				.setReceivedOrganization(organization.copyMdhtOrganization());
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
	public void setTelecoms(Telecoms telecoms) {
		getIntendedRecipient().getIntendedRecipient().getTelecoms()
				.addAll(EcoreUtil.copyAll(telecoms.getMdhtTelecoms()));
	}
}
