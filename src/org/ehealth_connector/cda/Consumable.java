/********************************************************************************
*
* The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
* Year of publication: 2015
*
********************************************************************************/

package org.ehealth_connector.cda;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Util;
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
   * Erzeugt ein Objekt welches eine Substanz repräsentiert. Dieser Konstruktor wird verwendet, wenn ein leeres
   * Object initialisiert werden soll (true) oder codiert werden soll, dass die Substanz unbekannt ist (false)
   * 
   * @param currentProblems true: Erstellung eines leeren Objekts, false: Es sind keine Impfungen bekannt.
   */
  public Consumable(boolean consumableKnown) {
    this("Unbekannt");
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
   * @param gtin Packungs-GTIN, GLN oder swissINDEX. Diese ID MUSS ein GTIN, GLN, oder Swiss Index Code sein.
   * @see org.ehealth_connector.cda.ch.enums.CodeSystems
   */
  public Consumable(String tradeNameOfVaccine, Code gtin) {
    this(tradeNameOfVaccine, gtin, null);
  }

  /**
   * Erzeugt ein Objekt welches eine verabreichende Substanz repräsentiert. Dieses Objekt kann einer
   * ImmunizationRecommendation oder einer Immunization hinzugefügt werden. Wenn der Impfstoff resp. das Produkt nicht bekannt ist (z.B. im Ausland verabreichte Impfung), dann muss das Antigen mittels WHO ATC angegeben werden. Wenn in einem Produkt mehrere Antigene enthalten sind, MUSS das Immunization Element für jedes Antigen je einmal angegeben werden. 
   *
   * @param tradeNameOfVaccine Handelsname des Impfstoffes
   * @param gtinOrPharmacodeOrGln Packungs-GTIN, GLN oder swissINDEX (GLN ist veraltet)
   * @param whoAtcCode <br>
   * 		<div class="de"> who atc code</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   */
  public Consumable(String tradeNameOfVaccine, Code gtinOrPharmacodeOrGln, String whoAtcCode) {

    mConsumable = CDAFactory.eINSTANCE.createConsumable();
    mProductEntry = IHEFactory.eINSTANCE.createProductEntry().init();
    mMaterial = CDAFactory.eINSTANCE.createMaterial();

    mProductEntry.setManufacturedMaterial(mMaterial);
    mConsumable.setManufacturedProduct(mProductEntry);

    //The WhoAtcCode has to be present as code element, otherwise translations can´t be set
    setManufacturedProductId(Identificator.convertToIdentificator(gtinOrPharmacodeOrGln));
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
   * Adds the manufactured material code to the code element.
   *
   * @param code the new manufactured material code
   */
  private void addManufacturedMaterialCodeTranslation(Code code) {
    CD cd = EcoreUtil.copy(code.getCD());
    mMaterial.getCode().getTranslations().add(cd);
  }

  /**
   * <div class="de">Adds the manufactured material translation.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param codedId das codedId Objekt welches gesetzt wird
   */
  public void addManufacturedMaterialTranslation(Code codedId) {
    mMaterial.getCode().getTranslations().add(codedId.getCD());
  }

  /**
   * <div class="de">Copy mdht consumable.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
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
   * Gets the manufactured material translations.
   *
   * @return the manufactured material translations
   */
  public EList<CD> getManufacturedMaterialTranslations() {
    return mMaterial.getCode().getTranslations();
  }

  /**
   * Gets the product id from the ManufacturedProduct Ids oder the ManufacturedMaterial Code or the according translations
   *
   * @return the gtin or ean or swiss index, null otherwise
   */
  public Identificator getManufacturedProductId() {
    for (II id : mProductEntry.getIds()) {
      if (id.getRoot() != null && id.getRoot().equals(CodeSystems.GTIN.getCodeSystemId()) || id.getRoot() != null && id.getRoot().equals(CodeSystems.SwissINDEX.getCodeSystemId()) || id.getRoot() != null && id.getRoot().equals(CodeSystems.GLN.getCodeSystemId())) {
        Identificator ide = new Identificator(id);
        return ide;
      }
    }
//    if (Code.getTranslationOrCode(CodeSystems.GTIN.getCodeSystemId(), mMaterial.getCode())!=null) {
//      return Code.getTranslationOrCode(CodeSystems.GTIN.getCodeSystemId(), mMaterial.getCode());
//    }
//    if (Code.getTranslationOrCode(CodeSystems.GLN.getCodeSystemId(), mMaterial.getCode())!=null) {
//      return Code.getTranslationOrCode(CodeSystems.GLN.getCodeSystemId(), mMaterial.getCode());
//    }
//    if (Code.getTranslationOrCode(CodeSystems.SwissINDEX.getCodeSystemId(), mMaterial.getCode())!=null) {
//      return Code.getTranslationOrCode(CodeSystems.SwissINDEX.getCodeSystemId(), mMaterial.getCode());
//    }
    return null;
    //	  for (CD codeTranslation : getManufacturedMaterialTranslations()) {
    //			String codeTransStr = codeTranslation.getCodeSystem();
    //			if (codeTransStr.equals(CodeSystems.GTIN.getCodeSystemId()) || codeTransStr.equals(CodeSystems.GLN.getCodeSystemId()) || codeTransStr.equals(CodeSystems.SwissINDEX.getCodeSystemId())) {
    //				Code code = new Code(codeTranslation);
    //				return code;
    //			}
    //		}
    //		return null;
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
   * Gets the Lot Number (Chargennummer)
   * @return the Lot Number 
   */
  public String getLotNr() {
    if (this.mMaterial.getLotNumberText()!=null) {
      return this.mMaterial.getLotNumberText().getText();
    }
    return null;
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
   * Sets the manufactured product id. This ID HAS TO BE a GTIN, GLN, or Swiss Index Code
   * @see org.ehealth_connector.cda.ch.enums.CodeSystems
   *
   * @param gtinOrPharmacodeOrGln the new manufactured product id. If null, a NullFlavor.UNK will be set instead.
   */
  public void setManufacturedProductId(Identificator gtinOrPharmacodeOrGln) {
    if (gtinOrPharmacodeOrGln != null) {
      mProductEntry.getIds().clear();
      mProductEntry.getIds().add(gtinOrPharmacodeOrGln.getIi());
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
   * Sets the Lot Number (Chargennummer)
   * @param text
   */
  public void setLotNr(String text) {
    mMaterial.setLotNumberText(Util.st(text));
  }

  /**
   * Sets the trade name.
   *
   * @param tradeNameOfVaccine das tradeNameOfVaccine Objekt welches gesetzt wird
   */
  public void setTradeName(String tradeNameOfVaccine) {
    EN en = DatatypesFactory.eINSTANCE.createEN();
    if (tradeNameOfVaccine == null) {
      en.addText("Unknown");
    }
    else {
      en.addText(tradeNameOfVaccine);
    }
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
  
  /**
   * Sets the Organization that manufactured this product
   * @param organization the organization
   */
  public void setManufacturer(Organization organization) {
	  mProductEntry.setManufacturerOrganization(organization.copyMdhtOrganization());
  }
  
  /**
   * Gets the  Organization that manufactured this product
   * @return the organization
   */
  public Organization getManufacturer() {
	  if (mProductEntry!=null && mProductEntry.getManufacturerOrganization()!=null) {
		  return new Organization(mProductEntry.getManufacturerOrganization());
	  }
	return null;
  }
}
