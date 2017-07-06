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
package org.ehealth_connector.cda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.ReferenceRange;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.junit.Test;

public class ReferenceRangeTest extends TestUtils {
	@Test
	public void testModel() {
		ReferenceRange r = new ReferenceRange();

		r.setInterpretation(ObservationInterpretation.ABNORMAL);
		assertEquals(ObservationInterpretation.ABNORMAL, r.getInterpretation());

		// Test Value with IVL_PQ Value
		Value v = new Value(new BigDecimal("0.0"), new BigDecimal("5.0"));
		r.setValue(v);

		assertTrue("0.0".equals(r.getValue().getPhysicalQuantityIntervalLowValue().toString()));
		assertTrue("5.0".equals(r.getValue().getPhysicalQuantityIntervalHighValue().toString()));

		// Test Observation Interpretation
		r.setInterpretation(ObservationInterpretation.ABNORMAL);
		assertEquals(ObservationInterpretation.ABNORMAL, r.getInterpretation());
	}
}
