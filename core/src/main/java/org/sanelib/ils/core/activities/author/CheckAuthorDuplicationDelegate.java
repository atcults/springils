package org.sanelib.ils.core.activities.author;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.author.AddAuthor;
import org.sanelib.ils.core.commands.author.UpdateAuthor;
import org.sanelib.ils.core.dao.AuthorRepository;
import org.sanelib.ils.core.domain.entity.Author;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckAuthorDuplicationDelegate implements JavaDelegate {

    @Autowired
    AuthorRepository authorRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Checking authors for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateAuthor;

        String existingAuthorCode = ((AddAuthor) command).getCode();

        List<Author> authors = authorRepository.findByColumnAndValue("code", existingAuthorCode);

        if(!authors.isEmpty()) {
            if(!isUpdate || !Objects.equals(existingAuthorCode, authors.get(0).getCode())){
                processError.addError("common.field.duplicate", "existingAuthorCode", Arrays.asList("domain.entity.author", "domain.common.code"), existingAuthorCode);
            }
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
