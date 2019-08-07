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
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">This element contains the allergies and intolerances of the
 * patient</div> Allergy Concern <div class="de">Dieses Element enthält die
 * Allergien und Unverträglichkeiten des Patienten.</div> <div class="fr"></div>
 * .
 */
public class BaseAllergyConcern extends AbstractConcern {

	protected LanguageCode myLang = LanguageCode.ENGLISH;

	/**
	 * The MDHT allergy concern.
	 */
	private final org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mAllergyConcern;

	/**
	 * Instantiates a new allergy concern.
	 */
	public BaseAllergyConcern() {
		super(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init());
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.getMdhtConcern();
	}

	/**
	 * Instantiates a new allergy concern.
	 *
	 * @param lang
	 *            the language
	 */
	public BaseAllergyConcern(LanguageCode lang) {
		super(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init());
		myLang = lang;
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.getMdhtConcern();
	}

	/**
	 * <div class="en">Creates an object which represents an allergy
	 * concern</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert.</div> <div class="fr">Crée un objet qui représente un
	 * problème.</div>
	 *
	 * @param mdht
	 *            allergy concern
	 **/
	public BaseAllergyConcern(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mdht) {
		super(mdht);
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.getMdhtConcern();
	}

	/**
	 * <div class="en">Creates an object which represents an allergy
	 * concern</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert.</div> <div class="fr">Crée un objet qui représente un
	 * problème.</div>
	 *
	 * @param mdht
	 *            allergy concern
	 * @param lang
	 *            the language
	 */
	public BaseAllergyConcern(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mdht,
			LanguageCode lang) {
		super(mdht);
		myLang = lang;
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.getMdhtConcern();
	}

	/**
	 * <div class="en">Creates an object which represents an allergy
	 * concern</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert.</div> <div class="fr">Crée un objet qui représente un
	 * problème.</div>
	 *
	 * @param concern
	 *            <div class="en">The concern (free text)</div>
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param problemEntry
	 *            <div class="en">the medical problem</div> <div class="de"> Das
	 *            medizinische Problem</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param concernStatus
	 *            <div class="en">status of the concern
	 *            (active/suspended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public BaseAllergyConcern(String concern, BaseAllergyProblem problemEntry,
			org.ehealth_connector.cda.enums.ProblemConcernStatusCode concernStatus) {
		super(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init());
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.getConcernEntry();
		setConcern(concern);
		addAllergyProblem(problemEntry);
		addId(null);
		setStatus(concernStatus);
		setEffectiveTime(null, null);
	}

	/**
	 * <div class="en">Creates an object which represents an allergy
	 * concern</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert. Dieses Objekt kann einer ActiveProblemsSection hinzugefügt
	 * werden.</div>
	 *
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 *
	 * @param concern
	 *            <div class="en">The concern (free text)</div>
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param begin
	 *            <div class="en">begin of concern</div> <div class="de">Beginn
	 *            des Leidens</div> <div class="fr">Le début du problème</div>
	 * @param end
	 *            <div class="en">end of concern</div> <div class="de">Ende des
	 *            Leidens</div> <div class="fr">Le fin du problème</div>
	 * @param problemEntry
	 *            <div class="en">the medical problem</div> <div class="de"> Das
	 *            medizinische Problem</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param concernStatus
	 *            <div class="en">status of the concern
	 *            (active/suspended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public BaseAllergyConcern(String concern, Date begin, Date end, BaseAllergyProblem problemEntry,
			ProblemConcernStatusCode concernStatus) {
		this(concern, problemEntry, concernStatus);
		if (end != null) {
			setEffectiveTime(begin, end);
		} else {
			final IVL_TS ivlts = DatatypesFactory.eINSTANCE.createIVL_TS();
			ivlts.setLow(DateUtilMdht.createIVXB_TSFromDate(begin));
			mAllergyConcern.setEffectiveTime(ivlts);
		}
	}

	/**
	 * <div class="en">Adds a medical problem to the concern</div>
	 * <div class="de">Fügt dem Leiden ein medizinisches Problem hinzu.</div>
	 *
	 * @param problemEntry
	 *            Das Problem
	 */
	public void addAllergyProblem(BaseAllergyProblem problemEntry) {
		mAllergyConcern.addObservation(EcoreUtil.copy(problemEntry.getAllergyProblem()));
		mAllergyConcern.getEntryRelationships()
				.get(mAllergyConcern.getEntryRelationships().size() - 1)
				.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		mAllergyConcern.getEntryRelationships()
				.get(mAllergyConcern.getEntryRelationships().size() - 1).setInversionInd(false);
	}

	/**
	 * <div class="en">Copy mdht allergy concern.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.ihe. allergy intolerance
	 *         concern
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern copyMdhtAllergyConcern() {
		return EcoreUtil.copy(mAllergyConcern);
	}

	/**
	 * Gets the allergy problems.
	 *
	 * @return the allergy problems
	 */
	public List<BaseAllergyProblem> getAllergyProblems() {
		final List<BaseAllergyProblem> apl = new ArrayList<BaseAllergyProblem>();
		for (final AllergyIntolerance mAllergy : getMdht().getAllergyIntolerances()) {
			final AllergyProblem allergy = new AllergyProblem(mAllergy);
			apl.add(allergy);
		}
		return apl;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		final Code code = new Code(mAllergyConcern.getCode());
		return code;
	}

	/**
	 * Gets the effective time.
	 *
	 * @return the effective time
	 */
	public Date getEffectiveTime() {
		if (getMdht() != null) {
			if (getMdht().getEffectiveTime() != null) {
				if (getMdht().getEffectiveTime().getValue() != null)
					return DateUtilMdht.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
			}
		}
		return null;
	}

	/**
	 * Gets the mdht allergy concern.
	 *
	 * @return the mdht allergy concern
	 */
	@Override
	public AllergyIntoleranceConcern getMdht() {
		return mAllergyConcern;
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
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		String retVal = "";
		if (mAllergyConcern != null)
			if (mAllergyConcern.getText() != null)
				retVal = mAllergyConcern.getText().getText();
		return retVal;
	}
}
