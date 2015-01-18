package org.ehc.cda;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.Code;
import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ccd.CCDFactory;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ProductEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

public class Consumable {

  // private org.openhealthtools.mdht.uml.cda.SubstanceAdministration mSubstanceAdministration;
  private org.openhealthtools.mdht.uml.cda.Consumable mConsumable;
  private ManufacturedProduct mManufactoredProduct;
  private Material mMaterial;
  private ProductEntry mProductEntry;

  /**
   * Erzeugt ein Objekt welches eine verabreichende Substanz repräsentiert. Dieses Objekt kann einer
   * ImmunizationRecommendation oder einer Immunization hinzugefügt werden.
   * 
   * @param codedId Packungs-GTIN, GLN oder swissINDEX
   * @param endOfPossibleAppliance Ende des Zeitraums, in welchem die empfohlene Impfung verabreicht
   *        werden soll.
   * @param tradeNameOfVaccine Handelsname des Impfstoffes
   * @param whoACTCode WHO ACT Code des Impfstoffes
   */
  public Consumable(Code codedId, String tradeNameOfVaccine, String whoActCode) {

    this.mConsumable = CDAFactory.eINSTANCE.createConsumable();
    this.mProductEntry = IHEFactory.eINSTANCE.createProductEntry().init();
    this.mMaterial = CDAFactory.eINSTANCE.createMaterial();
    
    mProductEntry.setManufacturedMaterial(mMaterial);
    mConsumable.setManufacturedProduct(mProductEntry);
    
    CE ce = DatatypesFactory.eINSTANCE.createCE();
    mMaterial.setCode(ce);

    this.setCodedId(codedId);
    this.setTradeNameOfVaccine(tradeNameOfVaccine);
    this.setWHOACTCode(whoActCode);
    this.mConsumable.setTypeCode(ParticipationType.CSM);
  }

  /**
   * @return das codedId Objekt
   */
  public Code getCodedId() {
    Code code = new Code(mConsumable.getManufacturedProduct().getManufacturedMaterial().getCode());
    return code;
  }


  /**
   * @return das tradeNameOfVaccine Objekt
   */
  public String getTradeNameOfVaccine() {
    return mConsumable.getManufacturedProduct().getManufacturedMaterial().getName().getText();
  }

  /**
   * @param codedId das codedId Objekt welches gesetzt wird
   */
  public void setCodedId(Code codedId) {
    this.mConsumable.getManufacturedProduct().getManufacturedMaterial().getCode().getTranslations().add(codedId.getCD());
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
  CE ce = mMaterial.getCode();
  ce.setCodeSystem("2.16.840.1.113883.6.73");
  ce.setCode(whoActCode);
    mMaterial.setCode(ce);

  }

  public org.openhealthtools.mdht.uml.cda.Consumable getMdhtConsumable() {
    return this.mConsumable;
  }
  
  public void setGtin(Code codedId) {
    CD cd = EcoreUtil.copy(codedId.getCD());
    mMaterial.getCode().getTranslations().add(cd);
  }

}
