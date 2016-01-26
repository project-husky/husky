package org.ehealth_connector.cda.ch.edes;

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

public class VitalSignObservation {

	public enum VitalSignCodes {
		RESPIRATION_RATE("9279-1"), HEART_BEAT("8867-4"), OXYGEN_SATURATION_PERCENT("2710-2"), INTRAVASCULAR_SYSTOLIC(
				"8480-6"), INTRAVASCULAR_DIASTOLIC("8462-4"), BODY_TEMPERATURE_CEL("8310-5"), BODY_HEIGHT(
				"8302-2"), BODY_HEIGHT_LYING("8306-3"), CIRCUMFRENCE_OCCIPITAL_FRONTAL("8287-5"), BODY_WEIGHT(
				"3141-9");

		private String loinc;

		private VitalSignCodes(String loinc) {
			this.loinc = loinc;
		}

		public Code getCode() {
			return new Code(CodeSystems.LOINC, loinc);
		}

		public Object getLoinc() {
			return loinc;
		}
	}

	/** The m vital sign observation. */
	private final org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation mVitalSignObservation;

	/**
	 * Instantiates a new vital sign observation.
	 */
	public VitalSignObservation() {
		mVitalSignObservation = IHEFactory.eINSTANCE.createVitalSignObservation().init();
	}

	/**
	 * Instantiates a new vital sign observation.
	 * 
	 * @param observation
	 *            <div class="en">Existing vital sign observation</div> <div
	 *            class="de">Existierende vital sign observation</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(
			org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation observation) {
		mVitalSignObservation = observation;
	}

	/**
	 * Instantiates a new vital sign observation.
	 * 
	 * @param code
	 *            <div class="en">Code for a vital sign observation</div> <div
	 *            class="de">Code für ein Vitalzeichen</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param effectiveTime
	 *            <div class="en">clinically or operationally relevant
	 *            time</div> <div class="de">klinisch relevantes Datum und
	 *            Uhrzeit</div> <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(VitalSignCodes code, Date effectiveTime, Value value) {
		this(code.getCode(), effectiveTime, value);
	}

	/**
	 * Instantiates a new vital sign observation.
	 * 
	 * @param code
	 *            <div class="en">Code for a vital sign observation</div> <div
	 *            class="de">Code für ein Vitalzeichen</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param effectiveTime
	 *            <div class="en">clinically or operationally relevant
	 *            time</div> <div class="de">klinisch relevantes Datum und
	 *            Uhrzeit</div> <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(Code code, Date effectiveTime, Value value) {
		mVitalSignObservation = IHEFactory.eINSTANCE.createVitalSignObservation().init();

		setCode(code);
		setEffectiveTime(effectiveTime);
		addValue(value);
	}

	/**
	 * <div class="de">Get a copy mdht vital sign observation.</div> <div
	 * class="de">Gibt eine Kopie der mdth vital sign observation zurück.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return the org.openhealthtools.mdht.uml.cda.ch. vital sign observation
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation getMdhtCopy() {
		return EcoreUtil.copy(mVitalSignObservation);
	}

	/**
	 * Sets the code.
	 * 
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		mVitalSignObservation.setCode(code.getCD());
	}

	/**
	 * <div class="en">Gets the code of the observation</div> <div
	 * class="de">Gibt den Code der Beobachtung zurück.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @return the code
	 */
	public Code getCode() {
		final Code code = new Code(mVitalSignObservation.getCode());
		return code;
	}

	/**
	 * Sets the date time of result.
	 * 
	 * @param dateTimeOfResult
	 *            the new date time of result
	 */
	public void setEffectiveTime(Date dateTimeOfResult) {
		try {
			mVitalSignObservation.setEffectiveTime(DateUtil
					.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the Effective Time
	 * 
	 * @return the effective time as date
	 */
	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(mVitalSignObservation.getEffectiveTime());
	}

	/**
	 * Get the (first) problem value. The Value may be a coded or uncoded
	 * String.
	 * 
	 * @return the (first) problem value as string.
	 */
	public Value getValue() {
		if (!mVitalSignObservation.getValues().isEmpty()) {
			return new Value(mVitalSignObservation.getValues().get(0));
		}
		return null;
	}

	/**
	 * Adds the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void addValue(Value value) {
		if (value.isPhysicalQuantity()) {
			mVitalSignObservation.getValues().add(value.copyMdhtPhysicalQuantity());
		}
		if (value.isCode()) {
			mVitalSignObservation.getValues().add(value.copyMdhtCode());
		}
		if (value.isRto()) {
			mVitalSignObservation.getValues().add(value.copyMdhtRto());
		}
	}
}
