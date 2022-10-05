/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.narrative;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.ANY;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.POCDMT000040Act;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.hl7cdar2.StrucDocContent;
import org.projecthusky.common.hl7cdar2.StrucDocTable;
import org.projecthusky.common.hl7cdar2.StrucDocTbody;
import org.projecthusky.common.hl7cdar2.StrucDocTd;
import org.projecthusky.common.hl7cdar2.StrucDocTr;
import org.projecthusky.common.model.Code;

public class ImmunizationRelevantDiseasesNarrativeTextGenerator extends BaseTextGenerator {

	private List<POCDMT000040Entry> entries;

	/**
	 * Constructor.
	 *
	 * @param entries a list of entries
	 */
	public ImmunizationRelevantDiseasesNarrativeTextGenerator(List<POCDMT000040Entry> entries) {
		this.entries = entries;
	}

	private StrucDocTable getBody(POCDMT000040Act act, Map<String, String> comments) {
		var table = new StrucDocTable();
		var body = new StrucDocTbody();
		if (act != null) {
			for (POCDMT000040EntryRelationship entryRel : act.getEntryRelationship()) {
				if (entryRel != null && entryRel.getObservation() != null) {
					var td = new StrucDocTd();
					var diseaseCode = extractDiseaseCode(entryRel.getObservation());

					td.getContent().add(diseaseCode.getDisplayName());
					td.setID(diseaseCode.getOriginalText());

					var tr = new StrucDocTr();
					if (entryRel.getObservation().getText() != null
							&& entryRel.getObservation().getText().getReference() != null
							&& entryRel.getObservation().getText().getReference().getValue() != null) {
						tr.setID(entryRel.getObservation().getText().getReference().getValue().replace("#", ""));
					}

					tr.getThOrTd().add(getCellTdTime(entryRel.getObservation().getEffectiveTime()));
					tr.getThOrTd().add(td);
					tr.getThOrTd().add(
							getCellTdComment(comments, diseaseCode.getCode(),
									entryRel.getObservation().getEntryRelationship()));

					body.getTr().add(tr);
				}
			}
		}

		table.getTbody().add(body);

		return table;
	}

	private Code extractDiseaseCode(POCDMT000040Observation obs) {
		Code code = new Code();
		if (!obs.getValue().isEmpty()) {
			for (ANY value : obs.getValue()) {
				if (value instanceof CD cd) {
					code.setDisplayName(cd.getDisplayName());
					code.setCode(cd.getCode());

					if (cd.getOriginalText() != null && cd.getOriginalText().getReference() != null
							&& cd.getOriginalText().getReference().getValue() != null) {
						code.setOriginalText(cd.getOriginalText().getReference().getValue().replace("#", ""));
					}
				}
			}
		}

		return code;
	}

	private StrucDocTd getCellTdComment(Map<String, String> comments, String diseaseCode,
			List<POCDMT000040EntryRelationship> entryRel) {
		var tdComment = new StrucDocTd();

		StrucDocContent content = new StrucDocContent();

		String commentToAdd = "";
		if (comments.containsKey(diseaseCode)) {
			commentToAdd = comments.get(diseaseCode);
		}

		if (entryRel != null && !entryRel.isEmpty()) {
			for (POCDMT000040EntryRelationship entryRelComment : entryRel) {
				content.getContent().add(commentToAdd);
				if (entryRelComment != null && entryRelComment.getAct() != null
						&& entryRelComment.getAct().getText() != null
						&& entryRelComment.getAct().getText().getReference() != null
						&& entryRelComment.getAct().getText().getReference().getValue() != null) {
					content.setID(entryRelComment.getAct().getText().getReference().getValue().replace("#", ""));
					tdComment.getContent().add(
							new JAXBElement<>(new QName("urn:hl7-org:v3", "content"), StrucDocContent.class, content));
				}
			}
		}

		return tdComment;
	}

	public List<JAXBElement<StrucDocTable>> getTablesFromCda(Map<String, String> comments) {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();

		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getAct() != null) {
				tables.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "table"), StrucDocTable.class,
						getBody(entry.getAct(), comments)));
			}
		}

		return tables;
	}

}
