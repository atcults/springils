package org.sanelib.ils.core.activities.author;

import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sanelib.ils.common.utils.StringHelper;
import org.sanelib.ils.core.commands.author.AddAuthor;
import org.sanelib.ils.core.dao.AuthorRepository;
import org.sanelib.ils.core.domain.entity.Author;

public class ProcessAddAuthorDelegateTest {

    private AuthorRepository authorRepositoryMock;

    private ProcessAddAuthorDelegate processAddUserDelegate;

    @Before
    public void setUp(){
        authorRepositoryMock = Mockito.mock(AuthorRepository.class);
        processAddUserDelegate = new ProcessAddAuthorDelegate();
        processAddUserDelegate.authorRepository = authorRepositoryMock;
    }

    @Test
    public void testAddAuthor() throws Exception{

        Mockito.doNothing().when(authorRepositoryMock).save(Mockito.isA(Author.class));

        AddAuthor addAuthor = new AddAuthor();
        addAuthor.setCode("code");
        addAuthor.setLastName("Author Last Name");
        addAuthor.setFirstName("Author First Name");
        addAuthor.setPhone(StringHelper.convertPhoneNumber("+91-9876543210"));
        addAuthor.setAddress("Address");
        addAuthor.setCity("City");
        addAuthor.setState("State");
        addAuthor.setZipCode("5432");
        addAuthor.setContract(true);

        DelegateExecution execution = Mockito.mock(DelegateExecution.class);
        Mockito.when(execution.getVariable("command")).thenReturn(addAuthor);

        processAddUserDelegate.execute(execution);

        Mockito.verify(execution).setVariable("result", "code");
    }
}
