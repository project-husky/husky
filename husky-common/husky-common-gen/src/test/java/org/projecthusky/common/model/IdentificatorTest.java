/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.common.model;

import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test class for Identificator.
 */
class IdentificatorTest {

	/**
	 * Do all tests.
	 */
	@Test
	void doAllTests() {

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

		assertEquals(identificator1, identificator2);

		// Null Flavor Tests
		II nullHl7CdaR2Value = null;
		Identificator nullObj = new Identificator(nullHl7CdaR2Value);
		assertEquals(NullFlavor.NOT_AVAILABLE_L2, nullObj.getNullFlavor());

		ObjectFactory factory = new ObjectFactory();
		nullHl7CdaR2Value = factory.createII();
		nullHl7CdaR2Value.nullFlavor = new ArrayList<String>();
		nullHl7CdaR2Value.nullFlavor.add("UNK");
		nullObj = new Identificator(nullHl7CdaR2Value);
		assertEquals(NullFlavor.UNKNOWN_L1, nullObj.getNullFlavor());

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
