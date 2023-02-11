package org.projecthusky.fhir.emed.ch.epr.resource.padv;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.emed.ch.common.enums.EmedPadvEntryType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprObservation;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR Observation (PADV).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "https://fhir.cara.ch/StructureDefinition/ch-emed-epr-observation")
public class ChEmedEprObservationPadv extends ChEmedEprObservation {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprObservationPadv() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication statement id.
     * @param padvType  The pharmaceutical advice type.
     */
    public ChEmedEprObservationPadv(final UUID entryUuid,
                                    final EmedPadvEntryType padvType) {
        super(entryUuid, padvType);
    }
}
