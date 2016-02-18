package org.sanelib.ils.core.activities.department;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.department.UpdateDepartment;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Department;
import org.sanelib.ils.core.domain.entity.DepartmentId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UpdateDepartmentProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateDepartmentProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Department department = new Department();

        department.setDepartmentId(hibernateHelper.getNextId(Department.class, "departmentId.id"), library.getId());
        department.setDeptName("department");
        department.setHodId("1");

        persist(department);

        UpdateDepartment updateDepartment = new UpdateDepartment();

        updateDepartment.setId(department.getDepartmentId().getId());
        updateDepartment.setLibraryId(library.getId());
        updateDepartment.setDeptName("updated department");
        updateDepartment.setHodId("2");

        String result = execute(updateDepartment, ActivitiProcessConstants.Admin.UPDATE_DEPARTMENT);

        assertNull(result);

        Department dbDept = fetch(Department.class, new DepartmentId(library.getId(), department.getDepartmentId().getId()));

        assertNotNull(dbDept);

        assertEquals(updateDepartment.getDeptName(), dbDept.getDeptName());
        assertEquals(updateDepartment.getHodId(),dbDept.getHodId());
    }
}
