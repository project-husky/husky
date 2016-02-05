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

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * Implements the IHE PharmSubstitutionHandlingEntry.
 */
public class PharmSubstitutionHandlingEntry extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmSubstitutionHandlingEntry> {

	/**
	 * Instantiates a new pharm substitution handling entry.
	 *
	 * @param languageCode the language code
	 */
	public PharmSubstitutionHandlingEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmSubstitutionHandlingEntry().init());
		this.getMdht().setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
	}

	/**
	 * Instantiates a new pharm substitution handling entry.
	 */
	public PharmSubstitutionHandlingEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new pharm substitution handling entry.
	 *
	 * @param mdht the mdht
	 */
	public PharmSubstitutionHandlingEntry(org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmSubstitutionHandlingEntry mdht) {
		super(mdht);
	}
	

}
