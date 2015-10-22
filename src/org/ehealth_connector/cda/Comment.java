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

import org.ehealth_connector.common.Util;

/**
 * <div class="en">Class for Comments</div> <div class="de">Die Klasse für
 * Kommentar-Objekte</div> <div class="fr"></div> <div class="it"></div>
 * 
 * @deprecated use CommentEntry
 */
@Deprecated
public class Comment extends CommentEntry {

	/**
	 * Instantiates a new comment.
	 */
	public Comment() {
	}

	/**
	 * Instantiates a new comment.
	 * 
	 * @param comment
	 *            <br>
	 *            <div class="en">Comment</div> <div class="de">Kommentar</div>
	 *            <div class="fr"> comment</div> <div class="it"> comment</div>
	 */
	public Comment(org.openhealthtools.mdht.uml.cda.ihe.Comment comment) {
		super(comment);
	}

	/**
	 * Instantiates a new comment.
	 * 
	 * @param text
	 *            <br>
	 *            <div class="en">Comment</div> <div class="de"> Kommentar</div>
	 *            <div class="fr"> text</div> <div class="it"> text</div>
	 */
	public Comment(String text) {
		setText(text);
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
	public String getText() {
		return this.getMdht().getText().getText();
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.getMdht().setText(Util.createEd(text));
	}
}
