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
package org.ehealth_connector.cda.utils;

import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

/**
 * <div class="en">This class contains methods for the XML converion to
 * HTML.</div> <div class="de">Diese Klasse enthält verschiedene Methoden zur
 * Konvertierung von XML nach HTML.</div>
 *
 */
public class Xml2Html {

	/**
	 * <div class="en">Converts an XML containing xml-stylesheet processing
	 * instruction(s) to HTML as stream.</div>
	 *
	 * @param xml
	 *            <div class="en">the xml.</div>
	 * @return <div class="en">the generated HTML as stream result</div>
	 * @throws TransformerException
	 *             <div class="en">Signals that a transformer exception has
	 *             occurred.</div>
	 *
	 */
	public static StreamResult convertXMLToHTML(Source xml) throws TransformerException {
		StreamResult retVal = new StreamResult(new StringWriter());

		TransformerFactory tFactory = TransformerFactory.newInstance();
		Source xslt = tFactory.getAssociatedStylesheet(xml, null, null, null);
		Transformer transform = tFactory.newTransformer(xslt);
		transform.transform(xml, retVal);
		return retVal;

	}

	/**
	 * <div class="en">Converts an XML to HTML as stream by applying the given
	 * stylesheet. xml-stylesheet processing instruction(s) within the xml are
	 * ignored.</div>
	 *
	 * @param xml
	 *            <div class="en">the xml.</div>
	 * @param xslt
	 *            <div class="en">the xslt to be applied.</div>
	 * @return <div class="en">the generated HTML as stream result</div>
	 * @throws TransformerException
	 *             <div class="en">Signals that a transformer exception has
	 *             occurred.</div>
	 */
	public static StreamResult convertXMLToHTML(Source xml, Source xslt)
			throws TransformerException {
		StreamResult retVal = new StreamResult(new StringWriter());

		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transform = tFactory.newTransformer(xslt);
		transform.transform(xml, retVal);
		return retVal;

	}
}