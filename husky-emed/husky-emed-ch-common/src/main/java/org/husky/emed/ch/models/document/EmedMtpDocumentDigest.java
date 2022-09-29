/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.models.document;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.husky.common.ch.enums.stable.ConfidentialityCode;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.emed.ch.enums.CceDocumentType;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.OrganizationDigest;
import org.husky.emed.ch.models.common.PatientDigest;
import org.husky.emed.ch.models.common.RecipientDigest;
import org.husky.emed.ch.models.entry.EmedEntryDigest;
import org.husky.emed.ch.models.entry.EmedMtpEntryDigest;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents the digest of an MTP Emed document.
 *
 * @author Quentin Ligier
 */
public class EmedMtpDocumentDigest extends EmedDocumentDigest {

    /**
     * The MTP entry contained in the document.
     */
    private final EmedMtpEntryDigest mtpEntryDigest;

    /**
     * Constructor.
     *
     * @param id                  The document ID.
     * @param setId               The document set ID.
     * @param version             The document version.
     * @param creationTime        The document creation time.
     * @param documentationTime   The planning time.
     * @param confidentialityCode The confidentiality code.
     * @param languageCode        The document main language.
     * @param patient             The targeted patient.
     * @param authors             The author(s).
     * @param custodian           The custodian.
     * @param recipients          The intended recipient(s).
     * @param narrativeText       The narrative text.
     * @param mtpEntryDigest      The MTP entry digest.
     */
    public EmedMtpDocumentDigest(final UUID id,
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
                                 final EmedMtpEntryDigest mtpEntryDigest) {
        super(id, setId, version, creationTime, documentationTime, confidentialityCode, languageCode, patient, authors,
                custodian, recipients, narrativeText);
        this.mtpEntryDigest = Objects.requireNonNull(mtpEntryDigest);
    }

    /**
     * Returns the MTP entry digest.
     */
    public EmedMtpEntryDigest getMtpEntryDigest() {
        return mtpEntryDigest;
    }

    /**
     * Returns the type of the Emed document.
     */
    public CceDocumentType getDocumentType() {
        return CceDocumentType.MTP;
    }

    /**
     * Returns the list of entry digests.
     */
    public List<@org.checkerframework.checker.nullness.qual.NonNull EmedEntryDigest> getEntryDigests() {
        return List.of(this.mtpEntryDigest);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedMtpDocumentDigest that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(mtpEntryDigest, that.mtpEntryDigest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mtpEntryDigest);
    }

    @Override
    public String toString() {
        return "EmedMtpDocumentDigest{" +
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
                ", mtpEntryDigest=" + this.mtpEntryDigest +
                '}';
    }
}
