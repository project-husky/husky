package org.ehealth_connector.emed.cda.models.treatment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.emed.cda.generated.artdecor.enums.PharmaceuticalDoseFormEdqm;

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
