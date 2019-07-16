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
 * <p>Java-Klasse für x_ActClassDocumentEntryAct.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActClassDocumentEntryAct">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACT"/>
 *     &lt;enumeration value="ACCM"/>
 *     &lt;enumeration value="CONS"/>
 *     &lt;enumeration value="CTTEVENT"/>
 *     &lt;enumeration value="INC"/>
 *     &lt;enumeration value="INFRM"/>
 *     &lt;enumeration value="PCPR"/>
 *     &lt;enumeration value="REG"/>
 *     &lt;enumeration value="SPCTRT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_ActClassDocumentEntryAct")
@XmlEnum
public enum XActClassDocumentEntryAct {

    ACT,
    ACCM,
    CONS,
    CTTEVENT,
    INC,
    INFRM,
    PCPR,
    REG,
    SPCTRT;

    public String value() {
        return name();
    }

    public static XActClassDocumentEntryAct fromValue(String v) {
        return valueOf(v);
    }

}
