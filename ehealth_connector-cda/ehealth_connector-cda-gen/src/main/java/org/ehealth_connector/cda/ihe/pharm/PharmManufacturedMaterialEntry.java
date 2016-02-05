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
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Implements the IHE PharmManufacturedMaterialEntry.
 */
public class PharmManufacturedMaterialEntry extends
		MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmManufacturedMaterialEntry> {

	/**
	 * Instantiates a new pharm manufactured product entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public PharmManufacturedMaterialEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmManufacturedMaterialEntry().init());
	}

	/**
	 * Instantiates a new pharm manufactured product entry.
	 */
	public PharmManufacturedMaterialEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new pharm manufactured product entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public PharmManufacturedMaterialEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmManufacturedMaterialEntry mdht) {
		super(mdht);
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		final EN en = DatatypesFactory.eINSTANCE.createEN();
		en.addText(name);
		this.getMdht().setName(en);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		if (this.getMdht().getName() != null) {
			return this.getMdht().getName().getText();
		}
		return null;
	}

	public Code getWhoAtcCode() {
		if (this.getMdht().getCode() != null && this.getMdht().getCode().getCodeSystem() != null) {
			if (this.getMdht().getCode().getCodeSystem()
					.equals(CodeSystems.WHOATCCode.getCodeSystemId())) {
				return new Code(getMdht().getCode());
			}
		}
		return null;
	}

	public String getLotNr() {
		if ((this.getMdht().getLotNumberText() != null)) {
			return this.getMdht().getLotNumberText().getText();
		}
		return null;
	}

	/**
	 * Sets the who atc code (Use CodeSystem.WHOATCCode)
	 * 
	 * @param whoAtcCode
	 *            das WHOATcCode Objekt welches gesetzt wird
	 */
	public void setWhoAtcCode(Code whoAtcCode) {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		if (whoAtcCode != null) {
			ce = whoAtcCode.getCE();
		} else {
			ce.setNullFlavor(NullFlavor.UNK);
		}
		this.getMdht().setCode(ce);
	}

	public void setLotNr(String text) {
		this.getMdht().setLotNumberText(Util.st(text));
	}
	
	/**
	 * Sets the form code.
	 *
	 * @param formCode the new form code
	 */
//	public void setFormCode(Code formCode) {
//		CE ce = DatatypesFactory.eINSTANCE.createCE();
//		if (formCode != null) {
//			ce = formCode.getCE();
//		} else {
//			ce.setNullFlavor(NullFlavor.UNK);
//		}
//		this.getMdht().setFormCode(ce);;
//	}
//
//	
	

}
