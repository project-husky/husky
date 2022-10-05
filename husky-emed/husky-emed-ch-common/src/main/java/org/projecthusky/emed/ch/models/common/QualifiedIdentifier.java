package org.projecthusky.emed.ch.models.common;

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
