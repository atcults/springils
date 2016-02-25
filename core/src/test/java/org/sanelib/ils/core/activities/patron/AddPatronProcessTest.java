package org.sanelib.ils.core.activities.patron;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.patron.AddPatron;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.PatronRepository;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.Patron;
import org.sanelib.ils.core.domain.entity.PatronCode;
import org.sanelib.ils.core.enums.PatronType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddPatronProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    PatronRepository patronRepository;

    @Test
    public void testAddPatronProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        AddPatron addPatron=new AddPatron();

        addPatron.setLibraryId(library.getId());
        addPatron.setCode("Pat1");
        addPatron.setPatronCategoryId(1);
        addPatron.setOwns("Owns");
        addPatron.setOtherLibraryPatronId(1);
        addPatron.setLibraryPatronId(1);
        addPatron.setPatronType(PatronType.Patron);
        addPatron.setDeptId(1);
        addPatron.setFirstName("First Name");
        addPatron.setAddress1("Address1");
        addPatron.setAddress2("Address2");
        addPatron.setCity("City");
        addPatron.setState("State");
        addPatron.setCountry("Country");
        addPatron.setPin("387003");
        addPatron.setPhone1("+91-9876543210");
        addPatron.setPhone2("+91-9876543210");
        addPatron.setFax("+91-9876543210");
        addPatron.setEmail("name@mail.com");
        addPatron.setPermanentAddress1("PAddress1");
        addPatron.setPermanentAddress2("PAddress2");
        addPatron.setPermanentCity("PCity");
        addPatron.setPermanentState("PState");
        addPatron.setPermanentCountry("PCountry");
        addPatron.setPermanentPin("PPin");
        addPatron.setPermanentPhone1("+91-9876543210");
        addPatron.setPermanentPhone2("+91-9876543210");
        addPatron.setPermanentFax("+91-9876543210");
        addPatron.setPermanentEmail("name@mail.com");
        addPatron.setMembershipFrom(DateHelper.constructDate(2014,4,1));
        addPatron.setMembershipTo(DateHelper.constructDate(2016,3,31));
        addPatron.setDelinquencyReason("Reason");
        addPatron.setCommonEmail(true);
        addPatron.setCommonInstantMsg(true);
        addPatron.setCommonPrint(true);
        addPatron.setUserPassword("password");
        addPatron.setCourseId(1);
        addPatron.setCustom("Custom");
        addPatron.setPrivilege("privilege");
        addPatron.setTwitterId("TId");
        addPatron.setFacebookId("FId");
        addPatron.setSubLocationId(1);
        addPatron.setLoginId("L12Id2");
        addPatron.setAuthenticateLocalDatabase("A");

        PatronType patronType = PatronType.getByName("Patron");
        addPatron.setPatronType(patronType);

        String result = execute(addPatron, ActivitiProcessConstants.Admin.ADD_PATRON);

        assertNotNull(result);

        Patron patron = fetch(Patron.class, new PatronCode(library.getId(), result));

        assertNotNull(patron);

        assertEquals(addPatron.getCode(), patron.getPatronCode().getCode());
        assertEquals(addPatron.getPatronCategoryId(), patron.getOtherLibraryPatronId());
        assertEquals(addPatron.getOwns(), patron.getOwns());
        assertEquals(addPatron.getOtherLibraryPatronId(), patron.getOtherLibraryPatronId());
        assertEquals(addPatron.getPatronType(), patron.getPatronType());
        assertEquals(addPatron.getDeptId(), patron.getDeptId());
        assertEquals(addPatron.getFirstName(), patron.getFirstName());
        assertEquals(addPatron.getAddress1(), patron.getAddress1());
        assertEquals(addPatron.getAddress2(), patron.getAddress2());
        assertEquals(addPatron.getCity(), patron.getCity());
        assertEquals(addPatron.getState(), patron.getState());
        assertEquals(addPatron.getCountry(), patron.getCountry());
        assertEquals(addPatron.getPin(), patron.getPin());
        assertEquals(addPatron.getPhone1(), patron.getPhone1());
        assertEquals(addPatron.getPhone2(), patron.getPhone2());
        assertEquals(addPatron.getFax(), patron.getFax());
        assertEquals(addPatron.getEmail(), patron.getEmail());
        assertEquals(addPatron.getPermanentAddress1(), patron.getPermanentAddress1());
        assertEquals(addPatron.getPermanentAddress2(), patron.getPermanentAddress2());
        assertEquals(addPatron.getPermanentCity(), patron.getPermanentCity());
        assertEquals(addPatron.getPermanentState(), patron.getPermanentState());
        assertEquals(addPatron.getPermanentCountry(), patron.getPermanentCountry());
        assertEquals(addPatron.getPermanentPin(), patron.getPermanentPin());
        assertEquals(addPatron.getPermanentPhone1(), patron.getPermanentPhone1());
        assertEquals(addPatron.getPermanentPhone2(), patron.getPermanentPhone2());
        assertEquals(addPatron.getPermanentFax(), patron.getPermanentFax());
        assertEquals(addPatron.getPermanentEmail(), patron.getPermanentEmail());
        assertEquals(addPatron.getMembershipFrom(), patron.getMembershipFrom());
        assertEquals(addPatron.getMembershipTo(), patron.getMembershipTo());
        assertEquals(addPatron.getDelinquencyReason(), patron.getDelinquencyReason());
        assertEquals(addPatron.commonEmail(), patron.commonEmail());
        assertEquals(addPatron.commonInstantMsg(), patron.commonInstantMsg());
        assertEquals(addPatron.commonPrint(), patron.commonPrint());
        assertEquals(addPatron.getUserPassword(), patron.getUserPassword());
        assertEquals(addPatron.getCourseId(), patron.getCourseId());
        assertEquals(addPatron.getCustom(), patron.getCustom());
        assertEquals(addPatron.getPrivilege(), patron.getPrivilege());
        assertEquals(addPatron.getTwitterId(), patron.getTwitterId());
        assertEquals(addPatron.getFacebookId(), patron.getFacebookId());
        assertEquals(addPatron.getSubLocationId(), patron.getSubLocationId());
        assertEquals(addPatron.getLoginId(), patron.getLoginId());
        assertEquals(addPatron.getAuthenticateLocalDatabase(), patron.getAuthenticateLocalDatabase());
        assertEquals(addPatron.isSendToAddress(), patron.isSendToAddress());
        assertEquals(addPatron.isActive(), patron.isActive());
    }
}
