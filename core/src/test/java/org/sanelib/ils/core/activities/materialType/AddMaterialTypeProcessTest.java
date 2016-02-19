package org.sanelib.ils.core.activities.materialType;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.materialType.AddMaterialType;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.MaterialTypeRepository;
import org.sanelib.ils.core.domain.entity.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddMaterialTypeProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    MaterialTypeRepository materialTypeRepository;

    @Test
    public void testAddMaterialTypeProcess() throws Throwable{
        AddMaterialType addMaterialType = new AddMaterialType();

        addMaterialType.setMaterialType("MicroForm");

        String result = execute(addMaterialType, ActivitiProcessConstants.Admin.ADD_MATERILTYPE);

        Integer materialTypeId = Integer.parseInt(result);

        MaterialType materialType = fetch(MaterialType.class, materialTypeId);

        assertNotNull(materialType);

        assertEquals(addMaterialType.getMaterialType() ,materialType.getMaterialType());
    }
}
