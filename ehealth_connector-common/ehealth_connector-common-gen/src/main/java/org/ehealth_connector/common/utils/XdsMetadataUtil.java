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

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.CodedMetadataEnumInterface;
import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.common.hl7v2.SourcePatientInfoType;
import org.openhealthtools.ihe.common.hl7v2.XAD;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.common.hl7v2.XON;
import org.openhealthtools.ihe.common.hl7v2.XPN;
import org.openhealthtools.ihe.common.hl7v2.XTN;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.InternationalStringType;
import org.openhealthtools.ihe.xds.metadata.LocalizedStringType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

/**
 * <div class="de">Class XdsUtil provides helper methods for the IHE XDS
 * Context.</div>
 */
public class XdsMetadataUtil {

	private XdsMetadataUtil() {

	}

	/**
	 * <div class="en">Converts eHC Code to OHT CodedMetadataType.</div>
	 * 
	 * @param code
	 *            <br>
	 *            <div class="en"> the code</div>
	 * @return the coded metadata type
	 */
	public static CodedMetadataType convertEhcCodeToCodedMetadataType(Code code) {
		return createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName(),
				null);
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
	public static CodedMetadataType convertEhcCodeToCodedMetadataType(Code code, String language) {
		return createCodedMetadata(code.getCodeSystem(), code.getCode(), code.getDisplayName(),
				null, language);
	}

	/**
	 * Converts a list of eHC Code to a list of OHT CodedMetadataType.
	 * 
	 * @param codeList
	 *            the list of Code
	 * @return the CodedMetadataType Array
	 */
	public static CodedMetadataType[] convertEhcCodeToCodedMetadataType(Code[] codeList) {
		if (codeList == null)
			return null;
		else {
			final CodedMetadataType[] cmtArray = new CodedMetadataType[codeList.length];

			int i = 0;
			for (final Code cme : codeList) {
				cmtArray[i] = XdsMetadataUtil.convertEhcCodeToCodedMetadataType(cme);
				i++;
			}

			return cmtArray;
		}
	}

	// /**
	// * Converts a list of eHC DateTimeRange to a list of OHT DateTimeRange.
	// *
	// * @param dtr
	// * the OHT DateTimeRange
	// * @return the DateTimeRange Array
	// */
	// public static org.openhealthtools.ihe.xds.consumer.query.DateTimeRange[]
	// convertEhcDateTimeRange(
	// org.ehealth_connector.communication.xd.storedquery.DateTimeRange[] dtr) {
	// if (dtr == null)
	// return null;
	// else {
	// final org.openhealthtools.ihe.xds.consumer.query.DateTimeRange[] dtrArray
	// = new
	// org.openhealthtools.ihe.xds.consumer.query.DateTimeRange[dtr.length];
	//
	// int i = 0;
	// for (final
	// org.ehealth_connector.communication.xd.storedquery.DateTimeRange dt :
	// dtr) {
	// dtrArray[i] = dt.getOhtDateTimeRange();
	// i++;
	// }
	//
	// return dtrArray;
	// }
	// }

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
	 * <div class="en">Convert identificator to OHT CX</div>
	 * 
	 * @param id
	 *            <br>
	 *            <div class="en"> id</div>
	 * @return the cx
	 */
	public static CX convertEhcIdentificator(Identificator id) {
		if (id == null)
			return null;
		return createCx(id.getRoot(), id.getExtension());
	}

