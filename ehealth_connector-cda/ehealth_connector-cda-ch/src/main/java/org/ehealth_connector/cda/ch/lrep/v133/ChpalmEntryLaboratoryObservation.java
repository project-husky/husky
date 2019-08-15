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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.lrep.v133;

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
}
