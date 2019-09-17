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
package org.ehealth_connector.cda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.mdht.Person;
import org.junit.Test;

public class AssociatedEntityTest extends TestUtils {
	@Test
	public void testModel() {
		super.init();
		AssociatedEntity ae = new AssociatedEntity();

		// Adress
		ae.addAddress(address1);
		assertEquals(address1.getCity(), ae.getAddresses().get(0).getCity());

		// Person
		Person person = new Person();
		person.addName(name1);
		ae.setPerson(person);
		assertTrue(isEqual(name1, ae.getPerson().getNames().get(0)));

		// Organization
		ae.setOrganization(organization1);
		assertNotNull(ae.getOrganization());
		assertTrue(isEqual(organization1, ae.getOrganization()));

		// Telecoms
		ae.setTelecoms(telecoms1);
		assertTrue(isEqual(telecoms1, ae.getTelecoms()));

		// Ids
		ae.addId(id1);
		ae.addId(id2);
		assertTrue(isEqual(id1, ae.getIds().get(0)));
		assertTrue(isEqual(id2, ae.getIds().get(1)));
	}
}
