/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Utility for date handling.
 *
 */
public class DateUtil {

	/**
	 * <div class="en">Convert date.</div>
	 *
	 * @param date
	 *          <br>
	 *          <div class="en"> date</div>
	 * @return the ivl ts
	 */
	public static IVL_TS convertDate(Date date) {
		if (date == null) {
			return createUnknownTime(null);
		} else {
			final IVL_TS ts = DatatypesFactory.eINSTANCE.createIVL_TS();
			ts.setValue(format(date));
			return ts;
		}
	}

	/**
	 * <div class="en">Convert date.</div>
	 *
	 * @param date
	 *          <br>
	 *          <div class="en"> date</div>
	 * @return the ivl ts
	 */
	public static IVL_TS convertDateyyyyMMddHHmmssZZZZ(Date date) {
		if (date == null) {
			return createUnknownTime(null);
		} else {
			final IVL_TS ts = DatatypesFactory.eINSTANCE.createIVL_TS();

			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssZZZZ");
			final String tsStr = sdf.format(date);

			ts.setValue(tsStr);
			return ts;
		}
	}

	/**
	 * <div class="en">Convert sxc m_ ts to eur string.</div>
	 * <div class="de"></div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param effectiveTimes
	 *          <br>
	 *          <div class="en"> effective times</div> <div class="de"> </div>
	 *          <div class="fr"> </div> <div class="it"> </div>
	 * @return the string
	 */
	public static String convertSXCM_TSToEurString(List<SXCM_TS> effectiveTimes) {
		final StringBuilder b = new StringBuilder();
		for (final SXCM_TS effectiveTime : effectiveTimes) {
			if (effectiveTime instanceof IVL_TS) {
				final IVL_TS effectiveTimeInterval = (IVL_TS) effectiveTime;
				if (effectiveTimeInterval.getLow() != null) {
					final Date tsLow = DateUtil.parseDateyyyyMMdd(effectiveTimeInterval.getLow().getValue());
					if ((effectiveTimeInterval.getHigh() != null)
							&& (effectiveTimeInterval.getHigh().getValue() != null)) {
						final Date tsHigh = DateUtil
								.parseDateyyyyMMdd(effectiveTimeInterval.getHigh().getValue());
						final String tsHighStr = DateUtil.formatDateCH(tsHigh);
						final String tsLowStr = DateUtil.formatDateCH(tsLow);
						b.append(tsLowStr + " - " + tsHighStr);
					} else {
						final String tsLowStr = DateUtil.formatDateCH(tsLow);
						b.append(tsLowStr);
					}
				}
			} else {
				if (effectiveTime instanceof TS) {
					final Date ts = DateUtil.parseDateyyyyMMdd(effectiveTime.getValue());
					final String tsStr = DateUtil.formatDateCH(ts);
					b.append(tsStr);
				}
				b.append(" ");
			}
		}
		return b.toString();
	}

	/**
	 * Creates an IVL_TS object
	 *
	 * @param eurDateTime
	 *          <div class="en">start of an interval in the european format
	 *          dd.MM.yyyy</div> <div class="de">der Begin des Intervals in dem
	 *          Format dd.MM.yyyy wie er in Europa gebräuchlich ist</div>
	 * @return HL7 IVL_TS Objekt
	 * @throws ParseException
	 *           the parse exception
	 */
	public static IVL_TS createIVL_TSFromEuroDate(Date eurDateTime) throws ParseException {
		// Create OHT Data structure
		final IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

		final DateFormat cdaDateFormatter = new SimpleDateFormat("yyyyMMdd");
		// Create and set Begin
		if (eurDateTime != null) {
			ohtInterval.setValue(cdaDateFormatter.format(eurDateTime));
		} else {
			ohtInterval.setLow(createIVXB_TSFromDate(null));
		}

		return ohtInterval;
	}

	/**
	 * Creates an IVL_TS object
	 *
	 * @param eurDateBegin
	 *          <div class="en">start of an interval in the european format
	 *          dd.MM.yyyy</div> <div class="de">der Begin des Intervals in dem
	 *          Format dd.MM.yyyy wie er in Europa gebräuchlich ist</div>
	 * @param eurDateEnd
	 *          <div class="en">end of an interval in the european format
	 *          dd.MM.yyyy</div> <div class="de">das Ende des Intervals in dem
	 *          Format dd.MM.yyyy wie er in Europa gebräuchlich ist</div>
	 * @return HL7 IVL_TS Objekt
	 * @throws ParseException
	 *           the parse exception
	 */
	public static IVL_TS createIVL_TSFromEuroDate(Date eurDateBegin, Date eurDateEnd)
			throws ParseException {
		// Create OHT Data structure
		final IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

		// Create and set Begin
		ohtInterval.setLow(createIVXB_TSFromDate(eurDateBegin));

		// Create and set End
		ohtInterval.setHigh(createIVXB_TSFromDate(eurDateEnd));
		return ohtInterval;
	}

