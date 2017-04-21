/*
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
package org.ehealth_connector.common;

import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;

/**
 * The Class ObservationRange. This elements holds information about the range
 * of an observation.
 */
public class ObservationRange {

	/** The MDHT Observation Range Object */
	private org.openhealthtools.mdht.uml.cda.ObservationRange mObsR;

	/**
	 * Instantiates a new observation range.
	 */
	public ObservationRange() {
		mObsR = CDAFactory.eINSTANCE.createObservationRange();
		mObsR.setClassCode(ActClassObservation.OBS);
		mObsR.setMoodCode(ActMood.EVNCRT);
	}

	/**
	 * Instantiates a new observation range.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public ObservationRange(org.openhealthtools.mdht.uml.cda.ObservationRange mdht) {
		mObsR = mdht;
	}

	/**
	 * Gets the interpretation code.
	 *
	 * @return the interpretation code
	 */
	public ObservationInterpretation getInterpretationCode() {
		if (mObsR.getInterpretationCode() != null) {
			return ObservationInterpretation.getEnum(mObsR.getInterpretationCode().getCode());
		}
		return null;
	}

	/**
	 * Method to get
	 *
	 * @return the obsR
	 */
	public org.openhealthtools.mdht.uml.cda.ObservationRange getObsR() {
		return mObsR;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Value getValue() {
		if (mObsR.getValue() != null) {
			return new Value(mObsR.getValue());
		}
		return null;
	}

	/**
	 * Sets the interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	public void setInterpretationCode(ObservationInterpretation code) {
		mObsR.setInterpretationCode(code.getCE());
	}

	/**
	 * Method to set
	 *
	 * @param obsR
	 *            the obsR to set
	 */
	public void setObsR(org.openhealthtools.mdht.uml.cda.ObservationRange obsR) {
		mObsR = obsR;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(Value value) {
		mObsR.setValue(value.getValue());
	}

}
