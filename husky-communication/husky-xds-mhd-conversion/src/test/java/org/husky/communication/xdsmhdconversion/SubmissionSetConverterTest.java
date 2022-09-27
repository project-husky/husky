package org.husky.communication.xdsmhdconversion;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.Identifier.IdentifierUse;
import org.hl7.fhir.r4.model.ListResource.ListMode;
import org.hl7.fhir.r4.model.ListResource.ListStatus;
import org.husky.common.utils.XdsMetadataUtil;
import org.husky.common.utils.xml.XmlFactories;
import org.husky.communication.xdsmhdconversion.converters.SubmissionSetConverter;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.ProvideAndRegisterDocumentSetRequestType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.platform.camel.ihe.xds.core.converters.EbXML30Converters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link SubmissionSetConverter} class.
 *
 * @author Ronaldo Loureiro
 */
class SubmissionSetConverterTest {

    private final Class<?> UNMARSHALLED_CLASS = ProvideAndRegisterDocumentSetRequestType.class;
    private final Unmarshaller UNMARSHALLER;

    public SubmissionSetConverterTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testConvertSubmissionSet1() throws Exception {
        final var provideAndRegisterDocumentSet = this.unmarshall("/ProvideAndRegisterDocumentSetRequest/PARDSR_01.xml");

        ListResource list = new ListResource();
        new SubmissionSetConverter().convertSubmissionSet(provideAndRegisterDocumentSet.getSubmissionSet(), list);

        testListResource(list,
                false,
                "urn:oid:2.16.756.5.30.1.196.3.2.1",
                null,
                "71388002",
                "urn:oid:2.25.322215999717263588403896523221898918396",
                "urn:uuid:22d94e9e-d193-4c84-ab11-0fef6c64d3cc",
                false,
                null,
                "2.16.756.5.30.1.191.1.0.2.1-22701467-5f85-4818-8cd5-202d86c4decc",
                XdsMetadataUtil.convertDtmStringToDate("20220914072843"),
                0);

        assertEquals("HCP", ((PractitionerRole) list.getSource().getResource()).getCode().get(0).getCodingFirstRep().getCode());

        SubmissionSet submissionSet = new SubmissionSetConverter().convertList(list);
        testSubmissionSet(provideAndRegisterDocumentSet.getSubmissionSet(), submissionSet);
    }

    @Test
    void testConvertSubmissionSet2() throws Exception {
        final var provideAndRegisterDocumentSet = this.unmarshall("/ProvideAndRegisterDocumentSetRequest/PARDSR_02.xml");

        ListResource list = new ListResource();
        new SubmissionSetConverter().convertSubmissionSet(provideAndRegisterDocumentSet.getSubmissionSet(), list);

        testListResource(list,
                false,
                "urn:oid:2.16.756.5.30.1.196.3.2.1",
                null,
                "71388002",
                "urn:oid:2.25.37706314341356520517812219821721369919",
                "urn:uuid:19dc2a0b-b37f-4f9c-a652-10ad13d78b02",
                false,
                null,
                "2.16.756.5.30.1.191.1.0.2.1-c55f4ca7-bd4e-4134-8dcd-56b793ade958",
                XdsMetadataUtil.convertDtmStringToDate("20220919182449"),
                0);

        assertEquals("HCP", ((PractitionerRole) list.getSource().getResource()).getCode().get(0).getCodingFirstRep().getCode());

        SubmissionSet submissionSet = new SubmissionSetConverter().convertList(list);
        testSubmissionSet(provideAndRegisterDocumentSet.getSubmissionSet(), submissionSet);
    }

