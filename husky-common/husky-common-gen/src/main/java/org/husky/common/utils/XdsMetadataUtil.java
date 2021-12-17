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

/**
 * <div class="de">Class XdsUtil provides helper methods for the IHE XDS
 * Context.</div>
 */
public class XdsMetadataUtil {

	public static final String DTM_FMT_Y = "yyyy";
	public static final String DTM_FMT_YM = "yyyyMM";
	public static final String DTM_FMT_YMD = "yyyyMMdd";
	public static final String DTM_FMT_YMDH = "yyyyMMddHH";
	public static final String DTM_FMT_YMDHM = "yyyyMMddHHmm";

	public static final String DTM_FMT_YMDHMS = "yyyyMMddHHmmss";

	protected static final String[] DTM_FMT = { DTM_FMT_YMDHMS, DTM_FMT_YMDHM, DTM_FMT_YMDH, DTM_FMT_YMD, DTM_FMT_YM,
			DTM_FMT_Y };

	/**
	 * <div class="en">Method to convert a Date object to an DTM formatted string
	 * using the format yyyyMMddHHmmss.
	 *
	 * @param dateTime the date to be formatted to a string
	 * @return the string representing the date object</div>
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
	 * <div class="en">Method to convert the DTM string to a Date object. The String
	 * will be parsed using the formats int the following definition and order:
	 * yyyyMMddHHmmss yyyyMMddHHmm yyyyMMddHH yyyyMMdd yyyyMM yyyy";
	 *
	 * @param dateTimeString the string with DTM format
	 * @return the representing Date object </div>
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
				}
				++count;
			}
		}

		return retVal;
	}

	/**
	 * <div class="en">Converts eHC Code to IPF Code.</div>
	 *
	 * @param code <br>
	 *             <div class="en"> the code</div>
	 * @return the code
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code convertEhcCodeToCode(Code code) {
		return createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName());
	}

	/**
	 * <div class="en">Converts eHC Code to IPF Code.</div>
	 *
	 * @param code <br>
	 *             <div class="en"> the code</div>
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
	 * <div class="en">Convert identificator to IPF Identifiable</div>
	 *
	 * @param id <br>
	 *           <div class="en"> id</div>
	 * @return the Identifiable
	 */
	public static Identifiable convertEhcIdentificator(Identificator id) {
		if (id == null)
			return null;

		return new Identifiable(id.getExtension(), new AssigningAuthority(id.getRoot()));
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
			org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization xon = null;
			if (at.getAuthorInstitution() != null && !at.getAuthorInstitution().isEmpty()
					&& at.getAuthorInstitution().get(0) != null) {
				for (var i = 0; i < at.getAuthorInstitution().size(); i++) {
					xon = at.getAuthorInstitution().get(i);
					final var org = new OrganizationBaseType();
					org.addIdentificator(
							convertOhtXcnIdToEhc(xon.getAssigningAuthority(), xon.getIdNumber()));
					org.addName(new Name(xon.getOrganizationName()));
					a.setOrganization(new Organization(org));
				}
			}

			// Role
			Code role = null;
			if (at.getAuthorRole() != null && !at.getAuthorRole().isEmpty()
					&& at.getAuthorRole().get(0) != null) {
					role = new Code();
					role.setCode(at.getAuthorRole().get(0).getId());
					if (at.getAuthorRole().get(0).getAssigningAuthority() != null) {
						role.setCodeSystem(at.getAuthorRole().get(0).getAssigningAuthority().getUniversalId());
					}

				a.setRoleFunction(role);
			}

			// Speciality
			Code speciality = null;
			if (at.getAuthorSpecialty() != null && !at.getAuthorSpecialty().isEmpty()
					&& at.getAuthorSpecialty().get(0) != null) {
					speciality = new Code();
					speciality.setCode(at.getAuthorSpecialty().get(0).getId());
					speciality.setCodeSystem(at.getAuthorSpecialty().get(0).getAssigningAuthority().getUniversalId());

				a.setSpeciality(speciality);
			}

			// Telecoms
			Telecom xtn = null;
			final List<org.husky.common.model.Telecom> t = new LinkedList<>();
			if (at.getAuthorTelecom() != null && !at.getAuthorTelecom().isEmpty()
					&& at.getAuthorTelecom().get(0) != null) {
				for (var i = 0; i < at.getAuthorTelecom().size(); i++) {
					xtn = at.getAuthorTelecom().get(i);
					if (xtn.getType() != null) {
						var telecom = new org.husky.common.model.Telecom();

						var number = "";
						if (xtn.getUnformattedPhoneNumber() != null && !xtn.getUnformattedPhoneNumber().isEmpty()) {
							number = xtn.getUnformattedPhoneNumber();
						} else {
							number = String.format("%d%d%d%d", xtn.getCountryCode(), xtn.getAreaCityCode(),
									xtn.getLocalNumber(), xtn.getExtension());
						}

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

				a.setTelecoms(t);
			}
		}

		return a;
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

					a.getAuthorInstitution().add(org);
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
		Iterator<org.openehealth.ipf.commons.ihe.xds.core.metadata.Name> names = spit.getNames();
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
	 * <div class="en">Creates the IPF code.</div>
	 *
	 * @param schemeName  <br>
	 *                    <div class="en"> scheme name</div>
	 * @param code        <br>
	 *                    <div class="en"> code</div>
	 * @param displayName <br>
	 *                    <div class="en"> display name</div>
	 * @param schemeUuid  <br>
	 *                    <div class="en"> scheme uuid</div>
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
	 * <div class="en">Creates the OHT coded metadata.</div>
	 *
	 * @param schemeName  <br>
	 *                    <div class="en"> scheme name</div>
	 * @param code        <br>
	 *                    <div class="en"> code</div>
	 * @param displayName <br>
	 *                    <div class="en"> display name</div>
	 * @param schemeUuid  <br>
	 *                    <div class="en"> scheme uuid</div>
	 * @param language    <br>
	 *                    language
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
	 * <div class="en">Creates the IPF LocalizedString.</div>
	 *
	 * @param text <br>
	 *             <div class="en"> text</div>
	 * @return the org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString
	 */
	public static LocalizedString createInternationalString(String text) {
		final var lst = new LocalizedString();
		lst.setValue(text);
		return lst;
	}

	/**
	 * <div class="en">Creates the IPF LocalizedString</div>
	 *
	 * @param text     <br>
	 *                 <div class="en">the text</div>
	 * @param language <br>
	 *                 the language
	 * @return the org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString
	 */
	public static LocalizedString createInternationalString(String text, String language) {
		final var lst = new LocalizedString();
		lst.setValue(text);
		lst.setLang(language);
		return lst;
	}

	private XdsMetadataUtil() {

	}

}
