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

import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;
import org.husky.emed.ch.cda.generated.artdecor.enums.MedicationDosageQualifier;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.cda.utils.CdaR2Utils;
import org.husky.emed.ch.cda.utils.EntryRelationshipUtils;
import org.husky.emed.ch.cda.utils.IiUtils;
import org.husky.emed.ch.cda.utils.TemplateIds;
import org.husky.emed.ch.cda.utils.readers.AuthorReader;
import org.husky.emed.ch.cda.utils.readers.DosageInstructionsReader;
import org.husky.emed.ch.cda.utils.readers.ManufacturedMaterialReader;
import org.husky.emed.ch.enums.DispenseSupplyType;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;
import org.husky.emed.ch.models.common.Quantity;
import org.husky.emed.ch.models.entry.EmedDisEntryDigest;
import org.husky.emed.ch.models.treatment.MedicationProduct;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.husky.emed.ch.cda.utils.TemplateIds.*;

/**
 * Creator of CDA-CH-EMED DIS item entry digests.
 *
 * @author Quentin Ligier
 */
@Component
public class CceDisEntryDigester {

    /**
     * The registry of {@link org.husky.emed.ch.models.entry.EmedEntryDigest}.
     */
    private final EmedEntryDigestService emedEntryService;

    /**
     * Constructor.
     *
     * @param emedEntryService The registry of {@link org.husky.emed.ch.models.entry.EmedEntryDigest}.
     */
    public CceDisEntryDigester(final EmedEntryDigestService emedEntryService) {
        this.emedEntryService = emedEntryService;
    }

    /**
     * Creates a new {@link EmedDisEntryDigest} from an DIS Supply element.
     *
     * @param supply                   The DIS Supply element.
     * @param disDocumentId            The MTP document ID.
     * @param disDocumentEffectiveTime The MTP document effective time.
     * @param parentDocumentAuthor     The parent document author (not the original document author).
     * @param parentSectionAuthor      The parent section author (not the original section author).
     * @return a digest of the element.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    protected EmedDisEntryDigest createDigest(final POCDMT000040Supply supply,
                                              final UUID disDocumentId,
                                              final Instant disDocumentEffectiveTime,
                                              final AuthorDigest parentDocumentAuthor,
                                              final AuthorDigest parentSectionAuthor) throws InvalidEmedContentException {

        final var refMtpEntry = this.getMtpReference(supply).orElse(null);
        final var refMtpEntryDigest = Optional.ofNullable(refMtpEntry)
                .map(EmedReference::getEntryId).flatMap(this.emedEntryService::getById).orElse(null);
        final var refPreEntry = this.getPreReference(supply).orElse(null);
        final var refPreEntryDigest = Optional.ofNullable(refPreEntry)
                .map(EmedReference::getEntryId).flatMap(this.emedEntryService::getById).orElse(null);

        final int sequence;
        final UUID medicationTreatmentId;
        final boolean isOtc;
        if (refPreEntryDigest != null) {
            sequence = (int) this.emedEntryService.getSequence(refPreEntryDigest.getMedicationTreatmentId(),
                    disDocumentEffectiveTime);
            medicationTreatmentId = refPreEntryDigest.getMedicationTreatmentId();
            isOtc = false;
        } else if (refMtpEntryDigest != null) {
            sequence = (int) this.emedEntryService.getSequence(refMtpEntryDigest.getMedicationTreatmentId(),
                    disDocumentEffectiveTime);
            medicationTreatmentId = refMtpEntryDigest.getMedicationTreatmentId();
            isOtc = true;
        } else {
            sequence = 0;
            medicationTreatmentId = this.getEntryId(supply);
            isOtc = true;
        }

        final AuthorDigest documentAuthor;
        final AuthorDigest sectionAuthor;
        if (supply.getAuthor().size() == 2) {
            sectionAuthor = new AuthorReader(supply.getAuthor().get(0)).toDigest();
            documentAuthor = new AuthorReader(supply.getAuthor().get(1)).toDigest();
        } else if (supply.getAuthor().size() == 1) {
            sectionAuthor = new AuthorReader(supply.getAuthor().get(0)).toDigest();
            documentAuthor = sectionAuthor;
        } else {
            documentAuthor = parentDocumentAuthor;
            sectionAuthor = parentSectionAuthor;
        }

        return new EmedDisEntryDigest(
                disDocumentEffectiveTime,
                disDocumentId,
                documentAuthor,
                sectionAuthor,
                this.getEntryId(supply),
                medicationTreatmentId,
                sequence,
                this.getAnnotationComment(supply).orElse(null),
                this.getDispenseType(supply),
                isOtc,
                refMtpEntry,
                refPreEntry,
                this.getMedicationProduct(supply),
                this.getQuantity(supply),
                this.getPatientMedicationInstructions(supply).orElse(null),
                this.getFulfilmentNotes(supply).orElse(null),
                this.isInReserve(supply),
                this.getDosageInstructions(supply).orElse(null)
        );
    }


    /**
     * Returns the item entry ID; it shall contain a root and may contain an extension.
     *
     * @param supply The dispense entry Supply.
     * @return the item entry ID.
     * @throws InvalidEmedContentException if the item entry ID is missing.
     */
    UUID getEntryId(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return Optional.ofNullable(OptionalUtils.getListFirstElement(supply.getId()))
                .map(IiUtils::getUuid)
                .orElseThrow(() -> new InvalidEmedContentException("Unable to retrieve the entry ID"));
    }

