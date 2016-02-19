package org.sanelib.ils.core.activities.serialBoundVolume;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.serialBoundVolume.DeleteSerialBoundVolume;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;
import org.sanelib.ils.core.domain.entity.SerialBoundVolumeId;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteSerialBoundVolumeProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteSerialBoundVolumeProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        SerialBoundVolume serialBoundVolume = new SerialBoundVolume();

        serialBoundVolume.setSerialBoundVolumeId(hibernateHelper.getNextId(SerialBoundVolume.class, "serialBoundVolumeId.id"), library.getId());
        serialBoundVolume.setName("serialBoundVolume");
        serialBoundVolume.setColor("Color");
        serialBoundVolume.setPrice(10.10);
        serialBoundVolume.setEntryId("EntryId");

        persist(serialBoundVolume);

        DeleteSerialBoundVolume deleteSerialBoundVolume = new DeleteSerialBoundVolume();

        deleteSerialBoundVolume.setId(serialBoundVolume.getSerialBoundVolumeId().getId());
        deleteSerialBoundVolume.setLibraryId(library.getId());

        String result = execute(deleteSerialBoundVolume, ActivitiProcessConstants.Admin.DELETE_SERIALBOUNDVOLUME);

        assertNull(result);

        SerialBoundVolume dbSerialBoundVolume = fetch(SerialBoundVolume.class, new SerialBoundVolumeId(library.getId(), serialBoundVolume.getSerialBoundVolumeId().getId()));

        assertNull(dbSerialBoundVolume);
    }
}
