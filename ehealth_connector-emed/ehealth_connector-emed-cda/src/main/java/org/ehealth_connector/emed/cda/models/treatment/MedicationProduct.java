package org.ehealth_connector.emed.cda.models.treatment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.emed.cda.generated.artdecor.enums.PharmaceuticalDoseFormEdqm;

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
    @Nullable private String gtinCode;

    /**
     * The medication name or {@code null} if it's not known.
     */
    @Nullable private String name;

    /**
     * The lot number or {@code null} if it's not known.
     */
    @Nullable private String lotNumber;

    /**
     * The form code or {@code null} if it's not known.
     */
    @Nullable private PharmaceuticalDoseFormEdqm formCode;

    /**
     * The expiration time (specific date, specific date including time) or {@code null} if it's not known.
     */
    @Nullable private String expirationTime;

    /**
     * The packaging of the medication or {@code null}.
     */
    @Nullable private MedicationPackagedProduct packagedProduct;

    /**
     * The list of active ingredients.
     */
    private final List<MedicationProductIngredient> ingredients = new ArrayList<>();
}
