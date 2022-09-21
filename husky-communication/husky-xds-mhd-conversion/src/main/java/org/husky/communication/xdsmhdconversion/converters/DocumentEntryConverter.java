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
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;

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
            documentReference.setType(ConverterUtils.transformToCodeableConcept(documentEntry.getTypeCode()));
        }

        // category | DocumentEntry.classCode
        if (documentEntry.getClassCode() != null) {
            documentReference.addCategory(ConverterUtils.transformToCodeableConcept(documentEntry.getClassCode()));
        }

        // subject | DocumentEntry.patientId
        if (documentEntry.getPatientId() != null) {
            documentReference.setSubject(ConverterUtils.transformToPatientReference(documentEntry.getPatientId()));
        }

        // author | DocumentEntry.author
        if (documentEntry.getAuthors() != null) {
            for (Author author : documentEntry.getAuthors()) {
                documentReference.addAuthor(ConverterUtils.transformToReference(author));
            }
        }

        // authenticator | DocumentEntry.legalAuthenticator
        if (documentEntry.getLegalAuthenticator() != null) {
            final var practitioner = ConverterUtils.transformToPractitioner(documentEntry.getLegalAuthenticator());
            documentReference.setAuthenticator((Reference) new Reference().setResource(practitioner));
        }

        // TODO: relatesTo | DocumentEntry Associations

        // description | DocumentEntry.comments
        if (documentEntry.getComments() != null) {
            documentReference.setDescription(documentEntry.getComments().getValue());
        }

        // securityLabel | DocumentEntry.confidentialityCode
        if (documentEntry.getConfidentialityCodes() != null) {
            documentReference.addSecurityLabel(ConverterUtils.transformToCodeableConcept(documentEntry.getConfidentialityCodes()));
        }

        // content
        final DocumentReferenceContentComponent content = documentReference.addContent();

        //// attachment
        final Attachment attachment = new Attachment();
        content.setAttachment(attachment);

        ////// contentType | DocumentEntry.mimeType
        if (documentEntry.getMimeType() != null) {
            attachment.setContentType(documentEntry.getMimeType());
        }

        ////// language | DocumentEntry.languageCode
        if (documentEntry.getLanguageCode() != null) {
            attachment.setLanguage(documentEntry.getLanguageCode());
        }

        ////// url | DocumentEntry.repositoryUniqueId or DocumentEntry.URI
        // TODO: check if it's ok
        if (documentEntry.getUri() != null) {
            attachment.setUrl(documentEntry.getUri());
        }

        ////// size | DocumentEntry.size
        if (documentEntry.getSize() != null) {
            attachment.setSize(documentEntry.getSize().intValue());
        }

        ////// hash | DocumentEntry.hash
        if (documentEntry.getHash() != null) {
            try {
                attachment.setHash(Hex.decodeHex(documentEntry.getHash()));
            } catch (DecoderException ignored) {}
        }

        ////// title | DocumentEntry.title
        if (documentEntry.getTitle() != null) {
            attachment.setTitle(documentEntry.getTitle().getValue());
        }

        ////// creation | DocumentEntry.creationTime
        if (documentEntry.getCreationTime() != null) {
            attachment.setCreation(XdsMetadataUtil.convertDtmStringToDate(documentEntry.getCreationTime().toHL7()));
        }

        //// format | DocumentEntry.formatCode
        if (documentEntry.getFormatCode() != null) {
            content.setFormat(ConverterUtils.transformToCoding(documentEntry.getFormatCode()));
        }

        // context
        DocumentReferenceContextComponent context = new DocumentReferenceContextComponent();

        //// event | Document.eventCodeList
        if (documentEntry.getEventCodeList() != null) {
            documentReference.getContext().setEvent(ConverterUtils.transformToListCodeableConcept(documentEntry.getEventCodeList()));
        }

        //// period
        if (documentEntry.getServiceStartTime() != null || documentEntry.getServiceStopTime() != null) {
            Period period = new Period();

            ////// start | DocumentEntry.serviceStartTime
            period.setStartElement(ConverterUtils.transformToDateTimeType(documentEntry.getServiceStartTime()));

            ////// stop | DocumentEntry.serviceStopTime
            period.setEndElement(ConverterUtils.transformToDateTimeType(documentEntry.getServiceStopTime()));

            documentReference.getContext().setPeriod(period);
        }

        //// facilityType | DocumentEntry.healthcareFacilityTypeCode
        if (documentEntry.getHealthcareFacilityTypeCode() != null) {
            context.setFacilityType(ConverterUtils.transformToCodeableConcept(documentEntry.getHealthcareFacilityTypeCode()));
        }

        //// practiceSetting | DocumentEntry.practiceSettingCode
        if (documentEntry.getPracticeSettingCode() != null) {
            context.setPracticeSetting(ConverterUtils.transformToCodeableConcept(documentEntry.getPracticeSettingCode()));
        }

        //// sourcePatientInfo
        Patient sourcePatient = new Patient();

        ////// reference | DocumentEntry.sourcePatientInfo
        if (documentEntry.getSourcePatientInfo() != null) {
            // in progress...
        }

        ////// identifier | DocumentEntry.sourcePatientId
        Identifier sourcePatientId = ConverterUtils.transformToIdentifier(documentEntry.getSourcePatientId());
        if (sourcePatientId != null) {
            sourcePatient.addIdentifier(sourcePatientId.setUse(IdentifierUse.OFFICIAL));
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
        return null;
    }
}
