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
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch.textbuilder;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.AbstractAllergyConcern;
import org.ehealth_connector.cda.AbstractAllergyProblem;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.cda.enums.ContentIdPrefix;
import org.ehealth_connector.cda.textbuilder.AllergyConcernTextBuilder;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;

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
	 *          a list of problem concerns
	 * @param section
	 *          the section
	 */
	public AllergyConcernChTextBuilder(List<AllergyConcern> problemConcerns,
			ContentIdPrefix section) {
		super(toAbstracAllergyConcernList(problemConcerns), section);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.textbuilder.AllergyConcernTextBuilder#addRow(org.ehealth_connector.cda.AbstractAllergyConcern,
	 *      int)
	 */
	@Override
	protected void addRow(AbstractAllergyConcern allergyConcern, int i) {
		append("<tr>");
		addCell("Komplikationsrisiko");
		if (allergyConcern.getConcern() != null) {
			addCellWithContent(allergyConcern.getConcern(), getContentIdPrefix(), i);
		} else {
			addCell("");
		}
		if (allergyConcern.getAllergyProblems() == null) {
			addCell("");
		} else {
			// Create a string with more than one reference
			String cellStr = "<td>";
			int j = 0;
			boolean minOneComment = false;
			for (final AbstractAllergyProblem ap : allergyConcern.getAllergyProblems()) {
				if (ap.getMdhtAllergyProblem().getEntryRelationships() != null) {
					for (final EntryRelationship er : ap.getMdhtAllergyProblem().getEntryRelationships()) {
						if (Util.isComment(er)) {
							j++;
							minOneComment = true;
							cellStr = cellStr
									+ ("<content ID='" + SectionsVACD.ALLERGIES_REACTIONS.getContentIdPrefix()
											+ "-comment" + i + j + "'>");
							cellStr = cellStr + (ap.getCommentText());
							cellStr = cellStr + ("</content>");
						}
					}
				}
			}
			if (minOneComment) {
				cellStr = cellStr + "</td>";
				append(cellStr);
			}
		}
		append("</tr>");
	}
}
