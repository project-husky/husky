/*
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
package org.ehealth_connector.cda.ch.lab.lrep;

import java.util.Date;

import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Participant;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;

/**
 * The derived SpecimenCollectionEntry.This is just to add the Swiss
 * templpateIds and fix the display name.
 */
public class SpecimenCollectionEntry
		extends org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry {

	/**
	 * Instantiates a new specimen collection entry.
	 */
	public SpecimenCollectionEntry() {
		super();
		CdaUtil.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.11"));
		getMdht().getCode().setDisplayName("Collection date of Unspecified specimen");
	}

	/**
	 * Instantiates a new specimen collection entry.
	 *
	 * @param effectiveTime
	 *            the effective time
	 * @param id
	 *            the id
	 * @param textReference
	 *            the text reference
	 */
	public SpecimenCollectionEntry(Date effectiveTime, Identificator id, String textReference) {
		super(effectiveTime, id, textReference);
		CdaUtil.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.11"));
		getMdht().getCode().setDisplayName("Collection date of Unspecified specimen");
	}

	/**
	 * Instantiates a new specimen collection entry.
	 *
	 * @param effectiveTime
	 *            the effective time
	 * @param participant
	 *            the participant
	 * @param textReference
	 *            the text reference
	 */
	public SpecimenCollectionEntry(Date effectiveTime, Participant participant,
			String textReference) {
		super(effectiveTime, participant, textReference);
		CdaUtil.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.11"));
		getMdht().getCode().setDisplayName("Collection date of Unspecified specimen");
	}

	/**
	 * Instantiates a new specimen collection entry.
	 *
	 * @param id
	 *            the id
	 * @param textReference
	 *            the text reference
	 */
	public SpecimenCollectionEntry(Identificator id, String textReference) {
		super(id, textReference);
		CdaUtil.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.11"));
		getMdht().getCode().setDisplayName("Collection date of Unspecified specimen");
	}

	/**
	 * Instantiates a new specimen collection entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenCollectionEntry(SpecimenCollection mdht) {
		super(mdht);
	}

}
