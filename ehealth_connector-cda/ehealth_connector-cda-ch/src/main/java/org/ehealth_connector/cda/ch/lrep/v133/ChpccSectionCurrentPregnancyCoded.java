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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.3.53
 * Template description: Chapter (CDA Body Section) containing the information about a current pregnancy. This section is specialisation of the Pregnancy Hostory section according to IHE PCC Technical Framework Revision 11.0 - November 11, 2016.The section MUST contain at least one Pregnancy Observation entry. In case of no pregnancy, one of the 'special case' codes MUST be used.This section SHALL not be present for male patients.For eVACDOC, this section MUST only contain the estimated delivery date.
 *
 * Element description: Chapter (CDA Body Section) containing the information about a current pregnancy. This section is specialisation of the Pregnancy Hostory section according to IHE PCC Technical Framework Revision 11.0 - November 11, 2016.The section MUST contain at least one Pregnancy Observation entry. In case of no pregnancy, one of the 'special case' codes MUST be used.This section SHALL not be present for male patients.For eVACDOC, this section MUST only contain the estimated delivery date.
 */
public class ChpccSectionCurrentPregnancyCoded extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Section {
}
