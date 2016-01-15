package org.sanelib.ils.core.activities.library;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.commands.library.UpdateLibrary;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateLibraryDelegate implements JavaDelegate {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Update Library called");

        UpdateLibrary command = (UpdateLibrary) execution.getVariable("command");

        Library entity = libraryRepository.get(command.getId());

        entity.setName(command.getName());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setCountry(command.getCountry());

        libraryRepository.save(entity);
	}
}
