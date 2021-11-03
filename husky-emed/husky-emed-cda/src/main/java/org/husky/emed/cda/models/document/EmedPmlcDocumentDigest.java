package org.husky.emed.cda.models.document;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.husky.emed.cda.enums.EmedDocumentType;
import org.husky.emed.cda.generated.artdecor.enums.DocumentEntryConfidentialityCode;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.emed.cda.models.common.AuthorDigest;
import org.husky.emed.cda.models.common.OrganizationDigest;
import org.husky.emed.cda.models.common.PatientDigest;
import org.husky.emed.cda.models.common.RecipientDigest;
import org.husky.emed.cda.models.entry.EmedMtpEntryDigest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the digest of a PMLC Emed document.
 *
 * @author Quentin Ligier
 */
public class EmedPmlcDocumentDigest extends EmedDocumentDigest {

    /**
     * The MTP entries contained in the document.
     */
    private final List<@NonNull EmedMtpEntryDigest> mtpEntryDigests = new ArrayList<>();

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
     * @param mtpEntryDigests     The MTP entry digests.
     */
    public EmedPmlcDocumentDigest(final String id,
                                  final String setId,
                                  final int version,
                                  final OffsetDateTime effectiveTime,
                                  final DocumentEntryConfidentialityCode confidentialityCode,
                                  final String languageCode,
                                  final PatientDigest patient,
                                  final List<@NonNull AuthorDigest> authors,
                                  final OrganizationDigest custodian,
                                  final List<@NonNull RecipientDigest> recipients,
                                  final StrucDocText narrativeText,
                                  final List<@NonNull EmedMtpEntryDigest> mtpEntryDigests) {
        super(id, setId, version, effectiveTime, confidentialityCode, languageCode, patient, authors, custodian,
                recipients, narrativeText);
        this.mtpEntryDigests.addAll(Objects.requireNonNull(mtpEntryDigests));
    }

    /**
     * Returns the MTP entries contained in the document.
     */
    public List<@NonNull EmedMtpEntryDigest> getMtpEntryDigests() {
        return mtpEntryDigests;
    }

    /**
     * Returns the type of the Emed document.
     */
    public EmedDocumentType getEmedDocumentType() {
        return EmedDocumentType.PMLC;
    }

    public String toString() {
        return "EmedPmlcDocumentDigest(super=" + super.toString() + ", mtpEntryDigests=" + this.getMtpEntryDigests() +
                ")";
    }
}
