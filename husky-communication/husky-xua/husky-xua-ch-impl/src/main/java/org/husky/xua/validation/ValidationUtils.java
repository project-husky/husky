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
package org.husky.xua.validation;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.schema.XSString;
import org.opensaml.core.xml.schema.XSURI;

import java.util.Objects;
import java.util.Optional;

/**
 * Some utility methods for the validators.
 *
 * @author Quentin Ligier
 **/
public class ValidationUtils {

    /**
     * This class is not instantiable.
     */
    private ValidationUtils() {
    }

    /**
     * Extracts the string value of an XMLObject.
     *
     * @param xmlObject The XML object.
     * @return The String value or {@code null}.
     */
    @Nullable
    public static String extractXsValue(final XMLObject xmlObject) {
        return Optional.of(xmlObject)
                .map(object -> {
                    if (object instanceof final XSString xsString){
                        return xsString.getValue();
                    } else if (object instanceof final XSURI xsUri) {
                        return xsUri.getURI();
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .map(String::trim)
                .orElse(null);
    }
}
