package org.sanelib.ils.api.converters.patronCategory;


import org.junit.Test;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patronCategory.UpdatePatronCategory;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdatePatronCategoryConverterTest {

    @Test
    public void testUpdatePatronCategorySuccessExecute() throws Exception{
        PatronCategoryDto dto = new PatronCategoryDto();
        dto.setId("1");
        dto.setLibraryId("1");
        dto.setPatronCategoryName("PCName");
        dto.setIllThruNet("I");
        dto.setRenewalThruNet("R");
        dto.setEntryDate("2007/01/02");
        dto.setOverallLoanLimit("2");
        dto.setAllowMultipleCopies("M");
        dto.setAcqWorkflow("AcqWorkflow");

        ProcessError processError = new ProcessError();

        UpdatePatronCategoryConverter updatePatronCategoryConverter = new UpdatePatronCategoryConverter();
        ProcessCommand command = updatePatronCategoryConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdatePatronCategory);
        UpdatePatronCategory updatePatronCategory = (UpdatePatronCategory) command;
        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updatePatronCategory.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updatePatronCategory.getLibraryId()));
        assertEquals("Name is not mapped", dto.getPatronCategoryName(), updatePatronCategory.getPatronCategoryName());
        assertEquals("Ill Thru Net not Mapped ", dto.getIllThruNet(),updatePatronCategory.getIllThruNet());
        assertEquals("Renewal Thru Net not Mapped ", dto.getRenewalThruNet(),updatePatronCategory.getRenewalThruNet());
        assertEquals("Entry date not Mapped ", dto.getEntryDate(), DateHelper.toDateString(updatePatronCategory.getEntryDate()));
        assertEquals("Overall Loan limit not Mapped ", dto.getOverallLoanLimit(),String.valueOf(updatePatronCategory.getOverallLoanLimit()));
        assertEquals("Allow Multiple Copies not Mapped ", dto.getAllowMultipleCopies(),updatePatronCategory.getAllowMultipleCopies());
        assertEquals("Acq Workflow not Mapped ", dto.getAcqWorkflow(),updatePatronCategory.getAcqWorkflow());
    }

}
