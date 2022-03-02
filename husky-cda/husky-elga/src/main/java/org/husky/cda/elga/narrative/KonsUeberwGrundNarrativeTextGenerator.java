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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocTh;
import org.husky.common.hl7cdar2.StrucDocThead;
import org.husky.common.hl7cdar2.StrucDocTr;

public class KonsUeberwGrundNarrativeTextGenerator {

	private List<POCDMT000040Entry> entries;

	/**
	 * Constructor.
	 *
	 * @param problemConcerns a list of problem concerns
	 * @param section         the section
	 */
	public KonsUeberwGrundNarrativeTextGenerator(List<POCDMT000040Entry> entries) {
		this.entries = entries;
	}

	private StrucDocThead getTableHeader() {
		StrucDocThead thead = new StrucDocThead();

		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getTableHeaderCell("Code", null));
		tr.getThOrTd().add(getTableHeaderCell("Zusatzinformation", null));
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

	private StrucDocTd getCellTd(String text) {
		if (text == null)
			text = "";

		StrucDocTd td = new StrucDocTd();
		td.getContent().add(text);
		return td;
	}

	private StrucDocTable getBody(POCDMT000040Act act) {
		var table = new StrucDocTable();
		var body = new StrucDocTbody();
		if (act != null) {
			for (POCDMT000040EntryRelationship entryRel : act.getEntryRelationship()) {
				if (entryRel != null && entryRel.getObservation() != null) {
					int index = 0;
					for (ANY value : entryRel.getObservation().getValue()) {
						CD cdValue = (CD) value;

						StrucDocTr tr = new StrucDocTr();
						tr.setID(String.format("classification-%d", index));
						tr.getThOrTd().add(getCellTd(cdValue.getCodeSystemName() + ": " + cdValue.getCode()));
						tr.getThOrTd().add(getCellTd(cdValue.getDisplayName()));
						body.getTr().add(tr);
						index++;
					}
				}
			}
		}

		table.setThead(getTableHeader());
		table.getTbody().add(body);

		return table;
	}

	public List<JAXBElement<StrucDocTable>> getTablesFromCda() {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();

		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getAct() != null) {
				tables.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "table"), StrucDocTable.class,
						getBody(entry.getAct())));
			}
		}

		return tables;
	}

}
