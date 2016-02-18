package org.sanelib.ils.core.activities.patron;


import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.patron.UpdatePatron;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.domain.entity.Patron;
import org.sanelib.ils.core.domain.entity.PatronCode;
import org.sanelib.ils.core.enums.PatronType;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UpdatePatronProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdatePatronProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        Patron patron=new Patron();

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
        patron.setPermanentFax("+91-987654321");
        patron.setPermanentEmail("name@mail.com");
        patron.setMembershipFrom(DateHelper.constructDate(2014,4,1));
        patron.setMembershipTo(DateHelper.constructDate(2016,3,31));
        patron.setDelinquencyReason("Reason");
        patron.setCommonEmail(true);
        patron.setCommonInstantMsg(true);
        patron.setCommonPrint(true);
        patron.setUserPassword("password");
        patron.setCourseId(1);
        patron.setCustom("Custom");
        patron.setPrivilege("privilege");
        patron.setTwitterId("TId");
        patron.setFacebookId("FId");
        patron.setSubLocationId(1);
        patron.setLoginId("L21Id");
        patron.setAuthenticateLocalDatabase("A");

        persist(patron);

        UpdatePatron updatePatron=new UpdatePatron();

        updatePatron.setLibraryId(library.getId());
        updatePatron.setCode(patron.getPatronCode().getCode());
        updatePatron.setPatronCategoryId(1);
        updatePatron.setIsOnline("Is Online");
        updatePatron.setOwns("Owns");
        updatePatron.setCreatedOn(DateHelper.constructDate(2014,5,2));
        updatePatron.setOtherLibraryPatronId(1);
        updatePatron.setLibraryPatronId(1);
        updatePatron.setPatronType(PatronType.Patron);
        updatePatron.setDeptId(1);
        updatePatron.setFirstName("First Name");
        updatePatron.setAddress1("Address1");
        updatePatron.setAddress2("Address2");
        updatePatron.setCity("City");
        updatePatron.setState("State");
        updatePatron.setCountry("Country");
        updatePatron.setPin("387003");
        updatePatron.setPhone1("+91-9876543210");
        updatePatron.setPhone2("+91-9876543210");
        updatePatron.setFax("+91-987654321");
        updatePatron.setEmail("name@mail.com");
        updatePatron.setPermanentAddress1("PAddress1");
        updatePatron.setPermanentAddress2("PAddress2");
        updatePatron.setPermanentCity("PCity");
        updatePatron.setPermanentState("PState");
        updatePatron.setPermanentCountry("PCountry");
        updatePatron.setPermanentPin("PPin");
        updatePatron.setPermanentPhone1("+91-9876543210");
        updatePatron.setPermanentPhone2("+91-9876543210");
        updatePatron.setPermanentFax("+91-987654321");
        updatePatron.setPermanentEmail("name@mail.com");
        updatePatron.setMembershipFrom(DateHelper.constructDate(2014,4,1));
        updatePatron.setMembershipTo(DateHelper.constructDate(2016,3,31));
        updatePatron.setDelinquencyReason("Reason");
        updatePatron.setCommonEmail(true);
        updatePatron.setCommonInstantMsg(true);
        updatePatron.setCommonPrint(true);
        updatePatron.setUserPassword("password");
        updatePatron.setCourseId(1);
        updatePatron.setCustom("Custom");
        updatePatron.setPrivilege("privilege");
        updatePatron.setTwitterId("TId");
        updatePatron.setFacebookId("FId");
        updatePatron.setSubLocationId(1);
        updatePatron.setLoginId("L21Id");
        updatePatron.setAuthenticateLocalDatabase("A");

        String result = execute(updatePatron, ActivitiProcessConstants.Admin.UPDATE_PATRON);

        assertNull(result);

        Patron dbPatron = fetch(Patron.class, new PatronCode(library.getId(), patron.getPatronCode().getCode()));

        assertNotNull(dbPatron);

        assertEquals(updatePatron.getCode() , patron.getPatronCode().getCode());
        assertEquals(updatePatron.getPatronCategoryId() ,patron.getOtherLibraryPatronId());
        assertEquals(updatePatron.getIsOnline() ,patron.getIsOnline());
        assertEquals(updatePatron.getOwns() ,patron.getOwns());
        assertEquals(updatePatron.getCreatedOn() ,patron.getCreatedOn());
        assertEquals(updatePatron.getOtherLibraryPatronId() ,patron.getOtherLibraryPatronId());
        assertEquals(updatePatron.getPatronType() ,patron.getPatronType());
        assertEquals(updatePatron.getDeptId() ,patron.getDeptId());
        assertEquals(updatePatron.getFirstName() ,patron.getFirstName());
        assertEquals(updatePatron.getAddress1() ,patron.getAddress1());
        assertEquals(updatePatron.getAddress2() ,patron.getAddress2());
        assertEquals(updatePatron.getCity() ,patron.getCity());
        assertEquals(updatePatron.getState() ,patron.getState());
        assertEquals(updatePatron.getCountry() ,patron.getCountry());
        assertEquals(updatePatron.getPin() ,patron.getPin());
        assertEquals(updatePatron.getPhone1() ,patron.getPhone1());
        assertEquals(updatePatron.getPhone2() ,patron.getPhone2());
        assertEquals(updatePatron.getFax() ,patron.getFax());
        assertEquals(updatePatron.getEmail() ,patron.getEmail());
        assertEquals(updatePatron.getPermanentAddress1() ,patron.getPermanentAddress1());
        assertEquals(updatePatron.getPermanentAddress2() ,patron.getPermanentAddress2());
        assertEquals(updatePatron.getPermanentCity() ,patron.getPermanentCity());
        assertEquals(updatePatron.getPermanentState() ,patron.getPermanentState());
        assertEquals(updatePatron.getPermanentCountry() ,patron.getPermanentCountry());
        assertEquals(updatePatron.getPermanentPin() ,patron.getPermanentPin());
        assertEquals(updatePatron.getPermanentPhone1() ,patron.getPermanentPhone1());
        assertEquals(updatePatron.getPermanentPhone2() ,patron.getPermanentPhone2());
        assertEquals(updatePatron.getPermanentFax() ,patron.getPermanentFax());
        assertEquals(updatePatron.getPermanentEmail() ,patron.getPermanentEmail());
        assertEquals(updatePatron.getMembershipFrom() ,patron.getMembershipFrom());
        assertEquals(updatePatron.getMembershipTo() ,patron.getMembershipTo());
        assertEquals(updatePatron.getDelinquencyReason() ,patron.getDelinquencyReason());
        assertEquals(updatePatron.commonEmail() ,patron.commonEmail());
        assertEquals(updatePatron.commonInstantMsg() ,patron.commonInstantMsg());
        assertEquals(updatePatron.commonPrint() ,patron.commonPrint());
        assertEquals(updatePatron.getUserPassword() ,patron.getUserPassword());
        assertEquals(updatePatron.getCourseId() ,patron.getCourseId());
        assertEquals(updatePatron.getCustom() ,patron.getCustom());
        assertEquals(updatePatron.getPrivilege() ,patron.getPrivilege());
        assertEquals(updatePatron.getTwitterId() ,patron.getTwitterId());
        assertEquals(updatePatron.getFacebookId() ,patron.getFacebookId());
        assertEquals(updatePatron.getSubLocationId() ,patron.getSubLocationId());
        assertEquals(updatePatron.getLoginId() ,patron.getLoginId());
        assertEquals(updatePatron.getAuthenticateLocalDatabase() ,patron.getAuthenticateLocalDatabase());

    }

}
