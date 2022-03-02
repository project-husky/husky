/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ps;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.POCDMT000040Reference;

/**
 * Iddescontainers
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90013<br>
 * Effective date: 2020-07-21 13:38:52<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class Iddescontainers extends POCDMT000040Reference {

    public Iddescontainers() {
        super.setTypeCode(org.husky.common.hl7cdar2.XActRelationshipExternalReference.XCRPT);
    }

    /**
     * Gets the hl7ExternalDocument
     */
    public org.husky.common.hl7cdar2.POCDMT000040ExternalDocument getHl7ExternalDocument() {
        return externalDocument;
    }

    /**
     * Sets the hl7ExternalDocument
     */
    public void setHl7ExternalDocument(org.husky.common.hl7cdar2.POCDMT000040ExternalDocument value) {
        this.externalDocument = value;
    }
}
