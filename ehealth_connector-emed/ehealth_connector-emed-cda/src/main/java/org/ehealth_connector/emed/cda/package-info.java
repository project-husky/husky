/**
 * <p>Module for the CDA-CH-EMED project.
 *
 * <p>Current CDA-CH-EMED release supported: <strong>v0.97.0</strong>
 *
 * <p>To update the code to a new CDA-CH-EMED release:
 * <ul>
 *     <li>1. The XML Schema must be adapted to the new release.
 *     <li>2.1. If large changes happen,
 *     <li>2.2. For small changes (e.g. ), the models can be adapted manually.
 *     <li>3. The {@link org.ehealth_connector.emed.cda.CdaChEmedUtils} and
 *     {@link org.ehealth_connector.emed.cda.NarrativeTextGenerator} should be adapted, if needed.
 * </ul>
 *
 * <p>There is currently no versioning of the module, apart from the natural eHC versioning; the code is continually
 * adapted to support the latest CDA-CH-EMED release. Breaking changes can happen at any time. There is actually no
 * plan for the stable versioning of the project (CDA-CH-EMED >= 1.0.0); that is to be discussed with eHealthSuisse,
 * notably to know if breaking changes could happen after v1.0.0.
 *
 * <p>By default, parameters and return values are annotated with
 * {@link org.checkerframework.checker.nullness.qual.NonNull} except for the generated package. Nullable values are
 * specifically annotated with {@link org.checkerframework.checker.nullness.qual.Nullable}.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN,
        TypeUseLocation.FIELD})
package org.ehealth_connector.emed.cda;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;