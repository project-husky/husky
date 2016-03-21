package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;

public class MdhtObservationFacade<E extends Observation> extends MdhtFacade<E> {

	protected MdhtObservationFacade(E mdht) {
		super(mdht, null, null);
	}

	protected MdhtObservationFacade(E mdht, String templateIdRoot, String templateIdExtension) {
		super(mdht, templateIdRoot, templateIdExtension);
	}

	/**
	 * Gets the Effective Time
	 *
	 * @return the effective time as date
	 */
	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
	}

	/**
	 * Get the (first) problem value. The Value may be a coded or uncoded String.
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
	 * Sets the date time of result.
	 *
	 * @param dateTimeOfResult
	 *          the new date time of result
	 */
	public void setEffectiveTime(Date dateTimeOfResult) {
		try {
			getMdht().setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	protected void addValue(Value value) {
		if (getMdht() != null && getMdht().getValues() != null) {
			getMdht().getValues().add(value.getValue());
		}
	}

	/**
	 * Get a list of all problem values. Each Value may be a coded or uncoded
	 * String.
	 *
	 * @return all problem values as ArrayList.
	 */
	protected List<Value> getValues() {
		final List<Value> vl = new ArrayList<Value>();
		for (final ANY a : getMdht().getValues()) {
			final Value v = new Value(a);
			vl.add(v);
		}
		return vl;
	}
}
