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

import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.RouteOfAdministration;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Dieses Element enthält den empfohlenen Impfplan für den Patienten. Zudem kann zur Begründung ein Verweis auf entsprechende Guidelines angegeben werden.
 * Dieses Kapitel ist KONDITIONAL und nur dann erforderlich, wenn es sich beim Dokument um die Antwort aus einem Expertensystem für Impfempfehlungen handelt (Clinical Decision Support System; CDSS) oder wenn beabsichtigte aber noch nicht erfolgte Impfungen dokumentiert werden.
 */
public class ImmunizationRecommendation {

	private org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation mImmunizationRecommendation;

	/**
	 * Instantiates a new immunization recommendation.
	 */
	public ImmunizationRecommendation() {
		mImmunizationRecommendation = CHFactory.eINSTANCE.createImmunizationRecommendation().init();
		
	    //Fix the TemplateID Extension of the CDA-CH.Body.MediL3 Template
        List<II> templateIds = mImmunizationRecommendation.getTemplateIds();
        for (II templateId: templateIds) {
            if (templateId.getRoot().equals("2.16.756.5.30.1.1.1.1.1")) {
                templateId.setExtension("CDA-CH.Body.MediL3");
            }
        }
        
        //Set the null values       
        mImmunizationRecommendation.setPriorityCode(Util.createCENullFlavorNASK());
        mImmunizationRecommendation.setRouteCode(Util.createCENullFlavorNASK());
        mImmunizationRecommendation.setDoseQuantity(Util.createIVL_PQNullFlavorNASK());
        mImmunizationRecommendation.setRateQuantity(Util.createIVL_PQNullFlavorNASK());   
	}

	/**
	 * Erzeugt ein Objekt welches eine Impfempfehlung repräsentiert. Dieses Objekt
	 * kann einer ImmunizationRecommendationsSection hinzugefügt werden.
	 * @param consumable 
	 * 			Impfstoff, der empfohlen wird
	 * @param author
	 *          Arzt, der diese Eintragung veranlasst hat
	 * @param startOfPossibleAppliance
	 * 			Beginn des Zeitraumes, in dem die Impfung erfolgen sollte
	 * @param endOfPossibleAppliance 
	 * 			Ende des Zeitraumes, in dem die Impfung erfolgen sollte
	 * @param intendedOrProposed
	 *          true, bei einer beabsichtigten, aber noch nicht erfolgten Impfung.
	 *          false bei einer vorgeschlagenen Impfung.
	 * @param shallNotBeAdministerd
	 *          true, wenn die Impfung nicht verabreicht werden soll. false, wenn
	 *          die Impfung zu verabreichen ist.
	 */
	public ImmunizationRecommendation (Consumable consumable,
			org.ehealth_connector.common.Author author, Date startOfPossibleAppliance, Date endOfPossibleAppliance,
			boolean intendedOrProposed, boolean shallNotBeAdministerd) {      

	    this();
		setConsumable(consumable);

		//Set the Attributes of this class
		setId(null);
		setIntendedOrProposed(intendedOrProposed);
		setShallNotBeAdministerd(shallNotBeAdministerd);
		setPossibleAppliance(startOfPossibleAppliance, endOfPossibleAppliance);
		setAuthor(author);
	}

	
	/**
	 * Sets the consumable.
	 *
	 * @param consumable the new consumable
	 */
	public void setConsumable(Consumable consumable) {
      mImmunizationRecommendation.setConsumable(consumable.copyMdhtConsumable());  
    }
	
	/**
	 * Instantiates a new immunization recommendation.
	 *
	 * @param immunizationRecommendation <br>
	 * 		<div class="de">Impfempfehlung</div>
	 * 		<div class="fr"></div>
	 * 		<div class="it"></div>
	 */
	public ImmunizationRecommendation (org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation immunizationRecommendation) {
		mImmunizationRecommendation = immunizationRecommendation;
	}

