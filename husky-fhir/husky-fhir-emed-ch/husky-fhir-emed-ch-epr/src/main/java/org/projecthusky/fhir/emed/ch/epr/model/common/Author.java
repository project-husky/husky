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
package org.projecthusky.fhir.emed.ch.epr.model.common;

import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.DateTimeType;
import org.projecthusky.fhir.emed.ch.epr.resource.*;

import java.time.Instant;
import java.util.Objects;

/**
 * An author in the CH-EMED-EPR IG. It can be made up of a single (e.g. patient) or multiple resources (e.g.
 * practitionerRole, practitioner and organization).
 *
 * @author Quentin Ligier
 **/
@Data
public class Author {

    @Nullable
    private ChEmedEprPractitioner practitioner;

    @Nullable
    private ChEmedEprPractitionerRole practitionerRole;

    @Nullable
    private ChEmedEprDevice device;

    @Nullable
    private ChEmedEprRelatedPerson relatedPerson;

    @Nullable
    private ChEmedEprPatient patient;

    @Nullable
    private ChEmedEprOrganization organization;

    /**
     * The time of authorship, if specified.
     */
    @Nullable
    private Instant time;

    public Author(final IBaseResource resource) {
        super();
        Objects.requireNonNull(resource);
        if (resource instanceof final ChEmedEprDevice device) {
            this.setDevice(device);
        } else if (resource instanceof final ChEmedEprOrganization organization) {
            this.setOrganization(organization);
        } else if (resource instanceof final ChEmedEprPatient patient) {
            this.setPatient(patient);
        } else if (resource instanceof final ChEmedEprPractitioner practitioner) {
            this.setPractitioner(practitioner);
        } else if (resource instanceof final ChEmedEprPractitionerRole practitionerRole) {
            this.setPractitionerRole(practitionerRole);
        } else if (resource instanceof final ChEmedEprRelatedPerson relatedPerson) {
            this.setRelatedPerson(relatedPerson);
        } else {
            throw new IllegalArgumentException("Passed resource is not a supported author: " + resource.getClass().getName());
        }
    }

    public Author(final IBaseResource resource, @Nullable DateTimeType time) {
        this(resource);
        this.time = (time == null)? null : time.getValueAsCalendar().toInstant();
    }

    public Author(final IBaseResource resource, @Nullable Instant time) {
        this(resource);
        this.time = time;
    }

    /**
     * Returns the first non-null resource or {@code null}.
     */
    @Nullable
    public IBaseResource getFirstNonNull() {
        if (this.device != null) {
            return this.device;
        } else if (this.organization != null) {
            return this.organization;
        } else if (this.patient != null) {
            return this.patient;
        } else if (this.practitioner != null) {
            return this.practitioner;
        } else if (this.practitionerRole != null) {
            return this.practitionerRole;
        } else if (this.relatedPerson != null) {
            return this.relatedPerson;
        }
        return null;
    }
}
