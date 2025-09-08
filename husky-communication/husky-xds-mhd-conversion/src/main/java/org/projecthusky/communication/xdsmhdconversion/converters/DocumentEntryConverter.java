/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.xdsmhdconversion.converters;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent;
import org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent;
import org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.r4.model.Identifier.IdentifierUse;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.common.utils.time.Hl7Dtm;
import org.projecthusky.communication.xdsmhdconversion.utils.ConverterUtils;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.openehealth.ipf.commons.ihe.xds.core.metadata.Vocabulary.SLOT_NAME_REPOSITORY_UNIQUE_ID;

/**
 * A converter between XDS' DocumentEntry and MHD's DocumentReference.
 *
 * @author Quentin Ligier
 * @see <a href="https://ihe.github.io/publications/ITI/TF/Volume3/ch-4.2.html#4.2.3.2">DocumentEntry Attributes</a>
 * @see <a
 * href="https://ihe.github.io/publications/ITI/MHD/StructureDefinition-IHE.MHD.Comprehensive.DocumentReference.html">Resource
 * Profile: MHD DocumentReference Comprehensive</a>
 **/
public class DocumentEntryConverter {
    public final static String COMPREHENSIVE_DOCUMENT_REFERENCE_PROFILE =
            "https://profiles.ihe.net/ITI/MHD/StructureDefinition-IHE.MHD.Comprehensive.DocumentReference.html";
    public final static String MINIMAL_DOCUMENT_REFERENCE_PROFILE =
            "https://profiles.ihe.net/ITI/MHD/StructureDefinition-IHE.MHD.Minimal.DocumentReference.html";

