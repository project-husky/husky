/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.valueset.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.husky.common.utils.CustomizedYaml;
import org.husky.valueset.config.ValueSetConfig;
import org.husky.valueset.config.ValueSetPackageConfig;
import org.husky.valueset.enums.ValueSetPackageStatus;
import org.husky.valueset.exceptions.ConfigurationException;
import org.husky.valueset.exceptions.InitializationException;
import org.husky.valueset.model.ValueSetPackage;
import org.xml.sax.SAXException;

/**
 * <div class="en">The Class ValueSetPackageManager is intended to provide all
 * necessary functions to fill, use, download and save value set packages.</div>
 *
 * <div class="de">Der Class ValueSetPackageManager dient dazu alle notwendigen
 * Funktionen zum Befüllen, Verwenden, Herunterladen und Speichern von
 * ValueSet-Paketen bereitzustellen.</div>
 */
public class ValueSetPackageManager {

	/** The value set package config list. */
	private ArrayList<ValueSetPackageConfig> valueSetPackageConfigList;

	/**
	 * <div class="en">Adds a value set package config.</div>
	 *
	 * <div class="de">Fügt eine Wertesatz-Paket-Konfiguration hinzu.</div>
	 *
	 * @param value
	 *            the value
	 */
	public void addValueSetPackageConfig(ValueSetPackageConfig value) {
		if (this.valueSetPackageConfigList == null) {
			this.valueSetPackageConfigList = new ArrayList<>();
		}
		this.valueSetPackageConfigList.add(value);

	}

	/**
	 * <div class="en">Clears the value set package config list.</div>
	 *
	 * <div class="de">Löscht die Konfigurationsliste des Wertesatzpakets.</div>
	 */
	public void clearValueSetPackageConfigList() {
		this.valueSetPackageConfigList = new ArrayList<>();
	}

	/**
	 * <div class="en">Downloads a value set package.</div>
	 *
	 * <div class="de">Lädt ein Wertesatzpaket herunter.</div>
	 *
	 * @param valueSetPackageConfig
	 *            the value set package config
	 * @return the value set package
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the SAX exception
	 * @throws InitializationException
	 *             the initialization exception
	 */
	public ValueSetPackage downloadValueSetPackage(ValueSetPackageConfig valueSetPackageConfig)
			throws IOException, ParserConfigurationException, SAXException,
			InitializationException {
		ValueSetPackage retVal = ValueSetPackage.builder()
				.withDescription(valueSetPackageConfig.getDescription())
				.withIdentificator(valueSetPackageConfig.getIdentificator())
				.withSourceUrl(valueSetPackageConfig.getSourceUrl())
				.withStatus(valueSetPackageConfig.getStatus())
				.withVersion(valueSetPackageConfig.getVersion()).build();

		var valueSetManager = new ValueSetManager();

		for (ValueSetConfig valueSetConfig : valueSetPackageConfig.getValueSetConfigList()) {
			var valueSet = valueSetManager.downloadValueSet(valueSetConfig);
			retVal.addValueSet(valueSet);
		}
		return retVal;
	}

	/**
	 * <div class="en">Downloads a value set package configuration from the
	 * given URL.</div>
	 *
	 * <div class="de">Lädt eine Value-Set-Paketkonfiguration von der
	 * angegebenen URL herunter.</div>
	 *
	 * @param sourceUrl
	 *            the source url
	 * @return the value set package config
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ConfigurationException
	 *             the configuration exception
	 */
	public ValueSetPackageConfig downloadValueSetPackageConfig(String sourceUrl)
			throws IOException, ConfigurationException {
		return downloadValueSetPackageConfig(new URL(sourceUrl));
	}

	/**
	 * <div class="en">Downloads a value set package configuration from the
	 * given URL.</div>
	 *
	 * <div class="de">Lädt eine Value-Set-Paketkonfiguration von der
	 * angegebenen URL herunter.</div>
	 *
	 * @param sourceUrl
	 *            the source url
	 * @return the value set package config
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ConfigurationException
	 *             the configuration exception
	 */
	public ValueSetPackageConfig downloadValueSetPackageConfig(URL sourceUrl)
			throws IOException, ConfigurationException {
		ValueSetPackageConfig retVal = null;
		// download a package config
		var downloadedString = IOUtils.toString(sourceUrl, StandardCharsets.UTF_8);
		retVal = loadValueSetPackageConfig(IOUtils.toInputStream(downloadedString));
		return retVal;
	}

