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
package org.projecthusky.communication.xds_mhd;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Address;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.openehealth.ipf.commons.ihe.xds.core.responses.*;
import org.projecthusky.common.utils.datatypes.Oids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;

/**
 * A converter of search responses between XDS and MHD (ITI-18 and ITI-66/67, PHARM-1 and PHARM-5).
 *
 * @author Quentin Ligier
 * @author Alexander Kreutz
 **/
public class SearchResponseConverter {
    private static final Logger log = LoggerFactory.getLogger(SearchResponseConverter.class);

    /**
     * This class is not instantiable.
     */
    private SearchResponseConverter() {
    }

    /**
     * @param resource Either a {@link Bundle} or an {@link OperationOutcome}.
     * @return
     */
    public static QueryResponse toXds(final Resource resource) {
        final var response = new QueryResponse();
        if (resource instanceof final OperationOutcome operationOutcome) {
            response.setStatus(Status.FAILURE); // An OperationOutcome is always an error
            operationOutcome.getIssue().forEach(issue -> response.getErrors().add(new ErrorInfo(
                    toXdsErrorCode(issue.getCode()),
                    issue.getDiagnostics(),
                    toXdsSeverity(issue.getSeverity()),
                    (issue.hasLocation()) ? issue.getLocation().get(0).getValue() : null,
                    null
            )));
        } else if (resource instanceof final Bundle bundle) {
            response.setStatus(Status.SUCCESS);
            // TODO: in the Bundle, we may have an OperationOutcome with warnings
            throw new NotImplementedException();
        } else {
            throw new IllegalArgumentException("SearchResponseConverter.toXds: the resource is neither a Bundle nor " +
                                                       "an OperationOutcome");
        }
        return response;
    }

