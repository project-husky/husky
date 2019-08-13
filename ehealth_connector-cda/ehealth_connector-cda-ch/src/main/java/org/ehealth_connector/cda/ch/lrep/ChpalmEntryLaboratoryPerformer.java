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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.7
 * Template description: This CAN be used to indicate another executing laboratory in the CDA body. When executing laboratories are specified, the following applies:
 * - If all tests have been performed by the same laboratory, this element MUST be specified in the header using the Laboratory Performer (documentationOf).
 * - If multple laboratories have provided results for this document, they must be specified in the body using this element (at entry, organizer or observation level, depending on the extent of the results delivered by the appropriate laboratory).
 * - All persons and organizations, MUST according to XD-LAB contain name, addr and telecom.
 */
public class ChpalmEntryLaboratoryPerformer extends org.ehealth_connector.common.hl7cdar2.II {
}
