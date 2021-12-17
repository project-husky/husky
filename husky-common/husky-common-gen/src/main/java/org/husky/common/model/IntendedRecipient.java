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
package org.husky.common.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.husky.common.hl7cdar2.AD;
import org.husky.common.hl7cdar2.POCDMT000040IntendedRecipient;
import org.husky.common.hl7cdar2.POCDMT000040Person;
import org.husky.common.hl7cdar2.TEL;

/**
 * The Class IntendedRecipient. This element contains information about a
 * specific person or organization which is the recipient of the document.
 */
public class IntendedRecipient {

	/** The MDHT intended recipient object. */
	private POCDMT000040IntendedRecipient mIntendedRecipient;

	/**
	 * Standard constructor.
	 */
	public IntendedRecipient() {
		this.setIntendedRecipient(new POCDMT000040IntendedRecipient());
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
	public IntendedRecipient(Name name, Identificator id, Address address, List<Telecom> telecoms) {
		this();
		final var p = new Person();
		p.addName(name);
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
	public IntendedRecipient(POCDMT000040IntendedRecipient mdht) {
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
		final var mdht = organization.getHl7CdaR2Pocdmt000040Organization();
		if (!mdht.getAddr().isEmpty()) {
			getIntendedRecipient().getAddr().addAll(mdht.getAddr());
		}
		if (!mdht.getId().isEmpty()) {
			getIntendedRecipient().getId().addAll(mdht.getId());
		}
		if (!mdht.getTelecom().isEmpty()) {
			getIntendedRecipient().getTelecom().addAll(mdht.getTelecom());
		}
		if (!mdht.getName().isEmpty()) {
			final var p = new POCDMT000040Person();
			p.getName().add(new Name(mdht.getName().get(0)).getHl7CdaR2Pn());
			getIntendedRecipient().setInformationRecipient(p);
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
		getIntendedRecipient().getAddr().add(address.getHl7CdaR2Ad());
	}

	/**
	 * Assigns an id.
	 *
	 * @param identificator
	 *            the id
	 */
	public void addId(Identificator identificator) {
		getIntendedRecipient().getId().add(identificator.getHl7CdaR2Ii());
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<>();
		for (final AD mAddress : getIntendedRecipient().getAddr()) {
			al.add(new Address(mAddress));
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
		return Identificator.getIdentificatorList(getIntendedRecipient().getId());
	}

	/**
	 * Method to get
	 *
	 * @return the intendedRecipient
	 */
	public POCDMT000040IntendedRecipient getIntendedRecipient() {
		return mIntendedRecipient;
	}

	/**
	 * Gets the person, who receives the information.
	 *
	 * @return the person
	 */
	public Person getMdhtInformationRecipient() {
		return new Person(getIntendedRecipient().getInformationRecipient());
	}

	/**
	 * Returns the underlying mdht element.
	 *
	 * @return the mdht element
	 */
	public POCDMT000040IntendedRecipient getMdhtIntendedRecipient() {
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
		return new Organization(
				getIntendedRecipient().getReceivedOrganization());
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public List<Telecom> getTelecoms() {
		List<Telecom> telecoms = new LinkedList<>();

		for (TEL tel : getIntendedRecipient().getTelecom()) {
			if (tel != null) {
				telecoms.add(new Telecom(tel));
			}
		}
		return telecoms;
	}

	/**
	 * Sets the person, who receives the information.
	 *
	 * @param person
	 *            the person
	 */
	public void setInformationRecipient(Person person) {
		getIntendedRecipient()
				.setInformationRecipient(person.getHl7CdaPerson());
	}

	/**
	 * Method to set
	 *
	 * @param intendedRecipient
	 *            the intendedRecipient to set
	 */
	public void setIntendedRecipient(
			POCDMT000040IntendedRecipient intendedRecipient) {
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
		getIntendedRecipient()
				.setReceivedOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
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
	public void setTelecoms(List<Telecom> telecoms) {
		for (Telecom telecom : telecoms) {
			if (telecom != null) {
				getIntendedRecipient().getTelecom().add(telecom.getHl7CdaR2Tel());
			}
		}
	}
}
