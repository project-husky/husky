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
package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.ReferenceRange;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.NullFlavor;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;

/**
 * The Class AbstractLaboratoryObservation.
 */
public abstract class AbstractLaboratoryObservation
		extends org.ehealth_connector.cda.ihe.lab.LaboratoryObservation {

	/** The language code for narrative text generation. */
	protected LanguageCode myLang = LanguageCode.ENGLISH;

	/**
	 * Instantiates a new abstract laboratory observation.
	 */
	public AbstractLaboratoryObservation() {
		super();
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
	}

	/**
	 * Instantiates a new abstract laboratory observation.
	 *
	 * @param observation
	 *            the observation
	 */
	public AbstractLaboratoryObservation(Observation observation) {
		super((LaboratoryObservation) observation);
	}

	/**
	 * Instantiates a new abstract laboratory observation.
	 *
	 * @param mdht
	 *            the mdht object
	 */
	public AbstractLaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht) {
		super(mdht);
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
	}

	/**
	 * Instantiates a new abstract laboratory observation.
	 *
	 * @param mdht
	 *            the mdht object
	 * @param lang
	 *            the lang
	 */
	public AbstractLaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht,
			LanguageCode lang) {
		super(mdht);
		myLang = lang;
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
	}

	/**
	 * Add a comment entry.
	 *
	 * @param commentEntry
	 *            the new comment entry
	 */
	@Override
	public void addCommentEntry(SectionAnnotationCommentEntry commentEntry) {
		if (commentEntry != null) {
			this.getMdht().addAct(commentEntry.copy());
			CdaUtil.setEntryRelationshipCommentInversionIdAndTypeCode(
					getMdht().getEntryRelationships());
		}
	}

	/**
	 * Gets the list of all comment entries.
	 *
	 * @return the comment entry list.
	 */
	public List<SectionAnnotationCommentEntry> getCommentEntryList() {
		if (this.getMdht().getComments() != null) {
			final List<SectionAnnotationCommentEntry> comments = new ArrayList<SectionAnnotationCommentEntry>();
			for (final Comment comment : this.getMdht().getComments()) {
				comments.add(new SectionAnnotationCommentEntry(comment));
			}
			return comments;
		}
		return null;
	}

	/**
	 * Gets the narrative text of the observation in the desired language.
	 *
	 * @return the observation name
	 */
	public String getNarrativeText() {
		String obsName = getText();
		if ("".equals(obsName)) {
			VitalSignCodes vs = VitalSignCodes.getEnum(getCode().getCode());
			if (vs != null)
				obsName = vs.getDisplayName(myLang);
		}
		if ("".equals(obsName)) {
			obsName = getCode().getOriginalText();
		}
		return obsName;
	}

	/**
	 * Gets the reference range <div class="de">(Referenzbereich)</div>.
	 *
	 * @return the reference range
	 */
	public ReferenceRange getReferenceRange() {
		if ((getMdht().getReferenceRanges() != null) && !getMdht().getReferenceRanges().isEmpty()) {
			return new ReferenceRange(getMdht().getReferenceRanges().get(0));
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtFacade#getTextReference()
	 */
	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtObservationFacade#getValues()
	 */
	@Override
	public List<Value> getValues() {
		final List<Value> vl = new ArrayList<Value>();
		for (final ANY v : getMdht().getValues()) {
			vl.add(new Value(v));
		}
		return vl;
	}

	/**
	 * Convenience function to set a new code, which is not currently available
	 * in the value set for LRXX.
	 *
	 * @param code
	 *            the code
	 * @param commentEntry
	 *            the comment entry
	 */
	public void setNewCode(Code code, SectionAnnotationCommentEntry commentEntry) {
		this.addCommentEntry(commentEntry);
		final Code nullCode = new Code(NullFlavor.TEMPORARILY_UNAVAILABLE);
		nullCode.addTranslation(code);
		this.setCode(nullCode);
	}
}
