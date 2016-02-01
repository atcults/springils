package org.sanelib.ils.core.activities.accessionSeries;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.accessioSeries.DeleteAccessionSeries;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
import org.sanelib.ils.core.domain.entity.AccessionSeriesCode;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteAccessionSeriesProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteAccessionSeriesProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        AccessionSeries accessionSeries = new AccessionSeries();

        accessionSeries.setAccessionSeriesCode("AS1", library.getId());
        accessionSeries.setMaxNumber(100);

        persist(accessionSeries);

        DeleteAccessionSeries deleteAccessionSeries = new DeleteAccessionSeries();

        deleteAccessionSeries.setCode(accessionSeries.getAccessionSeriesCode().getCode());
        deleteAccessionSeries.setLibraryId(library.getId());

        String result = execute(deleteAccessionSeries, ActivitiProcessConstants.Admin.DELETE_ACCESSIONSERIES);

        assertNull(result);

        AccessionSeries dbAccessionSeries = fetch(AccessionSeries.class,
                new AccessionSeriesCode(library.getId(),accessionSeries.getAccessionSeriesCode().getCode() ));

        assertNull(dbAccessionSeries);
    }
}
