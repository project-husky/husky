/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.digesters;

import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.cda.utils.CdaR2Utils;
import org.husky.emed.ch.cda.utils.EntryRelationshipUtils;
import org.husky.emed.ch.cda.utils.IiUtils;
import org.husky.emed.ch.cda.utils.TemplateIds;
import org.husky.emed.ch.cda.utils.readers.AuthorReader;
import org.husky.emed.ch.cda.utils.readers.DosageInstructionsReader;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.enums.PharmaceuticalAdviceStatus;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.errors.InvalidMedicationTreatmentStateException;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;
import org.husky.emed.ch.models.entry.*;
import org.husky.emed.ch.models.entry.padv.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.husky.emed.ch.cda.utils.TemplateIds.*;

/**
 * Creator of CDA-CH-EMED MTP item entry digests.
 *
 * @author Quentin Ligier
 */
@Component
public class CcePadvEntryDigester {

    /**
     * The registry of {@link EmedEntryDigest}.
     */
    private final EmedEntryDigestService emedEntryService;

    /**
     * The MTP entry digester.
     */
    private final CceMtpEntryDigester mtpEntryDigester;

    /**
     * The PRE entry digester.
     */
    private final CcePreEntryDigester preEntryDigester;

    /**
     * Constructor.
     *
     * @param emedEntryService The registry of {@link EmedEntryDigest}.
     * @param mtpEntryDigester The MTP entry digester.
     * @param preEntryDigester The PRE entry digester.
     */
    public CcePadvEntryDigester(final EmedEntryDigestService emedEntryService,
                                final CceMtpEntryDigester mtpEntryDigester,
                                final CcePreEntryDigester preEntryDigester) {
        this.emedEntryService = Objects.requireNonNull(emedEntryService);
        this.mtpEntryDigester = Objects.requireNonNull(mtpEntryDigester);
        this.preEntryDigester = Objects.requireNonNull(preEntryDigester);
    }

