package org.projecthusky.communication.xdsmhdconversion.converters;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Extension;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.projecthusky.common.ch.ChEpr;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.communication.ch.enums.stable.DeletionStatus;
import org.projecthusky.communication.ch.enums.stable.OriginalProviderRole;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/**
 * A A converter between XDS' DocumentEntry and MHD's DocumentReference customized to the
 * <a href="https://fhir.ch/ig/ch-epr-fhir/index.html">CH EPR FHIR</a> IG specs.
 *
 * @see <a
 * href="http://fhir.ch/ig/ch-epr-fhir/StructureDefinition/ch-mhd-documentreference-comprehensive">Resource
 * Profile: CH MHD DocumentReference Comprehensive</a>
 */
public class ChEprFhirDocumentEntryConverter extends DocumentEntryConverter {
    public static final String DELETION_STATUS_EXTENSION_URL = "http://fhir.ch/ig/ch-epr-fhir/StructureDefinition/ch-ext-deletionstatus";
    public static final String ORIGINAL_PROVIDER_ROLE_EXTENSION_URL = "http://fhir.ch/ig/ch-epr-fhir/StructureDefinition/ch-ext-author-authorrole";

    /**
     * Convert an XDS DocumentEntry to an MHD DocumentReference.
     *
     * @param documentEntry The XDS DocumentEntry to convert.
     * @return the equivalent MHD DocumentReference.
     */
    public DocumentReference convertDocumentEntry(final DocumentEntry documentEntry) {
        final var docRef = super.convertDocumentEntry(documentEntry);

        final var languageCode = LanguageCode.getEnum(documentEntry.getLanguageCode());

        //Fill CH EPR FHIR extensions (deletion status and original provider role)
        final var extraMetadata = documentEntry.getExtraMetadata();
        if (extraMetadata != null && !extraMetadata.isEmpty()) {
            if (extraMetadata.containsKey(ChEpr.DELETION_STATUS_URN)) {
                final var deletionStatusMetadata = extraMetadata.get(ChEpr.DELETION_STATUS_URN);
                if (deletionStatusMetadata.size() != 1)
                    throw new IllegalArgumentException(String.format("The document entry extra metadata contains an entry for '%s' but less or more than one single code.", ChEpr.DELETION_STATUS_URN));
                final var deletionStatus = Objects.requireNonNull(DeletionStatus.getEnum(deletionStatusMetadata.get(0)));
                docRef.addExtension(
                        DELETION_STATUS_EXTENSION_URL,
                        new Coding(
                                Oids.PREFIX_OID + deletionStatus.getCodeSystemId(),
                                deletionStatus.getCodeValue(),
                                deletionStatus.getDisplayName(languageCode)
                        )
                );
            }
            if (extraMetadata.containsKey(ChEpr.ORIGINAL_PROVIDER_ROLE_URN)) {
                final var originalProviderRoleMetadata = extraMetadata.get(ChEpr.ORIGINAL_PROVIDER_ROLE_URN);
                if (originalProviderRoleMetadata.size() != 1)
                    throw new IllegalArgumentException(String.format("The document entry extra metadata contains an entry for '%s' but less or more than one single code.", ChEpr.ORIGINAL_PROVIDER_ROLE_URN));
                final var parsedOriginalProviderRole = Hl7v2Based.parse(originalProviderRoleMetadata.get(0), Identifiable.class);
                final var originalProviderRoleCode = new Code(parsedOriginalProviderRole.getId(), null, parsedOriginalProviderRole.getAssigningAuthority().getUniversalId());
                final var originalProviderRole = Arrays.stream(OriginalProviderRole.values())
                        .filter(o -> o.isEqualTo(originalProviderRoleCode))
                        .findAny().orElseThrow(() -> new IllegalArgumentException("Could not convert the original provider value from the document entry extra metadata."));
                docRef.addExtension(
                        ORIGINAL_PROVIDER_ROLE_EXTENSION_URL,
                        new Coding(
                                Oids.PREFIX_OID + originalProviderRole.getCodeSystemId(),
                                originalProviderRole.getCodeValue(),
                                originalProviderRole.getDisplayName(languageCode)
                        )
                );
            }
        }

        //The date is mandatory for CH EPR FHIR document references, set it to the document entry creation time by default.
        // The enforcement of the date cardinality to 1 will be lifted as this was a mistake, see https://github.com/hl7ch/ch-core/issues/321
        //docRef.setDate(Date.from(documentEntry.getCreationTime().getDateTime().toInstant()));

        return docRef;
    }

    /**
     * Convert an MHD DocumentReference to an XDS DocumentEntry.
     *
     * @param documentReference The MHD DocumentReference to convert.
     * @return the equivalent XDS DocumentEntry.
     */
    public DocumentEntry convertDocumentReference(final DocumentReference documentReference) {
        final var documentEntry = super.convertDocumentReference(documentReference);

        documentReference.getMeta().addProfile("http://fhir.ch/ig/ch-epr-fhir/StructureDefinition/ch-mhd-documentreference-comprehensive");

        // deletionStatus
        final Extension deletionStatus = documentReference.getExtensionByUrl(DELETION_STATUS_EXTENSION_URL);
        if (deletionStatus != null && deletionStatus.getValue() instanceof Coding coding)
            documentEntry.getExtraMetadata().put(ChEpr.DELETION_STATUS_URN, Collections.singletonList(coding.getCode()));

        // originalProviderRole
        final Extension originalRole = documentReference.getExtensionByUrl(ORIGINAL_PROVIDER_ROLE_EXTENSION_URL);
        if (originalRole != null && originalRole.getValue() instanceof final Coding coding) {
            documentEntry.getExtraMetadata().put(
                    ChEpr.ORIGINAL_PROVIDER_ROLE_URN,
                    Collections.singletonList(String.format("%s^^^&%s&ISO", coding.getCode(), Oids.normalize(coding.getSystem())))
            );
        }

        return documentEntry;
    }
}
