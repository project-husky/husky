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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.cda.elga.utils.NamespaceUtils;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040Precondition;
import org.husky.common.hl7cdar2.StrucDocContent;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;

public class ImmunizationBaseTextGenerator extends BaseTextGenerator {

	protected StrucDocTr getRowScheme(POCDMT000040Precondition precondition, int index) {
		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getCellTd("Impfschema:"));
		if (precondition != null && precondition.getCriterion() != null) {
			String contentId = String.format("criterion-%d", index);

			if (precondition.getCriterion().getText() != null
					&& precondition.getCriterion().getText().getReference() != null
					&& precondition.getCriterion().getText().getReference().getValue() != null) {
				contentId = precondition.getCriterion().getText().getReference().getValue().replace("#", "");
			}

			if (precondition.getCriterion().getCode() != null) {
				tr.getThOrTd()
						.add(getCellTdWithContent(precondition.getCriterion().getCode().getDisplayName(), contentId));
			}
		}

		return tr;
	}

	protected List<StrucDocTr> getRowTargetDiseases(List<POCDMT000040EntryRelationship> entryRelationships) {
		List<StrucDocTr> list = new LinkedList<>();

		for (POCDMT000040EntryRelationship entryRel : entryRelationships) {
			if (entryRel != null && entryRel.getObservation() != null
					&& entryRel.getTypeCode().equals(XActRelationshipEntryRelationship.RSON)
					&& entryRel.getObservation().getCode() != null) {
				StrucDocTr tr = new StrucDocTr();
				StrucDocTd td = new StrucDocTd();
				td.getStyleCode().add("xELGA_colw:20");
				td.getContent().add("Impfung gegen:");
				tr.getThOrTd().add(td);

				String contentId = "";

				if (entryRel.getObservation().getText() != null
						&& entryRel.getObservation().getText().getReference() != null
						&& entryRel.getObservation().getText().getReference().getValue() != null) {
					contentId = entryRel.getObservation().getText().getReference().getValue().replace("#", "");
				}

				tr.getThOrTd()
						.add(getCellTdWithContent(entryRel.getObservation().getCode().getDisplayName(), contentId));

				list.add(tr);
			}
		}

		return list;
	}

	protected StrucDocTr getRowDose(POCDMT000040Precondition precondition) {
		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getCellTd("Dosis:"));
		if (precondition != null && precondition.getCriterion() != null
				&& precondition.getCriterion().getValue() instanceof CD code) {
			tr.getThOrTd().add(getCellTd(code.getDisplayName()));
		}

		return tr;
	}

	protected void addCommentContent(StrucDocText text, POCDMT000040Entry entry, Map<String, String> comments) {
		for (POCDMT000040EntryRelationship entryRel : entry.getSubstanceAdministration().getEntryRelationship()) {
			if (entryRel != null && entryRel.getAct() != null) {
				var commentReference = "";
				if (entryRel.getAct().getText() != null && entryRel.getAct().getText().getReference() != null) {
					commentReference = entryRel.getAct().getText().getReference().getValue();
				}

				if (entryRel.getObservation().getEntryRelationship() != null
						&& !entryRel.getObservation().getEntryRelationship().isEmpty()) {
					for (POCDMT000040EntryRelationship entryRelComment : entryRel.getObservation()
							.getEntryRelationship()) {
						if (entryRelComment != null && entryRelComment.getAct() != null
								&& entryRelComment.getAct().getText() != null
								&& entryRelComment.getAct().getText().getReference() != null
								&& entryRelComment.getAct().getText().getReference().getValue() != null) {
							text.getContent().add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "content"),
									StrucDocContent.class, getCommentContent(comments, commentReference)));
						}
					}
				}

			}
		}
	}

	private StrucDocContent getCommentContent(Map<String, String> comments, String commentReference) {
		StrucDocContent content = new StrucDocContent();

		String commentToAdd = "";
		if (comments.containsKey(commentReference)) {
			commentToAdd = comments.get(commentReference);
		}

		content.getContent().add(commentToAdd);
		content.setID(commentReference.replace("#", ""));

		return content;
	}
}
