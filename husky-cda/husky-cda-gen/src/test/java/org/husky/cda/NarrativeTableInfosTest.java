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
package org.husky.cda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.husky.cda.NarrativeTableInfos;
import org.junit.jupiter.api.Test;

public class NarrativeTableInfosTest {

	private String[] colHeaders = new String[] { "col1", "col2" };
	private NarrativeTableInfos narrativeTableInfos = new NarrativeTableInfos("Test title",
			colHeaders);

	/**
	 * Test if getTableCol works
	 */
	@Test
	public void getTableColParams() {
		for (int i = 0; i < narrativeTableInfos.getTableColParams().size(); i++) {
			assertEquals(colHeaders[i], narrativeTableInfos.getTableColParams().get(i));
		}
	}

	/**
	 * Test if getTableTitle works
	 */
	@Test
	public void getTableTitle() {
		assertEquals(narrativeTableInfos.getTableTitle(), "Test title");
	}

	/**
	 * Test if setTableColParams works
	 */
	@Test
	public void setTableColParams() {
		String[] colHeaders = new String[] { "col1", "col2", "col3" };
		narrativeTableInfos.setTableColParams(Arrays.asList(colHeaders));
		assertEquals(narrativeTableInfos.getTableColParams().size(), colHeaders.length);
	}

	/**
	 * Test if setTableTitle works
	 */
	@Test
	public void setTableTitle() {
		narrativeTableInfos.setTableTitle("new title");
		assertEquals("new title", narrativeTableInfos.getTableTitle());
	}
}
