package org.husky.valueset.model;

import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;

public class CustomNamespaceContext implements NamespaceContext {

	@Override
	public Iterator<String> getPrefixes(String namespaceURI) {
		return null;
	}

	@Override
	public String getPrefix(String namespaceURI) {
		return null;
	}

	@Override
	public String getNamespaceURI(String prefix) {
		if ("ihesvs".equals(prefix) || "".equals(prefix)) {
			return "urn:ihe:iti:svs:2008";
		} else if ("xsi".equals(prefix)) {
			return "http://www.w3.org/2001/XMLSchema-instance";
		}
		return null;
	}

}
