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

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.2.62
 * Template description: The document MUST contain a title. The following translations of the LOINC codes specified in XD-LAB MUST be used:Multidisciplinary reports<table><tbody><tr><th>LOINC Code</th><th>Text</th></tr><tr><td>11502-2</td><td>[ge]: MultidisziplinÃ¤re Befunde[fr]: RÃ©sultats multidisciplinaires[it]: Risultati multidisciplinari</td></tr></tbody></table>Findings of a particular disciplineThe same translations as for Laboratory Speciality Section are to be used.
 *
 * Element description: The document title must follow the following text format where &lt;human readable code&gt; is the local translation of the document LOINC code:
 * - [de]: 'Laborbefund - &lt;human readable code&gt;'
 * - [fr]: 'Rapport de laboratoire - &lt;human readable code&gt;'
 * - [it]: 'Referto di laboratorio - &lt;human readable code&gt;'
 * - [en]: 'Laboratory report - &lt;human readable code&gt;'
 */
public class CdachlrepHeaderDocumentTitle extends org.ehealth_connector.common.hl7cdar2.ST {
}
