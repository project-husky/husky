package org.ehealth_connector.common.utils;

import org.apache.commons.lang3.RegExUtils;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Address;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Name;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Telecom;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XcnName;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XpnName;
import org.openhealthtools.ihe.common.hl7v2.XPN;
import org.openhealthtools.ihe.common.hl7v2.format.HL7V2MessageFormat;
import org.openhealthtools.ihe.common.hl7v2.format.MessageDelimiters;

public class Hl7Util {

	/**
	 * Default constructor.
	 */
	private Hl7Util() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * extracts {@link Identifier} from passed {@link String} value. Value is Hl7v2
	 * CX format. This looks like {ID}^^^&amp;{OID}&amp;ISO
	 *
	 * @param value Hl7v2 CX formatted ID
	 *
	 * @return extracted {@link Identifier}
	 */
	public static Identifiable extractHl7Cx(String value) {
		var patientId = HL7V2MessageFormat.buildCXFromMessageString(value, MessageDelimiters.COMPONENT,
				MessageDelimiters.SUBCOMPONENT);
		patientId.setAssigningAuthorityUniversalId(
				RegExUtils.replaceAll(patientId.getAssigningAuthorityUniversalId(), "&amp;|amp;", ""));
		var id = new Identifiable();
		id.setId(patientId.getIdNumber());
		var assignAuth = new AssigningAuthority();
		assignAuth.setUniversalId(patientId.getAssigningAuthorityUniversalId());
		id.setAssigningAuthority(assignAuth);
		return id;
	}

	public static Organization extractHl7Xon(String value) {
		var intendedOrganization = HL7V2MessageFormat.buildXONFromMessageString(value, MessageDelimiters.COMPONENT,
				MessageDelimiters.SUBCOMPONENT);

		var org = new Organization();
		org.setOrganizationName(intendedOrganization.getOrganizationName());
		org.setIdNumber(intendedOrganization.getIdNumber());
		var assigningAuth = new AssigningAuthority();
		assigningAuth.setUniversalId(intendedOrganization.getAssigningAuthorityUniversalId());
		org.setAssigningAuthority(assigningAuth);

		return org;
	}

	public static Person extractHl7Xcn(String value) {
		var intendedPerson = HL7V2MessageFormat.buildXCNFromMessageString(value, MessageDelimiters.COMPONENT,
				MessageDelimiters.SUBCOMPONENT);
		var pers = new Person();
		var name = new XcnName(intendedPerson.getFamilyName(), intendedPerson.getGivenName(),
				intendedPerson.getOtherName(), intendedPerson.getSuffix(), intendedPerson.getPrefix(), null);
		pers.setName(name);
		var id = new Identifiable(intendedPerson.getIdNumber(),
				new AssigningAuthority(intendedPerson.getAssigningAuthorityUniversalId()));
		pers.setId(id);
		return pers;
	}

	public static XpnName extractHl7Xpn(String value) {
		XPN xpn = HL7V2MessageFormat.buildXPNFromMessageString(value, MessageDelimiters.COMPONENT);

		XpnName name = new XpnName();
		name.setFamilyName(xpn.getFamilyName());
		name.setGivenName(xpn.getGivenName());
		name.setPrefix(xpn.getPrefix());
		name.setSuffix(xpn.getSuffix());
		name.setSecondAndFurtherGivenNames(xpn.getOtherName());

		return name;
	}

	public static Address extractHl7Xad(String value) {
		var xad = HL7V2MessageFormat.buildXADFromMessageString(value,
				MessageDelimiters.COMPONENT);
		var address = new Address();

		address.setCity(xad.getCity());
		address.setCountry(xad.getCountry());
		address.setStateOrProvince(xad.getStateOrProvince());
		address.setStreetAddress(xad.getStreetAddress());
		address.setZipOrPostalCode(xad.getZipOrPostalCode());

		return address;

	}

	public static Telecom extractHl7Xtn(String value) {
		var intendedPersonTel = HL7V2MessageFormat.buildXTNFromMessageString(value, MessageDelimiters.COMPONENT);
		var telecom = new Telecom();

		if (intendedPersonTel.getTelecommunicationAddress() != null
				&& intendedPersonTel.getTelecommunicationAddress().contains("tel")) {
			telecom.setUnformattedPhoneNumber(intendedPersonTel.getTelecommunicationAddress());
		} else if (intendedPersonTel.getTelecommunicationAddress() != null
				&& intendedPersonTel.getTelecommunicationAddress().contains("mail")) {
			telecom.setEmail(intendedPersonTel.getTelecommunicationAddress());
		}

		telecom.setUse(intendedPersonTel.getTelecommunicationType());
		return telecom;
	}

