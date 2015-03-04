package org.ehealth_connector.cda.tests;
import java.util.Random;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <div class="de">Erzeugt ein AllTests.java- Objekt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 */

/**
 * @author hodi
 * Test 
 */
@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {


	public static String generateString(int length)
	{
		Random rng = new Random();
		String characters = "abcëÙdÀÿeŒfúgËÛùhijàÊkÇlŸmœÏçÚnÔÈoæûèp»ÙÈqùôêîïÆrsâÉtéÎuvwèxylïäüìöÄÏÒÜÂÖÌ?ßÓ/òó:#\\íÍ~*É'é,´Àà";

		char[] text = new char[length];
		for (int i = 0; i < length; i++)
		{
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}
}
