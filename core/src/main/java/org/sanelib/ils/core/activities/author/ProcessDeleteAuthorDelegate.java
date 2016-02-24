package org.sanelib.ils.core.activities.author;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.author.DeleteAuthor;
import org.sanelib.ils.core.dao.AuthorRepository;
import org.sanelib.ils.core.domain.entity.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteAuthorDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessDeleteAuthorDelegate.class);

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Process Author Delete called");

        DeleteAuthor command = (DeleteAuthor) execution.getVariable("command");
        Author author = this.authorRepository.load(command.getCode());

        authorRepository.remove(author);
    }
}