    /**
     * Returns the annotation comment.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the annotation comment.
     */
    Optional<String> getAnnotationComment(final POCDMT000040Supply supply) {
        return EntryRelationshipUtils.getActsFromEntryRelationshipsByTemplateId(supply.getEntryRelationship(),
                        TemplateIds.ANNOTATION_COMMENT).stream()
                .findFirst()
                .map(POCDMT000040Act::getText)
                .map(ED::getTextContent);
    }

    /**
     * Returns the supply type as an instance of {@link DispenseSupplyType} or throw an exception if the value is
     * invalid (this should be checked by the Schematron.
     *
     * @param supply The dispense entry Supply.
     */
    DispenseSupplyType getDispenseType(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        final CD fillCode = supply.getCode();
        // The code "First Fill - Complete" is induced if the code is absent (IHE Pharm DIS, 6.3.4.5.3.4)
        if (fillCode == null) {
            return DispenseSupplyType.FIRST_FILL_COMPLETE;
        }
        if (!DispenseSupplyType.isEnumOfValueSet(fillCode.getCode())) {
            throw new InvalidEmedContentException("The supply code is invalid");
        }
        final var dispenseSupplyType = DispenseSupplyType.getEnum(fillCode.getCode());
        if (dispenseSupplyType == null || !dispenseSupplyType.getCodeSystemId().equals(fillCode.getCodeSystem())) {
            throw new InvalidEmedContentException("The supply code is invalid");
        }
        return dispenseSupplyType;
    }

    /**
     * Returns the author of the item entry.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the item entry author.
     */
    Optional<POCDMT000040Author> getEntryAuthorElement(final POCDMT000040Supply supply) {
        return Optional.ofNullable(!supply.getAuthor().isEmpty() ? supply.getAuthor().get(0) : null);
    }

    /**
     * Returns the author of the original parent document. It's generally set in PML documents only, as the author of
     * the PML document may be different than the author of the MTP/PRE/DIS/PADV document.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} tht may contain the parent document author.
     */
    Optional<POCDMT000040Author> getParentDocumentAuthorElement(final POCDMT000040Supply supply) {
        return Optional.ofNullable(supply.getAuthor().size() >= 2 ? supply.getAuthor().get(1) : null);
    }

    /**
     * Returns the reference to the targeted MTP document.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the reference to the targeted MTP document.
     */
    Optional<EmedReference> getMtpReference(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return supply.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .filter(substanceAdministration -> hasAllIds(REFERENCE_TO_MTP, substanceAdministration.getTemplateId()))
                .map(CdaR2Utils::toEmedReference)
                .findAny();
    }

