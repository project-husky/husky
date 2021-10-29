/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2020.07.09 um 01:07:39 PM CEST
//

package org.husky.emed.cda.generated.hl7cdar2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für TimingEvent.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="TimingEvent">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="ACD"/>
 *     &lt;enumeration value="ACM"/>
 *     &lt;enumeration value="ACV"/>
 *     &lt;enumeration value="HS"/>
 *     &lt;enumeration value="IC"/>
 *     &lt;enumeration value="ICD"/>
 *     &lt;enumeration value="ICM"/>
 *     &lt;enumeration value="ICV"/>
 *     &lt;enumeration value="PC"/>
 *     &lt;enumeration value="PCD"/>
 *     &lt;enumeration value="PCM"/>
 *     &lt;enumeration value="PCV"/>
 *     &lt;enumeration value="CM"/>
 *     &lt;enumeration value="CD"/>
 *     &lt;enumeration value="CV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "TimingEvent")
@XmlEnum
public enum TimingEvent {

    AC, ACD, ACM, ACV, HS, IC, ICD, ICM, ICV, PC, PCD, PCM, PCV, CM, CD, CV;

    public static TimingEvent fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
