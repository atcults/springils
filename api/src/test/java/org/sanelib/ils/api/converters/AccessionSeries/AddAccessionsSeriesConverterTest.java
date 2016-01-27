package org.sanelib.ils.api.converters.accessionSeries;

import org.junit.Test;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.accessioSeries.AddAccessionSeries;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddAccessionSeriesConverterTest {

    @Test
    public void testAddAccessionSeriesSuccessExecute() throws Exception{
        AccessionSeriesDto dto = new AccessionSeriesDto();

        dto.setLibraryId("1");
        dto.setCode("AC1");
        dto.setMaxNumber("100");

        ProcessError processError = new ProcessError();

        AddAccessionSeriesConverter addAccessionSeriesConverter = new AddAccessionSeriesConverter();
        ProcessCommand command = addAccessionSeriesConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddAccessionSeries);

        AddAccessionSeries addAccessionSeries = (AddAccessionSeries) command;
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addAccessionSeries.getLibraryId()));
    }
}
