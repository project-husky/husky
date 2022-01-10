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
package org.husky.xua.hl7v3.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.xua.hl7v3.CE;
import org.husky.xua.hl7v3.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 *
 * <!-- @formatter:on -->
 */
class RoleBuilderTest {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">HIERISTDEUTSCH</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @throws java.lang.Exception
	 * <!-- @formatter:on -->
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.hl7v3.impl.ch.ppq.hl7v3.RoleBuilder#buildObject(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testBuildObject() {
		final CE ref = new CodedWithEquivalentsBuilder().buildObject(Role.DEFAULT_NS_URI,
				Role.DEFAULT_ELEMENT_LOCAL_NAME, Role.DEFAULT_PREFIX);
		assertNotNull(ref);
	}

}
