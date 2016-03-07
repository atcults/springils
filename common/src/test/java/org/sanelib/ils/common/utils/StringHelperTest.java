package org.sanelib.ils.common.utils;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringHelperTest {

    @Test
    public void testStringHelper() {
        String phoneNumber = "+91-9876543210";
        String convertedPhoneNumber = "919876543210";

        assertEquals(convertedPhoneNumber, StringHelper.convertPhoneNumber(phoneNumber));
        assertEquals(phoneNumber, StringHelper.toOriginalString(convertedPhoneNumber));
      }
}
