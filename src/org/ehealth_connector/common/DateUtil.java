/********************************************************************************
*
* The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
* Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
* This code is are made available under the terms of the Eclipse Public License v1.0.
*
* Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
* Year of publication: 2015
*
********************************************************************************/

package org.ehealth_connector.common;

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
 * @author gsc, Axel Helmer
 */
public class DateUtil {

  /**
   * <div class="en">Convert date.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param date <br>
   * 		<div class="de"> date</div>
   * 		<div class="fr"> date</div>
   * 		<div class="it"> date</div>
   * @return the ivl ts
   */
  public static IVL_TS convertDate(Date date) {
    if (date == null) {
      return createUnknownTime(null);
    } else {
      IVL_TS ts = DatatypesFactory.eINSTANCE.createIVL_TS();
      ts.setValue(format(date));
      return ts;
    }
  }

  /**
   * <div class="en">Convert sxc m_ ts to eur string.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param effectiveTimes <br>
   * 		<div class="de"> effective times</div>
   * 		<div class="fr"> effective times</div>
   * 		<div class="it"> effective times</div>
   * @return the string
   */
  public static String convertSXCM_TSToEurString(List<SXCM_TS> effectiveTimes) {
    StringBuilder b = new StringBuilder();
    for (SXCM_TS effectiveTime : effectiveTimes) {
      if (effectiveTime instanceof IVL_TS) {
        IVL_TS effectiveTimeInterval = (IVL_TS) effectiveTime;
        Date tsLow = DateUtil.parseDateyyyyMMdd(effectiveTimeInterval.getLow().getValue());
        if (effectiveTimeInterval.getHigh()!=null && effectiveTimeInterval.getHigh().getValue()!=null) {
          Date tsHigh = DateUtil.parseDateyyyyMMdd(effectiveTimeInterval.getHigh().getValue());
          String tsHighStr = DateUtil.formatDateCH(tsHigh);
          String tsLowStr = DateUtil.formatDateCH(tsLow);
          b.append(tsLowStr + " - " + tsHighStr);
        }
        else {
          String tsLowStr = DateUtil.formatDateCH(tsLow);
          b.append(tsLowStr);
        }
      } else {
        if (effectiveTime instanceof TS) {
          Date ts = DateUtil.parseDateyyyyMMdd(effectiveTime.getValue());
          String tsStr = DateUtil.formatDateCH(ts);
          b.append(tsStr);
        }
        b.append(" ");
      }
    }
    return b.toString();
  }

  /**
   * Erzeugt ein IVL_TS Objekt.
   *
   * @param eurDateBegin der Begin des Intervals in dem Format dd.MM.yyyy wie er in Europa
   *        gebräuchlich ist
   * @param eurDateEnd das Ende des Intervals in dem Format dd.MM.yyyy wie er in Europa gebräuchlich
   *        ist
   * @return HL7 IVL_TS Objekt
   * @throws ParseException the parse exception
   */
  public static IVL_TS createIVL_TSFromEuroDate(Date eurDateBegin, Date eurDateEnd)
      throws ParseException {
    // Create OHT Data structure
    IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

    // Create and set Begin
    ohtInterval.setLow(createIVXB_TSFromDate(eurDateBegin));

    // Create and set End
    ohtInterval.setHigh(createIVXB_TSFromDate(eurDateEnd));
    return ohtInterval;
  }

  /**
   * Erzeugt ein IVL_TS Objekt.
   *
   * @param eurDateBegin der Begin des Intervals in dem Format dd.MM.yyyy wie er in Europa
   *        gebräuchlich ist
   * @param eurDateEnd das Ende des Intervals in dem Format dd.MM.yyyy wie er in Europa gebräuchlich
   *        ist
   * @return HL7 IVL_TS Objekt
   * @throws ParseException the parse exception
   */
  public static IVL_TS createIVL_TSFromEuroDate(String eurDateBegin, String eurDateEnd)
      throws ParseException {
    // Create OHT Data structure
    IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

    // Create and set Begin
    ohtInterval.setLow(createIVXB_TSFromEuroDate(eurDateBegin));

    // Create and set End
    ohtInterval.setHigh(createIVXB_TSFromEuroDate(eurDateEnd));

    return ohtInterval;
  }

  /**
   * Erzeugt ein IVL_TS Objekt.
   *
   * @param eurDateTime der Begin des Intervals in dem Format dd.MM.yyyy HH:mm wie er in Europa
   *        gebräuchlich ist
   * @return HL7 IVL_TS Objekt
   * @throws ParseException the parse exception
   */
  public static IVL_TS createIVL_TSFromEuroDateTime(Date eurDateTime)
      throws ParseException {
    // Create OHT Data structure
    IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

    final DateFormat cdaDateFormatter = new SimpleDateFormat("yyyyMMddHHmmZ");
    // Create and set Begin
    ohtInterval.setValue(cdaDateFormatter.format(eurDateTime));

    return ohtInterval;
  }
  
