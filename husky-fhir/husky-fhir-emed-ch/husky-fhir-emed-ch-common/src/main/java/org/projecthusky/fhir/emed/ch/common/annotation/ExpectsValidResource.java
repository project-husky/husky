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
package org.projecthusky.fhir.emed.ch.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * An annotation that indicates the method expects the FHIR resource to be valid regarding the relevant IG. It may throw
 * if the resource is invalid. The method is designed as a convenient reader for a resource that has been validated
 * beforehand.
 *
 * @author Quentin Ligier
 **/
@Documented
@Target(value = ElementType.METHOD)
public @interface ExpectsValidResource {
}
