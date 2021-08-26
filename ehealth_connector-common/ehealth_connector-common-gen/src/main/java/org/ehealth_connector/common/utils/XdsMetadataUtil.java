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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.TelecomAddressUse;
import org.ehealth_connector.common.mdht.Address;
import org.ehealth_connector.common.mdht.Organization;
import org.ehealth_connector.common.mdht.Telecoms;
import org.ehealth_connector.common.mdht.enums.AdministrativeGender;
import org.ehealth_connector.common.mdht.enums.CodedMetadataEnumInterface;
import org.ehealth_connector.common.mdht.enums.PostalAddressUse;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.PatientInfo;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryList;
import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.common.hl7v2.XAD;
import org.openhealthtools.ihe.common.hl7v2.XON;
import org.openhealthtools.ihe.common.hl7v2.XTN;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.mdht.uml.cda.Person;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

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

	public static final String[] DTM_FMT = { DTM_FMT_YMDHMS, DTM_FMT_YMDHM, DTM_FMT_YMDH,
			DTM_FMT_YMD, DTM_FMT_YM, DTM_FMT_Y };

	/**
	 * <div class="en">Method to convert a Date object to an DTM formatted
	 * string using the format yyyyMMddHHmmss.
	 *
	 * @param dateTime
	 *            the date to be formatted to a string
	 * @return the string representing the date object</div>
	 */
	public static String convertDateToDtmString(Date dateTime) {
		String retVal = null;
		if (dateTime != null) {
			final SimpleDateFormat sdf = new SimpleDateFormat(DTM_FMT_YMDHMS);
			retVal = sdf.format(dateTime);
		}
		return retVal;
	}

	/**
	 * <div class="en">Method to convert the DTM string to a Date object. The
	 * String will be parsed using the formats int the following definition and
	 * order: yyyyMMddHHmmss yyyyMMddHHmm yyyyMMddHH yyyyMMdd yyyyMM yyyy";
	 *
	 * @param dateTimeString
	 *            the string with DTM format
	 * @return the representing Date object </div>
	 */
	public static Date convertDtmStringToDate(String dateTimeString) {
		Date retVal = null;
		if ((dateTimeString != null) && !"".equals(dateTimeString)) {
			final SimpleDateFormat sdf = new SimpleDateFormat();

			int count = 0;
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
	 * <div class="en">Converts eHC Code to OHT CodedMetadataType.</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="en"> the code</div>
	 * @return the coded metadata type
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code convertEhcCodeToCode(Code code) {
		return createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName());
	}

	/**
	 * Converts eHC Code and a given language to OHT CodedMetadataType.
	 *
	 * @param code
	 *            the code
	 * @param language
	 *            the language
	 * @return the coded metadata type
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code convertEhcCodeToCodedMetadataType(Code code,
			String language) {
		var retVal = createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName());
		retVal.getDisplayName().setLang(language);
		return retVal;
	}

	/**
	 * Converts a list of eHC Code to a list of OHT CodedMetadataType.
	 *
	 * @param codeList
	 *            the list of Code
	 * @return the CodedMetadataType Array
	 */
	public static List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> convertEhcCodeToCode(
			Code[] codeList) {
		if (codeList == null)
			return null;
		else {
			final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> cmtArray = new LinkedList<>();

			for (final Code cme : codeList) {
				cmtArray.add(XdsMetadataUtil.convertEhcCodeToCode(cme));
			}

			return cmtArray;
		}
	}

	/**
	 * Converts a list of eHC Code to a list of OHT CodedMetadataType.
	 *
	 * @param codeList the list of Code
	 * @return the CodedMetadataType Array
	 */
	public static QueryList<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> convertEhcCodeToQueryListCode(
			Code[] codeList) {
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
	 * Converts a list of eHC Enums to a given language to a list of OHT
	 * CodedMetadataType.
	 *
	 * @param codedMetadataEnum
	 *            the eHC Enums
	 * @return the CodedMetadataType array
	 */
	public static CodedMetadataType[] convertEhcEnumToCodedMetadataType(
			CodedMetadataEnumInterface[] codedMetadataEnum) {
		if (codedMetadataEnum == null)
			return null;
		else {
			final CodedMetadataType[] cmtArray = new CodedMetadataType[codedMetadataEnum.length];

			int i = 0;
			for (final CodedMetadataEnumInterface cme : codedMetadataEnum) {
				cmtArray[i] = cme.getCodedMetadataType();
				i++;
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
	 * @param ist
	 *            the InternationalStringType
	 * @return the String
	 */
	public static String convertInternationalStringType(LocalizedString ist) {
		if (ist != null) {
			return ist.getValue();
		}
		return null;
	}

	/**
	 * Converts an OHT AuthorType to eHC Author
	 *
	 * @param at
	 *            the OHT AuthorType
	 * @return the eHC Author
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Author convertOhtAuthorType(Author at) {
		final var a = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Author();

		// Author Person
		Person ap = null;
		if (at != null) {
			if (at.getPerson() != null) {
				ap = at.getPerson();
				// Id
				a.addId(convertOhtXcnIdToEhc(ap.getAssigningAuthorityUniversalId(),
						ap.getIdNumber()));
				// Name
				final Name name = new Name(ap.getGivenName(), ap.getFamilyName(), ap.getPrefix(),
						ap.getSuffix());
				a.addName(name);
			}
		}
		// Institution
		XON xon = null;
		if (Util.atLeastOne(at.getAuthorInstitution())) {
			for (int i = 0; i < at.getAuthorInstitution().size(); i++) {
				xon = (XON) at.getAuthorInstitution().get(i);
				final Organization org = new Organization(xon.getOrganizationName());
				org.addId(convertOhtXcnIdToEhc(xon.getAssigningAuthorityUniversalId(),
						xon.getIdNumber()));
			}
		}
		// Role
		String role = null;
		if (Util.atLeastOne(at.getAuthorRole())) {
			role = (String) at.getAuthorRole().get(0);
			a.setRoleFunction(new Code("", role));
		}
		// Speciality
		CE speciality = null;
		if (Util.atLeastOne(at.getAuthorSpeciality())) {
			speciality = (CE) at.getAuthorSpeciality().get(0);
			a.setSpeciality(new Code(speciality));
		}
		// Telecoms
		XTN xtn = null;
		final Telecoms t = new Telecoms();
		if (Util.atLeastOne(at.getAuthorTelecommunication())) {
			for (int i = 0; i < at.getAuthorTelecommunication().size(); i++) {
				xtn = (XTN) at.getAuthorTelecommunication().get(i);
				if ((xtn.getTelecommunicationAddress() != null)
						&& (xtn.getTelecommunicationType() != null))
					t.add(xtn.getTelecommunicationType(), xtn.getTelecommunicationAddress(),
							TelecomAddressUse.PRIVATE);
			}
		}

		return a;
	}

	/**
	 * Converts an OHT CodedMetadataType to eHC Code
	 *
	 * @param cmt
	 *            the CodedMetadataType
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
	 * Converts an OHT CX to an eHC Identificator
	 *
	 * @param cx
	 *            the OHT CX
	 * @return the Identificator
	 */
	public static Identificator convertOhtCx(Identifiable cx) {
		if (cx == null) {
			return null;
		}
		return new Identificator(cx.getAssigningAuthority().getUniversalId(), cx.getId());
	}

	/**
	 * Converts an OHT SourcePatientInfoType to an eHC Patient
	 *
	 * @param spit
	 *            the SourcePatientInfoType
	 * @return the eHC Patient
	 */
	public static Patient convertOhtSourcePatientInfoType(PatientInfo spit) {
		final Patient p = new Patient();

		// Name
		if (spit.getNames().hasNext()) {
			while (spit.getNames().hasNext()) {
				final var xpn = spit.getNames().next();
				p.addName(XdsMetadataUtil.convertOhtXpn(xpn));
			}
		}
		// Date of birth
		if (spit.getDateOfBirth() != null) {
			p.setBirthday(DateUtil.parseDateyyyyMMdd(spit.getDateOfBirth().getDateTime()));
		}
		// Gender
		if (spit.getGender() != null) {
			p.setAdministrativeGender(AdministrativeGender.getEnum(spit.getGender()));
		}
		// Address
		if (spit.getAddresses() != null) {
			p.addAddress(XdsMetadataUtil.convertOhtXad(spit.getAddresses()));
		}
		// ID
		if (Util.atLeastOne(spit.getPatientIdentifier())) {
			for (int i = 0; i < spit.getPatientIdentifier().size(); i++) {
				final CX cx = (CX) spit.getPatientIdentifier().get(i);
				p.addId(XdsMetadataUtil.convertOhtCx(cx));
			}
		}
		// Phone Business
		final Telecoms t = new Telecoms();
		if (spit.getPatientPhoneBusiness() != null) {
			t.add(spit.getPatientPhoneBusiness().getTelecommunicationType(),
					spit.getPatientPhoneBusiness().getTelecommunicationAddress(),
					TelecomAddressUse.BUSINESS);
		}
		// Phone Home
		if (spit.getPatientPhoneHome() != null) {
			t.add(spit.getPatientPhoneHome().getTelecommunicationType(),
					spit.getPatientPhoneHome().getTelecommunicationAddress(),
					TelecomAddressUse.PRIVATE);
		}
		p.setTelecoms(t);

		return p;
	}

	/**
	 * Converts an OHT XAD to an eHC Address
	 *
	 * @param xad
	 *            the XAD
	 * @return the Address
	 */
	public static Address convertOhtXad(XAD xad) {
		if (xad == null)
			return null;
		else {
			final Address address = new Address();
			if ((xad.getStreetAddress() != null) && !xad.getStreetAddress().equals("")) {
				address.setAddressline1(xad.getStreetAddress());
			}
			if (xad.getZipOrPostalCode() != null) {
				address.setZip(xad.getZipOrPostalCode());
			}
			address.setUsage(PostalAddressUse.PRIVATE);
			return address;
		}
	}

	/**
	 * Converts the parts of an OHC XCN to an eHC Identificator
	 *
	 * @param assigningAuthorityUniversalId
	 *            the assigningAuthorityUniversalId
	 * @param id
	 *            the ID part
	 * @return the Identificator
	 */
	public static Identificator convertOhtXcnIdToEhc(String assigningAuthorityUniversalId,
			String id) {
		return new Identificator(assigningAuthorityUniversalId, id);
	}

	/**
	 * Converts an OHT XPN (Name) to an eHC Name
	 *
	 * @param xpn
	 *            the OHT XPN
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
	 * <div class="en">Creates the OHT coded metadata.</div>
	 *
	 * @param schemeName
	 *            <br>
	 *            <div class="en"> scheme name</div>
	 * @param code
	 *            <br>
	 *            <div class="en"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="en"> display name</div>
	 * @param schemeUuid
	 *            <br>
	 *            <div class="en"> scheme uuid</div>
	 * @return the coded metadata type
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code createCodedMetadata(String schemeName,
			String code,
			String displayName) {
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
	 * @param schemeName
	 *            <br>
	 *            <div class="en"> scheme name</div>
	 * @param code
	 *            <br>
	 *            <div class="en"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="en"> display name</div>
	 * @param schemeUuid
	 *            <br>
	 *            <div class="en"> scheme uuid</div>
	 * @param language
	 *            <br>
	 *            language
	 * @return the coded metadata type
	 */
	public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Code createCodedMetadata(String schemeName,
			String code,
			String displayName, String language) {
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
	 * <div class="en">Creates the OHT CX.</div>
	 *
	 * @param ii
	 *            <br>
	 *            <div class="en">the II value</div>
	 * @return the cx
	 */
	public static CX createCx(II ii) {
		final CX cx = Hl7v2Factory.eINSTANCE.createCX();
		cx.setAssigningAuthorityUniversalId(ii.getRoot());
		cx.setIdNumber(ii.getExtension());
		cx.setAssigningAuthorityName(ii.getAssigningAuthorityName());
		cx.setAssigningAuthorityUniversalIdType("ISO");
		return cx;
	}

	/**
	 * <div class="en">Creates the OHT CX.</div>
	 *
	 * @param authorityId
	 *            <br>
	 *            <div class="en"> authority id</div>
	 * @param id
	 *            <br>
	 *            <div class="en"> id</div>
	 * @return the cx
	 */
	public static CX createCx(String authorityId, String id) {
		final CX cx = Hl7v2Factory.eINSTANCE.createCX();
		cx.setAssigningAuthorityUniversalId(authorityId);
		cx.setIdNumber(id);
		cx.setAssigningAuthorityUniversalIdType("ISO");
		return cx;
	}

	/**
	 * <div class="en">Creates the OHT InternationalStringType.</div>
	 *
	 * @param text
	 *            <br>
	 *            <div class="en"> text</div>
	 * @return the org.openhealthtools.ihe.xds.metadata.InternationalStringType
	 */
	@SuppressWarnings("unchecked")
	public static LocalizedString createInternationalString(
			String text) {
		final var lst = new LocalizedString();
		lst.setValue(text);
		return lst;
	}

	/**
	 * <div class="en">Creates the OHT InternationalStringType</div>
	 *
	 * @param text
	 *            <br>
	 *            <div class="en">the text</div>
	 * @param language
	 *            <br>
	 *            the language
	 * @return the org.openhealthtools.ihe.xds.metadata.InternationalStringType
	 */
	public static LocalizedString createInternationalString(
			String text, String language) {
		final var lst = new LocalizedString();
		lst.setValue(text);
		lst.setLang(language);
		return lst;
	}

	private XdsMetadataUtil() {

	}

}
