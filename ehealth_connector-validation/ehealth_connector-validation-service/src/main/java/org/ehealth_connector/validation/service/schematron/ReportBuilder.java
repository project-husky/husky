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

package org.ehealth_connector.validation.service.schematron;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.transform.Source;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

import org.ehealth_connector.validation.service.transform.StylesheetFactory;
import org.ehealth_connector.validation.service.transform.StylesheetURIResolver;
import org.ehealth_connector.validation.service.transform.Transformation;
import org.ehealth_connector.validation.service.transform.TransformationException;
import org.ehealth_connector.validation.service.util.JarUtils;
import org.xml.sax.SAXException;

import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.SaxonApiUncheckedException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathExecutable;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XdmDestination;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XsltExecutable;

/**
 * Class used for generating <cite>Schematron</cite> validation reports in HTML.
 * <p>
 * This class encapsulates a {@link Validators} instance for efficiently build
 * and retrieve compiled <cite>Schematron</cite> validator stylesheets.
 * </p>
 * <h4>Thread Safety</h4>
 * <p>
 * This class is immutable and therefore thread-safe.
 * </p>
 *
 */
public class ReportBuilder {

	/** Directory were xls-Sheets are stored */
	private static final String xslDir = JarUtils.getResourceUri("xsl", ReportBuilder.class);

	/** Style sheet for generating Validation HTML output */
	public static final String SVRL_TO_HTML = xslDir + JarUtils.separator + "svrl_to_html.xsl";
	/** Style sheet for generating Validation XML output */
	public static final String SVRL_TO_XML = xslDir + JarUtils.separator + "ms-svrl.xsl";

	/** Validator class used for validation */
	private final Validators validators;

	/** URI Resolver */
	private final URIResolver resolver;

	/** Stylesheet Factory */
	private final StylesheetFactory factory;

	/** Rule Set List */
	private Collection<RuleSet> ruleSetList = null;

	/** Rule Set OID map */
	private Map<String, RuleSet> ruleSetOidMap = null;

	/** XPath Selector */
	private XPathSelector xPathSelector;

	/**
	 * Creates a new report builder instance.
	 *
	 * @param validators
	 *            a valid reference to the {@link Validators} instance.
	 * @param ruleSetList
	 *            the list of available rule-sets.
	 * @throws NullPointerException
	 *             if the specified <tt>Validators</tt> instance is
	 *             <tt>null</tt>.
	 */
	public ReportBuilder(Validators validators, Collection<RuleSet> ruleSetList) {
		if (validators == null) {
			throw new NullPointerException("Validators instance is null.");
		}
		this.validators = validators;
		this.ruleSetList = ruleSetList;
		this.resolver = new StylesheetURIResolver(xslDir);
		this.factory = new StylesheetFactory(getProcessor(), this.resolver);
	}

	/**
	 * Count the errors in Schematron validation report
	 *
	 * @param in
	 *            Schematron validation report
	 * @return Number of errors
	 * @throws TransformationException
	 */
	protected long countErrors(InputStream in) throws TransformationException {
		final DocumentBuilder builder = getProcessor().newDocumentBuilder();
		final XPathCompiler compiler = getProcessor().newXPathCompiler();
		compiler.declareNamespace("svrl", "http://purl.oclc.org/dsdl/svrl");
		final String expression = "count(//svrl:failed-assert[@role='error'])"
				+ " + count(//svrl:successful-report[@role='error'])";
		try {
			final XdmNode document = builder.build(new StreamSource(in));
			final XdmItem item = compiler.evaluateSingle(expression, document);
			return ((XdmAtomicValue) item).getLongValue();
		} catch (final SaxonApiException cause) {
			throw new TransformationException(cause);
		}
	}

	/**
	 * Creates an HTML validation report for the specified input document.
	 * <p>
	 * This method tries to auto-detect the rule-set to use for the validation
	 * process from the specified input document and the list of available
	 * rule-sets.
	 * </p>
	 *
	 * @param ruleSetList
	 *            the list of available rule-sets.
	 *
	 * @param workDir
	 *            the work directory where to put/read precompiled Schematron
	 *            stylesheets
	 *
	 * @param input
	 *            the XML input to be validated as an array of bytes.
	 *
	 * @param parameters
	 *            XSLT parameters
	 *
	 * @return an HTML validation report as an array of bytes.
	 *
	 * @throws RuleSetDetectionException
	 *             if no rule-set or if more than one rule-set was found for the
	 *             specified document, or if an error occurs when building the
	 *             document, for example a parsing error or because the type of
	 *             document supplied does not match the required type.
	 *
	 * @throws TransformationException
	 *             if the construction of the validator stylesheet aborted by
	 *             throwing an exception, if any stylesheet contains static
	 *             errors or cannot be read, or during the transformation phase,
	 *             if an error occurs when setting the source for the
	 *             transformation, or if any dynamic error occurs during the
	 *             transformation.
	 * @throws InterruptedException
	 *             if the construction of the validator stylesheet was
	 *             interrupted.
	 * @throws NullPointerException
	 *             if the specified input source document is <tt>null</tt>.
	 */
	public byte[] createHTMLReport(Collection<RuleSet> ruleSetList, File workDir, byte[] input,
			Properties parameters) throws SAXException, RuleSetDetectionException,
			TransformationException, InterruptedException {
		final ByteArrayInputStream in = new ByteArrayInputStream(input);
		final RuleSet ruleSet = detectRuleSet(new StreamSource(in));
		return createHTMLReport(ruleSet, workDir, input, parameters);
	}

