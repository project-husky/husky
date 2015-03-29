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

package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.AllergiesAndIntolerances;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="de">Ein allergisches Leiden</div> <div class="fr"></div>.
 */
public class AllergyProblem {

	/** The m allergy problem. */
	AllergyIntolerance mAllergyProblem;

	/**
	 * Instantiates a new allergy problem.
	 */
	public AllergyProblem() {
		mAllergyProblem = IHEFactory.eINSTANCE.createAllergyIntolerance()
				.init();
	}

	/**
	 * Erzeugt ein Objekt welches ein Allergie-Problem repräsentiert. Dieser
	 * Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand
	 * unbekannt ist, das Problem als Code angegeben werden soll. Dieses Objekt
	 * kann einem ProblemConcernEntry hinzugefügt werden.
	 *
	 * @param allergy
	 *            <div class="de">Die Art der Allergie</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public AllergyProblem(AllergiesAndIntolerances allergy) {
		mAllergyProblem = IHEFactory.eINSTANCE.createAllergyIntolerance()
				.init();
		mAllergyProblem.setEffectiveTime(DateUtil
				.createUnknownLowHighTimeNullFlavor());
		setNotOccured(false);
		setCode(allergy);
		setId(null);
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.UNK);
		mAllergyProblem.getValues().add(cd);
	}

	/**
	 * Erzeugt ein Objekt welches ein Allergie-Problem repräsentiert. Dieser
	 * Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand
	 * bekannt ist und das Problem als Code angegeben werden soll. Dieses Objekt
	 * kann einem ProblemConcernEntry hinzugefügt werden.
	 *
	 * @param kindOfAllergy
	 * <br>
	 *            <div class="de"> kind of allergy</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param problem
	 *            <div class="de">Code zu Komplikationsrisiken oder
	 *            Expositionsrisiken.</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param startOfProblem
	 *            <div class="de">Beginn des Problems</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param endOfProblem
	 *            <div class="de">Ende des Problems</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public AllergyProblem(AllergiesAndIntolerances kindOfAllergy,
			org.ehealth_connector.common.Code problem, Date startOfProblem,
			Date endOfProblem) {
		this(kindOfAllergy, problem, startOfProblem, endOfProblem, null);

	}

	/**
	 * Erzeugt ein Objekt welches ein Allergie-Problem repräsentiert. Dieser
	 * Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand
	 * bekannt ist und das Problem als Code angegeben werden soll. Dieses Objekt
	 * kann einem ProblemConcernEntry hinzugefügt werden.
	 *
	 * @param kindOfAllergy
	 * <br>
	 *            <div class="de">Die Art der Allergie</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param problem
	 *            <div class="de">Code zu Komplikationsrisiken oder
	 *            Expositionsrisiken.</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param startOfProblem
	 *            <div class="de">Beginn des Problems</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param endOfProblem
	 *            <div class="de">Ende des Problems</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param internalProblemId
	 *            <div class="de">Interne ID des Problems innerhalb der Akte.
	 *            Steht eine solche nicht zur Verfügung dann kann ein anderer
	 *            Konstruktor verwendet werden und es wird stattdesssen eine
	 *            GUID durch die Convenience API generiert.</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public AllergyProblem(AllergiesAndIntolerances kindOfAllergy,
			org.ehealth_connector.common.Code problem, Date startOfProblem,
			Date endOfProblem, Identificator internalProblemId) {
		mAllergyProblem = IHEFactory.eINSTANCE.createAllergyIntolerance()
				.init();
		setNotOccured(false);
		try {
			setStart(startOfProblem);
			setEndOfProblem(endOfProblem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		setId(internalProblemId);
		setCode(kindOfAllergy);
		addValue(problem);
	}

	/**
	 * Instantiates a new allergy problem.
	 *
	 * @param allergyIntolerance
	 * <br>
	 *            <div class="de"> allergy intolerance</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public AllergyProblem(
			org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance allergyIntolerance) {
		mAllergyProblem = allergyIntolerance;
	}

	/**
	 * Adds the value.
	 *
	 * @param code
	 *            the new value
	 */
	public void addValue(Code code) {
		CD mCodedProblem = EcoreUtil.copy(code.getCD());
		mAllergyProblem.getValues().add(mCodedProblem);
	}

	/**
	 * Adds the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void addValue(Value value) {
		mAllergyProblem.getValues().add(value.getValue());
	}

	/**
	 * <div class="de">Copy mdht allergy intolerance.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return the allergy intolerance
	 */
	public AllergyIntolerance copyMdhtAllergyIntolerance() {
		return EcoreUtil.copy(mAllergyProblem);
	}

	/**
	 * Gets the code.
	 *
	 * @return das codedProblem Objekt
	 */
	public org.ehealth_connector.common.Code getCode() {
		org.ehealth_connector.common.Code code = new org.ehealth_connector.common.Code(
				mAllergyProblem.getCode());
		return code;
	}

	/**
	 * Gets the reference to the comment in the level 2 section text.
	 *
	 * @return the reference of the level 3 comment entry, which point to the
	 *         level 2 text
	 */
	public String getCommentRef() {
		return Util.getCommentRef(mAllergyProblem.getEntryRelationships());
	}

