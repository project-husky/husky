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
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.models.AdditionalInformation;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.COCTMT230100UVIngredient;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Act;
import org.projecthusky.common.hl7cdar2.POCDMT000040Consumable;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.SXCMTS;
import org.projecthusky.common.hl7cdar2.StrucDocTable;
import org.projecthusky.common.hl7cdar2.StrucDocTbody;
import org.projecthusky.common.hl7cdar2.StrucDocTd;
import org.projecthusky.common.hl7cdar2.StrucDocThead;
import org.projecthusky.common.hl7cdar2.StrucDocTr;
import org.projecthusky.common.hl7cdar2.TN;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.utils.time.DateTimes;
import org.projecthusky.common.utils.time.Hl7Dtm;

public class MedBaseTextGenerator extends BaseTextGenerator {

	protected List<List<AdditionalInformation>> patientInstructions;
	protected List<List<AdditionalInformation>> pharmInstructions;


	public MedBaseTextGenerator(List<List<AdditionalInformation>> patientInstructions,
			List<List<AdditionalInformation>> pharmInstructions) {
		this.patientInstructions = patientInstructions;
		this.pharmInstructions = pharmInstructions;
	}

	protected void addAdditionalInformationRows(POCDMT000040Act act, StrucDocTbody body, int index) {
		List<AdditionalInformation> additionalInformations = new LinkedList<>();

		if ("PINSTRUCT".equalsIgnoreCase(act.getCode().getCode())) {
			additionalInformations = patientInstructions.get(index);
		} else if ("FINSTRUCT".equalsIgnoreCase(act.getCode().getCode())) {
			additionalInformations = pharmInstructions.get(index);
		}

		StringBuilder infos = new StringBuilder();
		int indexLastInfo = additionalInformations.size();
		int indexInfo = 0;
		for (AdditionalInformation info : additionalInformations) {
			if (info != null) {
				infos.append(info.getInformation());

				if (indexInfo != indexLastInfo) {
					infos.append(",");
				}
			}
		}

		body.getTr().add(getRow("Zusatzinformationen für den Patienten und alternative Einnahme", infos.toString()));
	}

	protected void addTimeRows(List<SXCMTS> time, StrucDocTbody body) {
		if (time != null) {
			Map<String, String> timeMap = getTsElement((IVLTS) time.get(0));

			String startDateDisease = timeMap.get("low");
			String endDateDisease = timeMap.get("high");
			String duration = timeMap.get("width");

			var sdf = new SimpleDateFormat("dd.MM.yyyy");

			if (startDateDisease != null) {
				body.getTr().add(
						getRow("Einnahmestart", sdf.format(DateTimes.toInstant(Hl7Dtm.fromHl7(startDateDisease)))));
			}

			if (endDateDisease != null) {
				body.getTr()
						.add(getRow("Einnahmeende", sdf.format(DateTimes.toInstant(Hl7Dtm.fromHl7(endDateDisease)))));
			}

			if (duration != null) {
				body.getTr().add(getRow("Einnahmedauer", duration));
			}
		}

	}

	protected StrucDocTr getRow(String title, String text) {
		StrucDocTr tr = new StrucDocTr();
		StrucDocTd titleTd = new StrucDocTd();
		titleTd.getContent().add(title);
		tr.getThOrTd().add(titleTd);

		StrucDocTd textTd = new StrucDocTd();
		textTd.getContent().add(text);
		tr.getThOrTd().add(textTd);

		return tr;
	}

	protected void addInformationOfEntryRelRows(List<POCDMT000040EntryRelationship> entryRels, StrucDocTbody body,
			int index) {
		if (entryRels != null) {
			for (POCDMT000040EntryRelationship entryRel : entryRels) {
				if (entryRel != null) {
					if (entryRel.getTypeCode().equals(XActRelationshipEntryRelationship.COMP)) {
						if (entryRel.getAct() != null && entryRel.getAct().getCode() != null) {
							body.getTr().add(getRow("Therapieart", entryRel.getAct().getCode().getDisplayName()));
						} else if (entryRel.getSupply() != null && entryRel.getSupply().getQuantity() != null) {
							body.getTr()
									.add(getRow("Anzahl der Packungen", entryRel.getSupply().getQuantity().getValue()));
						}

					} else if (entryRel.getTypeCode().equals(XActRelationshipEntryRelationship.SUBJ)
							&& entryRel.getAct() != null) {
						addAdditionalInformationRows(entryRel.getAct(), body, index);
					}
				}
			}
		}
	}

	protected void addConsumableInformationRows(POCDMT000040Consumable consumable, StrucDocTbody body) {
		if (consumable != null && consumable.getManufacturedProduct() != null
				&& consumable.getManufacturedProduct().getManufacturedMaterial() != null) {
			body.getTr().add(getRow("Arznei: Handelsname",
					consumable.getManufacturedProduct().getManufacturedMaterial().getName().getMergedXmlMixed()));
			body.getTr().add(getRow("Arznei: Pharmazentralnummer",
					consumable.getManufacturedProduct().getManufacturedMaterial().getCode().getCode()));

			if (consumable.getManufacturedProduct().getManufacturedMaterial().getFormCode() != null) {
				body.getTr().add(getRow("Arznei: Darreichungsform",
						consumable.getManufacturedProduct().getManufacturedMaterial().getFormCode().getDisplayName()));
			}

			if (consumable.getManufacturedProduct().getManufacturedMaterial().getAsContent() != null
					&& consumable.getManufacturedProduct().getManufacturedMaterial().getAsContent()
							.getContainerPackagedMedicine() != null
					&& consumable.getManufacturedProduct().getManufacturedMaterial().getAsContent()
							.getContainerPackagedMedicine().getCapacityQuantity() != null) {
				body.getTr()
						.add(getRow("Arznei: Angaben zur Packung",
								String.format("%s %s",
										consumable.getManufacturedProduct().getManufacturedMaterial().getAsContent()
												.getContainerPackagedMedicine().getCapacityQuantity().getValue(),
										consumable.getManufacturedProduct().getManufacturedMaterial().getAsContent()
												.getContainerPackagedMedicine().getCapacityQuantity().getUnit())));
			}

			addIngredientRows(consumable.getManufacturedProduct().getManufacturedMaterial().getIngredient(), body);
		}
	}

