/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

package org.ehealth_connector.common.mdht;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.TelecomAddressUse;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

/**
 * <div class="en">Class Telecom represents a list of telecommunication
 * endpoints.</div> <div class="de">Die Klasse für Telekommunikation enthält
 * eine Liste mit Telekommunikationsendpunkten</div>
 */
public class Telecoms {

	/**
	 * The mdht tels.
	 */
	private List<TEL> mTels;

	/**
	 * <div class="en">Instantiates a new telecoms object.</div>
	 * <div class="de">Instantiiert eine neue Liste mit Telcoms</div>
	 */
	public Telecoms() {
		mTels = new ArrayList<TEL>();
	}

	/**
	 * <div class="en">Instantiates a new telecoms object.</div>
	 * <div class="de">Instantiiert eine neue Liste mit Telcoms</div>
	 *
	 * @param telecoms
	 *            <br>
	 *            <div class="en"> telecoms</div>
	 */
	public Telecoms(List<TEL> telecoms) {
		this();
		for (final TEL tel : telecoms) {
			mTels.add(EcoreUtil.copy(tel));
		}
	}

	/**
	 * <div class="en">Adds a new entry to the telecoms object. These shall have
	 * the following format: : "+41.32.234.66.77" </div><div class="de"> Weist
	 * der Telecoms Liste einen Eintrag zu. Diese MÜSSEN folgendes Format haben:
	 * "+41.32.234.66.77" </div>
	 *
	 * @param type
	 *            e.g. "tel"
	 * @param endpointIdentifier
	 *            e.g. Phone number "+41.32.234.66.77"
	 * @param usage
	 *            <div class="en">use of this endpoint</div>
	 *            <div class="de">Verwendungszweck (Privat, Geschäft, Mobil)
	 *            </div>
	 */
	public void add(String type, String endpointIdentifier, TelecomAddressUse usage) {
		TEL tel = null;
		if (type.equals(Util.TELECOMS_EMAIL_PREFIX) || (type.equals(Util.TELECOMS_EMAIL_PREFIX
				.substring(0, Util.TELECOMS_EMAIL_PREFIX.length() - 1)))) {
			tel = Util.createTel(endpointIdentifier, usage);
		}
		if (type.equals(Util.TELECOMS_FAX_PREFIX) || (type.equals(
				Util.TELECOMS_FAX_PREFIX.substring(0, Util.TELECOMS_FAX_PREFIX.length() - 1)))) {
			tel = Util.createTel(endpointIdentifier, usage);
		}
		if (type.equals(Util.TELECOMS_PHONE_PREFIX) || (type.equals(Util.TELECOMS_PHONE_PREFIX
				.substring(0, Util.TELECOMS_PHONE_PREFIX.length() - 1)))) {
			tel = Util.createTel(endpointIdentifier, usage);
		}
		if (type.equals(Util.TELECOMS_WEBSITE_PREFIX) || (type.equals(Util.TELECOMS_WEBSITE_PREFIX
				.substring(0, Util.TELECOMS_WEBSITE_PREFIX.length() - 1)))) {
			tel = Util.createTel(endpointIdentifier, usage);
		}
		if (tel == null) {
			tel = Util.createUnknownTel(endpointIdentifier, usage);
		}
		mTels.add(tel);
	}

	/**
	 * <div class="en">Add a new email adress to the telecoms list</div>
	 * <div class="de">Weist der Telecoms Liste eine eMail Adresse zu.</div>
	 *
	 * @param eMail
	 *            eMail address
	 * @param usage
	 *            <div class="en">use of this endpoint</div>
	 *            <div class="de">Verwendungszweck (Privat, Geschäft, Mobil)
	 *            </div>
	 */
	public void addEMail(String eMail, TelecomAddressUse usage) {
		mTels.add(Util.createEMail(eMail, usage));
	}

	/**
	 * <div class="en">Add a new fax number to the telecoms list. This shall
	 * have the following format: "+41.32.234.66.77"</div><div class="de">Weist
	 * der Telecoms Liste eine Fax Nummer zu. Diese MÜSSEN folgendes Format
	 * haben: "+41.32.234.66.77"</div>
	 *
	 * @param fax
	 *            <br>
	 *            <div class="de"> fax</div>
	 * @param usage
	 *            <div class="en">use of this endpoint</div>
	 *            <div class="de">Verwendungszweck (Privat, Geschäft, Mobil)
	 *            </div>
	 */
	public void addFax(String fax, TelecomAddressUse usage) {
		mTels.add(Util.createFax(fax, usage));
	}

