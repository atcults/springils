package org.sanelib.ils.core.activities.author;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.author.DeleteAuthor;
import org.sanelib.ils.core.domain.entity.Author;

import static org.junit.Assert.assertNull;

public class DeleteAuthorProcessTest extends EntityIntegrationTestBase {

    @Test
    public void testDeleteAuthorSuccess() throws Throwable {

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

        DeleteAuthor deleteAuthor = new DeleteAuthor();
        deleteAuthor.setCode(author.getCode());

        String result = execute(deleteAuthor, ActivitiProcessConstants.Admin.DELETE_AUTHOR);
        assertNull(result);

        Author deletedAuthor = fetch(Author.class, author.getCode());

        assertNull(deletedAuthor);
    }
}
