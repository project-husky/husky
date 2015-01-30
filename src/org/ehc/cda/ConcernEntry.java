package org.ehc.cda;

import java.text.ParseException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;

public class ConcernEntry {
  org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry mConcernEntry;
  
  public ConcernEntry (org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry concernEntry) {
    this.mConcernEntry = concernEntry;
  }
  
  public void setEffectiveTime(String begin, String end) {
    // Create and set the concern interval
    try {
      mConcernEntry.setEffectiveTime(DateUtil
                .createIVL_TSFromEuroDate(begin, end));
    } catch (ParseException e) {
        e.printStackTrace();
    }
}

  /**
   * Gibt den Status (aktiv/inaktiv/...) des Leidens zurück
   * 
   * @return Status des Leidens
   */
  public String getCodedStatusOfConcern() {
      //TODO map the String to an enum 
      return mConcernEntry.getStatusCode().getCode();
  }

  /**
   * Gibt das Ende des Leidens zurück
   * 
   * @return Ende des Leidens
   */
  public String getEndOfConcern() {
      return Util.createEurDateStrFromTS(copyMdhtConcernEntry()
              .getEffectiveTime().getHigh().getValue());
  }

  /**
   * Gibt den Beginn des Leidens zurück
   * 
   * @return Beginn des Leidens
   */
  public String getStartOfConcern() {
      return Util.createEurDateStrFromTS(copyMdhtConcernEntry()
              .getEffectiveTime().getLow().getValue());
  }

  private org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry copyMdhtConcernEntry() {
    return EcoreUtil.copy(mConcernEntry);
  }

  /**
   * Setzt den Status (aktiv/inaktiv/...) des Leidens
   * 
   * @param concernStatus
   *            Status
   */
  public void setCodedStatusOfConcern(ch.ehc.cda.enums.StatusCode concernStatus) {
      // Create and set the status code
      // TODO Prüfen, ob hier immer "completed" angegeben werden muss
      // (Implementierungsleitfaden 7.5.2.4)
      
    mConcernEntry.setStatusCode(concernStatus.getCS());
  }

  /**
   * Setzt das Ende des Leidens
   * 
   * @param endOfConcern
   *            Ende des Leidens
   */
  public void setEndOfConcern(String endOfConcern) {
      try {
        mConcernEntry.getEffectiveTime().setHigh(
              DateUtil.createIVXB_TSFromEuroDate(endOfConcern));
      } catch (ParseException e) {
          e.printStackTrace();
      }
  }

  /**
   * Setzt den Beginn des Leidens
   * 
   * @param startOfConcern
   *            Beginn des Leidens
   */
  public void setStartOfConcern(String startOfConcern) {
      try {
        mConcernEntry.getEffectiveTime().setLow(
              DateUtil.createIVXB_TSFromEuroDate(startOfConcern));
      } catch (ParseException e) {
          e.printStackTrace();
      }
  }
  
  /**
   * Setzt das Leiden
   * 
   * @param concern
   *            Leiden
   */
  public void setProblemConcern(String concern) {
      // Create and set the concern as freetext
      ED concernText = DatatypesFactory.eINSTANCE.createED(concern);
      mConcernEntry.setText(concernText);
  }

  /**
   * Gibt das Leiden zurück
   * 
   */
  public String getProblemConcern() {
      return mConcernEntry.getText().getText();
  }
}
