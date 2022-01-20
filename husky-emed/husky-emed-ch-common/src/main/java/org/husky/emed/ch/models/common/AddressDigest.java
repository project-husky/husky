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

import java.util.Objects;

/**
 * A digest of address.
 *
 * @author Quentin Ligier
 **/
public class AddressDigest {

    /**
     * The street name.
     */
    @Nullable
    private String streetName;

    /**
     * The house number.
     */
    @Nullable
    private String houseNumber;

    /**
     * The city.
     */
    @Nullable
    private String city;

    /**
     * The postal code.
     */
    @Nullable
    private String postalCode;

    /**
     * The country.
     */
    @Nullable
    private String country;

    public AddressDigest() {
    }

    public AddressDigest(@Nullable final String streetName,
                         @Nullable final String houseNumber,
                         @Nullable final String city,
                         @Nullable final String postalCode,
                         @Nullable final String country) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Nullable
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(@Nullable final String streetName) {
        this.streetName = streetName;
    }

    @Nullable
    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(@Nullable final String houseNumber) {
        this.houseNumber = houseNumber;
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

    public boolean isEmpty() {
        return this.streetName != null
                || this.houseNumber != null
                || this.city != null
                || this.postalCode != null
                || this.country != null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final AddressDigest that)) return false;
        return Objects.equals(streetName, that.streetName)
                && Objects.equals(houseNumber, that.houseNumber)
                && Objects.equals(city, that.city)
                && Objects.equals(postalCode, that.postalCode)
                && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, houseNumber, city, postalCode, country);
    }

    @Override
    public String toString() {
        return "AddressDigest{" +
                "streetName='" + this.streetName + '\'' +
                ", houseNumber='" + this.houseNumber + '\'' +
                ", city='" + this.city + '\'' +
                ", postalCode='" + this.postalCode + '\'' +
                ", country='" + this.country + '\'' +
                '}';
    }
}
