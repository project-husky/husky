//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.07.08 um 04:56:31 PM CEST 
//


package org.ehealth_connector.cda.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Note: because this type is defined as an extension of SXCM_T,
 * 				all of the attributes and elements accepted for T are also
 * 				accepted by this definition.  However, they are NOT allowed
 * 				by the normative description of this type.  Unfortunately,
 * 				we cannot write a general purpose schematron contraints to
 * 				provide that extra validation, thus applications must be
 * 				aware that instance (fragments) that pass validation with
 * 				this might might still not be legal.
 * 			
 * 
 * <p>Java-Klasse für PIVL_TS complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PIVL_TS">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}SXCM_TS">
 *       &lt;sequence>
 *         &lt;element name="phase" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *         &lt;element name="period" type="{urn:hl7-org:v3}PQ" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="alignment" type="{urn:hl7-org:v3}CalendarCycle" />
 *       &lt;attribute name="institutionSpecified" type="{urn:hl7-org:v3}bl" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PIVL_TS", propOrder = {
    "phase",
    "period"
})
public class PIVLTS
    extends SXCMTS
{

    protected IVLTS phase;
    protected PQ period;
    @XmlAttribute(name = "alignment")
    protected List<String> alignment;
    @XmlAttribute(name = "institutionSpecified")
    protected Boolean institutionSpecified;

    /**
     * Ruft den Wert der phase-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IVLTS }
     *     
     */
    public IVLTS getPhase() {
        return phase;
    }

    /**
     * Legt den Wert der phase-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IVLTS }
     *     
     */
    public void setPhase(IVLTS value) {
        this.phase = value;
    }

    /**
     * Ruft den Wert der period-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PQ }
     *     
     */
    public PQ getPeriod() {
        return period;
    }

    /**
     * Legt den Wert der period-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PQ }
     *     
     */
    public void setPeriod(PQ value) {
        this.period = value;
    }

    /**
     * Gets the value of the alignment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alignment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlignment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAlignment() {
        if (alignment == null) {
            alignment = new ArrayList<String>();
        }
        return this.alignment;
    }

    /**
     * Ruft den Wert der institutionSpecified-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isInstitutionSpecified() {
        if (institutionSpecified == null) {
            return false;
        } else {
            return institutionSpecified;
        }
    }

    /**
     * Legt den Wert der institutionSpecified-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInstitutionSpecified(Boolean value) {
        this.institutionSpecified = value;
    }

}
