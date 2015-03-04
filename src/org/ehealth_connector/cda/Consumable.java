/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ProductEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

/**
 * <div class="de">Ein konsumierbares Produkt</div>\n
 * <div class="fr"></div>\n
 * <div class="it"></div>
 */
public class Consumable {

	private org.openhealthtools.mdht.uml.cda.Consumable mConsumable;
	private Material mMaterial;
	private ProductEntry mProductEntry;

	protected Consumable (org.openhealthtools.mdht.uml.cda.Consumable consumable) {
		setMdhtConsumable(consumable);
	}

	/**
	 * Erzeugt ein Objekt welches eine verabreichende Substanz repräsentiert. Dieses Objekt kann einer
	 * ImmunizationRecommendation oder einer Immunization hinzugefügt werden.
	 * @param tradeNameOfVaccine Handelsname des Impfstoffes
	 */
	public Consumable(String tradeNameOfVaccine) {
		this(tradeNameOfVaccine, null);
	}

	/**
	 * Erzeugt ein Objekt welches eine verabreichende Substanz repräsentiert. Dieses Objekt kann einer
	 * ImmunizationRecommendation oder einer Immunization hinzugefügt werden.
	 * @param tradeNameOfVaccine Handelsname des Impfstoffes
	 * @param gtin Packungs-GTIN, GLN oder swissINDEX
	 */
	public Consumable(String tradeNameOfVaccine, Code gtin) {
		this(tradeNameOfVaccine, gtin, null);
	}

	/**
	 * Erzeugt ein Objekt welches eine verabreichende Substanz repräsentiert. Dieses Objekt kann einer
	 * ImmunizationRecommendation oder einer Immunization hinzugefügt werden.
	 *
	 * @param tradeNameOfVaccine Handelsname des Impfstoffes
	 * @param gtinOrPharmacodeOrGln Packungs-GTIN, GLN oder swissINDEX (GLN ist veraltet)
	 * @param whoAtcCode <br>
	 * 		<div class="de"> who atc code</div>
	 * 		<div class="fr"> who atc code</div>
	 * 		<div class="it"> who atc code</div>
	 */
	public Consumable(String tradeNameOfVaccine, Code gtinOrPharmacodeOrGln, String whoAtcCode) {

		mConsumable = CDAFactory.eINSTANCE.createConsumable();
		mProductEntry = IHEFactory.eINSTANCE.createProductEntry().init();
		mMaterial = CDAFactory.eINSTANCE.createMaterial();

		mProductEntry.setManufacturedMaterial(mMaterial);
		mConsumable.setManufacturedProduct(mProductEntry);

		//The WhoAtcCode has to be present as code element, otherwise translations can´t be set
		setManufacturedProductId(gtinOrPharmacodeOrGln);
		if (whoAtcCode!=null) {
			setWhoAtcCode(whoAtcCode);
			addManufacturedMaterialTranslation(gtinOrPharmacodeOrGln);
		}
		else {
			setWhoAtcCode(null);
		}
		setTradeName(tradeNameOfVaccine);
		mConsumable.setTypeCode(ParticipationType.CSM);
	}

	/**
	 * <div class="de">Adds the manufactured material translation.</div>
	 * <div class="fr">Adds the manufactured material translation.</div>
	 * <div class="it">Adds the manufactured material translation.</div>
	 *
	 * @param codedId das codedId Objekt welches gesetzt wird
	 */
	public void addManufacturedMaterialTranslation(Code codedId) {
		mMaterial.getCode().getTranslations().add(codedId.getCD());
	}

	/**
	 * <div class="de">Copy mdht consumable.</div>
	 * <div class="fr">Copy mdht consumable.</div>
	 * <div class="it">Copy mdht consumable.</div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda. consumable
	 */
	public org.openhealthtools.mdht.uml.cda.Consumable copyMdhtConsumable() {
		return EcoreUtil.copy(mConsumable);
	}

