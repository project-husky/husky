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

import java.time.ZonedDateTime;
import java.util.Date;

import org.ehealth_connector.common.enums.DateTimeRangeAttributes;
import org.ehealth_connector.common.utils.DateUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.TimeRange;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.Precision;

/**
 * This class represents a date and time range
 */
public class DateTimeRange {

	/** the oht date time range */
	private org.openehealth.ipf.commons.ihe.xds.core.metadata.TimeRange ipfDtr;
	DateTimeRangeAttributes dateTimeRangeAttribute;

	/**
	 * Constructs a new DateTimeRange
	 *
	 * @param name The XDS metadata attribute to which this DateTimeRange belongs to
	 *             (CreationTime, ServiceStartTime, ServiceStopTime)
	 * @param from The point in time where this range starts
	 * @param to   The point in time where this range ends
	 */
	public DateTimeRange(DateTimeRangeAttributes name, Date from, Date to) {
		ipfDtr = new TimeRange();
		ipfDtr.setFrom(DateUtil.formatDateTimeTzon(from));
		ipfDtr.setTo(DateUtil.formatDateTimeTzon(to));
		dateTimeRangeAttribute = name;
	}

	/**
	 * Gets the point in time where this range starts
	 *
	 * @return the starting point
	 */
	public ZonedDateTime getFrom() {
		return ipfDtr.getFrom().getDateTime();
	}

	/**
	 * Gets the point in time where this range starts
	 *
	 * @return the start point
	 */
	public String getFromAsUsFormattedString() {
		return DateUtil.formatDateTimeTzon(ipfDtr.getFrom().getDateTime());
	}

	/**
	 * Gets the wrapped OHT DateTimeRange Object
	 *
	 * @return the DateTimeRange
	 */
	public org.openehealth.ipf.commons.ihe.xds.core.metadata.TimeRange getOhtDateTimeRange() {
		return this.ipfDtr;
	}

	/**
	 * Gets the point in time where this range ends
	 *
	 * @return the end point
	 */
	public ZonedDateTime getTo() {
		return ipfDtr.getTo().getDateTime();
	}

	/**
	 * Gets the point in time where this range ends
	 *
	 * @return the end point
	 */
	public String getToAsUsFormattedString() {
		return DateUtil.formatDateTimeTzon(ipfDtr.getTo().getDateTime());
	}

	/**
	 * Sets the point in time where this range starts
	 *
	 * @param from the starting point
	 */
	public void setFrom(Date from) {
		ipfDtr.setFrom(DateUtil.formatDateTimeTzon(from));
	}

	/**
	 * Sets the point in time where this range ends
	 *
	 * @param to the end point
	 */
	public void setTo(Date to) {
		ipfDtr.setTo(DateUtil.formatDateTimeTzon(to));
	}

	/**
	 * Sets the point in time where this range starts
	 *
	 * @param from the starting point
	 */
	public void setFrom(ZonedDateTime from, Precision precision) {
		ipfDtr.setFrom(new Timestamp(from, precision));
	}

	/**
	 * Sets the point in time where this range ends
	 *
	 * @param to the end point
	 */
	public void setTo(ZonedDateTime to, Precision precision) {
		ipfDtr.setTo(new Timestamp(to, precision));
	}

	public DateTimeRangeAttributes getDateTimeRangeAttribute() {
		return dateTimeRangeAttribute;
	}
}
