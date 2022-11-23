package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.MedicationDispense;
import org.hl7.fhir.r4.model.StringType;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.model.common.EmedReference;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprMedicationDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosage;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosageSplit;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPharmaceuticalAdvice;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtPrescription;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.sql.Date;
import java.time.Instant;
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
    public ChEmedEprMedicationDis resolveMedicationReference() throws InvalidEmedContentException {
        if (!this.hasMedicationReference())
            throw new InvalidEmedContentException("The medication reference is missing.");
        final var resource = this.getMedicationReference().getResource();
        if (resource instanceof ChEmedEprMedicationDis chMedication) {
            return chMedication;
        }
        throw new InvalidEmedContentException("The medication resource isn't the right type.");
    }

    /**
     * The number of packages.
     *
     * @return the number of packages.
     * @throws InvalidEmedContentException if the number of packages is missing.
     * @throws ArithmeticException         if this has a nonzero fractional part, or will not fit in an int.
     */
    @ExpectsValidResource
    public int resolveQuantity() throws InvalidEmedContentException, ArithmeticException {
        if (!this.hasQuantity()) throw new InvalidEmedContentException("The number of packages is missing.");
        return this.getQuantity().getValue().intValueExact();
    }

    /**
     * Resolves the date/time of when the product was distributed.
     *
     * @return the date/time of when the product was distributed.
     * @throws InvalidEmedContentException if the date/time of when the product was distributed is missing.
     */
    @ExpectsValidResource
    public Instant resolveWhenHandedOver() throws InvalidEmedContentException {
        if (!this.hasWhenHandedOver())
            throw new InvalidEmedContentException("the date/time of when the product was distributed is missing.");
        return this.getWhenHandedOver().toInstant();
    }

    /**
     * Resolves the base entry of the dosage instruction.
     *
     * @return the base entry of the dosage instruction
     * @throws InvalidEmedContentException if the base entry of the dosage instruction is missing.
     */
    @ExpectsValidResource
    public ChEmedDosage resolveDosageBaseEntry() throws InvalidEmedContentException {
        return this.getDosageInstruction().stream()
                .filter(ChEmedDosage.class::isInstance)
                .map(ChEmedDosage.class::cast)
                .findAny()
                .orElseThrow(() -> new InvalidEmedContentException("Base entry of the dosage instruction is missing."));
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
     * Gets additional entries of the dosage instruction
     *
     * @return additional entries of the dosage instruction.
     */
    public List<ChEmedDosageSplit> getDosageAdditionalEntry() {
        return this.getDosageInstruction().stream()
                .filter(ChEmedDosageSplit.class::isInstance)
                .map(ChEmedDosageSplit.class::cast)
                .toList();
    }

    @Override
    public EmedEntryType getEmedType() {
        return EmedEntryType.DIS;
    }

    /**
     * Gets the treatment reason. If it doesn't exist, it's created.
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
     * Gets the pharmaceutical advice element. If it doesn't exist, it's created.
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
     * Sets the ID of a medication dispense, if it's already exists, it's replaced.
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
    public ChEmedEprMedicationDispense setDosageBaseEntry(final ChEmedDosage dosageBaseEntry) {
        for (int i = 0; i < this.getDosageInstruction().size(); i++) {
            if (this.getDosageInstruction().get(i) instanceof ChEmedDosage) {
                this.getDosageInstruction().set(i, dosageBaseEntry);
                return this;
            }
        }

        this.getDosageInstruction().add(dosageBaseEntry);
        return this;
    }

    /**
     * Adds additional entry of the dosage instruction.
     *
     * @param dosageAdditionalEntry additional entry of the dosage instruction.
     * @return this.
     */
    public ChEmedEprMedicationDispense addDosageAdditionalEntry(final ChEmedDosageSplit dosageAdditionalEntry) {
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
        return this.prescription != null;
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
        return this.treatmentPlan != null;
    }

    /**
     * Returns whether the base entry of the dosage instruction.
     *
     * @return {@code true} if the base entry of the dosage instruction exists, {@code false} otherwise.
     */
    public boolean hasDosageBaseEntry() {
        return this.hasDosageInstruction() && this.getDosageInstruction().stream()
                .anyMatch(ChEmedDosage.class::isInstance);
    }

    /**
     * Returns whether additional entry of the dosage instruction.
     *
     * @return {@code true} if additional entry of the dosage instruction exists, {@code false} otherwise.
     */
    public boolean hasDosageAdditionalEntry() {
        return this.hasDosageInstruction() && this.getDosageInstruction().stream()
                .anyMatch(ChEmedDosageSplit.class::isInstance);
    }
}