    private void testListResource(final ListResource list,
                                  final boolean limitedMetadata,
                                  @Nullable final String sourceIdVal,
                                  @Nullable final String intendedRecipientVal,
                                  @Nullable final String designationTypeVal,
                                  @Nullable final String uniqueIdVal,
                                  @Nullable final String entryUuidVal,
                                  final boolean hasStatus,
                                  @Nullable final String titleVal,
                                  @Nullable final String patientIdVal,
                                  @Nullable final Date dateVal,
                                  final int nbNote) {
        final String profile = list.getMeta().getProfile().get(0).getValue();

        final Optional<Extension> sourceId = list.getExtension().stream()
                .filter(e -> e.getUrl().equals("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-sourceId"))
                .findAny();

        final Optional<Extension> intendedRecipient = list.getExtension().stream()
                .filter(e -> e.getUrl().equals("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-intendedRecipient"))
                .findAny();

        final Optional<Extension> designationType = list.getExtension().stream()
                .filter(e -> e.getUrl().equals("https://profiles.ihe.net/ITI/MHD/StructureDefinition/ihe-designationType"))
                .findAny();

        final Optional<Identifier> uniqueId = list.getIdentifier().stream()
                .filter(i -> i.getUse() == IdentifierUse.USUAL)
                .findFirst();

        final Optional<Identifier> entryUuid = list.getIdentifier().stream()
                .filter(i -> i.getUse() == IdentifierUse.OFFICIAL)
                .findFirst();

        if (limitedMetadata) {
            assertEquals("https://profiles.ihe.net/ITI/MHD/StructureDefinition/IHE.MHD.Minimal.SubmissionSet", profile);
        } else {
            assertEquals("https://profiles.ihe.net/ITI/MHD/StructureDefinition/IHE.MHD.Comprehensive.SubmissionSet", profile);
        }

        if (sourceIdVal != null) {
            assertTrue(sourceId.isPresent());
            assertEquals(sourceIdVal, ((Identifier) sourceId.get().getValue()).getValue());
        } else {
            assertTrue(sourceId.isEmpty());
        }

        if (intendedRecipientVal == null) {
            assertTrue(intendedRecipient.isEmpty());
        }

        if (designationTypeVal != null) {
            assertTrue(designationType.isPresent());
            assertEquals(designationTypeVal, ((CodeableConcept) designationType.get().getValue()).getCoding().get(0).getCode());
        } else {
            assertTrue(designationType.isEmpty());
        }

        if (uniqueIdVal != null) {
            assertTrue(uniqueId.isPresent());
            assertEquals(uniqueIdVal, uniqueId.get().getValue());
        } else {
            assertTrue(uniqueId.isEmpty());
        }

        if (entryUuidVal != null) {
            assertTrue(entryUuid.isPresent());
            assertEquals(entryUuidVal, entryUuid.get().getValue());
        } else {
            assertTrue(entryUuid.isEmpty());
        }

        if (hasStatus) {
            assertEquals(ListStatus.CURRENT, list.getStatus());
        } else {
            assertNull(list.getStatus());
        }

        assertEquals(ListMode.WORKING, list.getMode());

        if (titleVal != null) {
            assertEquals(titleVal, list.getTitle());
        } else {
            assertNull(list.getTitle());
        }

        assertEquals("submissionset", list.getCode().getCoding().get(0).getCode());

        if (patientIdVal != null) {
            assertEquals(patientIdVal, list.getSubject().getReference());
        } else {
            assertNull(list.getSubject());
        }

        if (dateVal != null) {
            assertEquals(dateVal, list.getDate());
        } else {
            assertNull(list.getDate());
        }

        assertEquals(nbNote, list.getNote().size());
    }

    private void testSubmissionSet(SubmissionSet original, SubmissionSet submissionSet) {
        assertEquals(original.isLimitedMetadata(), submissionSet.isLimitedMetadata());
        assertEquals(original.getSourceId(), submissionSet.getSourceId());
        assertEquals(original.getIntendedRecipients(), submissionSet.getIntendedRecipients());
        assertEquals(original.getUniqueId(), submissionSet.getUniqueId());
        assertEquals(original.getTitle(), submissionSet.getTitle());
        assertEquals(original.getPatientId(), submissionSet.getPatientId());
        assertEquals(original.getSubmissionTime(), submissionSet.getSubmissionTime());
//        assertEquals(original.getAuthors(), submissionSet.getAuthors());
        assertEquals(original.getComments(), submissionSet.getComments());
    }

    private ProvideAndRegisterDocumentSet unmarshall(final String filename) throws Exception {
        final InputStream xmlStream = SubmissionSetConverterTest.class.getResourceAsStream(filename);

        final var document = XmlFactories.newSafeDocumentBuilder().parse(xmlStream);
        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var provideAndRegisterDocumentSetRequestType = (ProvideAndRegisterDocumentSetRequestType) JAXBIntrospector.getValue(root);
        return EbXML30Converters.convert(provideAndRegisterDocumentSetRequestType);
    }
}
