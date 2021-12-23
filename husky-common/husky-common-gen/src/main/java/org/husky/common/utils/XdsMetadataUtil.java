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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.basetypes.OrganizationBaseType;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.enums.TelecomAddressUse;
import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.common.model.Address;
import org.husky.common.model.Author;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Organization;
import org.husky.common.model.Patient;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.PatientInfo;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Telecom;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XpnName;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class XdsUtil provides helper methods for the IHE XDS Context.
 */
public class XdsMetadataUtil {

	/** The SLF4J logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(XdsMetadataUtil.class);

	public static final String DTM_FMT_Y = "yyyy";
	public static final String DTM_FMT_YM = "yyyyMM";
	public static final String DTM_FMT_YMD = "yyyyMMdd";
	public static final String DTM_FMT_YMDH = "yyyyMMddHH";
	public static final String DTM_FMT_YMDHM = "yyyyMMddHHmm";

	public static final String DTM_FMT_YMDHMS = "yyyyMMddHHmmss";

	protected static final String[] DTM_FMT = { DTM_FMT_YMDHMS, DTM_FMT_YMDHM, DTM_FMT_YMDH, DTM_FMT_YMD, DTM_FMT_YM,
			DTM_FMT_Y };

	private XdsMetadataUtil() {

	}

	/**
	 * Method to convert a Date object to an DTM formatted string using the format
	 * yyyyMMddHHmmss.
	 *
	 * @param dateTime the date to be formatted to a string
	 * @return the string representing the date object
	 */
	public static String convertDateToDtmString(Date dateTime) {
		String retVal = null;
		if (dateTime != null) {
			final var sdf = new SimpleDateFormat(DTM_FMT_YMDHMS);
			retVal = sdf.format(dateTime);
		}
		return retVal;
	}

	/**
	 * Method to convert the DTM string to a Date object. The String will be parsed
	 * using the formats int the following definition and order: yyyyMMddHHmmss
	 * yyyyMMddHHmm yyyyMMddHH yyyyMMdd yyyyMM yyyy";
	 *
	 * @param dateTimeString the string with DTM format
	 * @return the representing Date object
	 */
	public static Date convertDtmStringToDate(String dateTimeString) {
		Date retVal = null;
		if ((dateTimeString != null) && !"".equals(dateTimeString)) {
			final var sdf = new SimpleDateFormat();

			var count = 0;
			while ((retVal == null) && (count < DTM_FMT.length)) {
				sdf.applyPattern(DTM_FMT[count]);
				try {
					retVal = sdf.parse(dateTimeString);
				} catch (final ParseException e) {
					LOGGER.info("Date {} could not be parsed", dateTimeString);
				}
				++count;
			}
		}

		return retVal;
	}

	/**
	 * Converts eHC Code to IPF Code.
	 *
	 * @param code the code
	 * @return the code
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code convertEhcCodeToCode(Code code) {
		return createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName());
	}

	/**
	 * Converts eHC Code to IPF Code.
	 *
	 * @param code the code
	 * @return the code
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code convertEhcCodeToCode(
			ValueSetEnumInterface code) {
		return createCodedMetadata(code.getCodeSystemId(), code.getCodeValue(), code.getDisplayName());
	}

	/**
	 * Converts eHC Code and a given language to IPF Code.
	 *
	 * @param code     the code
	 * @param language the language
	 * @return the code
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code convertEhcCodeToIpfCode(Code code,
			String language) {
		var retVal = createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName());
		retVal.getDisplayName().setLang(language);
		return retVal;
	}

	/**
	 * Converts a list of eHC Code to a list of IPF Code.
	 *
	 * @param codeList the list of Code
	 * @return the list of IPF Code
	 */
	public static List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> convertEhcCodeToCode(
			List<Code> codeList) {
		if (codeList == null)
			return new LinkedList<>();
		else {
			final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> cmtArray = new LinkedList<>();

			for (final Code cme : codeList) {
				cmtArray.add(XdsMetadataUtil.convertEhcCodeToCode(cme));
			}

			return cmtArray;
		}
	}

	/**
	 * Converts a list of eHC Code to a list of IPF Code.
	 *
	 * @param codeList the list of Code
	 * @return the list of IPF Code
	 */
	public static List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> convertEhcCodeToCode(
			ValueSetEnumInterface[] codeList) {
		if (codeList == null)
			return new LinkedList<>();
		else {
			final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> cmtArray = new LinkedList<>();

			for (final ValueSetEnumInterface cme : codeList) {
				cmtArray.add(XdsMetadataUtil.convertEhcCodeToCode(cme));
			}

			return cmtArray;
		}
	}

