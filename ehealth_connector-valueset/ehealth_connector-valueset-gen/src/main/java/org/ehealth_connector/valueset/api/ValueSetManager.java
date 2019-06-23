/*
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
package org.ehealth_connector.valueset.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.valueset.config.CustomizedYaml;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.model.ValueSet;

/**
 *
 * <div class="en">TODO</div> <div class="de">TODO: Die Methode
 * dowloadValueSet(..) soll immer ein JSON der gleichen Struktur zurückliefern.
 * Die Konvertierung der verschiedenen Quellformate und abweichenden Strukturen
 * ist im Download- anstelle Load-Teil zu lösen. Eine zusätzliche
 * Download-Methode bietet die Option das ValueSet im RAW-Format des
 * Quellsystems 1:1 herunterzuladen. Diese Methode wird jedoch vom
 * ValueSetPackageManager nicht direkt genutzt jedoch intern in der Methode
 * downloadValueSet(..) verwendet.</div>
 */
public class ValueSetManager {

	/**
	 * <div class="en">The default encoding used to encode URL parameter.</div>
	 */
	private static final String UTF8_ENCODING = "UTF-8";

	/**
	 * <div class="en">Build the complete URL to retrieve a value set JSON
	 * configuration from ART-DECOR.</div>
	 *
	 * @param baseUrl
	 *            The base URL that includes host, path and prefix.
	 * @param valueSet
	 *            The parsed value set configuration containing the ID and date
	 *            to use.
	 * @return The complete URL to download a value set in JSON format.
	 * @throws MalformedURLException
	 *             When the provided baseUrl is invalid.
	 */
	public static URL buildValueSetArtDecorUrl(String baseUrl, IdentificatorBaseType id,
			Date effectiveDate) throws MalformedURLException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			return new URL(baseUrl + "&id="
					+ java.net.URLEncoder.encode(id.getRoot(), UTF8_ENCODING) + "&effectiveDate="
					+ java.net.URLEncoder.encode(dateFormat.format(effectiveDate), UTF8_ENCODING));
		} catch (UnsupportedEncodingException unsupportedEncodingException) {
			throw new MalformedURLException(unsupportedEncodingException.getMessage());
		}
	}

	public OutputStream downloadValueSetAsJson(ValueSetConfig valueSetConfig) {
		// TODO
		return null;
	}

	public OutputStream downloadValueSetRaw(ValueSetConfig valueSetConfig) {
		// TODO
		return null;
	}

	public ValueSetConfig loadValueSetConfig(File config) throws FileNotFoundException {
		return loadValueSetConfig(new FileInputStream(config));
	}

	public ValueSetConfig loadValueSetConfig(InputStream config) {
		return loadValueSetConfig(new InputStreamReader(config, Charsets.UTF_8));
	}

	public ValueSetConfig loadValueSetConfig(InputStreamReader reader) {
		ValueSetConfig valueSetConfig = CustomizedYaml.getCustomizedYaml().loadAs(reader,
				ValueSetConfig.class);
		return valueSetConfig;
	}

	public ValueSetConfig loadValueSetConfig(String fileName) throws FileNotFoundException {
		return loadValueSetConfig(new File(fileName));
	}

	public ValueSet loadValueSetIheSvs(File valueSet) throws FileNotFoundException {
		return loadValueSetIheSvs(new FileInputStream(valueSet));
	}

	public ValueSet loadValueSetIheSvs(InputStream valueSet) {
		return loadValueSetIheSvs(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	public ValueSet loadValueSetIheSvs(InputStreamReader reader) {
		ValueSet valueSet = null;
		// TODO
		return valueSet;
	}

	public ValueSet loadValueSetIheSvs(String fileName) throws FileNotFoundException {
		return loadValueSetIheSvs(new File(fileName));
	}

	public ValueSet loadValueSetJson(File valueSet) throws FileNotFoundException {
		return loadValueSetJson(new FileInputStream(valueSet));
	}

	public ValueSet loadValueSetJson(InputStream valueSet) {
		return loadValueSetJson(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	public ValueSet loadValueSetJson(InputStreamReader reader) {
		ValueSet valueSet = null;
		// TODO
		return valueSet;
	}

	public ValueSet loadValueSetJson(String fileName) throws FileNotFoundException {
		return loadValueSetJson(new File(fileName));
	}

	public ValueSet loadValueSetYaml(File valueSet) throws FileNotFoundException {
		return loadValueSetYaml(new FileInputStream(valueSet));
	}

	public ValueSet loadValueSetYaml(InputStream valueSet) {
		return loadValueSetYaml(new InputStreamReader(valueSet, Charsets.UTF_8));
	}

	public ValueSet loadValueSetYaml(InputStreamReader reader) {
		ValueSet valueSet = CustomizedYaml.getCustomizedYaml().loadAs(reader, ValueSet.class);
		return valueSet;
	}

	public ValueSet loadValueSetYaml(String fileName) throws FileNotFoundException {
		return loadValueSetYaml(new File(fileName));
	}

	/**
	 * Save value set.
	 *
	 * @param valueSet
	 *            the value set
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSet(ValueSet valueSet, File file) throws IOException {
		FileUtils.writeByteArrayToFile(file,
				CustomizedYaml.getCustomizedYaml().dumpAsMap(valueSet).getBytes(Charsets.UTF_8));
	}

	/**
	 * Save value set.
	 *
	 * @param valueSet
	 *            the value set
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSet(ValueSet valueSet, String fileName) throws IOException {
		saveValueSet(valueSet, new File(fileName));
	}

	public void saveValueSetConfig(ValueSetConfig valueSetConfig, File file) throws IOException {
		FileUtils.writeByteArrayToFile(file, CustomizedYaml.getCustomizedYaml()
				.dumpAsMap(valueSetConfig).getBytes(Charsets.UTF_8));
	}

	public void saveValueSetConfig(ValueSetConfig valueSetConfig, String fileName)
			throws IOException {
		saveValueSetConfig(valueSetConfig, new File(fileName));
	}

}
