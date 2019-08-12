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

package org.ehealth_connector.cda.textbuilder;

/**
 * Common code for all text builder classes.
 *
 */
public abstract class TextBuilder {

	protected final static String tableFooter = "</tbody></table>";

	private final StringBuffer buffer = new StringBuffer();

	public TextBuilder() {
	}

	protected void addCell(String text) {
		append(getCell(text));
	}

	protected void addCellWithContent(String text, String prefix, int i) {
		append(getCellWithContent(text, prefix, i));
	}

	protected void addContent(String text, String contentId) {
		append(getContent(text, contentId));
	}

	protected void addContent(String text, String prefix, int i) {
		append(getContent(text, prefix, i));
	}

	protected void append(String text) {
		buffer.append(text);
	}

	protected String buildCell(String text) {
		return ("<td>" + text + "</td>");
	}

	protected String getCell(String text) {
		if (text == null)
			text = "";
		return "<td>" + text + "</td>";
	}

	protected String getCellWithContent(String text, String contentId) {
		return "<td>" + getContent(text, contentId) + "</td>";
	}

	protected String getCellWithContent(String text, String prefix, int i) {
		return "<td>" + getContent(text, prefix, i) + "</td>";
	}

	protected String getContent(String text, String contentId) {
		return "<content ID='" + contentId + "'>" + text + "</content>";
	}

	protected String getContent(String text, String prefix, int i) {
		return "<content ID='" + prefix + i + "'>" + text + "</content>";
	}

	@Override
	public String toString() {
		return buffer.toString();
	}

}
