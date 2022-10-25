/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.II;

/**
 * atcdabbr_header_DocumentTypeId
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.30<br>
 * Effective date: 2021-02-19 11:05:29<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrHeaderDocumentTypeId extends II {

    public AtcdabbrHeaderDocumentTypeId() {
        super.setRoot("2.16.840.1.113883.1.3");
        super.setExtension("POCD_HD000040");
    }
}
