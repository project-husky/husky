/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.Date;

import org.ehealth_connector.cda.ch.enums.StandardCdaBodySelections;
import org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.ObservationInterpretation;

/**
 * The Class LaboratoryObservation. <div class="en">Each laboratory observation
 * for notifable germs in Swiss MUST contain a code and an interpretation of the
 * result. Depending on the kind of result, a value CAN be added.</div>
 * <div class="de">Jedes Laborresultat für meldepflichtige Erregernachweise in
 * der Schweiz MUSS aus einem Code und der Interpretation des Messresultates
 * bestehen. Je nach Art des Resultates KANN ein Wert angegeben werden. </div>
 */
public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	protected org.openhealthtools.mdht.uml.cda.Observation mObservation;

	/**
	 * Instantiates a new laboratory observation.
	 */
	public LaboratoryObservation() {
		super();
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            the code
	 * @param interpretationCode
	 *            the interpretation code
	 * @param effectiveTime
	 *            <div class="en">point in time of the result (physiological
	 *            relevant point in time). Precision: Date with hour and
	 *            minute</div> <div class="de">Zeitpunkt des Resultats
	 *            (physiologisch relevanter Zeitpunkt) Genauigkeit des Werts:
	 *            Datum und Tageszeit mit Stunde und Minute </div>
	 */
	public LaboratoryObservation(Code code, ObservationInterpretation interpretationCode,
			Date effectiveTime) {
		this();
		setCode(code);
		setInterpretationCode(interpretationCode);
		setEffectiveTime(effectiveTime);
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            the code
	 * @param interpretationCode
	 *            the interpretation code
	 * @param effectiveTime
	 *            <div class="en">point in time of the result (physiological
	 *            relevant point in time). Precision: Date with hour and
	 *            minute</div> <div class="de">Zeitpunkt des Resultats
	 *            (physiologisch relevanter Zeitpunkt) Genauigkeit des Werts:
	 *            Datum und Tageszeit mit Stunde und Minute </div>
	 */
	public LaboratoryObservation(LabObsListSnomed code,
			ObservationInterpretation interpretationCode, Date effectiveTime) {
		this();
		setCode(code);
		addInterpretationCode(interpretationCode);
		setEffectiveTime(effectiveTime);
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht) {
		super(mdht);
	}

	// public org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc
	// getCodeAsEnum() {
	// if (getCode() != null) {
	// return LabObsListLoinc.getEnum(getCode().getCode());
	// }
	// return null;
	// }

	/**
	 * Gets the code as snomed enum.
	 *
	 * @return the code as snomed enum
	 */
	public org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed getCodeAsSnomedEnum() {
		if (getCode() != null) {
			return LabObsListSnomed.getEnum(getCode().getCode());
		}
		return null;
	}

	/**
	 * Convenience function for special case HIV. Gets the HIV recency (if
	 * present)
	 *
	 * @return the HIV recency
	 */
	public StandardCdaBodySelections getHivRecency() {
		if (getCode() != null && StandardCdaBodySelections.isInValueSet(getCode().getCode())) {
			return StandardCdaBodySelections.getEnum(getCode().getCode());
		}
		return null;
	}

	// public void
	// setCode(org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListLoinc code)
	// {
	// setCode(code.getCode());
	// }

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(org.ehealth_connector.cda.ch.lab.lrph.enums.LabObsListSnomed code) {
		setCode(code.getCode());
	}

	/**
	 * Convenience function for special case HIV. Sets the HIV recency.
	 *
	 * @param selection
	 *            the recency
	 */
	public void setHivRecency(StandardCdaBodySelections selection) {
		setCode(selection.getCode());
	}
}
