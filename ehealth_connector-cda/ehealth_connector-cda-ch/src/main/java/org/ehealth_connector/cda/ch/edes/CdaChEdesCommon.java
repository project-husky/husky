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

package org.ehealth_connector.cda.ch.edes;

import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.textbuilder.SimpleTextBuilder;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;

public class CdaChEdesCommon {

	private static final String DOCTITLE_EN = "Emergency Department Encounter Summary";

	private static final String DOCTITLE_GER = "Notfallaustrittsbericht";
	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1.3.1.1";

	private ClinicalDocument document;

	public CdaChEdesCommon(ClinicalDocument document) {
		this.document = document;
	}

	public void addSection(Section section) {
		SectionsEDES sectionEnum = SectionsEDES.getEnum(section);
		if (document.getLanguageCode() != null) {
			section.setTitle(Util.st(sectionEnum.getSectionTitle(LanguageCode.getEnum(document
					.getLanguageCode().getCode()))));
		}
		document.addSection(section);
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
}
