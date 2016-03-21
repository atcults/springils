package org.sanelib.ils.core.activities.publisher;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.publisher.DeletePublisher;
import org.sanelib.ils.core.dao.PublisherRepository;
import org.sanelib.ils.core.domain.entity.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeletePublisherDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessDeletePublisherDelegate.class);

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Process Publisher Delete called");

        DeletePublisher command = (DeletePublisher) execution.getVariable("command");

        Publisher publisher = this.publisherRepository.load(command.getCode());

        publisherRepository.remove(publisher);
    }
}
