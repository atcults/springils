package org.sanelib.ils.core.activities.publisher;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.publisher.DeletePublisher;
import org.sanelib.ils.core.domain.entity.Publisher;

import static org.junit.Assert.assertNull;

public class DeletePublisherProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testDeleteEmployeeSuccess() throws Throwable {

        Publisher publisher = new Publisher();
        publisher.setId("1");
        publisher.setName("Publisher");
        publisher.setCity("City");
        publisher.setState("GJ");
        publisher.setCountry("Country");

        persist(publisher);

        DeletePublisher deleteEmployee = new DeletePublisher();
        deleteEmployee.setCode(publisher.getId());

        String result = execute(deleteEmployee, ActivitiProcessConstants.Admin.DELETE_PUBLISHER);
        assertNull(result);

        Publisher deletedPublisher = fetch(Publisher.class, publisher.getId());
        assertNull(deletedPublisher);
    }
}