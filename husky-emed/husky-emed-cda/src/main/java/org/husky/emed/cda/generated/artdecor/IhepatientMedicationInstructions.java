/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Act;
import org.husky.emed.models.common.Code;
import org.husky.emed.models.common.basetypes.CodeBaseType;

/**
 * IHEPatientMedicationInstructions
 * <p>
 * Template description: <div>Any medication may be the subject of further instructions to the patient, for example to indicate <span style="line-height: 1.22;">that it should be taken with food, et cetera.</span></div><br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.5.3.1.4.3<br>
 * Effective date: 2013-12-20 00:00:00<br>
 * Version: 2014<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-11-24")
public class IhepatientMedicationInstructions extends POCDMT000040Act {

    public IhepatientMedicationInstructions() {
        super.setClassCode(org.husky.common.hl7cdar2.XActClassDocumentEntryAct.ACT);
        super.setMoodCode(org.husky.common.hl7cdar2.XDocumentActMood.INT);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.3"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.49"));
        super.setCode(createHl7CodeFixedValue("PINSTRUCT",
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
    private static org.husky.common.hl7cdar2.CD createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CD retVal = factory.createCD();
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
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.common.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.husky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.husky.common.hl7cdar2.ED getHl7Text() {
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
    public void setHl7Code(org.husky.common.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.husky.common.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.husky.common.hl7cdar2.ED value) {
        this.text = value;
    }
}
