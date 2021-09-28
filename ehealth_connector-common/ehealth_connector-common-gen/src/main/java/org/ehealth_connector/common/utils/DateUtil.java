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
package org.ehealth_connector.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.SXCMTS;
import org.ehealth_connector.common.hl7cdar2.TS;

/**
 * <div class="en">Toolbox for date handling.</div>
 *
 * <div class="de">Toolbox für das Datums-Handling.</div>
 *
 */
public class DateUtil {

	/**
	 * <div class="en">Creates a CDA R2 IVL_TS having the given nullFlavor
	 * set.</div>
	 *
	 * <div class="de">Erstellt ein CDA R2 IVL_TS mit dem angegebenen
	 * nullFlavor.</div>
	 *
	 * @param value
	 *            the value
	 * @return the ivlts
	 */
	public static IVLTS createIvltsUnknown(NullFlavor value) {
		ObjectFactory factory = new ObjectFactory();
		final IVLTS ts = factory.createIVLTS();
		ts.nullFlavor = new ArrayList<String>();
		if (value == null) {
			ts.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			ts.nullFlavor.add(value.getCodeValue());
		}
		return ts;
	}

	/**
	 * <div class="en">Creates a CDA R2 TS having the given nullFlavor
	 * set.</div>
	 *
	 * <div class="de">Erstellt ein CDA R2 TS mit dem angegebenen
	 * nullFlavor.</div>
	 *
	 * @param value
	 *            the value
	 * @return the ts
	 */
	public static TS createTsUnknown(NullFlavor value) {
		ObjectFactory factory = new ObjectFactory();
		final TS ts = factory.createTS();
		ts.nullFlavor = new ArrayList<String>();
		if (value == null) {
			ts.nullFlavor.add(NullFlavor.UNKNOWN.getCodeValue());
		} else {
			ts.nullFlavor.add(value.getCodeValue());
		}
		return ts;
	}

	/**
	 * <div class="en">Converts the given date to a CDA R2 IVL_TS value (without
	 * timezone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum in einen CDA R2
	 * IVL_TS-Wert (ohne Zeitzonenangabe).</div>
	 *
	 * @param value
	 *            the value
	 * @return the ivlts
	 */
	public static IVLTS date2Ivlts(Date value) {
		if (value == null) {
			return createIvltsUnknown(null);
		} else {
			ObjectFactory factory = new ObjectFactory();
			final IVLTS ts = factory.createIVLTS();
			ts.setValue(formatDateTime(value));
			return ts;
		}
	}

	/**
	 * <div class="en">Converts the given date to a CDA R2 IVL_TS value (without
	 * timezone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum in einen CDA R2
	 * IVL_TS-Wert (ohne Tageszeit und Zeitzonenangabe).</div>
	 *
	 * @param value
	 *            the value
	 * @return the ivlts
	 */
	public static IVLTS date2IvltsDateOnly(Date value) {
		if (value == null) {
			return createIvltsUnknown(null);
		} else {
			ObjectFactory factory = new ObjectFactory();
			final IVLTS ts = factory.createIVLTS();
			ts.setValue(formatDateOnly(value));
			return ts;
		}
	}

	/**
	 * <div class="en">Converts the given date to a CDA R2 IVL_TS value
	 * (including timezone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum in einen CDA R2
	 * IVL_TS-Wert (mit Zeitzonenangabe).</div>
	 *
	 * @param value
	 *            the value
	 * @return the ivlts
	 */
	public static IVLTS date2IvltsTzon(Date value) {
		if (value == null) {
			return createIvltsUnknown(null);
		} else {
			ObjectFactory factory = new ObjectFactory();
			final IVLTS ts = factory.createIVLTS();
			ts.setValue(formatDateTimeTzon(value));
			return ts;
		}
	}

	/**
	 * <div class="en">Converts the given dates to a CDA R2 IVL_TS (low and high
	 * values, both including time zone when not null or nullFlavor UNK when
	 * null).</div>
	 *
	 * <div class="de">Konvertiert die angegebenen Daten in ein CDA R2 IVL_TS
	 * (low und high values, beide mit Zeitzone, wenn nicht null, oder
	 * nullFlavor UNK, wenn null).</div>
	 *
	 * @param lowValue
	 *            the low value
	 * @param highValue
	 *            the high value
	 * @return the ivlts
	 */
	public static IVLTS date2IvltsTzon(Date lowValue, Date highValue) {
		ObjectFactory factory = new ObjectFactory();
		IVLTS retVal = factory.createIVLTS();

		TS tsLow = null;
		if (lowValue == null) {
			tsLow = createTsUnknown(null);
		} else {
			tsLow = factory.createTS();
			tsLow.setValue(formatDateTimeTzon(lowValue));
		}

		TS tsHigh = null;
		if (highValue == null) {
			tsHigh = createTsUnknown(null);
		} else {
			tsHigh = factory.createTS();
			tsHigh.setValue(formatDateTimeTzon(highValue));
		}

		retVal.getRest()
				.add(new JAXBElement<TS>(new QName("urn:hl7-org:v3", "low"), TS.class, tsLow));
		retVal.getRest()
				.add(new JAXBElement<TS>(new QName("urn:hl7-org:v3", "high"), TS.class, tsHigh));
		return retVal;
	}

