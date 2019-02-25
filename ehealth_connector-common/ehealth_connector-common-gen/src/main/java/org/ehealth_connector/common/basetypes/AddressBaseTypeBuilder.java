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

/**
 * Java Prototype for Value Set Management Concept.
 */
public interface AddressBaseTypeBuilder {

	public AddressBaseTypeBuilder additionalLocator(String value);

	public AddressBaseTypeBuilder city(String value);

	public AddressBaseTypeBuilder country(String value);

	public AddressBaseType createAddressBaseType();

	public AddressBaseTypeBuilder houseNumber(String value);

	public AddressBaseTypeBuilder postalCode(String value);

	public AddressBaseTypeBuilder postBox(String value);

	public AddressBaseTypeBuilder state(String value);

	public AddressBaseTypeBuilder streetAddressLine1(String value);

	public AddressBaseTypeBuilder streetAddressLine2(String value);

	public AddressBaseTypeBuilder usage(String value);

}
