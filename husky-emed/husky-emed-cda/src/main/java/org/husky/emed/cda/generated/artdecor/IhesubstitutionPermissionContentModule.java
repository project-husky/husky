package org.husky.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;
import org.husky.emed.cda.models.common.Code;
import org.husky.emed.cda.models.common.basetypes.CodeBaseType;

/**
 * IHESubstitutionPermissionContentModule
 * <p>
 * Template description: <div>An act element, containing exactly one element describing the substitution permission.</div><br>
 * Element description: 6.3.4.8 Substitution Permission Content Module<br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.9.1.3.9.1<br>
 * Effective date: 2018-01-10 15:34:25<br>
 * Version: 2017<br>
 * Status: pending
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class IhesubstitutionPermissionContentModule extends POCDMT000040Act {

    public IhesubstitutionPermissionContentModule() {
        super.setClassCode(XActClassDocumentEntryAct.ACT);
        super.setMoodCode(XDocumentActMood.DEF);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.9.1"));
        super.setCode(createHl7CodeFixedValue());
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
    }

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static CD createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        CD retVal = factory.createCD();
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
     * 6.3.4.8.3.3 Substitution Permission code
     */
    public CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7StatusCode
     * 6.3.4.8.3.4 Substitution Permission statusCode
     */
    public CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     * 6.3.4.8.3.2 Substitution Permission Template ID
     */
    public List<II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabStatusCodeCode() {
        return vocabStatusCodeCode;
    }

    /**
     * Sets the hl7Code
     * 6.3.4.8.3.3 Substitution Permission code
     */
    public void setHl7Code(CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7StatusCode
     * 6.3.4.8.3.4 Substitution Permission statusCode
     */
    public void setHl7StatusCode(CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     * 6.3.4.8.3.2 Substitution Permission Template ID
     */
    public void setHl7TemplateId(II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
