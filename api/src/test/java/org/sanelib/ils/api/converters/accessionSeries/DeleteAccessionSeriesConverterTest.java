package org.sanelib.ils.api.converters.accessionSeries;

import org.junit.Test;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.accessioSeries.DeleteAccessionSeries;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteAccessionSeriesConverterTest {
    @Test
    public void testDeleteAccessionSeriesSuccessExecute() throws Exception{

        AccessionSeriesDto dto = new AccessionSeriesDto();

        dto.setCode("AS1");
        dto.setLibraryId("1");

        ProcessError processError= new ProcessError();

        DeleteAccessionSeriesConverter converter = new DeleteAccessionSeriesConverter();
        ProcessCommand command = converter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteAccessionSeries);

        DeleteAccessionSeries deleteAccessionSeries = (DeleteAccessionSeries) command;

        assertEquals("Code is not mapped", dto.getCode(), deleteAccessionSeries.getCode());
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteAccessionSeries.getLibraryId()));
    }
}
