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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für Currency.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
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
 */
@XmlType(name = "Currency")
@XmlEnum
public enum Currency {

    ARS, AUD, BRL, CAD, CHF, CLF, CNY, DEM, ESP, EUR, FIM, FRF, GBP, ILS, INR, JPY, KRW, MXN, NLG, NZD, PHP, RUR, THB, TRL, TWD, USD, ZAR;

    @NonNull
    public static Currency fromValue(String v) {
        return valueOf(v);
    }

    @NonNull
    public String value() {
        return name();
    }

}
