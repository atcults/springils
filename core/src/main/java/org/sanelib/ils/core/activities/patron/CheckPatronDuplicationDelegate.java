package org.sanelib.ils.core.activities.patron;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.patron.AddPatron;
import org.sanelib.ils.core.commands.patron.UpdatePatron;
import org.sanelib.ils.core.dao.PatronRepository;
import org.sanelib.ils.core.domain.entity.Patron;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckPatronDuplicationDelegate implements JavaDelegate {

    @Autowired
    PatronRepository patronRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println("Checking patron for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdatePatron;

        String code = isUpdate ? ((UpdatePatron) command).getCode() : ((AddPatron) command).getCode();
        Integer LibraryId = ((AddPatron) command).getLibraryId();

        List<Patron> patron  = patronRepository.findByColumnAndValue(
                new String[]{"patronCode.libraryId", "patronCode.code"},
                new Object[]{LibraryId, code}
        );

        if(!patron.isEmpty()) {
            if(!isUpdate || !Objects.equals(code, patron.get(0).getPatronCode().getCode())) {
                processError.addError("common.field.duplicate", "patron.code",
                        Arrays.asList("domain.entity.library", "domain.patron.code"), code);
            }
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }

}
