package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;

public class IntendedRecipient {
	protected org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient mIntendedRecipient;

	/**
	 * Standard constructor
	 */
	public IntendedRecipient() {
		this.mIntendedRecipient = LABFactory.eINSTANCE.createIntendedRecipient().init();
		this.mIntendedRecipient.setIntendedRecipient(CDAFactory.eINSTANCE.createIntendedRecipient());
	}

	/**
	 * Convenience constructor with required elements, if the recipient is a
	 * person. The according informationRecipient element will be constructed with
	 * the given name.
	 */
	public IntendedRecipient(Name name, Identificator id, Address address, Telecoms telecoms) {
		this();
		Person p = new Person(name);
		setInformationRecipient(p);
		addId(id);
		addAddress(address);
		setTelecoms(telecoms);
	}

	/**
	 * Standard mdht constructor
	 *
	 * @param mdht
	 *          the mdht object
	 */
	public IntendedRecipient(org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient mdht) {
		this.mIntendedRecipient = mdht;
	}

	/**
	 * Convenience constructor with required elements, if the recipient is an
	 * organization. The according receivingOrganization element will be
	 * constructed with the same data as the IntendedRecipient (Id, addr,
	 * telecoms). These elements have to be present in the Organization object.
	 */
	public IntendedRecipient(Organization organization) {
		this();
		org.openhealthtools.mdht.uml.cda.Organization mdht = organization.copyMdhtOrganization();
		if (!mdht.getAddrs().isEmpty()) {
			mIntendedRecipient.getIntendedRecipient().getAddrs().addAll(mdht.getAddrs());
		}
		if (!mdht.getIds().isEmpty()) {
			mIntendedRecipient.getIntendedRecipient().getIds().addAll(mdht.getIds());
		}
		if (!mdht.getTelecoms().isEmpty()) {
			mIntendedRecipient.getIntendedRecipient().getTelecoms().addAll(mdht.getTelecoms());
		}
		setOrganization(organization);
	}

	/**
	 * Assigns a post address
	 *
	 * @param address
	 *          the post address
	 */
	public void addAddress(Address address) {
		mIntendedRecipient.getIntendedRecipient().getAddrs().add(address.copyMdhtAdress());
	}

	/**
	 * Assigns an id
	 *
	 * @param identificator
	 *          the id
	 */
	public void addId(Identificator identificator) {
		mIntendedRecipient.getIntendedRecipient().getIds().add(identificator.getIi());
	}

	/**
	 * Returns a copy of the underlying mdht element
	 *
	 * @return the copy of the mdht element
	 */
	public org.openhealthtools.mdht.uml.cda.IntendedRecipient copy() {
		return EcoreUtil.copy(mIntendedRecipient.getIntendedRecipient());
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<Address>();
		for (final AD mAddress : mIntendedRecipient.getIntendedRecipient().getAddrs()) {
			final Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	/**
	 * <div class="en">Gets all ids of the author</div> <div class="de">Liefert
	 * alle IDs des Autoren</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<Identificator> getIds() {
		return Util.convertIds(mIntendedRecipient.getIntendedRecipient().getIds());
	}

	/**
	 * Returns the underlying mdht element
	 *
	 * @return
	 *
	 * @return the mdht element
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient getIntendedRecipient() {
		return this.mIntendedRecipient;
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
				mIntendedRecipient.getIntendedRecipient().getReceivedOrganization());
		return o;
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public Telecoms getTelecoms() {
		return new Telecoms(mIntendedRecipient.getIntendedRecipient().getTelecoms());
	}

	/**
	 * Gets the person, who receives the information
	 *
	 * @return the person
	 */
	public Person setInformationRecipient() {
		return new Person(mIntendedRecipient.getIntendedRecipient().getInformationRecipient());
	}

	/**
	 * Sets the person, who receives the information
	 *
	 * @param person
	 *          the person
	 */
	public void setInformationRecipient(Person person) {
		mIntendedRecipient.getIntendedRecipient().setInformationRecipient(person.copyMdhtPerson());
	}

	/**
	 * <div class="en">Sets the organization (ReceivedOrganization).</div>
	 * <div class="de">Setzt eine Organisation (ReceivedOrganization), der der
	 * Autor angehört (z.B. ein Krankenhaus). </div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @param organization
	 *          <div class="en">the new organization</div> <div class="de">die
	 *          neue Organisation</div> <div class="fr"></div>
	 *          <div class="it"></div>
	 */
	public void setOrganization(Organization organization) {
		mIntendedRecipient.getIntendedRecipient()
				.setReceivedOrganization(organization.copyMdhtOrganization());
	}

	/**
	 * <div class="en">Sets the telecoms.</div> <div class="de">Setzt
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param telecoms
	 *          <div class="en">the new telecoms</div> <div class="de">das neue
	 *          telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void setTelecoms(Telecoms telecoms) {
		mIntendedRecipient.getIntendedRecipient().getTelecoms()
				.addAll(EcoreUtil.copyAll(telecoms.getMdhtTelecoms()));
	}
}
