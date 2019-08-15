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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.46
 * Template description: Chapter (CDA Body Section) containing the coded results according to IHE PCC Technical Framework Revision 11.0 - November 11, 2016.This section MAY contain relevant coded results of a patient for the given document context. The section MUST contain at least one Problem entry. In case of no relevant results, one of the 'special case' codes MUST be used.In the context of immunizations, this section may indicate the gestational age of a child if relevant for immunization of the child.In the context of lab reports, this section may indicate the gestational age of a child if relevant for the observation interpretation.
 *
 * Element description: Chapter (CDA Body Section) containing the coded results according to IHE PCC Technical Framework Revision 11.0 - November 11, 2016.This section MAY contain relevant coded results of a patient for the given document context. The section MUST contain at least one Problem entry. In case of no relevant results, one of the 'special case' codes MUST be used.In the context of immunizations, this section may indicate the gestational age of a child if relevant for immunization of the child.In the context of lab reports, this section may indicate the gestational age of a child if relevant for the observation interpretation.
 */
public class CdachvacdSectionOtherRelevantObservationsCoded extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {
}
