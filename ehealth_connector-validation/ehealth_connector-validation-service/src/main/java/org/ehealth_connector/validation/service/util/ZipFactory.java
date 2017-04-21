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

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * A ZIP factory, able to recursively compress files and directories.
 *
 * @author L.Millet, April 2012/2013
 */
public class ZipFactory {

	/** Size of the data buffer used in read operations. */
	private final static int READ_BUFFER_SIZE = 4096;

	/**
	 * Reads data from the input stream till end of file and writes it out to
	 * the output stream.
	 *
	 * @param in
	 *            the stream from which data is read.
	 * @param out
	 *            the stream to which data is written.
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	private static void copyData(InputStream in, OutputStream out) throws IOException {
		final byte[] data = new byte[READ_BUFFER_SIZE];
		int bytesRead = 0;
		while ((bytesRead = in.read(data)) != -1) {
			out.write(data, 0, bytesRead);
		}
	}

	/** An optional file filter. */
	private FileFilter filter;

	/** Enables/disables storing just the name (junk the path). */
	private boolean flatten = false;

	/** The SLF4J logger instance. */
	// protected final Logger log = LoggerFactory.getLogger(getClass());

	private final OutputStream out;

	/** Enables/disables traveling the directory structure recursively. */
	private boolean recursive = false;

	/** The ZIP output stream. */
	private ZipOutputStream zos;

	/**
	 * Creates a new ZIP factory, which outputs the compressed data to standard
	 * output.
	 */
	public ZipFactory() {
		this(System.out, null);
	}

	/**
	 * Creates a new ZIP factory, which outputs the compressed data to the
	 * specified output stream.
	 *
	 * @param out
	 *            the output stream where the data is written.
	 * @throws NullPointerException
	 *             if the specified output stream is <tt>null</tt>.
	 */
	public ZipFactory(OutputStream out) {
		this(out, null);
	}

	/**
	 * Creates a new ZIP factory, which outputs the compressed data to the
	 * specified output stream. If specified, only files passing the file filter
	 * are included in the archive.
	 *
	 * @param out
	 *            the output stream where the data is written.
	 * @param filter
	 *            a file filter (may be <tt>null</tt>).
	 * @throws NullPointerException
	 *             if the specified output stream is <tt>null</tt>.
	 */
	public ZipFactory(OutputStream out, FileFilter filter) {
		if (out == null) {
			throw new NullPointerException("OutputStream is null");
		}
		this.out = out;
		this.filter = filter;
	}

	/**
	 * Adds a new ZIP file entry. If the specified path is a directory, add
	 * recursively all files found in this directory.
	 *
	 * Note that empty directories will not appear in the ZIP file.
	 *
	 * @param path
	 *            the path of a directory or a regular file to be added.
	 * @throws FileNotFoundException
	 *             if the specified path is a regular file and does not exist or
	 *             if the path could not be read for some other reason.
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	public void addEntry(File path) throws FileNotFoundException, IOException {
		if (path == null) {
			throw new NullPointerException("Path must not be null");
		} else if (!(path = path.getCanonicalFile()).exists()) {
			throw new FileNotFoundException("Path does not exist: '" + path + "'");
		} else if (path.isFile()) {
			addEntry(path, null);
		} else if (path.isDirectory() && isRecursive()) {
			final File base = path;
			final Deque<File> queue = new LinkedList<File>();
			queue.push(path);
			File directory;
			while ((directory = queue.poll()) != null) {
				addEntry(directory, base);
				for (final File file : directory.listFiles(filter)) {
					if (file.isDirectory()) {
						queue.push(file);
					} else {
						addEntry(file, base);
					}
				}
			}
		}
	}

	/**
	 * Adds a new Zip entry.
	 *
	 * @param path
	 *            path of the file to add.
	 * @param base
	 *            base path used for constructing the relative path.
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	private void addEntry(File path, File base) throws IOException {
		String entryName;
		if (isFlatten()) {
			entryName = path.getName();
		} else if (path.isAbsolute() && (base != null)) {
			entryName = base.toURI().relativize(path.toURI()).toString();
		} else {
			entryName = path.getPath();
		}
		if (path.isDirectory() && !entryName.endsWith("/")) {
			entryName += "/";
		}
		// Add a new entry and copy the file's data
		// log.debug("Adding Zip Entry: '" + entryName + "'");
		InputStream in = null;
		try {
			final ZipOutputStream zos = getZipOutputStream();
			zos.putNextEntry(new ZipEntry(entryName));
			if (path.isFile()) {
				in = new FileInputStream(path);
				copyData(in, zos);
			}
			zos.closeEntry();
		} finally {
			if (in != null)
				in.close();
		}
	}

	/**
	 * Adds a new ZIP file entry. If the specified path is a directory, add
	 * recursively all files found in this directory.
	 *
	 * Note that empty directories will not appear in the ZIP file.
	 *
	 * @param pathName
	 *            the path name of a directory or a regular file to be added.
	 * @throws FileNotFoundException
	 *             if the specified path is a regular file and does not exist or
	 *             if the path could not be read for some other reason.
	 * @throws IOException
	 *             if an I/O error occurs.
	 * @throws NullPointerException
	 *             if the specified path name is <code>null</code>.
	 */
	public void addEntry(String pathName) throws FileNotFoundException, IOException {
		addEntry(new File(pathName));
	}

	/**
	 * Closes the current ZIP entry, the ZIP output stream and the stream being
	 * filtered.
	 *
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	public void close() throws IOException {
		if (zos != null) {
			zos.close();
		}
	}

	/**
	 * Returns the output stream lazy creating it from the ZIP file name. If the
	 * file name is a single dash "-", the compressed data is sent to standard
	 * output.
	 *
	 * @return the output stream.
	 * @throws FileNotFoundException
	 */
	protected ZipOutputStream getZipOutputStream() throws FileNotFoundException {
		if (zos == null) {
			zos = new ZipOutputStream(out);
		}
		return zos;
	}

	/**
	 * Indicates whether to store the path or not.
	 *
	 * @return <code>true</code> if the path is to be removed,
	 *         <code>false</code> if the full relative path is to be stored.
	 */
	public boolean isFlatten() {
		return flatten;
	}

	/**
	 * Indicates whether the directory structure is traveled recursively.
	 *
	 * @return <code>true</code> if the directory structure is traveled
	 *         recursively, <code>false</code> if not.
	 */
	public boolean isRecursive() {
		return recursive;
	}

	/**
	 * Sets if the path is to be removed or not.
	 *
	 * @param flatten
	 *            flag enabling/disabling the flat file name mode.
	 */
	public void setFlatten(boolean flatten) {
		this.flatten = flatten;
	}

	/**
	 * Sets if the directory structure should be traveled recursively.
	 *
	 * @param recursive
	 *            flag enabling/disabling recursive mode.
	 */
	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}

}
