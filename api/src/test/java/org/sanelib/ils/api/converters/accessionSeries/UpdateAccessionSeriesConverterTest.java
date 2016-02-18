package org.sanelib.ils.api.converters.accessionSeries;

import org.junit.Test;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.accessioSeries.UpdateAccessionSeries;
import org.sanelib.ils.core.enums.AccessionSeriesType;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UpdateAccessionSeriesConverterTest {

    @Test
    public void testUpdateAgencySuccessExecute() throws Exception{

        AccessionSeriesDto dto = new AccessionSeriesDto();

        dto.setCode("AS2");
        dto.setLibraryId("1");
        dto.setMaxNumber("100");
        dto.setMaxZero("2");
        dto.setPrefix("AS");
        dto.setTypeName(AccessionSeriesType.Fixed);

        ProcessError processError = new ProcessError();

        UpdateAccessionSeriesConverter updateAccessionSeriesConverter = new UpdateAccessionSeriesConverter();
        ProcessCommand command = updateAccessionSeriesConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof UpdateAccessionSeries);

        UpdateAccessionSeries updateAccessionSeries = (UpdateAccessionSeries) command;

        assertEquals("Code is not mapped", dto.getCode(), updateAccessionSeries.getCode());
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(updateAccessionSeries.getLibraryId()));
        assertEquals("Max Number of series not mapped",dto.getMaxNumber(),  String.valueOf(updateAccessionSeries.getMaxNumber()));
        assertEquals("Max Zero of series not mapped",dto.getMaxZero(),  String.valueOf(updateAccessionSeries.getMaxZero()));
        assertEquals("Prefix of series not mapped",dto.getPrefix(),  updateAccessionSeries.getPrefix());
        assertEquals("Series Type not mapped",dto.getTypeName(),  updateAccessionSeries.getTypeName());
    }
}
