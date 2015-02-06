package org.ehc.cda;

import java.util.ArrayList;
import java.util.List;

import org.ehc.common.Util;
import org.ehc.common.ch.SectionsVACD;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Observation;

/**
 * Builds the <text> part of the Treatment plan section.
 * 
 * Always builds the whole part (not only adds one recommendation).
 * 
 * @author gsc, ahelmer
 */
public class ProblemConcernTextBuilder extends TextBuilder {

	private List<ActiveProblemConcern> problemConcernEntries;
	private ActiveProblemConcern newProblemConcernEntry;
	private String sectionText;
	private int newId;
	protected final static String tableStub = "<table border=\"1\" width=\"100%\"><thead><tr><th>Risikokategorie</th><th>Risikofaktor</th></tr></thead><tbody>";

	public ProblemConcernTextBuilder(
			ArrayList<ActiveProblemConcern> problemConcernEntries,
			ActiveProblemConcern newProblemConcernEntry, String sectionText) {
		this.problemConcernEntries = problemConcernEntries;
		this.newProblemConcernEntry = newProblemConcernEntry;
		this.sectionText = sectionText;
		init();
	}

	public void init() {
		// ID
		if (problemConcernEntries.size() != 0) {
			this.newId = problemConcernEntries.size() + 1;
			if (sectionText.equals("") || sectionText == null)
				try {
					throw new Exception(
							"If there is more than zero elements, the sectionText can´t be empty.");
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else {
			this.newId = 1;
			this.sectionText = tableStub + tableFooter;
		}

		this.sectionText = insertRow(newProblemConcernEntry, newId,
				this.sectionText);
	}

	public String insertRow(ActiveProblemConcern newProblemConcernEntry2, int newId,
			String sectionText) {
		String rowStr = buildRow(newProblemConcernEntry2, newId);
		// TODO If there is no element found that could be replaced, then an
		// error occured (e.g. in a scenario, where an external document is
		// loaded where the table footer does not match this table footer. If
		// the convenience API is used to add a ProblemConcern then this method
		// would not find the specific text.
		// - In this case: Generate a new (convennience API conformant) set of
		// ids, update the text and the objects. For this purpose the other
		// methods of this and the super class could be useful.
		String tableStr = sectionText
				.replace(tableFooter, rowStr + tableFooter);
		return tableStr;
	}

	private String buildRow(ActiveProblemConcern newProblemConcernEntry2, int newId) {
		StringBuilder rowBuilder = new StringBuilder();
		rowBuilder.append("<tr>");
		rowBuilder.append(buildCell("Komplikationsrisiko"));
		rowBuilder
				.append(buildCellWithContent(
						newProblemConcernEntry2.getConcern(), newId,
						SectionsVACD.ACTIVE_PROBLEMS.getContentIdPrefix()));
		rowBuilder.append("</tr>");
		return rowBuilder.toString();
	}

	public ActiveProblemConcern getProblemConcernEntry() {
		return this.newProblemConcernEntry;
	}

	public String getSectionText() {
		return this.sectionText;
	}

	//
	// /**
	// * Returns HTML formatted string.
	// *
	// * @see java.lang.Object#toString()
	// */
	// public String toString() {
	// return super.toString();
	// }
	//
	// public String buildCompleteText() {
	// // tableHeader = new String[]
	// //
	// {"Impfstoff Handelsname","Hersteller","Lot-Nr","Datum","Impfung gegen","Impfung erfolgt durch"};
	// // Header
	// tableHeader = new String[] { "Risikokategorie", "Risikofaktor" };
	// // Body
	// tableBody = new String[problemConcernEntries.size()][2];
	// for (int i = 0; i < problemConcernEntries.size(); i++) {
	// tableBody[i][0] = "Komplikationsrisiko";
	// tableBody[i][1] = problemConcernEntries.get(i).getProblemConcern();
	// }
	// // References
	// referenceBodyCell = new Boolean[] { false, true };
	//
	// // Build the Complete Text for all ProblemConcernEntries
	// super.build(tableHeader, tableBody, referenceBodyCell);
	// return super.toString();
	// }

}
