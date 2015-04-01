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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

/**
 * <div class="de">Die Klasse für Kommentar-Objekte</div> <div class="fr"></div>
 * <div class="it"></div>
 */
public class Comment {

	/** The m comment. */
	org.openhealthtools.mdht.uml.cda.ihe.Comment mComment;

	/**
	 * Instantiates a new comment.
	 */
	public Comment() {
		mComment = IHEFactory.eINSTANCE.createComment().init();
	}

	/**
	 * Instantiates a new comment.
	 * 
	 * @param comment
	 * <br>
	 *          <div class="de">Kommentar</div> <div class="fr"> comment</div>
	 *          <div class="it"> comment</div>
	 */
	public Comment(org.openhealthtools.mdht.uml.cda.ihe.Comment comment) {
		mComment = comment;
	}

	/**
	 * Instantiates a new comment.
	 * 
	 * @param text
	 * <br>
	 *          <div class="de"> Kommentar</div> <div class="fr"> text</div> <div
	 *          class="it"> text</div>
	 */
	public Comment(String text) {
		mComment = IHEFactory.eINSTANCE.createComment().init();
		setText(text);
	}

	/**
	 * <div class="de">Copy mdht comment.</div> <div class="fr">Copy mdht
	 * comment.</div> <div class="it">Copy mdht comment.</div>
	 * 
	 * @return the org.openhealthtools.mdht.uml.cda.ihe. comment
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.Comment copyMdhtComment() {
		return EcoreUtil.copy(mComment);
	}

	/**
	 * Gets the mdht comment.
	 * 
	 * @return the mdht comment
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.Comment getMdhtComment() {
		return mComment;
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return mComment.getText().getText();
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *          the new text
	 */
	public void setText(String text) {
		mComment.setText(Util.createEd(text));
	}
}
