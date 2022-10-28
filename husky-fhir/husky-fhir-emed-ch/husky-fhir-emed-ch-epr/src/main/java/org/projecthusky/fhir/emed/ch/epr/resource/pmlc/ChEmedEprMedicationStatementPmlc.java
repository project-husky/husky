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
package org.projecthusky.fhir.emed.ch.epr.resource.pmlc;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationStatement;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement (PMLC).
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprMedicationStatementPmlc extends ChEmedEprMedicationStatement {

    // TODO: add support for extensions treatmentPlan

    // TODO CH EMED Extension MTP ?
  /*  @Child(name = "treatmentPlan")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentplan", definedLocally = false)
    protected ? treatmentPlan;*/

    /**
     * "Last" author of the original document if different from the author of the medical decision
     * (MedicationStatement.informationSource)
     */
    @Child(name = "auhtorDocument")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author")
    protected Reference authorDocument;

    /**
     * Constructor
     *
     * @param entryUuid the uuid of the medication statement.
     */
    public ChEmedEprMedicationStatementPmlc(final UUID entryUuid) {
        super(entryUuid);
    }

    /**
     * Gets the treatment plan element in the medication statement.
     *
     * @return the treatment plan element.
     * @throws InvalidEmedContentException if the reference to the MTP that introduced this medication in the treatment plan is missing.
     */
/*    @ExpectsValidResource
    public ? getTreatmentPlanElement() throws InvalidEmedContentException {
        if (this.treatmentPlan != null) {
            return treatmentPlan;
        }
        throw new InvalidEmedContentException("The reference to the MTP that introduced this medication in the treatment plan is missing.");
    }*/

    /**
     * Gets the author document element in the medication statement.
     *
     * @return the author document element.
     */
    public Reference getAuthorDocumentElement() {
        if (this.authorDocument == null) {
            this.authorDocument = new Reference();
        }
        return this.authorDocument;
    }

    /**
     * Gets the last author document resource in the medication statement if available.
     *
     * @return the author document resource or {@code null}.
     * @throws InvalidEmedContentException if the author document resource is invalid.
     */
    @Nullable
    @ExpectsValidResource
    public DomainResource getAuthorDocument() throws InvalidEmedContentException {
        final var resource = getAuthorDocumentElement().getResource();
        if (resource == null) return null;

        if (resource instanceof ChCorePatientEpr || resource instanceof ChEmedEprPractitionerRole) {
            return (DomainResource) resource;
        }
        throw new InvalidEmedContentException("The last author of the original document is invalid");
    }

    /**
     * Sets the last author document of the medication statement.
     *
     * @param authorDocument the patient.
     * @return this.
     */
    public ChEmedEprMedicationStatementPmlc setAuthorDocument(ChCorePatientEpr authorDocument) {
        this.getAuthorDocumentElement().setResource(authorDocument);
        return this;
    }

    /**
     * Sets the last author document of the medication statement.
     *
     * @param authorDocument the practitioner role.
     * @return this.
     */
    public ChEmedEprMedicationStatementPmlc setAuthorDocument(ChEmedEprPractitionerRole authorDocument) {
        this.getAuthorDocumentElement().setResource(authorDocument);
        return this;
    }

    /**
     * Returns whether author document exists.
     *
     * @return {@code true} if the author document exists, {@code false} otherwise.
     */
    public boolean hasAuthorDocument() {
        return this.authorDocument != null && this.authorDocument.getResource() != null;
    }
}
