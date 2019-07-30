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
