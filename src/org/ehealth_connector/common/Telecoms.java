/********************************************************************************
*
* The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
* Year of publication: 2015
*
********************************************************************************/

package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.AddressUse;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

/**
 * <div class="en">Class Telecoms.</div>\n <div class="de">Klasse für Telekommunikation</div>\n <div
 * class="it"></div>
 */
public class Telecoms {

  /**
   * The mdht tels.
   */
  ArrayList<TEL> mTels;

  /**
   * <div class="en">Instantiates a new telecoms.</div> <div class="de">Instantiiert eine neue Liste
   * mit Telcoms</div> <div class="fr"></div> <div class="it"></div>
   */
  public Telecoms() {
    mTels = new ArrayList<TEL>();
  }

  /**
   * <div class="en">Instantiates a new telecoms.</div> <div class="de">Instantiiert eine neue Liste
   * mit Telcoms</div> <div class="fr"></div> <div class="it"></div>
   *
   * @param telecoms <br>
   *        <div class="de"> telecoms</div> <div class="fr"> telecoms</div> <div class="it">
   *        telecoms</div>
   */
  public Telecoms(EList<TEL> telecoms) {
    this();
    for (TEL tel : telecoms) {
      mTels.add(tel);
    }
  }

  /**
   * Weist der Telecoms Liste eine eMail Adresse zu.
   *
   * @param eMail eMail Adresse
   * @param usage Verwendungszweck (Privat, Geschäft)
   */
  public void addEMail(String eMail, AddressUse usage) {
    mTels.add(Util.createEMail(eMail, usage));
  }

  /**
   * Weist der Telecoms Liste eine Fax Nummer zu. Diese MÜSSEN folgendes Format haben:
   * "+41.32.234.66.77"
   *
   * @param fax <br>
   *        <div class="de"> fax</div> <div class="fr"></div> <div class="it"></div>
   * @param usage Verwendungszweck (Privat, Geschäft)
   */
  public void addFax(String fax, AddressUse usage) {
    mTels.add(Util.createFax(fax, usage));
  }

  /**
   * Weist der Telecoms Liste eine Fax Nummer zu. Diese MÜSSEN folgendes Format haben:
   * "+41.32.234.66.77"
   *
   * @param phoneNr Telefonnummer (nur internationale Rufnummer ohne Sonderzeichen:
   *        "+41.32.234.66.77"
   * @param usage Verwendungszweck (Privat, Geschäft, Mobil)
   */
  public void addPhone(String phoneNr, AddressUse usage) {
    mTels.add(Util.createTel(phoneNr, usage));
  }

   /**
   * Weist der Telecoms Liste eine Webseite zu.
   *
   * @param url Webseite (z.B. "http://www.ehealth-connector.org")
   * @param usage Verwendungszweck (Privat, Geschäft)
   */
   public void addWebsite(String url, AddressUse usage) {
     TEL t = DatatypesFactory.eINSTANCE.createTEL();
     t.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
     t.setValue(url);
     mTels.add(t);
   }

  /**
   * <div class="en">Copy mdht telecoms.</div> <div class="de"></div> <div class="fr"></div> <div
   * class="it"></div>
   *
   * @return EList the MDHT EList containing the Telecoms
   */
  public EList<TEL> copyMdhtTelecoms() {
    return (EList<TEL>) EcoreUtil.copyAll(mTels);
  }

  /**
   * <div class="en">Gets the e mails.</div> <div class="de">Liefert e mails.</div> <div
   * class="fr"></div> <div class="it"></div>
   *
   * @return ArrayList<String> <div class="en">the e mails and ArrayList with Strings</div>
   */
  public HashMap<String, AddressUse> getEMails() {
    return Util.getEMail(mTels);
  }

  /**
   * <div class="en">Gets the faxes.</div> <div class="de">Liefert alle Fax Nummern</div> <div
   * class="fr"></div> <div class="it"></div>
   *
   * @return <div class="en">the faxes</div>
   */
  public HashMap<String, AddressUse> getFaxes() {
    return Util.getFax(mTels);
  }
  
  /**
   * <div class="en">Gets the Websides</div> <div class="de">Liefert alle Websides</div> <div
   * class="fr"></div> <div class="it"></div>
   *
   * @return <div class="en">the websides</div>
   */
  public HashMap<String, AddressUse> getWebsites() {
    return Util.getWebsites(mTels);
  }

  /**
   * <div class="en">Gets the mdht telecoms.</div> <div class="de">Liefert mdht telecoms.</div> <div
   * class="fr"></div> <div class="it"></div>
   *
   * @return ArrayList<TEL> <div class="en">the mdht telecoms</div>
   */
  public ArrayList<TEL> getMdhtTelecoms() {
    return mTels;
  }

  /**
   * <div class="en">Gets the phones.</div> <div class="de">Liefert alle Telefonnummern</div> <div
   * class="fr"></div> <div class="it"></div>
   *
   * @return <div class="en">the phones</div>
   */
  public HashMap<String, AddressUse> getPhones() {
    return Util.getPhones(mTels);
  }

  /**
   * <div class="en">Gets the telecoms as HashMap</div> <div class="de">Liefert die Telecoms Liste
   * als HashMap</div> <div class="fr"></div> <div class="it"></div>
   *
   * @return <div class="en">the telecoms</div>
   */
  public HashMap<String, TelecommunicationAddressUse> getTelecoms() {
    HashMap<String, TelecommunicationAddressUse> pm =
        new HashMap<String, TelecommunicationAddressUse>();
    for (TEL mName : mTels) {
      pm.put(mName.getValue(), mName.getUses().get(0));
    }
    return pm;
  }
}
