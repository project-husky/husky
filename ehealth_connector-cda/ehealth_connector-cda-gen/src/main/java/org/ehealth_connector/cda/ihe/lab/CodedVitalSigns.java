package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

public class CodedVitalSigns
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection> {

	protected CodedVitalSigns() {
		this(LanguageCode.ENGLISH);
	}

	protected CodedVitalSigns(CodedVitalSignsSection mdht) {
		super(mdht);
	}

	protected CodedVitalSigns(LanguageCode languageCode) {
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

	public Code getCode() {
		return new Code(getMdht().getCode());
	}

	public String getTitle() {
		if (this.getMdht().getTitle() != null) {
			return this.getMdht().getTitle().getText();
		}
		return null;
	}

	public VitalSignsOrganizer getVitalSignOrganizer() {
		return null;

	}

	public void setCode(Code code) {
		getMdht().setCode(code.getCE());
	}

	public void setTitle(String title) {
		getMdht().setTitle(Util.st(title));
	}

	public void setVitalSignOrganizer(VitalSignsOrganizer organizer) {
		getMdht().getVitalSignsOrganizers().add(organizer.copy());
	}

}
