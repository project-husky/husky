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
package org.projecthusky.fhir.emed.ch.epr.resource;

import org.apache.commons.lang3.NotImplementedException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.model.common.EffectiveDosageInstructions;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedDosage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationStatement.
 *
 * @author Quentin Ligier
 **/
public abstract class ChEmedEprMedicationStatement extends MedicationStatement implements ChEmedEprEntry {
    // Here goes everything common to MedicationStatement (MTP), (PML) and (PMLC)

    /**
     * Empty constructor for the parser.
     */
    protected ChEmedEprMedicationStatement() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid the medication statement id.
     */
    protected ChEmedEprMedicationStatement(final UUID entryUuid) {
        super();
        this.setStatus(MedicationStatementStatus.COMPLETED);
        this.addIdentifier().setValue(Uuids.URN_PREFIX + entryUuid).setSystem(FhirSystem.URI);
    }

    @Override
    public EmedEntryType getEmedType() {
        return EmedEntryType.MTP;
    }

    /**
     * Returns the medication or throws.
     *
     * @return the medication.
     * @throws InvalidEmedContentException if the medication is missing or invalid.
     */
    @ExpectsValidResource
    public ChEmedEprMedication resolveMedication() throws InvalidEmedContentException {
        if (!this.hasMedication()) {
            throw new InvalidEmedContentException("The medication is missing in the medication statement");
        }

        final var reference = this.getMedication();
        if (reference instanceof final Reference ref) {
            final var resource = ref.getResource();
            if (resource instanceof ChEmedEprMedication chMedication) {
                return chMedication;
            }
        }
        throw new InvalidEmedContentException("The medication is invalid");
    }

    /**
     * Resolves the medication statement UUID or throws.
     *
     * @return the medication statement UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing.");
        return Uuids.parseUrnEncoded(this.getIdentifierFirstRep().getValue());
    }

    /**
     * Resolves the base entry of the dosage instruction.
     *
     * @return the base entry of the dosage instruction
     * @throws InvalidEmedContentException if the base entry of the dosage instruction is missing.
     */
    @ExpectsValidResource
    public ChEmedDosage resolveBaseDosage() throws InvalidEmedContentException {
        if (!this.getDosage().isEmpty() && this.getDosage().get(0) instanceof final ChEmedDosage dosage) {
            return dosage;
        }
        throw new InvalidEmedContentException("Base entry of the dosage instruction is missing.");
    }

    /**
     * Resolves additional entries of the dosage instruction. The list may be empty.
     *
     * @return additional entries of the dosage instruction.
     */
    public List<ChEmedDosage> resolveAdditionalDosage() {
        return this.getDosage().stream()
                .filter(ChEmedDosage.class::isInstance)
                .map(ChEmedDosage.class::cast)
                .skip(1)
                .toList();
    }

    /**
     * Resolves the information source as a practitioner role.
     *
     * @return the practitioner role or {@code null}.
     */
    @ExpectsValidResource
    @Nullable
    public ChEmedEprPractitionerRole resolveInformationSource() {
        if (this.getInformationSource().isEmpty()) {
            return null;
        }
        if (this.getInformationSource().getResource() instanceof final ChEmedEprPractitionerRole pr) {
            return pr;
        }
        throw new InvalidEmedContentException("The information source isn't a ChEmedEprPractitionerRole");
    }

    /**
     * Gets the treatment reason if available.
     *
     * @return the treatment reason or {@code null}.
     */
    @Nullable
    protected String getTreatmentReason() {
        if (this.reasonCode == null || !this.getReasonCodeFirstRep().hasText()) return null;
        return this.getReasonCodeFirstRep().getText();
    }

    /**
     * Sets the treatment reason. If the treatment reason already exists, it's replaced.
     *
     * @param treatmentReason the treatment reason
     * @return this.
     */
    protected ChEmedEprMedicationStatement setTreatmentReason(final String treatmentReason) {
        this.getReasonCodeFirstRep().setText(treatmentReason);
        return this;
    }

    /**
     * Sets the medication statement UUID.
     *
     * @param documentUUID The medication statement UUID.
     * @return this.
     */
    public ChEmedEprMedicationStatement setIdentifier(final UUID documentUUID) {
        var identifier = this.getIdentifierFirstRep();
        if (identifier == null) {
            identifier = new Identifier();
            identifier.setSystem(FhirSystem.URI);
        }
        identifier.setValue(Uuids.URN_PREFIX + documentUUID);
        return this;
    }

    /**
     * Sets the base entry of the dosage instruction. If it already exists, it will be replaced.
     *
     * @param dosageBaseEntry the base entry of the dosage instruction.
     * @return this.
     */
    public ChEmedEprMedicationStatement setDosageBaseEntry(final ChEmedDosage dosageBaseEntry) {
        if (this.hasDosage()) {
            this.getDosage().set(0, dosageBaseEntry);
        } else {
            this.getDosage().add(dosageBaseEntry);
        }
        return this;
    }

    /**
     * Adds additional entry of the dosage instruction.
     *
     * @param dosageAdditionalEntry additional entry of the dosage instruction.
     * @return this.
     */
    public ChEmedEprMedicationStatement addDosageAdditionalEntry(final ChEmedDosage dosageAdditionalEntry) {
        this.getDosage().add(dosageAdditionalEntry);
        return this;
    }

    /**
     * Returns whether the base entry of the dosage instruction.
     *
     * @return {@code true} if the base entry of the dosage instruction exists, {@code false} otherwise.
     */
    public boolean hasDosageBaseEntry() {
        return this.hasDosage();
    }

    /**
     * Returns whether additional entry of the dosage instruction.
     *
     * @return {@code true} if additional entry of the dosage instruction exists, {@code false} otherwise.
     */
    public boolean hasDosageAdditionalEntry() {
        return this.hasDosage() && this.getDosage().size() > 1;
    }

    /**
     * @return {@link #dosage} (Indicates how the medication is/was or should be taken by the patient.)
     */
    @Override
    public List<Dosage> getDosage() {
        if (this.dosage == null)
            this.dosage = new ArrayList<>();
        else {
            for (int i = 0; i < this.dosage.size(); ++i) {
                if (!(this.dosage.get(i) instanceof ChEmedDosage)) {
                    final var newDosage = new ChEmedDosage();
                    this.dosage.get(i).copyValues(newDosage);
                    this.dosage.set(i, newDosage);
                }
            }
        }
        return this.dosage;
    }

    /**
     * @param theDosage
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    @Override
    public MedicationStatement setDosage(final List<Dosage> theDosage) {
        return super.setDosage(theDosage);
    }

    @Override
    public ChEmedDosage addDosage() {
        final var dosage = new ChEmedDosage();
        this.addDosage(dosage);
        return dosage;
    }

    @Override
    public MedicationStatement addDosage(final Dosage t) {
        if (t instanceof final ChEmedDosage chEmedDosage) {
            this.dosage.add(chEmedDosage);
        }
        final var newDosage = new ChEmedDosage();
        t.copyValues(newDosage);
        this.dosage.add(newDosage);
        return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dosage}, creating it if it does not already exist
     */
    @Override
    public ChEmedDosage getDosageFirstRep() {
        if (getDosage().isEmpty()) {
            addDosage();
        }
        return (ChEmedDosage) getDosage().get(0);
    }

    /**
     * Converts the main and additional dosages into a read-only model, containing the effective dosage instructions.
     */
    @ExpectsValidResource
    public EffectiveDosageInstructions resolveEffectiveDosageInstructions() {
        throw new NotImplementedException();
    }
}