	/**
	 * Converts a list of eHC Code to a list of IPF Code.
	 *
	 * @param codeList the list of Code
	 * @return the list of IPF Code
	 */
	public static QueryList<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> convertEhcCodeToQueryListCode(
			List<Code> codeList) {
		if (codeList == null)
			return null;
		else {
			final QueryList<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> cmtArray = new QueryList<>();

			for (final Code cme : codeList) {
				cmtArray.getOuterList().add(List.of(XdsMetadataUtil.convertEhcCodeToCode(cme)));
			}

			return cmtArray;
		}
	}

	/**
	 * Converts a list of eHC Code to a list of IPF Code.
	 *
	 * @param codeList the list of Code
	 * @return the list of IPF Code
	 */
	public static QueryList<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> convertEhcCodeToQueryListCode(
			ValueSetEnumInterface[] codeList) {
		if (codeList == null)
			return null;
		else {
			final QueryList<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> cmtArray = new QueryList<>();

			for (final ValueSetEnumInterface cme : codeList) {
				cmtArray.getOuterList().add(List.of(XdsMetadataUtil.convertEhcCodeToCode(cme)));
			}

			return cmtArray;
		}
	}

	/**
	 * Convert identificator to IPF Identifiable
	 *
	 * @param id id
	 * @return the Identifiable
	 */
	public static Identifiable convertEhcIdentificator(Identificator id) {
		if (id == null)
			return null;

		return new Identifiable(id.getExtension(), new AssigningAuthority(id.getRoot()));
	}

	/**
	 * Converts an IPF Organization to husky Organization
	 *
	 * @param at the husky Organization
	 * @return the husky Organization
	 */
	public static Organization convertIpfOrganization(
			org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization xon) {
		if (xon == null) {
			return null;
		}

		final var org = new OrganizationBaseType();
		org.addIdentificator(convertOhtXcnIdToEhc(xon.getAssigningAuthority(), xon.getIdNumber()));
		org.addName(new Name(xon.getOrganizationName()));

		return new Organization(org);
	}

	/**
	 * Converts an OHT InternationalStringType to String
	 *
	 * @param ist the InternationalStringType
	 * @return the String
	 */
	public static String convertInternationalStringType(LocalizedString ist) {
		if (ist != null) {
			return ist.getValue();
		}
		return null;
	}

	/**
	 * Converts an IPF Author to eHC Author
	 *
	 * @param at the IPF Author
	 * @return the eHC Author
	 */
	public static Author convertIpfAuthor(org.openehealth.ipf.commons.ihe.xds.core.metadata.Author at) {
		final var a = new Author();

		// Author Person
		Person ap = null;
		if (at != null) {
			if (at.getAuthorPerson() != null) {
				ap = at.getAuthorPerson();
				// Id
				a.addId(convertIpfIdentifiableToEhc(ap.getId()));
				// Name
				a.addName(new Name(ap.getName()));
			}

			// Institution
			if (!at.getAuthorInstitution().isEmpty()) {
				for (org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization xon : at.getAuthorInstitution()) {
					a.setOrganization(convertIpfOrganization(xon));
				}
			}

			// Role
			if (!at.getAuthorRole().isEmpty() && at.getAuthorRole().get(0) != null) {
				var codeSystem = "";

				if (at.getAuthorRole().get(0).getAssigningAuthority() != null) {
					codeSystem = at.getAuthorRole().get(0).getAssigningAuthority().getUniversalId();
				}

				a.setRoleFunction(new Code(at.getAuthorRole().get(0).getId(), codeSystem, null));
			}

			// Speciality
			if (!at.getAuthorSpecialty().isEmpty()
					&& at.getAuthorSpecialty().get(0) != null) {
				a.setSpeciality(new Code(at.getAuthorSpecialty().get(0).getId(),
						at.getAuthorSpecialty().get(0).getAssigningAuthority().getUniversalId(), null));
			}

			// Telecoms
			if (!at.getAuthorTelecom().isEmpty()) {
				a.setTelecoms(convertIpfTelecoms(at.getAuthorTelecom()));
			}
		}

		return a;
	}

	public static List<org.husky.common.model.Telecom> convertIpfTelecoms(List<Telecom> xtnList) {
		final List<org.husky.common.model.Telecom> t = new LinkedList<>();

		for (Telecom xtn : xtnList) {
			if (xtn != null && xtn.getType() != null) {
				var telecom = new org.husky.common.model.Telecom();

				var number = extractPhoneNumber(xtn);

				if ("FX".equalsIgnoreCase(xtn.getType())) {
					telecom.setFax(number);
				} else if ("PH".equalsIgnoreCase(xtn.getType())) {
					telecom.setPhone(number);
				} else {
					telecom.setMail(xtn.getEmail());
				}

				if (xtn.getUse() != null) {
					telecom.setUsage(TelecomAddressUse.valueOf(xtn.getUse()));
				}

				t.add(telecom);
			}
		}

		return t;
	}

