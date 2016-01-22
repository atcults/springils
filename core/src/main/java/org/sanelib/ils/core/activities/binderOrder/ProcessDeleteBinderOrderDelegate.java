package org.sanelib.ils.core.activities.binderOrder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binderOrder.DeleteBinderOrder;
import org.sanelib.ils.core.dao.BinderOrderRepository;
import org.sanelib.ils.core.domain.entity.BinderOrder;
import org.sanelib.ils.core.domain.entity.BinderOrderId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteBinderOrderDelegate implements JavaDelegate {

    @Autowired
    BinderOrderRepository binderOrderRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Delete BinderOrder called");

        DeleteBinderOrder command = (DeleteBinderOrder) execution.getVariable("command");
        BinderOrder binderOrder = this.binderOrderRepository.load(new BinderOrderId(command.getLibraryId(), command.getId()));

        binderOrderRepository.remove(binderOrder);
	}
}
