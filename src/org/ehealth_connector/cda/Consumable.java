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

public class Consumable {

	// private org.openhealthtools.mdht.uml.cda.SubstanceAdministration mSubstanceAdministration;
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
	 * @param tradeNameOfVaccine Handelsname des Impfstoffes
	 * @param gtinOrPharmacodeOrGln Packungs-GTIN, GLN oder swissINDEX (GLN ist veraltet)
	 * @param whoACTCode WHO ATC Code des Impfstoffes
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
	 * @param codedId das codedId Objekt welches gesetzt wird
	 */
	public void addManufacturedMaterialTranslation(Code codedId) {
		mMaterial.getCode().getTranslations().add(codedId.getCD());
	}

	public org.openhealthtools.mdht.uml.cda.Consumable copyMdhtConsumable() {
		return EcoreUtil.copy(mConsumable);
	}

	/**
	 * @return das codedId Objekt
	 */
	public Code getManufacturedMaterialCode() {
		Code code = new Code(mMaterial.getCode());
		return code;
	}

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

	public EList<CD> getManufacturedMaterialTranslations() {
		return mMaterial.getCode().getTranslations();
	}

	public org.openhealthtools.mdht.uml.cda.Consumable getMdhtConsumable() {
		return EcoreUtil.copy(mConsumable);
	}

	/**
	 * @return das tradeNameOfVaccine Objekt
	 */
	public String getTradeName() {
		return mConsumable.getManufacturedProduct().getManufacturedMaterial().getName().getText();
	}

	/**
	 */
	public Code getWhoAtcCode() {

		return Code.getTranslationOrCode(CodeSystems.WHOATCCode.getCodeSystemId(), mMaterial.getCode()); 
		//		//Check if the code is nullFlavor
		//		Code code;
		//		if (mMaterial.getCode()!=null) {
		//			code = new Code (mMaterial.getCode());
		//			if (code.getOid().equals(CodeSystems.WHOATCCode.getCodeSystemId())) {
		//				return code;
		//			}
		//			else {
		//				for (CD codeTranslation : mMaterial.getCode().getTranslations()) {
		//					String codeTransStr = codeTranslation.getCodeSystem();
		//					if (codeTransStr.equals(CodeSystems.WHOATCCode.getCodeSystemId())) {
		//						code = new Code(codeTranslation);
		//						return code;
		//					}
		//				}
		//				return code;
		//			}  
		//		}
		//		return null;
	}

	public void setManufacturedMaterialCode(Code codedId) {
		CD cd = EcoreUtil.copy(codedId.getCD());
		mMaterial.getCode().getTranslations().add(cd);
	}

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
	 * @param tradeNameOfVaccine das tradeNameOfVaccine Objekt welches gesetzt wird
	 */
	public void setTradeName(String tradeNameOfVaccine) {
		EN en = DatatypesFactory.eINSTANCE.createEN();
		en.addText(tradeNameOfVaccine);
		mMaterial.setName(en);
	}

	/**
	 * @param whoActCode das WHOACTCode Objekt welches gesetzt wird
	 */
	public void setWhoAtcCode(String whoActCode) {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		if (whoActCode!=null) {
			ce.setCodeSystem(CodeSystems.WHOATCCode.getCodeSystemId());
			ce.setCode(whoActCode);
		}
		else {
			ce.setNullFlavor(NullFlavor.UNK);
		}
		mMaterial.setCode(ce);
	}
}
