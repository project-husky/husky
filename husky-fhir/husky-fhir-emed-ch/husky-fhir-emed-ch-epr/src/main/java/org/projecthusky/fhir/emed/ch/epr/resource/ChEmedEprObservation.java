package org.projecthusky.fhir.emed.ch.epr.resource;

import org.hl7.fhir.r4.model.Observation;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EmedPadvEntryType;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR Observation.
 *
 * @author Ronaldo Loureiro
 **/
public abstract class ChEmedEprObservation extends Observation implements ChEmedEprEntry {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprObservation() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication statement id.
     * @param padvType  The pharmaceutical advice type.
     */
    public ChEmedEprObservation(final UUID entryUuid,
                                final EmedPadvEntryType padvType) {
        super();
        this.setStatus(ObservationStatus.FINAL);
        this.addIdentifier().setValue(Uuids.URN_PREFIX + entryUuid).setSystem(FhirSystem.URI);
        this.getCode().getCodingFirstRep().setCode(padvType.name()); // TODO: EmedPadvEntryType shall be a FhirValueSetEnumInterface
    }

    /**
     * Resolves the observation UUID or throws.
     *
     * @return the observation UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing.");
        return Uuids.parseUrnEncoded(this.getIdentifierFirstRep().getValue());
    }

}
