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

package org.ehealth_connector.cda.ch.textbuilder;

import java.util.List;

import org.ehealth_connector.cda.AbstractObservation;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.cda.textbuilder.TextBuilder;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.LanguageCode;

/**
 * Builds the &lt;text&gt; part of the observations.
 *
 */
public class ObservationChTextBuilder extends TextBuilder {

	private final List<AbstractObservation> laboratoryObservation;
	private final String contentIdPrefix;

	public ObservationChTextBuilder(List<AbstractObservation> list, SectionsEDES section) {
		laboratoryObservation = list;
		contentIdPrefix = section.getContentIdPrefix();
	}

	/**
	 * Constructor.
	 *
	 * @param list
	 *            a list of laboratory observations
	 * @param section
	 *            the section
	 */
	public ObservationChTextBuilder(List<AbstractObservation> list, SectionsVACD section) {
		laboratoryObservation = list;
		contentIdPrefix = section.getContentIdPrefix();
	}

	private void addBody() {
		append("<tbody>");
		int i = 1;
		for (final AbstractObservation item : laboratoryObservation) {
			addRow(item, i++);
		}
		append("</tbody>");
	}

	private void addHeader() {
		append("<thead>");
		append("<tr>");
		append("<th>Beobachtung</th>");
		append("<th>Resultat</th>");
		append("<th>Code</th>");
		append("<th>Codesystem</th>");
		append("<th>Kommentar</th>");
		append("</tr>");
		append("</thead>");
	}

	private void addRow(AbstractObservation observation, int i) {
		append("<tr>");
		// Beobachtung
		if (observation.getCode() != null) {
			// using display name just in case the language texts are missing...
			String value = "";
			if (observation.getLangTexts() != null)
				value = observation.getLangTexts().getText(LanguageCode.GERMAN);
			if (value.equals(""))
				value = observation.getCode().getDisplayName();
			if (value == null)
				value = "";

			ActSite actSite = observation.getTargetSite();
			if (actSite != null) {
				String actSiteString = actSite.getLangTexts().getText(LanguageCode.GERMAN);
				if (actSiteString.equals(""))
					actSiteString = actSite.getCode().getDisplayName();
				if (actSiteString == null)
					actSiteString = "";
				if (!value.equals(""))
					value += " (" + actSiteString + ")";
			}

			addCell(value);
		} else {
			addCell("");
		}

		// Resultat
		Value val = observation.getValue();
		if (val != null)
			addCellWithContent(val.toString(), contentIdPrefix, i);
		else
			addCell("");

		// Code & CodeSystem
		if (observation.getCode() != null) {
			if (observation.getCode().getCode() != null) {
				addCell(observation.getCode().getCode());
			} else {
				addCell("");
			}
			if (observation.getCode().getCodeSystem() != null) {
				String codeSystemName = observation.getCode().getCodeSystemName();
				if (codeSystemName == null)
					codeSystemName = observation.getCode().getCodeSystem();
				if (codeSystemName.equals("2.16.840.1.113883.6.1"))
					codeSystemName = "LOINC";
				if (codeSystemName.equals("2.16.840.1.113883.6.96"))
					codeSystemName = "SNOMED-CT";
				addCell(codeSystemName);
			} else {
				addCell("");
			}

		} else {
			addCell("");
			addCell("");
		}

		// Kommentar
		String commentText = observation.getCommentText();
		if (commentText == null)
			commentText = "";
		addCell(commentText);
		append("</tr>");
	}

	/**
	 * Returns HTML formatted string.
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		append("<table border='1' width='100%'>");
		addHeader();
		addBody();
		append("</table>");
		return super.toString();
	}
}
