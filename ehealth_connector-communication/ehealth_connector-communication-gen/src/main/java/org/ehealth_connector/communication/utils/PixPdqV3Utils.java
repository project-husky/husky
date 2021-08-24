package org.ehealth_connector.communication.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import net.ihe.gazelle.hl7v3.coctmt090003UV01.COCTMT090003UV01AssignedEntity;
import net.ihe.gazelle.hl7v3.coctmt090003UV01.COCTMT090003UV01Organization;
import net.ihe.gazelle.hl7v3.coctmt150002UV01.COCTMT150002UV01Organization;
import net.ihe.gazelle.hl7v3.coctmt150003UV03.COCTMT150003UV03ContactParty;
import net.ihe.gazelle.hl7v3.coctmt150003UV03.COCTMT150003UV03Organization;
import net.ihe.gazelle.hl7v3.datatypes.AD;
import net.ihe.gazelle.hl7v3.datatypes.AdxpAdditionalLocator;
import net.ihe.gazelle.hl7v3.datatypes.AdxpCity;
import net.ihe.gazelle.hl7v3.datatypes.AdxpCountry;
import net.ihe.gazelle.hl7v3.datatypes.AdxpCounty;
import net.ihe.gazelle.hl7v3.datatypes.AdxpPostalCode;
import net.ihe.gazelle.hl7v3.datatypes.AdxpState;
import net.ihe.gazelle.hl7v3.datatypes.AdxpStreetAddressLine;
import net.ihe.gazelle.hl7v3.datatypes.BL;
import net.ihe.gazelle.hl7v3.datatypes.CD;
import net.ihe.gazelle.hl7v3.datatypes.CE;
import net.ihe.gazelle.hl7v3.datatypes.CS;
import net.ihe.gazelle.hl7v3.datatypes.EN;
import net.ihe.gazelle.hl7v3.datatypes.EnFamily;
import net.ihe.gazelle.hl7v3.datatypes.EnGiven;
import net.ihe.gazelle.hl7v3.datatypes.EnPrefix;
import net.ihe.gazelle.hl7v3.datatypes.EnSuffix;
import net.ihe.gazelle.hl7v3.datatypes.II;
import net.ihe.gazelle.hl7v3.datatypes.INT;
import net.ihe.gazelle.hl7v3.datatypes.IVLTS;
import net.ihe.gazelle.hl7v3.datatypes.ON;
import net.ihe.gazelle.hl7v3.datatypes.PN;
import net.ihe.gazelle.hl7v3.datatypes.ST;
import net.ihe.gazelle.hl7v3.datatypes.TEL;
import net.ihe.gazelle.hl7v3.datatypes.TS;
import net.ihe.gazelle.hl7v3.mccimt000100UV01.MCCIMT000100UV01Agent;
import net.ihe.gazelle.hl7v3.mccimt000100UV01.MCCIMT000100UV01Device;
import net.ihe.gazelle.hl7v3.mccimt000100UV01.MCCIMT000100UV01Organization;
import net.ihe.gazelle.hl7v3.mccimt000100UV01.MCCIMT000100UV01Receiver;
import net.ihe.gazelle.hl7v3.mccimt000100UV01.MCCIMT000100UV01Sender;
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01Agent;
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01Device;
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01Organization;
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01Receiver;
import net.ihe.gazelle.hl7v3.mccimt000300UV01.MCCIMT000300UV01Sender;
import net.ihe.gazelle.hl7v3.mfmimt700701UV01.MFMIMT700701UV01Custodian;
import net.ihe.gazelle.hl7v3.voc.CommunicationFunctionType;
import net.ihe.gazelle.hl7v3.voc.EntityClassDevice;
import net.ihe.gazelle.hl7v3.voc.EntityClassOrganization;
import net.ihe.gazelle.hl7v3.voc.EntityDeterminer;
import net.ihe.gazelle.hl7v3.voc.HomeAddressUse;
import net.ihe.gazelle.hl7v3.voc.NullFlavor;
import net.ihe.gazelle.hl7v3.voc.ParticipationType;
import net.ihe.gazelle.hl7v3.voc.RoleClassAgent;
import net.ihe.gazelle.hl7v3.voc.RoleClassAssignedEntity;
import net.ihe.gazelle.hl7v3.voc.WorkPlaceAddressUse;

public class PixPdqV3Utils {
	static int sequence = 0;

