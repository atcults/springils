package org.sanelib.ils.core.activities.author;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.author.AddAuthor;
import org.sanelib.ils.core.dao.AuthorRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddAuthorDelegate implements JavaDelegate {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    AuthorRepository authorRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Add Author called");

        AddAuthor command = (AddAuthor) execution.getVariable("command");

        Author entity = new Author();

        entity.setCode(command.getCode());
        entity.setLastName(command.getLastName());
        entity.setFirstName(command.getFirstName());
        entity.setPhone(command.getPhone());
        entity.setAddress(command.getAddress());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setZipCode(command.getZipCode());

        authorRepository.save(entity);

        execution.setVariable("result", entity.getCode());
	}
}
