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
import org.projecthusky.fhir.emed.ch.common.enums.AddressLineType;

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
        public static final String LINE_TYPE_URL = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-ech-10-linetype";
        public static final String STREET_NAME_URL = "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-streetName";
        public static final String HOUSE_NUMBER_URL = "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-houseNumber";
        public static final String UNIT_ID_URL = "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-unitID";
        public static final String POSTBOX_URL = "http://hl7.org/fhir/StructureDefinition/iso21090-ADXP-postBox";

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
         * Constructor for a string. A string type containing the received string will be implicitly created.
         * @param line The address line string to use.
         */
        public AddressLineAdapter(final String line) {
            this.line = new StringType(Objects.requireNonNull(line));
        }

        /**
         * Gets the underlying address line.
         */
        public StringType getLine() {
            return this.line;
        }

        /**
         * Gets the address line type from the <a href="">ECH0010AddressLineType</a> extension if present and matching a
         * proper value. {@code null} otherwise.
         */
        public @Nullable AddressLineType getLineType() {
            final var lineTypeExtension = line.getExtensionByUrl(LINE_TYPE_URL);
            if (lineTypeExtension != null)
                return AddressLineType.getEnum(lineTypeExtension.getValueAsPrimitive().getValueAsString());
            else return null;
        }

        /**
         * Gets the street name extension content from the address line.
         * @return The string containing the street name from the extension, if it exists, {@code null} otherwise.
         */
        public @Nullable String getStreetName() {
            return line.getExtensionString(STREET_NAME_URL);
        }

        /**
         * Sets the street name extension for the wrapped address line.
         * @param streetName The street name to be set in the extension.
         * @return The address line adapter itself.
         */
        public AddressLineAdapter setStreetName(final String streetName) {
            line.addExtension(STREET_NAME_URL, new StringType(streetName));
            return this;
        }

        /**
         * Gets the house number extension content from the address line.
         * @return The string containing the house number from the extension if it exists, otherwise {@code null}.
         */
        public @Nullable String getHouseNumber() {
            return line.getExtensionString(HOUSE_NUMBER_URL);
        }

        /**
         * Sets the house number extension for the wrapped address line.
         * @param houseNumber The house number to be set in the extension.
         * @return The address line adapter itself.
         */
        public AddressLineAdapter setHouseNumber(final String houseNumber) {
            line.addExtension(HOUSE_NUMBER_URL, new StringType(houseNumber));
            return this;
        }

        /**
         * Gets the unit id extension content from the address line.
         * @return The string containing the unit id from the extension if it exists, otherwise {@code null}.
         */
        public @Nullable String getUnitId() {
            return line.getExtensionString(UNIT_ID_URL);
        }

        /**
         * Sets the unit id extension for the wrapped address line.
         * @param unitId The unit id to be set in the extension.
         * @return The address line adapter itself.
         */
        public AddressLineAdapter setUnitId(final String unitId) {
            line.addExtension(UNIT_ID_URL, new StringType(unitId));
            return this;
        }

        /**
         * Gets the postbox extension content from the address line.
         * @return The string containing the postbox from the extension if it exists, otherwise {@code null}.
         */
        public @Nullable String getPostBox() {
            return line.getExtensionString(POSTBOX_URL);
        }

        /**
         * Sets the postbox extension for the wrapped address line.
         * @param postBox The postbox to be set in the extension.
         * @return The address line adapter itself.
         */
        public AddressLineAdapter setPostBox(final String postBox) {
            line.addExtension(POSTBOX_URL, new StringType(postBox));
            return this;
        }
    }
}
