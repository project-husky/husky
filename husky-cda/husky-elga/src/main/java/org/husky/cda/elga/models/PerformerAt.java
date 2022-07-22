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

import org.husky.cda.elga.generated.artdecor.AtcdabbrOtherPerformerBody;
import org.husky.cda.elga.generated.artdecor.AtcdabbrOtherPerformerBodyImpfendePerson;
import org.husky.cda.elga.generated.artdecor.base.LaboratoryPerformer2;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Performer;
import org.husky.common.utils.time.DateTimes;

public class PerformerAt extends Performer {

	Code immunizationRole;

	public Code getImmunizationRole() {
		return immunizationRole;
	}

	public void setImmunizationRole(Code immunizationRole) {
		this.immunizationRole = immunizationRole;
	}

	public AtcdabbrOtherPerformerBodyImpfendePerson getAtcdabbrOtherPerformerBodyImpfendePerson(
			ZonedDateTime timePerformed) {
		AtcdabbrOtherPerformerBodyImpfendePerson performer = new AtcdabbrOtherPerformerBodyImpfendePerson();
		performer.setAssignedEntity(getHl7Cdar2Perfomer().getAssignedEntity());
		performer.setHl7Time(new IVLTS(DateTimes.toDatetimeTs(timePerformed).getValue()));

		if (immunizationRole != null) {
			performer.getAssignedEntity().setCode(new CE(immunizationRole.getCode(), immunizationRole.getCodeSystem(),
					immunizationRole.getCodeSystemName(), immunizationRole.getDisplayName()));
		} else {
			CE codeCE = new CE();
			codeCE.nullFlavor = new ArrayList<>();
			codeCE.nullFlavor.add("UNK");
			performer.getAssignedEntity().setCode(codeCE);
		}

		return performer;
	}

	public LaboratoryPerformer2 getLaboratoryPerformer2(ZonedDateTime finishingLabTest) {
		LaboratoryPerformer2 lab = new LaboratoryPerformer2();
		lab.setHl7Time(new IVLTS(DateTimes.toDatetimeTs(finishingLabTest).getValue()));

		POCDMT000040AssignedEntity assignedEntity = getHl7Cdar2Perfomer().getAssignedEntity();

		if (assignedEntity.getId().isEmpty()) {
			Identificator id = new Identificator();
			id.setNullFlavor(NullFlavor.NOINFORMATION);
			assignedEntity.getId().add(id.getHl7CdaR2Ii());
		}

		Code code = new Code();
		code.setCode("E");
		code.setCodeSystem("2.16.840.1.113883.2.16.1.4.9");
		code.setCodeSystemName("HL7.at.Laborkennzeichnung");
		code.setDisplayName("EXTERN");
		assignedEntity.setCode(code.getHl7CdaR2Ce());

		lab.setHl7AssignedEntity(assignedEntity);

		return lab;
	}

	public AtcdabbrOtherPerformerBody getAtcdabbrOtherPerformerBodyLaboratory(ZonedDateTime finishingLabTest) {
		AtcdabbrOtherPerformerBody lab = new AtcdabbrOtherPerformerBody();
		lab.setHl7Time(new IVLTS(DateTimes.toDatetimeTs(finishingLabTest).getValue()));

		POCDMT000040AssignedEntity assignedEntity = getHl7Cdar2Perfomer().getAssignedEntity();

		if (assignedEntity.getId().isEmpty()) {
			Identificator id = new Identificator();
			id.setNullFlavor(NullFlavor.UNKNOWN);
			assignedEntity.getId().add(id.getHl7CdaR2Ii());
		}

		if (immunizationRole != null) {
			assignedEntity.setCode(immunizationRole.getHl7CdaR2Ce());
		} else {
			Code code = new Code();
			code.setNullFlavor(NullFlavor.UNKNOWN);
			assignedEntity.setCode(code.getHl7CdaR2Ce());
		}

		lab.setHl7AssignedEntity(assignedEntity);

		return lab;
	}

}