	private static String extractPhoneNumber(Telecom xtn) {
		if (xtn.getUnformattedPhoneNumber() != null && !xtn.getUnformattedPhoneNumber().isEmpty()) {
			return xtn.getUnformattedPhoneNumber();
		} else {
			return String.format("%d%d%d%d", xtn.getCountryCode(), xtn.getAreaCityCode(), xtn.getLocalNumber(),
					xtn.getExtension());
		}
	}

	/**
	 * Converts an eHC Author to IPF Author
	 *
	 * @param at the eHC Author
	 * @return the IPF Author
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Author converteHCAuthor(Author at) {
		final var a = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Author();

		// Author Person
		var ap = new Person();
		if (at != null) {
			if (at.getName() != null) {
				ap.setName(new XpnName(at.getName().getFamily(), at.getName().getGiven(), null,
						at.getName().getSuffix(), at.getName().getPrefix(), null));
			}

			if (at.getIds() != null && !at.getIds().isEmpty() && at.getIds().get(0) != null) {
				ap.setId(convertEhcIdentificator(at.getIds().get(0)));
			}

			a.setAuthorPerson(ap);

			// Institution
			Organization xon = null;
			if (at.getOrganization() != null) {
				xon = at.getOrganization();
				a.getAuthorInstitution().add(convertXonToIpfOrganization(xon));
			}

			// Role
			Identifiable role = null;
			if (at.getRoleFunction() != null) {
				role = new Identifiable(at.getRoleFunction().getCode(),
						new AssigningAuthority(at.getRoleFunction().getCodeSystem()));
				a.getAuthorRole().add(role);
			}

			// Speciality
			Identifiable speciality = null;
			if (at.getSpeciality() != null) {
				speciality = new Identifiable(at.getSpeciality().getCode(),
						new AssigningAuthority(at.getSpeciality().getCodeSystem()));
				a.getAuthorSpecialty().add(speciality);
			}
		}

		return a;
	}

	/**
	 * Converts an husky Organization to IPF Organization
	 *
	 * @param at the husky Organization
	 * @return the IPF Organization
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization convertXonToIpfOrganization(
			Organization xon) {
		final var org = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization();

		if (xon.getPrimaryName() != null) {
			org.setOrganizationName(xon.getPrimaryName().getFullName());
		}

		if (xon.getPrimaryIdentificator() != null) {
			org.setIdNumber(xon.getPrimaryIdentificator().getExtension());
			var assigningAuthority = new AssigningAuthority();
			assigningAuthority.setUniversalId(xon.getPrimaryIdentificator().getExtension());
			org.setAssigningAuthority(assigningAuthority);
		}

		return org;
	}

	/**
	 * Converts an IPF Code to eHC Code
	 *
	 * @param cmt the Code
	 * @return the eHC Code
	 */
	public static Code convertOhtCodedMetadataType(org.openehealth.ipf.commons.ihe.xds.core.metadata.Code cmt) {
		var code = new Code();
		code.setCode(cmt.getCode());
		code.setDisplayName(convertInternationalStringType(cmt.getDisplayName()));
		code.setCodeSystem(cmt.getSchemeName());
		return code;
	}

	/**
	 * Converts an IPF Identifiable to an eHC Identificator
	 *
	 * @param cx the IPF Identifiable
	 * @return the Identificator
	 */
	public static Identificator convertOhtCx(Identifiable cx) {
		if (cx == null) {
			return null;
		}
		return new Identificator(cx.getAssigningAuthority().getUniversalId(), cx.getId());
	}

	/**
	 * Converts an IPF PatientInfo to an eHC Patient
	 *
	 * @param spit the IPF PatientInfo
	 * @return the eHC Patient
	 */
	public static Patient convertOhtSourcePatientInfoType(PatientInfo spit) {
		final var p = new Patient();

		// Name
		ListIterator<org.openehealth.ipf.commons.ihe.xds.core.metadata.Name> names = spit.getNames();
		if (names.hasNext()) {
			while (names.hasNext()) {
				p.addName(XdsMetadataUtil.convertOhtXpn(names.next()));
			}
		}
		// Date of birth
		if (spit.getDateOfBirth() != null) {
			p.setBirthday(spit.getDateOfBirth().getDateTime());
		}
		// Gender
		if (spit.getGender() != null) {
			p.setAdministrativeGender(AdministrativeGender.getEnum(spit.getGender()));
		}
		// Address
		Iterator<org.openehealth.ipf.commons.ihe.xds.core.metadata.Address> addresses = spit.getAddresses();
		if (addresses != null) {
			while (addresses.hasNext()) {
				p.addAddress(XdsMetadataUtil.convertOhtXad(addresses.next()));
			}

		}
		// ID
		Iterator<Identifiable> ids = spit.getIds();
		if (ids != null) {
			while (ids.hasNext()) {
				final Identifiable cx = ids.next();
				p.addId(XdsMetadataUtil.convertOhtCx(cx));
			}

		}

		return p;
	}

