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

package ehealth_connector.validation.service.config;

import java.io.File;
import java.io.IOException;

import ehealth_connector.validation.service.config.bind.ConfigurationType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Configures the application given an XML configuration file.
 * Configuring the application involves the following steps:
 * <ul>
 *    <li>parse the underlying XML configuration file</li>
 *    <li>setup the application's home directory</li>
 *    <li>try to create a new <tt>Configuration</tt> instance</li>
 * </ul>
 */
public class Configurator {

  /** The SLF4J logger instance. */
  protected final Logger log = LoggerFactory.getLogger(getClass());

  /** Parser used to process the application's XML configuration file */
  private final ConfigurationParser configurationParser;

  /**
   * Creates a new application configurator, given the specified file.
   *
   * @param file
   *    the application's configuration file.
   * @throws NullPointerException
   *    if the specified configuration file is <tt>null</tt>.
   */
  public Configurator(File file) {
    this.configurationParser = new ConfigurationParser(file);
  }

  /**
   * Returns the parser used to process the application's XML
   * configuration file.
   *
   * @return
   *    the configuration parser.
   */
  protected ConfigurationParser getConfigurationParser() {
    return configurationParser;
  }

  /**
   * Creates a new <tt>Configuration</tt> instance. This method parses the
   * underlying configuration file, sets-up the application's home directory
   * and tries to create a new {@link Configuration} instance.
   *
   * @return
   *    a new {@link Configuration} instance.
   * @throws ConfigurationException
   *    if the configuration file cannot be opened for reading, is not valid,
   *    or if any unexpected errors occur while unmarshalling and when
   *    an I/O error occurs, when constructing the canonical pathname of
   *    the application's home directory.
   * @throws IllegalArgumentException
   *    if no implementation of the schema language is available.
   */
  public Configuration createConfiguration() throws ConfigurationException {
    ConfigurationType configurationType = getConfigurationParser().parse();
    setupHomeDirectory(configurationType);
    return new Configuration(configurationType);
  }

  /**
   * Sets-up the application's home directory.
   * <p>
   * The default location used as the application's home directory is the
   * directory where the configuration file resides. If this directory is
   * not available, then the current working directory is used instead.
   * </p><p>
   * The application's home directory is set accordingly to the value of
   * the <tt>baseDir</tt> attribute of the <tt>&lt;configuration&gt;</tt>
   * element. If this attribute is not present, then the default location
   * is used. If the path denoted by the value of the <tt>baseDir</tt>
   * attribute is not absolute, then it will be relative to the default
   * location. 
   * </p>
   * @param configurationType
   *    the unmarshalled <tt>&lt;configuration&gt;</tt> element.
   * @throws ConfigurationException
   *    If an I/O error occurs, when constructing the canonical pathname.
   */
  protected void setupHomeDirectory(ConfigurationType configurationType)
  throws ConfigurationException {
    File defaultDir = getConfigurationParser().getConfigFile().getParentFile();
    if (defaultDir == null) defaultDir = new File(".");

    String homeDirName;
    File homeDir;
    if ((homeDirName = configurationType.getBaseDir().getAbsolutePath()) == null) {
      homeDir = defaultDir;
    } else if (!(homeDir = new File(homeDirName)).isAbsolute()) {
      homeDir = new File(defaultDir, homeDirName);
    }
    try {
      homeDir = homeDir.getCanonicalFile();
    } catch (IOException e) {
      throw new ConfigurationException(e);
    }
    log.info("Setting application base directory to '{}'", homeDir);
    System.setProperty("user.dir", homeDir.getPath());
  }

}
