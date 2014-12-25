/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2014
 *
 *******************************************************************************/

package ch.ehc.cda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.ehc.cda.Organization;
import org.ehc.cda.ConvenienceUtilsEnums.AdministrativeGenderCode;
import org.ehc.cda.ConvenienceUtilsEnums.Language;
import org.ehc.cda.ConvenienceUtilsEnums.UseCode;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CustodianOrganization;
import org.openhealthtools.mdht.uml.cda.LegalAuthenticator;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;

/**
 * Hilfs-Methoden
 * 
 */
public class CdaChUtil {

	/**
	 * Erzeugt eine Adresse
	 * 
	 * @param streetName
	 *            Contains the StreetName
	 * @param houseNumber
	 *            Contains the house number
	 * @param zip
	 *            PLZ
	 * @param city
	 *            Ort
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 * @return the new address
	 */
	public static AD createAddress(String streetName, String houseNumber,
			String zip, String city, UseCode usage) {
		final AD ad = createAddress(zip, city, usage);

		if (streetName != null) {
			ad.addStreetAddressLine(streetName);
		}
		if (houseNumber != null) {
			ad.addHouseNumber(houseNumber);
		}
		return ad;
	}

	/**
	 * Erzeugt eine Adresse
	 * 
	 * @param addressline1
	 *            Adresszeile 1
	 * @param addressline2
	 *            Adresszeile 2
	 * @param addressline3
	 *            Adresszeile 3
	 * @param zip
	 *            PLZ
	 * @param city
	 *            Ort
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 * @return HL7 AD Objekt
	 */
	public AD createAddress(String addressline1, String addressline2,
			String addressline3, String zip, String city, UseCode usage) {
		final AD ad = createAddress(zip, city, usage);

		if (addressline1 != null) {
			ad.addStreetAddressLine(addressline1);
		}
		if (addressline2 != null) {
			ad.addStreetAddressLine(addressline2);
		}
		if (addressline3 != null) {
			ad.addStreetAddressLine(addressline3);
		}
		return ad;
	}

	/**
	 * Erzeugt eine Adresse
	 * 
	 * @param zip
	 *            PLZ
	 * @param city
	 *            Ort
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 * @return HL7 AD Objekt
	 */
	public static AD createAddress(String zip, String city, UseCode usage) {
		final AD ad = DatatypesFactory.eINSTANCE.createAD();

		if (zip != null) {
			ad.addPostalCode(zip);
		}
		if (city != null) {
			ad.addCity(city);
		}
		if (usage != null) {
			// TODO add the real Use Code here
			// ad.getUses().add(usage);
		}
		return ad;
	}

	/**
	 * Erzeugt eine Adresse
	 * 
	 * @param addressline
	 * @param zip
	 *            PLZ
	 * @param city
	 *            Ort
	 * @param usage
	 *            Verwendungszweck (Privat, Geschäft)
	 */
	public static AD createAdress(String addressline, String zip, String city,
			UseCode usage) {
		final AD ad = createAddress(zip, city, usage);

		if (addressline != null) {
			ad.addStreetAddressLine(addressline);
		}
		return ad;
	}

	/**
	 * Erzeugt ein AdministrativeGenderCode
	 * 
	 * @param sex
	 *            Geschlecht
	 * @return HL7 CE Objekt
	 */
	public static CE createAdministrativeGenderCode(AdministrativeGenderCode sex) {
		// TODO Auf das richtige Value Set ändern
		String pSexStr = null;
		switch (sex) {
		case Male:
			pSexStr = "M";
			break;
		case Female:
			pSexStr = "F";
			break;
		case Undifferentiated:
			pSexStr = "U";
		}
		final CE pSex = DatatypesFactory.eINSTANCE.createCE(pSexStr,
				"2.16.840.1.113883.5.1");
		return pSex;
	}

	/**
	 * Erzeugt aus einem MDHT Organization Objekt ein neues MDHT
	 * CustodianOrganization Objekt
	 * 
	 * @param organization
	 *            Organisation
	 * @return CustodianOrganization
	 */
	public static CustodianOrganization createCustodianOrganizationFromOrganization(
			Organization organization) {
		// create and set the mdht RepresentedCustodianOrganization Object
		final CustodianOrganization mdhtCustOrg = CDAFactory.eINSTANCE
				.createCustodianOrganization();

		ON on = DatatypesFactory.eINSTANCE.createON();
		on.addText(organization.getName());
		mdhtCustOrg.setName(on);
		// take the first address and set it as CustodianAdress
		mdhtCustOrg.setAddr(organization.getOrganization().getAddrs().get(0));
		// take the first telecom and set it as CustodianTelecom
		mdhtCustOrg.setTelecom(organization.getOrganization().getTelecoms().get(0));
		// TODO handle any other adresses/telecoms
		return mdhtCustOrg;
	}