	/**
	 * Convert an AD (Address) object into a String array containing each part as
	 * follows: String[0] = Street Address Line String[1] = Additional Locator
	 * String[2] = City String[3] = State String[4] = Postal Code String[5] = <not
	 * populated> String[6] = <not populated> String[7] = <not populated> String[8]
	 * = County
	 *
	 * @param ad (The AD object containing the address)
	 * @return String array containing each part of the address.
	 */
	public static String[] ADToStringArray(AD ad) {
		// NOTE: I'm only getting the first address line, other locator, etc.
		var addressArray = new String[9];
		if (null != ad.getStreetAddressLine() && !ad.getStreetAddressLine().isEmpty())
			addressArray[0] = getMixedValue(ad.getStreetAddressLine().get(0).getMixed());
		if (null != ad.getAdditionalLocator() && !ad.getAdditionalLocator().isEmpty())
			addressArray[1] = getMixedValue(ad.getAdditionalLocator().get(0).getMixed());
		if (null != ad.getCity() && !ad.getCity().isEmpty())
			addressArray[2] = getMixedValue(ad.getCity().get(0).getMixed());
		if (null != ad.getState() && !ad.getState().isEmpty())
			addressArray[3] = getMixedValue(ad.getState().get(0).getMixed());
		if (null != ad.getPostalCode() && !ad.getPostalCode().isEmpty())
			addressArray[4] = getMixedValue(ad.getPostalCode().get(0).getMixed());
		if (null != ad.getCountry() && !ad.getCountry().isEmpty())
			addressArray[5] = getMixedValue(ad.getCountry().get(0).getMixed());
		if (null != ad.getCounty() && !ad.getCounty().isEmpty())
			addressArray[8] = getMixedValue(ad.getCounty().get(0).getMixed());
		return addressArray;
	}

	/**
	 * Create a new II with the same root, extension and assignAuthority as the
	 * supplied sourceII.
	 *
	 * @param sourceII
	 * @return II with the same root, extension and assignAuthority as the supplied
	 *         sourceII.
	 */
	public static II copyII(II sourceII) {
		return createII(sourceII.getRoot(), sourceII.getExtension(), sourceII.getAssigningAuthorityName());
	}

	/**
	 * Create an AD type object containing the supplied address parts that are
	 * non-empty (all are optional). If no address parts are supplied, the returned
	 * value will be null.
	 *
	 * @param addressStreetAddress
	 * @param addressCity
	 * @param addressCounty
	 * @param addressState
	 * @param addressCountry
	 * @param addressZip
	 * @param addressOtherDesignation
	 * @param addressType             (possible values are "H", "W", or "WP")
	 * @return AD type object containing the non-empty address parts provided.
	 */
	public static AD createAD(List<String> addressStreetAddressLines, String addressCity, String addressCounty,
			String addressState, String addressCountry, String addressZip, String addressOtherDesignation,
			String addressType) {
		var addressAD = new AD();

		// make sure we actually add an address
		var addressAdded = false;

		for (String addressStreetAddress : addressStreetAddressLines) {
			// if there is a street address
			if (addressStreetAddress != null && !addressStreetAddress.equals("")) {
				// create the street address
				var streetAddress = new AdxpStreetAddressLine();

				// set the street address value
				streetAddress.addMixed(addressStreetAddress);

				// Add the street address to the AD
				addressAD.addStreetAddressLine(streetAddress);

				// indicate that some part of the address was added
				addressAdded = true;
			}
		}

		// if there is a city
		if (addressCity != null && !addressCity.equals("")) {
			// create the city
			var city = new AdxpCity();

			// set the street address value
			city.addMixed(addressCity);

			// Add the city to the AD
			addressAD.addCity(city);

			// indicate that some part of the address was added
			addressAdded = true;
		}

		// if there is a county code
		if (addressCounty != null && !addressCounty.isEmpty()) {
			// create the county
			var county = new AdxpCounty();

			// set the county value
			county.addMixed(addressCounty);

			// Add the county to the AD
			addressAD.addCounty(county);

			// indicate that some part of the address was added
			addressAdded = true;
		}

		// if there is a state
		if (addressState != null && !addressState.isEmpty()) {
			// create the state
			var state = new AdxpState();

			// set the state value
			state.addMixed(addressState);

			// Add the state to the AD
			addressAD.addState(state);

			// indicate that some part of the address was added
			addressAdded = true;
		}

		// if there is a country
		if (addressCountry != null && !addressCountry.isEmpty()) {
			// create the state
			var country = new AdxpCountry();

			// set the state value
			country.addMixed(addressCountry);

			// Add the country to the AD
			addressAD.addCountry(country);

			// indicate that some part of the address was added
			addressAdded = true;
		}

		// if there is a zip code
		if (addressZip != null && !addressZip.isEmpty()) {
			// create the zipCode
			var zipCode = new AdxpPostalCode();

			// set the zip code
			zipCode.addMixed(addressZip);

			// add the zip code to the AD
			addressAD.addPostalCode(zipCode);

			// indicate that some part of the address was added
			addressAdded = true;
		}

		// if there is an other designation
		if (addressOtherDesignation != null && !addressOtherDesignation.isEmpty()) {
			// create the other designation object
			// TODO: is this the right place for other designation??
			var otherDesignation = new AdxpAdditionalLocator();

			// set the other designation
			otherDesignation.addMixed(addressOtherDesignation);

			// add the other designation to the AD
			addressAD.addAdditionalLocator(otherDesignation);

			// indicate that some part of the address was added
			addressAdded = true;
		}

		// if there is an addressType
		if (addressType != null && !addressType.equals("")) {
			if ("H".equalsIgnoreCase(addressType))
				addressAD.setUse(HomeAddressUse.H.value());
			if (("W".equalsIgnoreCase(addressType)) || ("WP".equalsIgnoreCase(addressType)))
				addressAD.setUse(WorkPlaceAddressUse.WP.value());
		}

		// if address wasn't added, null it out
		if (!addressAdded)
			addressAD = null;

		// return the value
		return addressAD;
	}

