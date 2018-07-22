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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.ReferenceRange;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.LangTexts;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Performer2;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.RTO;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationPhysicalPerformer;

/**
 * The base Observation.
 */
public class BaseObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.Observation>
		implements Comparator<BaseObservation> {

	/** The local observation. */
	protected org.openhealthtools.mdht.uml.cda.Observation mObservation;

	/** The local language code. */
	protected LanguageCode myLang = LanguageCode.ENGLISH;

	/** The local observation language texts. */
	protected LangTexts myObservationLangTexts = new LangTexts();

	/** The local target site language texts. */
	protected LangTexts myTargetSiteLangTexts = new LangTexts();

	/** The local value language texts. */
	protected LangTexts myValueLangTexts = new LangTexts();

	/**
	 * Instantiates a new base observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public BaseObservation(Observation mdht) {
		super(mdht);
		mObservation = mdht;
	}

	/**
	 * Instantiates a new base observation.
	 *
	 * @param mdht
	 *            the mdht
	 * @param lang
	 *            the lang
	 */
	public BaseObservation(Observation mdht, LanguageCode lang) {
		super(mdht);
		mObservation = mdht;
		myLang = lang;
	}

	/**
	 * Adds an author.
	 *
	 * @param author
	 *            the author
	 * @param dateTimeOfDocumentation
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void addAuthor(Author author, Date dateTimeOfDocumentation) {
		final org.openhealthtools.mdht.uml.cda.Author mAuthor = author.copyMdhtAuthor();
		// mAuthor.setTypeCode(ParticipationPhysicalPerformer.PRF);
		try {
			mAuthor.setTime(DateUtil.createIVL_TSFromEuroDate(dateTimeOfDocumentation));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		getMdht().getAuthors().add(mAuthor);
	}

	/**
	 * Adds a interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	@Override
	public void addInterpretationCode(Code code) {
		mObservation.getInterpretationCodes().add(code.getCE());
	}

	/**
	 * Adds a nullFlavor interpretation code.
	 *
	 * @param nullFlavor
	 *            the desired NullFlavor
	 *
	 */
	public void addInterpretationCode(NullFlavor nullFlavor) {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(nullFlavor);
		mObservation.getInterpretationCodes().add(ce);
	}

	/**
	 * Adds a performer.
	 *
	 * @param performer
	 *            the performer
	 * @param dateTimeOfPerformance
	 *            <div class="en">date and time, when the result was known</div>
	 *            <div class="de">Datum und Uhrzeit, an dem das Resultat bekannt
	 *            wurde.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void addPerformer(Performer performer, Date dateTimeOfPerformance) {
		final Performer2 mPerformer = performer.copyMdhtPerfomer();
		mPerformer.setTypeCode(ParticipationPhysicalPerformer.PRF);
		try {
			mPerformer.setTime(DateUtil.createIVL_TSFromEuroDate(dateTimeOfPerformance));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		getMdht().getPerformers().add(mPerformer);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(BaseObservation o1, BaseObservation o2) {
		BaseObservationComparator comparator = new BaseObservationComparator();
		return comparator.compare(o1, o2);
	}

	/**
	 * Gets the author list.
	 *
	 * @return the author list
	 */
	public List<Author> getAuthors() {
		final List<Author> list = new ArrayList<Author>();
		for (final org.openhealthtools.mdht.uml.cda.Author mdht : getMdht().getAuthors()) {
			final Author eHC = new Author(mdht);
			list.add(eHC);
		}
		return list;
	}

	/**
	 * Gets the observation code.
	 *
	 * @return the observation code
	 */
	public Code getCode() {
		final Code code = new Code(mObservation.getCode());
		return code;
	}

	/**
	 * Gets the comment text.
	 *
	 * @return the comment text
	 */
	public String getCommentText() {
		return Util.getCommentText(mObservation.getEntryRelationships());
	}

	/**
	 * Gets the comment text.
	 *
	 * @param contentId
	 *            the content id
	 * @return the comment text
	 */
	public String getCommentText(String contentId) {
		String retVal = Util.getCommentText(mObservation.getEntryRelationships(), contentId);
		if (retVal == null)
			retVal = "";
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtObservationFacade#getEffectiveTime()
	 */
	@Override
	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(mObservation.getEffectiveTime());
	}

	/**
	 * <div class="en">Gets the (first) interpretation code</div>.
	 *
	 * @return the interpretation code
	 */
	@Override
	public Code getInterpretationCode() {
		if (mObservation != null) {
			if (mObservation.getInterpretationCodes().size() > 0) {
				return new Code(mObservation.getInterpretationCodes().get(0));
			}
		}
		return null;
	}

	/**
	 * Gets the mdht observation.
	 *
	 * @return the mdht observation
	 */
	public Object getMdhtObservation() {
		return mObservation;
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
	 * Gets the observation.
	 *
	 * @return the observation
	 */
	public org.openhealthtools.mdht.uml.cda.Observation getObservation() {
		return mObservation;
	}

	/**
	 * Gets the observation language texts.
	 *
	 * @return the observation language texts
	 */
	public LangTexts getObservationLangTexts() {
		return myObservationLangTexts;
	}

	/**
	 * Gets the narrative text of he observation in the desired language.
	 *
	 * @return the observation name
	 */
	public String getOriginalText() {
		String obsName = null;
		if (getCode() != null) {
			if (!"".equals(getCode().getOriginalText())) {
				obsName = getCode().getOriginalText();
			}
		}
		return obsName;
	}

	/**
	 * Gets the performer list.
	 *
	 * @return the performer list
	 */
	public List<Performer> getPerformers() {
		final List<Performer> list = new ArrayList<Performer>();
		for (final Performer2 mdht : getMdht().getPerformers()) {
			final Performer eHC = new Performer(mdht);
			list.add(eHC);
		}
		return list;
	}

	/**
	 * Gets the reference range <div class="de">(Referenzbereich)</div>.
	 *
	 * @return the reference range
	 */
	public ReferenceRange getReferenceRange() {
		if ((getMdht().getReferenceRanges() != null) && !getMdht().getReferenceRanges().isEmpty()) {
			return new ReferenceRange(getMdht().getReferenceRanges().get(0));
		}
		return null;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public String getResult() {
		String retVal = "";
		for (Value value : getValues()) {
			String tempOneValue = "";
			String tempOneUnit = "";
			if (value != null) {
				if (value.isPhysicalQuantity()) {
					tempOneValue = value.getPhysicalQuantityValue();
					if ("-1".equals(tempOneValue))
						tempOneValue = "-";
					tempOneUnit = value.getPhysicalQuantityUnit();
				} else if (value.isRto()) {
					tempOneValue = value.getRtoValueText();
					tempOneUnit = value.getRtoUnitText();
				} else if (value.isBl()) {
					if (value.getValue() != null) {
						String temp = value.getBlText();
						if (temp != null) {
							tempOneValue = temp;
						}
					}
				} else if (value.isEd()) {
					tempOneValue = value.toString();
					tempOneValue = tempOneValue.replace("<", "&lt;");
					tempOneValue = tempOneValue.replace(">", "&gt;");
				} else
					tempOneValue = value.toString();
			}
			if (!"".equals(retVal))
				retVal = retVal + "<br />";
			if (!"".equals(tempOneValue) && !"".equals(tempOneUnit))
				retVal = tempOneValue + " " + tempOneUnit;
			else
				retVal = tempOneValue + tempOneUnit;
		}
		return retVal;
	}

	/**
	 * Gets the target site.
	 *
	 * @return the target site
	 */
	public ActSite getTargetSite() {
		if (getMdht().getTargetSiteCodes() != null)
			if (getMdht().getTargetSiteCodes().size() > 0)
				return ActSite.getEnum(getMdht().getTargetSiteCodes().get(0).getCode());

		return null;
	}

	/**
	 * Gets the target site language texts.
	 *
	 * @return the target site language texts
	 */
	public LangTexts getTargetSiteLangTexts() {
		return myTargetSiteLangTexts;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		String retVal = "";
		if (mObservation != null)
			if (mObservation.getText() != null)
				retVal = mObservation.getText().getText();
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtFacade#getTextReference()
	 */
	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtObservationFacade#getValue()
	 */
	@Override
	public Value getValue() {
		if (!mObservation.getValues().isEmpty()) {
			if ((mObservation.getValues().get(0) instanceof BL)
					|| (mObservation.getValues().get(0) instanceof CD)
					|| (mObservation.getValues().get(0) instanceof ED)
					|| (mObservation.getValues().get(0) instanceof PQ)
					|| (mObservation.getValues().get(0) instanceof RTO)
					|| (mObservation.getValues().get(0) instanceof INT))
				return new Value(mObservation.getValues().get(0));
		}
		return null;

	}

	/**
	 * Gets the language texts of the value.
	 *
	 * @return the language texts of the value.
	 */
	public LangTexts getValueLangTexts() {
		return myValueLangTexts;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtObservationFacade#getValues()
	 */
	@Override
	public List<Value> getValues() {

		List<Value> retVal = new ArrayList<Value>();
		for (ANY value : mObservation.getValues()) {
			if ((value instanceof BL) || (value instanceof CD) || (value instanceof ED)
					|| (value instanceof PQ) || (value instanceof RTO) || (value instanceof INT))
				retVal.add(new Value(value));
		}
		return retVal;
	}

	/**
	 * Sets the date time of result.
	 *
	 * @param dateTimeOfResult
	 *            the new date time of result
	 */
	@Override
	public void setEffectiveTime(Date dateTimeOfResult) {
		try {
			getObservation()
					.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	public void setInterpretationCode(Code code) {
		mObservation.getInterpretationCodes().clear();
		mObservation.getInterpretationCodes().add(code.getCE());
	}

	/**
	 * Sets the observation.
	 *
	 * @param observation
	 *            the new observation
	 */
	public void setObservation(org.openhealthtools.mdht.uml.cda.Observation observation) {
		mObservation = observation;
	}

	/**
	 * Sets the observation language texts.
	 *
	 * @param observationLangTexts
	 *            the new observation language texts
	 */
	public void setObservationLangTexts(LangTexts observationLangTexts) {
		this.myObservationLangTexts = observationLangTexts;
	}

	/**
	 * Sets the target site.
	 *
	 * @param actSite
	 *            the new target site
	 */
	public void setTargetSite(ActSite actSite) {
		if (actSite != null) {
			mObservation.getTargetSiteCodes().clear();
			mObservation.getTargetSiteCodes().add(actSite.getCD());
		}
	}

	/**
	 * Sets the target site.
	 *
	 * @param actSite
	 *            the act site
	 * @param targetSiteLangTexts
	 *            the target site language texts
	 */
	public void setTargetSite(ActSite actSite, LangTexts targetSiteLangTexts) {
		setTargetSite(actSite);
		this.myTargetSiteLangTexts = targetSiteLangTexts;
	}

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		final ED ed = DatatypesFactory.eINSTANCE.createED();
		ed.addText(text);
		mObservation.setText(ed);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtFacade#setTextReference(java.lang.String)
	 */
	@Override
	public void setTextReference(String textReference) {
		ED existingText = this.getMdht().getText();
		if (textReference != null) {
			if (!textReference.equals("")) {
				if (!textReference.startsWith("#"))
					textReference = "#" + textReference;
				this.getMdht().setText(Util.createReference(existingText, textReference));
			}
		}
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(Value value) {
		if (value.isPhysicalQuantity()) {
			mObservation.getValues().add(value.copyMdhtPhysicalQuantity());
		}
		if (value.isCode()) {
			mObservation.getValues().add(value.copyMdhtCode());
		}
		if (value.isRto()) {
			mObservation.getValues().add(value.copyMdhtRto());
		}
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the value
	 * @param valueLangTexts
	 *            the value language texts
	 */
	public void setValue(Value value, LangTexts valueLangTexts) {
		setValue(value);
		this.myValueLangTexts = valueLangTexts;
	}

}
