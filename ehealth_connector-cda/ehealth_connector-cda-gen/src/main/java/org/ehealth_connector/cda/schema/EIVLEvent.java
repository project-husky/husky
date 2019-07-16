//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.08 um 04:56:31 PM CEST 
//


package org.ehealth_connector.cda.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				A code for a common (periodical) activity of daily
 * 				living based on which the event related periodic
 * 				interval is specified.
 * 			
 * 
 * <p>Java-Klasse für EIVL.event complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EIVL.event">
 *   &lt;complexContent>
 *     &lt;restriction base="{urn:hl7-org:v3}CE">
 *       &lt;attribute name="code" type="{urn:hl7-org:v3}TimingEvent" />
 *       &lt;attribute name="codeSystem" type="{urn:hl7-org:v3}uid" fixed="2.16.840.1.113883.5.139" />
 *       &lt;attribute name="codeSystemName" type="{urn:hl7-org:v3}st" fixed="TimingEvent" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EIVL.event")
public class EIVLEvent
    extends CE
{


}
