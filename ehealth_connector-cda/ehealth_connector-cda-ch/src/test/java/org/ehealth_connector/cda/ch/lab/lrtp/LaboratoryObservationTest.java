package org.ehealth_connector.cda.ch.lab.lrtp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.ReferenceRange;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.junit.Test;
import org.w3c.dom.Document;

public class LaboratoryObservationTest extends TestUtils {

	public LaboratoryObservationTest() {
		super.init();
	}

	@Test
	public void testLrtpModel() throws XPathExpressionException {
		LaboratoryObservation lo = new LaboratoryObservation();

		// // SOAS Info Entry
		// SoasInfoEntry s = new SoasInfoEntry();
		// lo.addSoasInfoEntry(s);
		// Document document = lo.getDocument();
		// assertFalse(lo.getSoasInfoEnties().isEmpty());
		//
		// assertTrue(xExist(document,
		// "//observation/entryRelationship/observation/templateId[@root='2.16.756.5.30.1.1.1.1.3.4.1'
		// and @extension='CDA-CH.LRTP.SOASInfo']"));
		// assertTrue(xExist(document,
		// "//observation/entryRelationship/observation/templateId[@root='1.3.6.1.4.1.19376.1.3.1.6']"));

		// Reference Range
		ReferenceRange r = new ReferenceRange();
		r.setValue(new Value(new BigDecimal("0.0"), new BigDecimal("5.0")));
		lo.setReferenceRange(r);
		assertNotNull(lo.getReferenceRange());

		Document document = lo.getDocument();
		assertTrue(xExist(document, "//referenceRange[@typeCode='REFV']"));
		assertTrue(xExist(document,
				"//referenceRange/observationRange/interpretationCode[@code='N' and @codeSystem='2.16.840.1.113883.5.83']"));
		assertTrue(xExist(document, "//referenceRange/observationRange/value/low[@value='0.0']"));
		assertTrue(xExist(document, "//referenceRange/observationRange/value[@type='IVL_PQ']"));

		// Code
		lo.setCode(LabObsList.A11_HLA_ANTIGENE);
		assertNotNull(lo.getCode());
		assertEquals(LabObsList.A11_HLA_ANTIGENE, lo.getCodeAsLoincEnum());

		// // Convenience SoasInfoEntry (creates two SoasInfoEntries)
		// LaboratoryObservation lo2 = new LaboratoryObservation();
		// lo2.addSoasInfoEnties(true, true);
		// document = lo2.getDocument();
		// assertTrue(xCount(document,
		// "//observation/entryRelationship/observation/templateId[@root='2.16.756.5.30.1.1.1.1.3.4.1'
		// and @extension='CDA-CH.LRTP.SOASInfo']",
		// 2));

		// Interpretation Code
		lo.addInterpretationCode(ObservationInterpretation.ABNORMAL);
		lo.addInterpretationCode(ObservationInterpretation.HIGH);
		assertFalse(lo.getInterpretationCodes().isEmpty());
		assertEquals(ObservationInterpretation.HIGH, lo.getInterpretationCodesAsEnum().get(1));
	}
}
