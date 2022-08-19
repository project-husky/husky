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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The digest of an organization.
 *
 * @author Quentin Ligier
 */
public class OrganizationDigest {

    /**
     * The organization identifiers.
     */
    private final List<@NonNull QualifiedIdentifier> ids = new ArrayList<>(0);

    /**
     * The organization names.
     */
    private final List<@NonNull String> names = new ArrayList<>(0);

    /**
     * The organization telecoms or {@code null}.
     */
    @Nullable
    private TelecomDigest telecoms;

    /**
     * The organization addresses.
     */
    private final List<AddressDigest> addresses = new ArrayList<>(0);

    public OrganizationDigest(final List<@NonNull QualifiedIdentifier> ids,
                              final List<@NonNull String> names,
                              @Nullable final TelecomDigest telecoms,
                              final List<AddressDigest> addresses) {
        this.ids.addAll(ids);
        this.names.addAll(names);
        this.telecoms = telecoms;
        this.addresses.addAll(addresses);
    }

    public List<@NonNull QualifiedIdentifier> getIds() {
        return ids;
    }

    public List<@NonNull String> getNames() {
        return names;
    }

    @Nullable
    public TelecomDigest getTelecoms() {
        return telecoms;
    }

    public void setTelecoms(@Nullable final TelecomDigest telecoms) {
        this.telecoms = telecoms;
    }

    public List<AddressDigest> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final OrganizationDigest that)) return false;
        return Objects.equals(ids, that.ids)
                && Objects.equals(names, that.names)
                && Objects.equals(telecoms, that.telecoms)
                && Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids, names, telecoms, addresses);
    }

    @Override
    public String toString() {
        return "OrganizationDigest{" +
                "ids=" + this.ids +
                ", names=" + this.names +
                ", telecoms=" + this.telecoms +
                ", addresses=" + this.addresses +
                '}';
    }
}
