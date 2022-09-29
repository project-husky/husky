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
package org.husky.emed.ch.cda.digesters;

import org.apache.commons.lang3.ObjectUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.husky.common.ch.enums.stable.ConfidentialityCode;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;
import org.husky.common.utils.time.Hl7Dtm;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.cda.utils.IiUtils;
import org.husky.emed.ch.cda.utils.readers.AuthorReader;
import org.husky.emed.ch.cda.utils.readers.ClinicalDocumentReader;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.errors.InvalidMedicationTreatmentStateException;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.OrganizationDigest;
import org.husky.emed.ch.models.common.PatientDigest;
import org.husky.emed.ch.models.common.RecipientDigest;
import org.husky.emed.ch.models.document.*;
import org.husky.emed.ch.models.entry.EmedEntryDigest;

import java.math.BigInteger;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * Digester of CDA-CH-EMED documents. It takes any CDA-CH-EMED document as an input and creates a digest (summary) of
 * it.
 *
 * @author Quentin Ligier
 */
public class CceDocumentDigester {

    /**
     * The CDA-CH-EMED entry digesters.
     */
    protected final CceMtpEntryDigester mtpEntryDigester;
    @Nullable
    protected final CcePreEntryDigester preEntryDigester;
    @Nullable
    protected final CceDisEntryDigester disEntryDigester;
    @Nullable
    protected final CcePadvEntryDigester padvEntryDigester;

    /**
     * Constructor without parameters. It can only digest MTP, PMLC and PML (with only MTP item entries) documents.
     */
    public CceDocumentDigester() {
        this.mtpEntryDigester = new CceMtpEntryDigester();
        this.preEntryDigester = null;
        this.disEntryDigester = null;
        this.padvEntryDigester = null;
    }

    /**
     * Constructor with the eMed entry service. Default digesters will be instantiated with it.
     *
     * @param emedEntryService The registry of {@link EmedEntryDigest}.
     */
    public CceDocumentDigester(final EmedEntryDigestService emedEntryService) {
        Objects.requireNonNull(emedEntryService, "emedEntryService shall not be null in CceDocumentDigester()");
        this.mtpEntryDigester = new CceMtpEntryDigester();
        this.preEntryDigester = new CcePreEntryDigester(emedEntryService);
        this.disEntryDigester = new CceDisEntryDigester(emedEntryService);
        this.padvEntryDigester = new CcePadvEntryDigester(emedEntryService, this.mtpEntryDigester, this.preEntryDigester);
    }

    /**
     * Constructor with all four digesters. Useful if you need to overwrite them for some reason.
     *
     * @param mtpEntryDigester  The MTP entry digester.
     * @param preEntryDigester  The PRE entry digester.
     * @param disEntryDigester  The DIS entry digester.
     * @param padvEntryDigester The PADV entry digester.
     */
    public CceDocumentDigester(final CceMtpEntryDigester mtpEntryDigester,
                               final CcePreEntryDigester preEntryDigester,
                               final CceDisEntryDigester disEntryDigester,
                               final CcePadvEntryDigester padvEntryDigester) {
        this.mtpEntryDigester = Objects.requireNonNull(mtpEntryDigester);
        this.preEntryDigester = Objects.requireNonNull(preEntryDigester);
        this.disEntryDigester = Objects.requireNonNull(disEntryDigester);
        this.padvEntryDigester = Objects.requireNonNull(padvEntryDigester);
    }

