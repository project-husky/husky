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

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtEntryActFacade;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.MedicationFullfillmentInstructions;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;

/**
 * Implements the IHE MedicationFullfillmentInstructionsEntry.
 */
public class MedicationFullfillmentInstructionsEntry
		extends MdhtEntryActFacade<MedicationFullfillmentInstructions> {

	/**
	 * Instantiates a new medication fullfillment instructions entry.
	 */
	public MedicationFullfillmentInstructionsEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new medication fullfillment instructions entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public MedicationFullfillmentInstructionsEntry(LanguageCode languageCode) {
		super(IHEFactory.eINSTANCE.createMedicationFullfillmentInstructions().init());
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("completed");
		this.getMdht().setStatusCode(statusCodeCompleted);
		this.getMdht().setClassCode(x_ActClassDocumentEntryAct.ACT);
		this.getMdht().setMoodCode(x_DocumentActMood.INT);
		final CD piCode = DatatypesFactory.eINSTANCE.createCD();
		piCode.setCode("FINSTRUCT");
		piCode.setCodeSystem("1.3.6.1.4.1.19376.1.5.3.2");
		piCode.setCodeSystemName("IHEActCode");
		this.getMdht().setCode(piCode);
	}

	/**
	 * Instantiates a new medication fullfillment instructions entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public MedicationFullfillmentInstructionsEntry(MedicationFullfillmentInstructions mdht) {
		super(mdht);
	}

}
