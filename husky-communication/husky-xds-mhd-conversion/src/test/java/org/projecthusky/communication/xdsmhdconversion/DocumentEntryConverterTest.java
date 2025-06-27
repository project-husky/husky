package org.projecthusky.communication.xdsmhdconversion;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.XdsJaxbDataBinding;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.ProvideAndRegisterDocumentSetRequestType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.platform.camel.ihe.xds.core.converters.EbXML30Converters;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.common.utils.time.Hl7Dtm;
import org.projecthusky.communication.ch.enums.stable.OriginalProviderRole;
import org.projecthusky.communication.xdsmhdconversion.converters.ChEprFhirDocumentEntryConverter;
import org.projecthusky.communication.xdsmhdconversion.converters.DocumentEntryConverter;

import jakarta.xml.bind.JAXBContext;
import java.io.InputStream;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link DocumentEntryConverter} class.
 * @author Ronaldo Loureiro
 */
class DocumentEntryConverterTest {
    @Test
    void testConvertDocumentReference1() throws Exception {
        final var provideAndRegisterDocumentSet = this.unmarshall("/ProvideAndRegisterDocumentSetRequest/PARDSR_02.xml");

        final var documentEntry = provideAndRegisterDocumentSet.getDocuments().getFirst().getDocumentEntry();
        final var documentReference = new DocumentEntryConverter().convertDocumentEntry(documentEntry);

        testDocumentReference(documentReference,
                "urn:uuid:c888e8c5-7e12-4bec-b99e-9fd92e10f6da",
                "urn:uuid:768f1904-cc07-49db-8104-92be8f9c6fc1",
                DocumentReferenceStatus.CURRENT,
                "419891008",
                "440545006",
                "2.16.756.5.30.1.191.1.0.2.1|c55f4ca7-bd4e-4134-8dcd-56b793ade958",
                documentReference.getAuthenticator().getReference(),
                documentReference.getDescription(),
                "17621005",
                "text/xml",
                "en-US",
                "urn:oid:2.999.756.42.1",
                4850,
                20,
                "Pharmaceutical Advice",
                Hl7Dtm.fromHl7("20220919182449").toInstant(),
                "urn:ihe:pharm:padv:2010",
                null,
                null,
                "22232009",
                "394802001",
                null);
    }

    @Test
    void testConvertDocumentReference2() throws Exception {
        final var provideAndRegisterDocumentSet = this.unmarshall("/ProvideAndRegisterDocumentSetRequest/PARDSR_02.xml");

        final var documentEntry = provideAndRegisterDocumentSet.getDocuments().getFirst().getDocumentEntry();
        final var documentReference = new DocumentEntryConverter().convertDocumentEntry(documentEntry);

        testDocumentReference(documentReference,
                "urn:uuid:c888e8c5-7e12-4bec-b99e-9fd92e10f6da",
                "urn:uuid:768f1904-cc07-49db-8104-92be8f9c6fc1",
                DocumentReferenceStatus.CURRENT,
                "419891008",
                "440545006",
                "2.16.756.5.30.1.191.1.0.2.1|c55f4ca7-bd4e-4134-8dcd-56b793ade958",
                documentReference.getAuthenticator().getReference(),
                documentReference.getDescription(),
                "17621005",
                "text/xml",
                "en-US",
                "urn:oid:2.999.756.42.1",
                4850,
                20,
                "Pharmaceutical Advice",
                Hl7Dtm.fromHl7("20220919182449").toInstant(),
                "urn:ihe:pharm:padv:2010",
                null,
                null,
                "22232009",
                "394802001",
                null);

        final var documentEntry2 = new DocumentEntryConverter().convertDocumentReference(documentReference);
        testDocumentEntry(documentEntry, documentEntry2);
    }

