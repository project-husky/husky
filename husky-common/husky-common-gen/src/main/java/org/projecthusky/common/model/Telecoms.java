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

package org.projecthusky.common.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.projecthusky.common.enums.TelecomAddressUse;
import org.projecthusky.common.hl7cdar2.TEL;


/**
 * Class Telecom represents a list of telecommunication endpoints.
 */
public class Telecoms {

	/**
	 * The Constant TELECOMS_EMAIL_PREFIX.
	 */
	public static final String TELECOMS_EMAIL_PREFIX = "mailto:";

	/**
	 * The Constant TELECOMS_FAX_PREFIX.
	 */
	public static final String TELECOMS_FAX_PREFIX = "fax:";

	/**
	 * The Constant TELECOMS_PHONE_PREFIX.
	 */
	public static final String TELECOMS_PHONE_PREFIX = "tel:";

	/**
	 * The Constant TELECOMS_WEBSITE_PREFIX. Note: omitting the : here in order to
	 * support http and https
	 */
	public static final String TELECOMS_WEBSITE_PREFIX = "http";

    /**
     * The mdht tels.
     */
    private List<TEL> mTels;

    /**
     * Instantiates a new telecoms object.
     */
    public Telecoms() {
		mTels = new ArrayList<>();
    }

    /**
     * Instantiates a new telecoms object.
     *
     * @param telecoms telecoms
     */
    public Telecoms(List<TEL> telecoms) {
        this();
        for (final TEL tel : telecoms) {
            mTels.add(tel);
        }
    }

    /**
     * Adds a new entry to the telecoms object. These shall have the following format: : "+41.32.234.66.77"
     *
     * @param type               e.g. "tel"
     * @param endpointIdentifier e.g. Phone number "+41.32.234.66.77"
     * @param usage              use of this endpoint
     */
    public void add(String type, String endpointIdentifier, TelecomAddressUse usage) {
        TEL tel = null;
		if (type.equals(TELECOMS_EMAIL_PREFIX)
				|| (type.equals(TELECOMS_EMAIL_PREFIX.substring(0, TELECOMS_EMAIL_PREFIX.length() - 1)))) {
            tel = createTel(endpointIdentifier, usage);
        }
		if (type.equals(TELECOMS_FAX_PREFIX)
				|| (type.equals(TELECOMS_FAX_PREFIX.substring(0, TELECOMS_FAX_PREFIX.length() - 1)))) {
            tel = createTel(endpointIdentifier, usage);
        }
		if (type.equals(TELECOMS_PHONE_PREFIX)
				|| (type.equals(TELECOMS_PHONE_PREFIX.substring(0, TELECOMS_PHONE_PREFIX.length() - 1)))) {
            tel = createTel(endpointIdentifier, usage);
        }
		if (type.equals(TELECOMS_WEBSITE_PREFIX)
				|| (type.equals(TELECOMS_WEBSITE_PREFIX.substring(0, TELECOMS_WEBSITE_PREFIX.length() - 1)))) {
            tel = createTel(endpointIdentifier, usage);
        }

        mTels.add(tel);
    }

    public TEL createTel(String telNr, TelecomAddressUse usage) {
        final var tel = new TEL();
        if (usage != null) {
            tel.getUse().add(usage.getCodeValue());
        }
		tel.setValue(TELECOMS_PHONE_PREFIX + telNr.replaceAll("\\s+", ""));
        return tel;
    }

    /**
     * Add a new email adress to the telecoms list
     *
     * @param eMail eMail address
     * @param usage use of this endpoint
     */
    public void addEMail(String eMail, TelecomAddressUse usage) {
        mTels.add(createEMail(eMail, usage));
    }

    public TEL createEMail(String eMail, TelecomAddressUse usage) {
        final var tel = new TEL();
        if (usage != null) {
            tel.getUse().add(usage.getCodeValue());
        }
		tel.setValue(TELECOMS_EMAIL_PREFIX + eMail);
        return tel;
    }

    /**
     * Add a new fax number to the telecoms list. This shall have the following format: "+41.32.234.66.77"
     *
     * @param fax   fax
     * @param usage use of this endpoint
     */
    public void addFax(String fax, TelecomAddressUse usage) {
        mTels.add(createTel(fax, usage));
    }

    /**
     * Adds a new fax number to the telecoms list. This shall have the following format: "+41.32.234.66.77"
     *
     * @param phoneNr Phone number (only international format)
     * @param usage   use of this endpoint
     */
    public void addPhone(String phoneNr, TelecomAddressUse usage) {
        mTels.add(createTel(phoneNr, usage));
    }

    /**
     * Add a new website to the telecoms list.
     *
     * @param url   website e.g. "http://www.ehealth-connector.org")
     * @param usage use of this endpoint
     */
    public void addWebsite(String url, TelecomAddressUse usage) {
        final var t = new TEL();
        t.getUse().add(usage.getCodeValue());
        t.setValue(url);
        mTels.add(t);
    }

    /**
     * Gets the e mails.
     *
     * @return ArrayList the e mails as am ArrayList of Strings and AddressUse
     */
    public Map<String, TelecomAddressUse> getEMails() {
        return new HashMap<>();
    }

    /**
     * Gets the faxes.
     *
     * @return the faxes
     */
    public Map<String, TelecomAddressUse> getFaxes() {
        return new HashMap<>();
    }

    /**
     * Gets the telecoms.
     *
     * @return ArrayList the telecoms
     */
    public List<TEL> getMdhtTelecoms() {
        return mTels;
    }

    /**
     * Gets the phone numbers
     *
     * @return the phones
     */
    public Map<String, TelecomAddressUse> getPhones() {
        return new HashMap<>();
    }

    /**
     * Gets the telecoms as HashMap
     *
     * @return the telecoms
     */
    public Map<String, TelecomAddressUse> getTelecoms() {
        final Map<String, TelecomAddressUse> pm = new HashMap<>();
        for (final TEL mName : mTels) {
            pm.put(mName.getValue(), TelecomAddressUse.getEnum(mName.getUse().get(0)));
        }
        return pm;
    }

    /**
     * Gets the Websites
     *
     * @return the websides
     */
    public Map<String, TelecomAddressUse> getWebsites() {
        return new HashMap<>();
    }

}
