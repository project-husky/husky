/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.communication.xd.storedquery;

import java.util.Date;

import org.ehealth_connector.common.mdht.enums.DateTimeRangeAttributes;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.openhealthtools.ihe.xds.consumer.query.MalformedQueryException;

/**
 * This class represents a date and time range
 */
public class DateTimeRange {

	/** the oht date time range */
	private org.openhealthtools.ihe.xds.consumer.query.DateTimeRange ohtDtr;

	/**
	 * Constructs a new DateTimeRange
	 *
	 * @param name
	 *            The XDS metadata attribute to which this DateTimeRange belongs
	 *            to (CreationTime, ServiceStartTime, ServiceStopTime)
	 * @param from
	 *            The point in time where this range starts
	 * @param to
	 *            The point in time where this range ends
	 */
	public DateTimeRange(DateTimeRangeAttributes name, Date from, Date to) {
		try {
			ohtDtr = new org.openhealthtools.ihe.xds.consumer.query.DateTimeRange(name.getName(),
					DateUtilMdht.format(from), DateUtilMdht.format(to));
		} catch (final MalformedQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the point in time where this range starts
	 *
	 * @return the starting point
	 */
	public Date getFrom() {
		return DateUtil.parseDateyyyyMMddHHmmss(ohtDtr.getFrom());
	}

	/**
	 * Gets the point in time where this range starts
	 *
	 * @return the start point
	 */
	public String getFromAsUsFormattedString() {
		return ohtDtr.getFrom();
	}

	/**
	 * Gets the wrapped OHT DateTimeRange Object
	 *
	 * @return the DateTimeRange
	 */
	public org.openhealthtools.ihe.xds.consumer.query.DateTimeRange getOhtDateTimeRange() {
		return this.ohtDtr;
	}

	/**
	 * Gets the point in time where this range ends
	 *
	 * @return the end point
	 */
	public Date getTo() {
		return DateUtil.parseDateyyyyMMddHHmmss(ohtDtr.getTo());
	}

	/**
	 * Gets the point in time where this range ends
	 *
	 * @return the end point
	 */
	public String getToAsUsFormattedString() {
		return ohtDtr.getTo();
	}

	/**
	 * Sets the point in time where this range starts
	 *
	 * @param from
	 *            the starting point
	 */
	public void setFrom(Date from) {
		ohtDtr.setFrom(DateUtilMdht.format(from));
	}

	/**
	 * Sets the point in time where this range ends
	 *
	 * @param to
	 *            the end point
	 */
	public void setTo(Date to) {
		ohtDtr.setTo(DateUtilMdht.format(to));
	}
}
