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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.6
 * Template description: If, in a part of the document, certain laboratory observations for a human patient base on a sample of a non-human material (e.g., food eaten by the patient or an animal that has bitten the patient), it MUST be declared using this element in the CDA body. Other parts of the document may contain laboratory observations that base on other samples (including samples taken from the patient). In addition, the IHE template 1.3.6.1.4.1.19376.1.3.3.1.3 - Human Patient with Non-Human Subject (recordTarget) MUST be used in the CDA header.
 */
public class ChpalmEntryHumanPatientWithNonHumanSubject extends org.ehealth_connector.common.hl7cdar2.II {
}
