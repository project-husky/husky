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
package org.ehealth_connector.cda.ch.lab.lrph;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class OutbreakIdentificationObservation.
 *
 * * <div class="en">This element will be added, according to [Melde-Verordnung
 * EDI].</div> <div class="de">Dieses Element wird dann angegeben, wenn gemäss
 * [Melde-Verordnung EDI] Beobachtungen über dem für den betreffenden Zeitpunkt
 * und Ort zu erwartenden Niveau festgestellt werden, die sonst nicht innerhalb
 * von 24 Stunden oder gar nicht gemeldet werden müssen. </div>
 */
public class OutbreakIdentificationObservation
		extends org.ehealth_connector.cda.ihe.lab.OutbreakIdentificationObservation {

	/**
	 * Instantiates a new outbreak identification observation.
	 */
	public OutbreakIdentificationObservation() {
		super();
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.NA);
		getMdht().getValues().add(ce);
	}

	/**
	 * Instantiates a new outbreak identification observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public OutbreakIdentificationObservation(OutbreakIdentification mdht) {
		super(mdht);
	}

	/**
	 * Instantiates a new outbreak identification observation.
	 *
	 * @param comment
	 *            the comment
	 */
	// Required Elements
	public OutbreakIdentificationObservation(SectionAnnotationCommentEntry comment) {
		this();
		setCommentEntry(comment);
	}

	/**
	 * Gets the comment entry.
	 *
	 * @return the comment entry
	 */
	@Override
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
	@Override
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
