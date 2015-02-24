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
 * Attribution-ShareAlike 3.0 Switzerland License.
 * 
 * Year of publication: 2014
 * 
 *******************************************************************************/

package org.ehealth_connector.communication;


/**
 * The Class Response.
 */
public class Response {

  /**
   * Instantiates a new response.
   */
  public Response(ErrorList xdsErrorList, Status xdsStatus, boolean isComplete) {
    this.xdsErrorList = xdsErrorList;
    this.xdsStatus = xdsStatus;
    this.isComplete = isComplete;
  }

  /**
   * Gets the xds error list.
   *
   * @return the xds error list
   */
  public ErrorList getXdsErrorList() {
    return xdsErrorList;
  }

  /**
   * Gets the xds status.
   *
   * @return the xds status
   */
  public Status getXdsStatus() {
    return xdsStatus;
  }

  /**
   * Checks if is complete.
   *
   * @return true, if is complete
   */
  public boolean isComplete() {
    return isComplete;
  }

  /**
   * Eine Liste mit evtl. aufgetretenden Fehlern
   */
  ErrorList xdsErrorList;

  /** Gibt den Gesamtstatus der Transaktion wieder. */
  Status xdsStatus;

  /**
   * true, wenn die Transaktion erfolgreich war. Sonst: false.
   */
  boolean isComplete;

}
