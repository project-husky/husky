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
 */
package org.husky.emed.ch.models.entry;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.ActSubstanceAdminSubstitutionCode;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.enums.RouteOfAdministrationEdqm;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;
import org.husky.emed.ch.models.treatment.MedicationProduct;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the digest of an eMed MTP document item entry.
 *
 * @author Quentin Ligier
 */
@Getter
@Setter
public class EmedMtpEntryDigest extends EmedEntryDigest {

    /**
     * The list of substance substitution permissions.
     */
    private final List<@NonNull ActSubstanceAdminSubstitutionCode> substitutionPermissions = new ArrayList<>();
    /**
     * The dosage instructions.
     */
    private MedicationDosageInstructions dosageInstructions;
    /**
     * The fulfilment instructions or {@code null} if it isn't provided.
     */
    @Nullable
    private String fulfilmentInstructions;
    /**
     * The reference to the original MTP entry if this one is consolidated (i.e. part of a PMLC document instead of an
     * MTP one).
     */
    @Nullable
    private EmedReference originalMtpReference;
    /**
     * The patient medication instructions or {@code null} if it isn't provided.
     */
    @Nullable
    private String patientMedicationInstructions;
    /**
     * The medication product.
     */
    private MedicationProduct product;
    /**
     * Number of repeats/refills (excluding the initial dispense). It's a non-zero integer if it's limited, it's zero if
     * no repeat/refill is authorized and {@code null} if unlimited repeats/refills are authorized.
     */
    @Nullable
    private Integer repeatNumber;
    /**
     * The medication route of administration or {@code null} if it's not specified.
     */
    @Nullable
    private RouteOfAdministrationEdqm routeOfAdministration;
    /**
     * The inclusive instant at which the item shall start.
     */
    private Instant serviceStartTime;
    /**
     * The inclusive instant at which the item shall stop or {@code null} if it's unknown.
     */
    @Nullable
    private Instant serviceStopTime;
    /**
     * The treatment reason or {@code null} if it isn't provided.
     */
    @Nullable
    private String treatmentReason;

    /**
     * Constructor.
     *
     * @param creationTime                  The instant at which the item entry was created.
     * @param documentId                    The parent document unique ID.
     * @param documentAuthor                The author of the original parent document or {@code null} if they're not
     *                                      known.
     * @param sectionAuthor                 The author of the original parent section or {@code null} if they're not
     *                                      known.
     * @param entryId                       The item entry ID.
     * @param medicationTreatmentId         The ID of the medication treatment this item entry belongs to.
     * @param sequence                      The sequence of addition.
     * @param annotationComment             The annotation comment or {@code null} if it isn't provided.
     * @param dosageInstructions            The dosage instructions.
     * @param product                       The medication product.
     * @param repeatNumber                  Number of repeats/refills (excluding the initial dispense). It's a non-zero
     *                                      integer if it's limited, it's zero if no repeat/refill is authorized and
     *                                      {@code null} if unlimited repeats/refills are authorized.
     * @param routeOfAdministration         The medication route of administration or {@code null} if it's not
     *                                      specified.
     * @param serviceStartTime              The inclusive instant at which the item shall start.
     * @param serviceStopTime               The inclusive instant at which the item shall stop or {@code null} if it's
     *                                      unknown.
     * @param substitutionPermissions       The list of substance substitution permissions or {@code null} if it's not
     *                                      specified.
     * @param originalMtpReference          The reference to the original MTP entry if this one is consolidated.
     * @param treatmentReason               The treatment reason or {@code null} if it isn't provided.
     * @param patientMedicationInstructions The patient medication instructions or {@code null} if it isn't provided.
     * @param fulfilmentInstructions        The fulfilment instructions or {@code null} if it isn't provided.
     */
    public EmedMtpEntryDigest(final Instant creationTime,
                              final String documentId,
                              @Nullable final AuthorDigest documentAuthor,
                              @Nullable final AuthorDigest sectionAuthor,
                              final String entryId,
                              final String medicationTreatmentId,
                              final int sequence,
                              @Nullable final String annotationComment,
                              final MedicationDosageInstructions dosageInstructions,
                              final MedicationProduct product,
                              @Nullable final Integer repeatNumber,
                              @Nullable final RouteOfAdministrationEdqm routeOfAdministration,
                              final Instant serviceStartTime,
                              @Nullable final Instant serviceStopTime,
                              @Nullable final List<@NonNull ActSubstanceAdminSubstitutionCode> substitutionPermissions,
                              @Nullable final EmedReference originalMtpReference,
                              @Nullable final String treatmentReason,
                              @Nullable final String patientMedicationInstructions,
                              @Nullable final String fulfilmentInstructions) {
        super(creationTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, sequence,
                annotationComment);
        this.dosageInstructions = Objects.requireNonNull(dosageInstructions);
        this.product = Objects.requireNonNull(product);
        this.routeOfAdministration = routeOfAdministration;
        this.repeatNumber = repeatNumber;
        this.serviceStartTime = Objects.requireNonNull(serviceStartTime);
        this.serviceStopTime = serviceStopTime;
        if (substitutionPermissions != null) {
            this.substitutionPermissions.addAll(substitutionPermissions);
        }
        this.originalMtpReference = originalMtpReference;
        this.treatmentReason = treatmentReason;
        this.patientMedicationInstructions = patientMedicationInstructions;
        this.fulfilmentInstructions = fulfilmentInstructions;
    }

    /**
     * Checks whether the MTP entry is consolidated or not.
     *
     * @return {@code true} if the MTP entry is consolidated.
     */
    public boolean isConsolidatedEntry() {
        return this.originalMtpReference != null;
    }

    /**
     * Returns the non-null type of the item entry digest.
     */
    public EmedEntryType getEmedEntryType() {
        return EmedEntryType.MTP;
    }

    @Override
    public String toString() {
        return "EmedMtpEntryDigest{" +
                "creationTime=" + creationTime +
                ", documentId='" + documentId + '\'' +
                ", sectionAuthor=" + sectionAuthor +
                ", documentAuthor=" + documentAuthor +
                ", entryId='" + entryId + '\'' +
                ", medicationTreatmentId='" + medicationTreatmentId + '\'' +
                ", sequence=" + sequence +
                ", annotationComment='" + annotationComment + '\'' +
                ", substitutionPermissions=" + substitutionPermissions +
                ", dosageInstructions=" + dosageInstructions +
                ", product=" + product +
                ", repeatNumber=" + repeatNumber +
                ", routeOfAdministration=" + routeOfAdministration +
                ", serviceStartTime=" + serviceStartTime +
                ", serviceStopTime=" + serviceStopTime +
                ", originalMtpReference=" + originalMtpReference +
                ", treatmentReason='" + treatmentReason + '\'' +
                ", patientMedicationInstructions='" + patientMedicationInstructions + '\'' +
                ", fulfilmentInstructions='" + fulfilmentInstructions + '\'' +
                '}';
    }
}
