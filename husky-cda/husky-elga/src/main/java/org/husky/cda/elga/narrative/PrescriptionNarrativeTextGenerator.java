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

import org.husky.cda.elga.models.AdditionalInformation;
import org.husky.common.hl7cdar2.COCTMT230100UVIngredient;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.IVXBTS;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.QTY;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocTh;
import org.husky.common.hl7cdar2.StrucDocThead;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.hl7cdar2.TN;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;

public class PrescriptionNarrativeTextGenerator {

	private List<POCDMT000040Entry> entries;
	private List<List<AdditionalInformation>> patientInstructions;
	private List<List<AdditionalInformation>> pharmInstructions;

	/**
	 * Constructor.
	 *
	 * @param entries list of POCDMT000040Entry
	 */
	public PrescriptionNarrativeTextGenerator(List<POCDMT000040Entry> entries,
			List<List<AdditionalInformation>> patientInstructions,
			List<List<AdditionalInformation>> pharmInstructions) {
		this.entries = entries;
		this.patientInstructions = patientInstructions;
		this.pharmInstructions = pharmInstructions;
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

	private StrucDocTh getTableHeaderCell(String text, String styleCode) {
		StrucDocTh th = new StrucDocTh();
		if (styleCode != null) {
			th.getStyleCode().add(styleCode);
		}

		th.getContent().add(text);
		return th;
	}

	private StrucDocTable getBody(POCDMT000040SubstanceAdministration substance) {
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

	public List<JAXBElement<StrucDocTable>> getTablesFromCda() {
		List<JAXBElement<StrucDocTable>> tables = new LinkedList<>();

		int index = 0;
		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getAct() != null) {
				tables.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "table"), StrucDocTable.class,
						getBody(entry.getSubstanceAdministration())));
				tables.add(new JAXBElement<>(new QName("urn:hl7-org:v3", "table"), StrucDocTable.class,
						getBodyPrescriptionEntry(entry.getSubstanceAdministration(), index)));
				index++;
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

	private StrucDocTable getBodyPrescriptionEntry(POCDMT000040SubstanceAdministration substance, int index) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

