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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.35
 * Template description: Address information according to the eCH-0010 V7.0 addressInformation data type. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.See https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0010&amp;documentVersion=7.0 for more information.
 *
 * Element description: Free additional lines for additional address information which can not be used in the other address fields (e.g. for c/o entries, etc.), with a maximum length of 150 characters.addressLine1 should be used for personalized addressing (e.g., c/o-Address).
 */
public class CdachOtherAddressInformationCompilationECh0010 extends org.ehealth_connector.common.hl7cdar2.ADXP {
}
