package org.sanelib.ils.core.activities.publisher;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.ibatis.annotations.Update;
import org.sanelib.ils.core.commands.publisher.AddPublisher;
import org.sanelib.ils.core.commands.publisher.UpdatePublisher;
import org.sanelib.ils.core.dao.PublisherRepository;
import org.sanelib.ils.core.domain.entity.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdatePublisherDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessUpdatePublisherDelegate.class);

    @Autowired
    PublisherRepository publisherRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Update Publisher called");

        UpdatePublisher command = (UpdatePublisher) execution.getVariable("command");

        Publisher entity = publisherRepository.get(command.getCode());

        entity.setCode(command.getCode());
        entity.setName(command.getName());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setCountry(command.getCountry());

        publisherRepository.save(entity);
	}
}
