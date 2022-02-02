/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.POCDMT000040AuthoringDevice;

/**
 * atcdabbr_other_DeviceCompilation
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.18<br>
 * Effective date: 2021-06-28 13:57:36<br>
 * Version: 1.0.1+20210628<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrOtherDeviceCompilation extends POCDMT000040AuthoringDevice {

    public AtcdabbrOtherDeviceCompilation() {
    }

    /**
     * Gets the hl7ManufacturerModelName
     */
    public org.husky.common.hl7cdar2.SC getHl7ManufacturerModelName() {
        return manufacturerModelName;
    }

    /**
     * Gets the hl7SoftwareName
     */
    public org.husky.common.hl7cdar2.SC getHl7SoftwareName() {
        return softwareName;
    }

    /**
     * Sets the hl7ManufacturerModelName
     */
    public void setHl7ManufacturerModelName(org.husky.common.hl7cdar2.SC value) {
        this.manufacturerModelName = value;
    }

    /**
     * Sets the hl7SoftwareName
     */
    public void setHl7SoftwareName(org.husky.common.hl7cdar2.SC value) {
        this.softwareName = value;
    }
}
