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
package org.husky.emed.ch.models.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A digest of telecoms.
 *
 * @author Quentin Ligier
 **/
public class TelecomDigest {

    /**
     * The email addresses.
     */
    private final List<String> mails = new ArrayList<>();

    /**
     * The phone numbers.
     */
    private final List<String> phones = new ArrayList<>();

    /**
     * The fax numbers.
     */
    private final List<String> faxes = new ArrayList<>();

    /**
     * The website addresses.
     */
    private final List<String> websites = new ArrayList<>();

    /**
     * Other telecoms. The URL specifies the protocol.
     */
    private final List<String> others = new ArrayList<>();

    /**
     * Full constructor.
     *
     * @param mails    The email addresses.
     * @param phones   The phone numbers.
     * @param faxes    The fax numbers.
     * @param websites The website addresses.
     * @param others   Other telecoms.
     */
    public TelecomDigest(final List<String> mails,
                         final List<String> phones,
                         final List<String> faxes,
                         final List<String> websites,
                         final List<String> others) {
        this.mails.addAll(Objects.requireNonNull(mails));
        this.phones.addAll(Objects.requireNonNull(phones));
        this.faxes.addAll(Objects.requireNonNull(faxes));
        this.websites.addAll(Objects.requireNonNull(websites));
        this.others.addAll(Objects.requireNonNull(others));
    }

    public List<String> getMails() {
        return mails;
    }

    public List<String> getPhones() {
        return phones;
    }

    public List<String> getFaxes() {
        return faxes;
    }

    public List<String> getWebsites() {
        return websites;
    }

    public List<String> getOthers() {
        return others;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final TelecomDigest that)) return false;
        return Objects.equals(mails, that.mails)
                && Objects.equals(phones, that.phones)
                && Objects.equals(faxes, that.faxes)
                && Objects.equals(websites, that.websites)
                && Objects.equals(others, that.others);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mails, phones, faxes, websites, others);
    }

    @Override
    public String toString() {
        return "TelecomDigest{" +
                "mails=" + this.mails +
                ", phones=" + this.phones +
                ", faxes=" + this.faxes +
                ", websites=" + this.websites +
                ", others=" + this.others +
                '}';
    }
}
