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
import org.openhealthtools.mdht.uml.cda.ihe.PatientMedicalInstructions;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * Implements the IHE PatientMedicalInstructionsEntry.
 */
public class PatientMedicalInstructionsEntry extends MdhtEntryActFacade<PatientMedicalInstructions> {
	
	/**
	 * Instantiates a new patient medical instructions entry.
	 *
	 * @param languageCode the language code
	 */
	public PatientMedicalInstructionsEntry(LanguageCode languageCode) {
		super(IHEFactory.eINSTANCE.createPatientMedicalInstructions().init());
		final CS statusCodeCompleted = DatatypesFactory.eINSTANCE.createCS();
		statusCodeCompleted.setCode("completed");
		this.getMdht().setStatusCode(statusCodeCompleted);
	}
	
	/**
	 * Instantiates a new patient medical instructions entry.
	 */
	public PatientMedicalInstructionsEntry() {
		this(LanguageCode.ENGLISH);
	}


	/**
	 * Instantiates a new patient medical instructions entry.
	 *
	 * @param mdht the mdht
	 */
	public PatientMedicalInstructionsEntry(PatientMedicalInstructions mdht) {
		super(mdht);
	}


}
