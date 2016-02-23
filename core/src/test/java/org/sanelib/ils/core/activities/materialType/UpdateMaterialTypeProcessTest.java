package org.sanelib.ils.core.activities.materialType;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.materialType.UpdateMaterialType;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.MaterialTypeRepository;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class UpdateMaterialTypeProcessTest extends EntityIntegrationTestBase{

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    MaterialTypeRepository materialTypeRepository;

    @Test
    public void testUpdateMaterialType() throws Throwable{

        MaterialType materialType = new MaterialType();

        materialType.setId(hibernateHelper.getNextId(MaterialType.class));
        materialType.setMaterialType("Boook");

        persist(materialType);

        UpdateMaterialType updateMaterialType = new UpdateMaterialType();

        updateMaterialType.setId(materialType.getId());
        updateMaterialType.setMaterialType("Book");

        String result = execute(updateMaterialType, ActivitiProcessConstants.Admin.UPDATE_MATERIALTYPE);

        assertNull(result);
    }
}
