package org.sanelib.ils.core.activities.patronCategory;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.patronCategory.AddPatronCategory;
import org.sanelib.ils.core.commands.patronCategory.UpdatePatronCategory;
import org.sanelib.ils.core.dao.PatronCategoryRepository;
import org.sanelib.ils.core.domain.entity.PatronCategory;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckPatronCategoryDuplicationDelegate implements JavaDelegate {

	private static final Logger LOG = LoggerFactory.getLogger(CheckPatronCategoryDuplicationDelegate.class);

    @Autowired
    PatronCategoryRepository patronCategoryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Checking patron category for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdatePatronCategory;

        Integer patronCategoryId = isUpdate ? ((UpdatePatronCategory) command).getId() : null;
        Integer libraryId = ((AddPatronCategory) command).getLibraryId();
        String patronCategoryName = ((AddPatronCategory) command).getName();

        List<PatronCategory> patronCategories = patronCategoryRepository.findByColumnAndValue(new String[]{"patronCategoryId.libraryId", "name"}, new Object[] {libraryId, patronCategoryName});

        PatronCategory dbPatronCategory = patronCategories.isEmpty() ? null : patronCategories.get(0);

        if(dbPatronCategory != null && (!isUpdate || !Objects.equals(patronCategoryId, dbPatronCategory.getPatronCategoryId().getId()))){
            processError.addError("common.field.duplicate", "patronCategoryName", Arrays.asList("domain.entity.patronCategory", "domain.common.name"), patronCategoryName);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
