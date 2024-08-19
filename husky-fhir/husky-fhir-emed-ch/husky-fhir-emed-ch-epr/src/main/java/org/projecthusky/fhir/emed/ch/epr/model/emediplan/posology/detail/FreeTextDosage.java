package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;

/**
 * Describes an unstructured dosage consisting of free text.
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class FreeTextDosage extends PosologyDetail {
    /**
     * Free text describing the dosage if it cannot be expressed in a structured manner. It should not be empty.
     */
    protected String text;

    public FreeTextDosage() {
        super(PosologyType.FREE_TEXT);
    }

    public FreeTextDosage(final String text) {
        this();
        this.text = text;
    }
}