	/**
	 * Creates an IVL_TS object
	 *
	 * @param eurDateBegin
	 *          <div class="en">start of an interval in the european format
	 *          dd.MM.yyyy</div> <div class="de">der Begin des Intervals in dem
	 *          Format dd.MM.yyyy wie er in Europa gebräuchlich ist</div>
	 * @param eurDateEnd
	 *          <div class="en">end of an interval in the european format
	 *          dd.MM.yyyy</div> <div class="de">das Ende des Intervals in dem
	 *          Format dd.MM.yyyy wie er in Europa gebräuchlich ist</div>
	 * @return HL7 IVL_TS Objekt
	 * @throws ParseException
	 *           the parse exception
	 */
	public static IVL_TS createIVL_TSFromEuroDate(String eurDateBegin, String eurDateEnd)
			throws ParseException {
		// Create OHT Data structure
		final IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

		// Create and set Begin
		ohtInterval.setLow(createIVXB_TSFromEuroDate(eurDateBegin));

		// Create and set End
		ohtInterval.setHigh(createIVXB_TSFromEuroDate(eurDateEnd));

		return ohtInterval;
	}

	/**
	 * Creates an IVL_TS object
	 *
	 * @param eurDateTime
	 *          <div class="en">start of an interval in the european format
	 *          dd.MM.yyyy</div> <div class="de">der Begin des Intervals in dem
	 *          Format dd.MM.yyyy wie er in Europa gebräuchlich ist</div>
	 * @return HL7 IVL_TS Objekt
	 * @throws ParseException
	 *           the parse exception
	 */
	public static IVL_TS createIVL_TSFromEuroDateTime(Date eurDateTime) throws ParseException {
		// Create OHT Data structure
		final IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

		final DateFormat cdaDateFormatter = new SimpleDateFormat("yyyyMMddHHmmZ");
		// Create and set Begin
		ohtInterval.setValue(cdaDateFormatter.format(eurDateTime));

		return ohtInterval;
	}

	/**
	 * Creates an IVL_TS object
	 *
	 * @param yyyyMMdd
	 *          <div class="en">start of an interval in the format yyyyMMdd</div>
	 *          <div class="de">der Begin des Intervals im Format yyyyMMdd</div>
	 * @return HL7 IVL_TS Objekt
	 * @throws ParseException
	 *           the parse exception
	 */
	public static IVL_TS createIVL_TSFromHL7Date(String yyyyMMdd) throws ParseException {
		// Create OHT Data structure
		final IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();
		ohtInterval.setValue(yyyyMMdd);
		return ohtInterval;
	}

	/**
	 * <div class="en">Creates an IVXB_TS Object day resolution.
	 *
	 * @param date
	 *          date</div> <div class="de"></div><div class="fr"></div>
	 *          <div class="it"></div>
	 * @return HL7 IVXB_TS Objekt
	 */
	public static IVXB_TS createIVXB_TSFromDate(Date date) {
		// Create IVXB_TS
		final IVXB_TS ohtIntervalPoint = DatatypesFactory.eINSTANCE.createIVXB_TS();
		if (date == null) {
			ohtIntervalPoint.setNullFlavor(NullFlavor.UNK);
		} else {
			ohtIntervalPoint.setValue(DateUtil.formatDate(date));
		}
		return ohtIntervalPoint;
	}

	/**
	 * <div class="en">Creates an IVXB_TS Object day/time resolution.
	 *
	 * @param date
	 *          date</div> <div class="de"></div><div class="fr"></div>
	 *          <div class="it"></div>
	 * @return HL7 IVXB_TS Objekt
	 */
	public static IVXB_TS createIVXB_TSFromDateTime(Date date) {
		// Create IVXB_TS
		final IVXB_TS ohtIntervalPoint = DatatypesFactory.eINSTANCE.createIVXB_TS();
		if (date == null) {
			ohtIntervalPoint.setNullFlavor(NullFlavor.UNK);
		} else {
			ohtIntervalPoint.setValue(DateUtil.format(date));
		}
		return ohtIntervalPoint;
	}

