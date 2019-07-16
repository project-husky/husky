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
 * 				The quantity data type is an abstract generalization
 * 				for all data types (1) whose value set has an order
 * 				relation (less-or-equal) and (2) where difference is
 * 				defined in all of the data type's totally ordered value
 * 				subsets.  The quantity type abstraction is needed in
 * 				defining certain other types, such as the interval and
 * 				the probability distribution.
 * 			
 * 
 * <p>Java-Klasse für QTY complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="QTY">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ANY">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QTY")
@XmlSeeAlso({
    RTOMOPQ.class,
    RTOPQPQ.class,
    RTOQTYQTY.class,
    REAL.class,
    PQ.class,
    MO.class,
    TS.class,
    INT.class,
    Quantity.class
})
public abstract class QTY
    extends ANY
{


}
