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
package org.husky.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.TS;

/**
 * <div class="en">Toolbox for date handling.</div>
 *
 * <div class="de">Toolbox für das Datums-Handling.</div>
 *
 * Deprecated, use {@link org.husky.common.utils.time.Hl7Dtm}, {@link org.husky.common.utils.time.DateTimes} and the
 * new Java time API.
 * @deprecated
 */
@Deprecated (since="1.0", forRemoval=true)
public class DateUtil {
	
	public static final String SHORT_DATE_FORMAT = "yyyyMMdd";
	public static final String LONG_DATE_FORMAT = "yyyyMMddHHmmss";
	public static final String ERRORMSG_CANNOT_PARSE_DATE_VAL = "Cannot parse date, value=[";
	
	private DateUtil() {
		
	}

	/**
	 * <div class="en">Converts the given date to a CDA R2 IVL_TS value (without
	 * timezone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum in einen CDA R2
	 * IVL_TS-Wert (ohne Zeitzonenangabe).</div>
	 * @deprecated
	 * @param value
	 *            the value
	 * @return the ivlts
	 */
	
	public static IVLTS date2Ivlts(Date value) {
		if (value == null) {
			return new IVLTS(NullFlavor.UNKNOWN);
		} else {
			return new IVLTS(formatDateTime(value));
		}
	}

	/**
	 * <div class="en">Converts the given date to a CDA R2 IVL_TS value (without
	 * timezone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum in einen CDA R2
	 * IVL_TS-Wert (ohne Tageszeit und Zeitzonenangabe).</div>
	 * @deprecated
	 * @param value
	 *            the value
	 * @return the ivlts
	 */
	public static IVLTS date2IvltsDateOnly(Date value) {
		if (value == null) {
			return new IVLTS(NullFlavor.UNKNOWN);
		} else {
			return new IVLTS(formatDateOnly(value));
		}
	}

	/**
	 * <div class="en">Converts the given date to a CDA R2 IVL_TS value
	 * (including timezone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum in einen CDA R2
	 * IVL_TS-Wert (mit Zeitzonenangabe).</div>
	 * @deprecated
	 * @param value
	 *            the value
	 * @return the ivlts
	 */
	public static IVLTS date2IvltsTzon(Date value) {
		if (value == null) {
			return new IVLTS(NullFlavor.UNKNOWN);
		} else {
			return new IVLTS(formatDateTimeTzon(value));
		}
	}


	/**
	 * <div class="en">Converts the given date including day of time to a CDA R2
	 * TS (without time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum inkl. Tageszeit in ein
	 * CDA R2 TS (ohne Zeitzone).</div>
	 * @deprecated
	 * @param value
	 *            the value
	 * @return the ts
	 */
	public static TS date2Ts(Date value) {
		if (value == null) {
			return new IVLTS(NullFlavor.UNKNOWN);
		} else {
			return new TS(formatDateTime(value));
		}
	}

	/**
	 * <div class="en">Converts the given date without day of time to a CDA R2
	 * TS (without time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum ohne Tageszeit in ein
	 * CDA R2 TS (ohne Zeitzone).</div>
	 * @deprecated
	 * @param value
	 *            the value
	 * @return the ts
	 */
	public static TS date2TsDateOnly(Date value) {
		if (value == null) {
			return new IVLTS(NullFlavor.UNKNOWN);
		} else {
			return new TS(formatDateOnly(value));
		}
	}

	/**
	 * <div class="en">Converts the given date without day of time to a CDA R2 TS
	 * (without time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum ohne Tageszeit in ein CDA R2
	 * TS (ohne Zeitzone).</div>
	 * @deprecated
	 * @param value the value
	 * @return the ts
	 */
	public static TS date2TsDateOnly(ZonedDateTime value) {
		if (value == null) {
			return new IVLTS(NullFlavor.UNKNOWN);
		} else {
			return new TS(formatDateOnly(value));
		}
	}

	/**
	 * <div class="en">Converts the given date including day of time to a CDA R2
	 * TS (including time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum inkl. Tageszeit in ein
	 * CDA R2 TS (mit Zeitzone).</div>
	 * @deprecated
	 * @param value
	 *            the value
	 * @return the ts
	 */
	public static TS date2TsTzon(Date value) {
		if (value == null) {
			return new IVLTS(NullFlavor.UNKNOWN);
		} else {
			return new TS(formatDateTimeTzon(value));
		}
	}

	/**
	 * <div class="en">Formats the given timestamp as String: yyyyMMdd</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMdd</div>
	 * @deprecated
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String formatDateOnly(Date value) {
		final SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		return sdf.format(value);
	}

	/**
	 * <div class="en">Formats the given timestamp as String: yyyyMMdd</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMdd</div>
	 * @deprecated
	 * @param value the value
	 * @return the string
	 */
	public static String formatDateOnly(ZonedDateTime value) {
		return value.format(DateTimeFormatter.ofPattern(SHORT_DATE_FORMAT));
	}