	/**
	 * Converts an OHT InternationalStringType to String
	 * 
	 * @param ist
	 *            the InternationalStringType
	 * @return the String
	 */
	public static String convertInternationalStringType(InternationalStringType ist) {
		if (ist != null) {
			if ((ist.getLocalizedString() != null) && (ist.getLocalizedString().size() > 0)) {
				String s = "";
				for (int i = 0; i < ist.getLocalizedString().size(); i++) {
					final LocalizedStringType lst = (LocalizedStringType) ist.getLocalizedString()
							.get(i);
					s = s + lst.getValue();
					if (i > 0)
						s = s + "\n";
				}
				return s;
			}
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
	public static Author convertOhtAuthorType(AuthorType at) {
		final Author a = new Author();

		// Author Person
		XCN ap = null;
		if (at != null) {
			if (at.getAuthorPerson() != null) {
				ap = at.getAuthorPerson();
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
				t.add(xtn.getTelecommunicationType(), xtn.getTelecommunicationAddress(),
						AddressUse.PRIVATE);
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
	public static Code convertOhtCodedMetadataType(CodedMetadataType cmt) {
		return new Code(cmt.getSchemeName(), cmt.getCode(),
				convertInternationalStringType(cmt.getDisplayName()));
	}

	/**
	 * Converts an OHT CX to an eHC Identificator
	 * 
	 * @param cx
	 *            the OHT CX
	 * @return the Identificator
	 */
	public static Identificator convertOhtCx(CX cx) {
		return new Identificator(cx.getAssigningAuthorityUniversalId(), cx.getIdNumber());
	}

	/**
	 * Converts an OHT SourcePatientInfoType to an eHC Patient
	 * 
	 * @param spit
	 *            the SourcePatientInfoType
	 * @return the eHC Patient
	 */
	public static Patient convertOhtSourcePatientInfoType(SourcePatientInfoType spit) {
		final Patient p = new Patient();

		// Name
		if (Util.atLeastOne(spit.getPatientName())) {
			for (int i = 0; i < spit.getPatientName().size(); i++) {
				final XPN xpn = (XPN) spit.getPatientName().get(i);
				p.addName(XdsMetadataUtil.convertOhtXpn(xpn));
			}
		}
		// Date of birth
		if (spit.getPatientDateOfBirth() != null) {
			p.setBirthday(DateUtil.parseDateyyyyMMdd(spit.getPatientDateOfBirth()));
		}
		// Gender
		if (spit.getPatientSex() != null) {
			p.setAdministrativeGender(AdministrativeGender.getEnum(spit.getPatientSex()));
		}
		// Address
		if (spit.getPatientAddress() != null) {
			p.addAddress(XdsMetadataUtil.convertOhtXad(spit.getPatientAddress()));
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
					AddressUse.BUSINESS);
		}
		// Phone Home
		if (spit.getPatientPhoneHome() != null) {
			t.add(spit.getPatientPhoneHome().getTelecommunicationType(),
					spit.getPatientPhoneHome().getTelecommunicationAddress(), AddressUse.PRIVATE);
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
		return new Address(xad.getStreetAddress(), xad.getZipOrPostalCode(), xad.getCity(),
				AddressUse.PRIVATE);
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
	public static Name convertOhtXpn(XPN xpn) {
		return new Name(xpn.getGivenName(), xpn.getFamilyName(), xpn.getPrefix(), xpn.getSuffix());
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
	public static CodedMetadataType createCodedMetadata(String schemeName, String code,
			String displayName, String schemeUuid) {
		final CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();

		cmt.setCode(code);
		if (displayName != null) {
			cmt.setDisplayName(createInternationalString(displayName));
		}
		if (schemeName != null) {
			cmt.setSchemeName(schemeName);
		}
		if (schemeUuid != null) {
			cmt.setSchemeUUID(schemeUuid);
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
	public static CodedMetadataType createCodedMetadata(String schemeName, String code,
			String displayName, String schemeUuid, String language) {
		final CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();

		cmt.setCode(code);
		if (displayName != null) {
			cmt.setDisplayName(createInternationalString(displayName, language));
		}
		if (schemeName != null) {
			cmt.setSchemeName(schemeName);
		}
		if (schemeUuid != null) {
			cmt.setSchemeUUID(schemeUuid);
		}

		return cmt;
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
	public static org.openhealthtools.ihe.xds.metadata.InternationalStringType createInternationalString(
			String text) {
		final org.openhealthtools.ihe.xds.metadata.InternationalStringType ist = MetadataFactory.eINSTANCE
				.createInternationalStringType();
		final LocalizedStringType lst = MetadataFactory.eINSTANCE.createLocalizedStringType();
		lst.setValue(text);
		ist.getLocalizedString().add(lst);
		return ist;
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
	@SuppressWarnings("unchecked")
	public static org.openhealthtools.ihe.xds.metadata.InternationalStringType createInternationalString(
			String text, String language) {
		final org.openhealthtools.ihe.xds.metadata.InternationalStringType ist = MetadataFactory.eINSTANCE
				.createInternationalStringType();
		final LocalizedStringType lst = MetadataFactory.eINSTANCE.createLocalizedStringType();
		lst.setValue(text);
		lst.setLang(language);
		ist.getLocalizedString().add(lst);
		return ist;
	}

	// /**
	// * Creates a document name in conformance with the XDM document naming
	// * scheme
	// *
	// * @param xdsDoc
	// * the OHT XDSDocument
	// * @param docNr
	// * the number of the document
	// * @return the name of the document
	// */
	// public static String createXdmDocName(XDSDocument xdsDoc, int docNr) {
	// // compile the path and filename for the zip file
	// String fileName = "DOC";
	//
	// // Fix DocumentDescriptor problem...
	// DocumentDescriptor dd = xdsDoc.getDescriptor();
	// if (dd.toString().startsWith("UNKNOWN!")) {
	// String mimeType = dd.toString().replace("UNKNOWN!", "");
	// mimeType = mimeType.substring(mimeType.indexOf("!") + 1,
	// mimeType.length());
	// dd = DocumentDescriptor.getDocumentDescriptorForMimeType(mimeType);
	// }
	// // if ("UNKNOWN!CDA-R2!text/xml".equals(dd.toString()))
	// // dd = DocumentDescriptor.CDA_R2;
	//
	// final String fileNameExtension = DocDescriptor.getFileExtension(dd);
	// fileName = fileName.concat(String.format("%5s", docNr).replace(' ',
	// '0'));
	// fileName = fileName.concat("." + fileNameExtension.toUpperCase());
	// return fileName;
	// }
	//
	// /**
	// * Creates a document path and name in conformance with the XDM document
	// * naming scheme
	// *
	// * @param xdsDoc
	// * the OHT XDSDocument
	// * @param docNr
	// * the number of the document
	// * @return the path and name of the document
	// */
	// public static String createXdmDocPathAndName(XDSDocument xdsDoc, int
	// docNr) {
	// final String filePath = "IHE_XDM/SUBSET01/" + createXdmDocName(xdsDoc,
	// docNr);
	// return filePath;
	// }
}
