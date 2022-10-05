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
package org.projecthusky.common.enums;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.utils.datatypes.Hl7v25;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;

import java.util.Collection;
import java.util.Objects;

/**
 * Interface for all dynamically created/updated value sets.
 */
public interface ValueSetEnumInterface extends CodedMetadataEnumInterface {

    /**
     * Gets the HL7 {@link CE}.
     *
     * @return the HL7 CE.
     */
    @NonNull
    default CE getCE() {
        return this.getCE(null);
    }

    /**
     * Gets the HL7 {@link CE} in the given language.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the HL7 CE.
     */
    @NonNull
    default CE getCE(@Nullable final LanguageCode languageCode) {
        final var ce = new CE();
        ce.setCodeSystem(getCodeSystemId());
        ce.setCode(getCodeValue());
        if (!getCodeSystemName().isEmpty()) {
            ce.setCodeSystemName(getCodeSystemName());
        }
        if (!getDisplayName().isEmpty()) {
            ce.setDisplayName(getDisplayName(languageCode));
        }
        return ce;
    }

    /**
     * Gets the HL7 {@link CD}.
     *
     * @return the HL7 CD.
     */
    @NonNull
    default CD getCD() {
        return this.getCD(null);
    }

    /**
     * Gets the HL7 {@link CD}.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the HL7 CD.
     */
    @NonNull
    default CD getCD(@Nullable final LanguageCode languageCode) {
        final var cd = new CD();
        cd.setCodeSystem(getCodeSystemId());
        cd.setCode(getCodeValue());
        if (!getCodeSystemName().isEmpty()) {
            cd.setCodeSystemName(getCodeSystemName());
        }
        if (!getDisplayName().isEmpty()) {
            cd.setDisplayName(getDisplayName(languageCode));
        }
        return cd;
    }

    /**
     * Gets the husky Code Object.
     *
     * @return the code.
     */
    @NonNull
    default Code getCode() {
        return this.getCode(null);
    }

    /**
     * Gets the husky Code Object.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the code.
     */
    @NonNull
    default Code getCode(@Nullable final LanguageCode languageCode) {
        return new Code(getCodeValue(), getCodeSystemId(), getDisplayName(languageCode));
    }

    /**
     * Gets the IPF metadata {@link org.openehealth.ipf.commons.ihe.xds.core.metadata.Code}.
     *
     * @return the IPF code.
     */
    @Override
    default org.openehealth.ipf.commons.ihe.xds.core.metadata.@NonNull Code getIpfCode() {
		return new org.openehealth.ipf.commons.ihe.xds.core.metadata.Code(
				this.getCodeValue(),
				new LocalizedString(this.getDisplayName(), LanguageCode.ENGLISH_CODE, "UTF-8"),
				this.getCodeSystemId()
		);
    }

    /**
     * Verifies if the current instance and a {@link org.openehealth.ipf.commons.ihe.xds.core.metadata.Code} are coding
     * the same value in the same system.
     *
     * @param code The code to compare.
     * @return {@code true} if they are equal, {@code false} otherwise.
     */
    @Override
    default boolean isEqualTo(final org.openehealth.ipf.commons.ihe.xds.core.metadata.@NonNull Code code) {
        return this.getCodeSystemId().equals(Objects.requireNonNull(code).getSchemeName())
                && this.getCodeValue().equals(code.getCode());
    }

    /**
     * Checks whether a collection of codes contains a particular value set code.
     *
     * @param codes The collection of codes.
     * @return {@code true} if the collection contains the value set code, {@code false} otherwise.
     */
    @Override
    default boolean isContainedIn(@NonNull final Collection<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> codes) {
        return Objects.requireNonNull(codes).stream().anyMatch(this::isEqualTo);
    }

    /**
     * Encodes an eHC value set code to an IHE Coded String, as defined in ITI TF-3 Table 4.2.3.1.7-2. It is mostly an
     * HL7 V2.5 CX field. The code is escaped, the code system ID shall be an OID so escaping it shouldn't be needed.
     *
     * @return the encoded IHE Coded String.
     */
    @Override
    @NonNull
    default String getCodedString() {
        return String.format(
                "%s^^^&%s&ISO",
                Hl7v25.encodeSt(this.getCodeValue()),
                this.getCodeSystemId()
        );
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @NonNull
    String getCodeSystemId();

    /**
     * Gets the code system name.
     *
     * @return the code system name.
     */
    @NonNull
    String getCodeSystemName();

    /**
     * Gets the actual Code as string.
     *
     * @return the code.
     */
    @NonNull
    String getCodeValue();

    /**
     * Gets the default display name.
     *
     * @return the default display name.
     */
    @NonNull
    default String getDisplayName() {
        return getDisplayName(null);
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @NonNull
    String getDisplayName(@Nullable final LanguageCode languageCode);

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @NonNull
    String getValueSetId();

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @NonNull
    String getValueSetName();
}
