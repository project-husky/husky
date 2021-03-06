/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import javax.xml.bind.annotation.XmlTransient;

/**
 * cdach_other_AddressInformationCompilation-eCH-0010
 * <p>
 * Template description: Address information according to the eCH-0010 V7.0 addressInformation data type. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.See https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0010&amp;documentVersion=7.0 for more information.<br>
 * Element description: Two-digit, alphanumeric ISO country code according to [ISO 3166-1] of the country in which the address is located. The country defines the conventions for addressing.The country code MUST also be declared for Swiss postal addresses.Caution: Political changes or renaming of countries will result in adjustments to the ISO country list.The length of the feature is 2 characters.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.35<br>
 * Effective date: 2022-02-24 10:06:00<br>
 * Version: 2022<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class CdachOtherAddressInformationCompilationECh0010 {

    public CdachOtherAddressInformationCompilationECh0010() {
    }

    /**
     * Number of addressed apartment. This is occasionally necessary for larger buildings. With a maximum length of 30 characters.
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP additionalLocator;

    /**
     * Addressed city (in foreign addresses if necessary including province, etc.).When using the information according to the Swiss Post, the 27-digit city name must be used.
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP city;

    /**
     * Two-digit, alphanumeric ISO country code according to [ISO 3166-1] of the country in which the address is located. The country defines the conventions for addressing.The country code MUST also be declared for Swiss postal addresses.Caution: Political changes or renaming of countries will result in adjustments to the ISO country list.The length of the feature is 2 characters.
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP country;

    /**
     * House number in postal addresses (including house number additives). With a maximum length of 30 characters.
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP houseNumber;

    /**
     * Number of the addressed post box in a maximum length of 8 characters.
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP postBox;

    /**
     * Postal code given by Swiss Post or postal code issued by a post office abroad, that can consist of numbers, letters or a combination of both, possibly even special characters.
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP postalCode;

    /**
     * Occasionally, additional geographic information must be provided in foreign addresses, in addition to city and country. This element can be used for such cases.It contains superordinate or subordinate information on a city, such as region, province, state or local district.Since it is difficult - especially with foreign addresses - to determine whether an indication is subordinate or subordinate, a separate mapping of superordinate and subordinate indication is omitted.
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP state;

    /**
     * Free additional lines for additional address information which can not be used in the other address fields (e.g. for c/o entries, etc.), with a maximum length of 150 characters.<br clear="none"/>addressLine1 should be used for personalized addressing (e.g., c/o-Address).<br clear="none"/>addressLine2 should be used for non-personalized address details (e.g., additional location information, e.g. "Chalet Edelweiss").<br clear="none"/>
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP streetAddressLine;

    /**
     * Street names in postal addresses. It can also be the name of a locality, a hamlet, etc. With a maximum length of 150 characters.
     */
    @XmlTransient()
    private org.husky.common.hl7cdar2.ADXP streetName;

    /**
     * Adds a hl7StreetAddressLine<br/>
     * Free additional lines for additional address information which can not be used in the other address fields (e.g. for c/o entries, etc.), with a maximum length of 150 characters.<br/>addressLine1 should be used for personalized addressing (e.g., c/o-Address).<br/>addressLine2 should be used for non-personalized address details (e.g., additional location information, e.g. "Chalet Edelweiss").<br/>
     */
    public void addHl7StreetAddressLine(org.husky.common.hl7cdar2.ADXP value) {
        streetAddressLine = value;
    }

    /**
     * Gets the hl7AdditionalLocator<br/>
     * Number of addressed apartment. This is occasionally necessary for larger buildings. With a maximum length of 30 characters.
     */
    public org.husky.common.hl7cdar2.ADXP getHl7AdditionalLocator() {
        return additionalLocator;
    }

    /**
     * Gets the hl7City<br/>
     * Addressed city (in foreign addresses if necessary including province, etc.).When using the information according to the Swiss Post, the 27-digit city name must be used.
     */
    public org.husky.common.hl7cdar2.ADXP getHl7City() {
        return city;
    }

    /**
     * Gets the hl7Country<br/>
     * Two-digit, alphanumeric ISO country code according to [ISO 3166-1] of the country in which the address is located. The country defines the conventions for addressing.The country code MUST also be declared for Swiss postal addresses.Caution: Political changes or renaming of countries will result in adjustments to the ISO country list.The length of the feature is 2 characters.
     */
    public org.husky.common.hl7cdar2.ADXP getHl7Country() {
        return country;
    }

    /**
     * Gets the hl7HouseNumber<br/>
     * House number in postal addresses (including house number additives). With a maximum length of 30 characters.
     */
    public org.husky.common.hl7cdar2.ADXP getHl7HouseNumber() {
        return houseNumber;
    }

    /**
     * Gets the hl7PostBox<br/>
     * Number of the addressed post box in a maximum length of 8 characters.
     */
    public org.husky.common.hl7cdar2.ADXP getHl7PostBox() {
        return postBox;
    }

    /**
     * Gets the hl7PostalCode<br/>
     * Postal code given by Swiss Post or postal code issued by a post office abroad, that can consist of numbers, letters or a combination of both, possibly even special characters.
     */
    public org.husky.common.hl7cdar2.ADXP getHl7PostalCode() {
        return postalCode;
    }

    /**
     * Gets the hl7State<br/>
     * Occasionally, additional geographic information must be provided in foreign addresses, in addition to city and country. This element can be used for such cases.It contains superordinate or subordinate information on a city, such as region, province, state or local district.Since it is difficult - especially with foreign addresses - to determine whether an indication is subordinate or subordinate, a separate mapping of superordinate and subordinate indication is omitted.
     */
    public org.husky.common.hl7cdar2.ADXP getHl7State() {
        return state;
    }

    /**
     * Gets the hl7StreetName<br/>
     * Street names in postal addresses. It can also be the name of a locality, a hamlet, etc. With a maximum length of 150 characters.
     */
    public org.husky.common.hl7cdar2.ADXP getHl7StreetName() {
        return streetName;
    }

    /**
     * Sets the hl7AdditionalLocator<br/>
     * Number of addressed apartment. This is occasionally necessary for larger buildings. With a maximum length of 30 characters.
     */
    public void setHl7AdditionalLocator(org.husky.common.hl7cdar2.ADXP value) {
        this.additionalLocator = value;
    }

    /**
     * Sets the hl7City<br/>
     * Addressed city (in foreign addresses if necessary including province, etc.).When using the information according to the Swiss Post, the 27-digit city name must be used.
     */
    public void setHl7City(org.husky.common.hl7cdar2.ADXP value) {
        this.city = value;
    }

    /**
     * Sets the hl7Country<br/>
     * Two-digit, alphanumeric ISO country code according to [ISO 3166-1] of the country in which the address is located. The country defines the conventions for addressing.The country code MUST also be declared for Swiss postal addresses.Caution: Political changes or renaming of countries will result in adjustments to the ISO country list.The length of the feature is 2 characters.
     */
    public void setHl7Country(org.husky.common.hl7cdar2.ADXP value) {
        this.country = value;
    }

    /**
     * Sets the hl7HouseNumber<br/>
     * House number in postal addresses (including house number additives). With a maximum length of 30 characters.
     */
    public void setHl7HouseNumber(org.husky.common.hl7cdar2.ADXP value) {
        this.houseNumber = value;
    }

    /**
     * Sets the hl7PostBox<br/>
     * Number of the addressed post box in a maximum length of 8 characters.
     */
    public void setHl7PostBox(org.husky.common.hl7cdar2.ADXP value) {
        this.postBox = value;
    }

    /**
     * Sets the hl7PostalCode<br/>
     * Postal code given by Swiss Post or postal code issued by a post office abroad, that can consist of numbers, letters or a combination of both, possibly even special characters.
     */
    public void setHl7PostalCode(org.husky.common.hl7cdar2.ADXP value) {
        this.postalCode = value;
    }

    /**
     * Sets the hl7State<br/>
     * Occasionally, additional geographic information must be provided in foreign addresses, in addition to city and country. This element can be used for such cases.It contains superordinate or subordinate information on a city, such as region, province, state or local district.Since it is difficult - especially with foreign addresses - to determine whether an indication is subordinate or subordinate, a separate mapping of superordinate and subordinate indication is omitted.
     */
    public void setHl7State(org.husky.common.hl7cdar2.ADXP value) {
        this.state = value;
    }

    /**
     * Sets the hl7StreetName<br/>
     * Street names in postal addresses. It can also be the name of a locality, a hamlet, etc. With a maximum length of 150 characters.
     */
    public void setHl7StreetName(org.husky.common.hl7cdar2.ADXP value) {
        this.streetName = value;
    }
}