		var table = new StrucDocTable();
		var body = new StrucDocTbody();
		if (substance != null) {
			addRow("Verordnung", index + "");

			if (!substance.getId().isEmpty() && substance.getId().get(0) != null) {
				addRow("VerordnungsID",
						substance.getId().get(0).getRoot() + " / " + substance.getId().get(0).getExtension() + "_"
								+ index);
			}

			if (substance.getConsumable() != null && substance.getConsumable().getManufacturedProduct() != null
					&& substance.getConsumable().getManufacturedProduct().getManufacturedMaterial() != null) {
				addRow("Arznei: Handelsname", substance.getConsumable().getManufacturedProduct()
						.getManufacturedMaterial().getName().getMergedXmlMixed());
				addRow("Arznei: Pharmazentralnummer", substance.getConsumable().getManufacturedProduct()
						.getManufacturedMaterial().getCode().getCode());

				if (substance.getConsumable().getManufacturedProduct().getManufacturedMaterial()
						.getFormCode() != null) {
					addRow("Arznei: Darreichungsform", substance.getConsumable().getManufacturedProduct()
							.getManufacturedMaterial().getFormCode().getDisplayName());
				}

				if (substance.getConsumable().getManufacturedProduct().getManufacturedMaterial().getAsContent() != null
						&& substance.getConsumable().getManufacturedProduct().getManufacturedMaterial().getAsContent()
								.getContainerPackagedMedicine() != null
						&& substance.getConsumable().getManufacturedProduct().getManufacturedMaterial().getAsContent()
								.getContainerPackagedMedicine().getCapacityQuantity() != null) {
					addRow("Arznei: Angaben zur Packung", String.format("%s %s",
							substance.getConsumable().getManufacturedProduct().getManufacturedMaterial().getAsContent()
									.getContainerPackagedMedicine().getCapacityQuantity().getValue(),
							substance.getConsumable().getManufacturedProduct().getManufacturedMaterial().getAsContent()
									.getContainerPackagedMedicine().getCapacityQuantity().getUnit()));
				}

				if (substance.getConsumable().getManufacturedProduct().getManufacturedMaterial()
						.getIngredient() != null) {
					for (COCTMT230100UVIngredient ingredient : substance.getConsumable().getManufacturedProduct()
							.getManufacturedMaterial().getIngredient()) {
						if (ingredient != null && ingredient.getIngredient() != null
								&& ingredient.getIngredient().getValue() != null) {
							
							StringBuilder ingredients = new StringBuilder();
							for (TN tn : ingredient.getIngredient().getValue().getName()) {
								if (tn != null) {
									ingredients.append(tn.getMergedXmlMixed());
								}
							}

							if (ingredient.getIngredient().getValue().getCode() != null) {
								ingredients.append("(");
								ingredients.append(ingredient.getIngredient().getValue().getCode().getCode());
								ingredients.append(")");
							}

							addRow("Arznei: Wirkstoffklassifikation (ATC Code)", ingredients.toString());
							
						}
					}
				}
			}

			if (substance.getEffectiveTime() != null) {
				Map<String, String> timeMap = getTsElement((IVLTS) substance.getEffectiveTime().get(0));

				Instant startDateDisease = DateTimes.toInstant(Hl7Dtm.fromHl7(timeMap.get("low")));
				Instant endDateDisease = DateTimes.toInstant(Hl7Dtm.fromHl7(timeMap.get("high")));
				String duration = timeMap.get("width");

				var sdf = new SimpleDateFormat("dd.MM.yyyy");

				if (startDateDisease != null) {
					addRow("Einnahmestart", sdf.format(startDateDisease));
				}

				if (endDateDisease != null) {
					addRow("Einnahmeende", sdf.format(endDateDisease));
				}

				if (duration != null) {
					addRow("Einnahmedauer", duration);
				}

			}

			if (substance.getEntryRelationship() != null) {
				for (POCDMT000040EntryRelationship entryRel : substance.getEntryRelationship()) {
					if (entryRel != null) {
						if (entryRel.getTypeCode().equals(XActRelationshipEntryRelationship.COMP)) {
							if (entryRel.getAct() != null && entryRel.getAct().getCode() != null) {
								addRow("Therapieart", entryRel.getAct().getCode().getDisplayName());
							} else if (entryRel.getSupply() != null && entryRel.getSupply().getQuantity() != null) {
								addRow("Anzahl der Packungen", entryRel.getSupply().getQuantity().getValue());
							}

						} else if (entryRel.getTypeCode().equals(XActRelationshipEntryRelationship.SUBJ)
								&& entryRel.getAct() != null) {

							if ("PINSTRUCT".equalsIgnoreCase(entryRel.getAct().getCode().getCode())) {
								StringBuilder patInfos = new StringBuilder();
								int indexLastInfo = patientInstructions.get(index).size();
								int indexInfo = 0;
								for (AdditionalInformation info : patientInstructions.get(index)) {
									if (info != null) {
										patInfos.append(info.getInformation());

										if (indexInfo != indexLastInfo) {
											patInfos.append(",");
										}
									}
								}

								addRow("Zusatzinformationen für den Patienten und alternative Einnahme",
										patInfos.toString());
							} else if ("FINSTRUCT".equalsIgnoreCase(entryRel.getAct().getCode().getCode())) {
								StringBuilder pharmInfos = new StringBuilder();
								int indexLastInfo = pharmInstructions.get(index).size();
								int indexInfo = 0;
								for (AdditionalInformation info : pharmInstructions.get(index)) {
									if (info != null) {
										pharmInfos.append(info.getInformation());

										if (indexInfo != indexLastInfo) {
											pharmInfos.append(",");
										}
									}

									indexInfo++;
								}

								addRow("Ergänzende Informationen zu magistralen Zubereitungen", pharmInfos.toString());
							}

						}
					}
				}
			}

			if (substance.getRouteCode() != null) {
				addRow("Art der Anwendung", substance.getRouteCode().getDisplayName());
			}

			if (substance.getRepeatNumber() != null) {
				addRow("Anzahl der Einlösungen", String.format("%d", substance.getRepeatNumber().getValue()));
			}




			table.getTbody().add(body);
		}

		return table;
	}

	protected StrucDocTr addRow(String title, String text) {
		StrucDocTr tr = new StrucDocTr();
		StrucDocTd titleTd = new StrucDocTd();
		titleTd.getContent().add(title);
		tr.getThOrTd().add(titleTd);

		StrucDocTd textTd = new StrucDocTd();
		textTd.getContent().add(text);
		tr.getThOrTd().add(textTd);

		return tr;
	}

}
