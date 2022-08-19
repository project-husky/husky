/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.models.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.hl7cdar2.II;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the recipient of an eMed document.
 */
public class RecipientDigest {

    /**
     * Whether the recipient is a primary ({@code true}) or secondary ({@code false}) one.
     */
    private boolean isPrimary;

    /**
     * The list of the recipient
     */
    private final List<@NonNull II> ids = new ArrayList<>(0);

    /**
     * The recipient addresses. It may be empty.
     */
    private final List<@NonNull AddressDigest> addresses = new ArrayList<>(0);

    /**
     * The recipient telecoms or {@code null}.
     */
    @Nullable
    private TelecomDigest telecom;

    /**
     * The addressee organization or {@code null}.
     */
    @Nullable
    private OrganizationDigest organization;

    public RecipientDigest(final boolean isPrimary,
                           final List<@NonNull II> ids,
                           @Nullable final List<@NonNull AddressDigest> addresses,
                           @Nullable final TelecomDigest telecom,
                           @Nullable final OrganizationDigest organization) {
        this.isPrimary = isPrimary;
        this.ids.addAll(ids);
        if (addresses != null) {
            this.addresses.addAll(addresses);
        }
        this.telecom = telecom;
        this.organization = organization;
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public void setPrimary(final boolean primary) {
        isPrimary = primary;
    }

    public List<II> getIds() {
        return this.ids;
    }

    public List<@NonNull AddressDigest> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(final List<@NonNull AddressDigest> addresses) {
        this.addresses.clear();
        this.addresses.addAll(addresses);
    }

    @Nullable
    public TelecomDigest getTelecom() {
        return this.telecom;
    }

    public void setTelecom(@Nullable final TelecomDigest telecom) {
        this.telecom = telecom;
    }

    @Nullable
    public OrganizationDigest getOrganization() {
        return this.organization;
    }

    public void setOrganization(@Nullable final OrganizationDigest organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final RecipientDigest that)) return false;
        return isPrimary == that.isPrimary
                && Objects.equals(ids, that.ids)
                && Objects.equals(addresses, that.addresses)
                && Objects.equals(telecom, that.telecom)
                && Objects.equals(organization, that.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPrimary, ids, addresses, telecom, organization);
    }

    @Override
    public String toString() {
        return "RecipientDigest{" +
                "isPrimary=" + this.isPrimary +
                ", ids=" + this.ids +
                ", addresses=" + this.addresses +
                ", telecom=" + this.telecom +
                ", organization=" + this.organization +
                '}';
    }
}
