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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für Currency.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;simpleType name="Currency"&gt;
 *   &lt;restriction base="{urn:hl7-org:v3}cs"&gt;
 *     &lt;enumeration value="ARS"/&gt;
 *     &lt;enumeration value="AUD"/&gt;
 *     &lt;enumeration value="BRL"/&gt;
 *     &lt;enumeration value="CAD"/&gt;
 *     &lt;enumeration value="CHF"/&gt;
 *     &lt;enumeration value="CLF"/&gt;
 *     &lt;enumeration value="CNY"/&gt;
 *     &lt;enumeration value="DEM"/&gt;
 *     &lt;enumeration value="ESP"/&gt;
 *     &lt;enumeration value="EUR"/&gt;
 *     &lt;enumeration value="FIM"/&gt;
 *     &lt;enumeration value="FRF"/&gt;
 *     &lt;enumeration value="GBP"/&gt;
 *     &lt;enumeration value="ILS"/&gt;
 *     &lt;enumeration value="INR"/&gt;
 *     &lt;enumeration value="JPY"/&gt;
 *     &lt;enumeration value="KRW"/&gt;
 *     &lt;enumeration value="MXN"/&gt;
 *     &lt;enumeration value="NLG"/&gt;
 *     &lt;enumeration value="NZD"/&gt;
 *     &lt;enumeration value="PHP"/&gt;
 *     &lt;enumeration value="RUR"/&gt;
 *     &lt;enumeration value="THB"/&gt;
 *     &lt;enumeration value="TRL"/&gt;
 *     &lt;enumeration value="TWD"/&gt;
 *     &lt;enumeration value="USD"/&gt;
 *     &lt;enumeration value="ZAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
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
