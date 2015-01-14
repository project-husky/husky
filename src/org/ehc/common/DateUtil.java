package org.ehc.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;

/**
 * Utility for date handling.
 * 
 * @author gsc
 */
public class DateUtil {

	private DateUtil() {}
	
	/**
	 * Parse date in format yyyyMMdd.
	 * 
	 * @param value
	 * @return java.util.Date
	 * @throws ParseException
	 */
	public static Date parseDate(String value) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.parse(value);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Cannot parse date, value=[" + value + "]. Expected format is yyyyMMdd.", e);
		}
	}
	
	/**
	 * Converts Date to String.
	 * 
	 * @param date
	 * @return String - yyyyMMdd formatted
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
	/**
	 * Converts Date to String.
	 * 
	 * @param date
	 * @return String - dd.MM.yyyy formatted
	 */
	public static String formatDateCH(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(date);
	}	
	
	public static Date parseDate(TS timeStamp) {
		String value = timeStamp.getValue();
		return parseDate(value);
	}
	
	public static TS nowAsTS() {
		return ts(new Date());
	}
	
	public static TS ts(Date date) {
		TS timestamp = DatatypesFactory.eINSTANCE.createTS();
		timestamp.setValue(DateUtil.formatDate(date));
		return timestamp;
	}
	
}