	/**
	 * <div class="en">Gets the latest value set package config. The timestamps
	 * validFrom and validTo are taken in charge for the selection. If multiple
	 * entries have the same conditions, one of them will be returned without
	 * further checks.</div>
	 *
	 * <div class="de">Ruft die Konfiguration des neuesten Wertesatzpakets ab.
	 * Für die Auswahl werden die Zeitstempel validFrom und validTo verwendet.
	 * Wenn mehrere Einträge dieselben Bedingungen haben, wird einer von ihnen
	 * ohne weitere Prüfung zurückgegeben.</div>
	 *
	 * @return the latest value set package config
	 */
	public ValueSetPackageConfig getLatestValueSetPackageConfig() {
		return getLatestValueSetPackageConfigByStatus(null);
	}

	/**
	 * <div class="en">Gets the latest value set package config by status. The
	 * timestamps validFrom and validTo are taken in charge for the selection
	 * and elements not having the given status will be ignored. If multiple
	 * entries have the same conditions, one of them will be returned without
	 * further checks.</div>
	 *
	 * <div class="de">Ruft die Konfiguration des neuesten Wertesatzpakets nach
	 * Status ab. Die Zeitstempel validFrom und validTo werden für die Auswahl
	 * verwendet und Elemente, die nicht den angegebenen Status haben, werden
	 * ignoriert. Wenn mehrere Einträge dieselben Bedingungen haben, wird einer
	 * von ihnen ohne weitere Prüfung zurückgegeben.</div>
	 *
	 * @param status
	 *            the status to be verified
	 * @return the latest value set package config by status
	 */
	public ValueSetPackageConfig getLatestValueSetPackageConfigByStatus(
			ValueSetPackageStatus status) {
		return getValueSetPackageConfigByStatusAndDate(status, null);
	}

	/**
	 * <div class="en">Gets the value set package config by status and date.
	 * Elements not having the given status and elements that are not valid at
	 * the given time will be ignored. From the remaining elements, the latest
	 * one will be returned. If multiple entries have the same conditions, one
	 * of them will be returned without further checks.</div>
	 *
	 * <div class="de">Ruft die Wertesatz-Paketkonfiguration nach Status und
	 * Datum ab. Elemente, die nicht den angegebenen Status haben, und Elemente,
	 * die zum angegebenen Zeitpunkt nicht gültig sind, werden ignoriert. Von
	 * den übrigen Elementen wird das letzte zurückgegeben. Wenn mehrere
	 * Einträge dieselben Bedingungen haben, wird einer von ihnen ohne weitere
	 * Prüfung zurückgegeben.</div>
	 *
	 * @param status
	 *            the status
	 * @param date
	 *            the date
	 * @return the value set package config by status and date
	 */
	public ValueSetPackageConfig getValueSetPackageConfigByStatusAndDate(
			ValueSetPackageStatus status, Date date) {
		ValueSetPackageConfig retVal = null;
		var isCandidate = false;
		Date latestFrom = null;
		Date latestTo = null;
		if (valueSetPackageConfigList != null) {
			for (ValueSetPackageConfig valueSetPackageConfig : valueSetPackageConfigList) {
				isCandidate = false;
				boolean ignoreStatus = (status == null);
				boolean ignoreDate = (date == null);

				if ((ignoreStatus) || (status == valueSetPackageConfig.getStatus())) {
					Date from = valueSetPackageConfig.getVersion().getValidFrom();
					Date to = valueSetPackageConfig.getVersion().getValidTo();

					if (ignoreDate || fitsDate(date, from, to)) {

						if (retVal == null)
							retVal = valueSetPackageConfig;

						if (from != null) {
							if (latestFrom == null)
								latestFrom = from;
						} else
							isCandidate = true;

						if (to != null) {
							if (latestTo == null)
								latestTo = to;
						} else {
							// from null and to null => this always valid
							// -> the first entry makes it
							if (isCandidate)
								retVal = valueSetPackageConfig;
							isCandidate = true;
						}

						if (from != null) {
							if (from.after(latestFrom)) {
								latestFrom = from;
								// in this case, a from candidate with a later
								// from
								// date
								// will
								// get the new choice
								if (isCandidate)
									retVal = valueSetPackageConfig;
								isCandidate = true;
							} else
								isCandidate = false;
						}

						if (to != null) {
							if (to.after(latestTo)) {
								latestTo = to;
								// in this case, a from candidate with a later
								// to
								// date
								// will
								// get the new choice
								if (isCandidate)
									retVal = valueSetPackageConfig;
							}
						} else if (isCandidate)
							// in this case, a from candidate with a null to
							// date
							// will
							// get the new choice
							retVal = valueSetPackageConfig;
					}
				}
			}
		}

		return retVal;

	}