	/**
	 * Create an AD type object containing the supplied address parts that are
	 * non-empty (all are optional). If no address parts are supplied, the returned
	 * value will be null.
	 *
	 * @param addressStreetAddress
	 * @param addressCity
	 * @param addressCounty
	 * @param addressState
	 * @param addressCountry
	 * @param addressZip
	 * @param addressOtherDesignation
	 * @param addressType             (possible values are "H", "W", or "WP")
	 * @return AD type object containing the non-empty address parts provided.
	 */
	public static AD createAD(String addressStreetAddress, String addressCity, String addressCounty,
			String addressState, String addressCountry, String addressZip, String addressOtherDesignation,
			String addressType) {
		List<String> adressLines = new ArrayList<>();
		adressLines.add(addressStreetAddress);
		return createAD(adressLines, addressCity, addressCounty, addressState, addressCountry, addressZip,
				addressOtherDesignation, addressType);
	}

	/**
	 * Create a BL1 object with the supplied boolean.
	 *
	 * @param value
	 * @return BL1 object with a value equal to the supplied boolean.
	 */
	public static BL createBL(boolean value) {
		var bl = new BL();
		bl.setValue(value);
		return bl;
	}

	/**
	 * Create a CD type with the supplied values. All parameters are optional. Only
	 * those that are non-empty will be populated in the CD object.
	 *
	 * @param code
	 * @param codeSystem
	 * @param codeSystemName
	 * @param displayValue
	 * @return CD type containing the supplied values.
	 */
	public static CD createCD(String code, String codeSystem, String codeSystemName, String displayValue) {
		var cd = new CD();
		if (null != code && !code.isEmpty())
			cd.setCode(code);
		if (null != codeSystem && !codeSystem.isEmpty())
			cd.setCodeSystem(codeSystem);
		if (null != codeSystemName && !codeSystemName.isEmpty())
			cd.setCodeSystemName(codeSystemName);
		if (null != displayValue && !displayValue.isEmpty())
			cd.setDisplayName(displayValue);

		// return the completed CD
		return cd;
	}

	/**
	 * Create a CE type with the code supplied and empty strings for all other
	 * attributes.
	 *
	 * @param code
	 * @return CE type with the code supplied and empty strings for all other
	 *         attributes.
	 */
	public static CE createCE(String code) {
		return createCE(code, "", "", "");
	}

	/**
	 * Create a CE type with the supplied values. All parameters are optional. Only
	 * those that are non-empty will be populated in the CD object.
	 *
	 * @param code
	 * @param codeSystem
	 * @param codeSystemName
	 * @param displayValue
	 * @return CE type containing the supplied values.
	 */
	public static CE createCE(String code, String codeSystem, String codeSystemName, String displayValue) {

		var ce = new CE();
		if (null != code && !code.isEmpty())
			ce.setCode(code);
		if (null != codeSystem && !codeSystem.isEmpty())
			ce.setCodeSystem(codeSystem);
		if (null != codeSystemName && !codeSystemName.isEmpty())
			ce.setCodeSystemName(codeSystemName);
		if (null != displayValue && !displayValue.isEmpty())
			ce.setDisplayName(displayValue);

		// return the completed CE
		return ce;
	}

