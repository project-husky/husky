/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.base;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * CDsetIdversionNumber
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90007<br>
 * Effective date: 2015-09-18 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class CdsetIdversionNumber extends POCDMT000040ClinicalDocument {

    public CdsetIdversionNumber() {
    }

    /**
     * Gets the hl7SetId
     */
    public org.projecthusky.common.hl7cdar2.II getHl7SetId() {
        return setId;
    }

    /**
     * Gets the hl7VersionNumber
     */
    public org.projecthusky.common.hl7cdar2.INT getHl7VersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the hl7SetId
     */
    public void setHl7SetId(org.projecthusky.common.hl7cdar2.II value) {
        this.setId = value;
    }

    /**
     * Sets the hl7VersionNumber
     */
    public void setHl7VersionNumber(org.projecthusky.common.hl7cdar2.INT value) {
        this.versionNumber = value;
    }
}
