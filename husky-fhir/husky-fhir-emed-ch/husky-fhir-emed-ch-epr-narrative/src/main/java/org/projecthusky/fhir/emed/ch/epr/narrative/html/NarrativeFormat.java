package org.projecthusky.fhir.emed.ch.epr.narrative.html;

public enum NarrativeFormat {
    /**
     * CARA's own paper layout.
     */
    CH_EMED_EPR,
    /**
     * Umbrella code for an eMediplan paper layout. This could be either CHMED16A or CHMED23A.
     */
    EMEDIPLAN,
    /**
     * Specifically CHMED16A paper layout.
     */
    CHMED16A,
    /**
     * Spcecifically CHMED23A paper layout.
     */
    CHMED23A,
    /**
     * ePrescription (eRezept) paper layout.
     */
    EPRESCRIPTION
}
