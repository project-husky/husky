package org.ehealth_connector.communication.ch.storedquery;

import java.util.Date;

import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.communication.ch.enums.DateTimeRangeAttributes;
import org.openhealthtools.ihe.xds.consumer.query.MalformedQueryException;

public class DateTimeRange {
	org.openhealthtools.ihe.xds.consumer.query.DateTimeRange ohtDtr;
	
	public DateTimeRange(DateTimeRangeAttributes name, Date from, Date to) throws MalformedQueryException {
		ohtDtr = new org.openhealthtools.ihe.xds.consumer.query.DateTimeRange(name.getName(), DateUtil.format(from), DateUtil.format(to));
	}
	
	public Date getFrom() {
		return DateUtil.parseDateyyyyMMddHHmmss(ohtDtr.getFrom());
	}
	
	public Date getTo() {
		return DateUtil.parseDateyyyyMMddHHmmss(ohtDtr.getTo());
	}
	
	public void setFrom(Date from) {
		ohtDtr.setFrom(DateUtil.format(from));
	}
	
	public void setTo(Date to) {
		ohtDtr.setFrom(DateUtil.format(to));
	}
	
	public org.openhealthtools.ihe.xds.consumer.query.DateTimeRange getOhtDateTimeRange() {
		return this.ohtDtr;
	}
}