	/**
	 * <div class="en">Converts the given date without day of time to a CDA R2
	 * TS (without time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum ohne Tageszeit in ein
	 * CDA R2 TS (ohne Zeitzone).</div>
	 *
	 * @param value
	 *            the value
	 * @return the ts
	 */
	public static SXCMTS date2SxcmTsDateOnly(Date value) {
		if (value == null) {
			return createIvltsUnknown(null);
		} else {
			ObjectFactory factory = new ObjectFactory();
			final SXCMTS ts = factory.createSXCMTS();
			ts.setValue(formatDateOnly(value));
			return ts;
		}
	}

	/**
	 * <div class="en">Converts the given date including day of time to a CDA R2
	 * TS (without time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum inkl. Tageszeit in ein
	 * CDA R2 TS (ohne Zeitzone).</div>
	 *
	 * @param value
	 *            the value
	 * @return the ts
	 */
	public static TS date2Ts(Date value) {
		if (value == null) {
			return createIvltsUnknown(null);
		} else {
			ObjectFactory factory = new ObjectFactory();
			final TS ts = factory.createTS();
			ts.setValue(formatDateTime(value));
			return ts;
		}
	}

	/**
	 * <div class="en">Converts the given date without day of time to a CDA R2
	 * TS (without time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum ohne Tageszeit in ein
	 * CDA R2 TS (ohne Zeitzone).</div>
	 *
	 * @param value
	 *            the value
	 * @return the ts
	 */
	public static TS date2TsDateOnly(Date value) {
		if (value == null) {
			return createIvltsUnknown(null);
		} else {
			ObjectFactory factory = new ObjectFactory();
			final TS ts = factory.createTS();
			ts.setValue(formatDateOnly(value));
			return ts;
		}
	}

	/**
	 * <div class="en">Converts the given date without day of time to a CDA R2 TS
	 * (without time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum ohne Tageszeit in ein CDA R2
	 * TS (ohne Zeitzone).</div>
	 *
	 * @param value the value
	 * @return the ts
	 */
	public static TS date2TsDateOnly(ZonedDateTime value) {
		if (value == null) {
			return createIvltsUnknown(null);
		} else {
			ObjectFactory factory = new ObjectFactory();
			final TS ts = factory.createTS();
			ts.setValue(formatDateOnly(value));
			return ts;
		}
	}

	/**
	 * <div class="en">Converts the given date including day of time to a CDA R2
	 * TS (including time zone).</div>
	 *
	 * <div class="de">Konvertiert das angegebene Datum inkl. Tageszeit in ein
	 * CDA R2 TS (mit Zeitzone).</div>
	 *
	 * @param value
	 *            the value
	 * @return the ts
	 */
	public static TS date2TsTzon(Date value) {
		if (value == null) {
			return createIvltsUnknown(null);
		} else {
			ObjectFactory factory = new ObjectFactory();
			final TS ts = factory.createTS();
			ts.setValue(formatDateTimeTzon(value));
			return ts;
		}
	}

