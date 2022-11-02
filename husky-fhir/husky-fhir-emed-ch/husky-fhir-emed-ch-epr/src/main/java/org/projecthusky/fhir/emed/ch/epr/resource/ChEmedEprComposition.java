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
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.resource.ChEmedOrganization;
import org.projecthusky.fhir.emed.ch.common.util.FhirSystem;

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

    @Nullable
    @Child(name = "informationRecipient", min = 1, max = Child.MAX_UNLIMITED)
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-informationrecipient", definedLocally = false)
    protected List<Reference> informationRecipient;

    // TODO add support for extension dataEnterer

    // TODO language

    // TODO author on each child class

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprComposition() {
        super();
        this.setVersionNumber(1);
        this.setStatus(CompositionStatus.FINAL);
        this.setConfidentiality(DocumentConfidentiality.N);
        final var confidentialityCode = new Coding(FhirSystem.SNOMEDCT, "17621005", "Normal (qualifier value)");
        this.getConfidentialityElement().addExtension(
                "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-confidentialitycode",
                new CodeableConcept().addCoding(confidentialityCode));
    }

    /**
     * Constructor
     *
     * @param compositionId Version-independent identifier for the Composition
     * @param date The document's creation date and time
     */
    public ChEmedEprComposition(final UUID compositionId,
                                final Date date) {
        this.getIdentifier().setSystem(FhirSystem.URI).setValue(Uuids.URN_PREFIX + compositionId);
        this.setDate(date);
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
        return UUID.fromString(this.getIdentifier().getValue());
    }

    /**
     *
     * @return
     */
    public UnsignedIntType getVersionNumberElement() {
        if (this.versionNumber == null) {
            this.versionNumber = new UnsignedIntType();
        }
        return this.versionNumber;
    }

    public int getVersionNumber() {
        return this.versionNumber == null || this.versionNumber.isEmpty() ? 0 : this.versionNumber.getValue();
    }

    public List<Reference> getInformationRecipient() {
        if (this.informationRecipient == null) {
            this.informationRecipient = new ArrayList<>(0);
        }
        return this.informationRecipient;
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

    public ChEmedEprComposition setVersionNumberElement(final UnsignedIntType versionNumber) {
        if (versionNumber.hasValue() && versionNumber.getValue() < 0) {
            throw new IllegalArgumentException("The version number shall be positive or zero");
        }
        this.versionNumber = versionNumber;
        return this;
    }

    public ChEmedEprComposition setVersionNumber(int value) {
        if (this.versionNumber == null)
            this.versionNumber = new UnsignedIntType();
        this.versionNumber.setValue(value);
        return this;
    }

    public ChEmedEprComposition setInformationRecipient(final List<Reference> informationRecipient) {
        this.informationRecipient = informationRecipient;
        return this;
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
        identifier.setValue(documentUUID.toString());

        return this;
    }

    public boolean hasVersionNumber() {
        return this.versionNumber != null && !this.versionNumber.isEmpty();
    }

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
}
