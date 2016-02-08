package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.LaboratorySpecialtySection;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class CdaChLrph extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChLrph> {

	/**
	 * Instantiates a new cda ch mtps dis.
	 */
	public CdaChLrph(Code code) {
		this(code, LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch lrph.
	 *
	 * @param languageCode
	 *          the language code
	 */
	public CdaChLrph(Code code, LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChLrph().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case FRENCH:
			setTitle("Rapport de laboratoire");
			break;
		case GERMAN:
			this.setTitle("Laborbefund");
			break;
		case ITALIAN:
			setTitle("Rapporto di laboratorio");
			break;
		case ENGLISH:
			setTitle("Laboratory Specialty Section");
			break;
		}
		LaboratorySpecialtySection specialtySection = new LaboratorySpecialtySection(code,
				languageCode);
		this.getDoc().addSection(specialtySection.getMdht());
	}

	/**
	 * Instantiates a new cda ch mtps dis.
	 *
	 * @param doc
	 *          mdht model document
	 */
	public CdaChLrph(org.openhealthtools.mdht.uml.cda.ch.CdaChLrph doc) {
		super(doc);
	}

	/**
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	public List<LaboratorySpecialtySection> getLaboratorySpecialtySection() {
		return null;
	}
}