	/**
	 * <div class="en">Adds a new fax number to the telecoms list. This shall
	 * have the following format: "+41.32.234.66.77"</div><div class="de">Weist
	 * der Telecoms Liste eine Fax Nummer zu. Diese MÜSSEN folgendes Format
	 * haben: "+41.32.234.66.77"</div>
	 *
	 * @param phoneNr
	 *            <div class="en">Phone number (only international format)</div>
	 *            <div class="de">Telefonnummer (nur internationale Rufnummer
	 *            ohne Sonderzeichen: "+41.32.234.66.77"</div>
	 * @param usage
	 *            <div class="en">use of this endpoint</div>
	 *            <div class="de">Verwendungszweck (Privat, Geschäft, Mobil)
	 *            </div>
	 */
	public void addPhone(String phoneNr, TelecomAddressUse usage) {
		mTels.add(Util.createTel(phoneNr, usage));
	}

	/**
	 * <div class="en">Add a new website to the telecoms list.</div>
	 * <div class="de">Weist der Telecoms Liste eine neue Webseite</div>
	 *
	 * @param url
	 *            <div class="en">website e.g.
	 *            "http://www.ehealth-connector.org")</div>
	 *            <div class="de">Webseite (z.B.
	 *            "http://www.ehealth-connector.org")</div>
	 * @param usage
	 *            <div class="en">use of this endpoint</div>
	 *            <div class="de">Verwendungszweck (Privat, Geschäft, Mobil)
	 *            </div>
	 */
	public void addWebsite(String url, TelecomAddressUse usage) {
		final TEL t = DatatypesFactory.eINSTANCE.createTEL();
		t.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
		t.setValue(url);
		mTels.add(t);
	}

	/**
	 * <div class="en">Copy mdht telecoms.</div>
	 *
	 * @return EList the MDHT EList containing the Telecoms
	 */
	public EList<TEL> copyMdhtTelecoms() {
		return (EList<TEL>) EcoreUtil.copyAll(mTels);
	}

	/**
	 * <div class="en">Gets the e mails.</div> <div class="de">Liefert e
	 * mails.</div>
	 *
	 * @return ArrayList <div class="en">the e mails as am ArrayList of Strings
	 *         and AddressUse</div>
	 */
	public Map<String, TelecomAddressUse> getEMails() {
		return Util.getEMail(mTels);
	}

	/**
	 * <div class="en">Gets the faxes.</div> <div class="de">Liefert alle Fax
	 * Nummern</div>
	 *
	 * @return <div class="en">the faxes</div>
	 */
	public Map<String, TelecomAddressUse> getFaxes() {
		return Util.getFax(mTels);
	}

	/**
	 * <div class="en">Gets the mdht telecoms.</div><div class="de">Liefert mdht
	 * telecoms.</div>
	 *
	 * @return ArrayList <div class="en">the mdht telecoms</div>
	 */
	public List<TEL> getMdhtTelecoms() {
		return mTels;
	}

	/**
	 * <div class="en">Gets the phone numbers</div> <div class="de">Liefert alle
	 * Telefonnummern</div>
	 *
	 * @return <div class="en">the phones</div>
	 */
	public Map<String, TelecomAddressUse> getPhones() {
		return Util.getPhones(mTels);
	}

	/**
	 * <div class="en">Gets the telecoms as HashMap</div>
	 * <div class="de">Liefert die Telecoms Liste als HashMap</div>
	 *
	 * @return <div class="en">the telecoms</div>
	 */
	public Map<String, TelecommunicationAddressUse> getTelecoms() {
		final Map<String, TelecommunicationAddressUse> pm = new HashMap<String, TelecommunicationAddressUse>();
		for (final TEL mName : mTels) {
			pm.put(mName.getValue(), mName.getUses().get(0));
		}
		return pm;
	}

	/**
	 * <div class="en">Gets the Websites</div> <div class="de">Liefert alle
	 * Webseiten</div>
	 *
	 * @return <div class="en">the websides</div>
	 */
	public Map<String, TelecomAddressUse> getWebsites() {
		return Util.getWebsites(mTels);
	}
}
