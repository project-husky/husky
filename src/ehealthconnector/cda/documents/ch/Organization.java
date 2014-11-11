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

package ehealthconnector.cda.documents.ch;

import java.util.List;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

/**
 * Eine Organisation (Arztpraxis, Spital, Arbeitgeber, Versicherung, ...)
 */
public class Organization {

	org.openhealthtools.mdht.uml.cda.Organization mOrganization;

	/**
	 * Erstellt eine neue Organisation (Spital, Arztpraxis, Firma, Verein, etc.)
	 * 
	 * @param name
	 *            Name der Organisation
	 */
	public Organization(String name) {
		mOrganization = CDAFactory.eINSTANCE.createOrganization();
		this.addName(name);
	}

	/**
	 * Weist der Organisation eine Postadresse zu (Geschäftsadresse)
	 * 
	 * @param name
	 *            Name
	 */
	public void addName(String name) {
		ON orgaName = DatatypesFactory.eINSTANCE.createON();
		mOrganization.getNames().add(orgaName);
		orgaName.addText(name);
	}

	/**
	 * Weist der Organisation eine Postadresse zu (Geschäftsadresse)
	 * 
	 * @param address
	 *            Adresse
	 */
	public void addAddress(Address address) {
		mOrganization.getAddrs().add(address);
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
		mOrganization.getTelecoms().add(tel);
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
		mOrganization.getTelecoms().add(tel);
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
		mOrganization.getTelecoms().add(tel);
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
		mOrganization.getTelecoms().add(tel);
	}

	/**
	 * Gibt den Namen der Organisation zurück
	 * 
	 * @return Namen der Organisation
	 */
	public String getName() {
		return mOrganization.getNames().get(0).getText();
	}

	public List<TEL> getTelecoms() {
		return mOrganization.getTelecoms();
	}
}
