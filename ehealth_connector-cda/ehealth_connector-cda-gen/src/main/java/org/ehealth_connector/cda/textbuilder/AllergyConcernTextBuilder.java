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

import org.ehealth_connector.cda.AbstractAllergyConcern;
import org.ehealth_connector.cda.enums.ContentIdPrefix;

/**
 * Builds the &lt;text&gt; part of the Immunization recommendations.
 *
 * Always builds the whole part (not only adds one immunization recommendation).
 *
 */
public abstract class AllergyConcernTextBuilder extends TextBuilder {

	private List<org.ehealth_connector.cda.AbstractAllergyConcern> problemConcerns;
	private String contentIdPrefix;

	/**
	 * Constructor.
	 *
	 * @param problemConcerns
	 *            a list of problem concerns
	 * @param section
	 *            the section
	 */
	public AllergyConcernTextBuilder(List<AbstractAllergyConcern> problemConcerns,
			ContentIdPrefix section) {
		this.problemConcerns = problemConcerns;
		contentIdPrefix = section.getContentIdPrefix();
	}

	private void addBody() {
		append("<tbody>");
		int i = 1;
		for (final org.ehealth_connector.cda.AbstractAllergyConcern problemConcern : problemConcerns) {
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
	 * @param allergyConcern
	 *            the allergy concern to be displayed in the narrative text
	 * @param i
	 *            the row index (used for the creation of the content id
	 *            elements; make sure you do not use duplicate indexes other
	 *            wise the CDA xml will become invalid!)
	 */
	protected abstract void addRow(AbstractAllergyConcern allergyConcern, int i);

	/**
	 * Method to get
	 *
	 * @return the contentIdPrefix
	 */
	public String getContentIdPrefix() {
		return contentIdPrefix;
	}

	/**
	 * Method to get
	 *
	 * @return the problemConcerns
	 */
	public List<org.ehealth_connector.cda.AbstractAllergyConcern> getProblemConcerns() {
		return problemConcerns;
	}

	/**
	 * Method to set
	 *
	 * @param contentIdPrefix
	 *            the contentIdPrefix to set
	 */
	public void setContentIdPrefix(String contentIdPrefix) {
		this.contentIdPrefix = contentIdPrefix;
	}

	/**
	 * Method to set
	 *
	 * @param problemConcerns
	 *            the problemConcerns to set
	 */
	public void setProblemConcerns(
			List<org.ehealth_connector.cda.AbstractAllergyConcern> problemConcerns) {
		this.problemConcerns = problemConcerns;
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
