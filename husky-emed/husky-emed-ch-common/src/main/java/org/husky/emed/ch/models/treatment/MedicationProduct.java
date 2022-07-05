/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.models.treatment;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.PharmaceuticalDoseFormEdqm;
import org.husky.emed.ch.models.common.QuantityWithRegularUnit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A data structure about a medication product.
 *
 * @author Quentin Ligier
 */
public class MedicationProduct {

    /**
     * The medication code in the GTIN system or {@code null}.
     */
    @Nullable
    private String gtinCode;

    /**
     * The medication code in the ATC system or {@code null}.
     */
    @Nullable
    private String atcCode;

    /**
     * The medication name or {@code null}.
     */
    @Nullable
    private String name;

    /**
     * The lot number or {@code null} if it's not known.
     */
    @Nullable
    private String lotNumber;

    /**
     * The form code or {@code null} if it's not known.
     */
    @Nullable
    private PharmaceuticalDoseFormEdqm formCode;

    /**
     * The expiration date or {@code null} if it's not known.
     */
    @Nullable
    private LocalDate expirationDate;

    /**
     * The packaging code or {@code null}. It is given in the GTIN system.
     */
    @Nullable
    private String packageGtinCode;

    /**
     * The packaging name or {@code null}.
     */
    @Nullable
    private String packageName;

    /**
     * The packaging form code or {@code null}.
     */
    @Nullable
    private PharmaceuticalDoseFormEdqm packageFormCode;

    /**
     * The capacity of the packaging.
     */
    @Nullable
    private QuantityWithRegularUnit packageCapacityQuantity;

    /**
     * The list of active ingredients.
     */
    private final List<@NonNull MedicationProductIngredient> ingredients = new ArrayList<>();

    /**
     * Constructor without packaging information.
     */
    public MedicationProduct(@Nullable final String gtinCode,
                             @Nullable final String atcCode,
                             @Nullable final String name,
                             @Nullable final String lotNumber,
                             @Nullable final PharmaceuticalDoseFormEdqm formCode,
                             @Nullable final LocalDate expirationDate,
                             @Nullable final List<@NonNull MedicationProductIngredient> ingredients) {
        this.gtinCode = gtinCode;
        this.atcCode = atcCode;
        this.name = name;
        this.lotNumber = lotNumber;
        this.formCode = formCode;
        this.expirationDate = expirationDate;
        if (ingredients != null) {
            this.ingredients.addAll(ingredients);
        }
    }

    /**
     * Constructor with packaging information.
     */
    public MedicationProduct(@Nullable final String gtinCode,
                             @Nullable final String atcCode,
                             @Nullable final String name,
                             @Nullable final String lotNumber,
                             @Nullable final PharmaceuticalDoseFormEdqm formCode,
                             @Nullable final LocalDate expirationDate,
                             @Nullable final String packageGtinCode,
                             @Nullable final String packageName,
                             @Nullable final PharmaceuticalDoseFormEdqm packageFormCode,
                             @Nullable final QuantityWithRegularUnit packageCapacityQuantity,
                             @Nullable final List<@NonNull MedicationProductIngredient> ingredients) {
        this.gtinCode = gtinCode;
        this.atcCode = atcCode;
        this.name = name;
        this.lotNumber = lotNumber;
        this.formCode = formCode;
        this.expirationDate = expirationDate;
        this.packageGtinCode = packageGtinCode;
        this.packageName = packageName;
        this.packageFormCode = packageFormCode;
        this.packageCapacityQuantity = packageCapacityQuantity;
        if (ingredients != null) {
            this.ingredients.addAll(ingredients);
        }
    }

    @Nullable
    public String getGtinCode() {
        return gtinCode;
    }

    public void setGtinCode(@Nullable final String gtinCode) {
        this.gtinCode = gtinCode;
    }

    @Nullable
    public String getAtcCode() {
        return atcCode;
    }

    public void setAtcCode(@Nullable final String atcCode) {
        this.atcCode = atcCode;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable final String name) {
        this.name = name;
    }

    @Nullable
    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(@Nullable final String lotNumber) {
        this.lotNumber = lotNumber;
    }

    @Nullable
    public PharmaceuticalDoseFormEdqm getFormCode() {
        return formCode;
    }

    public void setFormCode(@Nullable final PharmaceuticalDoseFormEdqm formCode) {
        this.formCode = formCode;
    }

    @Nullable
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(@Nullable final LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Nullable
    public String getPackageGtinCode() {
        return packageGtinCode;
    }

    public void setPackageGtinCode(@Nullable final String packageGtinCode) {
        this.packageGtinCode = packageGtinCode;
    }

    @Nullable
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(@Nullable final String packageName) {
        this.packageName = packageName;
    }

    @Nullable
    public PharmaceuticalDoseFormEdqm getPackageFormCode() {
        return packageFormCode;
    }

    public void setPackageFormCode(@Nullable final PharmaceuticalDoseFormEdqm packageFormCode) {
        this.packageFormCode = packageFormCode;
    }

    @Nullable
    public QuantityWithRegularUnit getPackageCapacityQuantity() {
        return packageCapacityQuantity;
    }

    public void setPackageCapacityQuantity(@Nullable final QuantityWithRegularUnit packageCapacityQuantity) {
        this.packageCapacityQuantity = packageCapacityQuantity;
    }

    public List<MedicationProductIngredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicationProduct)) return false;
        final MedicationProduct that = (MedicationProduct) o;
        return Objects.equals(gtinCode, that.gtinCode) && Objects.equals(atcCode, that.atcCode) && Objects.equals(name, that.name) && Objects.equals(lotNumber, that.lotNumber) && formCode == that.formCode && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(packageGtinCode, that.packageGtinCode) && Objects.equals(packageName, that.packageName) && packageFormCode == that.packageFormCode && Objects.equals(packageCapacityQuantity, that.packageCapacityQuantity) && Objects.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gtinCode, atcCode, name, lotNumber, formCode, expirationDate, packageGtinCode,
                packageName, packageFormCode, packageCapacityQuantity, ingredients);
    }

    @Override
    public String toString() {
        return "MedicationProduct{" +
                "gtinCode='" + gtinCode + '\'' +
                ", atcCode='" + atcCode + '\'' +
                ", name='" + name + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                ", formCode=" + formCode +
                ", expirationDate='" + expirationDate + '\'' +
                ", packageGtinCode='" + packageGtinCode + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageFormCode=" + packageFormCode +
                ", packageCapacityQuantity=" + packageCapacityQuantity +
                ", ingredients=" + ingredients +
                '}';
    }
}
