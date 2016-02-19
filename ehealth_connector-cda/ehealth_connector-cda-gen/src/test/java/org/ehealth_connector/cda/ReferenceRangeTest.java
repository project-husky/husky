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

		r.setInterpretationCode(ObservationInterpretation.ABNORMAL);
		assertEquals(ObservationInterpretation.ABNORMAL, r.getInterpretationCode());

		// Test Value with IVL_PQ Value
		Value v = new Value(new BigDecimal("0.0"), new BigDecimal("5.0"));
		r.setValue(v);

		assertTrue("0.0".equals(r.getValue().getPhysicalQuantityIntervalLowValue().toString()));
		assertTrue("5.0".equals(r.getValue().getPhysicalQuantityIntervalHighValue().toString()));

		// Test Observation Interpretation
		r.setInterpretationCode(ObservationInterpretation.ABNORMAL);
		assertEquals(ObservationInterpretation.ABNORMAL, r.getInterpretationCode());
	}
}
