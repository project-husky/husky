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
package org.projecthusky.fhir.emed.ch.common.util;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Identifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Identifier utilities.
 *
 * @author Quentin Ligier
 **/
public class Identifiers {

    /**
     * This class is not instantiable.
     */
    private Identifiers() {
    }

    /**
     * Gets a single identifier by its system in a list.
     *
     * @param identifiers All identifiers.
     * @param system      The system to find.
     * @return the first identifier with the given system or {@code null} if none found.
     */
    @Nullable
    public static Identifier getBySystem(final List<Identifier> identifiers,
                                         final String system) {
        for (final var identifier : identifiers) {
            if (system.equals(identifier.getSystem())) {
                return identifier;
            }
        }
        return null;
    }

    /**
     * Gets the value of a single identifier by its system in a list.
     *
     * @param identifiers All identifiers.
     * @param system      The system to find.
     * @return the value of first identifier with the given system or {@code null} if none found.
     */
    @Nullable
    public static String getValueBySystem(final List<Identifier> identifiers,
                                          final String system) {
        final var identifier = getBySystem(identifiers, system);
        if (identifier == null || identifier.getValue() == null) {
            return null;
        }
        return identifier.getValue();
    }

    /**
     * Sets the value of a single identifier by its system in a list.
     *
     * @param identifiers All identifiers.
     * @param system      The system to find.
     * @param value       The value to set
     * @return the created/modified Identifier
     */
    public static Identifier setValueBySystem(final List<Identifier> identifiers,
                                              final String system,
                                              final String value) {
        var identifier = getBySystem(identifiers, system);
        if (identifier == null) {
            identifier = new Identifier();
            identifier.setSystem(system);
        }
        identifier.setValue(value);
        return identifier;
    }

    /**
     * Finds identifiers by their system in a list.
     *
     * @param identifiers All identifiers.
     * @param system      The system to find.
     * @return a list of the identifiers with the given system.
     */
    public static List<Identifier> findBySystem(final List<Identifier> identifiers,
                                                final String system) {
        final var foundIdentifiers = new ArrayList<Identifier>(0);
        for (final var identifier : identifiers) {
            if (system.equals(identifier.getSystem())) {
                foundIdentifiers.add(identifier);
            }
        }
        return foundIdentifiers;
    }
}
