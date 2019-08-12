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

package org.ehealth_connector.validation.service.transform;

import java.io.File;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XsltCompiler;
import net.sf.saxon.s9api.XsltExecutable;

/**
 * Represents an immutable XSL stylesheet element.
 *
 * <h4>Thread Safety</h4>
 * <p>
 * This class is immutable and therefore thread-safe.
 * </p>
 */
public class Stylesheet {

	/**
	 * Factory method to create a new stylesheet.
	 *
	 * @param file
	 *            a valid reference to the stylesheet file.
	 * @param compiler
	 *            a reference to the <cite>Saxon</cite> XSLT compiler.
	 * @return a new pre-compiled stylesheet instance.
	 * @throws TransformationException
	 *             if the stylesheet contains static errors or if it cannot be
	 *             read.
	 * @throws NullPointerException
	 *             if either the specified file or XSLT compiler is
	 *             <tt>null</tt>.
	 */
	public static Stylesheet createInstance(File file, XsltCompiler compiler)
			throws TransformationException {
		return new Stylesheet(file).compile(compiler);
	}

	private final ErrorListener errorListener = new TransformerErrorListener();

	/** The compiled form of the stylesheet. Immutable and thread-safe. */
	private XsltExecutable executable;

	private final File file;

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Constructs a new stylesheet.
	 *
	 * @param file
	 *            a valid reference to the stylesheet file.
	 * @throws NullPointerException
	 *             if the specified file is <tt>null</tt>.
	 */
	private Stylesheet(File file) {
		if (file == null) {
			throw new NullPointerException("File is null.");
		}
		this.file = file;
	}

	/**
	 * Compiles the underlying stylesheet.
	 *
	 * @param compiler
	 *            a reference to the <cite>Saxon</cite> XSLT compiler.
	 * @return this stylesheet instance.
	 * @throws TransformationException
	 *             if the stylesheet contains static errors or if it cannot be
	 *             read.
	 * @throws NullPointerException
	 *             if the specified XSLT compiler is <tt>null</tt>.
	 */
	private Stylesheet compile(XsltCompiler compiler) throws TransformationException {
		if (compiler == null) {
			throw new NullPointerException("XSLT compiler is null.");
		} else if (compiler.getErrorListener() == null) {
			compiler.setErrorListener(errorListener);
		}
		final Source source = new StreamSource(file);
		try {
			log.debug("Compiling stylesheet " + source.getSystemId());
			this.executable = compiler.compile(source);
			return this;
		} catch (final SaxonApiException e) {
			throw new TransformationException("Failed to compile XSL stylesheet.", e);
		}
	}

	/**
	 * Returns the underlying compiled stylesheet.
	 *
	 * @return the underlying compiled stylesheet.
	 * @throws IllegalStateException
	 *             if the stylesheet has not been compiled.
	 */
	public XsltExecutable getExecutable() {
		if (executable == null) {
			throw new IllegalStateException("Stylesheet has not been compiled.");
		}
		return executable;
	}

	public String getName() {
		return file.getName();
	}

}
