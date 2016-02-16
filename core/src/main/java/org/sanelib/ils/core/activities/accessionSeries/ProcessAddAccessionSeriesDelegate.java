package org.sanelib.ils.core.activities.accessionSeries;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.accessioSeries.AddAccessionSeries;
import org.sanelib.ils.core.dao.AccessionSeriesRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
import org.sanelib.ils.core.enums.AccessionSeriesType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddAccessionSeriesDelegate implements JavaDelegate {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    AccessionSeriesRepository accessionSeriesRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Add AccessionSeries called");

        AddAccessionSeries command = (AddAccessionSeries) execution.getVariable("command");

        AccessionSeries entity = new AccessionSeries();

        entity.setAccessionSeriesCode(command.getCode(), command.getLibraryId());
        entity.setMaxNumber(command.getMaxNumber());
        entity.setMaxZero(command.getMaxZero());
        entity.setPrefix(command.getPrefix());
        entity.setTypeName(AccessionSeriesType.Fixed);
        entity.setEntrylibraryId(command.getEntryLibraryId());
        entity.setEntryId(command.getEntryId());

        accessionSeriesRepository.save(entity);

        execution.setVariable("result", entity.getAccessionSeriesCode().getCode());
	}
}
