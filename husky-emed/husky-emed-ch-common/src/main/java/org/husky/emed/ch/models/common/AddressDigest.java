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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.units.qual.N;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A digest of address.
 *
 * @author Quentin Ligier
 **/
public class AddressDigest {

    /**
     * The street address line(s).
     */
    private final List<String> streetAddressLines = new ArrayList<>(0);

    /**
     * Addressed city (in foreign addresses if necessary including province, etc.).
     * When using the information according to the Swiss Post, the 27-digit city name must be used.
     */
    @Nullable
    private String city;

    /**
     * Postal code given by Swiss Post or postal code issued by a post office abroad, that can consist of numbers,
     * letters or a combination of both, possibly even special characters.
     */
    @Nullable
    private String postalCode;

    /**
     * Two-digit, alphanumeric ISO country code according to [ISO 3166-1] of the country in which the address is
     * located. E.g. 'CH'
     */
    @Nullable
    private String country;

    /**
     * Number of addressed apartment. This is occasionally necessary for larger buildings. With a maximum length of 30
     * characters.
     */
    @Nullable
    private String additionalLocator;

    /**
     * Number of the addressed post box in a maximum length of 8 characters.
     */
    @Nullable
    private String postBox;

    /**
     * It contains superordinate or subordinate information on a city, such as region, province, state or local
     * district. In Switzerland: 'AG', 'AI', 'AR', 'BE', 'BL', 'BS', 'FL', 'FR', 'GE', 'GL', 'GR', 'JU', 'LU', 'NE',
     * 'NW', 'OW', 'SG', 'SH', 'SO', 'SZ', 'TG', 'TI', 'UR', 'VD', 'VS', 'ZG', 'ZH'
     */
    @Nullable
    private String state;

    public AddressDigest() {
    }

    public AddressDigest(@Nullable final List<String> streetAddressLines,
                         @Nullable final String city,
                         @Nullable final String postalCode,
                         @Nullable final String country,
                         @Nullable final String additionalLocator,
                         @Nullable final String postBox,
                         @Nullable final String state) {
        if (streetAddressLines != null) {
            this.streetAddressLines.addAll(streetAddressLines);
        }
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.additionalLocator = additionalLocator;
        this.postBox = postBox;
        this.state = state;
    }

    public List<String> getStreetAddressLines() {
        return streetAddressLines;
    }

    @Nullable
    public String getCity() {
        return city;
    }

    public void setCity(@Nullable final String city) {
        this.city = city;
    }

    @Nullable
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@Nullable final String postalCode) {
        this.postalCode = postalCode;
    }

    @Nullable
    public String getCountry() {
        return country;
    }

    public void setCountry(@Nullable final String country) {
        this.country = country;
    }

    @Nullable
    public String getAdditionalLocator() {
        return additionalLocator;
    }

    public void setAdditionalLocator(@Nullable final String additionalLocator) {
        this.additionalLocator = additionalLocator;
    }

    @Nullable
    public String getPostBox() {
        return postBox;
    }

    public void setPostBox(@Nullable final String postBox) {
        this.postBox = postBox;
    }

    @Nullable
    public String getState() {
        return state;
    }

    public void setState(@Nullable final String state) {
        this.state = state;
    }

    public boolean isEmpty() {
        return !this.streetAddressLines.isEmpty()
                || this.city != null
                || this.postalCode != null
                || this.country != null
                || this.additionalLocator != null
                || this.postBox != null
                || this.state != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDigest that = (AddressDigest) o;
        return streetAddressLines.equals(that.streetAddressLines) && Objects.equals(city, that.city)
                && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country)
                && Objects.equals(additionalLocator, that.additionalLocator) && Objects.equals(postBox, that.postBox)
                && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddressLines, city, postalCode, country, additionalLocator, postBox, state);
    }

    @Override
    public String toString() {
        return "AddressDigest{"
                + "streetAddressLines=" + streetAddressLines
                + ", city='" + city + '\''
                + ", postalCode='" + postalCode + '\''
                + ", country='" + country + '\''
                + ", additionalLocator='" + additionalLocator + '\''
                + ", postBox='" + postBox + '\''
                + ", state='" + state + '\''
                + '}';
    }
}
