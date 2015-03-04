/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.common;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.mdht.uml.cda.AssignedAuthor;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;


/**
 * Ein Autor (meist ein Arzt).
 */
public class Author {

	/**
	 * The m author.
	 */
	org.openhealthtools.mdht.uml.cda.Author mAuthor;

	/**
	 * <div class="en">Instantiates a new author.</div>
	 * <div class="de">Instantiiert a neuen Autor</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param iAuthor <br>
	 * 		<div class="de">IHE Author-Objekt</div>
	 * 		<div class="fr"></div>
	 * 		<div class="it"></div>
	 */
	public Author(AuthorType iAuthor) {
		//TODO Create Constructor for IHEProfiles Author object
		// System.out.println(iAuthor.getAuthorPerson().getFamilyName());
	}

	/**
	 * Erstellt einen neuen Autor (Dieser Konstruktor wird oft gebraucht für
	 * Behandelnde).
	 *
	 * @param name            Name
	 * @param gln            Global Location Number (GLN)
	 */
	public Author(Name name, String gln) {
		// Create and fill Person Name and GLN
		II id = DatatypesFactory.eINSTANCE.createII();
		id.setRoot(CodeSystems.GLN.getCodeSystemId());
		id.setExtension(gln);

		mAuthor = CDAFactory.eINSTANCE.createAuthor();
		org.openhealthtools.mdht.uml.cda.Person asPers = CDAFactory.eINSTANCE
				.createPerson();

		AssignedAuthor asAuth = CDAFactory.eINSTANCE.createAssignedAuthor();
		asAuth.setAssignedPerson(asPers);
		asAuth.getIds().add(id);

		mAuthor.setAssignedAuthor(asAuth);

		// add functionCode and time
		mAuthor.setFunctionCode(createFunctionCode());
		mAuthor.setTime(DateUtil.nowAsTS());
		addName(name);
	}

	/**
	 * Erstellt ein eHealthconnector-Author Objekt mittels eines MDHT-Author
	 * Objekts.
	 *
	 * @param authorMdht the MDHT Author Object
	 */
	public Author(org.openhealthtools.mdht.uml.cda.Author authorMdht) {
		mAuthor = authorMdht;
	}

	/**
	 * Weist dem Autor eine Postadresse zu.
	 *
	 * @param address            Die Postadresse des Autors
	 */
	public void addAddress(Address address) {
		mAuthor.getAssignedAuthor().getAddrs().add(address.copyMdhtAdress());
	}

	/**
	 * Weist dem Autoren eine ID zu.
	 *
	 * @param identificator            Kombination von eigentlicher ID und der OID der verwaltenden
	 *            Domäne
	 */
	public void addId(Identificator identificator) {
		mAuthor.getAssignedAuthor().getIds().add(identificator.getIi());
	}

	/**
	 * <div class="en">Adds the name.</div>
	 * <div class="de"></div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param name name
	 */
	public void addName(Name name) {
		mAuthor.getAssignedAuthor().getAssignedPerson().getNames()
		.add(name.getMdhtPn());
	}

	/**
	 * <div class="en">Copy mdht author.</div>
	 * <div class="de"></div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.author
	 */
	public org.openhealthtools.mdht.uml.cda.Author copyMdhtAuthor() {
		return EcoreUtil.copy(mAuthor);
	}

