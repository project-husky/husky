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
package org.ehealth_connector.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.hl7cdar2.II;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.junit.Test;

/**
 * The test class for Identificator.
 */
public class IdentificatorTest {

	/**
	 * Do all tests.
	 */
	@Test
	public void doAllTests() {

		String assigningAuthorityName = "assigningAuthorityName";
		boolean displayable = false;
		String extension = "myextension";
		String root = "2.999";

		IdentificatorBaseType identificatorBt = IdentificatorBaseType.builder()
				.withAssigningAuthorityName(assigningAuthorityName).withDisplayable(displayable)
				.withExtension(extension).withRoot(root).build();

		Identificator identificator1 = new Identificator(identificatorBt);
		II hl7CdaR2Type = identificator1.getHl7CdaR2Ii();
		Identificator identificator2 = new Identificator(hl7CdaR2Type);

		assertTrue(identificator1.equals(identificator2));

		// Null Flavor Tests
		II nullHl7CdaR2Value = null;
		Identificator nullObj = new Identificator(nullHl7CdaR2Value);
		assertEquals(NullFlavor.NOT_AVAILABLE, nullObj.getNullFlavor());

		ObjectFactory factory = new ObjectFactory();
		nullHl7CdaR2Value = factory.createII();
		nullHl7CdaR2Value.nullFlavor = new ArrayList<String>();
		nullHl7CdaR2Value.nullFlavor.add("UNK");
		nullObj = new Identificator(nullHl7CdaR2Value);
		assertEquals(NullFlavor.UNKNOWN, nullObj.getNullFlavor());

		// This is for debugging purposes, only. When enabled, you need to IId
		// @XmlRootElement(name = "debug") to class II
		// JAXBContext context;
		// try {
		// context = JAXBContext.newInstance(II.class);
		// Marshaller mar = context.createMarshaller();
		// mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// mar.marshal(hl7CdaR2Type,
		// new File(Util.getTempDirectory() +
		// FileUtil.getPlatformSpecificPathSeparator()
		// + hl7CdaR2Type.getClass().getName() + ".xml"));
		// } catch (JAXBException e) {
		// e.printStackTrace();
		// }

	}

}
