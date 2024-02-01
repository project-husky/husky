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
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Medication;
import org.hl7.fhir.r4.model.UriType;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.PharmaceuticalDoseFormEdqm;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.util.List;

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
        return this.hasGtin() ? this.getCode().getCodingFirstRep().getCode() : null;
    }

    /**
     * @return The atc code or {@code null}.
     */
    @ExpectsValidResource
    @Nullable
    public String resolveAtcCode() {
        return this.hasAtc() ? this.getCode().getCodingFirstRep().getCode() : null;
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
     * Sets the GTIN.  If a code already exists, it's replaced.
     *
     * @param gtin        The GTIN code.
     * @param displayName The name associate with GTIN.
     * @return this.
     */
    public ChEmedEprMedication setGtin(final String gtin,
                                       final String displayName) {

        final var system = new UriType(FhirSystem.GTIN);
        final var coding = new Coding()
                .setSystemElement(system)
                .setCode(gtin)
                .setDisplay(displayName);

        final var code = new CodeableConcept(coding).setText(displayName);

        this.setCode(code);

        return this;
    }

    /**
     * Sets the ATC. If a code already exists, it's replaced.
     *
     * @param atc         The ATC code.
     * @param displayName The name associate with ATC.
     * @return this.
     */
    public ChEmedEprMedication setAtc(final String atc,
                                      final String displayName) {
        final var system = new UriType(FhirSystem.ATC);
        final var coding = new Coding()
                .setSystemElement(system)
                .setCode(atc)
                .setDisplay(displayName);

        final var code = new CodeableConcept(coding).setText(displayName);

        this.setCode(code);

        return this;
    }

    /**
     * Returns whether GTIN code exists.
     *
     * @return {@code true} if the GTIN code exists, {@code false} otherwise.
     */
    public boolean hasGtin() {
        if (!this.hasCode() || !this.getCode().hasCoding()) return false;
        return this.getCode().getCodingFirstRep().getSystem().equals(FhirSystem.GTIN);
    }

    /**
     * Returns whether ATC code exists.
     *
     * @return {@code true} if the ATC code exists, {@code false} otherwise.
     */
    public boolean hasAtc() {
        if (!this.hasCode() || !this.getCode().hasCoding()) return false;
        return this.getCode().getCodingFirstRep().getSystem().equals(FhirSystem.ATC);
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
                .filter(ChEmedEprMedicationIngredient.class::isInstance)
                .map(ChEmedEprMedicationIngredient.class::cast)
                .toList();
    }

    /**
     * Sets pharmaceutical dose form. If the pharmaceutical dose form already exists, it's replaced.
     *
     * @param doseForm the pharmaceutical dose form.
     * @return this.
     */
    public ChEmedEprMedication setForm(final PharmaceuticalDoseFormEdqm doseForm) {
        final var system = UriType.fromOid(doseForm.getCodeSystemId());

        final var coding = new Coding()
                .setSystemElement(system)
                .setCode(doseForm.getCodeValue())
                .setDisplay(doseForm.getDisplayName());

        this.setForm(new CodeableConcept(coding));
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

    @Override
    public ChEmedEprMedication copy() {
        final var copy = new ChEmedEprMedication();
        this.copyValues(copy);
        return copy;
    }
}
