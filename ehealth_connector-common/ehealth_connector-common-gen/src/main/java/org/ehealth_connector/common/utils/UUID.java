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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;

/**
 * Generates a (mostly) ASN.1 complaint UUID. <br>Under Windows the MAC address of the machine is used, under Linux and other OS's a
 * randomly generated construct using the SHA-1 message digest is used. It is thus possible that UUIDs will not be completely unique under
 * non Windows platforms, but given the number of bits of random data used to generate the fake MAC addresses for non Windows machines, it
 * is very unlikely any collosions will every occur in practice.
 * 
 * @author Glenn Deen
 * @since IHII Phase 1
 */
public class UUID {

	/**
	 * Holds the time this alogorithm was last run
	 */
	private static long lastTimeCalled = 0;

	/**
	 *
	 */
	private static String MAC = null;

	/**
	 * Generates and returns a formatted UUID holding a 128 bit UUID in the form: AABBCCDDEEFF-GGHH-IIJJ-KKLLMMNNOOPP
	 *
	 * @return the generated uuid
	 */
	public static String generate() {
		StringBuffer uuid = new StringBuffer(32); // 16 bytes, 32 chars in hex
		uuid.replace(0, 31, "00000000000000000000000000000000");
		// breakdown is as follows"
		// 00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31 index
		// |31|30|29|28|27|26|25|24|23|22|21|20|19|18|17|16|15|14|13|12|11|10|09|08|07|06|05|04|03|02|01|00| char
		// | 15 | 14 | 13 | 12 | 11 | 10 | 9 | 8 | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 | octet (byte)
		// |---- time low ---------|-time mid -|-ver thigh-|vCLH | CLL |--------------- node --------------|

		// uuid[31..24] = Time Low
		// uuid[23..20] = Time Mid
		// uuid[19..16] = version and Time High
		// uuid[15..14] = varient and Clock Seq High
		// uuid[13..12] = Clock Sequence Low
		// uuid[11..0] = Node field

		long time = (new GregorianCalendar()).getTimeInMillis(); // 4 bytes

		while (time == lastTimeCalled) {
			// We are being called closely to the last time we were called.
			// Spin for a bit to move the clock ahead.
			long tmp = time;
			for (int i = 0; i < Math.random() * 10000; i++)
				tmp = tmp - i;
			time = (new GregorianCalendar()).getTimeInMillis();
		}

		UUID.lastTimeCalled = time;

		long timeLow = (time & 0x0FFFFFFF) * 10;
		long timeMid = ((time >> 16) & 0xFFFF) * 10;
		long timeHigh = ((time >> 24) & 0x0FFF) * 10;

		// System.out.println(Long.toHexString(timeLow)+"."+ Long.toHexString(timeMid) +"."+Long.toHexString(timeHigh));

		String hex = Long.toHexString(timeLow);
		int len = hex.length();
		if (len > 8)
			hex = hex.substring(len - 8, len);
		len = hex.length();
		uuid.replace(8 - len, 8, hex);

		hex = Long.toHexString(timeMid);
		len = hex.length();
		if (len > 4)
			hex = hex.substring(len - 4, len);
		len = hex.length();
		uuid.replace(12 - hex.length(), 12, hex);

		hex = Long.toHexString(timeHigh);
		len = hex.length();
		if (len > 4)
			hex = hex.substring(len - 4, len);
		len = hex.length();
		uuid.replace(16 - len, 16, hex);

		// set the UUID version - bits 7-4 of the 9th byte - index 12
		char c = uuid.charAt(12);

		long l = Character.getNumericValue(c) & 0x0F;
		l = l + 0x40;
		hex = Long.toHexString(l);
		len = hex.length();
		uuid.replace(12, 13, hex.substring(len - 1));

		// Clock Sequence
		// since we don't use a persistent store of time values used, generate a
		// random clock sequence
		long clockSequence = (long) (Math.random() * Math.pow(2, 14)) & 0x3FFF; // get to 14 bits of value

		hex = Long.toHexString(clockSequence);
		len = hex.length();
		if (len > 4)
			hex = hex.substring(len - 4, len);
		len = hex.length();
		uuid.replace(20 - len, 20, hex);

		// now set the variance bits - this is the
		c = uuid.charAt(16);
		l = Character.getNumericValue(c) & 0x3F ^ 0x80; // set the high bits 7 & 6 to 1 0
		uuid.replace(16, 17, hex.substring(len - 1));

		String MAC = UUID.getMAC();
		uuid.replace(20, 32, MAC);

		uuid.insert(20, '-');
		uuid.insert(16, '-');
		uuid.insert(12, '-');
		uuid.insert(8, '-');
		return uuid.toString();
	}