	public static String generateXon(Organization xon, char componentSeparator, char subComponentSeparator) {
		final var result = new StringBuilder();
		if (xon == null) {
			return result.toString();
		}
		// XON.1
		if (xon.getOrganizationName() != null) {
			result.append(xon.getOrganizationName());
		}
		// IHE 2009 ITI CP 316
		result.append(componentSeparator);
		// XON.2 - not present
		result.append(componentSeparator);
		// XON.3 - not present
		result.append(componentSeparator);
		// XON.4 - not present
		result.append(componentSeparator);
		// XON.5 - not present
		result.append(componentSeparator);
		// XON.6.1
		result.append(subComponentSeparator);
		// XON.6.2
		if (xon.getAssigningAuthority() != null && xon.getAssigningAuthority().getUniversalId() != null) {
			result.append(xon.getAssigningAuthority().getUniversalId());
		}
		result.append(subComponentSeparator);
		// XON.6.3
		if (xon.getAssigningAuthority() != null && xon.getAssigningAuthority().getUniversalIdType() != null) {
			result.append(xon.getAssigningAuthority().getUniversalIdType());
		}
		result.append(componentSeparator);
		// XON.7 - not present
		result.append(componentSeparator);
		// XON.8 - not present
		result.append(componentSeparator);
		// XON.9 - not present
		result.append(componentSeparator);
		// XON.10
		if (xon.getIdNumber() != null) {
			result.append(xon.getIdNumber());
		}

		trimDelimiters(result, componentSeparator, subComponentSeparator);
		return result.toString();
	}

	/**
	 * Converts a model instance of the CX type to a HL7v2.5 standard delimited
	 * string.
	 *
	 * @param cx                    instance of the CX model
	 * @param componentSeparator    component level separator for message
	 * @param subComponentSeparator component level separato for message
	 * @return the delimited String
	 */
	public static String generateFromCx(Person cx, char componentSeparator, char subComponentSeparator) {
		return generateFromCx(cx.getId(), componentSeparator, subComponentSeparator);
	}

	/**
	 * Converts a model instance of the CX type to a HL7v2.5 standard delimited
	 * string.
	 *
	 * @param cx                    instance of the CX model
	 * @param componentSeparator    component level separator for message
	 * @param subComponentSeparator component level separato for message
	 * @return the delimited String
	 */
	public static String generateFromCx(Identifiable cx, char componentSeparator, char subComponentSeparator) {
		final var result = new StringBuilder("");
		if (cx == null) {
			return result.toString();
		}
		// CX.1
		if (cx.getId() != null) {
			result.append(cx.getId());
		}
		result.append(componentSeparator);
		// CX.2 - not present
		result.append(componentSeparator);
		// CX.3 - not present
		result.append(componentSeparator);

		// CX.4.1 - Use of this subcomponent is prohibited in XDS, not other profiles
		result.append(subComponentSeparator);
		// CX.4.2
		if (cx.getAssigningAuthority() != null && cx.getAssigningAuthority().getUniversalId() != null) {
			result.append(cx.getAssigningAuthority().getUniversalId());
		}
		result.append(subComponentSeparator);
		// CX.4.3
		if (cx.getAssigningAuthority() != null && cx.getAssigningAuthority().getUniversalIdType() != null) {
			result.append(cx.getAssigningAuthority().getUniversalIdType());
		}

		trimDelimiters(result, componentSeparator, subComponentSeparator);
		return result.toString();
	}

	/**
	 * Converts a model instance of the XTN type to a HL7v2.5 standard delimited
	 * string.
	 *
	 * @param xtn                instance of the XTN model
	 * @param componentSeparator component level separator for message
	 * @return the delimited String
	 */
	public static String generateXtn(Telecom xtn, char componentSeparator) {
		final var result = new StringBuilder("");
		if (xtn == null) {
			return result.toString();
		}
		if (xtn.getType() == null) {
			return result.toString();
		}
		// XTN.1- not present
		result.append(componentSeparator);
		// XTN.2 - not present
		if (xtn.getUse() != null) {
			result.append(xtn.getUse());
		}
		result.append(componentSeparator);

		// ADDED for CP 524, 627 and 628 for IHE ITI TF v9 (2012-2013)
		// XTN.3 - telecommunication type
		if (xtn.getType() != null) {
			result.append(xtn.getType());
			result.append(componentSeparator);
		} else {
			result.append(componentSeparator);
		}
		// XTN.4 - telecommunication address
		if (xtn.getEmail() != null) {
			result.append(xtn.getEmail());
		}
		result.append(componentSeparator);

		// XTN.5 - country code of phone number
		if (xtn.getCountryCode() != null) {
			result.append(xtn.getCountryCode());
		}
		result.append(componentSeparator);

		// XTN.6 - area code of phone number
		if (xtn.getAreaCityCode() != null) {
			result.append(xtn.getAreaCityCode());
		}
		result.append(componentSeparator);

		// XTN.7 - local part of phone number
		if (xtn.getLocalNumber() != null) {
			result.append(xtn.getLocalNumber());
		}
		result.append(componentSeparator);

		// XTN.8 - extension of phone number
		if (xtn.getExtension() != null) {
			result.append(xtn.getExtension());
		}
		result.append(componentSeparator);

		// XTN.9 - not present
		result.append(componentSeparator);

		// XTN.10 - not present
		result.append(componentSeparator);

		// XTN.11 - not present
		result.append(componentSeparator);

		// XTN.12 - unformatted phone number
		if (xtn.getUnformattedPhoneNumber() != null) {
			result.append(xtn.getUnformattedPhoneNumber());
		}

		return result.toString();
	}

