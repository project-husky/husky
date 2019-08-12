/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.ehealth_connector.common.hl7cdar2.XActRelationshipExternalReference;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.3 Template
 * description: Laboratory reports MUST contain at least one laboratory result
 * which is declared using this element. Each laboratory result consists of
 * code, value and interpretation of the result.CodeFor laboratory reports in
 * Switzerland, primarly LOINC and where necessary, additional SNOMED CT codes
 * MUST be used. At least one laboratory result for a specimen MUST thus contain
 * a LOINC code.Certain microbiology pathogen detection can not be uniquely
 * identified with LOINC (e.g., Campylobacter coli). Such pathogen detection
 * must be specified in a second observation in the same Laboratory Battery
 * Organizer with a corresponding code from another code system (e.g., SNOMED
 * CT).For examinations according to the Swiss analysis list (AL), a translation
 * element CAN be specified to establish the reference to the corresponding AL
 * position.Further translation elements may be added to make reference to other
 * codes, e.g. the locally used code in the laboratory.ValueThe concrete values
 * measured MUST be specified in observation elements as follows (data types
 * according to HL7 CDA): - Text findings are declared as free text in the
 * narrative portion of the corresponding section, and the text element MUST
 * contain the corresponding reference to the narrative text. In this case, the
 * observation MAY NOT contain the value element. - True / False values are
 * declared using the data type BL. - Encoded values are declared using the data
 * type CD. - Numeric results are declared using data type PQ in combination
 * with internationally standardized units (UCUM), according to the value set. -
 * Ratios are declared with data type RTO.InterpretationThe interpretation code
 * specifies AT LEAST whether it is a normal result or a result outside the
 * normal range. Further interpretation codes CAN be used.
 *
 * Element description: Laboratory result with interpretation, related previous
 * results, reference range, participants (persons and devices) as well as
 * comments.
 */
