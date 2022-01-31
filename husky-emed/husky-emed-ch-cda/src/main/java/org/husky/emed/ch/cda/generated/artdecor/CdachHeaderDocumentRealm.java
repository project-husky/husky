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
import org.husky.common.hl7cdar2.CS;

/**
 * cdach_header_DocumentRealm
 * <p>
 * Template description: Swiss Realm (CHE) of HL7 CDA. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST reference this template.<br>
 * Element description: Swiss Realm (CHE) of HL7 CDA.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.25<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class CdachHeaderDocumentRealm extends CS {

    public CdachHeaderDocumentRealm() {
        super.setCode("CHE");
    }
}
