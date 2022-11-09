package org.projecthusky.fhir.emed.ch.epr.resource.dis;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Medication;
import org.hl7.fhir.r4.model.UriType;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.ActivePharmaceuticalIngredient;
import org.projecthusky.fhir.emed.ch.common.enums.PharmaceuticalDoseFormEdqm;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChEmedOrganization;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.dosage.ChEmedRatioWithEmedUnits;

/**
 * The HAPI custom structure for CH-EMED-EPR Medication (DIS).
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedEprMedicationDis extends Medication {
    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationDis() {
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
    public ChEmedEprMedicationDis setGtin(final String gtin,
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
    public ChEmedEprMedicationDis setAtc(final String atc,
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
        if (!this.hasCode() && !this.getCode().hasCoding()) return false;
        return this.getCode().getCodingFirstRep().getSystem().equals(FhirSystem.GTIN);
    }

    /**
     * Returns whether ATC code exists.
     *
     * @return {@code true} if the ATC code exists, {@code false} otherwise.
     */
    public boolean hasAtc() {
        if (!this.hasCode() && !this.getCode().hasCoding()) return false;
        return this.getCode().getCodingFirstRep().getSystem().equals(FhirSystem.ATC);
    }

    /**
     * Returns the manufacturer or throws.
     *
     * @return the manufacturer.
     * @throws InvalidEmedContentException if the manufacturer is missing.
     */
    @ExpectsValidResource
    public ChEmedOrganization resolveManufacturer() throws InvalidEmedContentException {
        if (!this.hasManufacturer()) throw new InvalidEmedContentException("The manufacturer is not specified");

        final var resource = this.getManufacturer().getResource();
        if (resource instanceof final ChEmedOrganization chManufacturer) {
            return chManufacturer;
        }
        throw new InvalidEmedContentException("The manufacturer is invalid");
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
     * Resolves the package size.
     *
     * @return the package size.
     * @throws InvalidEmedContentException if the package size is missing or of the wrong type.
     */
    @ExpectsValidResource
    public ChEmedRatioWithEmedUnits resolveAmount() throws InvalidEmedContentException {
        if (!this.hasAmount()) throw new InvalidEmedContentException("The package size is missing.");

        if (this.getAmount() instanceof ChEmedRatioWithEmedUnits chRatio) {
            return chRatio;
        }
        throw new InvalidEmedContentException("The package size isn't of the right type.");
    }

    /**
     * Sets pharmaceutical dose form. If the pharmaceutical dose form already exists, it's replaced.
     *
     * @param doseForm the pharmaceutical dose form.
     * @return this.
     */
    public ChEmedEprMedicationDis setForm(final PharmaceuticalDoseFormEdqm doseForm) {
        final var system = UriType.fromOid(doseForm.getCodeSystemId());

        final var coding = new Coding()
                .setSystemElement(system)
                .setCode(doseForm.getCodeValue())
                .setDisplay(doseForm.getDisplayName());

        this.setForm(new CodeableConcept(coding));
        return this;
    }

    /**
     * Sets the package size.
     *
     * @param amount the package size.
     * @return this.
     */
    public ChEmedEprMedicationDis setAmount(final ChEmedRatioWithEmedUnits amount) {
        super.setAmount(amount);
        return this;
    }

    /**
     * Adds active ingredient.
     *
     * @param activeIngredient active ingredient.
     * @return this.
     */
    public ChEmedEprMedicationDis addIngredient(final ActivePharmaceuticalIngredient activeIngredient,
                                             @Nullable final ChEmedRatioWithEmedUnits strength) {
        final var coding = new Coding()
                .setSystemElement(UriType.fromOid(activeIngredient.getCodeSystemId()))
                .setCode(activeIngredient.getCodeValue())
                .setDisplay(activeIngredient.getDisplayName());

        final var item = new CodeableConcept(coding)
                .setText(activeIngredient.getDisplayName());

        this.addIngredient()
                .setIsActive(true)
                .setItem(item)
                .setStrength(strength);

        return this;
    }
}
