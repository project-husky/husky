package org.husky.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;
import org.husky.emed.cda.models.common.Code;
import org.husky.emed.cda.models.common.basetypes.CodeBaseType;

/**
 * TreatmentReasonEntryContentModule
 * <p>
 * Template description: Treatment reason<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.41<br>
 * Effective date: 2016-06-13 00:00:00<br>
 * Version: 2017<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class TreatmentReasonEntryContentModule extends POCDMT000040Observation {

    public TreatmentReasonEntryContentModule() {
        super.getClassCode().add("OBS");
        super.setMoodCode(XActMoodDocumentObservation.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.41"));
        super.setCode(createHl7CodeFixedValue("75326-9",
                                              "2.16.840.1.113883.6.1",
                                              "LOINC",
                                              "Problem"));
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
     * It shall contain both the narrative text content and a reference to the human readable part of the item. This human readable part may contain a simple text to redirect the reader to the PDF document (e.g. "See PDF version included").<br clear="none"/>There shall be a single non-blank text node (i.e. the text shall be completely before or after the reference, see examples). The text shall be raw (i.e. no markup shall be used).
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
     * It shall contain both the narrative text content and a reference to the human readable part of the item. This human readable part may contain a simple text to redirect the reader to the PDF document (e.g. "See PDF version included").<br clear="none"/>There shall be a single non-blank text node (i.e. the text shall be completely before or after the reference, see examples). The text shall be raw (i.e. no markup shall be used).
     */
    public void setHl7Text(ED value) {
        this.text = value;
    }
}
