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

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Entry;

/**
 * eimpf_entry_AntikoerperBestimmungDataProcessing
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.15<br>
 * Effective date: 2021-10-29 13:45:50<br>
 * Version: 1.1.1+20220103<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class EimpfEntryAntikoerperBestimmungDataProcessing extends POCDMT000040Entry {

    public EimpfEntryAntikoerperBestimmungDataProcessing() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.15"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1"));
        super.setAct(createHl7ActFixedValue("ACT",
                                            "EVN"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Act
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Act createHl7ActFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Act retVal = factory.createPOCDMT000040Act();
        retVal.setClassCode(org.husky.common.hl7cdar2.XActClassDocumentEntryAct.fromValue(classCode));
        retVal.setMoodCode(org.husky.common.hl7cdar2.XDocumentActMood.fromValue(moodCode));
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
     * Gets the hl7Act
     */
    public org.husky.common.hl7cdar2.POCDMT000040Act getHl7Act() {
        return act;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7Act
     */
    public void setHl7Act(org.husky.common.hl7cdar2.POCDMT000040Act value) {
        this.act = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
