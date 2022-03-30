/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.utils.readers;

import org.husky.common.hl7cdar2.*;
import org.husky.emed.ch.models.common.AddressDigest;

import javax.xml.bind.JAXBElement;
import java.util.Objects;
import java.util.Optional;

/**
 * A reader for CDA-CH-EMED addresses.
 *
 * @author Quentin Ligier
 **/
public record AddressReader(AD address) {

    /**
     * Constructor.
     *
     * @param address The address.
     */
    public AddressReader(final AD address) {
        this.address = Objects.requireNonNull(address);
    }

    /**
     * Gets the street address, if any.
     */
    public Optional<String> getStreetAddress() {
        return this.address.getContent().stream()
                .filter(JAXBElement.class::isInstance)
                .map(JAXBElement.class::cast)
                .map(JAXBElement::getValue)
                .filter(AdxpStreetAddressLine.class::isInstance)
                .map(AdxpStreetAddressLine.class::cast)
                .map(AdxpStreetAddressLine::getMergedXmlMixed)
                .findFirst();
    }

    /**
     * Gets the additional street address, if any.
     */
    public Optional<String> getAdditionalStreetAddress() {
        final var addressLines = this.address.getContent().stream()
                .filter(JAXBElement.class::isInstance)
                .map(JAXBElement.class::cast)
                .map(JAXBElement::getValue)
                .filter(AdxpStreetAddressLine.class::isInstance)
                .map(AdxpStreetAddressLine.class::cast)
                .map(AdxpStreetAddressLine::getMergedXmlMixed)
                .toList();
        if (addressLines.size() > 1) {
            return Optional.of(addressLines.get(1));
        }
        return Optional.empty();
    }

    /**
     * Gets the street name, if any.
     */
    public Optional<String> getStreetName() {
        return this.getField(AdxpStreetName.class);
    }

    /**
     * Gets the house number, if any.
     */
    public Optional<String> getHouseNumber() {
        return this.getField(AdxpHouseNumber.class);
    }

    /**
     * Gets the state, if any.
     */
    public Optional<String> getState() {
        return this.getField(AdxpState.class);
    }

    /**
     * Gets the city, if any.
     */
    public Optional<String> getCity() {
        return this.getField(AdxpCity.class);
    }

    /**
     * Gets the postal code, if any.
     */
    public Optional<String> getPostalCode() {
        return this.getField(AdxpPostalCode.class);
    }

    /**
     * Gets the country, if any.
     */
    public Optional<String> getCountry() {
        return this.getField(AdxpCountry.class);
    }

    /**
     * Gets a field by its type.
     *
     * @param type The type.
     * @param <T> The type.
     * @return An {@link Optional} that may contain the field content.
     */
    private <T extends ADXP> Optional<String> getField(final Class<T> type) {
        return this.address.getContent().stream()
                .filter(JAXBElement.class::isInstance)
                .map(JAXBElement.class::cast)
                .map(JAXBElement::getValue)
                .filter(type::isInstance)
                .map(type::cast)
                .map(T::getMergedXmlMixed)
                .findAny();
    }

    /**
     * Creates and fills an {@link AddressDigest}.
     */
    public AddressDigest toDigest() {
        return new AddressDigest(
                this.getStreetName().orElse(null),
                this.getHouseNumber().orElse(null),
                this.getCity().orElse(null),
                this.getPostalCode().orElse(null),
                this.getCountry().orElse(null)
        );
    }
}
