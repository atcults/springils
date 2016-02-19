package org.sanelib.ils.api.converters.serialBoundVolume;

import org.junit.Test;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.serialBoundVolume.AddSerialBoundVolume;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddSerialBoundVolumeConverterTest {

    @Test
    public void testAddSerialBoundVolumeSuccessExecute() throws Exception{
        SerialBoundVolumeDto dto = new SerialBoundVolumeDto();

        dto.setLibraryId("1");
        dto.setName("SerialBoundVolume");
        dto.setColor("Color");
        dto.setPrice("10.10");
        dto.setEntryId("EntryId");

        ProcessError processError = new ProcessError();

        AddSerialBoundVolumeConverter addSerialBoundVolumeConverter = new AddSerialBoundVolumeConverter();
        ProcessCommand command = addSerialBoundVolumeConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddSerialBoundVolume);

        AddSerialBoundVolume addSerialBoundVolume = (AddSerialBoundVolume) command;

        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addSerialBoundVolume.getLibraryId()));
        assertEquals("Name is not mapped", dto.getName(), addSerialBoundVolume.getName());
        assertEquals("Color is not mapped", dto.getColor(), addSerialBoundVolume.getColor());
        assertEquals("Price is not mapped", Double.valueOf(dto.getPrice()), addSerialBoundVolume.getPrice());
        assertEquals("Entry Id is not mapped", dto.getEntryId(), addSerialBoundVolume.getEntryId());
    }
}
