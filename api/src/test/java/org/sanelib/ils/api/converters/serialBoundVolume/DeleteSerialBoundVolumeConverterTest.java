package org.sanelib.ils.api.converters.serialBoundVolume;


import org.junit.Test;
import org.sanelib.ils.api.dto.serialBoundVolume.SerialBoundVolumeDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.serialBoundVolume.DeleteSerialBoundVolume;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteSerialBoundVolumeConverterTest {

    @Test
    public void testDeleteSerialBoundVolumeSuccessExecute() throws Exception{

        SerialBoundVolumeDto dto = new SerialBoundVolumeDto();

        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError= new ProcessError();

        DeleteSerialBoundVolumeConverter converter = new DeleteSerialBoundVolumeConverter();
        ProcessCommand command = converter.convert(dto , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteSerialBoundVolume);

        DeleteSerialBoundVolume deleteSerialBoundVolume = (DeleteSerialBoundVolume) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteSerialBoundVolume.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteSerialBoundVolume.getLibraryId()));
    }

}