    /**
     * Creates a digest of a CDA-CH-EMED document and its entries.
     *
     * @param cce The CDA-CH-EMED document to digest.
     * @return an implementation of {@link EmedDocumentDigest}.
     * @throws InvalidEmedContentException              if the CCE document is invalid.
     * @throws InvalidMedicationTreatmentStateException if the treatment state is invalid.
     */
    @SideEffectFree
    public EmedDocumentDigest digest(final POCDMT000040ClinicalDocument cce) throws InvalidEmedContentException, InvalidMedicationTreatmentStateException {
        final UUID id = Optional.ofNullable(cce.getId()).map(IiUtils::getUuid)
                .orElseThrow(() -> new InvalidEmedContentException("The document ID is missing"));
        final UUID setId = Optional.ofNullable(cce.getSetId()).map(IiUtils::getUuid)
                .orElseThrow(() -> new InvalidEmedContentException("The document set ID is missing"));
        final int version = Optional.ofNullable(cce.getVersionNumber()).map(INT::getValue)
                .map(BigInteger::intValue)
                .orElseThrow(() -> new InvalidEmedContentException("The document version is missing"));
        final var creationTime = Optional.ofNullable(cce.getEffectiveTime()).map(TS::getValue)
                .map(Hl7Dtm::toOffsetDateTime)
                .orElseThrow(() -> new InvalidEmedContentException("The document effective time is missing"));
        final var confidentialityCode = Optional.ofNullable(cce.getConfidentialityCode())
                .map(CD::getCode).map(ConfidentialityCode::getEnum)
                .orElseThrow(() -> new InvalidEmedContentException("The confidentiality code is missing"));
        final String languageCode = Optional.ofNullable(cce.getLanguageCode()).map(CD::getCode)
                .orElseThrow(() -> new InvalidEmedContentException("The language code is missing"));

        final var reader = new ClinicalDocumentReader(cce);
        final var patient = reader.getPatientDigest();
        final var authors = cce.getAuthor().stream()
                .map(AuthorReader::new)
                .map(AuthorReader::toDigest)
                .toList();

        final var custodian = reader.getCustodian();
        final var recipients = reader.getRecipients();

        final StrucDocText narrativeText = reader.getNarrativeText();
        final var contentSection = reader.getContentSection();
        final var sectionAuthor = Optional.of(contentSection.getAuthor())
                .map(OptionalUtils::getListFirstElement)
                .map(AuthorReader::new)
                .map(AuthorReader::toDigest)
                .orElseGet(() -> authors.get(0));

        final Instant documentationTime = ObjectUtils.firstNonNull(
                sectionAuthor.getAuthorshipTimestamp(),
                authors.get(0).getAuthorshipTimestamp(),
                creationTime.toInstant()
        );

        final EmedDocumentDigest doc;
        switch (reader.getDocumentType()) {
            case MTP -> doc = this.createMtpDigest(id, setId, version, creationTime, documentationTime,
                    confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                    contentSection, sectionAuthor);
            case PRE -> doc = this.createPreDigest(id, setId, version, creationTime, documentationTime,
                    confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                    contentSection, sectionAuthor, reader);
            case DIS -> doc = this.createDisDigest(id, setId, version, creationTime, documentationTime,
                    confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                    contentSection, sectionAuthor);
            case PADV -> doc = this.createPadvDigest(id, setId, version, creationTime, documentationTime,
                    confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                    contentSection, sectionAuthor);
            case PML -> throw new UnsupportedOperationException("PML digestion not available");
            case PMLC -> doc = this.createPmlcDigest(id, setId, version, creationTime, documentationTime,
                    confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                    contentSection, sectionAuthor);
            default -> throw new UnsupportedOperationException("Unknown document type");
        }
        doc.setRemarks(reader.getRemarks());
        doc.setPdfRepresentation(reader.getPdfRepresentation().orElse(new byte[]{}));
        return doc;
    }

    protected EmedMtpDocumentDigest createMtpDigest(final UUID id,
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
                                                    final POCDMT000040Section contentSection,
                                                    final AuthorDigest sectionAuthor) {
        final var mtpEntry = Optional.of(contentSection.getEntry())
                .map(OptionalUtils::getListFirstElement)
                .map(POCDMT000040Entry::getSubstanceAdministration)
                .orElseThrow(() -> new InvalidEmedContentException("The MTP entry is missing"));
        final var mtpEntryDigest = this.mtpEntryDigester.createDigest(mtpEntry, id,
                documentationTime, authors.get(0), sectionAuthor);
        return new EmedMtpDocumentDigest(id, setId, version, creationTime, documentationTime,
                confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                mtpEntryDigest);
    }

