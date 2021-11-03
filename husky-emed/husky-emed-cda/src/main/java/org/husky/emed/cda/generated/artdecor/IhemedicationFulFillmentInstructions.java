package org.husky.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;
import org.husky.emed.cda.models.common.Code;
import org.husky.emed.cda.models.common.basetypes.CodeBaseType;

/**
 * IHEMedicationFulFillmentInstructions
 * <p>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.5.3.1.4.3.1<br>
 * Effective date: 2013-12-20 00:00:00<br>
 * Version: 2014<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class IhemedicationFulFillmentInstructions extends POCDMT000040Act {

    public IhemedicationFulFillmentInstructions() {
        super.setClassCode(XActClassDocumentEntryAct.ACT);
        super.setMoodCode(XDocumentActMood.INT);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.43"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.3.1"));
        super.setCode(createHl7CodeFixedValue("FINSTRUCT",
                                              "1.3.6.1.4.1.19376.1.5.3.2",
                                              "IHEActCode",
                                              null));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
    }

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static CD createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        CD retVal = factory.createCD();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
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
     * Gets the hl7Code
     */
    public CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7StatusCode
     */
    public CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public ED getHl7Text() {
        return text;
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabStatusCodeCode() {
        return vocabStatusCodeCode;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(ED value) {
        this.text = value;
    }
}
