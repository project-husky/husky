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

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.PharmaceuticalDoseFormEdqm;

import java.util.ArrayList;
import java.util.List;

/**
 * A data structure about a medication product.
 *
 * @author Quentin Ligier
 */
@Data
@NoArgsConstructor
public class MedicationProduct {

    /**
     * The medication code or {@code null} if it's a magistral preparation/compound medicine. It is given in the GTIN
     * system.
     */
    @Nullable
    private String gtinCode;

    /**
     * The medication name or {@code null} if it's not known.
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
     * The expiration time (specific date, specific date including time) or {@code null} if it's not known.
     */
    @Nullable
    private String expirationTime;

    /**
     * The packaging of the medication or {@code null}.
     */
    @Nullable
    private MedicationPackagedProduct packagedProduct;

    /**
     * The list of active ingredients.
     */
    private final List<@NonNull MedicationProductIngredient> ingredients = new ArrayList<>();
}
