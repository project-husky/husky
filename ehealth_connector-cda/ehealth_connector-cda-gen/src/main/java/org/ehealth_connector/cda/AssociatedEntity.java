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
package org.ehealth_connector.cda;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Person;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * The Class AssociatedEntity.
 */
public class AssociatedEntity
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.AssociatedEntity> {

	/**
	 * Instantiates a new associated entity.
	 */
	public AssociatedEntity() {
		super(CDAFactory.eINSTANCE.createAssociatedEntity());
	}

	/**
	 * Creates a new AssociatedEntity. This constructor can be used, if the
	 * Adress and Telecoms of the Entity are unknown (associatedEntity/addr and
	 * associatedEntity/telecom will be set to NullFlavor = UNK). The
	 * constructor also creates a Person object with the given Name
	 * (associatedEntity/associatedPerson/name)
	 *
	 * @param name
	 *            the name
	 */
	public AssociatedEntity(Name name) {
		this();
		final Person person = new Person(name);
		setPerson(person);

		// add AD = UNK
		final AD address = DatatypesFactory.eINSTANCE.createAD();
		address.setNullFlavor(NullFlavor.UNK);
		getMdht().getAddrs().add(address);

		// add TEL = UNK
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.setNullFlavor(NullFlavor.UNK);
		getMdht().getTelecoms().add(tel);
	}

	/**
	 * Creates a new AssociatedEntity. This constructor also creates a Person
	 * object with the given Name (associatedEntity/associatedPerson/name)
	 *
	 * @param name
	 *            the persons name
	 * @param address
	 *            the address
	 * @param telecoms
	 *            the telecoms
	 *
	 *
	 */
	public AssociatedEntity(Name name, Address address, Telecoms telecoms) {
		this(name);
		getMdht().getAddrs().clear();
		getMdht().getTelecoms().clear();
		addAddress(address);
		setTelecoms(telecoms);
	}

	/**
	 * Instantiates a new associated entity.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public AssociatedEntity(org.openhealthtools.mdht.uml.cda.AssociatedEntity mdht) {
		super(mdht);
	}

	/**
	 * <div class="en">Sets the adress.</div> <div class="de">Weist eine
	 * Postadresse zu.</div>
	 *
	 *
	 * @param adress
	 *            the adress
	 */
	public void addAddress(Address adress) {
		getMdht().getAddrs().add(adress.copyMdhtAdress());
	}

	/**
	 * <div class="en">Adds an ID.</div> <div class="de">Weist dem Element eine
	 * ID zu.</div>
	 *
	 *
	 * @param identificator
	 *            Combination of a root ID and an extension
	 */
	public void addId(Identificator identificator) {
		getMdht().getIds().add(identificator.getIi());
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<Address>();
		for (final AD mAddress : getMdht().getAddrs()) {
			final Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	/**
	 * <div class="en">Gets all ids</div> <div class="de">Liefert alle IDs</div>
	 * <div class="fr"></div> <div class="it"></div>.
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<Identificator> getIds() {
		return Util.convertIds(getMdht().getIds());
	}

	/**
	 * <div class="en">Gets the organization (RepresentedOrganization).</div>
	 * <div class="de">Liefert die Organisation (RepresentedOrganization), der
	 * der Autor angehört (z.B. ein Krankenhaus).</div>
	 *
	 *
	 * @return organization <div class="en">the organization</div>
	 *         <div class="de">die Organisation</div> <div class="fr"></div>
	 *         <div class="it"></div>
	 */
	public Organization getOrganization() {
		final Organization o = new Organization(getMdht().getScopingOrganization());
		return o;
	}

	/**
	 * Gets the person.
	 *
	 * @return the person
	 */
	public Person getPerson() {
		if (getMdht().getAssociatedPerson() != null) {
			return new Person(getMdht().getAssociatedPerson());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public Telecoms getTelecoms() {
		return new Telecoms(getMdht().getTelecoms());
	}

	/**
	 * <div class="en">Sets the organization (RepresentedOrganization).</div>
	 * <div class="de">Setzt eine Organisation (ScopingOrganization), der der
	 * überweisende Arzt angehört (z.B. ein Krankenhaus).</div>
	 *
	 *
	 * @param organization
	 *            <div class="en">the new organization</div> <div class="de">die
	 *            neue Organisation</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setOrganization(Organization organization) {
		getMdht().setScopingOrganization(organization.copyMdhtOrganization());
	}

	/**
	 * Sets the person.
	 *
	 * @param person
	 *            the new person
	 */
	public void setPerson(Person person) {
		getMdht().setAssociatedPerson(person.getMdhtPerson());
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
		getMdht().getTelecoms().addAll(EcoreUtil.copyAll(telecoms.getMdhtTelecoms()));
	}
}
