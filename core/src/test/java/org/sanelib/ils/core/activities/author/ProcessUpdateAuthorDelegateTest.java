package org.sanelib.ils.core.activities.author;


import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.commands.author.UpdateAuthor;
import org.sanelib.ils.core.dao.AuthorRepository;
import org.sanelib.ils.core.domain.entity.Author;

public class ProcessUpdateAuthorDelegateTest {

    private AuthorRepository authorRepositoryMock;

    private ProcessUpdateAuthorDelegate processUpdateAuthorDelegate;

    @Before
    public void setUp(){
        authorRepositoryMock = Mockito.mock(AuthorRepository.class);
        processUpdateAuthorDelegate = new ProcessUpdateAuthorDelegate();
        processUpdateAuthorDelegate.authorRepository = authorRepositoryMock;
    }

    @Test
    public void testUpdateAuthor() throws Exception{

        Author author = new Author();

        author.setCode("1");
        author.setLastName("Author Last Name");
        author.setFirstName("Author First Name");
        author.setPhone(StringHelper.convertPhoneNumber("+91-9876432190"));
        author.setAddress("Address");
        author.setCity("City");
        author.setState("GJ");
        author.setZipCode("5433");

        Mockito.doNothing().when(authorRepositoryMock).save(Mockito.isA(Author.class));

        Mockito.doReturn(author).when(authorRepositoryMock).get("1");

        UpdateAuthor updateAuthor = new UpdateAuthor();

        updateAuthor.setCode("1");
        updateAuthor.setLastName("Updated Last name");
        updateAuthor.setFirstName("Updated First name");
        updateAuthor.setPhone(StringHelper.convertPhoneNumber("+91-8976543290"));
        updateAuthor.setAddress("Updated Address");
        updateAuthor.setCity("new city");
        updateAuthor.setState("MH");
        updateAuthor.setZipCode("5433");

        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(updateAuthor);

        processUpdateAuthorDelegate.execute(execution);

        Mockito.verify(authorRepositoryMock).save(Mockito.isA(Author.class));
    }
}
