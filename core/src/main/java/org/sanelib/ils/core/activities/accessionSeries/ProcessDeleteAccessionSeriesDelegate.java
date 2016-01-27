package org.sanelib.ils.core.activities.accessionSeries;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.accessioSeries.DeleteAccessionSeries;
import org.sanelib.ils.core.dao.AccessionSeriesRepository;
import org.sanelib.ils.core.domain.entity.AccessionSeries;
import org.sanelib.ils.core.domain.entity.AccessionSeriesCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteAccessionSeriesDelegate implements JavaDelegate {

    @Autowired
    AccessionSeriesRepository accessionSeriesRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Delete AccessionSeries called");

        DeleteAccessionSeries command = (DeleteAccessionSeries) execution.getVariable("command");
        AccessionSeries accessionSeries = this.accessionSeriesRepository.load(new AccessionSeriesCode(command.getLibraryId(), command.getCode()));
        accessionSeriesRepository.remove(accessionSeries);
	}
}
