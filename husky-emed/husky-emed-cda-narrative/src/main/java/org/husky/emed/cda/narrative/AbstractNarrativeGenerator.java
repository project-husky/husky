/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.narrative;

import java.util.Objects;
import java.util.Optional;
import java.util.PropertyResourceBundle;

import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.emed.models.treatment.MedicationPackagedProduct;
import org.husky.emed.models.treatment.MedicationProduct;

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
