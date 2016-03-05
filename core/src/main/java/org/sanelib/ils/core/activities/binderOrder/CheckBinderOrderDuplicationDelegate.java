package org.sanelib.ils.core.activities.binderOrder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binderOrder.AddBinderOrder;
import org.sanelib.ils.core.commands.binderOrder.UpdateBinderOrder;
import org.sanelib.ils.core.dao.BinderOrderRepository;
import org.sanelib.ils.core.domain.entity.BinderOrder;
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
public class CheckBinderOrderDuplicationDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(CheckBinderOrderDuplicationDelegate.class);

    @Autowired
    BinderOrderRepository binderOrderRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Checking binderOrder for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateBinderOrder;

        Integer binderOrderId = isUpdate ? ((UpdateBinderOrder) command).getId() : null;
        Integer libraryId = ((AddBinderOrder) command).getLibraryId();
        Integer binderId = ((AddBinderOrder) command).getBinderId();

        List<BinderOrder> binderOrders = binderOrderRepository.findByColumnAndValue(
                new String[]{"binderOrderId.libraryId", "binderId"}, new Object[] {libraryId, binderId});

        BinderOrder dbBinderOrder = binderOrders.isEmpty() ? null : binderOrders.get(0);

        if(dbBinderOrder != null && (!isUpdate || !Objects.equals(binderOrderId, dbBinderOrder.getBinderOrderId().getId()))){
            processError.addError("common.field.duplicate", "binderId", Arrays.asList("domain.entity.binderOrder", "domain.binderOrder.binderId"), String.valueOf(binderId));
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
