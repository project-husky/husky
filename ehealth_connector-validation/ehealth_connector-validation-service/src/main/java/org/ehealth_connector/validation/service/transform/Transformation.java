/*
 * 
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

package org.ehealth_connector.validation.service.transform;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.transform.Source;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.saxon.s9api.Destination;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XsltExecutable;
import net.sf.saxon.s9api.XsltTransformer;

/**
 * Represents a single XSLT transformation within a sequence of a transformation
 * steps.
 *
 * <h4>Thread Safety</h4>
 * <p>
 * This class is not thread-safe, but it might be reused to transform a
 * multitude of XML documents sequentially within the same thread.
 * </p>
 */
public class Transformation {
	/**
	 * Returns a string describing the specified destination. For debugging
	 * purpose only.
	 *
	 * @param destination
	 *            the destination to be used.
	 * @return a string describing the specified destination.
	 */
	private static String describeDestination(Destination destination) {
		if (destination instanceof XsltTransformer) {
			return "Pipe to next transformation";
		} else if (destination instanceof Serializer) {
			final Object out = ((Serializer) destination).getOutputDestination();
			if (out instanceof File) {
				return ((File) out).getPath();
			}
			return out.getClass().getName();
		}
		return destination.getClass().getName();
	}

	/**
	 * Returns a string describing the specified source. For debugging purpose
	 * only.
	 *
	 * @param source
	 *            the source document for the transformation.
	 * @return a string describing the specified source.
	 */
	public static String describeSource(Source source) {
		if (source == null) {
			return "Read from pipe";
		} else if (source instanceof StreamSource) {
			final StreamSource streamSource = (StreamSource) source;
			if (streamSource.getPublicId() != null) {
				return streamSource.getPublicId();
			} else if (streamSource.getSystemId() != null) {
				return source.getSystemId();
			}
			final InputStream in = streamSource.getInputStream();
			if (in != null)
				return in.getClass().getName();
		} else if (source.getSystemId() != null) {
			return source.getSystemId();
		}
		return source.getClass().getName();
	}

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** The next transformation step (may be <tt>null</tt>). */
	private Transformation next;

	/** An optional output file (may be <tt>null</tt>). */
	private File outputFile;

	/** The underlying <cite>Saxon</cite> XSLT transformer. */
	private final XsltTransformer transformer;

	/**
	 * Creates a new transformation using the specified XSLT stylesheet.
	 *
	 * @param stylesheet
	 *            the pre-compiled XSLT stylesheet to use for this
	 *            transformation.
	 * @throws NullPointerException
	 *             if the specified executable is <tt>null</tt>.
	 */
	public Transformation(XsltExecutable stylesheet) {
		if (stylesheet == null) {
			throw new NullPointerException("Stylesheet is null.");
		}
		this.transformer = stylesheet.load();
	}

	/**
	 * Determines the source document for the next transformation.
	 *
	 * @return the source document for the next transformation, or <tt>null</tt>
	 *         if this is the last transformation step or if this transformation
	 *         step does not create any output file.
	 */
	protected Source getNextSource() {
		final File output = getOutputFile();
		if (isLastStep() || (output == null)) {
			return null;
		}
		return new StreamSource(output);
	}

	/**
	 * Returns the next transformation step.
	 *
	 * @return the next transformation step or <tt>null</tt>, if this is the
	 *         last transformation step.
	 * @see #isLastStep()
	 */
	public Transformation getNextStep() {
		return next;
	}

	/**
	 * Returns this transformation step's output file.
	 *
	 * @return this transformation step's output file or <tt>null</tt>.
	 */
	public File getOutputFile() {
		return outputFile;
	}

	/**
	 * Returns this transformation's XSLT transformer instance.
	 *
	 * @return the {@link XsltTransformer} instance.
	 */
	private XsltTransformer getTransformer() {
		return transformer;
	}

	/**
	 * Indicates whether this is the last transformation in the transformation
	 * chain.
	 *
	 * @return <tt>true</tt> if this is the last transformation step.
	 */
	public boolean isLastStep() {
		return (next == null);
	}

