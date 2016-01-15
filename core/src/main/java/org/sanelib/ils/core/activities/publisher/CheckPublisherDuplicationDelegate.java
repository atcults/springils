package org.sanelib.ils.core.activities.publisher;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.publisher.AddPublisher;
import org.sanelib.ils.core.dao.PublisherRepository;
import org.sanelib.ils.core.domain.entity.Publisher;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckPublisherDuplicationDelegate implements JavaDelegate {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Checking publishers for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        String existingPublisherCode = ((AddPublisher) command).getCode();

        //Name duplication check
        String name = ((AddPublisher) command).getName();

        List<Publisher> publishers = publisherRepository.findByColumnAndValue("id", existingPublisherCode);

        if(!publishers.isEmpty() && !Objects.equals(existingPublisherCode, publishers.get(0).getId())){
            processError.addError("common.field.duplicate", "code", Arrays.asList("domain.publisher.name", "domain.publisher.code"), name);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
