package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;

/**
 * PrescribedQuantityEntryContentModule
 * <p>
 * Template description: Amount of units of the consumable to dispense<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.38<br>
 * Effective date: 2016-06-13 00:00:00<br>
 * Version: 2017<br>
 * Status: pending
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class PrescribedQuantityEntryContentModule extends POCDMT000040Supply {

    public PrescribedQuantityEntryContentModule() {
        super.setClassCode(ActClassSupply.SPLY);
        super.setMoodCode(XDocumentSubstanceMood.RQO);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.8"));
        super.setIndependentInd(createHl7IndependentIndFixedValue("false"));
        super.setQuantity(createHl7QuantityFixedValue("1"));
    }

    /**
     * Creates fixed contents for CDA Element hl7IndependentInd
     *
     * @param value the desired fixed value for this argument.
     */
    private static BL createHl7IndependentIndFixedValue(String value) {
        ObjectFactory factory = new ObjectFactory();
        BL retVal = factory.createBL();
        if (value != null) {
            retVal.setValue(Boolean.parseBoolean(value));
        }
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Quantity
     *
     * @param unit the desired fixed value for this argument.
     */
    private static PQ createHl7QuantityFixedValue(String unit) {
        ObjectFactory factory = new ObjectFactory();
        PQ retVal = factory.createPQ();
        retVal.setUnit(unit);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7IndependentInd
     */
    public BL getHl7IndependentInd() {
        return independentInd;
    }

    /**
     * Gets the hl7Quantity
     */
    public PQ getHl7Quantity() {
        return quantity;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7IndependentInd
     */
    public void setHl7IndependentInd(BL value) {
        this.independentInd = value;
    }

    /**
     * Sets the hl7Quantity
     */
    public void setHl7Quantity(PQ value) {
        this.quantity = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
