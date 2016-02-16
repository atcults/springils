package org.sanelib.ils.core.activities.publisher;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.publisher.DeletePublisher;
import org.sanelib.ils.core.dao.PublisherRepository;
import org.sanelib.ils.core.domain.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeletePublisherDelegate implements JavaDelegate {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Publisher Delete called");

        DeletePublisher command = (DeletePublisher) execution.getVariable("command");
        Publisher publisher = this.publisherRepository.load(command.getCode());
        publisherRepository.remove(publisher);
    }
}
