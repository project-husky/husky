/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.services.readers;

import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.POCDMT000040AuthoringDevice;

import java.util.Objects;
import java.util.Optional;

/**
 * A reader for CDA-CH-EMED POCDMT000040AuthoringDevice.
 *
 * @author Quentin Ligier
 */
public class DeviceReader {

    private final POCDMT000040AuthoringDevice device;

    public DeviceReader(final POCDMT000040AuthoringDevice device) {
        this.device = Objects.requireNonNull(device);
    }

    /**
     * Gets the manufacturer model's name, if any.
     */
    public Optional<String> getManufacturerModelName() {
        return Optional.ofNullable(this.device.getManufacturerModelName())
                .map(ANY::getMergedXmlMixed);
    }

    /**
     * Gets the software's name.
     */
    public String getSoftwareName() {
        return Optional.ofNullable(this.device.getSoftwareName())
                .map(ANY::getMergedXmlMixed)
                .orElseThrow();
    }
}