	/**
	 * Gets the text of the comment text element (this is not necessarily the
	 * comment itself)
	 *
	 * @return the comment text
	 */
	public String getCommentText() {
		return Util.getCommentText(mAllergyProblem.getEntryRelationships());
	}

	/**
	 * Gets the end of problem.
	 *
	 * @return das endOfProblem Objekt
	 */
	public String getEnd() {
		if (mAllergyProblem.getEffectiveTime() != null) {
			if (mAllergyProblem.getEffectiveTime().getHigh() != null) {
				return Util.createEurDateStrFromTS(mAllergyProblem
						.getEffectiveTime().getHigh().getValue());
			}
		}
		return null;
	}

	/**
	 * <div class="de">Liefert die (erste) interne (z.B. aus der Krankenakte
	 * bekannte) ID für das Allergie Problem. Ist keine ID vorhanden, wird null
	 * zurückgegeben.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the new id
	 */
	public Identificator getId() {
		if (mAllergyProblem.getIds().size() > 0) {
			Identificator id = new Identificator(mAllergyProblem.getIds()
					.get(0));
			return id;
		}
		return null;
	}

	/**
	 * Gets the mdht allergy problem.
	 *
	 * @return the mdht allergy problem
	 */
	public AllergyIntolerance getMdhtAllergyProblem() {
		return mAllergyProblem;
	}

	/**
	 * Gets the problem not occured (NegationId).
	 *
	 * @return das NotOccured Objekt. True, if the problem did not occur. false,
	 *         otherwise.
	 */
	public boolean getNotOccured() {
		return mAllergyProblem.getNegationInd();
	}

	/**
	 * Gets the start.
	 *
	 * @return das startOfProblem Objekt
	 */
	public String getStart() {
		if (mAllergyProblem.getEffectiveTime() != null) {
			if (mAllergyProblem.getEffectiveTime().getLow() != null) {
				return Util.createEurDateStrFromTS(mAllergyProblem
						.getEffectiveTime().getLow().getValue());
			}
		}
		return null;
	}

	/**
	 * The Value may be a coded or uncoded String.
	 * <p>
	 * If the value is coded, the convenience API will return the Code.
	 * </p>
	 * <p>
	 * If the value is uncoded, the convenience API will return the xml
	 * reference to the free text description of the document for further
	 * processing.
	 * </p>
	 * 
	 * @return the problem value as string.
	 */
	public Value getValue() {
		Value value = new Value(mAllergyProblem.getValues().get(0));
		return value;
	}

	/**
	 * Get a list of all problem values. Each Value may be a coded or uncoded
	 * String.
	 * 
	 * @return all problem values as ArrayList.
	 */
	public ArrayList<Value> getValues() {
		ArrayList<Value> vl = new ArrayList<Value>();
		for (ANY a : mAllergyProblem.getValues()) {
			Value v = new Value(a);
			vl.add(v);
		}
		return vl;
	}

	/**
	 * Sets the code.
	 *
	 * @param kindOfAllergy
	 *            the new code
	 */
	public void setCode(AllergiesAndIntolerances kindOfAllergy) {
		mAllergyProblem.setCode(kindOfAllergy.getCD());
	}

	/**
	 * Sets a comment text
	 *
	 * @param text
	 *            the text
	 */
	public void setCommentText(String text) {
		Comment mComment = IHEFactory.eINSTANCE.createComment().init();
		ED ed = DatatypesFactory.eINSTANCE.createED();
		ed.addText(text);
		mComment.setText(ed);
		mAllergyProblem.addAct(mComment);

		EntryRelationship er = mAllergyProblem.getEntryRelationships().get(
				mAllergyProblem.getEntryRelationships().size() - 1);
		er.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		er.setInversionInd(true);
	}

	/**
	 * Sets the end of problem.
	 *
	 * @param endOfProblem
	 *            End of problem date.
	 * @throws ParseException
	 *             the parse exception
	 */
	public void setEndOfProblem(Date endOfProblem) throws ParseException {
		mAllergyProblem.getEffectiveTime().setHigh(
				DateUtil.createIVXB_TSFromDate(endOfProblem));
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		II ii = Util.createIdentificator(id);
		mAllergyProblem.getIds().add(ii);
	}

	/**
	 * Sets the problem not occured (negationId)
	 *
	 * @param notOccured
	 *            true, if the problem is not occured, false otherwise.
	 */
	public void setNotOccured(boolean notOccured) {
		mAllergyProblem.setNegationInd(notOccured);
	}

	/**
	 * Sets the start.
	 *
	 * @param startOfProblem
	 *            Start of the problem
	 * @throws ParseException
	 *             the parse exception
	 */
	public void setStart(Date startOfProblem) {
		if (mAllergyProblem.getEffectiveTime() == null) {
			IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			mAllergyProblem.setEffectiveTime(interval);
		}
		try {
			mAllergyProblem.getEffectiveTime().setLow(
					DateUtil.createIVXB_TSFromDate(startOfProblem));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
