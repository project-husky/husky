/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.StatusCode;
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

/**
 * <div class="de">Klasse Gestationsalter. Dies ist der Zeitraum vom 1. Tag der
 * letzten Regelblutung der Mutter bis zur Geburt des Kindes. Hier kann
 * Gestationsalter eines Kindes angegeben werden, sofern das rund um Impfungen
 * am Kind relevant ist. </div> <div class="fr"></div> <div class="it"></div>
 */
public class GestationalAge extends CodedResults {

	private GestationalAgeWeeksSimpleObservation mWeeks;
	private GestationalAgeDaysSimpleObservation mDays;
	private II mIi;

	/**
	 * Instantiates a new gestational age.
	 *
	 */
	public GestationalAge() {
		super(CHFactory.eINSTANCE.createCodedResultsSection().init());
		mWeeks = CHFactory.eINSTANCE
				.createGestationalAgeWeeksSimpleObservation().init();
		mDays = CHFactory.eINSTANCE.createGestationalAgeDaysSimpleObservation()
				.init();

		crs.addObservation(mWeeks);
		crs.addObservation(mDays);

		// Create Id
		mIi = Util.createUuidVacdIdentificator(null);

		// CreateEmpty Procedure Entry
		crs.addProcedure(createEmptyProcedureEntry());
	}

	/**
	 * Instantiates a new gestational age.
	 *
	 * @param codedResultsSection
	 * <br>
	 *            <div class="de">Instantiiert das Objekt auf Basis einer MDHT
	 *            CodedResultsSection</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public GestationalAge(CodedResultsSection codedResultsSection) {
		crs = codedResultsSection;
		mWeeks = (GestationalAgeWeeksSimpleObservation) codedResultsSection
				.getGestationalAgeWeeksSimpleObservations();
		mDays = (GestationalAgeDaysSimpleObservation) codedResultsSection
				.getGestationalAgeDaysSimpleObservations();
	}

	/**
	 * Instantiates a new gestational age.
	 *
	 * @param days
	 * <br>
	 *            <div class="de">Gestationsalter in Tagen (nicht in Wochen UND
	 *            Tagen)</div> <div class="fr"></div> <div class="it"></div>
	 */
	public GestationalAge(int days) {
		this(days / 7, days % 7);
	}

	/**
	 * Instantiates a new gestational age.
	 *
	 * @param weeks
	 * <br>
	 *            <div class="de">Gestationsalter in Wochen und Tagen. Dieser
	 *            Parameter gibt die Anzahl der Wochen an.</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param weeksDays
	 * <br>
	 *            <div class="de">Gestationsalter in Wochen und Tagen. Dieser
	 *            Parameter gibt die Anzahl der Tage an.</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public GestationalAge(int weeks, int weeksDays) {
		// create and add the MDHT Objects to the section
		this();

		// Set payload
		setWeeksAndDays(weeks, weeksDays);
	}

	/**
	 * <div class="de">Copy mdht coded results section.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return the coded results section
	 */
	public CodedResultsSection copyMdhtCodedResultsSection() {
		return EcoreUtil.copy(crs);
	}

	/**
	 * <div class="de">Copy mdht gestational age days observation.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return the gestational age days simple observation
	 */
	public GestationalAgeDaysSimpleObservation copyMdhtGestationalAgeDaysObservation() {
		return EcoreUtil.copy(mDays);
	}

	/**
	 * <div class="de">Copy mdht gestational age weeks observation.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return the gestational age weeks simple observation
	 */
	public GestationalAgeWeeksSimpleObservation copyMdhtGestationalAgeWeeksObservation() {
		return EcoreUtil.copy(mWeeks);
	}

	/**
	 * Gets the absolute days.
	 *
	 * @return <div class="de">Gibt das Gestationsalter in absoluten Tagen (ohne
	 *         Wochen) zurück.</div> <div class="fr"></div> <div
	 *         class="it"></div>
	 */
	public int getAbsoluteDays() {
		return (getWeeksOfWeeksAndDays() * 7) + getDaysOfWeeksAndDays();
	}

