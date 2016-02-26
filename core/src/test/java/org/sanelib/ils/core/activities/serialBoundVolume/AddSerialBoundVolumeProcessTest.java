package org.sanelib.ils.core.activities.serialBoundVolume;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.serialBoundVolume.AddSerialBoundVolume;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;
import org.sanelib.ils.core.domain.entity.SerialBoundVolumeId;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddSerialBoundVolumeProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void testAddSerialBoundVolumeProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        AddSerialBoundVolume addSerialBoundVolume = new AddSerialBoundVolume();

        addSerialBoundVolume.setLibraryId(library.getId());
        addSerialBoundVolume.setName("name");
        addSerialBoundVolume.setColor("Color");
        addSerialBoundVolume.setPrice(10.10);

        String result = execute(addSerialBoundVolume, ActivitiProcessConstants.Admin.ADD_SERIALBOUNDVOLUME);

        assertNotNull(result);

        SerialBoundVolume serialBoundVolume = fetch(SerialBoundVolume.class, new SerialBoundVolumeId(library.getId(), Integer.parseInt(result)));

        assertNotNull(serialBoundVolume);

        assertEquals(addSerialBoundVolume.getName() ,serialBoundVolume.getName());
        assertEquals(addSerialBoundVolume.getColor() ,serialBoundVolume.getColor());
        assertEquals(addSerialBoundVolume.getPrice() ,serialBoundVolume.getPrice());
    }
}
