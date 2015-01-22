package org.ehc.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Utility for date handling.
 * 
 * @author gsc
 */
public class DateUtil {

  public static IVL_TS convertDate(Date date) {
    if (date == null) {
      return createUnknownTime();
    } else {
      IVL_TS ts = DatatypesFactory.eINSTANCE.createIVL_TS();
      ts.setValue(format(date));
      return ts;
    }
  }

  public static String convertSXCM_TSToEurString(List<SXCM_TS> effectiveTimes) {
    StringBuilder b = new StringBuilder();
    for (SXCM_TS effectiveTime : effectiveTimes) {
      if (effectiveTime instanceof IVL_TS) {
        IVL_TS effectiveTimeInterval = (IVL_TS) effectiveTime;
        Date tsLow = DateUtil.parseDate(effectiveTimeInterval.getLow().getValue());
        Date tsHigh = DateUtil.parseDate(effectiveTimeInterval.getHigh().getValue());
        String tsLowStr = DateUtil.formatDateCH(tsLow);
        String tsHighStr = DateUtil.formatDateCH(tsHigh);
        b.append(tsLowStr + " - " + tsHighStr);
      } else {
        if (effectiveTime instanceof TS) {
          Date ts = DateUtil.parseDate(effectiveTime.getValue());
          String tsStr = DateUtil.formatDateCH(ts);
          b.append(tsStr);
        }
        b.append(" ");
      }
    }
    return b.toString();
  }

  public static IVL_PQ createIVL_PQNullFlavorNASK() {
    IVL_PQ ivlpq = DatatypesFactory.eINSTANCE.createIVL_PQ();
    ivlpq.setNullFlavor(NullFlavor.NASK);
    return ivlpq;
  }

  /**
   * Erzeugt ein IVL_TS Objekt
   * 
   * @param eurDateBegin der Begin des Intervals in dem Format dd.MM.yyyy wie er in Europa
   *        gebräuchlich ist
   * @param eurDateEnd das Ende des Intervals in dem Format dd.MM.yyyy wie er in Europa gebräuchlich
   *        ist
   * @return HL7 IVL_TS Objekt
   * @throws ParseException
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
   * Erzeugt ein IVL_TS Objekt
   * 
   * @param eurDateBegin der Begin des Intervals in dem Format dd.MM.yyyy wie er in Europa
   *        gebräuchlich ist
   * @param eurDateEnd das Ende des Intervals in dem Format dd.MM.yyyy wie er in Europa gebräuchlich
   *        ist
   * @return HL7 IVL_TS Objekt
   * @throws ParseException
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
   * Erzeugt ein IVXB_TS Objekt
   * 
   * @param eurDateStr ein Date String in dem Format dd.MM.yyyy wie er in Europa gebräuchlich ist
   * @return HL7 IVXB_TS Objekt
   * @throws ParseException
   */
  public static IVXB_TS createIVXB_TSFromDate(Date date) throws ParseException {
    // Create IVXB_TS
    IVXB_TS ohtIntervalPoint = DatatypesFactory.eINSTANCE.createIVXB_TS();
    ohtIntervalPoint.setValue(DateUtil.formatDate(date));

    return ohtIntervalPoint;
  }

  /**
   * Erzeugt ein IVXB_TS Objekt
   * 
   * @param eurDateStr ein Date String in dem Format dd.MM.yyyy wie er in Europa gebräuchlich ist
   * @return HL7 IVXB_TS Objekt
   * @throws ParseException
   */
  public static IVXB_TS createIVXB_TSFromEuroDate(String eurDateStr) throws ParseException {
    final DateFormat eurDateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    final DateFormat ohtDateFormatter = new SimpleDateFormat("yyyyMMdd");

    // Parse date
    final Date date = eurDateFormatter.parse(eurDateStr);
    final String ohtDate = ohtDateFormatter.format(date);

    // Create IVXB_TS
    IVXB_TS ohtIntervalPoint = DatatypesFactory.eINSTANCE.createIVXB_TS();
    ohtIntervalPoint.setValue(ohtDate);

    return ohtIntervalPoint;
  }

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
   * Erzeugt ein TS Objekt
   * 
   * @param eurDateStr ein Date String in dem Format dd.MM.yyyy wie er in Europa gebräuchlich ist
   * @return HL7 TS Objekt
   * @throws ParseException
   */
  public static TS createTSFromEuroDate(String eurDateStr) throws ParseException {
    final DateFormat eurDateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    final DateFormat ohtDateFormatter = new SimpleDateFormat("yyyyMMdd");

    final Date eurDate = eurDateFormatter.parse(eurDateStr);
    final String ohtDateStr = ohtDateFormatter.format(eurDate);

    final TS ohtDate = DatatypesFactory.eINSTANCE.createTS(ohtDateStr);
    return ohtDate;
  }

  public static IVL_TS createUnknownLowHighTimeNullFlavor() {
    IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
    effectiveTime.setLow(Util.createNullFlavorUnknown());
    effectiveTime.setHigh(Util.createNullFlavorUnknown());
    return effectiveTime;
  }

  public static IVL_TS createUnknownTime() {
    IVXB_TS ts_unknown = DatatypesFactory.eINSTANCE.createIVXB_TS();

    IVL_TS effectiveTime = DatatypesFactory.eINSTANCE.createIVL_TS();
    effectiveTime.setLow(ts_unknown);

    return effectiveTime;
  }

  public static String format(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    return sdf.format(date);
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

  public static TS nowAsTS() {
    return ts(new Date());
  }

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
      throw new IllegalArgumentException("Cannot parse date, value=[" + value
          + "]. Expected format is yyyyMMdd.", e);
    }
  }

  public static Date parseDate(TS timeStamp) {
    String value = timeStamp.getValue();
    return parseDate(value);
  }

  public static TS ts(Date date) {
    TS timestamp = DatatypesFactory.eINSTANCE.createTS();
    timestamp.setValue(DateUtil.formatDate(date));
    return timestamp;
  }

  private DateUtil() {}

}
