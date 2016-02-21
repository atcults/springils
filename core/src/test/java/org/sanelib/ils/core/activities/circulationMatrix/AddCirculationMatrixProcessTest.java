package org.sanelib.ils.core.activities.circulationMatrix;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.enums.LoanDurationType;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddCirculationMatrixProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testAddPublisherProcess() throws Throwable {


        CirculationMatrix inputRule = new CirculationMatrix();
        inputRule.setCirculationMatrixId(3, 1, 1, new Date());
        inputRule.setOverAllLoanLimit(10);
        inputRule.setFinePerDay(1.0);
        inputRule.setMaxCeilOnFine(200.0);
        inputRule.setAuditUserCode("1");
        inputRule.setRenewalLimit(2);
        inputRule.setRenewalThroughOPAC(true);
        inputRule.setLoanDurationType(LoanDurationType.Days);

        persist(inputRule);

        CirculationMatrix persistedRule = fetch(CirculationMatrix.class, inputRule.getCirculationMatrixId());

        assertNotNull(persistedRule);

        assertEquals("Problem in mapping loan limit", inputRule.getOverAllLoanLimit(), persistedRule.getOverAllLoanLimit());
        assertEquals("Problem in mapping duration type", inputRule.getLoanDurationType(), persistedRule.getLoanDurationType());
    }
}
