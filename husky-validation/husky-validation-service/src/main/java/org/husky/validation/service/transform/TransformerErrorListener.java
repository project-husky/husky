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

package org.husky.validation.service.transform;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXParseException;

/**
 * An <tt>ErrorListener</tt> which collects warnings and errors that occur
 * during XML parsing, validation or transformation.
 *
 * <h4>Thread Safety</h4>
 * <p>
 * This class is not thread-safe but it may be reused repeatedly within a single
 * thread. Call the {@link #clear()} method to reset the collected errors and
 * warnings.
 * </p>
 */
public class TransformerErrorListener implements ErrorListener {

	/** Maximum number of recorded exceptions. */
	private static final int SIZE_LIMIT = 10;

	public static String explainException(TransformerException exception) {
		final StringBuilder sb = new StringBuilder();
		final String location = getLocationString(exception);
		if (location != null) {
			sb.append("Error on " + location);
		}
		for (Throwable e = exception.getCause(); e != null; e = e.getCause()) {
			if (e instanceof SAXParseException) {
				sb.append("Error reported by XML parser");
			} else {
				sb.append(e.getClass().getSimpleName());
			}
			sb.append(": " + e.getLocalizedMessage());
			if (e.getCause() != null)
				sb.append("\n");
		}
		return sb.toString();
	}

	private static String getFileName(String uri) {
		final int pos = uri.lastIndexOf("/");
		if ((pos >= 0) && (pos < (uri.length() - 1))) {
			return uri.substring(pos + 1);
		}
		return uri;
	}

	private static String getLocationString(TransformerException exception) {
		SourceLocator locator;
		if ((locator = exception.getLocator()) != null) {
			return "line " + locator.getLineNumber() + " column " + locator.getColumnNumber()
					+ " of " + getFileName(locator.getSystemId());
		} else if (exception.getCause() instanceof SAXParseException) {
			final SAXParseException e = (SAXParseException) exception.getCause();
			return "line " + e.getLineNumber() + " column " + e.getColumnNumber() + " of "
					+ getFileName(e.getSystemId());
		}
		return null;
	}

	private List<Exception> errors;

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	private List<Exception> warnings;

	/**
	 * Clears all recorded exceptions.
	 */
	public void clear() {
		warnings = null;
		errors = null;
	}

	@Override
	public void error(TransformerException exception) throws TransformerException {
		handleError(exception);
	}

	@Override
	public void fatalError(TransformerException exception) throws TransformerException {
		handleError(exception);
	}

	/**
	 * @return the list of recorded errors or <tt>null</tt> if there are no
	 *         errors.
	 */
	public Exception[] getErrors() {
		if (errors != null) {
			return errors.toArray(new Exception[0]);
		}
		return null;
	}

	/**
	 * @return the list of recorded warnings or <tt>null</tt> if there are no
	 *         warnings.
	 */
	public Exception[] getWarnings() {
		if (warnings != null) {
			return warnings.toArray(new Exception[0]);
		}
		return null;
	}

	protected void handleError(TransformerException e) {
		for (final String s : explainException(e).split("\n")) {
			log.error(s);
		}
		if (errors == null) {
			errors = new ArrayList<Exception>();
		}
		if (errors.size() < SIZE_LIMIT) {
			errors.add(e);
			if (errors.size() == SIZE_LIMIT) {
				log.warn("Recorded errors reached limit of " + SIZE_LIMIT
						+ " entries. No more errors will be recorded.");
			}
		}
	}

	protected void handleWarning(TransformerException e) {
		for (final String s : explainException(e).split("\n")) {
			log.warn(s);
		}
		if (warnings == null) {
			warnings = new ArrayList<Exception>();
		}
		if (warnings.size() < SIZE_LIMIT) {
			warnings.add(e);
			if (warnings.size() == SIZE_LIMIT) {
				log.warn("Recorded warnings reached limit of " + SIZE_LIMIT
						+ " entries. No more warnings will be recorded.");
			}
		}
	}

	/**
	 * Indicates whether this <tt>ErrorListener</tt> recorded some errors.
	 *
	 * @return <tt>true</tt> if some error is available.
	 */
	public boolean hasErrors() {
		return (errors != null);
	}

	/**
	 * Indicates whether this <tt>ErrorListener</tt> recorded some warnings.
	 *
	 * @return <tt>true</tt> if some warning is available.
	 */
	public boolean hasWarnings() {
		return (warnings != null);
	}

	@Override
	public void warning(TransformerException exception) throws TransformerException {
		handleWarning(exception);
	}

}