	/**
	 * Create a COCTMT150002UV01Organization object with the provided organization
	 * ID
	 *
	 * @param root (Organization ID)
	 * @return COCTMT150002UV01Organization object with the provided organization
	 *         ID.
	 */
	public static COCTMT150002UV01Organization createCOCTMT150002UV01Organization(String root) {
		var organization = new COCTMT150002UV01Organization();
		organization.setClassCode(EntityClassOrganization.ORG);
		organization.setDeterminerCode(EntityDeterminer.INSTANCE);
		organization.getId().add(createII(root, "", ""));
		return organization;
	}

	/**
	 * Create a COCTMT150003UV03Organization with the provided organization ID, name
	 * and telecom
	 *
	 * @param organizationOID
	 * @param organizationName
	 * @param telecomValue
	 * @return COCTMT150003UV03Organization object populated with provided values.
	 */
	public static COCTMT150003UV03Organization createCOCTMT150003UV03Organization(String organizationOID,
			String organizationName, String telecomValue) {
		var organization = new COCTMT150003UV03Organization();
		organization.setClassCode(EntityClassOrganization.ORG);
		organization.setDeterminerCode(EntityDeterminer.INSTANCE);
		organization.getId().add(createII(organizationOID, "", ""));
		var on = new ON();
		on.getMixed().add(organizationName);
		organization.getName().add(on);
		var contactParty = new COCTMT150003UV03ContactParty();
		contactParty.setClassCode(net.ihe.gazelle.hl7v3.voc.RoleClassContact.CON);
		// TODO: Should this have a "use" value? Possibly "WP" (Work Phone)
		contactParty.getTelecom().add(createTEL(telecomValue, ""));
		organization.getContactParty().add(contactParty);
		return organization;
	}

	/**
	 * Create a CS1 type with the supplied code set.
	 *
	 * @param code
	 * @return CS1 type with the supplied code set.
	 */
	public static CS createCS(String code) {
		var cs = new CS();
		cs.setCode(code);
		return cs;
	}

	/**
	 * Create an EN type with the provided name components. All components are
	 * optional and will only be populated if non-empty.
	 *
	 * @param family
	 * @param given
	 * @param other
	 * @param suffix
	 * @param prefix
	 * @return EN Type containing the provided name components.
	 */
	public static EN createEN(String family, String given, String other, String suffix, String prefix) {

		var en = new EN();

		// if there is a family name
		if (family != null && !family.isEmpty()) {
			// create the family name object
			var familyName = new EnFamily();

			// add the text to the family name
			familyName.addMixed(family);

			// Add the family name to the EN
			en.addFamily(familyName);
		}

		// if there is a given name
		if (given != null && !given.isEmpty()) {
			// create the given name object
			var givenName = new EnGiven();

			// add the text to the family name
			givenName.addMixed(given);

			// Add the given name to the EN
			en.addGiven(givenName);
		}

		// if there is an other name
		if (other != null && !other.isEmpty()) {
			// create the given name object
			var givenName2 = new EnGiven();

			// add the text to the second given name
			givenName2.addMixed(other);

			// Add the given name to the EN
			en.addGiven(givenName2);
		}

		// if there is a suffix
		if (suffix != null && !suffix.isEmpty()) {
			// create the suffix object
			var suffixname = new EnSuffix();

			// add the text to the suffix
			suffixname.addMixed(suffix);

			// Add the suffix to the EN
			en.addSuffix(suffixname);
		}

		// if there is a prefix
		if (prefix != null && !prefix.isEmpty()) {
			// create the prefix object
			var prefixname = new EnPrefix();

			// add the text to the suffix
			prefixname.addMixed(prefix);

			// Add the prefix to the EN
			en.addPrefix(prefixname);
		}

		return en;
	}

	/**
	 * Helper method for turning an Enumerator into a list
	 *
	 * @param Enumerator (the enum value that will make up the list)
	 * @return List of Enumerator containing the single supplied value.
	 */
	public static List<Enumerator> createEnumeratorList(Enumerator enumValue) {

		// create a list to hold the "use" value
		List<Enumerator> enumList = new ArrayList<>();

		// add the SRCH value;
		enumList.add(enumValue);

		return enumList;
	}

