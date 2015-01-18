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
* Year of publication: 2014
*
*******************************************************************************/

package org.ehc.cda;

import java.util.Date;
import java.util.List;

import org.ehc.common.Author;
import org.ehc.common.Code;
import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Eine Impfempfehlung
 */
public class ImmunizationRecommendation {
  
	private org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation mImmunizationRecommendation;
	
	/**
	 * Erzeugt ein Objekt welches eine Impfempfehlung repräsentiert. Dieses Objekt
	 * kann einer ImmunizationRecommendationsSection hinzugefügt werden.
	 * 
	 * @param intendedOrProposed
	 *          true, bei einer beabsichtigten, aber noch nicht erfolgten Impfung.
	 *          false bei einer vorgeschlagenen Impfung.
	 * @param shallNotBeAdministerd
	 *          true, wenn die Impfung nicht verabreicht werden soll. false, wenn
	 *          die Impfung zu verabreichen ist.
	 * @param codedId
	 *          Packungs-GTIN, GLN oder swissINDEX
	 * @param startOfPossibleAppliance
	 *          Start des Zeitraums, in welchem die empfohlene Impfung verabreicht
	 *          werden soll.
	 * @param endOfPossibleAppliance
	 *          Ende des Zeitraums, in welchem die empfohlene Impfung verabreicht
	 *          werden soll.
	 * @param tradeNameOfVaccine
	 *          Handelsname des Impfstoffes
	 * @param whoACTCode
	 *          WHO ACT Code des Impfstoffes
	 * @param author
     *          Arzt, der diese Eintragung veranlasst hat
	 */
	public ImmunizationRecommendation (boolean intendedOrProposed,
			boolean shallNotBeAdministerd, Date startOfPossibleAppliance, Date endOfPossibleAppliance,
			Code codedId, String tradeNameOfVaccine, String whoACTCode, org.ehc.common.Author author) {      
	    mImmunizationRecommendation = CHFactory.eINSTANCE.createImmunizationRecommendation().init();
	    Consumable consumable = new Consumable(codedId, tradeNameOfVaccine, whoACTCode);
	    mImmunizationRecommendation.setConsumable(consumable.getMdhtConsumable());

	    this.setCodedId(codedId);
        this.setIntendedOrProposed(intendedOrProposed);
        this.setShallNotBeAdministerd(shallNotBeAdministerd);
        this.setPossibleAppliance(startOfPossibleAppliance, endOfPossibleAppliance);
        this.getEffectiveTime();
        this.mImmunizationRecommendation.getAuthors().add(author.getAuthorMdht());
	}
	
    public ImmunizationRecommendation (org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation immunizationRecommendation) {
      setMdhtImmunizationRecommendation(immunizationRecommendation);
    }
	
	
	
	private void setCodedId(Code codedId) {
	  //Seems dirty, but the Spec wants it like this
	  II ii = DatatypesFactory.eINSTANCE.createII(codedId.getCD().getCodeSystem(), codedId.getCode());
	  mImmunizationRecommendation.getIds().add(ii);
    }

  /**
	 * @param endOfPossibleAppliance
	 *          das endOfPossibleAppliance Objekt welches gesetzt wird
	 */
	public void setPossibleAppliance(Date startOfPossibleAppliacne, Date endOfPossibleAppliance) {
	  mImmunizationRecommendation.getEffectiveTimes().add(0, Util.createSTCM_TS(startOfPossibleAppliacne, endOfPossibleAppliance));
	}

	/**
	 * @param intendedOrProposed
	 *          das intendedOrProposed Objekt welches gesetzt wird
	 */
	public void setIntendedOrProposed(boolean intendedOrProposed) {
	  if (intendedOrProposed) {
	    mImmunizationRecommendation.setMoodCode(x_DocumentSubstanceMood.INT);
	  }
	  else {
	    mImmunizationRecommendation.setMoodCode(x_DocumentSubstanceMood.PRP);
	  }
	  
	}

	/**
	 * @param shallNotBeAdministerd
	 *          das shallNotBeAdministerd Objekt welches gesetzt wird
	 */
	public void setShallNotBeAdministerd(boolean shallNotBeAdministerd) {
	    if (shallNotBeAdministerd) {
	      mImmunizationRecommendation.setNegationInd(true);
	    }
	    else {
	      mImmunizationRecommendation.setNegationInd(false);
	    }
	}
	
	public org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation getMdhtImmunizationRecommendation() {
	  return this.mImmunizationRecommendation;
	}

	   public void setMdhtImmunizationRecommendation(org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation immunizationRecommendation) {
	      this.mImmunizationRecommendation = immunizationRecommendation;
	    }
	
  public String getVaccineName() {
    return this.mImmunizationRecommendation.getConsumable().getManufacturedProduct().getManufacturedMaterial().getName().getText();
  }

  public String getEffectiveTime() {
     List<SXCM_TS> effectiveTimes = this.mImmunizationRecommendation.getEffectiveTimes();
     return Util.convertSXCM_TSToEurString(effectiveTimes);
  }
  
  public org.ehc.common.Author getAuthor() {
    try {
      org.openhealthtools.mdht.uml.cda.Author author = mImmunizationRecommendation.getAuthors().get(0);
      return new Author(author);
  } catch(IndexOutOfBoundsException e) {
      // no author available
      return null;
  }
  }
}
