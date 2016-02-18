package org.ehealth_connector.cda.ch.edes;

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationVitalSign;
import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

public class VitalSignObservation {

	/** The m vital sign observation. */
	private final org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation mVitalSignObservation;

	/**
	 * Instantiates a new vital sign observation.
	 */
	public VitalSignObservation() {
		mVitalSignObservation = initMdht();
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
	 * @param interpretation
	 *            <div class="de">Beurteilung des Resultats</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param targetSite
	 *            <div class="de">Anatomische Lage des Resultats</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(VitalSignCodes code, Date effectiveTime,
			ObservationInterpretationVitalSign interpretation, ActSite targetSite, Value value) {
		this(code.getCode(), effectiveTime, interpretation, targetSite, value);
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
		this(code, effectiveTime, null, null, value);
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
	 * @param interpretation
	 *            <div class="de">Beurteilung des Resultats</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param targetSite
	 *            <div class="de">Anatomische Lage des Resultats</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="de">Wert des Resultats (als Value-Objekt)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(Code code, Date effectiveTime,
			ObservationInterpretationVitalSign interpretation, ActSite targetSite, Value value) {
		mVitalSignObservation = initMdht();

		setCode(code);
		setEffectiveTime(effectiveTime);
		setInterpretationCode(interpretation);
		setTargetSite(targetSite);
		addValue(value);
	}

	private org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation initMdht() {
		org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation mdht = IHEFactory.eINSTANCE
				.createVitalSignObservation().init();
		CE ceNullFlavourCode = DatatypesFactory.eINSTANCE.createCE();
		ceNullFlavourCode.setNullFlavor(NullFlavor.NA);

		CD cdNullFlavourCode = DatatypesFactory.eINSTANCE.createCD();
		cdNullFlavourCode.setNullFlavor(NullFlavor.NA);

		mdht.getMethodCodes().add(EcoreUtil.copy(ceNullFlavourCode));
		mdht.getInterpretationCodes().add(EcoreUtil.copy(ceNullFlavourCode));
		mdht.getTargetSiteCodes().add(EcoreUtil.copy(cdNullFlavourCode));

		mdht.setText(Util.createReference("#TODO"));

		II ii = DatatypesFactory.eINSTANCE
				.createII(AbstractCdaCh.OID_V1, "CDA-CH.Body.VitalSignL3");
		mdht.getTemplateIds().add(ii);

		return mdht;
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

	/**
	 * Set a new interpretations of the vital sign observation.
	 * 
	 * @param code
	 *            <div class="de">Beurteilung des Resultats</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public void setInterpretationCode(ObservationInterpretationVitalSign code) {
		if (code != null) {
			mVitalSignObservation.getInterpretationCodes().clear();
			mVitalSignObservation.getInterpretationCodes().add(code.getCE());
		}
	}

	/**
	 * Gets the interpretation of the vital sign observation.
	 * 
	 * @return the interpretation as code or null.
	 */
	public Code getInterpretationCode() {
		EList<CE> codes = mVitalSignObservation.getInterpretationCodes();
		if (!codes.isEmpty()) {
			return new Code(codes.get(0));
		}
		return null;
	}

	/**
	 * Set a new act site of the vital sign observation.
	 * 
	 * @param code
	 *            <div class="de">Anatomische Lage des Resultats</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public void setTargetSite(ActSite code) {
		if (code != null) {
			mVitalSignObservation.getTargetSiteCodes().clear();
			mVitalSignObservation.getTargetSiteCodes().add(code.getCD());
		}
	}

	/**
	 * Gets the target site of the vital sign observation.
	 * 
	 * @return the target site as code or null.
	 */
	public Code getTargetSiteCode() {
		EList<CD> codes = mVitalSignObservation.getTargetSiteCodes();
		if (!codes.isEmpty()) {
			return new Code(codes.get(0));
		}
		return null;
	}

	/**
	 * Set a new language code of the vital sign observation, and its codes.
	 * 
	 * @param languageCode
	 *            <div class="de">Language code</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setLanguageCode(CS languageCode) {
		mVitalSignObservation.setLanguageCode(languageCode);
		CD code = mVitalSignObservation.getCode();
		if (code != null) {
			VitalSignCodes vsCode = VitalSignCodes.getEnum(code.getCode());
			if (vsCode != null) {
				code.setDisplayName(vsCode.getDisplayName(languageCode));
			}
		}
		if (!mVitalSignObservation.getTargetSiteCodes().isEmpty()) {
			CD tsCode = mVitalSignObservation.getTargetSiteCodes().get(0);
			ActSite aSite = ActSite.getEnum(tsCode.getCode());
			if (aSite != null) {
				tsCode.setDisplayName(aSite.getDisplayName(languageCode));
			}
		}
	}
}
