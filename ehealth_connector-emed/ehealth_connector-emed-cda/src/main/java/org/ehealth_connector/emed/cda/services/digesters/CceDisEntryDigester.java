package org.ehealth_connector.emed.cda.services.digesters;

import org.ehealth_connector.common.utils.StreamUtils;
import org.ehealth_connector.emed.cda.errors.InvalidEmedContentException;
import org.ehealth_connector.emed.cda.generated.artdecor.enums.ActSubstanceAdminSubstitutionCode;
import org.ehealth_connector.emed.cda.generated.artdecor.enums.DispenseSupplyType;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.*;
import org.ehealth_connector.emed.cda.models.common.AuthorDigest;
import org.ehealth_connector.emed.cda.models.common.EmedReference;
import org.ehealth_connector.emed.cda.models.common.QuantityWithUnit;
import org.ehealth_connector.emed.cda.models.entry.EmedDisEntryDigest;
import org.ehealth_connector.emed.cda.models.entry.EmedEntryDigest;
import org.ehealth_connector.emed.cda.models.treatment.MedicationProduct;
import org.ehealth_connector.emed.cda.services.EmedEntryDigestService;
import org.ehealth_connector.emed.cda.services.readers.ManufacturedMaterialReader;
import org.ehealth_connector.emed.cda.utils.EntryRelationshipUtils;
import org.ehealth_connector.emed.cda.utils.IiUtils;
import org.ehealth_connector.emed.cda.utils.TemplateIds;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

import static org.ehealth_connector.emed.cda.utils.TemplateIds.*;

/**
 * Creator of CDA-CH-EMED DIS item entry digests.
 *
 * @author Quentin Ligier
 */
@Component
public class CceDisEntryDigester {

    /**
     * The registry of {@link EmedEntryDigest}.
     */
    private final EmedEntryDigestService emedEntryService;

    /**
     * Constructor.
     *
     * @param emedEntryService The registry of {@link EmedEntryDigest}.
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
     * @param patientId                The patient ID.
     * @return a digest of the element.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    protected EmedDisEntryDigest createDigest(final POCDMT000040Supply supply,
                                              final String disDocumentId,
                                              final Instant disDocumentEffectiveTime,
                                              final String patientId) throws InvalidEmedContentException {

        final var refMtpEntry = this.getMtpReference(supply).orElse(null);
        final var refMtpEntryDigest = Optional.ofNullable(refMtpEntry)
                .map(EmedReference::getItemId).flatMap(this.emedEntryService::getById).orElse(null);
        final var refPreEntry = this.getPreReference(supply).orElse(null);
        final var refPreEntryDigest = Optional.ofNullable(refPreEntry)
                .map(EmedReference::getItemId).flatMap(this.emedEntryService::getById).orElse(null);

        final int sequence;
        final String medicationTreatmentId;
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

        return new EmedDisEntryDigest(
                disDocumentEffectiveTime,
                disDocumentId,
                new AuthorDigest(), // TODO
                new AuthorDigest(), // TODO
                this.getEntryId(supply),
                medicationTreatmentId,
                patientId,
                sequence,
                this.getAnnotationComment(supply).orElse(null),
                this.getDispenseType(supply),
                isOtc,
                refMtpEntry,
                refPreEntry,
                this.getMedicationProduct(supply),
                this.getQuantity(supply),
                this.getSubstitutionAct(supply).orElse(null),
                this.getPatientMedicationInstructions(supply).orElse(null),
                this.getFulfilmentNotes(supply).orElse(null)
        );
    }


    /**
     * Returns the item entry ID; it shall contain a root and may contain an extension.
     *
     * @param supply The dispense entry Supply.
     * @return the item entry ID.
     * @throws InvalidEmedContentException if the item entry ID is missing.
     */
    private String getEntryId(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return Optional.ofNullable(StreamUtils.getListFirst(supply.getId()))
                .map(IiUtils::getNormalizedUid)
                .orElseThrow(() -> new InvalidEmedContentException(""));
    }

    /**
     * Returns the annotation comment.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the annotation comment.
     */
    private Optional<String> getAnnotationComment(final POCDMT000040Supply supply) {
        return EntryRelationshipUtils.getActsFromEntryRelationshipsByTemplateId(supply.getEntryRelationship(),
                        TemplateIds.ANNOTATION_COMMENT).stream()
                .findFirst()
                .map(POCDMT000040Act::getText)
                .map(ED::getTextContent);
    }

