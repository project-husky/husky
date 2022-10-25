/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ps;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Authenticator;

/**
 * HeaderAuthenticator
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.20007<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class HeaderAuthenticator extends POCDMT000040Authenticator {

    public HeaderAuthenticator() {
        super.getTypeCode().add("AUTHEN");
        super.setSignatureCode(createHl7SignatureCodeFixedValue("S",
                                                                null,
                                                                null,
                                                                null));
    }

    /**
     * Creates fixed contents for CDA Element hl7SignatureCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7SignatureCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CS retVal = factory.createCS();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Gets the hl7AssignedEntity
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
        return assignedEntity;
    }

    /**
     * Gets the hl7SignatureCode
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7SignatureCode() {
        return signatureCode;
    }

    /**
     * Gets the hl7Time
     */
    public org.projecthusky.common.hl7cdar2.TS getHl7Time() {
        return time;
    }

    /**
     * Sets the hl7AssignedEntity
     */
    public void setHl7AssignedEntity(org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity value) {
        this.assignedEntity = value;
    }

    /**
     * Sets the hl7SignatureCode
     */
    public void setHl7SignatureCode(org.projecthusky.common.hl7cdar2.CS value) {
        this.signatureCode = value;
    }

    /**
     * Sets the hl7Time
     */
    public void setHl7Time(org.projecthusky.common.hl7cdar2.TS value) {
        this.time = value;
    }
}
