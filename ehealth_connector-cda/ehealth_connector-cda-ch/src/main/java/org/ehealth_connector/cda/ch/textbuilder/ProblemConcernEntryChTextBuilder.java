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

import java.util.List;

import org.ehealth_connector.cda.AbstractProblemConcern;
import org.ehealth_connector.cda.AbstractProblemEntry;
import org.ehealth_connector.cda.enums.ContentIdPrefix;
import org.ehealth_connector.cda.textbuilder.TextBuilder;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * Builds the &lt;text&gt; part of the Immunization recommendations.
 *
 * Always builds the whole part (not only adds one immunization recommendation).
 *
 */
public class ProblemConcernEntryChTextBuilder extends TextBuilder {

	private final List<org.ehealth_connector.cda.AbstractProblemConcern> problemConcerns;
	private final String contentIdPrefix;

	/**
	 * Constructor.
	 *
	 * @param problemConcerns
	 *            a list of Problem Concerns
	 * @param section
	 *            the section
	 */
	public ProblemConcernEntryChTextBuilder(List<AbstractProblemConcern> problemConcerns,
			ContentIdPrefix section) {
		this.problemConcerns = problemConcerns;
		contentIdPrefix = section.getContentIdPrefix();
	}

	private void addBody() {
		append("<tbody>");
		int i = 0;
		for (final org.ehealth_connector.cda.AbstractProblemConcern problemConcern : problemConcerns) {
			addRow(problemConcern, i);
			i++;
		}
		append("</tbody>");
	}

	private void addHeader() {
		// Currently only German available. Translation contributions are
		// welcome
		append("<thead>");
		append("<tr>");
		append("<th>Bereich</th>");
		append("<th>Leiden</th>");
		append("<th>Von</th>");
		append("<th>Bis</th>");
		append("</tr>");
		append("</thead>");
	}

	private void addRow(org.ehealth_connector.cda.AbstractProblemConcern problemConcerns,
			int index) {
		// Currently only German available. Translation contributions are
		// welcome
		int i = 0;
		for (AbstractProblemEntry problem : problemConcerns.getProblemEntries()) {
			append("<tr>");
			if (i == 0 && problemConcerns.getConcern() != null) {
				addCell(problemConcerns.getConcern());
			} else {
				addCell("");
			}

			Value val = problem.getValue();
			if (val != null)
				addCellWithContent(val.toString(), contentIdPrefix, index);
			else
				addCell("");

			addCell(DateUtil.formatDateCH(problem.getStartDate()));
			addCell(DateUtil.formatDateCH(problem.getEndDate()));

			append("</tr>");
			i++;
		}
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
