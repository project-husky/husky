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
 * Year of publication: 2014
 *
 *******************************************************************************/

package org.ehc.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.AllergyProblem;
import org.ehc.cda.ch.enums.CodeSystems;
import org.ehc.common.ConvenienceUtilsEnums.KnownOID;
import org.ehc.common.ConvenienceUtilsEnums.UseCode;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.mdht.uml.cda.AssignedAuthor;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;


/**
 * Ein Autor (meist ein Arzt)
 */
public class Author {
	org.openhealthtools.mdht.uml.cda.Author mAuthor;

	/**
	 * Erstellt ein eHealthconnector-Author Objekt mittels eines MDHT-Author
	 * Objekts
	 * 
	 * @param authorMdht
	 */
	public Author(org.openhealthtools.mdht.uml.cda.Author authorMdht) {
		mAuthor = authorMdht;
	}

	/**
	 * @param iAuthor
	 */
	public Author(AuthorType iAuthor) {
		//TODO Create Constructor for IHEProfiles Author object
		// System.out.println(iAuthor.getAuthorPerson().getFamilyName());
	}

	//TODO Hier wäre es evtl. sinnvoller für einen Arzt eine eigene Klasse zu erstellen, in der die GLN Verpflichtend anzugeben ist. Beim Aufruf des VACD-Konstruktors wird dann eben diese Klasse dem Dokument hinzugefügt (daraus kann dann auch gleich die ID für den Custodian generiert werden).

	/**
	 * Erstellt einen neuen Autor (Dieser Konstruktor wird oft gebraucht für
	 * Behandelnde)
	 * 
	 * @param name
	 *            Name
	 * @param gln
	 *            Global Location Number (GLN)
	 */
	public Author(Name name, String gln) {
		// Create and fill Person Name and GLN
		II id = DatatypesFactory.eINSTANCE.createII();
		id.setRoot(ConvenienceUtilsEnums.knownOID(KnownOID.GLN));
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
		this.addName(name);
	}

	/**
	 * Weist dem Autor eine Postadresse zu
	 * 
	 * @param address
	 *            Die Postadresse des Autors
	 */
	public void addAddress(Address address) {
		mAuthor.getAssignedAuthor().getAddrs().add(address.copyMdhtAdress());
	}

	/**
	 * Weist dem Autor eine eMail Adresse zu
	 * 
	 * @param eMail
	 *            eMail Adresse
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 */
	private void addEMail(String eMail, UseCode usage) {
		//TODO Implement this
	}

	/**
	 * Weist dem Autoren eine ID zu
	 * 
	 * @param identificator
	 *            Kombination von eigentlicher ID und der OID der verwaltenden
	 *            Domäne
	 */
	public void addId(Identificator identificator) {
		mAuthor.getAssignedAuthor().getIds().add(identificator.getIi());
	}
	
	public ArrayList<Identificator> getIds() {
		ArrayList<Identificator> il = new ArrayList<Identificator>();
		for (II mId: mAuthor.getAssignedAuthor().getIds()) {
			Identificator id = new Identificator(mId);
			il.add(id);
		}
		return il;
	}

	public void addName(Name name) {
		mAuthor.getAssignedAuthor().getAssignedPerson().getNames()
		.add(name.getPn());
	}

	/**
	 * Weist dem Autor eine Telefon- oder Faxnummer zu
	 * 
	 * @param phoneNr
	 *            Telefon- oder Faxnummer (nur internationale Rufnummer ohne Sonderzeichen
	 *            erlaubt). Beispiel: +41322345566
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft, Mobil)
	 */
	public void addTelecom(String phoneNr, TelecommunicationAddressUse usage) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL(phoneNr);
		tel.getUses().add(usage);
		this.mAuthor.getAssignedAuthor().getTelecoms().add(tel);
	}
	
	public HashMap<String, TelecommunicationAddressUse> getTelecoms() {
		HashMap<String, TelecommunicationAddressUse> pm = new HashMap<String, TelecommunicationAddressUse>();
		for (TEL mName: mAuthor.getAssignedAuthor().getTelecoms()) {
			pm.put(mName.getValue(), mName.getUses().get(0));
		}
		return pm;
	}
	
	/**
	 * Weist dem Autor ein Fachgebiet zu (wird vor allem für Ärzte gebraucht)
	 * 
	 * @param speciality
	 *            Fachgebiet (z.B. Facharzt für Allgemeine Medizin)
	 */
	private void addSpeciality(String speciality) {
		// Auto-generated method stub
		// This is not a CDA-Element, but is important for the transmission of a
		// document with XDS!
		//TODO Implement this (there seems to be no way to do it directly with the MDHT API).
	}

	/**
	 * Weist dem Autor eine Webseite zu
	 * 
	 * @param eMail
	 *            Webseite
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 */
	public void addWebsite(String eMail, UseCode usage) {
		//TODO Implement this!
	}

	private CE createFunctionCode() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCode("221");
		ce.setCodeSystem("2.16.840.1.113883.2.9.6.2.7");
		ce.setCodeSystemName("ISCO-08");
		ce.setDisplayName("Medical doctors");
		return ce;
	}

	public org.openhealthtools.mdht.uml.cda.Author getAuthorMdht() {
		return EcoreUtil.copy(mAuthor);
	}

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
	
	public Name getName() {
		Name name = new Name (this.mAuthor.getAssignedAuthor().getAssignedPerson().getNames().get(0));
		return name;
	}
	
	public ArrayList<Name> getNames() {
		ArrayList<Name> nl = new ArrayList<Name>();
		for (PN mName: mAuthor.getAssignedAuthor().getAssignedPerson().getNames()) {
			Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}

	public String getGln() {
		// TODO Alle Ids durchsehen und die richtige (anhand der root-id)
		// zurückliefern.
		return mAuthor.getAssignedAuthor().getIds().get(0).getExtension();
	}
	
	public Identificator getGlnAdIdentificator() {
		II ii =  mAuthor.getAssignedAuthor().getIds().get(0);
		Identificator id = new Identificator(ii);
		return id;
	}
	
	public Address getAddress() {
		Address address = new Address(mAuthor.getAssignedAuthor().getAddrs().get(0));
		return address;
	}
	
	public ArrayList<Address> getAddresses() {
		ArrayList<Address> al = new ArrayList<Address>();
		for (AD mAddress: mAuthor.getAssignedAuthor().getAddrs()) {
			Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	public void setGln(String gln) {
		addId(new Identificator(CodeSystems.GLN.getCodeSystemId(), gln));
	}
}
