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
package org.projecthusky.fhir.emed.ch.common.datatype;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.StringType;

import java.util.List;
import java.util.Objects;

/**
 * An adapter for the CHCoreAddress datatype.
 *
 * @author Quentin Ligier
 **/
public class ChCoreAddressAdapter {

    /**
     * URLs for extensions.
     */
    public static final String BFS_EXTENSION = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-ech-7" +
            "-municipalityid";
    public static final String COUNTRY_CODE_EXTENSION = "http://hl7.org/fhir/StructureDefinition/iso21090-SC-coding";

    /**
     * The underlying address;
     */
    private final Address address;

    /**
     * Creates a new adapter around an empty address.
     */
    public ChCoreAddressAdapter() {
        this.address = new Address();
    }

    /**
     * Constructor with an instance of address.
     *
     * @param address The instance of address to use. It will be mutated if using setter methods.
     */
    public ChCoreAddressAdapter(final Address address) {
        this.address = Objects.requireNonNull(address);
    }

    /**
     * Returns the underlying address.
     *
     * @return the address.
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Returns the city BFS or {@code null} if it is not present.
     *
     * @return the city BFS or {@code null}.
     * @see <a href="https://www.bfs.admin.ch/bfs/de/home/grundlagen/agvch.html">BFS-Nummer</a>
     * @see <a
     * href="https://www.bfs.admin.ch/bfs/fr/home/bases-statistiques/repertoire-officiel-communes-suisse.html">Numéro
     * OFS</a>
     * @see <a href="https://www.bfs.admin.ch/bfs/it/home/basi-statistiche/elenco-ufficiale-comuni-svizzera.html">Numero
     * UST</a>
     */
    @Nullable
    public String getCityBfs() {
        return this.address.getCityElement().getExtensionString(BFS_EXTENSION);
    }

    /**
     * Sets the city BFS.
     *
     * @param bfs The city BFS.
     * @see <a href="https://www.bfs.admin.ch/bfs/de/home/grundlagen/agvch.html">BFS-Nummer</a>
     * @see <a
     * href="https://www.bfs.admin.ch/bfs/fr/home/bases-statistiques/repertoire-officiel-communes-suisse.html">Numéro
     * OFS</a>
     * @see <a href="https://www.bfs.admin.ch/bfs/it/home/basi-statistiche/elenco-ufficiale-comuni-svizzera.html">Numero
     * UST</a>
     * @return this.
     */
    public ChCoreAddressAdapter setCityBfs(@Nullable final String bfs) {
        this.address.getCityElement().addExtension(BFS_EXTENSION, new StringType(bfs));
        return this;
    }

    /**
     * Gets the country code (ISO Country Alpha-2 or ISO Country Alpha-3 code), or {@code null}.
     *
     * @return the country code or {@code null}.
     */
    @Nullable
    public String getCountryCode() {
        return this.address.getCountryElement().getExtensionString(COUNTRY_CODE_EXTENSION);
    }

    /**
     * Sets the country code (ISO Country Alpha-2 or ISO Country Alpha-3 code).
     *
     * @param countryCode The country code (ISO Country Alpha-2 or ISO Country Alpha-3 code).
     * @return this.
     */
    public ChCoreAddressAdapter setCountryCode(@Nullable final String countryCode) {
        this.address.getCountryElement().addExtension(COUNTRY_CODE_EXTENSION, new StringType(countryCode));
        return this;
    }

    /**
     * Returns the list of address lines.
     *
     * @return a list of address line adapters.
     */
    public List<AddressLineAdapter> getLines() {
        return this.address.getLine().stream().map(AddressLineAdapter::new).toList();
    }

    /**
     * Adds an address line.
     *
     * @param addressLineAdapter The address line adapter.
     * @return this.
     */
    public ChCoreAddressAdapter addLine(final AddressLineAdapter addressLineAdapter) {
        this.address.getLine().add(addressLineAdapter.getLine());
        return this;
    }

    public static final class AddressLineAdapter {

        /**
         * URLs of extensions.
         */
        public static final String LINE_TYPE = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-ech-10-linetype";

        /**
         * The underlying address line.
         */
        private final StringType line;

        /**
         * Creates a new adapter around an empty address line.
         */
        public AddressLineAdapter() {
            this.line = new StringType();
        }

        /**
         * Constructor with an instance of address line.
         *
         * @param line The instance of address line to use. It will be mutated if using setter methods.
         */
        public AddressLineAdapter(final StringType line) {
            this.line = Objects.requireNonNull(line);
        }

        /**
         * Gets the underlying address line.
         */
        public StringType getLine() {
            return this.line;
        }
    }
}