    @Test
    void testConvertChEprFhirDocumentReference2() throws Exception {
        final var provideAndRegisterDocumentSet = this.unmarshall("/ProvideAndRegisterDocumentSetRequest/PARDSR_02.xml");
        //final var provideAndRegisterDocumentSet = this.unmarshall("/ProvideAndRegisterDocumentSetRequest/ProvideAndRegisterDocumentSetRequestPMP.xml");

        final var documentEntry = provideAndRegisterDocumentSet.getDocuments().getFirst().getDocumentEntry();
        final var documentReference = new ChEprFhirDocumentEntryConverter().convertDocumentEntry(documentEntry);

        testDocumentReference(documentReference,
                "urn:uuid:c888e8c5-7e12-4bec-b99e-9fd92e10f6da",
                "urn:uuid:768f1904-cc07-49db-8104-92be8f9c6fc1",
                DocumentReferenceStatus.CURRENT,
                "419891008",
                "440545006",
                "2.16.756.5.30.1.191.1.0.2.1|c55f4ca7-bd4e-4134-8dcd-56b793ade958",
                documentReference.getAuthenticator().getReference(),
                documentReference.getDescription(),
                "17621005",
                "text/xml",
                "en-US",
                "urn:oid:2.999.756.42.1",
                4850,
                20,
                "Pharmaceutical Advice",
                Hl7Dtm.fromHl7("20220919182449").toInstant(),
                "urn:ihe:pharm:padv:2010",
                null,
                null,
                "22232009",
                "394802001",
                null);

        assertTrue(
                documentReference.getExtensionByUrl(ChEprFhirDocumentEntryConverter.ORIGINAL_PROVIDER_ROLE_EXTENSION_URL).getValue()
                        .equalsDeep(
                new Coding(Oids.PREFIX_OID + OriginalProviderRole.CODE_SYSTEM_ID, OriginalProviderRole.HEALTHCARE_PROFESSIONAL_CODE, OriginalProviderRole.HEALTHCARE_PROFESSIONAL.getDisplayName())
                        )
        );

        final var documentEntry2 = new DocumentEntryConverter().convertDocumentReference(documentReference);
        testDocumentEntry(documentEntry, documentEntry2);
    }

