package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.apache.commons.lang3.NotImplementedException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.enums.PrescriptionStatus;
import org.projecthusky.fhir.emed.ch.epr.model.common.EffectiveDosageInstructions;
import org.projecthusky.fhir.emed.ch.epr.model.common.EmedReference;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosage;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.util.References;

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
        this.setStatus(MedicationRequestStatus.COMPLETED);
        this.setIntent(MedicationRequestIntent.ORDER);
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the medication request id.
     */
    public ChEmedEprMedicationRequest(final UUID entryUuid) {
        super();
        this.setStatus(MedicationRequestStatus.COMPLETED);
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
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing.");
        return Uuids.parseUrnEncoded(this.getIdentifierFirstRep().getValue());
    }

    /**
     * Resolves the medication reference.
     *
     * @return the medication reference.
     * @throws InvalidEmedContentException if the medication reference is missing or if it isn't the right type.
     */
    @ExpectsValidResource
    public ChEmedEprMedication resolveMedicationReference() throws InvalidEmedContentException {
        if (!this.hasMedicationReference())
            throw new InvalidEmedContentException("The medication reference is missing.");
        final var resource = this.getMedicationReference().getResource();
        if (resource instanceof ChEmedEprMedication chMedication) {
            return chMedication;
        }
        throw new InvalidEmedContentException("The medication resource isn't the right type.");
    }

    /**
     * Resolves the targeted patient.
     *
     * @return the patient.
     * @throws InvalidEmedContentException if the patient is missing or isn't of the right type.
     */
    @ExpectsValidResource
    public ChCorePatientEpr resolvePatient() throws InvalidEmedContentException {
        if (!this.hasSubject()) throw new InvalidEmedContentException("The patient is missing.");
        final var resource = this.getSubject().getResource();
        if (resource instanceof ChCorePatientEpr chPatient) {
            return chPatient;
        }
        throw new InvalidEmedContentException("The patient resource isn't of the right type.");
    }

    /**
     * Resolves the base entry of the dosage instruction.
     *
     * @return the base entry of the dosage instruction
     * @throws InvalidEmedContentException if the base entry of the dosage instruction is missing.
     */
    @ExpectsValidResource
    public ChEmedDosage resolveBaseDosage() throws InvalidEmedContentException {
        if (!this.getDosageInstruction().isEmpty() && this.getDosageInstruction().get(0) instanceof final ChEmedDosage dosage) {
            return dosage;
        }
        throw new InvalidEmedContentException("Base entry of the dosage instruction is missing.");
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
    public List<ChEmedDosage> resolveAdditionalDosage() {
        return this.getDosageInstruction().stream()
                .filter(ChEmedDosage.class::isInstance)
                .map(ChEmedDosage.class::cast)
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
            case COMPLETED, UNKNOWN, NULL -> throw new InvalidEmedContentException("The status is not supported.");
        };
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
        this.setMedication(References.createReference(chEmedEprMedication));
        return this;
    }

    /**
     * Set the patient targeted.
     *
     * @param chCorePatientEpr the patient.
     * @return this.
     */
    public ChEmedEprMedicationRequest setPatient(final ChCorePatientEpr chCorePatientEpr) {
        this.setSubject(References.createReference(chCorePatientEpr));
        return this;
    }

    /**
     * Sets the base entry of the dosage instruction. If it already exists, it will be replaced.
     *
     * @param dosageBaseEntry the base entry of the dosage instruction.
     * @return this.
     */
    public ChEmedEprMedicationRequest setDosageBaseEntry(final ChEmedDosage dosageBaseEntry) {
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
    public ChEmedEprMedicationRequest addDosageAdditionalEntry(final ChEmedDosage dosageAdditionalEntry) {
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
                if (!(this.dosageInstruction.get(i) instanceof ChEmedDosage)) {
                    final var newDosage = new ChEmedDosage();
                    this.dosageInstruction.get(i).copyValues(newDosage);
                    this.dosageInstruction.set(i, newDosage);
                }
            }
        }
        return this.dosageInstruction;
    }

    /**
     * @param theDosage
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    @Override
    public MedicationRequest setDosageInstruction(final List<Dosage> theDosage) {
        return super.setDosageInstruction(theDosage);
    }

    @Override
    public ChEmedDosage addDosageInstruction() {
        final var dosage = new ChEmedDosage();
        this.addDosageInstruction(dosage);
        return dosage;
    }

    @Override
    public MedicationRequest addDosageInstruction(final Dosage t) {
        if (t instanceof final ChEmedDosage chEmedDosage) {
            this.dosageInstruction.add(t);
        }
        final var newDosage = new ChEmedDosage();
        t.copyValues(newDosage);
        this.dosageInstruction.add(newDosage);
        return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dosageInstruction}, creating it if it does not already
     * exist
     */
    @Override
    public ChEmedDosage getDosageInstructionFirstRep() {
        if (getDosageInstruction().isEmpty()) {
            addDosageInstruction();
        }
        return (ChEmedDosage) getDosageInstruction().get(0);
    }

    /**
     * Converts the main and additional dosages into a read-only model, containing the effective dosage instructions.
     */
    @ExpectsValidResource
    public EffectiveDosageInstructions resolveEffectiveDosageInstructions() {
        throw new NotImplementedException();
    }
}
