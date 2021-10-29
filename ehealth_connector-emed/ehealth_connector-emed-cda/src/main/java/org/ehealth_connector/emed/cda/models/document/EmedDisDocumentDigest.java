package org.ehealth_connector.emed.cda.models.document;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.ehealth_connector.emed.cda.enums.EmedDocumentType;
import org.ehealth_connector.emed.cda.generated.artdecor.enums.DocumentEntryConfidentialityCode;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.StrucDocText;
import org.ehealth_connector.emed.cda.models.common.AuthorDigest;
import org.ehealth_connector.emed.cda.models.common.OrganizationDigest;
import org.ehealth_connector.emed.cda.models.common.PatientDigest;
import org.ehealth_connector.emed.cda.models.common.RecipientDigest;
import org.ehealth_connector.emed.cda.models.entry.EmedDisEntryDigest;

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
                                 final DocumentEntryConfidentialityCode confidentialityCode,
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
