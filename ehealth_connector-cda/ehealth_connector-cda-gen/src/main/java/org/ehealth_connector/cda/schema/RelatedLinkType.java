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
 * <p>Java-Klasse für RelatedLinkType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="RelatedLinkType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="REL"/>
 *     &lt;enumeration value="BACKUP"/>
 *     &lt;enumeration value="DIRAUTH"/>
 *     &lt;enumeration value="INDAUTH"/>
 *     &lt;enumeration value="PART"/>
 *     &lt;enumeration value="REPL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelatedLinkType")
@XmlEnum
public enum RelatedLinkType {

    REL,
    BACKUP,
    DIRAUTH,
    INDAUTH,
    PART,
    REPL;

    public String value() {
        return name();
    }

    public static RelatedLinkType fromValue(String v) {
        return valueOf(v);
    }

}
