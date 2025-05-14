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
package org.projecthusky.fhir.core.ch;

import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;

/**	
 * 
 */
public class TestHelper {
	
	protected Logger logger = LoggerFactory.getLogger(TestHelper.class);

	public void prettyPrint(IBaseResource ref) {
		FhirContext ctx = FhirContext.forR4();
//		System.out.println(ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(ref));
		logger.info(ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(ref));
	}
	
}