    /**
     * Creates a new {@link EmedPadvEntryDigest} from an PADV Observation element.
     *
     * @param observation               The PADV Observation element.
     * @param padvDocumentId            The MTP document ID.
     * @param padvDocumentEffectiveTime The MTP document effective time.
     * @param parentDocumentAuthor      The parent document author (not the original document author).
     * @param parentSectionAuthor       The parent section author (not the original section author).
     * @return a digest of the element.
     * @throws InvalidEmedContentException              if the CCE document is invalid.
     * @throws InvalidMedicationTreatmentStateException if the treatment state is invalid.
     */
    protected EmedPadvEntryDigest createDigest(final POCDMT000040Observation observation,
                                               final UUID padvDocumentId,
                                               final Instant padvDocumentEffectiveTime,
                                               final AuthorDigest parentDocumentAuthor,
                                               final AuthorDigest parentSectionAuthor) throws InvalidEmedContentException, InvalidMedicationTreatmentStateException {
        final var entryId = this.getEntryId(observation);
        final var isCompleted = this.isCompleted(observation);

        // If the effectiveTime is not present, the observation becomes effective at the creation date of the document
        // (6.3.4.3.3.7)
        final Instant effectiveTime = this.getEffectiveTime(observation).orElse(padvDocumentEffectiveTime);

        // Fetch the referenced item
        final var refItemId = Objects.requireNonNull(this.getItemReference(observation).getEntryId());
        final EmedEntryDigest refEntryDigest = this.emedEntryService.getById(refItemId)
                .orElseThrow(() -> new InvalidEmedContentException("Unable to find an item entry digest"));
        final var targetedEntryType = refEntryDigest.getEmedEntryType();
        final var targetedEntryRef = new EmedReference(refEntryDigest.getDocumentId(), refEntryDigest.getEntryId());
        final var sequence = (int) this.emedEntryService.getSequence(refEntryDigest.getMedicationTreatmentId(),
                padvDocumentEffectiveTime);
        final var medicationTreatmentId = refEntryDigest.getMedicationTreatmentId();
        final var annotationComment = this.getAnnotationComment(observation).orElse(null);

        final AuthorDigest documentAuthor;
        final AuthorDigest sectionAuthor;
        if (observation.getAuthor().size() == 2) {
            sectionAuthor = new AuthorReader(observation.getAuthor().get(0)).toDigest();
            documentAuthor = new AuthorReader(observation.getAuthor().get(1)).toDigest();
        } else if (observation.getAuthor().size() == 1) {
            sectionAuthor = new AuthorReader(observation.getAuthor().get(0)).toDigest();
            documentAuthor = sectionAuthor;
        } else {
            documentAuthor = parentDocumentAuthor;
            sectionAuthor = parentSectionAuthor;
        }

        return switch (this.getStatus(observation)) {
            case OK -> {
                final var recommendedPrescriptions = observation.getEntryRelationship().stream()
                        .map(POCDMT000040EntryRelationship::getOrganizer)
                        .filter(Objects::nonNull)
                        .map(POCDMT000040Organizer::getComponent)
                        .map(OptionalUtils::getListOnlyElement)
                        .filter(Objects::nonNull)
                        .map(POCDMT000040Component4::getSubstanceAdministration)
                        .filter(Objects::nonNull)
                        .map(subAdm -> {
                            final EmedEntryDigest targetedEntry =
                                    this.emedEntryService.getById(Objects.requireNonNull(targetedEntryRef.getEntryId()))
                                            .orElseThrow(() -> new InvalidMedicationTreatmentStateException(String.format("The " +
                                                            "referenced %s is unknown",
                                                    targetedEntryRef.toText())));
                            if (targetedEntry instanceof final EmedPreEntryDigest targetedPreEntry) {
                                return this.preEntryDigester.createDigest(
                                        subAdm,
                                        padvDocumentId,
                                        targetedPreEntry.getPrescriptionTime(),
                                        targetedPreEntry.getPrescriptionDocumentValidityStart(),
                                        targetedPreEntry.getPrescriptionDocumentValidityStop(),
                                        documentAuthor,
                                        sectionAuthor);
                            }
                            throw new InvalidEmedContentException("The reference to a PRE entry cannot be found");
                        })
                        .toList();
                yield new EmedPadvOkEntryDigest(
                        padvDocumentEffectiveTime,
                        padvDocumentId,
                        documentAuthor,
                        sectionAuthor,
                        entryId,
                        medicationTreatmentId,
                        sequence,
                        annotationComment,
                        isCompleted,
                        effectiveTime,
                        targetedEntryRef,
                        targetedEntryType,
                        recommendedPrescriptions
                );
            }
            case CANCEL -> new EmedPadvCancelEntryDigest(
                    padvDocumentEffectiveTime,
                    padvDocumentId,
                    documentAuthor,
                    sectionAuthor,
                    entryId,
                    medicationTreatmentId,
                    sequence,
                    annotationComment,
                    isCompleted,
                    effectiveTime,
                    targetedEntryRef,
                    targetedEntryType
            );
            case CHANGE -> {
                final EmedEntryDigest targetedEntry =
                        this.emedEntryService.getById(Objects.requireNonNull(targetedEntryRef.getEntryId()))
                                .orElseThrow(() -> new InvalidMedicationTreatmentStateException(String.format("The " +
                                        "referenced %s cannot be found", targetedEntryRef.toText())));

                final EmedMtpEntryDigest changedMtpEntry;
                final EmedPreEntryDigest changedPreEntry;
                final MedicationDosageInstructions changedDosageInstructions;

                if (targetedEntryType == EmedEntryType.MTP && targetedEntry instanceof final EmedMtpEntryDigest targetedMtpEntry) {
                    changedMtpEntry = observation.getEntryRelationship().stream()
                            .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                            .filter(Objects::nonNull)
                            .filter(subAdmin -> hasAllIds(MTP_ENTRY, subAdmin.getTemplateId()))
                            .findAny()
                            .map(subAdm -> this.mtpEntryDigester.createDigest(
                                    subAdm,
                                    padvDocumentId,
                                    targetedMtpEntry.getPlanningTime(),
                                    documentAuthor,
                                    sectionAuthor))
                            .orElse(null);
                    changedPreEntry = null;
                    changedDosageInstructions = null;
                } else if (targetedEntryType == EmedEntryType.PRE && targetedEntry instanceof final EmedPreEntryDigest targetedPreEntry) {
                    changedMtpEntry = null;
                    changedPreEntry = observation.getEntryRelationship().stream()
                            .map(POCDMT000040EntryRelationship::getOrganizer)
                            .filter(Objects::nonNull)
                            .map(POCDMT000040Organizer::getComponent)
                            .map(OptionalUtils::getListOnlyElement)
                            .filter(Objects::nonNull)
                            .map(POCDMT000040Component4::getSubstanceAdministration)
                            .filter(Objects::nonNull)
                            .findAny()
                            .map(subAdm -> this.preEntryDigester.createDigest(
                                    subAdm,
                                    padvDocumentId,
                                    targetedPreEntry.getPrescriptionTime(),
                                    targetedPreEntry.getPrescriptionDocumentValidityStart(),
                                    targetedPreEntry.getPrescriptionDocumentValidityStop(),
                                    documentAuthor,
                                    sectionAuthor))
                            .orElse(null);
                    changedDosageInstructions = null;
                } else if (targetedEntryType == EmedEntryType.DIS && targetedEntry instanceof EmedDisEntryDigest) {
                    changedMtpEntry = null;
                    changedPreEntry = null;
                    changedDosageInstructions = observation.getEntryRelationship().stream()
                            .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                            .filter(Objects::nonNull)
                            .filter(subAdmin -> isInList(DOSAGE_INSTRUCTIONS, subAdmin.getTemplateId()))
                            .findAny()
                            .map(DosageInstructionsReader::new)
                            .map(DosageInstructionsReader::getDosageInstructions)
                            .orElse(null);
                } else {
                    throw new InvalidEmedContentException("Unable to process the reference to the changed entry");
                }
                yield new EmedPadvChangeEntryDigest(
                        padvDocumentEffectiveTime,
                        padvDocumentId,
                        documentAuthor,
                        sectionAuthor,
                        entryId,
                        medicationTreatmentId,
                        sequence,
                        annotationComment,
                        isCompleted,
                        effectiveTime,
                        targetedEntryRef,
                        targetedEntryType,
                        changedMtpEntry,
                        changedPreEntry,
                        changedDosageInstructions
                );
            }
            case REFUSE -> new EmedPadvRefuseEntryDigest(
                    padvDocumentEffectiveTime,
                    padvDocumentId,
                    documentAuthor,
                    sectionAuthor,
                    entryId,
                    medicationTreatmentId,
                    sequence,
                    annotationComment,
                    isCompleted,
                    effectiveTime,
                    targetedEntryRef,
                    targetedEntryType
            );
            case SUSPEND -> new EmedPadvSuspendEntryDigest(
                    padvDocumentEffectiveTime,
                    padvDocumentId,
                    documentAuthor,
                    sectionAuthor,
                    entryId,
                    medicationTreatmentId,
                    sequence,
                    annotationComment,
                    isCompleted,
                    effectiveTime,
                    targetedEntryRef,
                    targetedEntryType
            );
            case COMMENT -> {
                final String comment = Optional.ofNullable(observation.getText()).map(ED::getTextContent)
                        .orElseThrow(() -> new InvalidEmedContentException("The comment is missing"));
                yield new EmedPadvCommentEntryDigest(
                        padvDocumentEffectiveTime,
                        padvDocumentId,
                        documentAuthor,
                        sectionAuthor,
                        entryId,
                        medicationTreatmentId,
                        sequence,
                        annotationComment,
                        isCompleted,
                        effectiveTime,
                        targetedEntryRef,
                        targetedEntryType,
                        comment
                );
            }
        };
    }

