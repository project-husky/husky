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

package org.husky.validation.service.schematron;

import org.husky.validation.service.transform.StylesheetFactory;
import org.husky.validation.service.transform.StylesheetURIResolver;
import org.husky.validation.service.transform.Transformation;
import org.husky.validation.service.transform.TransformationException;
import org.husky.validation.service.util.JarUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XsltExecutable;

/**
 * Implementation of a transformation factory, which creates a <cite>Schematron
 * Validator</cite> from a given <cite>Schematron Master File</cite>.
 * <p>
 * Building a <cite>Schematron Validator</cite> involves three transformation
 * steps based on the following <cite>ISO Schematron</cite> stylesheets.
 * <ol>
 * <li>iso_dsdl_include.xsl</li>
 * <li>iso_abstract_expand.xsl</li>
 * <li>iso_svrl_for_xslt2.xsl</li>
 * </ol>
 * </p>
 * <h4>Thread Safety</h4>
 * <p>
 * This class is immutable and therefore thread-safe.
 * </p>
 */
public class RuleSetTransformer extends StylesheetFactory {
	public static final String ISO_ABSTRACT_EXPAND;

	public static final String ISO_DSDL_INCLUDE;
	public static final String ISO_SVRL_FOR_XSLT2;
	/** The SLF4J logger instance. */
	protected static final Logger log = LoggerFactory.getLogger(RuleSetTransformer.class);

	private static final String xslDir = JarUtils.getResourceUri("xsl/iso-schematron-xslt2",
			RuleSetTransformer.class);

	/** The name of all XSL stylesheets used by this factory. */
	static {
		ISO_DSDL_INCLUDE = xslDir + JarUtils.separator + "iso_dsdl_include.xsl";
		ISO_ABSTRACT_EXPAND = xslDir + JarUtils.separator + "iso_abstract_expand.xsl";
		ISO_SVRL_FOR_XSLT2 = xslDir + JarUtils.separator + "iso_svrl_for_xslt2.xsl";
	}

	private static final String[] stylesheetNames = new String[] { ISO_DSDL_INCLUDE,
			ISO_ABSTRACT_EXPAND, ISO_SVRL_FOR_XSLT2 };

	/**
	 * Constructs a new <cite>Schematron Rule-Set</cite> transformer instance.
	 *
	 * @param processor
	 *            the <cite>Saxon Processor</cite> instance.
	 * @throws NullPointerException
	 *             if the specified <tt>processor</tt> is <tt>null</tt>.
	 */
	public RuleSetTransformer(Processor processor) {
		super(processor, new StylesheetURIResolver(xslDir));
	}

	/**
	 * Creates and returns a single transformation step based on the specified
	 * XSL stylesheet URI.
	 * <p>
	 * This method creates a new {@link Transformation} using the XSL stylesheet
	 * returned by the {@link #getStylesheet(String, boolean)} method. It also
	 * sets some stylesheet parameters of the <tt>iso_svrl_for_xslt2.xsl</tt>
	 * script in order to:
	 * <ul>
	 * <li>allow foreign XML elements and attributes to be used</li>
	 * <li>use the human readable notation for SVRL's location attribute</li>
	 * </ul>
	 * </p>
	 *
	 * @param uri
	 *            the URI of the XSL stylesheet to be used.
	 * @return a new {@link Transformation} instance based on specified XSL
	 *         stylesheet URI.
	 * @throws TransformationException
	 *             if the stylesheet contains static errors or if it cannot be
	 *             read.
	 */
	protected Transformation createTransformation(String uri) throws TransformationException {
		log.debug("Creating transformation based on '{}'",
				JarUtils.getRelativeUri(uri, getClass()));
		final XsltExecutable stylesheet = getStylesheet(uri, false);
		final Transformation transformation = new Transformation(stylesheet, getProcessor());
		if (ISO_SVRL_FOR_XSLT2.equals(uri)) {
			transformation.setParameter("allow-foreign", "true");
			transformation.setParameter("full-path-notation", "2");
		}
		return transformation;
	}

	/**
	 * Creates a sequence of transformation steps.
	 * <p>
	 * This method creates an XML transformer consisting of a sequence of
	 * transformation steps. The number and the order of the transformation
	 * steps is determined by the {@link #getStylesheetNames()} method.
	 * </p>
	 * <p>
	 * For each transformation step the {@link #createTransformation(String)}
	 * method is invoked, giving the implementor the possibility to configure
	 * each transformation step as needed.
	 * </p>
	 *
	 * @return the root {@link Transformation} step.
	 * @throws TransformationException
	 * @see #getStylesheetNames()
	 * @see #createTransformation(String)
	 */
	public Transformation createTransformer() throws TransformationException {
		Transformation root = null;
		Transformation step = null;
		for (final String name : getStylesheetNames()) {
			if (step == null) {
				step = root = createTransformation(name);
			} else {
				step = step.setNextStep(createTransformation(name));
			}
		}
		return root;
	}

	/**
	 * Returns an ordered list of stylesheet names used for transforming a
	 * <cite>Schematron Master File</cite> into a <cite>Schematron Validator
	 * File</cite>.
	 *
	 * @return an ordered list of stylesheet names.
	 */
	protected String[] getStylesheetNames() {
		return stylesheetNames;
	}

}
