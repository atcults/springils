package org.sanelib.ils.core.activities.circulationMatrix;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.circulationMatrix.AddCirculationMatrix;
import org.sanelib.ils.core.commands.circulationMatrix.UpdateCirculationMatrix;
import org.sanelib.ils.core.dao.CirculationMatrixRepository;
import org.sanelib.ils.core.domain.entity.CirculationMatrix;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CheckCirculationMatrixDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckCirculationMatrixDuplicationDelegate.class);

    @Autowired
    CirculationMatrixRepository circulationMatrixRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Check circulation matrix for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateCirculationMatrix;

        Integer libraryId = ((AddCirculationMatrix) command).getLibraryId();
        Date withEffectFrom = ((AddCirculationMatrix) command).getWithEffectFrom();

        List<CirculationMatrix> circulationMatrix = circulationMatrixRepository.findByColumnAndValue(
                new String[] {"circulationMatrixId.libraryId" , "circulationMatrixId.withEffectFrom"},
                new Object[] {libraryId , withEffectFrom }
        );

        CirculationMatrix dbCirculationMatrix = circulationMatrix.isEmpty() ? null : circulationMatrix.get(0);

        if (dbCirculationMatrix != null && (!isUpdate || !Objects.equals(withEffectFrom , dbCirculationMatrix.getCirculationMatrixId().getWithEffectFrom()))) {
                processError.addError("common.field.duplicate" , "withEffectFrom" , Arrays.asList("domain.entity.library", "domain.circulationMatrix.withEffectFrom"), withEffectFrom);
        }

        if (!processError.isValid()) {
            throw new AppException(processError);
        }
    }
}
