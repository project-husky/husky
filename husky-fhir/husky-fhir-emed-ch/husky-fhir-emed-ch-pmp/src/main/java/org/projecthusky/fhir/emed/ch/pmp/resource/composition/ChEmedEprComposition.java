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
package org.projecthusky.fhir.emed.ch.pmp.resource.composition;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.hl7.fhir.r4.model.BaseReference;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.UnsignedIntType;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChCoreOrganizationEpr;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The HAPI custom structure for CH-EMED-EPR Compositions.
 * <p>
 * It assumes {@code Configuration.status = 0}, i.e. 'auto-create' mode when accessing attributes that have not been
 * set.
 *
 * @author Quentin Ligier
 **/
public abstract class ChEmedEprComposition extends Composition {

    public static final String ORIGINAL_REPR_SECTION_CODE_VALUE = "55108-5";
    public static final String TREATMENT_PLAN_SECTION_CODE_VALUE = "77604-7";
    public static final String ANNOTATION_SECTION_CODE_VALUE = "48767-8";

    @Child(name = "versionNumber")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-versionnumber", definedLocally = false)
    protected UnsignedIntType versionNumber;

    @Child(name = "informationRecipient", min = 1, max = Child.MAX_UNLIMITED)
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-informationrecipient", definedLocally = false)
    protected List<Reference> informationRecipient;

    // dataEnterer


    /**
     * Returns the targeted patient. It's a shortcut for {@code (ChCorePatientEpr) getSubject().getResource()}.
     *
     * @return the patient.
     * @throws InvalidEmedContentException if the patient is not set or not an instance of {@link ChCorePatientEpr}.
     */
    @ExpectsValidResource
    public ChCorePatientEpr getChPatient() throws InvalidEmedContentException {
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
     *                                     {@link ChCoreOrganizationEpr}.
     */
    @ExpectsValidResource
    public ChCoreOrganizationEpr getChCustodian() throws InvalidEmedContentException {
        return Optional.ofNullable(this.custodian)
                .map(BaseReference::getResource)
                .map(ChCoreOrganizationEpr.class::cast)
                .orElseThrow(() -> new InvalidEmedContentException("The custodian reference is missing or of wrong " +
                                                                           "type"));
    }

    public UnsignedIntType getVersionNumberElement() {
        if (this.versionNumber == null) {
            this.versionNumber = new UnsignedIntType();
        }
        return this.versionNumber;
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

    public int getVersionNumber() {
        return this.versionNumber == null || this.versionNumber.isEmpty() ? 0 : this.versionNumber.getValue();
    }

    public boolean hasVersionNumber() {
        return this.versionNumber != null && !this.versionNumber.isEmpty();
    }

    public List<Reference> getInformationRecipient() {
        if (this.informationRecipient == null) {
            this.informationRecipient = new ArrayList<>(0);
        }
        return this.informationRecipient;
    }

    public ChEmedEprComposition setInformationRecipient(final List<Reference> informationRecipient) {
        this.informationRecipient = informationRecipient;
        return this;
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
}
