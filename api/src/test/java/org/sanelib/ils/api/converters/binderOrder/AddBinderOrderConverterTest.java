package org.sanelib.ils.api.converters.binderOrder;

import org.junit.Test;
import org.sanelib.ils.api.dto.binderOrder.BinderOrderDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binderOrder.AddBinderOrder;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddBinderOrderConverterTest {

    @Test
    public void testAddBinderOrderSuccessExecute() throws Exception{
        BinderOrderDto dto = new BinderOrderDto();

        dto.setLibraryId("1");
        dto.setBinderId("101");
        dto.setOrderDate("2015/11/10");
        dto.setDueDate("2015/11/25");
        dto.setReturnedDate("2015/11/24");
        dto.setFormLetterNo("FormLetterNumber");
        dto.setSubject("Subject");
        dto.setContent("Content");
        dto.setMailStatus(true);
        dto.setPrintStatus(true);
        dto.setStatus("SetStatus");

        ProcessError processError = new ProcessError();

        AddBinderOrderConverter addBinderOrderConverter = new AddBinderOrderConverter();
        ProcessCommand command = addBinderOrderConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddBinderOrder);

        AddBinderOrder addBinderOrder = (AddBinderOrder) command;

        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addBinderOrder.getLibraryId()));
        assertEquals("Binder Id is not mapped", dto.getBinderId(), String.valueOf(addBinderOrder.getBinderId()));
        assertEquals("Order Date is not mapped", DateHelper.fromDateString(dto.getOrderDate()), addBinderOrder.getOrderDate());
        assertEquals("Due Date is not mapped", DateHelper.fromDateString(dto.getDueDate()), addBinderOrder.getDueDate());
        assertEquals("Returned Date is not mapped", DateHelper.fromDateString(dto.getReturnedDate()), addBinderOrder.getReturnedDate());
        assertEquals("Form Letter Number is not mapped", dto.getFormLetterNo(), addBinderOrder.getFormLetterNo());
        assertEquals("Subject is not mapped", dto.getSubject(), addBinderOrder.getSubject());
        assertEquals("Mail Status is not mapped", dto.isMailStatus(), addBinderOrder.isMailStatus());
        assertEquals("Print Status is not mapped", dto.isPrintStatus(), addBinderOrder.isPrintStatus());
        assertEquals("Status is not mapped", dto.getStatus(), addBinderOrder.getStatus());
    }
}
