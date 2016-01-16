package org.sanelib.ils.core.activities.library;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.library.DeleteLibrary;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteLibraryDelegate implements JavaDelegate {

    @Autowired
    LibraryRepository libraryRepository;


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Library Delete called");

        DeleteLibrary command = (DeleteLibrary) execution.getVariable("command");
        Library publisher = this.libraryRepository.load(command.getId());
        libraryRepository.remove(publisher);
    }
}
