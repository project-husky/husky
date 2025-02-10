package org.projecthusky.communication.xdsmhdconversion.converters;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Extension;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.projecthusky.common.ch.ChEpr;
import org.projecthusky.common.utils.datatypes.Oids;

import java.util.Collections;

/**
 * A A converter between XDS' DocumentEntry and MHD's DocumentReference customized to the
 * <a href="https://fhir.ch/ig/ch-epr-fhir/index.html">CH EPR FHIR</a> IG specs.
 *
 * @see <a
 * href="http://fhir.ch/ig/ch-epr-fhir/StructureDefinition/ch-mhd-documentreference-comprehensive">Resource
 * Profile: CH MHD DocumentReference Comprehensive</a>
 */
public class ChEprFhirDocumentEntryConverter extends DocumentEntryConverter {
    protected ChEprFhirDocumentEntryConverter() {}

    /**
     * Convert an XDS DocumentEntry to an MHD DocumentReference.
     *
     * @param documentEntry The XDS DocumentEntry to convert.
     * @return the equivalent MHD DocumentReference.
     */
    public static DocumentReference convertDocumentEntry(final DocumentEntry documentEntry) {
        return DocumentEntryConverter.convertDocumentEntry(documentEntry);
    }

    /**
     * Convert an MHD DocumentReference to an XDS DocumentEntry.
     *
     * @param documentReference The MHD DocumentReference to convert.
     * @return the equivalent XDS DocumentEntry.
     */
    public static DocumentEntry convertDocumentReference(final DocumentReference documentReference) {
        final var documentEntry = DocumentEntryConverter.convertDocumentReference(documentReference);

        documentReference.getMeta().addProfile("http://fhir.ch/ig/ch-epr-fhir/StructureDefinition/ch-mhd-documentreference-comprehensive");

        // deletionStatus
        final Extension deletionStatus = documentReference.getExtensionByUrl("http://fhir.ch/ig/ch-epr-fhir/StructureDefinition/ch-ext-deletionstatus");
        if (deletionStatus != null && deletionStatus.getValue() instanceof Coding coding)
            documentEntry.getExtraMetadata().put(ChEpr.DELETION_STATUS_URN, Collections.singletonList(coding.getCode()));

        // originalProviderRole
        final Extension originalRole = documentReference.getExtensionByUrl("http://fhir.ch/ig/ch-epr-fhir/StructureDefinition/ch-ext-author-authorrole");
        if (originalRole != null && originalRole.getValue() instanceof final Coding coding) {
            documentEntry.getExtraMetadata().put(
                    ChEpr.ORIGINAL_PROVIDER_ROLE_URN,
                    Collections.singletonList(String.format("%s^^^&%s&ISO", coding.getCode(), Oids.normalize(coding.getSystem())))
            );
        }

        return documentEntry;
    }
}
