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
package org.projecthusky.communication.xds_mhd;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A mapper for system OIDs and URIs.
 * <p>
 * A list of systems is available on <a href="http://hl7.org/fhir/terminologies-systems.html">HL7 FHIR website</a>.
 *
 * @author Quentin Ligier
 */
public class SystemMapper {

    /**
     * The list of known systems.
     */
    private static final List<@NonNull SystemEntry> systems = new ArrayList<>(5);

    /*
     * Initializes the known systems. Adjust the initial capacity if you add/remove entries.
     */
    static {
        systems.add(new SystemEntry("SNOMED CT", "http://snomed.info/sct", "2.16.840.1.113883.6.96"));
        systems.add(new SystemEntry("LOINC", "http://loinc.org", "2.16.840.1.113883.6.1"));
        systems.add(new SystemEntry("ATC WHO", "http://www.whocc.no/atc", "2.16.840.1.113883.6.73"));
        systems.add(new SystemEntry("HL7 Substance Admin Substitution",
                                    "http://terminology.hl7.org/CodeSystem/v3-substanceAdminSubstitution",
                                    "2.16.840.1.113883.5.1070"));
        systems.add(new SystemEntry("GTIN", "https://www.gs1.org/gtin", "2.51.1.1"));
    }

    private SystemMapper() {
    }

    /**
     * Finds a system by its URI.
     *
     * @param uri The non-null system URI.
     * @return the {@link SystemEntry} found or {@code null}.
     */
    @Nullable
    public static SystemEntry findByUri(final String uri) {
        Objects.requireNonNull(uri, "uri shall not be null in findByUri()");
        for (final SystemEntry systemEntry : systems) {
            if (uri.equals(systemEntry.systemUri)) {
                return systemEntry;
            }
        }
        return null;
    }

    /**
     * Finds a system by its OID.
     *
     * @param oid The non-null system OID.
     * @return the {@link SystemEntry} found or {@code null}.
     */
    @Nullable
    public static SystemEntry findByOid(final String oid) {
        Objects.requireNonNull(oid, "oid shall not be null in findByOid()");
        for (final SystemEntry systemEntry : systems) {
            if (oid.equals(systemEntry.systemOid)) {
                return systemEntry;
            }
        }
        return null;
    }

    /**
     * Finds a system by its name.
     *
     * @param name The non-null system name.
     * @return the {@link SystemEntry} found or {@code null}.
     */
    @Nullable
    public static SystemEntry findByName(final String name) {
        Objects.requireNonNull(name, "name shall not be null in findByName()");
        for (final SystemEntry systemEntry : systems) {
            if (name.equals(systemEntry.systemName())) {
                return systemEntry;
            }
        }
        return null;
    }

    /**
     * Checks if a known system uses the given URI.
     *
     * @param uri The system URI to check.
     * @return {@code true} if a known system uses the given URI, {@code false} otherwise.
     */
    public static boolean hasUri(final String uri) {
        return findByUri(uri) != null;
    }

    /**
     * Checks if a known system uses the given OID.
     *
     * @param oid The system OID to check.
     * @return {@code true} if a known system uses the given OID, {@code false} otherwise.
     */
    public static boolean hasOid(final String oid) {
        return findByOid(oid) != null;
    }

    /**
     * Checks if a known system uses the given name.
     *
     * @param name The system name to check.
     * @return {@code true} if a known system uses the given name, {@code false} otherwise.
     */
    public static boolean hasName(final String name) {
        return findByName(name) != null;
    }

    /**
     * Converts an OID to a URI, or returns {@code null} if the system is not found.
     *
     * @param oid The system OID.
     * @return the URI string or {@code null}.
     */
    public static @Nullable String oidToUri(final String oid) {
        final SystemEntry system = findByOid(oid);
        if (system != null) {
            return system.systemUri();
        }
        return null;
    }

    /**
     * Converts a URI to an OID, or returns {@code null} if the system is not found.
     *
     * @param uri The system URI.
     * @return the OID string or {@code null}.
     */
    public static @Nullable String uriToOid(final String uri) {
        final SystemEntry system = findByUri(uri);
        if (system != null) {
            return system.systemOid();
        }
        return null;
    }

    /**
     * Internal model of a system information
     *
     * @param systemName The system human name.
     * @param systemUri  The system URI.
     * @param systemOid  The system OID.
     */
    public record SystemEntry(String systemName, String systemUri, String systemOid) {
    }
}
