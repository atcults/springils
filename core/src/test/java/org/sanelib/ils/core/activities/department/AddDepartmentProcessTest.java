package org.sanelib.ils.core.activities.department;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.department.AddDepartment;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Department;
import org.sanelib.ils.core.domain.entity.DepartmentId;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddDepartmentProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Test
    public void testAddDepartmentProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("Library");

        persist(library);

        //NOTE: persist patron as library for hodid and entryid and entry and date is remaining

        AddDepartment addDepartment = new AddDepartment();

        addDepartment.setLibraryId(library.getId());
        addDepartment.setDeptName("name");
        addDepartment.setHodId("1");

        String result = execute(addDepartment, ActivitiProcessConstants.Admin.ADD_DEPARTMENT);

        assertNotNull(result);

        Department department = fetch(Department.class, new DepartmentId(library.getId(), Integer.parseInt(result)));

        assertNotNull(department);

        assertEquals(addDepartment.getDeptName() ,department.getDeptName());
    }
}
