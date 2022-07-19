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

import lombok.Data;
import lombok.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.emed.ch.enums.CceDocumentType;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.OrganizationDigest;
import org.husky.emed.ch.models.common.PatientDigest;
import org.husky.emed.ch.models.common.RecipientDigest;
import org.husky.emed.ch.models.entry.EmedEntryDigest;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * Represents the digest of an Emed document. This class is declined in subclasses {@link EmedMtpDocumentDigest}, {@link
 * EmedPreDocumentDigest}, {@link EmedDisDocumentDigest}, {@link EmedPadvDocumentDigest}, {@link EmedPmlDocumentDigest}
 * and {@link EmedPmlcDocumentDigest}.
 * <p>
 * Creating these digests is typically done from a CDA-CH-EMED document with the digesters.
 *
 * @author Quentin Ligier
 */
@Data
public abstract class EmedDocumentDigest {

    /**
     * The author(s).
     */
    protected final List<@org.checkerframework.checker.nullness.qual.NonNull AuthorDigest> authors = new ArrayList<>();

    /**
     * The intended recipient(s).
     */
    protected final List<@org.checkerframework.checker.nullness.qual.NonNull RecipientDigest> recipients = new ArrayList<>();

    /**
     * The document ID.
     */
    @NonNull
    protected UUID id;

    /**
     * The document set ID.
     */
    @NonNull
    protected UUID setId;

    /**
     * The document version.
     */
    protected int version;

    /**
     * The document effective time.
     */
    @NonNull
    protected OffsetDateTime creationTime;

    /**
     * The documentation time (planning time, prescription time, dispense time or pharmaceutical advice time).
     */
    @NonNull
    protected Instant documentationTime;

    /**
     * The confidentiality code.
     */
    @NonNull
    protected ConfidentialityCode confidentialityCode;

    /**
     * The document main language (some parts may be in another language, e.g. PML documents may contain entries in
     * different languages).
     */
    @NonNull
    protected String languageCode;

    /*
     * The data enterer or {@code null} if it's not provided.
     */

    /*
     * The CDA informant(s).
     */

    /**
     * The targeted patient.
     */
    @NonNull
    protected PatientDigest patient;

    /**
     * The custodian.
     */
    @NonNull
    protected OrganizationDigest custodian;

    /*
     * The legal authenticator or {@code null} if it's not provided.
     */

    /*
     * The authenticator(s).
     */

    /*
     * The employer(s).
     */

    /*
     * The insurance(s).
     */

    /*
     * The insurance card(s).
     */

    /*
     * The patient contact(s).
     */

    /*
     * The order reference(s).
     */

    /*
     * The health service(s).
     */

    /*
     * The document replacement(s).
     */

    /*
     * The CDA authorization(s).
     */

    /*
     * The component of or {@code null} if it's not provided.
     */

    /**
     * The narrative text.
     */
    protected StrucDocText narrativeText;

    /**
     * The document remarks or {@code null} if it's not provided.
     */
    @Nullable
    protected StrucDocText remarks = null;

    /**
     * The PDF representation of the human representation; it may be empty.
     */
    protected byte[] pdfRepresentation = new byte[]{};

    /**
     * Constructor.
     *
     * @param id                  The document ID.
     * @param setId               The document set ID.
     * @param version             The document version.
     * @param creationTime        The document creation time.
     * @param documentationTime   The time of the documentation (planning time, prescription time, dispense time or
     *                            pharmaceutical advice time).
     * @param confidentialityCode The confidentiality code.
     * @param languageCode        The document main language.
     * @param patient             The targeted patient.
     * @param authors             The author(s).
     * @param custodian           The custodian.
     * @param recipients          The intended recipient(s).
     * @param narrativeText       The narrative text.
     */
    public EmedDocumentDigest(final UUID id,
                              final UUID setId,
                              final int version,
                              final OffsetDateTime creationTime,
                              final Instant documentationTime,
                              final ConfidentialityCode confidentialityCode,
                              final String languageCode,
                              final PatientDigest patient,
                              final List<@org.checkerframework.checker.nullness.qual.NonNull AuthorDigest> authors,
                              final OrganizationDigest custodian,
                              final List<@org.checkerframework.checker.nullness.qual.NonNull RecipientDigest> recipients,
                              final StrucDocText narrativeText) {
        this.id = Objects.requireNonNull(id);
        this.setId = Objects.requireNonNull(setId);
        this.version = version;
        this.creationTime = Objects.requireNonNull(creationTime);
        this.documentationTime = Objects.requireNonNull(documentationTime);
        this.confidentialityCode = Objects.requireNonNull(confidentialityCode);
        this.languageCode = Objects.requireNonNull(languageCode);
        this.patient = Objects.requireNonNull(patient);
        this.authors.addAll(Objects.requireNonNull(authors));
        this.custodian = Objects.requireNonNull(custodian);
        this.recipients.addAll(Objects.requireNonNull(recipients));
        this.narrativeText = Objects.requireNonNull(narrativeText);
    }

    /**
     * Returns the type of the Emed document.
     */
    public abstract CceDocumentType getDocumentType();

    /**
     * Returns the list of entry digests.
     */
    public abstract List<@org.checkerframework.checker.nullness.qual.NonNull EmedEntryDigest> getEntryDigests();

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedDocumentDigest that)) return false;
        return version == that.version
                && Objects.equals(authors, that.authors)
                && Objects.equals(recipients, that.recipients)
                && id.equals(that.id)
                && setId.equals(that.setId)
                && creationTime.equals(that.creationTime)
                && documentationTime.equals(that.documentationTime)
                && confidentialityCode == that.confidentialityCode
                && languageCode.equals(that.languageCode)
                && patient.equals(that.patient)
                && custodian.equals(that.custodian)
                && Objects.equals(narrativeText, that.narrativeText)
                && Objects.equals(remarks, that.remarks)
                && Arrays.equals(pdfRepresentation, that.pdfRepresentation);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(authors, recipients, id, setId, version, creationTime, documentationTime, confidentialityCode, languageCode, patient, custodian, narrativeText, remarks);
        result = 31 * result + Arrays.hashCode(pdfRepresentation);
        return result;
    }

    @Override
    public String toString() {
        return "EmedDocumentDigest{" +
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
                '}';
    }
}
