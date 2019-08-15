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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.77
 * Template description: Chapter (CDA Body Section) with laboratory results according to Sharing Laboratory Reports (XD-LAB) Content Module, IHE PaLM Technical Framework Revision 8.0 - June 21, 2017.Each Laboratory Specialty Section contains laboratory tests of a particular discipline (e.g., microbiology or serology).The Laboratory Specialty Section uses LOINC codes to define the appropriate discipline. Laboratory Specialty Sections MUST NOT be nested.A Laboratory Specialty Section SHALL contain EITHER a list of Laboratory Report Item Section(s) OR a single text and entry element to represent the Report Items:
 * - Choice 1: Laboratory Report Item SectionWith this option, this Laboratory Specialty Section SHALL contain NEITHER a top level text NOR entry elements. Each Report Item is contained in a corresponding Laboratory Report Item Section which contains the Lab Report Data Processing Entry.
 * - Choice 2: Text and EntryWith this option, the examination results MUST be documented in the text element of the section and the corresponding entry element (Laboratory Data Processing Entry).The human-readable text MUST be generated automatically from the entry and its sub-elements.For this purpose the presentation options according to the CDA Narrative Block schema (NarrativeBlock.xsd) may be used: tables, lists, paragraphs, hyperlinks, footnotes, references to attached or embedded multimedia objects.If a document contains multiple Laboratory Specialty Sections, Choice 1 or Choice 2 can be selected for each individual chapter.
 */
public class CdachlrepSectionLaboratorySpecialtyCoded extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {
}
