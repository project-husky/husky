package org.ehealth_connector.cda.ch.lab.lrph;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

public class OutbreakIdentificationObservation
		extends org.ehealth_connector.cda.ihe.lab.OutbreakIdentificationObservation {

	/**
	 * Gets the comment entry.
	 *
	 * @return the comment entry
	 */
	public SectionAnnotationCommentEntry getCommentEntry() {
		if (this.getMdht().getComment() != null) {
			return new SectionAnnotationCommentEntry(this.getMdht().getComment());
		}
		return null;
	}

	/**
	 * Sets the comment entry.
	 *
	 * @param commentEntry
	 *          the new comment entry
	 */
	public void setCommentEntry(SectionAnnotationCommentEntry commentEntry) {
		this.getMdht().addAct(commentEntry.getMdht());
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : getMdht().getEntryRelationships()) {
			if (entryRelationShip.getAct() == commentEntry.getMdht()) {
				entryRelationShip.setInversionInd(true);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			}
		}
	}
}
