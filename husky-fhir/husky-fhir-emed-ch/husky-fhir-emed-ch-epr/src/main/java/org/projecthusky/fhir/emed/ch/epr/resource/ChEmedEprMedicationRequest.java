package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

import org.projecthusky.fhir.core.ch.util.FhirSystem;

import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.PrescriptionStatus;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.common.EffectiveDosageInstructions;
import org.projecthusky.fhir.emed.ch.epr.model.common.EmedReference;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationRequest.
 *
 * @author Ronaldo Loureiro
 **/
public abstract class ChEmedEprMedicationRequest extends MedicationRequest implements ChEmedEprEntry {

    @Nullable
    @Child(name = "treatmentplan", min = 1)
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentplan", definedLocally = false)
    protected ChEmedExtTreatmentPlan treatmentPlan;

    /**
     * Empty constructor for the parser
     */
    public ChEmedEprMedicationRequest() {
        super();
        this.setIntent(MedicationRequestIntent.ORDER);
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the medication request id.
     */
    public ChEmedEprMedicationRequest(final UUID entryUuid) {
        super();
        this.setIntent(MedicationRequestIntent.ORDER);
        this.addIdentifier().setValue(Uuids.URN_PREFIX + entryUuid).setSystem(FhirSystem.URI);
    }

    @Override
    public EmedEntryType getEmedType() {
        return EmedEntryType.PRE;
    }

    /**
     * Resolves the medication request UUID or throws.
     *
     * @return the medication request UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing");
        return Uuids.parseUrnEncoded(this.getIdentifierFirstRep().getValue());
    }

    /**
     * Resolves the medication or throws.
     *
     * @return the medication.
     * @throws InvalidEmedContentException if the medication is missing or if it isn't of the right type.
     */
    @ExpectsValidResource
    public ChEmedEprMedication resolveMedication() throws InvalidEmedContentException {
        if (!this.hasMedicationReference())
            throw new InvalidEmedContentException("The medication reference is missing");
        final var resource = this.getMedicationReference().getResource();
        if (resource instanceof ChEmedEprMedication chMedication) {
            return chMedication;
        }
        throw new InvalidEmedContentException("The medication resource isn't of the right type");
    }

    /**
     * Resolves the targeted patient.
     *
     * @return the patient.
     * @throws InvalidEmedContentException if the patient is missing or isn't of the right type.
     */
    @ExpectsValidResource
    public ChCorePatientEpr resolvePatient() throws InvalidEmedContentException {
        if (!this.hasSubject()) throw new InvalidEmedContentException("The patient is missing");
        final var resource = this.getSubject().getResource();
        if (resource instanceof ChCorePatientEpr chPatient) {
            return chPatient;
        }
        throw new InvalidEmedContentException("The patient resource isn't of the right type");
    }

    /**
     * Resolves the base entry of the dosage instruction.
     *
     * @return the base entry of the dosage instruction
     * @throws InvalidEmedContentException if the base entry of the dosage instruction is missing.
     */
    @ExpectsValidResource
    public ChEmedEprDosage resolveBaseDosage() throws InvalidEmedContentException {
        if (!this.getDosageInstruction().isEmpty() && this.getDosageInstruction().getFirst() instanceof final ChEmedEprDosage dosage) {
            return dosage;
        }
        throw new InvalidEmedContentException("Base entry of the dosage instruction is missing");
    }

    /**
     * Resolves the reference to the treatment plan entry.
     *
     * @return the reference to the treatment plan entry.
     * @throws InvalidEmedContentException if the reference is missing.
     */
    @ExpectsValidResource
    public EmedReference resolveMtpReference() throws InvalidEmedContentException {
        if (!this.hasTreatmentPlan()) {
            throw new InvalidEmedContentException("The treatment plan reference is missing");
        }
        return this.getTreatmentPlanElement().resolveReference();
    }

    /**
     * Resolves additional entries of the dosage instruction. The list may be empty.
     *
     * @return additional entries of the dosage instruction.
     */
    public List<ChEmedEprDosage> resolveAdditionalDosage() {
        return this.getDosageInstruction().stream()
                .filter(ChEmedEprDosage.class::isInstance)
                .map(ChEmedEprDosage.class::cast)
                .skip(1)
                .toList();
    }

    /**
     * Resolves the medication request status or throws.
     *
     * @return the medication request status {@link PrescriptionStatus}.
     * @throws InvalidEmedContentException if the status is missing or not supported.
     */
    @ExpectsValidResource
    public PrescriptionStatus resolveStatus() throws InvalidEmedContentException {
        if (!this.hasStatus()) throw new InvalidEmedContentException("The status is missing.");
        return switch (this.getStatus()) { // TODO check the matching between MedicationRequestStatus and PrescriptionStatus
            case ACTIVE -> PrescriptionStatus.ACTIVE;
            case ONHOLD, DRAFT -> PrescriptionStatus.SUBMITTED;
            case CANCELLED, STOPPED -> PrescriptionStatus.CANCELED;
            case ENTEREDINERROR -> PrescriptionStatus.REFUSED;
            case COMPLETED, UNKNOWN, NULL -> throw new InvalidEmedContentException("The status is not supported");
        };
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
     * Sets the treatment plan reference.
     *
     * @param treatmentPlan the treatment plan reference.
     * @return this.
     */
    public ChEmedEprMedicationRequest setTreatmentPlanElement(final ChEmedExtTreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
        return this;
    }

    /**
     * Sets the medication request UUID.
     *
     * @param documentUUID The medication request UUID.
     * @return this.
     */
    public ChEmedEprMedicationRequest setIdentifier(final UUID documentUUID) {
        var identifier = this.getIdentifierFirstRep();
        if (identifier == null) {
            identifier = new Identifier();
            identifier.setSystem(FhirSystem.URI);
        }
        identifier.setValue(Uuids.URN_PREFIX + documentUUID);
        return this;
    }

    /**
     * Sets the medication reference.
     *
     * @param chEmedEprMedication the medication resource.
     * @return this.
     */
    public ChEmedEprMedicationRequest setMedicationReference(final ChEmedEprMedication chEmedEprMedication) {
        this.setMedication(new Reference(chEmedEprMedication));
        return this;
    }

    /**
     * Set the patient targeted.
     *
     * @param chCorePatientEpr the patient.
     * @return this.
     */
    public ChEmedEprMedicationRequest setPatient(final ChCorePatientEpr chCorePatientEpr) {
        this.setSubject(new Reference(chCorePatientEpr));
        return this;
    }

    /**
     * Sets the base entry of the dosage instruction. If it already exists, it will be replaced.
     *
     * @param dosageBaseEntry the base entry of the dosage instruction.
     * @return this.
     */
    public ChEmedEprMedicationRequest setDosageBaseEntry(final ChEmedEprDosage dosageBaseEntry) {
        if (this.hasDosageInstruction()) {
            this.getDosageInstruction().set(0, dosageBaseEntry);
        } else {
            this.getDosageInstruction().add(dosageBaseEntry);
        }
        return this;
    }

    /**
     * Adds additional entry of the dosage instruction.
     *
     * @param dosageAdditionalEntry additional entry of the dosage instruction.
     * @return this.
     */
    public ChEmedEprMedicationRequest addDosageAdditionalEntry(final ChEmedEprDosage dosageAdditionalEntry) {
        this.getDosageInstruction().add(dosageAdditionalEntry);
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
     * Returns whether the base entry of the dosage instruction.
     *
     * @return {@code true} if the base entry of the dosage instruction exists, {@code false} otherwise.
     */
    public boolean hasDosageBaseEntry() {
        return this.hasDosageInstruction();
    }

    /**
     * Returns whether additional entry of the dosage instruction.
     *
     * @return {@code true} if additional entry of the dosage instruction exists, {@code false} otherwise.
     */
    public boolean hasDosageAdditionalEntry() {
        return this.hasDosageInstruction() && this.getDosageInstruction().size() > 1;
    }

    /**
     * @return {@link #dosageInstruction} (Indicates how the medication is/was or should be taken by the patient.)
     */
    @Override
    public List<Dosage> getDosageInstruction() {
        if (this.dosageInstruction == null)
            this.dosageInstruction = new ArrayList<>();
        else {
            for (int i = 0; i < this.dosageInstruction.size(); ++i) {
                if (!(this.dosageInstruction.get(i) instanceof ChEmedEprDosage)) {
                    final var newDosage = new ChEmedEprDosage();
                    this.dosageInstruction.get(i).copyValues(newDosage);
                    this.dosageInstruction.set(i, newDosage);
                }
            }
        }
        return this.dosageInstruction;
    }

    @Override
    public ChEmedEprDosage addDosageInstruction() {
        final var dosage = new ChEmedEprDosage();
        this.addDosageInstruction(dosage);
        return dosage;
    }

    @Override
    public MedicationRequest addDosageInstruction(final Dosage t) {
        if (t instanceof final ChEmedEprDosage chEmedEprDosage) {
            this.dosageInstruction.add(chEmedEprDosage);
            return this;
        }
        final var newDosage = new ChEmedEprDosage();
        t.copyValues(newDosage);
        this.dosageInstruction.add(newDosage);
        return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dosageInstruction}, creating it if it does not already
     * exist
     */
    @Override
    public ChEmedEprDosage getDosageInstructionFirstRep() {
        if (getDosageInstruction().isEmpty()) {
            addDosageInstruction();
        }
        return (ChEmedEprDosage) getDosageInstruction().getFirst();
    }

    /**
     * Converts the main and additional dosages into a read-only model, containing the effective dosage instructions.
     */
    @ExpectsValidResource
    public EffectiveDosageInstructions resolveEffectiveDosageInstructions() {
        return EffectiveDosageInstructions.fromDosages(this.resolveBaseDosage(), this.resolveAdditionalDosage());
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

    /**
     * Gets the substitution code in the medication statement.
     *
     * @return the substitution code.
     * @throws InvalidEmedContentException if the substitution code is invalid.
     */
    @ExpectsValidResource
    public SubstanceAdministrationSubstitutionCode resolveSubstitution() throws InvalidEmedContentException {
        if (!this.hasSubstitution() || !this.getSubstitution().hasAllowedCodeableConcept()) {
            return SubstanceAdministrationSubstitutionCode.EQUIVALENT;
        }
        final var substitutionCode =
                SubstanceAdministrationSubstitutionCode.fromCoding(this.getSubstitution().getAllowedCodeableConcept().getCodingFirstRep());
        if (substitutionCode == null) {
            throw new InvalidEmedContentException("The substitution code is invalid");
        }
        return substitutionCode;
    }

    /**
     * Sets the requester of the medication request.
     * @param author The author to be set as requester.
     * @return this.
     */
    public ChEmedEprMedicationRequest setRequester(final ChEmedEprPractitionerRole author) {
        this.setRequester(new Reference(author));
        return this;
    }

    /**
     *
     * @return The requester as an Author, including the authoredOn date as timestamp.
     */
    @ExpectsValidResource
    public ChEmedEprPractitionerRole resolveRequester() {
        if (!this.hasRequester()) {
            throw new InvalidEmedContentException("Missing requester.");
        }
        if (this.getRequester().getResource() instanceof final ChEmedEprPractitionerRole requester) {
            return requester;
        }
        throw new InvalidEmedContentException("The requester resource isn't of the right type.");
    }

    /**
     * @return Gets the authoredOn date as an Instant.
     */
    @ExpectsValidResource
    public Instant resolveAuthoredOn() {
        if (hasAuthoredOn()) return getAuthoredOnElement().getValueAsCalendar().toInstant();
        throw new InvalidEmedContentException("The authoredOn field is missing.");
    }

    @Override
    public void copyValues(final MedicationRequest dst) {
        super.copyValues(dst);
        if (dst instanceof final ChEmedEprMedicationRequest rst) {
            rst.treatmentPlan = treatmentPlan == null ? null : treatmentPlan.copy();
        }
    }

    /**
     *
     * @return The requester as medical Author, including authoredOn as its timestamp.
     */
    @Override
    @ExpectsValidResource
    public Author resolveMedicalAuthor() {
        return new Author(this.resolveRequester(), this.resolveAuthoredOn());
    }

    /**
     *
     * @return The authoredOn date as medical authorship timestamp.
     */
    @Override
    @ExpectsValidResource
    public Instant resolveMedicalAuthorshipTimestamp() {
        return resolveAuthoredOn();
    }

    public boolean hasTreatmentReason() {
        return this.hasReasonCode() && !this.getReasonCode().isEmpty() && this.getReasonCodeFirstRep().hasText();
    }

    /**
     * Gets the treatment reason if available.
     *
     * @return the treatment reason or {@code null}.
     */
    @Nullable
    public String getTreatmentReason() {
        if (!this.hasTreatmentReason()) {
            return null;
        }
        return this.getReasonCodeFirstRep().getText();
    }
}
