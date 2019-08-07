/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.lrep;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.ehealth_connector.common.CdaNamespacePrefixMapper;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.3
 * Template description: Laboratory reports MUST contain at least one laboratory result which is declared using this element. Each laboratory result consists of code, value and interpretation of the result.CodeFor laboratory reports in Switzerland, primarly LOINC and where necessary, additional SNOMED CT codes MUST be used. At least one laboratory result for a specimen MUST thus contain a LOINC code.Certain microbiology pathogen detection can not be uniquely identified with LOINC (e.g., Campylobacter coli). Such pathogen detection must be specified in a second observation in the same Laboratory Battery Organizer with a corresponding code from another code system (e.g., SNOMED CT).For examinations according to the Swiss analysis list (AL), a translation element CAN be specified to establish the reference to the corresponding AL position.Further translation elements may be added to make reference to other codes, e.g. the locally used code in the laboratory.ValueThe concrete values measured MUST be specified in observation elements as follows (data types according to HL7 CDA):
 * - Text findings are declared as free text in the narrative portion of the corresponding section, and the text element MUST contain the corresponding reference to the narrative text. In this case, the observation MAY NOT contain the value element.
 * - True / False values are declared using the data type BL.
 * - Encoded values are declared using the data type CD.
 * - Numeric results are declared using data type PQ in combination with internationally standardized units (UCUM), according to the value set.
 * - Ratios are declared with data type RTO.InterpretationThe interpretation code specifies AT LEAST whether it is a normal result or a result outside the normal range. Further interpretation codes CAN be used.
 *
 * Element description: Laboratory result with interpretation, related previous results, reference range, participants (persons and devices) as well as comments.
 */
