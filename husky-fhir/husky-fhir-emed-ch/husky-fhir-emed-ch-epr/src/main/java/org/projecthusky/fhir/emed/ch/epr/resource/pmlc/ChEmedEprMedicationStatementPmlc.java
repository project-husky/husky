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
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationStatementPmlBase;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPrescription;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement (PMLC).
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medicationstatement-card")
public class ChEmedEprMedicationStatementPmlc extends ChEmedEprMedicationStatementPmlBase {
    /**
     * Reference to the MTP that introduced this medication in the treatment plan.
     */
    @Nullable
    @Child(name = "treatmentPlan", min = 1)
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentplan", definedLocally = false)
    protected ChEmedExtTreatmentPlan treatmentPlan;

    /**
     * Reference to the PRE that introduced this medication in the treatment plan.
     */
    @Nullable
    @Child(name = "prescription")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-prescription", definedLocally = false)
    protected ChEmedExtPrescription prescription;

    /**
     * The identifier of the last document to have <i>touched</i> the treatment instance.
     * <p>
     *     This extension conveys the identifier of the document that was last considered to consolidate this medication
     *     statement. For instance, in the case of a treatment instance for which the last document was a PADV that
     *     modified it, this extension will convey the identifier of said PADV document.
     * </p>
     * <p>
     *     Beside the direct use of being able to retrieve said last document using the identifier, this extension
     *     allows systems reading a PMLC document to easily detect whether a treatment instance has changed since the
     *     last read/sync with the eMedication service, by checking whether the identifier of the lastConsideredDocument
     *     has changed or not.
     * </p>
     */
    @Nullable
    @Child(name = "lastConsideredDocument", min = 1)
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-last-considered-document", definedLocally = false)
    protected Identifier lastConsideredDocument;

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
     * Gets the treatment plan element. If it doesn't exist, it is created.
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
     * Gets the prescription element. If it doesn't exist, it is created.
     *
     * @return the prescription element.
     */
    public ChEmedExtPrescription getPrescriptionElement() {
        if (this.prescription == null) {
            this.prescription = new ChEmedExtPrescription();
        }
        return this.prescription;
    }

    /**
     * Gets the lats considered document element. If it does not exist, it is created empty.
     *
     * @return The last considered document element.
     */
    public Identifier getLastConsideredDocumentElement() {
        if (this.lastConsideredDocument == null) {
            this.lastConsideredDocument = new Identifier();
        }
        return this.lastConsideredDocument;
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
     * Sets the prescription reference.
     *
     * @param prescription the prescription reference.
     * @return this.
     */
    public ChEmedEprMedicationStatementPmlc setTreatmentPlanElement(final ChEmedExtPrescription prescription) {
        this.prescription = prescription;
        return this;
    }

    /**
     * Sets the last considered document identifier.
     *
     * @param lastConsideredDocument the identifier of the last document on this treatment instance/line.
     * @return this.
     */
    public ChEmedEprMedicationStatementPmlc setLastConsideredDocumentElement(final Identifier lastConsideredDocument) {
        this.lastConsideredDocument = lastConsideredDocument;
        return this;
    }

    /**
     * Returns whether the treatment plan reference.
     *
     * @return {@code true} if the treatment plan reference exists, {@code false} otherwise.
     */
    public boolean hasTreatmentPlan() {
        return this.treatmentPlan != null && !this.treatmentPlan.isEmpty();
    }

    /**
     * Returns whether the prescription reference.
     *
     * @return {@code true} if the prescription reference exists, {@code false} otherwise.
     */
    public boolean hasPrescription() {
        return this.prescription != null && !this.prescription.isEmpty();
    }

    @Override
    public ChEmedEprMedicationStatementPmlc copy() {
        final var copy = new ChEmedEprMedicationStatementPmlc();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public void copyValues(final MedicationStatement dst) {
        super.copyValues(dst);
        if (dst instanceof final ChEmedEprMedicationStatementPmlc als) {
            als.treatmentPlan = treatmentPlan == null ? null : treatmentPlan.copy();
        }
    }


    /**
     * Checks whether a medication statement with the specified status and base dosage is to be included in a generated
     * medication card at the specified evaluation time or not. Relies on isPmlcStatementShownInMedicationCard().
     * @param evaluationTime Time of generation of the medication card.
     * @return               True if a medication statement with the specified status and base dosage is to be included
     *                       in a generated medication card at the specified time. False otherwise.
     */
    public boolean isShownInMedicationCard(final Instant evaluationTime) {
        return isPmlcStatementShownInMedicationCard(evaluationTime, this.getStatus(), this.resolveBaseDosage());
    }

    /**
     * Checks whether a medication statement with the specified status and base dosage is to be included in a generated
     * medication card at the specified evaluation time or not.
     *
     * @param evaluationTime Time of generation of the medication card.
     * @param status         The status of the medication statement.
     * @param baseDosage     The base dosage resource of the medication statement.
     * @return               True if a medication statement with the specified status and base dosage is to be included
     *                       in a generated medication card at the specified time. False otherwise.
     */
    public static boolean isPmlcStatementShownInMedicationCard(final Instant evaluationTime,
                                                               final MedicationStatementStatus status,
                                                               final ChEmedEprDosage baseDosage) {
        return status == MedicationStatementStatus.ACTIVE &&
                (!baseDosage.hasBoundsPeriod() ||
                 !baseDosage.getBoundsPeriod().hasEnd() ||
                 !evaluationTime.isAfter(Objects.requireNonNull(baseDosage.getInclusiveEndTime()))
                );
    }
}
