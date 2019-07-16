/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda;

import org.ehealth_connector.common.mdht.Code;

/**
 * The Class Section.
 */
public class Section {

	/** The local code. */
	private Code mCode = null;

	/** The local index. */
	private Integer mIndex = null;

	/** The local text. */
	private String mText = "";

	/** The local title. */
	private String mTitle = "";

	/**
	 * Instantiates a new section.
	 */
	public Section() {
	}

	/**
	 * Instantiates a new section.
	 *
	 * @param title
	 *            the section title
	 * @param text
	 *            the section text
	 */
	public Section(String title, String text) {
		mTitle = title;
		mText = text;
	}

	/**
	 * Instantiates a new section.
	 *
	 * @param title
	 *            the section title
	 * @param text
	 *            the section text
	 * @param code
	 *            the section code
	 */
	public Section(String title, String text, Code code) {
		mTitle = title;
		mText = text;
		mCode = code;
	}

	/**
	 * Gets the section code.
	 *
	 * @return the section code
	 */
	public Code getCode() {
		return mCode;
	}

	/**
	 * Gets the section index (used for narrative text generatoin).
	 *
	 * @return the section index (used for narrative text generatoin)
	 */
	public Integer getIndex() {
		return mIndex;
	}

	/**
	 * Gets the section text.
	 *
	 * @return the section text
	 */
	public String getText() {
		return mText;
	}

	/**
	 * Gets the section title.
	 *
	 * @return the section title
	 */
	public String getTitle() {
		return mTitle;
	}

	/**
	 * Sets the section code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		mCode = code;
	}

	/**
	 * Sets the section index (used for narrative text generatoin).
	 *
	 * @param index
	 *            the new index
	 */
	public void setIndex(Integer index) {
		mIndex = index;
	}

	/**
	 * Sets the section text.
	 *
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		mText = text;
	}

	/**
	 * Sets the section title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		mTitle = title;
	}
}