	/**
	 * Create an II type with the specified root, extension, and namespace. All
	 * parameters are optional and the resulting object will contain only those that
	 * are non-empty.
	 *
	 * @param root
	 * @param extension
	 * @param namespace
	 * @return II created with the specified root, extension, and namespace.
	 */
	public static II createII(String root, String extension, String namespace) {
		// create an ID to identify this message
		var idII = new II();
		// for now set these to a fixed root and extension
		if (null != root && !root.isEmpty())
			idII.setRoot(root);
		if (null != extension && !extension.isEmpty())
			idII.setExtension(extension);
		if (null != namespace && !namespace.isEmpty())
			idII.setAssigningAuthorityName(namespace);

		return idII;
	}

	/**
	 * Creates an II type with the specified NullFlavor ("NI", "MSK", "UNC", or
	 * "NA")
	 *
	 * @param nullFlavorType (one of "NI", "MSK", "UNC", or "NA")
	 * @return II created with the specified NullFlavor
	 */
	public static II createIINullFlavor(String nullFlavorType) {
		// create an ID to identify this message
		var idII = new II();
		idII.setNullFlavor(NullFlavor.fromValue(nullFlavorType));
		return idII;
	}

	/**
	 * Create an II type with the specified root and a unique extension.
	 *
	 * @param root
	 * @return II created with an extension generated from currentTimeMillis and an
	 *         incremented sequence.
	 */
	public static II createIIwithUniqueExtension(String root) {
		// increment the sequence to ensure that we don't duplicate IDs
		sequence++;

		// build the extension from the current time and the sequence value
		String extension = String.valueOf(System.currentTimeMillis()) + String.valueOf(sequence);

		// if extension has grown too long (> 16 chars) then truncate it to the
		// last 16 chars
		if (extension.length() > 16)
			extension = extension.substring(extension.length() - 16, extension.length());

		return createII(root, extension, "");
	}

	/**
	 * Creates an INT1 type with the value of the supplied integer.
	 *
	 * @param i (The integer to create the INT1 type for)
	 * @return INT1 type with the value of the supplied integer.
	 */
	public static INT createINT1(Integer i) {
		var int1 = new INT();
		int1.setValue(i);
		return int1;
	}

	/**
	 * Create an IVLTS type with value of the supplied date.
	 *
	 * @param date (An appropriate string representation for the IVLTS value)
	 * @return IVLTS type with value of the supplied date.
	 */
	public static IVLTS createIVLTS(String date) {
		var ivlts = new IVLTS();
		ivlts.setValue(date);
		return ivlts;
	}

	/**
	 * Create a MCCIMT000100UV01Device with the supplied applicationOID (device) and
	 * facilityOID (organization).
	 *
	 * @param applicationOID
	 * @param facilityOID    (optional - if omitted, there will be no represented
	 *                       organization)
	 * @return MCCIMT000100UV01Device with the supplied applicationOID (device) and
	 *         facilityOID.
	 */
	public static MCCIMT000100UV01Device createMCCIMT000100UV01Device(String applicationOID, String facilityOID) {
		// create the sender device
		var device = new MCCIMT000100UV01Device();

		// Set the device class code
		device.setClassCode(EntityClassDevice.DEV);

		// get the device determiner code and set it TODO: same issue as
		// receiver device above
		device.setDeterminerCode(EntityDeterminer.INSTANCE);

		// instII.setExtension("PRPA_IN201305UV02");
		device.getId().add(createII(applicationOID, "", ""));

		// if there is a facility OID
		if (facilityOID != null && !facilityOID.equals("")) {
			// create the asAgent
			var asAgent = new MCCIMT000100UV01Agent();

			// set the classCode for the asAgent
			asAgent.setClassCode(RoleClassAgent.AGNT);

			// create the representedOrganization for the asAgent
			var senderRepresentedOrganization = new MCCIMT000100UV01Organization();

			// Set the device class code
			senderRepresentedOrganization.setClassCode(EntityClassOrganization.ORG);

			// get the device determiner code and set it TODO: same issue as
			// receiver device above
			senderRepresentedOrganization.setDeterminerCode(EntityDeterminer.INSTANCE);

			// add the id to the representedOrganization
			senderRepresentedOrganization.getId().add(createII(facilityOID, "", ""));

			// set the representedOrganization
			asAgent.setRepresentedOrganization(senderRepresentedOrganization);

			// set the asAgent
			device.setAsAgent(asAgent);
		}

		// return the sender
		return device;
	}

