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
package org.projecthusky.fhir.emed.ch.epr.resource;

import org.hl7.fhir.instance.model.api.IBaseResource;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;

import java.time.Instant;
import java.util.UUID;

/**
 * An interface for entries of CH-EMED-EPR documents.
 *
 * @author Quentin Ligier
 **/
public interface ChEmedEprEntry extends IBaseResource {

    UUID resolveIdentifier();

    EmedEntryType getEmedType();

    /**
     *
     * @return The medical author as an Author, including the timestamp of the authorship.
     */
    @ExpectsValidResource
    Author resolveMedicalAuthor();

    /**
     *
     * @return The time of medical authorship as an Instant.
     */
    @ExpectsValidResource
    Instant resolveMedicalAuthorshipTimestamp();
}
