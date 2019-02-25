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

import java.util.List;

import org.ehealth_connector.common.Identificator;

/**
 * Java Prototype for Value Set Management Concept.
 */
public interface OrganizationBaseType {

	public void addAddress(AddressBaseType value);

	public void addIdentificator(Identificator value);

	public void addName(String value);

	public void addTelecom(TelecomBaseType value);

	public AddressBaseType getPrimaryAddressBaseType();

	public Identificator getPrimaryIdentificator();

	public String getPrimaryName();

	public TelecomBaseType getPrimaryTelecom();

	public List<AddressBaseType> listAddresses();

	public List<Identificator> listIdentificators();

	public List<String> listNames();

	public List<TelecomBaseType> listTelecoms();

	public void setPrimaryAddress(AddressBaseType value);

	public void setPrimaryIdentificator(Identificator value);

	public void setPrimaryName(String value);

	public void setPrimaryTelecom(TelecomBaseType value);
}
