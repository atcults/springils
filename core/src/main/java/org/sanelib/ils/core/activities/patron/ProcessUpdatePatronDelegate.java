package org.sanelib.ils.core.activities.patron;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.patron.UpdatePatron;
import org.sanelib.ils.core.dao.PatronRepository;
import org.sanelib.ils.core.domain.entity.Patron;
import org.sanelib.ils.core.domain.entity.PatronCode;
import org.sanelib.ils.core.enums.PatronType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdatePatronDelegate implements JavaDelegate {

    @Autowired
    PatronRepository patronRepository;


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Update Patron called");

        UpdatePatron command = (UpdatePatron) execution.getVariable("command");

        Patron entity = patronRepository.get(new PatronCode(command.getLibraryId(),command.getCode()));

        entity.setPatronCategoryId(command.getPatronCategoryId());
        entity.setOwns(command.getOwns());
        entity.setOtherLibraryPatronId(command.getOtherLibraryPatronId());
        entity.setLibraryPatronId(command.getLibraryPatronId());
        entity.setPatronType(PatronType.Patron);
        entity.setDeptId(command.getDeptId());
        entity.setFirstName(command.getFirstName());
        entity.setMiddleName(command.getMiddleName());
        entity.setLastName(command.getLastName());
        entity.setAddress1(command.getAddress1());
        entity.setAddress2(command.getAddress2());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setCountry(command.getCountry());
        entity.setPin(command.getPin());
        entity.setPhone1(command.getPhone1());
        entity.setPhone2(command.getPhone2());
        entity.setFax(command.getFax());
        entity.setEmail(command.getEmail());
        entity.setPermanentAddress1(command.getPermanentAddress1());
        entity.setPermanentAddress2(command.getPermanentAddress2());
        entity.setPermanentCity(command.getPermanentCity());
        entity.setPermanentState(command.getPermanentState());
        entity.setPermanentCountry(command.getPermanentCountry());
        entity.setPermanentPin(command.getPermanentPin());
        entity.setPermanentPhone1(command.getPermanentPhone1());
        entity.setPermanentPhone2(command.getPermanentPhone2());
        entity.setPermanentFax(command.getPermanentFax());
        entity.setPermanentEmail(command.getPermanentEmail());
        entity.setMembershipFrom(command.getMembershipFrom());
        entity.setMembershipTo(command.getMembershipTo());
        entity.setDelinquencyReason(command.getDelinquencyReason());
        entity.setCommonEmail(command.commonEmail());
        entity.setCommonInstantMsg(command.commonInstantMsg());
        entity.setCommonPrint(command.commonPrint());
        entity.setUserPassword(command.getUserPassword());
        entity.setCourseId(command.getCourseId());
        entity.setCustom(command.getCustom());
        entity.setPrivilege(command.getPrivilege());
        entity.setTwitterId(command.getTwitterId());
        entity.setFacebookId(command.getFacebookId());
        entity.setSubLocationId(command.getSubLocationId());
        entity.setLoginId(command.getLoginId());
        entity.setAuthenticateLocalDatabase(command.getAuthenticateLocalDatabase());
        entity.setSendToAddress(command.isSendToAddress());
        entity.setActive(command.isActive());
        patronRepository.save(entity);
    }
}
