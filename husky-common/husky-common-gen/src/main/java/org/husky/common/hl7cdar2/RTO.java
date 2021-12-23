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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * A quantity constructed as the quotient of a numerator quantity divided by a denominator quantity. Common factors in
 * the numerator and denominator are not automatically cancelled out. RTO supports titers (e.g., "1:128") and other
 * quantities produced by laboratories that truly represent ratios. Ratios are not simply "structured numerics",
 * particularly blood pressure measurements (e.g. "120/60") are not ratios. In many cases REAL should be used instead of
 * RTO.
 *
 *
 * <p>
 * Java-Klasse für RTO complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType name="RTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:v3}RTO_QTY_QTY"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTO")
public class RTO extends RTOQTYQTY {

}
