package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.enums.EmedPadvEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtDispense;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPrescription;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprMedicationStatementMtp;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR Observation.
 *
 * @author Ronaldo Loureiro
 **/
public abstract class ChEmedEprObservation extends Observation implements ChEmedEprEntry {

    /**
     * Reference to the medication treatment plan
     */
    @Nullable
    @Child(name = "treatmentPlan")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentplan", definedLocally = false)
    protected ChEmedExtTreatmentPlan treatmentPlan;

    /**
     * Reference to the medication prescription
     */
    @Nullable
    @Child(name = "prescription")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-prescription", definedLocally = false)
    protected ChEmedExtPrescription prescription;

    /**
     * Reference to the medication dispense
     */
    @Nullable
    @Child(name = "dispense")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-dispense", definedLocally = false)
    protected ChEmedExtDispense dispense;

    /**
     * Reference to the changed medication statement
     */
    @Nullable
    @Child(name = "medicationStatementChanged")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-medicationstatement-changed", definedLocally = false)
    protected Reference medicationStatementChanged;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprObservation() {
        super();
    }

    // TODO issued, note

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication statement id.
     * @param padvType  The pharmaceutical advice type.
     */
    public ChEmedEprObservation(final UUID entryUuid,
                                final EmedPadvEntryType padvType) {
        super();
        this.setStatus(ObservationStatus.FINAL);
        this.addIdentifier().setValue(Uuids.URN_PREFIX + entryUuid).setSystem(FhirSystem.URI);
        this.setCode(padvType.getCodeableConcept());
    }

    @Override
    public EmedEntryType getEmedType() {
        return EmedEntryType.PADV;
    }

    /**
     * Resolves the observation UUID or throws.
     *
     * @return the observation UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing.");
        return Uuids.parseUrnEncoded(this.getIdentifierFirstRep().getValue());
    }

    /**
     * Resolves the changed medication statement.
     *
     * @return the changed medication statement or {@code null}.
     * @throws InvalidEmedContentException if the changed medication statement isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedEprMedicationStatementMtp resolveMedicationStatementChanged() throws InvalidEmedContentException {
        if (this.medicationStatementChanged == null) return null;

        final var resource = this.medicationStatementChanged.getResource();
        if (resource instanceof ChEmedEprMedicationStatementMtp chEmedEprMedicationStatementMtp) {
            return chEmedEprMedicationStatementMtp;
        }
        throw new InvalidEmedContentException("The medication statement resource isn't of the right type.");
    }

    /**
     * Resolves the padv entry type.
     *
     * @return the padv entry type.
     * @throws InvalidEmedContentException if the padv entry type is missing or invalid.
     */
    @ExpectsValidResource
    public EmedPadvEntryType resolvePadvEntryType() throws InvalidEmedContentException {
        if (!this.hasCode()) throw new InvalidEmedContentException("The padv entry type is missing.");
        final var emedPadvEntryType = EmedPadvEntryType.getEnum(this.getCode().getCodingFirstRep());
        if (emedPadvEntryType != null) {
            return emedPadvEntryType;
        }
        throw new InvalidEmedContentException("The padv entry type is invalid.");
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
     * Gets the prescription element. If it doesn't exist, it's created.
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
     * Gets the medication dispense element. If it doesn't exist, it's created.
     *
     * @return the medication dispense element.
     */
    public ChEmedExtDispense getDispenseElement() {
        if (this.dispense == null) {
            this.dispense = new ChEmedExtDispense();
        }
        return this.dispense;
    }

    /**
     * Sets the treatment plan reference.
     *
     * @param treatmentPlan the treatment plan reference.
     * @return this.
     */
    public ChEmedEprObservation setTreatmentPlanElement(final ChEmedExtTreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
        return this;
    }

    /**
     * Sets the prescription reference.
     *
     * @param prescription the prescription reference.
     * @return this.
     */
    public ChEmedEprObservation setPrescriptionElement(final ChEmedExtPrescription prescription) {
        this.prescription = prescription;
        return this;
    }

    /**
     * Sets the medication dispense reference.
     *
     * @param dispense the medication dispense reference.
     * @return this.
     */
    public ChEmedEprObservation setDispenseElement(final ChEmedExtDispense dispense) {
        this.dispense = dispense;
        return this;
    }

    /**
     * Sets the changed medication statement.
     *
     * @param medicationStatement the changed medication statement.
     * @return this.
     */
    public ChEmedEprObservation setMedicationStatementChanged(final ChEmedEprMedicationStatementMtp medicationStatement) {
        this.medicationStatementChanged = References.createReference(medicationStatement);
        return this;
    }

    /**
     * Sets the padv entry type.
     *
     * @param padvEntryType the padv entry type.
     * @return this.
     */
    public ChEmedEprObservation setPadvEntryType(final EmedPadvEntryType padvEntryType) {
        this.setCode(padvEntryType.getCodeableConcept());
        return this;
    }

    /**
     * Returns whether the treatment plan reference.
     *
     * @return {@code true} if the treatment plan reference exists, {@code false} otherwise.
     */
    public boolean hasTreatmentPlan() {
        return this.treatmentPlan != null;
    }

    /**
     * Returns whether the prescription reference.
     *
     * @return {@code true} if the prescription reference exists, {@code false} otherwise.
     */
    public boolean hasPrescription() {
        return this.prescription != null;
    }

    /**
     * Returns whether the medication dispense reference.
     *
     * @return {@code true} if the medication dispense reference exists, {@code false} otherwise.
     */
    public boolean hasDispense() {
        return this.dispense != null;
    }

    /**
     * Returns whether the changed medication statement reference.
     *
     * @return {@code true} if the changed medication statement reference exists, {@code false} otherwise.
     */
    public boolean hasMedicationStatementChanged() {
        return this.medicationStatementChanged != null && !this.medicationStatementChanged.isEmpty();
    }

    /**
     * Returns whether the padv entry type.
     *
     * @return {@code true} if the padv entry type exists, {@code false} otherwise.
     */
    public boolean hasPadvEntryType() {
        return this.hasCode();
    }
}