	/**
	 * Creates an HTML validation report for the specified input document using
	 * the given rule-set.
	 *
	 * @param ruleSet
	 *            a valid <cite>Schematron Rule-Set</cite> instance to be used
	 *            for the validation process.
	 *
	 * @param workDir
	 *            the work directory where to put/read precompiled Schematron
	 *            stylesheets
	 *
	 * @param input
	 *            the XML input to be validated as an array of bytes.
	 *
	 * @param parameters
	 *            XSLT parameters
	 *
	 * @return an HTML validation report as an array of bytes.
	 *
	 * @throws TransformationException
	 *             if the construction of the validator stylesheet aborted by
	 *             throwing an exception, if any stylesheet contains static
	 *             errors or cannot be read, or during the transformation phase,
	 *             if an error occurs when setting the source for the
	 *             transformation, or if any dynamic error occurs during the
	 *             transformation.
	 * @throws InterruptedException
	 *             if the construction of the validator stylesheet was
	 *             interrupted.
	 * @throws NullPointerException
	 *             if either the specified rule-set or input stream is
	 *             <tt>null</tt>.
	 */
	public byte[] createHTMLReport(RuleSet ruleSet, File workDir, byte[] input,
			Properties parameters) throws TransformationException, InterruptedException {
		final ByteArrayInputStream in = new ByteArrayInputStream(input);
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		createHTMLReport(ruleSet, workDir, in, out, parameters);
		return out.toByteArray();
	}

	/**
	 * Creates an HTML <cite>Schematron</cite> validation report from the
	 * specified input using the given rule-set and sending the results to the
	 * output stream.
	 *
	 * @param ruleSet
	 *            a valid <cite>Schematron Rule-Set</cite> instance to be used
	 *            for the validation process.
	 * @param workDir
	 *            the work directory where to put/read precompiled Schematron
	 *            stylesheets
	 * @param in
	 *            the XML input to be validated.
	 * @param out
	 *            the output stream, where the validation results are written.
	 * @param parameters
	 *            XSLT parameters
	 * @return number of errors
	 * @throws TransformationException
	 *             if the construction of the validator stylesheet aborted by
	 *             throwing an exception, if any stylesheet contains static
	 *             errors or cannot be read, or during the transformation phase,
	 *             if an error occurs when setting the source for the
	 *             transformation, or if any dynamic error occurs during the
	 *             transformation.
	 * @throws InterruptedException
	 *             if the construction of the validator stylesheet was
	 *             interrupted.
	 */
	public long createHTMLReport(RuleSet ruleSet, File workDir, InputStream in, OutputStream out,
			Properties parameters) throws TransformationException, InterruptedException {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final XsltExecutable styleSheet = getValidator(ruleSet, workDir);
		final Transformation t1 = new Transformation(styleSheet, getProcessor());
		t1.setURIResolver(new StylesheetURIResolver(ruleSet.getPath().getParentFile()));
		t1.transform(in, baos);
		final byte[] svrl = baos.toByteArray();
		// for debugging only - comment these lines for productive releases
		// log.debug("Validation-Result input cachable: {}",
		// new Object[] { ruleSet.isCacheable() });
		// log.debug("Validation-Result SVRL: {}", new Object[] {
		// baos.toString() });
		// end of debugging only

		final Transformation t2 = new Transformation(factory.getStylesheet(SVRL_TO_HTML, false),
				getProcessor());
		t2.setURIResolver(this.resolver);
		t2.setParameters(parameters);
		t2.transform(new ByteArrayInputStream(svrl), out);
		// for debugging only - comment these lines for productive releases
		// log.debug("Validation-Result SVRL_TO_HTML: {}", new Object[] {
		// SVRL_TO_HTML });
		// log.debug("Validation-Result HTML: {}", new Object[] { out.toString()
		// });
		// end of debugging only
		return countErrors(new ByteArrayInputStream(svrl));
	}

