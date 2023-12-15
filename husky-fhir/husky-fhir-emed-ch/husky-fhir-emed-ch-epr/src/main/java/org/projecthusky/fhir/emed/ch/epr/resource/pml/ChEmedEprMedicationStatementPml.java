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
package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationStatementPmlBase;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement (PML).
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-medicationstatement-list")
public class ChEmedEprMedicationStatementPml extends ChEmedEprMedicationStatementPmlBase {
    /**
     * Reference to the original document.
     */
    @Nullable
    @Child(name = "parentDocument")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentplan")
    protected ChEmedExtTreatmentPlan parentDocument;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationStatementPml() {
        super();
    }

    /**
     * Constructor that pre-populates fields
     *
     * @param entryUuid The entry's UUID.
     */
    public ChEmedEprMedicationStatementPml(final UUID entryUuid) {
        super(entryUuid);
    }

    /**
     * Gets the parent document element. If it doesn't exist, it is created.
     *
     * @return the parent document element.
     */
    public ChEmedExtTreatmentPlan getParentDocumentElement() {
        if (this.parentDocument == null) {
            this.parentDocument = new ChEmedExtTreatmentPlan();
        }
        return this.parentDocument;
    }

    /**
     * Sets the parent document reference.
     *
     * @param parentDocument the parent document reference.
     * @return this.
     */
    public ChEmedEprMedicationStatementPml setParentDocumentElement(final ChEmedExtTreatmentPlan parentDocument) {
        this.parentDocument = parentDocument;
        return this;
    }

    /**
     * Returns whether the parent document reference exists.
     *
     * @return {@code true} if the parent document reference exists, {@code false} otherwise.
     */
    public boolean hasParentDocument() {
        return this.parentDocument != null && !this.parentDocument.isEmpty();
    }

    @Override
    public ChEmedEprMedicationStatementPml copy() {
        final var copy = new ChEmedEprMedicationStatementPml();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public void copyValues(final MedicationStatement dst) {
        super.copyValues(dst);
        if (dst instanceof final ChEmedEprMedicationStatementPml als) {
            als.parentDocument = parentDocument == null ? null : parentDocument.copy();
        }
    }
}
