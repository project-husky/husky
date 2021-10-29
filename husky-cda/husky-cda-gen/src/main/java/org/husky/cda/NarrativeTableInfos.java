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

import java.util.Arrays;
import java.util.List;

/**
 * <div class="en">Represent a table for the narrative text</div>
 */
public class NarrativeTableInfos {

	/** the tableColParams */
	private List<String> tableColParams;
	/** the tableTitle */
	private String tableTitle;

	/**
	 * <div class="en">Instantiates a new instance.</div>
	 *
	 * @param tableTitle
	 *            title of the table
	 * @param tableColParams
	 *            array of header attributes names
	 */
	public NarrativeTableInfos(String tableTitle, String[] tableColParams) {
		this.tableTitle = tableTitle;
		this.tableColParams = Arrays.asList(tableColParams);
	}

	/**
	 * <div class="en">get the getTableColParams</div>
	 *
	 * @return the tableColParams
	 */
	public List<String> getTableColParams() {
		return tableColParams;
	}

	/**
	 * <div class="en">get the tableTitle</div>
	 *
	 * @return the tableTitle
	 */
	public String getTableTitle() {
		return tableTitle;
	}

	/**
	 * <div class="en">get the tableColParams</div>
	 *
	 * @param tableColParams
	 *            the tableColParams
	 */
	public void setTableColParams(List<String> tableColParams) {
		this.tableColParams = tableColParams;
	}

	/**
	 * <div class="en">get the tableTitle</div>
	 *
	 * @param tableTitle
	 *            the tableTitle
	 */
	public void setTableTitle(String tableTitle) {
		this.tableTitle = tableTitle;
	}

}
