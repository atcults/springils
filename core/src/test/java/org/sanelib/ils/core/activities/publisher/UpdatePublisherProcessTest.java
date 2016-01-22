package org.sanelib.ils.core.activities.publisher;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.publisher.AddPublisher;
import org.sanelib.ils.core.commands.publisher.UpdatePublisher;
import org.sanelib.ils.core.domain.entity.Publisher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UpdatePublisherProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testUpdatePublisherProcess() throws Throwable {

        Publisher publisher = new Publisher();
        publisher.setCode("1");
        publisher.setName("Publisher");
        publisher.setCity("City");
        publisher.setState("GJ");
        publisher.setCountry("Country");

        persist(publisher);

        UpdatePublisher updatePublisher = new UpdatePublisher();
        updatePublisher.setCode("1");
        updatePublisher.setName("new name");
        updatePublisher.setCity("new city");
        updatePublisher.setState("MH");
        updatePublisher.setCountry("new country");


        String result = execute(updatePublisher, ActivitiProcessConstants.Admin.UPDATE_PUBLISHER);

        assertNull(result);

        Publisher updatedPublisher = fetch(Publisher.class, updatePublisher.getCode());

        assertNotNull(publisher);

        assertEquals(updatePublisher.getCode(), updatedPublisher.getCode());
        assertEquals(updatePublisher.getName() ,updatedPublisher.getName());
        assertEquals(updatePublisher.getCity() , updatedPublisher.getCity());
        assertEquals(updatePublisher.getState() ,updatedPublisher.getState());
        assertEquals(updatePublisher.getCountry() ,updatedPublisher.getCountry());
    }
}
