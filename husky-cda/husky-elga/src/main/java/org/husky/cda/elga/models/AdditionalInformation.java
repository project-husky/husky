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

import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.XActClassDocumentEntryAct;
import org.husky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.husky.common.hl7cdar2.XDocumentActMood;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;

public class AdditionalInformation {

	private Code kindOfInformation;
	private String information;
	
	public AdditionalInformation(POCDMT000040EntryRelationship entryRel) {
		if(entryRel != null && entryRel.getAct() != null && entryRel.getAct().getCode() != null) {
			this.kindOfInformation = new Code(entryRel.getAct().getCode());
		}
	}

	public String getInformation() {
		return information;
	}

	public Code getKindOfInformation() {
		return kindOfInformation;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public void setKindOfInformation(Code kindOfInformation) {
		this.kindOfInformation = kindOfInformation;
	}

	public POCDMT000040EntryRelationship getEntryRelationshipForPatientInformation(int index) {
		if (this.kindOfInformation == null || this.information == null) {
			return null;
		}
		
		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
		entryRel.setInversionInd(true);

		StringBuilder sb = new StringBuilder("#");
		sb.append(this.kindOfInformation.getCode().toLowerCase());
		sb.append("-");
		sb.append(index);

		return createEntryRelationshipInformation(entryRel, sb.toString(), this.kindOfInformation,
				"1.2.40.0.34.11.8.0.3.1");
	}

	public POCDMT000040EntryRelationship getEntryRelationshipForDispenseInformation(int index) {
		if (kindOfInformation == null || information == null) {
			return null;
		}

		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
		entryRel.setInversionInd(true);

		StringBuilder sb = new StringBuilder("#");
		sb.append(kindOfInformation.getCode().toLowerCase());
		sb.append("-");
		sb.append(index);

		return createEntryRelationshipInformation(entryRel, sb.toString(), kindOfInformation,
				"1.2.40.0.34.11.8.0.3.2");
	}

	protected POCDMT000040EntryRelationship createEntryRelationshipInformation(POCDMT000040EntryRelationship entryRel,
			String reference, Code code, String templateId) {
		POCDMT000040Act act = new POCDMT000040Act();
		act.setClassCode(XActClassDocumentEntryAct.ACT);
		act.setMoodCode(XDocumentActMood.INT);
		act.getTemplateId().add(new Identificator(templateId).getHl7CdaR2Ii());
		act.setCode(code.getHl7CdaR2Ce());
		act.setStatusCode(new CS("completed"));
		act.setText(new ED(null, new TEL(reference)));

		entryRel.setAct(act);

		return entryRel;
	}

}