	/**
	 * Erezugt aus einem MDHT Author Objekt ein neues MDHT LegalAuthenticator
	 * Objekt
	 * 
	 * @param author
	 */
	public static LegalAuthenticator createLagalAuthenticatorFromAuthor(
			org.ehc.cda.Author author) {
		// FIXME Copy the values from the author object, without drawing / move
		// them from it.

		// create and set the mdht RepresentedCustodianOrganization Object
		LegalAuthenticator mdhtLegAuth = CDAFactory.eINSTANCE
				.createLegalAuthenticator();
		AssignedEntity asEnt = CDAFactory.eINSTANCE.createAssignedEntity();
		mdhtLegAuth.setAssignedEntity(asEnt);

		org.openhealthtools.mdht.uml.cda.Person authorPerson = CDAFactory.eINSTANCE
				.createPerson();
		asEnt.setAssignedPerson(authorPerson);

		// TODO
		// EList<PN> authorName = DatatypesFactory.eINSTANCE.createPN();
		// authorName =
		// author.getAssignedAuthor().getAssignedPerson().getNames();

		authorPerson = author.getAuthorMdht().getAssignedAuthor()
				.getAssignedPerson();

		// Extract and assign the Name of the Author (CDA Class Person)
		// org.openhealthtools.mdht.uml.cda.AssignedAuthor asAuth =
		// CDAFactory.eINSTANCE.createAssignedAuthor();
		// asEnt.setAssignedPerson(value);
		// asAuth = author.getAssignedAuthor();

		// org.openhealthtools.mdht.uml.cda.AssignedAuthor authorAssignedAuthor
		// = CDAFactory.eINSTANCE.createAssignedAuthor();
		// authorAssignedAuthor = author.getAssignedAuthor();
		//
		// org.openhealthtools.mdht.uml.cda.Person authorPerson =
		// CDAFactory.eINSTANCE.createPerson();
		// authorAssignedAuthor.setAssignedPerson(authorPerson);
		// authorPerson = author.getAssignedAuthor().getAssignedPerson();
		// asEnt.setAssignedPerson(authorPerson);

		// Extract and assign the IDs of the Author
		// final EList<II> authorIds = author.getAssignedAuthor().getIds();
		// mdhtLegAuth.getAssignedEntity().getIds().addAll(authorIds);

		return mdhtLegAuth;
	}

	/**
	 * Erzeut ein LanguageCode Objekt
	 * 
	 * @param language
	 *            Sprache
	 * @return HL7 CS Objekt
	 */
	public static CS createLanguageCode(Language language) {
		// TODO: Use Modeled code system
		// Set one of the language codes which are possible in Swiss
		final CS lang = DatatypesFactory.eINSTANCE.createCS();
		switch (language) {
		case German:
			lang.setCode("de-CH");
			break;
		case French:
			lang.setCode("fr-CH");
			break;
		case Italian:
			lang.setCode("it-CH");
		}
		return lang;
	}

	/**
	 * Erzeugt ein TS Objekt
	 * 
	 * @param eurDateStr
	 *            ein Date String in dem Format dd.MM.yyyy wie er in Europa
	 *            gebräuchlich ist
	 * @return HL7 TS Objekt
	 * @throws ParseException
	 */
	public static TS createTSFromEuroDate(String eurDateStr)
			throws ParseException {
		final DateFormat eurDateFormatter = new SimpleDateFormat("dd.MM.yyyy");
		final DateFormat ohtDateFormatter = new SimpleDateFormat("yyyyMMdd");

		final Date eurDate = eurDateFormatter.parse(eurDateStr);
		final String ohtDateStr = ohtDateFormatter.format(eurDate);

		final TS ohtDate = DatatypesFactory.eINSTANCE.createTS(ohtDateStr);
		return ohtDate;
	}

	/**
	 * Erzeugt ein IVXB_TS Objekt
	 * 
	 * @param eurDateStr
	 *            ein Date String in dem Format dd.MM.yyyy wie er in Europa
	 *            gebräuchlich ist
	 * @return HL7 IVXB_TS Objekt
	 * @throws ParseException
	 */
	public static IVXB_TS createIVXB_TSFromEuroDate(String eurDateStr)
			throws ParseException {
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

	/**
	 * Erzeugt ein IVL_TS Objekt
	 * 
	 * @param eurDateBegin
	 *            der Begin des Intervals in dem Format dd.MM.yyyy wie er in
	 *            Europa gebräuchlich ist
	 * @param eurDateEnd
	 *            das Ende des Intervals in dem Format dd.MM.yyyy wie er in
	 *            Europa gebräuchlich ist
	 * @return HL7 IVL_TS Objekt
	 * @throws ParseException
	 */
	public static IVL_TS createIVL_TSFromEuroDate(String eurDateBegin,
			String eurDateEnd) throws ParseException {
		// Create OHT Data structure
		IVL_TS ohtInterval = DatatypesFactory.eINSTANCE.createIVL_TS();

		// Create and set Begin
		ohtInterval.setLow(createIVXB_TSFromEuroDate(eurDateBegin));

		// Create and set End
		ohtInterval.setHigh(createIVXB_TSFromEuroDate(eurDateEnd));

		return ohtInterval;
	}

	/**
	 * Erzeugt eine Dokumenten ID mit Hilfe einer applicationOidRoot
	 * 
	 * @param appliactionOidRoot
	 *            identifiziert diese Version des eHCs
	 * @return HL7 II Objekt
	 */
	public static II generateDocId(String appliactionOidRoot) {
		// Unique identifier of the document. The root part identifies the
		// application instance, the extension part identifies the document
		// instance.

		final String documentOid = org.openhealthtools.ihe.utils.OID
				.createOIDGivenRoot("ehealthconnctor");
		// Creates a random extension ID to identify the document
		final Random r = new Random();
		final II id = DatatypesFactory.eINSTANCE.createII(documentOid,
				String.valueOf(r.nextInt()));
		return id;
	}

	public static String createEurDateStrFromTS(String hl7Stimestamp) {
		// TODO Prüfen, ob der übergebene String das richtige Format hat.
		String eurDateStr = hl7Stimestamp.substring(6, 8) + "."
				+ hl7Stimestamp.substring(4, 6) + "."
				+ hl7Stimestamp.substring(0, 4);
		return eurDateStr;
	}

	public static ENXP createName(String name) {
		ENXP mName = DatatypesFactory.eINSTANCE.createENXP();
		mName.addText(name);
		return mName;
	}
}
