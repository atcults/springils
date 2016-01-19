package org.sanelib.ils.api.converters.patronCategory;

import org.junit.Test;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patronCategory.AddPatronCategory;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddPatronCategoryConverterTest {

    @Test
    public void testAddPatronSuccessExecute() throws Exception{
        PatronCategoryDto dto = new PatronCategoryDto();

        dto.setLibraryId("1");
        dto.setPatronCategoryName("PCName");
        dto.setIllThruNet("I");
        dto.setRenewalThruNet("R");
        dto.setEntryDate("2007/01/02");
        dto.setOverallLoanLimit("2");
        dto.setAllowMultipleCopies("A");
        dto.setAcqWorkflow("AcqWorkflow");

        ProcessError processError = new ProcessError();

        AddPatronCategoryConverter addPatronCategoryConverter = new AddPatronCategoryConverter();
        ProcessCommand command = addPatronCategoryConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddPatronCategory);

        AddPatronCategory addPatronCategory = (AddPatronCategory) command;
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addPatronCategory.getLibraryId()));
        assertEquals("Name is not mapped", dto.getPatronCategoryName(), addPatronCategory.getPatronCategoryName());
        assertEquals("Ill Thru Net not Mapped ", dto.getIllThruNet(),addPatronCategory.getIllThruNet());
        assertEquals("Renewal Thru Net not Mapped ", dto.getRenewalThruNet(),addPatronCategory.getRenewalThruNet());
        assertEquals("Entry date not Mapped ", dto.getEntryDate(), DateHelper.toDateString(addPatronCategory.getEntryDate()));
        assertEquals("Overall Loan limit not Mapped ", dto.getOverallLoanLimit(),String.valueOf(addPatronCategory.getOverallLoanLimit()));
        assertEquals("Allow Multiple Copies not Mapped ", dto.getAllowMultipleCopies(),addPatronCategory.getAllowMultipleCopies());
        assertEquals("Acq Workflow not Mapped ", dto.getAcqWorkflow(),addPatronCategory.getAcqWorkflow());
    }
}
