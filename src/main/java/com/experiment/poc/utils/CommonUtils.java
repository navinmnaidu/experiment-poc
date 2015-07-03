package com.experiment.poc.utils;

import static com.experiment.poc.utils.CommonConstants.EMPTY_STRING;

/**
 * Common utilities
 * @author Navin Naidu
 */
final public class CommonUtils {

	/**
	 * Is string null or empty
	 * @param str String
	 * @return  <code>true</code> if String is null or empty;
	 *			<code>false</code> otherwise.
	 */
	public static boolean isStringNullOrEmpty(String str) {
		return (str == null || EMPTY_STRING.equals(str.trim())) ? true : false;
	}
}
