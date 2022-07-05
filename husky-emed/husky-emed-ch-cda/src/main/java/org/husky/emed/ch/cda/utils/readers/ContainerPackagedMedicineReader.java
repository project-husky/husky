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
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.enums.PharmaceuticalDoseFormEdqm;
import org.husky.common.hl7cdar2.COCTMT230100UVPackagedMedicine;
import org.husky.emed.ch.models.common.QuantityWithRegularUnit;

import java.util.Objects;

/**
 * A reader of the {@link COCTMT230100UVPackagedMedicine} resource in a CDA-CH-EMED document.
 *
 * @author Quentin Ligier
 */
public class ContainerPackagedMedicineReader {

    /**
     * The original {@link COCTMT230100UVPackagedMedicine} element.
     */
    private final COCTMT230100UVPackagedMedicine packagedMedicine;

    /**
     * Constructor.
     *
     * @param packagedMedicine The original {@link COCTMT230100UVPackagedMedicine} element.
     */
    public ContainerPackagedMedicineReader(final COCTMT230100UVPackagedMedicine packagedMedicine) {
        Objects.requireNonNull(packagedMedicine);
        this.packagedMedicine = packagedMedicine;
    }

    /**
     * Returns the GTIN code value or {@code null} if it's not specified.
     */
    @Nullable
    public String getGtinCode() {
        if (this.packagedMedicine.getCode() == null) {
            throw new InvalidEmedContentException("The packaged medicine code is missing");
        }
        return this.packagedMedicine.getCode().getCode();
    }

    /**
     * Returns the name or {@code null} if it doesn't exist.
     */
    @Nullable
    public String getName() {
        return (!this.packagedMedicine.getName().isEmpty()) ?
                this.packagedMedicine.getName().get(0).getMergedXmlMixed() :
                null;
    }

    /**
     * Returns the form code as a value of {@link PharmaceuticalDoseFormEdqm} or {@code null} if it's not defined.
     */
    @Nullable
    public PharmaceuticalDoseFormEdqm getFormCode() throws InvalidEmedContentException {
        if (this.packagedMedicine.getFormCode() == null) {
            return null;
        }
        if (!PharmaceuticalDoseFormEdqm.isInValueSet(this.packagedMedicine.getFormCode().getCode())) {
            throw new InvalidEmedContentException("The formCode is not given in the mandatory value set");
        }
        return PharmaceuticalDoseFormEdqm.getEnum(this.packagedMedicine.getFormCode().getCode());
    }

    /**
     * Returns the capacity quantity or {@code null} if it's not defined.
     */
    @Nullable
    public QuantityWithRegularUnit getCapacityQuantity() {
        return (this.packagedMedicine.getCapacityQuantity() != null)
                ? QuantityWithRegularUnit.fromPq(this.packagedMedicine.getCapacityQuantity())
                : null;
    }
}
