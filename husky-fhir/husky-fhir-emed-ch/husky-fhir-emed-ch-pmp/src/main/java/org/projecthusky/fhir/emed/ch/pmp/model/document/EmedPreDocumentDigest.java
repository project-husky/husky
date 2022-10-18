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
package org.projecthusky.fhir.emed.ch.pmp.model.document;

import org.projecthusky.fhir.emed.ch.pmp.model.common.AuthorDigest;
import org.projecthusky.fhir.emed.ch.pmp.model.common.OrganizationDigest;
import org.projecthusky.fhir.emed.ch.pmp.model.common.PatientDigest;
import org.projecthusky.fhir.emed.ch.pmp.model.common.RecipientDigest;
import org.projecthusky.fhir.emed.ch.pmp.model.entry.EmedPreEntryDigest;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.ch.enums.ConfidentialityCode;
import org.projecthusky.common.hl7cdar2.StrucDocText;
import org.projecthusky.emed.ch.enums.CceDocumentType;
import org.projecthusky.fhir.emed.ch.pmp.model.entry.EmedEntryDigest;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * Represents the digest of a PRE Emed document.
 *
 * @author Quentin Ligier
 */
public class EmedPreDocumentDigest extends EmedDocumentDigest {

    /**
     * The prescription validity start time (inclusive).
     */
    final Instant prescriptionValidityStart;

    /**
     * The prescription validity stop time (inclusive) or {@code null}.
     */
    @Nullable
    final Instant prescriptionValidityStop;

    /**
     * The PRE entries contained in the document.
     */
    private final List<@NonNull EmedPreEntryDigest> preEntryDigests = new ArrayList<>(0);

    /**
     * Constructor.
     *
     * @param id                        The document ID.
     * @param setId                     The document set ID.
     * @param version                   The document version.
     * @param creationTime              The document creation time.
     * @param documentationTime         The prescription time.
     * @param confidentialityCode       The confidentiality code.
     * @param languageCode              The document main language.
     * @param patient                   The targeted patient.
     * @param authors                   The author(s).
     * @param custodian                 The custodian.
     * @param recipients                The intended recipient(s).
     * @param narrativeText             The narrative text.
     * @param preEntryDigests           The PRE entry digests.
     * @param prescriptionValidityStart The prescription validity start time (inclusive).
     * @param prescriptionValidityStop  The prescription validity stop time (inclusive) or {@code null}.
     */
    public EmedPreDocumentDigest(final UUID id,
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
                                 final List<@NonNull EmedPreEntryDigest> preEntryDigests,
                                 final Instant prescriptionValidityStart,
                                 @Nullable final Instant prescriptionValidityStop) {
        super(id, setId, version, creationTime, documentationTime, confidentialityCode, languageCode, patient, authors,
                custodian, recipients, narrativeText);
        this.preEntryDigests.addAll(Objects.requireNonNull(preEntryDigests));
        this.prescriptionValidityStart = Objects.requireNonNull(prescriptionValidityStart);
        this.prescriptionValidityStop = prescriptionValidityStop;
    }

    /**
     * Returns the PRE entries contained in the document.
     */
    public List<@NonNull EmedPreEntryDigest> getPreEntryDigests() {
        return this.preEntryDigests;
    }

    /**
     * Returns the prescription validity start time (inclusive).
     */
    public Instant getPrescriptionValidityStart() {
        return this.prescriptionValidityStart;
    }

    /**
     * Returns the prescription validity stop time (inclusive).
     */
    @Nullable
    public Instant getPrescriptionValidityStop() {
        return this.prescriptionValidityStop;
    }

    /**
     * Returns the type of the Emed document.
     */
    public CceDocumentType getDocumentType() {
        return CceDocumentType.PRE;
    }

    /**
     * Returns the list of entry digests.
     */
    public List<@org.checkerframework.checker.nullness.qual.NonNull EmedEntryDigest> getEntryDigests() {
        return new ArrayList<>(this.preEntryDigests);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedPreDocumentDigest that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(prescriptionValidityStart, that.prescriptionValidityStart)
                && Objects.equals(prescriptionValidityStop, that.prescriptionValidityStop)
                && Objects.equals(preEntryDigests, that.preEntryDigests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prescriptionValidityStart, prescriptionValidityStop, preEntryDigests);
    }

    @Override
    public String toString() {
        return "EmedPreDocumentDigest{" +
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
                ", prescriptionValidityStart=" + this.prescriptionValidityStart +
                ", prescriptionValidityStop=" + this.prescriptionValidityStop +
                ", preEntryDigests=" + this.preEntryDigests +
                '}';
    }
}