    /**
     * Returns the reference to the targeted PRE document.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the reference to the targeted PRE document.
     */
    Optional<EmedReference> getPreReference(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return supply.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .filter(substanceAdministration -> hasAllIds(REFERENCE_TO_PRE, substanceAdministration.getTemplateId()))
                .findAny()
                .map(CdaR2Utils::toEmedReference);
    }

    /**
     * Returns the reference to the targeted PADV document.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the reference to the targeted PADV document.
     */
    Optional<EmedReference> getPadvReference(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return supply.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getObservation)
                .filter(Objects::nonNull)
                .filter(obs -> hasAllIds(REFERENCE_TO_PADV, obs.getTemplateId()))
                .findAny()
                .map(CdaR2Utils::toEmedReference);
    }

    /**
     * Returns the reader of the manufactured material.
     *
     * @param supply The dispense entry Supply.
     */
    MedicationProduct getMedicationProduct(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return Optional.ofNullable(supply.getProduct())
                .map(POCDMT000040Product::getManufacturedProduct)
                .map(POCDMT000040ManufacturedProduct::getManufacturedMaterial)
                .map(ManufacturedMaterialReader::new)
                .map(ManufacturedMaterialReader::toMedicationProduct)
                .orElseThrow(() -> new InvalidEmedContentException("The manufactured material is missing in the SubstanceAdministration"));
    }

    /**
     * Returns the medication dispensed quantity.
     *
     * @param supply The dispense entry Supply.
     */
    Quantity getQuantity(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return Optional.ofNullable(supply.getQuantity())
                .filter(qty -> qty.getValue() != null && !qty.getValue().isBlank())
                .map(Quantity::fromPq)
                .orElseThrow(() -> new InvalidEmedContentException("The quantity value is missing in the Supply"));
    }

    /**
     * Returns the patient medication instructions.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the patient medication instructions.
     */
    Optional<String> getPatientMedicationInstructions(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return EntryRelationshipUtils.getPatientMedicationInstructions(supply.getEntryRelationship())
                .map(POCDMT000040Act::getText)
                .map(ED::getTextContent);
    }

    /**
     * Returns the fulfilment notes.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the fulfilment notes.
     */
    Optional<String> getFulfilmentNotes(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return EntryRelationshipUtils.getFulfillmentInstructions(supply.getEntryRelationship())
                .map(POCDMT000040Act::getText)
                .map(ED::getTextContent);
    }

    /**
     * Returns the dosage instructions.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the dosage instructions.
     */
    Optional<MedicationDosageInstructions> getDosageInstructions(final POCDMT000040Supply supply) {
        return EntryRelationshipUtils.getSubstanceAdministrationsFromEntryRelationshipsByTemplateId(supply.getEntryRelationship(), DOSAGE_INSTRUCTIONS)
                .stream().findAny()
                .map(DosageInstructionsReader::new)
                .map(DosageInstructionsReader::getDosageInstructions);
    }

    /**
     * Returns whether the treatment is to be taken regularly ({@code false}) or only if required ({@code true}).
     *
     * @param supply The dispense entry Supply.
     */
    boolean isInReserve(final POCDMT000040Supply supply) {
        return supply.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.COMP)
                .map(POCDMT000040EntryRelationship::getAct)
                .filter(Objects::nonNull)
                .filter(act -> TemplateIds.isInList(IN_RESERVE, act.getTemplateId()))
                .filter(act -> act.getCode() != null)
                .filter(act -> MedicationDosageQualifier.CODE_SYSTEM_ID.equals(act.getCode().getCodeSystem()))
                .findAny()
                .map(POCDMT000040Act::getCode)
                .map(CD::getCode)
                .map(MedicationDosageQualifier::getEnum)
                .map(substitution -> substitution == MedicationDosageQualifier.AS_REQUIRED_QUALIFIER_VALUE)
                .orElse(false); // Default is regular medication
    }
}
