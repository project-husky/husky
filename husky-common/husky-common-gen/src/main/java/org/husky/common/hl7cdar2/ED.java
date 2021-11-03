/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren.
// Generiert: 2020.07.09 um 01:07:39 PM CEST
//

package org.husky.common.hl7cdar2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

/**
 *
 * Data that is primarily intended for human interpretation or for further
 * machine processing is outside the scope of HL7. This includes unformatted or
 * formatted written language, multimedia data, or structured information as
 * defined by a different standard (e.g., XML-signatures.) Instead of the data
 * itself, an ED may contain only a reference (see TEL.) Note that the ST data
 * type is a specialization of the ED data type when the ED media type is
 * text/plain.
 *
 *
 * <p>
 * Java-Klasse für ED complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser
 * Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="ED">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}BIN">
 *       &lt;sequence>
 *         &lt;element name="reference" type="{urn:hl7-org:v3}TEL" minOccurs="0"/>
 *         &lt;element name="thumbnail" type="{urn:hl7-org:v3}thumbnail" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="mediaType" type="{urn:hl7-org:v3}cs" default="text/plain" />
 *       &lt;attribute name="language" type="{urn:hl7-org:v3}cs" />
 *       &lt;attribute name="compression" type="{urn:hl7-org:v3}CompressionAlgorithm" />
 *       &lt;attribute name="integrityCheck" type="{urn:hl7-org:v3}bin" />
 *       &lt;attribute name="integrityCheckAlgorithm" type="{urn:hl7-org:v3}IntegrityCheckAlgorithm" default="SHA-1" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ED", propOrder = { "reference", "thumbnail" })
@XmlSeeAlso({ Thumbnail.class, ST.class })
public class ED extends BIN {

    protected TEL reference;
    protected Thumbnail thumbnail;
    @XmlAttribute(name = "mediaType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mediaType;
    @XmlAttribute(name = "language")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String language;
    @XmlAttribute(name = "compression")
    protected CompressionAlgorithm compression;
    @XmlAttribute(name = "integrityCheck")
    protected byte[] integrityCheck;
    @XmlAttribute(name = "integrityCheckAlgorithm")
    protected IntegrityCheckAlgorithm integrityCheckAlgorithm;

    public ED() {}

    public ED(final String ed) {
        this.setXmlMixed(ed);
    }

    /**
     * Ruft den Wert der compression-Eigenschaft ab.
     *
     * @return possible object is {@link CompressionAlgorithm }
     *
     */
    public CompressionAlgorithm getCompression() {
        return compression;
    }

    /**
     * Ruft den Wert der integrityCheck-Eigenschaft ab.
     *
     * @return possible object is byte[]
     */
    public byte[] getIntegrityCheck() {
        return integrityCheck;
    }

    /**
     * Ruft den Wert der integrityCheckAlgorithm-Eigenschaft ab.
     *
     * @return possible object is {@link IntegrityCheckAlgorithm }
     *
     */
    public IntegrityCheckAlgorithm getIntegrityCheckAlgorithm() {
        if (integrityCheckAlgorithm == null) {
            return IntegrityCheckAlgorithm.SHA_1;
        } else {
            return integrityCheckAlgorithm;
        }
    }

    /**
     * Ruft den Wert der language-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Ruft den Wert der mediaType-Eigenschaft ab.
     *
     * @return possible object is {@link String }
     *
     */
    public String getMediaType() {
        if (mediaType == null) {
            return "text/plain";
        } else {
            return mediaType;
        }
    }

    /**
     * Ruft den Wert der reference-Eigenschaft ab.
     *
     * @return possible object is {@link TEL }
     *
     */
    public TEL getReference() {
        return reference;
    }

    /**
     * Ruft den Wert der thumbnail-Eigenschaft ab.
     *
     * @return possible object is {@link Thumbnail }
     *
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * Returns the text content of the ED.
     *
     * @return a string.
     */
    public String getTextContent() {
        if (this.getXmlMixed() == null) {
            return "";
        }
        final var strings = this.getXmlMixed().stream()
                .filter(Objects::nonNull)
                .map(String::strip)
                .filter(string -> !string.isEmpty())
                .toList();
        if (strings.isEmpty()) {
            return "";
        } else {
            return String.join(" ", strings).strip();
        }
    }

    /**
     * Legt den Wert der compression-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link CompressionAlgorithm }
     *
     */
    public void setCompression(CompressionAlgorithm value) {
        this.compression = value;
    }

    /**
     * Legt den Wert der integrityCheck-Eigenschaft fest.
     *
     * @param value
     *            allowed object is byte[]
     */
    public void setIntegrityCheck(byte[] value) {
        this.integrityCheck = value;
    }

    /**
     * Legt den Wert der integrityCheckAlgorithm-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link IntegrityCheckAlgorithm }
     *
     */
    public void setIntegrityCheckAlgorithm(IntegrityCheckAlgorithm value) {
        this.integrityCheckAlgorithm = value;
    }

    /**
     * Legt den Wert der language-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Legt den Wert der mediaType-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setMediaType(String value) {
        this.mediaType = value;
    }

    /**
     * Legt den Wert der reference-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link TEL }
     *
     */
    public void setReference(TEL value) {
        this.reference = value;
    }

    /**
     * Legt den Wert der thumbnail-Eigenschaft fest.
     *
     * @param value
     *            allowed object is {@link Thumbnail }
     *
     */
    public void setThumbnail(Thumbnail value) {
        this.thumbnail = value;
    }
}