	/**
	 * Prepares this and the next transformation steps.
	 * <p>
	 * This method walks through all the transformation steps and sets the
	 * source and destination accordingly to the specified parameters and to the
	 * value returned by the {@link #getOutputFile()} method.
	 * </p>
	 * <p>
	 * If multiple transformation steps are combined together to form a
	 * transformation chain, and if the results of a transformation are sent
	 * (piped) to the next transformation step, then a single call to the
	 * {@link XsltTransformer#transform()} method will perform all the
	 * transformations in a single step.
	 * </p>
	 * <p>
	 * If however the transformation results of a single step in the middle of
	 * the transformation chain is not piped, then the transformation task will
	 * stop at that point. It is necessary to invoke the <tt>transform</tt>
	 * method again on this particular transformation step to continue the
	 * transformation process.
	 * </p>
	 * <p>
	 * This method is aware of this fact and returns to the caller the list of
	 * transformation steps on which the <tt>transform</tt> method has to be
	 * invoked.
	 * </p>
	 *
	 * @param source
	 *            the XML source to transform.
	 * @param destination
	 *            the destination to be used for the last transformation step.
	 * @throws TransformationException
	 *             if an error occurs when setting the source for the
	 *             transformation.
	 * @throws NullPointerException
	 *             if the specified source is <tt>null</tt>.
	 * @return the list of transformation steps whose source document is not
	 *         piped from the preceding transformation step.
	 * @see #setSource(Source)
	 * @see #setDestination(Destination)
	 * @see #getNextSource()
	 */
	protected List<Transformation> prepare(Source source, Destination destination)
			throws TransformationException {
		if (source == null) {
			throw new NullPointerException("Source is null.");
		}
		final List<Transformation> breakPoints = new ArrayList<Transformation>();
		Transformation step = this;
		int index = 0;
		do {
			log.debug("== Transformation Step {} ==", ++index);
			// log.debug("Stylesheet: " + step.getStylesheet().getName());

			// Source document not read from piped
			if (source != null)
				breakPoints.add(step);

			step.setSource(source);
			step.setDestination(destination);

			// Next transformation reads from last destination
			source = step.getNextSource();
		} while ((step = step.getNextStep()) != null);
		return breakPoints;
	}

	/**
	 * Sets the destination to be used for the result of the transformation.
	 * <p>
	 * If this transformation is part of a transformation chain and if it is not
	 * the last member, then, in the absence of an output file, the result of
	 * the transformation is sent (piped) to the next transformation step in the
	 * chain.
	 * </p>
	 * <p>
	 * If this transformation is the last member of a transformation chain and
	 * if both, the final destination and an output file for the transformation
	 * have been specified, then the specified final destination parameter has
	 * precedence.
	 * </p>
	 * <p>
	 * If this transformation is the last member of a transformation chain and
	 * if neither the final destination nor an output file have been specified,
	 * then an <tt>IllegalStateException</tt> is thrown.
	 * </p>
	 *
	 * @param finalDestination
	 *            the destination to be used for the last transformation step.
	 *            This parameter is ignored if this transformation is not the
	 *            last member in the transformation chain. A <tt>null</tt> value
	 *            is allowed only if {@link #getOutputFile()} returns a non-null
	 *            value.
	 * @throws IllegalStateException
	 *             if no destination is available and this transformation is the
	 *             last member in the transformation chain.
	 * @see #getOutputFile()
	 */
	protected void setDestination(Destination finalDestination) {
		Destination destination;
		if (isLastStep() && (finalDestination != null)) {
			// Specified destination has precedence
			destination = finalDestination;
		} else {
			final File out = getOutputFile();
			if (isLastStep() && (out == null)) {
				throw new IllegalStateException("Missing final destination.");
			} else if (out != null) {
				destination = new Serializer(out);
			} else {
				// Pipe to next transformation
				destination = getNextStep().getTransformer();
			}
		}
		getTransformer().setDestination(destination);
		log.debug("Destination: " + describeDestination(destination));
	}

	/**
	 * Sets the specified transformation to be the transformation step
	 * immediately following this transformation step.
	 *
	 * @param next
	 *            the next transformation step or <tt>null</tt> to break the
	 *            transformation chain.
	 * @return the specified transformation step.
	 */
	public Transformation setNextStep(Transformation next) {
		this.next = next;
		return next;
	}

