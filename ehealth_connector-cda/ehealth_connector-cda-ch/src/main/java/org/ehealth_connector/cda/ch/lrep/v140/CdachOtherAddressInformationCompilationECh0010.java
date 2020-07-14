/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.lrep.v140;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.35 Template
 * description: Address information according to the eCH-0010 V7.0
 * addressInformation data type. CDA-CH V2 derivatives, i.e. Swiss exchange
 * formats MAY use this template by either reference or specialisation.See
 * https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0010&amp;documentVersion=7.0
 * for more information.
 *
 * Element description: Two-digit, alphanumeric ISO country code according to
 * [ISO 3166-1] of the country in which the address is located. The country
 * defines the conventions for addressing.The country code MUST also be declared
 * for Swiss postal addresses.Caution: Political changes or renaming of
 * countries will result in adjustments to the ISO country list.The length of
 * the feature is 2 characters.
 */
public class CdachOtherAddressInformationCompilationECh0010 {

	/**
	 * Number of addressed apartment. This is occasionally necessary for larger
	 * buildings. With a maximum length of 30 characters.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP additionalLocator;

	/**
	 * Addressed city (in foreign addresses if necessary including province,
	 * etc.).When using the information according to the Swiss Post, the
	 * 27-digit city name must be used.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP city;

	/**
	 * Two-digit, alphanumeric ISO country code according to [ISO 3166-1] of the
	 * country in which the address is located. The country defines the
	 * conventions for addressing.The country code MUST also be declared for
	 * Swiss postal addresses.Caution: Political changes or renaming of
	 * countries will result in adjustments to the ISO country list.The length
	 * of the feature is 2 characters.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP country;

	/**
	 * House number in postal addresses (including house number additives). With
	 * a maximum length of 30 characters.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP houseNumber;

	/**
	 * Number of the addressed post box in a maximum length of 8 characters.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP postBox;

	/**
	 * Postal code given by Swiss Post or postal code issued by a post office
	 * abroad, that can consist of numbers, letters or a combination of both,
	 * possibly even special characters.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP postalCode;

	/**
	 * Occasionally, additional geographic information must be provided in
	 * foreign addresses, in addition to city and country. This element can be
	 * used for such cases.It contains superordinate or subordinate information
	 * on a city, such as region, province, state or local district.Since it is
	 * difficult - especially with foreign addresses - to determine whether an
	 * indication is subordinate or subordinate, a separate mapping of
	 * superordinate and subordinate indication is omitted.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP state;

	/**
	 * Free additional lines for additional address information which can not be
	 * used in the other address fields (e.g. for c/o entries, etc.), with a
	 * maximum length of 150 characters.addressLine1 should be used for
	 * personalized addressing (e.g., c/o-Address).
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP streetAddressLine;

	/**
	 * Street names in postal addresses. It can also be the name of a locality,
	 * a hamlet, etc. With a maximum length of 150 characters.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.ADXP streetName;

	/**
	 * Gets the hl7AdditionalLocator Number of addressed apartment. This is
	 * occasionally necessary for larger buildings. With a maximum length of 30
	 * characters.
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7AdditionalLocator() {
		return additionalLocator;
	}

	/**
	 * Gets the hl7City Addressed city (in foreign addresses if necessary
	 * including province, etc.).When using the information according to the
	 * Swiss Post, the 27-digit city name must be used.
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7City() {
		return city;
	}

	/**
	 * Gets the hl7Country Two-digit, alphanumeric ISO country code according to
	 * [ISO 3166-1] of the country in which the address is located. The country
	 * defines the conventions for addressing.The country code MUST also be
	 * declared for Swiss postal addresses.Caution: Political changes or
	 * renaming of countries will result in adjustments to the ISO country
	 * list.The length of the feature is 2 characters.
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7Country() {
		return country;
	}

	/**
	 * Gets the hl7HouseNumber House number in postal addresses (including house
	 * number additives). With a maximum length of 30 characters.
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7HouseNumber() {
		return houseNumber;
	}

	/**
	 * Gets the hl7PostalCode Postal code given by Swiss Post or postal code
	 * issued by a post office abroad, that can consist of numbers, letters or a
	 * combination of both, possibly even special characters.
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7PostalCode() {
		return postalCode;
	}

	/**
	 * Gets the hl7PostBox Number of the addressed post box in a maximum length
	 * of 8 characters.
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7PostBox() {
		return postBox;
	}

	/**
	 * Gets the hl7State Occasionally, additional geographic information must be
	 * provided in foreign addresses, in addition to city and country. This
	 * element can be used for such cases.It contains superordinate or
	 * subordinate information on a city, such as region, province, state or
	 * local district.Since it is difficult - especially with foreign addresses
	 * - to determine whether an indication is subordinate or subordinate, a
	 * separate mapping of superordinate and subordinate indication is omitted.
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7State() {
		return state;
	}

	/**
	 * Gets the hl7StreetAddressLine Free additional lines for additional
	 * address information which can not be used in the other address fields
	 * (e.g. for c/o entries, etc.), with a maximum length of 150
	 * characters.addressLine1 should be used for personalized addressing (e.g.,
	 * c/o-Address).
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7StreetAddressLine() {
		return streetAddressLine;
	}

	/**
	 * Gets the hl7StreetName Street names in postal addresses. It can also be
	 * the name of a locality, a hamlet, etc. With a maximum length of 150
	 * characters.
	 */
	public org.ehealth_connector.common.hl7cdar2.ADXP getHl7StreetName() {
		return streetName;
	}

