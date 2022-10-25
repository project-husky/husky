/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.eimpf;

import java.util.ArrayList;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrEntryImmunizationSchedule;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.POCDMT000040Precondition;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.model.Code;

public class ImmunizationSchedule {

	private static final String REFERENCE_TEXT_EIMPF_DOSE = "#schedule-dose-";

	private Code immunizationScheme;
	private Code immunizationDose;

	public Code getImmunizationScheme() {
		return immunizationScheme;
	}


	public void setImmunizationScheme(Code immunizationScheme) {
		this.immunizationScheme = immunizationScheme;
	}


	public Code getImmunizationDose() {
		return immunizationDose;
	}


	public void setImmunizationDose(Code immunizationDose) {
		this.immunizationDose = immunizationDose;
	}


	public POCDMT000040Precondition getImmunizationRecommendationEntry(int index) {
		POCDMT000040Precondition precondition = new POCDMT000040Precondition();
		precondition.getTypeCode().add("PRCN");
		AtcdabbrEntryImmunizationSchedule schedule = new AtcdabbrEntryImmunizationSchedule();

		if (immunizationScheme != null) {
			schedule.setCode(new CE(immunizationScheme.getCode(), immunizationScheme.getCodeSystem(),
					immunizationScheme.getCodeSystemName(), immunizationScheme.getDisplayName()));
		} else {
			CE code = new CE();
			code.getNullFlavor().add("NI");
			schedule.setCode(code);
		}

		if (immunizationDose != null) {
			schedule.setValue(new CD(immunizationDose.getCode(), immunizationDose.getCodeSystem(),
					immunizationDose.getCodeSystemName(), immunizationDose.getDisplayName()));
		} else {
			CD value = new CD();
			value.nullFlavor = new ArrayList<>();
			value.nullFlavor.add("UNK");
			schedule.setValue(value);
		}

		StringBuilder sbEimpfDose = new StringBuilder(REFERENCE_TEXT_EIMPF_DOSE);
		sbEimpfDose.append(index);
		schedule.setHl7Text(new ED(null, new TEL(sbEimpfDose.toString())));

		precondition.setCriterion(schedule);
		return precondition;
	}

	public POCDMT000040Precondition getImmunizationScheduleEntry(int index) {
		POCDMT000040Precondition precondition = new POCDMT000040Precondition();
		precondition.getTypeCode().add("PRCN");
		AtcdabbrEntryImmunizationSchedule schedule = new AtcdabbrEntryImmunizationSchedule();

		if (immunizationScheme != null) {
			schedule.setCode(new CE(immunizationScheme.getCode(), immunizationScheme.getCodeSystem(),
					immunizationScheme.getCodeSystemName(), immunizationScheme.getDisplayName()));
		} else {
			CE code = new CE();
			code.getNullFlavor().add("NI");
			schedule.setCode(code);
		}

		StringBuilder sbEimpfDose = new StringBuilder(REFERENCE_TEXT_EIMPF_DOSE);
		sbEimpfDose.append(index);

		if (immunizationDose != null) {
			schedule.setValue(new CD(immunizationDose.getCode(), immunizationDose.getCodeSystem(),
					immunizationDose.getCodeSystemName(), immunizationDose.getDisplayName()));
		}

		schedule.setHl7Text(new ED(null, new TEL(sbEimpfDose.toString())));

		precondition.setCriterion(schedule);
		return precondition;
	}


}
