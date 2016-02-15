package org.sanelib.ils.core.activities.accessionSeries;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.accessioSeries.UpdateAccessionSeries;
import org.sanelib.ils.core.dao.AccessionSeriesRepository;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
import org.sanelib.ils.core.domain.entity.AccessionSeriesCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateAccessionSeriesDelegate implements JavaDelegate {

    @Autowired
    AccessionSeriesRepository accessionSeriesRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Update AccessionSeries called");

        UpdateAccessionSeries command = (UpdateAccessionSeries) execution.getVariable("command");

        AccessionSeries entity = accessionSeriesRepository.get(new AccessionSeriesCode(command.getLibraryId(), command.getCode()));

        entity.setMaxNumber(command.getMaxNumber());
        entity.setMaxZero(command.getMaxZero());
        entity.setPrefix(command.getPrefix());
        entity.setTypeName(command.getTypeName());
        entity.setEntryId(command.getEntryId());
        entity.setEntryDate(command.getEntryDate());

        accessionSeriesRepository.save(entity);
	}
}
