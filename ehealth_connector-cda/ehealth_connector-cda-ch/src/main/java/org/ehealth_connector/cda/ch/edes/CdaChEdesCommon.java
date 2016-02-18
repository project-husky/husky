package org.ehealth_connector.cda.ch.edes;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.textbuilder.SimpleTextBuilder;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;

public class CdaChEdesCommon {

	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1.3.1.1";

	private static final String DOCTITLE_GER = "Notfallaustrittsbericht";
	private static final String DOCTITLE_EN = "Emergency Department Encounter Summary";

	private ClinicalDocument document;

	public CdaChEdesCommon(ClinicalDocument document) {
		this.document = document;
	}

	public String getDocumentTitle() {
		CS lcode = document.getLanguageCode();
		if (lcode != null) {
			switch (lcode.getCode()) {
			case LanguageCode.GERMAN_CODE:
				return DOCTITLE_GER;
			case LanguageCode.FRENCH_CODE:
			case LanguageCode.ITALIAN_CODE:
			case LanguageCode.ENGLISH_CODE:
				return DOCTITLE_EN;
			}
		}
		return DOCTITLE_EN;
	}

	public String getNarrativeText(Section s) {
		if (s != null) {
			final StrucDocText t = s.getText();
			return Util.extractStringFromNonQuotedStrucDocText(t);
		}
		return null;
	}

	public void setNarrativeTextSection(SectionsEDES sectionEdes, Section section, String text) {
		if (section == null) {
			section = sectionEdes.createSection();
			addSection(section);
		}
		section.createStrucDocText(new SimpleTextBuilder(sectionEdes, text).toString());
	}

	public void addSection(Section section) {
		section.setLanguageCode(EcoreUtil.copy(document.getLanguageCode()));
		SectionsEDES sectionEnum = SectionsEDES.getEnum(section);
		section.setTitle(Util.st(sectionEnum.getSectionTitle(section.getLanguageCode())));
		document.addSection(section);
	}
}
