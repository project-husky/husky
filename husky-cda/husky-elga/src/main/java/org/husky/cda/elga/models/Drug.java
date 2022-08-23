/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.husky.cda.elga.generated.artdecor.AtcdabbrOtherVaccineProduct;
import org.husky.cda.elga.generated.artdecor.emed.ArzneiEntry;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.POCDMT000040Consumable;
import org.husky.common.hl7cdar2.POCDMT000040Material;
import org.husky.common.hl7cdar2.POCDMT000040Product;
import org.husky.common.hl7cdar2.ST;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.model.Code;
import org.husky.common.model.Name;
import org.husky.common.model.Organization;

public class Drug {

	private String name;
	private String text;
	private Code unit;
	private String packageSize;
	private String pharmNo;
	private Code vaccination;
	private Code historicVaccination;
	private Code dosageForm;
	private String lotNumberTxt;
	private List<Ingredient> ingredients;
	private Organization drugProducer;

	public Drug(POCDMT000040Consumable consumable) {
		ingredients = new ArrayList<>();
		if (consumable != null && consumable.getManufacturedProduct() != null
				&& consumable.getManufacturedProduct().getManufacturedMaterial() != null
				&& consumable.getManufacturedProduct().getManufacturedMaterial().getCode() != null) {
			this.name = consumable.getManufacturedProduct().getManufacturedMaterial().getCode().getDisplayName();
			this.pharmNo = consumable.getManufacturedProduct().getManufacturedMaterial().getCode().getCode();
		}
	}

	public String getName() {
		return this.name;
	}

	public String getPackageSize() {
		return packageSize;
	}

	public String getPharmNo() {
		return pharmNo;
	}

	public String getText() {
		return this.text;
	}

	public Code getUnit() {
		return unit;
	}

	public void setName(String name) {
		this.name = name;

	}

	public void setPackageSize(String packageSize) {
		this.packageSize = packageSize;
	}

	public void setPharmNo(String pharmNo) {
		this.pharmNo = pharmNo;
	}

	public void setText(String txt) {
		this.text = txt;
	}

	public void setUnit(Code unit) {
		this.unit = unit;
	}

	public Code getVaccination() {
		return vaccination;
	}

	public void setVaccination(Code vaccination) {
		this.vaccination = vaccination;
	}

	public Code getHistoricVaccination() {
		return historicVaccination;
	}

	public void setHistoricVaccination(Code historicVaccination) {
		this.historicVaccination = historicVaccination;
	}

	public String getLotNumberTxt() {
		return lotNumberTxt;
	}

	public void setLotNumberTxt(String lotNumberTxt) {
		this.lotNumberTxt = lotNumberTxt;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}

	public Organization getDrugProducer() {
		return drugProducer;
	}

	public void setDrugProducer(Organization drugProducer) {
		this.drugProducer = drugProducer;
	}

	public Code getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(Code dosageForm) {
		this.dosageForm = dosageForm;
	}

	public POCDMT000040Consumable getVaccineProduct(boolean immunizationRecommendaction) {
		POCDMT000040Consumable consumable = new POCDMT000040Consumable();
		consumable.getTypeCode().clear();
		consumable.getTypeCode().add("CSM");
		AtcdabbrOtherVaccineProduct vaccineProd = new AtcdabbrOtherVaccineProduct();
		POCDMT000040Material material = vaccineProd.getHl7ManufacturedMaterial();

		if (vaccination != null) {
			material.setCode(new CE(vaccination.getCode(), vaccination.getCodeSystem(), vaccination.getCodeSystemName(),
					vaccination.getDisplayName()));
		} else if (historicVaccination != null) {
			material.setCode(new CE(historicVaccination.getCode(), historicVaccination.getCodeSystem(),
					historicVaccination.getCodeSystemName(), historicVaccination.getDisplayName()));
		}

		ST lotNumber = new ST();
		if (lotNumberTxt != null && !immunizationRecommendaction) {
			lotNumber.setXmlMixed(lotNumberTxt);
		} else if (immunizationRecommendaction) {
			lotNumber.nullFlavor = new LinkedList<>();
			lotNumber.getNullFlavor().add("NA");
		} else {
			lotNumber.nullFlavor = new LinkedList<>();
			lotNumber.getNullFlavor().add("UNK");
		}
		material.setLotNumberText(lotNumber);

		if (this.ingredients != null && !this.ingredients.isEmpty()) {
			for (Ingredient ingredient : ingredients) {
				if (ingredient != null) {
					material.getIngredient().add(ingredient.getCOCTMT230100UVIngredient());
				}
			}
		}

		Name pharmName = new Name();
		if (this.name != null) {
			pharmName.setName(this.name);
		} else if (this.vaccination != null) {
			pharmName.setName(vaccination.getDisplayName());
		} else if (this.historicVaccination != null) {
			pharmName.setName(historicVaccination.getDisplayName());
		}

		material.setName(pharmName.getHl7CdaR2En());

		vaccineProd.setManufacturedMaterial(material);

		if (drugProducer != null) {
			vaccineProd.setManufacturerOrganization(drugProducer.getHl7CdaR2Pocdmt000040Organization());
		}

		consumable.setManufacturedProduct(vaccineProd);
		return consumable;
	}

	public POCDMT000040Product getArzneiEntryDelivery(int index) {
		POCDMT000040Product product = new POCDMT000040Product();
		ArzneiEntry drugEntry = new ArzneiEntry();
		POCDMT000040Material material = drugEntry.getHl7ManufacturedMaterial();

		if (this.name != null && pharmNo != null) {
			material.setCode(new CE(pharmNo, "1.2.40.0.34.4.16", "Pharmazentralnummer", this.name));
			Name pharmName = new Name();
			pharmName.setName(this.name);

			material.getCode().setOriginalText(new ED(null, new TEL("#prodcode-" + index)));
			material.setName(pharmName.getHl7CdaR2En());
		} else {
			material.getNullFlavor().add("NA");
		}

		product.setManufacturedProduct(drugEntry);
		return product;
	}

	public POCDMT000040Consumable getArzneiEntry() {
		POCDMT000040Consumable consumable = new POCDMT000040Consumable();
		ArzneiEntry drugEntry = new ArzneiEntry();
		POCDMT000040Material material = drugEntry.getHl7ManufacturedMaterial();

		if (this.name != null && pharmNo != null) {
			material.setCode(new CE(pharmNo, "1.2.40.0.34.4.16", "Pharmazentralnummer", this.name));
			Name pharmName = new Name();
			pharmName.setName(this.name);

			material.setName(pharmName.getHl7CdaR2En());
		} else {
			material.getNullFlavor().add("NA");
		}

		consumable.setManufacturedProduct(drugEntry);
		return consumable;
	}

}
