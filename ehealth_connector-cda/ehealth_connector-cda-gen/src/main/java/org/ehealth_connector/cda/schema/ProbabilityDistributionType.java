//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.08 um 04:56:31 PM CEST 
//


package org.ehealth_connector.cda.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ProbabilityDistributionType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ProbabilityDistributionType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="B"/>
 *     &lt;enumeration value="E"/>
 *     &lt;enumeration value="F"/>
 *     &lt;enumeration value="G"/>
 *     &lt;enumeration value="LN"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="T"/>
 *     &lt;enumeration value="U"/>
 *     &lt;enumeration value="X2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProbabilityDistributionType")
@XmlEnum
public enum ProbabilityDistributionType {

    B("B"),
    E("E"),
    F("F"),
    G("G"),
    LN("LN"),
    N("N"),
    T("T"),
    U("U"),
    @XmlEnumValue("X2")
    X_2("X2");
    private final String value;

    ProbabilityDistributionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProbabilityDistributionType fromValue(String v) {
        for (ProbabilityDistributionType c: ProbabilityDistributionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
