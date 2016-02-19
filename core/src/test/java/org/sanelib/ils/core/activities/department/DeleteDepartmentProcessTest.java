package org.sanelib.ils.core.activities.department;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.department.DeleteDepartment;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Department;
import org.sanelib.ils.core.domain.entity.DepartmentId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeleteDepartmentProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeleteDepartmentProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Department department = new Department();

        department.setDepartmentId(hibernateHelper.getNextId(Department.class, "departmentId.id"), library.getId());
        department.setDeptName("department");

        persist(department);

        DeleteDepartment deleteDepartment = new DeleteDepartment();

        deleteDepartment.setId(department.getDepartmentId().getId());
        deleteDepartment.setLibraryId(library.getId());

        String result = execute(deleteDepartment, ActivitiProcessConstants.Admin.DELETE_DEPARTMENT);

        assertNull(result);

        Department dbDept = fetch(Department.class, new DepartmentId(library.getId(), department.getDepartmentId().getId()));

        assertNull(dbDept);
    }
}
