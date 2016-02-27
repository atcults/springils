package org.sanelib.ils.common.utils;

public class StringHelper {
    public static String convertPhoneNumber(String phoneNumber){

        phoneNumber = phoneNumber.replaceAll("[\\D]", "");

        return phoneNumber;
    }

    public static String toOriginalString(String phoneNo){

        phoneNo = phoneNo.replaceFirst("(\\d{2})(\\d+)", "+$1-$2");

        return phoneNo;
    }
}
