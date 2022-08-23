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

import java.util.List;

import org.husky.cda.elga.generated.artdecor.base.Annotation;
import org.husky.cda.elga.models.Appendix;
import org.husky.common.hl7cdar2.ActRelationshipHasComponent;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.POCDMT000040Component4;
import org.husky.common.hl7cdar2.POCDMT000040Organizer;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.model.Code;

public class LaboratoryBatteryOrganizer extends Organizer {
	private Code structure;
	private List<Appendix> appendices;
	private List<String> notes;

	public Code getStructure() {
		return structure;
	}

	public List<Appendix> getAppendices() {
		return appendices;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setStructure(Code structure) {
		this.structure = structure;
	}

	public void setAppendices(List<Appendix> appendices) {
		this.appendices = appendices;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public org.husky.cda.elga.generated.artdecor.base.LaboratoryBatteryOrganizer getLaboratoryBatteryOrganizer() {
		org.husky.cda.elga.generated.artdecor.base.LaboratoryBatteryOrganizer organizer = new org.husky.cda.elga.generated.artdecor.base.LaboratoryBatteryOrganizer();

		organizer.setHl7Code(structure.getHl7CdaR2Ce());

		fillPOCDMT000040Organizer(organizer);

		addAppendices(organizer);
		addNotes(organizer);

		return organizer;
	}

	private void addAppendices(POCDMT000040Organizer organizer) {
		if (appendices != null && !appendices.isEmpty()) {
			int index = 0;
			for (Appendix appendix : appendices) {
				if (appendix != null) {
					POCDMT000040Component4 component = new POCDMT000040Component4();
					component.setTypeCode(ActRelationshipHasComponent.COMP);
					component.setObservationMedia(appendix.getEingebettetesObjektEntry("organizer", index));
					organizer.getComponent().add(component);
					index++;
				}
			}
		}
	}

	private void addNotes(POCDMT000040Organizer organizer) {
		if (notes != null && !notes.isEmpty()) {
			int index = 0;
			for (String note : notes) {
				if (note != null && !note.isEmpty()) {
					POCDMT000040Component4 component = new POCDMT000040Component4();
					component.setTypeCode(ActRelationshipHasComponent.COMP);
					component.setAct(getAnnotation(index));
					organizer.getComponent().add(component);
					index++;
				}
			}
		}
	}

	private Annotation getAnnotation(int index) {
		Annotation note = new Annotation();
		note.setText(new ED(null, new TEL("#footnote-" + index)));
		return note;
	}

}