  /**
   * Erzeugt ein IVL_TS Objekt.
   *
   * @param eurDateTime der Begin des Intervals in dem Format dd.MM.yyyy wie er in Europa
   *        gebräuchlich ist
   * @return HL7 IVL_TS Objekt
   * @throws ParseException the parse exception
   */
  public static IVL_TS createIVL_TSFromEuroDate(Date eurDateTime)
      throws ParseException {
    // Create OHT Data structure
    IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

    final DateFormat cdaDateFormatter = new SimpleDateFormat("yyyyMMdd");
    // Create and set Begin
    ohtInterval.setValue(cdaDateFormatter.format(eurDateTime));

    return ohtInterval;
  }

  /**
   * Erzeugt ein IVXB_TS Objekt.
   *
   * @param date <br>
   * 		<div class="de"> date</div>
   * 		<div class="fr"> date</div>
   * 		<div class="it"> date</div>
   * @return HL7 IVXB_TS Objekt
   * @throws ParseException the parse exception
   */
  public static IVXB_TS createIVXB_TSFromDate(Date date) throws ParseException {
    // Create IVXB_TS
    IVXB_TS ohtIntervalPoint = DatatypesFactory.eINSTANCE.createIVXB_TS();
    if (date == null) {
      ohtIntervalPoint.setNullFlavor(NullFlavor.UNK);
    }
    else {
      ohtIntervalPoint.setValue(DateUtil.formatDate(date));
    }
    return ohtIntervalPoint;
  }

