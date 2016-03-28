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

/**
 * Indicates on error in the application's XML configuration file.
 */
public class ConfigurationException extends Exception {
  private static final long serialVersionUID = 2656763986361768313L;

  /**
   * Constructs a new <tt>ConfigurationException</tt> with no detail
   * message.
   */
  public ConfigurationException() {}

  /**
   * Constructs a new <tt>ConfigurationException</tt> with the given
   * error detail message.
   * 
   * @param message
   *    the detail message.
   */
  public ConfigurationException(String message) {
    super(message);
  }

  /**
   * Constructs a new <tt>ConfigurationException</tt> with the specified
   * nested throwable cause and no detail message.
   * 
   * @param cause
   *    the cause leading this exception to be thrown.
   */
  public ConfigurationException(Throwable cause) {
    super(cause);
  }

  /**
   * Constructs a new <tt>ConfigurationException</tt> with the given
   * error detail message and the nested throwable cause.
   * 
   * @param message
   *    the detail message.
   * @param cause
   *    the cause leading this exception to be thrown.
   */
  public ConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }

}
