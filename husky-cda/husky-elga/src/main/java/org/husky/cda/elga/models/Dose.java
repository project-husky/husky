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

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.husky.cda.elga.generated.artdecor.emed.Dosierung1;
import org.husky.cda.elga.generated.artdecor.emed.Dosierung2er;
import org.husky.cda.elga.generated.artdecor.emed.Dosierung3;
import org.husky.cda.elga.generated.artdecor.emed.Dosierung3dq;
import org.husky.cda.elga.generated.artdecor.emed.Dosierung4er;
import org.husky.cda.elga.generated.artdecor.emed.enums.ElgaEinnahmezeitpunkte;
import org.husky.cda.elga.generated.artdecor.emed.enums.ElgaMedikationFrequenz;
import org.husky.cda.elga.generated.artdecor.emed.enums.ElgaMedikationMengenart;
import org.husky.common.hl7cdar2.EIVLEvent;
import org.husky.common.hl7cdar2.EIVLTS;
import org.husky.common.hl7cdar2.INT;
import org.husky.common.hl7cdar2.IVLPQ;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.PIVLTS;
import org.husky.common.hl7cdar2.POCDMT000040Consumable;
import org.husky.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.husky.common.hl7cdar2.POCDMT000040Material;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.PQ;
import org.husky.common.hl7cdar2.SXCMTS;
import org.husky.common.hl7cdar2.SXPRTS;
import org.husky.common.hl7cdar2.SetOperator;
import org.husky.common.hl7cdar2.XDocumentSubstanceMood;
import org.husky.common.model.Code;
import org.husky.common.utils.time.DateTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dose {

	private static final Logger LOGGER = LoggerFactory.getLogger(Dose.class.getName());
	private Double quantity;
	private Code unit;
	private Code frequence;
	private Code intakeTime;
	private List<LocalDate> days;
	private String text;

	public Dose(POCDMT000040SubstanceAdministration substance) {
		days = new ArrayList<>();
		if (substance != null) {
			if (!substance.getEffectiveTime().isEmpty()) {
				setDoses(substance.getEffectiveTime());
			}

			if (substance.getDoseQuantity() != null && substance.getDoseQuantity().getValue() != null) {
				try {
					this.quantity = Double.parseDouble(substance.getDoseQuantity().getValue());
				} catch (NumberFormatException ex) {
					LOGGER.error(ex.getMessage());
				}
			}
		}
	}

	private void setDoses(List<SXCMTS> effectiveTimes) {
		for (SXCMTS sxcmts : effectiveTimes) {
			if (sxcmts instanceof SXPRTS sxprts) {
				for (SXCMTS sxcmts2 : sxprts.getComp()) {
					if (sxcmts2 instanceof EIVLTS eivlts) {
						setSingleDose(eivlts);
					} else if (sxcmts2 instanceof PIVLTS pivlts) {
						setDailyDose(pivlts);
					}
				}
			} else if (sxcmts instanceof EIVLTS eivlts) {
				setSingleDose(eivlts);
			} else if (sxcmts instanceof PIVLTS pivlts) {
				setDailyDose(pivlts);
			}
		}
	}

	private void setSingleDose(EIVLTS effectiveTime) {
		if (effectiveTime == null) {
			return;
		}

		if (effectiveTime.getEvent() != null && effectiveTime.getEvent().getCode() != null) {
			this.intakeTime = ElgaEinnahmezeitpunkte.getEnum(effectiveTime.getEvent().getCode()).getCode();
		}

		if (effectiveTime.getOffset() != null && !effectiveTime.getOffset().getUnit().isEmpty()) {
			this.frequence = ElgaMedikationFrequenz.getEnum(effectiveTime.getOffset().getUnit()).getCode();
		}
	}

	private void setDailyDose(PIVLTS effectiveTime) {
		if (effectiveTime == null) {
			return;
		}

		if (effectiveTime.getPhase() != null && effectiveTime.getPhase().getValue() != null) {
			this.days.add(DateTimes.toLocalDate(effectiveTime.getPhase()));
		}

		if (effectiveTime.getPeriod() != null && !effectiveTime.getPeriod().getUnit().isEmpty()) {
			this.frequence = ElgaMedikationFrequenz.getEnum(effectiveTime.getPeriod().getUnit()).getCode();
		}

	}

	public List<LocalDate> getDays() {
		return days;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Code getFrequence() {
		return frequence;
	}

	public Code getIntakeTime() {
		return intakeTime;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Code getUnit() {
		return unit;
	}

	public void setDays(List<LocalDate> days) {
		this.days = days;
	}

	public void setFrequence(Code frequence) {
		this.frequence = frequence;
	}

	public void setIntakeTime(Code intakeTime) {
		this.intakeTime = intakeTime;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setUnit(Code unit) {
		this.unit = unit;
	}

	public Dosierung1 getDosierung1DailyDose() {
		Dosierung1 dose1 = new Dosierung1();
		PQ pq = dose1.getHl7Period();
		pq.setUnit(frequence.getCode());
		pq.setValue(this.quantity.toString());
		dose1.setHl7Period(pq);
		return dose1;
	}

	protected Dosierung3 getDosierung3DailyDoseWithPauseSingleWeekDay() {
		Dosierung3 dose = new Dosierung3();
		dose.setOperator(SetOperator.A);
		if (days != null && !days.isEmpty() && frequence != null) {
			IVLTS phase = new IVLTS();
			phase.setValue(DateTimes.toDateTs(days.get(0)).getValue());
			dose.setPhase(phase);
			dose.setPeriod(new PQ("1.0", frequence.getCode()));
		}

		return dose;
	}

	private PIVLTS createEffectiveTimePhasePeriod(String phaseValue, Double periodValue, String unit) {
		PIVLTS effectiveTime = new PIVLTS();
		effectiveTime.setOperator(SetOperator.A);
		IVLTS phase = new IVLTS();
		phase.setValue(phaseValue);
		effectiveTime.setPhase(phase);
		effectiveTime.setPeriod(new PQ(String.valueOf(periodValue), unit));
		return effectiveTime;
	}

	public Dosierung3dq getDosierung3dqDailyDoseWithPauseMultipleWeekDays() {
		Dosierung3dq dose = new Dosierung3dq();
		SXPRTS effectiveTime = new SXPRTS();

		if (days != null) {
			for (LocalDate day : this.days) {
				PIVLTS compEffTime = new PIVLTS();
				compEffTime.setOperator(SetOperator.A);
				IVLTS phase = new IVLTS();
				if (day != null) {
					phase.setValue(DateTimes.toDateTs(day).getValue());
				}

				compEffTime.setPhase(phase);
				if (frequence != null) {
					compEffTime.setPeriod(new PQ("1.0", frequence.getCode()));
				}

				effectiveTime.getComp().add(compEffTime);
			}
		}

		return dose;
	}

	public Dosierung2er getDosierung2erSingleDose(int index) {
		Dosierung2er dose = new Dosierung2er();

		INT sequenceNo = new INT();
		sequenceNo.setValue(BigInteger.valueOf(index));
		dose.setSequenceNumber(sequenceNo);

		if (quantity != null) {
			dose.setSubstanceAdministration(createSubstanceAdministrationForSingleDosage(quantity.toString(),
					intakeTime, "0", ElgaMedikationMengenart.S.getCode()));
		}

		return dose;
	}

	public Dosierung4er getDosierung4erSingleDoseWithPause(int index) {
		Dosierung4er dose = new Dosierung4er();
		INT sequenceNo = new INT();
		sequenceNo.setValue(BigInteger.valueOf(index));
		dose.setSequenceNumber(sequenceNo);
		dose.setSubstanceAdministration(getHl7CdaR2Pocdmt000040SubstanceAdministrationForSingleDosageWithPause());

		return dose;
	}

	protected POCDMT000040SubstanceAdministration getHl7CdaR2Pocdmt000040SubstanceAdministrationForSingleDosageWithPause() {
		POCDMT000040SubstanceAdministration substance = new POCDMT000040SubstanceAdministration();
		substance.getClassCode().add("SBADM");
		substance.setMoodCode(XDocumentSubstanceMood.INT);

		SXPRTS effectiveTime = new SXPRTS();
		EIVLTS eivlts = new EIVLTS();
		EIVLEvent event = new EIVLEvent();
		event.setCode(intakeTime.getCode());
		eivlts.setEvent(event);
		
		IVLPQ doseQuantity = new IVLPQ("0", ElgaMedikationMengenart.S.getCodeValue());
		eivlts.setOffset(doseQuantity);

		effectiveTime.getComp().add(eivlts);

		if (days != null) {
			for (LocalDate day : days) {
				if (day != null) {
					effectiveTime.getComp().add(createEffectiveTimePhasePeriod(DateTimes.toDateTs(day).getValue(), 1.0,
							ElgaMedikationFrequenz.WEEK_CODE));
				}
			}
		}

		substance.getEffectiveTime().add(effectiveTime);

		if (quantity != null) {
			substance.setDoseQuantity(getIVLPQ(quantity.toString(), unit));
		}

		substance.setConsumable(getHl7CdaR2Pocdmt000040ConsumableEmpty());

		return substance;
	}

	private POCDMT000040SubstanceAdministration createSubstanceAdministrationForSingleDosage(String doseQuantity,
			Code event, String offsetValue, Code unit) {
		POCDMT000040SubstanceAdministration substance = new POCDMT000040SubstanceAdministration();
		substance.getClassCode().add("SBADM");
		substance.setMoodCode(XDocumentSubstanceMood.INT);
		substance.setConsumable(getHl7CdaR2Pocdmt000040ConsumableEmpty());
		substance.setDoseQuantity(getIVLPQ(doseQuantity, null));

		EIVLTS eivlts = new EIVLTS();
		EIVLEvent eivlEvent = new EIVLEvent();
		eivlEvent.setCode(event.getCode());
		eivlts.setEvent(eivlEvent);

		IVLPQ ivlpq = new IVLPQ(offsetValue, unit.getCode());
		eivlts.setOffset(ivlpq);

		substance.getEffectiveTime().add(eivlts);
		return substance;
	}

	public static IVLPQ getIVLPQ(String value, Code unit) {
		IVLPQ retVal = new IVLPQ();

		if (value != null) {
			retVal.setValue(value);

			if (unit != null) {
				retVal.setUnit(unit.getCode());
			}

		} else {
			retVal.nullFlavor = new ArrayList<String>();
			retVal.nullFlavor.add("UNK");
		}

		return retVal;
	}

	private POCDMT000040Consumable getHl7CdaR2Pocdmt000040ConsumableEmpty() {
		POCDMT000040Consumable consumable = new POCDMT000040Consumable();
		consumable.getTypeCode().add("CSM");
		POCDMT000040ManufacturedProduct drugEntry = new POCDMT000040ManufacturedProduct();
		POCDMT000040Material material = new POCDMT000040Material();
		material.setClassCode("MMAT");
		material.getNullFlavor().add("NA");
		drugEntry.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(drugEntry);
		return consumable;
	}

}
