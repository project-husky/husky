/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */

package org.ehealth_connector.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * Generates a OID following the IHE XDS format from: IHE IT Infrastructure Technical Framework, vol.2 (ITI TF-2): Transactions Revison 2.0,
 * August 15,2005, pp234-236.
 *
 * This class generate a pretty unique UID
 * 
 * @version $Revision: 1.6 $
 * @author <a href="glenn@almaden.ibm.com">Glenn Deen </a>
 * @author <a href="seknoop@us.ibm.com">Sarah Knoop </a>
 */
public class OID {
	/**
	 * Monotoniclaly increasing sequence number
	 */
	static int sequence = 0;

	static final String rootPrefix = "1.2.820";

	public static final int OID_MAX_LENGTH_DEFAULT = 256;

	/**
	 * Creates an oid of the following format: <br> OID = rootOID.ipaddr.time.sequence <br> e.g 2.16.840.1.113883.3.18.123456790.123456789.1234
	 *
	 * If rootOid is null, the method createOID(null) is called and that result is returned. OID generated is 256 chars in length
	 * 
	 * @param rootOid
	 *            The ANSI issued complete Organizational OID for a given insitution, system, or persion to which the generated OID will be
	 *            associated.
	 * @return A IHE Document UUID String (OID)
	 */
	public static String create256CharOIDGivenRoot(String rootOid) {
		return createOIDGivenRoot(rootOid, 256);
	}

	/**
	 * Creates an oid of the following format: <br> OID = rootOID.ipaddr.time.sequence <br> e.g 2.16.840.1.113883.3.18.123456790.123456789.1234
	 *
	 * If rootOid is null, the method createOID(null) is called and that result is returned. OID generated is 64 chars in length
	 * 
	 * @param rootOid
	 *            The ANSI issued complete Organizational OID for a given insitution, system, or persion to which the generated OID will be
	 *            associated.
	 * @return A IHE Document UUID String (OID)
	 */
	public static String create64CharOIDGivenRoot(String rootOid) {
		return createOIDGivenRoot(rootOid, 64);
	}

	/**
	 * Creates an oid of the following format: <br> OID = rootPrefix.Organization.ipaddr.time.sequence <br> e.g
	 * 1.2.820.ORGANIZATION.123456790.123456789.1234
	 *
	 * If Orgnization is null, 99999 is used. Thr rootPrefix is set to "1.2.820".
	 * 
	 * @param organization
	 *            The ANSI issue Organizational ID (an INTEGER) for the organization to which the generated oid will be associated with
	 * @return A IHE Document UUID String (OID)
	 */
	public static String createOID(String organization) {
		sequence++;

		byte[] hostip = new byte[4];
		try {
			InetAddress localhost;
			localhost = InetAddress.getLocalHost();
			hostip = localhost.getAddress();
		} catch (UnknownHostException e) {
			// Use the loopback as a default
			hostip[0] = 127;
			hostip[1] = 0;
			hostip[2] = 0;
			hostip[3] = 1;
		}
		// this MAC is real, it's from Glenn's wireless card!
		int[] mac = { 0x00, 0x02, 0x8A, 0x4A, 0xFD, 0xAC };

		// to the the "fake" MAC address, munch this real MAC
		// with the host IP address as follows..
		for (int i = 0; i < mac.length; i++)
			mac[i] = (int) ((hostip[i % hostip.length] - mac[i]) * Math.random());

		String macString = "";
		for (int i = 0; i < mac.length; i++)
			macString = macString + format(mac[i]);

		// macString is now mac.length*3 bytes or 18bytes long!

		if (organization == null) {
			organization = "99999";
		}
		String root = rootPrefix + "." + Integer.parseInt(organization);
		String suffix = macString + "." + System.currentTimeMillis() + "." + sequence;
		int maxSuffix = 64 - 9; // allow room for "urn:UUID:"
		if (suffix.length() > maxSuffix)
			suffix = suffix.substring(0, maxSuffix);
		String result = root + "." + suffix;
		return result.replaceAll("[.]0", ".1");
	}

