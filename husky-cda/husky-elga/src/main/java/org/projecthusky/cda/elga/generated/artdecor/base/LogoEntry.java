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
import org.projecthusky.common.hl7cdar2.POCDMT000040ObservationMedia;

/**
 * LogoEntry
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.1.3.2<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class LogoEntry extends POCDMT000040ObservationMedia {

    public LogoEntry() {
        super.getClassCode().add("OBS");
        super.getMoodCode().add("EVN");
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.1.3.2"));
        super.setValue(createHl7ValueFixedValue("B64"));
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
     * Creates fixed contents for CDA Element hl7Value
     *
     * @param representation the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.ED createHl7ValueFixedValue(String representation) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.ED retVal = factory.createED();
        retVal.setRepresentation(org.projecthusky.common.hl7cdar2.BinaryDataEncoding.fromValue(representation));
        return retVal;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Value
     */
    public org.projecthusky.common.hl7cdar2.ED getHl7Value() {
        return value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.projecthusky.common.hl7cdar2.ED value) {
        this.value = value;
    }
}
