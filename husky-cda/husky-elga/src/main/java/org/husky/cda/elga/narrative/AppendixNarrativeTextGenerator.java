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

import org.husky.cda.elga.models.Appendix;
import org.husky.cda.elga.utils.NamespaceUtils;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocThead;
import org.husky.common.hl7cdar2.StrucDocTr;

public class AppendixNarrativeTextGenerator extends BaseTextGenerator {

	private List<Appendix> appendices;
	private List<POCDMT000040Entry> entries;

	/**
	 * Constructor.
	 *
	 * @param problemConcerns a list of problem concerns
	 * @param section         the section
	 */
	public AppendixNarrativeTextGenerator(List<POCDMT000040Entry> entries, List<Appendix> appendices) {
		this.entries = entries;
		this.appendices = appendices;
	}

	private StrucDocThead getTableHeader() {
		StrucDocThead thead = new StrucDocThead();

		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getTableHeaderCell("Name des Dokuments", null));
		tr.getThOrTd().add(getTableHeaderCell("Ersteller", null));
		tr.getThOrTd().add(getTableHeaderCell("Datum", null));
		tr.getThOrTd().add(getTableHeaderCell("Dokument", null));
		thead.getTr().add(tr);

		return thead;
	}

	private StrucDocTable getBody() {
		var table = new StrucDocTable();
		var body = new StrucDocTbody();
		if (entries != null) {
			int index = 0;
			for (POCDMT000040Entry entryRel : entries) {
				if (entryRel != null && entryRel.getObservationMedia() != null) {
					StrucDocTr tr = new StrucDocTr();
					tr.getThOrTd().add(getCellTd(appendices.get(index).getTitle()));
					tr.getThOrTd().add(getCellTd(appendices.get(index).getAuthor()));
					tr.getThOrTd().add(getCellTd(appendices.get(index).getCreationTime()));
					tr.getThOrTd().add(getCellWithRenderMultiMedia(entryRel.getObservationMedia().getIDAttr()));
					body.getTr().add(tr);

					index++;
				}
			}
		}

		table.setThead(getTableHeader());
		table.getTbody().add(body);

		return table;
	}

	public List<JAXBElement<StrucDocTable>> getTablesFromCda() {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();

		tables.add(
				new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "table"), StrucDocTable.class, getBody()));

		return tables;
	}
}
