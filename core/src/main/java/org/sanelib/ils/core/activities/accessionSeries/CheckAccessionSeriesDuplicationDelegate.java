package org.sanelib.ils.core.activities.accessionSeries;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.accessioSeries.AddAccessionSeries;
import org.sanelib.ils.core.commands.accessioSeries.UpdateAccessionSeries;
import org.sanelib.ils.core.dao.AccessionSeriesRepository;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
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
public class CheckAccessionSeriesDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckAccessionSeriesDuplicationDelegate.class);

    @Autowired
    AccessionSeriesRepository accessionSeriesRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Checking accessionSeries for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateAccessionSeries;

        String code = isUpdate ? ((UpdateAccessionSeries) command).getCode() : ((AddAccessionSeries) command).getCode();
        Integer LibraryId = ((AddAccessionSeries) command).getLibraryId();

        List<AccessionSeries> accessionSeries  = accessionSeriesRepository.findByColumnAndValue(
                new String[]{"accessionSeriesCode.libraryId", "accessionSeriesCode.code"},
                new Object[]{LibraryId, code}
        );

        if(!accessionSeries.isEmpty()) {
            if(!isUpdate || !Objects.equals(code, accessionSeries.get(0).getAccessionSeriesCode().getCode())) {
                processError.addError("common.field.duplicate", "accessionSeries.code",
                        Arrays.asList("domain.entity.library", "domain.accessionSeries.code"), code);
            }
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
