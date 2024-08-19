package org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum MedicamentIdType implements EMediplanEnum {
    NONE("1"),
    /**
     * Global Trade Item Number
     */
    GTIN("2"),
    /**
     * Pharmacode used to be the main article identifier in the INDEX proprietary database managed by HCI Solutions AG.
     * This is now deprecated in favour of GTIN identifiers.
     */
    PHARMACODE("3"),
    /**
     * This is the INDEX proprietary database assigned identifier for products, and it is managed by HCI Solutions AG.
     */
    PRODUCT_NUMBER("4");

    @JsonValue
    private final String code;

    MedicamentIdType(String code) {
        this.code = code;
    }
}
