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
import java.util.Calendar;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.ehealth_connector.valueset.config.ValueSetConfig;
import org.ehealth_connector.valueset.model.ValueSet;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

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
		DumperOptions options = new DumperOptions();
		options.setTimeZone(Calendar.getInstance().getTimeZone());
		Yaml yaml = new Yaml(options);

		ValueSetConfig valueSetConfig = yaml.loadAs(reader, ValueSetConfig.class);

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

		DumperOptions options = new DumperOptions();
		options.setTimeZone(Calendar.getInstance().getTimeZone());
		Yaml yaml = new Yaml(options);

		ValueSet valueSet = yaml.loadAs(reader, ValueSet.class);

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
		DumperOptions options = new DumperOptions();
		options.setTimeZone(Calendar.getInstance().getTimeZone());
		Yaml yaml = new Yaml(options);
		FileUtils.writeByteArrayToFile(file, yaml.dumpAsMap(valueSet).getBytes(Charsets.UTF_8));
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
		DumperOptions options = new DumperOptions();
		options.setTimeZone(Calendar.getInstance().getTimeZone());
		Yaml yaml = new Yaml(options);
		FileUtils.writeByteArrayToFile(file,
				yaml.dumpAsMap(valueSetConfig).getBytes(Charsets.UTF_8));
	}

	public void saveValueSetConfig(ValueSetConfig valueSetConfig, String fileName)
			throws IOException {
		saveValueSetConfig(valueSetConfig, new File(fileName));
	}

}
