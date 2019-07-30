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

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

/**
 * The Class CodedVitalSigns. The vital signs section contains coded measurement
 * results of a patient’s vital signs.
 *
 */
public class CodedVitalSigns
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection> {

	/**
	 * Instantiates a new coded vital signs.
	 */
	public CodedVitalSigns() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new coded vital signs.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public CodedVitalSigns(CodedVitalSignsSection mdht) {
		super(mdht);
	}

	/**
	 * Instantiates a new coded vital signs.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public CodedVitalSigns(LanguageCode languageCode) {
		super(IHEFactory.eINSTANCE.createCodedVitalSignsSection().init());

		switch (languageCode) {
		case FRENCH:
			setTitle("Signes vitaux codés");
			break;
		case GERMAN:
			this.setTitle("Codierte Vitalzeichenliste");
			break;
		case ITALIAN:
			setTitle("Elenco codificato dei segni vitali");
			break;
		case ENGLISH:
			setTitle("Coded Vital Signs");
			break;
		}
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		return new Code(getMdht().getCode());
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		if (this.getMdht().getTitle() != null) {
			return this.getMdht().getTitle().getText();
		}
		return null;
	}

	/**
	 * Gets the vital sign organizer.
	 *
	 * @return the vital sign organizer
	 */
	public VitalSignsOrganizer getVitalSignOrganizer() {
		return null;

	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		getMdht().setCode(code.getCE());
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		getMdht().setTitle(Util.st(title));
	}

	/**
	 * Sets the vital sign organizer.
	 *
	 * @param organizer
	 *            the new vital sign organizer
	 */
	public void setVitalSignOrganizer(VitalSignsOrganizer organizer) {
		getMdht().getVitalSignsOrganizers().add(organizer.copy());
	}

}