    protected EmedPreDocumentDigest createPreDigest(final UUID id,
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
                                                    final POCDMT000040Section contentSection,
                                                    final AuthorDigest sectionAuthor,
                                                    final ClinicalDocumentReader reader) {
        if (this.preEntryDigester == null) {
            throw new NullPointerException("The PRE document digester is null");
        }

        final var preStartTime = reader.getPreValidityStartTime(creationTime.toInstant());
        final var preStopTime = reader.getPreValidityStopTime();
        final var preEntryDigests = Optional.of(contentSection.getEntry())
                .orElse(Collections.emptyList()).stream()
                .map(POCDMT000040Entry::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .map(preEntry -> this.preEntryDigester.createDigest(preEntry, id, documentationTime, preStartTime
                        , preStopTime, authors.get(0), sectionAuthor))
                .toList();

        return new EmedPreDocumentDigest(id, setId, version, creationTime, documentationTime,
                confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                preEntryDigests, preStartTime, preStopTime);
    }

    protected EmedDisDocumentDigest createDisDigest(final UUID id,
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
                                                    final POCDMT000040Section contentSection,
                                                    final AuthorDigest sectionAuthor) {
        if (this.disEntryDigester == null) {
            throw new NullPointerException("The DIS document digester is null");
        }

        final var disEntryDigest = Optional.of(contentSection.getEntry())
                .map(OptionalUtils::getListFirstElement)
                .map(POCDMT000040Entry::getSupply)
                .map(disEntry -> this.disEntryDigester.createDigest(disEntry, id, documentationTime, authors.get(0), sectionAuthor))
                .orElseThrow(() -> new InvalidEmedContentException("The DIS entry is missing"));
        return new EmedDisDocumentDigest(id, setId, version, creationTime, documentationTime, confidentialityCode,
                languageCode, patient, authors, custodian, recipients, narrativeText, disEntryDigest);
    }

    protected EmedPadvDocumentDigest createPadvDigest(final UUID id,
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
                                                      final POCDMT000040Section contentSection,
                                                      final AuthorDigest sectionAuthor) {
        if (this.padvEntryDigester == null) {
            throw new NullPointerException("The PADV document digester is null");
        }

        final var padvEntryDigest = Optional.of(contentSection.getEntry())
                .map(OptionalUtils::getListFirstElement)
                .map(POCDMT000040Entry::getObservation)
                .map(padvEntry -> this.padvEntryDigester.createDigest(padvEntry, id, documentationTime, authors.get(0), sectionAuthor))
                .orElseThrow(() -> new InvalidEmedContentException("The PADV entry is missing"));
        return new EmedPadvDocumentDigest(id, setId, version, creationTime, documentationTime, confidentialityCode,
                languageCode, patient, authors, custodian, recipients, narrativeText, padvEntryDigest);
    }

    protected EmedPmlcDocumentDigest createPmlcDigest(final UUID id,
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
                                                      final POCDMT000040Section contentSection,
                                                      final AuthorDigest sectionAuthor) {
        final var mtpEntryDigests = Optional.of(contentSection.getEntry())
                .orElse(Collections.emptyList()).stream()
                .map(POCDMT000040Entry::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .map(mtpEntry -> this.mtpEntryDigester.createDigest(mtpEntry, id, documentationTime, authors.get(0), sectionAuthor))
                .toList();
        return new EmedPmlcDocumentDigest(id, setId, version, creationTime, documentationTime, confidentialityCode,
                languageCode, patient, authors, custodian, recipients, narrativeText, mtpEntryDigests);
    }
}
