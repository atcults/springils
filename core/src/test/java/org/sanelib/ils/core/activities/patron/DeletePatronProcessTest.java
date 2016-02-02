package org.sanelib.ils.core.activities.patron;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.patron.DeletePatron;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.Patron;
import org.sanelib.ils.core.domain.entity.PatronCode;
import org.sanelib.ils.core.enums.PatronType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNull;

public class DeletePatronProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testDeletePatronProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Patron patron = new Patron();

        patron.setPatronCode("Pat1", library.getId());
        patron.setPatronCategoryId(1);
        patron.setIsOnline("Is Online");
        patron.setOwns("Owns");
        patron.setCreatedOn(DateHelper.constructDate(2014,5,2));
        patron.setOtherLibraryPatronId(1);
        patron.setLibraryPatronId(1);
        patron.setPatronType(PatronType.Patron);
        patron.setDeptId(1);
        patron.setFirstName("First Name");
        patron.setAddress1("Address1");
        patron.setAddress2("Address2");
        patron.setCity("City");
        patron.setState("State");
        patron.setCountry("Country");
        patron.setPin("387003");
        patron.setPhone1("+91-9876543210");
        patron.setPhone2("+91-9876543210");
        patron.setFax("+91-987654321");
        patron.setEmail("name@mail.com");
        patron.setPermanentAddress1("PAddress1");
        patron.setPermanentAddress2("PAddress2");
        patron.setPermanentCity("PCity");
        patron.setPermanentState("PState");
        patron.setPermanentCountry("PCountry");
        patron.setPermanentPin("PPin");
        patron.setPermanentPhone1("+91-9876543210");
        patron.setPermanentPhone2("+91-9876543210");
        patron.setPermanentFax("+91-9876543210");
        patron.setPermanentEmail("name@mail.com");
        patron.setMembershipFrom(DateHelper.constructDate(2014,4,1));
        patron.setMembershipTo(DateHelper.constructDate(2016,3,31));
        patron.setDelinquencyReason("Reason");
        patron.setCommonEmail("A");
        patron.setCommonInstantMsg("B");
        patron.setCommonPrint("A");
        patron.setEntryDate(DateHelper.constructDate(2013,2,1));
        patron.setUserPassword("password");
        patron.setCourseId(1);
        patron.setCustom("Custom");
        patron.setPrivilege("privilege");
        patron.setTwitterId("TId");
        patron.setFacebookId("FId");
        patron.setSubLocationId(1);
        patron.setLoginId("LId");
        patron.setAuthenticateLocalDatabase("A");

        persist(patron);

        DeletePatron deletePatron = new DeletePatron();

        deletePatron.setCode(patron.getPatronCode().getCode());
        deletePatron.setLibraryId(library.getId());

        String result = execute(deletePatron, ActivitiProcessConstants.Admin.DELETE_PATRON);

        assertNull(result);

        Patron dbPatron = fetch(Patron.class, new PatronCode(library.getId(),patron.getPatronCode().getCode() ));

        assertNull(dbPatron);
    }
}
