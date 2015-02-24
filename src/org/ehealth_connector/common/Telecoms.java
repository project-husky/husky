package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.AddressUse;
import org.ehealth_connector.common.ConvenienceUtilsEnums.UseCode;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

public class Telecoms {
	ArrayList<TEL> mTels;

	public Telecoms() {
		mTels = new ArrayList<TEL>();
	}

	public Telecoms(EList<TEL> telecoms) {
		for (TEL tel: telecoms) {
			mTels.add(tel);
		}
	}

	/**
	 * Weist dem Autor eine eMail Adresse zu
	 * 
	 * @param eMail
	 *            eMail Adresse
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 */
	public void addEMail(String eMail, AddressUse usage) {
		mTels.add(Util.createEMail(eMail, usage));
	}

	/**
	 * Weist dem Autor eine Fax Adresse zu
	 * 
	 * @param eMail
	 *            eMail Adresse
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 */
	public void addFax(String fax, AddressUse usage) {
		mTels.add(Util.createFax(fax, usage));
	}

	/**
	 * Weist dem Autor eine Telefonnummer zu
	 * 
	 * @param phoneNr
	 *            Telefonnummer (nur internationale Rufnummer ohne Sonderzeichen
	 *            erlaubt). Beispiel: +41322345566
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft, Mobil)
	 */
	public void addPhone(String phoneNr, AddressUse usage) {
		mTels.add(Util.createTel(phoneNr, usage));
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

	public EList<TEL> copyMdhtTelecoms() {
		return (EList<TEL>) EcoreUtil.copyAll(mTels);
	}

	public ArrayList<String> getEMails() {
		return Util.getEMail(mTels);
	}

	public ArrayList<String> getFaxes() {
		return Util.getFax(mTels);
	}

	public ArrayList<TEL> getMdhtTelecoms() {
		return mTels;
	}

	public ArrayList<String> getPhones() {
		return Util.getPhone(mTels);
	}

	public HashMap<String, TelecommunicationAddressUse> getTelecoms() {
		HashMap<String, TelecommunicationAddressUse> pm = new HashMap<String, TelecommunicationAddressUse>();
		for (TEL mName: mTels) {
			pm.put(mName.getValue(), mName.getUses().get(0));
		}
		return pm;
	}
}
