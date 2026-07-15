/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.resource.r4.AbstractDocument;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatient;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;

/**
 * 
 */
public abstract class ChVacdAbstractMessage extends AbstractDocument {

	private static final long serialVersionUID = 4857272558697951577L;

	protected ChVacdAbstractMessage() {
		this.setLanguage("en-US");

		this.getEntry().clear();
		this.setId(UUID.randomUUID().toString());
		this.setIdentifier(new Identifier().setSystem("urn:ietf:rfc:3986")
				.setValue("urn:uuid:" + this.getId()));
		this.setTimestamp(new Date());
		this.setType(BundleType.MESSAGE);
	}

	@ExpectsValidResource
	public abstract ChVacdAbstractMessageHeader resolveMessageHeader();

	public boolean hasPatient() {
		return this.getEntryByResourceType(ChCorePatient.class) != null;
	}

	public ChCorePatient resolvePatient() {
		final var entry = this.getEntryByResourceType(ChCorePatient.class);
		return entry;
	}

	public void setPatient(ChCorePatient patient) {
		ChVacdAbstractMessageHeader header = this.resolveMessageHeader();
		this.getEntry().add(new BundleEntryComponent().setResource(patient)
				.setFullUrl("urn:uuid:" + patient.getId()));

		header.addFocus(new Reference(patient));
		patient.setIdElement(null);

	}

}