    /**
     * Convert an XDS DocumentEntry to an MHD DocumentReference.
     *
     * @param documentEntry The XDS DocumentEntry to convert.
     * @return the equivalent MHD DocumentReference.
     */
    public DocumentReference convertDocumentEntry(final DocumentEntry documentEntry) {
        final DocumentReference documentReference = new DocumentReference();

        documentReference.setId(ConverterUtils.removePrefixUuid(documentEntry.getEntryUuid()));

        // profile | DocumentEntry.limitedMetadata
        if (documentEntry.isLimitedMetadata()) {
            documentReference.getMeta().addProfile(MINIMAL_DOCUMENT_REFERENCE_PROFILE);
        } else {
            documentReference.getMeta().addProfile(COMPREHENSIVE_DOCUMENT_REFERENCE_PROFILE);
        }

        // masterIdentifier | DocumentEntry.uniqueId
        if (documentEntry.getUniqueId() != null) {
            final var masterId =
                    new Identifier().setValue(Uuids.match(documentEntry.getUniqueId())? Uuids.URN_PREFIX + Uuids.normalize(documentEntry.getUniqueId()) : documentEntry.getUniqueId());
            masterId.setSystem("urn:ietf:rfc:3986");
            documentReference.setMasterIdentifier(masterId);
        }

        // identifier | DocumentEntry.entryUUID
        if (documentEntry.getEntryUuid() != null) {
            final var id = new Identifier()
                    .setSystem("urn:ietf:rfc:3986")
                    .setValue(ConverterUtils.addPrefixUuid(documentEntry.getEntryUuid()))
                    .setUse(IdentifierUse.OFFICIAL);

            documentReference.addIdentifier(id);
        }

        // status | DocumentEntry.availabilityStatus
        final var status = switch (documentEntry.getAvailabilityStatus()) {
            case APPROVED -> DocumentReferenceStatus.CURRENT;
            case DEPRECATED -> DocumentReferenceStatus.SUPERSEDED;
            default -> null;
        };

        if (status != null) documentReference.setStatus(status);

        // type | DocumentEntry.typeCode
        if (documentEntry.getTypeCode() != null) {
            documentReference.setType(ConverterUtils.toCodeableConcept(documentEntry.getTypeCode()));
        }

        // category | DocumentEntry.classCode
        if (documentEntry.getClassCode() != null) {
            documentReference.addCategory(ConverterUtils.toCodeableConcept(documentEntry.getClassCode()));
        }

        // subject | DocumentEntry.patientId
        if (documentEntry.getPatientId() != null) {
            documentReference.setSubject(ConverterUtils.toPatientReference(documentEntry.getPatientId()));
        }

        // author | DocumentEntry.author
        if (documentEntry.getAuthors() != null) {
            for (Author author : documentEntry.getAuthors()) {
                documentReference.addAuthor(ConverterUtils.toReference(author));
            }
        }

        // authenticator | DocumentEntry.legalAuthenticator
        if (documentEntry.getLegalAuthenticator() != null) {
            final var practitioner = ConverterUtils.toPractitioner(documentEntry.getLegalAuthenticator());
            documentReference.setAuthenticator((Reference) new Reference().setResource(practitioner));
        }

        // description | DocumentEntry.comments
        if (documentEntry.getComments() != null) {
            documentReference.setDescription(documentEntry.getComments().getValue());
        }

        // securityLabel | DocumentEntry.confidentialityCode
        if (documentEntry.getConfidentialityCodes() != null) {
            documentReference.addSecurityLabel(ConverterUtils.toCodeableConcept(documentEntry.getConfidentialityCodes()));
        }

        // content
        final DocumentReferenceContentComponent content = documentReference.addContent();

        /// attachment
        final Attachment attachment = new Attachment();
        content.setAttachment(attachment);

        //// contentType | DocumentEntry.mimeType
        if (documentEntry.getMimeType() != null) {
            attachment.setContentType(documentEntry.getMimeType());
        }

        //// language | DocumentEntry.languageCode
        if (documentEntry.getLanguageCode() != null) {
            attachment.setLanguage(documentEntry.getLanguageCode());
        }

        //// url | DocumentEntry.repositoryUniqueId or DocumentEntry.URI
        if (documentEntry.getUri() != null) {
            try {
                attachment.setUrl(new URI(documentEntry.getUri()).toURL().toString());
                if (documentEntry.getRepositoryUniqueId() != null) {
                    final var url = String.format(
                            "%s&repositoryUniqueId=%s",
                            attachment.getUrl(),
                            Oids.match(documentEntry.getRepositoryUniqueId())? Oids.PREFIX_OID + Oids.normalize(documentEntry.getRepositoryUniqueId()) : documentEntry.getRepositoryUniqueId()
                    );
                    attachment.setUrl(url);
                }
            } catch (URISyntaxException | MalformedURLException ignored) {}
        } else if (documentEntry.getRepositoryUniqueId() != null)
            attachment.setUrl(Oids.match(documentEntry.getRepositoryUniqueId())? Oids.PREFIX_OID + Oids.normalize(documentEntry.getRepositoryUniqueId()) : documentEntry.getRepositoryUniqueId());

        //// size | DocumentEntry.size
        if (documentEntry.getSize() != null) {
            attachment.setSize(documentEntry.getSize().intValue());
        }

        //// hash | DocumentEntry.hash
        if (documentEntry.getHash() != null) {
            try {
                attachment.setHash(Hex.decodeHex(documentEntry.getHash()));
            } catch (DecoderException ignored) {}
        }

        //// title | DocumentEntry.title
        if (documentEntry.getTitle() != null) {
            attachment.setTitle(documentEntry.getTitle().getValue());
        }

        //// creation | DocumentEntry.creationTime
        if (documentEntry.getCreationTime() != null) {
            final var creationTime = Hl7Dtm.fromHl7(documentEntry.getCreationTime().toHL7());
            attachment.setCreation(Date.from(creationTime.toInstant()));
        }

        /// format | DocumentEntry.formatCode
        if (documentEntry.getFormatCode() != null) {
            content.setFormat(ConverterUtils.toCoding(documentEntry.getFormatCode()));
        }

        // context
        final var context = new DocumentReferenceContextComponent();
        documentReference.setContext(context);

        /// event | Document.eventCodeList
        if (documentEntry.getEventCodeList() != null) {
            documentReference.getContext().setEvent(ConverterUtils.toListCodeableConcept(documentEntry.getEventCodeList()));
        }

        /// period
        if (documentEntry.getServiceStartTime() != null || documentEntry.getServiceStopTime() != null) {
            Period period = new Period();

            //// start | DocumentEntry.serviceStartTime
            period.setStartElement(ConverterUtils.toDateTimeType(documentEntry.getServiceStartTime()));

            //// stop | DocumentEntry.serviceStopTime
            period.setEndElement(ConverterUtils.toDateTimeType(documentEntry.getServiceStopTime()));

            documentReference.getContext().setPeriod(period);
        }

        /// facilityType | DocumentEntry.healthcareFacilityTypeCode
        if (documentEntry.getHealthcareFacilityTypeCode() != null) {
            context.setFacilityType(ConverterUtils.toCodeableConcept(documentEntry.getHealthcareFacilityTypeCode()));
        }

        /// practiceSetting | DocumentEntry.practiceSettingCode
        if (documentEntry.getPracticeSettingCode() != null) {
            context.setPracticeSetting(ConverterUtils.toCodeableConcept(documentEntry.getPracticeSettingCode()));
        }

        /// sourcePatientInfo
        final Patient sourcePatient = ConverterUtils.toPatient(documentEntry.getSourcePatientId(), documentEntry.getSourcePatientInfo());
        if (sourcePatient != null) {
            context.getSourcePatientInfo().setResource(sourcePatient);
        }

        /// related | DocumentEntry.referenceIdList
        final List<ReferenceId> refIds = documentEntry.getReferenceIdList();
        if (refIds != null) {
            for (ReferenceId refId : refIds) {
                context.getRelated().add(ConverterUtils.toReference(refId));
            }
        }

        return documentReference;
    }

