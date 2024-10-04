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

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Medication;
import org.hl7.fhir.r4.model.UriType;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.PharmaceuticalDoseFormEdqm;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedRatioWithEmedUnits;

import java.util.List;
import java.util.Objects;

/**
 * The HAPI custom structure for CH-EMED-EPR Medication.
 * <p>
 * Because of the parser limitations, this class can't be extended into DIS and PML flavours. All methods and extensions
 * are included here, be careful and read the JavaDoc when using these new methods.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medication")
public class ChEmedEprMedication extends Medication {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedication() {
        super();
    }

    /**
     * @return The gtin code or {@code null}.
     */
    @ExpectsValidResource
    @Nullable
    public String resolveGtinCode() {
        return resolveCodeForSystem(FhirSystem.GTIN);
    }

    /**
     * @return The atc code or {@code null}.
     */
    @ExpectsValidResource
    @Nullable
    public String resolveAtcCode() {
        return resolveCodeForSystem(FhirSystem.ATC);
    }

    /**
     * @param system The system for which to resolve the code.
     * @return The code for the specified system or {@code null} if no code for that system is present.
     */
    @ExpectsValidResource
    @Nullable
    public String resolveCodeForSystem(final String system) {
        Objects.requireNonNull(system);
        if (!this.hasCode() || !this.getCode().hasCoding()) return null;
        return this.getCode().getCoding().stream()
                .filter(coding -> system.equals(coding.getSystem()))
                .map(Coding::getCode)
                .findAny().orElse(null);
    }

    /**
     * Returns the medication name or throws.
     *
     * @return The medication name.
     * @throws InvalidEmedContentException if the medication name is missing.
     */
    @ExpectsValidResource
    public String resolveMedicationName() throws InvalidEmedContentException {
        if (!this.hasCode() && this.getCode().getText() == null)
            throw new InvalidEmedContentException("The medication name is not specified");

        return this.getCode().getText();
    }

    /**
     * Sets the GTIN. If a GTIN code already exists, it's replaced. The text is set only if it doesn't exist yet.
     *
     * @param gtin        The GTIN code.
     * @param displayName The name associate with GTIN.
     * @return this.
     */
    public ChEmedEprMedication setGtin(final String gtin,
                                       final String displayName) {
        Coding coding = null;
        if (this.hasCode() && this.getCode().hasCoding()) {
            // Find any existing GTIN coding
            coding = this.getCode().getCoding().stream()
                    .filter(c -> FhirSystem.GTIN.equals(c.getSystem()))
                    .findAny()
                    .orElse(null);
        }
        if (coding == null) {
            // Otherwise, add a new coding
            coding = this.getCode().addCoding();
        }

        coding.setSystemElement(new UriType(FhirSystem.GTIN))
                .setCode(gtin)
                .setDisplay(displayName);

        if (!this.getCode().hasText()) {
            // Only set the text if it is not already set
            this.getCode().setText(displayName);
        }
        return this;
    }

    /**
     * Sets the ATC. If an ATC code already exists, it's replaced. The text is set only if it doesn't exist yet.
     *
     * @param atc         The ATC code.
     * @param displayName The name associate with ATC.
     * @return this.
     */
    public ChEmedEprMedication setAtc(final String atc,
                                      final String displayName) {
        Coding coding = null;
        if (this.hasCode() && this.getCode().hasCoding()) {
            // Find any existing ATC coding
            coding = this.getCode().getCoding().stream()
                    .filter(c -> FhirSystem.ATC.equals(c.getSystem()))
                    .findAny()
                    .orElse(null);
        }
        if (coding == null) {
            // Otherwise, add a new coding
            coding = this.getCode().addCoding();
        }

        coding.setSystemElement(new UriType(FhirSystem.ATC))
                .setCode(atc)
                .setDisplay(displayName);

        if (!this.getCode().hasText()) {
            // Only set the text if it is not already set
            this.getCode().setText(displayName);
        }
        return this;
    }

    /**
     * Returns whether GTIN code exists.
     *
     * @return {@code true} if the GTIN code exists, {@code false} otherwise.
     */
    public boolean hasGtin() {
        return hasCodeForSystem(FhirSystem.GTIN);
    }

    /**
     * Returns whether ATC code exists.
     *
     * @return {@code true} if the ATC code exists, {@code false} otherwise.
     */
    public boolean hasAtc() {
        return hasCodeForSystem(FhirSystem.ATC);
    }

    /**
     * Returns whether the medication coding contains a code for the specified system.
     * @param system The system for which to check if a code exists.
     * @return {@code true} if the ATC code exists, {@code false} otherwise.
     */
    public boolean hasCodeForSystem(final String system) {
        if (!this.hasCode() || !this.getCode().hasCoding()) return false;
        return this.getCode().getCoding().stream().anyMatch(coding -> system.equals(coding.getSystem()));
    }

    /**
     * Returns the pharmaceutical dose form or throws.
     *
     * @return the pharmaceutical dose form.
     * @throws InvalidEmedContentException if the pharmaceutical dose form is missing.
     */
    @ExpectsValidResource
    public PharmaceuticalDoseFormEdqm resolveForm() throws InvalidEmedContentException {
        if (!this.hasForm()) throw new InvalidEmedContentException("The form is not specified");

        final var edqmForm = PharmaceuticalDoseFormEdqm.getEnum(this.getForm().getCodingFirstRep().getCode());
        if (edqmForm == null)
            throw new InvalidEmedContentException(
                    "The form is not referenced in the value set PharmaceuticalDoseFormEDQM");

        return edqmForm;
    }

    /**
     * Resolves the active ingredients
     *
     * @return the lits with active ingredients
     */
    @ExpectsValidResource
    public List<ChEmedEprMedicationIngredient> resolveActiveIngredients() {
        return this.getIngredient().stream()
                .filter(MedicationIngredientComponent::getIsActive)
                .map(ingredient -> {
                    if (ingredient instanceof ChEmedEprMedicationIngredient chEmedEprIngredient) return  chEmedEprIngredient;
                    else return new ChEmedEprMedicationIngredient(ingredient);
                })
                .toList();
    }

    /**
     * Sets pharmaceutical dose form. If the pharmaceutical dose form already exists, it's replaced.
     *
     * @param doseForm the pharmaceutical dose form.
     * @return this.
     */
    public ChEmedEprMedication setForm(final PharmaceuticalDoseFormEdqm doseForm) {
        this.setForm(doseForm.getCodeableConcept());
        return this;
    }

    /**
     * Adds active ingredient.
     *
     * @param ingredient active ingredient.
     * @return this.
     */
    public ChEmedEprMedication addActiveIngredient(final ChEmedEprMedicationIngredient ingredient) {
        super.addIngredient(ingredient);
        return this;
    }

    /**
     * Resolves the package size.
     *
     * @return the package size.
     * @throws InvalidEmedContentException if the package size is missing or of the wrong type.
     */
    @Nullable
    public ChEmedRatioWithEmedUnits resolveAmount() {
        if (!this.hasAmount()) {
            return null;
        }
        if (this.getAmount() instanceof ChEmedRatioWithEmedUnits chRatio) {
            return chRatio;
        }
        final var chRatio = new ChEmedRatioWithEmedUnits();
        this.getAmount().copyValues(chRatio);
        return chRatio;
    }

    @Override
    public ChEmedEprMedication copy() {
        final var copy = new ChEmedEprMedication();
        this.copyValues(copy);
        return copy;
    }
}
