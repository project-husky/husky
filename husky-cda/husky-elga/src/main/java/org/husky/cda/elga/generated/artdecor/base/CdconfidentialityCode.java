/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.base;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.CE;

/**
 * CDconfidentialityCode
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90009<br>
 * Effective date: 2013-11-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class CdconfidentialityCode extends CE {

    public CdconfidentialityCode() {
        super.setCode("N");
        super.setCodeSystem("2.16.840.1.113883.5.25");
        super.setDisplayName("normal");
    }
}
