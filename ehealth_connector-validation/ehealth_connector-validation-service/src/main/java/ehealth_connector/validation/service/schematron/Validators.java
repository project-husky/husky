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

package ehealth_connector.validation.service.schematron;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ehealth_connector.validation.service.transform.TransformationException;
import ehealth_connector.validation.service.util.Exceptions;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XsltExecutable;

/**
 * A factory for compiled <cite>Schematron Validator</cite> stylesheets.
 * <p>
 * This class acts both, as a factory for a single validator and as a cache for
 * the already compiled validators. This class directly or indirectly supports
 * the following features:
 * <ul>
 * <li>Send the results of a transformation step to the next transformer without
 * creating unnecessary intermediate files.</li>
 * <li>Optionally persist the resulting <cite>Schematron Validator</cite> file
 * to disk.</li>
 * <li>Optionally cache the compiled validator stylesheet in memory.</li>
 * <li>Change the execution strategy of the transformation and compilation task.
 * </li>
 * </ul>
 * </p>
 * <h4>Thread Safety</h4>
 * <p>
 * This class is immutable and therefore thread-safe.
 * </p>
 */
public class Validators {
	
	/**
	 * Implementation of an {@link Executor}, which executes the supplied
	 * {@link Runnable} command directly in the current thread.
	 */
	class DirectExecutor implements Executor {
		@Override
		public void execute(Runnable command) {
			command.run();
		}
	}

	private static final String VALIDATOR_FILE_EXTENSION = "-validator.xsl";

	private static final String WORK_DIRECTORY_NAME = "work";

	/** The tread-safe cache for compiled stylesheets. */
	private final ConcurrentHashMap<File, Future<XsltExecutable>> cache = new ConcurrentHashMap<File, Future<XsltExecutable>>();

	/** The executor, to which the tasks are submitted. */
	private final Executor executor;

	/** The <cite>Schematron Rule-Set</cite> transformation factory. */
	private final RuleSetTransformer factory;

	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Creates a new <tt>Validators</tt> instance which relies on the specified
	 * transformer factory for constructing pre-compiled <cite>Schematron
	 * Validator</cite> instances.
	 * <p>
	 * Note that with this constructor the tasks will execute sequentially in
	 * the current thread.
	 * </p>
	 * 
	 * @param factory
	 *            the <cite>Schematron Rule-Set</cite> transformation factory.
	 * @throws NullPointerException
	 *             if the specified factory is <tt>null</tt>.
	 * @see #Validators(RuleSetTransformer, Executor)
	 */
	public Validators(RuleSetTransformer factory) {
		this(factory, null);
	}

	/**
	 * Creates a new <tt>Validators</tt> instance which relies on the specified
	 * transformer factory and <tt>Executor</tt> for constructing pre-compiled
	 * <cite>Schematron Validator</cite> instances.
	 * <p>
	 * A default {@link Executor} is provided, which executes the transformation
	 * and compilation tasks sequentially in the current thread, for the case
	 * where the specified executor is <tt>null</tt>.
	 * </p>
	 * 
	 * @param factory
	 *            the <cite>Schematron Rule-Set</cite> transformation factory.
	 * @param executor
	 *            the executor, to which the transformation and compilation task
	 *            is submitted (<tt>null</tt> allowed).
	 * @throws NullPointerException
	 *             if the specified factory is <tt>null</tt>.
	 */
	public Validators(RuleSetTransformer factory, Executor executor) {
		log.debug("Creating Validators instance ...");
		if (factory == null) {
			throw new NullPointerException("Transformer factory is null.");
		}
		this.factory = factory;
		this.executor = (executor != null ? executor : new DirectExecutor());
	}

	/**
	 * Creates an output file from the specified base file.
	 *
	 * @param base
	 *            the base file, normally the <cite>Schematron Master
	 *            File</cite>.
	 * @return a new output file for the <cite>Schematron Validator</cite>.
	 */
	protected File createOutputFile(File base) {
		String baseName = base.getName();
		int pos = baseName.lastIndexOf(".");
		if (pos >= 0) {
			baseName = baseName.substring(0, pos) + VALIDATOR_FILE_EXTENSION;
		}
		return new File(getWorkDir(), baseName);
	}

	/**
	 * Returns a compiled <cite>Schematron Validator</cite> stylesheet for the
	 * specified input <cite>Schematron Master File</cite>.
	 * <p>
	 * This method tries to get the compiled stylesheet from the cache, and if
	 * it is not present, submits its construction to an underlying
	 * <tt>Executor</tt>.
	 * </p>
	 * <p>
	 * If <tt>cacheable</tt> is <tt>true</tt>, then the compiled stylesheet is
	 * stored in memory for later use. If <tt>cacheable</tt> is <tt>false</tt>,
	 * then the cache is not consulted and each invocation triggers a rebuild of
	 * the compiled stylesheet.
	 * </p>
	 * <p>
	 * Note that this method blocks until the validator is available.
	 * </p>
	 * 
	 * @param in
	 *            the input file (a <cite>Schematron</cite> master file).
	 * @param out
	 *            the output file, where the validator file should be persisted
	 *            (<tt>null</null> allowed).
	 * &#64;param cacheable
	 *    allows/disallows caching of the compiled stylesheet.
	 * &#64;return
	 *    the compiled validator stylesheet.
	 * &#64;throws TransformationException
	 *    if the construction of the compiled stylesheet aborted by throwing
	 *    an exception.
	 * &#64;throws InterruptedException
	 *    if the construction of the compiled stylesheet was interrupted.
	 * &#64;throws NullPointerException
	 *    if the specified input file is <tt>null</tt>.
	 * @see #load(File, File, boolean)
	 */
	public XsltExecutable get(File in, File out, boolean cacheable)
			throws TransformationException, InterruptedException {
		Future<XsltExecutable> f = load(in, out, cacheable);
		try {
			return f.get();
		} catch (InterruptedException e) {
			cache.remove(in);
			throw e;
		} catch (ExecutionException e) {
			if (e.getCause() instanceof TransformationException) {
				throw (TransformationException) e.getCause();
			}
			throw Exceptions.launderThrowable(e);
		}
	}

