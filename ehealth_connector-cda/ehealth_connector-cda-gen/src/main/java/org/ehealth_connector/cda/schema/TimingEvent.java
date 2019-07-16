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
 * <p>Java-Klasse für TimingEvent.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
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

    AC,
    ACD,
    ACM,
    ACV,
    HS,
    IC,
    ICD,
    ICM,
    ICV,
    PC,
    PCD,
    PCM,
    PCV,
    CM,
    CD,
    CV;

    public String value() {
        return name();
    }

    public static TimingEvent fromValue(String v) {
        return valueOf(v);
    }

}
