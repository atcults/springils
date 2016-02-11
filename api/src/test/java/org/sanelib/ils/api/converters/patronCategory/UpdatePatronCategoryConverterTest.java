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
        dto.setName("PCName");
        dto.setAllowILLFromNet(true);
        dto.setAllowRenewalFromNet(true);
        dto.setOverallLoanLimit("2");
        dto.setAllowMultipleCopies(true);
        dto.setAcqWorkflow("AcqWorkflow");

        ProcessError processError = new ProcessError();

        UpdatePatronCategoryConverter updatePatronCategoryConverter = new UpdatePatronCategoryConverter();
        ProcessCommand command = updatePatronCategoryConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdatePatronCategory);

        UpdatePatronCategory updatePatronCategory = (UpdatePatronCategory) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updatePatronCategory.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updatePatronCategory.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), updatePatronCategory.getName());
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updatePatronCategory.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), updatePatronCategory.getName());
        assertEquals("Ill Thru Net not Mapped ", dto.isAllowILLFromNet(), updatePatronCategory.isAllowILLFromNet());
        assertEquals("Renewal Thru Net not Mapped ", dto.isAllowRenewalFromNet(), updatePatronCategory.isAllowRenewalFromNet());
        assertEquals("Overall Loan limit not Mapped ", dto.getOverallLoanLimit(), String.valueOf(updatePatronCategory.getOverallLoanLimit()));
        assertEquals("Allow Multiple Copies not Mapped ", dto.isAllowMultipleCopies(), updatePatronCategory.isAllowILLFromNet());
        assertEquals("Acq Workflow not Mapped ", dto.getAcqWorkflow(),updatePatronCategory.getAcqWorkflow());
    }

}
