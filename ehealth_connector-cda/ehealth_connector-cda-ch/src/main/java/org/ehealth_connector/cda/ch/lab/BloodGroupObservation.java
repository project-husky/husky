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
package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.enums.epsos.BloodGroup;
import org.ehealth_connector.cda.utils.CdaUtilMdht;
import org.ehealth_connector.common.mdht.Author;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ch.BloodgroupObservation;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class BloodGroupObservation.
 *
 * <div class="en">This element contains the blood group in a structured
 * form.</div> <div class="de">Dieses Kapitel enthält die Blutgruppe in
 * strukturierter Form.</div>
 */
public class BloodGroupObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ch.BloodgroupObservation> {

	/**
	 * Instantiates a new blood group observation.
	 */
	public BloodGroupObservation() {
		super(ChFactory.eINSTANCE.createBloodgroupObservation().init(),
				"2.16.756.5.30.1.1.1.1.3.4.1", "CDA-CH.LRTP.Body.StudiesSummaryL3.Bloodgroup");
	}

	/**
	 * Instantiates a new blood group observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public BloodGroupObservation(BloodgroupObservation mdht) {
		super(mdht);
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param referenceValue
	 *            reference to the section level text with the description of
	 *            the blood group
	 * @param value
	 *            the BloodGroup value
	 */
	public BloodGroupObservation(String referenceValue, BloodGroup value) {
		this();
		setContentIdReference(referenceValue);
		setValue(value);
	}

	/**
	 * Adds the author.
	 *
	 * @param author
	 *            the author
	 */
	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
	}

	/**
	 * Add a comment entry.
	 *
	 * @param commentEntry
	 *            the new comment entry
	 */
	public void addCommentEntry(SectionAnnotationCommentEntry commentEntry) {
		this.getMdht().addAct(commentEntry.copy());
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : getMdht().getEntryRelationships()) {
			if (entryRelationShip.getAct() instanceof Comment) {
				entryRelationShip.setInversionInd(true);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			}
		}
	}

	/**
	 * Gets the author list.
	 *
	 * @return the author list
	 */
	public List<Author> getAuthorList() {
		final List<Author> al = new ArrayList<Author>();
		if ((getMdht().getAuthors() != null) && !getMdht().getAuthors().isEmpty()) {
			for (final org.openhealthtools.mdht.uml.cda.Author a : getMdht().getAuthors()) {
				al.add(new Author(a));
			}
		}
		return al;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public SectionAnnotationCommentEntry getComment() {
		if (getMdht().getComment() != null) {
			return new SectionAnnotationCommentEntry(getMdht().getComment());
		}
		return null;
	}

	/**
	 * Gets the content id reference.
	 *
	 * @return the content id reference
	 */
	public String getContentIdReference() {
		if ((getMdht().getText() != null) && (getMdht().getText().getReference() != null)
				&& (getMdht().getText().getReference().getValue() != null)) {
			return getMdht().getText().getReference().getValue();
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
	 * Gets the value enum.
	 *
	 * @return the value enum
	 */
	public BloodGroup getValueEnum() {
		if (!getMdht().getValues().isEmpty() && (getMdht().getValues().get(0) instanceof CE)) {
			final CE ce = (CE) getMdht().getValues().get(0);
			return BloodGroup.getEnum(ce.getCode());
		}
		return null;
	}

	/**
	 * Sets the comment.
	 *
	 * @param commentEntry
	 *            the new comment
	 */
	public void setComment(SectionAnnotationCommentEntry commentEntry) {
		getMdht().addAct(commentEntry.copy());
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		CdaUtilMdht.setEntryRelationshipCommentInversionIdAndTypeCode(
				getMdht().getEntryRelationships());
	}

	/**
	 * Sets the content id reference.
	 *
	 * @param reference
	 *            the new content id reference
	 */
	public void setContentIdReference(String reference) {
		getMdht().setText(Util.createReference(reference));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtFacade#setTextReference(java.lang.String)
	 */
	@Override
	public void setTextReference(String textReference) {
		if (textReference != null) {
			if (!textReference.equals("")) {
				if (!textReference.startsWith("#"))
					textReference = "#" + textReference;
				this.getMdht().setText(Util.createReference(textReference));
			}
		}
	}

	/**
	 * Sets the blood group.
	 *
	 * @param value
	 *            <div class="en">Description of the blood group</div>
	 *            <div class="de">Bezeichnung der Blutgruppe</div>
	 */
	public void setValue(BloodGroup value) {
		getMdht().getValues().clear();
		getMdht().getValues().add(value.getCE());
	}
}