	protected void addIngredientRows(List<COCTMT230100UVIngredient> ingredients, StrucDocTbody body) {
		for (COCTMT230100UVIngredient ingredient : ingredients) {
			if (ingredient != null && ingredient.getIngredient() != null
					&& ingredient.getIngredient().getValue() != null) {

				StringBuilder ingredientsSb = new StringBuilder();
				for (TN tn : ingredient.getIngredient().getValue().getName()) {
					if (tn != null) {
						ingredientsSb.append(tn.getMergedXmlMixed());
					}
				}

				if (ingredient.getIngredient().getValue().getCode() != null) {
					ingredientsSb.append("(");
					ingredientsSb.append(ingredient.getIngredient().getValue().getCode().getCode());
					ingredientsSb.append(")");
				}

				body.getTr().add(getRow("Arznei: Wirkstoffklassifikation (ATC Code)", ingredients.toString()));
			}
		}
	}

	protected StrucDocTable getBodyPrescriptionEntry(POCDMT000040SubstanceAdministration substance, int index) {
		var table = new StrucDocTable();
		var body = new StrucDocTbody();
		if (substance != null) {
			body.getTr().add(getRow("Verordnung", index + ""));

			if (!substance.getId().isEmpty() && substance.getId().get(0) != null) {
				body.getTr().add(getRow("VerordnungsID", substance.getId().get(0).getRoot() + " / "
						+ substance.getId().get(0).getExtension() + "_" + index));
			}

			addConsumableInformationRows(substance.getConsumable(), body);

			addTimeRows(substance.getEffectiveTime(), body);

			addInformationOfEntryRelRows(substance.getEntryRelationship(), body, index);

			if (substance.getRouteCode() != null) {
				body.getTr().add(getRow("Art der Anwendung", substance.getRouteCode().getDisplayName()));
			}

			if (substance.getRepeatNumber() != null) {
				body.getTr().add(
						getRow("Anzahl der Einlösungen", String.format("%d", substance.getRepeatNumber().getValue())));
			}

			table.getTbody().add(body);
		}

		return table;
	}

	protected StrucDocThead getTableHeader() {
		StrucDocThead thead = new StrucDocThead();

		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getTableHeaderCell("Rezeptart", null));
		tr.getThOrTd().add(getTableHeaderCell("Gültig von", null));
		tr.getThOrTd().add(getTableHeaderCell("Gültig bis", null));
		thead.getTr().add(tr);

		return thead;
	}

	protected StrucDocTable getBody(POCDMT000040SubstanceAdministration substance) {
		var table = new StrucDocTable();
		var body = new StrucDocTbody();

		if (substance != null) {

			if (!substance.getId().isEmpty()) {
				table.setID(substance.getId().get(0).getExtension());
			}

			var tr = new StrucDocTr();
			var td = new StrucDocTd();
			if (substance.getCode() != null) {
				td.getContent().add(substance.getCode().getDisplayName());

				if (substance.getCode().getOriginalText() != null
						&& substance.getCode().getOriginalText().getReference() != null
						&& substance.getCode().getOriginalText().getReference().getValue() != null) {
					td.setID(substance.getCode().getOriginalText().getReference().getValue().replace("#", ""));
				}
			}

			tr.getThOrTd().add(td);

			Map<String, String> timeMap = getTsElement((IVLTS) substance.getEffectiveTime().get(0));

			Instant startDateDisease = DateTimes.toInstant(Hl7Dtm.fromHl7(timeMap.get("low")));
			Instant endDateDisease = DateTimes.toInstant(Hl7Dtm.fromHl7(timeMap.get("high")));

			var sdf = new SimpleDateFormat("dd.MM.yyyy");

			var tdStartTime = new StrucDocTd();
			tdStartTime.getContent().add(sdf.format(startDateDisease));
			tr.getThOrTd().add(tdStartTime);

			var tdEndTime = new StrucDocTd();
			tdEndTime.getContent().add(sdf.format(endDateDisease));
			tr.getThOrTd().add(tdEndTime);

			body.getTr().add(tr);

		}

		table.setThead(getTableHeader());
		table.getTbody().add(body);

		return table;
	}

	public List<JAXBElement<StrucDocTable>> getTablesFromCda(List<POCDMT000040Entry> entries) {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();

		int index = 0;
		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getAct() != null) {
				tables.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "table"), StrucDocTable.class,
						getBody(entry.getSubstanceAdministration())));
				tables.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "table"), StrucDocTable.class,
						getBodyPrescriptionEntry(entry.getSubstanceAdministration(), index)));
				index++;
			}
		}

		return tables;
	}
}
