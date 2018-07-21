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

package org.ehealth_connector.cda.textbuilder;

import java.util.List;

import org.ehealth_connector.cda.BaseProblemConcern;
import org.ehealth_connector.cda.enums.ContentIdPrefix;

/**
 * Builds the &lt;text&gt; part of the Immunization recommendations.
 *
 * Always builds the whole part (not only adds one immunization recommendation).
 *
 */
public abstract class ProblemConcernEntryTextBuilder extends TextBuilder {

	private final List<org.ehealth_connector.cda.BaseProblemConcern> problemConcerns;

	/**
	 * Constructor.
	 *
	 * @param problemConcerns
	 *            a list of Problem Concerns
	 * @param section
	 *            the section
	 */
	public ProblemConcernEntryTextBuilder(List<BaseProblemConcern> problemConcerns,
			ContentIdPrefix section) {
		this.problemConcerns = problemConcerns;
	}

	private void addBody() {
		append("<tbody>");
		int i = 1;
		for (final org.ehealth_connector.cda.BaseProblemConcern problemConcern : problemConcerns) {
			addRow(problemConcern, i++);
		}
		append("</tbody>");
	}

	/**
	 * adds the header line of the table in the narrative text
	 */
	protected abstract void addHeader();

	/**
	 * adds one table row in the narrative text
	 *
	 * @param problemConcern
	 *            the problem concern to be displayed in the narrative text
	 * @param i
	 *            the row index (used for the creation of the content id
	 *            elements; make sure you do not use duplicate indexes other
	 *            wise the CDA xml will become invalid!)
	 */
	protected abstract void addRow(org.ehealth_connector.cda.BaseProblemConcern problemConcern,
			int i);

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
