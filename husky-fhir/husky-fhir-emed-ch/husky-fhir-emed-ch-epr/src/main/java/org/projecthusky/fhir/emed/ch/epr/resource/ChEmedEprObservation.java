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
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.common.EmedReference;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtDispense;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPrescription;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprMedicationStatementMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprMedicationStatementChanged;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprMedicationRequestPre;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * The HAPI custom structure for CH-EMED-EPR Observation.
 *
 * @param <T> The type of {@link ChEmedEprMedicationStatement} to be returned by resolveMedicationStatementChanged().
 *            This is needed for documents that might contain several subtypes of MedicationStatement, e.g. a PML doc.
 *            since the parser cannot discriminate between them and hence these resources might be parsed as a different
 *            ChEmedEprMedicationStatement than the PADV attached {@link ChEmedEprMedicationStatementChanged}.
 *
 * @author Ronaldo Loureiro
 **/
public abstract class ChEmedEprObservation<T extends ChEmedEprMedicationStatement> extends Observation implements ChEmedEprEntry {

    /**
     * Reference to the medication treatment plan.
     */
    @Nullable
    @Child(name = "treatmentPlan")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentplan", definedLocally = false)
    protected ChEmedExtTreatmentPlan treatmentPlan;

    /**
     * Reference to the medication prescription.
     */
    @Nullable
    @Child(name = "prescription")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-prescription", definedLocally = false)
    protected ChEmedExtPrescription prescription;

    /**
     * Reference to the medication dispense.
     */
    @Nullable
    @Child(name = "dispense")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-dispense", definedLocally = false)
    protected ChEmedExtDispense dispense;

    /**
     * Reference to the changed medication statement.
     */
    @Nullable
    @Child(name = "medicationStatementChanged")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-medicationstatement-changed", definedLocally = false)
    protected Reference medicationStatementChanged;

    /**
     * Reference to the changed medication request.
     */
    @Nullable
    @Child(name = "medicationRequestChanged")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-medicationrequest-changed", definedLocally = false)
    protected Reference medicationRequestChanged;

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
    public T resolveMedicationStatementChanged() throws InvalidEmedContentException {
        if (!this.hasMedicationStatementChanged()) {
            return null;
        }
        final var resource = this.getMedicationStatementChangedReference().getResource();
        if (getMedicationStatementChangedType().isInstance(resource))
            return getMedicationStatementChangedType().cast(resource);
        throw new InvalidEmedContentException("The medication statement resource isn't of the right type.");
    }

    /**
     *
     * @return The class (type) of medication statement resource that is to be returned by
     *          resolveMedicationStatementChanged().
     */
    protected abstract Class<T> getMedicationStatementChangedType();

    /**
     * Resolves the changed medication request.
     *
     * @return the changed medication request or {@code null}.
     * @throws InvalidEmedContentException if the changed medication request isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedEprMedicationRequestPre resolveMedicationRequestChanged() throws InvalidEmedContentException {
        if (!this.hasMedicationRequestChanged()) {
            return null;
        }
        final var resource = this.getMedicationRequestChangedReference().getResource();
        if (resource instanceof ChEmedEprMedicationRequestPre chEmedEprMedicationRequestPre) {
            return chEmedEprMedicationRequestPre;
        }
        throw new InvalidEmedContentException("The medication request resource isn't of the right type.");
    }

    /**
     * Resolves the PADV entry type.
     *
     * @return the PADV entry type.
     * @throws InvalidEmedContentException if the PADV entry type is missing or invalid.
     */
    @ExpectsValidResource
    public EmedPadvEntryType resolvePadvEntryType() throws InvalidEmedContentException {
        if (!this.hasCode()) {
            throw new InvalidEmedContentException("The PADV entry type is missing.");
        }
        final var emedPadvEntryType = EmedPadvEntryType.getEnum(this.getCode().getCodingFirstRep());
        if (emedPadvEntryType != null) {
            return emedPadvEntryType;
        }
        throw new InvalidEmedContentException("The PADV entry type is invalid.");
    }

    /**
     * Resolves the date/time this version was made available.
     *
     * @return the date/time this version was made available.
     * @throws InvalidEmedContentException if the date/time this version was made available is missing.
     */
    @ExpectsValidResource
    public Instant resolveIssued() throws InvalidEmedContentException {
        if (!this.hasIssued()) {
            throw new InvalidEmedContentException("The date/time this version was made available is missing.");
        }
        return this.getIssuedElement().getValueAsCalendar().toInstant();
    }

