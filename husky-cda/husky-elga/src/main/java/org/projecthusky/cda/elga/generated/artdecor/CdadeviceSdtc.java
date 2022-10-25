/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Device;

/**
 * CDADeviceSDTC
 * <p>
 * Template description: Template CDA Device (prototype, directly derived from POCD_RM000040 MIF) + SDTC extensions<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.815<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class CdadeviceSdtc extends POCDMT000040Device {

    public CdadeviceSdtc() {
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7ManufacturerModelName
     */
    public org.projecthusky.common.hl7cdar2.SC getHl7ManufacturerModelName() {
        return manufacturerModelName;
    }

    /**
     * Gets the hl7SoftwareName
     */
    public org.projecthusky.common.hl7cdar2.SC getHl7SoftwareName() {
        return softwareName;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedCode() {
        return createHl7CodeFixedValue();
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7ManufacturerModelName
     */
    public void setHl7ManufacturerModelName(org.projecthusky.common.hl7cdar2.SC value) {
        this.manufacturerModelName = value;
    }

    /**
     * Sets the hl7SoftwareName
     */
    public void setHl7SoftwareName(org.projecthusky.common.hl7cdar2.SC value) {
        this.softwareName = value;
    }
}
