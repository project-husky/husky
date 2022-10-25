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
package org.projecthusky.xua.hl7v3.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.projecthusky.xua.hl7v3.CE;
import org.projecthusky.xua.hl7v3.PurposeOfUse;
import org.projecthusky.xua.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurposeOfUseBuilderTest extends InitializerTestHelper {

	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.hl7v3.impl.PurposeOfUseBuilder.ppq.hl7v3.PurposeOfUseBuilder#buildObject()}.
	 */
	@Test
	void testBuildObject() {
		final CE ref = new CodedWithEquivalentsBuilder().buildObject(PurposeOfUse.DEFAULT_NS_URI,
				PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);
		assertNotNull(ref);
	}

}
