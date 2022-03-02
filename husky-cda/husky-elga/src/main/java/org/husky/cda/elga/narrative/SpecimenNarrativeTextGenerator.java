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

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.common.hl7cdar2.StrucDocTh;
import org.husky.common.hl7cdar2.StrucDocThead;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.model.Name;
import org.husky.common.utils.time.Hl7Dtm;

public class SpecimenNarrativeTextGenerator {

	private List<POCDMT000040Entry> entries;

	/**
	 * Constructor.
	 *
	 * @param entries a list of POCDMT000040Entry
	 */
	public SpecimenNarrativeTextGenerator(List<POCDMT000040Entry> entries) {
		this.entries = entries;
	}

	private StrucDocTbody getBody(List<POCDMT000040EntryRelationship> entries) {
		StrucDocTbody body = new StrucDocTbody();
		for (POCDMT000040EntryRelationship component : entries) {
			if (component != null && component.getProcedure() != null) {

				StrucDocTr tr = new StrucDocTr();

				if (component.getProcedure().getText() != null
						&& component.getProcedure().getText().getReference() != null
						&& component.getProcedure().getText().getReference().getValue() != null) {
					tr.setID(component.getProcedure().getText().getReference().getValue().replace("#", ""));
				}

				if (component.getProcedure().getParticipant() != null
						&& !component.getProcedure().getParticipant().isEmpty()
						&& component.getProcedure().getParticipant().get(0) != null
						&& component.getProcedure().getParticipant().get(0).getParticipantRole() != null) {

					// Material-ID
					if (component.getProcedure().getParticipant().get(0).getParticipantRole().getId() != null
						&& !component.getProcedure().getParticipant().get(0).getParticipantRole().getId().isEmpty()) {
						tr.getThOrTd().add(getCellTdId(
								component.getProcedure().getParticipant().get(0).getParticipantRole().getId().get(0)));
					}

					// Untersuchtes Material
					if (component.getProcedure().getParticipant().get(0).getParticipantRole().getPlayingEntity() != null
							&& component.getProcedure().getParticipant().get(0).getParticipantRole().getPlayingEntity()
									.getCode() != null) {
						tr.getThOrTd().add(getCellTdCode(component.getProcedure().getParticipant().get(0)
								.getParticipantRole().getPlayingEntity().getCode()));
					}
				}

				// Probenentnahme
				if (component.getProcedure().getEffectiveTime() != null
						&& component.getProcedure().getEffectiveTime().getValue() != null) {
					Hl7Dtm hl7Dtm = Hl7Dtm.fromHl7(component.getProcedure().getEffectiveTime().getValue());
					String date = hl7Dtm.getDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
					tr.getThOrTd().add(getCellTd(date));
				}

				// Probenentnahme durch
				if (component.getProcedure().getPerformer() != null
						&& !component.getProcedure().getPerformer().isEmpty()
						&& component.getProcedure().getPerformer().get(0) != null
						&& component.getProcedure().getPerformer().get(0).getAssignedEntity() != null
						&& component.getProcedure().getPerformer().get(0).getAssignedEntity()
								.getRepresentedOrganization() != null) {
					Name name = new Name(component.getProcedure().getPerformer().get(0).getAssignedEntity()
							.getRepresentedOrganization().getName().get(0));
					tr.getThOrTd().add(getCellTd(name.getName()));
				}

				if (component.getProcedure().getEntryRelationship() != null
						&& !component.getProcedure().getEntryRelationship().isEmpty()
						&& component.getProcedure().getEntryRelationship().get(0) != null
						&& component.getProcedure().getEntryRelationship().get(0).getAct() != null) {

					// Probeneingang
					if (component.getProcedure().getEntryRelationship().get(0).getAct().getEffectiveTime() != null
							&& component.getProcedure().getEntryRelationship().get(0).getAct().getEffectiveTime()
									.getValue() != null) {
						Hl7Dtm hl7Dtm = Hl7Dtm.fromHl7(component.getProcedure().getEntryRelationship().get(0).getAct()
								.getEffectiveTime().getValue());
						String date = hl7Dtm.getDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
						tr.getThOrTd().add(getCellTd(date));
					}
				}

				body.getTr().add(tr);
			}
		}

		return body;
	}

	protected StrucDocTd getCellTdId(II codeId) {
		return getCellTd(String.format("%s - %s", codeId.getExtension(), codeId.getRoot()));
	}

	protected StrucDocTd getCellTdCode(CD codeTest) {
		return getCellTd(codeTest.getDisplayName());
	}

	protected StrucDocTd getCellTdCodes(List<CE> interpretationCodes) {
		StringBuilder sb = new StringBuilder();

		int index = 0;
		for (CE interpret : interpretationCodes) {
			if (interpret != null) {
				sb.append(interpret.getDisplayName());
			}

			index++;
			if (index != interpretationCodes.size()) {
				sb.append(" , ");
			}
		}

		return getCellTd(sb.toString());
	}

	private StrucDocTd getCellTd(String text) {
		if (text == null)
			text = "";

		StrucDocTd td = new StrucDocTd();
		td.getContent().add(text);
		return td;
	}

	private StrucDocTh getTableHeaderCell(String text, String styleCode) {
		StrucDocTh th = new StrucDocTh();
		if (styleCode != null) {
			th.getStyleCode().add(styleCode);
		}

		th.getContent().add(text);
		return th;
	}

	private StrucDocThead getTableHeader() {
		StrucDocThead thead = new StrucDocThead();

		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getTableHeaderCell("Material-ID", "xELGA_colw:15"));
		tr.getThOrTd().add(getTableHeaderCell("Untersuchtes Material", "xELGA_colw:14"));
		tr.getThOrTd().add(getTableHeaderCell("Probenentnahme", "xELGA_colw:10"));
		tr.getThOrTd().add(getTableHeaderCell("Probenentnahme durch", "xELGA_colw:17"));
		tr.getThOrTd().add(getTableHeaderCell("Probeneingang", "xELGA_colw:10"));
		thead.getTr().add(tr);

		return thead;
	}

	/**
	 * Returns {@link StrucDocTable} included in {@link JAXBElement}.
	 *
	 */
	public StrucDocTable getTable(List<POCDMT000040EntryRelationship> entries) {
		StrucDocTable table = new StrucDocTable();
		table.setThead(getTableHeader());
		table.getTbody().add(getBody(entries));
		return table;
	}

	/**
	 * Returns {@link StrucDocTable} included in {@link JAXBElement}.
	 *
	 */
	public StrucDocText getText() {
		StrucDocText text = new StrucDocText();

		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getAct() != null && !entry.getAct().getEntryRelationship().isEmpty()) {
				text.getContent().add(new JAXBElement<StrucDocTable>(new QName("urn:hl7-org:v3", "table"),
						StrucDocTable.class, getTable(entry.getAct().getEntryRelationship())));
			}
		}

		return text;
	}


}
