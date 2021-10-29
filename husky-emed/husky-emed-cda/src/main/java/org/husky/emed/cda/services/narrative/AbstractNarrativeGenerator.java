package org.husky.emed.cda.services.narrative;

import org.husky.common.model.enums.ValueSetEnumInterface;
import org.husky.emed.cda.models.treatment.MedicationPackagedProduct;
import org.husky.emed.cda.models.treatment.MedicationProduct;

import java.util.Objects;
import java.util.Optional;
import java.util.PropertyResourceBundle;

public abstract class AbstractNarrativeGenerator {

    protected final NarrativeLanguage lang;

    protected final PropertyResourceBundle bundle = null;

    protected AbstractNarrativeGenerator(final NarrativeLanguage lang) {
        this.lang = Objects.requireNonNull(lang);
    }

    protected void getDateFormatter() {

    }

    protected String getEnumNarrative(final ValueSetEnumInterface valueSet) {
        return valueSet.getDisplayName(this.lang.getLanguageCode());
    }

    protected String getMedicationName(final MedicationProduct product,
                                       final boolean isHtml) {
        final var name = Optional.ofNullable(product.getName()).orElse(
                Optional.ofNullable(product.getPackagedProduct()).map(MedicationPackagedProduct::getName).orElse(null)
        );
        final var gtin = Optional.ofNullable(product.getGtinCode()).orElse(
                Optional.ofNullable(product.getPackagedProduct()).map(MedicationPackagedProduct::getGtinCode).orElse(null)
        );
        if (name != null && gtin != null) {
            final var format = isHtml ? "%s<span class=\"gtin\">%s</span>" : "%s (%s)";
            return String.format(format, name, gtin);
        }
        final var magistral = "Préparation magistrale";
        if (name != null) {
            return String.format("%s (%s)", name, magistral);
        }
        return magistral;
    }
}
