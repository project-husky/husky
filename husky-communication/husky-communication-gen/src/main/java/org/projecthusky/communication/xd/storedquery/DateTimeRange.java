/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.xd.storedquery;

import java.time.ZonedDateTime;

import org.projecthusky.common.enums.DateTimeRangeAttributes;
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
	public DateTimeRange(DateTimeRangeAttributes name, ZonedDateTime from, ZonedDateTime to) {
		ipfDtr = new TimeRange();
		ipfDtr.setFrom(new Timestamp(from, null));
		ipfDtr.setTo(new Timestamp(to, null));
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
		return ipfDtr.getFrom().toHL7();
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
		return ipfDtr.getTo().toHL7();
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
