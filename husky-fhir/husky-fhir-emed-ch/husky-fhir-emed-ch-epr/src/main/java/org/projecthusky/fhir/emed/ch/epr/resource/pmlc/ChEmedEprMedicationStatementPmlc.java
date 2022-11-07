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
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprObservation;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement (PMLC).
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprMedicationStatementPmlc extends ChEmedEprMedicationStatement {

    /**
     * Reference to the MTP that introduced this medication in the treatment plan
     */
    @Child(name = "treatmentPlan")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentplan", definedLocally = false)
    protected ChEmedExtTreatmentPlan treatmentPlan;

    /**
     * "Last" author of the original document if different from the author of the medical decision
     * (MedicationStatement.informationSource)
     */
    @Nullable
    @Child(name = "auhtorDocument")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author")
    protected Reference authorDocument;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationStatementPmlc() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the uuid of the medication statement.
     */
    public ChEmedEprMedicationStatementPmlc(final UUID entryUuid) {
        super(entryUuid);
    }

    /**
     * Gets the treatment plan element. If it doesn't exist, it's created.
     *
     * @return the treatment plan element.
     */
    public ChEmedExtTreatmentPlan getTreatmentPlanElement() {
        if (this.treatmentPlan == null) {
            this.treatmentPlan = new ChEmedExtTreatmentPlan();
        }
        return this.treatmentPlan;
    }

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
    public ChEmedEprMedicationStatementPmlc setAuthorDocument(final ChCorePatientEpr authorDocument) {
        this.authorDocument = References.createReference(authorDocument);
        return this;
    }

    /**
     * Sets the last author document of the medication statement.
     *
     * @param authorDocument the practitioner role.
     * @return this.
     */
    public ChEmedEprMedicationStatementPmlc setAuthorDocument(final ChEmedEprPractitionerRole authorDocument) {
        this.authorDocument = References.createReference(authorDocument);
        return this;
    }

    /**
     * Sets the treatment plan reference.
     *
     * @param treatmentPlan the treatment plan reference.
     * @return this.
     */
    public ChEmedEprMedicationStatementPmlc setTreatmentPlanElement(final ChEmedExtTreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
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

    /**
     * Returns whether the treatment plan reference.
     *
     * @return {@code true} if the treatment plan reference exists, {@code false} otherwise.
     */
    public boolean hasTreatmentPlan() {
        return this.treatmentPlan != null;
    }
}
