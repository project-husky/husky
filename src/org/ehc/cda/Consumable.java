package org.ehc.cda;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.CodeSystems;
import org.ehc.common.Code;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ProductEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

public class Consumable {

	// private org.openhealthtools.mdht.uml.cda.SubstanceAdministration mSubstanceAdministration;
	private org.openhealthtools.mdht.uml.cda.Consumable mConsumable;
	private Material mMaterial;
	private ProductEntry mProductEntry;

	/**
	 * Erzeugt ein Objekt welches eine verabreichende Substanz repräsentiert. Dieses Objekt kann einer
	 * ImmunizationRecommendation oder einer Immunization hinzugefügt werden.
	 * 
	 * @param codedId Packungs-GTIN, GLN oder swissINDEX
	 * @param tradeNameOfVaccine Handelsname des Impfstoffes
	 * @param whoACTCode WHO ATC Code des Impfstoffes
	 */
	public Consumable(Code codedId, String tradeNameOfVaccine, String whoAtcCode) {

		mConsumable = CDAFactory.eINSTANCE.createConsumable();
		mProductEntry = IHEFactory.eINSTANCE.createProductEntry().init();
		mMaterial = CDAFactory.eINSTANCE.createMaterial();

		mProductEntry.setManufacturedMaterial(mMaterial);
		mConsumable.setManufacturedProduct(mProductEntry);

		//    CE ce = DatatypesFactory.eINSTANCE.createCE();
		//    mMaterial.setCode(ce);

		setWHOACTCode(whoAtcCode);
		setCodedId(codedId);
		setTradeNameOfVaccine(tradeNameOfVaccine);
		mConsumable.setTypeCode(ParticipationType.CSM);
	}

	protected Consumable (org.openhealthtools.mdht.uml.cda.Consumable consumable) {
		setMdhtConsumable(consumable);
	}

	/**
	 * @return das codedId Objekt
	 */
	public Code getCodedId() {
		Code code = new Code(mConsumable.getManufacturedProduct().getManufacturedMaterial().getCode());
		return code;
	}

	public Code getGtinOrEanOrSwissIndex() {
		for (CD codeTranslation : mConsumable.getManufacturedProduct().getManufacturedMaterial().getCode().getTranslations()) {
			String codeTransStr = codeTranslation.getCodeSystem();
			if (codeTransStr.equals(CodeSystems.GTIN.getCodeSystemId()) || codeTransStr.equals(CodeSystems.GLN.getCodeSystemId()) || codeTransStr.equals(CodeSystems.SwissINDEX.getCodeSystemId())) {
				Code code = new Code(codeTranslation);
				return code;
			}
		}
		return null;
	}

	public org.openhealthtools.mdht.uml.cda.Consumable getMdhtConsumable() {
		return EcoreUtil.copy(mConsumable);
	}

	/**
	 * @return das tradeNameOfVaccine Objekt
	 */
	public String getTradeNameOfVaccine() {
		return mConsumable.getManufacturedProduct().getManufacturedMaterial().getName().getText();
	}

	/**
	 */
	public Code getWHOATCCode() {
		Code code;

		//Check if the code is nullFlavor
		if (mMaterial.getCode()!=null) {
			code = new Code (mMaterial.getCode());

			if (code.getOid().equals(CodeSystems.WHOATCCode.getCodeSystemId())) {
				return code;
			}
			else {
				for (CD codeTranslation : mMaterial.getCode().getTranslations()) {
					String codeTransStr = codeTranslation.getCodeSystem();
					if (codeTransStr.equals(CodeSystems.WHOATCCode.getCodeSystemId())) {
						code = new Code(codeTranslation);
						return code;
					}
				}
				return code;
			}  
		}
		return null;
	}

	/**
	 * @param codedId das codedId Objekt welches gesetzt wird
	 */
	public void setCodedId(Code codedId) {
		mConsumable.getManufacturedProduct().getManufacturedMaterial().getCode().getTranslations().add(codedId.getCD());
	}

	public void setGtin(Code codedId) {
		CD cd = EcoreUtil.copy(codedId.getCD());
		mMaterial.getCode().getTranslations().add(cd);
	}

	public void setMdhtConsumable(org.openhealthtools.mdht.uml.cda.Consumable consumable) {
		mConsumable = EcoreUtil.copy(consumable);
		mProductEntry = (ProductEntry) consumable.getManufacturedProduct();
		mMaterial = mProductEntry.getManufacturedMaterial();
	}

	/**
	 * @param tradeNameOfVaccine das tradeNameOfVaccine Objekt welches gesetzt wird
	 */
	public void setTradeNameOfVaccine(String tradeNameOfVaccine) {
		EN en = DatatypesFactory.eINSTANCE.createEN();
		en.addText(tradeNameOfVaccine);
		mMaterial.setName(en);
	}

	/**
	 * @param whoActCode das WHOACTCode Objekt welches gesetzt wird
	 */
	public void setWHOACTCode(String whoActCode) {
		//    CD cd = DatatypesFactory.eINSTANCE.createCD();
		//    cd.setCodeSystem("2.16.840.1.113883.6.73");
		//    cd.setCode(whoActCode);
		//    mMaterial.getCode().getTranslations().add(cd);

		//TODO Klären, ob das Setzen von Gtin als Code ausreichend ist.
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CodeSystems.WHOATCCode.getCodeSystemId());
		ce.setCode(whoActCode);
		mMaterial.setCode(ce);
	}

}
