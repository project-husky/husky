/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.validation.service.transform;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An URIResolver which resolves referenced entities relative to a given base.
 * The base can be specified either as a directory or a location string.
 * <p>
 * If the base is a directory, then the source is a file whose path is
 * constructed using base as its parent directory.
 * </p>
 * <p>
 * If base is a location string, then the source is a resource whose name is
 * constructed using base as prefix.
 * </p>
 * <p>
 * This URI resolver may be required by transformations in the following cases:
 * <ul>
 * <li>at stylesheet compilation time, when the XSL script includes or imports
 * any other XSL stylesheets.</li>
 * <li>at runtime, when the XSL script references some external entities like
 * localization files.</li>
 * </ul>
 * </p>
 */
public class StylesheetURIResolver implements URIResolver {

	private final Object base;

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	public StylesheetURIResolver(File baseDir) {
		this.base = baseDir.getAbsoluteFile();
	}

	public StylesheetURIResolver(String baseDir) {
		this.base = baseDir;
	}

	private Source getSource(String href) {
		if (base instanceof File) {
			final File file = new File((File) base, href);
			return new StreamSource(file);
		} else if (base instanceof String) {
			final String name = (String) base + File.separator + href;
			final StreamSource source = new StreamSource(getClass().getResourceAsStream(name));
			source.setSystemId(name);
			return source;
		}
		return null;
	}

	@Override
	public Source resolve(String href, String base) throws TransformerException {
		final Source source = getSource(href);
		final Object[] values = { href, source.getSystemId() };
		log.trace("Resolving href=\"{}\" to '{}'", values);
		return source;
	}

}
