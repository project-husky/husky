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
package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.CommonLanguages;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.resource.ChEmedOrganization;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChExtEprDataEnterer;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.*;

/**
 * The HAPI custom structure for CH-EMED-EPR Compositions.
 *
 * @author Quentin Ligier
 **/
public abstract class ChEmedEprComposition extends Composition {

    public static final String ORIGINAL_REPR_SECTION_CODE_VALUE = "55108-5";
    public static final String TREATMENT_PLAN_SECTION_CODE_VALUE = "77604-7";
    public static final String PRESCRIPTION_SECTION_CODE_VALUE = "57828-6";
    public static final String DISPENSE_SECTION_CODE_VALUE = "60590-7";
    public static final String PHARMACEUTICAL_ADVICE_SECTION_CODE_VALUE = "61357-0";
    public static final String LIST_SECTION_CODE_VALUE = "56445-0";
    public static final String CARD_SECTION_CODE_VALUE = "10160-0";
    public static final String ANNOTATION_SECTION_CODE_VALUE = "48767-8";

    /**
     * Version number
     */
    @Nullable
    @Child(name = "versionNumber")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-versionnumber", definedLocally = false)
    protected UnsignedIntType versionNumber;

    /**
     * Extension for a list of recipients of this document (corresponds to the addressee of a letter - person or
     * organization), equivalent to CDA informationRecipient.
     */
    @Nullable
    @Child(name = "informationRecipient", min = 1, max = Child.MAX_UNLIMITED)
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-informationrecipient", definedLocally = false)
    protected List<Reference> informationRecipient;

    /**
     * Person who entered information into this document if it is a person other than the author.
     */
    @Nullable
    @Child(name = "dataEnterer")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-dataenterer", definedLocally = false)
    protected ChExtEprDataEnterer dataEnterer;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprComposition() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date          The document's creation date and time
     */
    public ChEmedEprComposition(final UUID compositionId,
                                final Instant date,
                                final LanguageCode language) {
        super();
        this.setVersionNumber(1);
        this.setStatus(CompositionStatus.FINAL);
        this.setConfidentiality(DocumentConfidentiality.N);
        final var confidentialityCode = new Coding(FhirSystem.SNOMEDCT, "17621005", "Normal (qualifier value)");
        this.getConfidentialityElement().addExtension(
                "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-confidentialitycode",
                new CodeableConcept().addCoding(confidentialityCode));
        this.getIdentifier().setSystem(FhirSystem.URI).setValue(Uuids.URN_PREFIX + compositionId);
        this.setDate(Date.from(date));
        this.setLanguage(language.getCodeValue());
    }

    /**
     * Returns the targeted patient. It's a shortcut for {@code (ChCorePatientEpr) getSubject().getResource()}.
     *
     * @return the patient.
     * @throws InvalidEmedContentException if the patient is not set or not an instance of {@link ChCorePatientEpr}.
     */
    @ExpectsValidResource
    public ChCorePatientEpr resolvePatient() throws InvalidEmedContentException {
        return Optional.ofNullable(this.subject)
                .map(BaseReference::getResource)
                .map(ChCorePatientEpr.class::cast)
                .orElseThrow(() -> new InvalidEmedContentException("The subject reference is missing or of wrong " +
                                                                           "type"));
    }

    /**
     * Returns the custodian. It's a shortcut for {@code (ChCoreOrganizationEpr) getCustodian().getResource()}.
     *
     * @return the custodian.
     * @throws InvalidEmedContentException if the custodian is not set or not an instance of
     *                                     {@link ChEmedOrganization}.
     */
    @ExpectsValidResource
    public ChEmedOrganization resolveCustodian() throws InvalidEmedContentException {
        return Optional.ofNullable(this.custodian)
                .map(BaseReference::getResource)
                .map(ChEmedOrganization.class::cast)
                .orElseThrow(() -> new InvalidEmedContentException("The custodian reference is missing or of wrong " +
                                                                           "type"));
    }

    /**
     * Resolves the document UUID or throws.
     *
     * @return the document UUID.
     * @throws InvalidEmedContentException if the id is missing.
     */
    @ExpectsValidResource
    public UUID resolveIdentifier() throws InvalidEmedContentException {
        if (!this.hasIdentifier()) throw new InvalidEmedContentException("The ID is missing.");
        return Uuids.parseUrnEncoded(this.getIdentifier().getValue());
    }

    /**
     * Resolves the language of the document.
     *
     * @return the language of the document.
     */
    @ExpectsValidResource
    public CommonLanguages resolveLanguage() {
        if (!this.hasLanguage()) throw new InvalidEmedContentException("The language is missing.");

        final var code = CommonLanguages.getEnum(this.getLanguage());
        if (code == null) {
            throw new InvalidEmedContentException("The language is invalid.");
        }
        return code;
    }

    /**
     * Gets the version number element.
     *
     * @return the version number element.
     */
    public UnsignedIntType getVersionNumberElement() {
        if (this.versionNumber == null) {
            this.versionNumber = new UnsignedIntType();
        }
        return this.versionNumber;
    }

    /**
     * Sets the version number element.
     *
     * @param versionNumber the version number element.
     * @return this.
     */
    public ChEmedEprComposition setVersionNumberElement(final UnsignedIntType versionNumber) {
        if (versionNumber.hasValue() && versionNumber.getValue() < 0) {
            throw new IllegalArgumentException("The version number shall be positive or zero");
        }
        this.versionNumber = versionNumber;
        return this;
    }

