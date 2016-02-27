package org.sanelib.ils.core.activities.binder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binder.AddBinder;
import org.sanelib.ils.core.dao.BinderRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Binder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddBinderDelegate implements JavaDelegate{

    private static final Logger LOG = LoggerFactory.getLogger(ProcessAddBinderDelegate.class);

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    BinderRepository binderRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Process Add Binder called");

        AddBinder command = (AddBinder) execution.getVariable("command");

        Binder entity = new Binder();

        Integer nextId = hibernateHelper.getNextId(Binder.class, "binderId.id");
        entity.setBinderId(nextId, command.getLibraryId());
        entity.setName(command.getBinderName());
        entity.setAddressLine1(command.getPrimaryAddress());
        entity.setAddressLine2(command.getSecondaryAddress());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setCountry(command.getCountry());
        entity.setPin(command.getPin());
        entity.setPrimaryPhone(command.getPrimaryPhone());
        entity.setSecondaryPhone(command.getSecondaryPhone());
        entity.setFax(command.getFax());
        entity.setEmail(command.getEmail());
        entity.setUserCode(command.getUserCode());

        binderRepository.save(entity);

        execution.setVariable("result", entity.getBinderId().getId());
    }
}
