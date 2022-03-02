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

import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.POCDMT000040Consumable;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040Precondition;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.StrucDocContent;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;

public class ImmunizationRecommendationNarrativeTextGenerator {

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
			table.setID(String.format("sbdm-%d", idxImmunization));
		}

		StrucDocTbody body = new StrucDocTbody();

		if (substanceAdministration.getPrecondition() != null) {
			for (POCDMT000040Precondition precondition : substanceAdministration.getPrecondition()) {
				if (precondition != null) {
					body.getTr().add(getRowDose(precondition));
					body.getTr().add(getRowScheme(precondition, idxImmunization));
				}
			}
		}

		if (substanceAdministration.getConsumable() != null) {
			body.getTr().add(getRowVaccine(substanceAdministration.getConsumable()));
		}

		if (substanceAdministration.getEntryRelationship() != null) {
			body.getTr().addAll(getRowTargetDiseases(substanceAdministration.getEntryRelationship()));
		}

		table.getTbody().add(body);
		return table;
	}

	private StrucDocTd getCellTd(String text) {
		if (text == null)
			text = "";

		StrucDocTd td = new StrucDocTd();
		td.getContent().add(text);
		return td;
	}

	private StrucDocTd getCellTdWithContent(String text, String contentId) {
		StrucDocTd td = new StrucDocTd();
		td.getContent().add(getStrucDocContent(text, contentId));
		return td;
	}

	protected StrucDocTr getRowDose(POCDMT000040Precondition precondition) {
		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getCellTd("Dosis:"));
		if (precondition != null && precondition.getCriterion() != null
				&& precondition.getCriterion().getValue() instanceof CD) {
			CD code = (CD) precondition.getCriterion().getValue();
			tr.getThOrTd().add(getCellTd(code.getDisplayName()));
		}

		return tr;
	}

	protected StrucDocTr getRowScheme(POCDMT000040Precondition precondition, int index) {
		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getCellTd("Impfschema:"));
		if (precondition != null && precondition.getCriterion() != null) {
			String contentId = String.format("criterion-%d", index);

			if (precondition.getCriterion().getText() != null
					&& precondition.getCriterion().getText().getReference() != null
					&& precondition.getCriterion().getText().getReference().getValue() != null) {
				contentId = precondition.getCriterion().getText().getReference().getValue().replace("#", "");
			}

			if (precondition.getCriterion().getCode() != null) {
				tr.getThOrTd()
						.add(getCellTdWithContent(precondition.getCriterion().getCode().getDisplayName(), contentId));
			}
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

	protected List<StrucDocTr> getRowTargetDiseases(List<POCDMT000040EntryRelationship> entryRelationships) {
		List<StrucDocTr> list = new LinkedList<>();

		for (POCDMT000040EntryRelationship entryRel : entryRelationships) {
			if (entryRel != null && entryRel.getObservation() != null
					&& entryRel.getTypeCode().equals(XActRelationshipEntryRelationship.RSON)
					&& entryRel.getObservation().getCode() != null) {
				StrucDocTr tr = new StrucDocTr();
				StrucDocTd td = new StrucDocTd();
				td.getStyleCode().add("xELGA_colw:20");
				td.getContent().add("Impfung gegen:");
				tr.getThOrTd().add(td);

				String contentId = "";

				if (entryRel.getObservation().getText() != null
						&& entryRel.getObservation().getText().getReference() != null
						&& entryRel.getObservation().getText().getReference().getValue() != null) {
					contentId = entryRel.getObservation().getText().getReference().getValue().replace("#", "");
				}

				tr.getThOrTd()
						.add(getCellTdWithContent(entryRel.getObservation().getCode().getDisplayName(), contentId));

				list.add(tr);
			}
		}

		return list;
	}

	protected JAXBElement<StrucDocContent> getStrucDocContent(String text, String contentId) {
		StrucDocContent content = new StrucDocContent();
		content.setID(contentId);
		content.getContent().add(text);

		return new JAXBElement<>(new QName("urn:hl7-org:v3", "content"), StrucDocContent.class, content);
	}

	public List<JAXBElement<StrucDocTable>> getTablesFromCda() {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();
		int idxImmunization = 0;

		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getSubstanceAdministration() != null) {
				tables.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "table"), StrucDocTable.class,
						getBody(idxImmunization, entry.getSubstanceAdministration())));
			}
		}

		return tables;
	}

}
