package org.sanelib.ils.core.activities.publisher;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.publisher.AddPublisher;
import org.sanelib.ils.core.domain.entity.Publisher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddPublisherProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testAddPublisherProcess() throws Throwable {

        AddPublisher addPublisher = new AddPublisher();

        addPublisher.setCode("CODE");
        addPublisher.setName("name");
        addPublisher.setCity("city");
        addPublisher.setState("ST");
        addPublisher.setCountry("country");

        String result = execute(addPublisher, ActivitiProcessConstants.Admin.ADD_PUBLISHER);

        assertNotNull(result);

        Publisher publisher = fetch(Publisher.class, addPublisher.getCode());

        assertNotNull(publisher);

        assertEquals(addPublisher.getCode(), publisher.getCode());
        assertEquals(addPublisher.getName(), publisher.getName());
        assertEquals(addPublisher.getCity(), publisher.getCity());
    }
}
