/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.common.model;

import java.util.Map;

import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.ehealth_connector.common.hl7cdar2.ANY;
import org.ehealth_connector.common.hl7cdar2.IVLPQ;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ObservationRange;
import org.ehealth_connector.common.hl7cdar2.PQ;

/**
 * The Class ObservationRange. This elements holds information about the range
 * of an observation.
 */
public class ObservationRange {

	/** The MDHT Observation Range Object */
	private POCDMT000040ObservationRange mObsR;

	/**
	 * Instantiates a new observation range.
	 */
	public ObservationRange() {
		mObsR = new POCDMT000040ObservationRange();
		mObsR.getClassCode().clear();
		mObsR.getClassCode().add("OBS");
		mObsR.getMoodCode().clear();
		mObsR.getMoodCode().add("EVNCRT");
	}

	/**
	 * Instantiates a new observation range.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public ObservationRange(POCDMT000040ObservationRange mdht) {
		mObsR = mdht;
	}

	/**
	 * Gets the interpretation code.
	 *
	 * @return the interpretation code
	 */
	public ObservationInterpretation getInterpretation() {
		if (mObsR.getInterpretationCode() != null) {
			return ObservationInterpretation.getEnum(mObsR.getInterpretationCode().getCode());
		}
		return null;
	}

	/**
	 * Gets the interpretation code.
	 *
	 * @return the interpretation code
	 */
	public Code getInterpretationCode() {
		if (mObsR.getInterpretationCode() != null) {
			return new Code(mObsR.getInterpretationCode());
		}
		return null;
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
	public void setInterpretation(ObservationInterpretation code) {
		mObsR.setInterpretationCode(code.getCE());
	}

	/**
	 * Sets the interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	public void setInterpretationCode(Code code) {
		mObsR.setInterpretationCode(code.getHl7CdaR2Ce());
	}

	/**
	 * Method to set
	 *
	 * @param obsR
	 *            the obsR to set
	 */
	public void setObsR(POCDMT000040ObservationRange obsR) {
		mObsR = obsR;
	}

	/**
	 * Method to get
	 *
	 * @return the obsR
	 */
	public POCDMT000040ObservationRange getObsR() {
		return mObsR;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(Value value) {
		ANY val = value.getValue();
		if (val instanceof IVLPQ) {
			var valIvlPq = (IVLPQ) val;

			Map<String, PQ> elements = value.getPqElement(valIvlPq);

			if (elements.get("low") != null && !elements.get("low").getUnit().isEmpty()) {
					elements.get("low").setUnit(null);
			}
			if (elements.get("high") != null && !elements.get("high").getUnit().isEmpty()) {
					elements.get("high").setUnit(null);
			}
		}
		mObsR.setValue(val);
	}

}
