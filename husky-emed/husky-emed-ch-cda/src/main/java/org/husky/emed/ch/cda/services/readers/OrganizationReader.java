/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.services.readers;

import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.POCDMT000040Organization;

import java.util.List;
import java.util.Objects;

/**
 * A reader for CDA-CH-EMED POCDMT000040Author.
 *
 * @author Quentin Ligier
 */
public class OrganizationReader {

    private final POCDMT000040Organization organization;

    public OrganizationReader(final POCDMT000040Organization organization) {
        this.organization = Objects.requireNonNull(organization);
    }

    /**
     * Gets the organization Ids. The list may be empty.
     */
    public List<II> getIds() {
        return this.organization.getId();
    }

    /**
     * Gets the organization names.
     */
    public List<String> getNames() {
        return this.organization.getName().stream()
                .map(ANY::getMergedXmlMixed)
                .toList();
    }

    /**
     * Gets the organization telecoms wrapped in a {@link TelecomReader}.
     */
    public TelecomReader getTelecoms() {
        return new TelecomReader(this.organization.getTelecom());
    }

    /**
     * Gets the organization addresses wrapped in an {@link AddressReader}.
     */
    public AddressReader getAddresses() {
        return new AddressReader(this.organization.getAddr());
    }
}
