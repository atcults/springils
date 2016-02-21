package org.sanelib.ils.core.domain.entity;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.enums.DurationType;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CirculationMatrixPersistTest extends EntityIntegrationTestBase {

    @Test
    public void testRecordPersist() throws Throwable {

        CirculationMatrix inputRule = new CirculationMatrix();
        inputRule.setCirculationMatrixId(3, 1, 1, new Date());
        inputRule.setOverAllLoanLimit(10);
        inputRule.setFinePerDay(1.0);
        inputRule.setMaxCeilOnFine(200.0);
        inputRule.setAuditUserCode("1");
        inputRule.setRenewalLimit(2);
        inputRule.setRenewalThroughOPAC(true);
        inputRule.setLoanDurationType(DurationType.Fixed);
        inputRule.setLoanDuration(7);
        inputRule.setIncludeHolidaysInDateDue(false);
        inputRule.addFixedDateDue(10, 1);
        inputRule.addFixedDateDue(10, 5);

        inputRule.setChargeDurationType(DurationType.Days);
        inputRule.setIncludeHolidaysInCharges(true);
        inputRule.addChargeDetail(0, 7, 1.0);
        inputRule.addChargeDetail(7, 10, 2.0);

        persist(inputRule);

        CirculationMatrix persistedRule = fetch(CirculationMatrix.class, inputRule.getCirculationMatrixId());

        assertNotNull(persistedRule);

        assertEquals("Problem in mapping loan limit", inputRule.getOverAllLoanLimit(), persistedRule.getOverAllLoanLimit());
        assertEquals("Problem in mapping loan duration type", inputRule.getLoanDurationType(), persistedRule.getLoanDurationType());
        assertEquals("Problem in mapping loan duration", inputRule.getLoanDuration(), persistedRule.getLoanDuration());
        assertEquals("Problem in mapping Include Holidays in Date Due", inputRule.isIncludeHolidaysInDateDue(), persistedRule.isIncludeHolidaysInDateDue());
        assertEquals("Problem in mapping Fixed Dates", inputRule.getFixedDateDues().size(), persistedRule.getFixedDateDues().size());

        assertEquals("Problem in mapping charge duration type", inputRule.getChargeDurationType(), persistedRule.getChargeDurationType());
        assertEquals("Problem in mapping Include Holidays in Over Due", inputRule.isIncludeHolidaysInCharges(), persistedRule.isIncludeHolidaysInCharges());
        assertEquals("Problem in mapping Charges", inputRule.getChargeDetails().size(), persistedRule.getChargeDetails().size());
    }
}
