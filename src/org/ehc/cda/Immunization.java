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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.RouteOfAdministration;
import org.ehc.common.Author;
import org.ehc.common.DateUtil;
import org.ehc.common.Identificator;
import org.ehc.common.Util;
import org.ehc.common.Value;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Eine Impfung
 * 
 */
public class Immunization {

	private org.openhealthtools.mdht.uml.cda.ihe.Immunization mImmunization;

	public Immunization() {
		mImmunization = CHFactory.eINSTANCE.createImmunization().init();
		mImmunization.setNegationInd(Boolean.FALSE);
	}
	
	/**
	 * Dieses Element enthält die verabreichten Impfungen und die ausdrücklich nicht erwünschten Impfungen. 
	 * @param consumable Impfstoff
	 * @author author Die eintragende Person
	 * @param appliedAt Datum der Impfung
	 */
	public Immunization(Consumable consumable, Author author, Date appliedAt) {
		mImmunization = CHFactory.eINSTANCE.createImmunization().init();
		mImmunization.setNegationInd(Boolean.FALSE);
	
		//Fix the TemplateID Extension of the CDA-CH.Body.MediL3 Template
		List<II> templateIds = mImmunization.getTemplateIds();
		for (II templateId: templateIds) {
			if (templateId.getRoot().equals("2.16.756.5.30.1.1.1.1.1")) {
				templateId.setExtension("CDA-CH.Body.MediL3");
			}
		}

		//mImmunization.setText(createText());
		setApplyDate(appliedAt);
		setPriorityCode(createPriorityCode());
		setId(null);
		setConsumable(consumable);
		setAuthor(author);
	}
	
	/**
	 * Dieses Element enthält die verabreichten Impfungen und die ausdrücklich nicht erwünschten Impfungen. 
	 * @param consumable Impfstoff
	 * @author author Die eintragende Person
	 * @param appliedAt Datum der Impfung
	 * @param route Einnahmeart (darf null sein)
	 * @param doseQuantity in milliliters (e.g. 0.5) (darf null sein)
	 */
	public Immunization(Consumable consumable, Author author, Date appliedAt, RouteOfAdministration route, String doseQuantity) {
		mImmunization = CHFactory.eINSTANCE.createImmunization().init();
		mImmunization.setNegationInd(Boolean.FALSE);
	
		//Fix the TemplateID Extension of the CDA-CH.Body.MediL3 Template
		List<II> templateIds = mImmunization.getTemplateIds();
		for (II templateId: templateIds) {
			if (templateId.getRoot().equals("2.16.756.5.30.1.1.1.1.1")) {
				templateId.setExtension("CDA-CH.Body.MediL3");
			}
		}

		//mImmunization.setText(createText());
		setApplyDate(appliedAt);
		setPriorityCode(createPriorityCode());
		setRouteOfAdministration(route);
		setDosage(doseQuantity);
		setId(null);
		setConsumable(consumable);
		setAuthor(author);
	}

	/**
	 * Constructor.
	 * 
	 * @param immunization
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
	 * Method should be package private.
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
			org.openhealthtools.mdht.uml.cda.Author author = mImmunization.getAuthors().get(0);
			return new Author(author);
		} catch(IndexOutOfBoundsException e) {
			// no author available
			return null;
		}

	}

	public Consumable getConsumable() {
		Consumable consumable = new Consumable(this.mImmunization.getConsumable());
		return consumable;
	}
	
	/**
	 * Gibt die Dosis der Impfung zurück
	 * 
	 * @return Dosis Dosis der Impfung
	 */
	public Value getDosage() {
		Value value = new Value(mImmunization.getDoseQuantity());
		return value;
	}	

	public Identificator getId() {
		Identificator id = new Identificator(mImmunization.getIds().get(0));
		return id;
	}

//	/**
//	 * Medikationsdaten muessen den GTIN (swissIndex) sowie den ATC-Code enthalten.
//	 * @return
//	 */
//	private CE createEpsosPivotCodeElement(String atcCode) {
//		CE code = createEpsosPivotCode();
//
//		code.setOriginalText(createText());
//		// TODO set correct GTIN
//		code.getTranslations().add(createTranslation("7680006690011", "1.3.160"));
//
//		code.getTranslations().add(createTranslation(atcCode, "2.16.840.1.113883.6.73"));
//		return code;
//	}
//
//	/**
//	 * Only codes defined in cda-ch-vacd-voc.xml are allowed.
//	 * 
//	 * Actually these are: IDINJ, NASNEB, PO, SQ, TRNSDERMD and IM.
//	 * 
//	 * @return CE
//	 */
//	private CE createRouteCode() {
//		CE ce = DatatypesFactory.eINSTANCE.createCE();
//		ce.setCode(routeCode.getCodeValue());
//		ce.setDisplayName(routeCode.getdisplayName());
//
//		// TODO define OID constant
//		ce.setCodeSystem("2.16.840.1.113883.5.112");
//		ce.setCodeSystemName("VACD_RouteOfAdministration");
//		return ce;
//	}

	/**
	 * Returns the encapsulated IHE class.
	 * Method should be package private.
	 * 
	 * @return org.openhealthtools.mdht.uml.cda.ihe.Immunization
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.Immunization getMdhtImmunization() {
		return mImmunization;
	}
	
	public RouteOfAdministration getRouteOfAdministration() {
		return RouteOfAdministration.getEnum(mImmunization.getRouteCode().getCode());
	}

	public void setApplyDate(Date appliedAt) {
		mImmunization.getEffectiveTimes().add(convertDate(appliedAt));
	}

	public void setAuthor(Author author) {
		mImmunization.getAuthors().add(author.copyMdhtAuthor());
	}

	public void setConsumable(Consumable consumable) {
		mImmunization.setConsumable(consumable.copyMdhtConsumable());
	}
	
	public void setDosage(String doseQuantity) {
		if (doseQuantity==null) {
			mImmunization.setDoseQuantity(Util.createIVL_PQNullFlavorNA());
		}
		else {
			IVL_PQ ivl_pq = DatatypesFactory.eINSTANCE.createIVL_PQ();
			ivl_pq.setUnit("ml");
			ivl_pq.setValue(Double.valueOf(doseQuantity));
		}
	}

	public void setId(Identificator codedId) {
		II ii = Util.createUuidVacdIdentificator(codedId);
		mImmunization.getIds().add(ii);
	}
	
	private void setPriorityCode(CE priorityCode) {
		mImmunization.setPriorityCode(priorityCode);
	}
	
	/**
	 * Optionally, one can set the route code (Einnahmearten).
	 * If not set, <routeCode nullFlavor="NA"/> is written to CDA document.
	 * 
	 * @param routeCode
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
