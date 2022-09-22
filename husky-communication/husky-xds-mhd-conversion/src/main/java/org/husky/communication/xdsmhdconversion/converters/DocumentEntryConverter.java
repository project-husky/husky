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
package org.husky.communication.xdsmhdconversion.converters;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent;
import org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent;
import org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.r4.model.Identifier.IdentifierUse;
import org.husky.common.utils.XdsMetadataUtil;
import org.husky.communication.xdsmhdconversion.utils.ConverterUtils;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * A converter between XDS' DocumentEntry and MHD's DocumentReference.
 *
 * @author Quentin Ligier
 * @see <a href="https://ihe.github.io/publications/ITI/TF/Volume3/ch-4.2.html#4.2.3.2">DocumentEntry Attributes</a>
 * @see <a
 * href="https://ihe.github.io/publications/ITI/MHD/StructureDefinition-IHE.MHD.Comprehensive.DocumentReference.html">Resource
 * Profile: MHD DocumentReference Comprehensive</a>
 * @see <a
 * href="http://build.fhir.org/ig/ehealthsuisse/ch-epr-mhealth/StructureDefinition-ch-mhd-documentreference-comprehensive.html">Resource
 * Profile: CH MHD DocumentReference Comprehensive</a>
 **/
public class DocumentEntryConverter {

    /**
     * Convert an XDS DocumentEntry to an MHD DocumentReference.
     *
     * @param documentEntry The XDS DocumentEntry to convert.
     * @return the equivalent MHD DocumentReference.
     */
    public DocumentReference convertDocumentEntry(final DocumentEntry documentEntry) {
        // TODO: est-ce qu'on passe un Bundle au lieu de retourner un DocumentReference ?
        final DocumentReference documentReference = new DocumentReference();

        documentReference.setId(ConverterUtils.removePrefixUuid(documentEntry.getEntryUuid()));

        // profile | DocumentEntry.limitedMetadata
        // ¯\_(ツ)_/¯
        if (documentEntry.isLimitedMetadata()) {
            documentReference.getMeta().addProfile("http://ihe.net/fhir/StructureDefinition/IHE_MHD_Query_Comprehensive_DocumentReference");
        } else {
            documentReference.getMeta().addProfile("http://ihe.net/fhir/StructureDefinition/IHE_MHD_Comprehensive_DocumentManifest");
        }

        // masterIdentifier | DocumentEntry.uniqueId
        if (documentEntry.getUniqueId() != null) {
            final var masterId = new Identifier().setValue(ConverterUtils.addPrefixOid(documentEntry.getUniqueId()));
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

        // TODO: relatesTo | DocumentEntry Associations

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
        // TODO: check if it's ok
        if (documentEntry.getUri() != null) {
            try {
                attachment.setUrl(new URI(documentEntry.getUri()).toURL().toString());
            } catch (URISyntaxException | MalformedURLException ignored) {}
        }

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
            attachment.setCreation(XdsMetadataUtil.convertDtmStringToDate(documentEntry.getCreationTime().toHL7()));
        }

        /// format | DocumentEntry.formatCode
        if (documentEntry.getFormatCode() != null) {
            content.setFormat(ConverterUtils.toCoding(documentEntry.getFormatCode()));
        }

        // context
        DocumentReferenceContextComponent context = new DocumentReferenceContextComponent();

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
        Patient sourcePatient = ConverterUtils.toPatient(documentEntry.getSourcePatientId(), documentEntry.getSourcePatientInfo());
        if (sourcePatient != null) {
            context.getSourcePatientInfo().setResource(sourcePatient);
        }

        /// related | DocumentEntry.referenceIdList
        List<ReferenceId> refIds = documentEntry.getReferenceIdList();
        if (refIds != null) {
            for (ReferenceId refId : refIds) {
                context.getRelated().add(ConverterUtils.toReference(refId));
            }
        }

        return documentReference;
    }

