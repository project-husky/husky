/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Supply;
import org.husky.common.hl7cdar2.SXCMTS;

/**
 * IHERenewalPeriodContentModule
 * <p>
 * Template description: <div>Renewal Period Content Module describes the possible renewal of a Prescription Item in terms 1985 of duration or period of time (start / end date).</div><br>
 * Element description: Renewal Period General Specification<br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.9.1.3.15<br>
 * Effective date: 2018-01-11 15:34:25<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class IherenewalPeriodContentModule extends POCDMT000040Supply {

    public IherenewalPeriodContentModule() {
        super.setClassCode(org.husky.common.hl7cdar2.ActClassSupply.SPLY);
        super.setMoodCode(org.husky.common.hl7cdar2.XDocumentSubstanceMood.RQO);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.15"));
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
     * Gets the hl7EffectiveTime<br/>
     * In case the renewal period is bound by a precise date
     */
    public List<SXCMTS> getHl7EffectiveTimeListSxcmts() {
        return effectiveTime;
    }

    /**
     * Gets the hl7TemplateId<br/>
     * Renewal Period effectiveTime
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * In case the renewal period is bound by a precise date
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7TemplateId<br/>
     * Renewal Period effectiveTime
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
