/*
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

package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.NameUse;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityNameUse;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

/**
 * Eine Organisation (Arztpraxis, Spital, Arbeitgeber, Versicherung, ...)
 */
public class Organization {

	/**
	 * The mdht organization object.
	 */
	private final org.openhealthtools.mdht.uml.cda.Organization mOrganization;

	public Organization() {
		mOrganization = CDAFactory.eINSTANCE.createOrganization();
	}

	/**
	 * <div class="en">Instantiates a new organization.</div>
	 * <div class="de">Instantiiert ein neues Organization Objekt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param organization
	 *            <br>
	 *            <div class="de"> organization</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Organization(org.openhealthtools.mdht.uml.cda.Organization organization) {
		mOrganization = organization;
	}

	/**
	 * Erstellt eine neue Organisation (Spital, Arztpraxis, Firma, Verein, etc.)
	 *
	 * @param name
	 *            Name der Organisation
	 */
	public Organization(String name) {
		mOrganization = CDAFactory.eINSTANCE.createOrganization();
		addName(name);
	}

	/**
	 * Erstellt eine neue Organisation (Spital, Arztpraxis, Firma, Verein, etc.)
	 *
	 * @param name
	 *            Name der Organisation
	 * @param use
	 *            the use
	 */
	public Organization(String name, NameUse use) {
		mOrganization = CDAFactory.eINSTANCE.createOrganization();
		addName(name, use);
	}

	/**
	 * Erstellt eine neue Organisation (Spital, Arztpraxis), die über eine
	 * eigene ID (GLN) verfügt.
	 *
	 * @param name
	 *            Name der Organisation
	 * @param gln
	 *            <br>
	 *            <div class="de"> gln</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Organization(String name, String gln) {
		this(name);
		final II id = DatatypesFactory.eINSTANCE.createII();
		id.setRoot(CodeSystems.GLN.getCodeSystemId());
		id.setExtension(gln);
		mOrganization.getIds().add(id);
	}

	/**
	 * Weist der Organisation eine Postadresse zu (Geschäftsadresse).
	 *
	 * @param address
	 *            Adresse
	 */
	public void addAddress(Address address) {
		getMdhtOrganization().getAddrs().add(address.copyMdhtAdress());
	}

	/**
	 * Weist der Organisation eine ID zu.
	 *
	 * @param id
	 *            Der neue Identificator
	 */
	public void addId(Identificator id) {
		mOrganization.getIds().add(id.getIi());
	}

	/**
	 * Weist der Organisation einen Namen zu.
	 *
	 * @param name
	 *            Name
	 */
	public void addName(String name) {
		if (name != null) {
			final ON orgaName = DatatypesFactory.eINSTANCE.createON();
			getMdhtOrganization().getNames().add(orgaName);
			orgaName.addText(name);
		}
	}

	/**
	 * Weist der Organisation einen Namen zu.
	 *
	 * @param name
	 *            Name
	 * @param use
	 *            the use
	 */
	public void addName(String name, NameUse use) {
		if (name != null) {
			final ON orgaName = DatatypesFactory.eINSTANCE.createON();
			orgaName.getUses().clear();
			orgaName.getUses().add(convertUse(use));
			getMdhtOrganization().getNames().add(orgaName);
			orgaName.addText(name);
		}
	}

	/**
	 * Weist der Organisation eine Webseite zu.
	 *
	 * @param url
	 *            URL der Webseite
	 */
	public void addWebsite(String url) {
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(TelecommunicationAddressUse.WP);
		tel.setValue("http://" + url);
		getMdhtOrganization().getTelecoms().add(tel);
	}

	/**
	 * Convert use.
	 *
	 * @param use
	 *            the use
	 * @return the entity name use
	 */
	public EntityNameUse convertUse(NameUse use) {
		EntityNameUse useCode = EntityNameUse.L;
		if (use != null) {
			switch (use) {
			case ASSIGNED:
				useCode = EntityNameUse.ASGN;
				break;
			case LEGAL:
				useCode = EntityNameUse.L;
				break;
			case PSEUDONYM:
				useCode = EntityNameUse.P;
				break;
			}
		}
		return useCode;
	}

	/**
	 * <div class="en">Copy mdht organization.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.Organization
	 */
	public org.openhealthtools.mdht.uml.cda.Organization copyMdhtOrganization() {
		return EcoreUtil.copy(mOrganization);
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<Address>();
		for (final AD mAddress : mOrganization.getAddrs()) {
			final Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	/**
	 * Gibt die (erste) ID der Organisation zurück (wenn z.B. eine GLN vorhanden
	 * ist)
	 *
	 * @return ID der Organisation
	 */
	public Identificator getId() {
		if (getMdhtOrganization().getIds().size() > 0) {
			return new Identificator(getMdhtOrganization().getIds().get(0));
		}
		return null;
	}

	/**
	 * <div class="en">Gets the mdht organization.</div> <div class="de">Liefert
	 * mdht organization.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.Organization <div class="en">the
	 *         mdht organization</div>
	 */
	public org.openhealthtools.mdht.uml.cda.Organization getMdhtOrganization() {
		return mOrganization;
	}

	/**
	 * Gibt den (ersten) Namen der Organisation zurück.
	 *
	 * @return Namen der Organisation
	 */
	public String getName() {
		if (!getMdhtOrganization().getNames().isEmpty()) {
			return getMdhtOrganization().getNames().get(0).getText();
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
		final Telecoms telecoms = new Telecoms(mOrganization.getTelecoms());
		return telecoms;
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
		mOrganization.getTelecoms().addAll(EcoreUtil.copyAll(telecoms.getMdhtTelecoms()));
	}

}
