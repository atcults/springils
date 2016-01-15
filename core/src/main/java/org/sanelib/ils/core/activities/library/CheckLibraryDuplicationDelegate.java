package org.sanelib.ils.core.activities.library;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckLibraryDuplicationDelegate implements JavaDelegate {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Checking library for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        Integer existingId = ((AddLibrary) command).getId();

        List<Library> libraries = libraryRepository.findByColumnAndValue("id", existingId);

        if(!libraries.isEmpty()&& !Objects.equals(existingId, libraries.get(0).getId())){
            processError.addError("common.field.duplicate", "id", Arrays.asList("domain.entity.library", "domain.common.id"), String.valueOf(existingId));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
