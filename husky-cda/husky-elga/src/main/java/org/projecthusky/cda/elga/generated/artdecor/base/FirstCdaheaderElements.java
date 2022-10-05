/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.base;

import java.util.List;
import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * FirstCDAHeaderElements
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.10000<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class FirstCdaheaderElements extends POCDMT000040ClinicalDocument {

    public FirstCdaheaderElements() {
        super.setTypeId(createHl7TypeIdFixedValue("2.16.840.1.113883.1.3",
                                                  "POCD_HD000040"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.1"));
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
     * Creates fixed contents for CDA Element hl7TypeId
     *
     * @param root the desired fixed value for this argument.
     * @param extension the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId createHl7TypeIdFixedValue(String root, String extension) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId retVal = factory.createPOCDMT000040InfrastructureRootTypeId();
        retVal.setRoot(root);
        retVal.setExtension(extension);
        return retVal;
    }

    /**
     * Gets the hl7RealmCode
     */
    public List<org.projecthusky.common.hl7cdar2.CS> getHl7RealmCode() {
        return realmCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7TypeId
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId getHl7TypeId() {
        return typeId;
    }

    /**
     * Sets the hl7RealmCode
     */
    public void setHl7RealmCode(org.projecthusky.common.hl7cdar2.CS value) {
        getRealmCode().clear();
        getRealmCode().add(value);
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7TypeId
     */
    public void setHl7TypeId(org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId value) {
        this.typeId = value;
    }
}