    /**
     * Convert an XDS DocumentEntry to an MHD DocumentReference.
     *
     * @param documentEntry The XDS DocumentEntry to convert.
     * @param associations  The XDS associations having this document entry as a source and another document entry as a
     *                      target. Associations are added to the relatesTo element of the document reference.
     * @return the equivalent MHD DocumentReference.
     */
    public DocumentReference convertDocumentEntry(final DocumentEntry documentEntry,
                                                  final List<Association> associations) {
        final var docRef = convertDocumentEntry(documentEntry);

        if (associations != null && !associations.isEmpty()) {
            for (final Association association : associations) {
                if (association.getAssociationType() == null) throw new IllegalArgumentException("Association type cannot be null");
                if (association.getSourceUuid() == null || !association.getSourceUuid().equals(documentEntry.getEntryUuid()))
                    throw new IllegalArgumentException("Association source uuid does not match the document entry uuid");
                if (association.getTargetUuid() == null) throw new IllegalArgumentException("Association target uuid cannot be null");
                final var relatesTo = docRef.addRelatesTo();
                relatesTo.setCode(
                        switch (association.getAssociationType()) {
                            case APPEND -> DocumentReference.DocumentRelationshipType.APPENDS;
                            case REPLACE, TRANSFORM_AND_REPLACE -> DocumentReference.DocumentRelationshipType.REPLACES;
                            case TRANSFORM, IS_SNAPSHOT_OF -> DocumentReference.DocumentRelationshipType.TRANSFORMS;
                            case SIGNS -> DocumentReference.DocumentRelationshipType.SIGNS;
                            case HAS_MEMBER, UPDATE_AVAILABILITY_STATUS, SUBMIT_ASSOCIATION, NON_VERSIONING_UPDATE ->
                                throw new IllegalArgumentException("Unsupported association type for document entry " + association.getAssociationType().name());
                        }
                );
                relatesTo.setTarget(new Reference().setIdentifier(
                        new Identifier()
                                .setSystem("urn:ietf:rfc:3986")
                                .setValue(ConverterUtils.addPrefixUuid(association.getTargetUuid()))
                                .setUse(IdentifierUse.OFFICIAL)
                ));
            }
        }

        return docRef;
    }

