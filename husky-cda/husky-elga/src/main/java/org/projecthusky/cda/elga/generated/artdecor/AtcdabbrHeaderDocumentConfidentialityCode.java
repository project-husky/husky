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

import org.projecthusky.common.hl7cdar2.CE;

/**
 * atcdabbr_header_DocumentConfidentialityCode
 * 
 * Identifier: 1.2.40.0.34.6.0.11.1.12<br>
 * Effective date: 2021-06-28 13:39:30<br>
 * Version: 1.0.1+20210628<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrHeaderDocumentConfidentialityCode extends CE {

    public AtcdabbrHeaderDocumentConfidentialityCode() {
        super.setCodeSystemName("HL7:Confidentiality");
    }
}
