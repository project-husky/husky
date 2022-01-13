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

package org.husky.emed.ch.cda.services.digesters;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;
import org.husky.common.utils.datatypes.Uuids;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;
import org.husky.emed.ch.cda.services.readers.NameReader;
import org.husky.emed.ch.cda.utils.IiUtils;
import org.husky.emed.ch.cda.utils.IvlTsUtils;
import org.husky.emed.ch.cda.utils.TemplateIds;
import org.husky.emed.ch.ChEmedSpec;
import org.husky.emed.enums.CceDocumentType;
import org.husky.emed.errors.InvalidEmedContentException;
import org.husky.emed.models.common.AuthorDigest;
import org.husky.emed.models.common.OrganizationDigest;
import org.husky.emed.models.common.PatientDigest;
import org.husky.emed.models.common.RecipientDigest;
import org.husky.emed.models.document.*;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Digester of CDA-CH-EMED documents. It takes any CDA-CH-EMED document as an input and creates a digest (summary) of
 * it.
 *
 * @author Quentin Ligier
 */
@Component
public class CceDocumentDigester {

    /**
     * The CDA-CH-EMED entry digesters.
     */
    private final CceMtpEntryDigester mtpEntryDigester;
    private final CcePreEntryDigester preEntryDigester;
    private final CceDisEntryDigester disEntryDigester;
    private final CcePadvEntryDigester padvEntryDigester;

