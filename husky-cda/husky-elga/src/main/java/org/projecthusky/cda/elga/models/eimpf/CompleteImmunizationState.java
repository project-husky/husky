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

import java.time.ZonedDateTime;

import org.projecthusky.cda.elga.generated.artdecor.EimpfDocumentKompletterImmunisierungsstatus;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.common.at.enums.ConfidentialityCode;
import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component2;
import org.projecthusky.common.hl7cdar2.POCDMT000040Custodian;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Organization;
import org.projecthusky.common.utils.time.DateTimes;

public class CompleteImmunizationState extends ImmunizationState {

	public EimpfDocumentKompletterImmunisierungsstatus getCompleteImmunizationState() {
		EimpfDocumentKompletterImmunisierungsstatus cda = new EimpfDocumentKompletterImmunisierungsstatus();

		addHeader(cda);

		POCDMT000040Component2 comp2 = new POCDMT000040Component2();
		comp2.setStructuredBody(this.getHl7CdaR2Pocdmt000040StructuredBodyImmunizationState());
		cda.setHl7Component(comp2);

		return cda;
	}

	private void addHeader(EimpfDocumentKompletterImmunisierungsstatus cda) {
		String gdaIndex = "";
		if (this.getAuthors() != null && !this.getAuthors().isEmpty()) {
			gdaIndex = this.getAuthors().get(0).getGdaIndex();

			for (PractitionerCdaAt author : this.getAuthors()) {
				cda.getAuthor().add(author.getAtcdabbrHeaderAuthor(this.getAuthorTime()));
			}
		}

		cda.setHl7Id(new Identificator(gdaIndex, this.getDocId()).getHl7CdaR2Ii());
		cda.setHl7SetId(new Identificator(gdaIndex, this.getSetId()).getHl7CdaR2Ii());
		cda.setVersionNumber(new INT(this.getVersion()));

		cda.setTitle(createTitle(this.getTitle()));
		cda.setEffectiveTime(DateTimes.toDatetimeTs(ZonedDateTime.now()));

		cda.setConfidentialityCode(ConfidentialityCode.NORMAL.getHl7cdar2CE());

		if (this.getPatient() != null) {
			cda.setHl7RecordTarget(this.getPatient().getAtcdabbrHeaderRecordTargetEImpfpass());

		}

		cda.setHl7Custodian(createHeaderCustodian(this.getCustodian()));

		cda.getDocumentationOf().add(getAtcdabbrHeaderDocumentationOfServiceEvent());

		if (this.getParentDocument() != null) {
			cda.getRelatedDocument().add(getAtcdabbrHeaderDocumentReplacementRelatedDocument());
		}

	}

	protected POCDMT000040Custodian createHeaderCustodian(Organization org) {
		if (org == null) {
			org = new Organization(new OrganizationBaseType());
		}

		POCDMT000040Custodian cust = org.getHl7CdaR2Pocdmt000040Custodian();
		cust.getTypeCode().add("CST");
		cust.getAssignedCustodian().setClassCode("ASSIGNED");
		cust.getAssignedCustodian().getRepresentedCustodianOrganization().setClassCode("ORG");
		cust.getAssignedCustodian().getRepresentedCustodianOrganization().setDeterminerCode("INSTANCE");

		return cust;
	}


}