    /**
     * @param queryResponse                  The XDS query response to convert.
     * @param retrieveEndpointUrl            The URL of the retrieve endpoint, without query params.
     * @param patientIdentifiableToReference A function that converts a patient {@link Identifiable} to a
     *                                       {@link Reference}.
     * @return either a {@link Bundle} (in case of success) or an {@link OperationOutcome} (in case of error).
     */
    public static Resource toMhd(final QueryResponse queryResponse,
                                 final String retrieveEndpointUrl,
                                 final Function<Identifiable, Reference> patientIdentifiableToReference) {
        // First, process the issues
        OperationOutcome operationOutcome = null;
        if (queryResponse.getErrors() != null) {
            operationOutcome = new OperationOutcome();
            boolean hasError = false;

            for (final ErrorInfo errorInfo : queryResponse.getErrors()) {
                if (errorInfo.getSeverity() == Severity.ERROR) {
                    hasError = true;
                }
                operationOutcome.addIssue()
                        .setCode(toMhdErrorCode(errorInfo.getErrorCode()))
                        .setDetails(new CodeableConcept().setText(errorInfo.getCodeContext()))
                        .setLocation((errorInfo.getLocation() != null) ?
                                             List.of(new StringType(errorInfo.getLocation())) :
                                             null)
                        .setSeverity(toMhdSeverity(errorInfo.getSeverity()));
            }

            if (hasError) {
                return operationOutcome;
            }
            // If we only have warnings, it is considered a success.
        }

        // Process relationship association
        final Map<String, List<DocumentReferenceRelatesToComponent>> relatesToMapping = new HashMap<>();
        for (final Association association : queryResponse.getAssociations()) {

            // Relationship type -> relatesTo.code code [1..1]
            // relationship reference -> relatesTo.target Reference(DocumentReference)

            final String source = association.getSourceUuid();
            final String target = association.getTargetUuid();
            final AssociationType type = association.getAssociationType();

            final var relatesTo = new DocumentReferenceRelatesToComponent();
            if (type != null) {
                switch (type) {
                    case APPEND -> relatesTo.setCode(DocumentReference.DocumentRelationshipType.APPENDS);
                    case REPLACE -> relatesTo.setCode(DocumentReference.DocumentRelationshipType.REPLACES);
                    case TRANSFORM -> relatesTo.setCode(DocumentReference.DocumentRelationshipType.TRANSFORMS);
                    case SIGNS -> relatesTo.setCode(DocumentReference.DocumentRelationshipType.SIGNS);
                    default -> log.warn("Association of type '{}' is not supported", type.name());
                }
            }
            relatesTo.setTarget(new Reference().setReference(Oids.PREFIX_OID + target));

            if (!relatesToMapping.containsKey(source)) {
                relatesToMapping.put(source, new ArrayList<>(1));
            }
            relatesToMapping.get(source).add(relatesTo);
        }

        final var bundle = new Bundle();
        bundle.setType(Bundle.BundleType.SEARCHSET);

        if (operationOutcome != null) {
            // The operation outcome contains warnings, we add it to the result as outcome.
            bundle.addEntry()
                    .setResource(operationOutcome)
                    .setSearch(new Bundle.BundleEntrySearchComponent().setMode(Bundle.SearchEntryMode.OUTCOME));
        }

        if (queryResponse.getDocumentEntries() != null) {
            for (final DocumentEntry documentEntry : queryResponse.getDocumentEntries()) {
                final var documentReference = new DocumentReference();
                bundle.addEntry().setResource(documentReference);

                documentReference.setId(MhdUtils.noUuidPrefix(documentEntry.getEntryUuid()));

                // limitedMetadata -> meta.profile canonical [0..*]
                if (documentEntry.isLimitedMetadata()) {
                    documentReference.getMeta().addProfile(
                            "http://ihe.net/fhir/StructureDefinition/IHE_MHD_Query_Comprehensive_DocumentReference");
                } else {
                    documentReference.getMeta().addProfile(
                            "http://ihe.net/fhir/StructureDefinition/IHE_MHD_Comprehensive_DocumentManifest");
                }

                // uniqueId -> masterIdentifier Identifier [0..1] [1..1]
                if (documentEntry.getUniqueId() != null) {
                    documentReference.setMasterIdentifier(
                            (new Identifier().setValue(Oids.PREFIX_OID + documentEntry.getUniqueId())));
                }

                // entryUUID -> identifier Identifier [0..*]
                // When the DocumentReference.identifier carries the entryUUID then the
                // DocumentReference.identifier. use shall be ‘official’
                if (documentEntry.getEntryUuid() != null) {
                    documentReference.addIdentifier((new Identifier().setSystem("urn:ietf:rfc:3986")
                            .setValue(MhdUtils.asUuid(documentEntry.getEntryUuid()))).setUse(Identifier.IdentifierUse.OFFICIAL));
                }
                // availabilityStatus -> status code {DocumentReferenceStatus} [1..1]
                // approved -> status=current
                // deprecated -> status=superseded
                // Other status values are allowed but are not defined in this mapping to XDS.
                if (documentEntry.getAvailabilityStatus() == AvailabilityStatus.APPROVED) {
                    documentReference.setStatus(Enumerations.DocumentReferenceStatus.CURRENT);
                }
                if (documentEntry.getAvailabilityStatus() == AvailabilityStatus.DEPRECATED) {
                    documentReference.setStatus(Enumerations.DocumentReferenceStatus.SUPERSEDED);
                }

                // contentTypeCode -> type CodeableConcept [0..1]
                if (documentEntry.getTypeCode() != null) {
                    documentReference.setType(XdsToMhdTypeConverter.toCodeableConcept(documentEntry.getTypeCode()));
                }
                // classCode -> category CodeableConcept [0..*]
                if (documentEntry.getClassCode() != null) {
                    documentReference.addCategory((XdsToMhdTypeConverter.toCodeableConcept(documentEntry.getClassCode())));
                }

                // patientId -> subject Reference(Patient| Practitioner| Group| Device) [0..1],
                // Reference(Patient)
                // Not a contained resource. URL Points to an existing Patient Resource
                // representing the XDS Affinity Domain Patient.
                if (documentEntry.getPatientId() != null) {
                    final Identifiable patient = documentEntry.getPatientId();
                    documentReference.setSubject(patientIdentifiableToReference.apply(patient));
                }

                // creationTime -> date instant [0..1]
                if (documentEntry.getCreationTime() != null) {
                    documentReference.setDate(Date.from(documentEntry.getCreationTime().getDateTime().toInstant()));
                }

                // authorPerson, authorInstitution, authorPerson, authorRole,
                // authorSpeciality, authorTelecommunication -> author Reference(Practitioner|
                // PractitionerRole| Organization| Device| Patient| RelatedPerson) [0..*]
                if (documentEntry.getAuthors() != null) {
                    for (final Author author : documentEntry.getAuthors()) {
                        documentReference.addAuthor(XdsToMhdTypeConverter.transformAuthor(author));
                    }
                }

                // legalAuthenticator -> authenticator Note 1
                // Reference(Practitioner|Practition erRole|Organization [0..1]
                final org.openehealth.ipf.commons.ihe.xds.core.metadata.Person person = documentEntry.getLegalAuthenticator();
                if (person != null) {
                    Practitioner practitioner = XdsToMhdTypeConverter.toPractitioner(person);
                    documentReference.setAuthenticator((Reference) new Reference().setResource(practitioner));
                }

                // Relationship Association -> relatesTo [0..*]
                // [1..1]
                documentReference.setRelatesTo(relatesToMapping.get(documentEntry.getEntryUuid()));

                // title -> description string [0..1]
                if (documentEntry.getTitle() != null) {
                    documentReference.setDescription(documentEntry.getTitle().getValue());
                }

                // confidentialityCode -> securityLabel CodeableConcept [0..*] Note: This
                // is NOT the DocumentReference.meta, as that holds the meta tags for the
                // DocumentReference itself.
                if (documentEntry.getConfidentialityCodes() != null) {
                    documentReference.addSecurityLabel(XdsToMhdTypeConverter.toCodeableConcept(documentEntry.getConfidentialityCodes()));
                }

                final DocumentReference.DocumentReferenceContentComponent content = documentReference.addContent();
                final var attachment = new Attachment();
                content.setAttachment(attachment);

                // mimeType -> content.attachment.contentType [1..1] code [0..1]
                if (documentEntry.getMimeType() != null) {
                    attachment.setContentType(documentEntry.getMimeType());
                }

                // languageCode -> content.attachment.language code [0..1]
                if (documentEntry.getLanguageCode() != null) {
                    attachment.setLanguage(documentEntry.getLanguageCode());
                }

                // retrievable location of the document -> content.attachment.url uri
                // [0..1] [1..1
                attachment.setUrl(String.format("%s?uniqueId=%s&repositoryUniqueId=%s",
                                                retrieveEndpointUrl,
                                                documentEntry.getUniqueId(),
                                                documentEntry.getRepositoryUniqueId()));

                // size -> content.attachment.size integer [0..1] The size is calculated
                if (documentEntry.getSize() != null) {
                    attachment.setSize(documentEntry.getSize().intValue());
                }

                // on the data prior to base64 encoding, if the data is base64 encoded.
                if (documentEntry.getHash() != null) {
                    attachment.setHash(Base64.getDecoder().decode(documentEntry.getHash()));
                }

                // comments -> content.attachment.title string [0..1]
                if (documentEntry.getComments() != null) {
                    attachment.setTitle(documentEntry.getComments().getValue());
                }

                // TcreationTime -> content.attachment.creation dateTime [0..1]
                if (documentEntry.getCreationTime() != null) {
                    attachment.setCreation(Date.from(documentEntry.getCreationTime().getDateTime().toInstant()));
                }

                // formatCode -> content.format Coding [0..1]
                if (documentEntry.getFormatCode() != null) {
                    content.setFormat(XdsToMhdTypeConverter.toCodeableConcept(documentEntry.getFormatCode()).getCodingFirstRep());
                }

                final var context = new DocumentReference.DocumentReferenceContextComponent();
                documentReference.setContext(context);

                // referenceIdList -> context.encounter Reference(Encounter) [0..*] When
                // referenceIdList contains an encounter, and a FHIR Encounter is available, it
                // may be referenced.
                // Map to context.related
                final List<ReferenceId> refIds = documentEntry.getReferenceIdList();
                if (refIds != null) {
                    for (ReferenceId refId : refIds) {
                        context.getRelated().add(XdsToMhdTypeConverter.toReference(refId));
                    }
                }

                // eventCodeList -> context.event CodeableConcept [0..*]
                if (documentEntry.getEventCodeList() != null) {
                    documentReference.getContext().setEvent(XdsToMhdTypeConverter.toCodeableConcepts(documentEntry.getEventCodeList()));
                }

                // serviceStartTime serviceStopTime -> context.period Period [0..1]
                if (documentEntry.getServiceStartTime() != null || documentEntry.getServiceStopTime() != null) {
                    final var period = new Period();
                    period.setStartElement(XdsToMhdTypeConverter.toDateTime(documentEntry.getServiceStartTime()));
                    period.setEndElement(XdsToMhdTypeConverter.toDateTime(documentEntry.getServiceStopTime()));
                    documentReference.getContext().setPeriod(period);
                }

                // healthcareFacilityTypeCode -> context.facilityType CodeableConcept
                // [0..1]
                if (documentEntry.getHealthcareFacilityTypeCode() != null) {
                    context.setFacilityType(XdsToMhdTypeConverter.toCodeableConcept(documentEntry.getHealthcareFacilityTypeCode()));
                }

                // practiceSettingCode -> context.practiceSetting CodeableConcept [0..1]
                if (documentEntry.getPracticeSettingCode() != null) {
                    context.setPracticeSetting(XdsToMhdTypeConverter.toCodeableConcept(documentEntry.getPracticeSettingCode()));
                }

                // sourcePatientId and sourcePatientInfo -> context.sourcePatientInfo
                // Reference(Patient) [0..1] Contained Patient Resource with
                // Patient.identifier.use element set to ‘usual’.
                final Identifiable sourcePatientId = documentEntry.getSourcePatientId();
                final PatientInfo sourcePatientInfo = documentEntry.getSourcePatientInfo();

                final var sourcePatient = new Patient();
                if (sourcePatientId != null) {
                    sourcePatient.addIdentifier((new Identifier()
                            .setSystem(Oids.PREFIX_OID + sourcePatientId.getAssigningAuthority().getUniversalId())
                            .setValue(sourcePatientId.getId())).setUse(Identifier.IdentifierUse.OFFICIAL));
                }

                if (sourcePatientInfo != null) {
                    sourcePatient.setBirthDateElement(XdsToMhdTypeConverter.toDate(sourcePatientInfo.getDateOfBirth()));
                    final String gender = sourcePatientInfo.getGender();
                    if (gender != null) {
                        switch (gender) {
                            case "F" -> sourcePatient.setGender(Enumerations.AdministrativeGender.FEMALE);
                            case "M" -> sourcePatient.setGender(Enumerations.AdministrativeGender.MALE);
                            case "U" -> sourcePatient.setGender(Enumerations.AdministrativeGender.UNKNOWN);
                            case "A" -> sourcePatient.setGender(Enumerations.AdministrativeGender.OTHER);
                        }
                    }
                    final ListIterator<Name> names = sourcePatientInfo.getNames();
                    while (names.hasNext()) {
                        final Name<?> name = names.next();
                        if (name != null) {
                            sourcePatient.addName(XdsToMhdTypeConverter.toHumanName(name));
                        }
                    }
                    final ListIterator<org.openehealth.ipf.commons.ihe.xds.core.metadata.Address> addresses =
                            sourcePatientInfo.getAddresses();
                    while (addresses.hasNext()) {
                        final Address address = addresses.next();
                        if (address != null) {
                            sourcePatient.addAddress(XdsToMhdTypeConverter.toAddress(address));
                        }
                    }
                }

                if (sourcePatientId != null || sourcePatientInfo != null) {
                    context.getSourcePatientInfo().setResource(sourcePatient);
                }
            }
        }

        return bundle;
    }

    public static Severity toXdsSeverity(final OperationOutcome.IssueSeverity severity) {
        if (severity == OperationOutcome.IssueSeverity.WARNING) {
            return Severity.WARNING;
        }
        return Severity.ERROR;
    }

    public static OperationOutcome.IssueSeverity toMhdSeverity(final Severity severity) {
        if (severity == Severity.WARNING) {
            return OperationOutcome.IssueSeverity.WARNING;
        }
        return OperationOutcome.IssueSeverity.ERROR;
    }

    public static ErrorCode toXdsErrorCode(final OperationOutcome.IssueType type) {
        return switch (type) {
            default -> ErrorCode.REGISTRY_ERROR;
        };
    }

    public static OperationOutcome.IssueType toMhdErrorCode(final ErrorCode code) {
        return switch (code) {
            default -> OperationOutcome.IssueType.INVALID;
        };
    }
}
