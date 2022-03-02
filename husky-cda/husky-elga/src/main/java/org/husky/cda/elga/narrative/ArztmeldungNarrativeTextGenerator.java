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

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.cda.elga.models.ems.Arztmeldung;
import org.husky.cda.elga.models.ems.CaseIdentification;
import org.husky.cda.elga.models.ems.ClinicalManifestation;
import org.husky.cda.elga.models.ems.ClinicalManifestationItem;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.model.Code;

public class ArztmeldungNarrativeTextGenerator {

	private Arztmeldung document;

	/**
	 * Constructor.
	 *
	 * @param document
	 */
	public ArztmeldungNarrativeTextGenerator(Arztmeldung document) {
		this.document = document;
	}

	protected StrucDocTr getRow(String title, String text, String contentId) {
		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getCellTd(title, null));
		tr.getThOrTd().add(getCellTd(text, contentId));
		return tr;
	}

	private StrucDocTable getBody(CaseIdentification entry, ClinicalManifestation clinicalManifestation,
			ZonedDateTime hospitalization) {
		StrucDocTable table = new StrucDocTable();
		StrucDocTbody body = new StrucDocTbody();

		if (entry.getDiagnosisDate() != null) {
			body.getTr().add(getRow("Diagnosedatum",
					DateTimeFormatter.ofPattern("dd.MM.yyyy").format(entry.getDiagnosisDate()), "epims-diag-date"));
		}

		body.getTr().add(getRow("Diagnose", entry.getDisease().getDisplayName(), "epims-diag"));
		body.getTr()
				.add(getRow("Diagnosesicherheit", entry.getDiagnosisConfidence().getDisplayName(), "epims-diag-conf"));

		if (entry.getFieldValues() != null && !entry.getFieldValues().isEmpty()) {
			int index = 1;
			for (Entry<Code, Code> mapEntry : entry.getFieldValues().entrySet()) {
				if (mapEntry != null && mapEntry.getKey() != null && mapEntry.getValue() != null) {
					body.getTr().add(getRow(mapEntry.getKey().getDisplayName(), mapEntry.getValue().getDisplayName(),
							String.format("epims-parameter-%d", index++)));
				}
			}
		}

		if (clinicalManifestation != null && clinicalManifestation.getClinicalManifestationItems() != null
				&& !clinicalManifestation.getClinicalManifestationItems().isEmpty()) {
			int index = 1;
			for (ClinicalManifestationItem item : clinicalManifestation.getClinicalManifestationItems()) {
				if (item != null && item.getCode() != null) {
					body.getTr().add(getRow(String.format("Klinische Manifestation %d", index),
							item.getCode().getDisplayName(), String.format("epims-entry-problem-%d", index++)));
				}
			}
		}

		if (hospitalization != null) {
			body.getTr().add(getRow("Hospitalisierung",
					DateTimeFormatter.ofPattern("dd.MM.yyyy").format(hospitalization), "epims-hospitalization"));
		}

		table.getTbody().add(body);
		return table;
	}

	private StrucDocTd getCellTd(String text, String id) {
		if (text == null)
			text = "";

		StrucDocTd td = new StrucDocTd();

		if (id != null && !id.isEmpty()) {
			td.setID(id);
		}

		td.getContent().add(text);
		return td;
	}

	/**
	 * Returns {@link StrucDocTable} included in {@link JAXBElement}.
	 *
	 */
	public JAXBElement<StrucDocTable> getTable() {
		return new JAXBElement<>(new QName("urn:hl7-org:v3", "table"), StrucDocTable.class,
				getBody(this.document.getCaseIdentification(), this.document.getClinicalManifestation(),
						this.document.getHospitalisation()));
	}

}
