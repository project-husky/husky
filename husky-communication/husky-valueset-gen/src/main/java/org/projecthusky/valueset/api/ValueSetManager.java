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
package org.projecthusky.valueset.api;

import org.apache.commons.io.IOUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.utils.CustomizedYaml;
import org.projecthusky.valueset.config.ValueSetConfig;
import org.projecthusky.valueset.enums.SourceFormatType;
import org.projecthusky.valueset.enums.SourceSystemType;
import org.projecthusky.valueset.exceptions.InitializationException;
import org.projecthusky.valueset.model.ValueSet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Manages the handling of ValueSets such as download from an URL, save to and load from a file.
 */
public class ValueSetManager {

    /**
     * Downloads a value set as defined in the given configuration.
     *
     * @param valueSetConfig the value set config
     * @return the value set
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws InitializationException
     */
    @Nullable
    public ValueSet downloadValueSet(ValueSetConfig valueSetConfig)
            throws ParserConfigurationException, SAXException, InitializationException {
        if (valueSetConfig == null) {
            return null;
        }
        if (valueSetConfig.getSourceSystemType() == SourceSystemType.ARTDECOR_FHIR) {
            final var sourceUrlString = valueSetConfig.getSourceUrl();
            final var manager = new ArtDecorValueSetManager();
            var downloadedString = "";
            try {
                downloadedString = IOUtils.toString(new URL(sourceUrlString), StandardCharsets.UTF_8);
                downloadedString = downloadedString.replace("&lt;", "<");
                downloadedString = downloadedString.replace("&gt;", ">");
                downloadedString = downloadedString.replace("&amp;", "&");
                downloadedString = downloadedString.replace("&#160;", "&nbsp;");
                downloadedString = downloadedString.replace("&nbsp;", " ");
                downloadedString = downloadedString.replace("\r\n", "\n");
                switch (valueSetConfig.getSourceFormatType()) {
                    case JSON:
                        return manager.loadValueSetJson(IOUtils.toInputStream(downloadedString,
                                                                                StandardCharsets.UTF_8));
                    case XML:
                        return manager.loadValueSetXml(IOUtils.toInputStream(downloadedString,
                                                                               StandardCharsets.UTF_8));
                    case IHESVS:
                        return manager.loadValueSetIheSvs(IOUtils.toInputStream(downloadedString,
                                                                                  StandardCharsets.UTF_8));
                }
            } catch (RuntimeException e) {
                throw new InitializationException(
                        "The value set cannot be loaded. Please check the content of the file/stream. (downloadedString is: '"
                                + downloadedString + "')");
            } catch (IOException e) {
                throw new InitializationException(
                        "The value set cannot be loaded. Please check the location. (downloadedString is: '"
                                + sourceUrlString + "')");

            }
        } else if (valueSetConfig.getSourceSystemType() == SourceSystemType.FHIR) {
            final var manager = new FhirValueSetManager();
            if (valueSetConfig.getSourceFormatType() == SourceFormatType.JSON) {
                try {
                    return manager.loadValueSetJson(new URL(valueSetConfig.getSourceUrl()).openStream());
                } catch (final MalformedURLException exception) {
                    throw new InitializationException(
                            "The value set cannot be loaded. Please check the URL '"+valueSetConfig.getSourceUrl()+"'.");
                } catch (IOException e) {
                    throw new InitializationException(
                            "The value set cannot be loaded. Please check the location.");

                }

            }
        }
        return null;
    }

    /**
     * Downloads a value set as defined in the given configuration. It will be returned in raw dformat exactly as
     * downloaded.
     *
     * @param valueSetConfig the value set config
     * @return the output stream
     * @throws IOException
     * @throws MalformedURLException
     */
    public byte[] downloadValueSetRaw(ValueSetConfig valueSetConfig) throws IOException {
        byte[] retVal = null;
        if (valueSetConfig != null && SourceSystemType.ARTDECOR_FHIR.equals(valueSetConfig.getSourceSystemType())) {
            retVal = IOUtils.toByteArray(new URL(valueSetConfig.getSourceUrl()));
        }
        return retVal;
    }