	/**
	 * Create a MCCIMT000100UV01Receiver with the supplied applicationOID (device)
	 * and facilityOID (organization).
	 *
	 * @param applicationOID
	 * @param facilityOID    (optional - if omitted, there will be no represented
	 *                       organization)
	 * @return MCCIMT000100UV01Receiver with the supplied applicationOID (device)
	 *         and facilityOID.
	 */
	public static MCCIMT000100UV01Receiver createMCCIMT000100UV01Receiver(String applicationOID, String facilityOID) {
		// create the receiver
		var receiver = new MCCIMT000100UV01Receiver();

		// create the receiver's communication function type
		CommunicationFunctionType receivercft = CommunicationFunctionType.RCV;

		// set the typecode of the receiver
		receiver.setTypeCode(receivercft);

		// now add the receiver device to the receiver
		receiver.setDevice(createMCCIMT000100UV01Device(applicationOID, facilityOID));

		// return the receiver
		return receiver;
	}

	/**
	 * Create a MCCIMT000100UV01Sender with the supplied applicationOID (device) and
	 * facilityOID (organization).
	 *
	 * @param applicationOID
	 * @param facilityOID    (optional - if omitted, there will be no represented
	 *                       organization)
	 * @return MCCIMT000100UV01Sender with the supplied applicationOID (device) and
	 *         facilityOID.
	 */
	public static MCCIMT000100UV01Sender createMCCIMT000100UV01Sender(String applicationOID, String facilityOID) {
		// create the sender
		var sender = new MCCIMT000100UV01Sender();

		// create the sender's communication function type
		CommunicationFunctionType senderCFT = CommunicationFunctionType.SND;

		// set the typecode of the sender
		sender.setTypeCode(senderCFT);

		// now add the sender device to the sender
		sender.setDevice(createMCCIMT000100UV01Device(applicationOID, facilityOID));

		// return the sender
		return sender;
	}

	/**
	 * Create a MCCIMT000300UV01Device with the supplied applicationOID (device) and
	 * facilityOID (organization).
	 *
	 * @param applicationOID
	 * @param facilityOID    (optional - if omitted, there will be no represented
	 *                       organization)
	 * @return MCCIMT000300UV01Device with the supplied applicationOID (device) and
	 *         facilityOID.
	 */
	public static MCCIMT000300UV01Device createMCCIMT000300UV01Device(String applicationOID, String facilityOID) {
		// create the sender device
		var device = new MCCIMT000300UV01Device();

		// Set the device class code
		device.setClassCode(EntityClassDevice.DEV);

		// get the device determiner code and set it TODO: same issue as
		// receiver device above
		device.setDeterminerCode(EntityDeterminer.INSTANCE);

		// instII.setExtension("PRPA_IN201305UV02");
		device.getId().add(createII(applicationOID, "", ""));

		// if there is a facility OID
		if (facilityOID != null && !facilityOID.equals("")) {
			// create the asAgent
			var asAgent = new MCCIMT000300UV01Agent();

			// set the classCode for the asAgent
			asAgent.setClassCode(RoleClassAgent.AGNT);

			// create the representedOrganization for the asAgent
			var senderRepresentedOrganization = new MCCIMT000300UV01Organization();

			// Set the device class code
			senderRepresentedOrganization.setClassCode(EntityClassOrganization.ORG);

			// get the device determiner code and set it TODO: same issue as
			// receiver device above
			senderRepresentedOrganization.setDeterminerCode(EntityDeterminer.INSTANCE);

			// add the id to the representedOrganization
			senderRepresentedOrganization.addId(createII(facilityOID, "", ""));

			// set the representedOrganization
			asAgent.setRepresentedOrganization(senderRepresentedOrganization);

			// set the asAgent
			device.setAsAgent(asAgent);
		}

		// return the sender
		return device;
	}

	/**
	 * Create a MCCIMT000300UV01Receiver with the supplied applicationOID (device)
	 * and facilityOID (organization).
	 *
	 * @param applicationOID
	 * @param facilityOID    (optional - if omitted, there will be no represented
	 *                       organization)
	 * @return MCCIMT000300UV01Receiver with the supplied applicationOID (device)
	 *         and facilityOID.
	 */
	public static MCCIMT000300UV01Receiver createMCCIMT000300UV01Receiver(String applicationOID, String facilityOID) {
		// create the receiver
		var receiver = new MCCIMT000300UV01Receiver();

		// create the receiver's communication function type
		CommunicationFunctionType receivercft = CommunicationFunctionType.RCV;

		// set the typecode of the receiver
		receiver.setTypeCode(receivercft);

		// now add the receiver device to the receiver
		receiver.setDevice(createMCCIMT000300UV01Device(applicationOID, facilityOID));

		// return the receiver
		return receiver;
	}

