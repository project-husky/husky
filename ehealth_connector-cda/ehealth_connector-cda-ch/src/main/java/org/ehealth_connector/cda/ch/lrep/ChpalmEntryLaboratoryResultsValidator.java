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
package org.ehealth_connector.cda.ch.lrep;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.8
 * Template description: The document MAY contain further signatures (besides the legal authenticator). A Laboratory Results Validator is such an authenticator. It is a laboratory specialist who has performed the clinical validation of the entire document or a subset of the laboratory results. If this element is specified, the following applies:
 * - If only one laboratory specialist has carried out the clinical validation of the document, it should be specified in the header, only.
 * - If multiple laboratory specialists were involved in the clinical validation of the document, all must be specified in the header and body (at entry, organizer or observation level, depending on the scope of the results that the corresponding person has validated).
 * - All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
 */
public class ChpalmEntryLaboratoryResultsValidator extends org.ehealth_connector.common.hl7cdar2.II {
}
