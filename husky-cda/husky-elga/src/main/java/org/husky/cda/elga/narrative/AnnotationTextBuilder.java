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

import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.StrucDocContent;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocTh;
import org.husky.common.hl7cdar2.StrucDocThead;
import org.husky.common.hl7cdar2.StrucDocTr;

public class AnnotationTextBuilder {

	private List<POCDMT000040Entry> entries;
	private List<String> notes;

	/**
	 * Constructor.
	 *
	 * @param problemConcerns a list of problem concerns
	 * @param section         the section
	 */
	public AnnotationTextBuilder(List<POCDMT000040Entry> entries, List<String> notes) {
		this.entries = entries;
		this.notes = notes;
	}

	private StrucDocThead getTableHeader() {
		StrucDocThead thead = new StrucDocThead();

		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getTableHeaderCell("Befundbewertung", null));
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

	private StrucDocTd getCellTdWithContent(String text, String contentId) {
		StrucDocTd td = new StrucDocTd();
		td.getContent().add(getStrucDocContent(text, contentId));
		return td;
	}

	protected JAXBElement<StrucDocContent> getStrucDocContent(String text, String contentId) {
		StrucDocContent content = new StrucDocContent();
		content.setID(contentId);
		content.getContent().add(text);

		return new JAXBElement<>(new QName("urn:hl7-org:v3", "content"), StrucDocContent.class, content);
	}

	private StrucDocTable getBody() {
		var table = new StrucDocTable();
		var body = new StrucDocTbody();
		int index = 0;
		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getAct() != null) {
				String reference = entry.getAct().getText().getReference().getMergedXmlMixed();
				StrucDocTr tr = new StrucDocTr();
				tr.getThOrTd().add(getCellTdWithContent(notes.get(index), reference));
				body.getTr().add(tr);
				index++;
			}
		}

		table.setThead(getTableHeader());
		table.getTbody().add(body);

		return table;
	}

	public List<JAXBElement<StrucDocTable>> getTablesFromCda() {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();

		tables.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "table"), StrucDocTable.class, getBody()));

		return tables;
	}

}
