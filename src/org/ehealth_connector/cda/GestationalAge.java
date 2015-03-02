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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.StatusCode;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.CodedResultsSection;
import org.openhealthtools.mdht.uml.cda.ch.GestationalAgeDaysSimpleObservation;
import org.openhealthtools.mdht.uml.cda.ch.GestationalAgeWeeksSimpleObservation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ProcedureEntry;
import org.openhealthtools.mdht.uml.cda.ihe.ProcedureEntryProcedureActivityProcedure;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

// TODO: Auto-generated Javadoc
/**
 * <div class="de">Class GestationalAge.</div>\n
 * <div class="fr">Class GestationalAge.</div>\n
 * <div class="it">Class GestationalAge.</div>
 */
public class GestationalAge {

	/** The crs. */
	CodedResultsSection crs;
	
	/** The m weeks. */
	GestationalAgeWeeksSimpleObservation mWeeks;
	
	/** The m days. */
	GestationalAgeDaysSimpleObservation mDays;
	
	/** The m ii. */
	II mIi;

	/**
	 * Instantiates a new gestational age.
	 *
	 * @param codedResultsSection <br>
	 * 		<div class="de"> coded results section</div>
	 * 		<div class="fr"> coded results section</div>
	 * 		<div class="it"> coded results section</div>
	 */
	public GestationalAge(CodedResultsSection codedResultsSection) {
		crs = codedResultsSection;
		mWeeks = (GestationalAgeWeeksSimpleObservation) codedResultsSection.getGestationalAgeWeeksSimpleObservations();
		mDays = (GestationalAgeDaysSimpleObservation) codedResultsSection.getGestationalAgeDaysSimpleObservations();
	}

	/**
	 * Instantiates a new gestational age.
	 *
	 * @param days <br>
	 * 		<div class="de"> days</div>
	 * 		<div class="fr"> days</div>
	 * 		<div class="it"> days</div>
	 */
	public GestationalAge (int days) {
		this(days/7, days%7);
	}

	/**
	 * Instantiates a new gestational age.
	 *
	 * @param weeks <br>
	 * 		<div class="de"> weeks</div>
	 * 		<div class="fr"> weeks</div>
	 * 		<div class="it"> weeks</div>
	 * @param weeksDays <br>
	 * 		<div class="de"> weeks days</div>
	 * 		<div class="fr"> weeks days</div>
	 * 		<div class="it"> weeks days</div>
	 */
	public GestationalAge (int weeks, int weeksDays) {
		//create and add the MDHT Objects to the section
		crs = CHFactory.eINSTANCE.createCodedResultsSection().init();
		mWeeks = CHFactory.eINSTANCE.createGestationalAgeWeeksSimpleObservation().init();
		mDays = CHFactory.eINSTANCE.createGestationalAgeDaysSimpleObservation().init();
		crs.addObservation(mWeeks);
		crs.addObservation(mDays);

		//Create Id
		mIi = Util.createUuidVacdIdentificator(null);

		//Set payload
		setWeeksOfWeeksAndDays(weeks);
		setDaysOfWeeksAndDays(weeksDays);

		crs.addProcedure(createEmptyProcedureEntry());
	}

	/**
	 * <div class="de">Copy mdht coded results section.</div>
	 * <div class="fr">Copy mdht coded results section.</div>
	 * <div class="it">Copy mdht coded results section.</div>
	 *
	 * @return the coded results section
	 */
	public CodedResultsSection copyMdhtCodedResultsSection() {
		return EcoreUtil.copy(crs);
	}

	/**
	 * <div class="de">Copy mdht gestational age days observation.</div>
	 * <div class="fr">Copy mdht gestational age days observation.</div>
	 * <div class="it">Copy mdht gestational age days observation.</div>
	 *
	 * @return the gestational age days simple observation
	 */
	public GestationalAgeDaysSimpleObservation copyMdhtGestationalAgeDaysObservation() {
		return EcoreUtil.copy(mDays);
	}

