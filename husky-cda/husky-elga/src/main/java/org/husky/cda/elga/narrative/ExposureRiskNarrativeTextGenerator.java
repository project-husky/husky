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

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.IVXBTS;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.QTY;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;

public class ExposureRiskNarrativeTextGenerator {

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
		if (act != null && act.getEntryRelationship() != null) {
			for (POCDMT000040EntryRelationship entryRel : act.getEntryRelationship()) {
				if (entryRel != null && entryRel.getObservation() != null) {
					Instant startDateDisease = null;
					Instant endDateDisease = null;

					var sb = new StringBuilder();

					var tdTime = new StrucDocTd();

					if (entryRel.getObservation().getEffectiveTime() != null
							&& entryRel.getObservation().getEffectiveTime().getRest() != null) {
						Map<String, String> timeMap = getTsElement(entryRel.getObservation().getEffectiveTime());
						startDateDisease = DateTimes.toInstant(Hl7Dtm.fromHl7(timeMap.get("low")));
						endDateDisease = DateTimes.toInstant(Hl7Dtm.fromHl7(timeMap.get("high")));

						var sdf = new SimpleDateFormat("dd.MM.yyyy");
						if (startDateDisease != null) {
							sb.append(sdf.format(startDateDisease));
							sb.append(" - ");
						}

						if (endDateDisease != null) {
							sb.append(sdf.format(endDateDisease));
						}
					}

					tdTime.getContent().add(sb.toString());

					var tr = new StrucDocTr();

					var td = new StrucDocTd();
					if (entryRel.getObservation().getValue() != null
							&& !entryRel.getObservation().getValue().isEmpty()) {
						for (ANY value : entryRel.getObservation().getValue()) {
							if (value instanceof CD) {
								CD code = (CD) value;
								td.getContent().add(code.getDisplayName());

								if (code.getOriginalText() != null && code.getOriginalText().getReference() != null
										&& code.getOriginalText().getReference().getValue() != null) {
									td.setID(code.getOriginalText().getReference().getValue().replace("#", ""));
								}
							}
						}
					}

					tr.getThOrTd().add(tdTime);
					tr.getThOrTd().add(td);
					body.getTr().add(tr);
				}
			}
		}

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

	/**
	 * extracts all {@link TS} elements of passed {@link IVLTS}. Extracted elements
	 * are stored in a map, where key is element name like "high" and value is
	 * element value.
	 *
	 * @param time to be extracted
	 *
	 * @return map of element name and value
	 */
	private Map<String, String> getTsElement(IVLTS time) {
		Map<String, String> tsElements = new HashMap<>();
		if (time != null) {
			for (JAXBElement<? extends QTY> ts : time.getRest()) {
				String value = "";
				String elementName = "";
				if (ts != null && IVXBTS.class.equals(ts.getDeclaredType()) && ts.getValue() != null) {
					value = ((IVXBTS) ts.getValue()).getValue();
				} else if (ts != null && TS.class.equals(ts.getDeclaredType()) && ts.getValue() != null) {
					value = ((TS) ts.getValue()).getValue();
				}

				if (ts != null && ts.getName() != null) {
					elementName = ts.getName().getLocalPart();
				}

				if (value != null && elementName != null) {
					tsElements.put(elementName, value);
				}
			}
		}

		return tsElements;
	}



}
