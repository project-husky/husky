package org.ehealth_connector.cda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Person;
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
