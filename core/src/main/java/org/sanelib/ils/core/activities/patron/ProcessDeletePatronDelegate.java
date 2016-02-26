package org.sanelib.ils.core.activities.patron;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.patron.DeletePatron;
import org.sanelib.ils.core.dao.PatronRepository;
import org.sanelib.ils.core.domain.entity.Patron;
import org.sanelib.ils.core.domain.entity.PatronCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeletePatronDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessDeletePatronDelegate.class);

    @Autowired
    PatronRepository patronRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Process Delete Patron called");

        DeletePatron command = (DeletePatron) execution.getVariable("command");

        Patron patron = this.patronRepository.load(new PatronCode(command.getLibraryId(), command.getCode()));

        patronRepository.remove(patron);
    }

}
