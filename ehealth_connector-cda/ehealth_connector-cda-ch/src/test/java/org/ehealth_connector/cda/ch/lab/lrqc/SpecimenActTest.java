package org.ehealth_connector.cda.ch.lab.lrqc;

import static org.junit.Assert.assertNotNull;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ihe.lab.NonHumanSubject;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class SpecimenActTest extends TestUtils {

	@Test
	public void testModel() throws XPathExpressionException {
		NonHumanSubject nhs = new NonHumanSubject();
		SpecimenAct spa = new SpecimenAct();

		spa.setNonHumanSubject(nhs);
		assertNotNull(spa.getNonHumanSubject());
		Document document = spa.getDocument();

		xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.1.2.1", null);

	}

}
