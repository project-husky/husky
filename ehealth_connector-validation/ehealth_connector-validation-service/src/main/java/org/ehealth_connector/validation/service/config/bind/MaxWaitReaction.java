//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.04.30 um 04:58:07 AM CEST 
//


package org.ehealth_connector.validation.service.config.bind;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MaxWaitReaction.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="MaxWaitReaction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="throwException"/>
 *     &lt;enumeration value="returnValidationError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MaxWaitReaction")
@XmlEnum
public enum MaxWaitReaction {

    @XmlEnumValue("throwException")
    THROW_EXCEPTION("throwException"),
    @XmlEnumValue("returnValidationError")
    RETURN_VALIDATION_ERROR("returnValidationError");
    private final String value;

    MaxWaitReaction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MaxWaitReaction fromValue(String v) {
        for (MaxWaitReaction c: MaxWaitReaction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