	private boolean fitsDate(Date date, Date from, Date to) {
		boolean dateFits = (date == null);
		if (!dateFits) {
			if (from != null)
				dateFits = ((date.equals(from)) || (date.after(from)));
			if (dateFits && to != null) {
				dateFits = ((date.equals(to)) || (date.before(to)));
			}
		}

		return dateFits;
	}

	/**
	 * <div class="en">Gets the value set package config list.</div>
	 *
	 * <div class="de">Ruft die Liste der Wertesatzpaket-Konfigurationen
	 * ab.</div>
	 *
	 * @return the list
	 */
	public List<ValueSetPackageConfig> listValueSetPackageConfigs() {
		if (this.valueSetPackageConfigList == null) {
			this.valueSetPackageConfigList = new ArrayList<>();
		}
		return this.valueSetPackageConfigList;

	}

	/**
	 * <div class="en">Loads a value set package from the given file.</div>
	 *
	 * <div class="de">Lädt ein Wertesatz-Paket aus der angegebenen Datei.</div>
	 *
	 * @param valueSetPackage
	 *            the value set package
	 * @return the value set package
	 * @throws IOException
	 */
	public ValueSetPackage loadValueSetPackage(File valueSetPackage) throws IOException {
		try (var is = new FileInputStream(valueSetPackage)) {
			return loadValueSetPackage(is);
		}
	}

	/**
	 * <div class="en">Loads a value set package from the given stream.</div>
	 *
	 * <div class="de">Lädt ein Wertesatz-Paket aus dem angegebenen
	 * Stream.</div>
	 *
	 * @param inputStream
	 *            the value set package
	 * @return the value set package
	 */
	public ValueSetPackage loadValueSetPackage(InputStream inputStream) {
		var reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		return CustomizedYaml.getCustomizedYaml().loadAs(reader,
				ValueSetPackage.class);

	}

	/**
	 * <div class="en">Loads a value set package from the given file (the given
	 * filename must contain the relative or full path to access the
	 * file).</div>
	 *
	 * <div class="de">Lädt ein Wertesatz-Paket aus der angegebenen Datei (der
	 * angegebene Dateiname muss den relativen oder vollständigen Pfad
	 * enthalten, um auf die Datei zuzugreifen).</div>
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set package
	 * @throws ConfigurationException
	 *             the configuration exception
	 * @throws IOException
	 */
	public ValueSetPackage loadValueSetPackage(String fileName)
			throws ConfigurationException, IOException {
		return loadValueSetPackage(new File(fileName));

	}

	/**
	 * <div class="en">Loads a value set package configuration from the given
	 * file.</div>
	 *
	 * <div class="de">Lädt eine Wertesatz-Paket-Konfigurationaus der
	 * angegebenen Datei.</div>
	 *
	 * @param config
	 *            the config
	 * @return the value set package config
	 * @throws ConfigurationException
	 *             the configuration exception
	 * @throws IOException
	 */
	public ValueSetPackageConfig loadValueSetPackageConfig(File config)
			throws ConfigurationException, IOException {
		try (var is = new FileInputStream(config)) {
			return loadValueSetPackageConfig(is);
		}
	}

	/**
	 * <div class="en">Loads a value set package configuration from the given
	 * stream.</div>
	 *
	 * <div class="de">Lädt eine Wertesatz-Paket-Konfigurationaus dem
	 * angegebenen Stream.</div>
	 *
	 * @param inputStream
	 *            the config
	 * @return the value set package config
	 * @throws ConfigurationException
	 *             the configuration exception
	 */
	public ValueSetPackageConfig loadValueSetPackageConfig(InputStream inputStream)
			throws ConfigurationException {
		var reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		if (this.valueSetPackageConfigList == null) {
			this.valueSetPackageConfigList = new ArrayList<>();
		}

		ValueSetPackageConfig valueSetPackageConfig;
		try {
			valueSetPackageConfig = CustomizedYaml.getCustomizedYaml().loadAs(reader,
					ValueSetPackageConfig.class);
		} catch (RuntimeException e) {
			throw new ConfigurationException(e.getMessage());
		}

		if (valueSetPackageConfig.getVersion() == null)
			throw new ConfigurationException(
					"ValueSetPackageConfig must contain a version element");
		else if (valueSetPackageConfig.getVersion().getValidFrom() == null)
			throw new ConfigurationException(
					"ValueSetPackageConfig must contain a version element, having a validFrom timestamp");

		valueSetPackageConfigList.add(valueSetPackageConfig);
		return valueSetPackageConfig;

	}

