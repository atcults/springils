package org.sanelib.ils.core.activities.materialType;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.materialType.DeleteMaterialType;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteMaterialTypeProcessTest extends EntityIntegrationTestBase{

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteMaterialType() throws Throwable{

        MaterialType materialType = new MaterialType();

        materialType.setId(7);
        materialType.setMaterialType("MicroForm");

        persist(materialType);

        DeleteMaterialType deleteMaterialType = new DeleteMaterialType();

        deleteMaterialType.setId(7);

        String result = execute(deleteMaterialType, ActivitiProcessConstants.Admin.DELETE_MATERIAL_TYPE);

        assertNull(result);

        MaterialType deletedEntity = fetch(MaterialType.class , deleteMaterialType.getId());

        assertNull(deletedEntity);
    }
}
