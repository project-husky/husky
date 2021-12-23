/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.models.document;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.emed.enums.EmedDocumentType;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.emed.models.common.AuthorDigest;
import org.husky.emed.models.common.OrganizationDigest;
import org.husky.emed.models.common.PatientDigest;
import org.husky.emed.models.common.RecipientDigest;
import org.husky.emed.models.entry.EmedDisEntryDigest;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Represents the digest of a DIS Emed document.
 *
 * @author Quentin Ligier
 */
public class EmedDisDocumentDigest extends EmedDocumentDigest {

    /**
     * The DIS entry contained in the document.
     */
    private final EmedDisEntryDigest disEntryDigest;

    /**
     * Constructor.
     *
     * @param id                  The document ID.
     * @param setId               The document set ID.
     * @param version             The document version.
     * @param effectiveTime       The document effective time.
     * @param confidentialityCode The confidentiality code.
     * @param languageCode        The document main language.
     * @param patient             The targeted patient.
     * @param authors             The author(s).
     * @param custodian           The custodian.
     * @param recipients          The intended recipient(s).
     * @param narrativeText       The narrative text.
     * @param disEntryDigest      The DIS entry digest.
     */
    public EmedDisDocumentDigest(final String id,
                                 final String setId,
                                 final int version,
                                 final OffsetDateTime effectiveTime,
                                 final ConfidentialityCode confidentialityCode,
                                 final String languageCode,
                                 final PatientDigest patient,
                                 final List<@NonNull AuthorDigest> authors,
                                 final OrganizationDigest custodian,
                                 final List<@NonNull RecipientDigest> recipients,
                                 final StrucDocText narrativeText,
                                 final EmedDisEntryDigest disEntryDigest) {
        super(id, setId, version, effectiveTime, confidentialityCode, languageCode, patient, authors, custodian,
                recipients, narrativeText);
        this.disEntryDigest = Objects.requireNonNull(disEntryDigest);
    }

    /**
     * Returns the DIS entry contained in the document.
     */
    public EmedDisEntryDigest getDisEntryDigest() {
        return disEntryDigest;
    }

    /**
     * Returns the type of the Emed document.
     */
    public EmedDocumentType getEmedDocumentType() {
        return EmedDocumentType.DIS;
    }

    public String toString() {
        return "EmedDisDocumentDigest(super=" + super.toString() + ", disEntryDigest=" + this.getDisEntryDigest() + ")";
    }
}
