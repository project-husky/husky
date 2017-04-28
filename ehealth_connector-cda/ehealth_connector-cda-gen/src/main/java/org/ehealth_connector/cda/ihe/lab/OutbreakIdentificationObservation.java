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
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class OutbreakIdentificationObservation. Outbreak Identification, when
 * present, SHALL be recorded as an observation under the Notification Organizer
 * as demonstrated. Outbreak Identification SHALL be present when dictated by
 * local outbreak identification reporting requirements.
 */
public class OutbreakIdentificationObservation extends
		MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification> {

	/**
	 * Instantiates a new outbreak identification observation.
	 */
	public OutbreakIdentificationObservation() {
		super(LABFactory.eINSTANCE.createOutbreakIdentification().init());
	}

	/**
	 * Instantiates a new outbreak identification observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public OutbreakIdentificationObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification mdht) {
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
	 *            the new comment entry
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