//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.04.30 um 04:58:07 AM CEST 
//


package org.ehealth_connector.validation.service.config.bind;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ApplicationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ApplicationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="downloads-url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jquery-theme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="document-schema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pdf-level" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pdf-reporting-level" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="license-key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minimal-memory-sch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insufficient-memory-reaction" type="{}InsufficientMemoryReaction" minOccurs="0"/>
 *         &lt;element name="timeout-sleep-ms" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="timeout-max-s" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="timeout-reaction" type="{}MaxWaitReaction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationType", propOrder = {
    "downloadsUrl",
    "jqueryTheme",
    "documentSchema",
    "pdfLevel",
    "pdfReportingLevel",
    "licenseKey",
    "minimalMemorySch",
    "insufficientMemoryReaction",
    "timeoutSleepMs",
    "timeoutMaxS",
    "timeoutReaction"
})
public class ApplicationType {

    @XmlElement(name = "downloads-url")
    protected String downloadsUrl;
    @XmlElement(name = "jquery-theme")
    protected String jqueryTheme;
    @XmlElement(name = "document-schema")
    protected String documentSchema;
    @XmlElement(name = "pdf-level")
    protected String pdfLevel;
    @XmlElement(name = "pdf-reporting-level")
    protected String pdfReportingLevel;
    @XmlElement(name = "license-key")
    protected String licenseKey;
    @XmlElement(name = "minimal-memory-sch")
    protected String minimalMemorySch;
    @XmlElement(name = "insufficient-memory-reaction")
    @XmlSchemaType(name = "string")
    protected InsufficientMemoryReaction insufficientMemoryReaction;
    @XmlElement(name = "timeout-sleep-ms")
    protected Integer timeoutSleepMs;
    @XmlElement(name = "timeout-max-s")
    protected Integer timeoutMaxS;
    @XmlElement(name = "timeout-reaction")
    @XmlSchemaType(name = "string")
    protected MaxWaitReaction timeoutReaction;

    /**
     * Ruft den Wert der downloadsUrl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    /**
     * Legt den Wert der downloadsUrl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadsUrl(String value) {
        this.downloadsUrl = value;
    }

    /**
     * Ruft den Wert der jqueryTheme-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJqueryTheme() {
        return jqueryTheme;
    }

    /**
     * Legt den Wert der jqueryTheme-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJqueryTheme(String value) {
        this.jqueryTheme = value;
    }

    /**
     * Ruft den Wert der documentSchema-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentSchema() {
        return documentSchema;
    }

    /**
     * Legt den Wert der documentSchema-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentSchema(String value) {
        this.documentSchema = value;
    }

    /**
     * Ruft den Wert der pdfLevel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdfLevel() {
        return pdfLevel;
    }

    /**
     * Legt den Wert der pdfLevel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdfLevel(String value) {
        this.pdfLevel = value;
    }

    /**
     * Ruft den Wert der pdfReportingLevel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdfReportingLevel() {
        return pdfReportingLevel;
    }

    /**
     * Legt den Wert der pdfReportingLevel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdfReportingLevel(String value) {
        this.pdfReportingLevel = value;
    }

    /**
     * Ruft den Wert der licenseKey-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseKey() {
        return licenseKey;
    }

    /**
     * Legt den Wert der licenseKey-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseKey(String value) {
        this.licenseKey = value;
    }

    /**
     * Ruft den Wert der minimalMemorySch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinimalMemorySch() {
        return minimalMemorySch;
    }

    /**
     * Legt den Wert der minimalMemorySch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinimalMemorySch(String value) {
        this.minimalMemorySch = value;
    }

    /**
     * Ruft den Wert der insufficientMemoryReaction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InsufficientMemoryReaction }
     *     
     */
    public InsufficientMemoryReaction getInsufficientMemoryReaction() {
        return insufficientMemoryReaction;
    }

    /**
     * Legt den Wert der insufficientMemoryReaction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InsufficientMemoryReaction }
     *     
     */
    public void setInsufficientMemoryReaction(InsufficientMemoryReaction value) {
        this.insufficientMemoryReaction = value;
    }

    /**
     * Ruft den Wert der timeoutSleepMs-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimeoutSleepMs() {
        return timeoutSleepMs;
    }

    /**
     * Legt den Wert der timeoutSleepMs-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimeoutSleepMs(Integer value) {
        this.timeoutSleepMs = value;
    }

    /**
     * Ruft den Wert der timeoutMaxS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimeoutMaxS() {
        return timeoutMaxS;
    }

    /**
     * Legt den Wert der timeoutMaxS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimeoutMaxS(Integer value) {
        this.timeoutMaxS = value;
    }

    /**
     * Ruft den Wert der timeoutReaction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MaxWaitReaction }
     *     
     */
    public MaxWaitReaction getTimeoutReaction() {
        return timeoutReaction;
    }

    /**
     * Legt den Wert der timeoutReaction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MaxWaitReaction }
     *     
     */
    public void setTimeoutReaction(MaxWaitReaction value) {
        this.timeoutReaction = value;
    }

}
