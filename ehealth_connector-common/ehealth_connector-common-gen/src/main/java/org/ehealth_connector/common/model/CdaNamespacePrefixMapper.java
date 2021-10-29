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
package org.ehealth_connector.common.model;

import java.util.HashMap;
import java.util.Map;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

/**
 * <div class="en">Implementation of {@link NamespacePrefixMapper} that maps the
 * schema namespaces more to readable names. Used by the jaxb marshaller.
 * Requires setting the property "com.sun.xml.bind.namespacePrefixMapper" to an
 * instance of this class.<div>
 *
 * <div class="de">Implementierung von {@link NamespacePrefixMapper}, das die
 * Schema-Namespaces besser lesbaren Namen zuordnet. Wird vom Jaxb Marshaller
 * benutzt. Erfordert das Setzen der Eigenschaft
 * "com.sun.xml.bind.namespacePrefixMapper" auf eine Instanz dieser Klasse.<div>
 */
public class CdaNamespacePrefixMapper
		extends com.sun.xml.bind.marshaller.NamespacePrefixMapper {

	/** The namespace map. */
	private Map<String, String> namespaceMap = new HashMap<>();

	/**
	 * <div class="en">Default constructor. Create the namespace mappings.<div>
	 *
	 * <div class="de">Standardkonstruktor. Erstellt die
	 * Namespace-Zuordnungen.<div>
	 */
	public CdaNamespacePrefixMapper() {
		namespaceMap.put("urn:hl7-org:v3", "hl7");
		namespaceMap.put("urn:ihe:pharm", "ihepharm");
		namespaceMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
	}

	/**
	 * <div class="en">Gets the preferred prefix.<div>
	 *
	 * <div class="de">Ruft den bevorzugten Prefix ab.<div>
	 *
	 * @param namespaceUri
	 *            the namespace uri
	 * @param suggestion
	 *            the suggestion
	 * @param requirePrefix
	 *            the require prefix
	 * @return the preferred prefix
	 */
	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion,
			boolean requirePrefix) {
		return namespaceMap.getOrDefault(namespaceUri, suggestion);
	}
}
