package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Block;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;

import java.util.UUID;


/**
 * The HAPI custom structure for CH-EMED-Ext Prescription. Extension to represent the reference to the Medication
 * Prescription document. URL : <a
 * href="https://build.fhir.org/ig/hl7ch/ch-emed//StructureDefinition-ch-emed-ext-prescription.html">...</a>
 *
 * @author Ronaldo Loureiro
 */
@Block
public class ChEmedExtPrescription extends ChEmedExtensionReference {

    /**
     * Empty constructor
     */
    public ChEmedExtPrescription() {
        super();
    }

    /**
     * Constructor
     *
     * @param id                 the ID of the Medication Prescription document.
     * @param externalDocumentId the ID of the external document.
     */
    public ChEmedExtPrescription(final UUID id,
                                 final UUID externalDocumentId) {
        super();
        this.setIdentifier(id);
        this.setExternalDocumentId(externalDocumentId);
    }

    @Override
    public ChEmedExtPrescription copy() {
        final var copy = new ChEmedExtPrescription();
        copy.identifier = identifier;
        copy.externalDocumentId = externalDocumentId;
        return copy;
    }

    @Override
    public EmedEntryType getEntryType() {
        return EmedEntryType.PRE;
    }
}