	/**
	 * <div class="en">Formats the given timestamp as String:
	 * yyyyMMddHHmmss</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMddHHmmss</div>
	 * @deprecated
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String formatDateTime(Date value) {
		final SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
		return sdf.format(value);
	}

	/**
	 * <div class="en">Formats the given timestamp as String: yyyyMMddHHmmss</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMddHHmmss</div>
	 * @deprecated
	 * @param value the value
	 * @return the string
	 */
	public static String formatDateTime(ZonedDateTime value) {
		return value.format(DateTimeFormatter.ofPattern(LONG_DATE_FORMAT).withZone(ZoneId.systemDefault()));
	}

	/**
	 * <div class="en">Formats the given timestamp as String:
	 * yyyyMMddHHmmssXXXX</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMddHHmmssXXXX</div>
	 * @deprecated
	 * @param value the value
	 * @return the string
	 */
	public static String formatDateTimeTzon(Date value) {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssZ");
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(value);
	}

	/**
	 * <div class="en">Formats the given timestamp as String:
	 * yyyyMMddHHmmssXXXX</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMddHHmmssXXXX</div>
	 * @deprecated
	 * @param value the value
	 * @return the string
	 */
	public static String formatDateTimeTzon(ZonedDateTime value) {
		return value.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssZ").withZone(ZoneId.systemDefault()));
	}

	public static Date parseDate(ZonedDateTime date) {
		return Date.from(date.toInstant());
	}

	public static ZonedDateTime parseZonedDate(Date date) {
		return ZonedDateTime.from(date.toInstant().atZone(ZoneId.systemDefault()));
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: dd.MM.yyyy</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: dd.MM.yyyy</div>
	 * @deprecated
	 * @param dateSt
	 *            <br>
	 *            <div class="en"> date String</div>
	 * @return the date
	 */
	public static Date parseDate(String dateSt) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			return sdf.parse(dateSt);
		} catch (final ParseException e) {
			// convert to RuntimeException
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: dd.MM.yyyy HH:mm or dd.MM.yyyy HH:mm:ss</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: dd.MM.yyyy HH:mm oder dd.MM.yyyy HH:mm:ss</div>
	 * @deprecated
	 * @param dateSt
	 *            <br>
	 *            <div class="de"> date String</div>
	 * @return the date
	 */
	public static Date parseDateAndTime(String dateSt) {
		try {
			SimpleDateFormat sdf;
			if (dateSt.length() > 16)
				sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			else
				sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

			return sdf.parse(dateSt);
		} catch (final ParseException e) {
			// convert to RuntimeException
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMM</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMM</div>
	 * @deprecated
	 * @param value
	 *            <br>
	 *            <div class="de">value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMM(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					ERRORMSG_CANNOT_PARSE_DATE_VAL + value + "]. Expected format is yyyyMM.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMdd</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMdd</div>
	 * @deprecated
	 * @param value
	 *            <br>
	 *            <div class="de">value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMdd(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					ERRORMSG_CANNOT_PARSE_DATE_VAL + value + "]. Expected format is yyyyMMdd.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyy-MM-dd</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyy-MM-dd</div>
	 * @deprecated
	 * @param value
	 *            <br>
	 *            <div class="de">value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMdd2(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					ERRORMSG_CANNOT_PARSE_DATE_VAL + value + "]. Expected format is yyyy-MM-dd.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmm</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmm</div>
	 * @deprecated
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmm(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					ERRORMSG_CANNOT_PARSE_DATE_VAL + value + "]. Expected format is yyyyMMddHHmm.",
					e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmmss</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmmss</div>
	 * @deprecated
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmmss(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
			sdf.setTimeZone(TimeZone.getDefault());
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					ERRORMSG_CANNOT_PARSE_DATE_VAL + value + "]. Expected format is yyyyMMddHHmmss.",
					e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmmZ</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmmZ</div>
	 * @deprecated
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmmZ(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmZ");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					ERRORMSG_CANNOT_PARSE_DATE_VAL + value + "]. Expected format is yyyyMMdd.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmmZZZZ</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmmZZZZ</div>
	 * @deprecated
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmmZZZZ(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmZZZZ");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(ERRORMSG_CANNOT_PARSE_DATE_VAL + value
					+ "]. Expected format is yyyyMMddHHmmZZZZ.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyy-MM-dd'T'HH:mm:ss</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyy-MM-dd'T'HH:mm:ss</div>
	 * @deprecated
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddTHHmmss(String value) {
		try {
			// 2017-04-15T17:10:29
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(ERRORMSG_CANNOT_PARSE_DATE_VAL + value
					+ "]. Expected format is yyyy-MM-ddTHH:mm:ss.", e);
		}
	}

	/**
	 * Check whether the dates of the two dates are equal (ignoring the time of the
	 * day).
	 * @deprecated
	 * @param validFrom  the valid from
	 * @param validFrom2 the valid from 2
	 * @return true, if equal
	 */
	public static boolean equalsDateOnly(Date validFrom, Date validFrom2) {
		DateFormat dateFormat = new SimpleDateFormat(SHORT_DATE_FORMAT);
		String validFromStr = dateFormat.format(validFrom);
		String validFromStr2 = dateFormat.format(validFrom2);
		return validFromStr.equals(validFromStr2);
	}

}