    /**
     * Returns the item entry ID; it shall contain a root and may contain an extension.
     *
     * @param observation The pharmaceutical advice entry Observation.
     * @return the item entry ID.
     * @throws InvalidEmedContentException if the item entry ID is missing.
     */
    private UUID getEntryId(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        return Optional.of(observation.getId())
                .map(OptionalUtils::getListFirstElement)
                .map(IiUtils::getUuid)
                .orElseThrow(() -> new InvalidEmedContentException("The entry ID is missing"));
    }

    /**
     * Retrieves the status (OK, CHANGE, CANCEL, SUSPEND, REFUSE, COMMENT) of the PADV observation element.
     */
    private PharmaceuticalAdviceStatus getStatus(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        return Optional.ofNullable(observation.getCode())
                .filter(code -> PharmaceuticalAdviceStatus.CODE_SYSTEM_OID.equals(code.getCodeSystem()))
                .map(CD::getCode)
                .map(PharmaceuticalAdviceStatus::getEnum)
                .orElseThrow(() -> new InvalidEmedContentException("The mandatory code is missing or invalid in the " +
                        "PADV Observation element"));
    }

    /**
     * Returns whether the status code is 'completed' or not ('active').
     */
    private boolean isCompleted(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        return "completed".equals(
                Optional.ofNullable(observation.getStatusCode())
                        .map(CD::getCode)
                        .orElseThrow(() -> new InvalidEmedContentException("The mandatory status code is missing or invalid in " +
                                "the PADV Observation element"))
        );
    }

