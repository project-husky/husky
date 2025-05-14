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

/**
 * The generic package for Swiss FHIR Implementation Guides.
 *
 * <p>By default, parameters and return values are annotated with
 * {@link org.checkerframework.checker.nullness.qual.NonNull} except for the generated package. Nullable values are
 * specifically annotated with {@link org.checkerframework.checker.nullness.qual.Nullable}.
 *
 * @author Quentin Ligier
 **/
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN,
        TypeUseLocation.FIELD})
package org.projecthusky.fhir.vacd.ch.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;