    /**
     * Constructor.
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
     * Returns the type of the CDA-CH-EMED document.
     *
     * @return an instance of {@link CceDocumentType}.
     */
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
     * <li>Three months after the document start time (see {@link ChEmedSpec#PRE_DEFAULT_DURATION_MONTHS}.
     * </ul>
     *
     * @param cce           The PRE document.
     * @param effectiveTime The document effective time.
     * @return the inclusive prescription validity stop time as an {@link Instant}.
     */
    @SideEffectFree
    public static Instant getPreValidityStopTime(final POCDMT000040ClinicalDocument cce,
                                                 final Instant effectiveTime) {
        return cce.getDocumentationOf().stream()
                .filter(documentationOf -> documentationOf.getTemplateId().isEmpty()) // The only one without template IDs
                .findAny()
                .map(POCDMT000040DocumentationOf::getServiceEvent)
                .map(POCDMT000040ServiceEvent::getEffectiveTime)
                .map(IvlTsUtils::getInclusiveHighInstant)
                .orElseGet(() -> {
                    ZonedDateTime localDateTime = DateTimes.getZonedDateTime(effectiveTime);
                    localDateTime = localDateTime.plusMonths(ChEmedSpec.PRE_DEFAULT_DURATION_MONTHS);
                    return localDateTime.toInstant();
                });
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
     * @throws IllegalArgumentException if the value is not in valid Base64 scheme. TODO throw
     *                                  InvalidEmedContentException
     */
    @SideEffectFree
    public static byte[] getPdfRepresentation(final POCDMT000040ClinicalDocument cce) {
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
                .map(b64 -> Base64.getDecoder().decode(b64))
                .orElse(new byte[]{});
    }

    /**
     * Returns the digest of the patient.
     *
     * @param cce The CDA-CH-EMED document.
     * @return the patient digest.
     */
    @SideEffectFree
    public static PatientDigest getPatientDigest(final POCDMT000040ClinicalDocument cce) {
        final var patientRole = Optional.of(cce.getRecordTarget())
                .map(OptionalUtils::getListOnlyElement)
                .map(POCDMT000040RecordTarget::getPatientRole)
                .filter(patientRole2 -> patientRole2.getPatient() != null)
                .orElseThrow();
        final var patient = patientRole.getPatient();
        final var names = new NameReader(patient.getName());
        return new PatientDigest(
                patientRole.getId().stream().map(IiUtils::getNormalizedCx).toList(),
                names.getFirstLegalFamilyName(),
                names.getFirstLegalGivenName(),
                Optional.ofNullable(patient.getAdministrativeGenderCode()).map(CD::getCode).map(AdministrativeGender::getEnum).orElseThrow(),
                Optional.ofNullable(patient.getBirthTime()).map(DateTimes::toLocalDate).orElse(null)
        );
    }

    /**
     * Creates a digest of a CDA-CH-EMED document and its entries.
     *
     * @param cce The CDA-CH-EMED document to digest.
     * @return an implementation of {@link EmedDocumentDigest}.
     */
    @SideEffectFree
    public EmedDocumentDigest digest(final POCDMT000040ClinicalDocument cce) throws InvalidEmedContentException {
        final var id = Optional.ofNullable(cce.getId()).map(II::getRoot).map(Uuids::normalize)
                .orElseThrow(() -> new InvalidEmedContentException("The document ID is missing"));
        final var setId = Optional.ofNullable(cce.getSetId()).map(II::getRoot).map(Uuids::normalize)
                .orElseThrow(() -> new InvalidEmedContentException("The document set ID is missing"));
        final var version = Optional.ofNullable(cce.getVersionNumber()).map(INT::getValue)
                .map(BigInteger::intValue)
                .orElseThrow(() -> new InvalidEmedContentException("The document version is missing"));
        final var effectiveTime = Optional.ofNullable(cce.getEffectiveTime()).map(TS::getValue)
                .map(Hl7Dtm::toOffsetDateTime)
                .orElseThrow(() -> new InvalidEmedContentException("The document effective time is missing"));
        final var confidentialityCode = Optional.ofNullable(cce.getConfidentialityCode())
                .map(CD::getCode).map(ConfidentialityCode::getEnum)
                .orElseThrow(() -> new InvalidEmedContentException("The confidentiality code is missing"));
        final var languageCode = Optional.ofNullable(cce.getLanguageCode()).map(CD::getCode)
                .orElseThrow(() -> new InvalidEmedContentException("The language code is missing"));

        final var patient = getPatientDigest(cce);
        final var authors = List.of(new AuthorDigest());
        final var custodian = new OrganizationDigest();
        final var recipients = List.of(new RecipientDigest());

        final var narrativeText = getNarrativeText(cce);
        final var contentSection = getContentSection(cce);

        final EmedDocumentDigest doc;
        switch (getDocumentType(cce)) {
            case MTP -> {
                final var mtpEntry = Optional.of(contentSection.getEntry())
                        .map(OptionalUtils::getListFirstElement)
                        .map(POCDMT000040Entry::getSubstanceAdministration)
                        .orElseThrow(() -> new InvalidEmedContentException("The MTP entry is missing"));
                final var mtpEntryDigest = this.mtpEntryDigester.createDigest(mtpEntry, id, effectiveTime.toInstant());
                doc = new EmedMtpDocumentDigest(id, setId, version, effectiveTime, confidentialityCode,
                        languageCode, patient, authors, custodian, recipients, narrativeText, mtpEntryDigest);
            }
            case PRE -> {
                final var preStartTime = getPreValidityStartTime(cce, effectiveTime.toInstant());
                final var preStopTime = getPreValidityStopTime(cce, effectiveTime.toInstant());
                final var preEntryDigests = Optional.of(contentSection.getEntry())
                        .orElse(Collections.emptyList()).stream()
                        .map(POCDMT000040Entry::getSubstanceAdministration)
                        .filter(Objects::nonNull)
                        .map(preEntry -> this.preEntryDigester.createDigest(preEntry, id, effectiveTime.toInstant(), preStartTime
                                , preStopTime))
                        .toList();

                doc = new EmedPreDocumentDigest(id, setId, version, effectiveTime, confidentialityCode, languageCode,
                        patient, authors, custodian, recipients, narrativeText, preEntryDigests, preStartTime, preStopTime);
            }
            case DIS -> {
                final var disEntryDigest = Optional.of(contentSection.getEntry())
                        .map(OptionalUtils::getListFirstElement)
                        .map(POCDMT000040Entry::getSupply)
                        .map(disEntry -> this.disEntryDigester.createDigest(disEntry, id, effectiveTime.toInstant()))
                        .orElseThrow(() -> new InvalidEmedContentException("The DIS entry is missing"));
                doc = new EmedDisDocumentDigest(id, setId, version, effectiveTime, confidentialityCode,
                        languageCode, patient, authors, custodian, recipients, narrativeText, disEntryDigest);
            }
            case PADV -> {
                final var padvEntryDigest = Optional.of(contentSection.getEntry())
                        .map(OptionalUtils::getListFirstElement)
                        .map(POCDMT000040Entry::getObservation)
                        .map(padvEntry -> this.padvEntryDigester.createDigest(padvEntry, id, effectiveTime.toInstant()))
                        .orElseThrow(() -> new InvalidEmedContentException("The PADV entry is missing"));
                doc = new EmedPadvDocumentDigest(id, setId, version, effectiveTime, confidentialityCode,
                        languageCode, patient, authors, custodian, recipients, narrativeText, padvEntryDigest);
            }
            case PML -> {
                // TODO: items: document dates are not available.
                throw new UnsupportedOperationException("PML digestion not available yet");
                /*doc = new EmedPmlDocumentDigest(id, setId, version, effectiveTime, confidentialityCode,
                        languageCode, patient, authors, custodian, recipients, narrativeText, );*/
            }
            case PMLC -> {
                final var mtpEntryDigests = Optional.of(contentSection.getEntry())
                        .orElse(Collections.emptyList()).stream()
                        .map(POCDMT000040Entry::getSubstanceAdministration)
                        .filter(Objects::nonNull)
                        .map(mtpEntry -> this.mtpEntryDigester.createDigest(mtpEntry, id, effectiveTime.toInstant()))
                        .toList();
                doc = new EmedPmlcDocumentDigest(id, setId, version, effectiveTime, confidentialityCode,
                        languageCode, patient, authors, custodian, recipients, narrativeText, mtpEntryDigests);
            }
            default -> throw new UnsupportedOperationException("Unknown document type");
        }
        doc.setRemarks(getRemarks(cce));
        doc.setPdfRepresentation(getPdfRepresentation(cce));
        return doc;
    }
}
