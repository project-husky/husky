/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;
import javax.xml.bind.annotation.XmlTransient;

/**
 * atcdabbr_other_AddressCompilation
 * 
 * Identifier: 1.2.40.0.34.6.0.11.9.25<br>
 * Effective date: 2021-02-19 13:05:47<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherAddressCompilation {

    public AtcdabbrOtherAddressCompilation() {
    }

    /**
     * No description available in the ART-DECOR model for this field.
     */
    @XmlTransient()
    private org.projecthusky.common.hl7cdar2.ADXP additionalLocator;

    /**
     * No description available in the ART-DECOR model for this field.
     */
    @XmlTransient()
    private org.projecthusky.common.hl7cdar2.ADXP city;

    /**
     * No description available in the ART-DECOR model for this field.
     */
    @XmlTransient()
    private org.projecthusky.common.hl7cdar2.ADXP country;

    /**
     * No description available in the ART-DECOR model for this field.
     */
    @XmlTransient()
    private org.projecthusky.common.hl7cdar2.ADXP houseNumber;

    /**
     * No description available in the ART-DECOR model for this field.
     */
    @XmlTransient()
    private org.projecthusky.common.hl7cdar2.ADXP postalCode;

    /**
     * No description available in the ART-DECOR model for this field.
     */
    @XmlTransient()
    private org.projecthusky.common.hl7cdar2.ADXP state;

    /**
     * No description available in the ART-DECOR model for this field.
     */
    @XmlTransient()
    private org.projecthusky.common.hl7cdar2.ADXP streetAddressLine;

    /**
     * No description available in the ART-DECOR model for this field.
     */
    @XmlTransient()
    private org.projecthusky.common.hl7cdar2.ADXP streetName;

    /**
     * Gets the hl7AdditionalLocator
     */
    public org.projecthusky.common.hl7cdar2.ADXP getHl7AdditionalLocator() {
        return additionalLocator;
    }

    /**
     * Gets the hl7City
     */
    public org.projecthusky.common.hl7cdar2.ADXP getHl7City() {
        return city;
    }

    /**
     * Gets the hl7Country
     */
    public org.projecthusky.common.hl7cdar2.ADXP getHl7Country() {
        return country;
    }

    /**
     * Gets the hl7HouseNumber
     */
    public org.projecthusky.common.hl7cdar2.ADXP getHl7HouseNumber() {
        return houseNumber;
    }

    /**
     * Gets the hl7PostalCode
     */
    public org.projecthusky.common.hl7cdar2.ADXP getHl7PostalCode() {
        return postalCode;
    }

    /**
     * Gets the hl7State
     */
    public org.projecthusky.common.hl7cdar2.ADXP getHl7State() {
        return state;
    }

    /**
     * Gets the hl7StreetAddressLine
     */
    public org.projecthusky.common.hl7cdar2.ADXP getHl7StreetAddressLine() {
        return streetAddressLine;
    }

    /**
     * Gets the hl7StreetName
     */
    public org.projecthusky.common.hl7cdar2.ADXP getHl7StreetName() {
        return streetName;
    }

    /**
     * Sets the hl7AdditionalLocator
     */
    public void setHl7AdditionalLocator(org.projecthusky.common.hl7cdar2.ADXP value) {
        this.additionalLocator = value;
    }

    /**
     * Sets the hl7City
     */
    public void setHl7City(org.projecthusky.common.hl7cdar2.ADXP value) {
        this.city = value;
    }

    /**
     * Sets the hl7Country
     */
    public void setHl7Country(org.projecthusky.common.hl7cdar2.ADXP value) {
        this.country = value;
    }

    /**
     * Sets the hl7HouseNumber
     */
    public void setHl7HouseNumber(org.projecthusky.common.hl7cdar2.ADXP value) {
        this.houseNumber = value;
    }

    /**
     * Sets the hl7PostalCode
     */
    public void setHl7PostalCode(org.projecthusky.common.hl7cdar2.ADXP value) {
        this.postalCode = value;
    }

    /**
     * Sets the hl7State
     */
    public void setHl7State(org.projecthusky.common.hl7cdar2.ADXP value) {
        this.state = value;
    }

    /**
     * Sets the hl7StreetAddressLine
     */
    public void setHl7StreetAddressLine(org.projecthusky.common.hl7cdar2.ADXP value) {
        this.streetAddressLine = value;
    }

    /**
     * Sets the hl7StreetName
     */
    public void setHl7StreetName(org.projecthusky.common.hl7cdar2.ADXP value) {
        this.streetName = value;
    }
}
