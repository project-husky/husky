package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.MedicationDispense;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.StringType;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedQuantityWithEmedUnits;
import org.projecthusky.fhir.emed.ch.epr.model.common.EffectiveDosageInstructions;
import org.projecthusky.fhir.emed.ch.epr.model.common.EmedReference;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprMedicationDis;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPharmaceuticalAdvice;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPrescription;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationDispense.
 *
 * @author Ronaldo Loureiro
 **/
public abstract class ChEmedEprMedicationDispense extends MedicationDispense implements ChEmedEprEntry {

    /**
     * The treatment reason.
     */
    @Nullable
    @Child(name = "treatmentReason")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentreason", definedLocally = false)
    protected StringType treatmentReason;

    /**
     * Reference to the medication prescription.
     */
    @Nullable
    @Child(name = "prescription")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-prescription", definedLocally = false)
    protected ChEmedExtPrescription prescription;

    /**
     * Reference to the pharmaceutical advice.
     */
    @Nullable
    @Child(name = "pharmaceuticalAdvice")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-pharmaceuticaladvice", definedLocally = false)
    protected ChEmedExtPharmaceuticalAdvice pharmaceuticalAdvice;

    /**
     * Reference to the medication treatment plan
     */
    @Nullable
    @Child(name = "treatmentPlan", min = 1)
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-treatmentplan", definedLocally = false)
    protected ChEmedExtTreatmentPlan treatmentPlan;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationDispense() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication dispense id.
     */
    public ChEmedEprMedicationDispense(final UUID entryUuid,
                                       final Instant whenHandedOver) {
        super();
        this.setStatus(MedicationDispenseStatus.COMPLETED);
        this.getIdentifierFirstRep().setValue(Uuids.URN_PREFIX + entryUuid).setSystem(FhirSystem.URI);
        this.setWhenHandedOver(Date.from(whenHandedOver));
    }

    /**
     * Resolves the medication dispense UUID or throws.
     *
     * @return the medication dispense UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) {
            throw new InvalidEmedContentException("The ID is missing");
        }
        return Uuids.parseUrnEncoded(this.getIdentifierFirstRep().getValue());
    }

    /**
     * Resolves the medication or throws.
     *
     * @return the medication.
     * @throws InvalidEmedContentException if the medication is missing or if it isn't of the right type.
     */
    @ExpectsValidResource
    public ChEmedEprMedicationDis resolveMedication() throws InvalidEmedContentException {
        if (!this.hasMedicationReference()) {
            throw new InvalidEmedContentException("The medication reference is missing");
        }
        final IBaseResource resource = this.getMedicationReference().getResource();
        if (resource instanceof ChEmedEprMedicationDis chMedication) {
            return chMedication;
        }
        throw new InvalidEmedContentException("The medication resource isn't of the right type");
    }

    /**
     * Resolves the amount of medication that has been dispensed. Includes unit of measure.
     *
     * @return The amount of medication that has been dispensed.
     * @throws InvalidEmedContentException if the quantity is missing or invalid.
     */
    @ExpectsValidResource
    public ChEmedQuantityWithEmedUnits resolveQuantity() throws InvalidEmedContentException {
        if (!this.hasQuantity()) {
            throw new InvalidEmedContentException("The number of packages is missing");
        }
        final Quantity quantity = this.getQuantity();
        if (quantity instanceof final ChEmedQuantityWithEmedUnits chQuantity) {
            return chQuantity;
        }
        throw new InvalidEmedContentException("The quantity isn't of the right type");
    }

    /**
     * Resolves the date/time of when the product was distributed.
     *
     * @return the date/time of when the product was distributed.
     * @throws InvalidEmedContentException if the date/time of when the product was distributed is missing.
     */
    @ExpectsValidResource
    public Instant resolveWhenHandedOver() throws InvalidEmedContentException {
        if (!this.hasWhenHandedOver()) {
            throw new InvalidEmedContentException("the date/time of when the product was distributed is missing.");
        }
        return this.getWhenHandedOver().toInstant();
    }

