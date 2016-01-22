package org.sanelib.ils.api.converters.binderOrder;


import org.junit.Test;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binderOrder.UpdateBinderOrder;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateBinderOrderConverterTest {

    @Test
    public void testUpdateBinderOrderSuccessExecute() throws Exception{
        BinderOrderDto dto = new BinderOrderDto();

        dto.setId("1");
        dto.setLibraryId("1");
        dto.setBinderId("101");
        dto.setOrderDate("2015/11/10");
        dto.setDueDate("2015/11/25");
        dto.setReturnedDate("2015/11/24");
        dto.setFormLetterNo("FormLetterNumber");
        dto.setSubject("Subject");
        dto.setContent("Content");
        dto.setMailStatus("M");
        dto.setPrintStatus("P");
        dto.setStatus("SetStatus");
        dto.setEntryId("EntryId");
        dto.setEntryDate("2015/11/10");

        ProcessError processError = new ProcessError();

        UpdateBinderOrderConverter updateBinderOrderConverter = new UpdateBinderOrderConverter();
        ProcessCommand command = updateBinderOrderConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateBinderOrder);

        UpdateBinderOrder updateBinderOrder = (UpdateBinderOrder) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateBinderOrder.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updateBinderOrder.getLibraryId()));
        assertEquals("Binder Id is not mapped", dto.getBinderId(), String.valueOf(updateBinderOrder.getBinderId()));
        assertEquals("Order Date is not mapped", DateHelper.fromDateString(dto.getOrderDate()), updateBinderOrder.getOrderDate());
        assertEquals("Due Date is not mapped", DateHelper.fromDateString(dto.getDueDate()), updateBinderOrder.getDueDate());
        assertEquals("Returned Date is not mapped", DateHelper.fromDateString(dto.getReturnedDate()), updateBinderOrder.getReturnedDate());
        assertEquals("Form Letter Number is not mapped", dto.getFormLetterNo(), updateBinderOrder.getFormLetterNo());
        assertEquals("Subject is not mapped", dto.getSubject(), updateBinderOrder.getSubject());
        assertEquals("Mail Status is not mapped", dto.getMailStatus(), updateBinderOrder.getMailStatus());
        assertEquals("Print Status is not mapped", dto.getPrintStatus(), updateBinderOrder.getPrintStatus());
        assertEquals("Status is not mapped", dto.getStatus(), updateBinderOrder.getStatus());
        assertEquals("Entry Id is not mapped", dto.getEntryId(), updateBinderOrder.getEntryId());
        assertEquals("Entry Date is not mapped", DateHelper.fromDateString(dto.getEntryDate()), updateBinderOrder.getEntryDate());
    }

}
