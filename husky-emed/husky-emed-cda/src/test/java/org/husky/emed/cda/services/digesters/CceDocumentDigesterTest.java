package org.husky.emed.cda.services.digesters;

import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.emed.cda.TestUtils;
import org.husky.emed.enums.EmedDocumentType;
import org.husky.emed.models.document.EmedMtpDocumentDigest;
import org.husky.emed.models.entry.EmedEntryDigest;
import org.husky.emed.cda.services.EmedEntryDigestService;
import org.junit.jupiter.api.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the {@link CceDocumentDigester} class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CceDocumentDigesterTest {

    private final EmedEntryDigestServiceImpl emedEntryDigestService;
    private final CceDocumentDigester digester;

    CceDocumentDigesterTest() {
        this.emedEntryDigestService = new EmedEntryDigestServiceImpl();
        this.digester = new CceDocumentDigester(
                new CceMtpEntryDigester(),
                new CcePreEntryDigester(emedEntryDigestService),
                new CceDisEntryDigester(emedEntryDigestService),
                new CcePadvEntryDigester(emedEntryDigestService)
        );
    }

    @Test
    @DisplayName("MTP documents are digested correctly")
    @Order(1)
    void testDigestMtpDocument() throws Exception {
        final var mtpDoc = TestUtils.loadCdaChEmedResource("CDA-CH-EMED/eHealthSuisse/v1.0/1-1-MedicationTreatmentPlan.xml");
        final var digest = (EmedMtpDocumentDigest) this.digester.digest(mtpDoc);

        assertEquals("c9f758a1-296c-4710-84d4-e181db8c7478", digest.getId());
        assertEquals("c9f758a1-296c-4710-84d4-e181db8c7478", digest.getSetId());
        assertEquals(1, digest.getVersion());
        assertEquals("de-CH", digest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, digest.getConfidentialityCode());
        //assertEquals("", digest.getAuthors());
        //assertEquals("", digest.getCustodian());
        assertEquals(OffsetDateTime.parse("2011-11-29T11:00:00+01:00"), digest.getEffectiveTime());
        assertEquals(EmedDocumentType.MTP, digest.getDocumentType());
        //assertEquals("", digest.getPatient());
        assertArrayEquals(new byte[]{}, digest.getPdfRepresentation());
        //assertEquals("", digest.getRecipients());
        assertNull(digest.getRemarks());

        this.emedEntryDigestService.add(digest.getMtpEntryDigest());
    }

    public static class EmedEntryDigestServiceImpl implements EmedEntryDigestService {

        private final List<EmedEntryDigest> digests = new ArrayList<>();

        @Override
        public Optional<EmedEntryDigest> getById(String entryId) {
            return this.digests.stream().filter(digest -> digest.getEntryId().equalsIgnoreCase(entryId)).findAny();
        }

        @Override
        public Optional<EmedEntryDigest> getByDocument(String documentUniqueId) {
            return this.digests.stream().filter(digest -> digest.getDocumentId().equalsIgnoreCase(documentUniqueId)).findAny();
        }

        @Override
        public long getSequence(String medicationTreatmentId, Instant creationTime) {
            return 0;
        }

        public void add(EmedEntryDigest digest) {
            this.digests.add(digest);
        }

        public void addAll(List<EmedEntryDigest> digests) {
            this.digests.addAll(digests);
        }
    }

}