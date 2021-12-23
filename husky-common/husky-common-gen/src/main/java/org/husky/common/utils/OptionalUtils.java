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

package org.husky.common.utils;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Objects;

/**
 * Helper utilities related to {@link java.util.Optional}s.
 *
 * @author Quentin Ligier
 **/
public class OptionalUtils {

    /**
     * This class is not instantiable.
     */
    private OptionalUtils() {
    }

    /**
     * Safe accessor to {@link List}s that returns null instead of throwing {@link IndexOutOfBoundsException}.
     *
     * @param list  The list.
     * @param index The index to access, positive or null.
     * @param <T>   The type of the list content.
     * @return the value of the list at the requested index as type {@code T} or {@code null}.
     */
    @Nullable
    public static <T> T getListElementAtIndex(final List<T> list, final int index) {
        Objects.requireNonNull(list);
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    /**
     * Safe accessor to {@link List}s that returns null instead of throwing {@link IndexOutOfBoundsException}.
     *
     * @param list The list.
     * @param <T>  The type of the list content.
     * @return the first value of the list as type {@code T} or {@code null}.
     */
    @Nullable
    public static <T> T getListFirstElement(final List<T> list) {
        return getListElementAtIndex(Objects.requireNonNull(list), 0);
    }

    /**
     * Safe accessor to {@link List}s that returns null if the list contains no or multiple elements.
     *
     * @param list The list.
     * @param <T>  The type of the list content.
     * @return the only value of the list as type {@code T} or {@code null}.
     */
    @Nullable
    public static <T> T getListOnlyElement(final List<T> list) {
        if (Objects.requireNonNull(list).size() != 1) {
            return null;
        }
        return list.get(0);
    }

    /**
     * Cast the given object to the required class or return {@code null} to filter the value in the {@link
     * java.util.Optional}.
     *
     * @param object The instance to cast or filter.
     * @param type   The required type.
     * @param <T>    The required type.
     * @return the casted object or {@code null} if it wasn't an instance of the required type.
     */
    @Nullable
    public static <T> T castOrFilter(final Object object,
                                     final Class<T> type) {
        return type.isInstance(object) ? type.cast(object) : null;
    }
}
