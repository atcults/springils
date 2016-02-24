package org.sanelib.ils.core.activities.circulationMatrix;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.circulationMatrix.DeleteCirculationMatrix;
import org.sanelib.ils.core.dao.CirculationMatrixRepository;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.domain.entity.CirculationMatrixId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteCirculationMatrixDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckCirculationMatrixExistDelegate.class);

    @Autowired
    CirculationMatrixRepository circulationMatrixRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Process delete CirculationMatrix called");

        DeleteCirculationMatrix command = (DeleteCirculationMatrix) execution.getVariable("command");
        CirculationMatrix circulationMatrix = this.circulationMatrixRepository.load(new CirculationMatrixId(command.getLibraryId(), command.getPatronCategoryId(), command.getMaterialTypeId(), command.getWithEffectFrom()));

        circulationMatrixRepository.remove(circulationMatrix);
    }
}
