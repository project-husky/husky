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

package org.projecthusky.common.hl7cdar2;

import org.checkerframework.checker.nullness.qual.NonNull;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Java-Klasse für StrucDoc.Th complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="StrucDoc.Th"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="content" type="{urn:hl7-org:v3}StrucDoc.Content"/&gt;
 *         &lt;element name="linkHtml" type="{urn:hl7-org:v3}StrucDoc.LinkHtml"/&gt;
 *         &lt;element name="sub" type="{urn:hl7-org:v3}StrucDoc.Sub"/&gt;
 *         &lt;element name="sup" type="{urn:hl7-org:v3}StrucDoc.Sup"/&gt;
 *         &lt;element name="br" type="{urn:hl7-org:v3}StrucDoc.Br"/&gt;
 *         &lt;element name="footnote" type="{urn:hl7-org:v3}StrucDoc.Footnote"/&gt;
 *         &lt;element name="footnoteRef" type="{urn:hl7-org:v3}StrucDoc.FootnoteRef"/&gt;
 *         &lt;element name="renderMultiMedia" type="{urn:hl7-org:v3}StrucDoc.RenderMultiMedia"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="language" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *       &lt;attribute name="styleCode" type="{http://www.w3.org/2001/XMLSchema}NMTOKENS" /&gt;
 *       &lt;attribute name="abbr" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="axis" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="headers" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
 *       &lt;attribute name="scope"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="row"/&gt;
 *             &lt;enumeration value="col"/&gt;
 *             &lt;enumeration value="rowgroup"/&gt;
 *             &lt;enumeration value="colgroup"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute>
 *       &lt;attribute name="rowspan" type="{http://www.w3.org/2001/XMLSchema}string" default="1" /&gt;
 *       &lt;attribute name="colspan" type="{http://www.w3.org/2001/XMLSchema}string" default="1" /&gt;
 *       &lt;attribute name="align"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="left"/&gt;
 *             &lt;enumeration value="center"/&gt;
 *             &lt;enumeration value="right"/&gt;
 *             &lt;enumeration value="justify"/&gt;
 *             &lt;enumeration value="char"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute>
 *       &lt;attribute name="char" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="charoff" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="valign"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="top"/&gt;
 *             &lt;enumeration value="middle"/&gt;
 *             &lt;enumeration value="bottom"/&gt;
 *             &lt;enumeration value="baseline"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute>
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StrucDoc.Th", propOrder = {"content"})
public class StrucDocTh {

    @XmlElementRefs({
            @XmlElementRef(name = "sup", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "footnoteRef", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "content", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "renderMultiMedia", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "footnote", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "linkHtml", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "br", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "sub", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false)})
    @XmlMixed
    protected List<Serializable> content;
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
    @XmlAttribute(name = "abbr")
    protected String abbr;
    @XmlAttribute(name = "axis")
    protected String axis;
    @XmlAttribute(name = "headers")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> headers;
    @XmlAttribute(name = "scope")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String scope;
    @XmlAttribute(name = "rowspan")
    protected String rowspan;
    @XmlAttribute(name = "colspan")
    protected String colspan;
    @XmlAttribute(name = "align")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String align;
    @XmlAttribute(name = "char")
    protected String _char;
    @XmlAttribute(name = "charoff")
    protected String charoff;
    @XmlAttribute(name = "valign")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String valign;

    /**
     * Ruft den Wert der abbr-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getAbbr() {
        return abbr;
    }

    /**
     * Ruft den Wert der align-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getAlign() {
        return align;
    }

    /**
     * Ruft den Wert der axis-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getAxis() {
        return axis;
    }

    /**
     * Ruft den Wert der char-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getChar() {
        return _char;
    }

    /**
     * Ruft den Wert der charoff-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getCharoff() {
        return charoff;
    }

    /**
     * Ruft den Wert der colspan-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    @NonNull
    public String getColspan() {
        if (colspan == null) {
            return "1";
        } else {
            return colspan;
        }
    }

    /**
     * Gets the value of the content property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the content property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link StrucDocSup }{@code
     * >} {@link JAXBElement }{@code <}{@link StrucDocFootnoteRef }{@code >} {@link JAXBElement }{@code <}{@link
     * StrucDocContent }{@code >} {@link JAXBElement }{@code <}{@link StrucDocRenderMultiMedia }{@code >} {@link
     * JAXBElement }{@code <}{@link StrucDocFootnote }{@code >} {@link String } {@link JAXBElement }{@code <}{@link
     * StrucDocLinkHtml }{@code >} {@link JAXBElement }{@code <}{@link StrucDocBr }{@code >} {@link JAXBElement }{@code
     * <}{@link StrucDocSub }{@code >}
     */
    @NonNull
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<>();
        }
        return this.content;
    }

    /**
     * Gets the value of the headers property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the headers property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getHeaders().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Object }
     */
    @NonNull
    public List<Object> getHeaders() {
        if (headers == null) {
            headers = new ArrayList<>();
        }
        return this.headers;
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
     * Ruft den Wert der rowspan-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    @NonNull
    public String getRowspan() {
        if (rowspan == null) {
            return "1";
        } else {
            return rowspan;
        }
    }

    /**
     * Ruft den Wert der scope-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getScope() {
        return scope;
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
     * Ruft den Wert der valign-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     */
    public String getValign() {
        return valign;
    }

    /**
     * Legt den Wert der abbr-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setAbbr(String value) {
        this.abbr = value;
    }

    /**
     * Legt den Wert der align-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setAlign(String value) {
        this.align = value;
    }

    /**
     * Legt den Wert der axis-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setAxis(String value) {
        this.axis = value;
    }

    /**
     * Legt den Wert der char-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setChar(String value) {
        this._char = value;
    }

    /**
     * Legt den Wert der charoff-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setCharoff(String value) {
        this.charoff = value;
    }

    /**
     * Legt den Wert der colspan-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setColspan(String value) {
        this.colspan = value;
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
     * Legt den Wert der rowspan-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setRowspan(String value) {
        this.rowspan = value;
    }

    /**
     * Legt den Wert der scope-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Legt den Wert der valign-Eigenschaft fest.
     *
     * @param value allowed object is {@link String }
     */
    public void setValign(String value) {
        this.valign = value;
    }

}
