package org.sanelib.ils.core.activities.publisher;


import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.ils.core.commands.publisher.UpdatePublisher;
import org.sanelib.ils.core.dao.PublisherRepository;
import org.sanelib.ils.core.domain.entity.Publisher;

public class ProcessUpdatePublisherDelegateTest {

    private PublisherRepository publisherRepositoryMock;

    private ProcessUpdatePublisherDelegate processUpdatePublisherDelegate;

    @Before
    public void setUp(){
        publisherRepositoryMock = Mockito.mock(PublisherRepository.class);
        processUpdatePublisherDelegate = new ProcessUpdatePublisherDelegate();
        processUpdatePublisherDelegate.publisherRepository = publisherRepositoryMock;
    }

    @Test
    public void testUpdatePublisher() throws Exception{

        Publisher publisher = new Publisher();
        publisher.setCode("1");
        publisher.setName("Publisher");
        publisher.setCity("City");
        publisher.setState("GJ");
        publisher.setCountry("Country");

        Mockito.doNothing().when(publisherRepositoryMock).save(Mockito.isA(Publisher.class));
        Mockito.doReturn(publisher).when(publisherRepositoryMock).get("1");

        UpdatePublisher updatePublisher = new UpdatePublisher();
        updatePublisher.setCode("1");
        updatePublisher.setName("new name");
        updatePublisher.setCity("new city");
        updatePublisher.setState("new state");
        updatePublisher.setCountry("new country");


        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(updatePublisher);

        processUpdatePublisherDelegate.execute(execution);

        Mockito.verify(publisherRepositoryMock).save(Mockito.isA(Publisher.class));
    }
}
