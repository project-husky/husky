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
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2020.07.09 um 01:07:39 PM CEST
//

package org.husky.common.hl7cdar2;

import org.checkerframework.checker.nullness.qual.NonNull;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für TextMediaType.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;simpleType name="TextMediaType"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="text/html"/&gt;
 *     &lt;enumeration value="text/plain"/&gt;
 *     &lt;enumeration value="text/rtf"/&gt;
 *     &lt;enumeration value="text/sgml"/&gt;
 *     &lt;enumeration value="text/x-hl7-ft"/&gt;
 *     &lt;enumeration value="text/xml"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TextMediaType")
@XmlEnum
public enum TextMediaType {

    @XmlEnumValue("text/html")
    TEXT_HTML("text/html"), @XmlEnumValue("text/plain")
    TEXT_PLAIN("text/plain"), @XmlEnumValue("text/rtf")
    TEXT_RTF("text/rtf"), @XmlEnumValue("text/sgml")
    TEXT_SGML("text/sgml"), @XmlEnumValue("text/x-hl7-ft")
    TEXT_X_HL_7_FT("text/x-hl7-ft"), @XmlEnumValue("text/xml")
    TEXT_XML("text/xml");

    @NonNull
    public static TextMediaType fromValue(String v) {
        for (TextMediaType c : TextMediaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    @NonNull
    private final String value;

    TextMediaType(@NonNull final String v) {
        value = v;
    }

    @NonNull
    public String value() {
        return value;
    }

}
