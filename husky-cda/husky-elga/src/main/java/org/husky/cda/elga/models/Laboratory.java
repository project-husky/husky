/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.husky.cda.elga.generated.artdecor.base.enums.ElgaObservationInterpretation;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040Observation;
import org.husky.common.hl7cdar2.POCDMT000040ObservationRange;
import org.husky.common.hl7cdar2.POCDMT000040ReferenceRange;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.utils.DateUtil;

public class Laboratory {

	private Identificator labTestId;
	private Code analysisCode;
	private boolean aborted;
	private ZonedDateTime samplingTime;
	private LaboratoryValue value;
	private ParticipantAt validatingPerson;
	private ZonedDateTime validatingTime;
	private Map<ElgaObservationInterpretation, LaboratoryValue> observationRange;
	private Map<ZonedDateTime, PerformerAt> laboratories;

	private void setObservationRange(int index, POCDMT000040Observation observation) {
		Iterator<Entry<ElgaObservationInterpretation, LaboratoryValue>> iteratorObservationRange = observationRange
				.entrySet().iterator();
		int indexObservationRange = 0;
		while (iteratorObservationRange.hasNext()) {
			Entry<ElgaObservationInterpretation, LaboratoryValue> entry = iteratorObservationRange.next();

			if (entry != null) {
				POCDMT000040ReferenceRange referenceRange = new POCDMT000040ReferenceRange();
				referenceRange.getTypeCode().add("REFV");

				POCDMT000040ObservationRange pocdObservationRange = new POCDMT000040ObservationRange();
				pocdObservationRange.getClassCode().add("OBS");
				pocdObservationRange.getMoodCode().add("EVN.CRT");

				if (entry.getKey() != null) {
					Code code = entry.getKey().getCode();
					pocdObservationRange.setInterpretationCode(new CE(code.getCode(), code.getCodeSystem(),
							code.getCodeSystemName(), code.getDisplayName()));
				}

				if (entry.getValue() != null) {
					pocdObservationRange.setValue(entry.getValue().getValue());
				}

				pocdObservationRange
						.setText(new ED(null, new TEL("#analyseRef-" + index + "-" + indexObservationRange++)));
				referenceRange.setObservationRange(pocdObservationRange);

				observation.getReferenceRange().add(referenceRange);
			}

		}
	}

	private void setSamplingTime(POCDMT000040Observation observation) {
		if (getSamplingTime() != null) {
			observation.setEffectiveTime(new IVLTS(DateUtil.formatDateTimeTzon(getSamplingTime())));
		} else {
			IVLTS effectiveTimeUnk = new IVLTS();
			effectiveTimeUnk.nullFlavor = new ArrayList<>();
			effectiveTimeUnk.nullFlavor.add("UNK");
			observation.setEffectiveTime(effectiveTimeUnk);
		}
	}

	protected void fillPOCDMT000040Observation(POCDMT000040Observation observation, int index) {
		if (observation != null) {
			if (getLabTestId() != null) {
				observation.getId().add(getLabTestId().getHl7CdaR2Ii());
				observation.setText(new ED(null, new TEL("#" + getLabTestId().getExtension())));
			} else {
				observation.setText(new ED(null, new TEL("#analyse-" + index)));
			}

			if (getAnalysisCode() != null) {
				observation.setCode(getAnalysisCode().getHl7CdaR2Ce());
			}

			setSamplingTime(observation);

			if (getValidatingPerson() != null) {
				observation.getParticipant()
						.add(getValidatingPerson().getPOCDMT000040Participant2(getValidatingTime()));
			}

			if (value != null) {
				observation.getValue().add(value.getValue());
			}

			if (getObservationRange() != null) {
				setObservationRange(index, observation);
			}
		}
	}

	public Identificator getLabTestId() {
		return labTestId;
	}

	public void setLabTestId(Identificator labTestId) {
		this.labTestId = labTestId;
	}

	public boolean isAborted() {
		return aborted;
	}

	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}

	public ParticipantAt getValidatingPerson() {
		return validatingPerson;
	}

	public void setValidatingPerson(ParticipantAt validatingPerson) {
		this.validatingPerson = validatingPerson;
	}

	public ZonedDateTime getValidatingTime() {
		return validatingTime;
	}

	public void setValidatingTime(ZonedDateTime validatingTime) {
		this.validatingTime = validatingTime;
	}

	public ZonedDateTime getSamplingTime() {
		return samplingTime;
	}

	public void setSamplingTime(ZonedDateTime samplingTime) {
		this.samplingTime = samplingTime;
	}

	public LaboratoryValue getValue() {
		return value;
	}

	public void setValue(LaboratoryValue value) {
		this.value = value;
	}

	public Map<ElgaObservationInterpretation, LaboratoryValue> getObservationRange() {
		return observationRange;
	}

	public void setObservationRange(Map<ElgaObservationInterpretation, LaboratoryValue> observationRange) {
		this.observationRange = observationRange;
	}

	public Code getAnalysisCode() {
		return analysisCode;
	}

	public Map<ZonedDateTime, PerformerAt> getLaboratories() {
		return laboratories;
	}

	public void setAnalysisCode(Code analysisCode) {
		this.analysisCode = analysisCode;
	}

	public void setLaboratories(Map<ZonedDateTime, PerformerAt> laboratories) {
		this.laboratories = laboratories;
	}


}
