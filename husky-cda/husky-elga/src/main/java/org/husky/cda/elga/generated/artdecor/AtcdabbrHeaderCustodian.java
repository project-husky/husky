/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Custodian;

/**
 * atcdabbr_header_Custodian
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.4<br>
 * Effective date: 2021-10-13 14:05:15<br>
 * Version: 1.0.1+20211213<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrHeaderCustodian extends POCDMT000040Custodian {

    public AtcdabbrHeaderCustodian() {
        super.getTypeCode().add("CST");
        super.setAssignedCustodian(createHl7AssignedCustodianFixedValue("ASSIGNED"));
    }

    /**
     * Creates fixed contents for CDA Element hl7AssignedCustodian
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040AssignedCustodian createHl7AssignedCustodianFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040AssignedCustodian retVal = factory.createPOCDMT000040AssignedCustodian();
        retVal.setClassCode(classCode);
        return retVal;
    }

    /**
     * Gets the hl7AssignedCustodian
     */
    public org.husky.common.hl7cdar2.POCDMT000040AssignedCustodian getHl7AssignedCustodian() {
        return assignedCustodian;
    }

    /**
     * Sets the hl7AssignedCustodian
     */
    public void setHl7AssignedCustodian(org.husky.common.hl7cdar2.POCDMT000040AssignedCustodian value) {
        this.assignedCustodian = value;
    }
}