	/**
	 * Sets the output file for the last or an intermediate transformation step.
	 *
	 * @param outputFile
	 *            the output file (<tt>null</tt> allowed).
	 */
	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	/**
	 * Sets the value of a stylesheet parameter.
	 *
	 * @param name
	 *            the name of the stylesheet parameter.
	 * @param value
	 *            the value of the stylesheet parameter, or <tt>null</tt> to
	 *            clear a previously set value.
	 */
	public void setParameter(String name, String value) {
		log.debug("Setting stylesheet parameter " + name + "=" + value);
		getTransformer().setParameter(new QName(name), new XdmAtomicValue(value));
	}

	/**
	 * Sets the value of multiple stylesheet parameters. Does nothing if the
	 * specified properties is <tt>null</tt>.
	 *
	 * @param properties
	 *            the key/value pairs to use as stylesheet parameters.
	 */
	public void setParameters(Properties properties) {
		if (properties != null) {
			for (final Object key : properties.keySet()) {
				final String name = (String) key;
				setParameter(name, properties.getProperty(name));
			}
		}
	}

	/**
	 * Sets the source document for the transformation.
	 * <p>
	 * Note that a <tt>null</tt> source is allowed if this transformation is
	 * part of a transformation chain and is not the first member.
	 * </p>
	 *
	 * @param source
	 *            the source document for the transformation (<tt>null</tt>
	 *            allowed).
	 * @throws TransformationException
	 *             if an error occurs when setting the source for the
	 *             transformation.
	 */
	protected void setSource(Source source) throws TransformationException {
		try {
			getTransformer().setSource(source);
			log.debug("Source: " + describeSource(source));
		} catch (final SaxonApiException e) {
			throw new TransformationException("Failed to set the source document.", e);
		}
	}

	/**
	 * Sets an object that will be used to resolve URIs used in
	 * <tt>fn:doc()</tt> and related functions.
	 *
	 * @param resolver
	 *            an object that implements the <tt>URIResolver</tt> interface,
	 *            or <tt>null</tt>.
	 */
	public void setURIResolver(URIResolver resolver) {
		getTransformer().setURIResolver(resolver);
	}

	/**
	 * Transforms the specified XML input file and writes the results to the
	 * given output file.
	 *
	 * @param in
	 *            the input XML file.
	 * @param out
	 *            the output file to which the result is written. if an error
	 *            occurs when setting the source for the transformation, or if
	 *            any dynamic error occurs during the transformation.
	 * @throws NullPointerException
	 *             if the specified input file is <tt>null</tt>.
	 */
	public void transform(File in, File out) throws TransformationException {
		if (in == null)
			throw new NullPointerException("Input file is null.");
		transform(new StreamSource(in), (out != null ? new Serializer(out) : null));
	}

	/**
	 * Transforms the specified XML input stream and writes the results to the
	 * given output stream.
	 * <p>
	 * Note that it is the responsibility of the caller to properly close the
	 * streams after use.
	 * </p>
	 *
	 * @param in
	 *            a reference to an XML input stream.
	 * @param out
	 *            the output stream to which the result is written.
	 * @throws TransformationException
	 *             if an error occurs when setting the source for the
	 *             transformation, or if any dynamic error occurs during the
	 *             transformation.
	 * @throws NullPointerException
	 *             if the specified input stream is <tt>null</tt>.
	 */
	public void transform(InputStream in, OutputStream out) throws TransformationException {
		if (in == null)
			throw new NullPointerException("Input stream is null.");
		transform(new StreamSource(in), (out != null ? new Serializer(out) : null));
	}

	/**
	 * Transforms the specified XML source and writes the results to the given
	 * destination.
	 *
	 * @param source
	 *            the XML source to transform.
	 * @param destination
	 *            the destination where the transformation results is to be
	 *            sent.
	 * @throws TransformationException
	 *             if an error occurs when setting the source for the
	 *             transformation, or if any dynamic error occurs during the
	 *             transformation.
	 * @throws NullPointerException
	 *             if the specified source is <tt>null</tt>.
	 */
	public void transform(Source source, Destination destination) throws TransformationException {
		if (source == null) {
			throw new NullPointerException("Source is null.");
		}
		log.debug("Initializing transformation sequences ...");
		final List<Transformation> breakPoints = prepare(source, destination);
		final String srcDocument = describeSource(source);
		log.info("Starting transformation of '{}'", srcDocument);
		try {
			for (final Transformation point : breakPoints) {
				point.getTransformer().transform();
			}
		} catch (final SaxonApiException e) {
			throw new TransformationException(e);
		}
		log.info("Successfully transformed '{}", srcDocument);
	}

}