  /**
   * Erzeugt ein IVXB_TS Objekt.
   *
   * @param eurDateStr ein Date String in dem Format dd.MM.yyyy wie er in Europa gebräuchlich ist
   * @return HL7 IVXB_TS Objekt
   * @throws ParseException the parse exception
   */
  public static IVXB_TS createIVXB_TSFromEuroDate(String eurDateStr) throws ParseException {
    IVXB_TS ohtIntervalPoint = DatatypesFactory.eINSTANCE.createIVXB_TS();
    if (eurDateStr == null) {
      ohtIntervalPoint.setNullFlavor(NullFlavor.UNK);
    }
    else {
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
   * <div class="en">Creates the stc m_ ts.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param startOfPossibleAppliacne <br>
   * 		<div class="de"> start of possible appliacne</div>
   * 		<div class="fr"> start of possible appliacne</div>
   * 		<div class="it"> start of possible appliacne</div>
   * @param endOfPossibleAppliance <br>
   * 		<div class="de"> end of possible appliance</div>
   * 		<div class="fr"> end of possible appliance</div>
   * 		<div class="it"> end of possible appliance</div>
   * @return the sxcm ts
   */
  public static SXCM_TS createSTCM_TS(Date startOfPossibleAppliacne, Date endOfPossibleAppliance) {
    // sxcm_ts = DatatypesFactory.eINSTANCE.createSXCM_TS();
    try {
      IVL_TS ivl_ts;
      ivl_ts = createIVL_TSFromEuroDate(startOfPossibleAppliacne, endOfPossibleAppliance);
      SXCM_TS sxcm_ts = ivl_ts;
      return sxcm_ts;
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Erzeugt ein TS Objekt.
   *
   * @param eurDate <br>
   * 		<div class="de"> eur date</div>
   * 		<div class="fr"> eur date</div>
   * 		<div class="it"> eur date</div>
   * @return HL7 TS Objekt
   * @throws ParseException the parse exception
   */
  public static TS createTSFromEuroDate(Date eurDate) throws ParseException {
    final DateFormat ohtDateFormatter = new SimpleDateFormat("yyyyMMdd");

    final String ohtDateStr = ohtDateFormatter.format(eurDate);

    final TS ohtDate = DatatypesFactory.eINSTANCE.createTS(ohtDateStr);
    return ohtDate;
  }

  /**
   * Erzeugt ein TS Objekt.
   *
   * @param eurDateStr ein Date String in dem Format dd.MM.yyyy wie er in Europa gebräuchlich ist
   * @return HL7 TS Objekt
   * @throws ParseException the parse exception
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
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the ivl ts
   */
  public static IVL_TS createUnknownLowHighTimeNullFlavor() {
    IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
    effectiveTime.setLow(Util.createNullFlavorUnknown());
    effectiveTime.setHigh(Util.createNullFlavorUnknown());
    return effectiveTime;
  }

  /**
   * <div class="en">Creates the unknown time.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param nf <br>
   * 		<div class="de"> nf</div>
   * 		<div class="fr"> nf</div>
   * 		<div class="it"> nf</div>
   * @return the ivl ts
   */
  public static IVL_TS createUnknownTime(NullFlavor nf) {
    IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
    if (nf==null) {
      effectiveTime.setNullFlavor(NullFlavor.UNK);
    }
    else {
      effectiveTime.setNullFlavor(nf);
    }
    return effectiveTime;
  }

  /**
   * <div class="en">Date.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param dateSt <br>
   * 		<div class="de"> date st</div>
   * 		<div class="fr"> date st</div>
   * 		<div class="it"> date st</div>
   * @return the date
   */
  public static Date date(String dateSt) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
      return sdf.parse(dateSt);
    } catch (ParseException e) {
      // convert to RuntimeException
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * <div class="en">Date and time.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param dateSt <br>
   * 		<div class="de"> date st</div>
   * 		<div class="fr"> date st</div>
   * 		<div class="it"> date st</div>
   * @return the date
   */
  public static Date dateAndTime(String dateSt) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
      return sdf.parse(dateSt);
    } catch (ParseException e) {
      // convert to RuntimeException
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * <div class="en">Format.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param date <br>
   * 		<div class="de"> date</div>
   * 		<div class="fr"> date</div>
   * 		<div class="it"> date</div>
   * @return the string
   */
  public static String format(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    return sdf.format(date);
  }

  /**
   * Converts Date to String.
   *
   * @param date <br>
   * 		<div class="de"> date</div>
   * 		<div class="fr"> date</div>
   * 		<div class="it"> date</div>
   * @return String - yyyyMMdd formatted
   */
  public static String formatDate(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    return sdf.format(date);
  }

  /**
   * Converts Date to String.
   *
   * @param date <br>
   * 		<div class="de"> date</div>
   * 		<div class="fr"> date</div>
   * 		<div class="it"> date</div>
   * @return String - dd.MM.yyyy formatted
   */
  public static String formatDateCH(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    return sdf.format(date);
  }

  public static String formatDateTimeCh(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    return sdf.format(date);
  }

  /**
   * <div class="en">Now as date.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the date
   */
  public static Date nowAsDate() {
    return new Date();
  }

  /**
   * <div class="en">Now as ts.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the ts
   */
  public static TS nowAsTS() {
    return ts(new Date());
  }

  /**
   * <div class="en">Parses the date.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param timeStamp <br>
   * 		<div class="de"> time stamp</div>
   * 		<div class="fr"> time stamp</div>
   * 		<div class="it"> time stamp</div>
   * @return the date
   */
  public static Date parseDate(TS timeStamp) {
    String value = timeStamp.getValue();
    return parseDateyyyyMMdd(value);
  }

  /**
   * <div class="en">Parses the date to str.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param timestamp <br>
   * 		<div class="de"> timestamp</div>
   * 		<div class="fr"> timestamp</div>
   * 		<div class="it"> timestamp</div>
   * @return the string
   */
  public static String parseDateToStr(TS timestamp) {
    Date date = parseDate(timestamp);
    return formatDateCH(date);
  }

  /**
   * Parse date in format yyyyMMdd.
   *
   * @param value <br>
   * 		<div class="de"> value</div>
   * 		<div class="fr"> value</div>
   * 		<div class="it"> value</div>
   * @return java.util.Date
   */
  public static Date parseDateyyyyMMdd(String value) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      return sdf.parse(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Cannot parse date, value=[" + value
          + "]. Expected format is yyyyMMdd.", e);
    }
  }

  /**
   * Parse date in format yyyyMMddHHmm.
   *
   * @param value <br>
   * 		<div class="de"> value</div>
   * 		<div class="fr"> value</div>
   * 		<div class="it"> value</div>
   * @return java.util.Date
   */
  public static Date parseDateyyyyMMddHHmm(String value) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
      return sdf.parse(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Cannot parse date, value=[" + value
          + "]. Expected format is yyyyMMdd.", e);
    }
  }

  /**
   * Parse date in format yyyyMMddHHmmZ.
   *
   * @param value <br>
   * 		<div class="de"> value</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @return java.util.Date
   */
  public static Date parseDateyyyyMMddHHmmZ(String value) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmZ");
      return sdf.parse(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Cannot parse date, value=[" + value
          + "]. Expected format is yyyyMMdd.", e);
    }
  }

  /**
   * <div class="en">Parses the iv l_ tsv date time value.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param effectiveTime <br>
   * 		<div class="de"> effective time</div>
   * 		<div class="fr"> effective time</div>
   * 		<div class="it"> effective time</div>
   * @return the date
   */
  public static Date parseIVL_TSVDateTimeValue(IVL_TS effectiveTime) {
    String value = effectiveTime.getValue();
    return parseDateyyyyMMddHHmmZ(value);
  }

  /**
   * <div class="en">Ts.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param date <br>
   * 		<div class="de"> date</div>
   * 		<div class="fr"> date</div>
   * 		<div class="it"> date</div>
   * @return the ts
   */
  public static TS ts(Date date) {
    TS timestamp = DatatypesFactory.eINSTANCE.createTS();
    timestamp.setValue(DateUtil.formatDate(date));
    return timestamp;
  }
}
