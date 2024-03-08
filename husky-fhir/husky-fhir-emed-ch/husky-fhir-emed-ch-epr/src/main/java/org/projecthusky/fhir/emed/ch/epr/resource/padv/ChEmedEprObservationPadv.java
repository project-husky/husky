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
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-observation")
public class ChEmedEprObservationPadv extends ChEmedEprObservation<ChEmedEprMedicationStatementChanged> {

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

    @Override
    protected Class<ChEmedEprMedicationStatementChanged> getMedicationStatementChangedType() {
        return ChEmedEprMedicationStatementChanged.class;
    }

    @Override
    public ChEmedEprObservationPadv copy() {
        final var copy = new ChEmedEprObservationPadv();
        this.copyValues(copy);
        return copy;
    }
}