	/**
	 * Returns a compiled <cite>Schematron Validator</cite> stylesheet for the
	 * specified <cite>Schematron Rule-Set</cite>.
	 * <p>
	 * This method is equivalent to the {@link #get(File, File, boolean)} method
	 * invocation, where the input file and cacheable properties are determined
	 * from the given {@link RuleSet}.
	 * </p>
	 * <p>
	 * If the rule-set is persistable, then the output file equals the value
	 * returned by the {@link #createOutputFile(File)} method.
	 * </p>
	 * <p>
	 * Note that this method blocks until the validator is available.
	 * </p>
	 * 
	 * @param ruleSet
	 *            a valid <cite>Schematron Rule-Set</cite> instance.
	 * @return the compiled validator stylesheet.
	 * @throws TransformationException
	 *             if the construction of the compiled stylesheet aborted by
	 *             throwing an exception.
	 * @throws InterruptedException
	 *             if the construction of the compiled stylesheet was
	 *             interrupted.
	 * @throws NullPointerException
	 *             if the specified rule-set is <tt>null</tt>.
	 * @see #load(RuleSet)
	 * @see #get(File, File, boolean)
	 * @see #createOutputFile(File)
	 */
	public XsltExecutable get(RuleSet ruleSet)
			throws TransformationException, InterruptedException {
		if (ruleSet == null)
			throw new NullPointerException("Rule-Set is null.");
		File in = ruleSet.getPath();
		File out = (ruleSet.isPersistable() ? createOutputFile(in) : null);
		return get(in, out, ruleSet.isCacheable());
	}

	/**
	 * Returns the <cite>Saxon Processor</cite> instance.
	 *
	 * @return the <cite>Saxon Processor</cite> instance.
	 */
	public Processor getProcessor() {
		return factory.getProcessor();
	}

	/**
	 * Returns the absolute path of the work directory.
	 *
	 * @return the absolute path of the directory, where the transformed output
	 *         file goes.
	 */
	protected File getWorkDir() {
		return new File(WORK_DIRECTORY_NAME).getAbsoluteFile();
	}

	/**
	 * Tries to get the compiled stylesheet from the cache, and if it is not
	 * present, submits its construction to an underlying <tt>Executor</tt>.
	 * <p>
	 * If <tt>cacheable</tt> is <tt>true</tt>, then the compiled stylesheet is
	 * stored in memory for later use. If <tt>cacheable</tt> is <tt>false</tt>,
	 * then the cache is not consulted and each invocation triggers a rebuild of
	 * the compiled stylesheet.
	 * </p>
	 * 
	 * @param in
	 *            the input file (a <cite>Schematron</cite> master file).
	 * @param out
	 *            the output file, where the validator file should be persisted
	 *            (<tt>null</null> allowed).
	 * &#64;param cacheable
	 *    allows/disallows caching of the compiled stylesheet.
	 * &#64;return
	 *    the compiled validator stylesheet wrapped in a <tt>Future</tt>.
	 * @throws NullPointerException
	 *             if the specified input file is <tt>null</tt>.
	 */
	public Future<XsltExecutable> load(File in, File out, boolean cacheable) {
		if (in == null)
			throw new NullPointerException("Input file is null.");
		Future<XsltExecutable> f = (cacheable ? cache.get(in) : null);
		if (f == null) {
			Callable<XsltExecutable> c = new ValidatorBuilder(factory, in, out);
			FutureTask<XsltExecutable> ft = new FutureTask<XsltExecutable>(c);
			if (!cacheable || (f = cache.putIfAbsent(in, ft)) == null) {
				f = ft;
				executor.execute(ft);
			}
		}
		return f;
	}

	/**
	 * Tries to get the compiled stylesheet from the cache, and if it is not
	 * present, submits its construction to an underlying <tt>Executor</tt>.
	 * <p>
	 * This method is equivalent to the {@link #load(File, File, boolean)}
	 * method invocation, where the input file and cacheable properties are
	 * determined from the given {@link RuleSet}.
	 * </p>
	 * <p>
	 * If the rule-set is persistable, then the output file equals the value
	 * returned by the {@link #createOutputFile(File)} method.
	 * </p>
	 * 
	 * @param ruleSet
	 *            a valid <cite>Schematron Rule-Set</cite> instance.
	 * @return the compiled validator stylesheet wrapped in a <tt>Future</tt>.
	 * @throws NullPointerException
	 *             if the specified rule-set is <tt>null</tt>.
	 */
	public Future<XsltExecutable> load(RuleSet ruleSet) {
		File in = ruleSet.getPath();
		File out = (ruleSet.isPersistable() ? createOutputFile(in) : null);
		return load(in, out, ruleSet.isCacheable());
	}

}
