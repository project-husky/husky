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
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

import com.sun.istack.internal.Nullable;

/**
 * Dieses Element enthält die verabreichten Impfungen und die ausdrücklich nicht erwünschten Impfungen.
 */
public class Immunization {

	private org.openhealthtools.mdht.uml.cda.ihe.Immunization mImmunization;

	/**
	 * Instantiates a new immunization.
	 */
	public Immunization() {
		mImmunization = CHFactory.eINSTANCE.createImmunization().init();
		mImmunization.setNegationInd(Boolean.FALSE);
		
	    //Fix the TemplateID Extension of the CDA-CH.Body.MediL3 Template
        List<II> templateIds = mImmunization.getTemplateIds();
        for (II templateId: templateIds) {
            if (templateId.getRoot().equals("2.16.756.5.30.1.1.1.1.1")) {
                templateId.setExtension("CDA-CH.Body.MediL3");
            }
        }
        
        setPriorityCode(createPriorityCode());
	}

	/**
	 * Dieses Element enthält die verabreichten Impfungen und die ausdrücklich nicht erwünschten Impfungen. 
	 *
	 * @author author Die eintragende Person
	 * @param consumable Impfstoff
	 * @param author <br>
	 * 		<div class="de">Autor der Impfung</div>
	 * 		<div class="fr"></div>
	 * 		<div class="it"></div>
	 * @param appliedAt Datum der Impfung
	 */
	public Immunization(Consumable consumable, Author author, Date appliedAt) {
	    this();
	    mImmunization.setNegationInd(Boolean.FALSE);

		//mImmunization.setText(createText());
		setApplyDate(appliedAt);
		setId(null);
		setConsumable(consumable);
		setAuthor(author);
	}

	/**
	 * Dieses Element enthält die verabreichten Impfungen und die ausdrücklich nicht erwünschten Impfungen. 
	 *
	 * @author author Die eintragende Person
	 * @param consumable Impfstoff
	 * @param author <br>
	 * 		<div class="de">Autor der Impfung</div>
	 * 		<div class="fr"></div>
	 * 		<div class="it"></div>
	 * @param appliedAt Datum der Impfung
	 * @param route Einnahmeart (darf null sein)
	 * @param doseQuantity in milliliters (e.g. 0.5) (darf null sein)
	 */
	public Immunization(Consumable consumable, Author author, Date appliedAt, RouteOfAdministration route, Double doseQuantity) {
	    this();
		mImmunization.setNegationInd(Boolean.FALSE);

		//mImmunization.setText(createText());
		setApplyDate(appliedAt);
		setRouteOfAdministration(route);
		setDosage(doseQuantity);
		setId(null);
		setConsumable(consumable);
		setAuthor(author);
	}

	/**
	 * Constructor.
	 *
	 * @param immunization <br>
	 * 		<div class="de">IHE Impf-Objekt</div>
	 * 		<div class="fr"> immunization</div>
	 * 		<div class="it"> immunization</div>
	 */
	public Immunization(org.openhealthtools.mdht.uml.cda.ihe.Immunization immunization) {
		mImmunization = immunization;
	}

	private void addTemplateId(II id) {
		mImmunization.getTemplateIds().add(id);
	}

	private SXCM_TS convertDate(Date appliedAt) {
		SXCM_TS timestamp = DatatypesFactory.eINSTANCE.createSXCM_TS();
		timestamp.setValue(DateUtil.formatDate(appliedAt));
		return timestamp;
	}