	/**
	 * Converts an IPF Address to an eHC Address
	 *
	 * @param xad the IPF address
	 * @return the Address
	 */
	public static Address convertOhtXad(org.openehealth.ipf.commons.ihe.xds.core.metadata.Address xad) {
		if (xad == null)
			return null;
		else {
			final var address = new Address(new AddressBaseType());
			if ((xad.getStreetAddress() != null) && !xad.getStreetAddress().equals("")) {
				address.setStreetAddressLine1(xad.getStreetAddress());
			}
			if (xad.getZipOrPostalCode() != null) {
				address.setPostalCode(xad.getZipOrPostalCode());
			}

			if (xad.getCity() != null) {
				address.setCity(xad.getCity());
			}

			if (xad.getCountry() != null) {
				address.setCountry(xad.getCountry());
			}

			if (xad.getStateOrProvince() != null) {
				address.setState(xad.getStateOrProvince());
			}

			return address;
		}
	}

	/**
	 * Converts the parts of an XCN to an eHC Identificator
	 *
	 * @param assigningAuthorityUniversalId the assigningAuthorityUniversalId
	 * @param id                            the ID part
	 * @return the Identificator
	 */
	public static Identificator convertOhtXcnIdToEhc(AssigningAuthority assigningAuthorityUniversalId, String id) {
		if (assigningAuthorityUniversalId != null) {
			return new Identificator(assigningAuthorityUniversalId.getUniversalId(), id);
		} else {
			return new Identificator(null, id);
		}
	}

	/**
	 * Converts IPF Identifiable to an eHC Identificator
	 *
	 * @param id the Identifiable
	 * @return the Identificator
	 */
	public static Identificator convertIpfIdentifiableToEhc(Identifiable id) {
		return new Identificator(id);
	}

	/**
	 * Converts an IPF XPN (Name) to an eHC Name
	 *
	 * @param xpn the IPF Name
	 * @return the OHT Name
	 */
	public static Name convertOhtXpn(org.openehealth.ipf.commons.ihe.xds.core.metadata.Name<?> xpn) {
		var name = new Name();
		name.setGiven(xpn.getGivenName());
		name.setFamily(xpn.getFamilyName());
		name.setPrefix(xpn.getPrefix());
		name.setSuffix(xpn.getSuffix());
		return name;
	}

	/**
	 * Creates the IPF code.
	 *
	 * @param schemeName  scheme name
	 * @param code        code
	 * @param displayName display name
	 * @return the code
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code createCodedMetadata(String schemeName,
			String code, String displayName) {
		var cmt = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Code();

		cmt.setCode(code);
		if (displayName != null) {
			cmt.setDisplayName(null);
			cmt.setDisplayName(createInternationalString(displayName));
		}
		if (schemeName != null) {
			cmt.setSchemeName(schemeName);
		}

		return cmt;
	}

	/**
	 * Creates the OHT coded metadata.
	 *
	 * @param schemeName  scheme name
	 * @param code        code
	 * @param displayName display name
	 * @param language    language
	 * @return the coded metadata type
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code createCodedMetadata(String schemeName,
			String code, String displayName, String language) {
		final var cmt = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Code();

		cmt.setCode(code);
		if (displayName != null) {
			cmt.setDisplayName(createInternationalString(displayName, language));
		}
		if (schemeName != null) {
			cmt.setSchemeName(schemeName);
		}

		return cmt;
	}

	/**
	 * Creates the IPF LocalizedString.
	 *
	 * @param text text
	 * @return the org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString
	 */
	public static LocalizedString createInternationalString(String text) {
		final var lst = new LocalizedString();
		lst.setValue(text);
		return lst;
	}

	/**
	 * Creates the IPF LocalizedString
	 *
	 * @param text     the text
	 * @param language the language
	 * @return the org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString
	 */
	public static LocalizedString createInternationalString(String text, String language) {
		final var lst = new LocalizedString();
		lst.setValue(text);
		lst.setLang(language);
		return lst;
	}

}
