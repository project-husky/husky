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
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.common.ch.enums.ConfidentialityCode;
import org.projecthusky.common.hl7cdar2.StrucDocText;
import org.projecthusky.emed.ch.enums.CceDocumentType;
import org.projecthusky.fhir.emed.ch.pmp.models.entry.EmedEntryDigest;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * Represents the digest of a PML Emed document.
 *
 * @author Quentin Ligier
 */
public class EmedPmlDocumentDigest extends EmedDocumentDigest {

    /**
     * The entries contained in the document.
     */
    private final List<@NonNull EmedEntryDigest> entryDigests = new ArrayList<>(0);

    /**
     * Constructor.
     *
     * @param id                  The document ID.
     * @param setId               The document set ID.
     * @param version             The document version.
     * @param creationTime        The document creation time.
     * @param documentationTime   The time of the documentation.
     * @param confidentialityCode The confidentiality code.
     * @param languageCode        The document main language.
     * @param patient             The targeted patient.
     * @param authors             The author(s).
     * @param custodian           The custodian.
     * @param recipients          The intended recipient(s).
     * @param narrativeText       The narrative text.
     * @param entryDigests        The entry digests.
     */
    public EmedPmlDocumentDigest(final UUID id,
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
                                 final List<@NonNull EmedEntryDigest> entryDigests) {
        super(id, setId, version, creationTime, documentationTime, confidentialityCode, languageCode, patient, authors,
                custodian, recipients, narrativeText);
        this.entryDigests.addAll(Objects.requireNonNull(entryDigests));
    }

    /**
     * Returns the type of the Emed document.
     */
    public CceDocumentType getDocumentType() {
        return CceDocumentType.PML;
    }

    /**
     * Returns the list of entry digests.
     */
    public List<@NonNull EmedEntryDigest> getEntryDigests() {
        return this.entryDigests;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedPmlDocumentDigest that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(entryDigests, that.entryDigests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), entryDigests);
    }

    @Override
    public String toString() {
        return "EmedPmlDocumentDigest{" +
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
                ", entryDigests=" + this.entryDigests +
                '}';
    }
}