	/**
	 * Creates a Schematron result in the SVRL format
	 *
	 * @param ruleSet
	 *            a valid <cite>Schematron Rule-Set</cite> instance to be used
	 *            for the validation process.
	 * @param workDir
	 *            the work directory where to put/read precompiled Schematron
	 *            stylesheets
	 * @param inStreamSource
	 *            the XML input to be validated.
	 * @param outStreamSource
	 *            the output stream, where the validation results are written.
	 * @param parameters
	 *            XSLT parameters
	 * @return Schematron result in the SVRL format
	 * @throws TransformationException
	 *             if the construction of the validator stylesheet aborted by
	 *             throwing an exception, if any stylesheet contains static
	 *             errors or cannot be read, or during the transformation phase,
	 *             if an error occurs when setting the source for the
	 *             transformation, or if any dynamic error occurs during the
	 *             transformation.
	 * @throws InterruptedException
	 *             if the construction of the validator stylesheet was
	 *             interrupted.
	 */
	public byte[] createSvrlReport(RuleSet ruleSet, File workDir, StreamSource inStreamSource,
			OutputStream outStreamSource, Properties parameters)
			throws TransformationException, InterruptedException {

		byte[] retVal = null;
		final XsltExecutable styleSheet1 = getValidator(ruleSet, workDir);
		if (styleSheet1 != null) {
			final Transformation t1 = new Transformation(styleSheet1, getProcessor());
			t1.setURIResolver(new StylesheetURIResolver(ruleSet.getPath().getParentFile()));
			XdmDestination destination = new XdmDestination();
			t1.transform(inStreamSource, destination);

			// for debugging only - comment these lines for productive releases
			// OutputStream outputStream1 = null;
			// try {
			// outputStream1 = new FileOutputStream("/temp/svrl_raw_out.xml");
			// Serializer serializer = new Serializer();
			// serializer.setOutputStream(outputStream1);
			// getProcessor().writeXdmValue(destination.getXdmNode(),
			// serializer);
			// outputStream1.close();
			// } catch (IOException | SaxonApiException e) {
			// // do nothing
			// e.printStackTrace();
			// }
			// end of debugging only

			boolean destContainsXhtml = false;
			final XPathCompiler xpathCompiler = getProcessor().newXPathCompiler();
			xpathCompiler.declareNamespace("xhtml", "http://www.w3.org/1999/xhtml");

			final String expression = "//xhtml:p";
			try {
				final XdmItem item = xpathCompiler.evaluateSingle(expression,
						destination.getXdmNode());
				destContainsXhtml = (item != null);
			} catch (SaxonApiException e) {
				// Do nothing
			}

			XdmNode returnNode = destination.getXdmNode();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			if (destContainsXhtml) {
				XdmDestination destination2 = new XdmDestination();
				XsltExecutable styleSheet2 = factory.getStylesheet(SVRL_TO_XML, false);
				if (styleSheet2 != null) {
					final Transformation t2 = new Transformation(styleSheet2, getProcessor());
					t2.setURIResolver(this.resolver);
					t2.setParameters(parameters);
					t2.transform(destination.getXdmNode().asSource(), destination2);
					returnNode = destination2.getXdmNode();

					// for debugging only - comment these lines for productive
					// releases
					// OutputStream outputStream2 = null;
					// try {
					// outputStream2 = new
					// FileOutputStream("/temp/svrl2xml_out.xml");
					// Serializer serializer = new Serializer();
					// serializer.setOutputStream(outputStream2);
					// getProcessor().writeXdmValue(destination2.getXdmNode(),
					// serializer);
					// outputStream2.close();
					// } catch (IOException | SaxonApiException e) {
					// // do nothing
					// e.printStackTrace();
					// }
					// end of debugging only
				}

			}

			if (returnNode != null) {
				Serializer out = factory.getProcessor().newSerializer();
				out.setOutputStream(baos);
				out.setOutputProperty(Serializer.Property.METHOD, "xml");
				out.setOutputProperty(Serializer.Property.ENCODING, "UTF-8");
				out.setOutputProperty(Serializer.Property.OMIT_XML_DECLARATION, "yes");
				out.setOutputProperty(Serializer.Property.INDENT, "no");
				// getTransformer().setDestination(out);

				try {
					getProcessor().writeXdmValue(returnNode, out);
					baos.close();
				} catch (SaxonApiException | IOException e) {
					// Do nothing
				}
			}
			retVal = baos.toByteArray();
		}
		return retVal;
	}