    void testDocumentReference(DocumentReference documentReference,
                               String masterIdentifier,
                               String identifier,
                               DocumentReferenceStatus status,
                               String codeType,
                               String categoryCode,
                               String subjectRef,
                               @Nullable String authenticatorRef,
                               @Nullable String description,
                               String securityCode,
                               String contentType,
                               String language,
                               String url,
                               int size,
                               int hashLength,
                               @Nullable String title,
                               Instant creation,
                               String formatCode,
                               @Nullable Date startContext,
                               @Nullable Date stopContext,
                               String facilityTypeCode,
                               String practiceSettingCode,
                               @Nullable String sourcePatientRef) {

        assertEquals(DocumentEntryConverter.COMPREHENSIVE_DOCUMENT_REFERENCE_PROFILE, documentReference.getMeta().getProfile().get(0).getValue());
        assertEquals(masterIdentifier, documentReference.getMasterIdentifier().getValue());
        assertEquals(identifier, documentReference.getIdentifier().get(0).getValue());
        assertEquals(status, documentReference.getStatus());
        assertEquals(codeType, documentReference.getType().getCodingFirstRep().getCode());
        assertEquals(categoryCode, documentReference.getCategoryFirstRep().getCodingFirstRep().getCode());
        assertEquals(
                subjectRef,
                String.format(
                        "%s|%s",
                        documentReference.getSubject().getIdentifier().getSystem(),
                        documentReference.getSubject().getIdentifier().getValue()
                ));
        assertTrue(documentReference.getAuthor().isEmpty());

        if (authenticatorRef != null) assertEquals(authenticatorRef, documentReference.getAuthenticator().getReference());
        else assertNull(documentReference.getAuthenticator().getReference());

        assertTrue(documentReference.getRelatesTo().isEmpty());

        if (description != null) assertEquals(description, documentReference.getDescription());
        else assertNull(documentReference.getDescription());

        assertEquals(securityCode, documentReference.getSecurityLabel().get(0).getCodingFirstRep().getCode());

        final var content = documentReference.getContentFirstRep();
        final var attachment = content.getAttachment();
        assertEquals(contentType, attachment.getContentType());
        assertEquals(language, attachment.getLanguage());
        assertEquals(url, attachment.getUrl());
        assertEquals(size, attachment.getSize());
        assertEquals(hashLength, attachment.getHash().length);

        if (title != null) assertEquals(title, attachment.getTitle());
        else assertNull(attachment.getTitle());

        assertEquals(creation, attachment.getCreation().toInstant());
        assertEquals(formatCode, content.getFormat().getCode());

        final var context = documentReference.getContext();
        assertTrue(context.getEvent().isEmpty());

        if (startContext != null) assertEquals(startContext, context.getPeriod().getStart());
        else assertNull(context.getPeriod().getStart());

        if (stopContext != null) assertEquals(stopContext, context.getPeriod().getEnd());
        else assertNull(context.getPeriod().getEnd());

        assertEquals(facilityTypeCode, context.getFacilityType().getCodingFirstRep().getCode());
        assertEquals(practiceSettingCode, context.getPracticeSetting().getCodingFirstRep().getCode());

        if (sourcePatientRef != null) assertEquals(sourcePatientRef, context.getSourcePatientInfo().getReference());
        else assertNull(context.getSourcePatientInfo().getReference());

        assertTrue(context.getRelated().isEmpty());
    }
    void testDocumentEntry(DocumentEntry original, DocumentEntry documentEntry) {
        assertEquals(original.isLimitedMetadata(), documentEntry.isLimitedMetadata());
        assertEquals(original.getUniqueId(), documentEntry.getUniqueId());
        // Certain Document Sharing transactions may allow symbolic Ids (anything that does not have the urn:uuid: prefix) to be used.
        // https://ihe.github.io/publications/ITI/TF/Volume3/ch-4.2.html#4.2.3.2.7
        // assertEquals(original.getEntryUuid(), documentEntry.getEntryUuid());
        assertEquals(original.getAvailabilityStatus(), documentEntry.getAvailabilityStatus());
        assertEquals(original.getTypeCode().getCode(), documentEntry.getTypeCode().getCode());
        assertEquals(original.getClassCode().getCode(), documentEntry.getClassCode().getCode());
        assertEquals(original.getPatientId().getId(), documentEntry.getPatientId().getId());
        assertEquals(original.getPatientId().getAssigningAuthority().getUniversalId(), documentEntry.getPatientId().getAssigningAuthority().getUniversalId());
        assertEquals(original.getAuthors().isEmpty(), documentEntry.getAuthors().isEmpty());
        assertEquals(original.getLegalAuthenticator(), documentEntry.getLegalAuthenticator());
        assertEquals(original.getComments(), documentEntry.getComments());
        assertEquals(original.getConfidentialityCodes().get(0).getCode(), documentEntry.getConfidentialityCodes().get(0).getCode());
        assertEquals(original.getMimeType(), documentEntry.getMimeType());
        assertEquals(original.getLanguageCode(), documentEntry.getLanguageCode());
        assertEquals(original.getRepositoryUniqueId(), documentEntry.getRepositoryUniqueId());
        assertEquals(original.getUri(), documentEntry.getUri());
        assertEquals(original.getSize(), documentEntry.getSize());
        assertEquals(original.getHash(), documentEntry.getHash());
        assertEquals(original.getTitle().getValue(), documentEntry.getTitle().getValue());
        assertEquals(original.getCreationTime(), documentEntry.getCreationTime());
        assertEquals(original.getFormatCode().getCode(), documentEntry.getFormatCode().getCode());
        assertEquals(original.getEventCodeList().isEmpty(), documentEntry.getEventCodeList().isEmpty());
        assertEquals(original.getServiceStartTime(), documentEntry.getServiceStartTime());
        assertEquals(original.getServiceStopTime(), documentEntry.getServiceStopTime());
        assertEquals(original.getHealthcareFacilityTypeCode().getCode(), documentEntry.getHealthcareFacilityTypeCode().getCode());
        assertEquals(original.getPracticeSettingCode().getCode(), documentEntry.getPracticeSettingCode().getCode());
        // assertEquals(original.getSourcePatientInfo(), documentEntry.getSourcePatientInfo());
        assertEquals(original.getReferenceIdList().isEmpty(), documentEntry.getReferenceIdList().isEmpty());
    }

    private ProvideAndRegisterDocumentSet unmarshall(final String filename) throws Exception {
        final InputStream xmlStream = SubmissionSetConverterTest.class.getResourceAsStream(filename);
        final var jaxbContext = JAXBContext.newInstance(ProvideAndRegisterDocumentSetRequestType.class);
        final var unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setListener(new XdsJaxbDataBinding.UnmarshallerListener());
        final var unmarshalledContent = (ProvideAndRegisterDocumentSetRequestType) unmarshaller.unmarshal(xmlStream);
        return EbXML30Converters.convert(unmarshalledContent);
    }
}
