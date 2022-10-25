/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040RecordTarget;

/**
 * cdach_header_Patient
 * <p>
 * Template description: A human patient for whom this CDA document instance was created. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST use this template by either reference or specialisation.<br>
 * Element description: A human patient for whom this CDA document instance was created.
 * - Target patientThe HL7 CDA R2 (2005) standard allows multiple patients.In order to ensure that the information in a CDA document is unambiguously assigned to one and only patient, a CDA-CH V2 based document MUST contain exactly one patient.Special cases: In exceptional cases (e.g., new-born twins, both having jaundice), multiple documents MUST be created (all of the same content, but each with a unique patient).
 * - Patient identifiersMultiple ids (patient identification number) MAY be declared.If multiple ids are known, it is highly recommended to declare all known ids. Especially in cases where the CDA document instance is kind of an answer to a preceding order (independent of its data format), all ids specified by the ordering system SHALL be declared in the CDA document instance. This allows the receiver to assign its internal patient identification.The patient identification number MUST be grouped with the OID of its assigning system. The patient identification number MUST be unique within the system identified by the OID.The declared OID MUST be found in one of the public OID registries, such as oid.refdata.ch (preferred), oid-info.com, hl7.org/oid, www.dimdi.de/static/de/klassi/oid/, gesundheit.gv.at/OID_Frontend/ etc.OIDs that can't be found in a public OID registry are NOT ALLOWED.
 * - PseudonymizingIn special cases, the demographic data of the patient are not allowed to be transmitted or they have to be pseudonymized.While HL7 CDA or its derivatives like CDA-CH or Swiss exchange formats nevertheless require these elements in the XML structure, the affected values MUST be replaced by a nullFlavor of type "MSK" (masked), in order to support the required data format structure and simultaneously to shield the real data.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.2.1<br>
 * Effective date: 2022-06-21 13:45:28<br>
 * Version: 2022<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class CdachHeaderPatient extends POCDMT000040RecordTarget {

    public CdachHeaderPatient() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.2.1"));
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7PatientRole
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040PatientRole getHl7PatientRole() {
        return patientRole;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7PatientRole
     */
    public void setHl7PatientRole(org.projecthusky.common.hl7cdar2.POCDMT000040PatientRole value) {
        this.patientRole = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
