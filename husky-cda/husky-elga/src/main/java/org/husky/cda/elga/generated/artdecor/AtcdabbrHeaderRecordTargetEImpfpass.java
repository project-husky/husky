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
import org.husky.common.hl7cdar2.POCDMT000040RecordTarget;

/**
 * atcdabbr_header_RecordTarget_eImpfpass
 * Identifier: 1.2.40.0.34.6.0.11.1.31<br>
 * Effective date: 2021-04-29 10:16:25<br>
 * Version: 1.0.1+20210512<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrHeaderRecordTargetEImpfpass extends POCDMT000040RecordTarget {

    public AtcdabbrHeaderRecordTargetEImpfpass() {
        super.getTypeCode().add("RCT");
        super.setContextControlCode("OP");
        super.setPatientRole(createHl7PatientRoleFixedValue("PAT"));
    }

    /**
     * Creates fixed contents for CDA Element hl7PatientRole
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040PatientRole createHl7PatientRoleFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040PatientRole retVal = factory.createPOCDMT000040PatientRole();
        retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Gets the hl7PatientRole
     */
    public org.husky.common.hl7cdar2.POCDMT000040PatientRole getHl7PatientRole() {
        return patientRole;
    }

    /**
     * Sets the hl7PatientRole
     */
    public void setHl7PatientRole(org.husky.common.hl7cdar2.POCDMT000040PatientRole value) {
        this.patientRole = value;
    }
}
