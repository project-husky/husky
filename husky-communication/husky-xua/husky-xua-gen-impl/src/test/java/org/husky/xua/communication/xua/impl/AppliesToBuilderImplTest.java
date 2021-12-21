/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.xua.communication.xua.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.xua.communication.xua.AppliesTo;
import org.husky.xua.communication.xua.AppliesToBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.soap.wsaddressing.Address;
import org.opensaml.soap.wsaddressing.EndpointReference;
import org.opensaml.soap.wsaddressing.impl.AddressBuilder;
import org.opensaml.soap.wsaddressing.impl.EndpointReferenceBuilder;

class AppliesToBuilderImplTest {

	private AppliesToBuilder builder;
	private String testAddress;
	private org.opensaml.soap.wspolicy.AppliesTo testFromOutsietAppliesTo;

	@BeforeEach
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
	void testAddress() {
		final AppliesTo ref = builder.address(testAddress).create();
		assertNotNull(ref);
		assertEquals(testAddress, ref.getAddress());
	}

	@Test
	void testCreateAppliesTo() {
		final AppliesTo ref = ((AppliesToBuilderImpl) builder).create(testFromOutsietAppliesTo);
		assertNotNull(ref);
		assertEquals(testFromOutsietAppliesTo, ((AppliesToImpl) ref).getWrappedObject());
	}

}