	/**
	 * Creates an oid of the following format: <br> OID = rootOID.ipaddr.time.sequence <br> e.g 2.16.840.1.113883.3.18.123456790.123456789.1234
	 *
	 * If rootOid is null, the method createOID(null) is called and that result is returned. OID generated is subject to OID_MAX_LENGTH_DEFAULT
	 * 
	 * @param rootOid
	 *            The ANSI issued complete Organizational OID for a given insitution, system, or persion to which the generated OID will be
	 *            associated.
	 * @return A IHE Document UUID String (OID)
	 */
	public static String createOIDGivenRoot(String rootOid) {
		return createOIDGivenRoot(rootOid, OID_MAX_LENGTH_DEFAULT);
	}

	/**
	 * Creates an oid of the following format: <br> OID = rootOID.ipaddr.time.sequence <br> e.g 2.16.840.1.113883.3.18.123456790.123456789.1234
	 *
	 * If rootOid is null, the method createOID(null) is called and that result is returned.
	 * 
	 * @param rootOid
	 *            The ANSI issued complete Organizational OID for a given insitution, system, or persion to which the generated OID will be
	 *            associated.
	 * @param maxLength
	 *            The maximum length of string for the OID
	 * @return OID subject to the max length
	 */
	public static String createOIDGivenRoot(String rootOid, int maxLength) {
		if (rootOid == null) {
			return createOID(rootOid);
		}

		sequence++;

		byte[] hostip = new byte[4];
		try {
			InetAddress localhost;
			localhost = InetAddress.getLocalHost();
			hostip = localhost.getAddress();
		} catch (UnknownHostException e) {
			// Use the loopback as a default
			hostip[0] = 127;
			hostip[1] = 0;
			hostip[2] = 0;
			hostip[3] = 1;
		}
		// this MAC is real, it's from Glenn's wireless card!
		int[] mac = { 0x00, 0x02, 0x8A, 0x4A, 0xFD, 0xAC };

		// to the the "fake" MAC address, munch this real MAC
		// with the host IP address as follows..
		for (int i = 0; i < mac.length; i++)
			mac[i] = (int) ((hostip[i % hostip.length] - mac[i]) * Math.random());

		String macString = "";
		for (int i = 0; i < mac.length; i++)
			macString = macString + format(mac[i]);
		// macString is now mac.length*3 bytes or 18bytes long!

		String root = rootOid;
		String suffix = macString + "." + System.currentTimeMillis() + "." + sequence;
		int maxSuffix = maxLength - 9; // allow room for "urn:UUID:"
		maxSuffix = maxSuffix - root.length() - 1; // adjust for root oid length
		if (maxSuffix < 0)
			maxSuffix = 0;
		if (suffix.length() > maxSuffix)
			suffix = suffix.substring(0, maxSuffix);

		String result = root + "." + suffix;

		if (result.charAt(result.length() - 1) == '.') {
			result = result.substring(0, result.length() - 1);
		}

		return result.replaceAll("[.]0", ".1");
	}

	/**
	 * Returns the byte as a three character String, with any leader zeros added. Negative values are made positive. Range: 0-127
	 * 
	 * @param b
	 * @return
	 */
	// private static String format(byte b)
	// {
	// StringBuffer sb= new StringBuffer();
	// if (b < 0) b = (byte)(b * -1);
	// if ( b < 10 ) {
	// sb.append("00");
	// }
	// else if ( b < 100)
	// {
	// sb.append('0');
	// }
	// sb.append(b);
	// return sb.toString();
	// }

	public static void main(String argv[]) {

		System.out.println("         1         2         3         4         5         6   x");
		System.out.println("123456789_123456789_123456789_123456789_123456789_123456789_123456789_123456789_");
		for (int i = 0; i < 15; i++)
			System.out.println(OID.createOID(null));
		System.out.println();

		System.out.println("123456789_123456789_123456789_123456789_123456789_123456789_123456789_123456789_");
		for (int i = 0; i < 15; i++)
			System.out.println(OID.createOIDGivenRoot("2.16.840.1.113883.3.18", 36));

	}

	/**
	 * Returns a String of lenght 3, with the value of i between 0 and 255, and 0 prefixed if needed. negative i's are made positive. i's > 255
	 * are reduced to 255. range: 0-255
	 * 
	 * @param i
	 * @return
	 */
	private static String format(int i) {
		i = Math.abs(i);
		StringBuffer sb = new StringBuffer(3);
		if (i < 10)
			sb.append("0");
		if (i < 100)
			sb.append("0");
		sb.append(i);

		return sb.toString();

	}

}
