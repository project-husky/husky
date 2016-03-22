package org.ehealth_connector.cda.ihe.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class NonHumanSubjectTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		super.init();
		NonHumanSubject nhs = new NonHumanSubject(code1, address1);

		assertNotNull(nhs.getAdress());
		assertEquals(address1.getAddressline1(), nhs.getAdress().getAddressline1());
		assertTrue(code1.equals(nhs.getCode()));

		Document document = nhs.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.1.2.1", null));
		assertTrue(xExist(document, "//relatedSubject/code"));
	}
}
