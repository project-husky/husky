/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;

public class Xml2Html {

	public static StreamResult convertXMLToHTML(Source xml) {
		StreamResult retVal = new StreamResult(new StringWriter());

		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Source xslt = tFactory.getAssociatedStylesheet(xml, null, null, null);
			if (xslt == null) {
				// TODO
			}
			Transformer transform = tFactory.newTransformer(xslt);
			transform.transform(xml, retVal);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return retVal;

	}

	public static StreamResult convertXMLToHTML(Source xml, Source xslt) {
		StreamResult retVal = new StreamResult(new StringWriter());

		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transform = tFactory.newTransformer(xslt);
			transform.transform(xml, retVal);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return retVal;

	}
}