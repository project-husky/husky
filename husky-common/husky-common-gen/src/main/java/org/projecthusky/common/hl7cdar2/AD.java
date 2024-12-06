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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Mailing and home or office addresses. A sequence of address parts, such as street or post office Box, city, postal
 * code, country, etc.
 *
 *
 * <p>
 * Java-Klasse für AD complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="AD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}ANY"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="delimiter" type="{urn:hl7-org:v3}adxp.delimiter"/&gt;
 *           &lt;element name="country" type="{urn:hl7-org:v3}adxp.country"/&gt;
 *           &lt;element name="state" type="{urn:hl7-org:v3}adxp.state"/&gt;
 *           &lt;element name="county" type="{urn:hl7-org:v3}adxp.county"/&gt;
 *           &lt;element name="city" type="{urn:hl7-org:v3}adxp.city"/&gt;
 *           &lt;element name="postalCode" type="{urn:hl7-org:v3}adxp.postalCode"/&gt;
 *           &lt;element name="streetAddressLine" type="{urn:hl7-org:v3}adxp.streetAddressLine"/&gt;
 *           &lt;element name="houseNumber" type="{urn:hl7-org:v3}adxp.houseNumber"/&gt;
 *           &lt;element name="houseNumberNumeric" type="{urn:hl7-org:v3}adxp.houseNumberNumeric"/&gt;
 *           &lt;element name="direction" type="{urn:hl7-org:v3}adxp.direction"/&gt;
 *           &lt;element name="streetName" type="{urn:hl7-org:v3}adxp.streetName"/&gt;
 *           &lt;element name="streetNameBase" type="{urn:hl7-org:v3}adxp.streetNameBase"/&gt;
 *           &lt;element name="streetNameType" type="{urn:hl7-org:v3}adxp.streetNameType"/&gt;
 *           &lt;element name="additionalLocator" type="{urn:hl7-org:v3}adxp.additionalLocator"/&gt;
 *           &lt;element name="unitID" type="{urn:hl7-org:v3}adxp.unitID"/&gt;
 *           &lt;element name="unitType" type="{urn:hl7-org:v3}adxp.unitType"/&gt;
 *           &lt;element name="careOf" type="{urn:hl7-org:v3}adxp.careOf"/&gt;
 *           &lt;element name="censusTract" type="{urn:hl7-org:v3}adxp.censusTract"/&gt;
 *           &lt;element name="deliveryAddressLine" type="{urn:hl7-org:v3}adxp.deliveryAddressLine"/&gt;
 *           &lt;element name="deliveryInstallationType" type="{urn:hl7-org:v3}adxp.deliveryInstallationType"/&gt;
 *           &lt;element name="deliveryInstallationArea" type="{urn:hl7-org:v3}adxp.deliveryInstallationArea"/&gt;
 *           &lt;element name="deliveryInstallationQualifier" type="{urn:hl7-org:v3}adxp.deliveryInstallationQualifier"/&gt;
 *           &lt;element name="deliveryMode" type="{urn:hl7-org:v3}adxp.deliveryMode"/&gt;
 *           &lt;element name="deliveryModeIdentifier" type="{urn:hl7-org:v3}adxp.deliveryModeIdentifier"/&gt;
 *           &lt;element name="buildingNumberSuffix" type="{urn:hl7-org:v3}adxp.buildingNumberSuffix"/&gt;
 *           &lt;element name="postBox" type="{urn:hl7-org:v3}adxp.postBox"/&gt;
 *           &lt;element name="precinct" type="{urn:hl7-org:v3}adxp.precinct"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="useablePeriod" type="{urn:hl7-org:v3}SXCM_TS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="use" type="{urn:hl7-org:v3}set_PostalAddressUse" /&gt;
 *       &lt;attribute name="isNotOrdered" type="{urn:hl7-org:v3}bl" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AD", propOrder = {"content"})
// Fix Tony Schaller, medshare GmbH: is an extension of ANY
// (see datatypes-base.xsd)
public class AD extends ANY {