	/**
	 * Sets the hl7AdditionalLocator Number of addressed apartment. This is
	 * occasionally necessary for larger buildings. With a maximum length of 30
	 * characters.
	 */
	public void setHl7AdditionalLocator(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.additionalLocator = value;
	}

	/**
	 * Sets the hl7City Addressed city (in foreign addresses if necessary
	 * including province, etc.).When using the information according to the
	 * Swiss Post, the 27-digit city name must be used.
	 */
	public void setHl7City(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.city = value;
	}

	/**
	 * Sets the hl7Country Two-digit, alphanumeric ISO country code according to
	 * [ISO 3166-1] of the country in which the address is located. The country
	 * defines the conventions for addressing.The country code MUST also be
	 * declared for Swiss postal addresses.Caution: Political changes or
	 * renaming of countries will result in adjustments to the ISO country
	 * list.The length of the feature is 2 characters.
	 */
	public void setHl7Country(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.country = value;
	}

	/**
	 * Sets the hl7HouseNumber House number in postal addresses (including house
	 * number additives). With a maximum length of 30 characters.
	 */
	public void setHl7HouseNumber(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.houseNumber = value;
	}

	/**
	 * Sets the hl7PostalCode Postal code given by Swiss Post or postal code
	 * issued by a post office abroad, that can consist of numbers, letters or a
	 * combination of both, possibly even special characters.
	 */
	public void setHl7PostalCode(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.postalCode = value;
	}

	/**
	 * Sets the hl7PostBox Number of the addressed post box in a maximum length
	 * of 8 characters.
	 */
	public void setHl7PostBox(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.postBox = value;
	}

	/**
	 * Sets the hl7State Occasionally, additional geographic information must be
	 * provided in foreign addresses, in addition to city and country. This
	 * element can be used for such cases.It contains superordinate or
	 * subordinate information on a city, such as region, province, state or
	 * local district.Since it is difficult - especially with foreign addresses
	 * - to determine whether an indication is subordinate or subordinate, a
	 * separate mapping of superordinate and subordinate indication is omitted.
	 */
	public void setHl7State(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.state = value;
	}

	/**
	 * Sets the hl7StreetAddressLine Free additional lines for additional
	 * address information which can not be used in the other address fields
	 * (e.g. for c/o entries, etc.), with a maximum length of 150
	 * characters.addressLine1 should be used for personalized addressing (e.g.,
	 * c/o-Address).
	 */
	public void setHl7StreetAddressLine(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.streetAddressLine = value;
	}

	/**
	 * Sets the hl7StreetName Street names in postal addresses. It can also be
	 * the name of a locality, a hamlet, etc. With a maximum length of 150
	 * characters.
	 */
	public void setHl7StreetName(org.ehealth_connector.common.hl7cdar2.ADXP value) {
		this.streetName = value;
	}
}