    /**
     * Resolves the note.
     *
     * @return the note.
     * @throws InvalidEmedContentException if the note is missing.
     */
    @ExpectsValidResource
    public String resolveNote() throws InvalidEmedContentException {
        if (!this.hasNote()) {
            throw new InvalidEmedContentException("The note is missing.");
        }
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
     * Gets the medication dispense element. If it doesn't exist, it is created.
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
     * Gets the reference to the changed medication statement. If it doesn't exist, it is created.
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
     * Gets the reference to the changed medication request. If it doesn't exist, it is created.
     *
     * @return the reference to the changed medication request.
     */
    public Reference getMedicationRequestChangedReference() {
        if (this.medicationRequestChanged == null) {
            this.medicationRequestChanged = new Reference();
        }
        return this.medicationRequestChanged;
    }

    /**
     * Sets the treatment plan reference.
     *
     * @param treatmentPlan the treatment plan reference.
     * @return this.
     */
    public ChEmedEprObservation<T> setTreatmentPlanElement(final ChEmedExtTreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
        return this;
    }

    /**
     * Sets the prescription reference.
     *
     * @param prescription the prescription reference.
     * @return this.
     */
    public ChEmedEprObservation<T> setPrescriptionElement(final ChEmedExtPrescription prescription) {
        this.prescription = prescription;
        return this;
    }

    /**
     * Sets the medication dispense reference.
     *
     * @param dispense the medication dispense reference.
     * @return this.
     */
    public ChEmedEprObservation<T> setDispenseElement(final ChEmedExtDispense dispense) {
        this.dispense = dispense;
        return this;
    }

    /**
     * Sets the changed medication statement.
     *
     * @param medicationStatement the changed medication statement.
     * @return this.
     */
    public ChEmedEprObservation<T> setMedicationStatementChanged(final ChEmedEprMedicationStatementMtp medicationStatement) {
        this.medicationStatementChanged = References.createReference(medicationStatement);
        return this;
    }

    /**
     * Sets the changed medication request.
     *
     * @param medicationRequest the changed medication request.
     * @return this.
     */
    public ChEmedEprObservation<T> setMedicationRequestChanged(final ChEmedEprMedicationRequestPre medicationRequest) {
        this.medicationRequestChanged = References.createReference(medicationRequest);
        return this;
    }

    /**
     * Sets the PADV entry type.
     *
     * @param padvEntryType the PADV entry type.
     * @return this.
     */
    public ChEmedEprObservation<T> setPadvEntryType(final EmedPadvEntryType padvEntryType) {
        this.setCode(padvEntryType.getCodeableConcept());
        return this;
    }

    /**
     * Sets the date/time this version was made available.
     *
     * @param issued the date/time this version was made available.
     * @return this.
     */
    public ChEmedEprObservation<T> setIssued(final Instant issued) {
        this.setIssued(Date.from(issued));
        return this;
    }

    /**
     * Sets the note. If it already exists, it is replaced.
     *
     * @param note the note.
     * @return this.
     */
    public ChEmedEprObservation<T> setNote(final String note) {
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
     * Returns whether the changed medication request reference.
     *
     * @return {@code true} if the changed medication request reference exists, {@code false} otherwise.
     */
    public boolean hasMedicationRequestChanged() {
        return this.medicationRequestChanged != null && !this.medicationRequestChanged.isEmpty();
    }

    /**
     * Returns whether the padv entry type.
     *
     * @return {@code true} if the padv entry type exists, {@code false} otherwise.
     */
    public boolean hasPadvEntryType() {
        return this.hasCode();
    }

    /**
     * Resolves the subject as a {@link ChCorePatientEpr}.
     *
     * @return the subject.
     */
    @ExpectsValidResource
    public ChCorePatientEpr resolveSubject() {
        if (this.hasSubject() && this.getSubject().getResource() instanceof final ChCorePatientEpr patient) {
            return patient;
        }
        throw new InvalidEmedContentException("The subject (Patient) is missing");
    }

    @Override
    public void copyValues(final Observation dst) {
        super.copyValues(dst);
        if (dst instanceof ChEmedEprObservation<?> obs) {
            obs.treatmentPlan = treatmentPlan == null ? null : treatmentPlan.copy();
            obs.prescription = prescription == null ? null : prescription.copy();
            obs.dispense = dispense == null ? null : dispense.copy();
            obs.medicationStatementChanged = medicationStatementChanged == null ? null : medicationStatementChanged.copy();
            obs.medicationRequestChanged = medicationRequestChanged == null ? null : medicationRequestChanged.copy();
        }
    }

    /**
     *
     * @return The first performer of type ChEmedEprPractitionerRole, ChCorePatientEpr or ChEmedEprRelatedPerson as an
     *         Author with the time set to the medical authorship timestamp, i.e. when issued.
     */
    @Override
    @ExpectsValidResource
    public Author resolveMedicalAuthor() {
        if (hasPerformer()) {
            for (final var performer : getPerformer()) {
                final var performerResource = performer.getResource();
                if (performerResource instanceof ChEmedEprPractitionerRole ||
                    performerResource instanceof ChCorePatientEpr ||
                    performerResource instanceof ChEmedEprRelatedPerson)
                    return new Author(performerResource, resolveMedicalAuthorshipTimestamp());
            }
            throw new InvalidEmedContentException("No suitable performer for medical authorship.");
        }
        throw new InvalidEmedContentException("Performer is missing.");
    }

    /**
     *
     * @return The time of medical authorship, i.e. when issued.
     */
    @Override
    @ExpectsValidResource
    public Instant resolveMedicalAuthorshipTimestamp() {
        return resolveIssued();
    }
}