	/**
	 * <div class="de">Copy mdht immunization recommendation.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.ch. immunization recommendation
	 */
	public org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation copyMdhtImmunizationRecommendation() {
		return EcoreUtil.copy(mImmunizationRecommendation);
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public org.ehealth_connector.common.Author getAuthor() {
		try {
			org.openhealthtools.mdht.uml.cda.Author author = EcoreUtil.copy(mImmunizationRecommendation.getAuthors().get(0));
			return new Author(author);
		} catch(IndexOutOfBoundsException e) {
			// no author available
			return null;
		}
	}

	/**
	 * Gets the consumable.
	 *
	 * @return the consumable
	 */
	public Consumable getConsumable() {
		Consumable consumable = new Consumable(mImmunizationRecommendation.getConsumable());
		return consumable;
	}

    /**
     * <div class="de">Liefert, den Zeitraum, in dem die Impfung verabreicht werden soll als String (z.B. "01.01.2015 - 01.03.1015")</div>
     * <div class="fr"></div>
     * <div class="it"></div>
     *
     * @return 
     *      <div class="de">Zeitraum, in dem die Impfung verabreicht werden soll als String</div>
     *      <div class="fr"></div>
     *      <div class="it"></div>
     */
	public String getPossibleAppliance() {
		List<SXCM_TS> effectiveTimes = mImmunizationRecommendation.getEffectiveTimes();
		return DateUtil.convertSXCM_TSToEurString(effectiveTimes);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = new Identificator(mImmunizationRecommendation.getIds().get(0));
		return id;
	}
	
    /**
     * <div class="de">Gibt zurück, ob eine Impfung beabsichtigt, aber noch nicht erfolgt, oder vorgeschlagen ist (moodCode).</div>
     * <div class="fr"></div>
     * <div class="it"></div>
     * @return true, wenn eine Impfung beabsichtigt, aber noch nicht erfolgt ist. false, wenn eine Impfung vorgeschlagen ist.
     */
	public boolean getIntendedOrProposed() {
	  if (mImmunizationRecommendation.getMoodCode().equals(x_DocumentSubstanceMood.INT)) return true;
	  if (mImmunizationRecommendation.getMoodCode().equals(x_DocumentSubstanceMood.PRP)) return false;
	  return true;
	}
	
	 /**
     * <div class="de">Gibt an, ob eine Impfung nicht verabreicht werden soll.</div>
     * <div class="fr"></div>
     * <div class="it"></div>
     *
     * @return true, wenn die Impfung nicht verabreicht werden soll, sonst false
     */
    public boolean gettShallNotBeAdministerd() {
       return mImmunizationRecommendation.getNegationInd();
    }

	/**
	 * Gets the mdht immunization recommendation.
	 *
	 * @return the mdht immunization recommendation
	 */
	public org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation getMdhtImmunizationRecommendation() {
		return mImmunizationRecommendation;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(org.ehealth_connector.common.Author author) {
	    mImmunizationRecommendation.getAuthors().clear();
		mImmunizationRecommendation.getAuthors().add(author.copyMdhtAuthor());
	}

	/**
	 * Sets the id.
	 *
	 * @param codedId the new id
	 */
	public void setId(Identificator codedId) {
		II ii = Util.createUuidVacdIdentificator(codedId);
		mImmunizationRecommendation.getIds().add(ii);
	}

	/**
     * <div class="de">Setzt, ob eine Impfung beabsichtigt, aber noch nicht erfolgt, oder vorgeschlagen ist (moodCode).</div>
     * <div class="fr"></div>
     * <div class="it"></div>
	 * @param intendedOrProposed true, wenn eine Impfung beabsichtigt, aber noch nicht erfolgt ist. false, wenn eine Impfung vorgeschlagen ist.
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
	 * <div class="de">Setzt, den Zeitraum, in dem die Impfung verabreicht werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param startOfPossibleAppliacne <br>
	 * 		<div class="de">Startpunkt des Zeitraumes, wann die Impfung verabreicht werden soll.</div>
	 * 		<div class="fr"></div>
	 * 		<div class="it"></div>
	 * @param endOfPossibleAppliance          
	 * 		<div class="de">Endpunkt des Zeitraumes, wann die Impfung verabreicht werden soll.</div>
	 * 		<div class="fr"></div>
	 * 		<div class="it"></div>
	 */
	public void setPossibleAppliance(Date startOfPossibleAppliacne, Date endOfPossibleAppliance) {
		mImmunizationRecommendation.getEffectiveTimes().add(0, DateUtil.createSTCM_TS(startOfPossibleAppliacne, endOfPossibleAppliance));
	}  

	/**
	 * <div class="de">Gibt an, ob eine Impfung nicht verabreicht werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param shallNotBeAdministerd
	 *      <div class="de">true, wenn die Impfung nicht verabreicht werden soll, sonst false</div>
     *      <div class="fr"></div>
     *      <div class="it"></div>
	 */
	public void setShallNotBeAdministerd(boolean shallNotBeAdministerd) {
		if (shallNotBeAdministerd) {
			mImmunizationRecommendation.setNegationInd(true);
		}
		else {
			mImmunizationRecommendation.setNegationInd(false);
		}
	}


}
