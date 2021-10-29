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
package org.husky.cda.ch.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.husky.cda.ch.utils.CdaChUtil;
import org.husky.cda.utils.CdaUtilMdhtTest;
import org.husky.common.enums.CodeSystems;
import org.husky.common.hl7cdar2.II;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of CdaChUtil
 *
 */
public class CdaChUtilTest extends CdaUtilMdhtTest {

	@Override
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link org.husky.cda.utils.CdaUtilMdht#createUniqueIiFromString(java.lang.String)}
	 * .
	 */
	@Test
	public void testCreateUuidVacd() {
		final II ref = CdaChUtil.createUniqueIiFromString(testId);

		assertEquals(testId, ref.getExtension());
	}

	/**
	 * Test method for
	 * {@link org.husky.cda.utils.CdaUtilMdht#createUniqueIiFromString(org.husky.common.Identificator)}
	 * .
	 */
	@Test
	public void testCreateUuidVacdIdentificator() {
		final II ref = CdaChUtil.createUniqueIiFromIdentificator(testIdentiicator);
		assertEquals(CodeSystems.GLN.getCodeSystemId(), ref.getRoot());
		assertEquals(testId, ref.getExtension());
	}


}
