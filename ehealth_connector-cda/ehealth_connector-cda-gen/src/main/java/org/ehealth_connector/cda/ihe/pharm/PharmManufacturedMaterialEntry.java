/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ihe.pharm;

import java.math.BigDecimal;
import java.util.Date;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.PharmAsContent;
import org.openhealthtools.mdht.uml.cda.PharmIngredient;
import org.openhealthtools.mdht.uml.cda.PharmPackagedMedicine;
import org.openhealthtools.mdht.uml.cda.PharmQuantity;
import org.openhealthtools.mdht.uml.cda.PharmSubstance;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.RTO;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityClassManufacturedMaterial;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityDeterminer;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityDeterminerDetermined;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClass;

/**
 * Implements the IHE PharmManufacturedMaterialEntry.
 */
public class PharmManufacturedMaterialEntry extends
		MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmManufacturedMaterialEntry> {

	/**
	 * Instantiates a new pharm manufactured product entry.
	 */
	public PharmManufacturedMaterialEntry() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new pharm manufactured product entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public PharmManufacturedMaterialEntry(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmManufacturedMaterialEntry().init());
		this.init();
	}

	/**
	 * Instantiates a new pharm manufactured product entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public PharmManufacturedMaterialEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmManufacturedMaterialEntry mdht) {
		super(mdht);
	}

	/**
	 * Gets the expiration time. NOTE for convenienc api: what is the correct resolution?
	 *
	 * @return the expiration time
	 */
	public Date getExpirationTime() {
		if (this.getMdht().getExpirationTime() != null) {
			return DateUtil.parseDateyyyyMMddHHmm(this.getMdht().getExpirationTime().getValue());
		}
		return null;
	}

	/**
	 * Gets the form code.
	 *
	 * @return the form code
	 */
	public Code getFormCode() {
		if (this.getMdht().getFormCode() != null) {
			return new Code(getMdht().getFormCode());
		}
		return null;
	}

	/**
	 * Gets the ingredient.
	 *
	 * @return the ingredient
	 */
	private PharmSubstance getIngredient() {
		if (this.getMdht() != null && this.getMdht().getIngredient() != null) {
			return this.getMdht().getIngredient().getIngredient();
		}
		return null;
	}

	/**
	 * Gets the ingredient code.
	 *
	 * @return the ingredient code
	 */
	public Code getIngredientCode() {
		PharmSubstance pharmIngredient = this.getIngredient();
		if (pharmIngredient != null && pharmIngredient.getCode() != null) {
			return new Code(pharmIngredient.getCode());
		}
		return null;
	}

	/**
	 * Gets the ingredient name.
	 *
	 * @return the ingredient name
	 */
	public String getIngredientName() {
		PharmSubstance pharmIngredient = this.getIngredient();
		if (pharmIngredient != null && pharmIngredient.getName() != null) {
			return pharmIngredient.getName().getText();
		}
		return null;
	}

	/**
	 * Gets the ingredient quantity.
	 *
	 * @return the ingredient quantity
	 */
	public Value getIngredientQuantity() {
		PharmIngredient pharmIngredient = this.getMdht().getIngredient();
		if (pharmIngredient != null && pharmIngredient.getQuantity() != null) {
			RTO rto = DatatypesFactory.eINSTANCE.createRTO();
			rto.setDenominator(pharmIngredient.getQuantity().getDenominator());
			rto.setNumerator(pharmIngredient.getQuantity().getNominator());
			return new Value(rto);
		}
		return null;
	}

	/**
	 * Gets the lot nr.
	 *
	 * @return the lot nr
	 */
	public String getLotNr() {
		if ((this.getMdht().getLotNumberText() != null)) {
			return this.getMdht().getLotNumberText().getText();
		}
		return null;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		if (this.getMdht().getName() != null) {
			return this.getMdht().getName().getText();
		}
		return null;
	}

	/**
	 * Gets the packaged medicine.
	 *
	 * @return the packaged medicine
	 */
	private PharmPackagedMedicine getPackagedMedicine() {
		if (this.getMdht() != null && this.getMdht().getAsContent() != null) {
			return getMdht().getAsContent().getAsContainerPackagedMedicine();
		}
		return null;
	}

	/**
	 * Gets the packaged medicine form code.
	 *
	 * @return the packaged medicine form code
	 */
	public Code getPackagedMedicineFormCode() {
		PharmPackagedMedicine packagedMedicine = getPackagedMedicine();
		if (packagedMedicine != null && packagedMedicine.getFormCode() != null) {
			return new Code(packagedMedicine.getFormCode());
		}
		return null;
	}

	/**
	 * Gets the packaged medicine name.
	 *
	 * @return the packaged medicine name
	 */
	public String getPackagedMedicineName() {
		PharmPackagedMedicine packagedMedicine = getPackagedMedicine();
		if (packagedMedicine != null && packagedMedicine.getName() != null) {
			return packagedMedicine.getName().getText();
		}
		return null;
	}

	/**
	 * Gets the packaged medicine product code.
	 *
	 * @return the packaged medicine product code
	 */
	public Code getPackagedMedicineProductCode() {
		PharmPackagedMedicine packagedMedicine = getPackagedMedicine();
		if (packagedMedicine != null && packagedMedicine.getCode() != null) {
			return new Code(packagedMedicine.getCode());
		}
		return null;
	}

	/**
	 * Gets the packaged medicine quantity.
	 *
	 * @return the packaged medicine quantity
	 */
	public BigDecimal getPackagedMedicineQuantity() {
		PharmPackagedMedicine packagedMedicine = getPackagedMedicine();
		if (packagedMedicine != null && packagedMedicine.getCapacityQuantity() != null) {
			return packagedMedicine.getCapacityQuantity().getValue();
		}
		return null;
	}

	/**
	 * Gets the who atc code.
	 *
	 * @return the who atc code
	 */
	public Code getWhoAtcCode() {
		if (this.getMdht().getCode() != null && this.getMdht().getCode().getCodeSystem() != null) {
			if (this.getMdht().getCode().getCodeSystem()
					.equals(CodeSystems.WHOATCCode.getCodeSystemId())) {
				return new Code(getMdht().getCode());
			}
		}
		return null;
	}

	/**
	 * Inits the class object.
	 */
	private void init() {
		this.getMdht().setClassCode(EntityClassManufacturedMaterial.MMAT);
		this.getMdht().setDeterminerCode(EntityDeterminerDetermined.KIND);

		if (this.getMdht().getAsContent() == null) {
			PharmAsContent pharmAsContent = CDAFactory.eINSTANCE.createPharmAsContent();
			pharmAsContent.setClassCode(EntityClassManufacturedMaterial.CONT);
			this.getMdht().setAsContent(pharmAsContent);
		}

		if (this.getMdht().getAsContent().getAsContainerPackagedMedicine() == null) {
			PharmPackagedMedicine packagedMedicine = CDAFactory.eINSTANCE
					.createPharmPackagedMedicine();
			packagedMedicine.setClassCode(EntityClassManufacturedMaterial.CONT);
			packagedMedicine.setDeterminerCode(EntityDeterminer.INSTANCE);
			this.getMdht().getAsContent().setAsContainerPackagedMedicine(packagedMedicine);
		}

		if (this.getMdht().getIngredient() == null) {
			PharmIngredient ingredient = CDAFactory.eINSTANCE.createPharmIngredient();
			ingredient.setClassCode(RoleClass.ACTI);
			this.getMdht().setIngredient(ingredient);
		}

		if (this.getMdht().getIngredient().getIngredient() == null) {
			PharmSubstance substance = CDAFactory.eINSTANCE.createPharmSubstance();
			substance.setClassCode(EntityClassManufacturedMaterial.MMAT);
			substance.setDeterminerCode(EntityDeterminer.KIND);
			this.getMdht().getIngredient().setIngredient(substance);
		}

	}

	/**
	 * Sets the expiration time.
	 *
	 * @param ts
	 *            the new expiration time
	 */
	public void setExpirationTime(Date ts) {

		if (ts != null) {
			this.getMdht().setExpirationTime(DateUtil.convertDate(ts));
		} else {
			this.getMdht().setExpirationTime(null);
		}
	}

	/**
	 * Sets the form code.
	 *
	 * @param formCode
	 *            the new form code
	 */
	public void setFormCode(Code formCode) {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		if (formCode != null) {
			ce = formCode.getCE();
		} else {
			ce.setNullFlavor(NullFlavor.UNK);
		}
		this.getMdht().setFormCode(ce);
		;
	}

	/**
	 * Sets the ingredient code.
	 *
	 * @param ingredientCode
	 *            the new ingredient code
	 */
	public void setIngredientCode(Code ingredientCode) {
		init();
		if (ingredientCode != null) {
			this.getMdht().getIngredient().getIngredient().setCode(ingredientCode.getCE());
		} else {
			this.getMdht().getIngredient().getIngredient().setCode(null);
		}
	}

	/**
	 * Sets the ingredient name.
	 *
	 * @param name
	 *            the new ingredient name
	 */
	public void setIngredientName(String name) {
		init();
		PharmSubstance pharmIngredient = this.getIngredient();
		if (name != null) {
			final EN en = DatatypesFactory.eINSTANCE.createEN();
			en.addText(name);
			pharmIngredient.setName(en);
		} else {
			pharmIngredient.setName(null);
		}
	}

	/**
	 * Sets the ingredient quantity.
	 *
	 * @param quantity
	 *            the new ingredient quantity
	 */
	public void setIngredientQuantity(Value quantity) {
		init();
		PharmIngredient pharmIngredient = this.getMdht().getIngredient();
		if (quantity != null) {
			if (pharmIngredient.getQuantity() == null) {
				PharmQuantity pharmQuantity = CDAFactory.eINSTANCE.createPharmQuantity();
				pharmIngredient.setQuantity(pharmQuantity);
				pharmQuantity.setDenominator(quantity.copyMdhtRto().getDenominator());
				pharmQuantity.setNominator(quantity.copyMdhtRto().getNumerator());
			}
		} else {
			pharmIngredient.setQuantity(null);
		}
	}

	/**
	 * Sets the lot nr.
	 *
	 * @param text
	 *            the new lot nr
	 */
	public void setLotNr(String text) {
		this.getMdht().setLotNumberText(Util.st(text));
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		final EN en = DatatypesFactory.eINSTANCE.createEN();
		en.addText(name);
		this.getMdht().setName(en);
	}

	/**
	 * Sets the packaged medicine form code.
	 *
	 * @param formCode
	 *            the new packaged medicine form code
	 */
	public void setPackagedMedicineFormCode(Code formCode) {
		init();
		if (formCode != null) {
			this.getMdht().getAsContent().getAsContainerPackagedMedicine()
					.setFormCode(formCode.getCE());
		} else {
			this.getMdht().getAsContent().getAsContainerPackagedMedicine().setFormCode(null);
		}
	}

	/**
	 * Sets the packaged medicine name.
	 *
	 * @param name
	 *            the new packaged medicine name
	 */
	public void setPackagedMedicineName(String name) {
		init();
		if (name != null) {
			final EN en = DatatypesFactory.eINSTANCE.createEN();
			en.addText(name);
			this.getMdht().getAsContent().getAsContainerPackagedMedicine().setName(en);
		} else {
			this.getMdht().getAsContent().getAsContainerPackagedMedicine().setName(null);
		}
	}

	/**
	 * Sets the packaged medicine product code.
	 *
	 * @param productCode
	 *            the new packaged medicine product code
	 */
	public void setPackagedMedicineProductCode(Code productCode) {
		init();
		if (productCode != null) {
			this.getMdht().getAsContent().getAsContainerPackagedMedicine()
					.setCode(productCode.getCE());
		} else {
			this.getMdht().getAsContent().getAsContainerPackagedMedicine().setCode(null);
		}
	}

	/**
	 * Sets the packaged medicine quantity.
	 *
	 * @param value
	 *            the new packaged medicine quantity
	 */
	public void setPackagedMedicineQuantity(BigDecimal value) {
		init();
		if (value != null) {
			final PQ pq = DatatypesFactory.eINSTANCE.createPQ();
			pq.setValue(value);
			this.getMdht().getAsContent().getAsContainerPackagedMedicine().setCapacityQuantity(pq);
		} else {
			this.getMdht().getAsContent().getAsContainerPackagedMedicine().setFormCode(null);
		}
	}

	/**
	 * Sets the who atc code (Use CodeSystem.WHOATCCode)
	 * 
	 * @param whoAtcCode
	 *            atc coe
	 */
	public void setWhoAtcCode(Code whoAtcCode) {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		if (whoAtcCode != null) {
			ce = whoAtcCode.getCE();
		} else {
			ce.setNullFlavor(NullFlavor.UNK);
		}
		this.getMdht().setCode(ce);
	}

}
