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
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.27
 * Template description: Specimen Type.
 *
 * Element description: IHE XD-LAB requires coding of the specimen. However, since the laboratory results have to be coded with LOINC, the specimen is already defined via the 'System' axis of LOINC. Therefore the following, fixed code CAN be used for laboratory reports in Switzerland.
 */
public class ChpalmEntrySpecimenType extends org.ehealth_connector.common.hl7cdar2.CE {
}
