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

package org.projecthusky.common.hl7cdar2;

import org.checkerframework.checker.nullness.qual.NonNull;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für TimingEvent.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;simpleType name="TimingEvent"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="AC"/&gt;
 *     &lt;enumeration value="ACD"/&gt;
 *     &lt;enumeration value="ACM"/&gt;
 *     &lt;enumeration value="ACV"/&gt;
 *     &lt;enumeration value="HS"/&gt;
 *     &lt;enumeration value="IC"/&gt;
 *     &lt;enumeration value="ICD"/&gt;
 *     &lt;enumeration value="ICM"/&gt;
 *     &lt;enumeration value="ICV"/&gt;
 *     &lt;enumeration value="PC"/&gt;
 *     &lt;enumeration value="PCD"/&gt;
 *     &lt;enumeration value="PCM"/&gt;
 *     &lt;enumeration value="PCV"/&gt;
 *     &lt;enumeration value="CM"/&gt;
 *     &lt;enumeration value="CD"/&gt;
 *     &lt;enumeration value="CV"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="WAKE"/&gt;
 *     &lt;enumeration value="MORN"/&gt;
 *     &lt;enumeration value="MORN.early"/&gt;
 *     &lt;enumeration value="MORN.late"/&gt;
 *     &lt;enumeration value="AFT"/&gt;
 *     &lt;enumeration value="AFT.early"/&gt;
 *     &lt;enumeration value="AFT.late"/&gt;
 *     &lt;enumeration value="EVE"/&gt;
 *     &lt;enumeration value="EVE.early"/&gt;
 *     &lt;enumeration value="EVE.late"/&gt;
 *     &lt;enumeration value="NIGHT"/&gt;
 *     &lt;enumeration value="PHS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TimingEvent")
@XmlEnum
public enum TimingEvent {

    AC("AC"),
    ACD("ACD"),
    ACM("ACM"),
    ACV("ACV"),
    HS("HS"),
    IC("IC"),
    ICD("ICD"),
    ICM("ICM"),
    ICV("ICV"),
    PC("PC"),
    PCD("PCD"),
    PCM("PCM"),
    PCV("PCV"),
    CM("CM"),
    CD("CD"),
    CV("CV"),
    C("C"),
    WAKE("WAKE"),
    MORN("MORN"),
    @XmlEnumValue("MORN.early") MORN_EARLY("MORN.early"),
    @XmlEnumValue("MORN.late") MORN_LATE("MORN.late"),
    AFT("AFT"),
    @XmlEnumValue("AFT.early") AFT_EARLY("AFT.early"),
    @XmlEnumValue("AFT.late") AFT_LATE("AFT.late"),
    EVE("EVE"),
    @XmlEnumValue("EVE.early") EVE_EARLY("EVE.early"),
    @XmlEnumValue("EVE.late") EVE_LATE("EVE.late"),
    NIGHT("NIGHT"),
    PHS("PHS");

    @NonNull
    public static TimingEvent fromValue(String v) {
        for (TimingEvent c : TimingEvent.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    @NonNull
    private final String value;

    TimingEvent(@NonNull final String v) {
        this.value = v;
    }

    @NonNull
    public String value() {
        return this.value;
    }

}
