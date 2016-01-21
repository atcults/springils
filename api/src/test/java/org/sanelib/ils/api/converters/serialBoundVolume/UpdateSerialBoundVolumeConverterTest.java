package org.sanelib.ils.api.converters.serialBoundVolume;


import org.junit.Test;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.serialBoundVolume.UpdateSerialBoundVolume;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateSerialBoundVolumeConverterTest {

    @Test
    public void testUpdateSerialBoundVolumeSuccessExecute() throws Exception{
        SerialBoundVolumeDto dto = new SerialBoundVolumeDto();

        dto.setId("1");
        dto.setLibraryId("1");
        dto.setName("SerialBoundVolume");
        dto.setColor("Color");
        dto.setPrice("10.10");
        dto.setEntryId("EntryId");
        dto.setEntryDate("2015/11/11");

        ProcessError processError = new ProcessError();

        UpdateSerialBoundVolumeConverter updateSerialBoundVolumeConverter = new UpdateSerialBoundVolumeConverter();
        ProcessCommand command = updateSerialBoundVolumeConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateSerialBoundVolume);

        UpdateSerialBoundVolume updateSerialBoundVolume = (UpdateSerialBoundVolume) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(updateSerialBoundVolume.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updateSerialBoundVolume.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), updateSerialBoundVolume.getName());
        assertEquals("Color is not mapped", dto.getColor(), updateSerialBoundVolume.getColor());
        assertEquals("Price is not mapped", Double.valueOf(dto.getPrice()), updateSerialBoundVolume.getPrice());
        assertEquals("Entry Id is not mapped", dto.getEntryId(), updateSerialBoundVolume.getEntryId());
        assertEquals("Entry Date is not mapped", DateHelper.fromDateString(dto.getEntryDate()), updateSerialBoundVolume.getEntryDate());
    }

}
