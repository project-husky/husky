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

package org.husky.common.hl7cdar2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für Currency.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="Currency">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ARS"/>
 *     &lt;enumeration value="AUD"/>
 *     &lt;enumeration value="BRL"/>
 *     &lt;enumeration value="CAD"/>
 *     &lt;enumeration value="CHF"/>
 *     &lt;enumeration value="CLF"/>
 *     &lt;enumeration value="CNY"/>
 *     &lt;enumeration value="DEM"/>
 *     &lt;enumeration value="ESP"/>
 *     &lt;enumeration value="EUR"/>
 *     &lt;enumeration value="FIM"/>
 *     &lt;enumeration value="FRF"/>
 *     &lt;enumeration value="GBP"/>
 *     &lt;enumeration value="ILS"/>
 *     &lt;enumeration value="INR"/>
 *     &lt;enumeration value="JPY"/>
 *     &lt;enumeration value="KRW"/>
 *     &lt;enumeration value="MXN"/>
 *     &lt;enumeration value="NLG"/>
 *     &lt;enumeration value="NZD"/>
 *     &lt;enumeration value="PHP"/>
 *     &lt;enumeration value="RUR"/>
 *     &lt;enumeration value="THB"/>
 *     &lt;enumeration value="TRL"/>
 *     &lt;enumeration value="TWD"/>
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="ZAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "Currency")
@XmlEnum
public enum Currency {

    ARS, AUD, BRL, CAD, CHF, CLF, CNY, DEM, ESP, EUR, FIM, FRF, GBP, ILS, INR, JPY, KRW, MXN, NLG, NZD, PHP, RUR, THB, TRL, TWD, USD, ZAR;

    public static Currency fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