    /**
     * Loads a value set config from the given file.
     *
     * @param config the config
     * @return the value set config
     * @throws IOException
     */
    public ValueSetConfig loadValueSetConfig(File config) throws IOException {
        try (var is = new FileInputStream(config)) {
            return loadValueSetConfig(is);
        }
    }

    /**
     * Loads a value set config from the given stream.
     *
     * @param inputStream the config
     * @return the value set config
     */
    public ValueSetConfig loadValueSetConfig(InputStream inputStream) {
        var reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return CustomizedYaml.getCustomizedYaml().loadAs(reader, ValueSetConfig.class);
    }

    /**
     * Loads a value set config from the given file (the given filename must contain the relative or full path to access
     * the file).
     *
     * @param fileName the file name
     * @return the value set config
     * @throws IOException
     */
    public ValueSetConfig loadValueSetConfig(String fileName) throws IOException {
        return loadValueSetConfig(new File(fileName));
    }

    /**
     * Loads a value set from the given file, which is provided in YAML format.
     *
     * @param valueSet the value set
     * @return the value set
     * @throws IOException
     */
    public ValueSet loadValueSetYaml(File valueSet) throws IOException {
        try (var is = new FileInputStream(valueSet)) {
            return loadValueSetYaml(is);
        }
    }

    /**
     * Loads a value set from the given stream, which is provided in YAML format.
     *
     * @param inputStream the value set
     * @return the value set
     */
    public ValueSet loadValueSetYaml(InputStream inputStream) {
        var reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return CustomizedYaml.getCustomizedYaml().loadAs(reader, ValueSet.class);
    }

    /**
     * Loads a value set from the given file, which is provided in YAML format (the given filename must contain the
     * relative or full path to access the file).
     *
     * @param fileName the file name
     * @return the value set
     * @throws IOException
     */
    public ValueSet loadValueSetYaml(String fileName) throws IOException {
        return loadValueSetYaml(new File(fileName));
    }

    /**
     * Saves the given value set in YAML format to the given file.
     *
     * @param valueSet the value set
     * @param file     the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void saveValueSet(ValueSet valueSet, File file) throws IOException {
        try (var fileOutputStream = new FileOutputStream(file)) {
            saveValueSet(valueSet, fileOutputStream);
        }
    }

    /**
     * Saves the given value set in YAML format to the given output stream.
     *
     * @param valueSet     the value set
     * @param outputStream the outputStream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void saveValueSet(ValueSet valueSet, OutputStream outputStream) throws IOException {
        var writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        writer.write(CustomizedYaml.getCustomizedYaml().dumpAsMap(valueSet));
        writer.flush();
        writer.close();
    }

    /**
     * Saves the given value set in YAML format to the given file (the given filename must contain the relative or full
     * path to access the file).
     *
     * @param valueSet the value set
     * @param fileName the file name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void saveValueSet(ValueSet valueSet, String fileName) throws IOException {
        saveValueSet(valueSet, new File(fileName));
    }

    /**
     * Saves the given value set configuration in YAML format to the given file.
     *
     * @param valueSetConfig the value set config
     * @param file           the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void saveValueSetConfig(ValueSetConfig valueSetConfig, File file) throws IOException {
        try (var fileOutputStream = new FileOutputStream(file)) {
            saveValueSetConfig(valueSetConfig, fileOutputStream);
        }
    }

    /**
     * Saves the given value set configuration in YAML format to the given output stream.
     *
     * @param valueSetConfig the value set config
     * @param outputStream   the outputStream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void saveValueSetConfig(ValueSetConfig valueSetConfig, OutputStream outputStream) throws IOException {
        var writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        writer.write(CustomizedYaml.getCustomizedYaml().dumpAsMap(valueSetConfig));
        writer.flush();
        writer.close();
    }

    /**
     * Saves the given value set configuration in YAML format to the given file (the given filename must contain the
     * relative or full path to access the file).
     *
     * @param valueSetConfig the value set config
     * @param fileName       the file name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void saveValueSetConfig(ValueSetConfig valueSetConfig, String fileName) throws IOException {
        saveValueSetConfig(valueSetConfig, new File(fileName));
    }
}