	/**
	 * Converts a model instance of the XAD type to a HL7v2.5 standard delimited
	 * string.
	 *
	 * @param xad                   instance of the XAD model
	 * @param componentSeparator    component level separator for message
	 * @param subComponentSeparator component level separato for message
	 * @return the delimited String
	 */
	public static String generateXad(Address xad, char componentSeparator) {
		final var result = new StringBuilder("");
		if (xad == null) {
			return result.toString();
		}
		// XAD.1.1
		if (xad.getStreetAddress() != null) {
			result.append(xad.getStreetAddress());
		}
		result.append(componentSeparator);
		// XAD.2
		if (xad.getOtherDesignation() != null) {
			result.append(xad.getOtherDesignation());
		}
		result.append(componentSeparator);
		// XAD.3
		if (xad.getCity() != null) {
			result.append(xad.getCity());
		}
		result.append(componentSeparator);
		// XAD.4
		if (xad.getStateOrProvince() != null) {
			result.append(xad.getStateOrProvince());
		}
		result.append(componentSeparator);
		// XAD.5 - not present
		if (xad.getZipOrPostalCode() != null) {
			result.append(xad.getZipOrPostalCode());
		}
		result.append(componentSeparator);
		// XAD.6
		if (xad.getCountry() != null) {
			result.append(xad.getCountry());
		}
		result.append(componentSeparator);
		// XAD.7 - not present
		result.append(componentSeparator);
		// XAD.8 - not present
		result.append(componentSeparator);
		// XAD.9
		if (xad.getCountyParishCode() != null) {
			result.append(xad.getCountyParishCode());
		}
		result.append(componentSeparator);

		trimDelimiters(result, componentSeparator);
		return result.toString();
	}

	/**
	 * Converts a model instance of the XPN type to a HL7v2.5 standard delimited
	 * string.
	 *
	 * @param xpn                   instance of the XPN model
	 * @param componentSeparator    component level separator for message
	 * @param subComponentSeparator component level separato for message
	 * @return the delimited String
	 */
	public static String generateXpn(Name<?> xpn, char componentSeparator) {
		final var result = new StringBuilder("");
		if (xpn == null) {
			return result.toString();
		}
		// XPN.1.1
		if (xpn.getFamilyName() != null) {
			result.append(xpn.getFamilyName());
		}
		result.append(componentSeparator);
		// XPN.2
		if (xpn.getGivenName() != null) {
			result.append(xpn.getGivenName());
		}
		result.append(componentSeparator);
		// XPN.3
		if (xpn.getSecondAndFurtherGivenNames() != null) {
			result.append(xpn.getSecondAndFurtherGivenNames());
		}
		result.append(componentSeparator);
		// XPN.4
		if (xpn.getSuffix() != null) {
			result.append(xpn.getSuffix());
		}
		result.append(componentSeparator);
		// XPN.5
		if (xpn.getPrefix() != null) {
			result.append(xpn.getPrefix());
		}
		result.append(componentSeparator);

		trimDelimiters(result, componentSeparator);
		return result.toString();
	}

	/**
	 * Trims trailing delimiters and sub delimiters from the message string
	 *
	 * @param msg
	 * @param delimiter
	 * @param subdelimiter
	 */
	public static void trimDelimiters(StringBuilder msg, char delimiter, char subdelimiter) {
		int count = msg.length() - 1;
		while ((msg.charAt(count) == delimiter) || (msg.charAt(count) == subdelimiter)) {
			msg.deleteCharAt(count);
			count--;
			if (count < 0)
				break;
		}
	}

	/**
	 * Trims trailing delimiters from the message string
	 *
	 * @param msg
	 * @param delimiter
	 */
	public static void trimDelimiters(StringBuilder msg, char delimiter) {
		int count = msg.length() - 1;
		while (msg.charAt(count) == delimiter) {
			msg.deleteCharAt(count);
			count--;
			if (count < 0)
				break;
		}
	}

}
