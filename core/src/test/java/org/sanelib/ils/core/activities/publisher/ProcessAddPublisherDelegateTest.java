package org.sanelib.ils.core.activities.publisher;


import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.ils.core.commands.publisher.AddPublisher;
import org.sanelib.ils.core.dao.PublisherRepository;
import org.sanelib.ils.core.domain.entity.Publisher;

public class ProcessAddPublisherDelegateTest {

    private PublisherRepository publisherRepositoryMock;

    private ProcessAddPublisherDelegate processAddUserDelegate;

    @Before
    public void setUp(){
        publisherRepositoryMock = Mockito.mock(PublisherRepository.class);
        processAddUserDelegate = new ProcessAddPublisherDelegate();
        processAddUserDelegate.publisherRepository = publisherRepositoryMock;
    }

    @Test
    public void testAddPublisher() throws Exception{

        Mockito.doNothing().when(publisherRepositoryMock).save(Mockito.isA(Publisher.class));

        AddPublisher addPublisher = new AddPublisher();
        addPublisher.setCode("code");
        addPublisher.setName("name");
        addPublisher.setCity("city");
        addPublisher.setState("state");
        addPublisher.setCountry("country");


        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(addPublisher);

        processAddUserDelegate.execute(execution);

        Mockito.verify(execution).setVariable("result", "code");
    }
}