	/**
	 * Create a MCCIMT000300UV01Sender with the supplied applicationOID (device) and
	 * facilityOID (organization).
	 *
	 * @param applicationOID
	 * @param facilityOID    (optional - if omitted, there will be no represented
	 *                       organization)
	 * @return MCCIMT000300UV01Sender with the supplied applicationOID (device) and
	 *         facilityOID.
	 */
	public static MCCIMT000300UV01Sender createMCCIMT000300UV01Sender(String applicationOID, String facilityOID) {
		// create the sender
		var sender = new MCCIMT000300UV01Sender();

		// create the sender's communication function type
		CommunicationFunctionType senderCFT = CommunicationFunctionType.SND;

		// set the typecode of the sender
		sender.setTypeCode(senderCFT);

		// now add the sender device to the sender
		sender.setDevice(createMCCIMT000300UV01Device(applicationOID, facilityOID));

		// return the sender
		return sender;
	}

	/**
	 * Create a PN Object containing the supplied name parts.
	 *
	 * @param familyName
	 * @param givenName
	 * @param otherName
	 * @param suffixName
	 * @param prefixName
	 * @return PN Object containing the supplied name parts.
	 */
	public static PN createPN(String familyName, String givenName, String otherName, String suffixName,
			String prefixName) {
		// first create the en
		var en = createEN(familyName, givenName, otherName, suffixName, prefixName);

		// now create the pn
		var pn = new PN();
		// copy values over
		pn.getFamily().addAll(en.getFamily());
		pn.getGiven().addAll(en.getGiven());
		pn.getSuffix().addAll(en.getSuffix());
		pn.getPrefix().addAll(en.getPrefix());

		return pn;
	}

	/**
	 * Creates a MFMIMT700701UV01Custodian with the supplied Organization ID and
	 * name
	 *
	 * @param organizationOID
	 * @param organizationName
	 * @return MFMIMT700701UV01Custodian with the supplied Organization ID and name.
	 */
	public static MFMIMT700701UV01Custodian createRegistrationCustodian(String organizationOID,
			String organizationName) {
		var custodian = new MFMIMT700701UV01Custodian();
		custodian.setTypeCode(ParticipationType.CST);
		var assignedEntity = new COCTMT090003UV01AssignedEntity();
		custodian.setAssignedEntity(assignedEntity);
		assignedEntity.setClassCode(RoleClassAssignedEntity.ASSIGNED);
		assignedEntity.addId(createII(organizationOID, "", ""));
		var assignedOrganization = new COCTMT090003UV01Organization();
		assignedEntity.setAssignedOrganization(assignedOrganization);
		assignedOrganization.setClassCode(EntityClassOrganization.ORG);
		assignedOrganization.setDeterminerCode(EntityDeterminer.INSTANCE);
		var name = new EN();
		name.addMixed(organizationName);
		assignedOrganization.addName(name);
		return custodian;
	}

	/**
	 * Create an ST1 type containing the supplied text value.
	 *
	 * @param text
	 * @return ST1 type containing the supplied text value.
	 */
	public static ST createST(String text) {
		var semanticsText = new ST();
		semanticsText.addMixed(text);
		return semanticsText;
	}

	/**
	 * Create a TEL type object with the supplied telecom value and use value (if
	 * supplied)
	 *
	 * @param telecomValue (the phone, web, or e-mail address value)
	 * @param useValue     (either "WP" for Work or "HP" for Home)
	 * @return TEL type with the supplied telecom and use values.
	 */
	public static TEL createTEL(String telecomValue, String useValue) {
		var returnTEL = new TEL();
		returnTEL.setValue(telecomValue);
		if (null != useValue) {
			if ("WP".equalsIgnoreCase(useValue))
				returnTEL.setUse(WorkPlaceAddressUse.WP.value());
			else if ("HP".equalsIgnoreCase(useValue))
				returnTEL.setUse(HomeAddressUse.HP.value());
		}
		return returnTEL;
	}

	/**
	 * Create a TS1 element with the supplied value.
	 *
	 * @param value
	 * @return TS1 element with the supplied value.
	 */
	public static TS createTS(String value) {
		// create a TS1 element
		var ts = new TS();

		// set the current time time
		ts.setValue(value);

		return ts;
	}

