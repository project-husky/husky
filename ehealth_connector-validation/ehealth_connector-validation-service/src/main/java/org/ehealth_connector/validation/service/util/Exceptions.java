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

package org.ehealth_connector.validation.service.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Some static utility functions related to exception.
 *
 * @author L.Millet, February 2013
 */
public class Exceptions {

	/**
	 * Returns the specified exception and all of its possibly nested causes.
	 * <p>
	 * If <tt>reverse</tt> is <tt>true</tt>, then the exception and its causes
	 * are returned in reverse order, that is, the root cause will be the first
	 * element of the array.
	 * </p>
	 * <p>
	 * If the specified exception is <tt>null</tt>, then an empty array is
	 * returned.
	 * </p>
	 * 
	 * @param e
	 *            an exception instance.
	 * @param reverse
	 *            if <tt>true</tt>, return the throwables in reverse order.
	 * @return the specified exception and all its nested causes as an array of
	 *         {@link Throwable}s.
	 */
	public static Throwable[] getExceptionCauses(Throwable e, boolean reverse) {
		List<Throwable> throwables = new ArrayList<Throwable>();
		for (; e != null; e = e.getCause())
			throwables.add(e);
		if (reverse)
			Collections.reverse(throwables);
		return throwables.toArray(new Throwable[0]);
	}

	/**
	 * Coerces an unchecked <tt>Throwable</tt> to a <tt>RuntimeException</tt>.
	 * <p>
	 * This method is from the book <cite>Java Concurrency In Practice</cite>.
	 * </p>
	 * 
	 * @param t
	 *            the <tt>Throwable</tt> instance.
	 * @return a <tt>RuntimeException</tt>.
	 * @throws Error
	 *             if the <tt>Throwable</tt> is an <tt>Error</tt>.
	 * @throws IllegalStateException
	 *             if the <tt>Throwable</tt> is an unchecked exception.
	 */
	public static RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException) {
			return (RuntimeException) t;
		} else if (t instanceof Error) {
			throw (Error) t;
		} else {
			throw new IllegalStateException("Not unchecked", t);
		}
	}

}
