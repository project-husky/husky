/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch;

import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

/**
 * Implements the CDA Body Level3 Comment Entry of CHACH-VACD, see chapter
 * 7.5.9.5 used to set an annotation comment text for a section.
 */
public class CommentEntry extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.Comment> {

	/**
	 * Instantiates a new CommentEntry.
	 */
	public CommentEntry() {
		super(IHEFactory.eINSTANCE.createComment().init());
	}

	/**
	 * Instantiates a new CommentEntry.
	 */
	protected CommentEntry(org.openhealthtools.mdht.uml.cda.ihe.Comment comment) {
		super(comment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CommentEntry)) {
			return false;
		}
		CommentEntry other = (CommentEntry) obj;

		String reference = this.getTextReference();
		if ((reference != null && !reference.equals(other.getTextReference()))
				|| (reference == null && other.getTextReference() != null)) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return this.getMdht().getText().getText();
	}

	/**
	 * Gets the text reference.
	 *
	 * @return the text reference
	 */
	public String getTextReference() {
		if (this.getMdht().getText() != null && this.getMdht().getText().getReference() != null) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.getTextReference() != null ? this.getTextReference().hashCode() : 0);
		return result;
	}

	/**
	 * Sets the comment text. This is the text element of the level3 object. If
	 * this object is added to a section with narrative generation enabled this
	 * text will copied to the section and the text can then be referenced by
	 * getTextReference / getContentIdText.
	 *
	 * @param text
	 *            the new comment text
	 */
	public void setCommentText(String text) {
		this.getMdht().setText(Util.createEd(text));
	}

	/**
	 * Sets the text reference.
	 *
	 * @param value
	 *            the new text reference, # for local reference has to be
	 *            included
	 */
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
