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

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * A thread-safe implementation of a generic cache.
 * <p>
 * This implementation is nearly a copy of an example from the excellent book
 * <cite>Java Concurrency In Practice</cite> from <cite>Brian Goetz</cite>.
 * </p>
 *
 * @author L.Millet, February 2013
 *
 * @param <A>
 *            the computable argument.
 * @param <V>
 *            the computed value.
 */
public class Memoizer<A, V> implements Computable<A, V> {

	private final Computable<A, V> c;

	private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

	public Memoizer(Computable<A, V> c) {
		this.c = c;
	}

	@Override
	public V compute(final A arg) throws Exception {
		while (true) {
			Future<V> f = cache.get(arg);
			if (f == null) {
				final Callable<V> eval = new Callable<V>() {
					@Override
					public V call() throws Exception {
						return c.compute(arg);
					}
				};
				final FutureTask<V> ft = new FutureTask<V>(eval);
				if ((f = cache.putIfAbsent(arg, ft)) == null) {
					f = ft;
					ft.run();
				}
			}
			try {
				return f.get();
			} catch (final CancellationException e) {
				cache.remove(arg, f);
			}
		}
	}

	public Future<V> remove(A arg) {
		return cache.remove(arg);
	}

}
