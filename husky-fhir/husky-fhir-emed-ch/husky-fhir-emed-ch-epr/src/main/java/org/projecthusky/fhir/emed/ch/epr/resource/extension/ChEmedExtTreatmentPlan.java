package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Block;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-Ext TreatmentPlan. Extension to represent the reference to the Medication
 * Treatment Plan document. URL : <a
 * href="https://build.fhir.org/ig/hl7ch/ch-emed//StructureDefinition-ch-emed-ext-treatmentplan.html">...</a>
 *
 * @author Ronaldo Loureiro
 */
@Block
public class ChEmedExtTreatmentPlan extends ChEmedExtensionReference {

    /**
     * Empty constructor
     */
    public ChEmedExtTreatmentPlan() {
        super();
    }

    /**
     * Constructor
     *
     * @param id                 the ID of the Medication Treatment Plan document.
     * @param externalDocumentId the ID of the external document.
     */
    public ChEmedExtTreatmentPlan(final UUID id,
                                  final UUID externalDocumentId) {
        super();
        this.setExtensionId(id);
        this.setExternalDocumentId(externalDocumentId);
    }

    @Override
    public ChEmedExtTreatmentPlan copy() {
        final var copy = new ChEmedExtTreatmentPlan();
        copy.extensionId = extensionId;
        copy.externalDocumentId = externalDocumentId;
        return copy;
    }

    @Override
    public EmedEntryType getEntryType() {
        return EmedEntryType.MTP;
    }
}