	/**
	 * <div class="de">Copy mdht gestational age weeks observation.</div>
	 * <div class="fr">Copy mdht gestational age weeks observation.</div>
	 * <div class="it">Copy mdht gestational age weeks observation.</div>
	 *
	 * @return the gestational age weeks simple observation
	 */
	public GestationalAgeWeeksSimpleObservation copyMdhtGestationalAgeWeeksObservation() {
		return EcoreUtil.copy(mWeeks);
	}

	private ProcedureEntry createEmptyProcedureEntry() {
		//Create and add an empty procedureEntry
		ProcedureEntryProcedureActivityProcedure pe = IHEFactory.eINSTANCE.createProcedureEntryProcedureActivityProcedure().init();
		pe.getIds().add(Util.createUuidVacd(null));
		pe.setCode(Util.createCodeNullFlavor());

		//Create NullFlavor Reference
		ED text = DatatypesFactory.eINSTANCE.createED();
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.setNullFlavor(NullFlavor.NA);
		text.setReference(tel);

		pe.setText(text);
		pe.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
		pe.setStatusCode(StatusCode.COMPLETED.getCS());
		return pe;
	}	

	/**
	 * Gets the abolute days.
	 *
	 * @return the abolute days
	 */
	public int getAboluteDays () {
		return (getWeeksOfWeeksAndDays()*7)+getDaysOfWeeksAndDays();
	}

	/**
	 * Gets the days of weeks and days.
	 *
	 * @return the days of weeks and days
	 */
	public int getDaysOfWeeksAndDays() {
		for (ANY any: mDays.getValues()){
			PQ pq = (PQ) any;
			if (pq.getUnit().equals("d")) {
				return pq.getValue().intValue();
			}
		}
		return 0;
	}

	/**
	 * Gets the gestational age text.
	 *
	 * @return the gestational age text
	 */
	public String getGestationalAgeText() {
		String gestationalText = "Das Gestationsalter beträgt: "+String.valueOf(getWeeksOfWeeksAndDays())+" Wochen und "+String.valueOf(getDaysOfWeeksAndDays())+" Tage";
		return gestationalText;
	}

	/**
	 * Gets the mdht coded results section.
	 *
	 * @return the mdht coded results section
	 */
	public CodedResultsSection getMdhtCodedResultsSection() {
		return crs;
	}

	/**
	 * Gets the mdht gestational age days observation.
	 *
	 * @return the mdht gestational age days observation
	 */
	public GestationalAgeDaysSimpleObservation getMdhtGestationalAgeDaysObservation() {
		return mDays;
	}

	/**
	 * Gets the mdht gestational age weeks observation.
	 *
	 * @return the mdht gestational age weeks observation
	 */
	public GestationalAgeWeeksSimpleObservation getMdhtGestationalAgeWeeksObservation() {
		return mWeeks;
	}

	/**
	 * Gets the weeks of weeks and days.
	 *
	 * @return the weeks of weeks and days
	 */
	public int getWeeksOfWeeksAndDays() {
		for (ANY any: mWeeks.getValues()){
			PQ pq = (PQ) any;
			if (pq.getUnit().equals("wk")) {
				return pq.getValue().intValue();
			}
		}
		return 0;
	}

	/**
	 * Sets the asbolute days.
	 *
	 * @param days the new asbolute days
	 */
	public void setAsboluteDays (int days) {
		setWeeksOfWeeksAndDays(days/7);
		setDaysOfWeeksAndDays(days%7);
	}

	/**
	 * Sets the days of weeks and days.
	 *
	 * @param days the new days of weeks and days
	 */
	public void setDaysOfWeeksAndDays(int days) {
		PQ mDaysValue = DatatypesFactory.eINSTANCE.createPQ(days, "d");
		mDays.getValues().add(mDaysValue);
		mDays.getIds().add(EcoreUtil.copy(mIi));
		mDays.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
	}

	/**
	 * Sets the weeks of weeks and days.
	 *
	 * @param weeks the new weeks of weeks and days
	 */
	public void setWeeksOfWeeksAndDays(int weeks) {
		//create and the values, ids and effectiveTime for weeks and days
		PQ mWeeksValue = DatatypesFactory.eINSTANCE.createPQ(weeks, "wk");
		mWeeks.getValues().add(mWeeksValue);
		mWeeks.getIds().add(EcoreUtil.copy(mIi));
		mWeeks.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
	}

}
