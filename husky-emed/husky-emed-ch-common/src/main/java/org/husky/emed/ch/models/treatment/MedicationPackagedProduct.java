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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.PharmaceuticalDoseFormEdqm;
import org.husky.emed.ch.models.common.QuantityWithRegularUnit;

import java.util.Objects;

/**
 * A data structure about the packaging of a medication product.
 *
 * @author Quentin Ligier
 */
public class MedicationPackagedProduct {

    /**
     * The packaging code or {@code null}. It is given in the GTIN system.
     */
    @Nullable
    private String gtinCode;

    /**
     * The packaging name or {@code null}.
     */
    @Nullable
    private String name;

    /**
     * The form code or {@code null}.
     */
    @Nullable
    private PharmaceuticalDoseFormEdqm formCode;

    /**
     * The capacity of the packaging.
     */
    @Nullable
    private QuantityWithRegularUnit capacityQuantity;

    /**
     * Empty constructor.
     */
    public MedicationPackagedProduct() {
    }

    /**
     * Constructor.
     *
     * @param gtinCode         The packaging code or {@code null}.
     * @param name             The packaging name or {@code null}.
     * @param formCode         The form code or {@code null}.
     * @param capacityQuantity The capacity of the packaging.
     */
    public MedicationPackagedProduct(@Nullable final String gtinCode,
                                     @Nullable final String name,
                                     @Nullable final PharmaceuticalDoseFormEdqm formCode,
                                     @Nullable final QuantityWithRegularUnit capacityQuantity) {
        this.gtinCode = gtinCode;
        this.name = name;
        this.formCode = formCode;
        this.capacityQuantity = capacityQuantity;
    }

    public String getGtinCode() {
        return this.gtinCode;
    }

    public void setGtinCode(@Nullable final String gtinCode) {
        this.gtinCode = gtinCode;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public void setName(@Nullable final String name) {
        this.name = name;
    }

    @Nullable
    public PharmaceuticalDoseFormEdqm getFormCode() {
        return this.formCode;
    }

    public void setFormCode(@Nullable final PharmaceuticalDoseFormEdqm formCode) {
        this.formCode = formCode;
    }

    @Nullable
    public QuantityWithRegularUnit getCapacityQuantity() {
        return this.capacityQuantity;
    }

    public void setCapacityQuantity(@Nullable final QuantityWithRegularUnit capacityQuantity) {
        this.capacityQuantity = capacityQuantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final MedicationPackagedProduct that)) return false;
        return Objects.equals(gtinCode, that.gtinCode)
                && Objects.equals(name, that.name)
                && formCode == that.formCode
                && Objects.equals(capacityQuantity, that.capacityQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gtinCode, name, formCode, capacityQuantity);
    }

    @Override
    public String toString() {
        return "MedicationPackagedProduct{" +
                "gtinCode='" + this.gtinCode + '\'' +
                ", name='" + this.name + '\'' +
                ", formCode=" + this.formCode +
                ", capacityQuantity=" + this.capacityQuantity +
                '}';
    }
}
