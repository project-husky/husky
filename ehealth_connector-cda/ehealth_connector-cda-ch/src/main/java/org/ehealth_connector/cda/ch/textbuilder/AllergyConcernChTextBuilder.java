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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.AbstractAllergyConcern;
import org.ehealth_connector.cda.AbstractAllergyProblem;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.enums.ContentIdPrefix;
import org.ehealth_connector.cda.textbuilder.AllergyConcernTextBuilder;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * Builds the &lt;text&gt; part of the Immunization recommendations.
 *
 * Always builds the whole part (not only adds one immunization recommendation).
 *
 */
public class AllergyConcernChTextBuilder extends AllergyConcernTextBuilder {

	private static List<AbstractAllergyConcern> toAbstracAllergyConcernList(
			List<AllergyConcern> allergyProblemConcerns) {
		final List<AbstractAllergyConcern> retVal = new ArrayList<>();
		retVal.addAll(allergyProblemConcerns);
		return retVal;
	}

	/**
	 * Constructor.
	 *
	 * @param problemConcerns
	 *            a list of problem concerns
	 * @param section
	 *            the section
	 */
	public AllergyConcernChTextBuilder(List<AllergyConcern> problemConcerns,
			ContentIdPrefix section) {
		super(toAbstracAllergyConcernList(problemConcerns), section);
	}

	@Override
	protected void addHeader() {
		// Currently only German available. Translation contributions are
		// welcome
		append("<thead>");
		append("<tr>");
		append("<th>Bereich</th>");
		append("<th>Allergie</th>");
		append("<th>Von</th>");
		append("<th>Bis</th>");
		append("<th>Kommentar</th>");
		append("</tr>");
		append("</thead>");
	}

	@Override
	protected void addRow(AbstractAllergyConcern allergyConcern, int i) {
		// Currently only German available. Translation contributions are
		// welcome
		int j = 0;
		String contentPrefix = getContentIdPrefix() + i;
		for (AbstractAllergyProblem problem : allergyConcern.getAllergyProblems()) {
			j++;
			append("<tr>");
			if (j == 1)
				addCell(allergyConcern.getConcern());
			else
				addCell("");

			Value val = problem.getValue();
			if (val != null)
				addCellWithContent(val.toString(), contentPrefix, i);
			else
				addCell("");

			addCell(DateUtil.formatDateCH(problem.getStartDate()));
			addCell(DateUtil.formatDateCH(problem.getEndDate()));

			String commentText = problem.getCommentText();
			if (commentText != null)
				addCellWithContent(commentText, contentPrefix + "-comment", i);
			else
				addCell("");
			append("</tr>");
		}
	}
}
