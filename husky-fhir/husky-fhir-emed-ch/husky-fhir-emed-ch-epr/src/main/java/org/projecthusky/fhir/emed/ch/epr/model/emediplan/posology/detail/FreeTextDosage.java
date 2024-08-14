package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

/**
 * Describes an unstructured dosage consisting of free text.
 */
public class FreeTextDosage extends PosologyDetail {
    /**
     * Free text describing the dosage if it cannot be expressed in a structured manner. It should not be empty.
     */
    protected String text;
}
