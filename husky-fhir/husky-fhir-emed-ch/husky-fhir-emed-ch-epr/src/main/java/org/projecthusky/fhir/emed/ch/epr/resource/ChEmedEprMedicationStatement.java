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

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.datatypes.Uuids;

import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;

import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

import org.projecthusky.fhir.core.ch.util.FhirSystem;

import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.common.EffectiveDosageInstructions;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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
     * Whether the dispenser can substitute the prescribed medicine/package by another that is deemed equivalent, for
     * medical or logistical reasons. By default, substitution is authorized.
     */
    @Nullable
    @Child(name = "substitution")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-substitution", definedLocally = false)
    protected CodeableConcept substitution;

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
     * Gets the substitution element in the medication statement.
     *
     * @return the substitution element.
     */
    public CodeableConcept getSubstitution() {
        if (this.substitution == null) {
            this.substitution = new CodeableConcept();
        }
        return this.substitution;
    }

    /**
     * Gets the substitution code in the medication statement.
     *
     * @return the substitution code.
     * @throws InvalidEmedContentException if the substitution code is invalid.
     */
    @ExpectsValidResource
    public SubstanceAdministrationSubstitutionCode resolveSubstitution() throws InvalidEmedContentException {
        if (!this.hasSubstitution()) {
            return SubstanceAdministrationSubstitutionCode.EQUIVALENT;
        }
        final var substitutionCode =
                SubstanceAdministrationSubstitutionCode.fromCoding(this.getSubstitution().getCodingFirstRep());
        if (substitutionCode == null) {
            throw new InvalidEmedContentException("The substitution code is invalid");
        }
        return substitutionCode;
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
    public ChEmedEprDosage resolveBaseDosage() throws InvalidEmedContentException {
        if (!this.getDosage().isEmpty() && this.getDosage().getFirst() instanceof final ChEmedEprDosage dosage) {
            return dosage;
        }
        throw new InvalidEmedContentException("Base entry of the dosage instruction is missing.");
    }

    /**
     * Resolves additional entries of the dosage instruction. The list may be empty.
     *
     * @return additional entries of the dosage instruction.
     */
    public List<ChEmedEprDosage> resolveAdditionalDosage() {
        return this.getDosage().stream()
                .filter(ChEmedEprDosage.class::isInstance)
                .map(ChEmedEprDosage.class::cast)
                .skip(1)
                .toList();
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

    /**
     * Sets the treatment reason. If the treatment reason already exists, it's replaced.
     *
     * @param treatmentReason the treatment reason
     * @return this.
     */
    public ChEmedEprMedicationStatement setTreatmentReason(final String treatmentReason) {
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
    public ChEmedEprMedicationStatement setDosageBaseEntry(final ChEmedEprDosage dosageBaseEntry) {
        if (this.hasDosage()) {
            this.getDosage().set(0, dosageBaseEntry);
        } else {
            this.getDosage().add(dosageBaseEntry);
        }
        return this;
    }

    /**
     * Sets the substitution element in the medication statement.
     *
     * @param value the substitution element.
     * @return this.
     */
    public ChEmedEprMedicationStatement setSubstitutionElement(final CodeableConcept value) {
        this.substitution = value;
        return this;
    }

    /**
     * Sets the substitution code in the medication statement, with an English display name.
     *
     * @param value the substitution code.
     * @return this.
     */
    public ChEmedEprMedicationStatement setSubstitution(final SubstanceAdministrationSubstitutionCode value) {
        this.setSubstitutionElement(value.getCodeableConcept());
        return this;
    }

    /**
     * Sets the substitution code in the medication statement, with a display name in the requested language.
     *
     * @param value        the substitution code.
     * @param languageCode the requested language for the display name.
     * @return this.
     */
    public ChEmedEprMedicationStatement setSubstitution(final SubstanceAdministrationSubstitutionCode value,
                                                        final LanguageCode languageCode) {
        this.setSubstitutionElement(value.getCodeableConcept(languageCode));
        return this;
    }

    /**
     * Adds additional entry of the dosage instruction.
     *
     * @param dosageAdditionalEntry additional entry of the dosage instruction.
     * @return this.
     */
    public ChEmedEprMedicationStatement addDosageAdditionalEntry(final ChEmedEprDosage dosageAdditionalEntry) {
        this.getDosage().add(dosageAdditionalEntry);
        return this;
    }

    /**
     * Returns whether substitution code exists.
     *
     * @return {@code true} if the substitution code exists, {@code false} otherwise.
     */
    public boolean hasSubstitution() {
        return this.substitution != null && !this.substitution.isEmpty();
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
                if (!(this.dosage.get(i) instanceof ChEmedEprDosage)) {
                    final var newDosage = new ChEmedEprDosage();
                    this.dosage.get(i).copyValues(newDosage);
                    this.dosage.set(i, newDosage);
                }
            }
        }
        return this.dosage;
    }

    @Override
    public ChEmedEprDosage addDosage() {
        final var dosage = new ChEmedEprDosage();
        this.addDosage(dosage);
        return dosage;
    }

    @Override
    public MedicationStatement addDosage(final Dosage t) {
        if (t instanceof final ChEmedEprDosage chEmedEprDosage) {
            this.dosage.add(chEmedEprDosage);
            return this;
        }
        final var newDosage = new ChEmedEprDosage();
        t.copyValues(newDosage);
        this.dosage.add(newDosage);
        return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dosage}, creating it if it does not already exist
     */
    @Override
    public ChEmedEprDosage getDosageFirstRep() {
        if (getDosage().isEmpty()) {
            addDosage();
        }
        return (ChEmedEprDosage) getDosage().getFirst();
    }

    /**
     * Converts the main and additional dosages into a read-only model, containing the effective dosage instructions.
     */
    @ExpectsValidResource
    public EffectiveDosageInstructions resolveEffectiveDosageInstructions() {
        return EffectiveDosageInstructions.fromDosages(this.resolveBaseDosage(), this.resolveAdditionalDosage());
    }

    /**
     * Resolves the information source.
     *
     * @return the information source or {@code null}.
     */
    @ExpectsValidResource
    public Author resolveInformationSource() {
        if (!this.hasInformationSource())
            throw new InvalidEmedContentException("Missing informationSource.");
        return new Author(this.getInformationSource().getResource(), resolveAsserted());
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
    public void copyValues(final MedicationStatement dst) {
        super.copyValues(dst);
        if (dst instanceof final ChEmedEprMedicationStatement als) {
            als.substitution = substitution == null ? null : substitution.copy();
        }
    }

    /**
     * Sets the information source (medical author) of the statement.
     * It creates a reference from the received author and sets it as information source.
     * If the author has a timestamp, it sets the asserted field.
     * @param author The medical author of the statement.
     * @return this.
     */
    public ChEmedEprMedicationStatement setInformationSource(final Author author) {
        this.setInformationSource(References.createAuthorReference(author));
        if (author.getTime() != null) this.setDateAsserted(Date.from(author.getTime()));
        return this;
    }

    /**
     *
     * @return The asserted date as an Instant.
     */
    @ExpectsValidResource
    public Instant resolveAsserted() {
        if (!this.hasDateAsserted())
            throw new InvalidEmedContentException("The asserted timestamp is missing");
        return this.getDateAssertedElement().getValueAsCalendar().toInstant();
    }

    /**
     *
     * @return The information source as Author and the asserted timestamp as its time.
     */
    @Override
    @ExpectsValidResource
    public Author resolveMedicalAuthor() {
        return resolveInformationSource();
    }

    /**
     *
     * @return The asserted timestamp.
     */
    @Override
    @ExpectsValidResource
    public Instant resolveMedicalAuthorshipTimestamp() {
        return resolveAsserted();
    }
}
