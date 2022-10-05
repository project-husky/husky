/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.ems;

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.PN;
import org.projecthusky.common.hl7cdar2.POCDMT000040InformationRecipient;
import org.projecthusky.common.hl7cdar2.POCDMT000040IntendedRecipient;
import org.projecthusky.common.hl7cdar2.POCDMT000040Person;
import org.projecthusky.common.hl7cdar2.XInformationRecipient;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Organization;

public class InformationRecipient {
	private String name;
	private Identificator id;
	private Organization receivedOrganization;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public Organization getReceivedOrganization() {
		return receivedOrganization;
	}

	public void setReceivedOrganization(Organization receivedOrganization) {
		this.receivedOrganization = receivedOrganization;
	}

	public POCDMT000040InformationRecipient getPOCDMT000040InformationRecipient() {
		ObjectFactory factory = new ObjectFactory();
		POCDMT000040InformationRecipient recipient = factory.createPOCDMT000040InformationRecipient();
		recipient.setTypeCode(XInformationRecipient.PRCP);
		POCDMT000040IntendedRecipient intendedRecipient = factory.createPOCDMT000040IntendedRecipient();
		intendedRecipient.getId().add(id.getHl7CdaR2Ii());

		POCDMT000040Person person = factory.createPOCDMT000040Person();
		PN namePn = factory.createPN();
		namePn.setXmlMixed(name);
		person.getName().add(namePn);

		intendedRecipient.setInformationRecipient(person);
		intendedRecipient.setReceivedOrganization(this.receivedOrganization.getHl7CdaR2Pocdmt000040Organization());
		recipient.setIntendedRecipient(intendedRecipient);
		return recipient;
	}

}
