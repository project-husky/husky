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
import org.projecthusky.fhir.emed.ch.epr.model.common.EmedReference;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtDispense;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPrescription;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprMedicationStatementMtp;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

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
     * Resolves the date/time this version was made available.
     *
     * @return the date/time this version was made available.
     * @throws InvalidEmedContentException if the date/time this version was made available is missing.
     */
    @ExpectsValidResource
    public Instant resolveIssued() throws InvalidEmedContentException {
        if (!this.hasIssued())
            throw new InvalidEmedContentException("The date/time this version was made available is missing.");
        return this.getIssued().toInstant();
    }

    /**
     * Resolves the note.
     *
     * @return the note.
     * @throws InvalidEmedContentException if the note is missing.
     */
    @ExpectsValidResource
    public String resolveNote() throws InvalidEmedContentException {
        if (!this.hasNote()) throw new InvalidEmedContentException("The note is missing.");
        return this.getNoteFirstRep().getText();
    }

    /**
     * Resolves the reference to the treatment plan entry (if any).
     *
     * @return the reference to the treatment plan entry or {@code null}.
     * @throws InvalidEmedContentException if one of the IDs is missing.
     */
    @ExpectsValidResource
    @Nullable
    public EmedReference resolveMtpReference() throws InvalidEmedContentException {
        if (!this.hasTreatmentPlan()) {
            return null;
        }
        return this.getTreatmentPlanElement().resolveReference();
    }

    /**
     * Resolves the reference to the prescription entry (if any).
     *
     * @return the reference to the prescription entry or {@code null}.
     * @throws InvalidEmedContentException if one of the IDs is missing.
     */
    @ExpectsValidResource
    @Nullable
    public EmedReference resolvePreReference() throws InvalidEmedContentException {
        if (!this.hasPrescription()) {
            return null;
        }
        return this.getPrescriptionElement().resolveReference();
    }

    /**
     * Resolves the reference to the dispense entry (if any).
     *
     * @return the reference to the dispense entry or {@code null}.
     * @throws InvalidEmedContentException if one of the IDs is missing.
     */
    @ExpectsValidResource
    @Nullable
    public EmedReference resolveDisReference() throws InvalidEmedContentException {
        if (!this.hasDispense()) {
            return null;
        }
        return this.getDispenseElement().resolveReference();
    }

    /**
     * Resolves the reference to the entry.
     *
     * @return the reference to the entry.
     * @throws InvalidEmedContentException if there's not a single reference.
     */
    @ExpectsValidResource
    public EmedReference resolveReference() throws InvalidEmedContentException {
        final var mtpReference = this.resolveMtpReference();
        final var preReference = this.resolvePreReference();
        final var disReference = this.resolveDisReference();
        final var nonnullReferences = Stream.of(mtpReference, preReference, disReference)
                .filter(Objects::nonNull)
                .toList();
        if (nonnullReferences.size() != 1) {
            throw new InvalidEmedContentException("A PADV Observation must have a single entry reference");
        }
        return nonnullReferences.get(0);
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
     * Gets the reference to the changed medication statement. If it doesn't exist, it's created.
     *
     * @return the reference to the changed medication statement.
     */
    public Reference getMedicationStatementChangedReference() {
        if (this.medicationStatementChanged == null) {
            this.medicationStatementChanged = new Reference();
        }
        return this.medicationStatementChanged;
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
     * Sets the date/time this version was made available.
     *
     * @param issued the date/time this version was made available.
     * @return this.
     */
    public ChEmedEprObservation setIssued(final Instant issued) {
        this.setIssued(Date.from(issued));
        return this;
    }

    /**
     * Sets the note. If it already exists, it's replaced.
     *
     * @param note the note.
     * @return this.
     */
    public ChEmedEprObservation setNote(final String note) {
        this.getNoteFirstRep().setText(note);
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

    /**
     * Returns whether the medication dispense reference.
     *
     * @return {@code true} if the medication dispense reference exists, {@code false} otherwise.
     */
    public boolean hasDispense() {
        return this.dispense != null && !this.dispense.isEmpty();
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
