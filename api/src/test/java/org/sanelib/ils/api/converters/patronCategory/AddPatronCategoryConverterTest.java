package org.sanelib.ils.api.converters.patronCategory;

import org.junit.Test;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
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
        dto.setName("PCName");
        dto.setAllowILLFromNet(true);
        dto.setAllowRenewalFromNet(true);
        dto.setOverallLoanLimit("2");
        dto.setAllowMultipleCopies(true);
        dto.setAcqWorkflow("AcqWorkflow");

        ProcessError processError = new ProcessError();

        AddPatronCategoryConverter addPatronCategoryConverter = new AddPatronCategoryConverter();
        ProcessCommand command = addPatronCategoryConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddPatronCategory);

        AddPatronCategory addPatronCategory = (AddPatronCategory) command;
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addPatronCategory.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), addPatronCategory.getName());
        assertEquals("Ill Thru Net not Mapped ", dto.isAllowILLFromNet(), addPatronCategory.isAllowILLFromNet());
        assertEquals("Renewal Thru Net not Mapped ", dto.isAllowRenewalFromNet(), addPatronCategory.isAllowRenewalFromNet());
        assertEquals("Overall Loan limit not Mapped ", dto.getOverallLoanLimit(), String.valueOf(addPatronCategory.getOverallLoanLimit()));
        assertEquals("Allow Multiple Copies not Mapped ", dto.isAllowMultipleCopies(), addPatronCategory.isAllowILLFromNet());
        assertEquals("Acq Workflow not Mapped ", dto.getAcqWorkflow(),addPatronCategory.getAcqWorkflow());
    }
}
