package org.ehealth_connector.cda.ch.edes;

import java.util.Date;

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.edes.enums.ObservationInterpretationVitalSign;
import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;

public class VitalSignObservation extends AbstractVitalSignObservation {

	/**
	 * Instantiates a new vital sign observation.
	 */
	public VitalSignObservation() {
		initMdht();
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *          <div class="en">Code for a vital sign observation</div> <div
	 *          class="de">Code für ein Vitalzeichen</div> <div class="fr"></div>
	 *          <div class="it"></div>
	 * @param effectiveTime
	 *          <div class="en">clinically or operationally relevant time</div>
	 *          <div class="de">klinisch relevantes Datum und Uhrzeit</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 * @param interpretation
	 *          <div class="de">Beurteilung des Resultats</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 * @param targetSite
	 *          <div class="de">Anatomische Lage des Resultats</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 * @param value
	 *          <div class="de">Wert des Resultats (als Value-Objekt)</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(Code code, Date effectiveTime,
			ObservationInterpretationVitalSign interpretation, ActSite targetSite, Value value) {
		initMdht();

		setCode(code);
		setEffectiveTime(effectiveTime);
		setInterpretationCode(interpretation);
		setTargetSite(targetSite);
		addValue(value);
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *          <div class="en">Code for a vital sign observation</div> <div
	 *          class="de">Code für ein Vitalzeichen</div> <div class="fr"></div>
	 *          <div class="it"></div>
	 * @param effectiveTime
	 *          <div class="en">clinically or operationally relevant time</div>
	 *          <div class="de">klinisch relevantes Datum und Uhrzeit</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 * @param value
	 *          <div class="de">Wert des Resultats (als Value-Objekt)</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(Code code, Date effectiveTime, Value value) {
		this(code, effectiveTime, null, null, value);
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param observation
	 *          <div class="en">Existing vital sign observation</div> <div
	 *          class="de">Existierende vital sign observation</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation observation) {
		mVitalSignObservation = observation;
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *          <div class="en">Code for a vital sign observation</div> <div
	 *          class="de">Code für ein Vitalzeichen</div> <div class="fr"></div>
	 *          <div class="it"></div>
	 * @param effectiveTime
	 *          <div class="en">clinically or operationally relevant time</div>
	 *          <div class="de">klinisch relevantes Datum und Uhrzeit</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 * @param interpretation
	 *          <div class="de">Beurteilung des Resultats</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 * @param targetSite
	 *          <div class="de">Anatomische Lage des Resultats</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 * @param value
	 *          <div class="de">Wert des Resultats (als Value-Objekt)</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(VitalSignCodes code, Date effectiveTime,
			ObservationInterpretationVitalSign interpretation, ActSite targetSite, Value value) {
		this(code.getCode(), effectiveTime, interpretation, targetSite, value);
	}

	/**
	 * Instantiates a new vital sign observation.
	 *
	 * @param code
	 *          <div class="en">Code for a vital sign observation</div> <div
	 *          class="de">Code für ein Vitalzeichen</div> <div class="fr"></div>
	 *          <div class="it"></div>
	 * @param effectiveTime
	 *          <div class="en">clinically or operationally relevant time</div>
	 *          <div class="de">klinisch relevantes Datum und Uhrzeit</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 * @param value
	 *          <div class="de">Wert des Resultats (als Value-Objekt)</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 */
	public VitalSignObservation(VitalSignCodes code, Date effectiveTime, Value value) {
		this(code.getCode(), effectiveTime, value);
	}

	/**
	 * Set a new interpretations of the vital sign observation.
	 *
	 * @param code
	 *          <div class="de">Beurteilung des Resultats</div> <div
	 *          class="fr"></div> <div class="it"></div>
	 */
	public void setInterpretationCode(ObservationInterpretationVitalSign code) {
		if (code != null) {
			mVitalSignObservation.getInterpretationCodes().clear();
			mVitalSignObservation.getInterpretationCodes().add(code.getCE());
		}
	}

	protected void initMdht() {
		super.initMdht();
		Identificator id = new Identificator(AbstractCdaCh.OID_V1, "CDA-CH.Body.VitalSignL3");
		mVitalSignObservation.getTemplateIds().add(id.getIi());
	}

}
