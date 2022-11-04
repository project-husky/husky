package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosageNormalMedicationRequest;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosageSplitMedicationRequest;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationRequest.
 *
 * @author Ronaldo Loureiro
 **/
public abstract class ChEmedEprMedicationRequest extends MedicationRequest {

    // TODO Update Dosage
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
     * Constructor
     *
     * @param entryUuid the medication request id.
     */
    public ChEmedEprMedicationRequest(final UUID entryUuid) {
        super();
        this.setStatus(MedicationRequestStatus.COMPLETED);
        this.setIntent(MedicationRequestIntent.ORDER);
        this.addIdentifier().setValue(Uuids.URN_PREFIX + entryUuid).setSystem(FhirSystem.URI);
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
        if (!this.hasMedicationReference()) throw new InvalidEmedContentException("The medication reference is missing.");
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
            return  chPatient;
        }
        throw new InvalidEmedContentException("The patient resource isn't of the right type.");
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
     * Sets structured normal dosing. If one or more dosages exist, they will be replaced.
     *
     * @param dosageStructuredNormal the structured normal dosing.
     * @return this.
     */
    public ChEmedEprMedicationRequest setDosageStructuredNormal(final ChEmedDosageNormalMedicationRequest dosageStructuredNormal) {
        if (!this.getDosageInstruction().isEmpty()) {
            this.getDosageInstruction().clear();
        }
        this.getDosageInstruction().add(dosageStructuredNormal);

        return this;
    }

    /**
     * Sets structured split dosing. If one or more dosages exist, they will be replaced.
     *
     * @param dosageStructuredSplit the structured split dosing.
     * @return this.
     */
    public ChEmedEprMedicationRequest addDosageStructuredSplit(final ChEmedDosageSplitMedicationRequest dosageStructuredSplit) {
        final var dosageInstructions = this.getDosageInstruction();
        if (!dosageInstructions.isEmpty()) {
            if (!(dosageInstructions.get(0) instanceof ChEmedDosageSplitMedicationRequest)) {
                dosageInstructions.clear();
            }
        }
        dosageInstructions.add(dosageStructuredSplit);
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
     * Returns whether the normal structured dosing.
     *
     * @return {@code true} if the normal structured dosing exists, {@code false} otherwise.
     */
    public boolean hasDosageStructuredNormal() {
        return this.hasDosageInstruction() && this.getDosageInstructionFirstRep() instanceof ChEmedDosageNormalMedicationRequest;
    }

    /**
     * Returns whether the split structured dosing.
     *
     * @return {@code true} if the split structured dosing exists, {@code false} otherwise.
     */
    public boolean hasDosageStructuredSplit() {
        return this.hasDosageInstruction() && this.getDosageInstructionFirstRep() instanceof ChEmedDosageSplitMedicationRequest;
    }
}
