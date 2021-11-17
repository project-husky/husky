/**
 * The validation services package. It includes classes for XML Schema, Schematron and PDF validation.
 *
 * <p>By default, parameters and return values are annotated with
 * {@link org.checkerframework.checker.nullness.qual.NonNull} except for the generated package. Nullable values are
 * specifically annotated with {@link org.checkerframework.checker.nullness.qual.Nullable}.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN,
        TypeUseLocation.FIELD})
package org.husky.validation.service;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;