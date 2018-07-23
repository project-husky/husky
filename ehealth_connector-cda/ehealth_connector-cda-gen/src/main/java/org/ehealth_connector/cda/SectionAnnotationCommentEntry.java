/*
 *
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

import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

/**
 * Implements the CDA Body Level3 Comment Entry used to set an annotation
 * comment text for a section. e.g. CHA-CH-VACD, see chapter 7.5.9.5
 */
public class SectionAnnotationCommentEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.Comment> {

	/**
	 * Instantiates an empty SectionAnnotationCommentEntry.
	 */
	public SectionAnnotationCommentEntry() {
		super(IHEFactory.eINSTANCE.createComment().init());
	}

	/**
	 * Instantiates a new SectionAnnotationCommentEntry based on the MDHT
	 * element.
	 */
	public SectionAnnotationCommentEntry(org.openhealthtools.mdht.uml.cda.ihe.Comment comment) {
		super(comment);
	}

	/**
	 * Instantiates an SectionAnnotationCommentEntry with a given
	 * ContentIdReference.
	 */
	public SectionAnnotationCommentEntry(String reference) {
		this();
		setContentIdReference(reference);
	}

	/**
	 * Instantiates an SectionAnnotationCommentEntry with a given
	 * ContentIdReference and an according text, which will be added after the
	 * reference element.
	 */
	public SectionAnnotationCommentEntry(String reference, String text) {
		this();
		setContentIdReference(reference);
		addAnnotationCommentText(text);
	}

	/**
	 * Adds the given text after the existing text of the annotation comment.
	 * This is the text element of the level3 object. If this object is added to
	 * a section with narrative generation enabled this text will copied to the
	 * section text and the text can then be referenced by the &lt;content
	 * ID="xxx"&gt; element.
	 *
	 * @param text
	 *            the new comment text
	 */
	public void addAnnotationCommentText(String text) {
		if (getMdht().getText() != null && getMdht().getText().getText() != null) {
			getMdht().getText().addText(text);
		} else {
			getMdht().setText(Util.createEd(text));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SectionAnnotationCommentEntry)) {
			return false;
		}
		final SectionAnnotationCommentEntry other = (SectionAnnotationCommentEntry) obj;

		final String reference = this.getContentIdReference();
		if (((reference != null) && !reference.equals(other.getContentIdReference()))
				|| ((reference == null) && (other.getContentIdReference() != null))) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the text of the annotation comment.
	 *
	 * @return the text of the annotation comment
	 */
	public String getAnnotationCommentText() {
		return this.getMdht().getText().getText();
	}

	/**
	 * Gets the reference to the content element. It is the value of the ID in
	 * the &lt;content ID="xxx"&gt; element prefixed with #.
	 *
	 * @return the content ID reference
	 */
	public String getContentIdReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ (this.getContentIdReference() != null ? this.getContentIdReference().hashCode()
						: 0);
		return result;
	}

	/**
	 * Sets the text of the annotation comment. This is the text element of the
	 * level3 object. If this object is added to a section with narrative
	 * generation enabled this text will copied to the section text and the text
	 * can then be referenced by the &lt;content ID="xxx"&gt; element.
	 *
	 * @param text
	 *            the new comment text
	 */
	public void setAnnotationCommentText(String text) {
		this.getMdht().setText(Util.createEd(text));
	}

	/**
	 * Sets the reference to the content element. This is the value of the ID in
	 * the &lt;content ID="xxx"&gt; element. If not provided it will
	 * automatically be prefixed with #.
	 *
	 * @param value
	 *            the content ID reference
	 */
	public void setContentIdReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
