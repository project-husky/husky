/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Observation;

/**
 * epims_entry_caseIdentificationArzt
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.57<br>
 * Effective date: 2020-02-20 15:08:54<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsEntryCaseIdentificationArzt extends POCDMT000040Observation {

    public EpimsEntryCaseIdentificationArzt() {
        super.getClassCode().add("CASE");
        super.setMoodCode(org.husky.common.hl7cdar2.XActMoodDocumentObservation.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.57"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.1.2"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.6.3.2"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Id
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7IdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Id
     */
    public List<org.husky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "1.2.40.0.34.3.1.1"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedId1240034311() {
        return createHl7IdFixedValue("1.2.40.0.34.3.1.1");
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
