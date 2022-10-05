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
import org.projecthusky.common.hl7cdar2.POCDMT000040Custodian;

/**
 * HeaderCustodian
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.20004<br>
 * Effective date: 2015-05-28 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class HeaderCustodian extends POCDMT000040Custodian {

    public HeaderCustodian() {
        super.getTypeCode().add("CST");
        super.setAssignedCustodian(createHl7AssignedCustodianFixedValue("ASSIGNED"));
    }

    /**
     * Creates fixed contents for CDA Element hl7AssignedCustodian
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040AssignedCustodian createHl7AssignedCustodianFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040AssignedCustodian retVal = factory.createPOCDMT000040AssignedCustodian();
        retVal.setClassCode(classCode);
        return retVal;
    }

    /**
     * Gets the hl7AssignedCustodian
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040AssignedCustodian getHl7AssignedCustodian() {
        return assignedCustodian;
    }

    /**
     * Sets the hl7AssignedCustodian
     */
    public void setHl7AssignedCustodian(org.projecthusky.common.hl7cdar2.POCDMT000040AssignedCustodian value) {
        this.assignedCustodian = value;
    }
}