	/**
	 * Returns the encapsulated IHE class.
	 * 
	 * @return org.openhealthtools.mdht.uml.cda.ihe.Immunization
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.Immunization copyMdhtImmunization() {
		return EcoreUtil.copy(mImmunization);
	}

	private CE createEpsosPivotCode() {
		CE code = DatatypesFactory.eINSTANCE.createCE();

		// TODO 141025, set correct code
		code.setCode("111164008");
		// TODO 141028, set correct display name
		code.setDisplayName("Poliomyelitis vaccine");

		code.setCodeSystem("1.3.6.1.4.1.12559.11.10.1.3.1.42.28");
		code.setCodeSystemName("epSOSVaccine");

		return code;
	}

	private CE createPriorityCode() {
		CE priorityCode = DatatypesFactory.eINSTANCE.createCE();
		priorityCode.setCode("R");
		priorityCode.setDisplayName("Routine");

		// TODO define OID constant
		priorityCode.setCodeSystem("2.16.840.1.113883.5.7");
		priorityCode.setCodeSystemName("ActPriority");
		return priorityCode;
	}

	/**
	 * Gets the apply date.
	 *
	 * @return the apply date
	 */
	public Date getApplyDate() {
		SXCM_TS date = mImmunization.getEffectiveTimes().get(0);
		return DateUtil.parseDateyyyyMMdd(date.getValue());
	}

	/**
	 * Returns author of this immunization.
	 * 
	 * @return Author
	 */
	public Author getAuthor() {
		try {
			org.openhealthtools.mdht.uml.cda.Author author = EcoreUtil.copy(mImmunization.getAuthors().get(0));
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
		Consumable consumable = new Consumable(mImmunization.getConsumable());
		return consumable;
	}

	/**
	 * Gibt die Dosis der Impfung zurück.
	 *
	 * @return Dosis Dosis der Impfung
	 */
	public Value getDosage() {
		if (mImmunization.getDoseQuantity()!=null) {
	      Value value = new Value(mImmunization.getDoseQuantity());
	      return value;
		}
		return null;
	}	

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = new Identificator(mImmunization.getIds().get(0));
		return id;
	}

	/**
	 * Returns the encapsulated IHE class.
	 * 
	 * @return org.openhealthtools.mdht.uml.cda.ihe.Immunization
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.Immunization getMdhtImmunization() {
		return mImmunization;
	}

	/**
	 * Gets the route of administration.
	 *
	 * @return the route of administration
	 */
	public RouteOfAdministration getRouteOfAdministration() {
		return RouteOfAdministration.getEnum(mImmunization.getRouteCode().getCode());
	}

	/**
	 * Sets the apply date.
	 *
	 * @param appliedAt the new apply date
	 */
	public void setApplyDate(Date appliedAt) {
		mImmunization.getEffectiveTimes().add(convertDate(appliedAt));
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(Author author) {
	    mImmunization.getAuthors().clear();
		mImmunization.getAuthors().add(author.copyMdhtAuthor());
	}

	/**
	 * Sets the consumable.
	 *
	 * @param consumable the new consumable
	 */
	public void setConsumable(Consumable consumable) {
		mImmunization.setConsumable(consumable.copyMdhtConsumable());
	}

	/**
	 * Sets the dosage.
	 *
	 * @param doseQuantity the new dosage (null ok)
	 */
	public void setDosage(@Nullable Double doseQuantity) {
		if (doseQuantity==null) {
			mImmunization.setDoseQuantity(Util.createIVL_PQNullFlavorNA());
		}
		else {
			IVL_PQ ivl_pq = DatatypesFactory.eINSTANCE.createIVL_PQ();
			ivl_pq.setUnit("ml");
			ivl_pq.setValue(doseQuantity);
			mImmunization.setDoseQuantity(ivl_pq);
		}
	}

	/**
	 * Sets the id.
	 *
	 * @param codedId the new id
	 */
	public void setId(Identificator codedId) {
		II ii = Util.createUuidVacdIdentificator(codedId);
		mImmunization.getIds().add(ii);
	}

	private void setPriorityCode(CE priorityCode) {
		mImmunization.setPriorityCode(priorityCode);
	}

	/**
	 * Optionally, one can set the route code (Einnahmearten).
	 * If not set, <routeCode nullFlavor="UNK"/> is written to CDA document.
	 *
	 * @param routeCode the new route of administration
	 */
	public void setRouteOfAdministration(RouteOfAdministration routeCode) {
		if (routeCode == null) {
			CE ce = DatatypesFactory.eINSTANCE.createCE();
			ce.setNullFlavor(NullFlavor.UNK);
			mImmunization.setRouteCode(ce);
		}
		else {
			mImmunization.setRouteCode(routeCode.getCE());
		}
	}

}
