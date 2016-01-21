package org.sanelib.ils.core.activities.binder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binder.AddBinder;
import org.sanelib.ils.core.dao.BinderRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Binder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddBinderDelegate implements JavaDelegate{

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    BinderRepository binderRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println("Process Add Binder called");

        AddBinder command = (AddBinder) execution.getVariable("command");

        Binder entity = new Binder();

        Integer nextId = hibernateHelper.getNextId(Binder.class, "binderId.id");
        entity.setBinderId(nextId, command.getLibraryId());
        entity.setBinderName(command.getBinderName());
        entity.setPrimaryAddress(command.getPrimaryAddress());
        entity.setSecondaryAddress(command.getSecondaryAddress());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setCountry(command.getCountry());
        entity.setPin(command.getPin());
        entity.setPrimaryPhoneNumber(command.getPrimaryPhoneNumber());
        entity.setSecondaryPhoneNumber(command.getSecondaryPhoneNumber());
        entity.setFax(command.getFax());
        entity.setEmail(command.getEmail());
        entity.setEntryId(command.getEntryId());
        entity.setEntryDate(command.getEntryDate());

        binderRepository.save(entity);

        execution.setVariable("result", entity.getBinderId().getId());

    }
}