	/**
	 * Generate a new UUID prefixed by urn:uuid:
	 */
	public static String generateURN() {
		return "urn:uuid:" + UUID.generate();
	}

	/**
	 * Runs a simple test of the UUID class, generating a set of UUIDs
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 100;
		System.out.println("Generating " + count + " test URNs ...");
		long start = System.currentTimeMillis();
		for (int i = 0; i < count; i++)
			System.out.println(UUID.generateURN());
		long end = System.currentTimeMillis();
		System.out.println("Generated " + count + " URN's at rate of "
				+ Math.round((double) count / (double) (end - start) * 1000) + " per second");
	}

	private static String getMAC() {
		String osName = System.getProperty("os.name").toLowerCase();

		// if (MAC != null) return MAC;

		if (osName.indexOf("windows") != -1) {
			if (MAC == null) {
				Process proc = null;
				try {
					proc = Runtime.getRuntime().exec("ipconfig /all");

					BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
					String line;

					while ((line = br.readLine()) != null) {
						if (line.indexOf("Physical Address") != -1) {
							String split[] = line.toLowerCase().split(":");
							String rawMAC = split[1];
							String MACBytes[] = rawMAC.trim().split("-");
							MAC = "";
							for (int i = 0; i < 6; i++)
								MAC = MAC + MACBytes[i];
							// System.out.println("mac is"+MAC);
							return MAC;
						}
					}
				} catch (Exception e) {
					// if we got an exception for any reason, don't do anything
					// instead fall through to the generic algorithm using the SHA-1
					// digest
				}
			} else
				return MAC;

		}

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			Runtime rt = Runtime.getRuntime();
			long freeMemory = rt.freeMemory();
			long maxMemory = rt.maxMemory();
			long totalMemory = rt.totalMemory();
			File cwd = new File(".");
			String list[] = cwd.list();
			String seed = Long.toHexString(freeMemory + maxMemory + totalMemory);
			for (int i = 0; i < list.length; i++)
				seed = seed + list[i];
			md.update(seed.getBytes());
			byte[] digest = new byte[20];
			md.digest(digest, 0, 20);
			// for (int i = 0; i < digest.length; i++) {
			// String hex = Long.toHexString(digest[i]);
			// if (hex.length() > 2) hex = hex.substring(hex.length() - 2);
			// if (hex.length() < 2) hex = "0" + hex;
			// System.out.print(hex);
			// }
			MAC = "";
			for (int i = 0; i < 6; i++) {
				String hex = Long.toHexString(digest[i]);
				if (hex.length() > 2)
					hex = hex.substring(hex.length() - 2);
				if (hex.length() < 2)
					hex = "0" + hex;
				MAC = MAC + hex;
			}
			return MAC;

		} catch (NoSuchAlgorithmException e) {

			// If we get there, then the SHA-1 wasn't available, resort to
			// less fancy techniques...
		} catch (DigestException e) {
			// If we get there, then the SHA-1 digest gave some error
			// when doing its thing, resort to
			// less fancy techniques...
		}

		File cwd = new File(".");
		String list[] = cwd.list();
		Runtime rt = Runtime.getRuntime();
		long[] octet = new long[6];
		octet[0] = Math.round((double) rt.freeMemory() * Math.random() * 255.0 * list.length);
		octet[1] = Math.round((double) rt.maxMemory() * Math.random() * 128.0 * list.length);
		octet[2] = Math.round((double) rt.totalMemory() * Math.random() * 64.0);

		MAC = "";
		for (int i = 0; i < 3; i++) {
			String hex = Long.toHexString(octet[i]);
			MAC = MAC + hex.substring(hex.length() - 4);
		}
		return MAC;

	}

}