	/**
	 * Creates an IVXB_TS Objekt.
	 *
	 * @param eurDateStr
	 *          a Date String in the European Format dd.MM.yyyy
	 * @return HL7 IVXB_TS Objekt
	 * @throws ParseException
	 *           the parse exception
	 */
	public static IVXB_TS createIVXB_TSFromEuroDate(String eurDateStr) throws ParseException {
		final IVXB_TS ohtIntervalPoint = DatatypesFactory.eINSTANCE.createIVXB_TS();
		if (eurDateStr == null) {
			ohtIntervalPoint.setNullFlavor(NullFlavor.UNK);
		} else {
			final DateFormat eurDateFormatter = new SimpleDateFormat("dd.MM.yyyy");
			final DateFormat ohtDateFormatter = new SimpleDateFormat("yyyyMMdd");

			// Parse date
			final Date date = eurDateFormatter.parse(eurDateStr);
			final String ohtDate = ohtDateFormatter.format(date);

			// Create IVXB_TS
			ohtIntervalPoint.setValue(ohtDate);
		}

		return ohtIntervalPoint;
	}

	/**
	 * Creates an MDHT SXCM_TS object
	 *
	 * @param date
	 *          the date
	 * @return the MDHT SXCM_TS object
	 */
	public static SXCM_TS createSTCM_TS(Date date) {
		try {
			final IVL_TS ivl_ts = createIVL_TSFromEuroDate(date);
			final SXCM_TS sxcm_ts = ivl_ts;
			return sxcm_ts;
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <div class="en">Creates the stc m_ ts.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param startOfPossibleAppliance
	 *          <br>
	 *          <div class="en"> start of possible appliance</div>
	 * @param endOfPossibleAppliance
	 *          <br>
	 *          <div class="en"> end of possible appliance</div>
	 * @return the sxcm ts
	 */
	public static SXCM_TS createSTCM_TS(Date startOfPossibleAppliance, Date endOfPossibleAppliance) {
		try {
			final IVL_TS ivl_ts = createIVL_TSFromEuroDate(startOfPossibleAppliance,
					endOfPossibleAppliance);
			final SXCM_TS sxcm_ts = ivl_ts;
			return sxcm_ts;
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates an TS Object.
	 *
	 * @param eurDate
	 *          <br>
	 *          <div class="de"> eur date</div>
	 * @return HL7 TS Object
	 * @throws ParseException
	 *           the parse exception
	 */
	public static TS createTSFromEuroDate(Date eurDate) throws ParseException {
		final DateFormat ohtDateFormatter = new SimpleDateFormat("yyyyMMdd");

		final String ohtDateStr = ohtDateFormatter.format(eurDate);

		final TS ohtDate = DatatypesFactory.eINSTANCE.createTS(ohtDateStr);
		return ohtDate;
	}

	/**
	 * Creates an TS Object.
	 *
	 * @param eurDateStr
	 *          <div class="en">a String in the european format dd.MM.yyyy</div>
	 *          <div class="de">Ein String in dem Format dd.MM.yyyy wie er in
	 *          Europa gebräuchlich ist</div>
	 * @return HL7 TS Objekt
	 * @throws ParseException
	 *           the parse exception
	 */
	public static TS createTSFromEuroDateStr(String eurDateStr) throws ParseException {
		final DateFormat eurDateFormatter = new SimpleDateFormat("dd.MM.yyyy");
		final DateFormat ohtDateFormatter = new SimpleDateFormat("yyyyMMdd");

		final Date eurDate = eurDateFormatter.parse(eurDateStr);
		final String ohtDateStr = ohtDateFormatter.format(eurDate);

		final TS ohtDate = DatatypesFactory.eINSTANCE.createTS(ohtDateStr);
		return ohtDate;
	}

	/**
	 * <div class="en">Creates the unknown low high time null flavor.</div>
	 * <div class="de"></div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the ivl ts
	 */
	public static IVL_TS createUnknownLowHighTimeNullFlavor() {
		final IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
		effectiveTime.setLow(Util.createNullFlavorUnknown());
		effectiveTime.setHigh(Util.createNullFlavorUnknown());
		return effectiveTime;
	}

	/**
	 * <div class="en">Creates the unknown time.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param nf
	 *          <br>
	 *          <div class="de"> nf</div>
	 * @return the ivl ts
	 */
	public static IVL_TS createUnknownTime(NullFlavor nf) {
		final IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
		if (nf == null) {
			effectiveTime.setNullFlavor(NullFlavor.UNK);
		} else {
			effectiveTime.setNullFlavor(nf);
		}
		return effectiveTime;
	}

	/**
	 * <div class="en">Date in dd.MM.yyyy</div>
	 *
	 * @param dateSt
	 *          <br>
	 *          <div class="en"> date String</div>
	 * @return the date
	 */
	public static Date date(String dateSt) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			return sdf.parse(dateSt);
		} catch (final ParseException e) {
			// convert to RuntimeException
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * <div class="en">Date and time in dd.MM.yyyy HH:mm.</div>
	 *
	 * @param dateSt
	 *          <br>
	 *          <div class="de"> date String</div>
	 * @return the date
	 */
	public static Date dateAndTime(String dateSt) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			return sdf.parse(dateSt);
		} catch (final ParseException e) {
			// convert to RuntimeException
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * <div class="en">Format date in yyyyMMddHHmmss</div>
	 *
	 * @param date
	 *          <br>
	 *          <div class="de"> date</div>
	 * @return the string
	 */
	public static String format(Date date) {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	/**
	 * Converts Date to String yyyyMMdd.
	 *
	 * @param date
	 *          <br>
	 *          <div class="de"> date</div>
	 * @return String - yyyyMMdd formatted
	 */
	public static String formatDate(Date date) {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	/**
	 * Converts Date to String dd.MM.yyyy.
	 *
	 * @param date
	 *          <br>
	 *          <div class="de"> date</div>
	 * @return String - dd.MM.yyyy formatted
	 */
	public static String formatDateCH(Date date) {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(date);
	}

	/**
	 * Formats a data to a dd.MM.yyyy HH:mm String
	 *
	 * @param date
	 *          the date
	 * @return the dd.MM.yyyy HH:mm String
	 */
	public static String formatDateTimeCh(Date date) {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		return sdf.format(date);
	}

	/**
	 * <div class="en">Now as date.</div>
	 *
	 * @return the date
	 */
	public static Date nowAsDate() {
		return new Date();
	}

	/**
	 * <div class="en">Now as ts.</div>
	 *
	 * @return the ts
	 */
	public static TS nowAsTS() {
		return ts(new Date());
	}

	/**
	 * <div class="en">Parses the date.</div>
	 *
	 * @param timeStamp
	 *          <br>
	 *          <div class="en"> time stamp</div>
	 * @return the date
	 */
	public static Date parseDate(TS timeStamp) {
		final String value = timeStamp.getValue();
		return parseDateyyyyMMdd(value);
	}

	public static Date parseDates(String value) {
		final String[] formatStrings = { "yyyyMMddHHmmssZZZZ", "yyyyMMddHHmm", "yyyyMMdd",
				"yyyyMMddHHmm" };

		for (final String formatString : formatStrings) {
			try {
				return new SimpleDateFormat(formatString).parse(value);
			} catch (final ParseException e) {
			}
		}

		return null;
	}

	/**
	 * <div class="en">Parses the date to str.</div>
	 *
	 * @param timestamp
	 *          <br>
	 *          <div class="en">timestamp</div>
	 * @return the string
	 */
	public static String parseDateToStr(TS timestamp) {
		final Date date = parseDate(timestamp);
		return formatDateCH(date);
	}

	/**
	 * Parse date in format yyyyMMdd.
	 *
	 * @param value
	 *          <br>
	 *          <div class="de">value</div>
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
	 * Parse date in format yyyyMMddHHmm.
	 *
	 * @param value
	 *          <br>
	 *          <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmm(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMddHHmm.", e);
		}
	}

	/**
	 * Parse date in format yyyyMMddHHmmss.
	 *
	 * @param value
	 *          <br>
	 *          <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmmss(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMddHHmmss.", e);
		}
	}

	/**
	 * Parse date in format yyyyMMddHHmmZ.
	 *
	 * @param value
	 *          <br>
	 *          <div class="de"> value</div>
	 * @return java.util.Date
	 */
	public static Date parseDateyyyyMMddHHmmssZZZZ(String value) {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssZZZZ");
			return sdf.parse(value);
		} catch (final ParseException e) {
			throw new IllegalArgumentException(
					"Cannot parse date, value=[" + value + "]. Expected format is yyyyMMddHHmmssZZZZ.", e);
		}
	}

	/**
	 * Parse date in format yyyyMMddHHmmZ.
	 *
	 * @param value
	 *          <br>
	 *          <div class="de"> value</div>
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
	 * <div class="en">Parses the iv l_ tsv date time value.</div>
	 * <div class="de"></div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param effectiveTime
	 *          <br>
	 *          <div class="de"> effective time</div>
	 * @return the date
	 */
	public static Date parseIVL_TSVDateTimeValue(IVL_TS effectiveTime) {
		final String value = effectiveTime.getValue();
		return parseDates(value);
	}

	/**
	 * <div class="en">Ts.</div> <div class="de"></div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param date
	 *          <br>
	 *          <div class="de"> date</div>
	 * @return the ts
	 */
	public static TS ts(Date date) {
		final TS timestamp = DatatypesFactory.eINSTANCE.createTS();
		timestamp.setValue(DateUtil.formatDate(date));
		return timestamp;
	}

	private DateUtil() {

	}
}
