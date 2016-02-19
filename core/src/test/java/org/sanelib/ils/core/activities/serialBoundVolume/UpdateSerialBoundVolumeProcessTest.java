package org.sanelib.ils.core.activities.serialBoundVolume;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.serialBoundVolume.UpdateSerialBoundVolume;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;
import org.sanelib.ils.core.domain.entity.SerialBoundVolumeId;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UpdateSerialBoundVolumeProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateSerialBoundVolumeProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        SerialBoundVolume serialBoundVolume = new SerialBoundVolume();

        serialBoundVolume.setSerialBoundVolumeId(hibernateHelper.getNextId(SerialBoundVolume.class, "serialBoundVolumeId.id"), library.getId());
        serialBoundVolume.setName("name");
        serialBoundVolume.setColor("Color");
        serialBoundVolume.setPrice(10.10);

        persist(serialBoundVolume);

        UpdateSerialBoundVolume updateSerialBoundVolume = new UpdateSerialBoundVolume();

        updateSerialBoundVolume.setId(serialBoundVolume.getSerialBoundVolumeId().getId());
        updateSerialBoundVolume.setLibraryId(library.getId());
        updateSerialBoundVolume.setName("Updated serialBoundVolume");
        updateSerialBoundVolume.setColor("Updated Color");
        updateSerialBoundVolume.setPrice(10.10);

        String result = execute(updateSerialBoundVolume, ActivitiProcessConstants.Admin.UPDATE_SERIALBOUNDVOLUME);

        assertNull(result);

        SerialBoundVolume dbSerialBoundVolume = fetch(SerialBoundVolume.class, new SerialBoundVolumeId(library.getId(), serialBoundVolume.getSerialBoundVolumeId().getId()));

        assertNotNull(dbSerialBoundVolume);

        assertEquals(updateSerialBoundVolume.getName(), dbSerialBoundVolume.getName());
        assertEquals(updateSerialBoundVolume.getColor(), dbSerialBoundVolume.getColor());
        assertEquals(updateSerialBoundVolume.getPrice(), dbSerialBoundVolume.getPrice());
    }
}
