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
 * Java-Klasse für URLScheme.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="URLScheme">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="fax"/>
 *     &lt;enumeration value="file"/>
 *     &lt;enumeration value="ftp"/>
 *     &lt;enumeration value="http"/>
 *     &lt;enumeration value="mailto"/>
 *     &lt;enumeration value="mllp"/>
 *     &lt;enumeration value="modem"/>
 *     &lt;enumeration value="nfs"/>
 *     &lt;enumeration value="tel"/>
 *     &lt;enumeration value="telnet"/>
 *     &lt;enumeration value="me"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "URLScheme")
@XmlEnum
public enum URLScheme {

    @XmlEnumValue("fax")
    FAX("fax"),

    @XmlEnumValue("file")
    FILE("file"),

    @XmlEnumValue("ftp")
    FTP("ftp"),

    @XmlEnumValue("http")
    HTTP("http"),

    @XmlEnumValue("mailto")
    MAILTO("mailto"),

    @XmlEnumValue("mllp")
    MLLP("mllp"),

    @XmlEnumValue("modem")
    MODEM("modem"),

    @XmlEnumValue("nfs")
    NFS("nfs"),

    @XmlEnumValue("tel")
    TEL("tel"),

    @XmlEnumValue("telnet")
    TELNET("telnet"),

    @XmlEnumValue("me")
    ME("me");

    @NonNull
    public static URLScheme fromValue(String v) {
        for (URLScheme c : URLScheme.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    @NonNull
    private final String value;

    URLScheme(@NonNull final String v) {
        value = v;
    }

    @NonNull
    public String value() {
        return value;
    }

}
