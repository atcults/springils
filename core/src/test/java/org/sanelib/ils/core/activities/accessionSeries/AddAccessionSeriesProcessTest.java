package org.sanelib.ils.core.activities.accessionSeries;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.accessioSeries.AddAccessionSeries;
import org.sanelib.ils.core.dao.AccessionSeriesRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
import org.sanelib.ils.core.domain.entity.AccessionSeriesCode;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.enums.AccessionSeriesType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddAccessionSeriesProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    AccessionSeriesRepository accessionSeriesRepository;

    @Test
    public void testAddAccessionSeriesProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        AddAccessionSeries addAccessionSeries = new AddAccessionSeries();

        addAccessionSeries.setLibraryId(library.getId());
        addAccessionSeries.setCode("AS1");
        addAccessionSeries.setMaxNumber(100);
        addAccessionSeries.setMaxZero(2);
        addAccessionSeries.setPrefix("AS");

        AccessionSeriesType accessionSeriesType = AccessionSeriesType.getByName("Fixed");
        addAccessionSeries.setTypeName(accessionSeriesType);

        addAccessionSeries.setUserCode("1");

        String result = execute(addAccessionSeries, ActivitiProcessConstants.Admin.ADD_ACCESSION_SERIES);

        assertNotNull(result);

        AccessionSeries accessionSeries = fetch(AccessionSeries.class, new AccessionSeriesCode(library.getId(), result));

        assertNotNull(accessionSeries);

        assertEquals(addAccessionSeries.getCode() , accessionSeries.getAccessionSeriesCode().getCode());
        assertEquals(addAccessionSeries.getMaxNumber(), accessionSeries.getMaxNumber());
        assertEquals(addAccessionSeries.getMaxZero(), accessionSeries.getMaxZero());
        assertEquals(addAccessionSeries.getPrefix(), accessionSeries.getPrefix());
        assertEquals(addAccessionSeries.getTypeName(), accessionSeries.getTypeName());
        assertEquals(addAccessionSeries.getUserCode(), accessionSeries.getUserCode());
    }
}
