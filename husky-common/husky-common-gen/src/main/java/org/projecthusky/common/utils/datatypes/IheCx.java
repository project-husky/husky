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
package org.projecthusky.common.utils.datatypes;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;

import java.util.Objects;

/**
 * Model of an IHE CX, based on an HL7 v2.5 CX.
 *
 * @author Quentin Ligier
 */
public class IheCx {

    /**
     * The Id number.
     */
    private String idNumber;

    /**
     * The assigning authority identifier.
     */
    private String assigningAuthorityId;

    /**
     * Constructs a new IHE CX.
     *
     * @param idNumber             The Id number.
     * @param assigningAuthorityId The assigning authority identifier.
     */
    public IheCx(final String idNumber,
                 final String assigningAuthorityId) {
        this.idNumber = Objects.requireNonNull(idNumber);
        this.assigningAuthorityId = Objects.requireNonNull(assigningAuthorityId);
    }

    /**
     * Parses a string as an IHE CX.
     *
     * @param string The string to parse.
     * @return the parsed IHE CX or {@code null} if the string is not a valid format.
     */
    @Nullable
    public static IheCx parse(@Nullable final String string) {
        if (!validate(string)) {
            return null;
        }
        final Identifiable cx = Hl7v2Based.parse(string, Identifiable.class);
        if (cx.getAssigningAuthority() == null) {
            return null;
        }
        return new IheCx(
            cx.getId(),
            cx.getAssigningAuthority().getUniversalId()
        );
    }

    /**
     * Validates that a string is a valid IHE CX.
     *
     * @param string The string to validate.
     * @return {@code true} if the string is a valid IHE CX, {@code false} otherwise.
     */
    public static boolean validate(@Nullable final String string) {
        if (string == null || string.isBlank()) {
            return false;
        }
        final var cx = Hl7v2Based.parse(string, Identifiable.class).getHapiObject();
        if (cx == null
            || cx.getCx1_IDNumber().getValue() == null
            || cx.getCx2_CheckDigit().getValue() != null
            || cx.getCx3_CheckDigitScheme().getValue() != null
            || cx.getCx4_AssigningAuthority().getHd1_NamespaceID().getValue() != null
            || cx.getCx4_AssigningAuthority().getHd2_UniversalID().getValue() == null
            || cx.getCx4_AssigningAuthority().getHd3_UniversalIDType().getValue() == null
            || cx.getCx5_IdentifierTypeCode().getValue() != null
            || cx.getCx6_AssigningFacility().getHd1_NamespaceID().getValue() != null
            || cx.getCx6_AssigningFacility().getHd2_UniversalID().getValue() != null
            || cx.getCx6_AssigningFacility().getHd3_UniversalIDType().getValue() != null
            || cx.getCx7_EffectiveDate().getValue() != null
            || cx.getCx8_ExpirationDate().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe1_Identifier().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe2_Text().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe3_NameOfCodingSystem().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe4_AlternateIdentifier().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe5_AlternateText().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe6_NameOfAlternateCodingSystem().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe7_CodingSystemVersionID().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe8_AlternateCodingSystemVersionID().getValue() != null
            || cx.getCx9_AssigningJurisdiction().getCwe9_OriginalText().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe1_Identifier().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe2_Text().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe3_NameOfCodingSystem().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe4_AlternateIdentifier().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe5_AlternateText().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe6_NameOfAlternateCodingSystem().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe7_CodingSystemVersionID().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe8_AlternateCodingSystemVersionID().getValue() != null
            || cx.getCx10_AssigningAgencyOrDepartment().getCwe9_OriginalText().getValue() != null) {
            return false;
        } else if (!"ISO".equals(cx.getAssigningAuthority().getHd3_UniversalIDType().getValue())) {
            return false;
        } else return Oids.PATTERN.matcher(cx.getCx4_AssigningAuthority().getHd2_UniversalID().getValue()).matches();
    }

    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the Id number.
     *
     * @param idNumber the Id number, as a non-null, non-blank string.
     */
    public void setIdNumber(final String idNumber) {
        if (Objects.requireNonNull(idNumber).isBlank()) {
            throw new IllegalArgumentException("The id number shall not be blank");
        }
        this.idNumber = idNumber;
    }

    public String getAssigningAuthorityId() {
        return assigningAuthorityId;
    }

    /**
     * Sets the assigning authority Id.
     *
     * @param assigningAuthorityId the assigning authority Id, as a non-null, non-blank string.
     */
    public void setAssigningAuthorityId(final String assigningAuthorityId) {
        if (Objects.requireNonNull(assigningAuthorityId).isBlank()) {
            throw new IllegalArgumentException("The assigning authority Id shall not be blank");
        }
        this.assigningAuthorityId = assigningAuthorityId;
    }

    /**
     * Returns the assigning authority type ID.
     */
    public String getAssigningAuthorityTypeId() {
        return "ISO";
    }

    /**
     * Renders the instance as an IHE CX.
     */
    public String render() {
        final var cx = new Identifiable();
        cx.setId(this.idNumber);
        final var aa = new AssigningAuthority();
        aa.setUniversalId(this.assigningAuthorityId);
        aa.setUniversalIdType(this.getAssigningAuthorityTypeId());
        cx.setAssigningAuthority(aa);
        return Hl7v2Based.render(cx);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final IheCx that)) return false;
        return idNumber.equals(that.idNumber)
            && assigningAuthorityId.equals(that.assigningAuthorityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, assigningAuthorityId);
    }

    @Override
    public String toString() {
        return "IheCx{" +
            "idNumber='" + this.idNumber + '\'' +
            ", assigningAuthorityId='" + this.assigningAuthorityId + '\'' +
            '}';
    }
}
