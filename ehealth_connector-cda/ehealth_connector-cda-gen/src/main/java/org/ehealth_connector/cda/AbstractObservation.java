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
import java.util.Date;

import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.LangTexts;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;

public abstract class AbstractObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.Observation> {

	protected LangTexts myValueLangTexts = new LangTexts();

	protected LangTexts myTargetSiteLangTexts = new LangTexts();
	protected ActSite myActSite = null;
	protected org.openhealthtools.mdht.uml.cda.Observation mObservation;

	protected AbstractObservation(Observation mdht) {
		super(mdht);
		mObservation = mdht;
	}

	public Code getCode() {
		final Code code = new Code(mObservation.getCode());
		return code;
	}

	public String getCommentText() {
		return Util.getCommentText(mObservation.getEntryRelationships());
	}

	@Override
	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(mObservation.getEffectiveTime());
	}

	public LangTexts getLangTexts() {
		return myValueLangTexts;
	}

	public Object getMdhtObservation() {
		return mObservation;
	}

	public org.openhealthtools.mdht.uml.cda.Observation getObservation() {
		return mObservation;
	}

	public ActSite getTargetSite() {
		return myActSite;
	}

	@Override
	public Value getValue() {
		if (!mObservation.getValues().isEmpty()
				&& (mObservation.getValues().get(0) instanceof PQ)) {
			return new Value(mObservation.getValues().get(0));
		}
		return null;

	}

	@Override
	public void setEffectiveTime(Date dateTimeOfResult) {
		try {
			getObservation()
					.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	public void setObservation(org.openhealthtools.mdht.uml.cda.Observation observation) {
		mObservation = observation;
	}

	public void setTargetSite(ActSite actSite) {
		if (actSite != null) {
			mObservation.getTargetSiteCodes().clear();
			mObservation.getTargetSiteCodes().add(actSite.getCD());
		}
	}

	public void setTargetSite(ActSite actSite, LangTexts targetSiteLangTexts) {
		setTargetSite(actSite);
		myActSite = actSite;
		this.myTargetSiteLangTexts = targetSiteLangTexts;
	}

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

	public void setValue(Value value, LangTexts valueLangTexts) {
		setValue(value);
		this.myValueLangTexts = valueLangTexts;
	}
}
