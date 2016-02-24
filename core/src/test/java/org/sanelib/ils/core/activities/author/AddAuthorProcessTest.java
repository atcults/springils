package org.sanelib.ils.core.activities.author;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.author.AddAuthor;
import org.sanelib.ils.core.domain.entity.Author;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddAuthorProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testAddAuthorProcess() throws Throwable {

        AddAuthor addAuthor = new AddAuthor();

        addAuthor.setCode("code");
        addAuthor.setLastName("Author Last Name");
        addAuthor.setFirstName("Author First Name");
        addAuthor.setPhone(StringHelper.convertPhoneNumber("+91-9876543210"));
        addAuthor.setAddress("Address");
        addAuthor.setCity("city");
        addAuthor.setState("ST");
        addAuthor.setZipCode("54321");
        addAuthor.setContract(true);

        String result = execute(addAuthor, ActivitiProcessConstants.Admin.ADD_AUTHOR);

        assertNotNull(result);

        Author author;
        author = fetch(Author.class, result);

        assertNotNull(author);

        assertEquals(addAuthor.getCode(), author.getCode());
        assertEquals(addAuthor.getLastName() , author.getLastName());
        assertEquals(addAuthor.getFirstName() , author.getFirstName());
        assertEquals(addAuthor.getPhone() , author.getPhone());
        assertEquals(addAuthor.getAddress() , author.getAddress());
        assertEquals(addAuthor.getCity() , author.getCity());
        assertEquals(addAuthor.getState() , author.getState());
        assertEquals(addAuthor.getZipCode() , author.getZipCode());
        assertEquals(addAuthor.isContract() , author.isContract());
    }
}
