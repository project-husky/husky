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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.cda.elga.utils.NamespaceUtils;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040Consumable;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040Precondition;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;

public class ImmunizationRecommendationNarrativeTextGenerator extends ImmunizationBaseTextGenerator {

	private List<POCDMT000040Entry> entries;

	/**
	 * Constructor.
	 *
	 * @param entries a list of POCDMT000040Entry
	 */
	public ImmunizationRecommendationNarrativeTextGenerator(List<POCDMT000040Entry> entries) {
		this.entries = entries;
	}

	private StrucDocTable getBody(int idxImmunization, POCDMT000040SubstanceAdministration substanceAdministration) {
		StrucDocTable table = new StrucDocTable();

		if (substanceAdministration.getText() != null && substanceAdministration.getText().getReference() != null
				&& substanceAdministration.getText().getReference().getValue() != null) {
			table.setID(substanceAdministration.getText().getReference().getValue().replace("#", ""));
		} else {
			table.setID(String.format("sbdmrec-%d", idxImmunization));
		}

		StrucDocTbody body = new StrucDocTbody();

		body.getTr().add(getRowPeriod(substanceAdministration));

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

	protected StrucDocTr getRowPeriod(POCDMT000040SubstanceAdministration substance) {
		StrucDocTr tr = new StrucDocTr();
		tr.getStyleCode().add("xELGA_colw:12");
		tr.getThOrTd().add(getCellTd("Impfzeitraum:"));

		var sb = new StringBuilder();

		var tdTime = new StrucDocTd();

		if (!substance.getEffectiveTime().isEmpty()
				&& substance.getEffectiveTime().get(0) != null) {
			Map<String, String> timeMap = getTsElement((IVLTS) substance.getEffectiveTime().get(0));
			String lowTime = timeMap.get("low");
			String highTime = timeMap.get("high");

			var sdf = new SimpleDateFormat("dd.MM.yyyy");
			if (lowTime != null) {
				sb.append(sdf.format(DateTimes.toInstant(Hl7Dtm.fromHl7(lowTime))));
				sb.append(" - ");
			}

			if (highTime != null) {
				sb.append(sdf.format(DateTimes.toInstant(Hl7Dtm.fromHl7(highTime))));
			}
		}

		tdTime.getContent().add(sb.toString());

		tr.getThOrTd().add(tdTime);

		return tr;
	}

	protected StrucDocTr getRowVaccine(POCDMT000040Consumable vaccine) {
		if (vaccine != null && vaccine.getManufacturedProduct() != null
				&& vaccine.getManufacturedProduct().getManufacturedMaterial() != null
				&& vaccine.getManufacturedProduct().getManufacturedMaterial().getCode() != null) {
			StrucDocTr tr = new StrucDocTr();
			tr.getStyleCode().add("xELGA_colw:35");
			tr.getThOrTd().add(getCellTd("Impfstoff:"));
			tr.getThOrTd().add(
					getCellTd("nicht anwendbar"));
			return tr;
		}

		return null;
	}

	public StrucDocText getNarrativeTextCda(Map<String, String> comments) {
		StrucDocText text = new StrucDocText();
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();
		int idxImmunization = 0;

		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getSubstanceAdministration() != null) {
				tables.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "table"), StrucDocTable.class,
						getBody(idxImmunization, entry.getSubstanceAdministration())));
				addCommentContent(text, entry, comments);
		}
	}

	text.getContent().addAll(tables);

	return text;
	}


}
