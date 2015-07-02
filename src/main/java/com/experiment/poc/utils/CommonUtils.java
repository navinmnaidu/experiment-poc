package com.experiment.poc.utils;

import static com.experiment.poc.utils.CommonConstants.EMPTY_STRING;

final public class CommonUtils {

	public static boolean isStringNullOrEmpty(String str) {
		return (str == null || EMPTY_STRING.equals(str.trim())) ? true : false;
	}
}
