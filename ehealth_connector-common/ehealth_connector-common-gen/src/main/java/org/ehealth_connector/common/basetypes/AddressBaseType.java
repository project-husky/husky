/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.common.basetypes;

import org.ehealth_connector.common.enums.AddressUse;

/**
 * Java Prototype for Value Set Management Concept.
 *
 * Source: ART-DECOR CDA-CH Address Information Compilation - eCH-0010
 */
public interface AddressBaseType {
	public String getAdditionalLocator();

	public String getCity();

	public String getCountry();

	public String getHouseNumber();

	public String getPostalCode();

	public String getPostBox();

	public String getState();

	public String getStreetAddressLine1();

	public String getStreetAddressLine2();

	public AddressUse getUsage();

	/**
	 * Sets the additional locator.
	 *
	 * Number of addressed apartment. This is occasionally necessary for larger
	 * buildings. With a maximum length of 30 characters. eCH-0010 V7.0
	 * addressInformation
	 *
	 * @param value
	 *            the new additional locator
	 */
	public void setAdditionalLocator(String value);

	/**
	 * Sets the city.
	 *
	 * Addressed city (in foreign addresses if necessary including province,
	 * etc.). When using the information according to the Swiss Post, the
	 * 27-digit city name must be used. eCH-0010 V7.0 addressInformation
	 *
	 *
	 *
	 * @param value
	 *            the new city
	 */
	public void setCity(String value);

	/**
	 * Sets the country.
	 *
	 * Two-digit, alphanumeric ISO country code according to [ISO 3166-1] of the
	 * country in which the address is located. The country defines the
	 * conventions for addressing. The country code MUST also be declared for
	 * Swiss postal addresses. Caution: Political changes or renaming of
	 * countries will result in adjustments to the ISO country list. The length
	 * of the feature is 2 characters. eCH-0010 V7.0 addressInformation
	 *
	 *
	 * @param value
	 *            the new country
	 */
	public void setCountry(String value);

	/**
	 * Sets the house number.
	 *
	 * House number in postal addresses (including house number additives). With
	 * a maximum length of 30 characters. eCH-0010 V7.0 addressInformation
	 *
	 * @param value
	 *            the new house number
	 */
	public void setHouseNumber(String value);

	/**
	 * Sets the postal code.
	 *
	 * Postal code given by Swiss Post or postal code issued by a post office
	 * abroad, that can consist of numbers, letters or a combination of both,
	 * possibly even special characters. eCH-0010 V7.0 addressInformation
	 *
	 *
	 * @param value
	 *            the new postal code
	 */
	public void setPostalCode(String value);

	/**
	 * Sets the post box.
	 *
	 * Number of the addressed post box in a maximum length of 8 characters.
	 * eCH-0010 V7.0 addressInformation
	 *
	 *
	 * @param value
	 *            the new post box
	 */
	public void setPostBox(String value);

	/**
	 * Sets the state.
	 *
	 * Occasionally, additional geographic information must be provided in
	 * foreign addresses, in addition to city and country. This element can be
	 * used for such cases. It contains superordinate or subordinate information
	 * on a city, such as region, province, state or local district. Since it is
	 * difficult - especially with foreign addresses - to determine whether an
	 * indication is subordinate or subordinate, a separate mapping of
	 * superordinate and subordinate indication is omitted. eCH-0010 V7.0
	 * addressInformation
	 *
	 *
	 * @param value
	 *            the new state
	 */
	public void setState(String value);

	/**
	 * Sets the street address line 1.
	 *
	 * Free additional lines for additional address information which can not be
	 * used in the other address fields (e.g. for c/o entries, etc.), with a
	 * maximum length of 150 characters. addressLine1 should be used for
	 * personalized addressing (e.g., c/o-Address). eCH-0010 V7.0
	 * addressInformation
	 *
	 * @param value
	 *            the new street address line 1
	 */
	public void setStreetAddressLine1(String value);

	/**
	 * Sets the street address line 2.
	 *
	 * Free additional lines for additional address information which can not be
	 * used in the other address fields (e.g. for c/o entries, etc.), with a
	 * maximum length of 150 characters. addressLine2 should be used for
	 * non-personalized address details (e.g., additional location information,
	 * e.g. "Chalet Edelweiss"). eCH-0010 V7.0 addressInformation
	 *
	 * @param value
	 *            the new street address line 2
	 */
	public void setStreetAddressLine2(String value);

	/**
	 * Sets the street name.
	 *
	 * Street names in postal addresses. It can also be the name of a locality,
	 * a hamlet, etc. With a maximum length of 150 characters. eCH-0010 V7.0
	 * addressInformation
	 *
	 *
	 * @param value
	 *            the new street name
	 */
	public void setStreetName(String value);

	public void setUsage(AddressUse value);

}
