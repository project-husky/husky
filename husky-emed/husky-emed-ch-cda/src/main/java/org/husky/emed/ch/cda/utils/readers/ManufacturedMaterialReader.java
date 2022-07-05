/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.utils.readers;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.COCTMT230100UVIngredient;
import org.husky.common.hl7cdar2.POCDMT000040Material;
import org.husky.common.utils.time.DateTimes;
import org.husky.emed.ch.cda.utils.CdaR2Utils;
import org.husky.emed.ch.enums.ActivePharmaceuticalIngredient;
import org.husky.emed.ch.enums.PharmaceuticalDoseFormEdqm;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.QuantityWithRegularUnit;
import org.husky.emed.ch.models.treatment.MedicationProduct;
import org.husky.emed.ch.models.treatment.MedicationProductIngredient;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/**
 * A reader for CDA-CH-EMED manufactured material.
 *
 * @author Quentin Ligier
 */
public class ManufacturedMaterialReader {

    /**
     * The CDA-CH-EMED manufactured material.
     */
    private final POCDMT000040Material material;

    /**
     * Constructor.
     *
     * @param material The CDA-CH-EMED manufactured material.
     */
    public ManufacturedMaterialReader(final POCDMT000040Material material) {
        this.material = Objects.requireNonNull(material);
    }

    /**
     * Returns the GTIN code value or {@code null} if it's not specified.
     */
    @Nullable
    public String getGtinCode() {
        return Optional.ofNullable(this.material.getCode())
                .filter(ce -> CodeSystems.GTIN.getCodeSystemId().equals(ce.getCodeSystem()))
                .map(CD::getCode)
                .orElse(null);
    }

    /**
     * Returns the ATC code value or {@code null} if it's not specified.
     */
    @Nullable
    public String getAtcCode() {
        return Optional.ofNullable(this.material.getCode())
                .filter(ce -> CodeSystems.WHO_ATC_CODE.getCodeSystemId().equals(ce.getCodeSystem()))
                .map(CD::getCode)
                .orElse(null);
    }

    /**
     * Returns the name or {@code null} if it's not specified.
     */
    @Nullable
    public String getName() {
        if (this.material.getName() == null) {
            throw new InvalidEmedContentException("The manufactured material name is missing");
        }
        final String name = this.material.getName().getMergedXmlMixed();
        return (name.isBlank()) ? null : name;
    }

    /**
     * Returns the form code as a value of {@link PharmaceuticalDoseFormEdqm} or {@code null} if it's not defined.
     */
    @Nullable
    public PharmaceuticalDoseFormEdqm getFormCode() throws InvalidEmedContentException {
        if (this.material.getFormCode() == null) {
            return null;
        }
        if (!PharmaceuticalDoseFormEdqm.isInValueSet(this.material.getFormCode().getCode())) {
            throw new InvalidEmedContentException("The formCode is not given in the mandatory value set");
        }
        return PharmaceuticalDoseFormEdqm.getEnum(this.material.getFormCode().getCode());
    }

    /**
     * Returns the lot number text or {@code null} if it's not defined.
     */
    @Nullable
    public String getLotNumberText() {
        return Optional.ofNullable(this.material.getLotNumberText()).map(CdaR2Utils::getSingleNullableMixedOrThrow).orElse(null);
    }

    /**
     * Returns the expiration date or {@code null} if it's not defined.
     */
    @Nullable
    public LocalDate getExpirationDate() {
        return Optional.ofNullable(this.material.getExpirationTime())
                .map(DateTimes::toLocalDate)
                .orElse(null);
    }

    /**
     * Returns the packaging of the medicine or {@code null} if it's not defined.
     */
    @Nullable
    public ContainerPackagedMedicineReader getPackagedMedicine() {
        if (this.material.getAsContent() == null || this.material.getAsContent().getContainerPackagedMedicine() == null) {
            return null;
        }
        return new ContainerPackagedMedicineReader(this.material.getAsContent().getContainerPackagedMedicine());
    }

    /**
     * Converts the ManufacturedMaterial to a {@link MedicationProduct}.
     */
    public MedicationProduct toMedicationProduct() throws InvalidEmedContentException {
        final MedicationProduct product = new MedicationProduct(
                this.getGtinCode(),
                this.getAtcCode(),
                this.getName(),
                this.getLotNumberText(),
                this.getFormCode(),
                this.getExpirationDate(),
                null
        );

        final ContainerPackagedMedicineReader packagedMedicine = this.getPackagedMedicine();
        if (packagedMedicine != null) {
            product.setPackageGtinCode(packagedMedicine.getGtinCode());
            product.setPackageName(packagedMedicine.getName());
            product.setPackageFormCode(packagedMedicine.getFormCode());
            product.setPackageCapacityQuantity(packagedMedicine.getCapacityQuantity());
        }

        product.getIngredients().addAll(this.material.getIngredient().stream()
                .filter(ingredient -> ingredient.getIngredient() != null)
                .filter(ingredient -> ingredient.getIngredient().getValue() != null)
                .map((COCTMT230100UVIngredient ingredient) -> {
                    final String name =
                            CdaR2Utils.getSingleNullableMixedOrThrow(ingredient.getIngredient().getValue().getName().get(0));
                    final var code =
                            this.activePharmaceuticalIngredientFromCdOrNull(ingredient.getIngredient().getValue().getCode());

                    QuantityWithRegularUnit numerator = null;
                    QuantityWithRegularUnit denominator = null;
                    if (ingredient.getQuantity() != null) {
                        if (ingredient.getQuantity().getNumerator() != null) {
                            numerator = QuantityWithRegularUnit.fromPq(ingredient.getQuantity().getNumerator());
                        }
                        if (ingredient.getQuantity().getDenominator() != null) {
                            denominator = QuantityWithRegularUnit.fromPq(ingredient.getQuantity().getDenominator());
                        }
                    }
                    return new MedicationProductIngredient(name, numerator, denominator, code);
                }).toList()
        );

        return product;
    }

    /**
     * Returns an instance of {@link ActivePharmaceuticalIngredient} corresponding to an HL7R2 {@link CD} or {@code
     * null}.
     *
     * @param cd The code to convert or {@code null}.
     * @return an instance of {@link ActivePharmaceuticalIngredient} or {@code null}.
     */
    @Nullable
    private ActivePharmaceuticalIngredient activePharmaceuticalIngredientFromCdOrNull(@Nullable final CD cd) {
        if (cd == null) {
            return null;
        }
        final var activePharmaceuticalIngredient = ActivePharmaceuticalIngredient.getEnum(cd.getCode());
        if (activePharmaceuticalIngredient == null
                || !activePharmaceuticalIngredient.getCodeSystemId().equals(cd.getCodeSystem())
        ) {
            return null;
        }
        return activePharmaceuticalIngredient;
    }
}