    @XmlElementRefs({
            @XmlElementRef(name = "additionalLocator", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "postBox", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "houseNumberNumeric", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "deliveryInstallationType", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "careOf", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "postalCode", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "streetName", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "deliveryAddressLine", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "city", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "streetAddressLine", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "unitID", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "precinct", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "deliveryInstallationArea", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "state", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "streetNameBase", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "country", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "censusTract", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "deliveryModeIdentifier", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "useablePeriod", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "delimiter", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "deliveryInstallationQualifier", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "houseNumber", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "deliveryMode", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "county", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "direction", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "streetNameType", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "buildingNumberSuffix", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "unitType", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false)})
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "isNotOrdered")
    protected Boolean isNotOrdered;
    @XmlAttribute(name = "use")
    protected List<String> use;

    /**
     * Mailing and home or office addresses. A sequence of address parts, such as street or post office Box, city,
     * postal code, country, etc. Gets the value of the content property.
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
     * Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link
     * AdxpAdditionalLocator }{@code >} {@link JAXBElement }{@code <}{@link AdxpPostBox }{@code >} {@link JAXBElement
     * }{@code <}{@link AdxpHouseNumberNumeric }{@code >} {@link JAXBElement }{@code <}{@link
     * AdxpDeliveryInstallationType }{@code >} {@link JAXBElement }{@code <}{@link AdxpCareOf }{@code >} {@link
     * JAXBElement }{@code <}{@link AdxpPostalCode }{@code >} {@link JAXBElement }{@code <}{@link AdxpStreetName }{@code
     * >} {@link JAXBElement }{@code <}{@link AdxpDeliveryAddressLine }{@code >} {@link JAXBElement }{@code <}{@link
     * AdxpCity }{@code >} {@link JAXBElement }{@code <}{@link AdxpStreetAddressLine }{@code >} {@link JAXBElement
     * }{@code <}{@link AdxpUnitID }{@code >} {@link JAXBElement }{@code <}{@link AdxpPrecinct }{@code >} {@link String
     * } {@link JAXBElement }{@code <}{@link AdxpDeliveryInstallationArea }{@code >} {@link JAXBElement }{@code <}{@link
     * AdxpState }{@code >} {@link JAXBElement }{@code <}{@link AdxpStreetNameBase }{@code >} {@link JAXBElement }{@code
     * <}{@link AdxpCountry }{@code >} {@link JAXBElement }{@code <}{@link AdxpCensusTract }{@code >} {@link JAXBElement
     * }{@code <}{@link AdxpDeliveryModeIdentifier }{@code >} {@link JAXBElement }{@code <}{@link SXCMTS }{@code >}
     * {@link JAXBElement }{@code <}{@link AdxpDelimiter }{@code >} {@link JAXBElement }{@code <}{@link
     * AdxpDeliveryInstallationQualifier }{@code >} {@link JAXBElement }{@code <}{@link AdxpHouseNumber }{@code >}
     * {@link JAXBElement }{@code <}{@link AdxpDeliveryMode }{@code >} {@link JAXBElement }{@code <}{@link AdxpCounty
     * }{@code >} {@link JAXBElement }{@code <}{@link AdxpDirection }{@code >} {@link JAXBElement }{@code <}{@link
     * AdxpStreetNameType }{@code >} {@link JAXBElement }{@code <}{@link AdxpBuildingNumberSuffix }{@code >} {@link
     * JAXBElement }{@code <}{@link AdxpUnitType }{@code >}
     */
    @NonNull
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<>();
        }
        return this.content;
    }

    /**
     * Gets the value of the use property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the use property.
     *
     * <p>
     * For example, to add a new item, do as follows: <pre>
     *    getUse().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    @NonNull
    public List<String> getUse() {
        if (use == null) {
            use = new ArrayList<>();
        }
        return this.use;
    }

    /**
     * Ruft den Wert der isNotOrdered-Eigenschaft ab.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isIsNotOrdered() {
        return isNotOrdered;
    }

    /**
     * Legt den Wert der isNotOrdered-Eigenschaft fest.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setIsNotOrdered(Boolean value) {
        this.isNotOrdered = value;
    }

}
