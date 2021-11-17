package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;

/**
 * chpharm_entry_AnnotationComments
 * <p>
 * Template description: This entry allows for a comment to be supplied with each entry. This is a modification of the CH-PCC template to change the<text>element include.</text><br>
 * Element description: A comment to the parent entry.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.82<br>
 * Effective date: 2021-06-10 11:32:29<br>
 * Version: 2016<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class ChpharmEntryAnnotationComments extends POCDMT000040Act {

    public ChpharmEntryAnnotationComments() {
        super.setClassCode(XActClassDocumentEntryAct.ACT);
        super.setMoodCode(XDocumentActMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.2"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.40"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.2"));
        super.setCode(createHl7CodeFixedValue("48767-8",
                                              "2.16.840.1.113883.6.1",
                                              "LOINC",
                                              "Annotation comment"));
        super.setStatusCode(createHl7StatusCodeFixedValue("completed"));
    }

    /**
     * Adds a hl7Author
     * The author of the statement SHALL be specified either here or in one of the ancestors.
     */
    public void addHl7Author(POCDMT000040Author value) {
        getAuthor().add(value);
    }

    /**
     * Adds a hl7Author
     * The author of the statement SHALL be specified either here or in one of the ancestors.
     */
    public void clearHl7Author() {
        getAuthor().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     * @param codeSystem the desired fixed value for this argument.
     * @param codeSystemName the desired fixed value for this argument.
     * @param displayName the desired fixed value for this argument.
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
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static CS createHl7StatusCodeFixedValue(String code) {
        ObjectFactory factory = new ObjectFactory();
        CS retVal = factory.createCS();
        retVal.setCode(code);
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
     * The reference to the text in the narrative section of the section MUST be specified.
     */
    public CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Id
     * An ID for this item MAY be filled for traceability.
     */
    public List<II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7StatusCode
     * The status 'completed' indicates that the comment is final.
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
     * Sets the hl7Code
     * The reference to the text in the narrative section of the section MUST be specified.
     */
    public void setHl7Code(CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7Id
     * An ID for this item MAY be filled for traceability.
     */
    public void setHl7Id(II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7StatusCode
     * The status 'completed' indicates that the comment is final.
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
