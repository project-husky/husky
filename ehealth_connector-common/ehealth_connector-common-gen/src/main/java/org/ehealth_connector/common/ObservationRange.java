package org.ehealth_connector.common;

import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;

public class ObservationRange {
	org.openhealthtools.mdht.uml.cda.ObservationRange mObsR;

	public ObservationRange() {
		mObsR = CDAFactory.eINSTANCE.createObservationRange();
		mObsR.setClassCode(ActClassObservation.OBS);
		mObsR.setMoodCode(ActMood.EVNCRT);
	}

	public ObservationRange(org.openhealthtools.mdht.uml.cda.ObservationRange mdht) {
		mObsR = mdht;
	}

	public ObservationInterpretation getInterpretationCode() {
		if (mObsR.getInterpretationCode() != null) {
			return ObservationInterpretation.getEnum(mObsR.getInterpretationCode().getCode());
		}
		return null;
	}

	public Value getValue() {
		if (mObsR.getValue() != null) {
			return new Value(mObsR.getValue());
		}
		return null;
	}

	public void setInterpretationCode(ObservationInterpretation code) {
		mObsR.setInterpretationCode(code.getCE());
	}

	public void setValue(Value value) {
		mObsR.setValue(value.getValue());
	}

}
