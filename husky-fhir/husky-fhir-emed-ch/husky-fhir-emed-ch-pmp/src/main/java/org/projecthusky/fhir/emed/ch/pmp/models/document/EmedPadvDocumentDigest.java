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
package org.projecthusky.fhir.emed.ch.pmp.models.document;

import org.projecthusky.fhir.emed.ch.pmp.models.common.AuthorDigest;
import org.projecthusky.fhir.emed.ch.pmp.models.common.OrganizationDigest;
import org.projecthusky.fhir.emed.ch.pmp.models.common.PatientDigest;
import org.projecthusky.fhir.emed.ch.pmp.models.common.RecipientDigest;
import org.projecthusky.fhir.emed.ch.pmp.models.entry.EmedPadvEntryDigest;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.common.ch.enums.ConfidentialityCode;
import org.projecthusky.emed.ch.enums.CceDocumentType;
import org.projecthusky.common.hl7cdar2.StrucDocText;
import org.projecthusky.fhir.emed.ch.pmp.models.entry.EmedEntryDigest;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents the digest of a PADV Emed document.
 *
 * @author Quentin Ligier
 */
public class EmedPadvDocumentDigest extends EmedDocumentDigest {

    /**
     * The PADV entry contained in the document.
     */
    private final EmedPadvEntryDigest padvEntryDigest;

    /**
     * Constructor.
     *
     * @param id                  The document ID.
     * @param setId               The document set ID.
     * @param version             The document version.
     * @param creationTime        The document creation time.
     * @param documentationTime   The pharmaceutical advice time.
     * @param confidentialityCode The confidentiality code.
     * @param languageCode        The document main language.
     * @param patient             The targeted patient.
     * @param authors             The author(s).
     * @param custodian           The custodian.
     * @param recipients          The intended recipient(s).
     * @param narrativeText       The narrative text.
     * @param padvEntryDigest     The PADV entry digest.
     */
    public EmedPadvDocumentDigest(final UUID id,
                                  final UUID setId,
                                  final int version,
                                  final OffsetDateTime creationTime,
                                  final Instant documentationTime,
                                  final ConfidentialityCode confidentialityCode,
                                  final String languageCode,
                                  final PatientDigest patient,
                                  final List<@NonNull AuthorDigest> authors,
                                  final OrganizationDigest custodian,
                                  final List<@NonNull RecipientDigest> recipients,
                                  final StrucDocText narrativeText,
                                  final EmedPadvEntryDigest padvEntryDigest) {
        super(id, setId, version, creationTime, documentationTime, confidentialityCode, languageCode, patient, authors,
                custodian, recipients, narrativeText);
        this.padvEntryDigest = Objects.requireNonNull(padvEntryDigest);
    }

    /**
     * Returns the PADV entry contained in the document.
     */
    public EmedPadvEntryDigest getPadvEntryDigest() {
        return padvEntryDigest;
    }

    /**
     * Returns the type of the Emed document.
     */
    public CceDocumentType getDocumentType() {
        return CceDocumentType.PADV;
    }

    /**
     * Returns the list of entry digests.
     */
    public List<@NonNull EmedEntryDigest> getEntryDigests() {
        return List.of(this.padvEntryDigest);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedPadvDocumentDigest that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(padvEntryDigest, that.padvEntryDigest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), padvEntryDigest);
    }

    @Override
    public String toString() {
        return "EmedPadvDocumentDigest{" +
                "authors=" + this.authors +
                ", recipients=" + this.recipients +
                ", id='" + this.id + '\'' +
                ", setId='" + this.setId + '\'' +
                ", version=" + this.version +
                ", creationTime=" + this.creationTime +
                ", documentationTime=" + this.documentationTime +
                ", confidentialityCode=" + this.confidentialityCode +
                ", languageCode='" + this.languageCode + '\'' +
                ", patient=" + this.patient +
                ", custodian=" + this.custodian +
                ", narrativeText=" + this.narrativeText +
                ", remarks=" + this.remarks +
                ", pdfRepresentation=" + Arrays.toString(this.pdfRepresentation) +
                ", padvEntryDigest=" + this.padvEntryDigest +
                '}';
    }
}
