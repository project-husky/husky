/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ihe.pharm.enums.OrderableDrugForm;
import org.ehealth_connector.cda.utils.CdaUtilMdht;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.enums.Ucum;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.PharmAsContent;
import org.openhealthtools.mdht.uml.cda.PharmPackagedMedicine;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityClassManufacturedMaterial;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityDeterminer;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityDeterminerDetermined;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * The Class ManufacturedMaterial. see also CDA CH MTPS 7.4.2.3
 */
public class ManufacturedMaterial extends MdhtFacade<org.openhealthtools.mdht.uml.cda.Material> {

	/**
	 * Instantiates a new manufactured material item entry.
	 */
	public ManufacturedMaterial() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new manufactured material item entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public ManufacturedMaterial(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmManufacturedMaterialEntry().init());

		Material material = this.getMdht();
		material.setClassCode(EntityClassManufacturedMaterial.MMAT);
		material.setDeterminerCode(EntityDeterminerDetermined.KIND);
	}

	/**
	 * Instantiates a new manufactured material item entry.
	 *
	 * @param mdht
	 */
	public ManufacturedMaterial(Material mdht) {
		super(mdht);
	}

	/**
	 * Adds an ingredient to the manufactured material list of ingredients
	 *
	 * @param ingredient
	 *            Ingredient to add
	 *
	 */
	public void addIngredient(PharmManufacturedMaterialEntry ingredient) {

		// TODO: Modelling problem should be n ingredients! (MTPS 7.5.12.1
		// cardinality is wrong)
		this.getMdht().setIngredient(ingredient.getMdht().getIngredient());

	}

	/**
	 * Gets the form code of the content of the box
	 *
	 * @return Form code of the content of the box or null
	 */
	public OrderableDrugForm getBoxDescriptionFormCode() {
		final PharmAsContent boxDescription = this.getMdht().getAsContent();
		if (boxDescription == null || boxDescription.getContainerPackagedMedicine() == null)
			return null;

		final CE formCode = boxDescription.getContainerPackagedMedicine().getFormCode();
		if (formCode != null) {
			for (OrderableDrugForm boxFormCode : OrderableDrugForm.values()) {
				if (boxFormCode.getCode().getCode().equalsIgnoreCase(formCode.getCode()))
					return boxFormCode;
			}
		}

		return null;
	}

	/**
	 * Gets the GTIN of the box
	 *
	 * @return GTIN of the box or null
	 */
	public String getBoxDescriptionGtin() {
		final PharmAsContent boxDescription = this.getMdht().getAsContent();
		if (boxDescription == null || boxDescription.getContainerPackagedMedicine() == null)
			return null;

		final CE codeAsContent = boxDescription.getContainerPackagedMedicine().getCode();
		if (codeAsContent == null || codeAsContent.getCodeSystem() == null || !CodeSystems.GTIN
				.getCodeSystemId().equalsIgnoreCase(codeAsContent.getCodeSystem()))
			return null;

		return new String(codeAsContent.getCode());
	}

	/**
	 * Gets the name of the box
	 *
	 * @return Name of the box or null
	 */
	public String getBoxDescriptionName() {
		final PharmAsContent boxDescription = this.getMdht().getAsContent();
		if (boxDescription == null || boxDescription.getContainerPackagedMedicine() == null
				|| boxDescription.getContainerPackagedMedicine().getName() == null)
			return null;
		return new String(boxDescription.getContainerPackagedMedicine().getName().getText());
	}

	/**
	 * Gets the size of the box
	 *
	 * @return Box size or null
	 */
	public Double getBoxDescriptionSize() {
		final PharmAsContent boxDescription = this.getMdht().getAsContent();
		if (boxDescription == null || boxDescription.getContainerPackagedMedicine() == null)
			return null;

		final PQ boxSize = boxDescription.getContainerPackagedMedicine().getCapacityQuantity();
		if (boxSize != null && boxSize.getValue() != null)
			return new Double(boxSize.getValue().doubleValue());
		return null;
	}

	/**
	 * Gets the units of the size of the box
	 *
	 * @return Units of the size of the box or null
	 */
	public Ucum getBoxDescriptionSizeUnits() {
		final PharmAsContent boxDescription = this.getMdht().getAsContent();
		if (boxDescription == null || boxDescription.getContainerPackagedMedicine() == null)
			return null;

		final PQ boxSize = boxDescription.getContainerPackagedMedicine().getCapacityQuantity();

		if (boxSize != null && boxSize.getUnit() != null) {
			for (Ucum boxSizeCode : Ucum.values()) {
				if (boxSizeCode.getCode().getCode().equalsIgnoreCase(boxSize.getUnit()))
					return boxSizeCode;
			}
		}
		return null;
	}

	/**
	 * Gets the ingredients of the manufactured material
	 *
	 * @return List of ingredients (or empty list)
	 *
	 */
	public PharmManufacturedMaterialEntry[] getIngredients() {

		if (this.getMdht().getIngredient() == null)
			return new PharmManufacturedMaterialEntry[0];

		// TODO Handle multiple ingredients
		final PharmManufacturedMaterialEntry[] listOfIngredients = new PharmManufacturedMaterialEntry[1];
		PharmManufacturedMaterialEntry ingredient = new PharmManufacturedMaterialEntry();
		ingredient.getMdht().setIngredient(this.getMdht().getIngredient());
		listOfIngredients[0] = ingredient;

		return listOfIngredients;
	}

	/**
	 * Gets the ATC code of the material
	 *
	 * @return ATC code or null
	 */
	public String getManufacturedMaterialAtcCode() {
		CE code = this.getMdht().getCode();
		if (code != null
				&& CodeSystems.WHOATCCode.getCodeSystemId().equalsIgnoreCase(code.getCodeSystem()))
			return code.getCode();
		return null;
	}

	/**
	 * Gets the form code of the material
	 *
	 * @return Form code of material or null if unknown
	 *
	 */
	public OrderableDrugForm getManufacturedMaterialFormCode() {
		CE formCode = this.getMdht().getFormCode();
		if (formCode != null) {
			for (OrderableDrugForm drugForm : OrderableDrugForm.values()) {
				if (drugForm.getCode().getCode().equalsIgnoreCase(formCode.getCode()))
					return drugForm;
			}
		}
		return null;
	}

	/**
	 * Gets the manufactured material lot number.
	 *
	 * @return the Lot number of material or null.
	 */
	public String getManufacturedMaterialLotNumber() {

		ST lotNumber = this.getMdht().getLotNumberText();
		if (lotNumber != null)
			return new String(lotNumber.getText());
		return null;
	}

	/**
	 * Gets the manufactured material name.
	 *
	 * @return the manufactured material name
	 */
	public String getManufacturedMaterialName() {
		EN name = this.getMdht().getName();
		if (name != null)
			return new String(name.getText());
		return null;
	}

	/**
	 *
	 * @param packageName
	 *            Commercial name
	 *
	 * @param packageGtin
	 *            GTIN of box
	 *
	 * @param formCode
	 *            Galenic form code
	 *
	 * @param packageSize
	 *            Number of "elements" in the box
	 *
	 * @param packageUnits
	 *            Only if not countable units
	 *
	 */
	public void setBoxDescription(String packageName, String packageGtin,
			OrderableDrugForm formCode, Double packageSize, Ucum packageUnits) {

		final PharmAsContent boxDescription = CdaUtilMdht.getMdhtCdaFactoryInstance()
				.createPharmAsContent();
		boxDescription.setClassCode(EntityClassManufacturedMaterial.CONT);

		final PharmPackagedMedicine packagedMedicine = CdaUtilMdht.getMdhtCdaFactoryInstance()
				.createPharmPackagedMedicine();

		packagedMedicine.setClassCode(EntityClassManufacturedMaterial.CONT);
		packagedMedicine.setDeterminerCode(EntityDeterminer.INSTANCE);

		if (packageGtin != null && packageGtin.length() > 0) {
			final CE codeAsContent = CdaUtilMdht.getMdhtDatatypesFactoryInstance().createCE();
			codeAsContent.setCode(new String(packageGtin));
			codeAsContent.setCodeSystem(CodeSystems.GTIN.getCodeSystemId());
			codeAsContent.setCodeSystemName(CodeSystems.GTIN.getCodeSystemName());
			if (packageName != null)
				codeAsContent.setDisplayName(new String(packageName));
			packagedMedicine.setCode(codeAsContent);
		}

		if (formCode != null) {
			final Code formCodeCode = formCode.getCode();
			final CE newFormCode = CdaUtilMdht.getMdhtDatatypesFactoryInstance().createCE(
					formCodeCode.getCode(), formCodeCode.getCodeSystem(),
					formCodeCode.getCodeSystemName(), formCodeCode.getDisplayName());
			packagedMedicine.setFormCode(newFormCode);
		}

		if (packageSize != null)
			packagedMedicine.setCapacityQuantity(
					CdaUtilMdht.getMdhtDatatypesFactoryInstance().createPQ(packageSize.doubleValue(),
							(packageUnits != null ? packageUnits.getCodeValue() : null)));

		if (packageName != null) {
			final EN mMname = CdaUtilMdht.getMdhtDatatypesFactoryInstance().createEN();
			mMname.addText(new String(packageName));
			packagedMedicine.setName(mMname);
		}

		boxDescription.setContainerPackagedMedicine(packagedMedicine);

		this.getMdht().setAsContent(boxDescription);
	}

	/**
	 * Sets the ATC code of the material
	 *
	 * @param atcCode
	 *            ATC code of material
	 * @param atcName
	 *            Name of ATC
	 *
	 */
	public void setManufacturedMaterialAtcCode(String atcCode, String atcName) {
		if (atcCode != null) {

			final CE codeMaterial = CdaUtilMdht.getMdhtDatatypesFactoryInstance().createCE();
			codeMaterial.setCodeSystem(CodeSystems.WHOATCCode.getCodeSystemId());
			codeMaterial.setCodeSystemName(CodeSystems.WHOATCCode.getCodeSystemName());
			codeMaterial.setCode(new String(atcCode));
			if (atcName != null)
				codeMaterial.setDisplayName(new String(atcName));

			this.getMdht().setCode(codeMaterial);
		}
	}

	/**
	 * Sets the form code of the material
	 *
	 * @param formCode
	 *            Form code of material
	 *
	 */
	public void setManufacturedMaterialFormCode(OrderableDrugForm formCode) {
		if (formCode != null) {
			final Code formCodeCode = formCode.getCode();
			final CE newFormCode = CdaUtilMdht.getMdhtDatatypesFactoryInstance().createCE(
					formCodeCode.getCode(), formCodeCode.getCodeSystem(),
					formCodeCode.getCodeSystemName(), formCodeCode.getDisplayName());
			this.getMdht().setFormCode(newFormCode);
		}
	}

	/**
	 * Sets the lot number
	 *
	 * @param lotNumber
	 *            Lot number of material
	 *
	 */
	public void setManufacturedMaterialLotNumber(String lotNumber) {

		if (lotNumber != null)
			this.getMdht().setLotNumberText(
					CdaUtilMdht.getMdhtDatatypesFactoryInstance().createST(lotNumber));
	}

	/**
	 * Sets the name of the material
	 *
	 * @param name
	 *            Name of material
	 *
	 */
	public void setManufacturedMaterialName(String name) {
		if (name != null)
			this.getMdht().setName(
					CdaUtilMdht.getMdhtDatatypesFactoryInstance().createEN().addText(new String(name)));
	}

	/**
	 * Null-flavor the material
	 *
	 */
	public void setNullFlavored() {
		this.getMdht().setNullFlavor(NullFlavor.NA);
	}
}
