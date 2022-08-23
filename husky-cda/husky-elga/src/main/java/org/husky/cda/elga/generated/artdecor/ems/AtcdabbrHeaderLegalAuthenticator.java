/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ems;

import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040LegalAuthenticator;

/**
 * atcdabbr_header_LegalAuthenticator
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.5<br>
 * Effective date: 2021-02-19 11:10:59<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrHeaderLegalAuthenticator extends POCDMT000040LegalAuthenticator {

    public AtcdabbrHeaderLegalAuthenticator() {
        super.setContextControlCode("OP");
        super.getTypeCode().add("LA");
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
    private static org.husky.common.hl7cdar2.CS createHl7SignatureCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CS retVal = factory.createCS();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Time
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.TS createHl7TimeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.TS retVal = factory.createTS();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Gets the hl7AssignedEntity
     */
    public org.husky.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
        return assignedEntity;
    }

    /**
     * Gets the hl7SignatureCode
     */
    public org.husky.common.hl7cdar2.CS getHl7SignatureCode() {
        return signatureCode;
    }

    /**
     * Gets the hl7Time
     */
    public org.husky.common.hl7cdar2.TS getHl7Time() {
        return time;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.TS, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.TS getPredefinedTimeUnk() {
        return createHl7TimeFixedValue("UNK");
    }

    /**
     * Sets the hl7AssignedEntity
     */
    public void setHl7AssignedEntity(org.husky.common.hl7cdar2.POCDMT000040AssignedEntity value) {
        this.assignedEntity = value;
    }

    /**
     * Sets the hl7SignatureCode
     */
    public void setHl7SignatureCode(org.husky.common.hl7cdar2.CS value) {
        this.signatureCode = value;
    }

    /**
     * Sets the hl7Time
     */
    public void setHl7Time(org.husky.common.hl7cdar2.TS value) {
        this.time = value;
    }
}
