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
import org.sanelib.ils.core.domain.entity.Patron;
import org.sanelib.ils.core.enums.PatronType;
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

        Patron patron=new Patron();
        patron.setPatronCode("Pat1", library.getId());
        patron.setPatronType(PatronType.Patron);
        patron.setFirstName("First Name");
        persist(patron);

        AddDepartment addDepartment = new AddDepartment();

        addDepartment.setLibraryId(library.getId());
        addDepartment.setDeptName("COMPUTER");
        addDepartment.setHodId(patron.getPatronCode().getCode());
        addDepartment.setEntryId(patron.getPatronCode().getCode());

        String result = execute(addDepartment, ActivitiProcessConstants.Admin.ADD_DEPARTMENT);

        assertNotNull(result);

        Department department = fetch(Department.class, new DepartmentId(library.getId(), Integer.parseInt(result)));

        assertNotNull(department);

        assertEquals(addDepartment.getDeptName() ,department.getDeptName());
        assertEquals(addDepartment.getHodId(),department.getHodId());
    }
}
