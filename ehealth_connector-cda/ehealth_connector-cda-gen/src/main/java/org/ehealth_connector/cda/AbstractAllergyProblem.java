/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.cda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.AllergiesAndIntolerances;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.enums.IdentityDomain;
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
 * <div class="en">An Allergy Problem</div> <div class="de">Ein Allergie
 * Problem</div> <div class="fr"></div>.
 */
public class AbstractAllergyProblem {

	protected LanguageCode myLang = LanguageCode.ENGLISH;

	/** The m allergy problem. */
	private AllergyIntolerance mAllergyProblem;

	/**
	 * Instantiates a new allergy problem.
	 */
	public AbstractAllergyProblem() {
		setAllergyProblem(IHEFactory.eINSTANCE.createAllergyIntolerance().init());
	}

	/**
	 * <div class="en">Creates an object, which represents an allergy problem.
	 * This constructor will be used, when the time span in which the problem
	 * has been present</div> <div class="de">Erzeugt ein Objekt welches ein
	 * Allergie-Problem repräsentiert. Dieser Konstruktor wird verwendet, wenn
	 * der Zeitraum in dem das Problem bestand unbekannt ist, das Problem als
	 * Code angegeben werden soll. Dieses Objekt kann einem ProblemConcernEntry
	 * hinzugefügt werden.</div>
	 *
	 * @param allergy
	 *            <div class="en">The allergy</div> <div class="de">Die Art der
	 *            Allergie</div> <div class="fr"></div> <div class="it"></div>
	 */
	public AbstractAllergyProblem(AllergiesAndIntolerances allergy) {
		setAllergyProblem(IHEFactory.eINSTANCE.createAllergyIntolerance().init());
		// mAllergyProblem.setEffectiveTime(DateUtil
		// .createUnknownLowHighTimeNullFlavor());
		setNotOccured(false);
		setCode(allergy);
		setId(null);
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.UNK);
		getAllergyProblem().getValues().add(cd);
	}

	/**
	 * <div class="en">Creates an object, which represents an allergy problem.
	 * This constructor will be used, when the time span in which the problem
	 * has been present</div> <div class="de">Erzeugt ein Objekt welches ein
	 * Allergie-Problem repräsentiert. Dieser Konstruktor wird verwendet, wenn
	 * der Zeitraum in dem das Problem bestand bekannt ist und das Problem als
	 * Code angegeben werden soll. Dieses Objekt kann einem ProblemConcernEntry
	 * hinzugefügt werden.</div>
	 *
	 * @param kindOfAllergy
	 *            <div class="en"> kind of allergy</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param problem
	 *            <div class="en">code for risc of complication or risc of
	 *            exposure</div> <div class="de">Code zu Komplikationsrisiken
	 *            oder Expositionsrisiken.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param startOfProblem
	 *            <div class="en">start of problem</div> <div class="de">Beginn
	 *            des Problems</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param endOfProblem
	 *            <div class="en">end of problem</div> <div class="de">Ende des
	 *            Problems</div> <div class="fr"></div> <div class="it"></div>
	 */
	public AbstractAllergyProblem(AllergiesAndIntolerances kindOfAllergy,
			org.ehealth_connector.common.Code problem, Date startOfProblem, Date endOfProblem) {
		this(kindOfAllergy, problem, startOfProblem, endOfProblem, null);

	}

	/**
	 * <div class="en">Creates an object, which represents an allergy problem.
	 * This constructor will be used, when the time span in which the problem
	 * has been present</div> <div class="de">Erzeugt ein Objekt welches ein
	 * Allergie-Problem repräsentiert. Dieser Konstruktor wird verwendet, wenn
	 * der Zeitraum in dem das Problem bestand bekannt ist und das Problem als
	 * Code angegeben werden soll. Dieses Objekt kann einem ProblemConcernEntry
	 * hinzugefügt werden.</div>
	 *
	 * @param kindOfAllergy
	 *            <div class="en">kind of allergy</div> <div class="de">Die Art
	 *            der Allergie</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param problem
	 *            <div class="en">code for risc of complication or risc of
	 *            exposure</div> <div class="de">Code zu Komplikationsrisiken
	 *            oder Expositionsrisiken.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param startOfProblem
	 *            <div class="en">start of problem</div> <div class="de">Beginn
	 *            des Problems</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param endOfProblem
	 *            <div class="en">end of problem</div> <div class="de">Ende des
	 *            Problems</div> <div class="fr"></div> <div class="it"></div>
	 * @param internalProblemId
	 *            <div class="en">internal id of the problem. If you don´t have
	 *            such an id you can you another constructor and the id will be
	 *            generated</div> <div class="de">Interne ID des Problems
	 *            innerhalb der Akte. Steht eine solche nicht zur Verfügung dann
	 *            kann ein anderer Konstruktor verwendet werden und es wird
	 *            stattdesssen eine GUID durch die Convenience API
	 *            generiert.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public AbstractAllergyProblem(AllergiesAndIntolerances kindOfAllergy,
			org.ehealth_connector.common.Code problem, Date startOfProblem, Date endOfProblem,
			Identificator internalProblemId) {
		setAllergyProblem(IHEFactory.eINSTANCE.createAllergyIntolerance().init());
		setNotOccured(false);
		setStartDate(startOfProblem);
		setEndDate(endOfProblem);
		setId(internalProblemId);
		setCode(kindOfAllergy);
		addValue(problem);
	}

	/**
	 * Instantiates a new allergy problem.
	 */
	public AbstractAllergyProblem(LanguageCode lang) {
		setAllergyProblem(IHEFactory.eINSTANCE.createAllergyIntolerance().init());
		myLang = lang;
	}

	/**
	 * Instantiates a new allergy problem.
	 *
	 * @param allergyIntolerance
	 *            <br>
	 *            <div class="de"> allergy intolerance</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public AbstractAllergyProblem(
			org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance allergyIntolerance) {
		setAllergyProblem(allergyIntolerance);
	}

	/**
	 * Instantiates a new allergy problem.
	 *
	 * @param allergyIntolerance
	 *            <br>
	 *            <div class="de"> allergy intolerance</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param lang
	 *            the lang
	 */
	public AbstractAllergyProblem(
			org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance allergyIntolerance,
			LanguageCode lang) {
		setAllergyProblem(allergyIntolerance);
		myLang = lang;
	}

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		final II ii = CdaUtil.createUniqueIiFromIdentificator(id);
		mAllergyProblem.getIds().add(ii);
	}

	/**
	 * Adds the value.
	 *
	 * @param code
	 *            the new value
	 */
	public void addValue(Code code) {
		final CD mCodedProblem = EcoreUtil.copy(code.getCD());
		getAllergyProblem().getValues().add(mCodedProblem);
	}

	/**
	 * Adds the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void addValue(Value value) {
		getAllergyProblem().getValues().add(value.getValue());
	}

	/**
	 * <div class="de">Copy mdht allergy intolerance.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the allergy intolerance
	 */
	public AllergyIntolerance copyMdhtAllergyIntolerance() {
		return EcoreUtil.copy(getAllergyProblem());
	}

	/**
	 * Method to get
	 *
	 * @return the mAllergyProblem
	 */
	public AllergyIntolerance getAllergyProblem() {
		return mAllergyProblem;
	}

	/**
	 * Gets the code.
	 *
	 * @return das codedProblem Objekt
	 */
	public org.ehealth_connector.common.Code getCode() {
		final org.ehealth_connector.common.Code code = new org.ehealth_connector.common.Code(
				getAllergyProblem().getCode());
		return code;
	}

	/**
	 * Gets the reference to the comment in the level 2 section text.
	 *
	 * @return the reference of the level 3 comment entry, which point to the
	 *         level 2 text
	 */
	public String getCommentRef() {
		return Util.getCommentRef(getAllergyProblem().getEntryRelationships());
	}

	/**
	 * Gets the text of the comment text element (this is not necessarily the
	 * comment itself)
	 *
	 * @return the comment text
	 */
	public String getCommentText() {
		return Util.getCommentText(getAllergyProblem().getEntryRelationships());
	}

	/**
	 * Gets the end date of the problem.
	 *
	 * @return the end date of the problem.
	 */
	public Date getEndDate() {
		Date retVal = null;
		if (getAllergyProblem().getEffectiveTime() != null) {
			if (getAllergyProblem().getEffectiveTime().getHigh() != null) {
				try {
					retVal = DateUtil.parseDate(getAllergyProblem().getEffectiveTime().getHigh());
				} catch (Exception e) {
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="de">Liefert die (erste) interne (z.B. aus der Krankenakte
	 * bekannte) ID für das Allergie Problem. Ist keine ID vorhanden, wird null
	 * zurückgegeben.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the new id
	 */
	public Identificator getId() {
		Identificator id = null;
		if (getAllergyProblem().getIds().size() > 0) {
			id = new Identificator(getAllergyProblem().getIds().get(0));
		}
		return id;
	}

	/**
	 * Gets the specified id value based on its code system.
	 *
	 * @param codeSystem
	 *            id's identity domain
	 * @return the id or null if it doesn't exist
	 */
	public Identificator getId(IdentityDomain codeSystem) {
		Identificator ident = null;
		for (final II id : getAllergyProblem().getIds()) {
			if (id.getRoot().equalsIgnoreCase(codeSystem.getCodeSystemId())) {
				ident = new Identificator(id);
			}
		}
		return ident;
	}

	/**
	 * Gets the mdht allergy problem.
	 *
	 * @return the mdht allergy problem
	 */
	public AllergyIntolerance getMdht() {
		return getAllergyProblem();
	}

	/**
	 * Gets the narrative text of he observation in the desired language.
	 *
	 * @return the observation name
	 */
	public String getNarrativeText() {
		String obsName = getText();
		if ("".equals(obsName)) {
			VitalSignCodes vs = VitalSignCodes.getEnum(getCode().getCode());
			if (vs != null)
				obsName = vs.getDisplayName(myLang);
		}
		if ("".equals(obsName)) {
			obsName = getCode().getOriginalText();
		}
		return obsName;
	}

	/**
	 * Gets the problem not occured (NegationId).
	 *
	 * @return das NotOccured Objekt. True, if the problem did not occur. false,
	 *         otherwise.
	 */
	public boolean getNotOccured() {
		return (getAllergyProblem().getNegationInd() == null ? false
				: getAllergyProblem().getNegationInd());
	}

	/**
	 * Gets the end date of the problem.
	 *
	 * @return the end date of the problem.
	 */
	public Date getStartDate() {
		Date retVal = null;
		if (getAllergyProblem().getEffectiveTime() != null) {
			if (getAllergyProblem().getEffectiveTime().getLow() != null) {
				try {
					retVal = DateUtil.parseDate(getAllergyProblem().getEffectiveTime().getLow());
				} catch (Exception e) {
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		String retVal = "";
		if (mAllergyProblem != null)
			if (mAllergyProblem.getText() != null)
				retVal = mAllergyProblem.getText().getText();
		return retVal;
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
		final Value value = new Value(getAllergyProblem().getValues().get(0));
		return value;
	}

	/**
	 * Get a list of all problem values. Each Value may be a coded or uncoded
	 * String.
	 *
	 * @return all problem values as ArrayList.
	 */
	public List<Value> getValues() {
		final List<Value> vl = new ArrayList<Value>();
		for (final ANY a : getAllergyProblem().getValues()) {
			final Value v = new Value(a);
			vl.add(v);
		}
		return vl;
	}

	/**
	 * Method to set
	 *
	 * @param aAllergyProblem
	 *            the mAllergyProblem to set
	 */
	public void setAllergyProblem(AllergyIntolerance aAllergyProblem) {
		mAllergyProblem = aAllergyProblem;
	}

	/**
	 * Sets the code.
	 *
	 * @param kindOfAllergy
	 *            the new code
	 */
	public void setCode(AllergiesAndIntolerances kindOfAllergy) {
		getAllergyProblem().setCode(kindOfAllergy.getCD());
	}

	/**
	 * Sets a comment text
	 *
	 * @param text
	 *            the text
	 */
	public void setCommentText(String text) {
		final Comment mComment = IHEFactory.eINSTANCE.createComment().init();
		final ED ed = DatatypesFactory.eINSTANCE.createED();
		ed.addText(text);
		mComment.setText(ed);
		getAllergyProblem().addAct(mComment);

		final EntryRelationship er = getAllergyProblem().getEntryRelationships()
				.get(getAllergyProblem().getEntryRelationships().size() - 1);
		er.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		er.setInversionInd(true);
	}

	/**
	 * Sets the end of problem.
	 *
	 * @param endOfProblem
	 *            End of problem date.
	 */
	public void setEndDate(Date endOfProblem) {
		if (getAllergyProblem().getEffectiveTime() == null) {
			final IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			getAllergyProblem().setEffectiveTime(interval);
		}
		getAllergyProblem().getEffectiveTime()
				.setHigh(DateUtil.createIVXB_TSFromDate(endOfProblem));
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		final II ii = CdaUtil.createUniqueIiFromIdentificator(id);
		getAllergyProblem().getIds().clear();
		getAllergyProblem().getIds().add(ii);
	}

	/**
	 * Sets the problem not occured (negationId)
	 *
	 * @param notOccured
	 *            true, if the problem is not occured, false otherwise.
	 */
	public void setNotOccured(boolean notOccured) {
		getAllergyProblem().setNegationInd(notOccured);
	}

	/**
	 * Sets the start.
	 *
	 * @param startOfProblem
	 *            Start of the problem
	 */
	public void setStartDate(Date startOfProblem) {
		if (getAllergyProblem().getEffectiveTime() == null) {
			final IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			getAllergyProblem().setEffectiveTime(interval);
		}
		getAllergyProblem().getEffectiveTime()
				.setLow(DateUtil.createIVXB_TSFromDate(startOfProblem));
	}
}
