/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.models.treatment;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.cda.generated.artdecor.enums.PharmaceuticalDoseFormEdqm;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A data structure about the packaging of a medication product.
 *
 * @author Quentin Ligier
 */
@Data
@NoArgsConstructor
public class MedicationPackagedProduct {

    /**
     * The packaging code or {@code null}. It is given in the GTIN system.
     */
    @Nullable private String gtinCode;

    /**
     * The packaging name or {@code null}.
     */
    @Nullable private String name;

    /**
     * The form code or {@code null}.
     */
    @Nullable private PharmaceuticalDoseFormEdqm formCode;

    /**
     * The capacity of the packaging.
     */
    private String capacity;

    /**
     * The unit of the packaging capacity.
     */
    @Nullable private String capacityUnit;
}
