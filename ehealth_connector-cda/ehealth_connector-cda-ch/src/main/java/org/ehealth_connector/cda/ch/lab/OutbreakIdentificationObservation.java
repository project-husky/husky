package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

public class OutbreakIdentificationObservation
		extends org.ehealth_connector.cda.ihe.lab.OutbreakIdentificationObservation {

	public OutbreakIdentificationObservation() {
		super();
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.NA);
		getMdht().getValues().add(ce);
	}

	public OutbreakIdentificationObservation(OutbreakIdentification mdht) {
		super(mdht);
	}

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
