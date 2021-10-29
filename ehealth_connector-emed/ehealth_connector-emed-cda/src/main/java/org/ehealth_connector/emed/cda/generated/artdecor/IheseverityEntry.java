package org.ehealth_connector.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.models.common.Code;
import org.ehealth_connector.emed.cda.models.common.basetypes.CodeBaseType;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.CS;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Observation;

/**
 * IHESeverityEntry
 * <p>
 * Template description: Any condition or allergy may be the subject of a severity observation. This structure is included <span style="line-height: 1.22;">in the target act using the &lt;entryRelationship&gt; element defined in the CDA Schema.</span><br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.5.3.1.4.1<br>
 * Effective date: 2013-12-20 00:00:00<br>
 * Version: 2014<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class IheseverityEntry extends POCDMT000040Observation {

    public IheseverityEntry() {
        super.getClassCode().add("OBS");
        super.setMoodCode(org.ehealth_connector.emed.cda.generated.hl7cdar2.XActMoodDocumentObservation.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.1"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.55"));
        super.setCode(createHl7CodeFixedValue("SEV",
                                              "2.16.840.1.113883.5.4",
                                              null,
                                              null));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").withCodeSystem("2.16.840.1.113883.5.14").build()));
        statusCode = (new Code(CodeBaseType.builder().withCode("completed").withCodeSystem("2.16.840.1.113883.5.14").build())).getHl7CdaR2Cs();
        vocabValueCode.add(new Code(CodeBaseType.builder().withCode("L").withCodeSystem("2.16.840.1.113883.5.1063").build()));
        vocabValueCode.add(new Code(CodeBaseType.builder().withCode("H").withCodeSystem("2.16.840.1.113883.5.1063").build()));
        vocabValueCode.add(new Code(CodeBaseType.builder().withCode("M").withCodeSystem("2.16.840.1.113883.5.1063").build()));
    }

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

    private final List<Code> vocabValueCode = new ArrayList<>();

    /**
     * Adds a hl7Value
     */
    public void addHl7Value(org.ehealth_connector.emed.cda.generated.hl7cdar2.CD value) {
        getValue().add(value);
    }

    /**
     * Adds a hl7Value
     */
    public void clearHl7Value() {
        getValue().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.CD createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.CD retVal = factory.createCD();
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
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     * This observation is of severity, as indicated by the &lt;code&gt; element listed above. This element is required.
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.CD getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7StatusCode
     * The code attribute of &lt;statusCode&gt; for all severity observations shall be completed. While the &lt;statusCode&gt; element is required in all acts to record the status of the act, the only sensible value of this element in this context is completed.
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     * The &lt;observation&gt; element shall contain a &lt;text&gt; element. The &lt;text&gt; element shall contain a &lt;reference&gt; element pointing to the narrative where the severity is recorded,
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabStatusCodeCode() {
        return vocabStatusCodeCode;
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabValueCode() {
        return vocabValueCode;
    }

    /**
     * Sets the hl7Code
     * This observation is of severity, as indicated by the &lt;code&gt; element listed above. This element is required.
     */
    public void setHl7Code(org.ehealth_connector.emed.cda.generated.hl7cdar2.CD value) {
        this.code = value;
    }

    /**
     * Sets the hl7StatusCode
     * The code attribute of &lt;statusCode&gt; for all severity observations shall be completed. While the &lt;statusCode&gt; element is required in all acts to record the status of the act, the only sensible value of this element in this context is completed.
     */
    public void setHl7StatusCode(org.ehealth_connector.emed.cda.generated.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.ehealth_connector.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     * The &lt;observation&gt; element shall contain a &lt;text&gt; element. The &lt;text&gt; element shall contain a &lt;reference&gt; element pointing to the narrative where the severity is recorded,
     */
    public void setHl7Text(org.ehealth_connector.emed.cda.generated.hl7cdar2.ED value) {
        this.text = value;
    }
}
