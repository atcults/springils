package org.sanelib.ils.core.activities.author;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.author.UpdateAuthor;
import org.sanelib.ils.core.domain.entity.Author;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class UpdateAuthorProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testUpdateAuthorProcess() throws Throwable {

        Author author = new Author();

        author.setCode("1");
        author.setLastName("Author Last Name");
        author.setFirstName("Author First Name");
        author.setPhone(StringHelper.convertPhoneNumber("+91-987643210"));
        author.setAddress("Address");
        author.setCity("City");
        author.setState("GJ");
        author.setZipCode("5433");
        author.setContract(true);

        persist(author);

        UpdateAuthor updateAuthor = new UpdateAuthor();

        updateAuthor.setCode("1");
        updateAuthor.setLastName("Updated Last name");
        updateAuthor.setFirstName("Updated First name");
        updateAuthor.setPhone(StringHelper.convertPhoneNumber("+91-8976543290"));
        updateAuthor.setAddress("Updated Address");
        updateAuthor.setCity("new city");
        updateAuthor.setState("MH");
        updateAuthor.setZipCode("5433");
        updateAuthor.setContract(false);

        String result = execute(updateAuthor, ActivitiProcessConstants.Admin.UPDATE_AUTHOR);

        assertNull(result);

        Author updatedAuthor = fetch(Author.class, updateAuthor.getCode());

        assertNotNull(author);

        assertEquals(updateAuthor.getCode(), updatedAuthor.getCode());
        assertEquals(updateAuthor.getLastName(), updatedAuthor.getLastName());
        assertEquals(updateAuthor.getFirstName(), updatedAuthor.getFirstName());
        assertEquals(updateAuthor.getPhone(), updatedAuthor.getPhone());
        assertEquals(updateAuthor.getAddress(), updatedAuthor.getAddress());
        assertEquals(updateAuthor.getCity(), updatedAuthor.getCity());
        assertEquals(updateAuthor.getState(), updatedAuthor.getState());
        assertEquals(updateAuthor.getZipCode(), updatedAuthor.getZipCode());
        assertEquals(updateAuthor.isContract(), updatedAuthor.isContract());
    }
}
