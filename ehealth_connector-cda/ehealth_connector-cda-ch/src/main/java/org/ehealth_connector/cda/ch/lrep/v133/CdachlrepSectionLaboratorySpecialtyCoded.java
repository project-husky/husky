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

	/**
	 * Adds a hl7Component
	 */
	public void addHl7Component(org.ehealth_connector.common.hl7cdar2.POCDMT000040Component5 value) {
		getComponent().add(value);
	}

	/**
	 * Adds a hl7Entry
	 * The narrative text in the text element of the section MUST be generated automatically from the information in this entry.
	 */
	public void addHl7Entry(org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry value) {
		getEntry().add(value);
	}

	/**
	 * Adds a hl7Component
	 */
	public void clearHl7Component() {
		getComponent().clear();
	}

	/**
	 * Adds a hl7Entry
	 * The narrative text in the text element of the section MUST be generated automatically from the information in this entry.
	 */
	public void clearHl7Entry() {
		getEntry().clear();
	}

	/**
	 * Gets the hl7Code
	 * This declares the laboratory discipline of the section.
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7Id
	 * An ID for this section MAY be filled for traceability.
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7Id() {
		return id;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public org.ehealth_connector.common.hl7cdar2.II getHl7TemplateId() {
		org.ehealth_connector.common.hl7cdar2.II retVal = null;
		if (getTemplateId() != null)
			if (getTemplateId().size() > 0)
				retVal = getTemplateId().get(0);
		return retVal;
	}

	/**
	 * Gets the hl7Text
	 * The narrative text for this section.
	 */
	public org.ehealth_connector.common.hl7cdar2.StrucDocText getHl7Text() {
		return text;
	}

	/**
	 * Gets the hl7Title
	 * The title of the chapter MUST be specified and correspond to the following text format, where &lt;human readable code&gt; contains the corresponding translation of the document LOINC code:
	 * - [ge]: 'Laborbefund - &lt;human readable code&gt;'
	 * - [fr]: 'Rapport de laboratoire - &lt;human readable code&gt;'
	 * - [it]: 'Referto di laboratorio - &lt;human readable code&gt;'
	 * - [en]: 'Laboratory Specialty - &lt;human readable code&gt;'The following translations of the LOINC codes given in XD-LAB MUST be used:<table><tbody><tr><th>LOINC Code</th><th>Text</th></tr><tr><td>18717-9</td><td>[ge]: Immunhämatologie[fr]: Immunohématologie[it]: Immunoematologia</td></tr><tr><td>18718-7</td><td>[ge]: Molekularbiologie[fr]: Biologie moléculaire[it]: Biologia molecolare</td></tr><tr><td>18719-5</td><td>[ge]: Chemie[fr]: Chimie[it]: Chimica</td></tr><tr><td>18720-3</td><td>[ge]: Gerinnung[fr]: Coagulation[it]: Coagulazione</td></tr><tr><td>18721-1</td><td>[ge]: Medikamente[fr]: Médicaments[it]: Medicamenti</td></tr><tr><td>18722-9</td><td>[ge]: Fertilität[fr]: Fertilité[it]: Fertilità</td></tr><tr><td>18723-7</td><td>[ge]: Hämatologie[fr]: Hématologie[it]: Ematologia</td></tr><tr><td>18724-5</td><td>[ge]: HLA[fr]: HLA[it]: HLA</td></tr><tr><td>18725-2</td><td>[ge]: Mikrobiologie[fr]: Microbiologie[it]: Microbiologia</td></tr><tr><td>18727-8</td><td>[ge]: Serologie[fr]: Sérologie[it]: Sierologia</td></tr><tr><td>18728-6</td><td>[ge]: Toxikologie[fr]: Toxicologie[it]: Tessicologia</td></tr><tr><td>18729-4</td><td>[ge]: Urin Untersuchungen[fr]: Analyses dans l'urine[it]: Analisi nelle urine</td></tr><tr><td>18767-4</td><td>[ge]: Blutgase[fr]: Gazométrie[it]: Gasometria</td></tr><tr><td>18768-2</td><td>[ge]: Differenzialblutbild[fr]: Répartition leucocytaire[it]: Differenziazione leucocitaria</td></tr><tr><td>18769-0</td><td>[ge]: Antibiogramme[fr]: Antibiogramme[it]: Antibiogramma</td></tr><tr><td>26435-8</td><td>[ge]: Molekulare Pathologie[fr]: Pathologie moleculaire[it]: Patologia moleculare</td></tr><tr><td>26436-6</td><td>[ge]: Laboruntersuchungen[fr]: Études de laboratoire[it]: Esami di laboratorio</td></tr><tr><td>26437-4</td><td>[ge]: Stimulationen[fr]: Stimulation[it]: Stimolazione</td></tr><tr><td>26438-2</td><td>[ge]: Zytologie[fr]: Cytologie[it]: Citologia</td></tr></tbody></table>
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7Title() {
		return title;
	}

	/**
	 * Sets the hl7Code
	 * This declares the laboratory discipline of the section.
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Id
	 * An ID for this section MAY be filled for traceability.
	 */
	public void setHl7Id(org.ehealth_connector.common.hl7cdar2.II value) {
		this.id = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text
	 * The narrative text for this section.
	 */
	public void setHl7Text(org.ehealth_connector.common.hl7cdar2.StrucDocText value) {
		this.text = value;
	}

	/**
	 * Sets the hl7Title
	 * The title of the chapter MUST be specified and correspond to the following text format, where &lt;human readable code&gt; contains the corresponding translation of the document LOINC code:
	 * - [ge]: 'Laborbefund - &lt;human readable code&gt;'
	 * - [fr]: 'Rapport de laboratoire - &lt;human readable code&gt;'
	 * - [it]: 'Referto di laboratorio - &lt;human readable code&gt;'
	 * - [en]: 'Laboratory Specialty - &lt;human readable code&gt;'The following translations of the LOINC codes given in XD-LAB MUST be used:<table><tbody><tr><th>LOINC Code</th><th>Text</th></tr><tr><td>18717-9</td><td>[ge]: Immunhämatologie[fr]: Immunohématologie[it]: Immunoematologia</td></tr><tr><td>18718-7</td><td>[ge]: Molekularbiologie[fr]: Biologie moléculaire[it]: Biologia molecolare</td></tr><tr><td>18719-5</td><td>[ge]: Chemie[fr]: Chimie[it]: Chimica</td></tr><tr><td>18720-3</td><td>[ge]: Gerinnung[fr]: Coagulation[it]: Coagulazione</td></tr><tr><td>18721-1</td><td>[ge]: Medikamente[fr]: Médicaments[it]: Medicamenti</td></tr><tr><td>18722-9</td><td>[ge]: Fertilität[fr]: Fertilité[it]: Fertilità</td></tr><tr><td>18723-7</td><td>[ge]: Hämatologie[fr]: Hématologie[it]: Ematologia</td></tr><tr><td>18724-5</td><td>[ge]: HLA[fr]: HLA[it]: HLA</td></tr><tr><td>18725-2</td><td>[ge]: Mikrobiologie[fr]: Microbiologie[it]: Microbiologia</td></tr><tr><td>18727-8</td><td>[ge]: Serologie[fr]: Sérologie[it]: Sierologia</td></tr><tr><td>18728-6</td><td>[ge]: Toxikologie[fr]: Toxicologie[it]: Tessicologia</td></tr><tr><td>18729-4</td><td>[ge]: Urin Untersuchungen[fr]: Analyses dans l'urine[it]: Analisi nelle urine</td></tr><tr><td>18767-4</td><td>[ge]: Blutgase[fr]: Gazométrie[it]: Gasometria</td></tr><tr><td>18768-2</td><td>[ge]: Differenzialblutbild[fr]: Répartition leucocytaire[it]: Differenziazione leucocitaria</td></tr><tr><td>18769-0</td><td>[ge]: Antibiogramme[fr]: Antibiogramme[it]: Antibiogramma</td></tr><tr><td>26435-8</td><td>[ge]: Molekulare Pathologie[fr]: Pathologie moleculaire[it]: Patologia moleculare</td></tr><tr><td>26436-6</td><td>[ge]: Laboruntersuchungen[fr]: Études de laboratoire[it]: Esami di laboratorio</td></tr><tr><td>26437-4</td><td>[ge]: Stimulationen[fr]: Stimulation[it]: Stimolazione</td></tr><tr><td>26438-2</td><td>[ge]: Zytologie[fr]: Cytologie[it]: Citologia</td></tr></tbody></table>
	 */
	public void setHl7Title(org.ehealth_connector.common.hl7cdar2.ST value) {
		this.title = value;
	}
}