public class ChpalmEntryLaboratoryObservation extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	/**
	 * This CAN be used to identify other parties:
	 * - Who has verified the result (AUTHEN).
	 * - Which external laboratory has delivered the result (RESP).
	 * - Which device (analyzer) was used to determine the result (DEV).
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author> hl7Author;

	/**
	 * A unique code for this result MUST be specified.
	 */
	private org.ehealth_connector.common.hl7cdar2.CD hl7Code;

	/**
	 * The result of the examination MUST be specified for all elements with status 'completed'. One of the following data types MUST be used. For elements with status 'aborted', the result of the test is NOT ALLOWED.In the case of microbiological or infection-serological detection of pathogens, NO value element is PERMITTED. Instead, declare using the interpretationCode whether the pathogen was detected in the sample (POS) or not (NEG).
	 */
	private org.ehealth_connector.common.hl7cdar2.IVLTS hl7EffectiveTime;

	/**
	 * Information on specimen collection for this Observation. This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship> hl7EntryRelationship;

	/**
	 * Comment on this Observation.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship> hl7EntryRelationship1;

	/**
	 * This CAN be used to indicate previous observation for the same test code on a previous specimen.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship> hl7EntryRelationship2;

	/**
	 * An ID for this item MAY be filled for traceability.
	 */
	private org.ehealth_connector.common.hl7cdar2.II hl7Id;

	/**
	 * IF this result is based on a specimen of a non-human material, this MUST be declared with the subject element.
	 */
	private org.ehealth_connector.common.hl7cdar2.CE hl7InterpretationCode;

	/**
	 * Who has verified the result (AUTHEN). This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2> hl7Participant;

	/**
	 * Which external laboratory has delivered the result (RESP). This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2> hl7Participant1;

	/**
	 * Which device (analyzer) was used to determine the result (DEV). This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2> hl7Participant2;

	/**
	 * This CAN be used to indicate who has performed the test. This information supersedes any information recorded at higher level.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2> hl7Performer;

	/**
	 * This CAN be used to make reference to an external document.
	 */
	private ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference> hl7Reference;

	/**
	 * The reference range SHALL be specified for the range of normal values for the data types PQ and INT. The following applies:
	 * - Upper limit: [R]
	 * - Lower limit: [R]
	 * - interpretationCode containing code=N: [M]The reference range CAN be omitted for other data types. If only an upper or lower limit is meaningful, the unused limit MUST be declared using nullFlavor.
	 */
	private org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange hl7ReferenceRange;

	/**
	 * The status 'completed' means that the result is final.The status 'aborted' means that the examination could not be performed.
	 */
	private org.ehealth_connector.common.hl7cdar2.CS hl7StatusCode;

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject hl7Subject;

	private org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject hl7Subject1;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId;

	private org.ehealth_connector.common.hl7cdar2.II hl7TemplateId1;

	/**
	 * True / False or Yes / No Result. If the observation value can not be determined, @value is NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	private org.ehealth_connector.common.hl7cdar2.BL hl7Value;

	/**
	 * Coded result. If the observation value can not be determined, @code, @codeSystem, @codeSystemName and @displayName are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	private org.ehealth_connector.common.hl7cdar2.CD hl7Value1;

	/**
	 * Text result.
	 */
	private org.ehealth_connector.common.hl7cdar2.ED hl7Value2;

	/**
	 * Numeric result with unit. If the observation value can not be determined, @value and @unit are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	private org.ehealth_connector.common.hl7cdar2.PQ hl7Value3;

	/**
	 * Ratio results. If the observation value can not be determined, numerator and denominator are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	private org.ehealth_connector.common.hl7cdar2.RTO hl7Value4;

	/**
	 * Adds a hl7Author
	 * This CAN be used to identify other parties:
	 * - Who has verified the result (AUTHEN).
	 * - Which external laboratory has delivered the result (RESP).
	 * - Which device (analyzer) was used to determine the result (DEV).
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		if (hl7Author == null)
			hl7Author = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Author>();
		hl7Author.add(value);
	}

	/**
	 * Adds a hl7EntryRelationship
	 * Information on specimen collection for this Observation. This information supersedes any information recorded at higher level.
	 */
	public void addHl7EntryRelationship(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		if (hl7EntryRelationship == null)
			hl7EntryRelationship = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship>();
		hl7EntryRelationship.add(value);
	}

	/**
	 * Adds a hl7EntryRelationship1
	 * Comment on this Observation.
	 */
	public void addHl7EntryRelationship1(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		if (hl7EntryRelationship1 == null)
			hl7EntryRelationship1 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship>();
		hl7EntryRelationship1.add(value);
	}

	/**
	 * Adds a hl7EntryRelationship2
	 * This CAN be used to indicate previous observation for the same test code on a previous specimen.
	 */
	public void addHl7EntryRelationship2(org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		if (hl7EntryRelationship2 == null)
			hl7EntryRelationship2 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship>();
		hl7EntryRelationship2.add(value);
	}

	/**
	 * Adds a hl7Participant
	 * Who has verified the result (AUTHEN). This information supersedes any information recorded at higher level.
	 */
	public void addHl7Participant(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		if (hl7Participant == null)
			hl7Participant = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2>();
		hl7Participant.add(value);
	}

	/**
	 * Adds a hl7Participant1
	 * Which external laboratory has delivered the result (RESP). This information supersedes any information recorded at higher level.
	 */
	public void addHl7Participant1(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		if (hl7Participant1 == null)
			hl7Participant1 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2>();
		hl7Participant1.add(value);
	}

	/**
	 * Adds a hl7Participant2
	 * Which device (analyzer) was used to determine the result (DEV). This information supersedes any information recorded at higher level.
	 */
	public void addHl7Participant2(org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		if (hl7Participant2 == null)
			hl7Participant2 = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2>();
		hl7Participant2.add(value);
	}

	/**
	 * Adds a hl7Performer
	 * This CAN be used to indicate who has performed the test. This information supersedes any information recorded at higher level.
	 */
	public void addHl7Performer(org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 value) {
		if (hl7Performer == null)
			hl7Performer = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2>();
		hl7Performer.add(value);
	}

	/**
	 * Adds a hl7Reference
	 * This CAN be used to make reference to an external document.
	 */
	public void addHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		if (hl7Reference == null)
			hl7Reference = new ArrayList<org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference>();
		hl7Reference.add(value);
	}

	/**
	 * Adds a hl7Author
	 * This CAN be used to identify other parties:
	 * - Who has verified the result (AUTHEN).
	 * - Which external laboratory has delivered the result (RESP).
	 * - Which device (analyzer) was used to determine the result (DEV).
	 */
	public void clearHl7Author() {
		hl7Author.clear();
	}

	/**
	 * Adds a hl7EntryRelationship
	 * Information on specimen collection for this Observation. This information supersedes any information recorded at higher level.
	 */
	public void clearHl7EntryRelationship() {
		hl7EntryRelationship.clear();
	}

	/**
	 * Adds a hl7EntryRelationship1
	 * Comment on this Observation.
	 */
	public void clearHl7EntryRelationship1() {
		hl7EntryRelationship1.clear();
	}

	/**
	 * Adds a hl7EntryRelationship2
	 * This CAN be used to indicate previous observation for the same test code on a previous specimen.
	 */
	public void clearHl7EntryRelationship2() {
		hl7EntryRelationship2.clear();
	}

	/**
	 * Adds a hl7Participant
	 * Who has verified the result (AUTHEN). This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Participant() {
		hl7Participant.clear();
	}

	/**
	 * Adds a hl7Participant1
	 * Which external laboratory has delivered the result (RESP). This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Participant1() {
		hl7Participant1.clear();
	}

	/**
	 * Adds a hl7Participant2
	 * Which device (analyzer) was used to determine the result (DEV). This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Participant2() {
		hl7Participant2.clear();
	}

	/**
	 * Adds a hl7Performer
	 * This CAN be used to indicate who has performed the test. This information supersedes any information recorded at higher level.
	 */
	public void clearHl7Performer() {
		hl7Performer.clear();
	}

	/**
	 * Adds a hl7Reference
	 * This CAN be used to make reference to an external document.
	 */
	public void clearHl7Reference() {
		hl7Reference.clear();
	}

	/**
	 * Gets the hl7Code
	 * A unique code for this result MUST be specified.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return hl7Code;
	}

	/**
	 * Gets the hl7EffectiveTime
	 * The result of the examination MUST be specified for all elements with status 'completed'. One of the following data types MUST be used. For elements with status 'aborted', the result of the test is NOT ALLOWED.In the case of microbiological or infection-serological detection of pathogens, NO value element is PERMITTED. Instead, declare using the interpretationCode whether the pathogen was detected in the sample (POS) or not (NEG).
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return hl7EffectiveTime;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return hl7Id;
	}

	/**
	 * Gets the hl7InterpretationCode
	 * IF this result is based on a specimen of a non-human material, this MUST be declared with the subject element.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7InterpretationCode() {
		return hl7InterpretationCode;
	}

	/**
	 * Gets the hl7ReferenceRange
	 * The reference range SHALL be specified for the range of normal values for the data types PQ and INT. The following applies:
	 * - Upper limit: [R]
	 * - Lower limit: [R]
	 * - interpretationCode containing code=N: [M]The reference range CAN be omitted for other data types. If only an upper or lower limit is meaningful, the unused limit MUST be declared using nullFlavor.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange getHl7ReferenceRange() {
		return hl7ReferenceRange;
	}

	/**
	 * Gets the hl7StatusCode
	 * The status 'completed' means that the result is final.The status 'aborted' means that the examination could not be performed.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return hl7StatusCode;
	}

	/**
	 * Gets the hl7Subject
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject getHl7Subject() {
		return hl7Subject;
	}

	/**
	 * Gets the hl7Subject1
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject getHl7Subject1() {
		return hl7Subject1;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		return hl7TemplateId;
	}

	/**
	 * Gets the hl7TemplateId1
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId1() {
		return hl7TemplateId1;
	}

	/**
	 * Gets the hl7Value
	 * True / False or Yes / No Result. If the observation value can not be determined, @value is NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public org.ehealth_connector.common.hl7cdar2.BL getHl7Value() {
		return hl7Value;
	}

	/**
	 * Gets the hl7Value1
	 * Coded result. If the observation value can not be determined, @code, @codeSystem, @codeSystemName and @displayName are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Value1() {
		return hl7Value1;
	}

	/**
	 * Gets the hl7Value2
	 * Text result.
	 */
	public org.ehealth_connector.common.hl7cdar2.ED getHl7Value2() {
		return hl7Value2;
	}

	/**
	 * Gets the hl7Value3
	 * Numeric result with unit. If the observation value can not be determined, @value and @unit are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public org.ehealth_connector.common.hl7cdar2.PQ getHl7Value3() {
		return hl7Value3;
	}

	/**
	 * Gets the hl7Value4
	 * Ratio results. If the observation value can not be determined, numerator and denominator are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public org.ehealth_connector.common.hl7cdar2.RTO getHl7Value4() {
		return hl7Value4;
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFileName the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryLaboratoryObservation loadFromFile(String inputFileName) throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	/**
	 * Loads the CDA document from file.
	 * @param inputFile the source file.
	 * n@return the CDA document\n@throws JAXBException\n@throws IOException Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryLaboratoryObservation loadFromFile(File inputFile) throws JAXBException, IOException {
		ChpalmEntryLaboratoryObservation retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmEntryLaboratoryObservation.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmEntryLaboratoryObservation> root = mar.unmarshal(source, ChpalmEntryLaboratoryObservation.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFileName the full path and filename of the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(String outputFileName) throws JAXBException {
		saveToFile(new File(outputFileName));
	}

	/**
	 * Saves the current CDA document to file.
	 * @param outputFile the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(File outputFile) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(this.getClass());
		Marshaller mar = context.createMarshaller();
		mar.setProperty("com.sun.xml.bind.namespacePrefixMapper", new CdaNamespacePrefixMapper());
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(this, outputFile);
	}

	/**
	 * Sets the hl7Code
	 * A unique code for this result MUST be specified.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		hl7Code = value;
	}

	/**
	 * Sets the hl7EffectiveTime
	 * The result of the examination MUST be specified for all elements with status 'completed'. One of the following data types MUST be used. For elements with status 'aborted', the result of the test is NOT ALLOWED.In the case of microbiological or infection-serological detection of pathogens, NO value element is PERMITTED. Instead, declare using the interpretationCode whether the pathogen was detected in the sample (POS) or not (NEG).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		hl7EffectiveTime = value;
	}

	/**
	 * Sets the hl7Id
	 * An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7Id = value;
	}

	/**
	 * Sets the hl7InterpretationCode
	 * IF this result is based on a specimen of a non-human material, this MUST be declared with the subject element.
	 */
	public void setHl7InterpretationCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		hl7InterpretationCode = value;
	}

	/**
	 * Sets the hl7ReferenceRange
	 * The reference range SHALL be specified for the range of normal values for the data types PQ and INT. The following applies:
	 * - Upper limit: [R]
	 * - Lower limit: [R]
	 * - interpretationCode containing code=N: [M]The reference range CAN be omitted for other data types. If only an upper or lower limit is meaningful, the unused limit MUST be declared using nullFlavor.
	 */
	public void setHl7ReferenceRange(org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange value) {
		hl7ReferenceRange = value;
	}

	/**
	 * Sets the hl7StatusCode
	 * The status 'completed' means that the result is final.The status 'aborted' means that the examination could not be performed.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		hl7StatusCode = value;
	}

	/**
	 * Sets the hl7Subject
	 */
	public void setHl7Subject(org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject value) {
		hl7Subject = value;
	}

	/**
	 * Sets the hl7Subject1
	 */
	public void setHl7Subject1(org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject value) {
		hl7Subject1 = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId = value;
	}

	/**
	 * Sets the hl7TemplateId1
	 */
	public void setHl7TemplateId1(org.ehealth_connector.common.hl7cdar2.II value) {
		hl7TemplateId1 = value;
	}

	/**
	 * Sets the hl7Value
	 * True / False or Yes / No Result. If the observation value can not be determined, @value is NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.BL value) {
		hl7Value = value;
	}

	/**
	 * Sets the hl7Value1
	 * Coded result. If the observation value can not be determined, @code, @codeSystem, @codeSystemName and @displayName are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public void setHl7Value1(org.ehealth_connector.common.hl7cdar2.CD value) {
		hl7Value1 = value;
	}

	/**
	 * Sets the hl7Value2
	 * Text result.
	 */
	public void setHl7Value2(org.ehealth_connector.common.hl7cdar2.ED value) {
		hl7Value2 = value;
	}

	/**
	 * Sets the hl7Value3
	 * Numeric result with unit. If the observation value can not be determined, @value and @unit are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public void setHl7Value3(org.ehealth_connector.common.hl7cdar2.PQ value) {
		hl7Value3 = value;
	}

	/**
	 * Sets the hl7Value4
	 * Ratio results. If the observation value can not be determined, numerator and denominator are NOT ALLOWED. Instead, @nullFlavor='NA' MUST be used in combination with interpretationCode that declares whether the result is below (Low of scale) or above (High of scale) of the reference range.
	 */
	public void setHl7Value4(org.ehealth_connector.common.hl7cdar2.RTO value) {
		hl7Value4 = value;
	}
}
