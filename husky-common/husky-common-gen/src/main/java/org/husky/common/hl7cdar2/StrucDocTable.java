/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2020.07.09 um 01:07:39 PM CEST
//

package org.husky.common.hl7cdar2;

import org.checkerframework.checker.nullness.qual.NonNull;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für StrucDoc.Table complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="StrucDoc.Table"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="caption" type="{urn:hl7-org:v3}StrucDoc.Caption" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="col" type="{urn:hl7-org:v3}StrucDoc.Col" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element name="colgroup" type="{urn:hl7-org:v3}StrucDoc.Colgroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="thead" type="{urn:hl7-org:v3}StrucDoc.Thead" minOccurs="0"/&gt;
 *         &lt;element name="tfoot" type="{urn:hl7-org:v3}StrucDoc.Tfoot" minOccurs="0"/&gt;
 *         &lt;element name="tbody" type="{urn:hl7-org:v3}StrucDoc.Tbody" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *       &lt;attribute name="styleCode" type="{http://www.w3.org/2001/XMLSchema}NMTOKENS" /&gt;
 *       &lt;attribute name="summary" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="border" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="frame"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="void"/&gt;
 *             &lt;enumeration value="above"/&gt;
 *             &lt;enumeration value="below"/&gt;
 *             &lt;enumeration value="hsides"/&gt;
 *             &lt;enumeration value="lhs"/&gt;
 *             &lt;enumeration value="rhs"/&gt;
 *             &lt;enumeration value="vsides"/&gt;
 *             &lt;enumeration value="box"/&gt;
 *             &lt;enumeration value="border"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute>
 *       &lt;attribute name="rules"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="none"/&gt;
 *             &lt;enumeration value="groups"/&gt;
 *             &lt;enumeration value="rows"/&gt;
 *             &lt;enumeration value="cols"/&gt;
 *             &lt;enumeration value="all"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute>
 *       &lt;attribute name="cellspacing" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="cellpadding" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StrucDoc.Table", propOrder = {"caption", "col", "colgroup", "thead", "tfoot",
        "tbody"})
public class StrucDocTable {

    protected StrucDocCaption caption;
    protected List<StrucDocCol> col;
    protected List<StrucDocColgroup> colgroup;
    protected StrucDocThead thead;
    protected StrucDocTfoot tfoot;
    @XmlElement(required = true)
    protected List<StrucDocTbody> tbody;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "language")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String language;
    @XmlAttribute(name = "styleCode")
    @XmlSchemaType(name = "NMTOKENS")
    protected List<String> styleCode;
    @XmlAttribute(name = "summary")
    protected String summary;
    @XmlAttribute(name = "width")
    protected String width;
    @XmlAttribute(name = "border")
    protected String border;
    @XmlAttribute(name = "frame")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String frame;
    @XmlAttribute(name = "rules")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String rules;
    @XmlAttribute(name = "cellspacing")
    protected String cellspacing;
    @XmlAttribute(name = "cellpadding")
    protected String cellpadding;

    /**
     * Ruft den Wert der border-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getBorder() {
        return border;
    }

    /**
     * Ruft den Wert der caption-Eigenschaft ab.
     *
     * @return possible object is {@link StrucDocCaption }
     */
    public StrucDocCaption getCaption() {
        return caption;
    }

    /**
     * Ruft den Wert der cellpadding-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getCellpadding() {
        return cellpadding;
    }

    /**
     * Ruft den Wert der cellspacing-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getCellspacing() {
        return cellspacing;
    }

    /**
     * Gets the value of the col property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the col property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getCol().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link StrucDocCol }
     */
    @NonNull
    public List<StrucDocCol> getCol() {
        if (col == null) {
            col = new ArrayList<>();
        }
        return this.col;
    }

    /**
     * Gets the value of the colgroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the colgroup property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getColgroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link StrucDocColgroup }
     */
    @NonNull
    public List<StrucDocColgroup> getColgroup() {
        if (colgroup == null) {
            colgroup = new ArrayList<>();
        }
        return this.colgroup;
    }

    /**
     * Ruft den Wert der frame-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getFrame() {
        return frame;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getID() {
        return id;
    }

    /**
     * Ruft den Wert der language-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Ruft den Wert der rules-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getRules() {
        return rules;
    }

    /**
     * Gets the value of the styleCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the styleCode property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getStyleCode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    @NonNull
    public List<String> getStyleCode() {
        if (styleCode == null) {
            styleCode = new ArrayList<>();
        }
        return this.styleCode;
    }

    /**
     * Ruft den Wert der summary-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Gets the value of the tbody property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the tbody property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getTbody().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link StrucDocTbody }
     */
    @NonNull
    public List<StrucDocTbody> getTbody() {
        if (tbody == null) {
            tbody = new ArrayList<>();
        }
        return this.tbody;
    }

    /**
     * Ruft den Wert der tfoot-Eigenschaft ab.
     *
     * @return possible object is {@link StrucDocTfoot }
     */
    public StrucDocTfoot getTfoot() {
        return tfoot;
    }

    /**
     * Ruft den Wert der thead-Eigenschaft ab.
     *
     * @return possible object is {@link StrucDocThead }
     */
    public StrucDocThead getThead() {
        return thead;
    }

    /**
     * Ruft den Wert der width-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getWidth() {
        return width;
    }

    /**
     * Legt den Wert der border-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setBorder(String value) {
        this.border = value;
    }

    /**
     * Legt den Wert der caption-Eigenschaft fest.
     *
     * @param value allowed object is {@link StrucDocCaption }
     */
    public void setCaption(StrucDocCaption value) {
        this.caption = value;
    }

    /**
     * Legt den Wert der cellpadding-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setCellpadding(String value) {
        this.cellpadding = value;
    }

    /**
     * Legt den Wert der cellspacing-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setCellspacing(String value) {
        this.cellspacing = value;
    }

    /**
     * Legt den Wert der frame-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setFrame(String value) {
        this.frame = value;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Legt den Wert der language-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Legt den Wert der rules-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setRules(String value) {
        this.rules = value;
    }

    /**
     * Legt den Wert der summary-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * Legt den Wert der tfoot-Eigenschaft fest.
     *
     * @param value allowed object is {@link StrucDocTfoot }
     */
    public void setTfoot(StrucDocTfoot value) {
        this.tfoot = value;
    }

    /**
     * Legt den Wert der thead-Eigenschaft fest.
     *
     * @param value allowed object is {@link StrucDocThead }
     */
    public void setThead(StrucDocThead value) {
        this.thead = value;
    }

    /**
     * Legt den Wert der width-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setWidth(String value) {
        this.width = value;
    }

}
