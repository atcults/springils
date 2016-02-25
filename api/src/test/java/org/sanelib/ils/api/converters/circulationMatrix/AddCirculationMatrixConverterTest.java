package org.sanelib.ils.api.converters.circulationMatrix;

import org.junit.Test;
import org.sanelib.ils.api.dto.circulationMatrix.CirculationMatrixDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.enums.DurationType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddCirculationMatrixConverterTest {

    @Test
    public void testAddCirculationMatrixSuccessExecute() throws Exception {

        CirculationMatrixDto dto = new CirculationMatrixDto();

        dto.setLibraryId("1");
        dto.setPatronCategoryId("1");
        dto.setMaterialTypeId("1");
        dto.setWithEffectFrom("2016-02-02");
        dto.setRenewalThroughOPAC(true);
        dto.setLoanDurationType(DurationType.Days);
        dto.setLoanDuration("2");
        dto.setLoanDurationType(DurationType.Fixed);
        dto.addFixedDateDue("2", "2");
        dto.setIncludeHolidaysInDateDue(true);
        dto.setOverAllLoanLimit("2");
        dto.setRenewalLimit("2");
        dto.setFinePerDay("2");
        dto.setMaxFine("2");
        dto.setChargeDurationType(DurationType.Fixed);
        dto.addChargeDetail("2", "2", "2.2");
        dto.setIncludeHolidaysInCharges(true);

        ProcessError processError = new ProcessError();

        AddCirculationMatrixConverter addCirculationMatrixConverter = new AddCirculationMatrixConverter();

        ProcessCommand command = addCirculationMatrixConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output" + command, command instanceof AddCirculationMatrix);

        AddCirculationMatrix addCirculationMatrix = (AddCirculationMatrix) command;

        assertEquals("Library Id is not mapped", dto.getLibraryId(), String .valueOf(addCirculationMatrix.getLibraryId()));
        assertEquals("Patron Category Id is not mapped", dto.getPatronCategoryId(), String .valueOf(addCirculationMatrix.getPatronCategoryId()));
        assertEquals("Material Type Id is not mapped", dto.getMaterialTypeId(), String .valueOf(addCirculationMatrix.getMaterialTypeId()));
        assertEquals("Date With Effect From is not mapped", dto.getWithEffectFrom(), String .valueOf(addCirculationMatrix.getWithEffectFrom()));
        assertEquals("Renewal Through OPAC is not mapped", dto.getRenewalThroughOPAC(), addCirculationMatrix.getRenewalThroughOPAC());
        assertEquals("Loan Duration Type is not mapped", dto.getLoanDurationType(), addCirculationMatrix.getLoanDurationType());
        assertEquals("Loan Duration is not mapped", dto.getLoanDuration(), String .valueOf(addCirculationMatrix.getLoanDuration()));
        assertEquals("Fixed Dates Due are not mapped", dto.getFixedDateDues(), addCirculationMatrix.getFixedDateDues());
        assertEquals("Include Holiday in Date Due is not mapped", dto.isIncludeHolidaysInDateDue(), addCirculationMatrix.isIncludeHolidaysInDateDue());
        assertEquals("Charge Duration Type is not mapped", dto.getChargeDurationType(), addCirculationMatrix.getChargeDurationType());
        assertEquals("Charge Details are not mapped", dto.getChargeDetails(), addCirculationMatrix.getChargeDetails());
        assertEquals("Include Holiday in Charges is not mapped", dto.isIncludeHolidaysInCharges(), addCirculationMatrix.isIncludeHolidaysInCharges());
    }

}
