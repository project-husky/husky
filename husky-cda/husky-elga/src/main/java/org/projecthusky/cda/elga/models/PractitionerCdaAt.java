/*
* This getCode() is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrHeaderAuthor;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrHeaderDataEnterer;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrHeaderLegalAuthenticator;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrOtherAuthorBodyEImpfpass;
import org.projecthusky.cda.elga.generated.artdecor.ps.AuthorBodyPs;
import org.projecthusky.common.at.PractitionerAt;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.projecthusky.common.hl7cdar2.POCDMT000040Author;
import org.projecthusky.common.hl7cdar2.POCDMT000040LegalAuthenticator;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.utils.time.DateTimes;

public class PractitionerCdaAt extends PractitionerAt {

	public PractitionerCdaAt() {
		super();
	}

	public PractitionerCdaAt(POCDMT000040Author author) {
		super(author);
	}

	public PractitionerCdaAt(POCDMT000040LegalAuthenticator authenticator) {
		super(authenticator);
	}

	public AtcdabbrHeaderAuthor getAtcdabbrHeaderAuthor(ZonedDateTime timeAuthor) {
		AtcdabbrHeaderAuthor author = new AtcdabbrHeaderAuthor();

		TS time = new TS();

		if (timeAuthor == null) {
			time.getNullFlavor().add(NullFlavor.UNKNOWN_L1_CODE);
		} else {
			time.setValue(DateTimes.toDatetimeTs(timeAuthor).getValue());
		}

		author.setTime(time);

		if (getCode() != null) {
			author.setFunctionCode(getCode().getHl7CdaR2Ce());
		}

		author.setAssignedAuthor(getHl7CdaR2Pocdmt000040AssignedAuthor(author.getAssignedAuthor()));
		return author;
	}

	public AtcdabbrHeaderLegalAuthenticator getHeaderLegalAuthenticator(ZonedDateTime timeLegalAuthen) {
		AtcdabbrHeaderLegalAuthenticator legalAuthenticator = new AtcdabbrHeaderLegalAuthenticator();

		TS time = new TS();

		if (timeLegalAuthen == null) {
			time.getNullFlavor().add(NullFlavor.UNKNOWN_L1_CODE);
		} else {
			time.setValue(DateTimes.toDatetimeTs(timeLegalAuthen).getValue());
		}

		legalAuthenticator.setHl7Time(time);
		legalAuthenticator.setAssignedEntity(createAssignedEntity(new POCDMT000040AssignedEntity()));
		return legalAuthenticator;
	}

	public AtcdabbrOtherAuthorBodyEImpfpass getAtcdabbrOtherAuthorBodyEImpfpass(ZonedDateTime timeAuthor) {
		AtcdabbrOtherAuthorBodyEImpfpass author = new AtcdabbrOtherAuthorBodyEImpfpass();

		TS time = new TS();
		if (timeAuthor != null) {
			time.setValue(DateTimes.toDatetimeTs(timeAuthor).getValue());
		} else {
			time.nullFlavor = new ArrayList<>();
			time.getNullFlavor().add(NullFlavor.UNKNOWN_L1_CODE);
		}
		author.setTime(time);

		author.setAssignedAuthor(getHl7CdaR2Pocdmt000040AssignedAuthor(author.getAssignedAuthor()));
		return author;
	}

	public AtcdabbrHeaderDataEnterer getHeaderDataEnterer(ZonedDateTime timeDataEnterer) {
		AtcdabbrHeaderDataEnterer dataEnterer = new AtcdabbrHeaderDataEnterer();
		dataEnterer.setTime(DateTimes.toDatetimeTs(timeDataEnterer));
		POCDMT000040AssignedEntity assignedEntity = new POCDMT000040AssignedEntity();

		if (getIdentifier() != null && !getIdentifier().isEmpty()) {
			assignedEntity.getId().addAll(getIis());
		}

		if (this.getAddresses() != null && !this.getAddresses().isEmpty()) {
			assignedEntity.getAddr().addAll(getAds());
		}

		assignedEntity.setAssignedPerson(getHl7CdaR2Pocdmt000040Person(assignedEntity.getAssignedPerson()));

		if (getTelecom() != null && !getTelecom().isEmpty()) {
			assignedEntity.getTelecom().addAll(getTels());
		}

		if (getOrganization() != null) {
			assignedEntity.setRepresentedOrganization(getOrganization().getHl7CdaR2Pocdmt000040Organization());
		}

		dataEnterer.setAssignedEntity(assignedEntity);

		return dataEnterer;
	}

	public AuthorBodyPs getAuthorBodyPs(ZonedDateTime authTime) {
		AuthorBodyPs author = new AuthorBodyPs();
		author.setTime(DateTimes.toDatetimeTs(authTime));
		author.setAssignedAuthor(getHl7CdaR2Pocdmt000040AssignedAuthor(author.getAssignedAuthor()));
		return author;
	}

}