public class ChpalmEntryLaboratoryObservation
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation {

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFile
	 *            the source file. n@return the CDA document\n@throws
	 *            JAXBException\n@throws IOException Signals that an I/O
	 *            exception has occurred.
	 */
	public static ChpalmEntryLaboratoryObservation loadFromFile(File inputFile)
			throws JAXBException, IOException {
		ChpalmEntryLaboratoryObservation retVal;
		JAXBContext context = JAXBContext.newInstance(ChpalmEntryLaboratoryObservation.class);
		Unmarshaller mar = context.createUnmarshaller();
		StreamSource source = new StreamSource(inputFile);
		JAXBElement<ChpalmEntryLaboratoryObservation> root = mar.unmarshal(source,
				ChpalmEntryLaboratoryObservation.class);
		retVal = root.getValue();
		return retVal;
	}

	/**
	 * Loads the CDA document from file.
	 *
	 * @param inputFileName
	 *            the full path and filename of the sourcefile.
	 * @return the CDA document\n@throws JAXBException\n@throws IOException
	 *         Signals that an I/O exception has occurred.
	 */
	public static ChpalmEntryLaboratoryObservation loadFromFile(String inputFileName)
			throws JAXBException, IOException {
		return loadFromFile(new File(inputFileName));
	}

	public ChpalmEntryLaboratoryObservation() {
		setHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.3.1.6");
		setHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.3");
		setHl7CodeFixedValue("NAV");
		setHl7ValueFixedValue("NA");
		setHl7ValueFixedValue("NA");
		setHl7ValueFixedValue("NA");
		setHl7ValueFixedValue("NA");
		setHl7EntryRelationshipFixedValue("COMP", null);
		setHl7EntryRelationshipFixedValue("SUBJ", "true");
		setHl7EntryRelationshipFixedValue("REFR", null);
		setHl7ReferenceFixedValue("REFR");
		setHl7ReferenceRangeFixedValue("REFV");
	}

	/**
	 * Adds a hl7Author This CAN be used to identify other parties: - Who has
	 * verified the result (AUTHEN). - Which external laboratory has delivered
	 * the result (RESP). - Which device (analyzer) was used to determine the
	 * result (DEV).
	 */
	public void addHl7Author(org.ehealth_connector.common.hl7cdar2.POCDMT000040Author value) {
		getAuthor().add(value);
	}

	/**
	 * Adds a hl7EntryRelationship Information on specimen collection for this
	 * Observation. This information supersedes any information recorded at
	 * higher level.
	 */
	public void addHl7EntryRelationship(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		getEntryRelationship().add(value);
	}

	/**
	 * Adds a hl7Participant Who has verified the result (AUTHEN). This
	 * information supersedes any information recorded at higher level.
	 */
	public void addHl7Participant(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Participant2 value) {
		getParticipant().add(value);
	}

	/**
	 * Adds a hl7Performer This CAN be used to indicate who has performed the
	 * test. This information supersedes any information recorded at higher
	 * level.
	 */
	public void addHl7Performer(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040Performer2 value) {
		getPerformer().add(value);
	}

	/**
	 * Adds a hl7Reference This CAN be used to make reference to an external
	 * document.
	 */
	public void addHl7Reference(org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference value) {
		getReference().add(value);
	}

	/**
	 * Adds a hl7Author This CAN be used to identify other parties: - Who has
	 * verified the result (AUTHEN). - Which external laboratory has delivered
	 * the result (RESP). - Which device (analyzer) was used to determine the
	 * result (DEV).
	 */
	public void clearHl7Author() {
		getAuthor().clear();
	}

	/**
	 * Adds a hl7EntryRelationship Information on specimen collection for this
	 * Observation. This information supersedes any information recorded at
	 * higher level.
	 */
	public void clearHl7EntryRelationship() {
		getEntryRelationship().clear();
	}

	/**
	 * Adds a hl7Participant Who has verified the result (AUTHEN). This
	 * information supersedes any information recorded at higher level.
	 */
	public void clearHl7Participant() {
		getParticipant().clear();
	}

	/**
	 * Adds a hl7Performer This CAN be used to indicate who has performed the
	 * test. This information supersedes any information recorded at higher
	 * level.
	 */
	public void clearHl7Performer() {
		getPerformer().clear();
	}

	/**
	 * Adds a hl7Reference This CAN be used to make reference to an external
	 * document.
	 */
	public void clearHl7Reference() {
		getReference().clear();
	}

	/**
	 * Gets the hl7Code A unique code for this result MUST be specified.
	 */
	public org.ehealth_connector.common.hl7cdar2.CD getHl7Code() {
		return super.code;
	}

	/**
	 * Gets the hl7EffectiveTime The result of the examination MUST be specified
	 * for all elements with status 'completed'. One of the following data types
	 * MUST be used. For elements with status 'aborted', the result of the test
	 * is NOT ALLOWED.In the case of microbiological or infection-serological
	 * detection of pathogens, NO value element is PERMITTED. Instead, declare
	 * using the interpretationCode whether the pathogen was detected in the
	 * sample (POS) or not (NEG).
	 */
	public org.ehealth_connector.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
		return super.effectiveTime;
	}

	/**
	 * Gets the hl7Id An ID for this item MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getId() != null)
			if (super.getId().size() > 0)
				retVal = super.getId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7InterpretationCode IF this result is based on a specimen of a
	 * non-human material, this MUST be declared with the subject element.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7InterpretationCode() {
		org.ehealth_connector.common.hl7cdar2.CE retVal = null;
		if (super.getInterpretationCode() != null)
			if (super.getInterpretationCode().size() > 0)
				retVal = super.getInterpretationCode().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7ReferenceRange The reference range SHALL be specified for the
	 * range of normal values for the data types PQ and INT. The following
	 * applies: - Upper limit: [R] - Lower limit: [R] - interpretationCode
	 * containing code=N: [M]The reference range CAN be omitted for other data
	 * types. If only an upper or lower limit is meaningful, the unused limit
	 * MUST be declared using nullFlavor.
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange getHl7ReferenceRange() {
		org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange retVal = null;
		if (super.getReferenceRange() != null)
			if (super.getReferenceRange().size() > 0)
				retVal = super.getReferenceRange().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7StatusCode The status 'completed' means that the result is
	 * final.The status 'aborted' means that the examination could not be
	 * performed.
	 */
	public org.ehealth_connector.common.hl7cdar2.CS getHl7StatusCode() {
		return super.statusCode;
	}

	/**
	 * Gets the hl7Subject
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject getHl7Subject() {
		return super.subject;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (super.getTemplateId() != null)
			if (super.getTemplateId().size() > 0)
				retVal = super.getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Value True / False or Yes / No Result. If the observation
	 * value can not be determined, @value is NOT ALLOWED.
	 * Instead, @nullFlavor='NA' MUST be used in combination with
	 * interpretationCode that declares whether the result is below (Low of
	 * scale) or above (High of scale) of the reference range.
	 */
	public org.ehealth_connector.common.hl7cdar2.BL getHl7Value() {
		org.ehealth_connector.common.hl7cdar2.BL retVal = null;
		if (super.getValue() != null)
			if (super.getValue().size() > 0)
				retVal = (org.ehealth_connector.common.hl7cdar2.BL) super.getValue().get(0);
		return retVal;
	}

	/**
	 * Saves the current CDA document to file.
	 *
	 * @param outputFile
	 *            the destination file.
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
	 * Saves the current CDA document to file.
	 *
	 * @param outputFileName
	 *            the full path and filename of the destination file.
	 * @throws JAXBException
	 */
	public void saveToFile(String outputFileName) throws JAXBException {
		saveToFile(new File(outputFileName));
	}

	/**
	 * Sets the hl7Code A unique code for this result MUST be specified.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CD value) {
		super.code = value;
	}

	/**
	 * Creates fixed contents for hl7Code
	 *
	 * @param nullFlavor
	 *            the desired fixed value for this argument.
	 */
	public void setHl7CodeFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.CD member = factory.createCD();
		member.nullFlavor = new ArrayList<String>();
		member.nullFlavor.add(nullFlavor);
		// setting the fixed value
		super.setCode(member);
	}

	/**
	 * Sets the hl7EffectiveTime The result of the examination MUST be specified
	 * for all elements with status 'completed'. One of the following data types
	 * MUST be used. For elements with status 'aborted', the result of the test
	 * is NOT ALLOWED.In the case of microbiological or infection-serological
	 * detection of pathogens, NO value element is PERMITTED. Instead, declare
	 * using the interpretationCode whether the pathogen was detected in the
	 * sample (POS) or not (NEG).
	 */
	public void setHl7EffectiveTime(org.ehealth_connector.common.hl7cdar2.IVLTS value) {
		super.effectiveTime = value;
	}

	/**
	 * Creates fixed contents for hl7EntryRelationship
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 * @param inversionInd
	 *            the desired fixed value for this argument.
	 */
	public void setHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship member = factory
				.createPOCDMT000040EntryRelationship();
		member.setTypeCode(XActRelationshipEntryRelationship.fromValue(typeCode));
		member.setInversionInd(Boolean.parseBoolean(inversionInd));
		// setting the fixed value
		super.getEntryRelationship().add(member);
	}

	/**
	 * Sets the hl7Id An ID for this item MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getId().clear();
		super.getId().add(value);
	}

	/**
	 * Sets the hl7InterpretationCode IF this result is based on a specimen of a
	 * non-human material, this MUST be declared with the subject element.
	 */
	public void setHl7InterpretationCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		super.getInterpretationCode().clear();
		super.getInterpretationCode().add(value);
	}

	/**
	 * Creates fixed contents for hl7Reference
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 */
	public void setHl7ReferenceFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040Reference member = factory
				.createPOCDMT000040Reference();
		member.setTypeCode(XActRelationshipExternalReference.fromValue(typeCode));
		// setting the fixed value
		super.getReference().add(member);
	}

	/**
	 * Sets the hl7ReferenceRange The reference range SHALL be specified for the
	 * range of normal values for the data types PQ and INT. The following
	 * applies: - Upper limit: [R] - Lower limit: [R] - interpretationCode
	 * containing code=N: [M]The reference range CAN be omitted for other data
	 * types. If only an upper or lower limit is meaningful, the unused limit
	 * MUST be declared using nullFlavor.
	 */
	public void setHl7ReferenceRange(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange value) {
		super.getReferenceRange().clear();
		super.getReferenceRange().add(value);
	}

	/**
	 * Creates fixed contents for hl7ReferenceRange
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 */
	public void setHl7ReferenceRangeFixedValue(String typeCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange member = factory
				.createPOCDMT000040ReferenceRange();
		member.getTypeCode().add(typeCode);
		// setting the fixed value
		super.getReferenceRange().add(member);
	}

	/**
	 * Sets the hl7StatusCode The status 'completed' means that the result is
	 * final.The status 'aborted' means that the examination could not be
	 * performed.
	 */
	public void setHl7StatusCode(org.ehealth_connector.common.hl7cdar2.CS value) {
		super.statusCode = value;
	}

	/**
	 * Sets the hl7Subject
	 */
	public void setHl7Subject(org.ehealth_connector.common.hl7cdar2.POCDMT000040Subject value) {
		super.subject = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		super.getTemplateId().clear();
		super.getTemplateId().add(value);
	}

	/**
	 * Creates fixed contents for hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	public void setHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II member = factory.createII();
		member.setRoot(root);
		// setting the fixed value
		super.getTemplateId().add(member);
	}

	/**
	 * Sets the hl7Value True / False or Yes / No Result. If the observation
	 * value can not be determined, @value is NOT ALLOWED.
	 * Instead, @nullFlavor='NA' MUST be used in combination with
	 * interpretationCode that declares whether the result is below (Low of
	 * scale) or above (High of scale) of the reference range.
	 */
	public void setHl7Value(org.ehealth_connector.common.hl7cdar2.BL value) {
		super.getValue().clear();
		super.getValue().add(value);
	}

	/**
	 * Creates fixed contents for hl7Value
	 *
	 * @param nullFlavor
	 *            the desired fixed value for this argument.
	 */
	public void setHl7ValueFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.BL member = factory.createBL();
		member.nullFlavor = new ArrayList<String>();
		member.nullFlavor.add(nullFlavor);
		// setting the fixed value
		super.getValue().add(member);
	}
}
