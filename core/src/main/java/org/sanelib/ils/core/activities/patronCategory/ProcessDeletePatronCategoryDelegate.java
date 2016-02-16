package org.sanelib.ils.core.activities.patronCategory;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.patronCategory.DeletePatronCategory;
import org.sanelib.ils.core.dao.PatronCategoryRepository;
import org.sanelib.ils.core.domain.entity.PatronCategory;
import org.sanelib.ils.core.domain.entity.PatronCategoryId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeletePatronCategoryDelegate implements JavaDelegate {

    @Autowired
    PatronCategoryRepository patronCategoryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Delete Patron Category called");

        DeletePatronCategory command = (DeletePatronCategory) execution.getVariable("command");
        PatronCategory patronCategory = this.patronCategoryRepository.load(new PatronCategoryId(command.getLibraryId(), command.getId()));
        patronCategoryRepository.remove(patronCategory);
	}
}
