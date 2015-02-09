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

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.AddressUse;
import org.ehc.common.ConvenienceUtilsEnums.KnownOID;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

/**
 * Eine Organisation (Arztpraxis, Spital, Arbeitgeber, Versicherung, ...)
 */
public class Organization {

	public org.openhealthtools.mdht.uml.cda.Organization mOrganization;

	public Organization(org.openhealthtools.mdht.uml.cda.Organization organization) {
		mOrganization = organization;
	}

	//TODO Verschiedene Konstruktoren für unterschiedliche Organisationen angeben:
	//1. Verein, Firma, Versicherung etc. (nur Name)
	//2. Spital / Arztpraxis (ID: GLN)
	/**
	 * Erstellt eine neue Organisation (Spital, Arztpraxis, Firma, Verein, etc.)
	 * 
	 * @param name
	 *            Name der Organisation
	 */
	public Organization(String name) {
		setOrganization(CDAFactory.eINSTANCE.createOrganization());
		addName(name);
	}

	/**
	 * Erstellt eine neue Organisation (Spital, Arztpraxis), die über eine eigene ID (GLN) verfügt
	 * 
	 * @param name
	 *            Name der Organisation
	 */
	public Organization(String name, String gln) {
		this(name);
		II id = DatatypesFactory.eINSTANCE.createII();
		id.setRoot(ConvenienceUtilsEnums.knownOID(KnownOID.GLN));
		id.setExtension(gln);
		mOrganization.getIds().add(id);
	}

	/**
	 * Weist der Organisation eine Postadresse zu (Geschäftsadresse)
	 * 
	 * @param address
	 *            Adresse
	 */
	public void addAddress(Address address) {
		getMdhtOrganization().getAddrs().add(address.copyMdhtAdress());
	}

	/**
	 * Weist der Organisation eine Postadresse zu (Geschäftsadresse)
	 * 
	 * @param name
	 *            Name
	 */
	public void addName(String name) {
		ON orgaName = DatatypesFactory.eINSTANCE.createON();
		getMdhtOrganization().getNames().add(orgaName);
		orgaName.addText(name);
	}

	/**
	 * Weist der Organisation eine Webseite zu
	 * 
	 * @param url
	 *            URL der Webseite
	 */
	public void addWebsite(String url) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(TelecommunicationAddressUse.WP);
		tel.setValue("http://" + url);
		getMdhtOrganization().getTelecoms().add(tel);
	}

	public org.openhealthtools.mdht.uml.cda.Organization copyMdhtOrganization() {
		return EcoreUtil.copy(mOrganization);
	}

	/**
	 * Gibt die ID der Organisation zurück (wenn z.B. eine GLN vorhanden ist)
	 * 
	 * @return ID der Organisation
	 */
	public String getId() {
		return getMdhtOrganization().getIds().get(0).getExtension();
	}

	public org.openhealthtools.mdht.uml.cda.Organization getMdhtOrganization() {
		return mOrganization;
	}

	/**
	 * Gibt den Namen der Organisation zurück
	 * 
	 * @return Namen der Organisation
	 */
	public String getName() {
		return getMdhtOrganization().getNames().get(0).getText();
	}
	
	public void setTelecoms(Telecoms telecoms) {
		mOrganization.getTelecoms().addAll(telecoms.getMdhtTelecoms());
	}
	
	public Telecoms getTelecoms() {
		Telecoms telecoms = new Telecoms(mOrganization.getTelecoms());
		return telecoms;
	}

	public void setOrganization(org.openhealthtools.mdht.uml.cda.Organization mOrganization) {
		this.mOrganization = mOrganization;
	}
}