	/**
	 * <div class="en">Formats the given timestamp as String: yyyyMMdd</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMdd</div>
	 *
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String formatDateOnly(Date value) {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(value);
	}

	/**
	 * <div class="en">Formats the given timestamp as String: yyyyMMdd</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMdd</div>
	 *
	 * @param value the value
	 * @return the string
	 */
	public static String formatDateOnly(ZonedDateTime value) {
		return value.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	/**
	 * <div class="en">Formats the given timestamp as String:
	 * yyyyMMddHHmmss</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMddHHmmss</div>
	 *
	 * @param value
	 *            the value
	 * @return the string
	 */
	public static String formatDateTime(Date value) {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(value);
	}

	/**
	 * <div class="en">Formats the given timestamp as String: yyyyMMddHHmmss</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMddHHmmss</div>
	 *
	 * @param value the value
	 * @return the string
	 */
	public static String formatDateTime(ZonedDateTime value) {
		return value.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.systemDefault()));
	}

	/**
	 * <div class="en">Formats the given timestamp as String:
	 * yyyyMMddHHmmssXXXX</div>
	 *
	 * <div class="de">Formatiert den angegebenen Zeitstempel als String:
	 * yyyyMMddHHmmssXXXX</div>
	 *
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
	 *
	 * @param value the value
	 * @return the string
	 */
	public static String formatDateTimeTzon(ZonedDateTime value) {
		return value.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssZ").withZone(ZoneId.systemDefault()));
	}

	/**
	 * <div class="en">Returns the current system timestamp.</div>
	 *
	 * <div class="de">Liefert die aktuelle Systemzeit.</div>
	 *
	 * @return the date
	 */
	public static Date nowAsDate() {
		return new Date();
	}

	/**
	 * <div class="en">Returns the current system timestamp.</div>
	 *
	 * <div class="de">Liefert die aktuelle Systemzeit.</div>
	 *
	 * @return the date
	 */
	public static ZonedDateTime nowAsZonedDate() {
		return ZonedDateTime.now();
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
	 *
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
	 *
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
	 * format: yyyy</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyy</div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de">value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyy(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date, value=[" + value + "]. Expected format is yyyy.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMM</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMM</div>
	 *
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
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMM.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMdd</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMdd</div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de">value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMdd(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMdd.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyy-MM-dd</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyy-MM-dd</div>
	 *
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
					"Cannot parse date, value=[" + value + "]. Expected format is yyyy-MM-dd.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHH</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHH</div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHH(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMddHH.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmm</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmm</div>
	 *
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
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMddHHmm.",
					e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmmss</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmmss</div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmmss(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			sdf.setTimeZone(TimeZone.getDefault());
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMddHHmmss.",
					e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmmssSSSZZZZ</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmmssSSSZZZZ</div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmmssSSSZZZZ(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSZZZZ");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException("Cannot parse date, value=[" + value
					+ "]. Expected format is yyyyMMddHHmmssSSSZZZZ.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmmssZZZZ</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmmssZZZZ</div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmmssZZZZ(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssZZZZ");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException("Cannot parse date, value=[" + value
					+ "]. Expected format is yyyyMMddHHmmssZZZZ.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmmZ</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmmZ</div>
	 *
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
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMdd.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHmmZZZZ</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHmmZZZZ</div>
	 *
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
			throw new IllegalArgumentException("Cannot parse date, value=[" + value
					+ "]. Expected format is yyyyMMddHHmmZZZZ.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyyMMddHHZZZZ</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyyMMddHHZZZZ</div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHZZZZ(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHZZZZ");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMddHHZZZZ.",
					e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyy-MM-dd'T'HH:mm:ss</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyy-MM-dd'T'HH:mm:ss</div>
	 *
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
			throw new IllegalArgumentException("Cannot parse date, value=[" + value
					+ "]. Expected format is yyyy-MM-ddTHH:mm:ss.", e);
		}
	}

	/**
	 * <div class="en">Parses the given String into a timestamp. Expected
	 * format: yyyy[MM[dd[HH[mm[ss[ZZZZ]]]]]]</div>
	 *
	 * <div class="de">Parst den angegebenen String in einen Zeitstempel.
	 * Erwartetes Format: yyyy[MM[dd[HH[mm[ss[ZZZZ]]]]]]</div>
	 *
	 * @param value
	 *            the value
	 * @return the date
	 */
	public static Date parseHl7Timestamp(String value) {
		Date retVal = null;
		if (value != null) {
			if (value.contains("+")) {
				if (value.length() == 19)
					retVal = parseDateyyyyMMddHHmmssZZZZ(value);
				else if (value.length() == 17)
					retVal = parseDateyyyyMMddHHmmZZZZ(value);
				else if (value.length() == 15)
					retVal = parseDateyyyyMMddHHZZZZ(value);
			} else {
				if (value.length() == 14)
					retVal = parseDateyyyyMMddHHmmss(value);
				else if (value.length() == 12)
					retVal = parseDateyyyyMMddHHmm(value);
				else if (value.length() == 10)
					retVal = parseDateyyyyMMddHH(value);
				else if (value.length() == 8)
					retVal = parseDateyyyyMMdd(value);
				else if (value.length() == 6)
					retVal = parseDateyyyyMM(value);
				else if (value.length() == 4)
					retVal = parseDateyyyy(value);
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Parses the given HL7 CDA R2 TS into a timestamp</div>
	 *
	 * <div class="de">Parst den angegebenen HL7 CDA R2 TS in einen
	 * Zeitstempel./div>
	 *
	 * @param value
	 *            the value
	 * @return the date
	 */
	public static Date parseHl7Timestamp(TS value) {
		return parseHl7Timestamp(value.getValue());
	}

	/**
	 * Check whether the dates of the two dates are equal (ignoring the time of the
	 * day).
	 *
	 * @param validFrom  the valid from
	 * @param validFrom2 the valid from 2
	 * @return true, if equal
	 */
	public static boolean equalsDateOnly(Date validFrom, Date validFrom2) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String validFromStr = dateFormat.format(validFrom);
		String validFromStr2 = dateFormat.format(validFrom2);
		return validFromStr.equals(validFromStr2);
	}

}
