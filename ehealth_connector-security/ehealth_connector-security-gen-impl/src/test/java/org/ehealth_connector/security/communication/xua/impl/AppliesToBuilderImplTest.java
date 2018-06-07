/*
 *
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
package org.ehealth_connector.security.communication.xua.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.communication.xua.AppliesTo;
import org.ehealth_connector.security.communication.xua.AppliesToBuilder;
import org.junit.Before;
import org.junit.Test;
import org.opensaml.soap.wsaddressing.Address;
import org.opensaml.soap.wsaddressing.EndpointReference;
import org.opensaml.soap.wsaddressing.impl.AddressBuilder;
import org.opensaml.soap.wsaddressing.impl.EndpointReferenceBuilder;

public class AppliesToBuilderImplTest {

	private AppliesToBuilder builder;
	private String testAddress;
	private org.opensaml.soap.wspolicy.AppliesTo testFromOutsietAppliesTo;

	@Before
	public void setUp() throws Exception {
		builder = new AppliesToBuilderImpl();
		testAddress = "https://guguesli.org/test/access/";
		testFromOutsietAppliesTo = new org.opensaml.soap.wspolicy.impl.AppliesToBuilder()
				.buildObject();
		final Address wsaAddress = new AddressBuilder().buildObject();
		wsaAddress.setValue(testAddress);
		final EndpointReference enpointRef = new EndpointReferenceBuilder().buildObject();
		enpointRef.setAddress(wsaAddress);
		testFromOutsietAppliesTo.getUnknownXMLObjects().add(enpointRef);
	}

	@Test
	public void testAddress() {
		final AppliesTo ref = builder.address(testAddress).create();
		assertNotNull(ref);
		assertEquals(testAddress, ref.getAddress());
	}

	@Test
	public void testCreateAppliesTo() {
		final AppliesTo ref = ((AppliesToBuilderImpl) builder).create(testFromOutsietAppliesTo);
		assertNotNull(ref);
		assertEquals(testFromOutsietAppliesTo, ((AppliesToImpl) ref).getWrappedObject());
	}

}
