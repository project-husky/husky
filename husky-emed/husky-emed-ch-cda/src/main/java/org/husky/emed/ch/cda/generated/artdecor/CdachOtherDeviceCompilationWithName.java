/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.POCDMT000040AuthoringDevice;

/**
 * cdach_other_DeviceCompilationWithName
 * <p>
 * Template description: Reusable template wherever a device with required name is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.A device is either a physical device (e.g. analyzer with which laboratory results are determined) or a software (e.g. laboratory information system, in which laboratory results are documented).<br>
 * Element description: The name of the device MUST be declared.Note:Altough this element is called softwareName, it contains also the name of physical devices (e.g. laboratory analyzer).<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.21<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class CdachOtherDeviceCompilationWithName extends POCDMT000040AuthoringDevice {

    public CdachOtherDeviceCompilationWithName() {
    }

    /**
     * Gets the hl7ManufacturerModelName<br/>
     * The model name of the device MAY be declared.
     */
    public org.husky.common.hl7cdar2.SC getHl7ManufacturerModelName() {
        return manufacturerModelName;
    }

    /**
     * Gets the hl7SoftwareName<br/>
     * The name of the device MUST be declared.Note:Altough this element is called softwareName, it contains also the name of physical devices (e.g. laboratory analyzer).
     */
    public org.husky.common.hl7cdar2.SC getHl7SoftwareName() {
        return softwareName;
    }

    /**
     * Sets the hl7ManufacturerModelName<br/>
     * The model name of the device MAY be declared.
     */
    public void setHl7ManufacturerModelName(org.husky.common.hl7cdar2.SC value) {
        this.manufacturerModelName = value;
    }

    /**
     * Sets the hl7SoftwareName<br/>
     * The name of the device MUST be declared.Note:Altough this element is called softwareName, it contains also the name of physical devices (e.g. laboratory analyzer).
     */
    public void setHl7SoftwareName(org.husky.common.hl7cdar2.SC value) {
        this.softwareName = value;
    }
}
