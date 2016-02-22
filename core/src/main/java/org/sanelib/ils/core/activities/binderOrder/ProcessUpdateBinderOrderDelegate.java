package org.sanelib.ils.core.activities.binderOrder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binderOrder.UpdateBinderOrder;
import org.sanelib.ils.core.dao.BinderOrderRepository;
import org.sanelib.ils.core.domain.entity.BinderOrder;
import org.sanelib.ils.core.domain.entity.BinderOrderId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateBinderOrderDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessUpdateBinderOrderDelegate.class);

    @Autowired
    BinderOrderRepository binderOrderRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Update BinderOrder called");

        UpdateBinderOrder command = (UpdateBinderOrder) execution.getVariable("command");

        BinderOrder entity = binderOrderRepository.get(new BinderOrderId(command.getLibraryId(), command.getId()));

        entity.setBinderId(command.getBinderId());
        entity.setOrderDate(command.getOrderDate());
        entity.setDueDate(command.getDueDate());
        entity.setReturnedDate(command.getReturnedDate());
        entity.setFormLetterNo(command.getFormLetterNo());
        entity.setSubject(command.getSubject());
        entity.setContent(command.getContent());
        entity.setMailStatus(command.isMailStatus());
        entity.setPrintStatus(command.isPrintStatus());
        entity.setStatus(command.getStatus());
        entity.setEntryId(command.getPatronCode());

        binderOrderRepository.save(entity);
	}
}