	/**
	 * <div class="en">Loads a value set package configuration from the given
	 * file (the given filename must contain the relative or full path to access
	 * the file).</div>
	 *
	 * <div class="de">Lädt eine Wertesatz-Paket-Konfigurationaus der
	 * angegebenen Datei (der angegebene Dateiname muss den relativen oder
	 * vollständigen Pfad enthalten, um auf die Datei zuzugreifen).</div>
	 *
	 * @param fileName
	 *            the file name
	 * @return the value set package config
	 * @throws ConfigurationException
	 *             the configuration exception
	 * @throws IOException
	 */
	public ValueSetPackageConfig loadValueSetPackageConfig(String fileName)
			throws ConfigurationException, IOException {
		return loadValueSetPackageConfig(new File(fileName));

	}

	/**
	 * <div class="en">Saves a value set package in YAML format into the given
	 * File.</div>
	 *
	 * <div class="de">Speichert ein Wertesatz-Paket im YAML-Format in der
	 * angegebenen Datei.</div>
	 *
	 * @param valueSetPackage
	 *            the value set package
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSetPackage(ValueSetPackage valueSetPackage, File file) throws IOException {
		try (var fileOutputStream = new FileOutputStream(file)) {
			saveValueSetPackage(valueSetPackage, fileOutputStream);
		}
	}

	/**
	 * <div class="en">Saves a value set package in YAML format into the given
	 * output stream.</div>
	 *
	 * <div class="de">Speichert ein Wertesatz-Paket im YAML-Format in der
	 * angegebenen Datei.</div>
	 *
	 * @param valueSetPackage
	 *            the value set package
	 * @param outputStream
	 *            the output stream
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSetPackage(ValueSetPackage valueSetPackage, OutputStream outputStream)
			throws IOException {
		var writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
		writer.write(CustomizedYaml.getCustomizedYaml().dumpAsMap(valueSetPackage));
		writer.flush();
		writer.close();
	}

	/**
	 * <div class="en">Saves a value set package in YAML format into the given
	 * File (the given filename must contain the relative or full path to access
	 * the file).</div>
	 *
	 * <div class="de">Speichert ein Wertesatz-Paket im YAML-Format in der
	 * angegebenen Datei (der angegebene Dateiname muss den relativen oder
	 * vollständigen Pfad enthalten, um auf die Datei zuzugreifen).</div>
	 *
	 * @param valueSetPackage
	 *            the value set package
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSetPackage(ValueSetPackage valueSetPackage, String fileName)
			throws IOException {
		saveValueSetPackage(valueSetPackage, new File(fileName));
	}

	/**
	 * <div class="en">Saves a value set package configuration in YAML format
	 * into the given File.</div>
	 *
	 * <div class="de">Speichert eine Wertesatz-Paket Konfiguration im
	 * YAML-Format in der angegebenen Datei.</div>
	 *
	 * @param config
	 *            the config
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSetPackageConfig(ValueSetPackageConfig config, File file)
			throws IOException {
		FileUtils.writeByteArrayToFile(file,
				CustomizedYaml.getCustomizedYaml().dumpAsMap(config).getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * <div class="en">Saves a value set package configuration in YAML format
	 * into the given output stream.</div>
	 *
	 * <div class="de">Speichert eine Wertesatz-Paket Konfiguration im
	 * YAML-Format in der angegebenen Datei.</div>
	 *
	 * @param config
	 *            the config
	 * @param outputStream
	 *            the output stream
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSetPackageConfig(ValueSetPackageConfig config, OutputStream outputStream)
			throws IOException {
		var writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
		writer.write(CustomizedYaml.getCustomizedYaml().dumpAsMap(config));
		writer.flush();
		writer.close();
	}

	/**
	 * <div class="en">Saves a value set package configuration in YAML format
	 * into the given File (the given filename must contain the relative or full
	 * path to access the file).</div>
	 *
	 * <div class="de">Speichert eine Wertesatz-Paket Konfiguration im
	 * YAML-Format in der angegebenen Datei (der angegebene Dateiname muss den
	 * relativen oder vollständigen Pfad enthalten, um auf die Datei
	 * zuzugreifen).</div>
	 *
	 * @param config
	 *            the config
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveValueSetPackageConfig(ValueSetPackageConfig config, String fileName)
			throws IOException {
		saveValueSetPackageConfig(config, new File(fileName));
	}

}
