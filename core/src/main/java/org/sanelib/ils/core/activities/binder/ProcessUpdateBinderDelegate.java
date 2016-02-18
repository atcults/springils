package org.sanelib.ils.core.activities.binder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binder.UpdateBinder;
import org.sanelib.ils.core.dao.BinderRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Binder;
import org.sanelib.ils.core.domain.entity.BinderId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateBinderDelegate implements JavaDelegate {

    @Autowired
    BinderRepository binderRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Update Binder called");

        UpdateBinder command = (UpdateBinder) execution.getVariable("command");

        Binder entity = binderRepository.get(new BinderId(command.getLibraryId(), command.getId()));

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

        binderRepository.save(entity);
	}
}
