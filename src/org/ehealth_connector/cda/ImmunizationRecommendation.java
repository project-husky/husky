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

// TODO: Auto-generated Javadoc
/**
 * Eine Impfempfehlung.
 */
public class ImmunizationRecommendation {

	private org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation mImmunizationRecommendation;

	/**
	 * Instantiates a new immunization recommendation.
	 */
	public ImmunizationRecommendation() {
		mImmunizationRecommendation = CHFactory.eINSTANCE.createImmunizationRecommendation().init();
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

		this(consumable, author, startOfPossibleAppliance, endOfPossibleAppliance, intendedOrProposed, shallNotBeAdministerd, null, null, null, null);
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
	 * @param priority 
	 * 			Dringlichkeit der Einnahme. Bei null wird auf die Angabe der Dringlichkeit verzichtet
	 * @param routeOfAdministration 
	 * 			Art der Einnahme. Bei null wird auf die Angabe der Einnahmeart verzichtet
	 * @param approachSiteCode
	 * 			Bei null wird auf die Angabe verzichtet.
	 * @param doseQuantity
	 * 			Dosis. Bei null wird auf die Angabe der Dosis verzichtet.
	 * @param rateQuantity
	 * 			Einnahmefrequenz. Bei null wird auf die Angabe der Einnahmefrequenz verzichtet.
	 */
	private ImmunizationRecommendation (Consumable consumable,
			org.ehealth_connector.common.Author author, Date startOfPossibleAppliance, Date endOfPossibleAppliance,
			boolean intendedOrProposed, boolean shallNotBeAdministerd, String priority, RouteOfAdministration routeOfAdministration, String doseQuantity, String rateQuantity) {      

		mImmunizationRecommendation = CHFactory.eINSTANCE.createImmunizationRecommendation().init();
		mImmunizationRecommendation.setConsumable(consumable.copyMdhtConsumable());  

		//Set the Attributes of this class
		setId(null);
		setIntendedOrProposed(intendedOrProposed);
		setShallNotBeAdministerd(shallNotBeAdministerd);
		setPossibleAppliance(startOfPossibleAppliance, endOfPossibleAppliance);
		mImmunizationRecommendation.getAuthors().add(author.getAuthorMdht());

		//Fix the TemplateID Extension of the CDA-CH.Body.MediL3 Template
		List<II> templateIds = mImmunizationRecommendation.getTemplateIds();
		for (II templateId: templateIds) {
			if (templateId.getRoot().equals("2.16.756.5.30.1.1.1.1.1")) {
				templateId.setExtension("CDA-CH.Body.MediL3");
			}
		}

		//TODO Later: Also consider real (Enum-) values here
		//Set the null values
		if (priority == null) {
			mImmunizationRecommendation.setPriorityCode(Util.createCENullFlavorNASK());
		}
		if (routeOfAdministration == null) {
			mImmunizationRecommendation.setRouteCode(Util.createCENullFlavorNASK());
		}
		if (doseQuantity == null) {
			mImmunizationRecommendation.setDoseQuantity(Util.createIVL_PQNullFlavorNASK());
		}
		if (rateQuantity == null) {
			mImmunizationRecommendation.setRateQuantity(Util.createIVL_PQNullFlavorNASK());
		}    
	}

	/**
	 * Instantiates a new immunization recommendation.
	 *
	 * @param immunizationRecommendation <br>
	 * 		<div class="de"> immunization recommendation</div>
	 * 		<div class="fr"> immunization recommendation</div>
	 * 		<div class="it"> immunization recommendation</div>
	 */
	public ImmunizationRecommendation (org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation immunizationRecommendation) {
		mImmunizationRecommendation = immunizationRecommendation;
	}

	/**
	 * <div class="de">Copy mdht immunization recommendation.</div>
	 * <div class="fr">Copy mdht immunization recommendation.</div>
	 * <div class="it">Copy mdht immunization recommendation.</div>
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
	 * Gets the effective time.
	 *
	 * @return the effective time
	 */
	public String getEffectiveTime() {
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
		mImmunizationRecommendation.getAuthors().add(author.getAuthorMdht());
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
	 * Sets the intended or proposed.
	 *
	 * @param intendedOrProposed          das intendedOrProposed Objekt welches gesetzt wird
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
	 * <div class="de">Sets the possible appliance.</div>
	 * <div class="fr">Sets the possible appliance.</div>
	 * <div class="it">Sets the possible appliance.</div>
	 *
	 * @param startOfPossibleAppliacne <br>
	 * 		<div class="de"> start of possible appliacne</div>
	 * 		<div class="fr"> start of possible appliacne</div>
	 * 		<div class="it"> start of possible appliacne</div>
	 * @param endOfPossibleAppliance          das endOfPossibleAppliance Objekt welches gesetzt wird
	 */
	public void setPossibleAppliance(Date startOfPossibleAppliacne, Date endOfPossibleAppliance) {
		mImmunizationRecommendation.getEffectiveTimes().add(0, DateUtil.createSTCM_TS(startOfPossibleAppliacne, endOfPossibleAppliance));
	}  

	/**
	 * Sets the shall not be administerd.
	 *
	 * @param shallNotBeAdministerd          das shallNotBeAdministerd Objekt welches gesetzt wird
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
