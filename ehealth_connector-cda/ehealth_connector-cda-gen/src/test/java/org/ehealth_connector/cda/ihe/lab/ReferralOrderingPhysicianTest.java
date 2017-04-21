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
package org.ehealth_connector.cda.ihe.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.cda.AssociatedEntity;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;

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
	}
}
