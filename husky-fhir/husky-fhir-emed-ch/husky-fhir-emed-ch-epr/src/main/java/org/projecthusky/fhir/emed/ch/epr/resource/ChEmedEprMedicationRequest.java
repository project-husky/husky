package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosageMedicationRequest;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosageSplitMedicationRequest;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationRequest.
 *
 * @author Ronaldo Loureiro
 **/
public abstract class ChEmedEprMedicationRequest extends MedicationRequest implements ChEmedEprEntry {

    @Child(name = "treatmentplan")
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
    public ChEmedDosageMedicationRequest resolveDosageBaseEntry() throws InvalidEmedContentException {
        return this.getDosageInstruction().stream()
                .filter(ChEmedDosageMedicationRequest.class::isInstance)
                .map(ChEmedDosageMedicationRequest.class::cast)
                .findAny()
                .orElseThrow(() -> new InvalidEmedContentException("Base entry of the dosage instruction is missing."));
    }

    /**
     * Gets additional entries of the dosage instruction
     *
     * @return additional entries of the dosage instruction.
     */
    public List<ChEmedDosageSplitMedicationRequest> getDosageAdditionalEntry() {
        return this.getDosageInstruction().stream()
                .filter(ChEmedDosageSplitMedicationRequest.class::isInstance)
                .map(ChEmedDosageSplitMedicationRequest.class::cast)
                .toList();
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
    public ChEmedEprMedicationRequest setDosageBaseEntry(final ChEmedDosageMedicationRequest dosageBaseEntry) {
        for (int i = 0; i < this.getDosageInstruction().size(); i++) {
            if (this.getDosageInstruction().get(i) instanceof ChEmedDosageMedicationRequest) {
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
    public ChEmedEprMedicationRequest addDosageAdditionalEntry(final ChEmedDosageSplitMedicationRequest dosageAdditionalEntry) {
        this.getDosageInstruction().add(dosageAdditionalEntry);
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
     * Returns whether the base entry of the dosage instruction.
     *
     * @return {@code true} if the base entry of the dosage instruction exists, {@code false} otherwise.
     */
    public boolean hasDosageBaseEntry() {
        return this.hasDosageInstruction() && this.getDosageInstruction().stream()
                .anyMatch(ChEmedDosageMedicationRequest.class::isInstance);
    }

    /**
     * Returns whether additional entry of the dosage instruction.
     *
     * @return {@code true} if additional entry of the dosage instruction exists, {@code false} otherwise.
     */
    public boolean hasDosageAdditionalEntry() {
        return this.hasDosageInstruction() && this.getDosageInstruction().stream()
                .anyMatch(ChEmedDosageSplitMedicationRequest.class::isInstance);
    }
}