	/**
	 * Tries to auto-detect the matching rule-set from the specified input
	 * source document.
	 *
	 * @param processor
	 *            the <cite>Saxon Processor</cite> instance.
	 * @param source
	 *            the source document.
	 * @return the one and only one matching rule-set for the specified input
	 *         source document.
	 * @throws RuleSetDetectionException
	 *             if no rule-set or if more than one rule-set was found for the
	 *             specified document, or if an error occurs when building the
	 *             document, for example a parsing error or because the type of
	 *             document supplied does not match the required type.
	 * @throws NullPointerException
	 *             if either the specified processor or source document is
	 *             <tt>null</tt>.
	 */
	public RuleSet detectRuleSet(Processor processor, Source source)
			throws RuleSetDetectionException {
		if (processor == null) {
			throw new NullPointerException("Processor is null.");
		} else if (source == null) {
			throw new NullPointerException("Source document is null.");
		} else if (ruleSetList == null) {
			throw new RuleSetDetectionException(new ArrayList<RuleSet>());
		}

		prepareSelector();

		final DocumentBuilder builder = getProcessor().newDocumentBuilder();
		try {
			final XdmNode document = builder.build(source);
			xPathSelector.setContextItem(document);
		} catch (SaxonApiException | SaxonApiUncheckedException e) {
			throw new RuleSetDetectionException(e.getClass().getName() + ":" + e.getMessage());
		}

		RuleSet match;
		String value;
		final List<RuleSet> matchingRuleSets = new ArrayList<RuleSet>();
		for (final XdmItem item : xPathSelector) {
			value = ((XdmNode) item).getStringValue();
			if ((match = ruleSetOidMap.get(value)) != null) {
				matchingRuleSets.add(match);
			}
		}
		if (matchingRuleSets.size() != 1) {
			throw new RuleSetDetectionException(matchingRuleSets);
		}
		return matchingRuleSets.get(0);
	}

	/**
	 * Tries to auto-detect the matching rule-set from the specified input
	 * source document.
	 *
	 * @param source
	 *            the source document.
	 * @return the one and only one matching rule-set for the specified input
	 *         source document.
	 * @throws RuleSetDetectionException
	 *             if no rule-set or if more than one rule-set was found for the
	 *             specified document, or if an error occurs when building the
	 *             document, for example a parsing error or because the type of
	 *             document supplied does not match the required type.
	 * @throws NullPointerException
	 *             if the specified source document is <tt>null</tt>.
	 */
	public RuleSet detectRuleSet(Source source) throws SAXException, RuleSetDetectionException {
		return detectRuleSet(getProcessor(), source);
	}

	/**
	 * Returns the <cite>Saxon Processor</cite> instance.
	 *
	 * @return the <cite>Saxon Processor</cite> instance.
	 */
	public Processor getProcessor() {
		return validators.getProcessor();
	}

	/**
	 * Returns a compiled <cite>Schematron Validator</cite> stylesheet for the
	 * specified <cite>Schematron Rule-Set</cite>, blocking until it is
	 * available.
	 *
	 * @param ruleSet
	 *            a valid <cite>Schematron Rule-Set</cite> instance.
	 *
	 * @param workDir
	 *            the work directory where to put/read precompiled Schematron
	 *            stylesheets
	 *
	 * @return the compiled validator stylesheet.
	 *
	 * @throws TransformationException
	 *             if the construction of the compiled stylesheet aborted by
	 *             throwing an exception.
	 *
	 * @throws InterruptedException
	 *             if the construction of the compiled stylesheet was
	 *             interrupted.
	 *
	 * @throws NullPointerException
	 *             if the specified rule-set is <tt>null</tt>.
	 */
	public XsltExecutable getValidator(RuleSet ruleSet, File workDir)
			throws TransformationException, InterruptedException {
		return validators.get(ruleSet, workDir);
	}

	/**
	 * Initialization of the XPathXelector for the use in detectRuleSet
	 *
	 * @throws RuleSetDetectionException
	 */
	private void prepareSelector() throws RuleSetDetectionException {

		ruleSetOidMap = new HashMap<String, RuleSet>();
		for (final RuleSet ruleSet : ruleSetList) {
			if (ruleSet.getTemplateId() != null) {
				ruleSetOidMap.put(ruleSet.getTemplateId(), ruleSet);
			}
		}
		final String expression = "/cda:ClinicalDocument/cda:templateId/@root";

		final XPathCompiler compiler = getProcessor().newXPathCompiler();
		compiler.declareNamespace("cda", "urn:hl7-org:v3");

		// try {
		XPathExecutable executable;
		try {
			executable = compiler.compile(expression);
		} catch (SaxonApiException e) {
			throw new RuleSetDetectionException(e);
		}
		xPathSelector = executable.load();
	}

} // End of ReportBuilder