	/**
	 * Create a TS1 element with the current time.
	 *
	 * @return TS1 element with the current time in format "yyyyMMddHHmmss"
	 */
	public static TS createTSCurrentTime() {
		// create a simple date format
		var dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

		return createTS(dateFormat.format(new Date()));
	}

	/**
	 * Convert a EN object into a string array with the following values: String[0]
	 * = Family Name String[1] = Given Name (first instance) String[2] = Given Name
	 * (second instance, if available) String[3] = Suffix String[4] = Prefix
	 *
	 * @param en (The EN value to convert)
	 * @return String[] with each component of the name.
	 */
	public static String[] ENToStringArray(EN en) {
		var patientName = new String[5];

		if (null != en.getFamily() && !en.getFamily().isEmpty())
			patientName[0] = getMixedValue(en.getFamily().get(0).getMixed());
		if (null != en.getGiven() && !en.getGiven().isEmpty()) {
			patientName[1] = getMixedValue(en.getGiven().get(0).getMixed());

			if (en.getGiven().size() > 1)
				patientName[2] = getMixedValue(en.getGiven().get(1).getMixed());
		}
		if (null != en.getSuffix() && !en.getSuffix().isEmpty())
			patientName[3] = getMixedValue(en.getSuffix().get(0).getMixed());
		if (null != en.getPrefix() && !en.getPrefix().isEmpty())
			patientName[4] = getMixedValue(en.getPrefix().get(0).getMixed());

		return patientName;
	}

	/**
	 * Helper method which gets the value of the supplied FeatureMap
	 *
	 * @param mixed (the FeatureMap containing the value)
	 * @return String containing the value of the supplied FeatureMap.
	 */
	private static String getMixedValue(List<Serializable> mixed) {
		var returnValue = "";
		// if we have a mixed
		if (!mixed.isEmpty() && mixed.get(0) instanceof String)
			returnValue = (String) mixed.get(0);
		return returnValue;
	}

	/**
	 * Get the appropriate telecom value given a particular useCode
	 *
	 * @param telecom (A list of telecoms)
	 * @param useCode (The useCode for the telecom to get)
	 * @return String containing the value of the telecom with the supplied useCode
	 *         or empty string.
	 */
	public static String getTelecomByUseCode(List<TEL> telecom, String useCode) {
		var telephoneNumber = "";

		// for each patient found
		for (var i = 0; i < telecom.size(); i++) {
			var currentTEL = telecom.get(i);
			if (null != currentTEL.getUse() && !currentTEL.getUse().isEmpty()) {
				if (currentTEL.getUse().equalsIgnoreCase(useCode)) {
					telephoneNumber = currentTEL.getValue();
					break;
				}
			}
		}
		return telephoneNumber;
	}

	/**
	 * Converts an II type into a String array with the following values: String[0]
	 * = id.getExtension(); String[1] = id.getAssigningAuthorityName(); String[2] =
	 * id.getRoot(); String[3] = "";
	 *
	 * @param id (The II type to convert to string array)
	 * @return String[] containing extension, assignAuthority, and name.
	 */
	public static String[] IIToStringArray(II id) {
		var array = new String[4];
		array[0] = id.getExtension();
		array[1] = id.getAssigningAuthorityName();
		array[2] = id.getRoot();
		array[3] = "";
		return array;
	}

	/**
	 * Convert a PN object into a string array with the following values: String[0]
	 * = Family Name String[1] = Given Name (first instance) String[2] = Given Name
	 * (second instance, if available) String[3] = Suffix String[4] = Prefix
	 *
	 * @param pn (The PN value to convert)
	 * @return String[] with each component of the name.
	 */
	public static String[] PNToStringArray(PN pn) {
		var patientName = new String[5];

		// if we've got a family name
		if (null != pn.getFamily() && !pn.getFamily().isEmpty())
			patientName[0] = getMixedValue(pn.getFamily().get(0).getMixed());
		if (null != pn.getGiven() && !pn.getGiven().isEmpty()) {
			patientName[1] = getMixedValue(pn.getGiven().get(0).getMixed());

			if (pn.getGiven().size() > 1)
				patientName[2] = getMixedValue(pn.getGiven().get(1).getMixed());
		}
		if (null != pn.getSuffix() && !pn.getSuffix().isEmpty())
			patientName[3] = getMixedValue(pn.getSuffix().get(0).getMixed());
		if (null != pn.getPrefix() && !pn.getPrefix().isEmpty())
			patientName[4] = getMixedValue(pn.getPrefix().get(0).getMixed());

		return patientName;
	}
}
