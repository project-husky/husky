//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.08 um 04:56:31 PM CEST 
//


package org.ehealth_connector.cda.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ParticipationAncillary.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationAncillary">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ADM"/>
 *     &lt;enumeration value="ATND"/>
 *     &lt;enumeration value="CALLBCK"/>
 *     &lt;enumeration value="CON"/>
 *     &lt;enumeration value="DIS"/>
 *     &lt;enumeration value="ESC"/>
 *     &lt;enumeration value="REF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationAncillary")
@XmlEnum
public enum ParticipationAncillary {

    ADM,
    ATND,
    CALLBCK,
    CON,
    DIS,
    ESC,
    REF;

    public String value() {
        return name();
    }

    public static ParticipationAncillary fromValue(String v) {
        return valueOf(v);
    }

}
