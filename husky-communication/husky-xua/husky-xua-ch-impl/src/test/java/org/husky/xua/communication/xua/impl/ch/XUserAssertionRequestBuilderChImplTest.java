/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.xua.communication.xua.impl.ch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.xua.ChEprXuaSpecifications;
import org.husky.xua.communication.xua.XUserAssertionRequest;
import org.husky.xua.communication.xua.impl.XUserAssertionRequestBuilderImpl;
import org.junit.jupiter.api.BeforeEach;

public class XUserAssertionRequestBuilderChImplTest {

	private XUserAssertionRequestBuilderImpl builder;
	private String testDialect;

	@BeforeEach
	public void setUp() throws Exception {
		builder = new XUserAssertionRequestBuilderChImpl();
		testDialect = "This is a Dialect";
	}

	@org.junit.jupiter.api.Test
	public void testDialect() {
		final XUserAssertionRequest ref = builder.dialect(testDialect).create();
		assertNotNull(ref);
		assertNotEquals(testDialect, ref.getDialect());
		assertEquals(ChEprXuaSpecifications.CLAIMS_DIALECT, ref.getDialect());
	}

}