	/**
	 * Gets the manufactured material code.
	 *
	 * @return das codedId Objekt
	 */
	public Code getManufacturedMaterialCode() {
		Code code = new Code(mMaterial.getCode());
		return code;
	}

	/**
	 * Gets the manufactured material translation gtin or ean or swiss index.
	 *
	 * @return the manufactured material translation gtin or ean or swiss index
	 */
	public Code getManufacturedMaterialTranslationGtinOrEanOrSwissIndex() {
		for (CD codeTranslation : getManufacturedMaterialTranslations()) {
			String codeTransStr = codeTranslation.getCodeSystem();
			if (codeTransStr.equals(CodeSystems.GTIN.getCodeSystemId()) || codeTransStr.equals(CodeSystems.GLN.getCodeSystemId()) || codeTransStr.equals(CodeSystems.SwissINDEX.getCodeSystemId())) {
				Code code = new Code(codeTranslation);
				return code;
			}
		}
		return null;
	}

	/**
	 * Gets the manufactured material translations.
	 *
	 * @return the manufactured material translations
	 */
	public EList<CD> getManufacturedMaterialTranslations() {
		return mMaterial.getCode().getTranslations();
	}

	/**
	 * Gets the mdht consumable.
	 *
	 * @return the mdht consumable
	 */
	public org.openhealthtools.mdht.uml.cda.Consumable getMdhtConsumable() {
		return EcoreUtil.copy(mConsumable);
	}

	/**
	 * Gets the trade name.
	 *
	 * @return das tradeNameOfVaccine Objekt
	 */
	public String getTradeName() {
		return mConsumable.getManufacturedProduct().getManufacturedMaterial().getName().getText();
	}

	/**
	 * <div class="en">Gets the who atc code.</div>
	 * <div class="de">Liefert who atc code.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return Code <div class="en">the who atc code</div>
	 */
	public Code getWhoAtcCode() {
		return Code.getTranslationOrCode(CodeSystems.WHOATCCode.getCodeSystemId(), mMaterial.getCode()); 
	}

	/**
	 * Sets the manufactured material code.
	 *
	 * @param codedId the new manufactured material code
	 */
	public void setManufacturedMaterialCode(Code codedId) {
		CD cd = EcoreUtil.copy(codedId.getCD());
		mMaterial.getCode().getTranslations().add(cd);
	}

	/**
	 * Sets the manufactured product id.
	 *
	 * @param gtinOrPharmacodeOrGln the new manufactured product id
	 */
	public void setManufacturedProductId(Code gtinOrPharmacodeOrGln) {
		if (gtinOrPharmacodeOrGln != null) {
			mProductEntry.getIds().add(Identificator.convertToIdentificator(gtinOrPharmacodeOrGln).getIi());
		}
		else {
			II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setNullFlavor(NullFlavor.UNK);
			mProductEntry.getIds().add(ii);
		}
	}

	protected void setMdhtConsumable(org.openhealthtools.mdht.uml.cda.Consumable consumable) {
		mConsumable = EcoreUtil.copy(consumable);
		mProductEntry = (ProductEntry) consumable.getManufacturedProduct();
		mMaterial = mProductEntry.getManufacturedMaterial();
	}

	/**
	 * Sets the trade name.
	 *
	 * @param tradeNameOfVaccine das tradeNameOfVaccine Objekt welches gesetzt wird
	 */
	public void setTradeName(String tradeNameOfVaccine) {
		EN en = DatatypesFactory.eINSTANCE.createEN();
		en.addText(tradeNameOfVaccine);
		mMaterial.setName(en);
	}

	/**
	 * Sets the who atc code.
	 *
	 * @param whoAtcCode das WHOATcCode Objekt welches gesetzt wird
	 */
	public void setWhoAtcCode(String whoAtcCode) {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		if (whoAtcCode!=null) {
			ce.setCodeSystem(CodeSystems.WHOATCCode.getCodeSystemId());
			ce.setCode(whoAtcCode);
		}
		else {
			ce.setNullFlavor(NullFlavor.UNK);
		}
		mMaterial.setCode(ce);
	}
}
