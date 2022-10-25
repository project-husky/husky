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

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.hl7cdar2.StrucDocTable;
import org.projecthusky.common.hl7cdar2.StrucDocTbody;
import org.projecthusky.common.hl7cdar2.StrucDocTd;
import org.projecthusky.common.hl7cdar2.StrucDocThead;
import org.projecthusky.common.hl7cdar2.StrucDocTr;
import org.projecthusky.common.utils.time.DateTimes;
import org.projecthusky.common.utils.time.Hl7Dtm;

public class PharmRecommendationNarrativeTextGenerator extends BaseTextGenerator {

	private List<POCDMT000040Entry> entries;

	/**
	 * Constructor.
	 *
	 * @param entries list of POCDMT000040Entry
	 */
	public PharmRecommendationNarrativeTextGenerator(List<POCDMT000040Entry> entries) {
		this.entries = entries;
	}

	private StrucDocThead getTableHeader() {
		StrucDocThead thead = new StrucDocThead();

		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getTableHeaderCell("Rezeptart", null));
		tr.getThOrTd().add(getTableHeaderCell("Gültig von", null));
		tr.getThOrTd().add(getTableHeaderCell("Gültig bis", null));
		thead.getTr().add(tr);

		return thead;
	}

	private StrucDocTable getBody(POCDMT000040Observation observation) {
		var table = new StrucDocTable();
		var body = new StrucDocTbody();

		if (observation != null) {

			if (!observation.getId().isEmpty()) {
				table.setID(observation.getId().get(0).getExtension());
			}

			var tr = new StrucDocTr();
			var td = new StrucDocTd();
			if (observation.getCode() != null) {
				td.getContent().add(observation.getCode().getDisplayName());

				if (observation.getCode().getOriginalText() != null
						&& observation.getCode().getOriginalText().getReference() != null
						&& observation.getCode().getOriginalText().getReference().getValue() != null) {
					td.setID(observation.getCode().getOriginalText().getReference().getValue().replace("#", ""));
				}
			}

			tr.getThOrTd().add(td);

			var tdTime = new StrucDocTd();

			if (observation.getEffectiveTime() != null) {
				var sdf = new SimpleDateFormat("dd.MM.yyyy");
				Instant instant = DateTimes.toInstant(Hl7Dtm.fromHl7(observation.getEffectiveTime().getValue()));
				tdTime.getContent().add(sdf.format(instant));
			}

			tr.getThOrTd().add(tdTime);

			body.getTr().add(tr);

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
						getBody(entry.getObservation())));
			}
		}

		return tables;
	}

}
