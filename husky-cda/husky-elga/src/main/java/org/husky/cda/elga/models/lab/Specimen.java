/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models.lab;

import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.POCDMT000040PlayingEntity;
import org.husky.common.hl7cdar2.POCDMT000040Specimen;
import org.husky.common.hl7cdar2.POCDMT000040SpecimenRole;
import org.husky.common.hl7cdar2.RoleClassSpecimen;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;

public class Specimen  {

	private Identificator id;
	private Code significantPathogen;

	public Identificator getId() {
		return id;
	}

	public Code getSignificantPathogen() {
		return significantPathogen;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public void setSignificantPathogen(Code significantPathogen) {
		this.significantPathogen = significantPathogen;
	}

	public POCDMT000040Specimen getPOCDMT000040Specimen() {
		POCDMT000040Specimen hl7Cdar2Specimen = new POCDMT000040Specimen();
		hl7Cdar2Specimen.getTypeCode().add("SPC");
		POCDMT000040SpecimenRole specimenRole = new POCDMT000040SpecimenRole();
		specimenRole.setClassCode(RoleClassSpecimen.SPEC);
		specimenRole.getId().add(id.getHl7CdaR2Ii());

		POCDMT000040PlayingEntity entity = new POCDMT000040PlayingEntity();
		entity.getClassCode().add("MIC");
		entity.setCode(significantPathogen.getHl7CdaR2Ce());
		
		ED ed = new ED();
		ed.setXmlMixed(significantPathogen.getOriginalText());
		entity.getCode().setOriginalText(ed);
		specimenRole.setSpecimenPlayingEntity(entity);
		hl7Cdar2Specimen.setSpecimenRole(specimenRole);

		return hl7Cdar2Specimen;
	}

}
