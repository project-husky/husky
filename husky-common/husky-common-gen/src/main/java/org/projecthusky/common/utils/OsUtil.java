package org.projecthusky.common.utils;

/**
 * Helper methods for the Husky for operating system
 */
public class OsUtil {

	private static final String PROPERTY_OS_NAME = "os.name";

	private OsUtil() {
		throw new IllegalStateException("This is a utility class");
	}

	/**
	 * Detects whether the current platform is Mac.
	 *
	 * @return true for Mac platforms; false otherwise
	 */
	public static boolean isMac() {
		return System.getProperty(PROPERTY_OS_NAME).toLowerCase().contains("mac");
	}

	/**
	 * Detects whether the current platform is Solaris.
	 *
	 * @return true for Solaris platforms; false otherwise
	 */
	public static boolean isSolaris() {
		return System.getProperty(PROPERTY_OS_NAME).toLowerCase().contains("sunos");
	}

	/**
	 * Detects whether the current platform is Unix.
	 *
	 * @return true for Unix platforms; false otherwise
	 */
	public static boolean isUnix() {
		return System.getProperty(PROPERTY_OS_NAME).toLowerCase().contains("nix")
				|| System.getProperty(PROPERTY_OS_NAME).toLowerCase().contains("nux")
				|| System.getProperty(PROPERTY_OS_NAME).toLowerCase().contains("aix");
	}

	/**
	 * Detects whether the current platform is Windows.
	 *
	 * @return true for Windows platforms; false otherwise
	 */
	public static boolean isWindows() {
		return System.getProperty(PROPERTY_OS_NAME).toLowerCase().contains("win");
	}

}
