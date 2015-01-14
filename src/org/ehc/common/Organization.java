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
		this.addName(name);
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
	 * @param name
	 *            Name
	 */
	public void addName(String name) {
		ON orgaName = DatatypesFactory.eINSTANCE.createON();
		getOrganization().getNames().add(orgaName);
		orgaName.addText(name);
	}

	/**
	 * Weist der Organisation eine Postadresse zu (Geschäftsadresse)
	 * 
	 * @param address
	 *            Adresse
	 */
	public void addAddress(Address address) {
		getOrganization().getAddrs().add(address);
	}

	/**
	 * Weist der Organisation eine eMail Adresse zu
	 * 
	 * @param eMail
	 *            eMail Adresse
	 */
	public void addEMail(String eMail) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(TelecommunicationAddressUse.WP);
		tel.setValue("mailto:" + eMail);
		getOrganization().getTelecoms().add(tel);
	}

	/**
	 * Weist der Organisation eine Faxnummer zu
	 * 
	 * @param faxNr
	 *            Faxnummer (nur internationale Rufnummer ohne Sonderzeichen
	 *            erlaubt). Beispiel: +41322345566
	 */
	public void addFax(String faxNr) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(TelecommunicationAddressUse.WP);
		tel.setValue("fax:" + faxNr);
		getOrganization().getTelecoms().add(tel);
	}

	/**
	 * Weist der Organisation eine Telefonnummer zu
	 * 
	 * @param phoneNr
	 *            Telefonnummer (nur internationale Rufnummer ohne Sonderzeichen
	 *            erlaubt). Beispiel: +41322345566
	 */
	public void addPhone(String phoneNr) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(TelecommunicationAddressUse.WP);
		tel.setValue("tel:" + phoneNr);
		getOrganization().getTelecoms().add(tel);
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
		getOrganization().getTelecoms().add(tel);
	}

	/**
	 * Gibt den Namen der Organisation zurück
	 * 
	 * @return Namen der Organisation
	 */
	public String getName() {
		return getOrganization().getNames().get(0).getText();
	}
	
	 /**
     * Gibt die ID der Organisation zurück (wenn z.B. eine GLN vorhanden ist)
     * 
     * @return ID der Organisation
     */
    public String getId() {
        return getOrganization().getIds().get(0).getExtension();
    }

	public List<TEL> getTelecoms() {
		return getOrganization().getTelecoms();
	}

	public org.openhealthtools.mdht.uml.cda.Organization getOrganization() {
		return mOrganization;
	}

	public void setOrganization(org.openhealthtools.mdht.uml.cda.Organization mOrganization) {
		this.mOrganization = mOrganization;
	}
}