    /**
     * Returns the substitution act.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the substitution act.
     */
    private Optional<ActSubstanceAdminSubstitutionCode> getSubstitutionAct(final POCDMT000040Supply supply) {
        return supply.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.COMP)
                .map(POCDMT000040EntryRelationship::getAct)
                .filter(Objects::nonNull)
                .filter(act -> isInList(SUBSTITUTION_ACT, act.getTemplateId()))
                .filter(act -> act.getCode() != null)
                .filter(act -> ActSubstanceAdminSubstitutionCode.NONE_L1.getCodeSystemId().equals(act.getCode().getCodeSystem()))
                .findAny()
                .map(act -> act.getCode().getCode())
                .map(ActSubstanceAdminSubstitutionCode::getEnum);
    }

    /**
     * Returns the supply type as an instance of {@link DispenseSupplyType} or throw an exception if the value is
     * invalid (this should be checked by the Schematron.
     *
     * @param supply The dispense entry Supply.
     */
    private DispenseSupplyType getDispenseType(final POCDMT000040Supply supply) throws InvalidEmedContentException {
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
    private Optional<POCDMT000040Author> getEntryAuthorElement(final POCDMT000040Supply supply) {
        return Optional.ofNullable(!supply.getAuthor().isEmpty() ? supply.getAuthor().get(0) : null);
    }

    /**
     * Returns the author of the original parent document. It's generally set in PML documents only, as the author of
     * the PML document may be different than the author of the MTP/PRE/DIS/PADV document.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} tht may contain the parent document author.
     */
    private Optional<POCDMT000040Author> getParentDocumentAuthorElement(final POCDMT000040Supply supply) {
        return Optional.ofNullable(supply.getAuthor().size() >= 2 ? supply.getAuthor().get(1) : null);
    }

    /**
     * Returns the reference to the targeted MTP document.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the reference to the targeted MTP document.
     */
    private Optional<EmedReference> getMtpReference(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return supply.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .filter(substanceAdministration -> hasAllIds(REFERENCE_TO_MTP, substanceAdministration.getTemplateId()))
                .map(EmedReference::new)
                .findAny();
    }

    /**
     * Returns the reference to the targeted PRE document.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the reference to the targeted PRE document.
     */
    private Optional<EmedReference> getPreReference(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return supply.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .filter(substanceAdministration -> hasAllIds(REFERENCE_TO_PRE, substanceAdministration.getTemplateId()))
                .findAny()
                .map(EmedReference::new);
    }

    /**
     * Returns the reference to the targeted PADV document.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the reference to the targeted PADV document.
     */
    private Optional<EmedReference> getPadvReference(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return supply.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getObservation)
                .filter(Objects::nonNull)
                .filter(obs -> hasAllIds(REFERENCE_TO_PADV, obs.getTemplateId()))
                .findAny()
                .map(EmedReference::new);
    }

    /**
     * Returns the reader of the manufactured material.
     *
     * @param supply The dispense entry Supply.
     */
    private MedicationProduct getMedicationProduct(final POCDMT000040Supply supply) throws InvalidEmedContentException {
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
     * TODO: another quantity in asContent
     *
     * @param supply The dispense entry Supply.
     */
    private QuantityWithUnit getQuantity(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return Optional.ofNullable(supply.getQuantity())
                .filter(qty -> qty.getValue() != null && !qty.getValue().isBlank())
                .map(QuantityWithUnit::fromPq)
                .orElseThrow(() -> new InvalidEmedContentException("The quantity value is missing in the Supply"));
    }

    /**
     * Returns the patient medication instructions.
     *
     * @param supply The dispense entry Supply.
     * @return an {@link Optional} that may contain the patient medication instructions.
     */
    private Optional<String> getPatientMedicationInstructions(final POCDMT000040Supply supply) throws InvalidEmedContentException {
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
    private Optional<String> getFulfilmentNotes(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        return EntryRelationshipUtils.getFulfillmentInstructions(supply.getEntryRelationship())
                .map(POCDMT000040Act::getText)
                .map(ED::getTextContent);
    }
}
