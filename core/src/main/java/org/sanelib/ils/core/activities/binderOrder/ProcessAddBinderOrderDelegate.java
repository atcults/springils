package org.sanelib.ils.core.activities.binderOrder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binderOrder.AddBinderOrder;
import org.sanelib.ils.core.dao.BinderOrderRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.BinderOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddBinderOrderDelegate implements JavaDelegate {

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    BinderOrderRepository binderOrderRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Process Add BinderOrder called");

        AddBinderOrder command = (AddBinderOrder) execution.getVariable("command");

        BinderOrder entity = new BinderOrder();

        Integer nextId = hibernateHelper.getNextId(BinderOrder.class, "binderOrderId.id");
        entity.setBinderOrderId(nextId, command.getLibraryId());
        entity.setBinderId(command.getBinderId());
        entity.setOrderDate(command.getOrderDate());
        entity.setDueDate(command.getDueDate());
        entity.setReturnedDate(command.getReturnedDate());
        entity.setFormLetterNo(command.getFormLetterNo());
        entity.setSubject(command.getSubject());
        entity.setContent(command.getContent());
        entity.setMailStatus(command.getMailStatus());
        entity.setPrintStatus(command.getPrintStatus());
        entity.setStatus(command.getStatus());
        entity.setEntryId(command.getEntryId());
        entity.setEntryDate(command.getEntryDate());

        binderOrderRepository.save(entity);

        execution.setVariable("result", entity.getBinderOrderId().getId());
	}
}
