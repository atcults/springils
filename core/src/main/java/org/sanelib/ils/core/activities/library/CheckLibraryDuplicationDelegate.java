package org.sanelib.ils.core.activities.library;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.commands.library.UpdateLibrary;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Library;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckLibraryDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckLibraryDuplicationDelegate.class);

    @Autowired
    LibraryRepository libraryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Checking library for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateLibrary;

        Integer libraryId = isUpdate ? ((UpdateLibrary) command).getId() : null;
        String libraryName = ((AddLibrary) command).getName();

        List<Library> libraries = libraryRepository.findByColumnAndValue("name", libraryName);

        Library dbLibrary = libraries.isEmpty() ? null : libraries.get(0);

        if(dbLibrary != null && (!isUpdate || !Objects.equals(libraryId, dbLibrary.getId()))){
            processError.addError("common.field.duplicate", "name", Arrays.asList("domain.entity.library", "domain.common.name"), libraryName);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