	private CE createFunctionCode() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCode("221");
		ce.setCodeSystem("2.16.840.1.113883.2.9.6.2.7");
		ce.setCodeSystemName("ISCO-08");
		ce.setDisplayName("Medical doctors");
		return ce;
	}

	/**
	 * <div class="en">Gets the address.</div>
	 * <div class="de">Liefert die (erste) Adresse.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the address</div>
	 */
	public Address getAddress() {
		Address address = new Address(mAuthor.getAssignedAuthor().getAddrs().get(0));
		return address;
	}

	/**
	 * <div class="en">Gets the addresses.</div>
	 * <div class="de">Liefert alle Adressen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public ArrayList<Address> getAddresses() {
		ArrayList<Address> al = new ArrayList<Address>();
		for (AD mAddress: mAuthor.getAssignedAuthor().getAddrs()) {
			Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	/**
	 * <div class="en">Gets the author mdht.</div>
	 * <div class="de">Liefert author mdht.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.Author <div class="en">the author mdht</div>
	 */
	public org.openhealthtools.mdht.uml.cda.Author getAuthorMdht() {
		return EcoreUtil.copy(mAuthor);
	}

	/**
	 * <div class="en">Gets the complete name.</div>
	 * <div class="de">Liefert den ganzen Namen (z.B. "Dr. Allzeit Bereit der Dritte")</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the complete name</div>
	 */
	public String getCompleteName() {
		//Search for the author name. If it isn´t there, try to use the organisation name.
		if (mAuthor.getAssignedAuthor() != null) {
			if (mAuthor.getAssignedAuthor().getAssignedPerson() != null) {
				if (mAuthor.getAssignedAuthor().getAssignedPerson().getNames() != null) {
					Name name = new Name(mAuthor.getAssignedAuthor().getAssignedPerson()
							.getNames().get(0));
					return name.getCompleteName();
				}
				else {
					if (mAuthor.getAssignedAuthor().getRepresentedOrganization() != null) {
						if (mAuthor.getAssignedAuthor().getRepresentedOrganization().getNames() != null) {
							Name name = new Name(mAuthor.getAssignedAuthor().getRepresentedOrganization().getNames().get(0));
							return name.getCompleteName();
						}
					}
				}
			}
		}
		return "";
	}

	/**
	 * <div class="en">Gets the gln (identification of the author)</div>
	 * <div class="de">Liefert die GLN (ID des Autors)</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the gln</div>
	 */
	public String getGln() {
		Identificator gln = Identificator.getIdentificator(mAuthor.getAssignedAuthor().getIds(), CodeSystems.GLN.getCodeSystemId());
		return gln.getExtension();
	}

	/**
	 * <div class="en">Gets the gln as identificator.</div>
	 * <div class="de">Liefert gln (ID des Autoren) als Identificator Objekt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the gln as identificator</div>
	 */
	public Identificator getGlnAsIdentificator() {
		II ii =  mAuthor.getAssignedAuthor().getIds().get(0);
		Identificator id = new Identificator(ii);
		return id;
	}

	/**
	 * <div class="en">Gets all ids of the author</div>
	 * <div class="de">Liefert alle IDs des Autoren</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the ids</div>
	 */
	public ArrayList<Identificator> getIds() {
		ArrayList<Identificator> il = new ArrayList<Identificator>();
		for (II mId: mAuthor.getAssignedAuthor().getIds()) {
			Identificator id = new Identificator(mId);
			il.add(id);
		}
		return il;
	}

	/**
	 * <div class="en">Gets the (first) family name.</div>
	 * <div class="de">Liefert den (ersten) Nachnamen</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the name</div>
	 */
	public Name getName() {
		Name name = new Name (mAuthor.getAssignedAuthor().getAssignedPerson().getNames().get(0));
		return name;
	}

	/**
	 * <div class="en">Gets the names.</div>
	 * <div class="de">Liefert alle Nachnamen</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	public ArrayList<Name> getNames() {
		ArrayList<Name> nl = new ArrayList<Name>();
		for (PN mName: mAuthor.getAssignedAuthor().getAssignedPerson().getNames()) {
			Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}

	/**
	 * <div class="en">Gets the telecoms.</div>
	 * <div class="de">Liefert telecoms.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public Telecoms getTelecoms() {
		Telecoms telecoms = new Telecoms(mAuthor.getAssignedAuthor().getTelecoms());
		return telecoms;
	}

	/**
	 * <div class="en">Sets the gln.</div>
	 * <div class="de">Setzt die GLN (ID des Autoren).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *  
	 *
	 * @param gln <div class="en">the new gln</div>
	 * <div class="de">das neue gln.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 */
	public void setGln(String gln) {
		addId(new Identificator(CodeSystems.GLN.getCodeSystemId(), gln));
	}

	/**
	 * <div class="en">Sets the telecoms.</div>
	 * <div class="de">Setzt telecoms.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *  
	 * @param telecoms <div class="en">the new telecoms</div>
	 * <div class="de">das neue telecoms.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 */
	public void setTelecoms(Telecoms telecoms) {
		mAuthor.getAssignedAuthor().getTelecoms().addAll(telecoms.getMdhtTelecoms());
	}
}
