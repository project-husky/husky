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
 * <p>Java-Klasse für ImageMediaType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ImageMediaType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="image/g3fax"/>
 *     &lt;enumeration value="image/gif"/>
 *     &lt;enumeration value="image/jpeg"/>
 *     &lt;enumeration value="image/png"/>
 *     &lt;enumeration value="image/tiff"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ImageMediaType")
@XmlEnum
public enum ImageMediaType {

    @XmlEnumValue("image/g3fax")
    IMAGE_G_3_FAX("image/g3fax"),
    @XmlEnumValue("image/gif")
    IMAGE_GIF("image/gif"),
    @XmlEnumValue("image/jpeg")
    IMAGE_JPEG("image/jpeg"),
    @XmlEnumValue("image/png")
    IMAGE_PNG("image/png"),
    @XmlEnumValue("image/tiff")
    IMAGE_TIFF("image/tiff");
    private final String value;

    ImageMediaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ImageMediaType fromValue(String v) {
        for (ImageMediaType c: ImageMediaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
