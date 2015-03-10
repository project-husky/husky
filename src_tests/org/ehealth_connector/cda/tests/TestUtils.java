package org.ehealth_connector.cda.tests;
import java.util.Random;

public class TestUtils {


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
