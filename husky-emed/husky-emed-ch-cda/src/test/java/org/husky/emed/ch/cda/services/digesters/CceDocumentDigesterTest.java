/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.services.digesters;

import org.husky.common.ch.enums.stable.ConfidentialityCode;
import org.husky.emed.ch.cda.TestUtils;
import org.husky.emed.ch.cda.digesters.*;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.enums.CceDocumentType;
import org.husky.emed.ch.models.document.EmedMtpDocumentDigest;
import org.husky.emed.ch.models.entry.EmedEntryDigest;
import org.junit.jupiter.api.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        final var cceMtpEntryDigester = new CceMtpEntryDigester();
        final var ccePreEntryDigester = new CcePreEntryDigester(this.emedEntryDigestService);
        this.digester = new CceDocumentDigester(
                cceMtpEntryDigester,
                ccePreEntryDigester,
                new CceDisEntryDigester(this.emedEntryDigestService),
                new CcePadvEntryDigester(this.emedEntryDigestService, cceMtpEntryDigester, ccePreEntryDigester)
        );
    }

    @Test
    @DisplayName("MTP documents are digested correctly")
    @Order(1)
    void testDigestMtpDocument() throws Exception {
        final var mtpDoc = TestUtils.loadCdaChEmedResource("CDA-CH-EMED/eHealthSuisse/v1.0/1-1-MedicationTreatmentPlan.xml");
        final var digest = (EmedMtpDocumentDigest) this.digester.digest(mtpDoc);

        assertEquals("c9f758a1-296c-4710-84d4-e181db8c7478", digest.getId().toString());
        assertEquals("c9f758a1-296c-4710-84d4-e181db8c7478", digest.getSetId().toString());
        assertEquals(1, digest.getVersion());
        assertEquals("de-CH", digest.getLanguageCode());
        assertEquals(ConfidentialityCode.NORMALLY_ACCESSIBLE, digest.getConfidentialityCode());
        //assertEquals("", digest.getAuthors());
        //assertEquals("", digest.getCustodian());
        assertEquals(OffsetDateTime.parse("2011-11-29T11:00:00+01:00"), digest.getCreationTime());
		assertEquals(CceDocumentType.MTP, digest.getDocumentType());
        //assertEquals("", digest.getPatient());
        assertArrayEquals(new byte[]{}, digest.getPdfRepresentation());
        //assertEquals("", digest.getRecipients());
        assertNull(digest.getRemarks());

        this.emedEntryDigestService.add(digest.getMtpEntryDigest());
    }

    public static class EmedEntryDigestServiceImpl implements EmedEntryDigestService {

        private final List<EmedEntryDigest> digests = new ArrayList<>();

        @Override
        public Optional<EmedEntryDigest> getById(UUID entryId) {
            return this.digests.stream().filter(digest -> digest.getEntryId().equals(entryId)).findAny();
        }

        @Override
        public int getSequence(UUID medicationTreatmentId, Instant creationTime) {
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