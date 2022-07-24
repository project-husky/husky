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
package org.husky.emed.ch.cda.utils.readers;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;
import org.husky.common.utils.time.DateTimes;
import org.husky.emed.ch.cda.utils.IiUtils;
import org.husky.emed.ch.cda.utils.IvlTsUtils;
import org.husky.emed.ch.cda.utils.TemplateIds;
import org.husky.emed.ch.enums.CceDocumentType;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.OrganizationDigest;
import org.husky.emed.ch.models.common.PatientDigest;
import org.husky.emed.ch.models.common.RecipientDigest;

import java.time.Instant;
import java.util.*;

/**
 * A reader for CDA-CH-EMED clinical documents.
 *
 * @author Quentin Ligier
 **/
public class ClinicalDocumentReader {

    /**
     * The clinical document.
     */
    private final POCDMT000040ClinicalDocument clinicalDocument;

    /**
     * Constructor.
     *
     * @param clinicalDocument The clinical document.
     */
    public ClinicalDocumentReader(final POCDMT000040ClinicalDocument clinicalDocument) {
        this.clinicalDocument = Objects.requireNonNull(clinicalDocument);
    }

    /**
     * Returns the type of the CDA-CH-EMED document.
     *
     * @return an instance of {@link CceDocumentType}.
     * @throws InvalidEmedContentException if the document type IDs cannot be found.
     */
    @SideEffectFree
    public CceDocumentType getDocumentType() throws InvalidEmedContentException {
        if (TemplateIds.hasAllIds(TemplateIds.MTP_DOCUMENT, this.clinicalDocument.getTemplateId())) {
            return CceDocumentType.MTP;
        } else if (TemplateIds.hasAllIds(TemplateIds.PRE_DOCUMENT, this.clinicalDocument.getTemplateId())) {
            return CceDocumentType.PRE;
        } else if (TemplateIds.hasAllIds(TemplateIds.DIS_DOCUMENT, this.clinicalDocument.getTemplateId())) {
            return CceDocumentType.DIS;
        } else if (TemplateIds.hasAllIds(TemplateIds.PADV_DOCUMENT, this.clinicalDocument.getTemplateId())) {
            return CceDocumentType.PADV;
        } else if (TemplateIds.hasAllIds(TemplateIds.PML_DOCUMENT, this.clinicalDocument.getTemplateId())) {
            return CceDocumentType.PML;
        } else if (TemplateIds.hasAllIds(TemplateIds.PMLC_DOCUMENT, this.clinicalDocument.getTemplateId())) {
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
     * @param effectiveTime The document effective time.
     * @return the inclusive prescription validity start time as an {@link Instant}.
     */
    @SideEffectFree
    public Instant getPreValidityStartTime(final Instant effectiveTime) {
        return this.clinicalDocument.getDocumentationOf().stream()
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
     * @return the inclusive prescription validity stop time as an {@link Instant} or {@code null}.
     */
    @SideEffectFree
    @Nullable
    public Instant getPreValidityStopTime() {
        return this.clinicalDocument.getDocumentationOf().stream()
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
     * @throws InvalidEmedContentException if the section is missing.
     */
    @SideEffectFree
    public POCDMT000040Section getContentSection() throws InvalidEmedContentException {
        return Optional.ofNullable(this.clinicalDocument.getComponent())
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
     * @return the narrative text as structured text.
     * @throws InvalidEmedContentException if the narrative text is missing.
     */
    @SideEffectFree
    public StrucDocText getNarrativeText() {
        return Optional.of(getContentSection())
                .map(POCDMT000040Section::getText)
                .orElseThrow(() -> new InvalidEmedContentException("Unable to retrieve the narrative text"));

    }

    /**
     * Returns the content of the remarks section.
     *
     * @return the remarks text or {@code null} if it was not provided.
     */
    @Nullable
    @SideEffectFree
    public StrucDocText getRemarks() {
        return Optional.ofNullable(this.clinicalDocument.getComponent())
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
     * @return an optional that may contain the PDF content as a byte array.
     * @throws InvalidEmedContentException if the value is not in valid Base64 scheme.
     */
    @SideEffectFree
    public Optional<byte[]> getPdfRepresentation() {
        return Optional.ofNullable(this.clinicalDocument.getComponent())
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
     * @return the patient digest.
     * @throws InvalidEmedContentException if the patient is incomplete.
     */
    @SideEffectFree
    public PatientDigest getPatientDigest() {
        final var patientRole = Optional.of(this.clinicalDocument.getRecordTarget())
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
     * @return the custodian digest.
     * @throws InvalidEmedContentException if the custodian is incomplete.
     */
    @SideEffectFree
    public OrganizationDigest getCustodian() {
        final var custodian = Optional.ofNullable(this.clinicalDocument.getCustodian())
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
     * @return the recipient digests.
     */
    @SideEffectFree
    public List<@NonNull RecipientDigest> getRecipients() {
        return this.clinicalDocument.getInformationRecipient().stream()
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
