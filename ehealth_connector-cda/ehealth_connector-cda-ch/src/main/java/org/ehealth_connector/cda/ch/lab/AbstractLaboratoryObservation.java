package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

public abstract class AbstractLaboratoryObservation
		extends org.ehealth_connector.cda.ihe.lab.LaboratoryObservation {

	public AbstractLaboratoryObservation() {
		super();
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
	}

	/**
	 * Add a comment entry.
	 *
	 * @param commentEntry
	 *          the new comment entry
	 */
	public void addCommentEntry(SectionAnnotationCommentEntry commentEntry) {
		this.getMdht().addAct(commentEntry.copy());
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : getMdht().getEntryRelationships()) {
			if (entryRelationShip.getAct() == commentEntry.getMdht()) {
				entryRelationShip.setInversionInd(true);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			}
		}
	}

	/**
	 * Gets the comment entries.
	 *
	 * @return the comment entry
	 */
	public List<SectionAnnotationCommentEntry> getCommentEntryList() {
		if (this.getMdht().getComments() != null) {
			ArrayList<SectionAnnotationCommentEntry> comments = new ArrayList<SectionAnnotationCommentEntry>();
			for (Comment comment : this.getMdht().getComments()) {
				comments.add(new SectionAnnotationCommentEntry(comment));
			}
			return comments;
		}
		return null;
	}

	// Convenience function to set a new code, which is not in the value set for
	// LRXX
	public void setNewCode(Code code, SectionAnnotationCommentEntry commentEntry) {
		this.addCommentEntry(commentEntry);
		Code nullCode = new Code(NullFlavor.TEMPORARILY_UNAVAILABLE);
		nullCode.addTranslation(code);
		this.setCode(nullCode);
	}
}