    /**
     * Convert an MHD DocumentReference to an XDS DocumentEntry.
     *
     * @param documentReference The MHD DocumentReference to convert.
     * @return the equivalent XDS DocumentEntry.
     */
    public DocumentEntry convertDocumentReference(final DocumentReference documentReference) {
        DocumentEntry documentEntry = new DocumentEntry();

        // profile | DocumentEntry.limitedMetadata
        // No action ¯\_(ツ)_/¯

        // masterIdentifier | DocumentEntry.uniqueId
        documentEntry.setUniqueId(ConverterUtils.removePrefixOid(documentReference.getMasterIdentifier().getValue()));

        // identifier | DocumentEntry.entryUUID
        if (documentReference.hasId()) {
            documentEntry.setEntryUuid(ConverterUtils.removePrefixUuid(documentReference.getId()));
        } else {
            documentEntry.assignEntryUuid();
            documentReference.setId(ConverterUtils.removePrefixUuid(documentEntry.getEntryUuid()));
        }

        // status | DocumentEntry.availabilityStatus
        AvailabilityStatus status = switch (documentReference.getStatus()) {
            case CURRENT -> AvailabilityStatus.APPROVED;
            case SUPERSEDED -> AvailabilityStatus.DEPRECATED;
            default -> null;
        };

        if (status != null) {
            documentEntry.setAvailabilityStatus(status);
        }

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

        // TODO relatesTo | DocumentEntry Associations

        // description | DocumentEntry.comments
        if (documentReference.getDescription() != null) {
            documentEntry.setComments(ConverterUtils.getLocalizedString(documentReference.getDescription(), documentReference.getLanguage()));
        }

        // securityLabel | DocumentEntry.confidentialityCode
        List<Code> confidentialityCode = ConverterUtils.toCodes(documentReference.getSecurityLabel(), documentReference.getLanguage());
        if (confidentialityCode != null && !confidentialityCode.isEmpty()) {
            documentEntry.getConfidentialityCodes().addAll(confidentialityCode);
        }

        // content
        DocumentReferenceContentComponent content = documentReference.getContentFirstRep();
        if (content != null && content.getAttachment() != null) {
            /// attachment
            Attachment attachment = content.getAttachment();

            //// contentType | DocumentEntry.mimeType
            documentEntry.setMimeType(attachment.getContentType());

            //// language | DocumentEntry.languageCode
            documentEntry.setLanguageCode(attachment.getLanguage());

            //// url | DocumentEntry.repositoryUniqueId or DocumentEntry.URI
            if (attachment.hasUrl()) {
                try {
                    documentEntry.setUri(new URL(attachment.getUrl()).toURI().toString());
                } catch (MalformedURLException | URISyntaxException ignored) {}
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
                documentEntry.setCreationTime(Timestamp.fromHL7(XdsMetadataUtil.convertDateToDtmString(attachment.getCreation())));
            }
        }

        /// format | DocumentEntry.formatCode
        if (content != null && content.hasFormat()) {
            documentEntry.setFormatCode(ConverterUtils.toCode(content.getFormat(), documentReference.getLanguage()));
        }

        // context
        DocumentReferenceContextComponent context = documentReference.getContext();

        /// event | DocumentEntry.eventCodeList
        List<Code> eventCodeList = ConverterUtils.toCodes(context.getEvent(), documentReference.getLanguage());
        if (eventCodeList != null && !eventCodeList.isEmpty()) {
            documentEntry.getEventCodeList().addAll(eventCodeList);
        }

        /// period
        if (context.hasPeriod()) {
            documentEntry.setServiceStartTime(Timestamp.fromHL7(XdsMetadataUtil.convertDateToDtmString(context.getPeriod().getStart())));
            documentEntry.setServiceStopTime(Timestamp.fromHL7(XdsMetadataUtil.convertDateToDtmString(context.getPeriod().getEnd())));
        }

        /// facilityType | DocumentEntry.healthcareFacilityTypeCode
        documentEntry.setHealthcareFacilityTypeCode(ConverterUtils.toCode(context.getFacilityType(), documentReference.getLanguage()));

        /// practiceSetting | DocumentEntry.practiceSettingCode

        /// sourcePatientInfo

        /// related | DocumentEntry.referenceIdList
        for (Reference ref : context.getRelated()) {
            Identifiable refId = ConverterUtils.toIdentifiable(ref, documentReference.getContained());
            if (refId != null) {
                documentEntry.getReferenceIdList().add(ConverterUtils.toReferenceId(refId));
            }
        }


        return documentEntry;
    }
}
