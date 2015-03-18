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
* Attribution-ShareAlike 4.0 Switzerland License.
*
 * Year of publication: 2015
*
 *******************************************************************************/
package org.ehealth_connector.cda;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.Pregnancies;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActMoodDocumentObservation;

/**
 * <div class="de">Bei Frauen KANN mit diesem Element die strukturierte Angabe der Anamnese zu einer Schwangerschaft erfolgen.</div>\n
 * <div class="fr">Class Pregnancy.</div>\n
 * <div class="it">Class Pregnancy.</div>
 */
public class Pregnancy {

  /** The m pregnancy. */
  org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation mPregnancy;

  /**
   * Instantiates a new pregnancy.
   */
  public Pregnancy() {
    mPregnancy = IHEFactory.eINSTANCE.createPregnancyObservation().init();
    mPregnancy.setClassCode(ActClassObservation.OBS);
    mPregnancy.setMoodCode(x_ActMoodDocumentObservation.EVN);
    mPregnancy.setCode(Pregnancies.DELIVERY_DATE_CLINICAL_ESTIMATE.getCD());
    mPregnancy.setEffectiveTime(DateUtil.createUnknownTime(null));
    setInternalId(null);
  }

  /**
   * Instantiates a new pregnancy.
   *
   * @param estimatedBirthDate <br>
   * 		<div class="de">Errechneter Geburtstermin</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   */
  public Pregnancy (Date estimatedBirthDate) {
    this();
    setEstimatedBirthDate(estimatedBirthDate);
  }

  /**
   * Instantiates a new pregnancy.
   *
   * @param pregnancy <br>
   * 		<div class="de"> pregnancy</div>
   * 		<div class="fr"> pregnancy</div>
   * 		<div class="it"> pregnancy</div>
   */
  public Pregnancy(org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation pregnancy) {
    mPregnancy = pregnancy;
  }

  /**
   * <div class="de">Copy mdht pregnancy.</div>
   * <div class="fr">Copy mdht pregnancy.</div>
   * <div class="it">Copy mdht pregnancy.</div>
   *
   * @return the org.openhealthtools.mdht.uml.cda.ihe. pregnancy observation
   */
  public org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation copyMdhtPregnancy() {
    return EcoreUtil.copy(mPregnancy);
  }

  /**
   * Gibt den errechneten Geburtstermin zurück.
   *
   * @return the estimated birthdate
   */
  public String getEstimatedBirthdate() {

    if (mPregnancy.getValues().size()>0) {
      TS ts = (TS) copyMdhtPregnancy().getValues().get(0);
      return DateUtil.parseDateToStr(ts);
    }
    else return null;
  }

  /**
   * Gets the mdht pregnancy.
   *
   * @return the mdht pregnancy
   */
  public PregnancyObservation getMdhtPregnancy() {
    return mPregnancy;
  }

  /**
   * Setzt den errechneten Geburtstermin
   *
   * @param estimatedBirdDate the new estimated birth date
   */
  public void setEstimatedBirthDate(Date estimatedBirdDate) {
    TS ts = DateUtil.ts(estimatedBirdDate);
    mPregnancy.getValues().add(ts);
  }

  private void setInternalId(String id) {
    II ii = Util.createUuidVacd(id);
    mPregnancy.getIds().add(ii);
  }
}