	/**
	 * Gets the gestational age text.
	 *
	 * @return the gestational age text <div class="de">Das Gestationsalter in
	 *         Satz-form:
	 *         "Das Gestationsalter beträgt: X Wochen und Y Tage"</div> <div
	 *         class="fr"></div> <div class="it"></div>
	 */
	public String getCodedResultsText() {
		String gestationalText = "Das Gestationsalter beträgt: "
				+ String.valueOf(getWeeksOfWeeksAndDays()) + " Wochen und "
				+ String.valueOf(getDaysOfWeeksAndDays()) + " Tage";
		return gestationalText;
	}

	/**
	 * Gets the days of weeks and days.
	 *
	 * @return <div class="de">Das Gestationsalter in Wochen und Tagen. Hier
	 *         wird die Anzahl der Tage zurückgegeben.</div> <div
	 *         class="fr"></div> <div class="it"></div>
	 */
	public int getDaysOfWeeksAndDays() {
		for (ANY any : mDays.getValues()) {
			PQ pq = (PQ) any;
			if (pq.getUnit().equals("d")) {
				return pq.getValue().intValue();
			}
		}
		return 0;
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
	 * @return <div class="de">Das Gestationsalter in Wochen und Tagen. Hier
	 *         wird die Anzahl der Wochen zurückgegeben.</div> <div
	 *         class="fr"></div> <div class="it"></div>
	 */
	public int getWeeksOfWeeksAndDays() {
		for (ANY any : mWeeks.getValues()) {
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
	 * @param days
	 *            <div class="de">Setzt das Gestationsalter in absoluten Tagen
	 *            (nicht in Wochen UND Tagen).</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public void setAsboluteDays(int days) {
		setWeeksAndDays(days / 7, days % 7);
	}

	/**
	 * Sets the days of weeks and days.
	 *
	 * @param weeks
	 *            <div class="de">Das Gestationsalter in Wochen und Tagen. Hier
	 *            wird die Anzahl der Wochen gesetzt.</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * 
	 * @param days
	 *            <div class="de">Das Gestationsalter in Wochen und Tagen. Hier
	 *            wird die Anzahl der Tage gesetzt.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setWeeksAndDays(int weeks, int days) {
		mDays.getValues().clear();
		mDays.getIds().clear();
		mWeeks.getValues().clear();
		mWeeks.getIds().clear();
		setWeeksOfWeeksAndDays(weeks);
		setDaysOfWeeksAndDays(days);
	}

	private ProcedureEntry createEmptyProcedureEntry() {
		// Create and add an empty procedureEntry
		ProcedureEntryProcedureActivityProcedure pe = IHEFactory.eINSTANCE
				.createProcedureEntryProcedureActivityProcedure().init();
		pe.getIds().add(Util.createUuidVacd(null));
		pe.setCode(Util.createCodeNullFlavorNA());

		// Create NullFlavor Reference
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
	 * Sets the days of weeks and days.
	 *
	 * @param days
	 *            <div class="de">Das Gestationsalter in Wochen und Tagen. Hier
	 *            wird die Anzahl der Tage gesetzt.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	private void setDaysOfWeeksAndDays(int days) {
		PQ mDaysValue = DatatypesFactory.eINSTANCE.createPQ(days, "d");
		mDays.getValues().add(mDaysValue);
		mDays.getIds().add(EcoreUtil.copy(mIi));
		mDays.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
	}

	/**
	 * Sets the weeks of weeks and days.
	 *
	 * @param weeks
	 *            <div class="de">Das Gestationsalter in Wochen und Tagen. Hier
	 *            wird die Anzahl der Wochen gesetzt.</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	private void setWeeksOfWeeksAndDays(int weeks) {
		// create and the values, ids and effectiveTime for weeks and days
		PQ mWeeksValue = DatatypesFactory.eINSTANCE.createPQ(weeks, "wk");
		mWeeks.getValues().add(mWeeksValue);
		mWeeks.getIds().add(EcoreUtil.copy(mIi));
		mWeeks.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
	}

}
