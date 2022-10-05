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

import org.projecthusky.cda.elga.generated.artdecor.EimpfDocumentUpdateImmunisierungsstatus;
import org.projecthusky.cda.elga.models.PatientContact;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.common.at.enums.ConfidentialityCode;
import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component2;
import org.projecthusky.common.hl7cdar2.POCDMT000040Custodian;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Organization;
import org.projecthusky.common.utils.time.DateTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateImmunizationState extends ImmunizationState {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpdateImmunizationState.class.getName());

	private PractitionerCdaAt dataEnterer;
	private PractitionerCdaAt legalAuthenticator;
	private PatientContact patientContact;

	public PractitionerCdaAt getDataEnterer() {
		return dataEnterer;
	}

	public void setDataEnterer(PractitionerCdaAt dataEnterer) {
		this.dataEnterer = dataEnterer;
	}

	public PractitionerCdaAt getLegalAuthenticator() {
		return legalAuthenticator;
	}

	public void setLegalAuthenticator(PractitionerCdaAt legalAuthenticator) {
		this.legalAuthenticator = legalAuthenticator;
	}

	public PatientContact getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(PatientContact patientContact) {
		this.patientContact = patientContact;
	}

	public EimpfDocumentUpdateImmunisierungsstatus getUpdateImmunizationState() {
		EimpfDocumentUpdateImmunisierungsstatus cda = new EimpfDocumentUpdateImmunisierungsstatus();

		addHeader(cda);

		POCDMT000040Component2 comp2 = new POCDMT000040Component2();
		comp2.setStructuredBody(getHl7CdaR2Pocdmt000040StructuredBodyImmunizationState());
		cda.setHl7Component(comp2);

		return cda;
	}

	private void addHeader(EimpfDocumentUpdateImmunisierungsstatus cda) {
		String gdaIndex = "";
		if (this.getAuthors() != null && !this.getAuthors().isEmpty()) {
			gdaIndex = this.getAuthors().get(0).getGdaIndex();

			for (PractitionerCdaAt author : getAuthors()) {
				cda.getHl7Author().add(author.getAtcdabbrHeaderAuthor(this.getAuthorTime()));
			}
		}

		cda.setHl7Id(new Identificator(gdaIndex, getDocId()).getHl7CdaR2Ii());
		cda.setHl7SetId(new Identificator(gdaIndex, this.getSetId()).getHl7CdaR2Ii());
		cda.setHl7VersionNumber(new INT(this.getVersion()));

		cda.setTitle(createTitle(this.getTitle()));
		cda.setEffectiveTime(DateTimes.toDatetimeTs(ZonedDateTime.now()));

		CE confCode = ConfidentialityCode.NORMAL.getCode().getHl7CdaR2Ce();
		confCode.setCodeSystemName("HL7:Confidentiality");
		cda.setConfidentialityCode(confCode);

		LOGGER.warn("code system name: {}", ConfidentialityCode.NORMAL.getCode().getCodeSystemName());

		cda.setHl7RealmCode(new CS("AT"));
		cda.setHl7LanguageCode(new CS("de-AT"));

		if (getPatient() != null) {
			cda.setHl7RecordTarget(this.getPatient().getAtcdabbrHeaderRecordTargetEImpfpass());

		}

		if (legalAuthenticator != null) {
			cda.setHl7LegalAuthenticator(legalAuthenticator.getHeaderLegalAuthenticator(this.getAuthorTime()));
		}

		if (dataEnterer != null) {
			cda.setHl7DataEnterer(dataEnterer.getHeaderDataEnterer(this.getAuthorTime()));
		}

		cda.setHl7Custodian(createHeaderCustodian(this.getCustodian()));

		cda.getDocumentationOf().add(getAtcdabbrHeaderDocumentationOfServiceEvent());

		if (this.patientContact != null) {
			cda.setComponentOf(this.patientContact.getAtcdabbrHeaderComponentOfEncompassingEncounter());
		}

		if (this.getParentDocument() != null && this.getParentDocument().getExtension() != null
				&& !this.getParentDocument().getExtension().isEmpty() && this.getParentDocument().getRoot() != null
				&& !this.getParentDocument().getRoot().isEmpty()) {
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
