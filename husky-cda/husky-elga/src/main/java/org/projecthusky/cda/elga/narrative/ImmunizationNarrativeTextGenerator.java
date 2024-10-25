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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.POCDMT000040Consumable;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040Precondition;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.StrucDocTable;
import org.projecthusky.common.hl7cdar2.StrucDocTbody;
import org.projecthusky.common.hl7cdar2.StrucDocTd;
import org.projecthusky.common.hl7cdar2.StrucDocTr;
import org.projecthusky.common.model.Code;

public class ImmunizationNarrativeTextGenerator extends ImmunizationBaseTextGenerator {

	private Map<String, List<Code>> immunizationTargets;
	private Map<String, Code> immunizationSchemas;
	private Map<String, Code> immunizationDose;
	private Map<String, Code> immunization;
	private Map<String, Code> historicImmunization;
	private List<POCDMT000040Entry> entries;

	public ImmunizationNarrativeTextGenerator(Map<String, List<Code>> immunizationTargets,
			Map<String, Code> immunizationSchemas, Map<String, Code> immunizationDose,
			Map<String, Code> immunization,
			Map<String, Code> historicImmunization) {
		this.immunizationTargets = immunizationTargets;
		this.immunizationSchemas = immunizationSchemas;
		this.immunizationDose = immunizationDose;
		this.immunization = immunization;
		this.historicImmunization = historicImmunization;
	}

	/**
	 * Constructor.
	 *
	 * @param entries a list of entries
	 */
	public ImmunizationNarrativeTextGenerator(List<POCDMT000040Entry> entries) {
		this.entries = entries;
	}

	private StrucDocTable getBody(int idxImmunization, String key) {
		StrucDocTable table = new StrucDocTable();
		table.setID(String.format("sbdm-%d", idxImmunization));
		StrucDocTbody body = new StrucDocTbody();

		if (immunizationTargets.get(key) != null && !immunizationTargets.get(key).isEmpty()) {
			body.getTr().add(getRow(immunizationTargets.get(key), "target-" + key));
		}

		body.getTr().add(getRowWithContentId(immunizationSchemas.get(key), "schedule-" + key, "Impfschema:"));
		body.getTr().add(getRow(immunizationDose.get(key), "Dosis:"));

		if (immunization.get(key) != null) {
			body.getTr().add(getRow(immunization.get(key), "Impfstoff:"));
		}

		if (historicImmunization.get(key) != null) {
			body.getTr().add(getRow(historicImmunization.get(key), "Historischer Impfstoff:"));
		}

		table.getTbody().add(body);
		return table;
	}

	protected StrucDocTr getRow(List<Code> immunizationTargets, String contentId) {
		if (immunizationTargets != null && !immunizationTargets.isEmpty()) {
			StrucDocTr tr = new StrucDocTr();
			StrucDocTd td = new StrucDocTd();
			td.getStyleCode().add("xELGA_colw:20");
			td.getContent().add("Impfung gegen:");
			tr.getThOrTd().add(td);

			StringBuilder targets = new StringBuilder();
			int indexLastEntry = immunizationTargets.size() - 1;
			int indexTarget = 0;
			for (Code target : immunizationTargets) {
				if (target != null) {
					targets.append(target.getDisplayName());

					if (indexLastEntry != indexTarget++) {
						targets.append(",");
					}
				}
			}

			tr.getThOrTd().add(getCellTdWithContent(targets.toString(), contentId));
			return tr;
		}

		return null;
	}

	protected StrucDocTr getRow(Code code, String title) {
		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getCellTd(title));
		if (code != null) {
			tr.getThOrTd().add(getCellTd(code.getDisplayName()));
		}

		return tr;
	}

	protected StrucDocTr getRowWithContentId(Code code, String contentId, String title) {
		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getCellTd(title));
		if (code != null) {
			tr.getThOrTd().add(getCellTdWithContent(code.getDisplayName(), contentId));
		}

		return tr;
	}

	protected StrucDocTr getRowVaccine(POCDMT000040Consumable vaccine) {
		if (vaccine != null && vaccine.getManufacturedProduct() != null
				&& vaccine.getManufacturedProduct().getManufacturedMaterial() != null
				&& vaccine.getManufacturedProduct().getManufacturedMaterial().getCode() != null) {
			StrucDocTr tr = new StrucDocTr();
			tr.getThOrTd().add(getCellTd("Impfstoff:"));
			tr.getThOrTd().add(
					getCellTd(vaccine.getManufacturedProduct().getManufacturedMaterial().getCode().getDisplayName()));
			return tr;
		}

		return null;
	}

	/**
	 * Returns {@link StrucDocTable} included in {@link JAXBElement}.
	 *
	 */
	public List<JAXBElement<StrucDocTable>> getTables() {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();
		int idxImmunization = 0;

		Iterator<String> it = immunizationTargets.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			tables.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "table"), StrucDocTable.class,
					getBody(idxImmunization++, key)));

		}

		return tables;
	}

	private StrucDocTable getBody(int idxImmunization, POCDMT000040SubstanceAdministration substanceAdministration) {
		StrucDocTable table = new StrucDocTable();

		if (substanceAdministration.getText() != null && substanceAdministration.getText().getReference() != null
				&& substanceAdministration.getText().getReference().getValue() != null) {
			table.setID(substanceAdministration.getText().getReference().getValue().replace("#", ""));
		} else {
			table.setID(String.format("sbdm-%d", idxImmunization));
		}

		StrucDocTbody body = new StrucDocTbody();

		for (POCDMT000040Precondition precondition : substanceAdministration.getPrecondition()) {
			if (precondition != null) {
				body.getTr().add(getRowDose(precondition));
				body.getTr().add(getRowScheme(precondition, idxImmunization));
			}
		}

		if (substanceAdministration.getConsumable() != null) {
			body.getTr().add(getRowVaccine(substanceAdministration.getConsumable()));
		}

		body.getTr().addAll(getRowTargetDiseases(substanceAdministration.getEntryRelationship()));

		table.getTbody().add(body);
		return table;
	}

	public List<JAXBElement<StrucDocTable>> getTablesFromCda() {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();
		int idxImmunization = 0;

		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getSubstanceAdministration() != null) {
				tables.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "table"), StrucDocTable.class,
						getBody(idxImmunization, entry.getSubstanceAdministration())));
			}
		}

		return tables;
	}


}
