/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2014
 *
 *******************************************************************************/

package org.ehc.cda;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.ehc.common.ConvenienceUtilsEnums.StatusCode;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> <div class="fr">Une
 * souffrance de la santé</div>
 */
public class AllergyConcern {

	protected org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mAllergyConcern;

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param problemConcernEntry
	 * <div class="de">Vorbestehendes Objekt, das geklont werden soll</div>
	 * 
	 * <div class="fr">Objet préexistante à cloner</div>
	 * 
	 */
	public AllergyConcern(
			org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern problemConcernEntry) {
		this.setAllergyConcern(problemConcernEntry);
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param concernStatus
	 *            <div class="de">Der Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public AllergyConcern(String concern, AllergyProblem problemEntry, StatusCode concernStatus) {
		setAllergyConcern(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern());
		mAllergyConcern.init();
		this.setAllergyConcern(concern);
		this.addAllergy(problemEntry);
		this.setCodedStatusOfConcern(concernStatus);
		this.setInternalId(null);
		this.setEffectiveTime(null, null);
	}
	
	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param concernStatus
	 *            <div class="de">Der Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 * @param begin
	 *            <div class="de">Beginn des Leidens</div> <div class="fr">Le
	 *            début du problème</div>
	 * @param end
	 *            <div class="de">Ende des Leidens</div> <div class="fr">Le fin
	 *            du problème</div>
	 */
	public AllergyConcern(String concern,
			Date begin, Date end, AllergyProblem problemEntry, StatusCode concernStatus) {
		this(concern,
				DateFormat.getDateInstance().format(begin), DateFormat
						.getDateInstance().format(end), problemEntry, concernStatus);
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param concernStatus
	 *            <div class="de">Der Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 * @param begin
	 *            <div class="de">Beginn des Leidens</div> <div class="fr">Le
	 *            début du problème</div>
	 * @param end
	 *            <div class="de">Ende des Leidens</div> <div class="fr">Le fin
	 *            du problème</div>
	 */
	public AllergyConcern(String concern, 
			String begin, String end, AllergyProblem problemEntry, StatusCode concernStatus) {
		this(concern, problemEntry, concernStatus);
		this.setEffectiveTime(begin, end);
	}

	public void setEffectiveTime(String begin, String end) {
	  // Create and set the concern interval
      try {
          mAllergyConcern.setEffectiveTime(DateUtil
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
		return mAllergyConcern.getStatusCode().getCode();
	}

	/**
	 * Gibt das Ende des Leidens zurück
	 * 
	 * @return Ende des Leidens
	 */
	public String getEndOfConcern() {
		return Util.createEurDateStrFromTS(copyMdhtAllergyConcern()
				.getEffectiveTime().getHigh().getValue());
	}

	/**
	 * Gibt den Beginn des Leidens zurück
	 * 
	 * @return Beginn des Leidens
	 */
	public String getStartOfConcern() {
		return Util.createEurDateStrFromTS(copyMdhtAllergyConcern()
				.getEffectiveTime().getLow().getValue());
	}

	/**
	 * Setzt den Status (aktiv/inaktiv/...) des Leidens
	 * 
	 * @param concernStatus
	 *            Status
	 */
	public void setCodedStatusOfConcern(StatusCode concernStatus) {
		// Create and set the status code
		// TODO Prüfen, ob hier immer "completed" angegeben werden muss
		// (Implementierungsleitfaden 7.5.2.4)
		CS concernStatusCode = DatatypesFactory.eINSTANCE
				.createCS(concernStatus.name());
		mAllergyConcern.setStatusCode(concernStatusCode);
	}

	/**
	 * Setzt das Ende des Leidens
	 * 
	 * @param endOfConcern
	 *            Ende des Leidens
	 */
	public void setEndOfConcern(String endOfConcern) {
		try {
			mAllergyConcern.getEffectiveTime().setHigh(
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
			mAllergyConcern.getEffectiveTime().setLow(
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
	public void setAllergyConcern(String concern) {
		// Create and set the concern as freetext
		ED concernText = DatatypesFactory.eINSTANCE.createED(concern);
		mAllergyConcern.setText(concernText);
	}

	/**
	 * Gibt das Leiden zurück
	 * 
	 */
	public String getAllergyConcern() {
		return mAllergyConcern.getText().getText();
	}

	/**
	 * Fügt dem Leiden ein medizinisches Problem hinzu
	 * 
	 * @param problemEntry
	 *            Das Problem
	 */
	public void addAllergy(AllergyProblem problemEntry) {
	  mAllergyConcern.addObservation(problemEntry.mAllergyProblem);
		mAllergyConcern.getEntryRelationships().get(0)
	    .setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		mAllergyConcern.getEntryRelationships().get(0).setInversionInd(false);
	}
	
    private void setInternalId(String id) {
      II ii = DatatypesFactory.eINSTANCE.createII();
      if (id==null) {
        ii.setRoot(UUID.generate());
      }
      else {
        ii.setRoot(id);
      }
      mAllergyConcern.getIds().add(ii);
    }

	public org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern copyMdhtAllergyConcern() {
		return EcoreUtil.copy(mAllergyConcern);
	}

	public void setAllergyConcern(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mAllergyConcern) {
		this.mAllergyConcern = mAllergyConcern;
	}
	
	public List<org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance> getMdhtAllergyList() {
      return this.mAllergyConcern.getAllergyIntolerances();
	}
}
