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
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

/**
 * Implements the IHE PharmManufacturedProductEntry.
 */
public class PharmManufacturedProductEntry extends
		MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmManufacturedProductEntry> {

	/**
	 * Instantiates a new pharm manufactured product entry.
	 */
	public PharmManufacturedProductEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new pharm manufactured product entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public PharmManufacturedProductEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmManufacturedProductEntry().init());
	}

	/**
	 * Instantiates a new pharm manufactured product entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public PharmManufacturedProductEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmManufacturedProductEntry mdht) {
		super(mdht);
	}

}
