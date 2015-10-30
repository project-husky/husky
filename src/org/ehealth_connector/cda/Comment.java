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

package org.ehealth_connector.cda;

import org.ehealth_connector.cda.ch.SectionAnnotationCommentEntry;
import org.ehealth_connector.util.Util;

/**
 * Class for Commment, please use CommentEntry instead
 * 
 * @deprecated use CommentEntry
 */
@Deprecated
public class Comment extends SectionAnnotationCommentEntry {

	/**
	 * Instantiates a new comment.
	 */
	public Comment() {
	}

	/**
	 * Instantiates a new comment.
	 * 
	 * @param comment
	 *            the mdht comment object
	 */
	public Comment(org.openhealthtools.mdht.uml.cda.ihe.Comment comment) {
		super(comment);
	}

	/**
	 * Instantiates a new comment.
	 * 
	 * @param text
	 *            text which should appear in t
	 */
	public Comment(String text) {
		setAnnotationCommentText(text);
	}

	/**
	 * Gets the mdht comment.
	 * 
	 * @return the mdht comment
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.Comment getMdhtComment() {
		return this.getMdht();
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getAnnotationCommentText() {
		return this.getMdht().getText().getText();
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setAnnotationCommentText(String text) {
		this.getMdht().setText(Util.createEd(text));
	}
}
