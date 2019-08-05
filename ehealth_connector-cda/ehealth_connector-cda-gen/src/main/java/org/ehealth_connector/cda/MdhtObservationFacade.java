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
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ihe.lab.LaboratoryObservation;
import org.ehealth_connector.cda.ihe.lab.LaboratoryObservationComparator;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.utils.DateUtilOld;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Mdht Facade for Observations.
 *
 * @param <E>
 *            the element type
 */
public class MdhtObservationFacade<E extends Observation> extends MdhtFacade<E> {

	/**
	 * Instantiates a new instance.
	 *
	 * @param mdht
	 *            the mdht
	 */
	protected MdhtObservationFacade(E mdht) {
		super(mdht, null, null);
	}

	/**
	 * Instantiates a new instance.
	 *
	 * @param mdht
	 *            the mdht
	 * @param templateIdRoot
	 *            the template id root
	 * @param templateIdExtension
	 *            the template id extension
	 */
	protected MdhtObservationFacade(E mdht, String templateIdRoot, String templateIdExtension) {
		super(mdht, templateIdRoot, templateIdExtension);
	}

	/**
	 * Adds the interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	public void addInterpretationCode(Code code) {
		getMdht().getInterpretationCodes().add(code.getCE());
	}

	/**
	 * Adds the previous observation.
	 *
	 * @param prevObs
	 *            the prev obs
	 */
	public void addPreviousObservation(LaboratoryObservation prevObs) {
		EntryRelationship er = CDAFactory.eINSTANCE.createEntryRelationship();
		er.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
		er.setObservation(prevObs.getMdht());
		getMdht().getEntryRelationships().add(er);
	}

	/**
	 * Adds the value.
	 *
	 * @param value
	 *            the value
	 */
	protected void addValue(Value value) {
		if (getMdht() != null && getMdht().getValues() != null) {
			getMdht().getValues().add(value.getValue());
		}
	}

	/**
	 * Gets the Effective Time.
	 *
	 * @return the effective time as date
	 */
	public Date getEffectiveTime() {
		return DateUtilOld.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
	}

	/**
	 * Gets the interpretation code (first of the list or null if none in the
	 * list).
	 *
	 * @return the interpretation code
	 */
	public Code getInterpretationCode() {
		List<Code> list = getInterpretationCodes();
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	/**
	 * Gets a list of all observation interpretation codes.
	 *
	 * @return the list
	 */
	public List<Code> getInterpretationCodes() {
		final List<Code> icl = new ArrayList<Code>();
		for (final CE ic : getMdht().getInterpretationCodes()) {
			icl.add(new Code(ic));
		}
		return icl;
	}

	/**
	 * Gets the previous observations.
	 *
	 * @return the previous observations
	 */
	public List<LaboratoryObservation> getPreviousObservations() {
		ArrayList<LaboratoryObservation> retVal = new ArrayList<LaboratoryObservation>();
		for (EntryRelationship er : getMdht().getEntryRelationships()) {
			if (er.getObservation() != null) {
				org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdhtObs = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation) er
						.getObservation();
				LaboratoryObservation lObs = new LaboratoryObservation(mdhtObs);
				retVal.add(lObs);
			}
		}
		retVal.sort(new LaboratoryObservationComparator());
		return retVal;
	}

	/**
	 * Get the (first) problem value. The Value may be a coded or uncoded
	 * String.
	 *
	 * @return the (first) problem value as string.
	 */
	public Value getValue() {
		if (!getMdht().getValues().isEmpty()) {
			return new Value(getMdht().getValues().get(0));
		}
		return null;
	}

	/**
	 * Get a list of all values. Each Value may be a coded or uncoded String.
	 *
	 * @return all problem values as ArrayList.
	 */
	public List<Value> getValues() {
		final List<Value> vl = new ArrayList<Value>();
		for (final ANY a : getMdht().getValues()) {
			final Value v = new Value(a);
			vl.add(v);
		}
		return vl;
	}

	/**
	 * Sets the date time of result.
	 *
	 * @param dateTimeOfResult
	 *            the new date time of result
	 */
	public void setEffectiveTime(Date dateTimeOfResult) {
		if (dateTimeOfResult != null) {
			try {
				getMdht().setEffectiveTime(DateUtilOld.createIVL_TSFromEuroDateTime(dateTimeOfResult));
			} catch (final ParseException e) {
				e.printStackTrace();
			}
		}
	}

}
