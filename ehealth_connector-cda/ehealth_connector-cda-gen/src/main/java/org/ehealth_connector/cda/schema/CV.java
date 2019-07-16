//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.08 um 04:56:31 PM CEST 
//


package org.ehealth_connector.cda.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Coded data, consists of a code, display name, code system,
 * 				and original text. Used when a single code value must be sent.
 * 			
 * 
 * <p>Java-Klasse für CV complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CV">
 *   &lt;complexContent>
 *     &lt;restriction base="{urn:hl7-org:v3}CE">
 *       &lt;sequence>
 *         &lt;element name="originalText" type="{urn:hl7-org:v3}ED" minOccurs="0"/>
 *         &lt;element name="translation" type="{urn:hl7-org:v3}CD" maxOccurs="0" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" type="{urn:hl7-org:v3}cs" />
 *       &lt;attribute name="codeSystem" type="{urn:hl7-org:v3}uid" />
 *       &lt;attribute name="codeSystemName" type="{urn:hl7-org:v3}st" />
 *       &lt;attribute name="codeSystemVersion" type="{urn:hl7-org:v3}st" />
 *       &lt;attribute name="displayName" type="{urn:hl7-org:v3}st" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CV")
@XmlSeeAlso({
    CO.class,
    CS.class,
    PQR.class
})
public class CV
    extends CE
{


}
