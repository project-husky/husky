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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.husky.validation.service.transform.Transformation;
import org.husky.validation.service.transform.TransformationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XsltExecutable;

/**
 * A callable task which produces a <cite>Schematron Validator</cite> from a
 * given <cite>Master Schematron File</cite>.
 * <p>
 * The produced <cite>Schematron Validator</cite> has the form of compiled XSL
 * stylesheet, which can be used to validate a source XML document.
 * </p>
 * <p>
 * Instances of this class may be submitted to an <tt>Executor</tt>.
 * </p>
 *
 */
public class ValidatorBuilder implements Callable<XsltExecutable> {

	/** The <cite>Schematron Rule-Set</cite> transformation factory. */
	private final RuleSetTransformer factory;

	/** The input <cite>Master Schematron File</cite>. */
	private final File in;

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** An optional output file, where the validator is persisted. */
	private final File out;

	/**
	 * Creates a new <cite>Schematron Validator</cite> builder instance. This is
	 * equivalent to the invocation of the constructor
	 * {@link #ValidatorBuilder(RuleSetTransformer, File, File)} with
	 * <tt>null</tt> as output file parameter.
	 *
	 * @param factory
	 *            a <cite>Schematron Rule-Set</cite> transformation factory.
	 * @param in
	 *            the input <cite>Master Schematron File</cite>.
	 * @throws NullPointerException
	 *             if either the specified factory or the input file is
	 *             <tt>null</tt>.
	 */
	public ValidatorBuilder(RuleSetTransformer factory, File in) {
		this(factory, in, null);
	}

	/**
	 * Creates a new <cite>Schematron Validator</cite> builder, which persists
	 * the transformation results to the specified output file.
	 * <p>
	 * If the specified output file is <tt>null</tt>, then the transformation
	 * results (the <cite>Schematron Validator</cite> file) is not persisted on
	 * disk but compiled in memory.
	 * </p>
	 *
	 * @param factory
	 *            a <cite>Schematron Rule-Set</cite> transformation factory.
	 * @param in
	 *            the input <cite>Master Schematron File</cite>.
	 * @param out
	 *            the output file, where the validator file should be persisted
	 *            (<tt>null</null> allowed).
	 * &#64;throws NullPointerException
	 *    if either the specified factory or the input file is <tt>null</tt>.
	 */
	public ValidatorBuilder(RuleSetTransformer factory, File in, File out) {
		if (factory == null) {
			throw new NullPointerException("Factory is null.");
		} else if (in == null) {
			throw new NullPointerException("Input file is null.");
		}
		this.factory = factory;
		this.in = in;
		this.out = out;
	}

	/**
	 * Transforms the specified source and builds a compiled XSL stylesheet that
	 * can be used as validator. All transformation steps as well as the
	 * compilation of the resulting stylesheet is entirely done in memory.
	 *
	 * @param source
	 *            the input <cite>Schematron Master File</cite>.
	 * @return a compiled XSL stylesheet that can be used as validator.
	 * @throws TransformationException
	 *             if any of the transformation steps fails due to an error, or
	 *             if the resulting stylesheet contains static errors or cannot
	 *             be read.
	 * @see #call()
	 */
	private XsltExecutable buildTransientValidator(Source source) throws TransformationException {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();

		final Serializer out = factory.getProcessor().newSerializer();
		out.setOutputStream(baos);

		final Transformation transformer = getFactory().createTransformer();
		transformer.transform(source, out);

		final InputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
		return getFactory().getStylesheet(new StreamSource(inputStream), false);
	}

	/**
	 * Transforms a <cite>Schematron Master File</cite> and builds a compiled
	 * XSL stylesheet that can be used as validator.
	 *
	 * @return a compiled XSL stylesheet that can be used as validator.
	 * @throws TransformationException
	 *             if any of the transformation steps fails due to an error, or
	 *             if the resulting stylesheet contains static errors or cannot
	 *             be read.
	 * @see #createValidator(File, File)
	 */
	@Override
	public XsltExecutable call() throws TransformationException {
		try {
			final XsltExecutable stylesheet = createValidator(in, out);
			log.info("<<< Successfully created validator for '{}'", in.getName());
			return stylesheet;
		} catch (final TransformationException e) {
			log.error("<<< Failed to create validator for '" + in.getName() + "'", e);
			throw e;
		}
	}

	/**
	 * Transforms the <cite>Schematron Master File</cite> and builds a compiled
	 * XSL stylesheet that can be used as validator.
	 * <p>
	 * Optionally the transformation results, that is the <cite>Schematron
	 * Validator File</cite>, may be persisted to a given output file.
	 * </p>
	 * <p>
	 * If an output file is specified, and if this file already exists and was
	 * last modified after the input file, then it is reused and all
	 * transformation steps are skipped.
	 * </p>
	 * <p>
	 * If no output file is specified, then all transformation steps as well as
	 * the compilation of the resulting stylesheet is entirely done in memory.
	 * </p>
	 *
	 * @param inFile
	 *            the input <cite>Schematron</cite> file.
	 * @param outFile
	 *            output file for the validator (<tt>null</tt> allowed).
	 * @return a compiled XSL stylesheet that can be used as validator.
	 * @throws TransformationException
	 *             if any of the transformation steps fails due to an error, or
	 *             if the resulting stylesheet contains static errors or cannot
	 *             be read.
	 */
	protected XsltExecutable createValidator(File inFile, File outFile)
			throws TransformationException {
		XsltExecutable stylesheet;
		final Source source = new StreamSource(inFile);
		if (outFile == null) {
			log.info(">>> Creating transient validator from file '{}'", inFile.getAbsolutePath());
			stylesheet = buildTransientValidator(source);
		} else {
			if (!outFile.exists() || (inFile.lastModified() > outFile.lastModified())) {
				log.info(">>> Creating new persitent validator from '{}' to '{}'",
						inFile.getAbsolutePath(), outFile.getAbsolutePath());
				final Serializer out = factory.getProcessor().newSerializer();
				out.setOutputFile(outFile);
				final Transformation transformer = getFactory().createTransformer();
				transformer.transform(source, out);
			} else {
				log.info(">>> Reusing persistent validator file '{}' (master file: '{}')",
						outFile.getAbsolutePath(), inFile.getAbsolutePath());
			}
			stylesheet = getFactory().getStylesheet(outFile, false);
		}
		return stylesheet;
	}

	/**
	 * Returns the <cite>Schematron Rule-Set</cite> transformation factory.
	 *
	 * @return the <cite>Schematron Rule-Set</cite> transformation factory.
	 */
	public RuleSetTransformer getFactory() {
		return factory;
	}

}
