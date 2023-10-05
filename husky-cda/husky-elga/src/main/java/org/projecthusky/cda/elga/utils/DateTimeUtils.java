package org.projecthusky.cda.elga.utils;

import java.time.ZonedDateTime;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.utils.time.DateTimes;

public class DateTimeUtils {

	private DateTimeUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static IVLTS createIvlts(ZonedDateTime startDate, ZonedDateTime stopDate) {
		if (startDate == null) {
			return null;
		}

		IVLTS ivlts = new IVLTS();
		ivlts.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
				TS.class, DateTimes.toDatetimeTs(startDate)));

		if (stopDate == null) {
			TS ts = new TS(NullFlavor.UNKNOWN_L1);
			ivlts.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
					TS.class, ts));
		} else {
			ivlts.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
					TS.class, DateTimes.toDatetimeTs(stopDate)));
		}

		return ivlts;
	}

	public static IVLTS createIvltsWithNullflavor(ZonedDateTime startDate, ZonedDateTime stopDate) {
		IVLTS ivlts = new IVLTS();
		if (startDate == null) {
			TS ts = new TS(NullFlavor.UNKNOWN_L1);
			ivlts.getRest().add(new JAXBElement<>(
					new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class, ts));
		} else {
			ivlts.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDatetimeTs(startDate)));
		}

		if (stopDate == null) {
			TS ts = new TS(NullFlavor.UNKNOWN_L1);
			ivlts.getRest().add(new JAXBElement<>(
					new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), TS.class, ts));
		} else {
			ivlts.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDatetimeTs(stopDate)));
		}

		return ivlts;
	}

}
