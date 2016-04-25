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

import org.ehealth_connector.cda.ch.ProblemConcern;
import org.ehealth_connector.cda.ch.edes.enums.SectionsEDES;
import org.ehealth_connector.cda.textbuilder.TextBuilder;

/**
 * Builds the &lt; text &gt; part of the Treatment plan section.
 *
 * Always builds the whole part (not only adds one recommendation).
 *
 */
public class EdDiagnosisChTextBuilder extends TextBuilder {

	protected final static String tableStub = "<table border=\"1\" width=\"100%\"><thead><tr><th>TODO tsc</th><th>TODO tsc</th></tr></thead><tbody>";
	private final List<ProblemConcern> problemConcernEntries;
	private final ProblemConcern newProblemConcernEntry;
	private String sectionText;
	private int newId;

	public EdDiagnosisChTextBuilder(List<ProblemConcern> problemConcernEntries,
			ProblemConcern newProblemConcernEntry, String sectionText) {
		this.problemConcernEntries = problemConcernEntries;
		this.newProblemConcernEntry = newProblemConcernEntry;
		this.sectionText = sectionText;
		init();
	}

	protected String buildRow(ProblemConcern newProblemConcernEntry2, int newId) {
		final StringBuilder rowBuilder = new StringBuilder();
		rowBuilder.append("<tr>");
		rowBuilder.append(buildCell("TODO tsc"));
		rowBuilder.append(buildCellWithContent(newProblemConcernEntry2.getConcern(), newId,
				SectionsEDES.ED_DIAGNOSIS.getContentIdPrefix()));
		rowBuilder.append("</tr>");
		return rowBuilder.toString();
	}

	public ProblemConcern getProblemConcernEntry() {
		return newProblemConcernEntry;
	}

	public String getSectionText() {
		return sectionText;
	}

	public void init() {
		// ID
		if (problemConcernEntries.size() != 0) {
			newId = problemConcernEntries.size() + 1;
			if ("".equals(sectionText) || (sectionText == null))
				try {
					throw new Exception(
							"If there is more than zero elements, the sectionText can´t be empty.");
				} catch (final Exception e) {
					e.printStackTrace();
				}
		} else {
			newId = 1;
			sectionText = tableStub + tableFooter;
		}

		sectionText = insertRow(newProblemConcernEntry, newId, sectionText);
	}

	public String insertRow(ProblemConcern newProblemConcernEntry2, int newId, String sectionText) {
		final String rowStr = buildRow(newProblemConcernEntry2, newId);
		// If there is no element found that could be replaced, then an
		// error occured (e.g. in a scenario, where an external document is
		// loaded where the table footer does not match this table footer. If
		// the convenience API is used to add a ProblemConcern then this method
		// would not find the specific text.
		// - In this case: Generate a new (convennience API conformant) set of
		// ids, update the text and the objects. For this purpose the other
		// methods of this and the super class could be useful.
		final String tableStr = sectionText.replace(tableFooter, rowStr + tableFooter);
		return tableStr;
	}

}