    /**
     * Resolves the base entry of the dosage instruction.
     *
     * @return the base entry of the dosage instruction
     * @throws InvalidEmedContentException if the base entry of the dosage instruction is missing.
     */
    @ExpectsValidResource
    public ChEmedEprDosage resolveBaseDosage() throws InvalidEmedContentException {
        if (!this.getDosageInstruction().isEmpty() && this.getDosageInstruction().get(0) instanceof final ChEmedEprDosage dosage) {
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

    @Override
    public EmedEntryType getEmedType() {
        return EmedEntryType.DIS;
    }

    /**
     * Gets the treatment reason. If it doesn't exist, it is created.
     *
     * @return the treatment reason.
     */
    public StringType getTreatmentReason() {
        if (this.treatmentReason == null) {
            this.treatmentReason = new StringType();
        }
        return this.treatmentReason;
    }

    /**
     * Sets the treatment reason.
     *
     * @param treatmentReason the treatment reason.
     * @return this.
     */
    public ChEmedEprMedicationDispense setTreatmentReason(final String treatmentReason) {
        this.getTreatmentReason().setValue(treatmentReason);
        return this;
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
     * Sets the prescription reference.
     *
     * @param prescription the prescription reference.
     * @return this.
     */
    public ChEmedEprMedicationDispense setPrescriptionElement(final ChEmedExtPrescription prescription) {
        this.prescription = prescription;
        return this;
    }

    /**
     * Gets the pharmaceutical advice element. If it doesn't exist, it is created.
     *
     * @return the pharmaceutical advice element.
     */
    public ChEmedExtPharmaceuticalAdvice getPharmaceuticalAdviceElement() {
        if (this.pharmaceuticalAdvice == null) {
            this.pharmaceuticalAdvice = new ChEmedExtPharmaceuticalAdvice();
        }
        return this.pharmaceuticalAdvice;
    }

    /**
     * Sets the pharmaceutical advice reference.
     *
     * @param pharmaceuticalAdvice the pharmaceutical advice reference.
     * @return this.
     */
    public ChEmedEprMedicationDispense setPharmaceuticalAdviceElement(final ChEmedExtPharmaceuticalAdvice pharmaceuticalAdvice) {
        this.pharmaceuticalAdvice = pharmaceuticalAdvice;
        return this;
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
    public ChEmedEprMedicationDispense setTreatmentPlanElement(final ChEmedExtTreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
        return this;
    }

    /**
     * Sets the ID of a medication dispense, if it is already exists, it is replaced.
     *
     * @param identifier the ID of a medication dispense.
     * @return this.
     */
    public ChEmedEprMedicationDispense setIdentifier(final UUID identifier) {
        if (!this.hasIdentifier()) {
            this.getIdentifierFirstRep().setSystem(FhirSystem.URI);
        }
        this.getIdentifierFirstRep()
                .setValue(Uuids.URN_PREFIX + identifier);
        return this;
    }

    /**
     * Sets the medication reference.
     *
     * @param chEmedEprMedication the medication resource.
     * @return this.
     */
    public ChEmedEprMedicationDispense setMedicationReference(final ChEmedEprMedicationDis chEmedEprMedication) {
        this.setMedication(References.createReference(chEmedEprMedication));
        this.addContained(chEmedEprMedication);
        return this;
    }

    /**
     * Sets the number of packages.
     *
     * @param quantity the number of packages.
     * @return this.
     */
    public ChEmedEprMedicationDispense setQuantity(final int quantity) {
        this.getQuantity().setValue(quantity);
        return this;
    }

    /**
     * Sets when product was given out.
     *
     * @param whenHandedOver when product was given out.
     * @return this.
     */
    public ChEmedEprMedicationDispense setWhenHandedOver(final Instant whenHandedOver) {
        super.setWhenHandedOver(Date.from(whenHandedOver));
        return this;
    }

    /**
     * Sets the base entry of the dosage instruction. If it already exists, it will be replaced.
     *
     * @param dosageBaseEntry the base entry of the dosage instruction.
     * @return this.
     */
    public ChEmedEprMedicationDispense setDosageBaseEntry(final ChEmedEprDosage dosageBaseEntry) {
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
    public ChEmedEprMedicationDispense addDosageAdditionalEntry(final ChEmedEprDosage dosageAdditionalEntry) {
        this.getDosageInstruction().add(dosageAdditionalEntry);
        return this;
    }

    /**
     * Returns whether the treatment reason.
     *
     * @return {@code true} if the treatment reason exists, {@code false} otherwise.
     */
    public boolean hasTreatmentReason() {
        return this.treatmentReason != null && !this.treatmentReason.isEmpty();
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
     * Returns whether the pharmaceutical advice reference.
     *
     * @return {@code true} if the pharmaceutical advice reference exists, {@code false} otherwise.
     */
    public boolean hasPharmaceuticalAdvice() {
        return this.pharmaceuticalAdvice != null;
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

    /**
     * @param theDosage
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    @Override
    public MedicationDispense setDosageInstruction(final List<Dosage> theDosage) {
        return super.setDosageInstruction(theDosage);
    }

    @Override
    public ChEmedEprDosage addDosageInstruction() {
        final var dosage = new ChEmedEprDosage();
        this.addDosageInstruction(dosage);
        return dosage;
    }

    @Override
    public MedicationDispense addDosageInstruction(final Dosage t) {
        if (t instanceof final ChEmedEprDosage chEmedEprDosage) {
            this.dosageInstruction.add(t);
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
        return (ChEmedEprDosage) getDosageInstruction().get(0);
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

    @Override
    public void copyValues(final MedicationDispense dst) {
        super.copyValues(dst);
        if (dst instanceof final ChEmedEprMedicationDispense als) {
            als.treatmentReason = treatmentReason == null ? null : treatmentReason.copy();
            als.prescription = prescription == null ? null : prescription.copy();
            als.pharmaceuticalAdvice = pharmaceuticalAdvice == null ? null : pharmaceuticalAdvice.copy();
            als.treatmentPlan = treatmentPlan == null ? null : treatmentPlan.copy();
        }
    }
}
