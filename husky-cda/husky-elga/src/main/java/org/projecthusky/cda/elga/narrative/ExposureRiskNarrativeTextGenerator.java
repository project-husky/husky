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

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.ANY;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.POCDMT000040Act;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.StrucDocTable;
import org.projecthusky.common.hl7cdar2.StrucDocTbody;
import org.projecthusky.common.hl7cdar2.StrucDocTd;
import org.projecthusky.common.hl7cdar2.StrucDocTr;

public class ExposureRiskNarrativeTextGenerator extends BaseTextGenerator {

	private List<POCDMT000040Entry> entries;

	/**
	 * Constructor.
	 *
	 * @param entries a list of POCDMT000040Entry
	 */
	public ExposureRiskNarrativeTextGenerator(List<POCDMT000040Entry> entries) {
		this.entries = entries;
	}

	private StrucDocTable getBody(POCDMT000040Act act) {
		var table = new StrucDocTable();
		var body = new StrucDocTbody();
		if (act != null) {
			for (POCDMT000040EntryRelationship entryRel : act.getEntryRelationship()) {
				if (entryRel != null && entryRel.getObservation() != null) {
					var tr = new StrucDocTr();
					tr.getThOrTd().add(getCellTdTime(entryRel.getObservation().getEffectiveTime()));
					tr.getThOrTd().add(getCellCodeValue(entryRel.getObservation().getValue()));
					body.getTr().add(tr);
				}
			}
		}

		table.getTbody().add(body);

		return table;
	}

	private StrucDocTd getCellCodeValue(List<ANY> values) {
		var td = new StrucDocTd();
		if (values != null && !values.isEmpty()) {
			for (ANY value : values) {
				if (value instanceof CD code) {
					td.getContent().add(code.getDisplayName());

					if (code.getOriginalText() != null && code.getOriginalText().getReference() != null
							&& code.getOriginalText().getReference().getValue() != null) {
						td.setID(code.getOriginalText().getReference().getValue().replace("#", ""));
					}
				}
			}
		}

		return td;
	}

	public List<JAXBElement<StrucDocTable>> getTablesFromCda() {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();

		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getAct() != null) {
				tables.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "table"), StrucDocTable.class,
						getBody(entry.getAct())));
			}
		}

		return tables;
	}





}
