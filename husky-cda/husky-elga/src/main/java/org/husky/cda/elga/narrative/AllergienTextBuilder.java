/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.narrative;

import java.util.List;

import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.StrucDocTh;
import org.husky.common.hl7cdar2.StrucDocThead;
import org.husky.common.hl7cdar2.StrucDocTr;

public class AllergienTextBuilder {

	private List<POCDMT000040Entry> allergies;

	/**
	 * Constructor.
	 *
	 * @param problemConcerns a list of problem concerns
	 * @param section         the section
	 */
	public AllergienTextBuilder(List<POCDMT000040Entry> entries) {
		this.allergies = entries;
	}

	private StrucDocThead getTableHeader() {
		StrucDocThead thead = new StrucDocThead();

		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getTableHeaderCell("Auslösende Substanz", "xELGA_colw:40"));
		tr.getThOrTd().add(getTableHeaderCell("Überempfindlichkeit", null));
		tr.getThOrTd().add(getTableHeaderCell("Zusatzinformationen", null));
		thead.getTr().add(tr);

		return thead;
	}

	private StrucDocTh getTableHeaderCell(String text, String styleCode) {
		StrucDocTh th = new StrucDocTh();
		if (styleCode != null) {
			th.getStyleCode().add(styleCode);
		}

		th.getContent().add(text);
		return th;
	}

	/*
	 * private StrucDocTable addBody() { StrucDocTable table = new StrucDocTable();
	 * 
	 * if (substanceAdministration.getText() != null &&
	 * substanceAdministration.getText().getReference() != null &&
	 * substanceAdministration.getText().getReference().getValue() != null) {
	 * table.setID(substanceAdministration.getText().getReference().getValue().
	 * replace("#", "")); } else { table.setID(String.format("sbdm-%d",
	 * idxImmunization)); }
	 * 
	 * StrucDocTbody body = new StrucDocTbody();
	 * 
	 * if (substanceAdministration.getPrecondition() != null) { for
	 * (POCDMT000040Precondition precondition :
	 * substanceAdministration.getPrecondition()) { if (precondition != null) {
	 * body.getTr().add(getRowDose(precondition));
	 * body.getTr().add(getRowScheme(precondition, idxImmunization)); } } }
	 * 
	 * if (substanceAdministration.getConsumable() != null) {
	 * body.getTr().add(getRowVaccine(substanceAdministration.getConsumable())); }
	 * 
	 * if (substanceAdministration.getEntryRelationship() != null) {
	 * body.getTr().addAll(getRowTargetDiseases(substanceAdministration.
	 * getEntryRelationship())); }
	 * 
	 * table.getTbody().add(body);
	 * 
	 * append("<tbody>"); int i = 1;
	 * 
	 * for (final Allergy allergy : allergies) { if (allergy != null) {
	 * addRow(allergy, i++); } } append("</tbody>"); }
	 * 
	 * protected StrucDocTr addRow(Code problem, int index) { StrucDocTr tr = new
	 * StrucDocTr();
	 * 
	 * if (problem.getAbsentAllergy() != null) { append("<tr ID=\"allergy" + index +
	 * "\">"); addCell(problem.getAbsentAllergy().getDisplayName());
	 * append("</tr>"); } else { if (problem.getAllergyAgent() != null) {
	 * append("<tr ID=\"alg" + index + "\">");
	 * addCell(problem.getAllergyAgent().getCode().getDisplayName());
	 * append("</tr>"); }
	 * 
	 * if (problem.getKindOfAllergy() != null) { append("<tr ID=\"typ" + index +
	 * "\">"); addCell(problem.getAllergyAgent().getCode().getDisplayName());
	 * append("</tr>"); }
	 * 
	 * append("<tr>"); addList(problem, index); append("</tr>");
	 * 
	 * } }
	 * 
	 * protected StrucDocList addList(POCDMT000040Observation problem, int index) {
	 * StrucDocList list = new StrucDocList();
	 * 
	 * if (problem.getEffectiveTime() != null) { append("<li>"); LocalDateTime date
	 * = LocalDateTime.ofInstant(problem.getStart().toInstant(),
	 * ZoneId.systemDefault()); append("bekannt seit " + date.getYear() + "-" +
	 * date.getMonthValue()); append("</li>"); }
	 * 
	 * if (problem.getInformant() != null) { append("<li>"); append("Informant: ");
	 * append(problem.getInformant().getName().getFullName()); append("</li>"); }
	 * 
	 * if (problem.getAuthor() != null && problem.getAuthor().getPractitioner() !=
	 * null) { for(Name name: problem.getAuthor().getPractitioner().getName()) {
	 * if(name != null) { append("<li"); append("Author: ");
	 * append(name.getFullName()); append("</li>"); } } }
	 * 
	 * if (problem.getReactions() != null && !problem.getReactions().isEmpty()) {
	 * append("<li>");
	 * 
	 * int reactionIndex = 1; for (AllergyReaction value : problem.getReactions()) {
	 * 
	 * if (value.getReaction() != null) { addContent("Reaktion: " +
	 * value.getReaction().getDisplayName(), "react" + index + "" + reactionIndex);
	 * }
	 * 
	 * if(value.getReaction() != null && value.getSeverity() != null) { append("(");
	 * addContent(value.getSeverity().getDisplayName(), "sev" + index + "" +
	 * reactionIndex); append(")"); }
	 * 
	 * reactionIndex++; }
	 * 
	 * append("</li>"); }
	 * 
	 * if (problem.getCriticality() != null) { append("<li ID='crit" + index +
	 * "'>"); append(problem.getCriticality().getDisplayName()); append("</li>"); }
	 * 
	 * if (problem.getVerificationState() != null) { append("<li ID='cert" + index +
	 * "'>"); append("Diagnosesicherheit: " +
	 * problem.getVerificationState().getDisplayName()); append("</li>"); }
	 * 
	 * if (problem.getClinicalState() != null) { append("<li ID='status" + index +
	 * "'>"); append("klinischer Status: " +
	 * problem.getClinicalState().getDisplayName()); append("</li>"); }
	 * 
	 * return list; }
	 */


}
