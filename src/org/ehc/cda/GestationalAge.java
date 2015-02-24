package org.ehc.cda;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.StatusCode;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
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

public class GestationalAge {

	CodedResultsSection crs;
	GestationalAgeWeeksSimpleObservation mWeeks;
	GestationalAgeDaysSimpleObservation mDays;
	II mIi;

	public GestationalAge(CodedResultsSection codedResultsSection) {
		crs = codedResultsSection;
		mWeeks = (GestationalAgeWeeksSimpleObservation) codedResultsSection.getGestationalAgeWeeksSimpleObservations();
		mDays = (GestationalAgeDaysSimpleObservation) codedResultsSection.getGestationalAgeDaysSimpleObservations();
	}

	public GestationalAge (int days) {
		this(days/7, days%7);
	}

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

	public CodedResultsSection copyMdhtCodedResultsSection() {
		return EcoreUtil.copy(crs);
	}

	public GestationalAgeDaysSimpleObservation copyMdhtGestationalAgeDaysObservation() {
		return EcoreUtil.copy(mDays);
	}

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

	public int getAboluteDays () {
		return (getWeeksOfWeeksAndDays()*7)+getDaysOfWeeksAndDays();
	}

	public int getDaysOfWeeksAndDays() {
		for (ANY any: mDays.getValues()){
			PQ pq = (PQ) any;
			if (pq.getUnit().equals("d")) {
				return pq.getValue().intValue();
			}
		}
		return 0;
	}

	public String getGestationalAgeText() {
		String gestationalText = "Das Gestationsalter beträgt: "+String.valueOf(getWeeksOfWeeksAndDays())+" Wochen und "+String.valueOf(getDaysOfWeeksAndDays())+" Tage";
		return gestationalText;
	}

	public CodedResultsSection getMdhtCodedResultsSection() {
		return crs;
	}

	public GestationalAgeDaysSimpleObservation getMdhtGestationalAgeDaysObservation() {
		return mDays;
	}

	public GestationalAgeWeeksSimpleObservation getMdhtGestationalAgeWeeksObservation() {
		return mWeeks;
	}

	public int getWeeksOfWeeksAndDays() {
		for (ANY any: mWeeks.getValues()){
			PQ pq = (PQ) any;
			if (pq.getUnit().equals("wk")) {
				return pq.getValue().intValue();
			}
		}
		return 0;
	}

	public void setAsboluteDays (int days) {
		setWeeksOfWeeksAndDays(days/7);
		setDaysOfWeeksAndDays(days%7);
	}

	public void setDaysOfWeeksAndDays(int days) {
		PQ mDaysValue = DatatypesFactory.eINSTANCE.createPQ(days, "d");
		mDays.getValues().add(mDaysValue);
		mDays.getIds().add(EcoreUtil.copy(mIi));
		mDays.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
	}

	public void setWeeksOfWeeksAndDays(int weeks) {
		//create and the values, ids and effectiveTime for weeks and days
		PQ mWeeksValue = DatatypesFactory.eINSTANCE.createPQ(weeks, "wk");
		mWeeks.getValues().add(mWeeksValue);
		mWeeks.getIds().add(EcoreUtil.copy(mIi));
		mWeeks.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
	}

}
