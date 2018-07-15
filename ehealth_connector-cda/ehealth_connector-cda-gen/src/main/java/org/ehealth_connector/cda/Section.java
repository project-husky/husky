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

import org.ehealth_connector.common.Code;

public class Section {
	private String mTitle = "";
	private String mText = "";
	private Code mCode = null;
	private Integer mIndex = null;

	public Section() {
	}

	public Section(String title, String text) {
		mTitle = title;
		mText = text;
	}

	public Section(String title, String text, Code code) {
		mTitle = title;
		mText = text;
		mCode = code;
	}

	public Code getCode() {
		return mCode;
	}

	public Integer getIndex() {
		return mIndex;
	}

	public String getText() {
		return mText;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setCode(Code code) {
		mCode = code;
	}

	public void setIndex(Integer index) {
		mIndex = index;
	}

	public void setText(String text) {
		mText = text;
	}

	public void setTitle(String title) {
		mTitle = title;
	}
}
