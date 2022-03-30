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
package org.husky.common.utils.datatypes;

import ca.uhn.hl7v2.model.v25.datatype.HD;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;

import java.util.Objects;

/**
 * Model of an IHE XON, based on an HL7 v2.5 XON.
 *
 * @author Quentin Ligier
 */
public class IheXon {

    /**
     * Maximum length of an IHE XON.
     */
    private static final int MAX_LENGTH = 256;

    /**
     * Organization name. Required, not limited.
     */
    @MonotonicNonNull
    private String organizationName;

    /**
     * Organization identifier. Optional.
     */
    @Nullable
    private String organizationId;

    /**
     * Assigning authority id. Forbidden if organizationId is an OID or {@code null}, required otherwise.
     */
    @Nullable
    private String assigningAuthorityId;

    /**
     * Constructs a new IHE XON.
     *
     * @param organizationName     The name of the organization as a non-null, non-blank string.
     * @param organizationId       The ID of the organization. It should be an OID; if not, the assigning authority ID
     *                             shall be given.
     * @param assigningAuthorityId The ID of the assigning authority that have assigned the {@code organizationId}.
     */
    public IheXon(final String organizationName,
                  @Nullable final String organizationId,
                  @Nullable final String assigningAuthorityId) {
        this.setOrganizationName(organizationName);
        this.setOrganizationId(organizationId, assigningAuthorityId);
    }

    /**
     * Parses a string as an IHE XON.
     *
     * @param string The string to parse.
     * @return the parsed IHE XON or {@code null} if the string is not a valid format.
     */
    @Nullable
    public static IheXon parse(final String string) {
        if (!validate(string)) {
            return null;
        }
        final Organization xon = Hl7v2Based.parse(string, Organization.class);
        return new IheXon(
            xon.getOrganizationName(),
            xon.getIdNumber(),
            (xon.getAssigningAuthority() != null) ? xon.getAssigningAuthority().getUniversalId() : null
        );
    }

    /**
     * Validates that a string is a valid IHE XON.
     *
     * @param string The string to validate.
     * @return {@code true} if the string is a valid IHE XON, {@code false} otherwise.
     */
    public static boolean validate(@Nullable final String string) {
        if (string == null || string.isBlank() || string.length() > MAX_LENGTH) {
            return false;
        }
        final var xon = Hl7v2Based.parse(string, Organization.class).getHapiObject();
        if (xon == null
            || xon.getXon1_OrganizationName().getValue() == null
            || xon.getXon2_OrganizationNameTypeCode().getValue() != null
            || xon.getXon3_IDNumber().getValue() != null
            || xon.getXon4_CheckDigit().getValue() != null
            || xon.getXon5_CheckDigitScheme().getValue() != null
            || xon.getXon6_AssigningAuthority().getHd1_NamespaceID().getValue() != null
            || xon.getXon7_IdentifierTypeCode().getValue() != null
            || xon.getXon8_AssigningFacility().getHd1_NamespaceID().getValue() != null
            || xon.getXon8_AssigningFacility().getHd2_UniversalID().getValue() != null
            || xon.getXon8_AssigningFacility().getHd3_UniversalIDType().getValue() != null
            || xon.getXon9_NameRepresentationCode().getValue() != null) {
            return false; // Missing required field or presence of illegal fields
        }
        final HD assigningAuthority = xon.getXon6_AssigningAuthority();
        if (xon.getXon10_OrganizationIdentifier().getValue() == null) {
            return assigningAuthority.getHd2_UniversalID().getValue() == null && assigningAuthority.getHd3_UniversalIDType().getValue() == null;
        } else {
            if (!Oids.match(xon.getXon10_OrganizationIdentifier().getValue()) &&
                (assigningAuthority.getHd2_UniversalID().getValue() == null || assigningAuthority.getHd3_UniversalIDType().getValue() == null
                    || !"ISO".equals(assigningAuthority.getHd3_UniversalIDType().getValue()))) {
                return false;
            }
            return !Oids.match(xon.getXon10_OrganizationIdentifier().getValue()) ||
                (assigningAuthority.getHd2_UniversalID().getValue() == null && assigningAuthority.getHd3_UniversalIDType().getValue() == null);
        }
    }

    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the organization name.
     *
     * @param organizationName The organization name as a non-null, non-blank string.
     * @throws IllegalArgumentException if the name is blank.
     */
    public void setOrganizationName(final String organizationName) {
        if (Objects.requireNonNull(organizationName).isBlank()) {
            throw new IllegalArgumentException("The organization name shall not be blank");
        }
        this.organizationName = organizationName;
    }

    @Nullable
    public String getOrganizationId() {
        return organizationId;
    }

    @Nullable
    public String getAssigningAuthorityId() {
        return assigningAuthorityId;
    }

    /**
     * Sets the organization ID, possibly with an assigning authority ID.
     *
     * @param organizationId       The organization ID, nullable.
     * @param assigningAuthorityId The assigning authority ID, non-null only when the organization ID is provided and
     *                             not an OID.
     * @throws IllegalArgumentException if arguments are invalid.
     */
    public void setOrganizationId(@Nullable final String organizationId,
                                  @Nullable final String assigningAuthorityId) {
        if (organizationId == null && assigningAuthorityId == null) {
            this.organizationId = null;
            this.assigningAuthorityId = null;
            return;
        }
        if (organizationId == null || organizationId.isBlank()) {
            throw new IllegalArgumentException("An IHE XON cannot have an assigning authority ID without an organization ID");
        }
        final boolean isOrganizationOid = Oids.match(organizationId);
        if (isOrganizationOid && assigningAuthorityId != null) {
            throw new IllegalArgumentException("An IHE XON shall not have an assigning authority ID with an OID");
        }
        if (!isOrganizationOid && (assigningAuthorityId == null || assigningAuthorityId.isBlank())) {
            throw new IllegalArgumentException("An IHE XON shall have an assigning authority ID without an OID");
        }
        if (isOrganizationOid) {
            this.organizationId = Oids.normalize(organizationId);
            this.assigningAuthorityId = null;
        } else {
            this.organizationId = organizationId;
            this.assigningAuthorityId = assigningAuthorityId;
        }
    }

    /**
     * Getter of the assigning authority ID type.
     */
    @Nullable
    public String getAssigningAuthorityIdType() {
        return (this.assigningAuthorityId != null) ? "ISO" : null;
    }

    /**
     * Renders the instance as an IHE XON.
     */
    public String render() {
        final var xon = new Organization();
        xon.setOrganizationName(this.organizationName);
        xon.setIdNumber(this.organizationId);
        if (this.assigningAuthorityId != null) {
            final var assigningAuthority = new AssigningAuthority();
            assigningAuthority.setUniversalId(this.assigningAuthorityId);
            assigningAuthority.setUniversalIdType("ISO");
            xon.setAssigningAuthority(assigningAuthority);
        }
        return Hl7v2Based.render(xon);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final IheXon that)) return false;
        return Objects.equals(organizationName, that.organizationName)
            && Objects.equals(organizationId, that.organizationId)
            && Objects.equals(assigningAuthorityId, that.assigningAuthorityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationName, organizationId, assigningAuthorityId);
    }

    @Override
    public String toString() {
        return "IheXon{" +
            "organizationName='" + this.organizationName + '\'' +
            ", organizationId='" + this.organizationId + '\'' +
            ", assigningAuthorityId='" + this.assigningAuthorityId + '\'' +
            '}';
    }
}
