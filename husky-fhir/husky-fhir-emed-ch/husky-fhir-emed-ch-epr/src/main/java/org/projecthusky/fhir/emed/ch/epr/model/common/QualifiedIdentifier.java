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
package org.projecthusky.fhir.emed.ch.epr.model.common;

import java.util.Objects;

/**
 * A qualified identifier.
 *
 * @author Quentin Ligier
 */
public class QualifiedIdentifier {

    /**
     * The assigned identifier.
     */
    private String identifier;

    /**
     * The assigning authority.
     */
    private String assigningAuthority;

    public QualifiedIdentifier(final String identifier,
                               final String assigningAuthority) {
        this.identifier = Objects.requireNonNull(identifier);
        this.assigningAuthority = Objects.requireNonNull(assigningAuthority);
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(final String identifier) {
        this.identifier = Objects.requireNonNull(identifier);
    }

    public String getAssigningAuthority() {
        return assigningAuthority;
    }

    public void setAssigningAuthority(final String assigningAuthority) {
        this.assigningAuthority = Objects.requireNonNull(assigningAuthority);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof QualifiedIdentifier)) return false;
        final QualifiedIdentifier that = (QualifiedIdentifier) o;
        return identifier.equals(that.identifier) && assigningAuthority.equals(that.assigningAuthority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, assigningAuthority);
    }

    @Override
    public String toString() {
        return "QualifiedIdentifier{" +
                "identifier='" + identifier + '\'' +
                ", assigningAuthority='" + assigningAuthority + '\'' +
                '}';
    }
}
