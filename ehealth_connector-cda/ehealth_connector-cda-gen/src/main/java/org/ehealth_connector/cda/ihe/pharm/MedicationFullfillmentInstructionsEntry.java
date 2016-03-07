/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtEntryActFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.MedicationFullfillmentInstructions;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

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