    /**
     * Returns the entry effective time.
     *
     * @return an {@link Optional} that may contain the effective time as an {@link Instant}.
     */
    private Optional<Instant> getEffectiveTime(final POCDMT000040Observation observation) {
        return Optional.ofNullable(observation.getEffectiveTime())
                .map(TS::getValue)
                .map(Hl7Dtm::fromHl7)
                .map(DateTimes::completeToEarliestInstant)
                .map(DateTimes::toInstant);
    }

    /**
     * Returns the reference to the targeted entry.
     *
     * @throws InvalidEmedContentException if the entry is incorrect or is missing the targeted entry.
     */
    private EmedReference getItemReference(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        return Stream.of(this.getMtpReference(observation), this.getPreReference(observation), this.getDisReference(observation))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny()
                .filter(ref -> ref.getEntryId() != null)
                .orElseThrow(() -> new InvalidEmedContentException("The mandatory referenced entry is missing"));
    }

    /**
     * Retrieves the {@link EmedReference} that references an MTP item.
     *
     * @return an {@link Optional} that may contain a MTP entry reference.
     * @throws InvalidEmedContentException if the PADV entry is invalid.
     */
    private Optional<EmedReference> getMtpReference(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        return observation.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .filter(subAdm -> hasAllIds(REFERENCE_TO_MTP, subAdm.getTemplateId()))
                .findAny()
                .map(CdaR2Utils::toEmedReference);
    }

    /**
     * Retrieves the {@link EmedReference} that references a PRE item.
     *
     * @return an {@link Optional} that may contain a PRE entry reference.
     * @throws InvalidEmedContentException if the PADV entry is invalid.
     */
    private Optional<EmedReference> getPreReference(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        return observation.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .filter(subAdm -> hasAllIds(REFERENCE_TO_PRE, subAdm.getTemplateId()))
                .findAny()
                .map(CdaR2Utils::toEmedReference);
    }

    /**
     * Retrieves the {@link EmedReference} that references a DIS item entry.
     *
     * @return an {@link Optional} that may contain a DIS entry reference.
     * @throws InvalidEmedContentException if the PADV entry is invalid.
     */
    private Optional<EmedReference> getDisReference(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        return observation.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getSupply)
                .filter(Objects::nonNull)
                .filter(su -> hasAllIds(REFERENCE_TO_DIS, su.getTemplateId()))
                .findAny()
                .map(CdaR2Utils::toEmedReference);
    }

    /**
     * Returns the annotation comment.
     *
     * @return an {@link Optional} that may contain the annotation comment.
     */
    private Optional<String> getAnnotationComment(final POCDMT000040Observation observation) {
        return EntryRelationshipUtils.getActsFromEntryRelationshipsByTemplateId(observation.getEntryRelationship(),
                        TemplateIds.ANNOTATION_COMMENT).stream()
                .findFirst()
                .map(POCDMT000040Act::getText)
                .map(ED::getTextContent);
    }
}
