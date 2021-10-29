package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Supply;
import org.husky.emed.cda.generated.hl7cdar2.SXCMTS;

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
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class IherenewalPeriodContentModule extends POCDMT000040Supply {

    public IherenewalPeriodContentModule() {
        super.setClassCode(org.husky.emed.cda.generated.hl7cdar2.ActClassSupply.SPLY);
        super.setMoodCode(org.husky.emed.cda.generated.hl7cdar2.XDocumentSubstanceMood.RQO);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.15"));
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7EffectiveTime
     * In case the renewal period is bound by a precise date
     */
    public List<SXCMTS> getHl7EffectiveTimeListSxcmts() {
        return effectiveTime;
    }

    /**
     * Gets the hl7TemplateId
     * Renewal Period effectiveTime
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7EffectiveTime
     * In case the renewal period is bound by a precise date
     */
    public void setHl7EffectiveTime(org.husky.emed.cda.generated.hl7cdar2.IVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }


    /**
     * Sets the hl7TemplateId
     * Renewal Period effectiveTime
     */
    public void setHl7TemplateId(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
