/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.common.model;

import java.util.Map;

import org.husky.common.enums.ObservationInterpretation;
import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.IVLPQ;
import org.husky.common.hl7cdar2.POCDMT000040ObservationRange;
import org.husky.common.hl7cdar2.PQ;

/**
 * The Class ObservationRange. This elements holds information about the range of an observation.
 */
public class ObservationRange {

    /**
     * The Observation Range Object
     */
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
     * @param mdht the mdht
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
     * Sets the interpretation code.
     *
     * @param code the new interpretation code
     */
    public void setInterpretation(ObservationInterpretation code) {
        mObsR.setInterpretationCode(code.getCE());
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
     * Sets the interpretation code.
     *
     * @param code the new interpretation code
     */
    public void setInterpretationCode(Code code) {
        mObsR.setInterpretationCode(code.getHl7CdaR2Ce());
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
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(Value value) {
        ANY val = value.getValue();
		if (val instanceof IVLPQ valIvlPq) {
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

    /**
     * Method to get
     *
     * @return the obsR
     */
    public POCDMT000040ObservationRange getObsR() {
        return mObsR;
    }

    /**
     * Method to set
     *
     * @param obsR the obsR to set
     */
    public void setObsR(POCDMT000040ObservationRange obsR) {
        mObsR = obsR;
    }

}