    /**
     * Gets the version number.
     *
     * @return the version number.
     */
    public int getVersionNumber() {
        return this.versionNumber == null || this.versionNumber.isEmpty() ? 0 : this.versionNumber.getValue();
    }

    /**
     * Sets the version number.
     *
     * @param value the version number.
     * @return this.
     */
    public ChEmedEprComposition setVersionNumber(int value) {
        if (this.versionNumber == null)
            this.versionNumber = new UnsignedIntType();
        this.versionNumber.setValue(value);
        return this;
    }

    /**
     * Gets the list of recipients of this document.
     *
     * @return the list of recipients of this document.
     */
    public List<Reference> getInformationRecipient() {
        if (this.informationRecipient == null) {
            this.informationRecipient = new ArrayList<>(0);
        }
        return this.informationRecipient;
    }

    /**
     * Sets list of recipients of this document.
     *
     * @param informationRecipient the list of recipients of this document.
     * @return this.
     */
    public ChEmedEprComposition setInformationRecipient(final List<Reference> informationRecipient) {
        this.informationRecipient = informationRecipient;
        return this;
    }

    /**
     * Gets the person who entered information into this document.
     *
     * @return the person who entered information into this document.
     */
    public ChExtEprDataEnterer getDataEnterer() {
        if (this.dataEnterer == null) {
            this.dataEnterer = new ChExtEprDataEnterer();
        }
        return dataEnterer;
    }

    /**
     * Sets the person who entered information into this document.
     *
     * @param dataEnterer the person who entered information into this document.
     * @return this.
     */
    public ChEmedEprComposition setDataEnterer(final ChExtEprDataEnterer dataEnterer) {
        this.dataEnterer = dataEnterer;
        return this;
    }

    /**
     * Sets the language of this document.
     *
     * @param language the language of this document.
     * @return this.
     */
    public ChEmedEprComposition setLanguage(CommonLanguages language) {
        this.setLanguage(language.getCodeValue());
        return this;
    }

    /**
     * Returns the original representation section; if missing, it creates it.
     *
     * @return the original representation section.
     */
    public SectionComponent getOriginalRepresentationSection() {
        var section = getSectionByLoincCode(ORIGINAL_REPR_SECTION_CODE_VALUE);
        if (section == null) {
            section = new SectionComponent();
            section.getCode().addCoding(new Coding(FhirSystem.LOINC,
                                                   ORIGINAL_REPR_SECTION_CODE_VALUE, "Clinical presentation"));
        }
        return section;
    }

    /**
     * Returns the PDF content of the original representation or throws.
     *
     * @return the PDF content of the original representation.
     * @throws InvalidEmedContentException if the original representation is missing.
     */
    @ExpectsValidResource
    public byte[] getOriginalRepresentationPdf() throws InvalidEmedContentException {
        final var section = this.getOriginalRepresentationSection();
        if (!section.hasEntry()) {
            throw new InvalidEmedContentException("The section has no entries");
        }
        final var resource = section.getEntry().get(0).getResource();
        if (resource instanceof final Binary binary && binary.hasData()) {
            return binary.getData();
        }
        throw new InvalidEmedContentException("The section isn't referencing a filled Binary resource");
    }

    /**
     * Finds a section by its LOINC code or {@code null}, without creating it.
     *
     * @return the section or {@code null}.
     */
    @Nullable
    protected SectionComponent getSectionByLoincCode(final String code) {
        return this.getSection().stream()
                .filter(section -> section.getCode().hasCoding(FhirSystem.LOINC, code))
                .findAny()
                .orElse(null);
    }

    /**
     * Sets the document UUID.
     *
     * @param documentUUID The document UUID
     * @return this.
     */
    public ChEmedEprComposition setIdentifier(final UUID documentUUID) {
        var identifier = this.getIdentifier();
        if (identifier == null) {
            identifier = new Identifier();
        }

        identifier.setSystem(FhirSystem.URI);
        identifier.setValue(Uuids.URN_PREFIX + documentUUID);

        return this;
    }

    /**
     * Set the patient targeted.
     *
     * @param chCorePatientEpr the patient.
     * @return this.
     */
    public ChEmedEprComposition setPatient(ChCorePatientEpr chCorePatientEpr) {
        this.setSubject(References.createReference(chCorePatientEpr));
        return this;
    }

    /**
     * Returns whether the version number.
     *
     * @return {@code true} if the version exists, {@code false} otherwise.
     */
    public boolean hasVersionNumber() {
        return this.versionNumber != null && !this.versionNumber.isEmpty();
    }

    /**
     * Returns whether the list of recipients of this document.
     *
     * @return {@code true} if the list of recipients of this document exists, {@code false} otherwise.
     */
    public boolean hasInformationRecipient() {
        if (this.informationRecipient == null) {
            return false;
        }
        for (final var item : this.informationRecipient) {
            if (!item.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether the original representation section exists.
     *
     * @return {@code true} if the original representation section exists, {@code false} otherwise.
     */
    public boolean hasOriginalRepresentationSection() {
        return getSectionByLoincCode(ORIGINAL_REPR_SECTION_CODE_VALUE) != null;
    }

    /**
     * Returns whether the person who entered information into this document.
     *
     * @return {@code true} if the person who entered information into this document exists, {@code false} otherwise.
     */
    public boolean hasDataEnterer() {
        return this.dataEnterer != null && this.dataEnterer.hasEnterer();
    }
}
