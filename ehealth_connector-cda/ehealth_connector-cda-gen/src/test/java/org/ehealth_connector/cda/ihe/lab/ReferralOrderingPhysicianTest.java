package org.ehealth_connector.cda.ihe.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.cda.AssociatedEntity;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class ReferralOrderingPhysicianTest extends TestUtils {
	@Test
	public void testModel() {
		super.init();
		ReferralOrderingPhysician rop = new ReferralOrderingPhysician();

		// Associated Entity
		AssociatedEntity ae = new AssociatedEntity();
		rop.setAssociatedEntity(ae);
		assertNotNull(rop.getAssociatedEntity());

		rop.setTime(endDate);
		assertEquals(endDate, rop.getTime());

		Document document = rop.getDocument();
	}
}
