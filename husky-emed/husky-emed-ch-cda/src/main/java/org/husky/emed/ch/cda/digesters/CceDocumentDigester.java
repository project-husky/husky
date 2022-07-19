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
import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.cda.utils.IiUtils;
import org.husky.emed.ch.cda.utils.IvlTsUtils;
import org.husky.emed.ch.cda.utils.TemplateIds;
import org.husky.emed.ch.cda.utils.readers.*;
import org.husky.emed.ch.enums.CceDocumentType;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.errors.InvalidMedicationTreatmentStateException;
import org.husky.emed.ch.models.common.OrganizationDigest;
import org.husky.emed.ch.models.common.PatientDigest;
import org.husky.emed.ch.models.common.RecipientDigest;
import org.husky.emed.ch.models.document.*;
import org.husky.emed.ch.models.entry.EmedEntryDigest;

import java.math.BigInteger;
import java.time.Instant;
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
    private final CceMtpEntryDigester mtpEntryDigester;
    @Nullable
    private final CcePreEntryDigester preEntryDigester;
    @Nullable
    private final CceDisEntryDigester disEntryDigester;
    @Nullable
    private final CcePadvEntryDigester padvEntryDigester;

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

        final var patient = getPatientDigest(cce);
        final var authors = cce.getAuthor().stream()
                .map(AuthorReader::new)
                .map(AuthorReader::toDigest)
                .toList();

        final var custodian = getCustodian(cce);
        final var recipients = getRecipients(cce);

        final StrucDocText narrativeText = getNarrativeText(cce);
        final var contentSection = getContentSection(cce);
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
        switch (getDocumentType(cce)) {
            case MTP -> {
                final var mtpEntry = Optional.of(contentSection.getEntry())
                        .map(OptionalUtils::getListFirstElement)
                        .map(POCDMT000040Entry::getSubstanceAdministration)
                        .orElseThrow(() -> new InvalidEmedContentException("The MTP entry is missing"));
                final var mtpEntryDigest = this.mtpEntryDigester.createDigest(mtpEntry, id,
                        documentationTime, authors.get(0), sectionAuthor);
                doc = new EmedMtpDocumentDigest(id, setId, version, creationTime, documentationTime,
                        confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                        mtpEntryDigest);
            }
            case PRE -> {
                if (this.preEntryDigester == null) {
                    throw new NullPointerException("The PRE document digester is null");
                }

                final var preStartTime = getPreValidityStartTime(cce, creationTime.toInstant());
                final var preStopTime = getPreValidityStopTime(cce);
                final var preEntryDigests = Optional.of(contentSection.getEntry())
                        .orElse(Collections.emptyList()).stream()
                        .map(POCDMT000040Entry::getSubstanceAdministration)
                        .filter(Objects::nonNull)
                        .map(preEntry -> this.preEntryDigester.createDigest(preEntry, id, documentationTime, preStartTime
                                , preStopTime, authors.get(0), sectionAuthor))
                        .toList();

                doc = new EmedPreDocumentDigest(id, setId, version, creationTime, documentationTime,
                        confidentialityCode, languageCode, patient, authors, custodian, recipients, narrativeText,
                        preEntryDigests, preStartTime, preStopTime);
            }
            case DIS -> {
                if (this.disEntryDigester == null) {
                    throw new NullPointerException("The DIS document digester is null");
                }

                final var disEntryDigest = Optional.of(contentSection.getEntry())
                        .map(OptionalUtils::getListFirstElement)
                        .map(POCDMT000040Entry::getSupply)
                        .map(disEntry -> this.disEntryDigester.createDigest(disEntry, id, documentationTime, authors.get(0), sectionAuthor))
                        .orElseThrow(() -> new InvalidEmedContentException("The DIS entry is missing"));
                doc = new EmedDisDocumentDigest(id, setId, version, creationTime, documentationTime, confidentialityCode,
                        languageCode, patient, authors, custodian, recipients, narrativeText, disEntryDigest);
            }
            case PADV -> {
                if (this.padvEntryDigester == null) {
                    throw new NullPointerException("The PADV document digester is null");
                }

                final var padvEntryDigest = Optional.of(contentSection.getEntry())
                        .map(OptionalUtils::getListFirstElement)
                        .map(POCDMT000040Entry::getObservation)
                        .map(padvEntry -> this.padvEntryDigester.createDigest(padvEntry, id, documentationTime, authors.get(0), sectionAuthor))
                        .orElseThrow(() -> new InvalidEmedContentException("The PADV entry is missing"));
                doc = new EmedPadvDocumentDigest(id, setId, version, creationTime, documentationTime, confidentialityCode,
                        languageCode, patient, authors, custodian, recipients, narrativeText, padvEntryDigest);
            }
            case PML -> throw new UnsupportedOperationException("PML digestion not available");
            case PMLC -> {
                final var mtpEntryDigests = Optional.of(contentSection.getEntry())
                        .orElse(Collections.emptyList()).stream()
                        .map(POCDMT000040Entry::getSubstanceAdministration)
                        .filter(Objects::nonNull)
                        .map(mtpEntry -> this.mtpEntryDigester.createDigest(mtpEntry, id, documentationTime, authors.get(0), sectionAuthor))
                        .toList();
                doc = new EmedPmlcDocumentDigest(id, setId, version, creationTime, documentationTime, confidentialityCode,
                        languageCode, patient, authors, custodian, recipients, narrativeText, mtpEntryDigests);
            }
            default -> throw new UnsupportedOperationException("Unknown document type");
        }
        doc.setRemarks(getRemarks(cce));
        doc.setPdfRepresentation(getPdfRepresentation(cce).orElse(new byte[]{}));
        return doc;
    }

    /**
     * Returns the type of the CDA-CH-EMED document.
     *
     * @return an instance of {@link CceDocumentType}.
     * @throws InvalidEmedContentException if the document type IDs cannot be found.
     */
    @SideEffectFree
    public static CceDocumentType getDocumentType(final POCDMT000040ClinicalDocument cce) {
        if (TemplateIds.hasAllIds(TemplateIds.MTP_DOCUMENT, cce.getTemplateId())) {
            return CceDocumentType.MTP;
        } else if (TemplateIds.hasAllIds(TemplateIds.PRE_DOCUMENT, cce.getTemplateId())) {
            return CceDocumentType.PRE;
        } else if (TemplateIds.hasAllIds(TemplateIds.DIS_DOCUMENT, cce.getTemplateId())) {
            return CceDocumentType.DIS;
        } else if (TemplateIds.hasAllIds(TemplateIds.PADV_DOCUMENT, cce.getTemplateId())) {
            return CceDocumentType.PADV;
        } else if (TemplateIds.hasAllIds(TemplateIds.PML_DOCUMENT, cce.getTemplateId())) {
            return CceDocumentType.PML;
        } else if (TemplateIds.hasAllIds(TemplateIds.PMLC_DOCUMENT, cce.getTemplateId())) {
            return CceDocumentType.PMLC;
        } else {
            throw new InvalidEmedContentException("The CDA-CH-EMED has invalid template IDs");
        }
    }

    /**
     * Returns the starting time of the PRE document. It's the first known time from:
     * <ul>
     * <li>The start date of the 'documentationOf' attribute of the PRE document;
     * <li>The creationTime of the document.
     * </ul>
     *
     * @param cce           The PRE document.
     * @param effectiveTime The document effective time.
     * @return the inclusive prescription validity start time as an {@link Instant}.
     */
    @SideEffectFree
    public static Instant getPreValidityStartTime(final POCDMT000040ClinicalDocument cce,
                                                  final Instant effectiveTime) {
        return cce.getDocumentationOf().stream()
                .filter(documentationOf -> documentationOf.getTemplateId().isEmpty()) // The only one without template IDs
                .findAny()
                .map(POCDMT000040DocumentationOf::getServiceEvent)
                .map(POCDMT000040ServiceEvent::getEffectiveTime)
                .map(IvlTsUtils::getInclusiveLowInstant)
                .orElse(effectiveTime);
    }

    /**
     * Returns the ending time of the PRE document. It's the first known time from:
     * <ul>
     * <li>The end date of the 'documentationOf' attribute of the MTP document.
     * </ul>
     *
     * @param cce The PRE document.
     * @return the inclusive prescription validity stop time as an {@link Instant} or {@code null}.
     */
    @SideEffectFree
    @Nullable
    public static Instant getPreValidityStopTime(final POCDMT000040ClinicalDocument cce) {
        return cce.getDocumentationOf().stream()
                .filter(documentationOf -> documentationOf.getTemplateId().isEmpty()) // The only one without template IDs
                .findAny()
                .map(POCDMT000040DocumentationOf::getServiceEvent)
                .map(POCDMT000040ServiceEvent::getEffectiveTime)
                .map(IvlTsUtils::getInclusiveHighInstant)
                .orElse(null);
    }

    /**
     * Returns the structured content section in the document.
     *
     * @param cce The CDA-CH-EMED document.
     * @throws InvalidEmedContentException if the section is missing.
     */
    public static POCDMT000040Section getContentSection(final POCDMT000040ClinicalDocument cce) throws InvalidEmedContentException {
        return Optional.ofNullable(cce.getComponent())
                .map(POCDMT000040Component2::getStructuredBody)
                .map(POCDMT000040StructuredBody::getComponent)
                .orElse(Collections.emptyList())
                .stream()
                .map(POCDMT000040Component3::getSection)
                .filter(Objects::nonNull)
                .filter(section -> TemplateIds.hasAllIds(TemplateIds.MTP_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PRE_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.DIS_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PADV_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PML_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PMLC_SECTION, section.getTemplateId()))
                .findAny()
                .orElseThrow(() -> new InvalidEmedContentException("The CCE document is missing its section"));
    }

    /**
     * Returns the document's narrative text.
     *
     * @param cce The CDA-CH-EMED document.
     * @return the narrative text as structured text.
     * @throws InvalidEmedContentException if the narrative text is missing.
     */
    @SideEffectFree
    public static StrucDocText getNarrativeText(final POCDMT000040ClinicalDocument cce) {
        return Optional.of(getContentSection(cce))
                .map(POCDMT000040Section::getText)
                .orElseThrow(() -> new InvalidEmedContentException("Unable to retrieve the narrative text"));

    }

    /**
     * Returns the content of the remarks section.
     *
     * @param cce The CDA-CH-EMED document.
     * @return the remarks text or {@code null} if it was not provided.
     */
    @Nullable
    @SideEffectFree
    public static StrucDocText getRemarks(final POCDMT000040ClinicalDocument cce) {
        return Optional.ofNullable(cce.getComponent())
                .map(POCDMT000040Component2::getStructuredBody)
                .map(POCDMT000040StructuredBody::getComponent)
                .orElse(Collections.emptyList())
                .stream()
                .map(POCDMT000040Component3::getSection)
                .filter(Objects::nonNull)
                .filter(section -> TemplateIds.isInList(TemplateIds.REMARKS_SECTION, section.getTemplateId()))
                .findAny()
                .map(POCDMT000040Section::getText)
                .orElse(null);
    }

    /**
     * Returns the original representation as a PDF content, if present. It's decoded from the Base64 scheme.
     *
     * @param cce The CDA-CH-EMED document.
     * @return an optional that may contain the PDF content as a byte array.
     * @throws InvalidEmedContentException if the value is not in valid Base64 scheme.
     */
    @SideEffectFree
    public static Optional<byte[]> getPdfRepresentation(final POCDMT000040ClinicalDocument cce) {
        return Optional.ofNullable(cce.getComponent())
                .map(POCDMT000040Component2::getStructuredBody)
                .map(POCDMT000040StructuredBody::getComponent)
                .orElse(Collections.emptyList())
                .stream()
                .map(POCDMT000040Component3::getSection)
                .filter(Objects::nonNull)
                .filter(section -> TemplateIds.isInList(TemplateIds.ORIGINAL_REPRESENTATION_SECTION, section.getTemplateId()))
                .findAny()
                .map(POCDMT000040Section::getEntry)
                .map(OptionalUtils::getListFirstElement)
                .map(POCDMT000040Entry::getObservationMedia)
                .map(POCDMT000040ObservationMedia::getValue)
                .map(ED::getTextContent)
                .map(b64 -> {
                    try {
                        return Base64.getDecoder().decode(b64);
                    } catch (final IllegalArgumentException exception) {
                        throw new InvalidEmedContentException("The original representation is badly encoded",
                                exception);
                    }
                });
    }

    /**
     * Returns the digest of the patient.
     *
     * @param cce The CDA-CH-EMED document.
     * @return the patient digest.
     * @throws InvalidEmedContentException if the patient is incomplete.
     */
    @SideEffectFree
    public static PatientDigest getPatientDigest(final POCDMT000040ClinicalDocument cce) {
        final var patientRole = Optional.of(cce.getRecordTarget())
                .map(OptionalUtils::getListOnlyElement)
                .map(POCDMT000040RecordTarget::getPatientRole)
                .filter(patientRole2 -> patientRole2.getPatient() != null)
                .orElseThrow(() -> new InvalidEmedContentException("The patient is missing"));
        final var patient = Objects.requireNonNull(patientRole.getPatient());
        final var names = new NameReader(patient.getName());
        return new PatientDigest(
                patientRole.getId().stream().map(IiUtils::toQualifiedIdentifier).toList(),
                names.getFirstLegalGivenName(),
                names.getFirstLegalFamilyName(),
                Optional.ofNullable(patient.getAdministrativeGenderCode()).map(CD::getCode).map(AdministrativeGender::getEnum).orElse(null),
                Optional.ofNullable(patient.getBirthTime()).map(DateTimes::toLocalDate).orElse(null)
        );
    }

    /**
     * Returns the digest of the custodian.
     *
     * @param cce The CDA-CH-EMED document.
     * @return the custodian digest.
     * @throws InvalidEmedContentException if the custodian is incomplete.
     */
    @SideEffectFree
    public static OrganizationDigest getCustodian(final POCDMT000040ClinicalDocument cce) {
        final var custodian = Optional.ofNullable(cce.getCustodian())
                .map(POCDMT000040Custodian::getAssignedCustodian)
                .map(POCDMT000040AssignedCustodian::getRepresentedCustodianOrganization)
                .orElseThrow(() -> new InvalidEmedContentException("The custodian is missing"));

        final var name = Optional.ofNullable(custodian.getName())
                .map(ANY::getMergedXmlMixed)
                .orElseThrow(() -> new InvalidEmedContentException("The custodian is missing their name"));
        final var telecoms = Optional.ofNullable(custodian.getTelecom())
                .map(List::of)
                .orElse(Collections.emptyList());
        final var address = Optional.ofNullable(custodian.getAddr())
                .map(AddressReader::new)
                .map(AddressReader::toDigest)
                .map(List::of)
                .orElse(Collections.emptyList());

        return new OrganizationDigest(
                custodian.getId().stream().map(IiUtils::toQualifiedIdentifier).toList(),
                List.of(name),
                new TelecomReader(telecoms).toDigest(),
                address
        );
    }

    /**
     * Returns the digests of the recipients.
     *
     * @param cce The CDA-CH-EMED document.
     * @return the recipient digests.
     */
    @SideEffectFree
    public static List<@NonNull RecipientDigest> getRecipients(final POCDMT000040ClinicalDocument cce) {
        return cce.getInformationRecipient().stream()
                .map(informationRecipient -> {
                    final var recipient = Objects.requireNonNull(informationRecipient.getIntendedRecipient());
                    final var organization = Optional.ofNullable(recipient.getReceivedOrganization())
                            .map(OrganizationReader::new)
                            .map(OrganizationReader::toDigest)
                            .orElse(null);
                    return new RecipientDigest(
                            informationRecipient.getTypeCode() != XInformationRecipient.TRC,
                            recipient.getId(),
                            recipient.getAddr().stream().map(AddressReader::new).map(AddressReader::toDigest).toList(),
                            new TelecomReader(recipient.getTelecom()).toDigest(),
                            organization
                    );
                }).toList();
    }
}
