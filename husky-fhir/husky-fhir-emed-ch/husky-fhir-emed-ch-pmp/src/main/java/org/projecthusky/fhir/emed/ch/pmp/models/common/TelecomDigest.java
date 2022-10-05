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
package org.projecthusky.fhir.emed.ch.pmp.models.common;

import org.checkerframework.checker.nullness.qual.NonNull;

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
    private final List<@NonNull String> mails = new ArrayList<>(0);

    /**
     * The phone numbers.
     */
    private final List<@NonNull String> phones = new ArrayList<>(0);

    /**
     * The fax numbers.
     */
    private final List<@NonNull String> faxes = new ArrayList<>(0);

    /**
     * The website addresses.
     */
    private final List<@NonNull String> websites = new ArrayList<>(0);

    /**
     * Other telecoms. The URL specifies the protocol.
     */
    private final List<@NonNull String> others = new ArrayList<>(0);

    /**
     * Full constructor.
     *
     * @param mails    The email addresses.
     * @param phones   The phone numbers.
     * @param faxes    The fax numbers.
     * @param websites The website addresses.
     * @param others   Other telecoms.
     */
    public TelecomDigest(final List<@NonNull String> mails,
                         final List<@NonNull String> phones,
                         final List<@NonNull String> faxes,
                         final List<@NonNull String> websites,
                         final List<@NonNull String> others) {
        this.mails.addAll(Objects.requireNonNull(mails));
        this.phones.addAll(Objects.requireNonNull(phones));
        this.faxes.addAll(Objects.requireNonNull(faxes));
        this.websites.addAll(Objects.requireNonNull(websites));
        this.others.addAll(Objects.requireNonNull(others));
    }

    public List<@NonNull String> getMails() {
        return mails;
    }

    public List<@NonNull String> getPhones() {
        return phones;
    }

    public List<@NonNull String> getFaxes() {
        return faxes;
    }

    public List<@NonNull String> getWebsites() {
        return websites;
    }

    public List<@NonNull String> getOthers() {
        return others;
    }

    public int size() {
        return mails.size() + phones.size() + faxes.size() + websites.size() + others.size();
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
