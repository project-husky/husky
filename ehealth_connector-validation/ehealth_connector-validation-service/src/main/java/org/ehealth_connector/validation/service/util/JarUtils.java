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

package org.ehealth_connector.validation.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Utility methods related to <cite>Java Jar</cite> files.
 *
 * @author L.Millet, March 2013
 */
public class JarUtils {
	public static final char separatorChar = '/';
	public static final String separator = new Character(separatorChar).toString();

	/**
	 * Returns the <cite>Manifest</cite> given a <tt>Class</tt> instance.
	 *
	 * @param clazz
	 * @return the <cite>Manifest</cite>.
	 * @throws IOException
	 *             if an I/O exception occurs.
	 * @throws NullPointerException
	 *             if the specified class is <tt>null</tt>.
	 */
	public static Manifest getManifest(Class<?> clazz) throws IOException {
		InputStream is = null;
		try {
			is = new URL(getResourceUri(JarFile.MANIFEST_NAME, clazz)).openStream();
			return new Manifest(is);
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (final IOException e) {
				}
		}
	}

	public static String getPackageUri(Class<?> clazz) {
		if (clazz == null) {
			throw new NullPointerException("Class is null.");
		}
		final String className = clazz.getSimpleName() + ".class";
		final String classPath = clazz.getResource(className).toString();
		Package pkg;
		if (classPath.startsWith("jar")) {
			return classPath.substring(0, classPath.lastIndexOf("!") + 1);
		} else if ((pkg = clazz.getPackage()) != null) {
			final String packagePath = pkg.getName().replace('.', separatorChar);
			return classPath.substring(0, classPath.lastIndexOf(packagePath) - 1);
		} else {
			return classPath.substring(0, classPath.lastIndexOf(separator));
		}
	}

	public static String getRelativeUri(String uri, Class<?> clazz) {
		final String path = uri.substring(getPackageUri(clazz).length());
		int index = 0;
		while (path.charAt(index) == separatorChar)
			++index;
		return path.substring(index);
	}

	/**
	 * Returns the full path of a specified resource given a <tt>Class</tt>
	 * instance. The specified class may be packaged in a Jar file or stand
	 * outside any archive.
	 *
	 * @param pathname
	 *            the relative path of the resource (<tt>null</tt> allowed).
	 * @param clazz
	 *            a class within the same package or Jar file as the resource.
	 * @return the full path of the specified resource.
	 * @throws NullPointerException
	 *             if the specified class is <tt>null</tt>.
	 */
	public static String getResourceUri(String pathname, Class<?> clazz) {
		return (getPackageUri(clazz) + (pathname != null ? (separator + pathname) : ""));
	}

}