    /**
     * Convert an MHD DocumentReference to an XDS DocumentEntry.
     *
     * @param documentReference The MHD DocumentReference to convert.
     * @return the equivalent XDS DocumentEntry.
     */
    public DocumentEntry convertDocumentReference(final DocumentReference documentReference) {
        final var documentEntry = new DocumentEntry();

        documentEntry.setExtraMetadata(new HashMap<>());

        // masterIdentifier | DocumentEntry.uniqueId
        documentEntry.setUniqueId(documentReference.getMasterIdentifier().getValue());

        // identifier | DocumentEntry.entryUUID
        documentEntry.setEntryUuid(documentReference.getIdentifierFirstRep().getValue());

        // status | DocumentEntry.availabilityStatus
        final AvailabilityStatus status = switch (documentReference.getStatus()) {
            case CURRENT -> AvailabilityStatus.APPROVED;
            case SUPERSEDED -> AvailabilityStatus.DEPRECATED;
            default -> null;
        };
        if (status != null) documentEntry.setAvailabilityStatus(status);

        // type | DocumentEntry.typeCode
        documentEntry.setTypeCode(ConverterUtils.toCode(documentReference.getType(), documentReference.getLanguage()));

        // category | DocumentEntry.classCode
        documentEntry.setClassCode(ConverterUtils.toCode(documentReference.getCategory(), documentReference.getLanguage()));

        // subject | DocumentEntry.patientId
        documentEntry.setPatientId(ConverterUtils.toIdentifiable(documentReference.getSubject(), documentReference.getContained()));

        // author | DocumentEntry.author
        for (Reference authorRef : documentReference.getAuthor()) {
            documentEntry.getAuthors().add(ConverterUtils.toAuthor(authorRef, documentReference.getContained(), null, documentReference.getLanguage()));
        }

        // authenticator | DocumentEntry.legalAuthenticator
        if (documentReference.hasAuthenticator()) {
            Resource authenticator = ConverterUtils.findResource(documentReference.getAuthenticator(), documentReference.getContained());
            if (authenticator instanceof PractitionerRole practitionerRole) {
                authenticator = ConverterUtils.findResource(practitionerRole.getPractitioner(), documentReference.getContained());
            }

            if (authenticator instanceof Practitioner practitioner) {
                documentEntry.setLegalAuthenticator(ConverterUtils.toPerson(practitioner));
            }
        }

        // description | DocumentEntry.comments
        if (documentReference.hasDescription()) {
            documentEntry.setComments(ConverterUtils.getLocalizedString(documentReference.getDescription(), documentReference.getLanguage()));
        }

        // securityLabel | DocumentEntry.confidentialityCode
        final List<Code> confidentialityCode = ConverterUtils.toCodes(documentReference.getSecurityLabel(), documentReference.getLanguage());
        if (confidentialityCode != null && !confidentialityCode.isEmpty()) {
            documentEntry.getConfidentialityCodes().addAll(confidentialityCode);
        }

        // content
        final DocumentReferenceContentComponent content = documentReference.getContentFirstRep();
        if (content != null) {
            if (content.hasAttachment()) {
                //// attachment
                final Attachment attachment = content.getAttachment();

                //// contentType | DocumentEntry.mimeType
                documentEntry.setMimeType(attachment.getContentType());

                //// language | DocumentEntry.languageCode
                documentEntry.setLanguageCode(attachment.getLanguage());

                //// url | DocumentEntry.repositoryUniqueId or DocumentEntry.URI
                if (attachment.hasUrl()) {
                    if (Oids.match(attachment.getUrl())) {
                        documentEntry.setRepositoryUniqueId(Oids.normalize(attachment.getUrl()));
                    } else {
                        final var uriComponents = UriComponentsBuilder.fromUriString(attachment.getUrl()).build();
                        //uriComponentsBuilder.
                        final var params = uriComponents.getQueryParams();
                        if (params.containsKey(SLOT_NAME_REPOSITORY_UNIQUE_ID)) {
                            documentEntry.setRepositoryUniqueId(Oids.normalize(params.getFirst(SLOT_NAME_REPOSITORY_UNIQUE_ID)));
                        }
                        documentEntry.setUri(uriComponents.toUriString());
                    }
                }

                //// size | DocumentEntry.size
                if (attachment.hasSize()) {
                    documentEntry.setSize((long) attachment.getSize());
                }

                //// hash | DocumentEntry.hash
                if (attachment.hasHash()) {
                    documentEntry.setHash(Hex.encodeHexString(attachment.getHash()));
                }

                //// title | DocumentEntry.title
                if (attachment.hasTitle()) {
                    documentEntry.setTitle(ConverterUtils.getLocalizedString(attachment.getTitle(), attachment.getLanguage()));
                }

                //// creation | DocumentEntry.creationTime
                if (attachment.hasCreation()) {
                    documentEntry.setCreationTime(new Timestamp(
                            attachment.getCreationElement().getValueAsCalendar().toZonedDateTime(),
                            Timestamp.Precision.SECOND)
                    );
                }
            }

            //// format | DocumentEntry.formatCode
            if (content.hasFormat()) {
                documentEntry.setFormatCode(ConverterUtils.toCode(content.getFormat(), documentReference.getLanguage()));
            }
        }

        // context
        final DocumentReferenceContextComponent context = documentReference.getContext();

        //// event | DocumentEntry.eventCodeList
        final List<Code> eventCodeList = ConverterUtils.toCodes(context.getEvent(), documentReference.getLanguage());
        if (eventCodeList != null && !eventCodeList.isEmpty()) {
            documentEntry.getEventCodeList().addAll(eventCodeList);
        }

        //// period
        if (context.hasPeriod()) {
            documentEntry.setServiceStartTime(
                    new Timestamp(
                            context.getPeriod().getStart().toInstant().atZone(ZoneId.systemDefault()),
                            Timestamp.Precision.SECOND)
            );

            documentEntry.setServiceStopTime(
                    new Timestamp(
                            context.getPeriod().getEnd().toInstant().atZone(ZoneId.systemDefault()),
                            Timestamp.Precision.SECOND)
            );
        }

        //// facilityType | DocumentEntry.healthcareFacilityTypeCode
        documentEntry.setHealthcareFacilityTypeCode(ConverterUtils.toCode(context.getFacilityType(), documentReference.getLanguage()));

        //// practiceSetting | DocumentEntry.practiceSettingCode
        documentEntry.setPracticeSettingCode(ConverterUtils.toCode(context.getPracticeSetting(), documentReference.getLanguage()));

        //// sourcePatientInfo
        if (context.hasSourcePatientInfo()) {
            documentEntry.setSourcePatientId(ConverterUtils.toIdentifiable(context.getSourcePatientInfo(), documentReference.getContained()));
            documentEntry.setSourcePatientInfo(ConverterUtils.toPatientInfo(context.getSourcePatientInfo(), documentReference.getContained()));
        }

        //// related | DocumentEntry.referenceIdList
        for (Reference ref : context.getRelated()) {
            final Identifiable refId = ConverterUtils.toIdentifiable(ref, documentReference.getContained());
            if (refId != null) {
                documentEntry.getReferenceIdList().add(ConverterUtils.toReferenceId(refId));
            }
        }

        return documentEntry;
    }
}