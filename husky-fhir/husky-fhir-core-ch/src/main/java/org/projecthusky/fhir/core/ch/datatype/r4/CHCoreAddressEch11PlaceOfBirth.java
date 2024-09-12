/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.fhir.core.ch.datatype.r4;

import org.hl7.fhir.r4.model.Address;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * 
 */
@DatatypeDef(name = "CHCoreAddressEch11PlaceOfBirth", isSpecialization = true, profileOf = Address.class)
public class CHCoreAddressEch11PlaceOfBirth extends ChCoreAddress {

}
